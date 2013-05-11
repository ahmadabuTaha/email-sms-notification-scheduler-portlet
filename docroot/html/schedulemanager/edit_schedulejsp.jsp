
<%@include file="/html/init.jsp" %>

<%
	ScheduleEntity sEntity = null;

	long scheduleId = ParamUtil.getLong(request, "scheduleId");

	if (scheduleId > 0) {
		sEntity = ScheduleEntityLocalServiceUtil.getScheduleEntity(scheduleId);
	}

	List<EmailTemplateEntity> emails = EmailTemplateEntityLocalServiceUtil.getEmailTemplateEntities(1, 2000);
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (sEntity != null) ? sEntity.getScheduleName() : "new-schedule" %>'
/>


<aui:model-context bean="<%= sEntity %>" model="<%= ScheduleEntity.class %>" />

<portlet:actionURL name='<%= sEntity == null ? "addNewEmailTemplate" : "updateEmailTemplate" %>' var="editEmailURL" windowState="normal" />

<aui:form action="<%= editEmailURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="scheduleId" value='<%= sEntity == null ? "" : sEntity.getScheduleId() %>'/>

		<aui:input name="scheduleName" />

		<aui:input name="scheduleStore" disabled='<%= sEntity==null? Boolean.valueOf(false): Boolean.valueOf(true) %>'/>
		
		<aui:input name="scheduleType" />
		
		<aui:input name="scheduleFlagValue" />
		
		<aui:input name="scheduleOp" />
		
		<aui:select name="scheduleActive" showEmptyOption="<%=false %>" label="Active">
			<aui:option value="0"><%= HtmlUtil.escape("Choose one") %></aui:option>
			<aui:option value="1"><%= HtmlUtil.escape("Active") %></aui:option>
			<aui:option value="2"><%= HtmlUtil.escape("InActive") %></aui:option>
		</aui:select>
		
		<aui:select name="templateId" showEmptyOption="<%= true %>" label="Email template">

	 		<%
				for(EmailTemplateEntity email : emails){
			%>
			<aui:option value="<%= email.getTemplateId() %>" selected="<%= sEntity != null && email.getTemplateId() == sEntity.getTemplateId() %>"><%= HtmlUtil.escape(email.getTemplateSubject())%></aui:option>
			<%
				}
			%>

		</aui:select>
		

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>