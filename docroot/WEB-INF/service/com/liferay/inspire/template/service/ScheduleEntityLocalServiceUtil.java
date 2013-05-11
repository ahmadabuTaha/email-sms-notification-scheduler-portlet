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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the schedule entity local service. This utility wraps {@link com.liferay.inspire.template.service.impl.ScheduleEntityLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ahmad Taha
 * @see ScheduleEntityLocalService
 * @see com.liferay.inspire.template.service.base.ScheduleEntityLocalServiceBaseImpl
 * @see com.liferay.inspire.template.service.impl.ScheduleEntityLocalServiceImpl
 * @generated
 */
public class ScheduleEntityLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.inspire.template.service.impl.ScheduleEntityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the schedule entity to the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @return the schedule entity that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity addScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScheduleEntity(scheduleEntity);
	}

	/**
	* Creates a new schedule entity with the primary key. Does not add the schedule entity to the database.
	*
	* @param scheduleId the primary key for the new schedule entity
	* @return the new schedule entity
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity createScheduleEntity(
		long scheduleId) {
		return getService().createScheduleEntity(scheduleId);
	}

	/**
	* Deletes the schedule entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity that was removed
	* @throws PortalException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity deleteScheduleEntity(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScheduleEntity(scheduleId);
	}

	/**
	* Deletes the schedule entity from the database. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @return the schedule entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity deleteScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScheduleEntity(scheduleEntity);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.inspire.template.model.ScheduleEntity fetchScheduleEntity(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchScheduleEntity(scheduleId);
	}

	/**
	* Returns the schedule entity with the primary key.
	*
	* @param scheduleId the primary key of the schedule entity
	* @return the schedule entity
	* @throws PortalException if a schedule entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity getScheduleEntity(
		long scheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScheduleEntity(scheduleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.inspire.template.model.ScheduleEntity> getScheduleEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScheduleEntities(start, end);
	}

	/**
	* Returns the number of schedule entities.
	*
	* @return the number of schedule entities
	* @throws SystemException if a system exception occurred
	*/
	public static int getScheduleEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScheduleEntitiesCount();
	}

	/**
	* Updates the schedule entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @return the schedule entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity updateScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScheduleEntity(scheduleEntity);
	}

	/**
	* Updates the schedule entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scheduleEntity the schedule entity
	* @param merge whether to merge the schedule entity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the schedule entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.inspire.template.model.ScheduleEntity updateScheduleEntity(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScheduleEntity(scheduleEntity, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScheduleEntityLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScheduleEntityLocalService.class.getName());

			if (invokableLocalService instanceof ScheduleEntityLocalService) {
				_service = (ScheduleEntityLocalService)invokableLocalService;
			}
			else {
				_service = new ScheduleEntityLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ScheduleEntityLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ScheduleEntityLocalService service) {
	}

	private static ScheduleEntityLocalService _service;
}