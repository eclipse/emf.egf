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
package org.eclipse.egf.core.ui.workbench.action.open;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorUtil;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;


/**
 * Implement an action that opens a domain editor for a domain model content.
 * @author Guillaume Brocard
 */
public class OpenDomainAction extends OpenModelElementAction {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(OpenDomainAction.class.getPackage().getName());

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public OpenDomainAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#getEditorId()
   */
  @Override
  protected String getEditorId() {
    String editorId = null;
    // If the action is in read only, we are opening a domain for a deployed factory component.
    // In this context, only the EMF standard editor is available.
    if (isReadOnly()) {
      editorId = IPreferenceConstants.ECORE_EDITOR_ID;
    } else {
      // Get it from the preference store.
      IPreferenceStore preferenceStore = EgfUiActivator.getDefault().getPreferenceStore();
      editorId = preferenceStore.getString(IPreferenceConstants.DOMAIN_EDITOR_ID);
    }
    return editorId;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return Domain.class;
  }

  /**
   * @see org.eclipse.jface.action.Action#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    // Default enablement.
    boolean isEnabled = super.isEnabled();
    if (isEnabled) {
      Domain domain = getDomain();
      // If the domain is defined, allow this action.
      isEnabled = ModelHelper.isDomainDefined(domain);
    }
    return isEnabled;
  }

  /**
   * Return the domain URI for current model element.
   * @return null if not found.
   */
  protected URI getDomainURI(Domain domain_p) {
    // Get the plug-in id that hosts this domain.
    FactoryComponent fcContainer = ModelHelper.getFactoryComponentContainer(domain_p);
    // Create the related URI.
    URI domainUri = FactoryComponentHelper.getDomainURI(fcContainer.getId());
    return domainUri;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.open.OpenModelElementAction#getEditorInput()
   */
  @Override
  protected IEditorInput getEditorInput() {
    IEditorInput result = null;
    Domain domain = getDomain();
    URI domainUri = getDomainURI(domain);
    if (null != domainUri) {
      // If the action is in read only, we are opening a domain for a deployed factory component.
      // In this context, only the EMF standard editor is available.
      if (isReadOnly()) {
        // The domain is located in the target platform.
        result = new URIEditorInput(domainUri);
      } else {
        // The domain is located in the workspace.
        result = handleEditorInputForDomainLocatedInWorkspace(domain, domainUri);
      }
    }
    return result;
  }

  private IEditorInput handleEditorInputForDomainLocatedInWorkspace(Domain domain_p, URI domainUri_p) {
    IEditorInput result = null;
    // Get the editor used to open the domain.
    String editorId = getEditorId();
    // Is it the standard EMF one ?
    if (IPreferenceConstants.ECORE_EDITOR_ID.equals(editorId)) {
      // Create the editor input handled by the Ecore editor.
      result = new URIEditorInput(domainUri_p);
    }
    // Is it the Graphical one ?
    else if (IPreferenceConstants.GRAPHICAL_ECORE_EDITOR_ID.equals(editorId)) {
      // Check if an Ecore diagram file exists.
      IPath ecoreDiagramPath = new Path(domain_p.getPath());
      // Remove the ecore file extension.
      ecoreDiagramPath = ecoreDiagramPath.removeFileExtension();
      // Add the ecoredi file extension
      ecoreDiagramPath = ecoreDiagramPath.addFileExtension(ICommonConstants.ECORE_DIAGRAM_FILE_EXTENSION);
      // Get the project that hosts this mapping model.
      IProject project = ModelHelper.getProject(domain_p);
      if (null != project) {
        // Get the ecore diagram file.
        IFile ecoreDiagramFile = project.getFile(ecoreDiagramPath);
        if (null != ecoreDiagramFile) {
          if (ecoreDiagramFile.exists()) {
            // Create the editor input handled by the Graphical editor.
            result = new FileEditorInput(ecoreDiagramFile);
          } else {
            // Create the diagram and open directly.
            createAndOpenEcoreDiagram(domainUri_p, URI.createPlatformResourceURI(ecoreDiagramFile.getFullPath().toString(), true));
            // Force to return a null IEditor input.
            result = null;
          }
        }
      }
    }
    return result;
  }

  /**
   * Create the Ecore diagram and open it.
   * @param domainUri_p
   * @param diagramUri_p
   */
  private void createAndOpenEcoreDiagram(final URI domainUri_p, final URI diagramUri_p) {
    WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
      /**
       * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      protected void execute(final IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException {
        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
          public void run() {
            try {
              // Get the root object used to initialize the diagram.
              EObject diagramEObject = getDiagramEObject(domainUri_p);
              // Create the diagram.
              Resource diagram =
                  EcoreDiagramEditorUtil.createDiagramOnly(diagramUri_p, domainUri_p, diagramEObject, true /* initialized the diagram */, monitor_p);
              // Try to open the diagram
              EcoreDiagramEditorUtil.openDiagram(diagram);
            } catch (PartInitException exception_p) {
              StringBuilder loggerMessage = new StringBuilder(".run(..) _ "); //$NON-NLS-1$
              __logger.warn(loggerMessage.toString(), exception_p);
            }
          }
        });
      }
    };
    try {
      PlatformUI.getWorkbench().getProgressService().run(true /* fork */, false /* not cancelable */, operation);
    } catch (InvocationTargetException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("OpenGraphicalDomainAction.run(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);

    } catch (InterruptedException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("OpenGraphicalDomainAction.run(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);

    }
  }

  /**
   * Get the diagram root object.
   * @return
   */
  private EObject getDiagramEObject(URI domainUri_p) {
    EObject result = null;
    // Create a resource set to open the domain resource
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource domain = resourceSet.getResource(domainUri_p, true);
    // Get the model root object.
    result = domain.getContents().get(0);
    return result;
  }

  // /**
  // * Get diagram id.
  // * @param diagramDescriptors_p
  // * @return null if not found.
  // */
  // private String getDiagramId(DiagramDescriptor[] diagramDescriptors_p) {
  // String editorId = null;
  // if (diagramDescriptors_p.length > 0) {
  // editorId = diagramDescriptors_p[0].getId();
  // }
  // return editorId;
  // }

  /**
   * Return the domain.
   * @return
   */
  private Domain getDomain() {
    Domain domain = (Domain) getModelElement();
    return domain;
  }
}