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

package org.eclipse.egf.portfolio.genchain.tools.ui;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class Messages extends NLS {

    public static String genchain_wizard_title;
    public static String genchain_wizard_file_description;
    public static String genchain_wizard_content_description;
    public static String genchain_wizard_addButton_label;
    public static String genchain_wizard_deleteButton_label;
    public static String genchain_wizard_upButton_label;
    public static String genchain_wizard_downButton_label;
    public static String genchain_wizard_extension_error;

    public static String genchain_generate_action_label;
    public static String genchain_run_action_label;
    public static String genchain_wizard_valueColumn_label;
    public static String genchain_wizard_error1;
    public static String genchain_wizard_element_name_creation;

    private static final String BUNDLE_NAME = "org.eclipse.egf.portfolio.genchain.tools.ui.Messages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
