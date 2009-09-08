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

public class AdapterFactoryClass implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized AdapterFactoryClass create(String lineSeparator)
  {
    nl = lineSeparator;
    AdapterFactoryClass result = new AdapterFactoryClass();
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
    
// Start of AdapterFactoryClass (full id = EmfLibrary/Model/Pattern.1240215499566.34).

    
// End of AdapterFactoryClass (full id = EmfLibrary/Model/Pattern.1240215499566.34).

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
