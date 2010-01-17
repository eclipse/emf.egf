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

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * This is an helper class to ease translation of patterns.
 * 
 * @author Thomas Guiu
 * 
 */
public class EngineHelper {

    public static void execute(String patternId, PatternContext ctx) throws MissingExtensionException, PatternException {
        PatternHelper createCollector = PatternHelper.createCollector();
        Pattern pattern = createCollector.getPattern(patternId);
        PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
        String reason = extension.canExecute(pattern);
        if (reason != null)
            throw new PatternException(reason);
        extension.createEngine(pattern).execute(ctx);
    }

    public static void executeWithInjection(String patternId, PatternContext ctx, Object... parameters) throws MissingExtensionException, PatternException {
        PatternHelper createCollector = PatternHelper.createCollector();
        Pattern pattern = createCollector.getPattern(patternId);
        PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
        String reason = extension.canExecute(pattern);
        if (reason != null)
            throw new PatternException(reason);
        extension.createEngine(pattern).executeWithInjection(ctx, parameters);
    }

    private EngineHelper() {
        super();

    }

}
