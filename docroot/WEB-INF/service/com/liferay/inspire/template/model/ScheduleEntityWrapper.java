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

package com.liferay.inspire.template.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScheduleEntity}.
 * </p>
 *
 * @author    Ahmad Taha
 * @see       ScheduleEntity
 * @generated
 */
public class ScheduleEntityWrapper implements ScheduleEntity,
	ModelWrapper<ScheduleEntity> {
	public ScheduleEntityWrapper(ScheduleEntity scheduleEntity) {
		_scheduleEntity = scheduleEntity;
	}

	public Class<?> getModelClass() {
		return ScheduleEntity.class;
	}

	public String getModelClassName() {
		return ScheduleEntity.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduleId", getScheduleId());
		attributes.put("scheduleName", getScheduleName());
		attributes.put("scheduleStore", getScheduleStore());
		attributes.put("scheduleType", getScheduleType());
		attributes.put("scheduleFlagValue", getScheduleFlagValue());
		attributes.put("scheduleOp", getScheduleOp());
		attributes.put("schedulePeriod", getSchedulePeriod());
		attributes.put("scheduleBeforAfter", getScheduleBeforAfter());
		attributes.put("scheduleActive", getScheduleActive());
		attributes.put("templateId", getTemplateId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long scheduleId = (Long)attributes.get("scheduleId");

		if (scheduleId != null) {
			setScheduleId(scheduleId);
		}

		String scheduleName = (String)attributes.get("scheduleName");

		if (scheduleName != null) {
			setScheduleName(scheduleName);
		}

		String scheduleStore = (String)attributes.get("scheduleStore");

		if (scheduleStore != null) {
			setScheduleStore(scheduleStore);
		}

		String scheduleType = (String)attributes.get("scheduleType");

		if (scheduleType != null) {
			setScheduleType(scheduleType);
		}

		String scheduleFlagValue = (String)attributes.get("scheduleFlagValue");

		if (scheduleFlagValue != null) {
			setScheduleFlagValue(scheduleFlagValue);
		}

		String scheduleOp = (String)attributes.get("scheduleOp");

		if (scheduleOp != null) {
			setScheduleOp(scheduleOp);
		}

		Long schedulePeriod = (Long)attributes.get("schedulePeriod");

		if (schedulePeriod != null) {
			setSchedulePeriod(schedulePeriod);
		}

		Long scheduleBeforAfter = (Long)attributes.get("scheduleBeforAfter");

		if (scheduleBeforAfter != null) {
			setScheduleBeforAfter(scheduleBeforAfter);
		}

		Boolean scheduleActive = (Boolean)attributes.get("scheduleActive");

		if (scheduleActive != null) {
			setScheduleActive(scheduleActive);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}
	}

	/**
	* Returns the primary key of this schedule entity.
	*
	* @return the primary key of this schedule entity
	*/
	public long getPrimaryKey() {
		return _scheduleEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this schedule entity.
	*
	* @param primaryKey the primary key of this schedule entity
	*/
	public void setPrimaryKey(long primaryKey) {
		_scheduleEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the schedule ID of this schedule entity.
	*
	* @return the schedule ID of this schedule entity
	*/
	public long getScheduleId() {
		return _scheduleEntity.getScheduleId();
	}

	/**
	* Sets the schedule ID of this schedule entity.
	*
	* @param scheduleId the schedule ID of this schedule entity
	*/
	public void setScheduleId(long scheduleId) {
		_scheduleEntity.setScheduleId(scheduleId);
	}

	/**
	* Returns the schedule name of this schedule entity.
	*
	* @return the schedule name of this schedule entity
	*/
	public java.lang.String getScheduleName() {
		return _scheduleEntity.getScheduleName();
	}

	/**
	* Sets the schedule name of this schedule entity.
	*
	* @param scheduleName the schedule name of this schedule entity
	*/
	public void setScheduleName(java.lang.String scheduleName) {
		_scheduleEntity.setScheduleName(scheduleName);
	}

	/**
	* Returns the schedule store of this schedule entity.
	*
	* @return the schedule store of this schedule entity
	*/
	public java.lang.String getScheduleStore() {
		return _scheduleEntity.getScheduleStore();
	}

	/**
	* Sets the schedule store of this schedule entity.
	*
	* @param scheduleStore the schedule store of this schedule entity
	*/
	public void setScheduleStore(java.lang.String scheduleStore) {
		_scheduleEntity.setScheduleStore(scheduleStore);
	}

	/**
	* Returns the schedule type of this schedule entity.
	*
	* @return the schedule type of this schedule entity
	*/
	public java.lang.String getScheduleType() {
		return _scheduleEntity.getScheduleType();
	}

	/**
	* Sets the schedule type of this schedule entity.
	*
	* @param scheduleType the schedule type of this schedule entity
	*/
	public void setScheduleType(java.lang.String scheduleType) {
		_scheduleEntity.setScheduleType(scheduleType);
	}

	/**
	* Returns the schedule flag value of this schedule entity.
	*
	* @return the schedule flag value of this schedule entity
	*/
	public java.lang.String getScheduleFlagValue() {
		return _scheduleEntity.getScheduleFlagValue();
	}

	/**
	* Sets the schedule flag value of this schedule entity.
	*
	* @param scheduleFlagValue the schedule flag value of this schedule entity
	*/
	public void setScheduleFlagValue(java.lang.String scheduleFlagValue) {
		_scheduleEntity.setScheduleFlagValue(scheduleFlagValue);
	}

	/**
	* Returns the schedule op of this schedule entity.
	*
	* @return the schedule op of this schedule entity
	*/
	public java.lang.String getScheduleOp() {
		return _scheduleEntity.getScheduleOp();
	}

	/**
	* Sets the schedule op of this schedule entity.
	*
	* @param scheduleOp the schedule op of this schedule entity
	*/
	public void setScheduleOp(java.lang.String scheduleOp) {
		_scheduleEntity.setScheduleOp(scheduleOp);
	}

	/**
	* Returns the schedule period of this schedule entity.
	*
	* @return the schedule period of this schedule entity
	*/
	public long getSchedulePeriod() {
		return _scheduleEntity.getSchedulePeriod();
	}

	/**
	* Sets the schedule period of this schedule entity.
	*
	* @param schedulePeriod the schedule period of this schedule entity
	*/
	public void setSchedulePeriod(long schedulePeriod) {
		_scheduleEntity.setSchedulePeriod(schedulePeriod);
	}

	/**
	* Returns the schedule befor after of this schedule entity.
	*
	* @return the schedule befor after of this schedule entity
	*/
	public long getScheduleBeforAfter() {
		return _scheduleEntity.getScheduleBeforAfter();
	}

	/**
	* Sets the schedule befor after of this schedule entity.
	*
	* @param scheduleBeforAfter the schedule befor after of this schedule entity
	*/
	public void setScheduleBeforAfter(long scheduleBeforAfter) {
		_scheduleEntity.setScheduleBeforAfter(scheduleBeforAfter);
	}

	/**
	* Returns the schedule active of this schedule entity.
	*
	* @return the schedule active of this schedule entity
	*/
	public boolean getScheduleActive() {
		return _scheduleEntity.getScheduleActive();
	}

	/**
	* Returns <code>true</code> if this schedule entity is schedule active.
	*
	* @return <code>true</code> if this schedule entity is schedule active; <code>false</code> otherwise
	*/
	public boolean isScheduleActive() {
		return _scheduleEntity.isScheduleActive();
	}

	/**
	* Sets whether this schedule entity is schedule active.
	*
	* @param scheduleActive the schedule active of this schedule entity
	*/
	public void setScheduleActive(boolean scheduleActive) {
		_scheduleEntity.setScheduleActive(scheduleActive);
	}

	/**
	* Returns the template ID of this schedule entity.
	*
	* @return the template ID of this schedule entity
	*/
	public long getTemplateId() {
		return _scheduleEntity.getTemplateId();
	}

	/**
	* Sets the template ID of this schedule entity.
	*
	* @param templateId the template ID of this schedule entity
	*/
	public void setTemplateId(long templateId) {
		_scheduleEntity.setTemplateId(templateId);
	}

	public boolean isNew() {
		return _scheduleEntity.isNew();
	}

	public void setNew(boolean n) {
		_scheduleEntity.setNew(n);
	}

	public boolean isCachedModel() {
		return _scheduleEntity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_scheduleEntity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _scheduleEntity.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _scheduleEntity.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scheduleEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scheduleEntity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scheduleEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScheduleEntityWrapper((ScheduleEntity)_scheduleEntity.clone());
	}

	public int compareTo(
		com.liferay.inspire.template.model.ScheduleEntity scheduleEntity) {
		return _scheduleEntity.compareTo(scheduleEntity);
	}

	@Override
	public int hashCode() {
		return _scheduleEntity.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.inspire.template.model.ScheduleEntity> toCacheModel() {
		return _scheduleEntity.toCacheModel();
	}

	public com.liferay.inspire.template.model.ScheduleEntity toEscapedModel() {
		return new ScheduleEntityWrapper(_scheduleEntity.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scheduleEntity.toString();
	}

	public java.lang.String toXmlString() {
		return _scheduleEntity.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scheduleEntity.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ScheduleEntity getWrappedScheduleEntity() {
		return _scheduleEntity;
	}

	public ScheduleEntity getWrappedModel() {
		return _scheduleEntity;
	}

	public void resetOriginalValues() {
		_scheduleEntity.resetOriginalValues();
	}

	private ScheduleEntity _scheduleEntity;
}