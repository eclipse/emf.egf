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
package org.eclipse.egf.model;

import org.eclipse.egf.common.activator.EGFEclipsePlugin;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.model.productionplan.invocation.IPlatformTaskInvocation;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the ProductionPlan model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class EGFProductionPlanModelPlugin extends EMFPlugin {
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final EGFProductionPlanModelPlugin INSTANCE = new EGFProductionPlanModelPlugin();

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EGFProductionPlanModelPlugin() {
    super(new ResourceLocator[] {});
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin() {
    return plugin;
  }

  /**
   * Get the IPlatformInvocation for given EMF Resource.
   * 
   * @param uri
   * @return an {@link IPlatformTaskInvocation} instance or null if the
   *         uri is null or not associated with an
   *         IPlatformTaskInvocation
   * @generated NOT
   */
  public static IPlatformTaskInvocation getPlatformTaskInvocation(String id) {
    if (id == null || id.trim().length() == 0) {
      return null;
    }
    // locate and return the first associated IPlatformInvocation
    for (IPlatformTaskInvocation invocation : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(IPlatformTaskInvocation.class)) {
      if (invocation.getId().equals(id)) {
        return invocation;
      }
    }
    // Nothing to retrieve
    return null;
  }

  /**
   * Returns a snapshot of known IPlatformTaskInvocation
   * 
   * @return an array of IPlatformTaskInvocation
   * @generated NOT
   */
  public static IPlatformTaskInvocation[] getPlatformTaskInvocations() {
    return EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(IPlatformTaskInvocation.class);
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static class Implementation extends EGFEclipsePlugin {
    /**
     * Creates an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
