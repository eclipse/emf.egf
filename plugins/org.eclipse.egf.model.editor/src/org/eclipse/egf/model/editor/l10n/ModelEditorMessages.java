/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.editor.l10n;

import org.eclipse.osgi.util.NLS;

public class ModelEditorMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.model.editor.l10n.messages"; //$NON-NLS-1$

    private ModelEditorMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, ModelEditorMessages.class);
    }

    public static String ActivityMenuContributor_openAction_label;

    public static String ActivityMenuContributor_selectAction_label;

    public static String ActivityMenuContributor_invokeAction_label;

    public static String ContractMenuContributor_openAction_label;

    public static String ContractMenuContributor_selectAction_label;

    public static String TaskMenuContributor_openAction_label;

    public static String TaskMenuContributor_selectAction_label;

    public static String URIMenuContributor_openAction_label;

    public static String URIMenuContributor_selectAction_label;

    public static String InvokeActivityWizard_Activity_title;

    public static String InvokeActivityWizard_Activity_description;

    public static String InvokeActivityWizard_Contract_title;

    public static String InvokeActivityWizard_Contract_description;

    public static String InvokeActivityWizard_Contract_select;

    public static String TypeURIEditorContributor_title;

    public static String _UI_InvokeCommand_label;

    public static String _UI_InvokeCommand_description;

}
