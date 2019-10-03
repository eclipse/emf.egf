/**
 * <copyright>
 *
 *  Copyright (c) 2009, 2018 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.pattern.templates.SimpleEngine;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenEngine extends SimpleEngine {

    protected static final String IMPORTS = "imports=\""; //$NON-NLS-1$
    protected static final String JET_PACKAGE = "<%@ jet package="; //$NON-NLS-1$
    protected String importString;

    public CodegenEngine(String pluginId, IProject project, String templateFileExtension) {
        super(pluginId, project, templateFileExtension);
    }

    @Override
    public String process(Templates template, Map<String, String> context) throws CoreException, IOException {
        String result = super.process(template, context);

        // add imports needed for codegen templates
        if (result.startsWith(JET_PACKAGE))
            result = result.replace(IMPORTS, getImportString());

        return result;
    }

    protected String getImportString() {
        if (importString == null) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(IMPORTS);
            buffer.append("org.eclipse.egf.emf.pattern.base.* "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.codegen.ecore.genmodel.* "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.codegen.ecore.genmodel.impl.* "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.codegen.ecore.genmodel.generator.* "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.codegen.util.* "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.ecore.util.* "); //$NON-NLS-1$
            buffer.append("org.eclipse.emf.common.util.* "); //$NON-NLS-1$
            importString = buffer.toString();
        }

        return importString;
    }

}
