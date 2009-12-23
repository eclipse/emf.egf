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

package org.eclipse.egf.pattern.templates;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.pattern.FileHelper_to_be_upgraded;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.egf.pattern.templates.TemplateEngine.Templates;

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
    
    public String process(Templates template, Map<String, String> context) throws CoreException, IOException {
        IPath path = new Path(PatternPreferences.getTemplatesFolderName()).append(template.getTemplateName()).addFileExtension(getExtension());
        String content = FileHelper_to_be_upgraded.getContent(getPluginId(), getProject(), path);
        if (content == null)
            return null;
        for (String key : context.keySet()) {
            content = content.replaceAll(key, context.get(key));
        }
        return content;
    }
}
