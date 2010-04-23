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

package org.eclipse.egf.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * Pattern are executed in the given order. Pattern libraries are substituted by
 * their contents.
 * 
 * @author Thomas Guiu
 * 
 */
public class DefaultStrategy extends AbstractPatternStrategy {

    public void execute(PatternContext context, Object parameter) throws PatternException, MissingExtensionException {
        List<Pattern> result = new ArrayList<Pattern>();
        // to replace libraries by their contents
        PatternCollector.INSTANCE.collect(patternElements, result);
        doExecute(result, context);
    }
}
