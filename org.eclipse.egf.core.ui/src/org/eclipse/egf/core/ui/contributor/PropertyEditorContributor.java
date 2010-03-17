/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.core.ui.contributor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Thomas Guiu
 * 
 */
public interface PropertyEditorContributor {
    public static final String EXTENSION_ID = "org.eclipse.egf.core.ui.editor.property.contributor"; //$NON-NLS-1$

    boolean canApply(Object object, IItemPropertyDescriptor descriptor);

    CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor);

    Helper HELPER = new Helper();

    class Helper {
        private final List<PropertyEditorContributor> contributors = new ArrayList<PropertyEditorContributor>();

        // TODO returns only the first one ?
        public PropertyEditorContributor selectPropertyEditor(Object object, IItemPropertyDescriptor descriptor) {
            if (!descriptor.canSetProperty(object))
                return null;

            for (PropertyEditorContributor contributor : contributors) {
                if (contributor.canApply(object, descriptor))
                    return contributor;
            }
            return null;
        }

        private Helper() {
            super();
            for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID)) {
                try {
                    PropertyEditorContributor contributor = (PropertyEditorContributor) element.createExecutableExtension("class"); //$NON-NLS-1$
                    contributors.add(contributor);
                } catch (CoreException e) {
                    EGFCoreUIPlugin.getDefault().logError(e);
                }
            }
        }
    }
}
