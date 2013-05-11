<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
EmailTemplateEntity mail = (EmailTemplateEntity)row.getObject();


String name = EmailTemplateEntity.class.getName();
long templateId = mail.getTemplateId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/emailtemplatebuilder/edit_templatejsp.jsp" />
		<portlet:param name="templateId" value="<%= String.valueOf(templateId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteTemplate" var="deleteURL">
		<portlet:param name="templateId" value="<%= String.valueOf(templateId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>