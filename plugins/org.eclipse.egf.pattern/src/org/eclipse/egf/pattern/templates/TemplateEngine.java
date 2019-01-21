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

package org.eclipse.egf.pattern.templates;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Guiu
 * 
 */
public abstract class TemplateEngine {

    private final IProject project;

    private final String pluginId;

    private final String extension;

    public TemplateEngine(String pluginId, IProject project, String templateFileExtension) {
        this.pluginId = pluginId;
        this.project = project;
        extension = templateFileExtension;
    }

    public abstract String process(Templates template, Map<String, String> context) throws CoreException, IOException;

    public IProject getProject() {
        return project;
    }

    public String getPluginId() {
        return pluginId;
    }

    public String getExtension() {
        return extension;
    }

    public static enum Templates {

        HEADER("header"), FOOTER("footer"), INIT("init"), PRE_CONDITION("condition"), DEFAULT("default"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

        private final String templateName;

        private Templates(String name) {
            templateName = name;
        }

        public String getTemplateName() {
            return templateName;
        }

    }

}
