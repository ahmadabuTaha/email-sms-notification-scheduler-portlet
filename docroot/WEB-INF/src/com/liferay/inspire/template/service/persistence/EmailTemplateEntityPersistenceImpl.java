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

import com.liferay.inspire.template.NoSuchEmailTemplateEntityException;
import com.liferay.inspire.template.model.EmailTemplateEntity;
import com.liferay.inspire.template.model.impl.EmailTemplateEntityImpl;
import com.liferay.inspire.template.model.impl.EmailTemplateEntityModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the email template entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmad Taha
 * @see EmailTemplateEntityPersistence
 * @see EmailTemplateEntityUtil
 * @generated
 */
public class EmailTemplateEntityPersistenceImpl extends BasePersistenceImpl<EmailTemplateEntity>
	implements EmailTemplateEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmailTemplateEntityUtil} to access the email template entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmailTemplateEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateEntityModelImpl.FINDER_CACHE_ENABLED,
			EmailTemplateEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateEntityModelImpl.FINDER_CACHE_ENABLED,
			EmailTemplateEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the email template entity in the entity cache if it is enabled.
	 *
	 * @param emailTemplateEntity the email template entity
	 */
	public void cacheResult(EmailTemplateEntity emailTemplateEntity) {
		EntityCacheUtil.putResult(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateEntityImpl.class, emailTemplateEntity.getPrimaryKey(),
			emailTemplateEntity);

		emailTemplateEntity.resetOriginalValues();
	}

	/**
	 * Caches the email template entities in the entity cache if it is enabled.
	 *
	 * @param emailTemplateEntities the email template entities
	 */
	public void cacheResult(List<EmailTemplateEntity> emailTemplateEntities) {
		for (EmailTemplateEntity emailTemplateEntity : emailTemplateEntities) {
			if (EntityCacheUtil.getResult(
						EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
						EmailTemplateEntityImpl.class,
						emailTemplateEntity.getPrimaryKey()) == null) {
				cacheResult(emailTemplateEntity);
			}
			else {
				emailTemplateEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all email template entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmailTemplateEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmailTemplateEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the email template entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmailTemplateEntity emailTemplateEntity) {
		EntityCacheUtil.removeResult(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateEntityImpl.class, emailTemplateEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmailTemplateEntity> emailTemplateEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmailTemplateEntity emailTemplateEntity : emailTemplateEntities) {
			EntityCacheUtil.removeResult(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
				EmailTemplateEntityImpl.class,
				emailTemplateEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new email template entity with the primary key. Does not add the email template entity to the database.
	 *
	 * @param templateId the primary key for the new email template entity
	 * @return the new email template entity
	 */
	public EmailTemplateEntity create(long templateId) {
		EmailTemplateEntity emailTemplateEntity = new EmailTemplateEntityImpl();

		emailTemplateEntity.setNew(true);
		emailTemplateEntity.setPrimaryKey(templateId);

		return emailTemplateEntity;
	}

	/**
	 * Removes the email template entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param templateId the primary key of the email template entity
	 * @return the email template entity that was removed
	 * @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EmailTemplateEntity remove(long templateId)
		throws NoSuchEmailTemplateEntityException, SystemException {
		return remove(Long.valueOf(templateId));
	}

	/**
	 * Removes the email template entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the email template entity
	 * @return the email template entity that was removed
	 * @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailTemplateEntity remove(Serializable primaryKey)
		throws NoSuchEmailTemplateEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmailTemplateEntity emailTemplateEntity = (EmailTemplateEntity)session.get(EmailTemplateEntityImpl.class,
					primaryKey);

			if (emailTemplateEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmailTemplateEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emailTemplateEntity);
		}
		catch (NoSuchEmailTemplateEntityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmailTemplateEntity removeImpl(
		EmailTemplateEntity emailTemplateEntity) throws SystemException {
		emailTemplateEntity = toUnwrappedModel(emailTemplateEntity);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, emailTemplateEntity);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(emailTemplateEntity);

		return emailTemplateEntity;
	}

	@Override
	public EmailTemplateEntity updateImpl(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity,
		boolean merge) throws SystemException {
		emailTemplateEntity = toUnwrappedModel(emailTemplateEntity);

		boolean isNew = emailTemplateEntity.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, emailTemplateEntity, merge);

			emailTemplateEntity.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
			EmailTemplateEntityImpl.class, emailTemplateEntity.getPrimaryKey(),
			emailTemplateEntity);

		return emailTemplateEntity;
	}

	protected EmailTemplateEntity toUnwrappedModel(
		EmailTemplateEntity emailTemplateEntity) {
		if (emailTemplateEntity instanceof EmailTemplateEntityImpl) {
			return emailTemplateEntity;
		}

		EmailTemplateEntityImpl emailTemplateEntityImpl = new EmailTemplateEntityImpl();

		emailTemplateEntityImpl.setNew(emailTemplateEntity.isNew());
		emailTemplateEntityImpl.setPrimaryKey(emailTemplateEntity.getPrimaryKey());

		emailTemplateEntityImpl.setTemplateId(emailTemplateEntity.getTemplateId());
		emailTemplateEntityImpl.setTemplateSubject(emailTemplateEntity.getTemplateSubject());
		emailTemplateEntityImpl.setTemplateBody(emailTemplateEntity.getTemplateBody());
		emailTemplateEntityImpl.setTemplateSender(emailTemplateEntity.getTemplateSender());

		return emailTemplateEntityImpl;
	}

	/**
	 * Returns the email template entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the email template entity
	 * @return the email template entity
	 * @throws com.liferay.portal.NoSuchModelException if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailTemplateEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the email template entity with the primary key or throws a {@link com.liferay.inspire.template.NoSuchEmailTemplateEntityException} if it could not be found.
	 *
	 * @param templateId the primary key of the email template entity
	 * @return the email template entity
	 * @throws com.liferay.inspire.template.NoSuchEmailTemplateEntityException if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EmailTemplateEntity findByPrimaryKey(long templateId)
		throws NoSuchEmailTemplateEntityException, SystemException {
		EmailTemplateEntity emailTemplateEntity = fetchByPrimaryKey(templateId);

		if (emailTemplateEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + templateId);
			}

			throw new NoSuchEmailTemplateEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				templateId);
		}

		return emailTemplateEntity;
	}

	/**
	 * Returns the email template entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the email template entity
	 * @return the email template entity, or <code>null</code> if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmailTemplateEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the email template entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param templateId the primary key of the email template entity
	 * @return the email template entity, or <code>null</code> if a email template entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EmailTemplateEntity fetchByPrimaryKey(long templateId)
		throws SystemException {
		EmailTemplateEntity emailTemplateEntity = (EmailTemplateEntity)EntityCacheUtil.getResult(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
				EmailTemplateEntityImpl.class, templateId);

		if (emailTemplateEntity == _nullEmailTemplateEntity) {
			return null;
		}

		if (emailTemplateEntity == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				emailTemplateEntity = (EmailTemplateEntity)session.get(EmailTemplateEntityImpl.class,
						Long.valueOf(templateId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (emailTemplateEntity != null) {
					cacheResult(emailTemplateEntity);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EmailTemplateEntityModelImpl.ENTITY_CACHE_ENABLED,
						EmailTemplateEntityImpl.class, templateId,
						_nullEmailTemplateEntity);
				}

				closeSession(session);
			}
		}

		return emailTemplateEntity;
	}

	/**
	 * Returns all the email template entities.
	 *
	 * @return the email template entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<EmailTemplateEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EmailTemplateEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<EmailTemplateEntity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EmailTemplateEntity> list = (List<EmailTemplateEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMAILTEMPLATEENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMAILTEMPLATEENTITY.concat(EmailTemplateEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EmailTemplateEntity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EmailTemplateEntity>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the email template entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EmailTemplateEntity emailTemplateEntity : findAll()) {
			remove(emailTemplateEntity);
		}
	}

	/**
	 * Returns the number of email template entities.
	 *
	 * @return the number of email template entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMAILTEMPLATEENTITY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the email template entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.inspire.template.model.EmailTemplateEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmailTemplateEntity>> listenersList = new ArrayList<ModelListener<EmailTemplateEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmailTemplateEntity>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EmailTemplateEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = EmailTemplateEntityPersistence.class)
	protected EmailTemplateEntityPersistence emailTemplateEntityPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EMAILTEMPLATEENTITY = "SELECT emailTemplateEntity FROM EmailTemplateEntity emailTemplateEntity";
	private static final String _SQL_COUNT_EMAILTEMPLATEENTITY = "SELECT COUNT(emailTemplateEntity) FROM EmailTemplateEntity emailTemplateEntity";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emailTemplateEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmailTemplateEntity exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmailTemplateEntityPersistenceImpl.class);
	private static EmailTemplateEntity _nullEmailTemplateEntity = new EmailTemplateEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmailTemplateEntity> toCacheModel() {
				return _nullEmailTemplateEntityCacheModel;
			}
		};

	private static CacheModel<EmailTemplateEntity> _nullEmailTemplateEntityCacheModel =
		new CacheModel<EmailTemplateEntity>() {
			public EmailTemplateEntity toEntityModel() {
				return _nullEmailTemplateEntity;
			}
		};
}