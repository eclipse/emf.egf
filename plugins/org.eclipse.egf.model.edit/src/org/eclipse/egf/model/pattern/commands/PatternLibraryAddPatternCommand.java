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

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.edit.l10n.EGFModelEditMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNameHelper;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 */
public class PatternLibraryAddPatternCommand extends AddCommand {

    private static IProject getProject(URIConverter converter, URI uri) {
        if (converter == null || uri == null) {
            return null;
        }
        uri = converter.normalize(uri);
        if (uri != null && uri.isPlatformResource()) {
            return ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
        }
        return null;
    }

    protected Collection<Pattern> _patterns;

    protected Map<PatternMethod, URI[]> _methods;

    protected Resource _resource;

    protected boolean _copy;

    public PatternLibraryAddPatternCommand(EditingDomain domain, PatternLibrary patternLibrary, Collection<?> collection, int index) {
        super(domain, patternLibrary, PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS, collection, index);
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
        if (library.eResource() == null || EMFHelper.getProject(library.eResource()) == null || library.eResource() instanceof IPlatformFcoreProvider == false) {
            return false;
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) library.eResource()).getIPlatformFcore();
        if (fcore == null) {
            return false;
        }
        // Populate
        _patterns = new UniqueEList<Pattern>();
        _methods = new HashMap<PatternMethod, URI[]>();
        for (Object object : collection) {
            if (object instanceof Pattern == false) {
                continue;
            }
            Pattern pattern = (Pattern) object;
            _patterns.add(pattern);
            try {
                for (PatternMethod method : pattern.getMethods()) {
                    _methods.put(method, new URI[] {
                            method.getPatternFilePath(), null
                    });
                }
            } catch (Throwable t) {
                return false;
            }
        }
        _resource = library.eResource();
        return true;
    }

    @Override
    public void doExecute() {
        // Add
        super.doExecute();
        // Check and update pattern name if not unique
        PatternLibrary library = (PatternLibrary) owner;
        IPlatformFcore fcore = ((IPlatformFcoreProvider) library.eResource()).getIPlatformFcore();
        for (Pattern pattern : _patterns) {
            PatternNameHelper.setUniquePatternName(fcore, pattern);
        }
        _copy = performCreatePatternTemplates(_resource, _methods);
    }

    @Override
    public void doUndo() {
        if (_copy) {
            PatternLibraryRemovePatternCommand.performDeletePatterns(_resource, _patterns);
        }
        super.doUndo();
    }

    @Override
    public void doRedo() {
        if (_copy) {
            PatternLibraryRemovePatternCommand.performRestorePatterns(_resource, _patterns);
        }
        super.doRedo();
    }

    public static boolean performCreatePatternTemplates(final Resource resource, final Map<PatternMethod, URI[]> methods) {

        if (resource == null || methods == null || methods.isEmpty() || resource instanceof IPlatformFcoreProvider == false) {
            return false;
        }
        boolean copy = false;
        boolean restore = false;
        List<IProject> projects = new UniqueEList<IProject>();
        final URIConverter converter = resource.getResourceSet().getURIConverter();

        // Compute new PatternFilePath and project to be locked
        for (Map.Entry<PatternMethod, URI[]> entry : methods.entrySet()) {
            // Ignore
            URI fromURI = entry.getValue()[0];
            if (fromURI == null) {
                continue;
            }
            // Compute new PatternFilePath
            PatternMethod method = entry.getKey();
            // ignore new pattern, chained command
            // @see org.eclipse.egf.pattern.ui.contributions.PatternMenuContributor.CreatePatternAction
            if (method.getPatternFilePath() == null) {
                continue;
            }
            // Create new URI
            URI toURI = TemplateModelFileHelper.computeFileURI(((IPlatformFcoreProvider) resource).getIPlatformFcore(), method);
            if (toURI == null) {
                continue;
            }
            // Assign new URI
            method.setPatternFilePath(toURI);
            // Store new URI
            entry.getValue()[1] = toURI;
            // Compute Target Project
            IProject toProject = getProject(converter, toURI);
            if (toProject == null) {
                continue;
            }
            // Check Whether or not we will process a copy or a .pt restore
            if (fromURI.equals(toURI)) {
                IFile file = toProject.getFile(URIHelper.toPlatformProjectString(fromURI, true));
                if (file.exists() == false) {
                    restore = true;
                }
            } else {
                copy = true;
            }
            // Store Projects to be processed
            IProject fromProject = getProject(converter, fromURI);
            if (fromProject != null) {
                projects.add(fromProject);
            }
            projects.add(toProject);
        }

        // Copy Template Job
        WorkspaceJob job = new WorkspaceJob(EGFModelEditMessages.CopyPatternTemplateCommand_execute) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {

                try {
                    SubMonitor subMonitor = SubMonitor.convert(monitor, 100 * methods.size());
                    MultiStatus statii = new MultiStatus(EGFModelEditPlugin.getPlugin().getSymbolicName(), IStatus.ERROR, EGFModelEditMessages.CopyPatternTemplatesCommand_execute_exception, null);
                    // Copy Pattern Templates
                    for (Map.Entry<PatternMethod, URI[]> entry : methods.entrySet()) {
                        URI fromURI = entry.getValue()[0];
                        if (fromURI == null) {
                            subMonitor.worked(100);
                            continue;
                        }
                        // ignore new pattern, chained command
                        // @see org.eclipse.egf.pattern.ui.contributions.PatternMenuContributor.CreatePatternAction
                        PatternMethod method = entry.getKey();
                        if (method.getPatternFilePath() == null) {
                            subMonitor.worked(100);
                            continue;
                        }
                        // Process copy or restore
                        URI toURI = entry.getValue()[1];
                        // Compute Target Project
                        IProject toProject = getProject(converter, toURI);
                        if (toProject == null) {
                            subMonitor.worked(100);
                            continue;
                        }
                        try {
                            // if method template exists do nothing or restore it if any
                            if (fromURI.equals(toURI)) {
                                // Restore pt files
                                IFile file = toProject.getFile(URIHelper.toPlatformProjectString(fromURI, true));
                                if (file.exists() == false) {
                                    IFileState[] states = file.getHistory(monitor);
                                    if (states != null && states.length > 0) {
                                        for (IFileState state : states) {
                                            if (state.exists() == false) {
                                                continue;
                                            }
                                            FileHelper.createContainers(subMonitor.newChild(50, SubMonitor.SUPPRESS_NONE), file);
                                            file.create(state.getContents(), false, subMonitor.newChild(50, SubMonitor.SUPPRESS_NONE));
                                            break;
                                        }
                                    }
                                }
                            } else {
                                // Locate source input
                                InputStream input = null;
                                // Compute Source Project
                                IProject fromProject = getProject(converter, fromURI);
                                if (fromProject != null) {
                                    // Workspace
                                    IFile fromFile = fromProject.getFile(URIHelper.toPlatformProjectString(fromURI, true));
                                    if (fromFile.exists() == false) {
                                        IFileState[] states = fromFile.getHistory(monitor);
                                        if (states != null && states.length > 0) {
                                            for (IFileState state : states) {
                                                if (state.exists() == false) {
                                                    continue;
                                                }
                                                input = state.getContents();
                                                break;
                                            }
                                        }
                                    } else {
                                        input = fromFile.getContents();
                                    }
                                } else {
                                    // Target
                                    input = converter.createInputStream(fromURI);
                                }
                                if (input == null) {
                                    throw new CoreException(EGFModelEditPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFModelEditMessages.CopyPatternTemplateCommand_no_input_exception, fromURI), null));
                                }
                                // Create target file content
                                IFile toFile = toProject.getFile(URIHelper.toPlatformProjectString(toURI, true));
                                FileHelper.createContainers(subMonitor.newChild(50, SubMonitor.SUPPRESS_NONE), toFile);
                                toFile.create(input, false, subMonitor.newChild(50, SubMonitor.SUPPRESS_NONE));
                            }
                        } catch (Throwable t) {
                            if (t instanceof CoreException) {
                                statii.add(((CoreException) t).getStatus());
                            } else {
                                statii.add(EGFModelEditPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFModelEditMessages.CopyPatternTemplateCommand_execute_exception, fromURI, toURI), t));
                            }
                        }
                    }
                    return statii.getChildren().length != 0 ? statii : Status.OK_STATUS;
                } finally {
                    monitor.done();
                }

            }

        };

        // Do nothing if no copy or restore
        if (copy || restore) {
            job.setRule(ProjectHelper.getRule(projects));
            job.schedule();
            return copy;
        }
        return false;

    }

}
