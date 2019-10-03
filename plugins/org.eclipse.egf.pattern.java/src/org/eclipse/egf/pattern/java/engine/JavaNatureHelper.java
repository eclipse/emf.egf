/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.java.engine;

import java.util.regex.Matcher;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.common.java.BaseJavaAssemblyHelper;
import org.eclipse.egf.pattern.common.java.BaseJavaPatternInitializer;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.TemplateFileHelper;

/**
 * @author Thomas Guiu
 */

public class JavaNatureHelper {

    private static final java.util.regex.Pattern compile = java.util.regex.Pattern.compile("\\s*package\\s*([\\w\\.]*);.*class\\s+(\\w*).*", java.util.regex.Pattern.DOTALL | java.util.regex.Pattern.MULTILINE); //$NON-NLS-1$

    /**
     * This method parses the template header to know the template class name.
     * 
     * @return never returns null or empty string.
     */
    public static String getClassName(Pattern pattern) throws PatternException {
        if (!"Java".equals(pattern.getNature().getName()))
            throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getNature().getName()));
        try {
            String content = TemplateFileHelper.getContent(pattern.getHeaderMethod());
            Matcher matcher = compile.matcher(content);
            if (matcher.matches()) {
                String pack = matcher.group(1);
                String cls = matcher.group(2);
                if ("".equals(pack) || "".equals(cls)) { //$NON-NLS-1$ //$NON-NLS-2$
                    throw new PatternException(Messages.bind(Messages.assembly_error8, pattern.getName()));
                }
                if (BaseJavaPatternInitializer.CLASS_KEY.equals(cls) && BaseJavaPatternInitializer.PACKAGE_KEY.equals(pack)) {
                    return BaseJavaAssemblyHelper.getFullClassName(pattern);
                }
                return pack + "." + cls; //$NON-NLS-1$
            }
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }
        throw new PatternException(Messages.bind(Messages.assembly_error6, pattern.getName()));
    }

    private JavaNatureHelper() {
        // Nothing to do
    }

}
