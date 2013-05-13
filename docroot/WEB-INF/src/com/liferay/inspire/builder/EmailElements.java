package com.liferay.inspire.builder;

import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.User;

import java.util.List;
import java.util.Map;

public class EmailElements {
	private Map<String, String> properties;
	private MailMessage mailMessage;
	private List<User> recipents;
	private ScheduleEntity scheduleEntity;
	
	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public MailMessage getMailMessage() {
		return mailMessage;
	}

	public void setMailMessage(MailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	public List<User> getRecipents() {
		return recipents;
	}

	public void setRecipents(List<User> recipents) {
		this.recipents = recipents;
	}
	
	public ScheduleEntity getScheduleEntity() {
		return scheduleEntity;
	}
	
	public void setScheduleEntity(ScheduleEntity scheduleEntity) {
		this.scheduleEntity = scheduleEntity;
	}
}
