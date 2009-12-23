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

package org.eclipse.egf.pattern.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;

/**
 * TODO for each call the extension point is read ...
 * 
 * @author Guiu
 * 
 */
public class ExtensionHelper {

    private static Map<String, PatternExtension> getExtensions() {
        Map<String, PatternExtension> result = new HashMap<String, PatternExtension>();
        for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(PatternExtension.EXTENSION_ID)) {
            try {
                PatternExtension pe = (PatternExtension) element.createExecutableExtension("class");
                result.put(getName(pe.getNature()), pe);
            } catch (CoreException e) {
                Activator.getDefault().logError(e);
            }
        }
        return result;
    }

    public static PatternExtension getExtension(PatternNature nature) throws MissingExtensionException {
        Map<String, PatternExtension> extensions = getExtensions();
        PatternExtension patternExtension = extensions.get(getName(nature));
        if (patternExtension == null)
            throw new MissingExtensionException(Messages.bind(Messages.extension_error1, getName(nature)));
        return patternExtension;

    }

    private static String getName(PatternNature nature) {
        return nature.eClass().getName();
    }

    public static class MissingExtensionException extends Exception {

        private static final long serialVersionUID = 8310777379305723688L;

        private MissingExtensionException(String message) {
            super(message);

        }

    }
}
