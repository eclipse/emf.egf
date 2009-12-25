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

package org.eclipse.egf.pattern.ui.editors;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

/**
 * 
 * @author Thomas Guiu
 * 
 */

public class PatternEditorInput implements IEditorInput {
    public static final String PATTERN_ID = "id";
    public static final String RESSOURCE_URI = "uri";

    private final Pattern pattern;
    private final PatternPersistableElement persistable = new PatternPersistableElement();

    public PatternEditorInput(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean exists() {

        return true;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public ImageDescriptor getImageDescriptor() {

        return null;
    }

    public String getName() {

        return pattern.getName();
    }

    public IPersistableElement getPersistable() {

        return persistable;
    }

    public String getToolTipText() {

        return Messages.input_tooltip;
    }

    public Object getAdapter(Class adapter) {

        return null;
    }

    private class PatternPersistableElement implements IPersistableElement {
        public void saveState(IMemento memento) {
            memento.putString(PATTERN_ID, pattern.getID());
            memento.putString(RESSOURCE_URI, pattern.eResource().getURI().toString());
        }

        public String getFactoryId() {

            return "org.eclipse.egf.pattern.ui.pattern.factory.id";
        }

    }
}
