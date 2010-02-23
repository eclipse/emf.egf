/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: ResourceLoadedListener.java,v 1.4 2007/11/14 18:13:57 cdamus Exp $
 */

package org.eclipse.egf.core.ui.domain;

import java.util.Set;

import org.eclipse.egf.common.ui.emf.EMFEditUIHelper;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Listens for the loading of resources, and creates editors on them when they
 * load.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class FcoreResourceLoadedListener extends DemultiplexingListener {

  private static FcoreResourceLoadedListener _instance;

  private final Set<Resource> _ignoredResources = new java.util.HashSet<Resource>();

  /**
   * Initializes me with my filter.
   */
  public FcoreResourceLoadedListener() {
    super(NotificationFilter.createFeatureFilter(EcorePackage.eINSTANCE.getEResource(), Resource.RESOURCE__IS_LOADED));
    _instance = this;
  }

  /**
   * Returns the default listener instance.
   * 
   * @return the instance associated with the editing domain that manages the
   *         specified resource set, or <code>null</code> if none is found
   */
  public static FcoreResourceLoadedListener getDefault() {
    if (_instance == null) {
      _instance = new FcoreResourceLoadedListener();
    }
    return _instance;
  }

  /**
   * Ignores any future load/unload notifications from the specified resource,
   * until the next call to {@link #watch(Resource) watch(res)}.
   * 
   * @param res
   *          the resource to ignore
   */
  public void ignore(Resource resource) {
    _ignoredResources.add(resource);
  }

  /**
   * Ceases to {@link #ignore(Resource)} a previously ignored resource.
   * 
   * @param res
   *          the resource
   */
  public void watch(Resource resource) {
    _ignoredResources.remove(resource);
  }

  @Override
  protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {
    if (_ignoredResources.contains(notification.getNotifier())) {
      // skip any resource that we are supposed to ignore
      return;
    }
    if (notification.getNewBooleanValue() && notification.getOldBooleanValue() == false) {
      // a resource has been loaded that was not loaded before. Open an editor if applicable
      final Resource resource = (Resource) notification.getNotifier();
      // Preferences
      if (EGFCoreUIPlugin.getDefault().getPreferenceStore().getBoolean(IEGFModelConstants.EDIT_LOADED_RESOURCES)) {
        Display.getDefault().asyncExec(new Runnable() {
          public void run() {
            try {
              if (resource.getURI() != null && isAlreadyOpened(resource) == false) {
                IEditorPart part = EditorHelper.openEditor(resource.getURI());
                if (part != null && part instanceof IEditingDomainProvider) {
                  EditorHelper.setSelectionToViewer(part, resource.getURI());
                }
              }
            } catch (PartInitException pie) {
              EGFCoreUIPlugin.getDefault().log(pie.getStatus());
            }
          }
        });
      }
    }
  }

  private boolean isAlreadyOpened(Resource resource) {
    IWorkbench workbench = PlatformUI.getWorkbench();
    if (workbench != null) {
      for (IWorkbenchWindow workbenchWindow : workbench.getWorkbenchWindows()) {
        for (IWorkbenchPage workbenchPage : workbenchWindow.getPages()) {
          for (IEditorReference editorReference : workbenchPage.getEditorReferences()) {
            try {
              IEditorInput editorInput = editorReference.getEditorInput();
              if (editorInput != null) {
                URI uri = EMFEditUIHelper.getURI(editorInput);
                if (uri != null && uri.equals(resource.getURI())) {
                  return true;
                }
              }
            } catch (PartInitException pie) {
              // Just Ignore
            }
          }
        }
      }
    }
    return false;
  }

}
