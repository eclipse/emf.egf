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
package org.eclipse.egf.portfolio.task.ant.engine;

import java.io.IOException;
import java.net.URL;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;
import org.eclipse.ant.core.AntCorePlugin;
import org.eclipse.ant.core.AntCorePreferences;
import org.eclipse.core.runtime.Platform;

/**
 * @author xiaoru chen
 * 
 */
public class AntProject extends Project {
    @Override
    public AntClassLoader createClassLoader(Path path) {
		AntClassLoader antClassLoader = new AntClassLoader(getClass().getClassLoader(), this, path);
		AntCorePreferences prefs = AntCorePlugin.getPlugin().getPreferences();
		URL[] antClasspath = prefs.getURLs();
		for (int i = 0; i < antClasspath.length; i++) {
			try {
				antClassLoader.addPathElement(Platform.asLocalURL(antClasspath[i]).getPath());
			} catch (IOException e) {
				continue;
			}
		}
		return antClassLoader;
    }
}
