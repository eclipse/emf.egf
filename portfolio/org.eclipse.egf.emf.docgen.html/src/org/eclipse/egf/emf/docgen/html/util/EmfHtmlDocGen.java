/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.docgen.html.util;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * @author Benoit Langlois
 * 
 */

public class EmfHtmlDocGen {

  private static final String UNKNOWN_ELEMENT = "unknown"; //$NON-NLS-1$

  /**
   * Provides the lower and upper bounds separated by a dash character
   * 
   * @param element
   *          ETypedElement
   * @return
   */
  public static String getBounds(ETypedElement element) {
    String upperBound;

    if (element.getUpperBound() == -1)
      upperBound = "*"; //$NON-NLS-1$
    else
      upperBound = "" + element.getUpperBound(); //$NON-NLS-1$

    return element.getLowerBound() + "-" + upperBound; //$NON-NLS-1$
  }

  /**
   * Provides the name of an ENamedElement
   * 
   * @param element
   * @return
   */
  public static String getName(ENamedElement element) {
    String value = EmfHtmlDocGenConstants.EMPTY_STRING;

    if (element == null)
      return value;

    if (element.getName().trim().length() > 0)
      return element.getName();

    return value;
  }

  /**
   * Provides the html file name
   * 
   * @param element
   * @return
   */
  public static String getHtmlFileName(ENamedElement element) {

    StringBuffer value = new StringBuffer();

    if (element == null || (element.getName().trim().length() == 0)) {
      value.append(UNKNOWN_ELEMENT);
    } else {
      value.append(getName(element));
    }

    value.append(element.eClass().getName()).append(EmfHtmlDocGenConstants.DOT_STRING).append(EmfHtmlDocGenConstants.HTML_FILE_EXTENSION);

    return value.toString();
  }

}
