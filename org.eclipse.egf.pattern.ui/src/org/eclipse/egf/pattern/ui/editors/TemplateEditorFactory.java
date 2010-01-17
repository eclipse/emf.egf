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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.editors.text.TextEditor;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class TemplateEditorFactory {
    protected static final String EXTENSION_POINT_EDITOR = "editor"; //$NON-NLS-1$
    protected static final String EXTENSION_POINT_NATURE = "Nature";
    private static Map<String, TextEditor> editors;

    public static TextEditor getEditor(Pattern pattern) {
        PatternNature nature = pattern.getNature();
        Map<String, TextEditor> editors = getEditors();
        if (editors.containsKey(nature.getClass().getName())) {
            return editors.get(nature.getClass().getName());
        }
        return null;

    }

    public static Map<String, TextEditor> getEditors() {
        if (editors == null)
            editors = new HashMap<String, TextEditor>();
        for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(Activator.getDefault().getPluginID(), EXTENSION_POINT_EDITOR)) {
            Object editorclass = null;
            String naturename = null;
            try {
                editorclass = ExtensionPointHelper.createInstance(configurationElement, EXTENSION_POINT_EDITOR);
                naturename = ExtensionPointHelper.getAttributeValue(configurationElement, EXTENSION_POINT_NATURE);
            } catch (CoreException ce) {
                Activator.getDefault().logError(ce);
            }
            if (editorclass == null || naturename == "") {
                continue;
            }
            // Make sure this is the correct resulting type.
            if (editorclass instanceof TextEditor == false) {
                Activator.getDefault().logError(NLS.bind("Wrong Class {0}", editorclass.getClass().getName())); //$NON-NLS-1$
                Activator.getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", TextEditor.class.getName()), 1); //$NON-NLS-1$
                Activator.getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
                Activator.getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
                continue;
            }
            editors.put(naturename, (TextEditor) editorclass);
        }
        return editors;
    }
}
