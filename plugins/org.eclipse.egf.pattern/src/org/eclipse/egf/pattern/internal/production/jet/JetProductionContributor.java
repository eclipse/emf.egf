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
package org.eclipse.egf.pattern.internal.production.jet;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;

import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;
import org.eclipse.emf.codegen.jet.JETSkeleton;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.helper.EcoreHelper;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternConditionHelper;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ecore.condition.IConditionConstants;
import org.eclipse.egf.pattern.ecore.condition.IPatternCondition;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.egf.pattern.execution.PatternExecutionHelper;
import org.eclipse.egf.pattern.production.IProductionContributor;
import org.eclipse.egf.pattern.production.TemplateType;
import org.eclipse.egf.pattern.production.jet.JETConstants;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.pattern.plugin.command.PatternTemplateExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.egf.pde.plugin.manifest.command.ManifestChangeCommandFactory;


/**
 * @author Guillaume Brocard
 */
public class JetProductionContributor implements IProductionContributor {
  
  /**
   * Generated template Java class default name suffix.
   */
  private static final String JET_SKELETON_CLASS_DEFAULT_SUFFIX = "Generator"; //$NON-NLS-1$
  
  /**
   * Jet skeleton 'imports' declaration.
   */
  private static final String JET_SKELETON_IMPORTS_DECLARATION = " imports="; //$NON-NLS-1$
  
  /**
   * Jet skeleton 'class' declaration.
   */
  private static final String JET_SKELETON_CLASS_DECLARATION = " class="; //$NON-NLS-1$
  
  /**
   * Jet skeleton 'package' declaration.
   */
  private static final String JET_SKELETON_PACKAGE_DECLARATION = " package="; //$NON-NLS-1$
  
  /**
   * Jet skeleton start mark-up.
   */
  private static final String JET_SKELETON_JSP_START = JETConstants.JET_MARKUP_START + "@ jet"; //$NON-NLS-1$
  
  /**
   * Jet generated template skeleton key for compiler options map.
   */
  private static final String JET_GENERATED_TEMPLATE_SKELETON_KEY = "skeleton"; //$NON-NLS-1$
  
  /**
   * Jet generated template skeleton path.
   */
  private static final String JET_GENERATED_TEMPLATE_SKELETON_PATH = "/org.eclipse.egf.pattern/resources/templates/generator.skeleton"; //$NON-NLS-1$
  
  /**
   * New initialized string builder (with string buffer).
   */
  private static final String NEW_INITIALIZED_STRING_BUILDER = " = new StringBuilder(stringBuffer);\n"; //$NON-NLS-1$
  
  /**
   * Declare a string builder prefix directive.
   */
  private static final String DECLARE_STRING_BUILDER = "StringBuilder "; //$NON-NLS-1$
  
  /**
   * Clear JET string buffer.
   */
  private static final String CLEAR_STRING_BUFFER = "stringBuffer = new StringBuffer();\n"; //$NON-NLS-1$
  
  /**
   * Call to new, with a space suffix.
   */
  private static final String NEW_CALL = "new "; //$NON-NLS-1$
  
  /**
   * Close java generic type usage.
   */
  private static final String CLOSE_JAVA_1_5_GENERIC_TYPE_USAGE = "> "; //$NON-NLS-1$
  
  /**
   * Assignment directive.
   */
  private static final String ASSIGNMENT_DIRECTIVE = " = "; //$NON-NLS-1$
  
  /**
   * Close method call, then new line.
   */
  private static final String JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE = ");\n"; //$NON-NLS-1$
  
  /**
   * Start a new block.
   */
  private static final String JAVA_CODE_OPEN_BLOCK = "{\n"; //$NON-NLS-1$
  
  /**
   * Close parenthesis, then start a new block.
   */
  private static final String JAVA_CODE_CLOSE_PAREN_AND_OPEN_BLOCK =
      ICommonConstants.EMPTY_STRING 
    + ICommonConstants.PARENTHESIS_CLOSE_CHARACTER
    + ICommonConstants.WHITE_SPACE_CHARACTER + JAVA_CODE_OPEN_BLOCK;
  
  /**
   * Close block java code.
   */
  private static final String JAVA_CODE_CLOSE_BLOCK = "}\n"; //$NON-NLS-1$
  
