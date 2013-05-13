package com.liferay.inspire.builder;

import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateEventEmailBuilder
implements EmailBuilder{


	private EmailElements emailElements;

	@Override
	public void buidEmail() {


	}

	@Override
	public void buildRecipent() {

		System.out.println("====== Start Building Date Event Mail Recipents..............");
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
		List<User> users = new ArrayList<User>();
		Map<String, String> props = emailElements.getProperties();


		String datevalue = String.valueOf(props.get("value"));
		//implementation for Period;
		
		//datevalue = datevalue.split("-")[1]+"-"+datevalue.split("-")[2];
		String currdatevalu = sdf.format(new Date());
		if(datevalue.equals(currdatevalu)){
			String sql = "select * from user_ u where ";
			try {
				Statement stmnt = EmailBuilderInitializer.getConnection().createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while(rs.next()){
					User user = UserLocalServiceUtil.getUser(Long.valueOf(rs.getString("userId")));
					users.add(user);
				}

			} catch (SQLException e) {
				System.out.println("===== Building Recipents Error : Error in Database check the database or config.properties file");
				e.printStackTrace();
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (PortalException e) {

				e.printStackTrace();
			} catch (SystemException e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public void buildProperties(long schdId) {

		System.out.println("====== Start Building Date Event Mail properties..............");
		ScheduleEntity sEntity = null;
		try {
			sEntity = ScheduleEntityLocalServiceUtil.getScheduleEntity(schdId);
		} catch (PortalException | SystemException e) {

			e.printStackTrace();
		}

		Map<String, String> props = new HashMap<String, String>();

		props.put("id", sEntity.getScheduleId()+"");
		props.put("name", sEntity.getScheduleName());
		props.put("key", sEntity.getScheduleType());
		props.put("value", sEntity.getScheduleFlagValue());
		String op = getOpFromSechedule(sEntity.getScheduleOp());
		props.put("operator", op);
		props.put("template", sEntity.getTemplateId()+"");
		//return props;
		emailElements.setProperties(props);

	}

	@Override
	public EmailElements getEmailElements() {

		return this.emailElements;
	}

	private String getOpFromSechedule(String ops){
		String op = "";
		if(op.equals("equals")){ ops = "=";}
		else if(op.equals("greater than")){ops = ">";}
		else if(op.equals("less than")){ops = "<";}
		else if(op.equals("greater than or equal")){ops=">=";}
		else if(op.equals("less than or equal")){ops = "<=";}
		else {ops ="<>";}
		return ops;
	}
}
