/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class TranslationHelper {

    private TranslationHelper() {
        // Prevent Instantiation
    }

    public static void translate(IProgressMonitor monitor, final Set<Pattern> patterns) throws PatternException {
        if (patterns.isEmpty()) {
            return;
        }
        translate(monitor, getOrderedList(patterns));
    }

    public static void translate(IProgressMonitor monitor, final List<Pattern> patterns) throws PatternException {
        if (patterns.isEmpty()) {
            return;
        }
        SubMonitor subMonitor = SubMonitor.convert(monitor, patterns.size());
        try {
            for (Pattern p : patterns) {
                subMonitor.setTaskName(NLS.bind(EGFPatternMessages.pattern_translation_label, p.getName()));
                PatternExtension extension = ExtensionHelper.getExtension(p.getNature());
                String reason = extension.canTranslate(p);
                if (reason == null) {
                    extension.createEngine(p).translate();
                } else {
                    EGFPatternPlugin.getDefault().logWarning(NLS.bind(EGFPatternMessages.assembly_error3, p.getName(), reason));
                }
                if (subMonitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
                subMonitor.worked(1);
            }
        } catch (MissingExtensionException e) {
            throw new PatternException(e);
        }
    }

    public static List<Pattern> getOrderedList(Set<Pattern> patterns) {
        List<Pattern> result = new ArrayList<Pattern>(patterns.size());
        Set<Pattern> visited = new HashSet<Pattern>(100);
        for (Pattern p : patterns) {
            addRequirements(p, result, patterns, visited);
        }
        visited.clear();
        return result;
    }

    private static void addRequirements(Pattern pattern, List<Pattern> result, Set<Pattern> allPatterns, Set<Pattern> visited) {
        if (visited.contains(pattern)) {
            return;
        }
        visited.add(pattern);
        Pattern superPattern = pattern.getSuperPattern();
        if (superPattern != null) {
            addRequirements(superPattern, result, allPatterns, visited);
        }
        // list dependencies
        for (Call call : pattern.getOrchestration()) {
            if (call instanceof AbstractPatternCall) {
                addRequirements(((AbstractPatternCall) call).getCalled(), result, allPatterns, visited);
            }
        }
        if (allPatterns.contains(pattern)) {
            result.add(pattern);
        }
    }

}
