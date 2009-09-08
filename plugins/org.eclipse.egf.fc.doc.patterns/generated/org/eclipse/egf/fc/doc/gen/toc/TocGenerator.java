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
package org.eclipse.egf.fc.doc.gen.toc;

import org.eclipse.egf.model.*;

public class TocGenerator implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized TocGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TocGenerator result = new TocGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?NLS TYPE=\"org.eclipse.help.toc\"?>" + NL + "" + NL + "<toc label=\"FC\"" + NL + "\tlink_to=\"../org.eclipse.egf.doc.user/topics_FactoryComponents.xml#core\">" + NL + "\t<topic label=\"";
  protected final String TEXT_2 = "\"" + NL + "\t\thref=\"html/fcs/fc.html\" />" + NL + "</toc>";
  protected final String TEXT_3 = NL;

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
// Start of Toc (full id = patternLibrary.1212569425341.37/Pattern.1212570575038.70).
StringBuilder pattern121257057503870BuilderSave = new StringBuilder(stringBuffer);
StringBuilder pattern121257057503870Builder = new StringBuilder();
org.eclipse.egf.pattern.ecore.condition.IPatternCondition pattern121257057503870Condition = (org.eclipse.egf.pattern.ecore.condition.IPatternCondition) org.eclipse.egf.common.helper.ExtensionPointHelper.createExecutableExtension("org.eclipse.egf.pattern","patternCondition","patternId","patternLibrary.1212569425341.37/Pattern.1212570575038.70");
if (null != pattern121257057503870Condition) {
pattern121257057503870Condition.setContext(context);
java.util.List<org.eclipse.egf.pattern.relations.ParameterRelation> pattern121257057503870Parameters = org.eclipse.egf.pattern.ecore.PatternConditionHelper.getPatternParameters("patternLibrary.1212569425341.37/Pattern.1212570575038.70");
java.util.Map<String, org.eclipse.emf.ecore.EObject>  pattern121257057503870Result = new java.util.HashMap<String, org.eclipse.emf.ecore.EObject> ();
org.eclipse.egf.pattern.relations.ParameterRelation factoryComponentRelation = pattern121257057503870Parameters.get(0);
java.util.Collection<org.eclipse.emf.ecore.EObject> factoryComponentCollection = new org.eclipse.emf.query.statements.SELECT(new org.eclipse.emf.query.statements.FROM(resource.getContents()), new org.eclipse.emf.query.statements.WHERE(new org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition(org.eclipse.egf.common.helper.EcoreHelper.getStaticClass(factoryComponentRelation.getType()),org.eclipse.emf.query.conditions.eobjects.TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL))).execute();
for (org.eclipse.emf.ecore.EObject factoryComponentLoop : factoryComponentCollection) {
FactoryComponent factoryComponent =  (FactoryComponent) factoryComponentLoop;
if (pattern121257057503870Condition.check(factoryComponentLoop)) {
stringBuffer = new StringBuffer();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(factoryComponent.getName());
    stringBuffer.append(TEXT_2);
    
pattern121257057503870Result.put(factoryComponentRelation.getName(), factoryComponentLoop);
reporter.patternLoopExecutionFinished(stringBuffer.toString(),"patternLibrary.1212569425341.37/Pattern.1212570575038.70",context,pattern121257057503870Result);
pattern121257057503870Builder.append(stringBuffer);
}
}
}
stringBuffer = new StringBuffer(pattern121257057503870BuilderSave).append(pattern121257057503870Builder);
reporter.patternExecutionFinished(pattern121257057503870Builder.toString(),"patternLibrary.1212569425341.37/Pattern.1212570575038.70",context);
// End of Toc (full id = patternLibrary.1212569425341.37/Pattern.1212570575038.70).
}

    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
