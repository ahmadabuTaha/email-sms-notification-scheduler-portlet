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
 * This class is a wrapper for {@link EmailTemplateEntity}.
 * </p>
 *
 * @author    Ahmad Taha
 * @see       EmailTemplateEntity
 * @generated
 */
public class EmailTemplateEntityWrapper implements EmailTemplateEntity,
	ModelWrapper<EmailTemplateEntity> {
	public EmailTemplateEntityWrapper(EmailTemplateEntity emailTemplateEntity) {
		_emailTemplateEntity = emailTemplateEntity;
	}

	public Class<?> getModelClass() {
		return EmailTemplateEntity.class;
	}

	public String getModelClassName() {
		return EmailTemplateEntity.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("templateSubject", getTemplateSubject());
		attributes.put("templateBody", getTemplateBody());
		attributes.put("templateSender", getTemplateSender());

		return attributes;
	}

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

	/**
	* Returns the primary key of this email template entity.
	*
	* @return the primary key of this email template entity
	*/
	public long getPrimaryKey() {
		return _emailTemplateEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this email template entity.
	*
	* @param primaryKey the primary key of this email template entity
	*/
	public void setPrimaryKey(long primaryKey) {
		_emailTemplateEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the template ID of this email template entity.
	*
	* @return the template ID of this email template entity
	*/
	public long getTemplateId() {
		return _emailTemplateEntity.getTemplateId();
	}

	/**
	* Sets the template ID of this email template entity.
	*
	* @param templateId the template ID of this email template entity
	*/
	public void setTemplateId(long templateId) {
		_emailTemplateEntity.setTemplateId(templateId);
	}

	/**
	* Returns the template subject of this email template entity.
	*
	* @return the template subject of this email template entity
	*/
	public java.lang.String getTemplateSubject() {
		return _emailTemplateEntity.getTemplateSubject();
	}

	/**
	* Sets the template subject of this email template entity.
	*
	* @param templateSubject the template subject of this email template entity
	*/
	public void setTemplateSubject(java.lang.String templateSubject) {
		_emailTemplateEntity.setTemplateSubject(templateSubject);
	}

	/**
	* Returns the template body of this email template entity.
	*
	* @return the template body of this email template entity
	*/
	public java.lang.String getTemplateBody() {
		return _emailTemplateEntity.getTemplateBody();
	}

	/**
	* Sets the template body of this email template entity.
	*
	* @param templateBody the template body of this email template entity
	*/
	public void setTemplateBody(java.lang.String templateBody) {
		_emailTemplateEntity.setTemplateBody(templateBody);
	}

	/**
	* Returns the template sender of this email template entity.
	*
	* @return the template sender of this email template entity
	*/
	public java.lang.String getTemplateSender() {
		return _emailTemplateEntity.getTemplateSender();
	}

	/**
	* Sets the template sender of this email template entity.
	*
	* @param templateSender the template sender of this email template entity
	*/
	public void setTemplateSender(java.lang.String templateSender) {
		_emailTemplateEntity.setTemplateSender(templateSender);
	}

	public boolean isNew() {
		return _emailTemplateEntity.isNew();
	}

	public void setNew(boolean n) {
		_emailTemplateEntity.setNew(n);
	}

	public boolean isCachedModel() {
		return _emailTemplateEntity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_emailTemplateEntity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _emailTemplateEntity.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _emailTemplateEntity.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_emailTemplateEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _emailTemplateEntity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_emailTemplateEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmailTemplateEntityWrapper((EmailTemplateEntity)_emailTemplateEntity.clone());
	}

	public int compareTo(
		com.liferay.inspire.template.model.EmailTemplateEntity emailTemplateEntity) {
		return _emailTemplateEntity.compareTo(emailTemplateEntity);
	}

	@Override
	public int hashCode() {
		return _emailTemplateEntity.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.inspire.template.model.EmailTemplateEntity> toCacheModel() {
		return _emailTemplateEntity.toCacheModel();
	}

	public com.liferay.inspire.template.model.EmailTemplateEntity toEscapedModel() {
		return new EmailTemplateEntityWrapper(_emailTemplateEntity.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _emailTemplateEntity.toString();
	}

	public java.lang.String toXmlString() {
		return _emailTemplateEntity.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_emailTemplateEntity.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EmailTemplateEntity getWrappedEmailTemplateEntity() {
		return _emailTemplateEntity;
	}

	public EmailTemplateEntity getWrappedModel() {
		return _emailTemplateEntity;
	}

	public void resetOriginalValues() {
		_emailTemplateEntity.resetOriginalValues();
	}

	private EmailTemplateEntity _emailTemplateEntity;
}