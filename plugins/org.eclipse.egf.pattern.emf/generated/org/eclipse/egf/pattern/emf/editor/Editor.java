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
package org.eclipse.egf.pattern.emf.editor;

public class Editor implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized Editor create(String lineSeparator)
  {
    nl = lineSeparator;
    Editor result = new Editor();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  /**
   * @see org.eclipse.egf.pattern.production.jet.IGenerator#generate(Object)
   */
  @SuppressWarnings({ "unchecked", "nls" })
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Start of Editor (full id = EmfLibrary/patternLibrary.1203064024097.22/Pattern.1203064069005.23).

    
// End of Editor (full id = EmfLibrary/patternLibrary.1203064024097.22/Pattern.1203064069005.23).

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
