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
package org.eclipse.egf.fc.generator.java.task;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.fc.generator.java.internal.GenerateJavaCodeOperation;
import org.eclipse.egf.fc.generator.java.model.AbstractGenModelGenerator;
import org.eclipse.egf.fc.generator.java.model.AbstractGenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;


/**
 * @author fournier
 */
public class GeneratorJavaTask extends AbstractTask {
  
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(GeneratorJavaTask.class.getPackage().getName());
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String EMF_ROOT_INTERFACE = "emfRootInterface"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String EMF_ROOT_CLASS = "emfRootClass"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String JDK_COMPLIANCE_LEVEL = "jdkComplianceLevel"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String GEN_MODEL_GENERATOR = "genModelGenerator"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String GENERATOR_ADAPTER_FACTORY = "generatorAdapterFactory"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.<br>
   * That allows to define its own merge rules.
   */
  private static final String MERGE_RULES_RELATIVE_PATH = "mergeRulesPath"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String BASE_PACKAGE = "basePackage"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String FACTORY_COMPONENT_PROJECT_NAME = "assetProjectName"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String INPUT_PATH = "inputPath"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String MODEL_DIRECTORY = "modelDirectory"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String RESOURCE_TYPE = "resourceType"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String IMPL_PACKAGE_SUFFIX = "implementationPackageSuffix"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String INTERFACE_PACKAGE_SUFFIX = "interfacePackageSuffix"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String METADATA_PACKAGE_SUFFIX = "metadataPackageSuffix"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by javaCodeGenerator factory component.
   */
  private static final String UTILITY_PACKAGE_SUFFIX = "utilityPackageSuffix"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    
    GenerateJavaCodeOperation generateJavaCodeOperation = new GenerateJavaCodeOperation(
      getInputPath(), 
      getFactoryComponentProjectName(), 
      getBasePackage(),
      getGenModelGenerator()
    );
    
    // Set the EMF Root interface(if any).
    String emfRootInterface = getEmfRootInterface();
    if (emfRootInterface != null) {
      generateJavaCodeOperation.setRootExtendsInterface(emfRootInterface);
    }
    
    // Set the EMF Root class(if any).
    String emfRootClass = getEmfRootClass();
    if (emfRootClass != null) {
      generateJavaCodeOperation.setRootExtendsClass(emfRootClass);
    }
    
    // Set the JDK Compliance level(if any).
    GenJDKLevel jdkComplianceLevel = getJdkComplianceLevel();
    if (jdkComplianceLevel != null) {
      generateJavaCodeOperation.setJdkComplianceLevel(jdkComplianceLevel);
    }
    
    // Set the EMF generator adapter factory(if any).
    AbstractGenModelGeneratorAdapterFactory generatorAdapterFactory = getGeneratorAdapterFactory();
    if (generatorAdapterFactory != null) {
      generateJavaCodeOperation.setGeneratorAdapterFactory(generatorAdapterFactory);
      // Set the EMF Merge rules file (if any).
      String mergeRulesPath = getMergeRulesRelativePath();
      if (mergeRulesPath != null) {
        generatorAdapterFactory.setMergeRulesRelativePath(mergeRulesPath);
      }
    }
    
    // Set the model directory (if any).
    String modelDirectory = getModelDirectory();
    if (modelDirectory != null) {
      generateJavaCodeOperation.setModelDirectory(modelDirectory);
    }
    
    // Set the Resource Type(if any).
    GenResourceKind resourceType = getResourceType();
    if (resourceType != null) {
      generateJavaCodeOperation.setResourceType(resourceType);
    }
    
    // Set the Implementation package (if any).
    String implementationPackageSuffix = getImplementationPackageSuffix();
    if (implementationPackageSuffix != null) {
      generateJavaCodeOperation.setImplementationPackageSuffix(implementationPackageSuffix);
    }
    
    // Set the Interface package (if any).
    String interfacePackageSuffix = getInterfacePackageSuffix();
    if (interfacePackageSuffix != null) {
      generateJavaCodeOperation.setInterfacePackageSuffix(interfacePackageSuffix);
    }
    
    // Set the Metadata package (if any).
    String metadataPackageSuffix = getMetadataPackageSuffix();
    if (metadataPackageSuffix != null) {
      generateJavaCodeOperation.setMetadataPackageSuffix(metadataPackageSuffix);
    }
    
