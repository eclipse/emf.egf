/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;

/**
 * @author Matthieu Helleboid
 *
 */
public class ItemPropertiesQuery implements IQuery {

	public List execute(ParameterDescription parameter,
			Map<String, String> queryCtx, PatternContext context) {
		Job job = (Job) context.getValue(PatternContext.INJECTED_CONTEXT);
		return new PropertiesHelper().getRuntimeProperties(job);
	}

}
