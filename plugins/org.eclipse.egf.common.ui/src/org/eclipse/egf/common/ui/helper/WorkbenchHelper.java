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
package org.eclipse.egf.common.ui.helper;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.ui.internal.resource.ExtendedUnmodifiableFile;
import org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


/**
 * Provides services to easily deal with workbench stuffs (e.g open an editor).<br>
 * Most of the services need to be called within the UI Thread.
 * @author Guillaume Brocard
 */
public class WorkbenchHelper {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(WorkbenchHelper.class.getPackage().getName());

  /**
   * Returns the currently active page for the active workbench window.<br>
   * Returns <code>null</code> if there is no active workbench page.<br>
   * Returns <code>null</code> if called from a non-UI thread.
   * @return the active workbench page, or <code>null</code> if there is no active workbench page or if called from a non-UI thread
   */
  public static IWorkbenchPage getActiveWorkbenchPage() {
    IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    if (activeWorkbenchWindow != null) {
      return activeWorkbenchWindow.getActivePage();
    }
    return null;
  }

  /**
   * Open file based editor for given file relative path.
   * @param fileRelativePath_p A path relative to workspace, starting with the project name.
   * @param editorId_p
   * @return
   */
  public static IEditorPart openFileEditor(String fileRelativePath_p, String editorId_p, boolean editable_p) {
    // Preconditions.
    if (fileRelativePath_p == null || editorId_p == null) {
      return null;
    }
    // Get file depending on 'editability'.
    IFile file = null;
    IPath filePath = new Path(fileRelativePath_p);
    if (editable_p) {
      file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
    } else {
      file = new ExtendedUnmodifiableFile(filePath);
    }
    return openEditor(new FileEditorInput(file), editorId_p, PlatformUI.getWorkbench().getDisplay().getActiveShell());
  }

  /**
   * Open an editor on the given input.
   * @param editorInput_p
   * @param editorId_p
   * @return an open and active editor, or null if an external editor was opened.
   */
  public static IEditorPart openEditor(IEditorInput editorInput_p, String editorId_p, Shell shell_p) {
    IEditorPart openEditor = null;
    // Preconditions.
    if (editorInput_p == null || editorId_p == null) {
      return openEditor;
    }
    try {
      IWorkbenchPage activeWorkbenchPage = getActiveWorkbenchPage();
      if (activeWorkbenchPage != null) {
        openEditor = activeWorkbenchPage.openEditor(editorInput_p, editorId_p);
      } else {
        throw new PartInitException("No active workbench page was found to open an editor"); //$NON-NLS-1$
      }
    } catch (PartInitException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("WorkbenchHelper.openEditor(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
      MessageDialog.openError(shell_p, Messages.OpenEditor_ErrorMessage, exception_p.getMessage());
    }
    return openEditor;
  }

  /**
   * Open file based editor for given file relative path with registered editor as default one.
   * @param fileRelativePath_p A path relative to workspace, starting with the project name.
   * @return
   */
  public static IEditorPart openDefaultFileEditor(String fileRelativePath_p, Shell shell_p) {
    // Preconditions.
    if (fileRelativePath_p == null) {
      return null;
    }
    // Get the editor registry.
    IEditorRegistry editorRegistry = PlatformUI.getWorkbench().getEditorRegistry();
    // Get default editor descriptor for specified file path.
    IEditorDescriptor defaultEditor = editorRegistry.getDefaultEditor(fileRelativePath_p);
    if (defaultEditor != null) {
      return openFileEditor(fileRelativePath_p, defaultEditor.getId(), true);
    }
    return null;
  }

  /**
   * Save given editor.
   * @param editor_p
   */
  public static void saveEditor(IEditorPart editor_p) {
    if (editor_p.isDirty()) {
      editor_p.doSave(new NullProgressMonitor());
    }
  }

  /**
   * Close file based editors for given file relative path.<br>
   * Note that all editors are asked to save content as they are closed.
   * @param fileRelativePath_p
   * @return
   */
  public static boolean closeFileEditors(String fileRelativePath_p) {
    boolean result = false;
    // Precondition.
    if (fileRelativePath_p == null) {
      return result;
    }
    IWorkbenchPage activeWorkbenchPage = getActiveWorkbenchPage();
    IFile fileToClose = null;
    try {
      fileToClose = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileRelativePath_p));
    } catch (Exception e_p) {
      StringBuilder loggerMessage = new StringBuilder("WorkbenchHelper.closeFileEditor(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), e_p);
    }
    // Preconditions.
    if (activeWorkbenchPage == null || fileToClose == null) {
      return result;
    }
    // Search for the editors working on this file.
    result = true;
    IEditorReference[] editorReferences = activeWorkbenchPage.getEditorReferences();
    for (int i = 0; i < editorReferences.length; i++) {
      IEditorPart editorPart = editorReferences[i].getEditor(false);
      IEditorInput editorInput = editorPart.getEditorInput();
      if (editorInput != null) {
        IFile file = (IFile) editorInput.getAdapter(IFile.class);
        if (fileToClose.equals(file)) {
          // Save content at closure time.
          result &= closeEditor(editorPart, true);
        }
      }
    }
    return result;
  }

