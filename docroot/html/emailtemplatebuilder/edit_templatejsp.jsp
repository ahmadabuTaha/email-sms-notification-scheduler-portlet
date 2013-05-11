<%@include file="/html/init.jsp" %>

<%
	EmailTemplateEntity mail = null;

	long templateId = ParamUtil.getLong(request, "templateId");

	if (templateId > 0) {
		mail = EmailTemplateEntityLocalServiceUtil.getEmailTemplateEntity(templateId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (mail != null) ? mail.getTemplateSubject() : "new-template" %>'
/>


<aui:model-context bean="<%= mail %>" model="<%= EmailTemplateEntity.class %>" />

<portlet:actionURL name='<%= mail == null ? "addNewEmailTemplate" : "updateEmailTemplate" %>' var="editEmailURL" windowState="normal" />

<aui:form action="<%= editEmailURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="templateId" value='<%= mail == null ? "" : mail.getTemplateId() %>'/>

		<aui:input name="templateSubject" />

		<aui:input name="templateSender" />

		<aui:input name="templateBody" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>