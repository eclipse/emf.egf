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

  public static String _UI_FcoreSelection_label;
  public static String _UI_SelectRegisteredFcore;

  public static String _UI_TypeSelection_label;
  public static String _UI_SelectType;
  public static String _UI_SelectTypeSubClass;
  public static String _UI_FilteredTypesSelectionDialog_library_name_format;
  public static String _UI_FilteredTypesSelectionDialog_dialogMessage;
  public static String _UI_FilteredItemsSelectionDialog_separatorLabel;
  public static String _UI_FilteredItemsSelectionDialog_platformSeparatorLabel;
  public static String _UI_Reset_Label;

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

  public static String FilteredTypeSelectionDialog_findType;
  public static String FilteredTypeSelectionDialog_findTypeHierarchy;

  public static String _UI_DiagnosisOfNObject_message;
  public static String _UI_DiagnosisOfNObjects_message;

  public static String MenuContributor_newChildGroup_label;
  public static String MenuContributor_siblingChildGroup_label;

  public static String TypeSelection_dialogTitle;
  public static String TypeSelectionDialog_dialogMessage;

}
