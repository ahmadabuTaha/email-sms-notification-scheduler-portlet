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

package com.liferay.inspire.template.service.persistence;

import com.liferay.inspire.template.model.EmailTemplateEntity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the email template entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmad Taha
 * @see EmailTemplateEntityPersistenceImpl
 * @see EmailTemplateEntityUtil
 * @generated
 */
public interface EmailTemplateEntityPersistence extends BasePersistence<EmailTemplateEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmailTemplateEntityUtil} to access the email template entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the email template entity in the entity cache if it is enabled.
	*
	* @param emailTemplateEntity the email template entity
	*/
	public void cacheResult(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity);

	/**
	* Caches the email template entities in the entity cache if it is enabled.
	*
	* @param emailTemplateEntities the email template entities
	*/
	public void cacheResult(
		java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> emailTemplateEntities);

	/**
	* Creates a new email template entity with the primary key. Does not add the email template entity to the database.
	*
	* @param templateId the primary key for the new email template entity
	* @return the new email template entity
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity create(
		long templateId);

	/**
	* Removes the email template entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity that was removed
	* @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity remove(
		long templateId)
		throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.inspire.template.model.EmailTemplateEntity updateImpl(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email template entity with the primary key or throws a {@link com.liferay.inspire.template.NoSuchEmailTemplateEntityException} if it could not be found.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity
	* @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity findByPrimaryKey(
		long templateId)
		throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the email template entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity, or <code>null</code> if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.EmailTemplateEntity fetchByPrimaryKey(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the email template entities.
	*
	* @return the email template entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the email template entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of email template entities
	* @param end the upper bound of the range of email template entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of email template entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the email template entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of email template entities.
	*
	* @return the number of email template entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}