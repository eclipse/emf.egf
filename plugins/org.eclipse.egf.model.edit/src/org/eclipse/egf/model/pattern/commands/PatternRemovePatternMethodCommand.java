/**
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
 */
package org.eclipse.egf.model.pattern.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.edit.l10n.EGFModelEditMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 */
public class PatternRemovePatternMethodCommand extends RemoveCommand {

    protected List<PatternMethod> _methods;

    protected Resource _resource;

    public PatternRemovePatternMethodCommand(EditingDomain domain, EObject owner, Collection<?> collection) {
        super(domain, owner, PatternPackage.Literals.PATTERN__METHODS, collection);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof Pattern == false) {
            return false;
        }
        if (feature != PatternPackage.Literals.PATTERN__METHODS) {
            return false;
        }
        Pattern pattern = (Pattern) owner;
        if (pattern.eResource() == null || pattern.eResource() instanceof IPlatformFcoreProvider == false) {
            return false;
        }
        _methods = new UniqueEList<PatternMethod>();
        for (Object object : collection) {
            if (object instanceof PatternMethod) {
                _methods.add((PatternMethod) object);
            }
        }
        _resource = pattern.eResource();
        return true;
    }

    @Override
    public void doUndo() {
        performRestorePatternMethods(_resource, _methods);
        super.doUndo();
    }

    public static void performDeletePatternMethods(final Resource resource, final List<PatternMethod> methods) {
        if (resource == null || methods == null || methods.isEmpty()) {
            return;
        }
        WorkspaceJob job = new WorkspaceJob(EGFModelEditMessages.RemovePatternMethodCommand_execute) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                // Remove PatternMethod
                try {
                    TemplateModelFileHelper.removeTemplates(monitor, methods);
                    return Status.OK_STATUS;
                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        return ((CoreException) t).getStatus();
                    }
                    return EGFModelEditPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFModelEditMessages.PatternRemovePatternMethodCommand_execute_exception, resource.getURI()), t);
                } finally {
                    monitor.done();
                }
            }

        };
        job.setRule(EMFHelper.getProject(resource));
        job.schedule();
    }

    public static void performRestorePatternMethods(final Resource resource, final List<PatternMethod> methods) {
        if (resource == null || methods == null || methods.isEmpty() || resource instanceof IPlatformFcoreProvider == false) {
            return;
        }
        WorkspaceJob job = new WorkspaceJob(EGFModelEditMessages.RestorePatternMethodCommand_execute) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                try {
                    // Restore Pattern
                    TemplateModelFileHelper.restoreTemplates(monitor, ((IPlatformFcoreProvider) resource).getIPlatformFcore(), methods);
                    return Status.OK_STATUS;
                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        return ((CoreException) t).getStatus();
                    }
                    return EGFModelEditPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFModelEditMessages.PatternRestorePatternMethodCommand_execute_exception, resource.getURI()), t);
                } finally {
                    monitor.done();
                }
            }

        };
        job.setRule(EMFHelper.getProject(resource));
        job.schedule();
    }

}
