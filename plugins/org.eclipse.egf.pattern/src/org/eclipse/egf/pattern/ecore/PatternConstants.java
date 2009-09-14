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
package org.eclipse.egf.pattern.ecore;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;


/**
 * @author brocard
 */
public class PatternConstants {
  
  /**
   * Pattern generated classes base package.
   */
  public static final String PATTERN_GENERATED_BASE_PACKAGE = "org.eclipse.egf.pattern"; //$NON-NLS-1$  
  
  /**
   * Condition generated classes base package.
   */
  public static final String PATTERN_CONDITION_GENERATED_BASE_PACKAGE = "org.eclipse.egf.condition"; //$NON-NLS-1$  
  
  /**
   * Pattern generated ecore namespace URI prefix
   */
  public static final String PATTERN_GENERATED_ECORE_NS_URI_PREFIX = "http://www.eclipse.org/egf/1.0.0/Pattern/Generated/"; //$NON-NLS-1$  
    
  /**
   * Read file (pattern code tag).
   */
  public static final String PC_TAG_READ = "READ"; //$NON-NLS-1$
  
  /**
   * Call to a super method (pattern code tag).
   */
  public static final String PC_TAG_SUPER = "SUPER"; //$NON-NLS-1$
  
  /**
   * Call to a method (pattern code tag).
   */
  public static final String PC_TAG_CALL = "CALL"; //$NON-NLS-1$
  
  /**
   * Call to an other pattern generate() method (pattern code tag).
   */
  public static final String PC_TAG_PATTERN = "PATTERN"; //$NON-NLS-1$
    
  /**
   * Pattern ecore file extension.
   */
  public static final String PATTERN_MODEL_FILE_EXTENSION = "pm"; //$NON-NLS-1$
  
  /**
   * Pattern method file extension.
   */
  public static final String PATTERN_METHOD_FILE_EXTENSION = "pt"; //$NON-NLS-1$  
    
  /**
   * Generated source code folder (relative to project) path.
   */
  public static final String GENERATION_SOURCE_FOLDER = "/generated"; //$NON-NLS-1$
  
  /**
   * Generated source code folder (relative to project) relative IPath.
   */
  public static final IPath GENERATION_SOURCE_FOLDER_IPATH = new Path("generated"); //$NON-NLS-1$  
  
  /**
   * Pattern model folder.
   */
  public static final String PATTERN_MODEL_FOLDER = "/model/pattern/"; //$NON-NLS-1$
  
  /**
   * Pattern model folder relative IPath.
   */
  public static final IPath PATTERN_MODEL_FOLDER_IPATH = new Path("model").append("pattern"); //$NON-NLS-1$ //$NON-NLS-2$
  
  /**
   * Pattern generate method name.
   */
  public static final String GENERATE_METHOD_NAME = "generateBody"; //$NON-NLS-1$
  
  /**
   * Generate method parameter name.
   */
  protected static final String GENERATE_METHOD_PARAMETER_NAME = "classLoader_p"; //$NON-NLS-1$
  
  /**
   * Pattern generate pre-matching method name.
   */
  public static final String GENERATE_PRE_MATCHING_METHOD_NAME = "generatePreMatching"; //$NON-NLS-1$
  
  /**
   * Pattern generate post-matching method name.
   */
  public static final String GENERATE_POST_MATCHING_METHOD_NAME = "generatePostMatching"; //$NON-NLS-1$
  
  /**
   * Pattern generate header method name.
   */
  public static final String GENERATE_HEADER_METHOD_NAME = "generateHeader"; //$NON-NLS-1$
  
  /**
   * Pattern generate footer method name.
   */
  public static final String GENERATE_FOOTER_METHOD_NAME = "generateFooter"; //$NON-NLS-1$
  
  /**
   * Parameters handler class suffix.
   */
  public static final String CLASS_PARAMETERS_HANDLER_SUFFIX = "ParametersHandler"; //$NON-NLS-1$
  
}
