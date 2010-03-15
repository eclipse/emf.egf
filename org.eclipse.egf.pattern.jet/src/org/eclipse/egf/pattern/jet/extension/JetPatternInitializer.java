/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.jet.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.TemplateInitializer;
import org.eclipse.egf.pattern.jet.Activator;
import org.eclipse.egf.pattern.jet.JetPreferences;
import org.eclipse.egf.pattern.templates.SimpleEngine;

/**
 * @author Guiu
 * 
 */
public class JetPatternInitializer extends TemplateInitializer {

    private static final String CLASS_KEY = "CLASS";
    private static final String PACKAGE_KEY = "PACKAGE";
    private final Map<String, String> ctx = new HashMap<String, String>();

    public JetPatternInitializer(IProject project, Pattern pattern) {
        super(project, pattern, new SimpleEngine(Activator.PLUGIN_ID, project, JetPreferences.getTemplateFileExtension()));
        ctx.put(CLASS_KEY, PatternHelper.dropNonWordCharacter(pattern.getName()));
        String fullLibraryName = PatternHelper.getFullLibraryName(pattern);
        if (fullLibraryName == null || "".equals(fullLibraryName))
            fullLibraryName = "default_package";
        ctx.put(PACKAGE_KEY, fullLibraryName);
    }

    @Override
    protected Map<String, String> createContext() {
        return ctx;
    }

}
