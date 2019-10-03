/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors;

import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * @author Thomas Guiu
 */
public class AbstractPatternMethodEditorInput implements IEditorInput {

    protected final String _fragment;

    protected final Resource _resource;

    public AbstractPatternMethodEditorInput(Resource resource, String fragment) {
        _resource = resource;
        _fragment = fragment;
    }

    public boolean exists() {
        return true;
    }

    public PatternMethod getPatternMethod() {
        return (PatternMethod) _resource.getEObject(_fragment);
    }

    public Resource getResource() {
        return _resource;
    }

    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    public String getToolTipText() {
        if (getPatternMethod() != null) {
            return getPatternMethod().getName();
        }
        return Messages.input_tooltip;
    }

    public String getName() {
        return getPatternMethod().getName();
    }

    public IPersistableElement getPersistable() {
        return null;
    }

    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class adapter) {
        return null;
    }

}
