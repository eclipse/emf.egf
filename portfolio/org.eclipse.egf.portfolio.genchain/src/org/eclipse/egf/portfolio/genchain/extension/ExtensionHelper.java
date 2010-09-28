/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.emf.ecore.EAttribute;

/**
 * Associated to a EClass
 * 
 * @author Thomas Guiu
 * 
 */
public abstract class ExtensionHelper implements ExtensionProperties {

    private static final String EXTENSION_ID = "org.eclipse.egf.portfolio.genchain.elements";
    protected final List<Substitution> EMPTY_SUBSTITUTION = new ArrayList<Substitution>();

    protected final Map<EAttribute, String> properties = new HashMap<EAttribute, String>();

    public abstract EcoreElement createEcoreElement(Map<String, String> properties);

    public abstract String getLabel();

    public final Map<EAttribute, String> getDefaultProperties(Map<String, String> context) {
        if (properties.isEmpty())
            computeDefaultProperties(context);
        return properties;
    }

    protected void computeDefaultProperties(Map<String, String> context) {
    };

    // TODO upgrade this implementation
    public String getId() {
        return getLabel();
    }

    public List<Substitution> getSubstitutions() {
        return EMPTY_SUBSTITUTION;
    }

    public static Map<String, ExtensionHelper> getExtensionsAsMap() {

        Map<String, ExtensionHelper> result = new HashMap<String, ExtensionHelper>();
        for (ExtensionHelper helper : getExtensions())
            result.put(helper.getId(), helper);
        return result;
    }

    public static List<ExtensionHelper> getExtensions() {

        List<ExtensionHelper> result = new ArrayList<ExtensionHelper>();
        for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID)) {
            try {
                ExtensionHelper pe = (ExtensionHelper) element.createExecutableExtension("class");
                result.add(pe);
            } catch (CoreException e) {
                EGFPatternPlugin.getDefault().logError(e);
            }
        }
        return result;
    }

    public static List<Substitution> getAllSubstitutions() {
        List<Substitution> all = new ArrayList<Substitution>();
        for (ExtensionHelper eh : getExtensions()) {
            all.addAll(eh.getSubstitutions());
        }
        return all;
    }

}
