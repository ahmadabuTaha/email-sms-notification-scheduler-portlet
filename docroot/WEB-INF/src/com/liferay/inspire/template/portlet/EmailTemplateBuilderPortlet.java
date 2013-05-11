package com.liferay.inspire.template.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.inspire.template.model.EmailTemplateEntity;
import com.liferay.inspire.template.model.impl.EmailTemplateEntityImpl;
import com.liferay.inspire.template.service.EmailTemplateEntityLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class EmailTemplateBuilderPortlet
 */
public class EmailTemplateBuilderPortlet extends MVCPortlet {
	public void addNewEmailTemplate(ActionRequest request, ActionResponse response) throws SystemException, IOException{

		long templateId = CounterLocalServiceUtil.increment(EmailTemplateEntity.class.getName());
		EmailTemplateEntity email = getEmailTemplateFromRequest(request,templateId);

		EmailTemplateEntityLocalServiceUtil.addEmailTemplateEntity(email);
		sendRedirect(request, response);
	}


	public void updateEmailTemplate(ActionRequest request, ActionResponse response) throws SystemException, IOException{
		EmailTemplateEntity email= getEmailTemplateFromRequest(request);
		EmailTemplateEntityLocalServiceUtil.updateEmailTemplateEntity(email);
		sendRedirect(request, response);
	}

	public void deleteTemplate(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long templateId = ParamUtil.getLong(request, "templateId");

		EmailTemplateEntityLocalServiceUtil.deleteEmailTemplateEntity(templateId);

		/* Placeholder for SessionMessages */

		sendRedirect(request, response);
	}
	private EmailTemplateEntity getEmailTemplateFromRequest(
			ActionRequest request, long templateId) {
		EmailTemplateEntity email = new EmailTemplateEntityImpl();

		email.setTemplateId(templateId);
		email.setTemplateBody(ParamUtil.getString(request, "templateBody"));
		email.setTemplateSender(ParamUtil.getString(request, "templateSender"));
		email.setTemplateSubject(ParamUtil.getString(request, "templateSubject"));
		return email;
	}
	private EmailTemplateEntity getEmailTemplateFromRequest(
			ActionRequest request) {
		EmailTemplateEntity email = new EmailTemplateEntityImpl();

		email.setTemplateId(ParamUtil.getLong(request, "templateId"));
		email.setTemplateBody(ParamUtil.getString(request, "templateBody"));
		email.setTemplateSender(ParamUtil.getString(request, "templateSender"));
		email.setTemplateSubject(ParamUtil.getString(request, "templateSubject"));
		return email;
	}
}