    // Set the Utility package (if any).
    String utilityPackageSuffix = getUtilityPackageSuffix();
    if (utilityPackageSuffix != null) {
      generateJavaCodeOperation.setUtilityPackageSuffix(utilityPackageSuffix);
    }
    
    try {
      generateJavaCodeOperation.run(progressMonitor_p);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("GeneratorJavaTask.doExecute(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Failed to generate java code for ").append(getFactoryComponentProjectName()); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    
    return generateJavaCodeOperation.getResult();
    
  }

  /**
   * Return the input path.
   * @return
   */
  private IPath getInputPath() {
    String modelName = (String) getContextElementValue(INPUT_PATH);
    // Prefix prepend to retrieved value.
    String rootPrefix = null;
    // Check if retrieved modelName already contains a starting slash character ?
    if (modelName.charAt(0) == ICommonConstants.SLASH_CHARACTER) {
      // No need to prepend a slash character.
      rootPrefix = ICommonConstants.EMPTY_STRING;
    } else {
      // No slash detected, prepend it.
      rootPrefix = String.valueOf(ICommonConstants.SLASH_CHARACTER);
    }
    return new Path(rootPrefix + modelName);
  }

  /**
   * Return the factory component project name
   * @return
   */
  private String getFactoryComponentProjectName() {
    return (String) getContextElementValue(FACTORY_COMPONENT_PROJECT_NAME);
  }

  /**
   * Get the base package to be used as prefix.
   * @return
   */
  private String getBasePackage() {
    return (String) getContextElementValue(BASE_PACKAGE);
  }

  /**
   * Get the interface used as root interface in EMF generation.
   * @return
   */
  private String getEmfRootInterface() {
    return (String) getContextElementValue(EMF_ROOT_INTERFACE);
  }

  /**
   * Get the class used as root class in EMF generation.
   * @return
   */
  private String getEmfRootClass() {
    return (String) getContextElementValue(EMF_ROOT_CLASS);
  }

  /**
   * Get the JDK compliance level.
   * @return
   */
  private GenJDKLevel getJdkComplianceLevel() {
    return (GenJDKLevel) getContextElementValue(JDK_COMPLIANCE_LEVEL);
  }

  /**
   * Get the resource type.
   * @return
   */
  private GenResourceKind getResourceType() {
    return (GenResourceKind) getContextElementValue(RESOURCE_TYPE);
  }

  /**
   * Get the model directory i.e the folder where the generated files are output.
   * @return
   */
  private String getModelDirectory() {
    return (String) getContextElementValue(MODEL_DIRECTORY);
  }

  /**
   * Get the genModel generator.
   * @return
   */
  private AbstractGenModelGenerator getGenModelGenerator() {
    return (AbstractGenModelGenerator) getContextElementValue(GEN_MODEL_GENERATOR);
  }

  /**
   * Get the generator adapter factory.
   * @return
   */
  private AbstractGenModelGeneratorAdapterFactory getGeneratorAdapterFactory() {
    return (AbstractGenModelGeneratorAdapterFactory) getContextElementValue(GENERATOR_ADAPTER_FACTORY);
  }

  /**
   * Get the merge rules file relative path as defined by {@link FileHelper}.
   * @return
   */
  private String getMergeRulesRelativePath() {
    return (String) getContextElementValue(MERGE_RULES_RELATIVE_PATH);
  }

  /**
   * Get implementation package suffix.
   * @return
   */
  private String getImplementationPackageSuffix() {
    return (String) getContextElementValue(IMPL_PACKAGE_SUFFIX);
  }

  /**
   * Get interface package suffix.
   * @return
   */
  private String getInterfacePackageSuffix() {
    return (String) getContextElementValue(INTERFACE_PACKAGE_SUFFIX);
  }

  /**
   * Get metadata package suffix.
   * @return
   */
  private String getMetadataPackageSuffix() {
    return (String) getContextElementValue(METADATA_PACKAGE_SUFFIX);
  }

  /**
   * Get utility package suffix.
   * @return
   */
  private String getUtilityPackageSuffix() {
    return (String) getContextElementValue(UTILITY_PACKAGE_SUFFIX);
  }
  
}
