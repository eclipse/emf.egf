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

package org.eclipse.egf.pattern.java;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.ProjectHelper;

/**
 * @author Guiu
 * 
 */
public class JavaPreferences {

    public static String getEncoding(IProject project) {
        return ProjectHelper.getEncoding(project);
    }

    public static String getTemplateFileExtension() {
        return "java_template"; //$NON-NLS-1$
    }

    private JavaPreferences() {
        super();
    }

}
