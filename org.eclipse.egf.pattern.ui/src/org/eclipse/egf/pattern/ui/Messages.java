/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class Messages extends NLS {
    // Overview Page
    public static String Editor_wrong_input;

    public static String OverviewPage_title;

    public static String OverviewPage_button_browse;

    public static String OverviewPage_sectionLeft_desci_label;

    public static String OverviewPage_sectionLeft_descripition_label;

    public static String OverviewPage_sectionLeft_fullName_label;

    public static String OverviewPage_sectionLeft_id_label;

    public static String OverviewPage_sectionLeft_name_label;

    public static String OverviewPage_sectionLeft_title;

    public static String OverviewPage_sectionLeft_title_label;

    public static String OverviewPage_sectionRight_impl_label;

    public static String OverviewPage_sectionRight_implLink_label;

    public static String OverviewPage_sectionRight_spec_label;

    public static String OverviewPage_sectionRight_specLink_label;

    public static String OverviewPage_sectionRight_title;

    public static String OverviewPage_sectionRight_title_label;

    // Implementation Page
    public static String ImplementationPage_title;

    public static String ImplementationPage_button_add;

    public static String ImplementationPage_button_down;

    public static String ImplementationPage_button_edit;

    public static String ImplementationPage_button_remove;

    public static String ImplementationPage_button_up;

    public static String ImplementationPage_Methods;

    public static String ImplementationPage_methAdd_dialog_title;

    public static String ImplementationPage_methEidt_dialog_title;

    public static String ImplementationPage_methSection_label;

    public static String ImplementationPage_orchSection_label;

    public static String ImplementationPage_orchSection_title;

    public static String ImplementationPage_varSection_label;

    public static String ImplementationPage_varSection_title;

    // Specification Page
    public static String SpecificationPage_title;

    public static String SpecificationPage_browse_dialog_title;

    public static String SpecificationPage_button_add;

    public static String SpecificationPage_button_browse;

    public static String SpecificationPage_button_down;

    public static String SpecificationPage_button_edit;

    public static String SpecificationPage_button_remove;

    public static String SpecificationPage_button_up;

    public static String SpecificationPage_inherSection_discrip_label;

    public static String SpecificationPage_inherSection_parent_label;

    public static String SpecificationPage_inherSection_title;

    public static String SpecificationPage_paraSection_discrip_label;

    public static String SpecificationPage_paraSection_title;

    public static String SpecificationPage_patternSection_discrip_label;

    public static String SpecificationPage_patternSection_title;

    public static String SpecificationPage_patternSection_type_label;

    // ContainerLibrarySelection Dialog
    public static String ContainerLibrarySelectionDialog_dialogArea_label;

    public static String ContainerLibrarySelectionDialog_pattern_label;

    // PatternSelection Dialog
    public static String PatternSelectiondialog_dialogArea_label;

    public static String PatternSelectiondialog_pattern_label;
    // Common

    public static String common_mark1;

    public static String common_mark2;

    public static String input_tooltip;

    private static final String BUNDLE_NAME = "org.eclipse.egf.pattern.ui.PatternUIMessages";//$NON-NLS-1$
    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
