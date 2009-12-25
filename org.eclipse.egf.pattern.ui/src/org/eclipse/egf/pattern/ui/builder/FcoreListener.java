/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui.builder;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.egf.core.fcore.IResourceFcoreListener;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * TODO faut il mettre à jour le nom du package destination quand le nom d'une
 * lib change ?
 * 
 * @author Thomas Guiu
 * 
 */
public class FcoreListener implements IResourceFcoreListener {

    public static final FcoreListener INSTANCE = new FcoreListener();

    public void fcoreChanged(IResourceFcoreDelta delta) {
        translate(delta.getChangedResourceFcores());
    }

    private void translate(final URI[] uris) {
        if (uris == null || uris.length == 0)
            return;
        Job job = new Job(Messages.translation_job_label) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    new WorkspaceModifyOperation() {
                        @Override
                        protected void execute(IProgressMonitor innerMonitor) throws CoreException, InvocationTargetException, InterruptedException {
                            ResourceSet set = new ResourceSetImpl();
                            try {
                                innerMonitor.beginTask(Messages.translation_job_label, uris.length);
                                // List<PatternElement> list = new
                                // ArrayList<PatternElement>();
                                // for (URI uri : uris) {
                                // Resource res =
                                // ResourceHelper.loadResource(set, uri);
                                // for (EObject obj : res.getContents())
                                // {
                                // }
                                // }
                            } catch (Exception e) {
                                throw new InvocationTargetException(e);
                            } finally {
                                for (Resource res : set.getResources())
                                    res.unload();
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
