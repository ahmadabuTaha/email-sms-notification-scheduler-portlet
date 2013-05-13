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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Ahmad Taha
 * @generated
 */
public class ScheduleEntitySoap implements Serializable {
	public static ScheduleEntitySoap toSoapModel(ScheduleEntity model) {
		ScheduleEntitySoap soapModel = new ScheduleEntitySoap();

		soapModel.setScheduleId(model.getScheduleId());
		soapModel.setScheduleName(model.getScheduleName());
		soapModel.setScheduleStore(model.getScheduleStore());
		soapModel.setScheduleType(model.getScheduleType());
		soapModel.setScheduleFlagValue(model.getScheduleFlagValue());
		soapModel.setScheduleOp(model.getScheduleOp());
		soapModel.setSchedulePeriod(model.getSchedulePeriod());
		soapModel.setScheduleBeforAfter(model.getScheduleBeforAfter());
		soapModel.setScheduleActive(model.getScheduleActive());
		soapModel.setTemplateId(model.getTemplateId());

		return soapModel;
	}

	public static ScheduleEntitySoap[] toSoapModels(ScheduleEntity[] models) {
		ScheduleEntitySoap[] soapModels = new ScheduleEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScheduleEntitySoap[][] toSoapModels(ScheduleEntity[][] models) {
		ScheduleEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScheduleEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScheduleEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScheduleEntitySoap[] toSoapModels(List<ScheduleEntity> models) {
		List<ScheduleEntitySoap> soapModels = new ArrayList<ScheduleEntitySoap>(models.size());

		for (ScheduleEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScheduleEntitySoap[soapModels.size()]);
	}

	public ScheduleEntitySoap() {
	}

	public long getPrimaryKey() {
		return _scheduleId;
	}

	public void setPrimaryKey(long pk) {
		setScheduleId(pk);
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

	public long getSchedulePeriod() {
		return _schedulePeriod;
	}

	public void setSchedulePeriod(long schedulePeriod) {
		_schedulePeriod = schedulePeriod;
	}

	public long getScheduleBeforAfter() {
		return _scheduleBeforAfter;
	}

	public void setScheduleBeforAfter(long scheduleBeforAfter) {
		_scheduleBeforAfter = scheduleBeforAfter;
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

	private long _scheduleId;
	private String _scheduleName;
	private String _scheduleStore;
	private String _scheduleType;
	private String _scheduleFlagValue;
	private String _scheduleOp;
	private long _schedulePeriod;
	private long _scheduleBeforAfter;
	private boolean _scheduleActive;
	private long _templateId;
}