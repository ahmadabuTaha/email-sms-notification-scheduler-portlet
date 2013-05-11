package com.liferay.inspire.trigger.schedules;

import com.liferay.inspire.util.EmailSender;
import com.liferay.inspire.util.impl.BirthDayEmailSender;
import com.liferay.inspire.util.impl.PassportExpiryDateEmailSender;
import com.liferay.inspire.util.impl.ResidenceExpireDateEmailSender;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class EmailNotificationListener implements MessageListener {

	@Override
	
	public void receive(Message message) throws MessageListenerException {
		
		EmailSender birhdaySender = new BirthDayEmailSender();
		birhdaySender.sendEmailMessage();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmailSender passportExpirySender = new PassportExpiryDateEmailSender();
		passportExpirySender.sendEmailMessage();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmailSender residenceExpirySender = new ResidenceExpireDateEmailSender();
		residenceExpirySender.sendEmailMessage();
		
		try{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