  /**
   * Jet java code end.
   */
  private static final String JAVA_CODE_END = "%>\n"; //$NON-NLS-1$
  
  /**
   * Jet java code start.
   */
  private static final String JAVA_CODE_BEGIN = "<%\n"; //$NON-NLS-1$
  
  /**
   * Set condition context Java call.
   */
  private static final String SET_CONDITION_CONTEXT_CALL = ".setContext(context);\n"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.pattern.production.IProductionContributor#createPatternMatchingTemplates(org.eclipse.egf.pattern.ecore.PatternHandler.PatternData,
   *      java.util.List)
   */
  public Couple<StringBuilder, StringBuilder> createPatternMatchingTemplates(PatternData patternData_p, List<ParameterRelation> parameters_p) {
    String patternFullId = patternData_p.getPattern().getId();
    // Replace both pre and post matching results at the same time.
    StringBuilder preMatchingResult = new StringBuilder();
    StringBuilder postMatchingResult = new StringBuilder();
    // Should buffer delegation be used ?
    boolean delegateBuffer = patternData_p.getProductionOptionsHandler().shouldModifyBuffer();
    // Open java code.
    preMatchingResult.append(JAVA_CODE_BEGIN);
    postMatchingResult.append(JAVA_CODE_BEGIN);
    // Create a new Java code block for variable names uniqueness.
    if (delegateBuffer) {
      preMatchingResult.append(JAVA_CODE_OPEN_BLOCK);
    }
    // Pattern name with first letter set to lower case.
    String patternNameToLowerFirst = StringHelper.toLowerFirst(
      StringHelper.replaceNonWordCharacters(
        patternData_p.getPattern().getShortId(), 
        null
      )
    );
    // Add pattern starting comment tag.
    preMatchingResult
      .append("// Start of ") //$NON-NLS-1$
      .append(patternData_p.getPatternLogicalName())
      .append(" (full id = ") //$NON-NLS-1$
      .append(patternFullId)
      .append(").\n"); //$NON-NLS-1$
    // Add this piece of code if buffer is to be delegated.
    String pbVariableName = null;
    String pbSaveVariableName = null;
    if (delegateBuffer) {
      // Replace string buffer with a pattern specific string builder.
      // Pattern builder variable name.
      pbVariableName = patternNameToLowerFirst + "Builder"; //$NON-NLS-1$
      // Pattern builder save variable name.
      pbSaveVariableName = pbVariableName + "Save"; //$NON-NLS-1$
      // Declare save builder and initialize it.
      preMatchingResult
        .append(DECLARE_STRING_BUILDER)
        .append(pbSaveVariableName)
        .append(NEW_INITIALIZED_STRING_BUILDER);
    }
    // Deals with parameters, if any.
    if (parameters_p != null && parameters_p.isEmpty() == false) {
      // Add this piece of code if buffer is to be delegated.
      if (delegateBuffer) {
        // Declare pattern builder and initialize it.
        preMatchingResult
          .append(DECLARE_STRING_BUILDER)
          .append(pbVariableName)
          .append(" = new StringBuilder();\n"); //$NON-NLS-1$
      }
      // EObject fully qualified name.
      String eObjectFullyQualifiedName = EObject.class.getName();
      // Pattern condition variable name.
      String pcVariableName = patternNameToLowerFirst + IConditionConstants.CONDITION_CLASS_NAME_SUFFIX;
      // Declare pattern condition class instance.
      String patternConditionInterfaceName = IPatternCondition.class.getName();
      preMatchingResult
        .append(patternConditionInterfaceName)
        .append(ICommonConstants.WHITE_SPACE_CHARACTER)
        .append(pcVariableName);
      preMatchingResult.append(ASSIGNMENT_DIRECTIVE);
      preMatchingResult
        .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER)
        .append(patternConditionInterfaceName)
        .append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER)
        .append(ICommonConstants.WHITE_SPACE_CHARACTER);
      preMatchingResult
        .append(ExtensionPointHelper.class.getName())
        .append(".createExecutableExtension("); //$NON-NLS-1$
      preMatchingResult
        .append(ICommonConstants.QUOTE_CHARACTER)
        .append(PatternActivator.getDefault().getPluginID())
        .append(ICommonConstants.QUOTE_CHARACTER);
      preMatchingResult.append(",\"patternCondition\""); //$NON-NLS-1$
      preMatchingResult.append(",\"patternId\""); //$NON-NLS-1$
      preMatchingResult
        .append(ICommonConstants.COMMA_CHARACTER)
        .append(ICommonConstants.QUOTE_CHARACTER)
        .append(patternFullId)
        .append(ICommonConstants.QUOTE_CHARACTER);
      preMatchingResult.append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE);
      // Test it.
      preMatchingResult
        .append("if (null != ") //$NON-NLS-1$
        .append(pcVariableName)
        .append(JAVA_CODE_CLOSE_PAREN_AND_OPEN_BLOCK);
      // If it's not being null, then create all query statements for the parameters.
      // First set context to the condition class.
      preMatchingResult
        .append(pcVariableName)
        .append(SET_CONDITION_CONTEXT_CALL);
      // Parameters list is not tested against nullity or emptiness.
      // It is expected that the pattern content has not changed between the generation of the condition structures and the
      // use of the pattern. If not, there has been an error during a modification (such as a re-factoring).
      String patternParametersVariableName = patternNameToLowerFirst + "Parameters"; //$NON-NLS-1$
      preMatchingResult
        .append(List.class.getName())
        .append('<')
        .append(ParameterRelation.class.getName())
        .append(CLOSE_JAVA_1_5_GENERIC_TYPE_USAGE);
      preMatchingResult.append(patternParametersVariableName);
      preMatchingResult
        .append(ASSIGNMENT_DIRECTIVE)
        .append(PatternConditionHelper.class.getName())
        .append(".getPatternParameters("); //$NON-NLS-1$
      preMatchingResult
        .append(ICommonConstants.QUOTE_CHARACTER)
        .append(patternFullId)
        .append(ICommonConstants.QUOTE_CHARACTER);
      preMatchingResult.append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE);
      // Define the tuple map result.
      String resultMapVariableName = patternNameToLowerFirst + "Result"; //$NON-NLS-1$
      String resultMapVariableGenerics = "<String, " + eObjectFullyQualifiedName + CLOSE_JAVA_1_5_GENERIC_TYPE_USAGE; //$NON-NLS-1$
      preMatchingResult
        .append(Map.class.getName())
        .append(resultMapVariableGenerics);
      preMatchingResult
        .append(ICommonConstants.WHITE_SPACE_CHARACTER)
        .append(resultMapVariableName)
        .append(ASSIGNMENT_DIRECTIVE);
      preMatchingResult
        .append(NEW_CALL)
        .append(HashMap.class.getName())
        .append(resultMapVariableGenerics)
        .append("();\n"); //$NON-NLS-1$
      // Injected in preMatchingResult in the end. Allows to cycle through parameters only one time.
      StringBuilder temporaryLoops = new StringBuilder();
      StringBuilder temporaryCondition = new StringBuilder("if (") //$NON-NLS-1$
        .append(pcVariableName)
        .append(".check("); //$NON-NLS-1$
      // Injected in postMatchingResult in the end, for the very same reason.
      StringBuilder temporaryPostLoops = new StringBuilder();
      // Create string content based on given parameters.
      int i = 0;
      for (Iterator<ParameterRelation> parameters = parameters_p.iterator(); parameters.hasNext();) {
        ParameterRelation currentParameter = parameters.next();
        // Parameter name.
        String paramName = currentParameter.getName();
        // Parameter type name.
        String paramTypeName = currentParameter.getType().getName();
        // Parameter relation variable.
        String paramRelationName = paramName + "Relation"; //$NON-NLS-1$
        preMatchingResult
          .append(ParameterRelation.class.getName())
          .append(ICommonConstants.WHITE_SPACE_CHARACTER)
          .append(paramRelationName);
        preMatchingResult
          .append(ASSIGNMENT_DIRECTIVE)
          .append(patternParametersVariableName)
          .append(".get(") //$NON-NLS-1$
          .append(i)
          .append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE);
        // Loop parameter name.
        String loopParamName = paramName + "Loop"; //$NON-NLS-1$
        // Declared collection of objects for current parameter.
        String collectionVariableName = paramName + "Collection"; //$NON-NLS-1$
        // Compute such a collection.
        preMatchingResult
          .append(Collection.class.getName())
          .append('<')
          .append(eObjectFullyQualifiedName)
          .append(CLOSE_JAVA_1_5_GENERIC_TYPE_USAGE)
          .append(collectionVariableName)
          .append(ASSIGNMENT_DIRECTIVE);
        preMatchingResult
          .append(NEW_CALL)
          .append(SELECT.class.getName())
          .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
        preMatchingResult
          .append(NEW_CALL)
          .append(FROM.class.getName())
          .append("(resource.getContents()), "); //$NON-NLS-1$
        preMatchingResult
          .append(NEW_CALL)
          .append(WHERE.class.getName())
          .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
        preMatchingResult
          .append(NEW_CALL)
          .append(EObjectTypeRelationCondition.class.getName())
          .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
        preMatchingResult
          .append(EcoreHelper.class.getName())
          .append(".getStaticClass(") //$NON-NLS-1$
          .append(paramRelationName)
          .append(".getType()),"); //$NON-NLS-1$
        // Append query relation type.
        // By default, always search for elements of the same type, or that are a sub-type, of given one.
        preMatchingResult
          .append(TypeRelation.class.getName())
          .append(".SAMETYPE_OR_SUBTYPE_LITERAL"); //$NON-NLS-1$
        // Close query call.
        preMatchingResult.append("))).execute();\n"); //$NON-NLS-1$
        // Add for directive associated to current parameter.
        temporaryLoops
          .append("for (") //$NON-NLS-1$
          .append(eObjectFullyQualifiedName)
          .append(ICommonConstants.WHITE_SPACE_CHARACTER)
          .append(loopParamName).append(" : ") //$NON-NLS-1$
          .append(collectionVariableName)
          .append(JAVA_CODE_CLOSE_PAREN_AND_OPEN_BLOCK);
        // Add real parameter declaration (for use in the template), for the parameter is used as an EObject so far.
        // Eg : EClass myParameter = (EClass) myParameterLoop;
        temporaryLoops
          .append(paramTypeName)
          .append(ICommonConstants.WHITE_SPACE_CHARACTER)
          .append(paramName);
        temporaryLoops
          .append(ASSIGNMENT_DIRECTIVE)
          .append(ICommonConstants.WHITE_SPACE_CHARACTER)
          .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER);
        temporaryLoops
          .append(paramTypeName)
          .append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER)
          .append(ICommonConstants.WHITE_SPACE_CHARACTER);
        temporaryLoops
          .append(loopParamName)
          .append(ICommonConstants.SEMICOLON_CHARACTER)
          .append(ICommonConstants.EOL_CHARACTER);
        // Add completion of the tuple to postMatchingResult.
        postMatchingResult
          .append(resultMapVariableName)
          .append(".put(") //$NON-NLS-1$
          .append(paramRelationName)
          .append(".getName(), "); //$NON-NLS-1$
        postMatchingResult
          .append(loopParamName)
          .append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE);
        // Add an end for directive.
        temporaryPostLoops.append(JAVA_CODE_CLOSE_BLOCK);
        // Append parameter name for condition call.
        temporaryCondition.append(loopParamName);
        if (parameters.hasNext()) {
          temporaryCondition.append(ICommonConstants.COMMA_CHARACTER);
        }
        // Increment parameter position.
        i++;
      }
      // Add for loops to pre-matching.
      preMatchingResult.append(temporaryLoops.toString());
      // If condition directive.
      preMatchingResult.append(temporaryCondition.toString());
      preMatchingResult.append(")) {\n"); //$NON-NLS-1$
      // Add this piece of code if buffer is to be delegated.
      if (delegateBuffer) {
        // Clear string buffer.
        preMatchingResult.append(CLEAR_STRING_BUFFER);
        // Call reporter for current string buffer content.
        // Output result.
        postMatchingResult
          .append("reporter.patternLoopExecutionFinished(") //$NON-NLS-1$
          .append("stringBuffer.toString(),"); //$NON-NLS-1$
        // Pattern fullId.
        postMatchingResult
          .append(ICommonConstants.QUOTE_CHARACTER)
          .append(patternFullId)
          .append(ICommonConstants.QUOTE_CHARACTER)
          .append(ICommonConstants.COMMA_CHARACTER);
        // Context.
        postMatchingResult.append("context,"); //$NON-NLS-1$
        // Resulting tuple.
        postMatchingResult
          .append(resultMapVariableName)
          .append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE);
        // Append tuple result to pattern builder.
        postMatchingResult
          .append(pbVariableName)
          .append(".append(stringBuffer)") //$NON-NLS-1$
          .append(ICommonConstants.SEMICOLON_CHARACTER)
          .append(ICommonConstants.EOL_CHARACTER);
      }
      // Append loops closures.
      postMatchingResult.append(temporaryPostLoops);
      // Close if condition directive.
      postMatchingResult.append(JAVA_CODE_CLOSE_BLOCK);
      // Close if condition not null directive.
      postMatchingResult.append(JAVA_CODE_CLOSE_BLOCK);
    } else if (delegateBuffer) {
      // Clear string buffer, now that it is saved.
      preMatchingResult.append(CLEAR_STRING_BUFFER);
      // Set pattern builder to string buffer, when work is done.
      postMatchingResult
        .append(DECLARE_STRING_BUILDER)
        .append(pbVariableName)
        .append(NEW_INITIALIZED_STRING_BUILDER);
    }
    // Add this piece of code if buffer is to be delegated.
    if (delegateBuffer) {
      // Restore string buffer.
      postMatchingResult
        .append("stringBuffer = new StringBuffer(") //$NON-NLS-1$
        .append(pbSaveVariableName)
        .append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER);
      postMatchingResult
        .append(".append(") //$NON-NLS-1$
        .append(pbVariableName)
        .append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE);
      // Call reporter for pattern execution.
      postMatchingResult
        .append("reporter.patternExecutionFinished(") //$NON-NLS-1$
        .append(pbVariableName)
        .append(".toString(),"); //$NON-NLS-1$
      postMatchingResult
        .append(ICommonConstants.QUOTE_CHARACTER)
        .append(patternFullId)
        .append(ICommonConstants.QUOTE_CHARACTER)
        .append(ICommonConstants.COMMA_CHARACTER);
      postMatchingResult
        .append("context")
        .append(JAVA_CODE_CLOSE_CALL_AND_RETURN_LINE); //$NON-NLS-1$
    }
    // Add pattern ending comment tag.
    postMatchingResult
      .append("// End of ") //$NON-NLS-1$
      .append(patternData_p.getPatternLogicalName())
      .append(" (full id = ") //$NON-NLS-1$
      .append(patternData_p.getPattern().getId())
      .append(").\n"); //$NON-NLS-1$
    // Close Java code block for variable names uniqueness.
    if (delegateBuffer) {
      postMatchingResult.append(JAVA_CODE_CLOSE_BLOCK);
    }
    // Close java code.
    preMatchingResult.append(JAVA_CODE_END);
    postMatchingResult.append(JAVA_CODE_END);
    // Return result.
    return new Couple<StringBuilder, StringBuilder>(preMatchingResult, postMatchingResult);
  }

  /**
   * @see org.eclipse.egf.pattern.production.IProductionContributor#compileTemplate(java.lang.String,
   *      org.eclipse.egf.pattern.ecore.PatternHandler.PatternData)
   */
  public boolean compileTemplate(String patternTemplatePath_p, PatternData patternData_p) throws Exception {
    // Now that the template is created, compile it.
    // Get mandatory templates containers.
    String[] templateContainerUris = { 
      FileHelper.getFileFullUri(patternData_p.getPluginId() + TemplateHelper.TEMPLATES_ROOT_PATH).toString(),
      URI.createURI("platform:/plugin/org.eclipse.emf.codegen.ecore/templates").toString() //$NON-NLS-1$ 
    };
    // Format template relative path.
    String relativePath = new Path(patternTemplatePath_p).removeFirstSegments(2).toString();
    // Call jet compiler.
    JETCompiler jetCompiler = new JETCompiler(templateContainerUris, relativePath) {
      @Override
      public void handleDirective(String directive_p, JETMark start_p, JETMark stop_p, Map<String, String> attributes_p) throws JETException {
        attributes_p.put(
          JET_GENERATED_TEMPLATE_SKELETON_KEY, 
          FileHelper.getFileFullUri(JET_GENERATED_TEMPLATE_SKELETON_PATH).toString()
        );
        super.handleDirective(directive_p, start_p, stop_p, attributes_p);
      }
    };
    jetCompiler.parse();
    // And write the resulting java code !
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    jetCompiler.generate(outputStream);
    JETSkeleton skeleton = jetCompiler.getSkeleton();
    StringBuilder ultimateGeneratedClassPath = new StringBuilder(patternData_p.getJavaProject().getProject().getFolder(PatternConstants.GENERATION_SOURCE_FOLDER).getFullPath().toString());
    ultimateGeneratedClassPath
      .append(ICommonConstants.SLASH_CHARACTER)
      .append(FileHelper.convertPackageNameToFolderPath(skeleton.getPackageName()));
    ultimateGeneratedClassPath
      .append(ICommonConstants.SLASH_CHARACTER)
      .append(skeleton.getClassName())
      .append(ICommonConstants.DOT_CHARACTER)
      .append(IPatternConstants.JAVA_SOURCE_FILE_EXTENSION);
    // Generated Java code.
    String javaCode = new String(outputStream.toByteArray());
    // Modify generated Java code buffer declaration.
    if (patternData_p.getProductionOptionsHandler().shouldModifyBuffer()) {
      StringBuilder codeTweak = new StringBuilder("StringBuffer stringBuffer = new StringBuffer();\n"); //$NON-NLS-1$
      String helperClassName = PatternExecutionHelper.class.getName();
      // Append resource variable.
      codeTweak
        .append(Resource.class.getName())
        .append(" resource = ") //$NON-NLS-1$
        .append(helperClassName)
        .append(".getResource(argument);\n"); //$NON-NLS-1$
      // Append context variable.
      codeTweak
        .append(ProductionContext.class.getName())
        .append(" context = ") //$NON-NLS-1$
        .append(helperClassName)
        .append(".getContext(argument);\n"); //$NON-NLS-1$
      // Append reporter variable.
      codeTweak
        .append(IPatternExecutionReporter.class.getName())
        .append(" reporter = ") //$NON-NLS-1$
        .append(helperClassName)
        .append(".getExecutionReporter(argument);\n"); //$NON-NLS-1$
      // Remove final statement in the declaration of the string buffer.
      javaCode = javaCode.replace("final StringBuffer stringBuffer = new StringBuffer();", codeTweak.toString()); //$NON-NLS-1$
    }
    boolean fileWritten = FileHelper.writeFile(
      ultimateGeneratedClassPath.toString(), 
      true, 
      javaCode
    );
    if (fileWritten) {
      // Add containing package to exported ones.
      performManifestChanges(
        patternData_p, 
        ManifestChangeCommandFactory.setExportedPackages(
          new String[] { 
            skeleton.getPackageName() 
          }
        )
      );
      // Update plugin.xml content accordingly.
      performPluginChanges(
        patternData_p, 
        PatternTemplateExtensionFactory.setPatternTemplateExtension(
          patternData_p.getPattern().getId(), 
          new StringBuilder(skeleton.getPackageName())
            .append(ICommonConstants.DOT_CHARACTER)
            .append(skeleton.getClassName())
            .toString(), 
          TemplateType.JET.getId(),
          patternTemplatePath_p
        )
      );
    }
    return fileWritten;
  }

  /**
   * @see org.eclipse.egf.pattern.production.IProductionContributor#fillGenerateHeader(org.eclipse.egf.pattern.ecore.PatternHandler.PatternData,
   *      org.eclipse.egf.pattern.ecore.AnnotationHandler)
   */
  public void fillGenerateHeader(PatternData patternData_p, AnnotationHandler handler_p) throws Exception {
    // Precondition.
    // Pattern is not expected to be compiled to a Java class.
    // Do not create a useless header, that may well indeed be a new source of confusion for both users
    // and Jet compiler.
    if (patternData_p.getProductionOptionsHandler().shouldCompileTemplate() == false) {
      return;
    }
    AnnotationHandler handler = handler_p;
    // Instantiate annotation handler, if none provided.
    if (handler == null) {
      handler = new AnnotationHandler();
    }
    // Get template file path.
    // First get generateHeader method.
    // Should always be not null, for it is added automatically at creation time.
    EOperation generateHeader = null;
    String generateHeaderName = PatternConstants.GENERATE_HEADER_METHOD_NAME;
    for (EOperation operation : patternData_p.getPattern().getEOperations()) {
      if (generateHeaderName.equals(operation.getName())) {
        generateHeader = operation;
        break;
      }
    }
    // Again, should not be null, for it is computed at creation time.
    String generateHeaderUid = handler.getUid(generateHeader);
    // Associated template file relative path.
    String templateFileRelativePath = TemplateHelper.getTemplateRelativePath(
        patternData_p.getPattern().getShortId(), 
        patternData_p.getPluginId(),
        generateHeaderName, 
        generateHeaderUid
    );
    // Read generate header template content.
    String generateHeaderContent = FileHelper.readFile(templateFileRelativePath);
    // Existing content, stop here.
    if (ICommonConstants.EMPTY_STRING.equals(StringHelper.replaceNonWordCharacters(generateHeaderContent, null).trim()) == false) {
      return;
    }
    // Empty content, create default one.
    // Start JET mark-up.
    StringBuilder content = new StringBuilder(JET_SKELETON_JSP_START);
    // Fill package structure and value.
    content
      .append(JET_SKELETON_PACKAGE_DECLARATION)
      .append(ICommonConstants.QUOTE_CHARACTER);
    // Computed package name
    String patternName = patternData_p.getPatternLogicalName();
    content
      .append(patternData_p.getPluginId())
      .append(ICommonConstants.DOT_CHARACTER)
      .append(patternName.toLowerCase());
    // End package structure.
    content.append(ICommonConstants.QUOTE_CHARACTER);
    // Fill class structure and value.
    content
      .append(JET_SKELETON_CLASS_DECLARATION)
      .append(ICommonConstants.QUOTE_CHARACTER);
    // Computed class name looks like toUpperFirst('patternName')Generator
    content
      .append(StringHelper.toUpperFirst(patternName))
      .append(JET_SKELETON_CLASS_DEFAULT_SUFFIX);
    // End class structure.
    content.append(ICommonConstants.QUOTE_CHARACTER);
    // Fill imports structure and value.
    content
      .append(JET_SKELETON_IMPORTS_DECLARATION)
      .append(ICommonConstants.QUOTE_CHARACTER);
    // Compute parameters dependencies.
    List<ParameterRelation> parameters = patternData_p.getAllParameters();
    // Add imports for each of them.
    for (ParameterRelation parameterRelation : parameters) {
      EPackage parameterPackage = parameterRelation.getType().getEPackage();
      // Parameter package name.
      String packageImportedName = EcoreHelper.getImportedPackageName(parameterPackage);
      if (packageImportedName != null) {
        // Added import looks like
        content
          .append(packageImportedName)
          .append(ICommonConstants.DOT_CHARACTER)
          .append(parameterRelation.getType().getName())
          .append(ICommonConstants.WHITE_SPACE_CHARACTER);
      }
    }
    // End imports structure.
    content.append(ICommonConstants.QUOTE_CHARACTER);
    // End JET mark-up.
    content
      .append(ICommonConstants.WHITE_SPACE_CHARACTER)
      .append(JETConstants.JET_MARKUP_END)
      .append(ICommonConstants.EOL_CHARACTER)
      .append(ICommonConstants.EOL_CHARACTER);
    // Write content to file.
    FileHelper.writeFile(templateFileRelativePath, true, content.toString());
  }

  /**
   * Perform changes on manifest file.
   * @param patternData_p
   * @param command_p
   */
  protected static void performManifestChanges(PatternData patternData_p, IPluginChangesCommand command_p) {
    IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
    runner.performChangesOnManifest(patternData_p.getPluginId(), Collections.singletonList(command_p));
  }

  /**
   * Perform changes on plugin.xml file.
   * @param patternData_p
   * @param command_p
   */
  protected static void performPluginChanges(PatternData patternData_p, IPluginChangesCommand command_p) {
    IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
    runner.performChangesOnPlugin(patternData_p.getPluginId(), Collections.singletonList(command_p));
  }
  
}
