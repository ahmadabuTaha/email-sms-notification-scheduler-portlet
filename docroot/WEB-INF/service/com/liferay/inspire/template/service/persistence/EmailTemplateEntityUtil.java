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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the email template entity service. This utility wraps {@link EmailTemplateEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmad Taha
 * @see EmailTemplateEntityPersistence
 * @see EmailTemplateEntityPersistenceImpl
 * @generated
 */
public class EmailTemplateEntityUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EmailTemplateEntity emailTemplateEntity) {
		getPersistence().clearCache(emailTemplateEntity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmailTemplateEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmailTemplateEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmailTemplateEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EmailTemplateEntity update(
		EmailTemplateEntity emailTemplateEntity, boolean merge)
		throws SystemException {
		return getPersistence().update(emailTemplateEntity, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EmailTemplateEntity update(
		EmailTemplateEntity emailTemplateEntity, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(emailTemplateEntity, merge, serviceContext);
	}

	/**
	* Caches the email template entity in the entity cache if it is enabled.
	*
	* @param emailTemplateEntity the email template entity
	*/
	public static void cacheResult(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity) {
		getPersistence().cacheResult(emailTemplateEntity);
	}

	/**
	* Caches the email template entities in the entity cache if it is enabled.
	*
	* @param emailTemplateEntities the email template entities
	*/
	public static void cacheResult(
		java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> emailTemplateEntities) {
		getPersistence().cacheResult(emailTemplateEntities);
	}

	/**
	* Creates a new email template entity with the primary key. Does not add the email template entity to the database.
	*
	* @param templateId the primary key for the new email template entity
	* @return the new email template entity
	*/
	public static com.liferay.inspire.template.model.EmailTemplateEntity create(
		long templateId) {
		return getPersistence().create(templateId);
	}

	/**
	* Removes the email template entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity that was removed
	* @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.EmailTemplateEntity remove(
		long templateId)
		throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(templateId);
	}

	public static com.liferay.inspire.template.model.EmailTemplateEntity updateImpl(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(emailTemplateEntity, merge);
	}

	/**
	* Returns the email template entity with the primary key or throws a {@link com.liferay.inspire.template.NoSuchEmailTemplateEntityException} if it could not be found.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity
	* @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.EmailTemplateEntity findByPrimaryKey(
		long templateId)
		throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(templateId);
	}

	/**
	* Returns the email template entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateId the primary key of the email template entity
	* @return the email template entity, or <code>null</code> if a email template entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.EmailTemplateEntity fetchByPrimaryKey(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(templateId);
	}

	/**
	* Returns all the email template entities.
	*
	* @return the email template entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.inspire.template.model.EmailTemplateEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the email template entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of email template entities.
	*
	* @return the number of email template entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmailTemplateEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmailTemplateEntityPersistence)PortletBeanLocatorUtil.locate(com.liferay.inspire.template.service.ClpSerializer.getServletContextName(),
					EmailTemplateEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(EmailTemplateEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EmailTemplateEntityPersistence persistence) {
	}

	private static EmailTemplateEntityPersistence _persistence;
}