package com.liferay.inspire.builder;

import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.portal.kernel.mail.MailMessage;

import java.util.List;
import java.util.Map;

public interface EmailBuilder {

	public void buidEmail();
	public void buildRecipent();
	public void buildProperties(long schdId);
	public EmailElements getEmailElements();
}
