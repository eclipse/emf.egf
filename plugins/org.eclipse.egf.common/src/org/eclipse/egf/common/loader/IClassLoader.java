/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
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
