/**
 * <copyright>
 *
 * Copyright (c) 2005-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EditUIUtil.java,v 1.8 2008/05/23 21:49:17 davidms Exp $
 */
package org.eclipse.egf.common.ui.emf;

import java.lang.reflect.Method;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.ui.activator.EGFCommonUIPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFEditUIUtil {

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

    static final Class<?> FILE_REVISION_CLASS;
    static final Method FILE_REVISION_GET_URI_METHOD;
    static {
      Class<?> fileRevisionClass = null;
      Method fileRevisionGetURIMethod = null;
      Bundle bundle = Platform.getBundle("org.eclipse.team.core");
      if (bundle != null && (bundle.getState() & (Bundle.ACTIVE | Bundle.STARTING | Bundle.RESOLVED)) != 0) {
        try {
          fileRevisionClass = bundle.loadClass("org.eclipse.team.core.history.IFileRevision");
          fileRevisionGetURIMethod = fileRevisionClass.getMethod("getURI");
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

  }

}
