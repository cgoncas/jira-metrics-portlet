/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.jira.metrics.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the JiraProject service. Represents a row in the &quot;jirametrics_JiraProject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.jira.metrics.model.impl.JiraProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.jira.metrics.model.impl.JiraProjectImpl}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraProject
 * @see com.liferay.jira.metrics.model.impl.JiraProjectImpl
 * @see com.liferay.jira.metrics.model.impl.JiraProjectModelImpl
 * @generated
 */
public interface JiraProjectModel extends BaseModel<JiraProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a jira project model instance should use the {@link JiraProject} interface instead.
	 */

	/**
	 * Returns the primary key of this jira project.
	 *
	 * @return the primary key of this jira project
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this jira project.
	 *
	 * @param primaryKey the primary key of this jira project
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the jira project ID of this jira project.
	 *
	 * @return the jira project ID of this jira project
	 */
	public long getJiraProjectId();

	/**
	 * Sets the jira project ID of this jira project.
	 *
	 * @param jiraProjectId the jira project ID of this jira project
	 */
	public void setJiraProjectId(long jiraProjectId);

	/**
	 * Returns the user ID of this jira project.
	 *
	 * @return the user ID of this jira project
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this jira project.
	 *
	 * @param userId the user ID of this jira project
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this jira project.
	 *
	 * @return the user uuid of this jira project
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this jira project.
	 *
	 * @param userUuid the user uuid of this jira project
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this jira project.
	 *
	 * @return the user name of this jira project
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this jira project.
	 *
	 * @param userName the user name of this jira project
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this jira project.
	 *
	 * @return the create date of this jira project
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this jira project.
	 *
	 * @param createDate the create date of this jira project
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this jira project.
	 *
	 * @return the modified date of this jira project
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this jira project.
	 *
	 * @param modifiedDate the modified date of this jira project
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this jira project.
	 *
	 * @return the name of this jira project
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this jira project.
	 *
	 * @param name the name of this jira project
	 */
	public void setName(String name);

	/**
	 * Returns the label of this jira project.
	 *
	 * @return the label of this jira project
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this jira project.
	 *
	 * @param label the label of this jira project
	 */
	public void setLabel(String label);

	/**
	 * Returns the jira project code of this jira project.
	 *
	 * @return the jira project code of this jira project
	 */
	public long getJiraProjectCode();

	/**
	 * Sets the jira project code of this jira project.
	 *
	 * @param jiraProjectCode the jira project code of this jira project
	 */
	public void setJiraProjectCode(long jiraProjectCode);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(JiraProject jiraProject);

	@Override
	public int hashCode();

	@Override
	public CacheModel<JiraProject> toCacheModel();

	@Override
	public JiraProject toEscapedModel();

	@Override
	public JiraProject toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}