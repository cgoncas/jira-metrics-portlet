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

package com.liferay.jira.metrics.service;

import com.liferay.jira.metrics.model.JiraComponentClp;
import com.liferay.jira.metrics.model.JiraDataRetrieveClp;
import com.liferay.jira.metrics.model.JiraMetricClp;
import com.liferay.jira.metrics.model.JiraPriorityClp;
import com.liferay.jira.metrics.model.JiraProjectClp;
import com.liferay.jira.metrics.model.JiraStatusClp;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel de la Peña
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"jira-metrics-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"jira-metrics-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "jira-metrics-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(JiraComponentClp.class.getName())) {
			return translateInputJiraComponent(oldModel);
		}

		if (oldModelClassName.equals(JiraDataRetrieveClp.class.getName())) {
			return translateInputJiraDataRetrieve(oldModel);
		}

		if (oldModelClassName.equals(JiraMetricClp.class.getName())) {
			return translateInputJiraMetric(oldModel);
		}

		if (oldModelClassName.equals(JiraPriorityClp.class.getName())) {
			return translateInputJiraPriority(oldModel);
		}

		if (oldModelClassName.equals(JiraProjectClp.class.getName())) {
			return translateInputJiraProject(oldModel);
		}

		if (oldModelClassName.equals(JiraStatusClp.class.getName())) {
			return translateInputJiraStatus(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputJiraComponent(BaseModel<?> oldModel) {
		JiraComponentClp oldClpModel = (JiraComponentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJiraComponentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJiraDataRetrieve(BaseModel<?> oldModel) {
		JiraDataRetrieveClp oldClpModel = (JiraDataRetrieveClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJiraDataRetrieveRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJiraMetric(BaseModel<?> oldModel) {
		JiraMetricClp oldClpModel = (JiraMetricClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJiraMetricRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJiraPriority(BaseModel<?> oldModel) {
		JiraPriorityClp oldClpModel = (JiraPriorityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJiraPriorityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJiraProject(BaseModel<?> oldModel) {
		JiraProjectClp oldClpModel = (JiraProjectClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJiraProjectRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJiraStatus(BaseModel<?> oldModel) {
		JiraStatusClp oldClpModel = (JiraStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJiraStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.jira.metrics.model.impl.JiraComponentImpl")) {
			return translateOutputJiraComponent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.jira.metrics.model.impl.JiraDataRetrieveImpl")) {
			return translateOutputJiraDataRetrieve(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.jira.metrics.model.impl.JiraMetricImpl")) {
			return translateOutputJiraMetric(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.jira.metrics.model.impl.JiraPriorityImpl")) {
			return translateOutputJiraPriority(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.jira.metrics.model.impl.JiraProjectImpl")) {
			return translateOutputJiraProject(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.jira.metrics.model.impl.JiraStatusImpl")) {
			return translateOutputJiraStatus(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (ClassNotFoundException cnfe) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(
					"com.liferay.jira.metrics.DuplicateJiraComponentException")) {
			return new com.liferay.jira.metrics.DuplicateJiraComponentException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.DuplicateJiraMetricException")) {
			return new com.liferay.jira.metrics.DuplicateJiraMetricException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.DuplicateJiraPriorityException")) {
			return new com.liferay.jira.metrics.DuplicateJiraPriorityException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.DuplicateJiraProjectException")) {
			return new com.liferay.jira.metrics.DuplicateJiraProjectException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.DuplicateJiraStatusException")) {
			return new com.liferay.jira.metrics.DuplicateJiraStatusException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.NoSuchJiraComponentException")) {
			return new com.liferay.jira.metrics.NoSuchJiraComponentException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.NoSuchJiraDataRetrieveException")) {
			return new com.liferay.jira.metrics.NoSuchJiraDataRetrieveException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.NoSuchJiraMetricException")) {
			return new com.liferay.jira.metrics.NoSuchJiraMetricException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.NoSuchJiraPriorityException")) {
			return new com.liferay.jira.metrics.NoSuchJiraPriorityException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.NoSuchJiraProjectException")) {
			return new com.liferay.jira.metrics.NoSuchJiraProjectException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.jira.metrics.NoSuchJiraStatusException")) {
			return new com.liferay.jira.metrics.NoSuchJiraStatusException(throwable.getMessage(),
				throwable.getCause());
		}

		return throwable;
	}

	public static Object translateOutputJiraComponent(BaseModel<?> oldModel) {
		JiraComponentClp newModel = new JiraComponentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJiraComponentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJiraDataRetrieve(BaseModel<?> oldModel) {
		JiraDataRetrieveClp newModel = new JiraDataRetrieveClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJiraDataRetrieveRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJiraMetric(BaseModel<?> oldModel) {
		JiraMetricClp newModel = new JiraMetricClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJiraMetricRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJiraPriority(BaseModel<?> oldModel) {
		JiraPriorityClp newModel = new JiraPriorityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJiraPriorityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJiraProject(BaseModel<?> oldModel) {
		JiraProjectClp newModel = new JiraProjectClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJiraProjectRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJiraStatus(BaseModel<?> oldModel) {
		JiraStatusClp newModel = new JiraStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJiraStatusRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}