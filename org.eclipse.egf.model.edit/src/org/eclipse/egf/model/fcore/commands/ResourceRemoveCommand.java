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
package org.eclipse.egf.model.fcore.commands;

import java.util.Collection;

import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * The FcoreResourceImpl supports multi-rooted resources
 * and therefore this command will remove a root from the resource..
 */
public class ResourceRemoveCommand extends RemoveCommand implements CommandActionDelegate {

  /**
   */
  private FcoreResourceImpl _resource = null;

  /**
   * Attribute for the adapter factory
   */
  private IItemLabelProvider _labelProvider = null;

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   * @param resource
   *          the resource to modify
   * @param collection
   *          the objects to be removed
   */
  public ResourceRemoveCommand(EditingDomain domain, FcoreResourceImpl resource, Collection<?> collection) {
    super(domain, resource.getContents(), collection);
    if (getDomain() instanceof AdapterFactoryEditingDomain) {
      _labelProvider = (IItemLabelProvider) ((AdapterFactoryEditingDomain) getDomain()).getAdapterFactory().adapt(getCollection().toArray()[0], IItemLabelProvider.class);
    }
    _resource = resource;
    setLabel(LABEL);
    setDescription(DESCRIPTION);
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getImage()
   */
  public Object getImage() {
    return this._labelProvider != null ? this._labelProvider.getImage(getCollection().toArray()[0]) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getText()
   */
  public String getText() {
    return this._labelProvider != null ? this._labelProvider.getText(getCollection().toArray()[0]) : null;
  }

  /**
   * @see org.eclipse.emf.edit.command.CommandActionDelegate#getToolTipText()
   */
  public String getToolTipText() {
    return getText();
  }

  @Override
  protected boolean prepare() {
    if (domain.isReadOnly(_resource)) {
      return false;
    }
    return super.prepare();
  }

}
