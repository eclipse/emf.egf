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
package org.eclipse.egf.tests.pattern;

public class HelloWorldGenerator implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized HelloWorldGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    HelloWorldGenerator result = new HelloWorldGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "HelloWorld !";
  protected final String TEXT_2 = NL;

  /**
   * @see org.eclipse.egf.pattern.production.jet.IGenerator#generate(Object)
   */
  @SuppressWarnings({ "unchecked", "nls" })
  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
org.eclipse.emf.ecore.resource.Resource resource = org.eclipse.egf.pattern.execution.PatternExecutionHelper.getResource(argument);
org.eclipse.egf.core.context.ProductionContext context = org.eclipse.egf.pattern.execution.PatternExecutionHelper.getContext(argument);
org.eclipse.egf.pattern.execution.IPatternExecutionReporter reporter = org.eclipse.egf.pattern.execution.PatternExecutionHelper.getExecutionReporter(argument);

    
{
// Start of HelloWorld (full id = patternLibrary.1233239207231.11/Pattern.1233239232789.12).
StringBuilder pattern123323923278912BuilderSave = new StringBuilder(stringBuffer);
stringBuffer = new StringBuffer();

    stringBuffer.append(TEXT_1);
    
StringBuilder pattern123323923278912Builder = new StringBuilder(stringBuffer);
stringBuffer = new StringBuffer(pattern123323923278912BuilderSave).append(pattern123323923278912Builder);
reporter.patternExecutionFinished(pattern123323923278912Builder.toString(),"patternLibrary.1233239207231.11/Pattern.1233239232789.12",context);
// End of HelloWorld (full id = patternLibrary.1233239207231.11/Pattern.1233239232789.12).
}

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
