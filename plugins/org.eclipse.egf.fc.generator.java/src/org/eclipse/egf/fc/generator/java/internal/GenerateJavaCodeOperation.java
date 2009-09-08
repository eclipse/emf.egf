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
package org.eclipse.egf.fc.generator.java.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.generator.IEgfGeneratorConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.helper.ProjectHelper.ProjectExistenceStatus;
import org.eclipse.egf.common.listener.DefaultResourceListener;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.ui.actions.AbstractGenerateCodeOperation;
import org.eclipse.egf.fc.generator.java.helper.FileNameHelper;
import org.eclipse.egf.fc.generator.java.internal.model.api.JavaApiCodeGenerator;
import org.eclipse.egf.fc.generator.java.model.AbstractGenModelGenerator;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.emf.PdeEmfActivator;
import org.eclipse.egf.pde.emf.plugin.command.EmfExtensionFactory;
import org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.egf.pde.plugin.manifest.command.ManifestChangeCommandFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ui.actions.WorkspaceModifyOperation;


/**
 * Supports Java code generation within an {@link WorkspaceModifyOperation}
 * @author fournier
 */
public class GenerateJavaCodeOperation extends AbstractGenerateCodeOperation {
  
  /**
   * Input path that the model API is generated for.
   */
  private IPath _inputPath;
  
  /**
   * FactoryComponent project identification.
   */
  private String _projectName;
  
  /**
   * Base package prefix.
   */
  private String _basePackage;
  

  /**
   * Genmodel generator used to create the genmodel file.
   */
  private AbstractGenModelGenerator _genModelGenerator;

  /**
   * Fully qualified interface used as root interface for generated EMF metamodel interfaces.
   */
  private String _rootExtendsInterface;

  /**
   * Fully qualified class used as root implementation class for generated EMF metamodel classes.
   */
  private String _rootExtendsClass;

  /**
   * JDK compliance level used in generation.
   */
  private GenJDKLevel _jdkComplianceLevel;
  /**
   * Model directory location ie the folder where generated files are output.
   */
  private String _modelDirectory;
  private GenResourceKind _resourceType;
  /**
   * Implementation package suffix used for model implementation classes
   */
  private String _implementationPackageSuffix;
  /**
   * Interface package suffix used for model interfaces and enumerations.
   */
  private String _interfacePackageSuffix;
  /**
   * Metadata package suffix used for package and factory classes.
   */
  private String _metadataPackageSuffix;
  /**
   * Utility package suffix is used for switch, validator, resource, and adapter factory classes.
   */
  private String _utilityPackageSuffix;

  /**
   * Constructor.
   * @param modelName_p
   * @param projectName_p
   * @param basePackage_p
   */
  public GenerateJavaCodeOperation(IPath inputPath_p, String projectName_p, String basePackage_p, AbstractGenModelGenerator genModelGenerator_p) {
    _inputPath = inputPath_p;
    _projectName = projectName_p;
    _basePackage = basePackage_p;
    _genModelGenerator = genModelGenerator_p;
    initializeDefaultValues();
  }

  /**
   * Initialize default attribute values.
   */
  private void initializeDefaultValues() {
    // Default values compatible with Eclipse Callisto.
    _rootExtendsInterface = EObject.class.getName();
    _rootExtendsClass = EObjectImpl.class.getName();
    _jdkComplianceLevel = getDefaultJDKComplianceLevel();
    _modelDirectory = IEgfGeneratorConstants.SRC_FOLDER;
    _resourceType = getDefaultResourceType();
    // Package suffixes.
    _implementationPackageSuffix = "impl"; //$NON-NLS-1$
    _interfacePackageSuffix = ICommonConstants.EMPTY_STRING;
    _metadataPackageSuffix = ICommonConstants.EMPTY_STRING;
    _utilityPackageSuffix = "util"; //$NON-NLS-1$
  }

  /**
   * Return the default JDK compliance level.
   * @return
   */
  private GenJDKLevel getDefaultJDKComplianceLevel() {
    return GenJDKLevel.JDK14_LITERAL;
  }

