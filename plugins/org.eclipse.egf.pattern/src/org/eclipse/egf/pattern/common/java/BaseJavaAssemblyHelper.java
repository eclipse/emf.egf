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

package org.eclipse.egf.pattern.common.java;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.engine.AssemblyContentProvider;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternHelper;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class BaseJavaAssemblyHelper extends AssemblyHelper {

    public BaseJavaAssemblyHelper(Pattern pattern, AssemblyContentProvider contentProvider) {
        super(pattern, contentProvider);

    }

    protected void addHeader() throws PatternException {
        String read = contentHelper.getMethodContent(pattern.getHeaderMethod());
        if (read != null) {
            // replace tokens for classn ame and package name.

            read = read.replaceAll(BaseJavaPatternInitializer.CLASS_KEY, getClassName(pattern));
            read = read.replaceAll(BaseJavaPatternInitializer.PACKAGE_KEY, getPackageName(pattern));

            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);
        }
    }

    public static String getFullClassName(Pattern pattern) {
        return getPackageName(pattern) + "." + getClassName(pattern);
    }

    public static String getClassName(Pattern pattern) {
        return PatternHelper.dropNonWordCharacter(pattern.getName());
    }

    public static String getPackageName(Pattern pattern) {
        return PatternHelper.dropNonWordCharacter(pattern.getContainer().getName());
    }
}
