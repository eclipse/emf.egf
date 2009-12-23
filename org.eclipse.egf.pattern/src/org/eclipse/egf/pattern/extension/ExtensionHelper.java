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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.pattern.Activator;

/**
 * @author Guiu
 *
 */
public class ExtensionHelper {

	public static List<PatternExtension> getExtensions()
	{
		List<PatternExtension> result = new ArrayList<PatternExtension>();
		for (IConfigurationElement element: Platform.getExtensionRegistry().getConfigurationElementsFor(PatternExtension.EXTENSION_ID))
		{
			try {
				result.add((PatternExtension)element.createExecutableExtension("class"));
			} catch (CoreException e) {
				Activator.getDefault().logError(e);
			}
		}
		return result;
	}
}
