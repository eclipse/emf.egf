/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.console.util;

import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Utility class to create status objects.
 */
public class ConsoleUtil {

  public static void setSelectionToViewer(IEditorPart part, URI uri) {
    if (part == null || part instanceof IEditingDomainProvider == false) {
      return;
    }
    if (uri == null || uri.hasFragment() == false) {
      return;
    }
    EditingDomain editingDomain = ((IEditingDomainProvider) part).getEditingDomain();
    EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
    if (eObject == null) {
      return;
    }
    try {
      Class<?>[] types = new Class[] { Class.forName("java.util.Collection") }; //$NON-NLS-1$              
      Method method = part.getClass().getMethod("setSelectionToViewer", types); //$NON-NLS-1$
      if (method != null) {
        Object[] params = new Object[] { Collections.singletonList(eObject) };
        method.invoke(part, params);
      }
    } catch (Exception e) {
      EGFConsolePlugin.getDefault().logError("IEditingDomainProvider.setSelectionToViewer", e); //$NON-NLS-1$
    }
  }

  /**
   * Opens the default editor for the resource that contains the specified
   * EObject.
   */
  public static IEditorPart openEditor(EObject eObject) throws PartInitException {
    if (eObject == null) {
      return null;
    }
    Resource resource = eObject.eResource();
    if (resource == null) {
      return null;
    }
    URI uri = resource.getURI();
    if (uri == null) {
      return null;
    }
    return openEditor(uri);
  }

  public static String computeEditorId(String fileName_p) {
    IWorkbench workbench = PlatformUI.getWorkbench();
    IEditorRegistry editorRegistry = workbench.getEditorRegistry();
    IEditorDescriptor descriptor = editorRegistry.getDefaultEditor(fileName_p);
    if (descriptor != null) {
      return descriptor.getId();
    }
    return EditorsUI.DEFAULT_TEXT_EDITOR_ID;
  }

  /**
   * Opens the default editor for the resource that contains the specified
   * EObject.
   */
  public static IEditorPart openEditor(URI uri) throws PartInitException {
    if (uri == null) {
      return null;
    }
    IEditorInput editorInput = null;
    if (uri.isPlatformResource()) {
      String path = uri.toPlatformString(true);
      IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
      if (workspaceResource instanceof IFile) {
        editorInput = EclipseUtil.createFileEditorInput((IFile) workspaceResource);
        return openEditor(editorInput, uri);
      }
    } else {
      return openEditor(new URIEditorInput(uri.trimFragment()), uri);
    }
    return null;
  }

  private static IEditorPart openEditor(IEditorInput input, URI uri) throws PartInitException {
    if (input != null && uri != null) {
      IWorkbench workbench = PlatformUI.getWorkbench();
      IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
      return page.openEditor(input, computeEditorId(uri.trimFragment().lastSegment()));
    }
    return null;
  }

  private static class EclipseUtil {

    static final Class<?> FILE_CLASS;
    static {
      Class<?> fileClass = null;
      try {
        fileClass = IFile.class;
      } catch (Throwable exception) {
        // Ignore any exceptions and assume the class isn't available.
      }
      FILE_CLASS = fileClass;
    }

    static final Class<?> URI_EDITOR_INPUT_CLASS;
    static {
      Class<?> uriEditorInputClass = null;
      try {
        uriEditorInputClass = IURIEditorInput.class;
      } catch (Throwable exception) {
        // Ignore any exceptions and assume the class isn't available.
      }
      URI_EDITOR_INPUT_CLASS = uriEditorInputClass;
    }

    public static IEditorInput createFileEditorInput(IFile file) {
      return new FileEditorInput(file);
    }

  }

}
