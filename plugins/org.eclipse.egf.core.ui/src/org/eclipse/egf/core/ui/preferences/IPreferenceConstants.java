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
package org.eclipse.egf.core.ui.preferences;

/**
 * Constants used in preferences pages.
 * @author Guillaume Brocard
 */
public interface IPreferenceConstants {
  /**
   * Preference constant that identifies the domain editor used to edit domain model.
   */
  public static final String DOMAIN_EDITOR_ID = "Domain_Editor_Id"; //$NON-NLS-1$
  /**
   * Id of the Standard Ecore editor.
   */
  public static final String ECORE_EDITOR_ID = "org.eclipse.emf.ecore.presentation.EcoreEditorID"; //$NON-NLS-1$
  /**
   * Id of the Graphical Ecore editor.
   */
  public static final String GRAPHICAL_ECORE_EDITOR_ID = "org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorID"; //$NON-NLS-1$
  /**
   * Preference constant that identifies Factory Component execution mode.
   */
  public static final String FC_EXECUTION_MODE = "FactoryComponent_Execution_Mode"; //$NON-NLS-1$
  /**
   * No validation is performed when a FC is executed.
   */
  public static final String EXECUTION_WITHOUT_VALIDATION = Boolean.FALSE.toString();
  /**
   * Validation is performed just before a FC execution.
   */
  public static final String EXECUTION_WITH_PRE_VALIDATION = Boolean.TRUE.toString();
  /**
   * Preference constant that identifies Pattern execution mode.
   */
  public static final String PATTERN_EXECUTION_MODE = "Pattern_Execution_Mode"; //$NON-NLS-1$
}
