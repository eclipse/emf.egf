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
 *
 * $Id$
 */
package org.eclipse.egf.model.editor;

import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.model.edit.EGFModelsEditPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * This is the central singleton for the FactoryComponent editor plugin. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public final class EGFModelsEditorPlugin extends EMFPlugin {
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static final EGFModelsEditorPlugin INSTANCE = new EGFModelsEditorPlugin();

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EGFModelsEditorPlugin() {
    super(new ResourceLocator[] { EcoreEditPlugin.INSTANCE, EGFModelsEditPlugin.INSTANCE, });
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  @Override
  public ResourceLocator getPluginResourceLocator() {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin() {
    return plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   */
  public static class Implementation extends EclipseUIPlugin {

    /**
     * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Implementation() {
      super();
    }

    /**
     * <!-- begin-user-doc -->
     * 
     * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     *      <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void start(BundleContext context_p) throws Exception {
      super.start(context_p);
      plugin = this;
      // Force EGF Platform Plugin initialization
      EGFPlatformPlugin.getDefault().getWorkspacePluginFactoryComponents();
      // Force EGF PDE Plugin initialization
      Bundle bundleGroupBundle = Platform.getBundle("org.eclipse.egf.pde"); //$NON-NLS-1$
      if (bundleGroupBundle != null) {
        try {
          bundleGroupBundle.start(Bundle.START_TRANSIENT);
        } catch (BundleException e) {
          // Nothing to do
        }
      }
    }

    /**
     * <!-- begin-user-doc -->
     * 
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     *      <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void stop(BundleContext context_p) throws Exception {
      plugin = null;
      super.stop(context_p);
    }

  }

}
