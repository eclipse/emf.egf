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
package org.eclipse.egf.fc.doc.gen.style;

public class StyleGenerator implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized StyleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    StyleGenerator result = new StyleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "p, table, td, th {  font-family: arial, helvetica, geneva; font-size: 10pt}" + NL + "pre {  font-family: \"Courier New\", Courier, mono; font-size: 10pt; background: #EEEEEE;}" + NL + "h2 { font-family: arial, helvetica, geneva; font-size: 18pt; font-weight: bold ; line-height: 14px}" + NL + "code {  font-family: \"Courier New\", Courier, mono; font-size: 10pt}" + NL + "sup {  font-family: arial,helvetica,geneva; font-size: 10px}" + NL + "h3 {  font-family: arial, helvetica, geneva; font-size: 14pt; font-weight: bold}" + NL + "li {  font-family: arial, helvetica, geneva; font-size: 10pt}" + NL + "h1 {  font-family: arial, helvetica, geneva; font-size: 28px; font-weight: bold}" + NL + "body {  font-family: arial, helvetica, geneva; font-size: 10pt; clip:   rect(   ); margin-top: 5mm; margin-left: 3mm}" + NL + ".indextop { font-size: x-large;; font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold}" + NL + ".indexsub { font-size: xx-small;; font-family: Arial, Helvetica, sans-serif; color: #8080FF}" + NL + "a.bar:link {  text-decoration: none; color: #FFFFFF}" + NL + "a.bar:visited {  color: #FFFFFF; text-decoration: none}" + NL + "a.bar:hover {  color: #FFFFFF; text-decoration: underline}" + NL + "a.bar {  color: #FFFFFF}";
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
// Start of Style (full id = patternLibrary.1212569425341.37/Pattern.1212569465756.38).
StringBuilder pattern121256946575638BuilderSave = new StringBuilder(stringBuffer);
stringBuffer = new StringBuffer();

    stringBuffer.append(TEXT_1);
    
StringBuilder pattern121256946575638Builder = new StringBuilder(stringBuffer);
stringBuffer = new StringBuffer(pattern121256946575638BuilderSave).append(pattern121256946575638Builder);
reporter.patternExecutionFinished(pattern121256946575638Builder.toString(),"patternLibrary.1212569425341.37/Pattern.1212569465756.38",context);
// End of Style (full id = patternLibrary.1212569425341.37/Pattern.1212569465756.38).
}

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
