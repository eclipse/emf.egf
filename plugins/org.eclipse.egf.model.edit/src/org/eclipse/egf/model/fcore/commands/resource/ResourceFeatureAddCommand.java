/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.commands.resource;

import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * Multi-rooted resources support.
 * This command will add a root defined EObject to the resource.
 */
public class ResourceFeatureAddCommand extends FcoreResourceAddCommand implements CommandActionDelegate {

    /**
   */
    private FcoreResourceImpl _fcoreResourceImpl = null;

    /**
   */
    private ItemProviderAdapter _itemProvider = null;

    /**
   */
    private Object _feature = null;

    /**
   */
    private Object _value = null;

    /**
     * Constructor
     * 
     * @param domain
     *            the editing domain
     * @param fcoreResourceImpl
     *            the resource to add to
     * @param feature
     *            the feature to process
     * @param value
     *            the value to add
     */
    public ResourceFeatureAddCommand(EditingDomain domain, FcoreResourceImpl fcoreResourceImpl, Object feature, Object value) {
        this(domain, fcoreResourceImpl, feature, value, CommandParameter.NO_INDEX);
    }

    /**
     * Constructor
     * 
     * @param domain
     *            the editing domain
     * @param fcoreResourceImpl
     *            the resource to add to
     * @param feature
     *            the feature to process
     * @param value
     *            the value to add
     * @param index
     *            the index
     */
    public ResourceFeatureAddCommand(EditingDomain domain, FcoreResourceImpl fcoreResourceImpl, Object feature, Object value, int index) {
        super(domain, fcoreResourceImpl, value, index);
        _fcoreResourceImpl = fcoreResourceImpl;
        _feature = feature;
        _value = value;
        if (getDomain() instanceof AdapterFactoryEditingDomain) {
            IEditingDomainItemProvider valueItemProvider = (IEditingDomainItemProvider) ((AdapterFactoryEditingDomain) getDomain()).getAdapterFactory().adapt(_value, IEditingDomainItemProvider.class);
            if (valueItemProvider instanceof ItemProviderAdapter) {
                _itemProvider = (ItemProviderAdapter) valueItemProvider;
            }
        }
        if (_itemProvider != null) {
            setLabel(_itemProvider.getCreateChildText(_fcoreResourceImpl, _feature, _value, null));
            setDescription(_itemProvider.getCreateChildDescription(_fcoreResourceImpl, _feature, _value, null));
        }
    }

    /**
     * @see org.eclipse.emf.edit.command.CommandActionDelegate#getImage()
     */
    public Object getImage() {
        return _itemProvider != null ? _itemProvider.getCreateChildImage(_fcoreResourceImpl, _feature, _value, null) : null;
    }

    /**
     * @see org.eclipse.emf.edit.command.CommandActionDelegate#getText()
     */
    public String getText() {
        return _itemProvider != null ? _itemProvider.getCreateChildText(_fcoreResourceImpl, _feature, _value, null) : null;
    }

    /**
     * @see org.eclipse.emf.edit.command.CommandActionDelegate#getToolTipText()
     */
    public String getToolTipText() {
        return _itemProvider != null ? _itemProvider.getCreateChildToolTipText(_fcoreResourceImpl, _feature, _value, null) : null;
    }

}
