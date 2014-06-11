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

package com.liferay.jira.metrics.service.persistence;

import com.liferay.jira.metrics.model.JiraPriority;
import com.liferay.jira.metrics.service.JiraPriorityLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;

/**
 * @author Manuel de la Peña
 * @deprecated As of 7.0.0, replaced by {@link JiraPriorityLocalServiceUtil#getExportActionableDynamicQuery()}
 * @generated
 */
@Deprecated
public abstract class JiraPriorityActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public JiraPriorityActionableDynamicQuery() {
		setBaseLocalService(JiraPriorityLocalServiceUtil.getService());
		setClass(JiraPriority.class);

		setClassLoader(com.liferay.jira.metrics.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("jiraPriorityId");
	}
}