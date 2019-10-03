/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.egf.portfolio.genchain.Activator;
import org.eclipse.egf.portfolio.genchain.Messages;
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
    private static final List<String> EMPTY_LIST = new ArrayList<String>();

    protected final List<Substitution> EMPTY_SUBSTITUTION = new ArrayList<Substitution>();
    protected final Map<EAttribute, String> properties = new HashMap<EAttribute, String>();
    private String id;

    public abstract EcoreElement createEcoreElement(Map<String, String> properties);

    public abstract String getLabel();

    public List<String> getConflictingExtensions() {
        return EMPTY_LIST;
    }

    public final Map<EAttribute, String> getDefaultProperties(Map<String, String> context) {
        if (properties.isEmpty())
            computeDefaultProperties(context);
        return properties;
    }

    protected void computeDefaultProperties(Map<String, String> context) {
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                String id = element.getAttribute("id");
                if (id == null) {
                    Activator.getDefault().logError(Messages.bind(Messages.Extension_load_error1, element.getAttribute("class")));
                    continue;
                }
                pe.setId(id);
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
