/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.domain;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.egf.core.fcore.IResourceFcoreListener;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFURIConverter extends ExtensibleURIConverterImpl {

  /**
   * This listens for platform changes.
   */
  protected IPlatformExtensionPointListener _platformListener = new IPlatformExtensionPointListener() {
    public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {
      loadURIMap();
    }
  };

  /**
   * This listens for fcore changes.
   */
  protected IResourceFcoreListener _fcoreListener = new IResourceFcoreListener() {
    public void fcoreChanged(IResourceFcoreDelta delta) {
      // Ignore updated resources
      List<URI> removed = delta.getRemovedFcores();
      List<URI> added = delta.getNewFcores();
      if ((removed != null && removed.size() > 0) || (added != null && added.size() > 0)) {
        loadURIMap();
      }
    }
  };

  /**
   * Creates an instance.
   */
  public EGFURIConverter() {
    super();
    EGFPlatformPlugin.getPlatformManager().addInFrontPlatformExtensionPointListener(_platformListener);
    EGFPDEPlugin.getDefault().addResourceFcoreListener(_fcoreListener);
    loadURIMap();
  }

  /**
   * Creates an instance.
   */
  public EGFURIConverter(Collection<URIHandler> uriHandlers, Collection<ContentHandler> contentHandlers) {
    super(uriHandlers, contentHandlers);
    EGFPlatformPlugin.getPlatformManager().addInFrontPlatformExtensionPointListener(_platformListener);
    EGFPDEPlugin.getDefault().addResourceFcoreListener(_fcoreListener);
    loadURIMap();
  }

  /**
   * Dispose.
   */
  public void dispose() {
    EGFPlatformPlugin.getPlatformManager().removePlatformExtensionPointListener(_platformListener);
    EGFPDEPlugin.getDefault().removeResourceFcoreListener(_fcoreListener);
    loadURIMap();
  }

  private void loadURIMap() {
    // Clear the previous URIMap content
    getURIMap().clear();
    // Assign a fresh URIMap content
    getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
  }

}
