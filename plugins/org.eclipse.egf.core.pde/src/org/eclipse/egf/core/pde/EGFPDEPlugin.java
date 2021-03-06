/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde;

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
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.egf.core.fcore.IResourceFcoreListener;
import org.eclipse.egf.core.pde.extension.IFcoreExtensionFactory;
import org.eclipse.egf.core.pde.internal.FcoreGeneratorHelper;
import org.eclipse.egf.core.pde.internal.extension.FcoreExtensionFactory;
import org.eclipse.egf.core.pde.internal.resource.FcoreResourceListener;
import org.eclipse.egf.core.pde.l10n.EGFPDEMessages;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFPDEPlugin extends EGFAbstractUIPlugin implements ISaveParticipant {

    /**
     * The shared instance
     */
    private static EGFPDEPlugin __plugin;

    /**
     * Fcore Resource listener
     */
    private FcoreResourceListener _fcoreResourceListener;

    /**
     * Return the display.
     * 
     * @return display
     */
    public static Display getDisplay() {
        // Get the display.
        Display display = null;
        if (PlatformUI.isWorkbenchRunning()) {
            display = PlatformUI.getWorkbench().getDisplay();
        } else {
            // Case of the headless mode.
            display = Display.getDefault();
        }
        return display;
    }

    /**
     * Returns the currently active window for this workbench (if any). Returns
     * <code>null</code> if there is no active workbench window. Returns
     * <code>null</code> if called from a non-UI thread.
     * 
     * @return the active workbench window, or <code>null</code> if there is
     *         no active workbench window or if called from a non-UI thread
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        return getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    /**
     * Returns the currently active shell for this workbench (if any).
     * 
     * @return the active workbench shell.
     */
    public static Shell getActiveWorkbenchShell() {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = getDefault().getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0].getShell();
            }
        } else {
            return window.getShell();
        }
        return null;
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    @SuppressWarnings("deprecation")
    public void start(BundleContext context) throws Exception {
        super.start(context);
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
                        	if (__plugin == null) {
                        		return;
                        	}
                        	
                        	// Preserve deprecated API for backward compatibility
                            ISavedState savedState = workspace.addSaveParticipant(__plugin, __plugin);
                            if (savedState != null) {
                                // the event type coming from the saved state is always POST_BUILD
                                // force it to be POST_CHANGE so that the delta processor can handle it
                                _fcoreResourceListener._overridenEventType = IResourceChangeEvent.POST_CHANGE;
                                savedState.processResourceChangeEvents(_fcoreResourceListener);
                                _fcoreResourceListener._overridenEventType = -1;
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
        processSavedState.setPriority(Job.SHORT);
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
    public void stop(BundleContext context) throws Exception {
        // Stop our listeners
        _fcoreResourceListener.dispose();
        _fcoreResourceListener = null;
        super.stop(context);
        __plugin = null;
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
     * @return IFcoreExtensionFactory
     */
    public static IFcoreExtensionFactory getFcoreExtensionHelper() {
        return FcoreExtensionFactory.getInstance();
    }

    /**
     * Add a listener
     * 
     * @param listener
     *            the listener to be added
     */
    public void addResourceFcoreListener(IResourceFcoreListener listener) {
        _fcoreResourceListener.addResourceFcoreListener(listener);
    }

    /**
     * Remove a listener
     * 
     * @param listener
     *            the listener to be removed
     */
    public void removeResourceFcoreListener(IResourceFcoreListener listener) {
        _fcoreResourceListener.removeResourceFcoreListener(listener);
    }

    /**
     * Get the plug-in file from an {@link IPluginModelBase} element.
     * 
     * @param pluginModelBase
     * @return null if file does not exist.
     */
    public IFile getFile(IPluginModelBase pluginModelBase) {
        return getFile(ProjectHelper.getProject(pluginModelBase));
    }

    /**
     * Get the plug-in file for given project.
     * 
     * @param project
     * @return null if file does not exist.
     */
    public IFile getFile(IProject project) {
        // Precondition.
        if (project == null) {
            return null;
        }
        IFile plugin = project.getFile(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR);
        return plugin.exists() ? plugin : null;
    }

    /**
     * Is the given file the plug-in file hosts in an {@link IProject}.
     * 
     * @param resource
     * @return true if given resource is the plug-in file (plugin.xml); false
     *         otherwise.
     */
    public boolean isPluginFile(IResource resource) {
        // Check if given resource is an IFile and the plug-in file ?
        if (resource != null && resource instanceof IFile) {
            return ((IFile) resource).getName().equals(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR);
        }
        return false;
    }

    /**
     * Add an entry with specified entry name in the binary build for given
     * project.
     */
    public void addEntryInBinaryBuild(IProject project, String entryName) throws CoreException {
        // Preconditions.
        if (project == null || entryName == null) {
            return;
        }
        WorkspaceBuildModel buildModel = FcoreGeneratorHelper.getBuildModel(project);
        FcoreGeneratorHelper.addEntryInBinaryBuild(buildModel, entryName);
        buildModel.save();
    }

}
