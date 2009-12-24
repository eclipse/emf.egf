/**
 * <copyright>
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
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.activator.EGFEclipsePlugin;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.uri.URIHelper;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.util.NLS;

/**
 * This is the central singleton for the Types model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public final class EGFModelsPlugin extends EMFPlugin {

  /**
   * Extension point "type".
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected static final String EXTENSION_POINT_TYPE = "type"; //$NON-NLS-1$  

  /**
   * EGF Registered Types.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  private static Collection<EClass> _types;

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final EGFModelsPlugin INSTANCE = new EGFModelsPlugin();

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
   * @generated
   */
  public EGFModelsPlugin() {
    super(new ResourceLocator[] {});
  }

  /**
   * Get Types.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return an empty list if none could be found.
   * @generated NOT
   */
  public static Collection<EClass> getTypes() {
    // Lazy loading.
    if (_types == null) {
      _types = new UniqueEList<EClass>();
      ResourceSet resourceSet = new ResourceSetImpl();
      resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
      // Get EGF logger extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(getPlugin().getSymbolicName(), EXTENSION_POINT_TYPE)) {
        String id = ExtensionPointHelper.getId(configurationElement);
        // Ignore
        if (id == null || id.trim().length() == 0) {
          continue;
        }
        URI uri = null;
        // Build URI
        try {
          uri = URIHelper.getPlatformURI(ExtensionPointHelper.getNamespace(configurationElement), id.trim(), false);
        } catch (Exception e) {
          getPlugin().logError(e);
          continue;
        }
        // Load
        try {
          EObject eObject = resourceSet.getEObject(uri, true);
          if (eObject instanceof EClass == false) {
            continue;
          }
          // Analyse the super types of this EClass against the static package
          boolean isValid = false;
          for (EClass eClass : ((EClass) eObject).getEAllSuperTypes()) {
            if (TypesPackage.Literals.TYPE.equals(EMFHelper.solveAgainstStaticPackage(eClass))) {
              isValid = true;
              break;
            }
          }
          if (isValid == false) {
            getPlugin().logError(NLS.bind("Wrong Type {0}", uri.toString()));
            getPlugin().logInfo("Type should be a sub-type of Type", 1);
            getPlugin().logInfo(NLS.bind("in extension point ''{0}''", configurationElement.getName()), 1);
            getPlugin().logInfo(NLS.bind("with attribute id ''{0}''", id.trim()), 1);
            getPlugin().logInfo(NLS.bind("in bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1);
            continue;
          }
          _types.add((EClass) eObject);
        } catch (Exception e) {
          if (e.getCause() instanceof FileNotFoundException) {
            getPlugin().logError(NLS.bind("Unable to load uri {0}", uri.toString()));
            getPlugin().logInfo(NLS.bind("in extension point ''{0}''", configurationElement.getName()), 1);
            getPlugin().logInfo(NLS.bind("with attribute id ''{0}''", id.trim()), 1);
            getPlugin().logInfo(NLS.bind("in bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1);
          } else {
            getPlugin().logError(e);
          }
          continue;
        }
      }
    }
    return _types;
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
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  public static class Implementation extends EGFEclipsePlugin {
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
