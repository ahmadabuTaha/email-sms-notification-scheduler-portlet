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


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class BirthDayEmailSender extends EmailSenderBaseImpl{

	@Override
	public void sendEmailMessage() {
		// TODO Auto-generated method stub
		try {
			
			System.out.println("====== Email Notifcation ... Get the Customer Birthdays for today....100%");
			System.out.println("====== Run At : "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			//--- Setting Email Configuration here ...
			//--------------------------------------
			
			String sender = super.getEmailSender(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_BIRTHDAY));
			//System.out.println(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_BIRTHDAY));
			InternetAddress from = new InternetAddress(sender);
			InternetAddress to = null;
			MailMessage mail = null;
			String subject = super.getEmailSubject(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_BIRTHDAY));
			//System.out.println(super.getEmailSubject(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_BIRTHDAY)));
			String body = super.getEmailBody(Long.valueOf(ConfigUtil.LR_EMAIL_TEMPLATE_BIRTHDAY));
			String mailSigniture = ConfigUtil.LR_EMAIL_SIGNITURE;

			List<User> users = getReciepentsLogic();
			
			for(User user: users){
				
				String emailAddress = user.getEmailAddress();
				if(emailAddress != null){
				
					to = new InternetAddress(emailAddress);
					Contact c = ContactLocalServiceUtil.getContact(user.getContactId());
					//System.out.println(c.getFullName()+" "+c.getFirstName()+user.getUserId()+" "+c.getLastName());
					subject = subject.replace("!", c.getFullName());
					body = body.replace("!", c.getFullName());
					body = "<h4>"+body+"</h4>"+"<br/>"+mailSigniture+
							"<br /><img src='http://vcd.kent.edu/inspire/images/logo.gif' style='width:200px;' />";
					 mail = new MailMessage(from, to, subject, body, true);
					 MailServiceUtil.sendEmail(mail);
				}
			}
		
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public List<User> getReciepentsLogic(){
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
			Statement stmnt = getConnection().createStatement();
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
		return users;
	}
	
}
