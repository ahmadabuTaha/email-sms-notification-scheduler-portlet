package com.liferay.inspire.util.codegen;

import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class ModuleGenUtil {

	public boolean doCompilingModule(String name, ScheduleEntity scheduleEntity, String path){
		boolean valid = true;
		String code = getCodeFromScheduleEntity(name, scheduleEntity);
		//System.out.println(code);
		SimpleJavaFileObject fileObject = new DynamicModuleGen(name, code);
		
		JavaFileObject[] fileObjects = new JavaFileObject[]{fileObject};

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		//System.out.println(compiler == null);
		StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, Locale.getDefault(), null);

		Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(fileObjects);
		
		
		String[] compileOptions = new String[]{"-d", "bin"};
		Iterable<String> compilationOptionss = Arrays.asList(compileOptions);

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		CompilationTask compilationTask  = compiler.getTask(null, stdFileManager, diagnostics, compilationOptionss, null, compilationUnits);

		boolean status  = compilationTask.call();

		if(!status){
			for(Diagnostic diagnostic : diagnostics.getDiagnostics()){
				System.out.format("Error in line %d in %s", diagnostic.getLineNumber(), diagnostic);
				System.out.println("\n");
				valid = false;
			}
		}
		try{
			System.out.println("======done and closing File Manger");
			stdFileManager.close();
			//valid = true;
		}
		catch(IOException e){
			e.printStackTrace();
			valid = false;
		}
		return valid;
	}

	private String getCodeFromScheduleEntity(String name, ScheduleEntity scheduleEntity) {
		
		String source  = "package com.liferay.inspire.util.impl;"+"\n"
						+"import com.liferay.inspire.util.ConfigUtil;"+"\n"
				        +"import com.liferay.inspire.util.base.impl.EmailSenderBaseImpl;"+"\n"
				        +"import com.liferay.mail.service.MailServiceUtil;"+"\n"
				        +"import com.liferay.portal.kernel.exception.PortalException;"+"\n"
				        +"import com.liferay.portal.kernel.exception.SystemException;"+"\n"
				        +"import com.liferay.portal.kernel.mail.MailMessage;"+"\n"
				        +"import com.liferay.portal.model.Contact;"+"\n"
				        +"import com.liferay.portal.model.User;"+"\n"
				        +"import com.liferay.portal.service.ContactLocalServiceUtil;"+"\n"
				        +"import com.liferay.portal.service.UserLocalServiceUtil;"+"\n"
				        +""+"\n"
				        +"import java.sql.ResultSet;"+"\n"
				        +"import java.sql.SQLException;"+"\n"
				        +"import java.sql.Statement;"+"\n"
				        +"import java.text.SimpleDateFormat;"+"\n"
				        +"import java.util.ArrayList;"+"\n"
				        +"import java.util.Date;"+"\n"
				        +"import java.util.List;"+"\n"
				        +"import javax.mail.internet.AddressException;"+"\n"
				        +"import javax.mail.internet.InternetAddress;"+"\n"
				        +"import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;"+"\n"
				        
				        +"//------------------- Building the Class -------\n"
						+"class "+scheduleEntity.getScheduleName()+" extends com.liferay.inspire.util.base.impl.EmailSenderBaseImpl{\n"
				        +"   "+getEmailMethod(scheduleEntity)+"\n"
						+"   "+getRecipientCode(scheduleEntity)+"\n"
				        +"   "+getCodeFromType(scheduleEntity)+"\n"
						+"   //get_Op_functionality_here"+"\n"
				        +"   "+getCodeFromFlagValue()+"\n"
						+"   "+"\n"
				        +"}";
		
		System.out.println("====== Class Source is : \n "+source);
		return source;
	}
	
	private String getCodeFromType(ScheduleEntity scheduleEntity){
		String source = "";
		if(scheduleEntity.getScheduleType().equals("Date")){
			
			if(scheduleEntity.getScheduleOp().equals("equals")){
			source = "private boolean isDateEquals(String flagdate){\n"+
					" java.util.Calendar calender = java.util.Calendar.getInstance();"+"\n"+
					" java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(\"yyyy-MM-dd\");"+"\n"+
					" java.util.Date currentDay = calender.getTime();"+"\n"+
					" String currDate = sdf.format(currentDay);"+"\n"+
					" return currDate.equals(flagdate);"+"\n"+
					"}\n";
			}
			else if(scheduleEntity.getScheduleType().equals(">=")){
				source = "private boolean isDateGreatorOrEquals(String flagdate){\n"+
						" java.util.Calendar calender = java.util.Calendar.getInstance();"+"\n"+
						" java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(\"yyyy-MM-dd\");"+"\n"+
						" java.util.Date currentDay = calender.getTime();"+"\n"+
						" String currDate = sdf.format(currentDay); "+"\n"+
						" flagdate = flagdate.replace(\"-\",\"0\");"+"\n"+
						" currDate = currDate.replace(\"-\",\"0\");"+"\n"+
						" int cdate = Integer.parseInt(currDate);\n " +
						" int fdate =  Integer.parseInt(currDate);\n" +
						" return cdate >= fdate"+
						"}\n";
			}
			else if(scheduleEntity.getScheduleType().equals("=>")){
				source = "private boolean isDateLessOrEquals(String flagdate){\n"+
						" java.util.Calendar calender = java.util.Calendar.getInstance();"+"\n"+
						" java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(\"yyyy-MM-dd\");"+"\n"+
						" java.util.Date currentDay = calender.getTime();"+"\n"+
						" String currDate = sdf.format(currentDay); "+"\n"+
						" flagdate = flagdate.replace(\"-\",\"0\");"+"\n"+
						" currDate = currDate.replace(\"-\",\"0\");"+"\n"+
						" int cdate = Integer.parseInt(currDate);\n " +
						" int fdate =  Integer.parseInt(currDate);\n" +
						" return cdate => fdate"+
						"}\n";
			}
			else{
				
			}
		}
		return source;
	}
	
	private String getCodeFromFlagValue(){
		
		String source = "private String getFlagValue(long schdId) {\n" +
				" com.liferay.inspire.template.model.ScheduleEntity sEntity = null;\n" +
				"String str = null;" +
				"try{\n" +
				"  " +
				"sEntity = ScheduleEntityLocalServiceUtil.getScheduleEntity(schdId);\n" +
				"str = sEntity.getScheduleFlagValue();\n" +
				"} catch (PortalException e) {" +
				" e.printStackTrace();" +
				"}\n catch (SystemException e) {" +
				" e.printStackTrace();" +
				"}\n" +
				"\n" +
				"return str;\n" +
				"}\n";
		return source;
	}
	
	private String getRecipientCode(ScheduleEntity scheduleEntity){
		String source = "";
		if(scheduleEntity.getScheduleType().equals("Yearly event")){
		source = "@Override\n" +
						"public List<User> getReciepentsLogic(){\n"+
						"	List<User> users = new ArrayList<User>();\n" +
						"   String currDate = new SimpleDateFormat(\"yyyy-MM\").format(new Date());\n" +
						"   if(currDate.equals("+scheduleEntity.getScheduleFlagValue()+")){" +
						"   String sql = \"select * from user_;\";\n" +
						"   try {" +
						"   Statement stmnt = getConnection().createStatement();\n"+
						"   ResultSet rSet = stmnt.executeQuery(sql);\n"+

						"   while(rSet.next()){\n"+
						"   long userId = rSet.getLong(\"userId\");\n" +
						"   User user   = UserLocalServiceUtil.getUser(userId);\n" +
						"   users.add(user);\n" +
						"     }\n" +
						"   }\n" +
						"   catch (SQLException e) {\n"+
			            "    e.printStackTrace();"+
			            "   } catch (PortalException e) {\n"+
			            "    e.printStackTrace();"+
			            "   } catch (SystemException e) {\n"+
			            "   e.printStackTrace();\n"+
			            "   }\n}\n"+
			            "   return users;"+"\n"+
			            "" +
						"}";

		}
		else{
			source = "@Override \n" +
					"public List<User> getReciepentsLogic(){\n"+
					" System.out.println(\"Worng Implementation for the method\");return null;\n" +
					"}";
		}
		return source;
	}
	
	
	private String getEmailMethod(ScheduleEntity scheduleEntity){
		String source = "@Override \n" +
				"public void sendEmailMessage() {\n" +
				"" +
				"  try{" +
				"    System.out.println(\"====== Email Notifcation ... "+scheduleEntity.getScheduleStore()+"....100%\");\n"+
				"	 System.out.println(\"====== Run At : \"+new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\").format(new Date()));\n" +
				"    String sender = super.getEmailSender("+scheduleEntity.getTemplateId()+");\n" +
				"    InternetAddress from = new InternetAddress(sender);\n" +
				"    InternetAddress to = null;\n" +
				"    MailMessage mail = null;\n" +
				"    String subject = super.getEmailSubject(Long.valueOf("+scheduleEntity.getTemplateId()+"));\n" +
				"    String body = super.getEmailBody(Long.valueOf("+scheduleEntity.getTemplateId()+"));\n" +
				"    String mailSigniture = ConfigUtil.LR_EMAIL_SIGNITURE;\n" +
				"    \n" +
				"    List<User> users = getReciepentsLogic();\n" +
				"    for(User user: users){\n" +
				"       String emailAddress = user.getEmailAddress();\n" +
				"       if(emailAddress != null){\n" +
				"         to = new InternetAddress(emailAddress);\n" +
				"         Contact c = ContactLocalServiceUtil.getContact(user.getContactId());\n" +
				"         subject = subject.replace(\"!\", c.getFullName());\n" +
				"         body = body.replace(\"!\", c.getFullName());\n" +
				"         body = \"<h4>\"+body+\"</h4>\"+\"<br/>\"+mailSigniture+\"<br /><img src='http://vcd.kent.edu/inspire/images/logo.gif' style='width:200px;' />\";\n"+
				"         mail = new MailMessage(from, to, subject, body, true);\n"+
				"         MailServiceUtil.sendEmail(mail);" +
				"          " +
				"    }\n" +
				"   }\n}\n" +
				"   catch (AddressException e) {" +
				"       e.printStackTrace();" +
				"   }\n" +
				"   catch (PortalException e) {" +
				"      e.printStackTrace();" +
				"   }\n" +
				"   catch (SystemException e) {" +
				"      e.printStackTrace();" +
				"   }\n" +
				"}\n";
		
		return source;
	}
}
