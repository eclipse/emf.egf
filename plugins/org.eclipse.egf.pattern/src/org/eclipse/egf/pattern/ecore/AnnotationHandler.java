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
package org.eclipse.egf.pattern.ecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.IDGeneratorHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternHandler.ProductionOptionsHandler;
import org.eclipse.egf.pattern.ecore.grammar.PatternLanguageLexer;
import org.eclipse.egf.pattern.ecore.grammar.PatternLanguageParser;
import org.eclipse.egf.pattern.production.jet.JETConstants;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;


/**
 * The annotation handler translates a pattern methods annotations to java code annotations.<br>
 * It also provides with a parsing of the methods annotations.
 * @author brocard
 */
public class AnnotationHandler {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AnnotationHandler.class.getPackage().getName());
  
  /**
   * Super method call prefix.
   */
  protected static final String JAVA_CODE_SUPER_CALL_PREFIX = "super."; //$NON-NLS-1$
  
  /**
   * Read file method call prefix.
   */
  protected static final String JAVA_CODE_READ_FILE_CALL_PREFIX = "org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile"; //$NON-NLS-1$
  
  /**
   * Create string builder.
   */
  protected static final String JAVA_CODE_CREATE_STRING_BUILDER = "StringBuilder builder = new StringBuilder();"; //$NON-NLS-1$
  
  /**
   * Append to string builder.
   */
  protected static final String JAVA_CODE_APPEND_TO_STRING_BUILDER = "builder.append"; //$NON-NLS-1$
  
  /**
   * Return string builder result.
   */
  protected static final String JAVA_CODE_GET_STRING_BUILDER_RESULT = "return builder.toString();"; //$NON-NLS-1$
  
  /**
   * Operation annotation body.
   */
  protected static final String OPERATION_ANNOTATION_BODY = "body"; //$NON-NLS-1$
  
  /**
   * UID annotation source.
   */
  protected static final String UID_ANNOTATION_SOURCE = "http://www.eclipse.org/egf/1.0.0/uid"; //$NON-NLS-1$
  
  /**
   * Java code annotation source.
   */
  protected static final String JAVA_CODE_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel"; //$NON-NLS-1$
  
  /**
   * Pattern code annotation source.
   */
  public static final String PATTERN_CODE_ANNOTATION_SOURCE = "http://www.eclipse.org/egf/1.0.0/Pattern"; //$NON-NLS-1$
  
  /**
   * Pattern production annotation source.
   */
  public static final String PATTERN_PRODUCTION_ANNOTATION_SOURCE = "http://www.eclipse.org/egf/1.0.0/Pattern/production"; //$NON-NLS-1$
  
  /**
   * Pattern production path annotation body.
   */
  public static final String PATTERN_PRODUCTION_ANNOTATION_BODY_PATH = "Path"; //$NON-NLS-1$
  
  /**
   * Pattern production compilation annotation body.
   */
  public static final String PATTERN_PRODUCTION_ANNOTATION_BODY_COMPILATION = "Compilation"; //$NON-NLS-1$
  
  /**
   * Pattern production buffer modification annotation body.
   */
  public static final String PATTERN_PRODUCTION_ANNOTATION_BODY_BUFFER_MODIFICATION = "BufferModification"; //$NON-NLS-1$
  
  /**
   * Pattern method id prefix.
   */
  protected static final String PATTERN_METHOD_ID_PREFIX = "PatternMethod"; //$NON-NLS-1$

  /**
   * Get abstract syntax tree out of given pattern code.
   * @param patternCode_p
   * @return
   */
  protected CommonTree getTree(String patternCode_p) {
    CommonTree result = null;
    // Try and get the abstract syntax tree out of the pattern code.
    PatternLanguageLexer lexer = new PatternLanguageLexer(new ANTLRStringStream(patternCode_p));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    PatternLanguageParser parser = new PatternLanguageParser(tokens);
    try {
      // Parse pattern code and get the tree.
      result = (CommonTree) parser.call().getTree();
    } catch (RecognitionException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("AnnotationHandler.getTree(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return result;
  }

  /**
   * Get ordered list of pattern code actions for given pattern operation.
   * @param operation_p
   * @return List of (action, parameter) couples.
   */
  public List<Couple<String, String>> getOrderedActionsFor(EOperation operation_p) {
    List<Couple<String, String>> actions = new ArrayList<Couple<String, String>>(0);
    // Precondition.
    if (null == operation_p) {
      return actions;
    }
    // Get pattern code.
    String patternCode = getPatternCode(operation_p);
    // Precondition.
    if (null == patternCode) {
      return actions;
    }
    CommonTree tree = getTree(patternCode);
    // Explore the actions tree, and fill given list accordingly (as the tree is being explored).
    explore(tree, actions);
    return actions;
  }

  /**
   * Get pattern IDs that are called through this operation.<br>
   * Only applicable to the generate method.
   * @param operation_p
   * @return An empty list of String if given method is null or is not the generate method or no external pattern is called.
   * A list of called patterns full IDs otherwise.
   */
  @SuppressWarnings("unchecked")
  public List<String> getCalledPatternIDs(EOperation operation_p) {
    // Precondition.
    if (null == operation_p) {
      return Collections.EMPTY_LIST;
    }
    List<Couple<String, String>> orderedActions = getOrderedActionsFor(operation_p);
    List<String> result = new ArrayList<String>(0);
    for (Couple<String, String> action : orderedActions) {
      // Get call to another pattern.
      if (PatternConstants.PC_TAG_PATTERN.equals(action.getKey())) {
        result.add(action.getValue());
      }
    }
    return result;
  }

  /**
   * Replace old parameter value with new one, everywhere it is used in given actions list.
   * @param oldParameterValue_p
   * @param newParameterValue_p As a result, given actions list remains unmodified, but its contained actions are (unless no modification happened).
   */
  public void replaceParameter(String oldParameterValue_p, String newParameterValue_p, List<Couple<String, String>> actions_p) {
    // Preconditions.
    if ((null == actions_p) || (null == oldParameterValue_p) || (null == newParameterValue_p)) {
      return;
    }
    // Iterate through actions.
    for (Couple<String, String> action : actions_p) {
      // Replace old value with new one.
      if (oldParameterValue_p.equals(action.getValue())) {
        action.setValue(newParameterValue_p);
      }
    }
  }

  /**
   * Remove actions using given parameter from given actions list.
   * @param parameterValue_p
   * @param actions_p
   * @return {@link List} of removed actions.
   * @deprecated
   */
  public List<Couple<String, String>> removeActionsFor(String parameterValue_p, List<Couple<String, String>> actions_p) {
    if ((null == parameterValue_p) || (null == actions_p) || actions_p.isEmpty()) {
      return null;
    }
    // Clone actions list.
    List<Couple<String, String>> clonedActions = new ArrayList<Couple<String, String>>(0);
    clonedActions.addAll(actions_p);
    // Iterate through actions.
    for (Couple<String, String> action : clonedActions) {
      // If parameter value matches, then remove action from given list.
      if (parameterValue_p.equals(action.getValue())) {
        actions_p.remove(action);
      }
    }
    // Retain removed actions.
    clonedActions.removeAll(actions_p);
    return clonedActions;
  }

  /**
   * Recompute pattern code annotation for given method using given actions.<br>
   * As a result, java code annotation is removed, and is to be recomputed.
   * @param operation_p
   * @param actions_p
   */
  public void recomputeAnnotationFromActions(EOperation operation_p, List<Couple<String, String>> actions_p) {
    // Preconditions.
    if ((null == operation_p) || (null == actions_p)) {
      return;
    }
    // Clear recomputed annotations.
    List<EAnnotation> keptAnnotations = Collections.singletonList(operation_p.getEAnnotation(UID_ANNOTATION_SOURCE));
    operation_p.getEAnnotations().retainAll(keptAnnotations);
    // Reconstruct pattern code.
    for (Couple<String, String> action : actions_p) {
      String actionType = action.getKey();
      String actionParameter = action.getValue();
      if (PatternConstants.PC_TAG_CALL.equals(actionType)) {
        // Call to a method call.
        addCallMethodPatternCode(operation_p, actionParameter);
      } else if (PatternConstants.PC_TAG_PATTERN.equals(actionType)) {
        // Call to another pattern.
        addGenerateOtherPatternPatternCode(operation_p, actionParameter);
      } else if (PatternConstants.PC_TAG_READ.equals(actionType)) {
        // Call to read template file.
        addReadFilePatternCode(operation_p, actionParameter);
      } else if (PatternConstants.PC_TAG_SUPER.equals(actionType)) {
        // Call to super method.
        addSuperMethodCallPatternCode(operation_p, actionParameter);
      }
    }
  }

  /**
   * Add UID annotation to given operation.
   * @param operation_p
   * @return String, the UID set for this operation, null if given operation is null.
   */
  public String addUidAnnotation(EOperation operation_p) {
    String result = null;
    // Precondition.
    if (null == operation_p) {
      return result;
    }
    // Get existing one, if any.
    EAnnotation annotation = operation_p.getEAnnotation(UID_ANNOTATION_SOURCE);
    if (null == annotation) {
      annotation = EcoreFactory.eINSTANCE.createEAnnotation();
      // Add it to operation.
      operation_p.getEAnnotations().add(annotation);
      annotation.setSource(UID_ANNOTATION_SOURCE);
    }
    // Create and set UID.
    result = IDGeneratorHelper.generatePrefixUID(PATTERN_METHOD_ID_PREFIX);
    annotation.getDetails().put(OPERATION_ANNOTATION_BODY, result);
    return result;
  }

  /**
   * Add/replace pattern production annotation based on given production handler values.
   * @param pattern_p
   * @param productionHandler_p
   * @return
   */
  public boolean addProductionAnnotation(Pattern pattern_p, ProductionOptionsHandler productionHandler_p) {
    boolean result = false;
    // Preconditions.
    if ((null == pattern_p) || (null == productionHandler_p)) {
      return result;
    }
    // Get annotation.
    EAnnotation annotation = pattern_p.getEAnnotation(PATTERN_PRODUCTION_ANNOTATION_SOURCE);
    // None existed, create a new one.
    if (null == annotation) {
      annotation = EcoreFactory.eINSTANCE.createEAnnotation();
      annotation.setSource(PATTERN_PRODUCTION_ANNOTATION_SOURCE);
      // Add it to pattern.
      pattern_p.getEAnnotations().add(annotation);
    }
    // Add/update the different production options.
    // The produced template relative path.
    EMap<String, String> details = annotation.getDetails();
    details.put(PATTERN_PRODUCTION_ANNOTATION_BODY_PATH, productionHandler_p.getPatternTemplatePath());
    // The compilation flag.
    details.put(PATTERN_PRODUCTION_ANNOTATION_BODY_COMPILATION, Boolean.toString(productionHandler_p.shouldCompileTemplate()));
    // The buffer modification flag.
    details.put(PATTERN_PRODUCTION_ANNOTATION_BODY_BUFFER_MODIFICATION, Boolean.toString(productionHandler_p.shouldModifyBuffer()));
    result = true;
    return result;
  }

  /**
   * Remove production annotation from given pattern, if any.
   * @param pattern_p
   * @return Removed annotation, or null if given pattern is null or is not containing such an annotation.
   */
  public EAnnotation removeProductionAnnotation(Pattern pattern_p) {
    EAnnotation result = null;
    // Precondition.
    if (null == pattern_p) {
      return result;
    }
    result = pattern_p.getEAnnotation(PATTERN_PRODUCTION_ANNOTATION_SOURCE);
    if (null != result) {
      pattern_p.getEAnnotations().remove(result);
    }
    return result;
  }

  /**
   * Get operation UID.
   * @param operation_p
   * @return null if given operation is null.
   */
  public String getUid(EOperation operation_p) {
    String result = null;
    // Precondition.
    if (null == operation_p) {
      return result;
    }
    // Get UID, if any.
    EAnnotation uidAnnotation = operation_p.getEAnnotation(UID_ANNOTATION_SOURCE);
    if (null != uidAnnotation) {
      result = uidAnnotation.getDetails().get(OPERATION_ANNOTATION_BODY);
    }
    return result;
  }

  /**
   * Get a couple composed of the top action (and its parameter) of given tree.
   * @param tree_p
   * @return Key = action name, Value = parameter.
   */
  protected Couple<String, String> getActionAndParameter(Tree tree_p) {
    // Precondition.
    if (null == tree_p) {
      return null;
    }
    // Get action type (ie action name).
    String actionType = tree_p.getText();
    // Get action parameter, if any.
    String actionParameter = getFirstChild(tree_p);
    return new Couple<String, String>(actionType, actionParameter);
  }

  /**
   * Explore current tree level, and fill given pattern code actions list accordingly.
   * @param tree_p
   * @param actions_p
   */
  protected void explore(Tree tree_p, List<Couple<String, String>> actions_p) {
    Couple<String, String> currentAction = getActionAndParameter(tree_p);
    // Precondition.
    if (null == currentAction) {
      return;
    }
    String actionType = currentAction.getKey();
    if (PatternConstants.PC_TAG_CALL.equals(actionType) || PatternConstants.PC_TAG_SUPER.equals(actionType) || PatternConstants.PC_TAG_READ.equals(actionType)
        || PatternConstants.PC_TAG_PATTERN.equals(actionType)) { // Action type must meet the pattern code grammar definition.
      actions_p.add(currentAction);
    } else { // If current node is not one of the looked for word, go-on with children.
      // Cycle through children.
      int childCount = tree_p.getChildCount();
      // Explore first-level children.
      for (int i = 0; i < childCount; i++) {
        explore(tree_p.getChild(i), actions_p);
      }
    }
  }

  /**
   * Translate annotations from pattern code to java code for given pattern operations.
   * @param operations_p
   * @return true if successful, false otherwise.
   */
  public boolean translateAnnotations(List<EOperation> operations_p) {
    boolean result = true;
    // Preconditions.
    if ((null == operations_p) || operations_p.isEmpty()) {
      return result;
    }
    // Iterate over given operations.
    for (EOperation operation : operations_p) {
      result &= doTranslateAnnotation(operation);
    }
    return result;
  }

  /**
   * Is given operation referencing pattern code ?
   * @param operation_p
   * @return
   */
  public boolean hasPatternCode(EOperation operation_p) {
    return (null != getPatternCode(operation_p));
  }

  /**
   * Do translate annotation for given operation.
   * @param operation_p
   * @return
   */
  protected boolean doTranslateAnnotation(EOperation operation_p) {
    // By default, no translation is a successful one.
    boolean result = true;
    // Get pattern code.
    String patternCode = getPatternCode(operation_p);
    // Precondition.
    if (null == patternCode) {
      return result;
    }
    // Initialize java code.
    initializeJavaCode(operation_p);
    // Try and get the abstract syntax tree out of the pattern code.
    CommonTree tree = getTree(patternCode);
    if (null != tree) {
      exploreAndTranslate(tree, operation_p);
    }
    // Always try to return a correct piece of code.
    finalizeJavaCode(operation_p);
    return result;
  }

  /**
   * Explore annotation abstract syntax tree and translate accordingly.
   * @param tree_p
   * @param operation_p
   */
  protected void exploreAndTranslate(Tree tree_p, EOperation operation_p) {
    Couple<String, String> action = getActionAndParameter(tree_p);
    // Precondition.
    if (null == action) {
      return;
    }
    // Get action type (ie action name).
    String actionType = action.getKey();
    // Get action parameter, if any.
    String actionParameter = action.getValue();
    if (PatternConstants.PC_TAG_CALL.equals(actionType)) { // CALL code ?
      addCallMethodJavaCode(operation_p, actionParameter);
    } else if (PatternConstants.PC_TAG_SUPER.equals(actionType)) { // SUPER code ?
      addSuperMethodCallJavaCode(operation_p, actionParameter);
    } else if (PatternConstants.PC_TAG_READ.equals(actionType)) { // READ code ?
      addReadFileJavaCode(operation_p, actionParameter);
    } else if (PatternConstants.PC_TAG_PATTERN.equals(actionType)) {
      addGenerateOtherPatternJavaCode(operation_p, actionParameter);
    } else { // If current node is not one of the looked for word, go-on with children.
      int childCount = tree_p.getChildCount();
      // Explore first-level children.
      for (int i = 0; i < childCount; i++) {
        exploreAndTranslate(tree_p.getChild(i), operation_p);
      }
    }
  }

  /**
   * Get first child of given tree as a string.
   * @param tree_p
   * @return null if none could be found.
   */
  protected String getFirstChild(Tree tree_p) {
    String result = null;
    if ((null != tree_p) && (0 < tree_p.getChildCount())) {
      result = tree_p.getChild(0).getText();
    }
    return result;
  }

  /**
   * Get pattern code for given operation.
   * @param operation_p
   * @return null if no code could be found.
   */
  protected String getPatternCode(EOperation operation_p) {
    // Do not force creation, if no pattern code annotation could be found.
    EAnnotation patternCodeAnnotation = getOrCreatePatternCodeAnnotation(operation_p, false);
    // Precondition.
    if (null == patternCodeAnnotation) {
      return null;
    }
    // Get existing pattern code.
    return patternCodeAnnotation.getDetails().get(OPERATION_ANNOTATION_BODY);
  }

  /**
   * Initialize java code for given operation.<br>
   * It does create a new java code annotation, and add string builder creation code.
   * @param operation_p
   */
  protected void initializeJavaCode(EOperation operation_p) {
    // Precondition.
    if (null == operation_p) {
      return;
    }
    // Done through a code appender.
    new UnbufferedJavaCodeAppender() {
      /**
       * @see org.eclipse.egf.pattern.ecore.AnnotationHandler.JavaCodeAppender#getCodeAnnotation(org.eclipse.emf.ecore.EOperation)
       */
      @Override
      protected EAnnotation getCodeAnnotation(EOperation operation) {
        // First of all, remove possibly existing java annotation.
        EAnnotation javaCodeAnnotation = operation.getEAnnotation(JAVA_CODE_ANNOTATION_SOURCE);
        operation.getEAnnotations().remove(javaCodeAnnotation);
        // Then behave as expected.
        return super.getCodeAnnotation(operation);
      }

      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Add string builder creation code.
        existingCode_p.append(JAVA_CODE_CREATE_STRING_BUILDER);
      }
    }.appendCode(operation_p);
  }

  /**
   * Finalize java code for given operation.<br>
   * Adds string builder return code.
   * @param operation_p
   */
  protected void finalizeJavaCode(EOperation operation_p) {
    // Precondition.
    if (null == operation_p) {
      return;
    }
    // Done through a code appender.
    new UnbufferedJavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Add string builder return result code.
        existingCode_p.append(JAVA_CODE_GET_STRING_BUILDER_RESULT);
      }
    }.appendCode(operation_p);
  }

  /**
   * Add generate identified pattern (pattern code) for given operation and pattern full id.
   * @param operation_p
   * @param patternFullId_p
   */
  public void addGenerateOtherPatternPatternCode(EOperation operation_p, final String patternFullId_p) {
    // Preconditions.
    if ((null == operation_p) || (null == patternFullId_p)) {
      return;
    }
    // Done through a code appender.
    new PatternCodeAppender() {
      @Override
      protected String getOperationName() {
        return PatternConstants.PC_TAG_PATTERN;
      }

      @Override
      protected String getParameter() {
        return patternFullId_p;
      }
    }.appendCode(operation_p);
  }

  /**
   * TODO Guillaume<br>
   * Specific to JET templates.<br>
   * Add generate identified pattern (java code) for given operation and pattern full id.
   * @param operation_p
   * @param patternFullId_p
   */
  protected void addGenerateOtherPatternJavaCode(EOperation operation_p, final String patternFullId_p) {
    // Precondition.
    if ((null == operation_p) || (null == patternFullId_p)) {
      return;
    }
    // Add JET start mark-up.
    new JavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Very specific to JET.
        existingCode_p.append(JETConstants.EXTERNAL_USE_JET_MARKUP_START);
      }
    }.appendCode(operation_p);
    // Done through a code appender.
    new JavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Resulting code looks like : "<%stringBuffer.append(com.thalesgroup.*.PatternExecutionHelper.invokePattern("pattern full id", argument));%>"
        // Specific to JET for stringBuffer is a JET variable.
        existingCode_p.append(ICommonConstants.QUOTE_CHARACTER).append("stringBuffer.append").append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER); //$NON-NLS-1$
        existingCode_p.append(getCallOtherPatternTemplateCode(patternFullId_p)).append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER);
        existingCode_p.append(ICommonConstants.SEMICOLON_CHARACTER).append(ICommonConstants.QUOTE_CHARACTER);
      }
    }.appendCode(operation_p);
    // Add JET end mark-up.
    new JavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Very specific to JET.
        existingCode_p.append(JETConstants.EXTERNAL_USE_JET_MARKUP_END);
      }
    }.appendCode(operation_p);
  }

  /**
   * TODO Guillaume<br>
   * Specific to JET templates.<br>
   * Get call to another pattern template code.
   * @param patternFullId_p The pattern to call full id.
   * @return
   */
  protected String getCallOtherPatternTemplateCode(String patternFullId_p) {
    // Specific to JET for argument is a JET variable.
    return StringHelper
        .formatMessage(
                       "org.eclipse.egf.pattern.execution.PatternExecutionHelper.invokePattern(\\\"{0}\\\", argument)", new Object[] { patternFullId_p }); //$NON-NLS-1$
  }

  /**
   * Add read file (pattern code) for given operation and file relative path.
   * @param operation_p
   * @param fileRelativePath_p
   */
  public void addReadFilePatternCode(EOperation operation_p, final String fileRelativePath_p) {
    // Preconditions.
    if ((null == operation_p) || (null == fileRelativePath_p)) {
      return;
    }
    // Done through a code appender.
    new PatternCodeAppender() {
      @Override
      protected String getOperationName() {
        return PatternConstants.PC_TAG_READ;
      }

      @Override
      protected String getParameter() {
        return fileRelativePath_p;
      }
    }.appendCode(operation_p);
  }

  /**
   * Add read file (java code) for given operation and file relative path.
   * @param operation_p
   * @param fileRelativePath_p
   */
  protected void addReadFileJavaCode(EOperation operation_p, final String fileRelativePath_p) {
    // Preconditions.
    if ((null == operation_p) || (null == fileRelativePath_p)) {
      return;
    }
    // Done through a code appender.
    new JavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Resulting code looks like : 'com.thalesgroup.*.TemplateHelper.readTemplateFile("fileRelativePath");'
        existingCode_p.append(JAVA_CODE_READ_FILE_CALL_PREFIX).append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
        existingCode_p.append(ICommonConstants.QUOTE_CHARACTER).append(fileRelativePath_p).append(ICommonConstants.QUOTE_CHARACTER);
        existingCode_p.append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER);
      }
    }.appendCode(operation_p);
  }

  /**
   * Add call method (pattern code) for given operation and method name.
   * @param operation_p
   * @param methodName_p
   */
  public void addCallMethodPatternCode(EOperation operation_p, final String methodName_p) {
    // Precondition.
    if ((null == operation_p) || (null == methodName_p)) {
      return;
    }
    // Done through a code appender.
    new PatternCodeAppender() {
      @Override
      protected String getOperationName() {
        return PatternConstants.PC_TAG_CALL;
      }

      @Override
      protected String getParameter() {
        return methodName_p;
      }
    }.appendCode(operation_p);
  }

  /**
   * Add call method (java code) for given operation and method name.
   * @param operation_p
   * @param methodName_p
   */
  protected void addCallMethodJavaCode(EOperation operation_p, final String methodName_p) {
    // Preconditions.
    if ((null == operation_p) || (null == methodName_p)) {
      return;
    }
    // Done through a code appender.
    new JavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Resulting java code looks like : 'myMethodName();'
        existingCode_p.append(methodName_p).append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER).append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER);
      }
    }.appendCode(operation_p);
  }

  /**
   * Add call to super method (pattern code) for given operation and method name.
   * @param operation_p
   * @param methodName_p
   */
  public void addSuperMethodCallPatternCode(EOperation operation_p, final String methodName_p) {
    // Precondition.
    if (null == operation_p) {
      return;
    }
    // Done through a code appender.
    new PatternCodeAppender() {
      @Override
      protected String getOperationName() {
        return PatternConstants.PC_TAG_SUPER;
      }

      @Override
      protected String getParameter() {
        return methodName_p;
      }
    }.appendCode(operation_p);
  }

  /**
   * Add call to super method (java code) for given operation and method name.
   * @param operation_p
   * @param methodName_p Can be null, the given operation name is used instead.
   */
  protected void addSuperMethodCallJavaCode(EOperation operation_p, String methodName_p) {
    // Precondition.
    if (null == operation_p) {
      return;
    }
    // Get method name.
    final String[] methodName = new String[] { methodName_p };
    // By default, there is no parameters to the super call.
    final List<EParameter> parametersList = new ArrayList<EParameter>(0);
    // No method name, make a super call to override method.
    if (null == methodName_p) {
      // Method name is the same as currently handled operation.
      methodName[0] = operation_p.getName();
      // And parameters are similar too.
      parametersList.addAll(operation_p.getEParameters());
    }
    // Done through a code appender.
    new JavaCodeAppender() {
      @Override
      protected void appendNewOperation(StringBuilder existingCode_p) {
        // Resulting java code looks like : 'super.myMethodName(methodParameters);'
        existingCode_p.append(JAVA_CODE_SUPER_CALL_PREFIX).append(methodName[0]).append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
        // Add parameters, super parameters should be the same, so there should be no issue there.
        for (Iterator<EParameter> parameters = parametersList.iterator(); parameters.hasNext();) {
          existingCode_p.append(parameters.next().getName());
          // Append comma after parameter if there is a following parameter.
          if (parameters.hasNext()) {
            existingCode_p.append(ICommonConstants.COMMA_CHARACTER);
          }
        }
        existingCode_p.append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER);
      }
    }.appendCode(operation_p);
  }

  /**
   * Get or create java code annotation for given operation.
   * @param operation_p
   * @return
   */
  protected EAnnotation getOrCreateJavaCodeAnnotation(EOperation operation_p) {
    return getOrCreateAnnotation(operation_p, JAVA_CODE_ANNOTATION_SOURCE, true);
  }

  /**
   * Get or create pattern code annotation for given operation.<br>
   * If creation flag is set to false, then no creation will be attempted if no annotation could be found.
   * @param operation_p
   * @param forceCreation_p
   * @return
   */
  protected EAnnotation getOrCreatePatternCodeAnnotation(EOperation operation_p, boolean forceCreation_p) {
    return getOrCreateAnnotation(operation_p, PATTERN_CODE_ANNOTATION_SOURCE, forceCreation_p);
  }

  /**
   * Get annotation for given operation and source.<br>
   * If none exists, and force creation flag is set to true, create a new one that matches these parameters.
   * @param operation_p
   * @param sourceAnnotation_p
   * @param forceCreation_p Should an annotation be created if none could be found ?
   * @return A not null annotation.
   */
  protected EAnnotation getOrCreateAnnotation(EOperation operation_p, String sourceAnnotation_p, boolean forceCreation_p) {
    EAnnotation result = null;
    // Preconditions.
    if ((null == operation_p) && (null == sourceAnnotation_p)) {
      return result;
    }
    result = operation_p.getEAnnotation(sourceAnnotation_p);
    if ((null == result) && forceCreation_p) {
      result = EcoreFactory.eINSTANCE.createEAnnotation();
      result.setSource(sourceAnnotation_p);
      operation_p.getEAnnotations().add(result);
    }
    return result;
  }

  /**
   * Append operation to given string builder of pattern code.
   * @param operationName_p Operation to use.
   * @param parameter_p Operation parameter. Always a {@link String}. May be null.
   * @param existingCode_p a not null {@link StringBuilder} containing existing pattern code.
   */
  protected void doAppendPatternCode(String operationName_p, String parameter_p, StringBuilder existingCode_p) {
    // Preconditions.
    if ((null == operationName_p) || (null == existingCode_p)) {
      return;
    }
    // Fill up content.
    existingCode_p.append(operationName_p);
    // Add parameters.
    existingCode_p.append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
    if (null != parameter_p) {
      existingCode_p.append(parameter_p);
    }
    // End call.
    existingCode_p.append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER).append(ICommonConstants.SEMICOLON_CHARACTER);
  }

  /**
   * Annotation code appender.<br>
   * Adds new code as an annotation to a specified operation.<br>
   * Not dependent on the type of code to append.
   * @author brocard
   */
  protected abstract class AnnotationCodeAppender {
    /**
     * Append new code to given operation.<br>
     * This is done through a specific code annotation.
     * @param operation_p
     */
    public void appendCode(EOperation operation_p) {
      EAnnotation annotation = getCodeAnnotation(operation_p);
      // Get existing code.
      String existingContent = annotation.getDetails().get(OPERATION_ANNOTATION_BODY);
      // Create string builder on existing code, or new one if none exists.
      StringBuilder resultingCode = null;
      if (null != existingContent) {
        resultingCode = new StringBuilder(existingContent);
      } else {
        resultingCode = new StringBuilder();
      }
      // Append code to existing one.
      doAppendCode(resultingCode);
      // Replace code with new one.
      annotation.getDetails().put(OPERATION_ANNOTATION_BODY, resultingCode.toString());
    }

    /**
     * Get the annotation that is/will be containing the code.
     * @param operation_p
     * @return
     */
    protected abstract EAnnotation getCodeAnnotation(EOperation operation_p);

    /**
     * Append new code to existing one.
     * @param existingCode_p
     */
    protected abstract void doAppendCode(StringBuilder existingCode_p);
  }

  /**
   * Pattern code appender to existing pattern operation.
   * @author brocard
   */
  protected abstract class PatternCodeAppender extends AnnotationCodeAppender {
    /**
     * @see org.eclipse.egf.pattern.ecore.AnnotationHandler.AnnotationCodeAppender#doAppendCode(java.lang.StringBuilder)
     */
    @Override
    protected void doAppendCode(StringBuilder existingCode_p) {
      doAppendPatternCode(getOperationName(), getParameter(), existingCode_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ecore.AnnotationHandler.AnnotationCodeAppender#getCodeAnnotation(org.eclipse.emf.ecore.EOperation)
     */
    @Override
    protected EAnnotation getCodeAnnotation(EOperation operation_p) {
      // Get the annotation that contains the pattern code for given operation.
      return getOrCreatePatternCodeAnnotation(operation_p, true);
    }

    /**
     * Get operation name to add.
     * @return
     */
    protected abstract String getOperationName();

    /**
     * Get operation parameter to add.
     * @return
     */
    protected abstract String getParameter();
  }

  /**
   * Java code append to existing pattern operation code.<br>
   * This appender always encapsulate added code within a call to string builder.<br>
   * Thus the specified code must be compatible with an insertion within a string builder.
   * @author brocard
   */
  protected abstract class JavaCodeAppender extends AnnotationCodeAppender {
    /**
     * @see org.eclipse.egf.pattern.ecore.AnnotationHandler.AnnotationCodeAppender#doAppendCode(java.lang.StringBuilder)
     */
    @Override
    protected void doAppendCode(StringBuilder existingCode_p) {
      existingCode_p.append(JAVA_CODE_APPEND_TO_STRING_BUILDER).append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
      appendNewOperation(existingCode_p);
      existingCode_p.append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER).append(ICommonConstants.SEMICOLON_CHARACTER).append(ICommonConstants.EOL_CHARACTER);
    }

    /**
     * @see org.eclipse.egf.pattern.ecore.AnnotationHandler.AnnotationCodeAppender#getCodeAnnotation(org.eclipse.emf.ecore.EOperation)
     */
    @Override
    protected EAnnotation getCodeAnnotation(EOperation operation_p) {
      return getOrCreateJavaCodeAnnotation(operation_p);
    }

    /**
     * Append new code to existing one.<br>
     * No specific layout is required here (even though the correctness is mandatory).
     * @return
     */
    protected abstract void appendNewOperation(StringBuilder existingCode_p);
  }

  /**
   * A java code appender that is not prefixed by a call to the string builder.<br>
   * Used for appending string builder creation and getting string builder resulting string.
   * @author brocard
   */
  protected abstract class UnbufferedJavaCodeAppender extends JavaCodeAppender {
    /**
     * @see org.eclipse.egf.pattern.ecore.AnnotationHandler.JavaCodeAppender#doAppendCode(java.lang.StringBuilder)
     */
    @Override
    protected void doAppendCode(StringBuilder existingCode_p) {
      appendNewOperation(existingCode_p);
      existingCode_p.append(ICommonConstants.EOL_CHARACTER);
    }
  }
  
}
