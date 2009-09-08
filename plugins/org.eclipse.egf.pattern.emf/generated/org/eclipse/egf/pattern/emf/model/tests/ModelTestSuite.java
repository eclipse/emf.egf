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
package org.eclipse.egf.pattern.emf.model.tests;

public class ModelTestSuite implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized ModelTestSuite create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelTestSuite result = new ModelTestSuite();
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
    
// Start of ModelTestSuite (full id = EmfLibrary/patternLibrary.1240228737568.98/Pattern.1240229598054.121).

    
// End of ModelTestSuite (full id = EmfLibrary/patternLibrary.1240228737568.98/Pattern.1240229598054.121).

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
