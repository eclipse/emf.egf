/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.emf.pattern.codegen.jet;

import java.util.regex.Pattern;

/**
 * @author Matthieu Helleboid
 *
 */
public interface CodegenJetConstants {

    public static final String BEGIN_JET = "<%"; //$NON-NLS-1$
    public static final String END_JET = "%>"; //$NON-NLS-1$
    public static final String EQUALS = "="; //$NON-NLS-1$
    public static final String BEGIN_EXP = BEGIN_JET + EQUALS;
    
    public static final String DIRECTIVE_INCLUDE = "include"; //$NON-NLS-1$
    public static final String ATTRIBUTE_FAIL = "fail"; //$NON-NLS-1$
    public static final String ATTRIBUTE_FILE = "file"; //$NON-NLS-1$
    public static final String FAIL_ALTERNATIVE = "alternative"; //$NON-NLS-1$

    public static final String DIRECTIVE_JET = "jet"; //$NON-NLS-1$
    public static final String DIRECTIVE_END = "end"; //$NON-NLS-1$
    public static final String DIRECTIVE_START = "start"; //$NON-NLS-1$
    
    public static final String AT = "@"; //$NON-NLS-1$
    public static final String SPACE = " "; //$NON-NLS-1$
    public static final String DBL_QUOTE = "\""; //$NON-NLS-1$
    public static final char N = '\n';
    public static final String MARK_STATEMENT = "new MarkStatement();\n"; //$NON-NLS-1$
    
    public static final Pattern INCLUDE_HEADER_REGEX = Pattern.compile("\\.\\./Header\\.(.*)jetinc"); //$NON-NLS-1$


}
