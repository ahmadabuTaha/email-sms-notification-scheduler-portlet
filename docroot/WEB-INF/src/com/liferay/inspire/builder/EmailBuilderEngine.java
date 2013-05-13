package com.liferay.inspire.builder;

public class EmailBuilderEngine {
	private EmailBuilder mailBuilder;
	private long scheduleId;
	
	public EmailBuilderEngine(EmailBuilder mBuilder){
		this.mailBuilder = mBuilder;
	}
	
	public EmailBuilderEngine(EmailBuilder mBuilder, long sechdId){
		this.scheduleId = sechdId;
		this.mailBuilder = mBuilder;
	}
	public void buildEmailMessage(){
		this.mailBuilder.buildProperties(getScheduleId());
		this.mailBuilder.buildRecipent();
		this.mailBuilder.buidEmail();
	}
	
	public EmailBuilder getEmailBuilder(){
		return mailBuilder;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	

	
	
}
