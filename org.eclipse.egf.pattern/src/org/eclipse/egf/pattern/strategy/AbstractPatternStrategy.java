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

package org.eclipse.egf.pattern.strategy;

import java.util.Collection;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractPatternStrategy extends AbstractStrategy {

    protected void doExecute(Collection<Pattern> patterns, PatternContext context) throws MissingExtensionException, PatternException {
        for (Pattern pattern : patterns) {
            PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
            String canExecute = extension.canExecute(pattern);
            if (canExecute != null)
                throw new PatternException(canExecute);
            extension.createEngine(pattern).execute(context);
        }
    }

}
