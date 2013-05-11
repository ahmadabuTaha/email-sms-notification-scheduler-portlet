/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.inspire.template.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EmailTemplateEntityLocalService}.
 * </p>
 *
 * @author    Ahmad Taha
 * @see       EmailTemplateEntityLocalService
 * @generated
 */
public class EmailTemplateEntityLocalServiceWrapper
	implements EmailTemplateEntityLocalService,
		ServiceWrapper<EmailTemplateEntityLocalService> {
	public EmailTemplateEntityLocalServiceWrapper(
		EmailTemplateEntityLocalService emailTemplateEntityLocalService) {
		_emailTemplateEntityLocalService = emailTemplateEntityLocalService;
	}

	/**
	* Adds the email template entity to the database. Also notifies the appropriate model listeners.
	*
	* @param emailTemplateEntity the email template entity
	* @return the email template entity that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity addEmailTemplateEntity(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.addEmailTemplateEntity(emailTemplateEntity);
	}

	/**
	* Creates a new email template entity with the primary key. Does not add the email template entity to the database.
	*
	* @param templateId the primary key for the new email template entity
	* @return the new email template entity
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity createEmailTemplateEntity(
		long templateId) {
		return _emailTemplateEntityLocalService.createEmailTemplateEntity(templateId);
	}

	/**
	* Deletes the email template entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity that was removed
	* @throws PortalException if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity deleteEmailTemplateEntity(
		long templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.deleteEmailTemplateEntity(templateId);
	}

	/**
	* Deletes the email template entity from the database. Also notifies the appropriate model listeners.
	*
	* @param emailTemplateEntity the email template entity
	* @return the email template entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity deleteEmailTemplateEntity(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.deleteEmailTemplateEntity(emailTemplateEntity);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emailTemplateEntityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.inspire.template.model.EmailTemplateEntity fetchEmailTemplateEntity(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.fetchEmailTemplateEntity(templateId);
	}

	/**
	* Returns the email template entity with the primary key.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity
	* @throws PortalException if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity getEmailTemplateEntity(
		long templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.getEmailTemplateEntity(templateId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the email template entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of email template entities
	* @param end the upper bound of the range of email template entities (not inclusive)
	* @return the range of email template entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> getEmailTemplateEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.getEmailTemplateEntities(start,
			end);
	}

	/**
	* Returns the number of email template entities.
	*
	* @return the number of email template entities
	* @throws SystemException if a system exception occurred
	*/
	public int getEmailTemplateEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.getEmailTemplateEntitiesCount();
	}

	/**
	* Updates the email template entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailTemplateEntity the email template entity
	* @return the email template entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity updateEmailTemplateEntity(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.updateEmailTemplateEntity(emailTemplateEntity);
	}

	/**
	* Updates the email template entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emailTemplateEntity the email template entity
	* @param merge whether to merge the email template entity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the email template entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity updateEmailTemplateEntity(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emailTemplateEntityLocalService.updateEmailTemplateEntity(emailTemplateEntity,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _emailTemplateEntityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_emailTemplateEntityLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _emailTemplateEntityLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EmailTemplateEntityLocalService getWrappedEmailTemplateEntityLocalService() {
		return _emailTemplateEntityLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEmailTemplateEntityLocalService(
		EmailTemplateEntityLocalService emailTemplateEntityLocalService) {
		_emailTemplateEntityLocalService = emailTemplateEntityLocalService;
	}

	public EmailTemplateEntityLocalService getWrappedService() {
		return _emailTemplateEntityLocalService;
	}

	public void setWrappedService(
		EmailTemplateEntityLocalService emailTemplateEntityLocalService) {
		_emailTemplateEntityLocalService = emailTemplateEntityLocalService;
	}

	private EmailTemplateEntityLocalService _emailTemplateEntityLocalService;
}