  /**
   * @see org.eclipse.egf.common.ui.actions.AbstractGenerateCodeOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException {
    Monitor monitor = BasicMonitor.toMonitor(monitor_p);
    final boolean[] result = new boolean[] { false };
    // Ensure hosting project does exist before generating anything.
    final ProjectExistenceStatus existenceStatus = ProjectHelper.ensurePluginProjectExists(_projectName);
    // Precondition.
    if (ProjectExistenceStatus.CREATION_FAILED == existenceStatus) {
      return result[0];
    }
    // Has GenModel been created (true) or reloaded and modified (false) ?
    // It has nothing to do with the fact that the hosting project was created or not.
    final boolean[] created = new boolean[] { true };
    // Update GenModel generator with parameters data.
    _genModelGenerator.setPluginId(_projectName);
    _genModelGenerator.setInputPath(_inputPath);
    _genModelGenerator.setBasePackagePrefix(_basePackage);
    _genModelGenerator.setRootExtendsInterface(_rootExtendsInterface);
    _genModelGenerator.setRootExtendsClass(_rootExtendsClass);
    _genModelGenerator.setJdkComplianceLevel(_jdkComplianceLevel);
    _genModelGenerator.setModelDirectory(_modelDirectory);
    _genModelGenerator.setResourceType(_resourceType);
    _genModelGenerator.setPackagesSuffixes(_implementationPackageSuffix, _interfacePackageSuffix, _metadataPackageSuffix, _utilityPackageSuffix);
    // Try and load GenModel first.
    GenModel genModel = loadExistingGenModel(_inputPath, PdeEmfActivator.getDefault().getAllEmfExtensionDescriptors());
    created[0] = (null == genModel);
    // Failed to load GenModel, generate it.
    if (created[0]) {
      // Remove currently 'in-production' GenModel from possible extensions.
      // Only search for extensions in the workspace.
      IEmfExtensionDescriptor[] extensions = cleanExtensions(_inputPath, PdeEmfActivator.getDefault().getWorkspaceEmfExtensionDescriptors());
      // Then register remaining ones.
      registerExtensions(extensions);
      genModel = _genModelGenerator.execute(monitor);
      // Unregister these extensions.
      unregisterExtensions(extensions);
    } else {
      // Set GenModel parameters.
      _genModelGenerator.setGenModelParameters(genModel);
    }
    result[0] = (null != genModel);
    // Create modification listener.
    IFile pluginFile = FileHelper.getPlatformFile(ICommonConstants.SLASH_CHARACTER + _projectName + IEgfGeneratorConstants.PROJECT_ROOT_FILE);
    final GenModel genModelTemp = genModel;
    if (ProjectExistenceStatus.CREATED == existenceStatus) {
      DefaultResourceListener listener = new DefaultResourceListener() {
        @Override
        protected void handleResourceChanged(IResourceChangeEvent event_p, IResource watchedResource_p) {
          // Convert the newly created project to a factory component.
          if (result[0]) {
            IProgressRunnable updatePlugin = new IProgressRunnable() {
              @SuppressWarnings("synthetic-access")
              public String getReportingTitle() {
                return Messages.ModelApiGenerator_UpdateProjectAfterCreation + _projectName;
              }

              @SuppressWarnings("synthetic-access")
              public boolean run(IProgressMonitor progressMonitor_p) {
                // If generation was successful, and project was created, but not the generation model,
                // then, EMF might have populated the plugin.xml and manifest.mf file with too much information.
                // Try to remove useless parts.
                if (!created[0]) {
                  // Remove the 'generated_package' extensions automatically added by EMF in case of a newly created project.
                  updateGeneratedPackageExtension(genModelTemp, true);
                  // Remove generated packages names from the runtime manifest.mf section.
                  updateRuntimePackages(genModelTemp, true);
                }
                // Add factory component required properties.
                EgfPdeActivator.getDefault().convertToFactoryComponent(_projectName, true);
                return true;
              }
            };
            ProgressReporter.asyncExec(updatePlugin);
          }
          // Dispose listener.
          dispose();
        }
      };
      listener.setResourceToWatch(pluginFile);
    }
    if (result[0]) {
      // Generate Java API for selected Ecore model.
      JavaApiCodeGenerator javaApiCodeGenerator = new JavaApiCodeGenerator(getGeneratorAdapterFactory());
      result[0] = javaApiCodeGenerator.generate(monitor, genModel);
      // Only update generated_package extensions and runtime if the GenModel was created.
      if (result[0] && created[0] && (ProjectExistenceStatus.ALREADY_EXISTS == existenceStatus)) {
        // Update the plugin.xml file to add the 'generated_package' extension.
        updateGeneratedPackageExtension(genModel, false);
        // Update runtime manifest.mf section with generated packages names (including implementation for pattern usability).
        updateRuntimePackages(genModel, false);
      }
    }
    // Clean genModel generator.
    _genModelGenerator.clear();
    return result[0];
  }

  /**
   * Set the interface used as root interface in EMF generation.
   * @param rootExtendsInterface_p the rootExtendsInterface to set
   */
  public void setRootExtendsInterface(String rootExtendsInterface_p) {
    _rootExtendsInterface = rootExtendsInterface_p;
  }

