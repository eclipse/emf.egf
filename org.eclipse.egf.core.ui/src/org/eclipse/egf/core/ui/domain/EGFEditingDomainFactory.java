/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.core.ui.domain;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Factory;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFEditingDomainFactory implements Factory {

  public TransactionalEditingDomain createEditingDomain() {
    TransactionalEditingDomain editingDomain = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();
    editingDomain.getResourceSet().getURIConverter().getURIMap().clear();
    editingDomain.getResourceSet().getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // the listener depends on UI to ask the user to solve conflict
    new WorkspaceSynchronizer(editingDomain, new ResourceLoadedListener());
    return editingDomain;
  }

  public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
    return null;
  }

  public TransactionalEditingDomain getEditingDomain(ResourceSet rset) {
    return null;
  }

}
