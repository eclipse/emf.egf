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
package org.eclipse.egf.common.generator;

/**
 * @author fournier
 */
public interface IEgfGeneratorConstants {
  
  /**
   * Define source folder where model API are produced.
   */
  public static final String SRC_FOLDER = "src"; //$NON-NLS-1$
  
  /**
   * A path to a file that should exist in every hosting project.
   */
  public static final String PROJECT_ROOT_FILE = "/META-INF/MANIFEST.MF"; //$NON-NLS-1$
  
  /**
   * Generated util Java packages prefix.
   */
  public static final String GENERATED_UTIL_JAVA_PACKAGE_SUFFIX = ".util"; //$NON-NLS-1$
  
  /**
   * Generated implementation Java packages prefix.
   */
  public static final String GENERATED_IMPL_JAVA_PACKAGE_SUFFIX = ".impl"; //$NON-NLS-1$
  
}
