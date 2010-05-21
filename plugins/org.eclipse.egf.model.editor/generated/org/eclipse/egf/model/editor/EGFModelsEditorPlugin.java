/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.editor;

import org.eclipse.egf.common.ui.activator.EGFEclipseUIPlugin;
import org.eclipse.egf.model.edit.EGFModelsEditPlugin;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * This is the central singleton for the Fcore editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public final class EGFModelsEditorPlugin extends EMFPlugin {
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final EGFModelsEditorPlugin INSTANCE = new EGFModelsEditorPlugin();

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EGFModelsEditorPlugin() {
    super(new ResourceLocator[] { EcoreEditPlugin.INSTANCE, EGFModelsEditPlugin.INSTANCE, EGFModelEditPlugin.INSTANCE, });
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the singleton instance.
   * @generated
   */
  @Override
  public ResourceLocator getPluginResourceLocator() {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin() {
    return plugin;
  }

  /**
   * 
   * Returns the currently active window for this workbench (if any). Returns
   * <code>null</code> if there is no active workbench window. Returns
   * <code>null</code> if called from a non-UI thread.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the active workbench window, or <code>null</code> if there is
   *         no active workbench window or if called from a non-UI thread
   * @generated NOT
   */
  public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return getPlugin().getWorkbench().getActiveWorkbenchWindow();
  }

  /**
   * Returns the currently active shell for this workbench (if any).
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return the active workbench shell.
   * @generated NOT
   */
  public static Shell getActiveWorkbenchShell() {
    IWorkbenchWindow window = getActiveWorkbenchWindow();
    if (window != null) {
      return window.getShell();
    }
    return null;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public static class Implementation extends EGFEclipseUIPlugin {
    /**
     * Creates an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Implementation() {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }

  }

}