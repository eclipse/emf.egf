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
package org.eclipse.egf.plugin.gen.task;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.generator.IEgfGeneratorConstants;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.helper.ProjectHelper.ProjectExistenceStatus;
import org.eclipse.egf.common.listener.DefaultResourceListener;
import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.pde.EgfPdeActivator;


/**
 * Create plug-in task.
 * @author Guillaume Brocard
 */
public class CreatePluginTask extends AbstractTask {
  
  /**
   * Context element 'create as FC' key.
   */
  protected static final String CONTEXT_ELEMENT_CREATE_FC = "createAsFactoryComponent"; //$NON-NLS-1$
  
  /**
   * Context element 'project name' key.
   */
  protected static final String CONTEXT_ELEMENT_PROJECT_NAME = "projectName"; //$NON-NLS-1$
  
  /**
   * Has manifest been created yet ?
   */
  protected volatile boolean _manifestCreated;

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    // Re-init creation flag.
    _manifestCreated = false;
    final boolean[] result = new boolean[] { false };
    final String projectName = (String) getContextElementValue(CONTEXT_ELEMENT_PROJECT_NAME);
    // Precondition.
    if (projectName == null) {
      return result[0];
    }
    // Should it be converted to a FC ?
    Boolean createAsFC = (Boolean) getContextElementValue(CONTEXT_ELEMENT_CREATE_FC);
    boolean makeItAFC = false;
    if (createAsFC != null) {
      makeItAFC = createAsFC.booleanValue();
    }
    // First of all, make sure project exists.
    ProjectExistenceStatus projectExistence = ProjectHelper.ensureProjectExists(projectName);
    final IProject project = ProjectHelper.getProject(projectName);
    // Add a listener to convert to FC in case it starts with a Java project.
    // In this case, it is required to convert the project to a plug-in project first.
    // That part is done by the convertToPlugin code later.
    // But then, the conversion to a FC cannot be done sequentially, for the manifest.mf file is accessible at an unknown time.
    // This is why there is a need for a listener on manifest.mf changes.
    FactoryComponent existingFC = EgfPdeActivator.getDefault().getFactoryComponent(project);
    // Do not try to convert to FC if it is not asked to.
    if (makeItAFC) {
      // Test if not already a FC first.
      // Do not try and convert an existing FC.
      if (existingFC == null && ProjectExistenceStatus.CREATED.equals(projectExistence)) {
        new DefaultResourceListener() {
          @Override
          protected void handleResourceChanged(IResourceChangeEvent event_p, IResource watchedResource_p) {
            // That requires that project already be a plug-in.
            // This is the part triggered by the convertToPlugin call.
            if (result[0]) {
              // First of all, make sure the listener won't bother the execution anymore.
              // For instance, asyncConverttoFc is modifying the manifest.mf file, thus sending a new event towards this listener.
              // But since it's not recommended to convert it twice, removing the listener seems reasonable.
              dispose();
              // Go for conversion.
              asyncConvertToFc(projectName);
            }
          }
        }.setResourceToWatch(project.getFile(IEgfGeneratorConstants.PROJECT_ROOT_FILE));
      }
    }
    // Handle the project creation result.
    if (ProjectExistenceStatus.CREATION_FAILED.equals(projectExistence)) {
      // Creation failed, return here.
      return result[0];
    } else if (ProjectExistenceStatus.CREATED.equals(projectExistence)) {
      // This is resulting in a creation of the manifest.mf file, thus awaking the previously registered listener.
      // Register another one to ensure end of creation.
      new DefaultResourceListener() {
        @Override
        protected void handleResourceChanged(IResourceChangeEvent event_p, IResource watchedResource_p) {
          dispose();
          _manifestCreated = true;
        }
      }.setResourceToWatch(project.getFile(IEgfGeneratorConstants.PROJECT_ROOT_FILE));
      // This is a fresh new project, convert it to plug-in.
      result[0] = EgfPdeActivator.getDefault().convertToPlugin(projectName);
    } else {
      // Plug-in already exists.
      result[0] = ProjectExistenceStatus.ALREADY_EXISTS.equals(projectExistence);
      _manifestCreated = true;
      // Should it be converted to a FC ?
      // And by the way, is it not already a FC ?
      if (makeItAFC && existingFC == null) {
        // Nope, convert it to FC.
        // In this case, the listener has not been registered earlier, so there is no reason asyncConvertToFc might be invoked twice.
        asyncConvertToFc(projectName);
      }
    }
    while (_manifestCreated == false) {
      try {
        // Wait 0.2s for the plug-in to be created entirely.
        Thread.sleep(200);
      } catch (InterruptedException exception_p) {
        // Try again !
      }
    }
    return result[0];
  }

  /**
   * Asynchronously convert named plug-in to a FC.
   * @param projectName_p
   */
  protected void asyncConvertToFc(final String projectName_p) {
    IProgressRunnable convertToFc = new IProgressRunnable() {
      public String getReportingTitle() {
        return StringHelper.formatMessage(Messages.CreatePluginTask_ConvertToFcProgressMessage, new Object[] { projectName_p });
      }
      public boolean run(IProgressMonitor progressMonitor_p) {
        EgfPdeActivator.getDefault().convertToFactoryComponent(projectName_p);
        return true;
      }
    };
    ProgressReporter.asyncExec(convertToFc);
  }
  
}
