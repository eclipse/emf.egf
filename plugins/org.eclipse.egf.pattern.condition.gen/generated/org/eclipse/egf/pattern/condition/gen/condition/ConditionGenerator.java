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
package org.eclipse.egf.pattern.condition.gen.condition;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import java.util.*;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pattern.production.GeneratedContentProducer;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.common.helper.EcoreHelper;
import org.eclipse.egf.pattern.ecore.condition.AbstractPatternCondition;
import org.eclipse.egf.pattern.ecore.condition.IConditionConstants;
import org.eclipse.egf.pattern.condition.gen.*;

public class ConditionGenerator implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized ConditionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ConditionGenerator result = new ConditionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "import ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "/**" + NL + " * Condition class implementation.<br>" + NL + " * A merge occurs each time the corresponding pattern parameters are changed.<br>" + NL + " * Both check methods are subject to merge (see associated comments).<br>" + NL + " * Any other method is left untouched as a result of the merging operation." + NL + " */" + NL + "public class ";
  protected final String TEXT_9 = " extends AbstractPatternCondition {";
  protected final String TEXT_10 = NL + "  /**" + NL + "   * Generated check method.<br>" + NL + "   * User should left this code untouched for it is lost when a merge is performed.<br>" + NL + "   * ";
  protected final String TEXT_11 = NL + "   */" + NL + "   public boolean check(Object... parameters_p) {" + NL + "     return check(";
  protected final String TEXT_12 = ");" + NL + "   }" + NL;
  protected final String TEXT_13 = NL + "  /**" + NL + "   * Check method user implementation.<br>" + NL + "   * User must implement and comment between delimiters only !<br>" + NL + "   * Public signature and comments are lost when a merge is performed.<br>" + NL + "   * ";
  protected final String TEXT_14 = NL + "   */" + NL + "   public boolean check(";
  protected final String TEXT_15 = ") {";
  protected final String TEXT_16 = NL + "     ";
  protected final String TEXT_17 = NL + "     return true;";
  protected final String TEXT_18 = NL + "     ";
  protected final String TEXT_19 = NL + "   }" + NL + "}";
  protected final String TEXT_20 = NL;

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

    stringBuffer.append(TEXT_1);
    
{
// Start of Condition (full id = patternLibrary.1213692227054.90/Pattern.1213692237160.91).
StringBuilder pattern121369223716091BuilderSave = new StringBuilder(stringBuffer);
stringBuffer = new StringBuffer();

    
// First of all, get pattern data from model path.
String modelPath = (String) context.getContextElementValue("patternModelPath", "asset.1213692164306.87"); //$NON-NLS-1$ //$NON-NLS-2$
// Test model path availability.
if (null == modelPath) {
  return ICommonConstants.EMPTY_STRING;
}
// Load pattern.
PatternData patternData = null;
try {
  patternData = new PatternHandler().load(modelPath);
} catch (Exception e_p) {
  return ICommonConstants.EMPTY_STRING;
}
// Store pattern full id.
context.addContextElement(ConditionExecutionReporter.PATTERN_FULL_ID, patternData.getPattern().getId(), ConditionExecutionReporter.PATTERN_FULL_ID, true);
// Get parameters.
List<ParameterRelation> parameters = patternData.getAllParameters();
if ((null == parameters) || parameters.isEmpty()) {
  // Suspicious call to ConditionGenerator.
  return ICommonConstants.EMPTY_STRING;
}

    
// And add package declaration.

    stringBuffer.append(TEXT_2);
    stringBuffer.append(org.eclipse.egf.pattern.ecore.PatternConstants.PATTERN_CONDITION_GENERATED_BASE_PACKAGE);
    stringBuffer.append(TEXT_3);
    
// Add imports for all parameters.
for (ParameterRelation parameterRelation : parameters) { // For (parameter import).
  EClass parameterType = parameterRelation.getType();
  String packageImportedName = EcoreHelper.getImportedPackageName(parameterType.getEPackage());
  if (null != packageImportedName) { // If (parameter imported name).
  // Append import directive.

    stringBuffer.append(TEXT_4);
    stringBuffer.append(packageImportedName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(parameterType.getName());
    stringBuffer.append(TEXT_6);
    
  } // If (parameter imported name).

    
} // For (parameter import).

    
// Add abstract pattern condition class import.

    stringBuffer.append(TEXT_7);
    stringBuffer.append(AbstractPatternCondition.class.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(GeneratedContentProducer.getConditionClassName(patternData));
    stringBuffer.append(TEXT_9);
    
// Compute methods call and signature.
String methodCall = ICommonConstants.EMPTY_STRING;
String checkImplSignature = ICommonConstants.EMPTY_STRING;
int i = 0;
for (Iterator<ParameterRelation> parametersIterator = parameters.iterator(); parametersIterator.hasNext(); i++) {
  ParameterRelation parameter = parametersIterator.next();
  String parameterType = parameter.getType().getName();
  methodCall += ICommonConstants.PARENTHESIS_OPEN_CHARACTER + parameterType + ICommonConstants.PARENTHESIS_CLOSE_CHARACTER;
  methodCall += "parameters_p[" + i + "]"; //$NON-NLS-1$ //$NON-NLS-2$
  checkImplSignature += parameterType + ICommonConstants.WHITE_SPACE_CHARACTER + parameter.getName();
  if (parametersIterator.hasNext()) {
    methodCall += ICommonConstants.COMMA_CHARACTER;
    checkImplSignature += ICommonConstants.COMMA_CHARACTER;
  }
}

    
// Add generic check method declaration.

    stringBuffer.append(TEXT_10);
    stringBuffer.append(IConditionConstants.UNMODIFIABLE_ANNOTATION_TAG);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(methodCall);
    stringBuffer.append(TEXT_12);
    
// Add specific (ie typed) check method declaration.

    stringBuffer.append(TEXT_13);
    stringBuffer.append(IConditionConstants.UNMODIFIABLE_ANNOTATION_TAG);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(checkImplSignature);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(IConditionConstants.USER_CODE_BEGINNING_DELIMITER);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(IConditionConstants.USER_CODE_END_DELIMITER);
    stringBuffer.append(TEXT_19);
    
StringBuilder pattern121369223716091Builder = new StringBuilder(stringBuffer);
stringBuffer = new StringBuffer(pattern121369223716091BuilderSave).append(pattern121369223716091Builder);
reporter.patternExecutionFinished(pattern121369223716091Builder.toString(),"patternLibrary.1213692227054.90/Pattern.1213692237160.91",context);
// End of Condition (full id = patternLibrary.1213692227054.90/Pattern.1213692237160.91).
}

    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
