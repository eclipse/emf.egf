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

package org.eclipse.egf.pattern.ui.builder;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.core.platform.resource.IResourceFactoryComponentDelta;
import org.eclipse.egf.core.platform.resource.IResourceFactoryComponentListener;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.execution.TranslationHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * TODO faut il mettre à jour le nom du package destination quand le nom d'une
 * lib change ?
 * 
 * @author Thomas Guiu
 * 
 */
public class FactoryComponentListener implements IResourceFactoryComponentListener {

    public static final FactoryComponentListener INSTANCE = new FactoryComponentListener();

    public void factoryComponentChanged(IResourceFactoryComponentDelta delta) {
        Set<Pattern> patterns = new HashSet<Pattern>();
        for (URI uri : delta.getChangedResourceFactoryComponents()) {
            patterns.addAll(PatternHelper.getPatterns(uri));
        }
        translate(patterns);
    }

    private void translate(final Set<Pattern> patterns) {
        if (patterns.isEmpty())
            return;
        Job job = new Job(Messages.translation_job_label) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    new WorkspaceModifyOperation() {
                        @Override
                        protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
                            try {
                                monitor.beginTask(Messages.translation_job_label, patterns.size());
                                TranslationHelper.translate(patterns);
                            } catch (Exception e) {
                                throw new InvocationTargetException(e);
                            }
                        }
                    }.run(monitor);
                } catch (InvocationTargetException e) {
                    Activator.getDefault().logError(e.getTargetException());
                } catch (InterruptedException e) {
                    Activator.getDefault().logError(e);
                }
                return Status.OK_STATUS;
            }

        };
        job.schedule();

    }

}
