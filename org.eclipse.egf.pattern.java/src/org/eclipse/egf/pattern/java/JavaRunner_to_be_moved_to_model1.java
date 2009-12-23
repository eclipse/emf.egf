/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.java;

import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.javapattern.impl.JavaRunnerImpl;
import org.eclipse.egf.pattern.PatternHelper;

/**
 * @author Guiu
 * 
 *         Temp class ...
 */
public class JavaRunner_to_be_moved_to_model1 extends JavaRunnerImpl {

	public void run(PatternContext context) {
	}

	public void translate() {
		if (getPattern() == null)
			throw new IllegalStateException();

		// **************************************************************************
		// 1 - put together all pt files
		PatternHelper helper = new JavaPatternHelper(getPattern());
		String templatecontent = helper.visit();

		// 2 - put the result in the right file
		// TODO
	}
}
