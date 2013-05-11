package com.liferay.inspire.util;

import java.util.ResourceBundle;

public class ConfigUtil {

	private static final ResourceBundle resourceBundle =
			ResourceBundle.getBundle("com.liferay.inspire.resources.config");
	
	
	//---- getting Database Configuration from the bundle ..
	//----
	public static final String LR_DB_DRIVER = resourceBundle.getString("lr-db.driver");
	public static final String LR_DB_CONNECTION = resourceBundle.getString("lr-db.connection-string");
	public static final String LR_DB_USER = resourceBundle.getString("lr-db.user");
	public static final String LR_DB_PASS = resourceBundle.getString("lr-db.passwd");

	//---- getting Email Configuration from the bundle ..
	public static final String LR_CENTER_MAIL = resourceBundle.getString("mail.liferay-outgoing-mail");
	
	
	//---- getting Liferay Configured data from bundle ..
	
	public static final String LR_WEB_ID = resourceBundle.getString("lr-config.webId");
	
	
	//--- getting Email Templates from the bundle...
	
	public static final String LR_EMAIL_TEMPLATE_BIRTHDAY = resourceBundle.getString("lr.email-templates.birthday");
	public static final String LR_EMAIL_TEMPLATE_PASSPORT = resourceBundle.getString("lr.email-templates.passport");
	public static final String LR_EMAIL_TEMPLATE_RESIDENCE = resourceBundle.getString("lr.email-templates.residence");
	public static final String LR_EMAIL_SIGNITURE = resourceBundle.getString("lr.email-templates.signiture");
	//--- getting Custom fields values from the bundle :
	
	public static final String LR_CUSTOM_FIELD_PASSPORT = resourceBundle.getString("lr.customfield.passport-expire");
	public static final String LR_CUSTOM_FIELD_RESIDENCE = resourceBundle.getString("lr.customfield.residence-expire");
	
	//-- getting Custom field properties from bundle :
	//
	
	public static final String LR_CUSTOM_FIELD_CHECK_BEFOREAFTER = resourceBundle.getString("lr.customfield.before-update-flag");
	public static final String LR_CUSTOM_FIELD_CHECK_PERIOD1 = resourceBundle.getString("lr.customfield.period-1");
	public static final String LR_CUSTOM_FIELD_CHECK_PERIOD2 = resourceBundle.getString("lr.customfield.period-2");
	
			
}
