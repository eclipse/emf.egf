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

package org.eclipse.egf.pattern.execution;

import java.util.Set;

import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * This class is responsible of the translation of a set of pattern. The set may
 * be ordered depending on pattern requirements.
 * 
 * TODO add support pattern dependencies
 * 
 * @author Thomas Guiu
 * 
 */
public class TranslationHelper {

    public static void translate(final Set<Pattern> patterns) throws PatternException {
        if (patterns.isEmpty())
            return;
        try {
            for (Pattern p : patterns) {
                PatternExtension extension = ExtensionHelper.getExtension(p.getNature());
                extension.createRunner(p).translate();
            }
        } catch (MissingExtensionException e) {
            throw new PatternException(e);

        }

    }
}
