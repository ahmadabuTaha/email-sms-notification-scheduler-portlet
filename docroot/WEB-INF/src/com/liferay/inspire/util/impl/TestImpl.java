package com.liferay.inspire.util.impl;
import com.liferay.inspire.builder.EmailBuilder;
import com.liferay.inspire.builder.EmailBuilderEngine;
import com.liferay.inspire.builder.EmailBuilderInitializer;
import com.liferay.inspire.builder.EmailElements;
import com.liferay.inspire.builder.YearlyEventEmailBuilder;
import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;
import com.liferay.inspire.util.EmailSender;
import com.liferay.inspire.util.base.impl.EmailSenderBaseImpl;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class TestImpl extends EmailSenderBaseImpl{

	private MailMessage mailMessage;
	private EmailBuilder mailBuilder;
	private EmailBuilderEngine mailBuilderEngine;

	@Override
	public void sendEmailMessage() {

		List<ScheduleEntity> sEntities = getScheduleEntities();
		System.out.println("======= checking schedules :   Number of Schedule found are :"+sEntities.size());
		
		for(ScheduleEntity sch : sEntities){
			if(sch.getScheduleType().equals("Yearly event")){
				
				EmailElements emailelements = new EmailElements();	
				mailBuilder = new YearlyEventEmailBuilder();
				
				
				mailBuilderEngine = new EmailBuilderEngine(mailBuilder, sch.getScheduleId());
				mailBuilderEngine.buildEmailMessage();

				emailelements = mailBuilderEngine.getEmailBuilder().getEmailElements();
				
				mailMessage = emailelements.getMailMessage();
				List<User> users = emailelements.getRecipents();
				System.out.println("====== Mail Name : "+sch.getScheduleName()+"\n," +
										"Count of Reciepents :"+users.size()+"\n" +
										"Sending Date : "+new Date()+"\n" +
										"Mail Id : "+sch.getScheduleId());
				for(User user : users){
					try {

						String to = user.getEmailAddress();
						if(to != null){
							Contact c = user.getContact();
							InternetAddress toReciever = new InternetAddress(to);
							mailMessage.setTo(toReciever);
							MailServiceUtil.sendEmail(mailMessage);
						}

					} catch (PortalException | SystemException e) {

						e.printStackTrace();
					} catch (AddressException e) {

						e.printStackTrace();
					}

				}
			}
		}


	}


	public List<ScheduleEntity> getScheduleEntities() {

		String sql = "SELECT * FROM emailtemplates_scheduleentity e where e.scheduleActive = 1;";
		List<ScheduleEntity> schd = new ArrayList<ScheduleEntity>();

		try {
			Statement stmnt = super.getConnection().createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while(rs.next()){
				ScheduleEntity s = ScheduleEntityLocalServiceUtil.getScheduleEntity(Long.valueOf(rs.getString("scheduleId")));
				schd.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return schd;
	}


	@Override
	public List<?> getReciepentsLogic() {
		// TODO Auto-generated method stub
		return null;
	}


}
