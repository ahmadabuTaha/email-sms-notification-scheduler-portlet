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

import com.liferay.inspire.template.service.ScheduleEntityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ahmad Taha
 */
public class ScheduleEntityClp extends BaseModelImpl<ScheduleEntity>
	implements ScheduleEntity {
	public ScheduleEntityClp() {
	}

	public Class<?> getModelClass() {
		return ScheduleEntity.class;
	}

	public String getModelClassName() {
		return ScheduleEntity.class.getName();
	}

	public long getPrimaryKey() {
		return _scheduleId;
	}

	public void setPrimaryKey(long primaryKey) {
		setScheduleId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_scheduleId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scheduleId", getScheduleId());
		attributes.put("scheduleName", getScheduleName());
		attributes.put("scheduleStore", getScheduleStore());
		attributes.put("scheduleType", getScheduleType());
		attributes.put("scheduleFlagValue", getScheduleFlagValue());
		attributes.put("scheduleOp", getScheduleOp());
		attributes.put("scheduleActive", getScheduleActive());
		attributes.put("templateId", getTemplateId());

		return attributes;
	}

	@Override
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

		Boolean scheduleActive = (Boolean)attributes.get("scheduleActive");

		if (scheduleActive != null) {
			setScheduleActive(scheduleActive);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}
	}

	public long getScheduleId() {
		return _scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		_scheduleId = scheduleId;
	}

	public String getScheduleName() {
		return _scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		_scheduleName = scheduleName;
	}

	public String getScheduleStore() {
		return _scheduleStore;
	}

	public void setScheduleStore(String scheduleStore) {
		_scheduleStore = scheduleStore;
	}

	public String getScheduleType() {
		return _scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		_scheduleType = scheduleType;
	}

	public String getScheduleFlagValue() {
		return _scheduleFlagValue;
	}

	public void setScheduleFlagValue(String scheduleFlagValue) {
		_scheduleFlagValue = scheduleFlagValue;
	}

	public String getScheduleOp() {
		return _scheduleOp;
	}

	public void setScheduleOp(String scheduleOp) {
		_scheduleOp = scheduleOp;
	}

	public boolean getScheduleActive() {
		return _scheduleActive;
	}

	public boolean isScheduleActive() {
		return _scheduleActive;
	}

	public void setScheduleActive(boolean scheduleActive) {
		_scheduleActive = scheduleActive;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public BaseModel<?> getScheduleEntityRemoteModel() {
		return _scheduleEntityRemoteModel;
	}

	public void setScheduleEntityRemoteModel(
		BaseModel<?> scheduleEntityRemoteModel) {
		_scheduleEntityRemoteModel = scheduleEntityRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ScheduleEntityLocalServiceUtil.addScheduleEntity(this);
		}
		else {
			ScheduleEntityLocalServiceUtil.updateScheduleEntity(this);
		}
	}

	@Override
	public ScheduleEntity toEscapedModel() {
		return (ScheduleEntity)Proxy.newProxyInstance(ScheduleEntity.class.getClassLoader(),
			new Class[] { ScheduleEntity.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScheduleEntityClp clone = new ScheduleEntityClp();

		clone.setScheduleId(getScheduleId());
		clone.setScheduleName(getScheduleName());
		clone.setScheduleStore(getScheduleStore());
		clone.setScheduleType(getScheduleType());
		clone.setScheduleFlagValue(getScheduleFlagValue());
		clone.setScheduleOp(getScheduleOp());
		clone.setScheduleActive(getScheduleActive());
		clone.setTemplateId(getTemplateId());

		return clone;
	}

	public int compareTo(ScheduleEntity scheduleEntity) {
		long primaryKey = scheduleEntity.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ScheduleEntityClp scheduleEntity = null;

		try {
			scheduleEntity = (ScheduleEntityClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = scheduleEntity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{scheduleId=");
		sb.append(getScheduleId());
		sb.append(", scheduleName=");
		sb.append(getScheduleName());
		sb.append(", scheduleStore=");
		sb.append(getScheduleStore());
		sb.append(", scheduleType=");
		sb.append(getScheduleType());
		sb.append(", scheduleFlagValue=");
		sb.append(getScheduleFlagValue());
		sb.append(", scheduleOp=");
		sb.append(getScheduleOp());
		sb.append(", scheduleActive=");
		sb.append(getScheduleActive());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.inspire.template.model.ScheduleEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scheduleId</column-name><column-value><![CDATA[");
		sb.append(getScheduleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleName</column-name><column-value><![CDATA[");
		sb.append(getScheduleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleStore</column-name><column-value><![CDATA[");
		sb.append(getScheduleStore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleType</column-name><column-value><![CDATA[");
		sb.append(getScheduleType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleFlagValue</column-name><column-value><![CDATA[");
		sb.append(getScheduleFlagValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleOp</column-name><column-value><![CDATA[");
		sb.append(getScheduleOp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleActive</column-name><column-value><![CDATA[");
		sb.append(getScheduleActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scheduleId;
	private String _scheduleName;
	private String _scheduleStore;
	private String _scheduleType;
	private String _scheduleFlagValue;
	private String _scheduleOp;
	private boolean _scheduleActive;
	private long _templateId;
	private BaseModel<?> _scheduleEntityRemoteModel;
}