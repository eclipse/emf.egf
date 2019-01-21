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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.pattern.PatternFolders;
import org.eclipse.egf.pattern.utils.TemplateFileHelper;

/**
 * This is a quick 'template engine' used for initialization of the contents of
 * new pattern methods.
 * 
 * @author Guiu
 * 
 */
public class SimpleEngine extends TemplateEngine {

    public SimpleEngine(String pluginId, IProject project, String templateFileExtension) {
        super(pluginId, project, templateFileExtension);
    }

    @Override
    public String process(Templates template, Map<String, String> context) throws CoreException, IOException {
        IPath path = new Path(PatternFolders.getTemplatesFolderName()).append(template.getTemplateName()).addFileExtension(getExtension());
        String content = TemplateFileHelper.getContent(getPluginId(), getProject(), path);
        if (content == null)
            return null;
        for (Iterator<Entry<String, String>> it = context.entrySet().iterator(); it.hasNext();) {
            Entry<String, String> entry = it.next();
            content = content.replaceAll(entry.getKey(), entry.getValue());
        }
        return content;
    }

}
