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
package org.eclipse.egf.common.ui.helper;

import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.emf.common.EMFPlugin;
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
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EditorHelper {

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
    } catch (Throwable t) {
      ThrowableHandler.handleThrowable(EGFCommonUIPlugin.getDefault().getPluginID(), t);
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

  public static String computeEditorId(String fileName) {
    IWorkbench workbench = PlatformUI.getWorkbench();
    IEditorRegistry editorRegistry = workbench.getEditorRegistry();
    IEditorDescriptor descriptor = editorRegistry.getDefaultEditor(fileName);
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

  public static URI getURI(IEditorInput editorInput) {
    URI result = null;
    if (EMFPlugin.IS_ECLIPSE_RUNNING) {
      result = EclipseUtil.getURI(editorInput);
    }
    if (result == null) {
      if (editorInput instanceof URIEditorInput) {
        result = ((URIEditorInput) editorInput).getURI().trimFragment();
      } else {
        result = URI.createURI(editorInput.getName());
      }
    }
    return result;
  }

  public static class EclipseUtil {

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

    static final Class<?> FILE_REVISION_CLASS;
    static final Method FILE_REVISION_GET_URI_METHOD;
    static {
      Class<?> fileRevisionClass = null;
      Method fileRevisionGetURIMethod = null;
      Bundle bundle = Platform.getBundle("org.eclipse.team.core"); //$NON-NLS-1$
      if (bundle != null && (bundle.getState() & (Bundle.ACTIVE | Bundle.STARTING | Bundle.RESOLVED)) != 0) {
        try {
          fileRevisionClass = bundle.loadClass("org.eclipse.team.core.history.IFileRevision"); //$NON-NLS-1$
          fileRevisionGetURIMethod = fileRevisionClass.getMethod("getURI"); //$NON-NLS-1$
        } catch (Throwable exeption) {
          // Ignore any exceptions and assume the class isn't available.
        }
      }
      FILE_REVISION_CLASS = fileRevisionClass;
      FILE_REVISION_GET_URI_METHOD = fileRevisionGetURIMethod;
    }

    static final Class<?> URI_EDITOR_INPUT_CLASS;
    static {
      Class<?> uriEditorInputClass = null;
      try {
        uriEditorInputClass = IURIEditorInput.class;
      } catch (Throwable exception) {
        // The class is not available.
      }
      URI_EDITOR_INPUT_CLASS = uriEditorInputClass;
    }

    public static URI getURI(IEditorInput editorInput) {
      if (FILE_CLASS != null) {
        IFile file = (IFile) editorInput.getAdapter(FILE_CLASS);
        if (file != null) {
          return URI.createPlatformPluginURI(file.getFullPath().toString(), true);
        }
      }
      if (FILE_REVISION_CLASS != null) {
        Object fileRevision = editorInput.getAdapter(FILE_REVISION_CLASS);
        if (fileRevision != null) {
          try {
            return URI.createURI(((java.net.URI) FILE_REVISION_GET_URI_METHOD.invoke(fileRevision)).toString());
          } catch (Throwable t) {
            EGFCommonUIPlugin.getDefault().logError(t);
          }
        }
      }
      if (URI_EDITOR_INPUT_CLASS != null) {
        if (editorInput instanceof IURIEditorInput) {
          return URI.createURI(((IURIEditorInput) editorInput).getURI().toString()).trimFragment();
        }
      }

      return null;
    }

    public static IFile getIFile(IEditorInput editorInput) {
      if (FILE_CLASS != null) {
        return (IFile) editorInput.getAdapter(FILE_CLASS);
      }
      return null;
    }

    public static IEditorInput createFileEditorInput(IFile file) {
      return new FileEditorInput(file);
    }
  }

}
