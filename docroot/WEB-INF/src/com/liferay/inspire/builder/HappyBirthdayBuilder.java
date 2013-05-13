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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class HappyBirthdayBuilder implements EmailBuilder{

	private EmailElements emailElements;

	public HappyBirthdayBuilder() {
		emailElements = new EmailElements();
	}
	@Override
	public void buidEmail() {
		//=====prepare Email Message :
		//

		Map<String, String> props = emailElements.getProperties();
		System.out.println("====== Start Building Happy Birthday Event Mail Message..............");
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
			System.out.println("======= Building Mail Error : Invalid Sender in your Template, or there are mistakes in Control Panel->Portal Settings->Mail configuration" +
					"\n Or Add the Missing Email Templates from Email Templates portlet...");
			e.printStackTrace();
		}
		MailMessage mailMessage = new MailMessage(fromSender, subject, body, true);
		//return mailMessage;
		emailElements.setMailMessage(mailMessage);
	}

	@Override
	public void buildRecipent() {
		System.out.println("====== Start Building Happy Birthday Event Mail Message..............");
		List<User> users = new ArrayList<User>();

		try {

			String sql = "select"+"\n"+
					"u.userId userId,"+"\n"+
					"u.companyId companyId,"+"\n"+
					"c.birthday birthday,"+"\n"+
					"u.emailAddress emailAddress"+"\n"+
					"from user_ u, contact_ c"+"\n"+
					"where u.companyId = c.companyId"+"\n"+
					"and   u.userId = c.userId"+"\n"+
					"and   DATE_FORMAT(c.birthday,'%m-%d') = DATE_FORMAT(CURRENT_DATE, '%m-%d');"+"\n";
			//System.out.println(sql);
			Statement stmnt = EmailBuilderInitializer.getConnection().createStatement();
			ResultSet rSet = stmnt.executeQuery(sql);

			while(rSet.next()){
				long userId = rSet.getLong("userId");
				User user   = UserLocalServiceUtil.getUser(userId);
				users.add(user);
			}
		} 

		catch (SQLException e) {

			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emailElements.setRecipents(users);
	}

	@Override
	public void buildProperties(long scheduleId) {

		System.out.println("====== Start Building HappyBirthday Mail properties..............");
		
		String template = getBirthdayTemplate();
		Map<String, String> props = new HashMap<String, String>();

		props.put("id", template);
		props.put("name", "Happy Birthday Scheduler");
		props.put("key", "com.liferay.inspire.util.impl.HappyBirthday");
		props.put("value", "");
		props.put("operator", "=");
		props.put("template", template);
		//return props;
		emailElements.setProperties(props);
	}
	


	private String getBirthdayTemplate() {
		String sql = "select * from emailTemplates_emailTemplateEntity sch where" +
				" sch.templateSubject = 'Happy Birthday' ";
		String template = "0";
		try {
			Statement stmnt = EmailBuilderInitializer.getConnection().createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while(rs.next()){
				template = rs.getString("templateId");
				break;
			}
			
		} catch (SQLException e) {
			System.out.println("====== Check the database connection or add Happy Birthday Template from " +
					" Email Template screen");
			e.printStackTrace();
		}
		
		return template;
	}
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
