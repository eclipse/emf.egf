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
package org.eclipse.egf.pattern.production;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ecore.condition.ConditionClassOutput;
import org.eclipse.egf.pattern.ecore.condition.IConditionConstants;
import org.eclipse.egf.pattern.internal.ConditionMergeHelper;
import org.eclipse.egf.pattern.internal.production.jet.JetProductionContributor;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.pattern.plugin.command.PatternConditionExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;

/**
 * The producer responsible for all generated content.
 * @author Guillaume Brocard
 */
public class GeneratedContentProducer {
  
  /**
   * Condition source code folder.
   */
  protected static final String CONDITION_SOURCE_FOLDER = "/src"; //$NON-NLS-1$
  
  /**
   * Platform specific production contributor.
   */
  private IProductionContributor _contributor;
  
  /**
   * Constructor.
   */
  public GeneratedContentProducer() {
    _contributor = new JetProductionContributor();
  }

  /**
   * Get associated production contributor.
   * @return
   */
  public IProductionContributor getProductionContributor() {
    return _contributor;
  }

  /**
   * @see org.eclipse.egf.pattern.ecore.condition.IConditionProducer#produceConditionStructures(java.lang.String)
   */
  public void produceConditionStructures(String fileRelativePath_p) throws Exception {
    PatternData patternData = new PatternHandler().load(fileRelativePath_p);
    // Call sibling method.
    produceConditionStructures(patternData);
  }

  /**
   * Produce condition structures based on given pattern data.
   * @param patternData_p
   * @throws Exception
   */
  public void produceConditionStructures(PatternData patternData_p) throws Exception {
    // Precondition.
    if (patternData_p == null) {
      return;
    }
    // Get all parameters.
    List<ParameterRelation> parameters = patternData_p.getAllParameters();
    // Preconditions.
    if (parameters == null || parameters.isEmpty()) {
      removeOldConditionStructures(patternData_p);
      // Refresh project.
      ProjectHelper.refreshProject(
        patternData_p.getJavaProject().getProject(), 
        null
      );
      return;
    }
    // Update condition Java class code, according to parameters list.
    updateConditionClass(patternData_p, parameters);
    // Replace matching pre/post templates.
    replacePatternMatchingTemplates(patternData_p, parameters);
    // Refresh project.
    ProjectHelper.refreshProject(
      patternData_p.getJavaProject().getProject(), 
      null
    );
  }

  /**
   * Produce public parameters handler.
   * @param patternData_p
   */
  protected void producePublicParametersHandler(PatternData patternData_p) {
    // Create a factory component dynamically.
    FactoryComponent fc = ModelHelper.createEmptyMinimalFC("GeneratePublicParametersHandler"); //$NON-NLS-1$
    // Add required factory component invocation.
    String generatorId = "asset.1212745121407.14"; //$NON-NLS-1$
    FactoryComponentInvocation fcInvocation = ModelHelper.addFactoryComponentInvocation(
      fc, 
      generatorId
    );
    // Add a context.
    Context context = ModelFactory.eINSTANCE.createContext();
    fcInvocation.setContext(context);
    // Add context elements.
    String contributorId = PatternActivator.getDefault().getPluginID();
    // Model path.
    ModelHelper.addReferencingContractContextElement(
      context, 
      generatorId, 
      "contractElement.1212763579828.93", //$NON-NLS-1$
      patternData_p.getRealRelativePath(),
      contributorId
    );
    // Pattern name.
    ModelHelper.addReferencingContractContextElement(
      context, 
      generatorId, 
      "contractElement.1212763518024.91", //$NON-NLS-1$ 
      patternData_p.getPatternName(), 
      contributorId
    );
    // Plug-in ID.
    ModelHelper.addReferencingContractContextElement(
      context, 
      generatorId, 
      "contractElement.1212763360724.90", //$NON-NLS-1$ 
      patternData_p.getPluginId(), 
      contributorId
    );
    // Execute it.
    CoreActivator.getDefault().generateFactoryComponentSynchronously(fc);
  }

