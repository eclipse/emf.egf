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
package org.eclipse.egf.pde;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.IDGeneratorHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.activator.AbstractUIActivator;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.data.FactoryComponentRegistry;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.egf.core.extensionpoint.IProductionPlanConstants;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.model.internal.data.ModelElement;
import org.eclipse.egf.pde.internal.FactoryComponentGeneratorHelper;
import org.eclipse.egf.pde.internal.plugin.command.PluginChangesCommandRunner;
import org.eclipse.egf.pde.internal.plugin.extension.ContextExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.ContractElementRefExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.ContractExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.FactoryComponentExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.FactoryComponentInvocationExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.MappingExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.ProductionPlanExtensionFactory;
import org.eclipse.egf.pde.internal.plugin.extension.TaskFactoryExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.egf.pde.plugin.extension.IContextExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IContractElementRefExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IContractExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IFactoryComponentInvocationExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IMappingExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.IProductionPlanExtensionFactory;
import org.eclipse.egf.pde.plugin.extension.ITaskFactoryExtensionFactory;
import org.eclipse.egf.pde.reader.PdeTargetPlatformReader;
import org.eclipse.egf.pde.reader.WorkspaceFactoryComponentReader;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.ui.wizards.tools.ConvertProjectToPluginOperation;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EgfPdeActivator extends AbstractUIActivator {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(EgfPdeActivator.class.getPackage().getName());
  
  /**
   * Constant that defines the Plug-in file name.
   */
  public static final String PLUGIN_FILE_NAME = "plugin.xml"; //$NON-NLS-1$
  
  /**
   * Constant that defines the bundle manifest file name.
   */
  public static final String MANIFEST_FILE_NAME = "META-INF/MANIFEST.MF"; //$NON-NLS-1$
  
  /**
   * The shared instance
   */
  private static EgfPdeActivator __plugin;
  
  /**
   * The unique command runner to perform changes in plug-ins.
   */
  private IPluginChangesCommandRunner _pluginChangesCommandRunner;

  /**
   * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Returns the shared instance
   * @return the shared instance
   */
  public static EgfPdeActivator getDefault() {
    return __plugin;
  }

  /**
   * Get a factory component extension helper.
   * @return
   */
  public IFactoryComponentExtensionFactory getFactoryComponentExtensionHelper() {
    return FactoryComponentExtensionFactory.getInstance();
  }

  /**
   * Get a contract extension helper.
   * @return
   */
  public IContractExtensionFactory getContractExtensionHelper() {
    return ContractExtensionFactory.getInstance();
  }

  /**
   * Get a contract element reference extension helper.
   * @return
   */
  public IContractElementRefExtensionFactory getContractElementRefExtensionHelper() {
    return ContractElementRefExtensionFactory.getInstance();
  }

  /**
   * Get a production plan extension helper.
   * @return
   */
  public IProductionPlanExtensionFactory getProductionPlanExtensionHelper() {
    return ProductionPlanExtensionFactory.getInstance();
  }

  /**
   * Get a factory component invocation extension helper.
   * @return
   */
  public IFactoryComponentInvocationExtensionFactory getFactoryComponentInvocationExtensionHelper() {
    return FactoryComponentInvocationExtensionFactory.getInstance();
  }

  /**
   * Get a task factory extension helper.
   * @return
   */
  public ITaskFactoryExtensionFactory getTaskFactoryExtensionHelper() {
    return TaskFactoryExtensionFactory.getInstance();
  }

  /**
   * Get a context extension helper.
   * @return
   */
  public IContextExtensionFactory getContextExtensionHelper() {
    return ContextExtensionFactory.getInstance();
  }

  /**
   * Get a mapping extension helper.
   * @return
   */
  public IMappingExtensionFactory getMappingExtensionHelper() {
    return MappingExtensionFactory.getInstance();
  }

  /**
   * Return the plug-in model for given factory component.
   * @param factoryComponent_p
   * @return null if given factory component has no {@link IPluginModelBase} adapter registered.
   */
  protected IPluginModelBase getPluginModelForFactoryComponent(FactoryComponent factoryComponent_p) {
    // Precondition.
    if (factoryComponent_p == null) {
      return null;
    }
    return (IPluginModelBase) ((ModelElement) factoryComponent_p).getAdapter(IPluginModelBase.class);
  }

  /**
   * Get the plug-in model base for given project.
   * @param project_p
   * @return an {@link IPluginModelBase} instance or null if the project is not a plug-in.
   */
  public IPluginModelBase getPluginModelBase(IProject project_p) {
    return PluginRegistry.findModel(project_p);
  }

  /**
   * Get the plug-in file where factory component is stored.
   * @param factoryComponentId_p
   * @return null if file does not exist.
   */
  public IFile getFile(String factoryComponentId_p) {
    // Get the factory component plug-in model for specified factory component id.
    return getFile(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(factoryComponentId_p));
  }

  /**
   * Get the plug-in file from an {@link IPluginModelBase} element.
   * @param pluginModelBase_p
   * @return null if file does not exist.
   */
  public IFile getFile(IPluginModelBase pluginModelBase_p) {
    return getFile(ProjectHelper.getProject(pluginModelBase_p));
  }

  /**
   * Get the plug-in file for given project.
   * @param project_p
   * @return null if file does not exist.
   */
  public IFile getFile(IProject project_p) {
    IFile result = null;
    // Precondition.
    if (project_p == null) {
      return result;
    }
    result = project_p.getFile(PLUGIN_FILE_NAME);
    // Check plug-in file existence ?
    result = result.exists() ? result : null;
    return result;
  }

  /**
   * Is the given file the plug-in file hosts in an {@link IProject}.
   * @param resource_p
   * @return true if given resource is the plug-in file (plugin.xml); false otherwise.
   */
  public boolean isPluginFile(IResource resource_p) {
    // Check if given resource is an IFile and the plug-in file ?
    if (resource_p != null && resource_p instanceof IFile) {
      return ((IFile) resource_p).getName().equals(PLUGIN_FILE_NAME);
    }
    return false;
  }

  /**
   * Get factory component id declared in given project.
   * @param project_p
   * @return the id or null if no factory component is declared in given project.
   */
  public String getFactoryComponentId(IProject project_p) {
    // Precondition
    if (project_p == null) {
      return null;
    }
    IFactoryComponentDescriptor descriptor = WorkspaceFactoryComponentReader.getDefault().readFactoryComponent(project_p);
    if (descriptor != null) {
      return descriptor.getId();
    }
    return null;
  }

  /**
   * Get the plug-in id for the given factory component located in the workspace only.
   * @param factoryComponentId_p
   * @return the plug-in id or null if not found.
   */
  public String getPluginIdForFactoryComponent(String factoryComponentId_p) {
    // Precondition.
    if (factoryComponentId_p == null) {
      return null;
    }
    // Get the plug-in id for retrieved plug-in model object (if retrieved, it has to be a plug-in).
    IPluginModelBase pluginModelBase = getPluginModelForFactoryComponent(factoryComponentId_p);
    // It should be not null
    if (pluginModelBase != null) {
      // Get the plug-in id.
      return pluginModelBase.getPluginBase().getId();
    }
    return null;
  }

  /**
   * Get the plug-in model for given factory component id.<br>
   * Look up is performed through the workspace.
   * @param factoryComponentId_p
   * @return
   */
  public IPluginModelBase getPluginModelForFactoryComponent(String factoryComponentId_p) {
    IPluginModelBase result = null;
    // Precondition
    if (factoryComponentId_p == null) {
      return result;
    }
    // First looking up from the factory component registry to get the factory component model element object.
    FactoryComponentRegistry fcRegistry = CoreActivator.getDefault().getFactoryComponentRegistry();
    FactoryComponent retrievedFc = fcRegistry.getFactoryComponent(factoryComponentId_p);
    // If the factory component is retrieved from the factory component registry, try to get the IPluginModelBase from it because it was previously loaded.
    if (retrievedFc != null) {
      result = getPluginModelForFactoryComponent(retrievedFc);
      // The plug-in model could be null if the plug-in model was unknown at project opening time.
      // Our ResourceChanged listener could be called before the one of PDE.Hence PDE does not know our project when we ask it the plug-in model.
      if (result == null) {
        // Case the plug-in model was unknown...
        // Get the related project, we got at least this data at project opening time.
        IProject fcProject = ModelHelper.getProject(retrievedFc);
        // Get it.
        result = getPluginModelBase(fcProject);
        // Set it for later usage.
        ((ModelElement) retrievedFc).setAdapter(IPluginModelBase.class, result);
      }
    } else {
      // Requested factory component is not already loaded in the registry. Try loading it from the workspace.
      // Get the workspace root.
      IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      // Get all projects within the current workspace.
      IProject[] projects = workspaceRoot.getProjects();
      // Retrieve given factory component from workspace projects.
      for (int i = 0; i < projects.length && (null == result); i++) {
        IProject project = projects[i];
        // Retrieve if current project provides an factory component.
        String projectFcId = getFactoryComponentId(project);
        // Test if factory component ids are equals.
        if (factoryComponentId_p.equals(projectFcId)) {
          // We've got it.
          result = getPluginModelBase(project);
        }
      }
    }
    return result;
  }

  /**
   * Get the project that hosts given factory component.<br>
   * Look up is performed through the workspace.
   * @param factoryComponentId_p
   * @return the project that hosts given factory component or null if not found in workspace. <br>
   *         Thus, given factory component is a deployed factory component located into the platform (either the eclipse platform itself or an extension
   *         location).
   */
  public IProject getProjectForFactoryComponent(String factoryComponentId_p) {
    IProject result = null;
    // Precondition
    if (null == factoryComponentId_p) {
      return result;
    }
    // Get plug-in model object.
    IPluginModelBase pluginModelBase = getPluginModelForFactoryComponent(factoryComponentId_p);
    // It should be not null
    if (null != pluginModelBase) {
      // Get the IResource as an IProject.
      result = ProjectHelper.getProject(pluginModelBase);
    }
    return result;
  }

  /**
   * Get the collection of existing factory components in current workspace.
   * @return a not null collection.
   */
  public Collection<FactoryComponent> getFactoryComponentsInWorkspace() {
    ArrayList<FactoryComponent> resultingFcList = new ArrayList<FactoryComponent>(0);
    // Loop over plug-in projects to retrieve these ones that contain a factory component.
    for (IProject project : getPluginProjects()) {
      FactoryComponent fc = getFactoryComponent(project);
      // Add it if only the current project contains a factory component.
      if (null != fc) {
        // Add it to the resulting list.
        resultingFcList.add(fc);
      }
    }
    return resultingFcList;
  }

  /**
   * Get all factory components in the target platform referenced by the current running Eclipse IDE instance.<br>
   * DO NOT USE : Experimental.
   * @return
   */
  public Collection<FactoryComponent> getFactoryComponentsInTargetPlatform() {
    ArrayList<FactoryComponent> result = new ArrayList<FactoryComponent>(0);
    IPluginModelBase[] targetPlatformModels = PluginRegistry.getExternalModels();
    // Instantiate a reader that is able to retrieve factory component in workspace.
    PdeTargetPlatformReader reader = PdeTargetPlatformReader.getDefault();
    // Loop over plug-in models to retrieve these ones that contain a factory component.
    for (IPluginModelBase pluginModel : targetPlatformModels) {
      IFactoryComponentDescriptor descriptor = reader.readFactoryComponent(pluginModel);
      // If the factory component descriptor is successfully read, instantiate it.
      if (null != descriptor) {
        FactoryComponent fc = CoreActivator.getDefault().getFactoryComponent(descriptor);
        ModelElement modelElement = ((ModelElement) fc);
        if ((null != fc) && (null == modelElement.getAdapter(IPluginModelBase.class))) {
          // Set the related IPluginModelBase that hosts this instantiated factory component to improve load-time performances.
          modelElement.setAdapter(IPluginModelBase.class, pluginModel);
        }
        result.add(fc);
      }
    }
    return result;
  }

  /**
   * Get all plug-in projects located in the workspace.
   * @return a not null collection.
   */
  public Collection<IProject> getPluginProjects() {
    ArrayList<IProject> pluginProjects = new ArrayList<IProject>(0);
    IPluginModelBase[] workspaceModels = PluginRegistry.getWorkspaceModels();
    // Loop over plug-in models to retrieve these ones that contain an factory component.
    for (IPluginModelBase pluginModel : workspaceModels) {
      IProject project = ProjectHelper.getProject(pluginModel);
      if (null != project) {
        pluginProjects.add(project);
      }
    }
    return pluginProjects;
  }

  /**
   * Return the factory component contained by given plug-in id.
   * @param pluginId_p
   * @return null if the given plug-in does not contain an {@link FactoryComponent}.
   */
  public FactoryComponent getFactoryComponentForPluginId(String pluginId_p) {
    FactoryComponent result = null;
    // Get all plug-ins in the workspace.
    IPluginModelBase[] workspaceModels = PluginRegistry.getWorkspaceModels();
    // Loop over the retrieved plug-in models.
    for (int i = 0; i < workspaceModels.length && (null == result); i++) {
      IPluginModelBase currentPlugin = workspaceModels[i];
      // Check if the current plug-in model has the given plug-in id.
      if (pluginId_p.equals(currentPlugin.getPluginBase().getId())) {
        // Get its project.
        IProject project = ProjectHelper.getProject(currentPlugin);
        // Get its factory component.
        result = getFactoryComponent(project);
      }
    }
    return result;
  }

  /**
   * Return the factory component for given project.
   * @param project_p
   * @return null if the project does not contain a factory component.
   */
  public FactoryComponent getFactoryComponent(IProject project_p) {
    // Check if a factory component is already loaded for current project.
    FactoryComponent fc = getFactoryComponentForProject(project_p);
    // If not, load it in reading a descriptor.
    if (null == fc) {
      // Instantiate a reader that is able to retrieve factory component in workspace.
      WorkspaceFactoryComponentReader reader = WorkspaceFactoryComponentReader.getDefault();
      IFactoryComponentDescriptor descriptor = reader.readFactoryComponent(project_p);
      // If the factory component descriptor is successfully read, instantiate it.
      if (null != descriptor) {
        fc = CoreActivator.getDefault().getFactoryComponent(descriptor);
        if (null != fc) {
          // Set the related IPluginModelBase that hosts this instantiated factory component to improve load-time performances.
          IPluginModelBase pluginModelBase = getPluginModelBase(project_p);
          ModelElement modelElement = ((ModelElement) fc);
          modelElement.setAdapter(IPluginModelBase.class, pluginModelBase);
          // Set the related project because the plug-in model could be unknown when opening a project from the package explorer.
          // Indeed, our ResourceChangedListener in FactoryComponentExplorerContentProvider class could be called before the PDE's one.
          // Hence, PDE does not know this project when we ask it its related plug-in model.
          modelElement.setAdapter(IProject.class, project_p);
        }
      }
    }
    return fc;
  }

  /**
   * Get the related factory component from the factory component registry for given project.
   * @param project_p
   * @return null if not found.
   */
  protected FactoryComponent getFactoryComponentForProject(IProject project_p) {
    FactoryComponent result = null;
    // Precondition.
    if (null == project_p) {
      return result;
    }
    Iterator<FactoryComponent> fcs = CoreActivator.getDefault().getFactoryComponentRegistry().getFactoryComponents().iterator();
    while (fcs.hasNext() && (null == result)) {
      FactoryComponent currentFc = fcs.next();
      IPluginModelBase pluginModelBase = getPluginModelForFactoryComponent(currentFc);
      if (project_p == ProjectHelper.getProject(pluginModelBase)) {
        result = currentFc;
      }
    }
    return result;
  }

  /**
   * Get the plug-in changes command runner that is able to execute {@link IPluginChangesCommand} commands.
   * @return a not null object.
   */
  public IPluginChangesCommandRunner getPluginChangesCommandRunner() {
    // Lazy creation pattern.
    if (null == _pluginChangesCommandRunner) {
      _pluginChangesCommandRunner = new PluginChangesCommandRunner();
    }
    return _pluginChangesCommandRunner;
  }

  /**
   * Add an entry with specified entry name in the binary build for given project.
   */
  public void addEntryInBinaryBuild(IProject project_p, String entryName_p) {
    // Preconditions.
    if ((null == project_p) || (null == entryName_p)) {
      return;
    }
    WorkspaceBuildModel buildModel = FactoryComponentGeneratorHelper.getBuildModel(project_p);
    if (null != buildModel) {
      FactoryComponentGeneratorHelper.addEntryInBinaryBuild(buildModel, entryName_p);
      buildModel.save();
    }
  }

  /**
   * Convert identified plug-in to a factory component.
   * @param pluginId_p That includes required dependencies (set as mandatory in this case).
   */
  public void convertToFactoryComponent(String pluginId_p) {
    convertToFactoryComponent(pluginId_p, false);
  }

  /**
   * Convert identified plug-in to a factory component by adding specific properties (extensions).
   * @param pluginId_p
   * @param makeItOptional_p Converting to a FC also implies new dependencies. Maybe those should be optional (true) or remain mandatory (false).
   */
  public void convertToFactoryComponent(String pluginId_p, boolean makeItOptional_p) {
    // Precondition : check given plug-in id has a workspace project with the same value as name.
    boolean canBeConverted = ProjectHelper.canBeConvertedToFC(pluginId_p);
    if (!canBeConverted) {
      return;
    }
    // Add dependencies.
    FactoryComponentGeneratorHelper.addStandardFactoryComponentDependencies(pluginId_p, makeItOptional_p);
    // Create the minimal factory component structure in the plugin.xml file.
    String fcId = IDGeneratorHelper.generatePrefixUID(IFactoryComponentConstants.FACTORY_COMPONENT_EXTENSION_CHILD);
    String productionPlanId = IDGeneratorHelper.generatePrefixUID(IProductionPlanConstants.PRODUCTION_PLAN_EXTENSION_CHILD);
    String contractId = IDGeneratorHelper.generatePrefixUID(IContractConstants.CONTRACT_EXTENSION_CHILD);
    List<IPluginChangesCommand> commandsOnPlugin = new ArrayList<IPluginChangesCommand>(3);
    commandsOnPlugin.add(getFactoryComponentExtensionHelper().setFactoryComponentExtension(fcId, pluginId_p, contractId, null, productionPlanId,
        ICommonConstants.EMPTY_STRING));
    commandsOnPlugin.add(getProductionPlanExtensionHelper().setProductionPlanExtension(productionPlanId, ICommonConstants.EMPTY_STRING));
    commandsOnPlugin.add(getContractExtensionHelper().setContract(contractId));
    IPluginChangesCommandRunner changesCommandRunner = getPluginChangesCommandRunner();
    changesCommandRunner.performChangesOnPlugin(pluginId_p, commandsOnPlugin);
    // Add the 'generated' source folder if missing.
    FactoryComponentGeneratorHelper.addGeneratedSourceFolderIn(pluginId_p, true);
    // Add the 'templates' folder if missing.
    FactoryComponentGeneratorHelper.addFolderIn(pluginId_p, ICommonConstants.TEMPLATES_FOLDER_PATH, true, new NullProgressMonitor());
    // Add the 'model' folder if missing.
    FactoryComponentGeneratorHelper.addFolderIn(pluginId_p, ICommonConstants.MODEL_FOLDER_PATH, true, new NullProgressMonitor());
  }

  /**
   * Convert named project to a valid plug-in project.
   * @param projectName_p
   * @return
   */
  public boolean convertToPlugin(String projectName_p) {
    boolean result = false;
    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName_p);
    // Precondition.
    if (null == project) {
      return result;
    }
    IRunnableWithProgress convertOperation = new ConvertProjectToPluginOperation(new IProject[] { project });
    try {
      convertOperation.run(new NullProgressMonitor());
      result = true;
    } catch (Exception exception_p1) {
      StringBuilder loggerMessage = new StringBuilder("EgfPdeActivator.convertToPlugin(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p1);
    }
    return result;
  }
}