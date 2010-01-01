/**
 * <copyright>
 * 
 * Copyright (c) 2004-2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * 
 * </copyright>
 * 
 * $Id: ValidateAction.java,v 1.28 2009/04/30 14:24:52 emerks Exp $
 */
package org.eclipse.egf.core.ui.diagnostic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.ui.diagnostic.ThrowableHandler;
import org.eclipse.egf.common.ui.emf.EMFEditUIHelper;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.ui.part.ISetSelectionTarget;

public class EGFValidator {

  private Collection<? extends EObject> _eObjects = new ArrayList<EObject>();

  public EGFValidator(Collection<? extends EObject> eObjects) {
    _eObjects = eObjects;
  }

  public Diagnostic validate() {

    final Diagnostic[] diagnostic = new Diagnostic[1];
    final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

    IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() {
      public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
        try {
          diagnostic[0] = validate(progressMonitor);
          shell.getDisplay().asyncExec(new Runnable() {
            public void run() {
              if (progressMonitor.isCanceled()) {
                handleDiagnostic(Diagnostic.CANCEL_INSTANCE);
              } else {
                handleDiagnostic(diagnostic[0]);
              }
            }
          });
        } finally {
          progressMonitor.done();
        }
      }
    };

    runnableWithProgress = new WorkspaceModifyDelegatingOperation(runnableWithProgress);

    try {
      // This runs the operation, and shows progress.
      // (It appears to be a bad thing to fork this onto another thread.)
      //
      new ProgressMonitorDialog(shell).run(true, true, runnableWithProgress);
    } catch (Exception exception) {
      EMFEditUIPlugin.INSTANCE.log(exception);
    }

    return diagnostic[0];

  }

  /**
   * This simply execute the command.
   */
  protected Diagnostic validate(IProgressMonitor progressMonitor) {
    int selectionSize = _eObjects.size();
    int count = selectionSize;
    for (EObject eObject : _eObjects) {
      for (Iterator<?> i = eObject.eAllContents(); i.hasNext(); i.next()) {
        ++count;
      }
    }

    progressMonitor.beginTask("", count); //$NON-NLS-1$

    Diagnostician diagnostician = createDiagnostician(progressMonitor);

    BasicDiagnostic diagnostic = new BasicDiagnostic(EObjectValidator.DIAGNOSTIC_SOURCE, 0, EMFEditUIPlugin.INSTANCE.getString("_UI_DiagnosisOfNObjects_message", new String[] { Integer.toString(selectionSize) }), _eObjects.toArray()); //$NON-NLS-1$
    Map<Object, Object> context = diagnostician.createDefaultContext();
    // Preferences
    IPreferenceStore store = EGFCoreUIPlugin.getDefault().getPreferenceStore();
    if (store.getBoolean(IEGFModelConstants.VALIDATE_TYPES)) {
      context.put(IEGFModelConstants.VALIDATE_TYPES, Boolean.TRUE);
    } else {
      context.put(IEGFModelConstants.VALIDATE_TYPES, Boolean.FALSE);
    }
    // Bundle Session
    ProjectBundleSession session = new ProjectBundleSession(EGFCoreUIPlugin.getDefault().getBundle().getBundleContext());
    context.put(ProjectBundleSession.PROJECT_BUNDLE_SESSION, session);
    // Validation
    for (EObject eObject : _eObjects) {
      progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[] { diagnostician.getObjectLabel(eObject) })); //$NON-NLS-1$
      diagnostician.validate(eObject, diagnostic, context);
    }
    // Dispose Session
    try {
      session.dispose();
    } catch (CoreException ce) {
      EGFCoreUIPlugin.getDefault().logError(ce);
    }
    return diagnostic;
  }

  protected Diagnostician createDiagnostician(final IProgressMonitor progressMonitor) {
    return new Diagnostician() {
      @Override
      public String getObjectLabel(EObject eObject) {
        return EMFHelper.getText(eObject);
      }

      @Override
      public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
        progressMonitor.worked(1);
        return super.validate(eClass, eObject, diagnostics, context);
      }
    };
  }

  protected void handleDiagnostic(Diagnostic diagnostic) {
    int severity = diagnostic.getSeverity();
    String title = null;
    String message = null;

    if (severity == Diagnostic.ERROR || severity == Diagnostic.WARNING) {
      title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_title"); //$NON-NLS-1$
      message = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_message"); //$NON-NLS-1$
    } else {
      title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationResults_title"); //$NON-NLS-1$
      message = EMFEditUIPlugin.INSTANCE.getString(severity == Diagnostic.OK ? "_UI_ValidationOK_message" : "_UI_ValidationResults_message"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    int result = 0;
    if (diagnostic.getSeverity() != Diagnostic.OK) {
      result = DiagnosticDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), title, message, diagnostic);
    }

    if (result == Window.OK) {
      if (diagnostic.getChildren().isEmpty() == false) {
        List<?> data = (diagnostic.getChildren().get(0)).getData();
        if (data.isEmpty() == false && data.get(0) instanceof EObject) {
          Object part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
          if (part instanceof ISetSelectionTarget) {
            ((ISetSelectionTarget) part).selectReveal(new StructuredSelection(data.get(0)));
          } else if (part instanceof IViewerProvider) {
            Viewer viewer = ((IViewerProvider) part).getViewer();
            if (viewer != null) {
              viewer.setSelection(new StructuredSelection(data.get(0)), true);
            }
          } else {
            URI uri = EcoreUtil.getURI((EObject) data.get(0));
            try {
              IEditorPart editorPart = EMFEditUIHelper.openEditor(uri);
              if (editorPart != null && editorPart instanceof IEditingDomainProvider) {
                EMFEditUIHelper.setSelectionToViewer(editorPart, uri);
              }
            } catch (PartInitException pie) {
              EGFCoreUIPlugin.getDefault().logError(pie);
              ThrowableHandler.displayAsyncDiagnostic(EGFCoreUIPlugin.getActiveWorkbenchShell(), pie, EGFCoreUIPlugin.getDefault().getPluginID());
            }
          }
        }
      }

    }
  }

}
