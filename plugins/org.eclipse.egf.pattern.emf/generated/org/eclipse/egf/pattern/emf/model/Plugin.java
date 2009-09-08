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
package org.eclipse.egf.pattern.emf.model;

public class Plugin implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized Plugin create(String lineSeparator)
  {
    nl = lineSeparator;
    Plugin result = new Plugin();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  /**
   * @see org.eclipse.egf.pattern.production.jet.IGenerator#generate(Object)
   */
  @SuppressWarnings({ "unchecked", "nls" })
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Start of Plugin (full id = EmfLibrary/Model/Pattern.1240217998867.152).

    
// End of Plugin (full id = EmfLibrary/Model/Pattern.1240217998867.152).

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