  /**
   * Get condition class content as for given pattern data.
   * @param patternData_p
   * @return null if an error occurred, {@link ICommonConstants#EMPTY_STRING} if it could not be generated.
   */
  protected String getConditionClassContent(PatternData patternData_p) {
    // Result output container.
    ConditionClassOutput.getSharedInstance().reset();
    // Create a factory component dynamically.
    FactoryComponent fc = ModelHelper.createEmptyMinimalFC("GenerateConditionClass"); //$NON-NLS-1$
    // Add required factory component invocation.
    String generatorId = "asset.1213692164306.87"; //$NON-NLS-1$
    FactoryComponentInvocation fcInvocation = ModelHelper.addFactoryComponentInvocation(
      fc, 
      generatorId
    );
    // Add a context.
    Context context = ModelFactory.eINSTANCE.createContext();
    fcInvocation.setContext(context);
    // Add context elements.
    String contributorId = PatternActivator.getDefault().getPluginID();
    // Model path.
    ModelHelper.addReferencingContractContextElement(
      context, 
      generatorId, 
      "contractElement.1213715622825.42", //$NON-NLS-1$
      patternData_p.getRealRelativePath(),
      contributorId
    );
    // Execute it.
    CoreActivator.getDefault().generateFactoryComponentSynchronously(fc);
    // Extract result.
    return ConditionClassOutput.getSharedInstance().getGeneratedConditionClassContent(patternData_p.getPattern().getId());
  }

  /**
   * Update condition class if it already exists, else create it with empty content.
   * @param patternData_p
   * @param parameters_p
   * @return
   */
  protected void updateConditionClass(PatternData patternData_p, List<ParameterRelation> parameters_p) throws Exception {
    // Resulting content is generated.
    String resultingContent = getConditionClassContent(patternData_p);
    if (resultingContent == null || ICommonConstants.EMPTY_STRING.equals(resultingContent)) {
      throw new IllegalArgumentException();
    }
    // Check existing condition class.
    String conditionClassRelativePath = getConditionFileRelativePath(patternData_p);
    // Merge required.
    if (FileHelper.exists(conditionClassRelativePath)) {
      resultingContent = ConditionMergeHelper.merge(
        resultingContent, 
        FileHelper.readFile(conditionClassRelativePath)
      );
    }
    // Write result to file.
    FileHelper.writeFile(conditionClassRelativePath, true, resultingContent);
    // Update plugin.xml content accordingly.
    IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner(); 
    runner.performChangesOnPlugin(
      patternData_p.getPluginId(), 
      Collections.singletonList(
        PatternConditionExtensionFactory.setPatternConditionExtension(
          patternData_p.getPattern().getId(), 
          new StringBuilder(PatternConstants.PATTERN_CONDITION_GENERATED_BASE_PACKAGE)
            .append(ICommonConstants.DOT_CHARACTER)
            .append(getConditionClassName(patternData_p))
            .toString()
        )
      )
    );
  }

  /**
   * Get condition file relative path from given parameters.
   * @param patternData_p
   * @return
   */
  public static String getConditionFileRelativePath(PatternData patternData_p) {
    // Return computed name.
    return getGeneratedClassRelativePath(
      patternData_p.getPluginId(), 
      CONDITION_SOURCE_FOLDER, 
      PatternConstants.PATTERN_CONDITION_GENERATED_BASE_PACKAGE, 
      getConditionClassName(patternData_p)
    );
  }

