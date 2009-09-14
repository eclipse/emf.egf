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
package org.eclipse.egf.pattern.ecore.condition;

/**
 * Condition producer and contributors shared constants.
 * @author Guillaume Brocard
 */
public interface IConditionConstants {
  
  /**
   * Condition class name suffix.
   */
  public static final String CONDITION_CLASS_NAME_SUFFIX = "Condition"; //$NON-NLS-1$
  
  /**
   * Delimiter that marks the beginning of a not generated code block.
   */
  public static final String USER_CODE_BEGINNING_DELIMITER = "// begin-user-code"; //$NON-NLS-1$
  
  /**
   * Delimiter that marks the end of a not generated code block.
   */
  public static final String USER_CODE_END_DELIMITER = "// end-user-code"; //$NON-NLS-1$
  
  /**
   * Annotation constant <code>@unmodifiable</code> used to mark methods that are generated and not modifiable by developer except in a specific block delimited by
   *               {@link #USER_CODE_BEGINNING_DELIMITER} and {@link #USER_CODE_END_DELIMITER}.
   */
  public static final String UNMODIFIABLE_ANNOTATION_TAG = "@unmodifiable"; //$NON-NLS-1$
  
}