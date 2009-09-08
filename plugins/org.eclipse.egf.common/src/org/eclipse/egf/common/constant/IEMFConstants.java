/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.constant;


/**
 * Define constants related to EMF constants used in plugin.xml.
 * @author Guillaume Brocard
 */
public interface IEMFConstants {
  
  /**
   * Emf generated package extension-point package child genmodel attribute.
   */
  static final String GENERATED_PACKAGE_EXTENSION_POINT_ATT_GEN_MODEL = "genModel"; //$NON-NLS-1$
  
  /**
   * Emf generated package extension-point package child uri attribute.
   */
  static final String GENERATED_PACKAGE_EXTENSION_POINT_ATT_URI = "uri"; //$NON-NLS-1$
  
  /**
   * Emf generated package extension-point package child.
   */
  static final String GENERATED_PACKAGE_EXTENSION_POINT_CHILD = "package"; //$NON-NLS-1$
  
  /**
   * Emf generated package extension point plug-in id.
   */
  static final String GENERATED_PACKAGE_EXTENSION_POINT_PLUGIN_ID = "org.eclipse.emf.ecore"; //$NON-NLS-1$
  
  /**
   * Emf generated package extension point short id.
   */
  static final String GENERATED_PACKAGE_EXTENSION_POINT_SHORT_ID = "generated_package"; //$NON-NLS-1$
  
  /**
   * Emf generated package extension-point id.
   */
  static final String GENERATED_PACKAGE_EXTENSION_POINT_FULL_ID = GENERATED_PACKAGE_EXTENSION_POINT_PLUGIN_ID + ICommonConstants.DOT_CHARACTER + GENERATED_PACKAGE_EXTENSION_POINT_SHORT_ID;
  
}