  /**
   * Close the given editor. The editor must belong to this workbench page.
   * <p>
   * If the editor has unsaved content and <code>save_p</code> is <code>true</code>,<br>
   * the user will be given the opportunity to save it.
   * </p>
   * @param editor_p the edit or to close.
   * @param save_p <code>true</code> to save the editor contents if required (recommended),<br>
   *          and <code>false</code> to discard any unsaved changes.
   * @return <code>true</code> if the editor was successfully closed, and <code>false</code> if the editor is still open.
   */
  public static boolean closeEditor(IEditorPart editor_p, boolean save_p) {
    IWorkbenchPage activeWorkbenchPage = getActiveWorkbenchPage();
    if (activeWorkbenchPage != null) {
      return activeWorkbenchPage.closeEditor(editor_p, save_p);
    }
    return false;
  }

  /**
   * Close a view for specified id in the current workbench page.
   * @param viewId_p
   */
  public static void closeView(String viewId_p) {
    // Precondition.
    if (viewId_p == null) {
      return;
    }
    IWorkbenchPage activeWorkbenchPage = WorkbenchHelper.getActiveWorkbenchPage();
    IViewPart viewPart = activeWorkbenchPage.findView(viewId_p);
    if (viewPart != null) {
      activeWorkbenchPage.hideView(viewPart);
    }
  }

  /**
   * Open a view for specified id in the current workbench page.
   * @param viewId_p
   */
  public static void openView(String viewId_p) {
    // Precondition.
    if (viewId_p == null) {
      return;
    }
    IWorkbenchPage activeWorkbenchPage = WorkbenchHelper.getActiveWorkbenchPage();
    try {
      activeWorkbenchPage.showView(viewId_p);
    } catch (PartInitException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("WorkbenchHelper.openView(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }

  /**
   * Return whether or not the view for specified id is open.
   * @param viewId_p
   * @return <code>true</code> means open.
   */
  public static boolean isViewOpen(String viewId_p) {
    // Precondition.
    if (viewId_p == null) {
      return false;
    }
    IWorkbenchPage activeWorkbenchPage = WorkbenchHelper.getActiveWorkbenchPage();
    if (activeWorkbenchPage != null) {
      return activeWorkbenchPage.findView(viewId_p) != null;
    }
    return false;
  }

  /**
   * Add a part listener in the active workbench page.
   * @param listener_p
   */
  public static void addPartListener(IPartListener listener_p) {
    // Get the active page
    IWorkbenchPage activeWorkbenchPage = getActiveWorkbenchPage();
    if (activeWorkbenchPage != null) {
      activeWorkbenchPage.addPartListener(listener_p);
    }
  }

  /**
   * Get all open editors in the active workbench page for given editor id.
   * @param editorId_p the editor id, the one use to open the related editor.
   * @return a not null array.
   */
  public static IEditorReference[] getAllOpenEditors(String editorId_p) {
    ArrayList<IEditorReference> openEditors = new ArrayList<IEditorReference>(0);
    IWorkbenchPage activePage = getActiveWorkbenchPage();
    // Get all open editors in the active page.
    IEditorReference[] allEditorReferences = activePage.getEditorReferences();
    // Loop over all open editors in the active page; add in the resulting list, the ones for which the id is matching the given one.
    for (IEditorReference editorReference : allEditorReferences) {
      if (editorId_p.equals(editorReference.getId())) {
        openEditors.add(editorReference);
      }
    }
    return openEditors.toArray(new IEditorReference[openEditors.size()]);
  }

  /**
   * Get the Package Explorer view.<br>
   * Returns <code>null</code> if there is no active workbench page.<br>
   * Returns <code>null</code> if called from a non-UI thread.<br>
   * Returns <code>null</code> if package explorer is not open.
   * @return the Package Explorer view, or <code>null</code> if there is no active workbench page or if called from a non-UI thread or if package explorer is
   *         not open.
   */
  public static PackageExplorerPart getPackageExplorerView() {
    IWorkbenchPage activeWorkbenchPage = WorkbenchHelper.getActiveWorkbenchPage();
    if (activeWorkbenchPage != null) {
      return (PackageExplorerPart) activeWorkbenchPage.findView(JavaUI.ID_PACKAGES);
    }
    return null;
  }
  
}
