/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.templateEditor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.ui.Activator;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class TemplateExtensionRegistry {
    protected static final String EXTENSION_POINT_EDITOR = "templateEditor";
    protected static final String EXTENSION_Id = "id";
    protected static final String EXTENSION_POINT_NATURE = "nature";
    private static Map<String, String> editors;

    public static String getEditor(Pattern pattern) {
        PatternNature nature = pattern.getNature();
        Map<String, String> editors = getEditors();
        if (editors != null) {
            String name = nature.eClass().getName();
            return editors.get(name);
        }
        return null;
    }

    public static Map<String, String> getEditors() {
        if (editors == null)
            editors = new HashMap<String, String>();
        for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(Activator.getDefault().getPluginID(), EXTENSION_POINT_EDITOR)) {
            String editorId = ExtensionPointHelper.getAttributeValue(configurationElement, EXTENSION_Id);
            String natureName = ExtensionPointHelper.getAttributeValue(configurationElement, EXTENSION_POINT_NATURE);

            editors.put(natureName, editorId);
        }
        return editors;
    }

}
