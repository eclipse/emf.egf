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

package org.eclipse.egf.pattern.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * @author Thomas Guiu
 * 
 */
public class TranslationHelper {

    public void translate(final Set<Pattern> patterns) throws PatternException {
        if (patterns.isEmpty())
            return;
        translate(getOrderedList(patterns));
    }

    public void translate(final List<Pattern> patterns) throws PatternException {
        if (patterns.isEmpty())
            return;
        try {
            for (Pattern p : patterns) {
                PatternExtension extension = ExtensionHelper.getExtension(p.getNature());
                String reason = extension.canTranslate(p);
                if (reason == null)
                    extension.createEngine(p).translate();
                else
                    Activator.getDefault().logWarning(Messages.bind(Messages.assembly_error3, p.getName(), reason));
            }
        } catch (MissingExtensionException e) {
            throw new PatternException(e);

        }
    }

    private List<Pattern> getOrderedList(Set<Pattern> patterns) {
        List<Pattern> result = new ArrayList<Pattern>(patterns.size());
        Set<Pattern> visited = new HashSet<Pattern>(100);
        for (Pattern p : patterns) {
            addRequirements(p, result, patterns, visited);
        }
        visited.clear();
        return result;
    }

    private void addRequirements(Pattern pattern, List<Pattern> result, Set<Pattern> allPatterns, Set<Pattern> visited) {
        if (visited.contains(pattern))
            return;
        visited.add(pattern);

        Pattern superPattern = pattern.getSuperPattern();
        if (superPattern != null)
            addRequirements(superPattern, result, allPatterns, visited);

        // list dependencies
        for (Call call : pattern.getOrchestration()) {
            if (call instanceof AbstractPatternCall) {
                addRequirements(((AbstractPatternCall) call).getCalled(), result, allPatterns, visited);
            }
        }
        if (allPatterns.contains(pattern))
            result.add(pattern);
    }
}
