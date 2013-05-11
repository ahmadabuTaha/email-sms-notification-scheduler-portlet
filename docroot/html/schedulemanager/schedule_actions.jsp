<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ScheduleEntity sEntity = (ScheduleEntity)row.getObject();


String name = ScheduleEntity.class.getName();
long scheduleId = sEntity.getScheduleId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/schedulemanager/edit_schedulejsp.jsp" />
		<portlet:param name="scheduleId" value="<%= String.valueOf(scheduleId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteTemplate" var="deleteURL">
		<portlet:param name="templateId" value="<%= String.valueOf(scheduleId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>


