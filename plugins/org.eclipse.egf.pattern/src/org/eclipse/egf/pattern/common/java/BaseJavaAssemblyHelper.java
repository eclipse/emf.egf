/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.common.java;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.pattern.engine.AssemblyContentProvider;
import org.eclipse.egf.pattern.engine.AssemblyHelper;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class BaseJavaAssemblyHelper extends AssemblyHelper {

    public BaseJavaAssemblyHelper(Pattern pattern, AssemblyContentProvider contentProvider) {
        super(pattern, contentProvider);
    }

    @Override
    protected void addHeader() throws PatternException {
        String read = contentHelper.getMethodContent(pattern.getHeaderMethod());
        if (read != null) {
            // replace tokens for class name and package name.
            read = read.replaceAll(BaseJavaPatternInitializer.CLASS_KEY, getClassName(pattern));
            read = read.replaceAll(BaseJavaPatternInitializer.PACKAGE_KEY, getPackageName(pattern.getContainer()));
            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);
        }
    }

    public static String getFullClassName(Pattern pattern) {
        if (pattern == null) {
            return null;
        }
        return getPackageName(pattern.getContainer()) + "." + getClassName(pattern); //$NON-NLS-1$
    }

    public static String getClassName(Pattern pattern) {
        if (pattern == null) {
            return null;
        }
        return getClassName(pattern.getName());
    }

    public static String getClassName(String name) {
        return JavaHelper.dropNonWordCharacter(name);
    }

    public static String getPackageName(PatternLibrary library) {
        if (library == null) {
            return null;
        }
        return getPackageName(library.getName());
    }

    public static String getPackageName(String name) {
        return JavaHelper.dropNonWordCharacterExcept(name, "."); //$NON-NLS-1$
    }

}
