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

package org.eclipse.egf.pattern.extension;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.pattern.Pattern;

/**
 * @author Guiu
 * 
 */
public abstract class PatternInitializer {

	public abstract void initContent(IProject project, Pattern pattern);
}
