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

package org.eclipse.egf.pattern.java.engine;

import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.common.java.AbstractJavaEngine;
import org.eclipse.egf.pattern.engine.AssemblyHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaEngine extends AbstractJavaEngine {

    public JavaEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    @Override
    public void translate() throws PatternException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new IllegalStateException();

        // **************************************************************************
        // 1 - put together all pt files
        AssemblyHelper helper = new JavaAssemblyHelper(pattern, new JavaAssemblyContentProvider(pattern));
        String templatecontent = helper.visit();

        // 2 - add additional code to the class
        JavaTranslationEnhancer enhancer = new JavaTranslationEnhancer(pattern);
        templatecontent = enhancer.enhance(templatecontent);

        // 3 - put the result in the right file
        try {
            String classname = JavaNatureHelper.getClassName(pattern);
            IPath outputPath = computeFilePath(classname);

            writeContent(pattern, outputPath, templatecontent);
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

    }

    @Override
    public String getUnderlyingClassname() throws PatternException {
        return JavaNatureHelper.getClassName(getPattern());
    }

}
