/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.loader;

import java.net.URL;

import org.eclipse.core.resources.IProject;

/**
 * @author Xavier Maysonnave
 *
 */
public interface IClassLoader {

    public IProject getProject();

    public ClassLoader getParentClassLoader();

    public URL findResource(String name);

    public Class<?> loadClass(String name) throws ClassNotFoundException;

    public URL[] getURLs();

}
