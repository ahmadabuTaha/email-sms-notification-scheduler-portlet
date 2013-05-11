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
public class EmailTemplateEntitySoap implements Serializable {
	public static EmailTemplateEntitySoap toSoapModel(EmailTemplateEntity model) {
		EmailTemplateEntitySoap soapModel = new EmailTemplateEntitySoap();

		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setTemplateSubject(model.getTemplateSubject());
		soapModel.setTemplateBody(model.getTemplateBody());
		soapModel.setTemplateSender(model.getTemplateSender());

		return soapModel;
	}

	public static EmailTemplateEntitySoap[] toSoapModels(
		EmailTemplateEntity[] models) {
		EmailTemplateEntitySoap[] soapModels = new EmailTemplateEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailTemplateEntitySoap[][] toSoapModels(
		EmailTemplateEntity[][] models) {
		EmailTemplateEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailTemplateEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailTemplateEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailTemplateEntitySoap[] toSoapModels(
		List<EmailTemplateEntity> models) {
		List<EmailTemplateEntitySoap> soapModels = new ArrayList<EmailTemplateEntitySoap>(models.size());

		for (EmailTemplateEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailTemplateEntitySoap[soapModels.size()]);
	}

	public EmailTemplateEntitySoap() {
	}

	public long getPrimaryKey() {
		return _templateId;
	}

	public void setPrimaryKey(long pk) {
		setTemplateId(pk);
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

	private long _templateId;
	private String _templateSubject;
	private String _templateBody;
	private String _templateSender;
}