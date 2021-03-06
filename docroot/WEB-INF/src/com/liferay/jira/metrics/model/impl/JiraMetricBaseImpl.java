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

import com.liferay.jira.metrics.model.JiraMetric;
import com.liferay.jira.metrics.service.JiraMetricLocalServiceUtil;

/**
 * The extended model base implementation for the JiraMetric service. Represents a row in the &quot;jirametrics_JiraMetric&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JiraMetricImpl}.
 * </p>
 *
 * @author Manuel de la Peña
 * @see JiraMetricImpl
 * @see com.liferay.jira.metrics.model.JiraMetric
 * @generated
 */
public abstract class JiraMetricBaseImpl extends JiraMetricModelImpl
	implements JiraMetric {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a jira metric model instance should use the {@link JiraMetric} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			JiraMetricLocalServiceUtil.addJiraMetric(this);
		}
		else {
			JiraMetricLocalServiceUtil.updateJiraMetric(this);
		}
	}
}