/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java;

import org.eclipse.osgi.util.NLS;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaTextEditorMessages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.ui.java.javaTextEditorMessages"; //$NON-NLS-1$
    public static String JavaTextEditorContentAssistProcessor_No_Default_proposals;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, JavaTextEditorMessages.class);
    }

    private JavaTextEditorMessages() {
    }
}
