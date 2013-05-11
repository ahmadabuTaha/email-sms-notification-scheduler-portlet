package com.liferay.inspire.template.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.inspire.template.model.impl.ScheduleEntityImpl;
import com.liferay.inspire.template.service.EmailTemplateEntityLocalServiceUtil;
import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;
import com.liferay.inspire.util.codegen.ModuleGenUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class ScheduleManagerPortlet
 */
public class ScheduleManagerPortlet extends MVCPortlet {
	
	private String fullName;
	public void addNewEmailTemplate(ActionRequest request, ActionResponse response) throws SystemException, IOException{

		long scheduleId = CounterLocalServiceUtil.increment(ScheduleEntity.class.getName());
		ScheduleEntity sEntity = getScheduleFromRequest(request, scheduleId);

		ScheduleEntityLocalServiceUtil.addScheduleEntity(sEntity);
		ModuleGenUtil moduleGenUtil = new ModuleGenUtil();
		moduleGenUtil.doCompilingModule(this.fullName, sEntity);
		sendRedirect(request, response);
	}


	public void updateEmailTemplate(ActionRequest request, ActionResponse response) throws SystemException, IOException{
		ScheduleEntity sEntity = getScheduleFromRequest(request);
		ScheduleEntityLocalServiceUtil.updateScheduleEntity(sEntity);
		sendRedirect(request, response);
	}

	public void deleteTemplate(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long scheduleId = ParamUtil.getLong(request, "scheduleId");

		EmailTemplateEntityLocalServiceUtil.deleteEmailTemplateEntity(scheduleId);

		/* Placeholder for SessionMessages */

		sendRedirect(request, response);
	}

	private ScheduleEntity getScheduleFromRequest(ActionRequest request, long scheduleId) {
		ScheduleEntity sEntity = new ScheduleEntityImpl();

		sEntity.setScheduleId(scheduleId);
		sEntity.setScheduleName(ParamUtil.getString(request, "scheduleName"));
		sEntity.setScheduleStore("com.liferay.inspire.util.impl."+ParamUtil.getString(request, "scheduleName"));
		this.fullName = "com.liferay.inspire.util.impl."+ParamUtil.getString(request, "scheduleName");
		sEntity.setScheduleType(ParamUtil.getString(request, "scheduleType"));
		sEntity.setScheduleFlagValue(ParamUtil.getString(request, "scheduleFlagValue"));
		sEntity.setScheduleOp(ParamUtil.getString(request, "scheduleOp"));
		sEntity.setScheduleActive(ParamUtil.getBoolean(request, "scheduleActive"));
		sEntity.setTemplateId(ParamUtil.getLong(request, "templateId"));

		return sEntity;

	}
	private ScheduleEntity getScheduleFromRequest(ActionRequest request) {
		ScheduleEntity sEntity = new ScheduleEntityImpl();

		sEntity.setScheduleId(ParamUtil.getLong(request, "scheduleId"));
		sEntity.setScheduleName(ParamUtil.getString(request, "scheduleName"));
		sEntity.setScheduleStore("com.liferay.inspire.util.impl."+ParamUtil.getString(request, "scheduleName"));
		
		sEntity.setScheduleType(ParamUtil.getString(request, "scheduleType"));
		sEntity.setScheduleFlagValue(ParamUtil.getString(request, "scheduleFlagValue"));
		sEntity.setScheduleOp(ParamUtil.getString(request, "scheduleOp"));
		sEntity.setScheduleActive(ParamUtil.getBoolean(request, "scheduleActive"));
		sEntity.setTemplateId(ParamUtil.getLong(request, "templateId"));

		return sEntity;
	}
}
