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
package org.eclipse.egf.pattern.production.jet;

/**
 * Patterns JET specific constants.
 * @author Guillaume Brocard
 */
public interface JETConstants {
  /**
   * Start mark-up.
   */
  public static final String JET_MARKUP_START = "<%"; //$NON-NLS-1$
  public static final String EXTERNAL_USE_JET_MARKUP_START = JETConstants.class.getName() + ".JET_MARKUP_START"; //$NON-NLS-1$
  /**
   * End mark-up.
   */
  public static final String JET_MARKUP_END = "%>"; //$NON-NLS-1$
  public static final String EXTERNAL_USE_JET_MARKUP_END = JETConstants.class.getName() + ".JET_MARKUP_END"; //$NON-NLS-1$
}
