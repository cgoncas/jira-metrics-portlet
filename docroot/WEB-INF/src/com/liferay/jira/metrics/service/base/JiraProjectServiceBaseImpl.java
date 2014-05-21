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

package com.liferay.jira.metrics.service.base;

import com.liferay.jira.metrics.model.JiraProject;
import com.liferay.jira.metrics.service.JiraProjectService;
import com.liferay.jira.metrics.service.persistence.JiraComponentPersistence;
import com.liferay.jira.metrics.service.persistence.JiraDataRetrievePersistence;
import com.liferay.jira.metrics.service.persistence.JiraMetricPersistence;
import com.liferay.jira.metrics.service.persistence.JiraPriorityPersistence;
import com.liferay.jira.metrics.service.persistence.JiraProjectPersistence;
import com.liferay.jira.metrics.service.persistence.JiraStatusPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the jira project remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.jira.metrics.service.impl.JiraProjectServiceImpl}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see com.liferay.jira.metrics.service.impl.JiraProjectServiceImpl
 * @see com.liferay.jira.metrics.service.JiraProjectServiceUtil
 * @generated
 */
public abstract class JiraProjectServiceBaseImpl extends BaseServiceImpl
	implements JiraProjectService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.jira.metrics.service.JiraProjectServiceUtil} to access the jira project remote service.
	 */

	/**
	 * Returns the jira component local service.
	 *
	 * @return the jira component local service
	 */
	public com.liferay.jira.metrics.service.JiraComponentLocalService getJiraComponentLocalService() {
		return jiraComponentLocalService;
	}

	/**
	 * Sets the jira component local service.
	 *
	 * @param jiraComponentLocalService the jira component local service
	 */
	public void setJiraComponentLocalService(
		com.liferay.jira.metrics.service.JiraComponentLocalService jiraComponentLocalService) {
		this.jiraComponentLocalService = jiraComponentLocalService;
	}

	/**
	 * Returns the jira component remote service.
	 *
	 * @return the jira component remote service
	 */
	public com.liferay.jira.metrics.service.JiraComponentService getJiraComponentService() {
		return jiraComponentService;
	}

	/**
	 * Sets the jira component remote service.
	 *
	 * @param jiraComponentService the jira component remote service
	 */
	public void setJiraComponentService(
		com.liferay.jira.metrics.service.JiraComponentService jiraComponentService) {
		this.jiraComponentService = jiraComponentService;
	}

	/**
	 * Returns the jira component persistence.
	 *
	 * @return the jira component persistence
	 */
	public JiraComponentPersistence getJiraComponentPersistence() {
		return jiraComponentPersistence;
	}

	/**
	 * Sets the jira component persistence.
	 *
	 * @param jiraComponentPersistence the jira component persistence
	 */
	public void setJiraComponentPersistence(
		JiraComponentPersistence jiraComponentPersistence) {
		this.jiraComponentPersistence = jiraComponentPersistence;
	}

	/**
	 * Returns the jira data retrieve local service.
	 *
	 * @return the jira data retrieve local service
	 */
	public com.liferay.jira.metrics.service.JiraDataRetrieveLocalService getJiraDataRetrieveLocalService() {
		return jiraDataRetrieveLocalService;
	}

	/**
	 * Sets the jira data retrieve local service.
	 *
	 * @param jiraDataRetrieveLocalService the jira data retrieve local service
	 */
	public void setJiraDataRetrieveLocalService(
		com.liferay.jira.metrics.service.JiraDataRetrieveLocalService jiraDataRetrieveLocalService) {
		this.jiraDataRetrieveLocalService = jiraDataRetrieveLocalService;
	}

	/**
	 * Returns the jira data retrieve remote service.
	 *
	 * @return the jira data retrieve remote service
	 */
	public com.liferay.jira.metrics.service.JiraDataRetrieveService getJiraDataRetrieveService() {
		return jiraDataRetrieveService;
	}

	/**
	 * Sets the jira data retrieve remote service.
	 *
	 * @param jiraDataRetrieveService the jira data retrieve remote service
	 */
	public void setJiraDataRetrieveService(
		com.liferay.jira.metrics.service.JiraDataRetrieveService jiraDataRetrieveService) {
		this.jiraDataRetrieveService = jiraDataRetrieveService;
	}

	/**
	 * Returns the jira data retrieve persistence.
	 *
	 * @return the jira data retrieve persistence
	 */
	public JiraDataRetrievePersistence getJiraDataRetrievePersistence() {
		return jiraDataRetrievePersistence;
	}

	/**
	 * Sets the jira data retrieve persistence.
	 *
	 * @param jiraDataRetrievePersistence the jira data retrieve persistence
	 */
	public void setJiraDataRetrievePersistence(
		JiraDataRetrievePersistence jiraDataRetrievePersistence) {
		this.jiraDataRetrievePersistence = jiraDataRetrievePersistence;
	}

	/**
	 * Returns the jira metric local service.
	 *
	 * @return the jira metric local service
	 */
	public com.liferay.jira.metrics.service.JiraMetricLocalService getJiraMetricLocalService() {
		return jiraMetricLocalService;
	}

	/**
	 * Sets the jira metric local service.
	 *
	 * @param jiraMetricLocalService the jira metric local service
	 */
	public void setJiraMetricLocalService(
		com.liferay.jira.metrics.service.JiraMetricLocalService jiraMetricLocalService) {
		this.jiraMetricLocalService = jiraMetricLocalService;
	}

	/**
	 * Returns the jira metric remote service.
	 *
	 * @return the jira metric remote service
	 */
	public com.liferay.jira.metrics.service.JiraMetricService getJiraMetricService() {
		return jiraMetricService;
	}

	/**
	 * Sets the jira metric remote service.
	 *
	 * @param jiraMetricService the jira metric remote service
	 */
	public void setJiraMetricService(
		com.liferay.jira.metrics.service.JiraMetricService jiraMetricService) {
		this.jiraMetricService = jiraMetricService;
	}

	/**
	 * Returns the jira metric persistence.
	 *
	 * @return the jira metric persistence
	 */
	public JiraMetricPersistence getJiraMetricPersistence() {
		return jiraMetricPersistence;
	}

	/**
	 * Sets the jira metric persistence.
	 *
	 * @param jiraMetricPersistence the jira metric persistence
	 */
	public void setJiraMetricPersistence(
		JiraMetricPersistence jiraMetricPersistence) {
		this.jiraMetricPersistence = jiraMetricPersistence;
	}

	/**
	 * Returns the jira priority local service.
	 *
	 * @return the jira priority local service
	 */
	public com.liferay.jira.metrics.service.JiraPriorityLocalService getJiraPriorityLocalService() {
		return jiraPriorityLocalService;
	}

	/**
	 * Sets the jira priority local service.
	 *
	 * @param jiraPriorityLocalService the jira priority local service
	 */
	public void setJiraPriorityLocalService(
		com.liferay.jira.metrics.service.JiraPriorityLocalService jiraPriorityLocalService) {
		this.jiraPriorityLocalService = jiraPriorityLocalService;
	}

	/**
	 * Returns the jira priority remote service.
	 *
	 * @return the jira priority remote service
	 */
	public com.liferay.jira.metrics.service.JiraPriorityService getJiraPriorityService() {
		return jiraPriorityService;
	}

	/**
	 * Sets the jira priority remote service.
	 *
	 * @param jiraPriorityService the jira priority remote service
	 */
	public void setJiraPriorityService(
		com.liferay.jira.metrics.service.JiraPriorityService jiraPriorityService) {
		this.jiraPriorityService = jiraPriorityService;
	}

	/**
	 * Returns the jira priority persistence.
	 *
	 * @return the jira priority persistence
	 */
	public JiraPriorityPersistence getJiraPriorityPersistence() {
		return jiraPriorityPersistence;
	}

	/**
	 * Sets the jira priority persistence.
	 *
	 * @param jiraPriorityPersistence the jira priority persistence
	 */
	public void setJiraPriorityPersistence(
		JiraPriorityPersistence jiraPriorityPersistence) {
		this.jiraPriorityPersistence = jiraPriorityPersistence;
	}

	/**
	 * Returns the jira project local service.
	 *
	 * @return the jira project local service
	 */
	public com.liferay.jira.metrics.service.JiraProjectLocalService getJiraProjectLocalService() {
		return jiraProjectLocalService;
	}

	/**
	 * Sets the jira project local service.
	 *
	 * @param jiraProjectLocalService the jira project local service
	 */
	public void setJiraProjectLocalService(
		com.liferay.jira.metrics.service.JiraProjectLocalService jiraProjectLocalService) {
		this.jiraProjectLocalService = jiraProjectLocalService;
	}

	/**
	 * Returns the jira project remote service.
	 *
	 * @return the jira project remote service
	 */
	public com.liferay.jira.metrics.service.JiraProjectService getJiraProjectService() {
		return jiraProjectService;
	}

	/**
	 * Sets the jira project remote service.
	 *
	 * @param jiraProjectService the jira project remote service
	 */
	public void setJiraProjectService(
		com.liferay.jira.metrics.service.JiraProjectService jiraProjectService) {
		this.jiraProjectService = jiraProjectService;
	}

	/**
	 * Returns the jira project persistence.
	 *
	 * @return the jira project persistence
	 */
	public JiraProjectPersistence getJiraProjectPersistence() {
		return jiraProjectPersistence;
	}

	/**
	 * Sets the jira project persistence.
	 *
	 * @param jiraProjectPersistence the jira project persistence
	 */
	public void setJiraProjectPersistence(
		JiraProjectPersistence jiraProjectPersistence) {
		this.jiraProjectPersistence = jiraProjectPersistence;
	}

	/**
	 * Returns the jira status local service.
	 *
	 * @return the jira status local service
	 */
	public com.liferay.jira.metrics.service.JiraStatusLocalService getJiraStatusLocalService() {
		return jiraStatusLocalService;
	}

	/**
	 * Sets the jira status local service.
	 *
	 * @param jiraStatusLocalService the jira status local service
	 */
	public void setJiraStatusLocalService(
		com.liferay.jira.metrics.service.JiraStatusLocalService jiraStatusLocalService) {
		this.jiraStatusLocalService = jiraStatusLocalService;
	}

	/**
	 * Returns the jira status remote service.
	 *
	 * @return the jira status remote service
	 */
	public com.liferay.jira.metrics.service.JiraStatusService getJiraStatusService() {
		return jiraStatusService;
	}

	/**
	 * Sets the jira status remote service.
	 *
	 * @param jiraStatusService the jira status remote service
	 */
	public void setJiraStatusService(
		com.liferay.jira.metrics.service.JiraStatusService jiraStatusService) {
		this.jiraStatusService = jiraStatusService;
	}

	/**
	 * Returns the jira status persistence.
	 *
	 * @return the jira status persistence
	 */
	public JiraStatusPersistence getJiraStatusPersistence() {
		return jiraStatusPersistence;
	}

	/**
	 * Sets the jira status persistence.
	 *
	 * @param jiraStatusPersistence the jira status persistence
	 */
	public void setJiraStatusPersistence(
		JiraStatusPersistence jiraStatusPersistence) {
		this.jiraStatusPersistence = jiraStatusPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the portlet preferences local service.
	 *
	 * @return the portlet preferences local service
	 */
	public com.liferay.portal.service.PortletPreferencesLocalService getPortletPreferencesLocalService() {
		return portletPreferencesLocalService;
	}

	/**
	 * Sets the portlet preferences local service.
	 *
	 * @param portletPreferencesLocalService the portlet preferences local service
	 */
	public void setPortletPreferencesLocalService(
		com.liferay.portal.service.PortletPreferencesLocalService portletPreferencesLocalService) {
		this.portletPreferencesLocalService = portletPreferencesLocalService;
	}

	/**
	 * Returns the portlet preferences remote service.
	 *
	 * @return the portlet preferences remote service
	 */
	public com.liferay.portal.service.PortletPreferencesService getPortletPreferencesService() {
		return portletPreferencesService;
	}

	/**
	 * Sets the portlet preferences remote service.
	 *
	 * @param portletPreferencesService the portlet preferences remote service
	 */
	public void setPortletPreferencesService(
		com.liferay.portal.service.PortletPreferencesService portletPreferencesService) {
		this.portletPreferencesService = portletPreferencesService;
	}

	/**
	 * Returns the portlet preferences persistence.
	 *
	 * @return the portlet preferences persistence
	 */
	public PortletPreferencesPersistence getPortletPreferencesPersistence() {
		return portletPreferencesPersistence;
	}

	/**
	 * Sets the portlet preferences persistence.
	 *
	 * @param portletPreferencesPersistence the portlet preferences persistence
	 */
	public void setPortletPreferencesPersistence(
		PortletPreferencesPersistence portletPreferencesPersistence) {
		this.portletPreferencesPersistence = portletPreferencesPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return JiraProject.class;
	}

	protected String getModelClassName() {
		return JiraProject.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = jiraProjectPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.jira.metrics.service.JiraComponentLocalService.class)
	protected com.liferay.jira.metrics.service.JiraComponentLocalService jiraComponentLocalService;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraComponentService.class)
	protected com.liferay.jira.metrics.service.JiraComponentService jiraComponentService;
	@BeanReference(type = JiraComponentPersistence.class)
	protected JiraComponentPersistence jiraComponentPersistence;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraDataRetrieveLocalService.class)
	protected com.liferay.jira.metrics.service.JiraDataRetrieveLocalService jiraDataRetrieveLocalService;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraDataRetrieveService.class)
	protected com.liferay.jira.metrics.service.JiraDataRetrieveService jiraDataRetrieveService;
	@BeanReference(type = JiraDataRetrievePersistence.class)
	protected JiraDataRetrievePersistence jiraDataRetrievePersistence;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraMetricLocalService.class)
	protected com.liferay.jira.metrics.service.JiraMetricLocalService jiraMetricLocalService;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraMetricService.class)
	protected com.liferay.jira.metrics.service.JiraMetricService jiraMetricService;
	@BeanReference(type = JiraMetricPersistence.class)
	protected JiraMetricPersistence jiraMetricPersistence;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraPriorityLocalService.class)
	protected com.liferay.jira.metrics.service.JiraPriorityLocalService jiraPriorityLocalService;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraPriorityService.class)
	protected com.liferay.jira.metrics.service.JiraPriorityService jiraPriorityService;
	@BeanReference(type = JiraPriorityPersistence.class)
	protected JiraPriorityPersistence jiraPriorityPersistence;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraProjectLocalService.class)
	protected com.liferay.jira.metrics.service.JiraProjectLocalService jiraProjectLocalService;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraProjectService.class)
	protected com.liferay.jira.metrics.service.JiraProjectService jiraProjectService;
	@BeanReference(type = JiraProjectPersistence.class)
	protected JiraProjectPersistence jiraProjectPersistence;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraStatusLocalService.class)
	protected com.liferay.jira.metrics.service.JiraStatusLocalService jiraStatusLocalService;
	@BeanReference(type = com.liferay.jira.metrics.service.JiraStatusService.class)
	protected com.liferay.jira.metrics.service.JiraStatusService jiraStatusService;
	@BeanReference(type = JiraStatusPersistence.class)
	protected JiraStatusPersistence jiraStatusPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.PortletPreferencesLocalService.class)
	protected com.liferay.portal.service.PortletPreferencesLocalService portletPreferencesLocalService;
	@BeanReference(type = com.liferay.portal.service.PortletPreferencesService.class)
	protected com.liferay.portal.service.PortletPreferencesService portletPreferencesService;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private JiraProjectServiceClpInvoker _clpInvoker = new JiraProjectServiceClpInvoker();
}