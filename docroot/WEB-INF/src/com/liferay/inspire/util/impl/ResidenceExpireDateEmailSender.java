package com.liferay.inspire.util.impl;

import com.liferay.inspire.util.ConfigUtil;
import com.liferay.inspire.util.base.impl.EmailSenderBaseImpl;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ResidenceExpireDateEmailSender extends EmailSenderBaseImpl {

	private String body = super.getEmailBody(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_RESIDENCE));
	@Override
	public void sendEmailMessage() {
		
		System.out.println("====== Email Notifcation ... Get the Customer Residence Expiry Date for today....100%");
		System.out.println("====== Run At : "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		String sender = super.getEmailSender(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_RESIDENCE));
		InternetAddress from = null;
		String to = null;
		String subject = super.getEmailSubject(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_RESIDENCE));
		
		MailMessage mail = null;
		String sign = ConfigUtil.LR_EMAIL_SIGNITURE;




		List<User> users = getReciepentsLogic();

		for(User user : users){
			try {
				//System.out.println(user.getUserId());
				Contact c = ContactLocalServiceUtil.getContact(user.getContactId());
				//System.out.println(c.getFullName());
				String emailAddress = user.getEmailAddress();
				//System.out.println(user.getEmailAddress());
				if(emailAddress != null){
					to = emailAddress;
					InternetAddress reciever = new InternetAddress(to);
					from = new InternetAddress(sender);
					body = body.replace("!", c.getFullName());
					body = "<h4>"+body+"</h4><br />"+sign+"<br /><img src='http://vcd.kent.edu/inspire/images/logo.gif' style='width:200px;' />";
					mail = new MailMessage(from, reciever, subject, body, true);
					MailServiceUtil.sendEmail(mail);
				}

			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public List<User> getReciepentsLogic() {

		String sql = "SELECT u.userId userId, e.data_ data_, e.valueId valueId FROM user_ u, expandovalue e where e.classPK = u.userId and e.columnId = "
				+ ConfigUtil.LR_CUSTOM_FIELD_RESIDENCE;
		
		//System.out.println(sql);
		//User u = UserLocalServiceUtil.getUser(11).getExpandoBridge().getAttribute("dsfasdfsadf");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<User> users = new ArrayList<User>();
		try {
			
			Statement stmnt = getConnection().createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while(rs.next()){
				String dstr = rs.getString("data_");
				long datel = Long.valueOf(dstr);
				Date date = new Date(datel);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String expdateStr = sdf.format(date);
				//System.out.println(expdateStr);
				//System.out.println(expdateStr);
				String afterBeforeFlag = ConfigUtil.LR_CUSTOM_FIELD_CHECK_BEFOREAFTER;
				if(validateExpiryDate(afterBeforeFlag, expdateStr)){
					long userId = rs.getLong("userId");
					body = body.replace("?", expdateStr);
					User user   = UserLocalServiceUtil.getUser(userId);
					users.add(user);
				}

			}
		} catch (SQLException sqle) {

			sqle.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	private boolean validateExpiryDate(String afterBeforeFlag, String expdateStr) {
		
		if(afterBeforeFlag.equals("before")){
			return validIsFinishedBeforePeriod(expdateStr, Integer.valueOf(ConfigUtil.LR_CUSTOM_FIELD_CHECK_PERIOD1))
				|| validIsFinishedBeforePeriod(expdateStr, Integer.valueOf(ConfigUtil.LR_CUSTOM_FIELD_CHECK_PERIOD2));
		}
		else{
			return validIsFinishedAfterPeriod(expdateStr, Integer.valueOf(ConfigUtil.LR_CUSTOM_FIELD_CHECK_PERIOD1)) 
				|| validIsFinishedAfterPeriod(expdateStr, Integer.valueOf(ConfigUtil.LR_CUSTOM_FIELD_CHECK_PERIOD2));
		}
	}
	
	private boolean validIsFinishedBeforePeriod(String expdateStr, int period) {
		boolean valid = true;
		
		
		Calendar current = Calendar.getInstance();
		Calendar expdate = Calendar.getInstance();
		
		//---- Setting the Current date :
		current.set(current.YEAR, current.get(current.YEAR));
		current.set(current.MONTH, current.get(current.MONTH)+period);
		
		//--- Setting the Expiry Date period :
		//
		int year = Integer.parseInt(expdateStr.split("-")[0]);
		int month = Integer.parseInt(expdateStr.split("-")[1]);
		expdate.set(expdate.YEAR, year);
		expdate.set(expdate.MONTH, month-1);
		
		valid = current.before(expdate);
		return valid;
	}

	private boolean validIsFinishedAfterPeriod(String expdateStr, int period){
		boolean valid = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar current = Calendar.getInstance();
		Calendar expdate = Calendar.getInstance();
		
		//---- Setting the Current date :
		current.set(current.YEAR, current.get(current.YEAR));
		current.set(current.MONTH, current.get(current.MONTH)+period);
		
		//--- Setting the Expiry Date period :
		//
		int year = Integer.parseInt(expdateStr.split("-")[0]);
		int month = Integer.parseInt(expdateStr.split("-")[1]);
		expdate.set(expdate.YEAR, year);
		expdate.set(expdate.MONTH, month-1);
		
		valid = current.after(expdate);
		return valid;
	}

}
