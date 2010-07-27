/**
 * <copyright>
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
 * </copyright>
 */

package org.eclipse.egf.task.ui.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFTaskUIMessages extends NLS {

    private static final String BUNDLE_NAME = "org.eclipse.egf.task.ui.l10n.messages";//$NON-NLS-1$

    static {
        NLS.initializeMessages(BUNDLE_NAME, EGFTaskUIMessages.class);
    }

    public static String missing_invoker_message;

    public static String TaskImplementationMenuContributor_openAction_label;

    public static String OpenTaskImplementationMenuContributor_error_title;
    public static String OpenTaskImplementationMenuContributor_error_message;
    public static String OpenTaskImplementationMenuContributor_error_open_message;
    public static String OpenTaskImplementationMenuContributor_unable_to_find_platform_fcore;
    public static String OpenTaskImplementationMenuContributor_unable_to_load_class;

    public static String InterpreterSetPreferencePage_boolean_field_editor_label_text;
    public static String InterpreterSetPreferencePage_indicate_label_text_1;
    public static String InterpreterSetPreferencePage_indicate_label_text_2;
    public static String InterpreterSetPreferencePage_indicate_label_text_3;
    public static String InterpreterSetPreferencePage_indicate_label_text_4;
    public static String InterpreterSetPreferencePage_libraries_empty_error_message;
    public static String InterpreterSetPreferencePage_rubyVM_library_paths_editor_label_text;

    public static String RubyVMLibraryPathsEditor_label_text;

    public static String JRubyInstallPathFieldEditor_label_text;
    public static String _UI_SelectRubyResource;

}
