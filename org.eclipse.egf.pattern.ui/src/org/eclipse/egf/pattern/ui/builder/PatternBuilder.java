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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.PatternConstants;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternHelper.FilenameFormatException;
import org.eclipse.egf.pattern.translation.TranslationHelper;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

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
            if (patternIds.isEmpty())
                return null;
        }

        checkCancellation(monitor);

        Set<Pattern> patterns = PatternHelper.getPatterns(getProject(), patternIds);
        if (patternIds != null && patterns.size() != patternIds.size())
            Activator.getDefault().logWarning(Messages.PatternBuilding_warning);
        try {
            new TranslationHelper().translate(patterns);
        } catch (PatternException e) {
            // log the error instead of throwing a CoreException
            Activator.getDefault().logError(Messages.PatternBuilding_Failed, e);
        } finally {
            if (!patterns.isEmpty()) {
                ResourceSet set = patterns.iterator().next().eResource().getResourceSet();
                for (Resource res : set.getResources())
                    res.unload();
                patterns.clear();
            }
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

        public boolean visit(IResourceDelta delta) throws CoreException {

            IResource resource = delta.getResource();
            if (resource.getType() == IResource.FILE) {
                if (delta.getKind() != IResourceDelta.REMOVED && PatternConstants.PATTERN_UNIT_FILE_EXTENSION.equals(resource.getFileExtension())) {
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
