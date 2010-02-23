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
import org.eclipse.egf.core.workspace.EGFWorkspaceSynchronizer;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFEditingDomainFactory extends WorkspaceEditingDomainFactory {

  @Override
  public TransactionalEditingDomain createEditingDomain() {
    TransactionalEditingDomain result = super.createEditingDomain();
    configure(result);
    return result;
  }

  @Override
  public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
    TransactionalEditingDomain result = super.createEditingDomain(rset);
    configure(result);
    return result;
  }

  /**
   * Configures the specified editing domain for correct functioning in the EGF environment.
   * 
   * @param domain
   *          the new editing domain
   */
  protected void configure(final TransactionalEditingDomain domain) {
    // Assign a fresh URIConverter
    domain.getResourceSet().getURIConverter().getURIMap().clear();
    domain.getResourceSet().getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // the listener depends on UI to ask the user to solve conflict
    new EGFWorkspaceSynchronizer(domain, new EGFResourceLoadedListener());
    // configure domain management
    configureResourceModificationManagement(domain);
  }

  /**
   * Configures <code>domain</code> so that the modified state
   * of resources in the <code>domain</code> is managed as operations are
   * executed, undone and redone on the operation history.
   * 
   * @param domain
   *          the editing domain to be configured
   */
  protected void configureResourceModificationManagement(TransactionalEditingDomain domain) {
    ResourceModificationManager.manage(domain);
  }

}
