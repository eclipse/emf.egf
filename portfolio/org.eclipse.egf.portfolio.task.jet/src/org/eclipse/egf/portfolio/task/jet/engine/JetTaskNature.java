/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.task.jet.engine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.ftask.task.ITaskNature;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

/**
 * Jet Task Nature implementation.
 * 
 * @author Florian Barbin
 * 
 */
public class JetTaskNature implements ITaskNature {

	public void invoke(Bundle bundle, ITaskProductionContext context,
			Task task, IProgressMonitor monitor) throws InvocationException {
		if (task == null || task.getImplementationValue() == null) {
			return;
		}
		String value = task.getImplementationValue().trim();

		Object parameter = context.getInputValue("parameter", Object.class);
		try {
			URI uri = URI.createURI(value);
			URL url;
			uri = CommonPlugin.resolve(uri);
			url = new URL(uri.toString());

			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					url.openStream());
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(bufferedInputStream));
			String content = bufferedReader.readLine();
			Pattern pattern = Pattern
					.compile("<%@ jet.package=\"([^\"]*)\".class=\"([^\"]*)\".*%>");

			Matcher matcher = pattern.matcher(content);
			if (matcher.matches()) {
				String packageString = matcher.group(1);
				String classString = matcher.group(2);

				Class<?> class1 = bundle.loadClass(packageString + "."
						+ classString);
				Object object = class1.newInstance();
				Method method = class1.getMethod("generate",
						new Class[] { Object.class });
				Object result = method.invoke(object,
						new Object[] { parameter });
				context.setOutputValue("result", result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isLoadableImplementation(Task task,
			Map<Object, Object> context) {
		return false;
	}

	public boolean isValidImplementation(Task task, Map<Object, Object> context) {
		return false;
	}

}
