/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

    protected final PatternMethod _method;

    public AbstractPatternMethodEditorInput(Resource resource, String fragment) {
        _resource = resource;
        _method = (PatternMethod) resource.getEObject(fragment);
        _fragment = fragment;
    }

    public boolean exists() {
        return true;
    }

    public PatternMethod getPatternMethod() {
        return _method;
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
