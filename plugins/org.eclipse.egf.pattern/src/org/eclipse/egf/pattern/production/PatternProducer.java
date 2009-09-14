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
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.MathHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.progress.ProductionProgressMonitor;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.fc.generator.java.model.EcoreGenModelGenerator;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternSeeker;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.template.TemplateHelper;


/**
 * Pattern producer.<br>
 * Can either produce a library of patterns, or a single pattern.
 * @author brocard
 */
public class PatternProducer {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternProducer.class.getPackage().getName());
  
  /**
   * Java builder factory component id.
   */
  protected static final String JAVA_BUILDER_FACTORY_COMPONENT_ID = "java.builder.asset"; //$NON-NLS-1$
  
  /**
   * Java builder project name contract element id.
   */
  protected static final String JAVA_BUILDER_FACTORY_COMPONENT_CONTRACT_FACTORY_COMPONENT_PROJECT_NAME = "java.builder.asset.contract.assetProjectName"; //$NON-NLS-1$
    
  /**
   * Java code generator jdk compliance level contract element id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_JDK_COMPLIANCE_LEVEL = "javaCodeGeneratorAsset.contract.jdkComplianceLevel"; //$NON-NLS-1$
  
  /**
   * Java code generator genModel generator contract element id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_GEN_MODEL_GENERATOR = "javaCodeGeneratorAsset.contract.genModelGenerator"; //$NON-NLS-1$
  
  /**
   * Java code generator base package contract element id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_BASE_PACKAGE = "javaCodeGeneratorAsset.contract.basePackage"; //$NON-NLS-1$
  
  /**
   * Java code generator project name contract element id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_FACTORY_COMPONENT_PROJECT_NAME = "javaCodeGeneratorAsset.contract.assetProjectName"; //$NON-NLS-1$
  
  /**
   * Java code generator input path contract element id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_INPUT_PATH = "javaCodeGeneratorAsset.contract.inputPath"; //$NON-NLS-1$
  
  /**
   * Java code generator model directory contract element id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_MODEL_DIRECTORY = "javaCodeGeneratorAsset.contract.modelDirectory"; //$NON-NLS-1$
  
  /**
   * Java code generator factory component id.
   */
  protected static final String JAVA_CODE_GENERATOR_FACTORY_COMPONENT_ID = "javaCodeGeneratorAsset"; //$NON-NLS-1$
  
  /**
   * Pattern seeker reference.
   */
  private static PatternSeeker _seeker; 

  /**
   * Constructor.
   */
  public PatternProducer() {
    //Nothing to do
  }

  /**
   * Get pattern seeker.
   * @return
   */
  protected static PatternSeeker getPatternSeeker() {
    if (_seeker == null) {
      // Do look for patterns in workspace.
      _seeker = new PatternSeeker(true);
    }
    return _seeker;
  }

  /**
   * Build the java project holding the currently produced pattern.
   * @param patternData_p
   * @return
   */
  protected boolean buildPatternProject(PatternData patternData_p) {
    // Create a factory component dynamically which goal is to build the pattern project.
    // It is referencing java builder factory component.
    String referencedFcId = JAVA_BUILDER_FACTORY_COMPONENT_ID;
    Couple<FactoryComponent, Context> buildProjectFc = createFactoryComponentSkeleton(
      "patternProducer.factoryComponent.buildProject",  //$NON-NLS-1$ 
      referencedFcId
    );
    // Fill context.
    // FactoryComponent project name.
    ModelHelper.addReferencingContractContextElement(
      buildProjectFc.getValue(), 
      referencedFcId, 
      JAVA_BUILDER_FACTORY_COMPONENT_CONTRACT_FACTORY_COMPONENT_PROJECT_NAME,
      patternData_p.getPluginId(), 
      PatternActivator.getDefault().getPluginID()
    );
    return generateFactoryComponent(buildProjectFc.getKey());
  }
  
  /**
   * Create a factory component with given name.<br>
   * By default, a factory with a unique production plan is added to the newly created factory component.<br>
   * This production plan contains a factory component invocation containing a default context.<br>
   * This context should be filled up.
   * @param fcName_p
   * @return
   */
  protected static Couple<FactoryComponent, Context> createFactoryComponentSkeleton(String fcName_p, String referencedFcId_p) {
    // Create a factory component dynamically.
    FactoryComponent fc = ModelHelper.createEmptyMinimalFC(fcName_p);
    // Add required factory component invocation.
    FactoryComponentInvocation fcInvocation = ModelHelper.addFactoryComponentInvocation(
      fc, 
      referencedFcId_p
    );
    // Add a default context.
    Context context = ModelFactory.eINSTANCE.createContext();
    fcInvocation.setContext(context);
    return new Couple<FactoryComponent, Context>(fc, context);
  }

  /**
   * Generate given factory component in current thread.
   * @param fc_p
   * @return
   */
  protected static boolean generateFactoryComponent(FactoryComponent fc_p) {
    return CoreActivator.getDefault().generateFactoryComponentSynchronously(fc_p);
  }

  /**
   * Generate pattern classes.<br>
   * That is generate classes that are describing the pattern structure as an object one.<br>
   * Such classes are composed of a <i>String generate()</i> method, and several internal pattern methods.<br>
   * Calling <i>generate()</i> method results in getting the content of a new template file that is indeed acting as the whole pattern, when applied.<br>
   * When all classes are generated, also force project build so that they may subsequently be used.
   * @param patternData_p
   * @return
   */
  protected static boolean generatePatternClasses(PatternData patternData_p) {
    IJavaProject javaProject = patternData_p.getJavaProject();
    // Precondition.
    // Only produce pattern for in-development patterns (that is not do-able for already deployed patterns).
    if (javaProject == null) {
      return false;
    }
    // Should fix bug prod00015930
    try {
      // That might be a good time to generate pre and post matching templates, if applicable.
      GeneratedContentProducer conditionProducer = new GeneratedContentProducer();
      conditionProducer.produceConditionStructures(patternData_p);
      // Fill generate header, if none is provided.
      conditionProducer.getProductionContributor().fillGenerateHeader(patternData_p, null);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("PatternProducer.generatePatternClasses(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    // End of fix for prod00015930
    // Make sure all dependencies are already compiled.
    ensurePatternsJavaFiles(patternData_p.getPatternDependenciesIds());
    // Create a factory component dynamically, used to produce the java code for this pattern.
    // It is referencing java code generator factory component.
    String referencedFcId = JAVA_CODE_GENERATOR_FACTORY_COMPONENT_ID;
    Couple<FactoryComponent, Context> producePatternCouple = createFactoryComponentSkeleton(
      "patternProducer.factoryComponent.ecoreToJava",  //$NON-NLS-1$ 
      referencedFcId
    );
    // Get context.
    Context context = producePatternCouple.getValue();
    // Fill context up.
    context.getContextElements().clear();
    String contributorId = PatternActivator.getDefault().getPluginID();
    // Model directory.
    ModelHelper.addReferencingContractContextElement(
      context, 
      referencedFcId, 
      JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_MODEL_DIRECTORY,
      new Path(PatternConstants.GENERATION_SOURCE_FOLDER).segment(0), 
      contributorId
    );
    // Input path.
    ModelHelper.addReferencingContractContextElement(
      context, 
      referencedFcId, 
      JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_INPUT_PATH, 
      patternData_p.getRealRelativePath(), 
      contributorId
    );
    // FactoryComponent project name.
    ModelHelper.addReferencingContractContextElement(
      context, 
      referencedFcId, 
      JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_FACTORY_COMPONENT_PROJECT_NAME, 
      patternData_p.getPluginId(), 
      contributorId
    );
    // Base package.
    ModelHelper.addReferencingContractContextElement(
      context, 
      referencedFcId, 
      JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_BASE_PACKAGE,
      PatternConstants.PATTERN_GENERATED_BASE_PACKAGE, 
      contributorId
    );
    // GenModel generator.
    ModelHelper.addReferencingContractContextElement(
      context, 
      referencedFcId, 
      JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_GEN_MODEL_GENERATOR,
      EcoreGenModelGenerator.class.getName(), 
      contributorId
    );
    // Jdk compliance level.
    ModelHelper.addReferencingContractContextElement(
      context, 
      referencedFcId, 
      JAVA_CODE_GENERATOR_FACTORY_COMPONENT_CONTRACT_ELEMENT_JDK_COMPLIANCE_LEVEL,
      GenJDKLevel.JDK50_LITERAL.getLiteral(), 
      contributorId
    );
    return generateFactoryComponent(producePatternCouple.getKey());
  }

  /**
   * Ensure all identified patterns are indeed usable as java classes.<br>
   * That is, if one of these patterns is being developed and has never been generated, do use its ecore file to generate its java classes form, and compile
   * them.
   * @param fullIds_p
   */
  protected static void ensurePatternsJavaFiles(Set<String> fullIds_p) {
    // Precondition.
    if (fullIds_p == null) {
      return;
    }
    // Get list of pattern paths.
    List<PatternData> patternsData = new ArrayList<PatternData>(0);
    for (String patternId : fullIds_p) {
      patternsData.addAll(getPatternSeeker().getPatternsData(patternId));
    }
    // Now just generate pattern classes for all selected ones.
    for (PatternData patternData : patternsData) {
      // Generate pattern java classes and ensure build of containing project.
      generatePatternClasses(patternData);
    }
  }

  /**
   * Take care of the whole production chain for given patterns data.
   * @param data_p
   * @param monitor_p
   * @param ticksCount_p
   * @return
   */
  protected static boolean handlePatternsProduction(List<PatternData> data_p, SubMonitor monitor_p, int ticksCount_p) {
    boolean result = true;
    // How many ticks should monitor eat each time ?
    int stepCount = ticksCount_p / data_p.size();
    // Cycle through pattern paths.
    for (PatternData patternData : data_p) {
      // Monitor each pattern to produce.
      ProductionProgressMonitor monitor = new ProductionProgressMonitor(
        monitor_p, 
        patternData.getPatternLogicalName(), 
        stepCount
      );
      // Check hosting java project.
      boolean proceed = patternData.getJavaProject() != null;
      if (proceed) {
        // Convert pattern ecore file to java files.
        proceed = generatePatternClasses(patternData);
      }
      result &= proceed;
      // Acknowledge each pattern production.
      monitor.end();
    }
    return result;
  }

  /**
   * Produce identified pattern.
   * @param fullId_p The absolute id of either a library or a pattern.
   * @return
   */
  public static boolean producePatterns(String fullId_p, IProgressMonitor progressMonitor_p) {
    boolean result = fullId_p != null;
    // Precondition.
    if (result == false) {
      progressMonitor_p.done();
      return result;
    }
    try {
      // Do produce the patterns.
      String productionMessage = Messages.PatternProducer_ProgressReporting_Title + fullId_p;
      // Convert progress monitor to sub monitor.
      SubMonitor subMonitor = SubMonitor.convert(progressMonitor_p, productionMessage, ProgressReporter.TASK_DEFAULT_TICKS_COUNT);
      // Get pattern path.
      int ticksCount = MathHelper.multiply(ProgressReporter.TASK_DEFAULT_TICKS_COUNT, 0.1f);
      List<PatternData> patternsData = getPatternSeeker().getPatternsData(fullId_p);
      int patternsCount = patternsData.size();
      subMonitor.worked(ticksCount);
      ticksCount = ProgressReporter.TASK_DEFAULT_TICKS_COUNT - ticksCount;
      subMonitor.setWorkRemaining(ticksCount);
      result = (patternsCount > 0);
      // Got the patterns paths, go on with production.
      if (result) {
        // Generate patterns classes.
        handlePatternsProduction(patternsData, subMonitor, ticksCount);
        subMonitor.setWorkRemaining(0);
      }
    } finally {
      // Whatever happened, always complete the progress monitor.
      progressMonitor_p.done();
      // Return false if cancellation happened.
      result &= progressMonitor_p.isCanceled() == false;
    }
    return result;
  }
  
  /**
   * Generate identified pattern.<br>
   * That is, generate resulting template and return it as a string.<br>
   * The resulting template does include neither the header, nor the footer.<br>
   * This method should only be called in the case of an inclusion of the identified pattern in another one.
   * @param fullId_p
   * @param classLoader_p
   * @return
   */
  public String generatePatterns(String fullId_p, Object classLoader_p) {
    String result = ICommonConstants.EMPTY_STRING;
    // Precondition.
    if (fullId_p == null || classLoader_p instanceof ClassLoader == false) {
      return result;
    }
    // Get class loader.
    ClassLoader usableClassLoader = (ClassLoader) classLoader_p;
    // Get pattern paths.
    List<PatternData> patternsData = getPatternSeeker().getPatternsData(fullId_p);
    // Check that there is indeed some work to do.
    if (patternsData.size() < 0) {
      return result;
    }
    StringBuilder resultingBuilder = new StringBuilder();
    // Now, go on with the good work.
    for (PatternData patternData : patternsData) {
      // Try and transform ecore pattern file to java classes, if it is necessary.
      generatePatternClasses(patternData);
      // Then get pattern template as a string.
      String patternTemplate = PatternTemplateProducer.getPatternTemplateAsString(patternData, usableClassLoader);
      if (patternTemplate != null) {
        resultingBuilder.append(patternTemplate);
      }
    }
    return resultingBuilder.toString();
  } 
  
  /**
   * Clean pattern template structure.
   * @param javaProject_p
   * @param descriptor_p
   */  
  public static void cleanGeneratedStructures(IJavaProject javaProject_p, IDescriptor descriptor_p) {
    if (javaProject_p == null || descriptor_p == null) {
      return;
    }
    // Process only Workspace Plugin
    IPluginModelBase model = PluginRegistry.findModel(javaProject_p.getProject());
    if (model == null) {
      return;
    }
    // Retrieve needed informations from IDescriptor
    String patternShortId = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_ID);
    String patternTemplatePath = (String) descriptor_p.getValue(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_PATH);
    String patternTemplateClass = (String) descriptor_p.getValue(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS);
    // Clean generated templates if any
    FileHelper.deleteResource(
      TemplateHelper.getTemplateRootIFolder(javaProject_p),
      TemplateHelper.getGeneratedPatternTemplateIFolder(javaProject_p, patternShortId),
      true
    );
  }  
  
}
