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

import com.liferay.jira.metrics.model.JiraDataRetrieve;
import com.liferay.jira.metrics.model.JiraDataRetrieveModel;
import com.liferay.jira.metrics.model.JiraDataRetrieveSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

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
 * The base model implementation for the JiraDataRetrieve service. Represents a row in the &quot;jirametrics_JiraDataRetrieve&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.jira.metrics.model.JiraDataRetrieveModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JiraDataRetrieveImpl}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraDataRetrieveImpl
 * @see com.liferay.jira.metrics.model.JiraDataRetrieve
 * @see com.liferay.jira.metrics.model.JiraDataRetrieveModel
 * @generated
 */
@JSON(strict = true)
public class JiraDataRetrieveModelImpl extends BaseModelImpl<JiraDataRetrieve>
	implements JiraDataRetrieveModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a jira data retrieve model instance should use the {@link com.liferay.jira.metrics.model.JiraDataRetrieve} interface instead.
	 */
	public static final String TABLE_NAME = "jirametrics_JiraDataRetrieve";
	public static final Object[][] TABLE_COLUMNS = {
			{ "jiraDataRetrieveId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.VARCHAR },
			{ "statusDescription", Types.VARCHAR },
			{ "day", Types.INTEGER },
			{ "month", Types.INTEGER },
			{ "year", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table jirametrics_JiraDataRetrieve (jiraDataRetrieveId LONG not null primary key,createDate DATE null,modifiedDate DATE null,status VARCHAR(75) null,statusDescription VARCHAR(75) null,day INTEGER,month INTEGER,year INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table jirametrics_JiraDataRetrieve";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraDataRetrieve.modifiedDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY jirametrics_JiraDataRetrieve.modifiedDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.jira.metrics.model.JiraDataRetrieve"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.jira.metrics.model.JiraDataRetrieve"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.jira.metrics.model.JiraDataRetrieve"),
			true);
	public static long DAY_COLUMN_BITMASK = 1L;
	public static long MONTH_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long YEAR_COLUMN_BITMASK = 8L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JiraDataRetrieve toModel(JiraDataRetrieveSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		JiraDataRetrieve model = new JiraDataRetrieveImpl();

		model.setJiraDataRetrieveId(soapModel.getJiraDataRetrieveId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusDescription(soapModel.getStatusDescription());
		model.setDay(soapModel.getDay());
		model.setMonth(soapModel.getMonth());
		model.setYear(soapModel.getYear());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JiraDataRetrieve> toModels(
		JiraDataRetrieveSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<JiraDataRetrieve> models = new ArrayList<JiraDataRetrieve>(soapModels.length);

		for (JiraDataRetrieveSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.jira.metrics.model.JiraDataRetrieve"));

	public JiraDataRetrieveModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jiraDataRetrieveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJiraDataRetrieveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jiraDataRetrieveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JiraDataRetrieve.class;
	}

	@Override
	public String getModelClassName() {
		return JiraDataRetrieve.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jiraDataRetrieveId", getJiraDataRetrieveId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusDescription", getStatusDescription());
		attributes.put("day", getDay());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jiraDataRetrieveId = (Long)attributes.get("jiraDataRetrieveId");

		if (jiraDataRetrieveId != null) {
			setJiraDataRetrieveId(jiraDataRetrieveId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusDescription = (String)attributes.get("statusDescription");

		if (statusDescription != null) {
			setStatusDescription(statusDescription);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@JSON
	@Override
	public long getJiraDataRetrieveId() {
		return _jiraDataRetrieveId;
	}

	@Override
	public void setJiraDataRetrieveId(long jiraDataRetrieveId) {
		_jiraDataRetrieveId = jiraDataRetrieveId;
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
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	@JSON
	@Override
	public String getStatusDescription() {
		if (_statusDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusDescription;
		}
	}

	@Override
	public void setStatusDescription(String statusDescription) {
		_statusDescription = statusDescription;
	}

	@JSON
	@Override
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_columnBitmask |= DAY_COLUMN_BITMASK;

		if (!_setOriginalDay) {
			_setOriginalDay = true;

			_originalDay = _day;
		}

		_day = day;
	}

	public int getOriginalDay() {
		return _originalDay;
	}

	@JSON
	@Override
	public int getMonth() {
		return _month;
	}

	@Override
	public void setMonth(int month) {
		_columnBitmask |= MONTH_COLUMN_BITMASK;

		if (!_setOriginalMonth) {
			_setOriginalMonth = true;

			_originalMonth = _month;
		}

		_month = month;
	}

	public int getOriginalMonth() {
		return _originalMonth;
	}

	@JSON
	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_columnBitmask |= YEAR_COLUMN_BITMASK;

		if (!_setOriginalYear) {
			_setOriginalYear = true;

			_originalYear = _year;
		}

		_year = year;
	}

	public int getOriginalYear() {
		return _originalYear;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JiraDataRetrieve.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JiraDataRetrieve toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JiraDataRetrieve)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JiraDataRetrieveImpl jiraDataRetrieveImpl = new JiraDataRetrieveImpl();

		jiraDataRetrieveImpl.setJiraDataRetrieveId(getJiraDataRetrieveId());
		jiraDataRetrieveImpl.setCreateDate(getCreateDate());
		jiraDataRetrieveImpl.setModifiedDate(getModifiedDate());
		jiraDataRetrieveImpl.setStatus(getStatus());
		jiraDataRetrieveImpl.setStatusDescription(getStatusDescription());
		jiraDataRetrieveImpl.setDay(getDay());
		jiraDataRetrieveImpl.setMonth(getMonth());
		jiraDataRetrieveImpl.setYear(getYear());

		jiraDataRetrieveImpl.resetOriginalValues();

		return jiraDataRetrieveImpl;
	}

	@Override
	public int compareTo(JiraDataRetrieve jiraDataRetrieve) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				jiraDataRetrieve.getModifiedDate());

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

		if (!(obj instanceof JiraDataRetrieve)) {
			return false;
		}

		JiraDataRetrieve jiraDataRetrieve = (JiraDataRetrieve)obj;

		long primaryKey = jiraDataRetrieve.getPrimaryKey();

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
		JiraDataRetrieveModelImpl jiraDataRetrieveModelImpl = this;

		jiraDataRetrieveModelImpl._originalStatus = jiraDataRetrieveModelImpl._status;

		jiraDataRetrieveModelImpl._originalDay = jiraDataRetrieveModelImpl._day;

		jiraDataRetrieveModelImpl._setOriginalDay = false;

		jiraDataRetrieveModelImpl._originalMonth = jiraDataRetrieveModelImpl._month;

		jiraDataRetrieveModelImpl._setOriginalMonth = false;

		jiraDataRetrieveModelImpl._originalYear = jiraDataRetrieveModelImpl._year;

		jiraDataRetrieveModelImpl._setOriginalYear = false;

		jiraDataRetrieveModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JiraDataRetrieve> toCacheModel() {
		JiraDataRetrieveCacheModel jiraDataRetrieveCacheModel = new JiraDataRetrieveCacheModel();

		jiraDataRetrieveCacheModel.jiraDataRetrieveId = getJiraDataRetrieveId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			jiraDataRetrieveCacheModel.createDate = createDate.getTime();
		}
		else {
			jiraDataRetrieveCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jiraDataRetrieveCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jiraDataRetrieveCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jiraDataRetrieveCacheModel.status = getStatus();

		String status = jiraDataRetrieveCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			jiraDataRetrieveCacheModel.status = null;
		}

		jiraDataRetrieveCacheModel.statusDescription = getStatusDescription();

		String statusDescription = jiraDataRetrieveCacheModel.statusDescription;

		if ((statusDescription != null) && (statusDescription.length() == 0)) {
			jiraDataRetrieveCacheModel.statusDescription = null;
		}

		jiraDataRetrieveCacheModel.day = getDay();

		jiraDataRetrieveCacheModel.month = getMonth();

		jiraDataRetrieveCacheModel.year = getYear();

		return jiraDataRetrieveCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{jiraDataRetrieveId=");
		sb.append(getJiraDataRetrieveId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusDescription=");
		sb.append(getStatusDescription());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", month=");
		sb.append(getMonth());
		sb.append(", year=");
		sb.append(getYear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.jira.metrics.model.JiraDataRetrieve");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraDataRetrieveId</column-name><column-value><![CDATA[");
		sb.append(getJiraDataRetrieveId());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDescription</column-name><column-value><![CDATA[");
		sb.append(getStatusDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>day</column-name><column-value><![CDATA[");
		sb.append(getDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>month</column-name><column-value><![CDATA[");
		sb.append(getMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JiraDataRetrieve.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			JiraDataRetrieve.class
		};
	private long _jiraDataRetrieveId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _status;
	private String _originalStatus;
	private String _statusDescription;
	private int _day;
	private int _originalDay;
	private boolean _setOriginalDay;
	private int _month;
	private int _originalMonth;
	private boolean _setOriginalMonth;
	private int _year;
	private int _originalYear;
	private boolean _setOriginalYear;
	private long _columnBitmask;
	private JiraDataRetrieve _escapedModel;
}