  /**
   * Set the class used as root class in EMF generation.
   * @param rootExtendsClass_p the rootExtendsClass to set
   */
  public void setRootExtendsClass(String rootExtendsClass_p) {
    _rootExtendsClass = rootExtendsClass_p;
  }

  /**
   * Set the JDK level compliance level.
   * @param jdkComplianceLevel_p the jdkComplianceLevel to set
   */
  public void setJdkComplianceLevel(GenJDKLevel jdkComplianceLevel_p) {
    _jdkComplianceLevel = jdkComplianceLevel_p;
  }

  /**
   * Set the resource type.
   * @param resourceType_p
   */
  public void setResourceType(GenResourceKind resourceType_p) {
    _resourceType = resourceType_p;
  }

  /**
   * Get default resource type.
   * @return
   */
  private GenResourceKind getDefaultResourceType() {
    return GenResourceKind.NONE_LITERAL;
  }

  /**
   * Set the model directory location ie the folder where the generated files are output
   * @param modelDirectory_p
   */
  public void setModelDirectory(String modelDirectory_p) {
    _modelDirectory = modelDirectory_p;
  }

  /**
   * Update runtime packages section of the manifest file with both generated public packages and the implementation siblings.
   * @param genModel_p
   * @param remove_p Should runtime packages be removed (true) or added/updated (false) ?
   */
  protected void updateRuntimePackages(GenModel genModel_p, boolean remove_p) {
    List<GenPackage> genPackages = genModel_p.getAllGenPackagesWithClassifiers();
    List<String> packagesToExport = new ArrayList<String>(0);
    for (GenPackage genPackage : genPackages) {
      String packageNameImpl = genPackage.getClassPackageName();
      if (null != packageNameImpl) {
        // Remove last segment.
        int indexOfPoint = packageNameImpl.lastIndexOf(ICommonConstants.DOT_CHARACTER);
        String packageName = null;
        if (indexOfPoint > -1) {
          packageName = packageNameImpl.substring(0, packageNameImpl.lastIndexOf(ICommonConstants.DOT_CHARACTER));
        }
        // Add both packages names.
        if (null != packageName) {
          packagesToExport.add(packageName);
          packagesToExport.add(packageName + IEgfGeneratorConstants.GENERATED_UTIL_JAVA_PACKAGE_SUFFIX);
        }
        packagesToExport.add(packageNameImpl);
      }
    }
    // Call for the manifest modification.
    if (packagesToExport.size() > 0) {
      String[] packagesNames = packagesToExport.toArray(new String[packagesToExport.size()]);
      IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
      IPluginChangesCommand command = remove_p ? ManifestChangeCommandFactory.unsetExportedPackages(packagesNames) : ManifestChangeCommandFactory.setExportedPackages(packagesNames);
      runner.performChangesOnManifest(genModel_p.getModelPluginID(), Collections.singletonList(command));
    }
  }

  /**
   * Update generated_package extensions for all generated packages in specified GenModel.
   * @param genModel_p
   * @param remove_p Should extension be removed (true) or added/updated (false) ?
   */
  protected void updateGeneratedPackageExtension(GenModel genModel_p, boolean remove_p) {
    // Get the GenModel relative path.
    String genModelPath = genModel_p.getRelativeGenModelLocation();
    // Create a plug-in changes command list.
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    // Get all generated packages.
    List<GenPackage> allGenPackagesWithClassifiers = genModel_p.getAllGenPackagesWithClassifiers();
    // Loop over generated packages and create a generated_package extension for everyone.
    for (GenPackage genPackage : allGenPackagesWithClassifiers) {
      String uri = genPackage.getNSURI();
      // Should delegate to a specific instance of a factory.
      // Since there is not much registered packages, this is acceptable to do so (unless there is a performance issue).
      if (remove_p) {
        commands.add(EmfExtensionFactory.unsetEmfGeneratedPackageExtension(uri));
      } else {
        String packageClassName = genPackage.getQualifiedPackageInterfaceName();
        commands.add(EmfExtensionFactory.setEmfGeneratedPackageExtension(uri, packageClassName, genModelPath));
      }
    }
    // Call the plug-in changes runner to apply changes.
    if (!commands.isEmpty()) {
      IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
      runner.performChangesOnPlugin(genModel_p.getModelPluginID(), commands);
    }
  }

