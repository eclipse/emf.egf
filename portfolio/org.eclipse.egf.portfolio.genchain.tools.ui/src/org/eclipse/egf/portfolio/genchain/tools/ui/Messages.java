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

    private static final String BUNDLE_NAME = "org.eclipse.egf.portfolio.genchain.tools.ui.Messages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
