/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

/**
 * TODO for each call the extension point is read ...
 * 
 * @author Guiu
 * 
 */
public class ExtensionHelper {

    public static PatternNature createNature(String name) {
        PatternExtension patternExtension = null;
        try {
            patternExtension = EGFPatternPlugin.getPatternExtension(name);
            if (patternExtension == null) {
                throw new IllegalStateException(NLS.bind(EGFPatternMessages.extension_error1, name));
            }
        } catch (CoreException ce) {
            throw new IllegalStateException(NLS.bind(EGFPatternMessages.extension_error1, name), ce);
        }
        EClass eClass = patternExtension.getNature().eClass();
        return (PatternNature) eClass.getEPackage().getEFactoryInstance().create(eClass);
    }

    public static PatternExtension getExtension(PatternNature nature) throws MissingExtensionException {
        if (nature == null)
            throw new NullPointerException(EGFPatternMessages.extension_error4);
        PatternExtension patternExtension = null;
        try {
            patternExtension = EGFPatternPlugin.getPatternExtension(nature);
            if (patternExtension == null) {
                throw new MissingExtensionException(NLS.bind(EGFPatternMessages.extension_error1, getName(nature)));
            }
        } catch (CoreException ce) {
            throw new MissingExtensionException(NLS.bind(EGFPatternMessages.extension_error1, getName(nature)), ce);
        }
        return patternExtension;

    }

    public static String getName(PatternNature nature) {
        if (nature == null)
            throw new NullPointerException(EGFPatternMessages.extension_error4);
        return nature.eClass().getName();
    }

    public static class MissingExtensionException extends Exception {

        private static final long serialVersionUID = 8310777379305723688L;

        private MissingExtensionException(String message) {
            super(message);
        }

        private MissingExtensionException(String message, Throwable t) {
            super(message, t);
        }

    }

}