  /**
   * Clean possible workspace extensions by removing the 'in-production' GenModel.
   * @param modelPath_p
   * @param extensions_p
   * @return
   */
  protected IEmfExtensionDescriptor[] cleanExtensions(IPath modelPath_p, Collection<IEmfExtensionDescriptor> extensions_p) {
    // Switch from ECore path to GenModel path.
    String modelPath = FileNameHelper.getGenModelPath(modelPath_p);
    for (Iterator<IEmfExtensionDescriptor> emfExtensionDescriptors = extensions_p.iterator(); emfExtensionDescriptors.hasNext();) {
      Couple<String, URI> generatedPackage = emfExtensionDescriptors.next().getGeneratedPackage();
      String nsUri = generatedPackage.getKey();
      URI physicalUri = generatedPackage.getValue();
      if ((null != physicalUri) && (physicalUri.toString().indexOf(modelPath) > 0)) {
        emfExtensionDescriptors.remove();
        // Also remove it from the ECore plug-in static map.
        // Thus, generated GenModel won't be able to reference itself (which seems to be a potential error).
        EcorePlugin.getEPackageNsURIToGenModelLocationMap().remove(nsUri);
      }
    }
    return extensions_p.toArray(new IEmfExtensionDescriptor[extensions_p.size()]);
  }

  /**
   * Register given extensions to EMF model location map.
   * @param extensions_p
   */
  protected void registerExtensions(IEmfExtensionDescriptor[] extensions_p) {
    Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
    for (IEmfExtensionDescriptor emfExtensionDescriptor : extensions_p) {
      Couple<String, URI> generatedPackage = emfExtensionDescriptor.getGeneratedPackage();
      map.put(generatedPackage.getKey(), generatedPackage.getValue());
    }
  }

  /**
   * Unregister given extensions from EMF model location map.
   * @param extensions_p
   */
  protected void unregisterExtensions(IEmfExtensionDescriptor[] extensions_p) {
    Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
    for (IEmfExtensionDescriptor emfExtensionDescriptor : extensions_p) {
      Couple<String, URI> generatedPackage = emfExtensionDescriptor.getGeneratedPackage();
      map.remove(generatedPackage.getKey());
    }
  }

  /**
   * The package suffix defines the last segment of the Java packages into which the various types of classes are generated.<br>
   * Implementation package suffix is used for model implementation classes.
   * @param implementationPackageSuffix_p
   */
  public void setImplementationPackageSuffix(String implementationPackageSuffix_p) {
    _implementationPackageSuffix = implementationPackageSuffix_p;
  }

  /**
   * The package suffix defines the last segment of the Java packages into which the various types of classes are generated.<br>
   * Interface package suffix is used for model interfaces and enumerations.
   * @param interfacePackageSuffix_p
   */
  public void setInterfacePackageSuffix(String interfacePackageSuffix_p) {
    _interfacePackageSuffix = interfacePackageSuffix_p;
  }

  /**
   * The package suffix defines the last segment of the Java packages into which the various types of classes are generated.<br>
   * Metadata package suffix is used for package and factory classes.
   * @param metadataPackageSuffix_p
   */
  public void setMetadataPackageSuffix(String metadataPackageSuffix_p) {
    _metadataPackageSuffix = metadataPackageSuffix_p;
  }

  /**
   * The package suffix defines the last segment of the Java packages into which the various types of classes are generated.<br>
   * Utility package suffix is used for switch, validator, resource, and adapter factory classes.
   * @param utilityPackageSuffix_p
   */
  public void setUtilityPackageSuffix(String utilityPackageSuffix_p) {
    _utilityPackageSuffix = utilityPackageSuffix_p;
  }
  
}