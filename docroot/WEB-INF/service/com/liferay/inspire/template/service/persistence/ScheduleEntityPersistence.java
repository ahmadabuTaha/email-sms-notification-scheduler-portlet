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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the schedule entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmad Taha
 * @see ScheduleEntityPersistenceImpl
 * @see ScheduleEntityUtil
 * @generated
 */
public interface ScheduleEntityPersistence extends BasePersistence<ScheduleEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScheduleEntityUtil} to access the schedule entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the schedule entity in the entity cache if it is enabled.
	*
	* @param scheduleEntity the schedule entity
	*/
	public void cacheResult(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity);

	/**
	* Caches the schedule entities in the entity cache if it is enabled.
	*
	* @param scheduleEntities the schedule entities
	*/
	public void cacheResult(
		java.util.List<com.liferay.inspire.template.model.ScheduleEntity> scheduleEntities);

	/**
	* Creates a new schedule entity with the primary key. Does not add the schedule entity to the database.
	*
	* @param scheduleId the primary key for the new schedule entity
	* @return the new schedule entity
	*/
	public com.liferay.inspire.template.model.ScheduleEntity create(
		long scheduleId);

	/**
	* Removes the schedule entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity that was removed
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity remove(
		long scheduleId)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.inspire.template.model.ScheduleEntity updateImpl(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schedule entity with the primary key or throws a {@link com.liferay.inspire.template.NoSuchScheduleEntityException} if it could not be found.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity findByPrimaryKey(
		long scheduleId)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schedule entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity, or <code>null</code> if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity fetchByPrimaryKey(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the schedule entities where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching schedule entity, or <code>null</code> if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule entity
	* @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last schedule entity in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching schedule entity, or <code>null</code> if a matching schedule entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.inspire.template.model.ScheduleEntity[] findByTemplateId_PrevAndNext(
		long scheduleId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.inspire.template.NoSuchScheduleEntityException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the schedule entities.
	*
	* @return the schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the schedule entities where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the schedule entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schedule entities where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schedule entities.
	*
	* @return the number of schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}