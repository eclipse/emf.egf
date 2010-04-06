/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.domain;

import java.util.Collection;

import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFURIConverter extends ExtensibleURIConverterImpl {

  public static String QUALIFIED_EXTENSION_POINT_GENERATED_PACKAGE = EcorePlugin.getPlugin().getBundle().getSymbolicName() + "." + EcorePlugin.GENERATED_PACKAGE_PPID; //$NON-NLS-1$

  protected IRegistryChangeListener _registryChangeListener = new IRegistryChangeListener() {
    public void registryChanged(IRegistryChangeEvent event) {
      IExtensionDelta[] deltas = event.getExtensionDeltas();
      for (IExtensionDelta delta : deltas) {
        if (delta.getExtensionPoint().isValid()) {
          loadURIMap();
        }
      }
    }
  };

  /**
   * This listens for platform changes.
   */
  protected IPlatformExtensionPointListener _platformListener = new IPlatformExtensionPointListener() {
    public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {
      loadURIMap();
    }
  };

  /**
   * Creates an instance.
   */
  public EGFURIConverter() {
    super();
    EGFPlatformPlugin.getPlatformManager().addInFrontPlatformExtensionPointListener(_platformListener);
    Platform.getExtensionRegistry().addRegistryChangeListener(_registryChangeListener, QUALIFIED_EXTENSION_POINT_GENERATED_PACKAGE);
    loadURIMap();
  }

  /**
   * Creates an instance.
   */
  public EGFURIConverter(Collection<URIHandler> uriHandlers, Collection<ContentHandler> contentHandlers) {
    super(uriHandlers, contentHandlers);
    EGFPlatformPlugin.getPlatformManager().addInFrontPlatformExtensionPointListener(_platformListener);
    Platform.getExtensionRegistry().addRegistryChangeListener(_registryChangeListener, QUALIFIED_EXTENSION_POINT_GENERATED_PACKAGE);
    loadURIMap();
  }

  /**
   * Dispose.
   */
  public void dispose() {
    EGFPlatformPlugin.getPlatformManager().removePlatformExtensionPointListener(_platformListener);
    Platform.getExtensionRegistry().removeRegistryChangeListener(_registryChangeListener);
  }

  private void loadURIMap() {
    // Clear the previous URIMap content
    getURIMap().clear();
    // Assign a fresh URIMap content
    getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
  }

}
