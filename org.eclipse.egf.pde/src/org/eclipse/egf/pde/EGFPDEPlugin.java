/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ISaveContext;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.ISavedState;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.egf.core.fcore.IResourceFcoreListener;
import org.eclipse.egf.pde.internal.FcoreGeneratorHelper;
import org.eclipse.egf.pde.internal.plugin.command.PluginChangesCommandRunner;
import org.eclipse.egf.pde.internal.plugin.extension.FcoreExtensionFactory;
import org.eclipse.egf.pde.internal.resource.FcoreResourceListener;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.egf.pde.plugin.extension.IFcoreExtensionFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.ui.wizards.tools.ConvertProjectToPluginOperation;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFPDEPlugin extends EGFAbstractUIPlugin implements ISaveParticipant {

  /**
   * Constant that defines the Plug-in file name.
   */
  public static final String PLUGIN_FILE_NAME = "plugin.xml"; //$NON-NLS-1$

  /**
   * Constant that defines the Plug-in file name.
   */
  public static final String FRAGMENT_FILE_NAME = "fragment.xml"; //$NON-NLS-1$  

  /**
   * Constant that defines the bundle manifest file name.
   */
  public static final String MANIFEST_FILE_NAME = "META-INF/MANIFEST.MF"; //$NON-NLS-1$

  /**
   * The shared instance
   */
  private static EGFPDEPlugin __plugin;

  /**
   * The unique command runner to perform changes in plug-ins.
   */
  private IPluginChangesCommandRunner _pluginChangesCommandRunner;

  /**
   * Fcore Resource listener
   */
  private FcoreResourceListener _fcoreResourceListener;

  /**
   * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
    // Listener initalization
    _fcoreResourceListener = new FcoreResourceListener();
    // process deltas since last activated in indexer thread so that indexes are
    // up-to-date.
    // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=38658
    final IWorkspace workspace = ResourcesPlugin.getWorkspace();
    Job processSavedState = new Job(EGFPDEMessages.savedState_jobName) {
      @Override
      protected IStatus run(IProgressMonitor monitor) {
        try {
          // add save participant and process delta atomically
          // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=59937
          workspace.run(new IWorkspaceRunnable() {
            public void run(IProgressMonitor progress) throws CoreException {
              ISavedState savedState = workspace.addSaveParticipant(EGFPDEPlugin.getDefault(), EGFPDEPlugin.this);
              if (savedState != null) {
                // the event type coming from the saved state is always
                // POST_BUILD
                // force it to be POST_CHANGE so that the delta processor can
                // handle it
                EGFPDEPlugin.this._fcoreResourceListener._overridenEventType = IResourceChangeEvent.POST_CHANGE;
                savedState.processResourceChangeEvents(EGFPDEPlugin.this._fcoreResourceListener);
              }
            }
          }, monitor);
        } catch (CoreException e) {
          return e.getStatus();
        }
        return Status.OK_STATUS;
      }
    };
    processSavedState.setSystem(true);
    processSavedState.setPriority(Job.SHORT); // process asap
    processSavedState.schedule();
  }

  public void doneSaving(ISaveContext saveContext) {
    // Nothing to do
  }

  public void prepareToSave(ISaveContext saveContext) throws CoreException {
    // Nothing to do
  }

  public void rollback(ISaveContext saveContext) {
    // Nothing to do
  }

  public void saving(ISaveContext saveContext) throws CoreException {
    // no state to be saved by the plug-in, but request a
    // resource delta to be used on next activation.
    saveContext.needDelta();
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    // Stop our listeners
    _fcoreResourceListener.dispose();
    _fcoreResourceListener = null;
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static EGFPDEPlugin getDefault() {
    return __plugin;
  }

  /**
   * Get a factory component extension helper.
   * 
   * @return
   */
  public static IFcoreExtensionFactory getFcoreExtensionHelper() {
    return FcoreExtensionFactory.getInstance();
  }

  /**
   * Add a listener
   * 
   * @param listener
   *          the listener to be added
   */
  public void addResourceFcoreListener(IResourceFcoreListener listener) {
    _fcoreResourceListener.addResourceFcoreListener(listener);
  }

  /**
   * Remove a listener
   * 
   * @param listener
   *          the listener to be removed
   */
  public void removeResourceFcoreListener(IResourceFcoreListener listener) {
    _fcoreResourceListener.removeResourceFcoreListener(listener);
  }

  /**
   * Get the plug-in file from an {@link IPluginModelBase} element.
   * 
   * @param pluginModelBase_p
   * @return null if file does not exist.
   */
  public IFile getFile(IPluginModelBase pluginModelBase_p) {
    return getFile(ProjectHelper.getProject(pluginModelBase_p));
  }

  /**
   * Get the plug-in file for given project.
   * 
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
   * 
   * @param resource_p
   * @return true if given resource is the plug-in file (plugin.xml); false
   *         otherwise.
   */
  public boolean isPluginFile(IResource resource_p) {
    // Check if given resource is an IFile and the plug-in file ?
    if (resource_p != null && resource_p instanceof IFile) {
      return ((IFile) resource_p).getName().equals(PLUGIN_FILE_NAME);
    }
    return false;
  }

  /**
   * Get the plug-in changes command runner that is able to execute
   * {@link IPluginChangesCommand} commands.
   * 
   * @return a not null object.
   */
  public static IPluginChangesCommandRunner getPluginChangesCommandRunner() {
    // Lazy creation pattern.
    if (getDefault()._pluginChangesCommandRunner == null) {
      getDefault()._pluginChangesCommandRunner = new PluginChangesCommandRunner();
    }
    return getDefault()._pluginChangesCommandRunner;
  }

  /**
   * Add an entry with specified entry name in the binary build for given
   * project.
   */
  public void addEntryInBinaryBuild(IProject project_p, String entryName_p) {
    // Preconditions.
    if (project_p == null || entryName_p == null) {
      return;
    }
    WorkspaceBuildModel buildModel = FcoreGeneratorHelper.getBuildModel(project_p);
    if (buildModel != null) {
      FcoreGeneratorHelper.addEntryInBinaryBuild(buildModel, entryName_p);
      buildModel.save();
    }
  }

  /**
   * Convert named project to a valid plug-in project.
   * 
   * @param projectName_p
   * @return
   */
  public void convertToPlugin(IProject project_p) {
    // Precondition.
    if (project_p == null) {
      return;
    }
    // PDE Project converter operation
    IRunnableWithProgress convertOperation = new ConvertProjectToPluginOperation(new IProject[] { project_p });
    try {
      convertOperation.run(new NullProgressMonitor());
    } catch (InvocationTargetException ite) {
      EGFPDEPlugin.getDefault().logError(NLS.bind("EGFPDEPlugin.convertToPlugin(..) _ Project: '{0}'", //$NON-NLS-1$
          project_p.getName()), ite);
    } catch (InterruptedException ie) {
      // Nothing to do
    }
  }

}