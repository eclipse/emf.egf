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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.ui.part.ISetSelectionTarget;

public class EGFValidator {

  private List<? extends EObject> _eObjects = new ArrayList<EObject>();

  public EGFValidator(List<? extends EObject> eObjects) {
    _eObjects = eObjects;
  }

  public Diagnostic validate() {

    // Nothing to do
    if (_eObjects == null || _eObjects.size() == 0) {
      return Diagnostic.OK_INSTANCE;
    }

    final Diagnostic[] diagnostic = new Diagnostic[1];
    final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

    IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress() {
      public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        try {
          diagnostic[0] = validate(monitor);
          shell.getDisplay().asyncExec(new Runnable() {
            public void run() {
              if (monitor.isCanceled()) {
                return;
              }
              int severity = diagnostic[0].getSeverity();
              if (severity == Diagnostic.ERROR || severity == Diagnostic.WARNING) {
                handleDiagnostic(EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_title"), EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_message"), diagnostic[0]); //$NON-NLS-1$ //$NON-NLS-2$
              }
            }
          });
        } finally {
          monitor.done();
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
  protected Diagnostic validate(IProgressMonitor monitor) {
    int selectionSize = _eObjects.size();
    int count = selectionSize;
    for (EObject eObject : _eObjects) {
      for (Iterator<?> i = eObject.eAllContents(); i.hasNext(); i.next()) {
        ++count;
      }
    }

    monitor.beginTask("", count); //$NON-NLS-1$

    Diagnostician diagnostician = createDiagnostician(monitor);

    String message = NLS.bind(CoreUIMessages._UI_DiagnosisOfNObjects_message, Integer.toString(selectionSize));
    if (_eObjects.size() == 1) {
      message = NLS.bind(CoreUIMessages._UI_DiagnosisOfNObject_message, EMFHelper.getText(_eObjects.get(0)));
    }
    BasicDiagnostic diagnostic = new BasicDiagnostic(EGFCoreUIPlugin.getDefault().getPluginID(), 0, message, _eObjects.toArray());
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
      monitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[] { diagnostician.getObjectLabel(eObject) })); //$NON-NLS-1$
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

  public static void handleDiagnostic(String title, String message, Diagnostic diagnostic) {

    int result = 0;

    EGFDiagnosticDialog dialog = new EGFDiagnosticDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), title, message, diagnostic, Diagnostic.OK | Diagnostic.INFO | Diagnostic.WARNING | Diagnostic.ERROR);

    if (diagnostic.getSeverity() != Diagnostic.OK) {
      result = dialog.open();
    }

    if (result == Window.OK && dialog.getSelection() != null) {
      List<?> data = dialog.getSelection().getData();
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
            IEditorPart editorPart = EditorHelper.openEditor(uri);
            if (editorPart != null && editorPart instanceof IEditingDomainProvider) {
              EditorHelper.setSelectionToViewer(editorPart, uri);
            }
          } catch (Throwable t) {
            ThrowableHandler.handleThrowable(EGFCoreUIPlugin.getDefault().getPluginID(), t);
          }
        }
      }

    }
  }

}
