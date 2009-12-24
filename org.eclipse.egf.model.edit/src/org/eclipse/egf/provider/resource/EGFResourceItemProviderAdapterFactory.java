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
package org.eclipse.egf.provider.resource;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFResourceItemProviderAdapterFactory extends ResourceItemProviderAdapterFactory {

  /**
   * This creates an adapter for a
   * {@link org.eclipse.emf.ecore.resource.Resource}.
   */
  @Override
  public Adapter createResourceAdapter() {
    return new EGFResourceItemProvider(this);
  }

}
