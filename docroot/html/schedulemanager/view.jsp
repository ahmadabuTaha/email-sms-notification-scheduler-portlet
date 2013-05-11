<%@include file="/html/init.jsp" %>


<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<aui:button-row>
	<portlet:renderURL var="addScheduleURL">
		<portlet:param name="mvcPath" value="/html/schedulemanager/edit_schedulejsp.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-template" onClick="<%= addScheduleURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="template-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ScheduleEntityLocalServiceUtil.getScheduleEntities(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ScheduleEntityLocalServiceUtil.getScheduleEntitiesCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.inspire.template.model.ScheduleEntity"
		keyProperty="scheduleId"
		modelVar="schedule" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="schedule-id"
			value="<%= String.valueOf(schedule.getScheduleId()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="schedule-Name"
			property="scheduleName"
		/>

		<liferay-ui:search-container-column-text
			name="schedule-Type"
			property="scheduleType"
		/>
		
		<liferay-ui:search-container-column-text
			name="schedule-Flag-Value"
			property="scheduleFlagValue"
		/>

		<liferay-ui:search-container-column-text
			name="template-Operator"
			property="scheduleOp"
		/>
		<liferay-ui:search-container-column-text
			name="template-active"
			property="scheduleActive"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/schedulemanager/schedule_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>