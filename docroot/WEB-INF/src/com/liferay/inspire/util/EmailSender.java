package com.liferay.inspire.util;

import java.util.List;

public interface EmailSender {
	public void sendEmailMessage();
	public List<?> getReciepentsLogic();
}
