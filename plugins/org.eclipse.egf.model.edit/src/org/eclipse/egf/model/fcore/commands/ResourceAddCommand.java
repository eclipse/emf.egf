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
package org.eclipse.egf.model.fcore.commands;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Multi-rooted resources support.
 * This command will add a root defined EObject to the resource.
 */
public class ResourceAddCommand extends AddCommand {

  /**
   */
  private Resource _resource = null;

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param resource
   *          the resource to add to
   * @param collection
   *          the collection to add
   */
  public ResourceAddCommand(EditingDomain domain, Resource resource, Collection<?> collection) {
    this(domain, resource, collection, CommandParameter.NO_INDEX);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param resource
   *          the resource to add to
   * @param collection
   *          the collection to add
   * @param index
   *          the index
   */
  public ResourceAddCommand(EditingDomain domain, Resource resource, Collection<?> collection, int index) {
    super(domain, resource.getContents(), collection, index);
    _resource = resource;
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param resource
   *          the resource to add to
   * @param value
   *          the value to add
   */
  public ResourceAddCommand(EditingDomain domain, Resource resource, Object value) {
    this(domain, resource, value, CommandParameter.NO_INDEX);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param resource
   *          the resource to add to
   * @param value
   *          the value to add
   * @param index
   *          the index
   */
  public ResourceAddCommand(EditingDomain domain, Resource resource, Object value, int index) {
    super(domain, resource.getContents(), value, index);
    _resource = resource;
  }

  @Override
  protected boolean prepare() {
    if (domain.isReadOnly(_resource)) {
      return false;
    }
    return super.prepare();
  }

}
