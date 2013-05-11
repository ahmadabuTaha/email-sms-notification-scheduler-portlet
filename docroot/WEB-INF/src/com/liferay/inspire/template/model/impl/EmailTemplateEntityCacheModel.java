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

import com.liferay.inspire.template.model.EmailTemplateEntity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing EmailTemplateEntity in entity cache.
 *
 * @author Ahmad Taha
 * @see EmailTemplateEntity
 * @generated
 */
public class EmailTemplateEntityCacheModel implements CacheModel<EmailTemplateEntity>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{templateId=");
		sb.append(templateId);
		sb.append(", templateSubject=");
		sb.append(templateSubject);
		sb.append(", templateBody=");
		sb.append(templateBody);
		sb.append(", templateSender=");
		sb.append(templateSender);
		sb.append("}");

		return sb.toString();
	}

	public EmailTemplateEntity toEntityModel() {
		EmailTemplateEntityImpl emailTemplateEntityImpl = new EmailTemplateEntityImpl();

		emailTemplateEntityImpl.setTemplateId(templateId);

		if (templateSubject == null) {
			emailTemplateEntityImpl.setTemplateSubject(StringPool.BLANK);
		}
		else {
			emailTemplateEntityImpl.setTemplateSubject(templateSubject);
		}

		if (templateBody == null) {
			emailTemplateEntityImpl.setTemplateBody(StringPool.BLANK);
		}
		else {
			emailTemplateEntityImpl.setTemplateBody(templateBody);
		}

		if (templateSender == null) {
			emailTemplateEntityImpl.setTemplateSender(StringPool.BLANK);
		}
		else {
			emailTemplateEntityImpl.setTemplateSender(templateSender);
		}

		emailTemplateEntityImpl.resetOriginalValues();

		return emailTemplateEntityImpl;
	}

	public long templateId;
	public String templateSubject;
	public String templateBody;
	public String templateSender;
}