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

package com.liferay.jira.metrics.model.impl;

import com.liferay.jira.metrics.model.JiraComponent;
import com.liferay.jira.metrics.model.JiraComponentModel;
import com.liferay.jira.metrics.model.JiraComponentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the JiraComponent service. Represents a row in the &quot;jirametrics_JiraComponent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.jira.metrics.model.JiraComponentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JiraComponentImpl}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraComponentImpl
 * @see com.liferay.jira.metrics.model.JiraComponent
 * @see com.liferay.jira.metrics.model.JiraComponentModel
 * @generated
 */
@JSON(strict = true)
public class JiraComponentModelImpl extends BaseModelImpl<JiraComponent>
	implements JiraComponentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a jira component model instance should use the {@link com.liferay.jira.metrics.model.JiraComponent} interface instead.
	 */
	public static final String TABLE_NAME = "jirametrics_JiraComponent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "jiraComponentId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "jiraComponentCode", Types.BIGINT },
			{ "jiraProjectId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table jirametrics_JiraComponent (jiraComponentId LONG not null primary key,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,jiraComponentCode LONG,jiraProjectId LONG,name VARCHAR(75) null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table jirametrics_JiraComponent";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraComponent.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY jirametrics_JiraComponent.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.jira.metrics.model.JiraComponent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.jira.metrics.model.JiraComponent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.jira.metrics.model.JiraComponent"),
			true);
	public static long JIRACOMPONENTCODE_COLUMN_BITMASK = 1L;
	public static long JIRAPROJECTID_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JiraComponent toModel(JiraComponentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		JiraComponent model = new JiraComponentImpl();

		model.setJiraComponentId(soapModel.getJiraComponentId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setJiraComponentCode(soapModel.getJiraComponentCode());
		model.setJiraProjectId(soapModel.getJiraProjectId());
		model.setName(soapModel.getName());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JiraComponent> toModels(JiraComponentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<JiraComponent> models = new ArrayList<JiraComponent>(soapModels.length);

		for (JiraComponentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.jira.metrics.model.JiraComponent"));

	public JiraComponentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jiraComponentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraComponentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraComponentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JiraComponent.class;
	}

	@Override
	public String getModelClassName() {
		return JiraComponent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraComponentId", getJiraComponentId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("jiraComponentCode", getJiraComponentCode());
		attributes.put("jiraProjectId", getJiraProjectId());
		attributes.put("name", getName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraComponentId = (Long)attributes.get("jiraComponentId");

		if (jiraComponentId != null) {
			setJiraComponentId(jiraComponentId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long jiraComponentCode = (Long)attributes.get("jiraComponentCode");

		if (jiraComponentCode != null) {
			setJiraComponentCode(jiraComponentCode);
		}

		Long jiraProjectId = (Long)attributes.get("jiraProjectId");

		if (jiraProjectId != null) {
			setJiraProjectId(jiraProjectId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getJiraComponentId() {
		return _jiraComponentId;
	}

	@Override
	public void setJiraComponentId(long jiraComponentId) {
		_jiraComponentId = jiraComponentId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getJiraComponentCode() {
		return _jiraComponentCode;
	}

	@Override
	public void setJiraComponentCode(long jiraComponentCode) {
		_columnBitmask |= JIRACOMPONENTCODE_COLUMN_BITMASK;

		if (!_setOriginalJiraComponentCode) {
			_setOriginalJiraComponentCode = true;

			_originalJiraComponentCode = _jiraComponentCode;
		}

		_jiraComponentCode = jiraComponentCode;
	}

	public long getOriginalJiraComponentCode() {
		return _originalJiraComponentCode;
	}

	@JSON
	@Override
	public long getJiraProjectId() {
		return _jiraProjectId;
	}

	@Override
	public void setJiraProjectId(long jiraProjectId) {
		_columnBitmask |= JIRAPROJECTID_COLUMN_BITMASK;

		if (!_setOriginalJiraProjectId) {
			_setOriginalJiraProjectId = true;

			_originalJiraProjectId = _jiraProjectId;
		}

		_jiraProjectId = jiraProjectId;
	}

	public long getOriginalJiraProjectId() {
		return _originalJiraProjectId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JiraComponent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JiraComponent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JiraComponent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JiraComponentImpl jiraComponentImpl = new JiraComponentImpl();

		jiraComponentImpl.setJiraComponentId(getJiraComponentId());
		jiraComponentImpl.setUserId(getUserId());
		jiraComponentImpl.setUserName(getUserName());
		jiraComponentImpl.setCreateDate(getCreateDate());
		jiraComponentImpl.setModifiedDate(getModifiedDate());
		jiraComponentImpl.setJiraComponentCode(getJiraComponentCode());
		jiraComponentImpl.setJiraProjectId(getJiraProjectId());
		jiraComponentImpl.setName(getName());
		jiraComponentImpl.setStatus(getStatus());

		jiraComponentImpl.resetOriginalValues();

		return jiraComponentImpl;
	}

	@Override
	public int compareTo(JiraComponent jiraComponent) {
		int value = 0;

		value = getName().compareTo(jiraComponent.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JiraComponent)) {
			return false;
		}

		JiraComponent jiraComponent = (JiraComponent)obj;

		long primaryKey = jiraComponent.getPrimaryKey();

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
	public void resetOriginalValues() {
		JiraComponentModelImpl jiraComponentModelImpl = this;

		jiraComponentModelImpl._originalJiraComponentCode = jiraComponentModelImpl._jiraComponentCode;

		jiraComponentModelImpl._setOriginalJiraComponentCode = false;

		jiraComponentModelImpl._originalJiraProjectId = jiraComponentModelImpl._jiraProjectId;

		jiraComponentModelImpl._setOriginalJiraProjectId = false;

		jiraComponentModelImpl._originalName = jiraComponentModelImpl._name;

		jiraComponentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JiraComponent> toCacheModel() {
		JiraComponentCacheModel jiraComponentCacheModel = new JiraComponentCacheModel();

		jiraComponentCacheModel.jiraComponentId = getJiraComponentId();

		jiraComponentCacheModel.userId = getUserId();

		jiraComponentCacheModel.userName = getUserName();

		String userName = jiraComponentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			jiraComponentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			jiraComponentCacheModel.createDate = createDate.getTime();
		}
		else {
			jiraComponentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jiraComponentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jiraComponentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jiraComponentCacheModel.jiraComponentCode = getJiraComponentCode();

		jiraComponentCacheModel.jiraProjectId = getJiraProjectId();

		jiraComponentCacheModel.name = getName();

		String name = jiraComponentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			jiraComponentCacheModel.name = null;
		}

		jiraComponentCacheModel.status = getStatus();

		return jiraComponentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{jiraComponentId=");
		sb.append(getJiraComponentId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", jiraComponentCode=");
		sb.append(getJiraComponentCode());
		sb.append(", jiraProjectId=");
		sb.append(getJiraProjectId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraComponent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraComponentId</column-name><column-value><![CDATA[");
		sb.append(getJiraComponentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraComponentCode</column-name><column-value><![CDATA[");
		sb.append(getJiraComponentCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraProjectId</column-name><column-value><![CDATA[");
		sb.append(getJiraProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JiraComponent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			JiraComponent.class
		};
	private long _jiraComponentId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _jiraComponentCode;
	private long _originalJiraComponentCode;
	private boolean _setOriginalJiraComponentCode;
	private long _jiraProjectId;
	private long _originalJiraProjectId;
	private boolean _setOriginalJiraProjectId;
	private String _name;
	private String _originalName;
	private int _status;
	private long _columnBitmask;
	private JiraComponent _escapedModel;
}