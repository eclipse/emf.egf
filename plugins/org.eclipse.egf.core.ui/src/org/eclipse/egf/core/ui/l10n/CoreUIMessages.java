/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.ui.l10n;

import org.eclipse.osgi.util.NLS;

public class CoreUIMessages {

    private static final String BUNDLE_NAME = "org.eclipse.egf.core.ui.l10n.messages"; //$NON-NLS-1$

    private CoreUIMessages() {
        // Do not instantiate
    }

    static {
        // load message values from bundle file
        NLS.initializeMessages(BUNDLE_NAME, CoreUIMessages.class);
    }

    public static String ExceptionDialog_seeErrorLogMessage;

    public static String _UI_GenericSelectionDialog_dialogTitle;

    public static String _UI_GenericSelectionDialog_dialogMessage;

    public static String _UI_FcoreSelection_label;

    public static String _UI_SelectRegisteredFcore;

    public static String _UI_TypeSelection;

    public static String _UI_SelectType;

    public static String _UI_SelectTypes;

    public static String _UI_FilteredItemsSelectionDialog_separatorLabel;

    public static String _UI_FilteredItemsSelectionDialog_runtimeSeparatorLabel;

    public static String _UI_FilteredItemsSelectionDialog_platformSeparatorLabel;

    public static String _UI_FilteredItemsSelectionDialog_workspaceSeparatorLabel;

    public static String EGFGeneralPreferencePage_Title;

    public static String EGFGeneralPreferencePage_Description;

    public static String EGFModelPreferencePage_Title;

    public static String EGFModelPreferencePage_Description;

    public static String EGFModelPreferencePage_Validate;

    public static String EGFModelPreferencePage_Validate_Types;

    public static String EGFProductionPreferencePage_Title;

    public static String EGFProductionPreferencePage_Description;

    public static String EGFProductionPreferencePage_Validate;

    public static String EGFProductionPreferencePage_Validate_Always;

    public static String EGFProductionPreferencePage_Validate_Never;

    public static String EGFProductionPreferencePage_Validate_Prompt;

    public static String AbstractCheckboxSelectionDialog_Select;

    public static String AbstractCheckboxSelectionDialog_Deselect;

    public static String _UI_DiagnosisOfNObject_message;

    public static String _UI_DiagnosisOfNObjects_message;

    public static String MenuContributor_newChildGroup_label;

    public static String MenuContributor_siblingChildGroup_label;

    public static String TypeSelection_dialogTitle;

    public static String TypeSelectionDialog_dialogMessage;

    public static String _UI_No_Associated_GenModel;

    public static String _UI_BrowseResource_title;

    public static String _UI_BrowseRegisteredPackages_title;

    public static String _UI_BrowseRegisteredPackages_label;

    public static String _UI_PackageSelection_label;

    public static String _UI_RegisteredPackageSelection_label;

    public static String _UI_SelectRegisteredPackageURI;

    public static String _UI_PackageURIs_label;

    public static String _UI_PackageURI_label;

    public static String ModelSelection_errorMessage;

    public static String TargetPlatformEcoreSelectionDialog_choose_model_button_title;

    public static String TargetPlatformEcoreSelectionDialog_nItemsSelected;

    public static String TargetPlatformEcoreSelectionDialog_toggleStatusAction;

    public static String TargetPlatformEcoreSelectionDialog_menu;

    public static String TargetPlatformEcoreSelectionDialog_select;

    public static String _UI_FileConflict_label;

    public static String _WARN_FileConflict;

}
