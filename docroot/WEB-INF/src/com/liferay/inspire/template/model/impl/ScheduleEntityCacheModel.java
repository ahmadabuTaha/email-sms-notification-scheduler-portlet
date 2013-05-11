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

package com.liferay.inspire.template.model.impl;

import com.liferay.inspire.template.model.ScheduleEntity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing ScheduleEntity in entity cache.
 *
 * @author Ahmad Taha
 * @see ScheduleEntity
 * @generated
 */
public class ScheduleEntityCacheModel implements CacheModel<ScheduleEntity>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{scheduleId=");
		sb.append(scheduleId);
		sb.append(", scheduleName=");
		sb.append(scheduleName);
		sb.append(", scheduleStore=");
		sb.append(scheduleStore);
		sb.append(", scheduleType=");
		sb.append(scheduleType);
		sb.append(", scheduleFlagValue=");
		sb.append(scheduleFlagValue);
		sb.append(", scheduleOp=");
		sb.append(scheduleOp);
		sb.append(", scheduleActive=");
		sb.append(scheduleActive);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append("}");

		return sb.toString();
	}

	public ScheduleEntity toEntityModel() {
		ScheduleEntityImpl scheduleEntityImpl = new ScheduleEntityImpl();

		scheduleEntityImpl.setScheduleId(scheduleId);

		if (scheduleName == null) {
			scheduleEntityImpl.setScheduleName(StringPool.BLANK);
		}
		else {
			scheduleEntityImpl.setScheduleName(scheduleName);
		}

		if (scheduleStore == null) {
			scheduleEntityImpl.setScheduleStore(StringPool.BLANK);
		}
		else {
			scheduleEntityImpl.setScheduleStore(scheduleStore);
		}

		if (scheduleType == null) {
			scheduleEntityImpl.setScheduleType(StringPool.BLANK);
		}
		else {
			scheduleEntityImpl.setScheduleType(scheduleType);
		}

		if (scheduleFlagValue == null) {
			scheduleEntityImpl.setScheduleFlagValue(StringPool.BLANK);
		}
		else {
			scheduleEntityImpl.setScheduleFlagValue(scheduleFlagValue);
		}

		if (scheduleOp == null) {
			scheduleEntityImpl.setScheduleOp(StringPool.BLANK);
		}
		else {
			scheduleEntityImpl.setScheduleOp(scheduleOp);
		}

		scheduleEntityImpl.setScheduleActive(scheduleActive);
		scheduleEntityImpl.setTemplateId(templateId);

		scheduleEntityImpl.resetOriginalValues();

		return scheduleEntityImpl;
	}

	public long scheduleId;
	public String scheduleName;
	public String scheduleStore;
	public String scheduleType;
	public String scheduleFlagValue;
	public String scheduleOp;
	public boolean scheduleActive;
	public long templateId;
}