/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
