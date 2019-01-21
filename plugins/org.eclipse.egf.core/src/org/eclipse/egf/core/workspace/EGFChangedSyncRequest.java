/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * 
 * </copyright>
 * 
 * $Id: ChangedSynchRequest.java,v 1.3 2007/11/14 18:14:08 cdamus Exp $
 */
package org.eclipse.egf.core.workspace;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Concrete synchronization request for resource content changes.
 * 
 * @author Christian W. Damus (cdamus)
 */
class EGFChangedSynchRequest extends EGFSynchRequest {
  /**
   * Initializes me with the synchronizer on whose behalf I perform a
   * synchronization and the resource whose workspace partner is changed.
   * 
   * @param synch
   *          the workspace synchronizer
   * @param resource
   *          the resource that has changed
   */
  EGFChangedSynchRequest(EGFWorkspaceSynchronizer synch, Resource resource) {
    super(synch, resource);
  }

  @Override
  protected void doPerform() {
    if (!synch.getDelegate().handleResourceChanged(resource)) {
      // note that if our delegate is the default, it
      // will always return true
      EGFWorkspaceSynchronizer.defaultDelegate.handleResourceChanged(resource);
    }
  }
}
