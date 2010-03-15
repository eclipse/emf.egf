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

package org.eclipse.egf.pattern.engine;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.Messages;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class PatternEngine {

    private final Pattern pattern;
    private final String bundleId;

    public PatternEngine(Pattern pattern) throws PatternException {
        this.pattern = pattern;
        bundleId = PatternHelper.getPlatformFcore(pattern).getPlatformBundle().getBundleId();
        if (bundleId == null)
            throw new PatternException(Messages.classloader_error4);
    }

    public abstract void executeWithInjection(PatternContext context, Object... parameters) throws PatternException;
    public abstract void execute(PatternContext context) throws PatternException;

    public abstract void translate() throws PatternException;

    protected Pattern getPattern() {
        return pattern;
    }

    protected String getBundleId() {
        return bundleId;
    }
}
