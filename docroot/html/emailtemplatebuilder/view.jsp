<%@include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<aui:button-row>
	<portlet:renderURL var="addEmailURL">
		<portlet:param name="mvcPath" value="/html/emailtemplatebuilder/edit_templatejsp.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-template" onClick="<%= addEmailURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="template-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= EmailTemplateEntityLocalServiceUtil.getEmailTemplateEntities(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= EmailTemplateEntityLocalServiceUtil.getEmailTemplateEntitiesCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.inspire.template.model.EmailTemplateEntity"
		keyProperty="templateId"
		modelVar="template" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="template-id"
			value="<%= String.valueOf(template.getTemplateId()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="template-subject"
			property="templateSubject"
		/>

		<liferay-ui:search-container-column-text
			name="template-body"
			property="templateBody"
		/>

		<liferay-ui:search-container-column-text
			name="template-sender"
			property="templateSender"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/emailtemplatebuilder/template_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>