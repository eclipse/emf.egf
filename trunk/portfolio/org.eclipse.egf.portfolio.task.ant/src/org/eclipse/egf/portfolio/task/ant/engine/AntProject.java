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
package org.eclipse.egf.portfolio.task.ant.engine;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.Path;

/**
 * @author xiaoru chen
 * 
 */
public class AntProject extends Project {
    @Override
    public AntClassLoader createClassLoader(Path path) {
        AntClassLoader antClassLoader = new AntClassLoader(getClass().getClassLoader(), this, path);
        return antClassLoader;
    }
}
