/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pde.emf;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.activator.AbstractActivator;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.pde.emf.reader.PdeEmfReader;
import org.eclipse.egf.pde.emf.reader.PlatformEmfExtensionReader;
import org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor;
import org.osgi.framework.BundleContext;


/**
 * @author Guillaume Brocard
 */
public class PdeEmfActivator extends AbstractActivator {
  /**
   * The shared instance
   */
  private static PdeEmfActivator __plugin;

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
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
  public static PdeEmfActivator getDefault() {
    return __plugin;
  }

  /**
   * Get EMF generated_package extensions available in workspace.
   * @return An empty collection if none could be found.
   */
  @SuppressWarnings("unchecked")
  public Collection<IEmfExtensionDescriptor> getWorkspaceEmfExtensionDescriptors() {
    ArrayList<IEmfExtensionDescriptor> emfExtensions = new ArrayList<IEmfExtensionDescriptor>(0);
    // Get the workspace.
    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
    // Get all projects within this workspace.
    IProject[] projects = workspaceRoot.getProjects();
    // Instantiate a reader that is able to retrieve emf extensions in workspace.
    PdeEmfReader reader = new PdeEmfReader();
    // Loop over projects to retrieve those containing an emf extension.
    for (IProject project : projects) {
      IDescriptor descriptor = reader.readEmfExtension(project);
      if (null != descriptor) {
        emfExtensions.addAll((Collection<? extends IEmfExtensionDescriptor>) descriptor.getChildren());
      }
    }
    return emfExtensions;
  }

  /**
   * Get EMF generated_package extensions available in workspace and in the platform.
   * @return An empty collection if none could be found.
   */
  @SuppressWarnings("unchecked")
  public Collection<IEmfExtensionDescriptor> getAllEmfExtensionDescriptors() {
    ArrayList<IEmfExtensionDescriptor> emfExtensions = new ArrayList<IEmfExtensionDescriptor>(0);
    // Add extensions from the workspace.
    emfExtensions.addAll(getWorkspaceEmfExtensionDescriptors());
    // Add extensions from the platform (deployed ones).
    IDescriptor descriptor = new PlatformEmfExtensionReader().readEmfExtensions();
    emfExtensions.addAll((Collection<? extends IEmfExtensionDescriptor>) descriptor.getChildren());
    return emfExtensions;
  }
}
