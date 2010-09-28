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

package org.eclipse.egf.pattern.engine;

import java.util.Map;

import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class PatternEngine {

    private final Pattern _pattern;

    private final String _bundleId;

    public PatternEngine(Pattern pattern) throws PatternException {
        if (pattern == null) {
            throw new PatternException(EGFPatternMessages.engine_error1);
        }
        if (pattern.eResource() == null) {
            throw new PatternException(NLS.bind(EGFCoreMessages.EObject_no_Resource, EcoreUtil.getURI(pattern)));
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) pattern.eResource()).getIPlatformFcore();
        if (fcore == null) {
            throw new PatternException(NLS.bind(EGFCoreMessages.Fcore_not_found, EcoreUtil.getURI(pattern).trimFragment()));
        }
        if (fcore.getPlatformBundle().getBundleId() == null) {
            throw new PatternException(EGFPatternMessages.classloader_error4);
        }
        _pattern = pattern;
        _bundleId = fcore.getPlatformBundle().getBundleId();
    }

    protected Pattern getPattern() {
        return _pattern;
    }

    protected String getBundleId() {
        return _bundleId;
    }

    public abstract boolean checkCondition(PatternContext context, Map<PatternParameter, Object> parameters) throws PatternException;

    public abstract void executeWithInjection(PatternContext context, Map<PatternParameter, Object> parameters) throws PatternException;

    public abstract void execute(PatternContext context) throws PatternException;

    public abstract void translate() throws PatternException;

}
