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

import com.liferay.inspire.template.service.EmailTemplateEntityLocalServiceUtil;

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
public class EmailTemplateEntityClp extends BaseModelImpl<EmailTemplateEntity>
	implements EmailTemplateEntity {
	public EmailTemplateEntityClp() {
	}

	public Class<?> getModelClass() {
		return EmailTemplateEntity.class;
	}

	public String getModelClassName() {
		return EmailTemplateEntity.class.getName();
	}

	public long getPrimaryKey() {
		return _templateId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTemplateId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_templateId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("templateSubject", getTemplateSubject());
		attributes.put("templateBody", getTemplateBody());
		attributes.put("templateSender", getTemplateSender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String templateSubject = (String)attributes.get("templateSubject");

		if (templateSubject != null) {
			setTemplateSubject(templateSubject);
		}

		String templateBody = (String)attributes.get("templateBody");

		if (templateBody != null) {
			setTemplateBody(templateBody);
		}

		String templateSender = (String)attributes.get("templateSender");

		if (templateSender != null) {
			setTemplateSender(templateSender);
		}
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public String getTemplateSubject() {
		return _templateSubject;
	}

	public void setTemplateSubject(String templateSubject) {
		_templateSubject = templateSubject;
	}

	public String getTemplateBody() {
		return _templateBody;
	}

	public void setTemplateBody(String templateBody) {
		_templateBody = templateBody;
	}

	public String getTemplateSender() {
		return _templateSender;
	}

	public void setTemplateSender(String templateSender) {
		_templateSender = templateSender;
	}

	public BaseModel<?> getEmailTemplateEntityRemoteModel() {
		return _emailTemplateEntityRemoteModel;
	}

	public void setEmailTemplateEntityRemoteModel(
		BaseModel<?> emailTemplateEntityRemoteModel) {
		_emailTemplateEntityRemoteModel = emailTemplateEntityRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EmailTemplateEntityLocalServiceUtil.addEmailTemplateEntity(this);
		}
		else {
			EmailTemplateEntityLocalServiceUtil.updateEmailTemplateEntity(this);
		}
	}

	@Override
	public EmailTemplateEntity toEscapedModel() {
		return (EmailTemplateEntity)Proxy.newProxyInstance(EmailTemplateEntity.class.getClassLoader(),
			new Class[] { EmailTemplateEntity.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmailTemplateEntityClp clone = new EmailTemplateEntityClp();

		clone.setTemplateId(getTemplateId());
		clone.setTemplateSubject(getTemplateSubject());
		clone.setTemplateBody(getTemplateBody());
		clone.setTemplateSender(getTemplateSender());

		return clone;
	}

	public int compareTo(EmailTemplateEntity emailTemplateEntity) {
		int value = 0;

		if (getTemplateId() < emailTemplateEntity.getTemplateId()) {
			value = -1;
		}
		else if (getTemplateId() > emailTemplateEntity.getTemplateId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EmailTemplateEntityClp emailTemplateEntity = null;

		try {
			emailTemplateEntity = (EmailTemplateEntityClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = emailTemplateEntity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{templateId=");
		sb.append(getTemplateId());
		sb.append(", templateSubject=");
		sb.append(getTemplateSubject());
		sb.append(", templateBody=");
		sb.append(getTemplateBody());
		sb.append(", templateSender=");
		sb.append(getTemplateSender());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.inspire.template.model.EmailTemplateEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateSubject</column-name><column-value><![CDATA[");
		sb.append(getTemplateSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateBody</column-name><column-value><![CDATA[");
		sb.append(getTemplateBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateSender</column-name><column-value><![CDATA[");
		sb.append(getTemplateSender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _templateId;
	private String _templateSubject;
	private String _templateBody;
	private String _templateSender;
	private BaseModel<?> _emailTemplateEntityRemoteModel;
}