/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench;

import org.eclipse.osgi.util.NLS;

/**
 * I18n translation helper.
 * @author fournier
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.core.ui.workbench.messages"; //$NON-NLS-1$

  public static String ExplorerActionProvider_NewMenuItem_Title;

  // I18n messages related to open model element objects.
  public static String OpenModelElementAction_Title;

  // I18n messages related to edit model element objects.
  public static String CreateDomainAction_Title;
  public static String CreateDomainAction_Tooltip;
  public static String CreateFactoryComponentInvocationAction_Title;
  public static String CreateFactoryComponentInvocationAction_Tooltip;
  public static String CreateTaskFactoryHolderAction_Title;
  public static String CreateTaskFactoryHolderAction_Tooltip;
  public static String CreateContractElementAction_Title;
  public static String CreateContractElementAction_Tooltip;
  public static String CreateContextAction_Title;
  public static String CreateContextAction_Tooltip;
  public static String CreateContextElementAction_Title;
  public static String CreateContextElementAction_Tooltip;
  public static String CreatePatternLibraryAction_Title;
  public static String CreatePatternLibraryAction_Tooltip;
  public static String CreatePatternAction_Title;
  public static String CreatePatternAction_Tooltip;
  public static String CreateMappingAction_Title;
  public static String CreateMappingAction_Tooltip;

  // I18n messages related to edit model element objects.
  public static String EditModelElementAction_Title;
  public static String EditModelElementAction_Tooltip;

  // I18n messages related to delete model element objects.
  public static String DeleteAction_Title;
  public static String DeleteAction_Tooltip;
  public static String DeleteDomainAction_Message;
  public static String DeleteFactoryComponentInvocationAction_Message;
  public static String DeleteTaskFactoryHolderAction_Message;
  public static String DeleteContractElementAction_Message;
  public static String DeleteContextAction_Message;
  public static String DeleteContextElementAction_Message;
  public static String DeletePatternLibraryAction_Message;
  public static String CleanPatternLibraryActionConfirmDialog_Message;
  public static String DeletePatternAction_Message;
  public static String CleanPatternAction_Title;
  public static String CleanPatternAction_Tooltip;
  public static String CleanPatternActionConfirmDialog_Title;
  public static String CleanPatternActionConfirmDialog_Message;
  public static String DeleteMappingAction_Message;

  // I18n messages related to execute (build) a factory component.
  public static String ExecuteFactoryAction_Title;
  public static String ExecuteFactoryAction_Tooltip;
  public static String ExecuteFactoryAction_ValidationErrorDialog_Title;

  // I18n messages related to produce (build) a pattern element either a pattern model or a pattern library.
  public static String ProducePatternElementAction_Title;
  public static String ProducePatternElementAction_Tooltip;

  // I18n messages related to convert a plug-in in factory component
  public static String ConvertPlugin2FactoryComponent_Title;
  public static String ConvertPlugin2FactoryComponent_ErrorDialog_Message;

  // I18n messages related to validation
  public static String ValidateElementAction_Title;
  public static String ValidateElementAction_ValidationReportDialog_Title_Info;
  public static String ValidateElementAction_ValidationReportDialog_Title_Problem;
  public static String ValidateElementAction_Tooltip;
  public static String ValidateElementAction_ValidationReportDialog_Title;
  public static String ValidateElementAction_NoError_Message;
  public static String ValidateElementAction_Error_Overall_Message;
  public static String ValidateElementAction_Error_Detailed_Message;

  // I18n messages related to factory components views
  public static String FactoryComponentView_PatternFilterText_Title;
  
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  /**
   * Constructor.
   */
  private Messages() {
    // Do nothing.
  }
}
