/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.builder;

import java.util.HashSet;
import java.util.List;
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
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper.FilenameFormatException;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;

/**
 * Performs pattern translation each time a pt file is changed.
 * TODO gérer le cas où le model est modifié/supprimé et quand la classe générée
 * est supprimée.
 * 
 * @author Thomas Guiu
 */
public class PatternBuilder extends IncrementalProjectBuilder {

    class PatternVisitor implements IResourceDeltaVisitor {

        private final Set<String> patternId2translate = new HashSet<String>();

        public PatternVisitor() {
            // Nothing to do
        }

        public boolean visit(IResourceDelta delta) throws CoreException {
            IResource resource = delta.getResource();
            if (resource.getType() == IResource.FILE) {
                if (delta.getKind() != IResourceDelta.REMOVED && TemplateModelFileHelper.PATTERN_UNIT_FILE_EXTENSION.equals(resource.getFileExtension())) {
                    if (delta.getFlags() != IResourceDelta.MARKERS) {
                        try {
                            patternId2translate.add(TemplateModelFileHelper.extractPatternId(resource.getProjectRelativePath()));
                        } catch (FilenameFormatException e) {
                            EGFPatternPlugin.getDefault().logError(e);
                        }
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

    @Override
    @SuppressWarnings("rawtypes")
    protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        if (project == null || project.isAccessible() == false) {
            return new IProject[0];
        }
        PatternHelper helper = null;
        List<Pattern> patterns = null;
        try {
            // Visitor
            Set<String> patternIds = null;
            IResourceDelta delta = getDelta(project);
            // Analyse delta
            if (delta != null && delta.getKind() != IResourceDelta.NO_CHANGE) {
                PatternVisitor patternVisitor = new PatternVisitor();
                delta.accept(patternVisitor);
                patternIds = patternVisitor.getPatternId2translate();
                // Nothing to do
                if (patternIds.isEmpty()) {
                    return null;
                }
            }
            // Check
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            // At this stage, either delta is null or patternIds are not empty
            // Collect patterns
            helper = PatternHelper.createCollector();
            patterns = helper.getPatterns(project, patternIds);
            // if (patternIds != null && patterns.size() != patternIds.size())
            // Activator.getDefault().logWarning(Messages.PatternBuilding_warning);
            // Translate
            if (delta != null) {
                TranslationHelper.translate(monitor, patterns);
            } else {
                TranslationHelper.translate(monitor, new HashSet<Pattern>(patterns));
            }
        } catch (OperationCanceledException oce) {
            throw oce;
        } catch (Throwable t) {
            // log the error instead of throwing a CoreException
            EGFPatternPlugin.getDefault().logError(EGFPatternMessages.PatternBuilding_Failed, t);
        } finally {
            monitor.done();
            if (helper != null) {
                helper.clear();
            }
            if (patterns != null) {
                patterns.clear();
            }
        }
        return null;
    }

}
