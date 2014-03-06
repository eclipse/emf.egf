/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.edit.l10n.EGFModelEditMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 */
public class PatternLibraryRemovePatternCommand extends RemoveCommand {

    protected List<Pattern> _patterns;

    protected Resource _resource;

    public PatternLibraryRemovePatternCommand(EditingDomain domain, EObject owner, Collection<?> collection) {
        super(domain, owner, PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS, collection);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof PatternLibrary == false) {
            return false;
        }
        if (feature != PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS) {
            return false;
        }
        PatternLibrary library = (PatternLibrary) owner;
        if (library.eResource() == null || library.eResource() instanceof IPlatformFcoreProvider == false) {
            return false;
        }
        _patterns = new UniqueEList<Pattern>();
        for (Object object : collection) {
            if (object instanceof Pattern) {
                _patterns.add((Pattern) object);
            }
        }
        _resource = library.eResource();
        return true;
    }

    @Override
    public void doUndo() {
        performRestorePatterns(_resource, _patterns);
        super.doUndo();
    }

    public static void performDeletePatterns(final Resource resource, final Collection<Pattern> patterns) {
        if (resource == null || patterns == null || patterns.isEmpty()) {
            return;
        }
        WorkspaceJob job = new WorkspaceJob(EGFModelEditMessages.RemovePatternCommand_execute) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                try {
                    SubMonitor subMonitor = SubMonitor.convert(monitor, 100 * patterns.size());
                    subMonitor.beginTask(null, 100);
                    MultiStatus statii = new MultiStatus(EGFModelEditPlugin.getPlugin().getSymbolicName(), IStatus.ERROR, NLS.bind(EGFModelEditMessages.PatternLibraryRemovePatternCommand_execute_exception, resource.getURI()), null);

                    // Remove Pattern
                    for (Pattern pattern : patterns) {
                        try {
                            // Remove Pattern templates
                            TemplateModelFileHelper.removeTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), pattern.getMethods());
                        } catch (Throwable t) {
                            if (t instanceof CoreException) {
                                statii.add(((CoreException) t).getStatus());
                            } else {
                                statii.add(EGFModelEditPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFModelEditMessages.RemovePatternCommand_execute_exception, EcoreUtil.getURI(pattern)), t));
                            }
                        }
                    }

                    return statii.getChildren().length != 0 ? statii : Status.OK_STATUS;
                } finally {
                    monitor.done();
                }
            }

        };
        job.setRule(EMFHelper.getProject(resource));
        job.schedule();
    }

    public static void performRestorePatterns(final Resource resource, final Collection<Pattern> patterns) {
        if (resource == null || patterns == null || patterns.isEmpty() || resource instanceof IPlatformFcoreProvider == false) {
            return;
        }
        WorkspaceJob job = new WorkspaceJob(EGFModelEditMessages.RestorePatternCommand_execute) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                try {
                    SubMonitor subMonitor = SubMonitor.convert(monitor, 100 * patterns.size());
                    MultiStatus statii = new MultiStatus(EGFModelEditPlugin.getPlugin().getSymbolicName(), IStatus.ERROR, NLS.bind(EGFModelEditMessages.PatternLibraryRestorePatternCommand_execute_exception, resource.getURI()), null);
                    // Restore Pattern
                    for (Pattern pattern : patterns) {
                        try {
                            TemplateModelFileHelper.restoreTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), ((IPlatformFcoreProvider) resource).getIPlatformFcore(), pattern.getMethods());
                        } catch (Throwable t) {
                            if (t instanceof CoreException) {
                                statii.add(((CoreException) t).getStatus());
                            } else {
                                statii.add(EGFModelEditPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFModelEditMessages.RestorePatternCommand_execute_exception, EcoreUtil.getURI(pattern)), t));
                            }
                        }
                    }
                    return statii.getChildren().length != 0 ? statii : Status.OK_STATUS;
                } finally {
                    monitor.done();
                }
            }

        };
        job.setRule(EMFHelper.getProject(resource));
        job.schedule();
    }

}
