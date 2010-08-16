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
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.pattern.Activator;

/**
 * Associated to a EClass
 * 
 * @author Thomas Guiu
 * 
 */
public abstract class ExtensionHelper {

    private static final String EXTENSION_ID = "org.eclipse.egf.portfolio.genchain.elements";
    protected final List<Substitution> EMPTY_SUBSTITUTION = new ArrayList<Substitution>();

    public abstract String getLabel();

    public List<Substitution> getSubstitutions() {
        return EMPTY_SUBSTITUTION;
    }

    public static List<ExtensionHelper> getExtensions() {

        List<ExtensionHelper> result = new ArrayList<ExtensionHelper>();
        for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID)) {
            try {
                ExtensionHelper pe = (ExtensionHelper) element.createExecutableExtension("class");
                result.add(pe);
            } catch (CoreException e) {
                Activator.getDefault().logError(e);
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
