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
package org.eclipse.egf.pattern.ecore.condition;

import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.EcoreHelper;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.GeneratedContentProducer;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.emf.ecore.EPackage;


/**
 * @author Guillaume Brocard
 */
public class GeneratedConditionProducer {
  
  /**
   * Check real implementation default code.
   */
  protected static final String CHECK_METHOD_IMPL_DEFAULT_IMPL =
      ") {\n" //$NON-NLS-1$ 
    + IConditionConstants.USER_CODE_BEGINNING_DELIMITER 
    + "\nreturn true;\n" //$NON-NLS-1$ 
    + IConditionConstants.USER_CODE_END_DELIMITER 
    + "\n}\n}"; //$NON-NLS-1$
  
  /**
   * Check real implementation signature prefix.
   */
  protected static final String CHECK_METHOD_IMPL_SIGNATURE_PREFIX = "protected boolean check("; //$NON-NLS-1$
  
  /**
   * Check real implementation default comments.
   */
  protected static final String CHECK_METHOD_IMPL_DEFAULT_COMMENTS =
      "/**\n* Check method user implementation.<br>\n* User must implement and comment between delimiters only !\n* Public signature and comments are lost when a merge is performed.\n* " //$NON-NLS-1$ 
    + IConditionConstants.UNMODIFIABLE_ANNOTATION_TAG 
    + "\n*/\n"; //$NON-NLS-1$
  
  /**
   * Array access to parameter number N prefix.
   */
  protected static final String PARAMETER_N_PREFIX = "parameters_p["; //$NON-NLS-1$
  
  /**
   * End of generic check method code.
   */
  protected static final String GENERIC_CHECK_METHOD_END = ");\n}\n\n"; //$NON-NLS-1$
  
  /**
   * Call to check method prefix.
   */
  protected static final String CHECK_METHOD_CALL_PREFIX = "return check("; //$NON-NLS-1$
  
  /**
   * Generic check method comments.
   */
  protected static final String GENERIC_CHECK_METHOD_COMMENTS =
      "/**\n* Generated check method.<br>\n* User should left this code untouched for it is lost when a merge is performed.\n* " //$NON-NLS-1$ 
    + IConditionConstants.UNMODIFIABLE_ANNOTATION_TAG 
    + "\n*/\n";//$NON-NLS-1$
  
  /**
   * Generic check method signature.
   */
  protected static final String GENERIC_CHECK_METHOD_SIGNATURE = 
    "public boolean check(Object... parameters_p) {\n"; //$NON-NLS-1$
  
  /**
   * Default implementation for generated condition class.
   */
  protected static final String DEFAULT_CONDITION_IMPLEMENTATION = 
      " extends " //$NON-NLS-1$ 
    + AbstractPatternCondition.class.getSimpleName() 
    + " {\n"; //$NON-NLS-1$
  
  /**
   * Class comments.
   */
  protected static final String CLASS_COMMENTS =
    "/**\n*Condition class implementation.\n*A merge occurs each time the corresponding pattern parameters are changed.\n*Both check methods are subject to merge (see associated comments).\n*Any other method is left untouched as a result of the merging operation.\n*/\n"; //$NON-NLS-1$
  
  /**
   * Class declaration prefix.
   */
  protected static final String CLASS_DECLARATION_PREFIX = "public class "; //$NON-NLS-1$
  
  /**
   * Default import for an implementation of a condition class.
   */
  protected static final String DEFAULT_CONDITION_IMPORT = 
      AbstractPatternCondition.class.getName() 
    + ";\n\n"; //$NON-NLS-1$
  
  /**
   * Import directive prefix.
   */
  protected static final String IMPORT_DIRECTIVE_PREFIX = "import "; //$NON-NLS-1$
  
  /**
   * Import suffix.
   */
  protected static final String IMPORT_DIRECTIVE_SUFFIX = ";\n"; //$NON-NLS-1$
  
  /**
   * Package declaration prefix.
   */
  protected static final String PACKAGE_DECLARATION_PREFIX = "package "; //$NON-NLS-1$
  
  /**
   * ']' character.
   */
  protected static final char SQUARE_BRACKET_CLOSING_CHARACTER = ']';

  /**
   * Get condition class expected content, without the already existing user code.<br>
   * This is the condition class as it should be by default for current pattern content.
   * @param patternData_p
   * @param parameters_p
   * @return
   */
  public static String getNewConditionClassDefaultContent(PatternData patternData_p, List<ParameterRelation> parameters_p) {
    StringBuilder result = new StringBuilder();
    // Add package declaration.
    result
      .append(PACKAGE_DECLARATION_PREFIX)
      .append(PatternConstants.PATTERN_CONDITION_GENERATED_BASE_PACKAGE);
    result
      .append(ICommonConstants.SEMICOLON_CHARACTER)
      .append(ICommonConstants.EOL_CHARACTER)
      .append(ICommonConstants.EOL_CHARACTER);
    // Add imports for all parameters.
    for (ParameterRelation parameterRelation : parameters_p) {
      EPackage parameterPackage = parameterRelation.getType().getEPackage();
      String packageImportedName = EcoreHelper.getImportedPackageName(parameterPackage);
      if (packageImportedName != null) {
        // Append import directive.
        result
          .append(IMPORT_DIRECTIVE_PREFIX)
          .append(packageImportedName)
          .append(ICommonConstants.DOT_CHARACTER)
          .append(parameterRelation.getType().getName())
          .append(IMPORT_DIRECTIVE_SUFFIX);
      }
    }
    result.append(ICommonConstants.EOL_CHARACTER);
    // Import parent interface/class.
    result
      .append(IMPORT_DIRECTIVE_PREFIX)
      .append(DEFAULT_CONDITION_IMPORT);
    // Add class declaration.
    String className = GeneratedContentProducer.getConditionClassName(patternData_p);
    result.append(CLASS_COMMENTS);
    result
      .append(CLASS_DECLARATION_PREFIX)
      .append(className)
      .append(DEFAULT_CONDITION_IMPLEMENTATION);
    // Add generic check method declaration.
    result.append(GENERIC_CHECK_METHOD_COMMENTS);
    result.append(GENERIC_CHECK_METHOD_SIGNATURE);
    result.append(CHECK_METHOD_CALL_PREFIX);
    // Parameter position.
    int i = 0;
    // True implementation signature.
    StringBuilder realImplSignature = new StringBuilder();
    for (Iterator<ParameterRelation> parameters = parameters_p.iterator(); parameters.hasNext(); i++) {
      ParameterRelation param = parameters.next();
      String paramTypeName = param.getType().getName();
      result
        .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER)
        .append(paramTypeName)
        .append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER);
      result
        .append(PARAMETER_N_PREFIX)
        .append(i)
        .append(SQUARE_BRACKET_CLOSING_CHARACTER);
      realImplSignature
        .append(paramTypeName)
        .append(ICommonConstants.WHITE_SPACE_CHARACTER)
        .append(param.getName());
      if (parameters.hasNext()) {
        result.append(ICommonConstants.COMMA_CHARACTER);
        realImplSignature.append(ICommonConstants.COMMA_CHARACTER);
      }
    }
    // Add generic check method end declaration.
    result.append(GENERIC_CHECK_METHOD_END);
    // Add real check implementation declaration.
    result.append(CHECK_METHOD_IMPL_DEFAULT_COMMENTS);
    result
      .append(CHECK_METHOD_IMPL_SIGNATURE_PREFIX)
      .append(realImplSignature.toString())
      .append(CHECK_METHOD_IMPL_DEFAULT_IMPL);
    return result.toString();
  }
  
}
