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
 * This class is a wrapper for {@link ScheduleEntityLocalService}.
 * </p>
 *
 * @author    Ahmad Taha
 * @see       ScheduleEntityLocalService
 * @generated
 */
public class ScheduleEntityLocalServiceWrapper
	implements ScheduleEntityLocalService,
		ServiceWrapper<ScheduleEntityLocalService> {
	public ScheduleEntityLocalServiceWrapper(
		ScheduleEntityLocalService scheduleEntityLocalService) {
		_scheduleEntityLocalService = scheduleEntityLocalService;
	}

	/**
	* Adds the schedule entity to the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @return the schedule entity that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity addScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.addScheduleEntity(scheduleEntity);
	}

	/**
	* Creates a new schedule entity with the primary key. Does not add the schedule entity to the database.
	*
	* @param scheduleId the primary key for the new schedule entity
	* @return the new schedule entity
	*/
	public com.liferay.inspire.template.model.ScheduleEntity createScheduleEntity(
		long scheduleId) {
		return _scheduleEntityLocalService.createScheduleEntity(scheduleId);
	}

	/**
	* Deletes the schedule entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity that was removed
	* @throws PortalException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity deleteScheduleEntity(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.deleteScheduleEntity(scheduleId);
	}

	/**
	* Deletes the schedule entity from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @return the schedule entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity deleteScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.deleteScheduleEntity(scheduleEntity);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scheduleEntityLocalService.dynamicQuery();
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
		return _scheduleEntityLocalService.dynamicQuery(dynamicQuery);
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
		return _scheduleEntityLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _scheduleEntityLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _scheduleEntityLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.inspire.template.model.ScheduleEntity fetchScheduleEntity(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.fetchScheduleEntity(scheduleId);
	}

	/**
	* Returns the schedule entity with the primary key.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity
	* @throws PortalException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity getScheduleEntity(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.getScheduleEntity(scheduleId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.inspire.template.model.ScheduleEntity> getScheduleEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.getScheduleEntities(start, end);
	}

	/**
	* Returns the number of schedule entities.
	*
	* @return the number of schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public int getScheduleEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.getScheduleEntitiesCount();
	}

	/**
	* Updates the schedule entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @return the schedule entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity updateScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.updateScheduleEntity(scheduleEntity);
	}

	/**
	* Updates the schedule entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @param merge whether to merge the schedule entity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the schedule entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.inspire.template.model.ScheduleEntity updateScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleEntityLocalService.updateScheduleEntity(scheduleEntity,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _scheduleEntityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scheduleEntityLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scheduleEntityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ScheduleEntityLocalService getWrappedScheduleEntityLocalService() {
		return _scheduleEntityLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedScheduleEntityLocalService(
		ScheduleEntityLocalService scheduleEntityLocalService) {
		_scheduleEntityLocalService = scheduleEntityLocalService;
	}

	public ScheduleEntityLocalService getWrappedService() {
		return _scheduleEntityLocalService;
	}

	public void setWrappedService(
		ScheduleEntityLocalService scheduleEntityLocalService) {
		_scheduleEntityLocalService = scheduleEntityLocalService;
	}

	private ScheduleEntityLocalService _scheduleEntityLocalService;
}