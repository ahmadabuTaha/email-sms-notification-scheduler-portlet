package com.liferay.inspire.util.base.impl;

import com.liferay.inspire.util.ConfigUtil;
import com.liferay.inspire.util.EmailSender;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class EmailSenderBaseImpl implements EmailSender{

	
	private static Connection conn;
	
	static{
		try{
			Class.forName(ConfigUtil.LR_DB_DRIVER);	
			conn = (Connection) DriverManager.getConnection(ConfigUtil.LR_DB_CONNECTION, ConfigUtil.LR_DB_USER, ConfigUtil.LR_DB_PASS);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	public static String getEmailSender(long templateId){
		
		String sender = ConfigUtil.LR_CENTER_MAIL;
		try {
			Statement stmnt = getConnection().createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT templateSender FROM emailtemplates_emailtemplateentity e where templateId = "+templateId+";");
			
			//System.out.println("SELECT templateSender FROM emailtemplates_emailtemplateentity e where templateId = "+templateId+";");
			while(rs.next()){
			sender = rs.getString("templateSender");
			break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sender;
	}
	
	public static String getEmailSubject(long templateId){
		String subject = "No Subject";
		try {
			Statement stmnt = getConnection().createStatement();
			
			ResultSet rs = stmnt.executeQuery("SELECT templateSubject FROM emailtemplates_emailtemplateentity e where templateId = "+templateId+";");
			//System.out.println("SELECT templateSubject FROM emailtemplates_emailtemplateentity e where templateId = "+templateId+";");
			while(rs.next()){
			subject = rs.getString("templateSubject");
			break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}
	
	public static String getEmailBody(long templateId){
		String body = "";
		try {
			Statement stmnt = getConnection().createStatement();
			
			ResultSet rs = stmnt.executeQuery("SELECT templateBody FROM emailtemplates_emailtemplateentity e where templateId = "+templateId+";");
			//System.out.println("SELECT templateBody FROM emailtemplates_emailtemplateentity e where templateId = "+templateId+";");
			while(rs.next()){
			body = rs.getString("templateBody");
			break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return body;
	}
}
