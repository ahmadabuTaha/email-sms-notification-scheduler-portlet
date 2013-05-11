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

package com.liferay.inspire.template.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.inspire.template.model.EmailTemplateEntity;
import com.liferay.inspire.template.service.EmailTemplateEntityLocalService;
import com.liferay.inspire.template.service.ScheduleEntityLocalService;
import com.liferay.inspire.template.service.persistence.EmailTemplateEntityPersistence;
import com.liferay.inspire.template.service.persistence.ScheduleEntityPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the email template entity local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.inspire.template.service.impl.EmailTemplateEntityLocalServiceImpl}.
 * </p>
 *
 * @author Ahmad Taha
 * @see com.liferay.inspire.template.service.impl.EmailTemplateEntityLocalServiceImpl
 * @see com.liferay.inspire.template.service.EmailTemplateEntityLocalServiceUtil
 * @generated
 */
public abstract class EmailTemplateEntityLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EmailTemplateEntityLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.inspire.template.service.EmailTemplateEntityLocalServiceUtil} to access the email template entity local service.
	 */

	/**
	 * Adds the email template entity to the database. Also notifies the appropriate model listeners.
	 *
	 * @param emailTemplateEntity the email template entity
	 * @return the email template entity that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmailTemplateEntity addEmailTemplateEntity(
		EmailTemplateEntity emailTemplateEntity) throws SystemException {
		emailTemplateEntity.setNew(true);

		return emailTemplateEntityPersistence.update(emailTemplateEntity, false);
	}

	/**
	 * Creates a new email template entity with the primary key. Does not add the email template entity to the database.
	 *
	 * @param templateId the primary key for the new email template entity
	 * @return the new email template entity
	 */
	public EmailTemplateEntity createEmailTemplateEntity(long templateId) {
		return emailTemplateEntityPersistence.create(templateId);
	}

	/**
	 * Deletes the email template entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the email template entity
	 * @return the email template entity that was removed
	 * @throws PortalException if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmailTemplateEntity deleteEmailTemplateEntity(long templateId)
		throws PortalException, SystemException {
		return emailTemplateEntityPersistence.remove(templateId);
	}

	/**
	 * Deletes the email template entity from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emailTemplateEntity the email template entity
	 * @return the email template entity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public EmailTemplateEntity deleteEmailTemplateEntity(
		EmailTemplateEntity emailTemplateEntity) throws SystemException {
		return emailTemplateEntityPersistence.remove(emailTemplateEntity);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EmailTemplateEntity.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return emailTemplateEntityPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return emailTemplateEntityPersistence.findWithDynamicQuery(dynamicQuery,
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return emailTemplateEntityPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return emailTemplateEntityPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public EmailTemplateEntity fetchEmailTemplateEntity(long templateId)
		throws SystemException {
		return emailTemplateEntityPersistence.fetchByPrimaryKey(templateId);
	}

	/**
	 * Returns the email template entity with the primary key.
	 *
	 * @param templateId the primary key of the email template entity
	 * @return the email template entity
	 * @throws PortalException if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EmailTemplateEntity getEmailTemplateEntity(long templateId)
		throws PortalException, SystemException {
		return emailTemplateEntityPersistence.findByPrimaryKey(templateId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return emailTemplateEntityPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<EmailTemplateEntity> getEmailTemplateEntities(int start, int end)
		throws SystemException {
		return emailTemplateEntityPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of email template entities.
	 *
	 * @return the number of email template entities
	 * @throws SystemException if a system exception occurred
	 */
	public int getEmailTemplateEntitiesCount() throws SystemException {
		return emailTemplateEntityPersistence.countAll();
	}

	/**
	 * Updates the email template entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param emailTemplateEntity the email template entity
	 * @return the email template entity that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmailTemplateEntity updateEmailTemplateEntity(
		EmailTemplateEntity emailTemplateEntity) throws SystemException {
		return updateEmailTemplateEntity(emailTemplateEntity, true);
	}

	/**
	 * Updates the email template entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param emailTemplateEntity the email template entity
	 * @param merge whether to merge the email template entity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the email template entity that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EmailTemplateEntity updateEmailTemplateEntity(
		EmailTemplateEntity emailTemplateEntity, boolean merge)
		throws SystemException {
		emailTemplateEntity.setNew(false);

		return emailTemplateEntityPersistence.update(emailTemplateEntity, merge);
	}

	/**
	 * Returns the email template entity local service.
	 *
	 * @return the email template entity local service
	 */
	public EmailTemplateEntityLocalService getEmailTemplateEntityLocalService() {
		return emailTemplateEntityLocalService;
	}

	/**
	 * Sets the email template entity local service.
	 *
	 * @param emailTemplateEntityLocalService the email template entity local service
	 */
	public void setEmailTemplateEntityLocalService(
		EmailTemplateEntityLocalService emailTemplateEntityLocalService) {
		this.emailTemplateEntityLocalService = emailTemplateEntityLocalService;
	}

	/**
	 * Returns the email template entity persistence.
	 *
	 * @return the email template entity persistence
	 */
	public EmailTemplateEntityPersistence getEmailTemplateEntityPersistence() {
		return emailTemplateEntityPersistence;
	}

	/**
	 * Sets the email template entity persistence.
	 *
	 * @param emailTemplateEntityPersistence the email template entity persistence
	 */
	public void setEmailTemplateEntityPersistence(
		EmailTemplateEntityPersistence emailTemplateEntityPersistence) {
		this.emailTemplateEntityPersistence = emailTemplateEntityPersistence;
	}

	/**
	 * Returns the schedule entity local service.
	 *
	 * @return the schedule entity local service
	 */
	public ScheduleEntityLocalService getScheduleEntityLocalService() {
		return scheduleEntityLocalService;
	}

	/**
	 * Sets the schedule entity local service.
	 *
	 * @param scheduleEntityLocalService the schedule entity local service
	 */
	public void setScheduleEntityLocalService(
		ScheduleEntityLocalService scheduleEntityLocalService) {
		this.scheduleEntityLocalService = scheduleEntityLocalService;
	}

	/**
	 * Returns the schedule entity persistence.
	 *
	 * @return the schedule entity persistence
	 */
	public ScheduleEntityPersistence getScheduleEntityPersistence() {
		return scheduleEntityPersistence;
	}

	/**
	 * Sets the schedule entity persistence.
	 *
	 * @param scheduleEntityPersistence the schedule entity persistence
	 */
	public void setScheduleEntityPersistence(
		ScheduleEntityPersistence scheduleEntityPersistence) {
		this.scheduleEntityPersistence = scheduleEntityPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.inspire.template.model.EmailTemplateEntity",
			emailTemplateEntityLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.inspire.template.model.EmailTemplateEntity");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return EmailTemplateEntity.class;
	}

	protected String getModelClassName() {
		return EmailTemplateEntity.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = emailTemplateEntityPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = EmailTemplateEntityLocalService.class)
	protected EmailTemplateEntityLocalService emailTemplateEntityLocalService;
	@BeanReference(type = EmailTemplateEntityPersistence.class)
	protected EmailTemplateEntityPersistence emailTemplateEntityPersistence;
	@BeanReference(type = ScheduleEntityLocalService.class)
	protected ScheduleEntityLocalService scheduleEntityLocalService;
	@BeanReference(type = ScheduleEntityPersistence.class)
	protected ScheduleEntityPersistence scheduleEntityPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private EmailTemplateEntityLocalServiceClpInvoker _clpInvoker = new EmailTemplateEntityLocalServiceClpInvoker();
}