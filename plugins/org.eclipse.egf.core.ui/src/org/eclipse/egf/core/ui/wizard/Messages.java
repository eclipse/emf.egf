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
package org.eclipse.egf.core.ui.wizard;

import org.eclipse.osgi.util.NLS;

/**
 * I18n translation helper for wizards.
 * @author fournier
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.egf.core.ui.wizard.messages"; //$NON-NLS-1$

  public static String CreationWizard_Prefix;
  public static String EditWizard_Prefix;
  public static String Wizard_Title;
  public static String WizardPage_Description_Title;
  public static String WizardPage_Description_Tooltip;

  // Edit FactoryComponent wizard messages.
  public static String EditFactoryComponentWizard_EditDescription_Message;
  public static String EditFactoryComponentWizard_Title;
  public static String EditFactoryComponentWizardPage_Title;
  public static String EditFactoryComponentWizardPage_Name_Title;
  public static String EditFactoryComponentWizardPage_Name_Tooltip;
  public static String EditFactoryComponentWizardPage_Name_ErrorMessage;

  // FactoryComponent configuration wizard messages.
  public static String FactoryComponentInvocationWizard_CreateDescription_Message;
  public static String FactoryComponentInvocationWizard_EditDescription_Message;
  public static String FactoryComponentInvocationWizard_Title;
  public static String FactoryComponentInvocationWizardPage_Title;
  public static String FactoryComponentInvocationWizardPage_Name_Title;
  public static String FactoryComponentInvocationWizardPage_Name_Tooltip;
  public static String FactoryComponentInvocationWizardPage_Name_ErrorMessage;
  public static String FactoryComponentInvocationWizardPage_ReferencedFactoryComponent_Title;
  public static String FactoryComponentInvocationWizardPage_ReferencedFactoryComponent_Tooltip;
  public static String FactoryComponentInvocationWizardPage_ReferencedFactoryComponent_ErrorMessage;
  public static String FactoryComponentInvocationWizard_WarnDialog_Title;
  public static String FactoryComponentInvocationWizard_WarnDialog_Message;

  // Task factory holder messages.
  public static String TaskFactoryHolderWizard_CreateDescription_Message;
  public static String TaskFactoryHolderWizard_EditDescription_Message;
  public static String TaskFactoryHolderWizard_Title;
  public static String TaskFactoryHolderWizardPage_Title;
  public static String TaskFactoryHolderWizardPage_Class_Title;
  public static String TaskFactoryHolderWizardPage_OpenTypeDialog_Title;

  // Contract element messages.
  public static String ContractElementWizard_CreateDescription_Message;
  public static String ContractElementWizard_EditDescription_Message;
  public static String ContractElementWizard_Title;
  public static String ContractElementWizardPage_Title;
  public static String ContractElementWizardPage_Key_Title;
  public static String ContractElementWizardPage_Key_Tooltip;
  public static String ContractElementWizardPage_Key_ErrorMessage;
  public static String ContractElementWizardPage_TypeGroup_Title;
  public static String ContractElementWizardPage_TypeGroup_Type;
  public static String ContractElementWizardPage_TypeGroup_Reference;
  public static String ContractElementWizardPage_OptionsGroup_Title;
  public static String ContractElementWizardPage_OptionsGroup_Mandatory_Title;
  public static String ContractElementWizardPage_OptionsGroup_Mandatory_Tooltip;
  public static String ContractElementTypeWizardPage_Class_Title;
  public static String ContractElementTypeWizardPage_ErrorMessage_1;
  public static String ContractElementTypeWizardPage_ErrorMessage_2;
  public static String ContractElementTypeWizardPage_OpenTypeDialog_Title;

  // Domain element messages.
  public static String DomainWizard_CreateDescription_Message;
  public static String DomainWizard_EditDescription_Message;
  public static String DomainWizard_Title;
  public static String DomainWizardPage_Title;
  public static String NewDomainWizardPage_Package_Title;
  public static String NewDomainWizardPage_Package_Tooltip;
  public static String NewDomainWizardPage_Package_ErrorMessage;
  public static String NewDomainWizardPage_Domain_Title;
  public static String NewDomainWizardPage_Domain_Tooltip;
  public static String NewDomainWizardPage_Domain_ErrorMessage;
  public static String NewDomainWizardPage_CreateDomain_Title;
  public static String NewDomainWizardPage_CreateDomain_Tooltip;
  public static String EditDomainWizardPage_OpenResourceDialog_Title;

  // Context Element messages.
  public static String ContextElementWizard_CreateDescription_Message;
  public static String ContextElementWizard_EditDescription_Message;
  public static String ContextElementWizard_Title;
  public static String ContextElementWizardPage_Title;
  public static String ContextElementWizardPage_Group_Key;
  public static String ContextElementWizardPage_Group_Reference;
  public static String ContextElementWizardPage_Key_Title;
  public static String ContextElementWizardPage_Key_Tooltip;
  public static String ContextElementWizardPage_Key_ErrorMessage;
  public static String ContextElementKeyWizardPage_Type_Title;
  public static String ContextElementKeyWizardPage_OpenTypeDialog_Title;
  public static String ContextElementValueWizardPage_Type_Title;
  public static String ContextElementValueWizardPage_Type_Tooltip;
  public static String ContextElementValueWizardPage_Value_Title;
  public static String ContextElementValueWizardPage_OpenValueTypeDialog_Title;
  public static String ContextElementValueWizardPage_ErrorMessage_EmtpyValue;
  public static String ContextElementValueWizardPage_ErrorMessage_NotValidValue;
  public static String ContextElementValueWizardPage_ErrorMessage_NotValidJavaValue;

  // Pattern library messages.
  public static String PatternLibraryWizard_Title;
  public static String PatternLibraryWizard_CreateDescription_Message;
  public static String PatternLibraryWizard_EditDescription_Message;
  public static String PatternLibraryWizardPage_Title;
  public static String PatternLibraryWizardPage_Name_Title;
  public static String PatternLibraryWizardPage_Name_Tooltip;
  public static String PatternLibraryWizardPage_Name_ErrorMessage;
  public static String PatternLibraryProductionSequenceWizardPage_Title;
  public static String PatternLibraryRuntimeSequenceWizardPage_Title;
  public static String AbstractPatternLibrarySequenceWizardPage_PatternElementSelectionDialog_Title;
  public static String AbstractPatternLibrarySequenceWizardPage_PatternElementSelectionDialog_Message;

  // Pattern messages.
  public static String PatternWizard_Title;
  public static String PatternWizard_CreateDescription_Message;
  public static String PatternWizard_EditDescription_Message;
  public static String PatternWizardPage_Title;
  public static String PatternWizardPage_Name_Title;
  public static String PatternWizardPage_Name_Tooltip;
  public static String PatternWizardPage_Name_ErrorMessage;

  public static String PatternElementValidator_Name_Already_Used_ErrorMessage;
  public static String PatternElementValidator_Sibling_EndMessage;

  // Mapping messages.
  public static String MappingWizard_Title;
  public static String MappingWizard_CreateDescription_Message;
  public static String MappingWizard_EditDescription_Message;
  public static String MappingWizardPage_Title;
  public static String MappingWizardPage_Id_Title;
  public static String MappingWizardPage_Id_Tooltip;
  public static String MappingWizardPage_Id_ErrorMessage;
  public static String MappingWizardPage_Name_Title;
  public static String MappingWizardPage_Name_Tooltip;
  public static String MappingWizardPage_Name_ErrorMessage;
  public static String MappingWizardPage_FcAsSource_Title;
  public static String MappingWizardPage_FcAsSource_Tooltip;
  public static String MappingWizardPage_FcAsSource_ErrorMessage;
  public static String MappingWizardPage_FcAsTarget_Title;
  public static String MappingWizardPage_FcAsTarget_Tooltip;
  public static String MappingWizardPage_FcAsTarget_ErrorMessage;

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
