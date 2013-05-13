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

import com.liferay.inspire.template.NoSuchScheduleEntityException;
import com.liferay.inspire.template.model.ScheduleEntity;
import com.liferay.inspire.template.model.impl.ScheduleEntityImpl;
import com.liferay.inspire.template.model.impl.ScheduleEntityModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the schedule entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmad Taha
 * @see ScheduleEntityPersistence
 * @see ScheduleEntityUtil
 * @generated
 */
public class ScheduleEntityPersistenceImpl extends BasePersistenceImpl<ScheduleEntity>
	implements ScheduleEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScheduleEntityUtil} to access the schedule entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScheduleEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityModelImpl.FINDER_CACHE_ENABLED,
			ScheduleEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityModelImpl.FINDER_CACHE_ENABLED,
			ScheduleEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			ScheduleEntityModelImpl.TEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityModelImpl.FINDER_CACHE_ENABLED,
			ScheduleEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityModelImpl.FINDER_CACHE_ENABLED,
			ScheduleEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the schedule entity in the entity cache if it is enabled.
	 *
	 * @param scheduleEntity the schedule entity
	 */
	public void cacheResult(ScheduleEntity scheduleEntity) {
		EntityCacheUtil.putResult(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityImpl.class, scheduleEntity.getPrimaryKey(),
			scheduleEntity);

		scheduleEntity.resetOriginalValues();
	}

	/**
	 * Caches the schedule entities in the entity cache if it is enabled.
	 *
	 * @param scheduleEntities the schedule entities
	 */
	public void cacheResult(List<ScheduleEntity> scheduleEntities) {
		for (ScheduleEntity scheduleEntity : scheduleEntities) {
			if (EntityCacheUtil.getResult(
						ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
						ScheduleEntityImpl.class, scheduleEntity.getPrimaryKey()) == null) {
				cacheResult(scheduleEntity);
			}
			else {
				scheduleEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all schedule entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScheduleEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScheduleEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the schedule entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScheduleEntity scheduleEntity) {
		EntityCacheUtil.removeResult(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityImpl.class, scheduleEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScheduleEntity> scheduleEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScheduleEntity scheduleEntity : scheduleEntities) {
			EntityCacheUtil.removeResult(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
				ScheduleEntityImpl.class, scheduleEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new schedule entity with the primary key. Does not add the schedule entity to the database.
	 *
	 * @param scheduleId the primary key for the new schedule entity
	 * @return the new schedule entity
	 */
	public ScheduleEntity create(long scheduleId) {
		ScheduleEntity scheduleEntity = new ScheduleEntityImpl();

		scheduleEntity.setNew(true);
		scheduleEntity.setPrimaryKey(scheduleId);

		return scheduleEntity;
	}

	/**
	 * Removes the schedule entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scheduleId the primary key of the schedule entity
	 * @return the schedule entity that was removed
	 * @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ScheduleEntity remove(long scheduleId)
		throws NoSuchScheduleEntityException, SystemException {
		return remove(Long.valueOf(scheduleId));
	}

	/**
	 * Removes the schedule entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the schedule entity
	 * @return the schedule entity that was removed
	 * @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduleEntity remove(Serializable primaryKey)
		throws NoSuchScheduleEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScheduleEntity scheduleEntity = (ScheduleEntity)session.get(ScheduleEntityImpl.class,
					primaryKey);

			if (scheduleEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduleEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scheduleEntity);
		}
		catch (NoSuchScheduleEntityException nsee) {
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
	protected ScheduleEntity removeImpl(ScheduleEntity scheduleEntity)
		throws SystemException {
		scheduleEntity = toUnwrappedModel(scheduleEntity);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, scheduleEntity);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(scheduleEntity);

		return scheduleEntity;
	}

	@Override
	public ScheduleEntity updateImpl(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity,
		boolean merge) throws SystemException {
		scheduleEntity = toUnwrappedModel(scheduleEntity);

		boolean isNew = scheduleEntity.isNew();

		ScheduleEntityModelImpl scheduleEntityModelImpl = (ScheduleEntityModelImpl)scheduleEntity;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, scheduleEntity, merge);

			scheduleEntity.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScheduleEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scheduleEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(scheduleEntityModelImpl.getOriginalTemplateId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] {
						Long.valueOf(scheduleEntityModelImpl.getTemplateId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleEntityImpl.class, scheduleEntity.getPrimaryKey(),
			scheduleEntity);

		return scheduleEntity;
	}

	protected ScheduleEntity toUnwrappedModel(ScheduleEntity scheduleEntity) {
		if (scheduleEntity instanceof ScheduleEntityImpl) {
			return scheduleEntity;
		}

		ScheduleEntityImpl scheduleEntityImpl = new ScheduleEntityImpl();

		scheduleEntityImpl.setNew(scheduleEntity.isNew());
		scheduleEntityImpl.setPrimaryKey(scheduleEntity.getPrimaryKey());

		scheduleEntityImpl.setScheduleId(scheduleEntity.getScheduleId());
		scheduleEntityImpl.setScheduleName(scheduleEntity.getScheduleName());
		scheduleEntityImpl.setScheduleStore(scheduleEntity.getScheduleStore());
		scheduleEntityImpl.setScheduleType(scheduleEntity.getScheduleType());
		scheduleEntityImpl.setScheduleFlagValue(scheduleEntity.getScheduleFlagValue());
		scheduleEntityImpl.setScheduleOp(scheduleEntity.getScheduleOp());
		scheduleEntityImpl.setSchedulePeriod(scheduleEntity.getSchedulePeriod());
		scheduleEntityImpl.setScheduleBeforAfter(scheduleEntity.getScheduleBeforAfter());
		scheduleEntityImpl.setScheduleActive(scheduleEntity.isScheduleActive());
		scheduleEntityImpl.setTemplateId(scheduleEntity.getTemplateId());

		return scheduleEntityImpl;
	}

	/**
	 * Returns the schedule entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule entity
	 * @return the schedule entity
	 * @throws com.liferay.portal.NoSuchModelException if a schedule entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduleEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the schedule entity with the primary key or throws a {@link com.liferay.inspire.template.NoSuchScheduleEntityException} if it could not be found.
	 *
	 * @param scheduleId the primary key of the schedule entity
	 * @return the schedule entity
	 * @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a schedule entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ScheduleEntity findByPrimaryKey(long scheduleId)
		throws NoSuchScheduleEntityException, SystemException {
		ScheduleEntity scheduleEntity = fetchByPrimaryKey(scheduleId);

		if (scheduleEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + scheduleId);
			}

			throw new NoSuchScheduleEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				scheduleId);
		}

		return scheduleEntity;
	}

	/**
	 * Returns the schedule entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule entity
	 * @return the schedule entity, or <code>null</code> if a schedule entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScheduleEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the schedule entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scheduleId the primary key of the schedule entity
	 * @return the schedule entity, or <code>null</code> if a schedule entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ScheduleEntity fetchByPrimaryKey(long scheduleId)
		throws SystemException {
		ScheduleEntity scheduleEntity = (ScheduleEntity)EntityCacheUtil.getResult(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
				ScheduleEntityImpl.class, scheduleId);

		if (scheduleEntity == _nullScheduleEntity) {
			return null;
		}

		if (scheduleEntity == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				scheduleEntity = (ScheduleEntity)session.get(ScheduleEntityImpl.class,
						Long.valueOf(scheduleId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (scheduleEntity != null) {
					cacheResult(scheduleEntity);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ScheduleEntityModelImpl.ENTITY_CACHE_ENABLED,
						ScheduleEntityImpl.class, scheduleId,
						_nullScheduleEntity);
				}

				closeSession(session);
			}
		}

		return scheduleEntity;
	}

	/**
	 * Returns all the schedule entities where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the matching schedule entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<ScheduleEntity> findByTemplateId(long templateId)
		throws SystemException {
		return findByTemplateId(templateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<ScheduleEntity> findByTemplateId(long templateId, int start,
		int end) throws SystemException {
		return findByTemplateId(templateId, start, end, null);
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
	public List<ScheduleEntity> findByTemplateId(long templateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId, start, end, orderByComparator };
		}

		List<ScheduleEntity> list = (List<ScheduleEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScheduleEntity scheduleEntity : list) {
				if ((templateId != scheduleEntity.getTemplateId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_SCHEDULEENTITY_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				list = (List<ScheduleEntity>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first schedule entity in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule entity
	 * @throws com.liferay.inspire.template.NoSuchScheduleEntityException if a matching schedule entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ScheduleEntity findByTemplateId_First(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchScheduleEntityException, SystemException {
		ScheduleEntity scheduleEntity = fetchByTemplateId_First(templateId,
				orderByComparator);

		if (scheduleEntity != null) {
			return scheduleEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScheduleEntityException(msg.toString());
	}

	/**
	 * Returns the first schedule entity in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule entity, or <code>null</code> if a matching schedule entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ScheduleEntity fetchByTemplateId_First(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScheduleEntity> list = findByTemplateId(templateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ScheduleEntity findByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchScheduleEntityException, SystemException {
		ScheduleEntity scheduleEntity = fetchByTemplateId_Last(templateId,
				orderByComparator);

		if (scheduleEntity != null) {
			return scheduleEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScheduleEntityException(msg.toString());
	}

	/**
	 * Returns the last schedule entity in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule entity, or <code>null</code> if a matching schedule entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ScheduleEntity fetchByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(templateId);

		List<ScheduleEntity> list = findByTemplateId(templateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ScheduleEntity[] findByTemplateId_PrevAndNext(long scheduleId,
		long templateId, OrderByComparator orderByComparator)
		throws NoSuchScheduleEntityException, SystemException {
		ScheduleEntity scheduleEntity = findByPrimaryKey(scheduleId);

		Session session = null;

		try {
			session = openSession();

			ScheduleEntity[] array = new ScheduleEntityImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session, scheduleEntity,
					templateId, orderByComparator, true);

			array[1] = scheduleEntity;

			array[2] = getByTemplateId_PrevAndNext(session, scheduleEntity,
					templateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScheduleEntity getByTemplateId_PrevAndNext(Session session,
		ScheduleEntity scheduleEntity, long templateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCHEDULEENTITY_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scheduleEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScheduleEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the schedule entities.
	 *
	 * @return the schedule entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<ScheduleEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ScheduleEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ScheduleEntity> findAll(int start, int end,
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

		List<ScheduleEntity> list = (List<ScheduleEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCHEDULEENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULEENTITY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ScheduleEntity>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ScheduleEntity>)QueryUtil.list(q,
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
	 * Removes all the schedule entities where templateId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTemplateId(long templateId) throws SystemException {
		for (ScheduleEntity scheduleEntity : findByTemplateId(templateId)) {
			remove(scheduleEntity);
		}
	}

	/**
	 * Removes all the schedule entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ScheduleEntity scheduleEntity : findAll()) {
			remove(scheduleEntity);
		}
	}

	/**
	 * Returns the number of schedule entities where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the number of matching schedule entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTemplateId(long templateId) throws SystemException {
		Object[] finderArgs = new Object[] { templateId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCHEDULEENTITY_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of schedule entities.
	 *
	 * @return the number of schedule entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCHEDULEENTITY);

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
	 * Initializes the schedule entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.inspire.template.model.ScheduleEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScheduleEntity>> listenersList = new ArrayList<ModelListener<ScheduleEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScheduleEntity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScheduleEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = EmailTemplateEntityPersistence.class)
	protected EmailTemplateEntityPersistence emailTemplateEntityPersistence;
	@BeanReference(type = ScheduleEntityPersistence.class)
	protected ScheduleEntityPersistence scheduleEntityPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SCHEDULEENTITY = "SELECT scheduleEntity FROM ScheduleEntity scheduleEntity";
	private static final String _SQL_SELECT_SCHEDULEENTITY_WHERE = "SELECT scheduleEntity FROM ScheduleEntity scheduleEntity WHERE ";
	private static final String _SQL_COUNT_SCHEDULEENTITY = "SELECT COUNT(scheduleEntity) FROM ScheduleEntity scheduleEntity";
	private static final String _SQL_COUNT_SCHEDULEENTITY_WHERE = "SELECT COUNT(scheduleEntity) FROM ScheduleEntity scheduleEntity WHERE ";
	private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "scheduleEntity.templateId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scheduleEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScheduleEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScheduleEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScheduleEntityPersistenceImpl.class);
	private static ScheduleEntity _nullScheduleEntity = new ScheduleEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScheduleEntity> toCacheModel() {
				return _nullScheduleEntityCacheModel;
			}
		};

	private static CacheModel<ScheduleEntity> _nullScheduleEntityCacheModel = new CacheModel<ScheduleEntity>() {
			public ScheduleEntity toEntityModel() {
				return _nullScheduleEntity;
			}
		};
}