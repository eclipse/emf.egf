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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.core.fcore.IResourceFcoreDelta;
import org.eclipse.egf.core.fcore.IResourceFcoreListener;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * TODO faut il mettre à jour le nom du package destination quand le nom d'une
 * lib change (meme question pour le nom du pattern) ?
 * 
 * @author Thomas Guiu
 * 
 */
public class FcoreListener implements IResourceFcoreListener {

  public static final FcoreListener INSTANCE = new FcoreListener();

  public void fcoreChanged(IResourceFcoreDelta delta) {
    translate(delta.getUpdatedResourceFcores());
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
              Set<Pattern> patterns = new HashSet<Pattern>();
              PatternHelper patternCollector = PatternHelper.createCollector();
              try {
                innerMonitor.beginTask(Messages.translation_job_label, uris.length);
                for (URI uri : uris)
                  patterns.addAll(patternCollector.getPatterns(uri));

                new TranslationHelper().translate(patterns);
              } catch (Exception e) {
                throw new InvocationTargetException(e);
              } finally {
                patterns.clear();
                patternCollector.clear();
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
