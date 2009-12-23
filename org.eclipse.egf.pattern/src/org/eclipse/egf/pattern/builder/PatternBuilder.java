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

package org.eclipse.egf.pattern.builder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.PatternConstants;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternHelper.FilenameFormatException;
import org.eclipse.egf.pattern.execution.TranslationHelper;

/**
 * Performs pattern translation each time a pt file is changed.
 * 
 * TODO gérer le cas où le model est modifié/supprimé et quand la classe générée
 * est supprimée.
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternBuilder extends IncrementalProjectBuilder {

    @SuppressWarnings("unchecked")
    @Override
    protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
        Set<String> patternIds = null;
        IResourceDelta delta = getDelta(getProject());
        if (delta != null && delta.getKind() != IResourceDelta.NO_CHANGE) {
            PatternVisitor patternVisitor = new PatternVisitor();
            delta.accept(patternVisitor);
            patternIds = patternVisitor.getPatternId2translate();
        }

        checkCancellation(monitor);

        Set<Pattern> patterns = PatternHelper.getPatterns(getProject(), patternIds);
        if (patternIds != null && patterns.size() != patternIds.size())
            Activator.getDefault().logWarning(Messages.PatternBuilding_warning);
        try {
            // TODO que se passe t il si le header est supprimé ?
            TranslationHelper.translate(patterns);
        } catch (PatternException e) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.PatternBuilding_Failed, e));
        }
        return null;
    }

    private void checkCancellation(IProgressMonitor monitor) {
        if (monitor != null && monitor.isCanceled())
            throw new OperationCanceledException();
    }

    class PatternVisitor implements IResourceDeltaVisitor {

        private final Set<String> patternId2translate = new HashSet<String>();

        public PatternVisitor() {
        }

        @Override
        public boolean visit(IResourceDelta delta) throws CoreException {

            IResource resource = delta.getResource();
            if (resource.getType() == IResource.FILE) {
                if (PatternConstants.PATTERN_UNIT_FILE_EXTENSION.equals(resource.getFileExtension())) {
                    try {
                        patternId2translate.add(PatternHelper.Filename.extractPatternId(resource.getProjectRelativePath()));
                    } catch (FilenameFormatException e) {
                        Activator.getDefault().logError(e);
                    }
                }
                return false;
            }
            return true;
        }

        public Set<String> getPatternId2translate() {
            return patternId2translate;
        }

    }

}
