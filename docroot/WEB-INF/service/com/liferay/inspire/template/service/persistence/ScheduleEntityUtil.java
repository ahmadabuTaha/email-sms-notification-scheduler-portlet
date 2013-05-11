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

import com.liferay.inspire.template.model.ScheduleEntity;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the schedule entity service. This utility wraps {@link ScheduleEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmad Taha
 * @see ScheduleEntityPersistence
 * @see ScheduleEntityPersistenceImpl
 * @generated
 */
public class ScheduleEntityUtil {
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
	public static void clearCache(ScheduleEntity scheduleEntity) {
		getPersistence().clearCache(scheduleEntity);
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
	public static List<ScheduleEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScheduleEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScheduleEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ScheduleEntity update(ScheduleEntity scheduleEntity,
		boolean merge) throws SystemException {
		return getPersistence().update(scheduleEntity, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ScheduleEntity update(ScheduleEntity scheduleEntity,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(scheduleEntity, merge, serviceContext);
	}

	/**
	* Caches the schedule entity in the entity cache if it is enabled.
	*
	* @param scheduleEntity the schedule entity
	*/
	public static void cacheResult(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity) {
		getPersistence().cacheResult(scheduleEntity);
	}

	/**
	* Caches the schedule entities in the entity cache if it is enabled.
	*
	* @param scheduleEntities the schedule entities
	*/
	public static void cacheResult(
		java.util.List<com.liferay.inspire.template.model.ScheduleEntity> scheduleEntities) {
		getPersistence().cacheResult(scheduleEntities);
	}

	/**
	* Creates a new schedule entity with the primary key. Does not add the schedule entity to the database.
	*
	* @param scheduleId the primary key for the new schedule entity
	* @return the new schedule entity
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity create(
		long scheduleId) {
		return getPersistence().create(scheduleId);
	}

	/**
	* Removes the schedule entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity that was removed
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity remove(
		long scheduleId)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(scheduleId);
	}

	public static com.liferay.inspire.template.model.ScheduleEntity updateImpl(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scheduleEntity, merge);
	}

	/**
	* Returns the schedule entity with the primary key or throws a {@link com.liferay.inspire.template.NoSuchScheduleEntityException} if it could not be found.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity findByPrimaryKey(
		long scheduleId)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(scheduleId);
	}

	/**
	* Returns the schedule entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity, or <code>null</code> if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity fetchByPrimaryKey(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scheduleId);
	}

	/**
	* Returns all the schedule entities where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId);
	}

	/**
	* Returns a range of all the schedule entities where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of schedule entities
	* @param end the upper bound of the range of schedule entities (not inclusive)
	* @return the range of matching schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId, start, end);
	}

	/**
	* Returns an ordered range of all the schedule entities where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of schedule entities
	* @param end the upper bound of the range of schedule entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(templateId, start, end, orderByComparator);
	}

	/**
	* Returns the first schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the first schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule entity, or <code>null</code> if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the last schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the last schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule entity, or <code>null</code> if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the schedule entities before and after the current schedule entity in the ordered set where templateId = &#63;.
	*
	* @param scheduleId the primary key of the current schedule entity
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity[] findByTemplateId_PrevAndNext(
		long scheduleId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(scheduleId, templateId,
			orderByComparator);
	}

	/**
	* Returns all the schedule entities.
	*
	* @return the schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the schedule entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of schedule entities
	* @param end the upper bound of the range of schedule entities (not inclusive)
	* @return the range of schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the schedule entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of schedule entities
	* @param end the upper bound of the range of schedule entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the schedule entities where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(templateId);
	}

	/**
	* Removes all the schedule entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of schedule entities where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(templateId);
	}

	/**
	* Returns the number of schedule entities.
	*
	* @return the number of schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScheduleEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScheduleEntityPersistence)PortletBeanLocatorUtil.locate(com.liferay.inspire.template.service.ClpSerializer.getServletContextName(),
					ScheduleEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(ScheduleEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ScheduleEntityPersistence persistence) {
	}

	private static ScheduleEntityPersistence _persistence;
}