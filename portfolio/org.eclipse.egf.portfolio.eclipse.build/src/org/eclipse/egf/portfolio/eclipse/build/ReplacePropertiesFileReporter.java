/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.eclipse.build;

import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ReplacePropertiesFileReporter extends FileReporter {

	public void executionFinished(String output, PatternContext context) {
	}

	public void loopFinished(String output, String outputWithCallBack,
			PatternContext context, Map<String, Object> parameterValues) {
	    Job job = (Job) parameterValues.get("job");
	    List<PropertyWrapper> allProperties = new PropertiesHelper().getRuntimeProperties(job);
	    for (PropertyWrapper propertyWrapper : allProperties) {
            String toReplace = "${" + propertyWrapper.getKey() + "}";
            String replacement = propertyWrapper.getValue();
	        outputWithCallBack = outputWithCallBack.replace(toReplace , replacement);
        }
	    super.loopFinished(output, outputWithCallBack, context, parameterValues);
	}
}
