/**
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
 */

package org.eclipse.egf.pattern.strategy;

import java.util.Collection;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;

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
            final InternalPatternContext context2 = (InternalPatternContext) context;
            context2.setNode(new Node.Container(context2.getNode(), (String) null));
            extension.createEngine(pattern).execute(context);
            context2.getExecutionBuffer().setLength(0);
            context2.setExecutionCurrentIndex(0);
        }
    }

}
