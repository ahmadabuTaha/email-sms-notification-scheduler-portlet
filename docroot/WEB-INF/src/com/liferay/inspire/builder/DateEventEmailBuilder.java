package com.liferay.inspire.builder;

import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;
import com.liferay.inspire.util.ConfigUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class DateEventEmailBuilder
implements EmailBuilder{


	private EmailElements emailElements;

	
	public DateEventEmailBuilder() {
		emailElements = new EmailElements();
	}
	@Override
	public void buidEmail() {

		//=====prepare Email Message :
		//

		Map<String, String> props = emailElements.getProperties();
		System.out.println("====== Start Building Date Event Mail Message..............");
		String from = EmailBuilderInitializer.getEmailSender(Long.valueOf(props.get("template")));
		String subject = EmailBuilderInitializer.getEmailSubject(Long.valueOf(props.get("template")));
		String body = EmailBuilderInitializer.getEmailBody(Long.valueOf(props.get("template")));
		String signiture = ConfigUtil.LR_EMAIL_SIGNITURE;

		body = "<h4>"+body+"</h4>\n" +
				"<br />\n" +
				signiture+"\n" +
				"";

		InternetAddress fromSender = null;
		try {
			fromSender = new InternetAddress(from);
		} catch (AddressException e) {
			System.out.println("======= Building Mail Error : Invalid Sender in your Template, or there are mistakes in Control Panel->Portal Settings->Mail configuration");
			e.printStackTrace();
		}
		MailMessage mailMessage = new MailMessage(fromSender, subject, body, true);
		//return mailMessage;
		emailElements.setMailMessage(mailMessage);
	}

	@Override
	public void buildRecipent() {

		System.out.println("====== Start Building Date Event Mail Recipents..............");
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
		List<User> users = new ArrayList<User>();
		Map<String, String> props = emailElements.getProperties();


		String datevalue = String.valueOf(props.get("value"));
		String current = sdf.format(new Date());
		long period = Long.valueOf(props.get("period"));
		long beforeAfter = Long.valueOf(props.get("beforOrAfter"));
		String op = props.get("operator");
		String sql = "select * from user_;";
		
		//System.out.println(period);
		if(period > 0){
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, Integer.parseInt(current.split("-")[0]));
			c.set(Calendar.MONTH, Integer.parseInt(current.split("-")[1])+(int)period);

			Calendar d = Calendar.getInstance();
			d.set(Calendar.YEAR, Integer.parseInt(datevalue.split("-")[0]));
			d.set(Calendar.MONTH, Integer.parseInt(datevalue.split("-")[1])-1);

			long newperiod = period/2;
			Calendar cb = Calendar.getInstance();
			cb.set(Calendar.YEAR, Integer.parseInt(current.split("-")[0]));
			cb.set(Calendar.MONTH, Integer.parseInt(current.split("-")[1])+(int)newperiod);

			System.out.println(sdf.format(c.getTime())+" "+sdf.format(cb.getTime())+sdf.format(d.getTime()));
			if(beforeAfter == 2){
				if(c.before(d) || cb.before(d)){
					try {
						Statement stmnt = EmailBuilderInitializer.getConnection().createStatement();
						ResultSet rs = stmnt.executeQuery(sql);
						while(rs.next()){
							User user = UserLocalServiceUtil.getUser(Long.valueOf(rs.getString("userId")));
							users.add(user);
						}

					} catch (SQLException e) {
						System.out.println("===== Building Recipents Error : Error in Database check the database or config.properties file");
						e.printStackTrace();
					} catch (NumberFormatException e) {

						e.printStackTrace();
					} catch (PortalException e) {

						e.printStackTrace();
					} catch (SystemException e) {

						e.printStackTrace();
					}
				}
				else if(beforeAfter ==3)
				{
					if(c.after(d) || cb.after(d)){
						try {
							Statement stmnt = EmailBuilderInitializer.getConnection().createStatement();
							ResultSet rs = stmnt.executeQuery(sql);
							while(rs.next()){
								User user = UserLocalServiceUtil.getUser(Long.valueOf(rs.getString("userId")));
								users.add(user);
							}

						} catch (SQLException e) {
							System.out.println("===== Building Recipents Error : Error in Database check the database or config.properties file");
							e.printStackTrace();
						} catch (NumberFormatException e) {

							e.printStackTrace();
						} catch (PortalException e) {

							e.printStackTrace();
						} catch (SystemException e) {

							e.printStackTrace();
						}
					}
				}
				else{
					if(datevalue.equals(sdf.format(new Date()))){
						try {
							Statement stmnt = EmailBuilderInitializer.getConnection().createStatement();
							ResultSet rs = stmnt.executeQuery(sql);
							while(rs.next()){
								User user = UserLocalServiceUtil.getUser(Long.valueOf(rs.getString("userId")));
								users.add(user);
							}

						} catch (SQLException e) {
							System.out.println("===== Building Recipents Error : Error in Database check the database or config.properties file");
							e.printStackTrace();
						} catch (NumberFormatException e) {

							e.printStackTrace();
						} catch (PortalException e) {

							e.printStackTrace();
						} catch (SystemException e) {

							e.printStackTrace();
						}
					}
				}
			}
			
		}

		this.emailElements.setRecipents(users);
	}

	@Override
	public void buildProperties(long schdId) {

		System.out.println("====== Start Building Date Event Mail properties..............");
		ScheduleEntity sEntity = null;
		try {
			sEntity = ScheduleEntityLocalServiceUtil.getScheduleEntity(schdId);
		} catch (PortalException | SystemException e) {

			e.printStackTrace();
		}

		Map<String, String> props = new HashMap<String, String>();

		props.put("id", sEntity.getScheduleId()+"");
		props.put("name", sEntity.getScheduleName());
		props.put("key", sEntity.getScheduleType());
		props.put("value", sEntity.getScheduleFlagValue());
		String op = getOpFromSechedule(sEntity.getScheduleOp());
		props.put("operator", op);
		props.put("template", sEntity.getTemplateId()+"");
		props.put("period", sEntity.getSchedulePeriod()+"");
		props.put("beforOrAfter", sEntity.getScheduleBeforAfter()+"");

		//return props;
		this.emailElements.setProperties(props);

	}

	@Override
	public EmailElements getEmailElements() {

		return this.emailElements;
	}

	private String getOpFromSechedule(String ops){
		String op = "";
		if(op.equals("equals")){ ops = "=";}
		else if(op.equals("greater than")){ops = ">";}
		else if(op.equals("less than")){ops = "<";}
		else if(op.equals("greater than or equal")){ops=">=";}
		else if(op.equals("less than or equal")){ops = "<=";}
		else {ops ="<>";}
		return ops;
	}
}
