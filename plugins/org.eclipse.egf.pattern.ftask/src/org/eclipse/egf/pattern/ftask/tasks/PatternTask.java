/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ftask.tasks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.utils.SubstitutionHelper;

/**
 * @author Thomas Guiu
 */
public class PatternTask extends AbstractPatternTask {

    private final List<Pattern> patterns = new ArrayList<Pattern>();

    @Override
    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        try {
            PatternContext ctx = createPatternContext(context);
            readContext(context, ctx);
            Node.Container currentNode = ((InternalPatternContext) ctx).getNode();

            TypePatternList patternList = context.getInputValue(PatternContext.PATTERN_ID, TypePatternList.class);
            PatternCollector.INSTANCE.collect(patternList.getElements().toArray(new PatternElement[patternList.getElements().size()]), patterns);
            TypePatternSubstitution substitutions = (TypePatternSubstitution) ctx.getValue(PatternContext.PATTERN_SUBSTITUTIONS);
            SubstitutionHelper.apply(patterns, substitutions);

            for (Pattern pattern : patterns) {
                PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                String reason = extension.canExecute(pattern);

                if (reason == null) {
                    final PatternEngine engine = extension.createEngine(pattern);
                    if (currentNode != null) {
                        Node.Container localNode = new Node.Container(currentNode, engine.getUnderlyingClassname());
                        ((InternalPatternContext) ctx).setNode(localNode);
                    }

                    engine.execute(ctx);
                } else
                    throw new InvocationException(reason);
            }
            writeContext(context, ctx);
            ((InternalPatternContext) ctx).setNode(currentNode);

        } catch (MissingExtensionException e) {
            throw new InvocationException(e);
        } catch (PatternException e) {
            throw new InvocationException(e);
        }
    }

    @Override
    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.postExecute(context, monitor);
        patterns.clear();
    }

}