  /**
   * Get generated class relative path.
   * @param pluginId_p
   * @param sourceFolder_p
   * @param packageName_p
   * @param className_p
   * @return
   */
  public static String getGeneratedClassRelativePath(
    String pluginId_p, 
    String sourceFolder_p, 
    String packageName_p, 
    String className_p
  ) {
    // Preconditions.
    if (pluginId_p == null || sourceFolder_p == null || packageName_p == null || className_p == null) {
      return ICommonConstants.EMPTY_STRING;
    }
    // Compute file relative path (does imply that dot-separated package name is converted into folder path).           
    return 
      new StringBuilder(pluginId_p)
        .append(sourceFolder_p)
        .append(ICommonConstants.SLASH_CHARACTER)
        .append(FileHelper.convertPackageNameToFolderPath(packageName_p))
        .append(ICommonConstants.SLASH_CHARACTER)
        .append(className_p)
        .append(ICommonConstants.DOT_CHARACTER)
        .append(IPatternConstants.JAVA_SOURCE_FILE_EXTENSION)
        .toString();
  }

  /**
   * Get condition class name from pattern data.
   * @param patternData_p
   * @return
   */
  public static String getConditionClassName(PatternData patternData_p) {
    return getClassName(
      patternData_p.getPatternName(), 
      IConditionConstants.CONDITION_CLASS_NAME_SUFFIX
    );
  }

  /**
   * Get generated class name from pattern one and suffix.
   * @param patternName_p
   * @param suffix_p
   * @return
   */
  public static String getClassName(String patternName_p, String suffix_p) {
    return 
      new StringBuilder(StringHelper.toUpperFirst(patternName_p))
        .append(suffix_p)
        .toString();
  }

  /**
   * Replace pre and post pattern matching templates that are included in the generated pattern template.
   * @param patternData_p
   * @param parameters_p
   */
  protected void replacePatternMatchingTemplates(PatternData patternData_p, List<ParameterRelation> parameters_p) {
    // (Re-)Create template files content.
    Couple<StringBuilder, StringBuilder> resultingTemplates = _contributor.createPatternMatchingTemplates(
      patternData_p, 
      parameters_p
    );
    // Save templates files.
    String patternShortId = patternData_p.getPattern().getShortId();
    String pluginId = patternData_p.getPluginId();
    FileHelper.writeFile(
      TemplateHelper.getTemplateRelativePath(
        patternShortId, 
        pluginId, 
        PatternConstants.GENERATE_PRE_MATCHING_METHOD_NAME, 
        null
      ), 
      true,
      resultingTemplates.getKey().toString()
    );
    FileHelper.writeFile(
      TemplateHelper.getTemplateRelativePath(
        patternShortId, 
        pluginId, 
        PatternConstants.GENERATE_POST_MATCHING_METHOD_NAME, 
        null
      ), 
      true,
      resultingTemplates.getValue().toString()
    );
  }

  /**
   * Remove no longer needed condition structures, if any.<br>
   * That might happen, when the pattern is loosing all its parameters, due to a user decision.
   * @param patternData_p
   */
  protected void removeOldConditionStructures(PatternData patternData_p) {
    // Delete existing condition class, if any.
    String conditionClassRelativePath = getConditionFileRelativePath(patternData_p);
    if (FileHelper.exists(conditionClassRelativePath)) {
      FileHelper.deleteFile(conditionClassRelativePath);
    }
    String patternShortId = patternData_p.getPattern().getShortId();
    String pluginId = patternData_p.getPluginId();
    // Delete pre-matching template, if any.
    String preMatchingRelativePath = TemplateHelper.getTemplateRelativePath(
      patternShortId, 
      pluginId, 
      PatternConstants.GENERATE_PRE_MATCHING_METHOD_NAME, 
      null
    );
    if (FileHelper.exists(preMatchingRelativePath)) {
      FileHelper.deleteFile(preMatchingRelativePath);
    }
    // Delete post-matching template, if any.
    String postMatchingRelativePath = TemplateHelper.getTemplateRelativePath(
      patternShortId, 
      pluginId, 
      PatternConstants.GENERATE_POST_MATCHING_METHOD_NAME, 
      null
    );
    if (FileHelper.exists(postMatchingRelativePath)) {
      FileHelper.deleteFile(postMatchingRelativePath);
    }
    // Ask for reconstruction of pre and post matching, if required.
    replacePatternMatchingTemplates(
      patternData_p, 
      new ArrayList<ParameterRelation>(0)
    );
  }
  
}
