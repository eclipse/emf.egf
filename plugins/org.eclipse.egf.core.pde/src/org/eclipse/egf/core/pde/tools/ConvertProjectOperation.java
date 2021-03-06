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
package org.eclipse.egf.core.pde.tools;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.helper.ProjectHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.natures.EGFNatures;
import org.eclipse.egf.core.pde.EGFPDEPlugin;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.ibundle.IManifestHeader;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.pde.internal.core.text.bundle.BundleSymbolicNameHeader;
import org.eclipse.pde.internal.ui.util.ModelModification;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;
import org.eclipse.pde.internal.ui.wizards.tools.OrganizeManifest;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;

/**
 * Operation to convert a simple project or a bundle into an EGF java bundle
 * project if necessary
 */
public class ConvertProjectOperation extends WorkspaceModifyOperation {

    private static final String DEFAULT_LIBRARY = EGFCommonConstants.DOT_STRING;

    private IProject _project;

    private boolean createJavaProject;

    private boolean addEGFNature;

    private final List<String> sourceFolders = new UniqueEList<String>();

    private final List<String> outputFolders = new UniqueEList<String>();

    private final List<String> libraries = new UniqueEList<String>();

    private final List<String> directories = new UniqueEList<String>();

    private final List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();

    private String[] initialSourceFolders;
    private String[] initialDependencies;

    /**
     * Workspace operation to convert the specified project into a plug-in
     * project.
     * 
     * @param project
     *            The project to be converted in a Bundle
     * @param createJavaProject
     *            The project should be converted to a JavaProject
     * @param addEGFNature
     *            The project should have en EGF Nature.
     */
    public ConvertProjectOperation(IProject project, boolean createJavaProject, boolean addEGFNature) {
        _project = project;
        this.createJavaProject = createJavaProject;
        this.addEGFNature = addEGFNature;
    }

    public static String getValidId(String projectName) {
        String name = projectName.replaceAll("[^a-zA-Z0-9\\._]", "_"); //$NON-NLS-1$ //$NON-NLS-2$
        // . is illegal as a first character
        if (name != null && name.startsWith(".")) { //$NON-NLS-1$
            return name.substring(1, name.length());
        }
        return name;
    }

    /**
     * Convert a project
     * 
     * @param monitor
     *            Progress monitor
     */

    @Override
    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {

        SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.ConvertProjectOperation_converter, 1000);

        boolean hasPluginNature = false;
        boolean hasJavaNature = false;

        // Do early checks to make sure we can get out fast if we're not setup
        // properly
        if (_project == null || _project.exists() == false) {
            return;
        }

        // Build an EMF URI Style
        URI projectLocationURI = URI.createFileURI(_project.getFullPath().toOSString());

        // Nature
        List<String> requiredNatures = new ArrayList<String>();
        List<String> requiredBuilders = new ArrayList<String>();

        if (_project.hasNature(EGFNatures.EGF_NATURE)) {
            requiredBuilders.add(EGFNatures.PATTERN_BUILDER_ID);
        } else if (addEGFNature) {
            requiredNatures.add(EGFNatures.EGF_NATURE);
            requiredBuilders.add(EGFNatures.PATTERN_BUILDER_ID);
        }

        if (_project.hasNature(PDE.PLUGIN_NATURE)) {
            hasPluginNature = true;
        } else
            requiredNatures.add(PDE.PLUGIN_NATURE);
        requiredBuilders.add(PDE.MANIFEST_BUILDER_ID);
        requiredBuilders.add(PDE.SCHEMA_BUILDER_ID);

        if (_project.hasNature(JavaCore.NATURE_ID)) {
            hasJavaNature = true;
            IJavaProject javaProject = null;
            try {
                javaProject = JavaCore.create(_project);
                classpathEntries.addAll(Arrays.asList(javaProject.getRawClasspath()));
                for (String outputFolder : JavaHelper.getStringOutputFolders(javaProject)) {
                    outputFolders.add(outputFolder + EGFCommonConstants.SLASH_CHARACTER);
                }
            } finally {
                if (javaProject != null) {
                    javaProject.close();
                }
            }
            requiredBuilders.add(JavaCore.BUILDER_ID);
        } else if (createJavaProject) {
            requiredNatures.add(JavaCore.NATURE_ID);
            requiredBuilders.add(JavaCore.BUILDER_ID);
        }
        // Create Project Description if necessary
        IProjectDescription projectDescription = null;
        if (_project.exists()) {
            projectDescription = _project.getDescription();
            subMonitor.worked(100);
        } else {
            projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(_project.getName());
            if (projectLocationURI != null) {
                try {
                    projectDescription.setLocationURI(new java.net.URI(projectLocationURI.toString()));
                } catch (URISyntaxException use) {
                    throw new CoreException(EGFPDEPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, use));
                }
            }
            _project.create(projectDescription, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        }

        // Nature setup
        if (projectDescription.getNatureIds() == null) {
            projectDescription.setNatureIds(requiredNatures.toArray(new String[requiredNatures.size()]));
            subMonitor.worked(200);
        } else
            ProjectHelper.addNatures(projectDescription, requiredNatures, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));

        ProjectHelper.addBuilders(projectDescription, requiredBuilders, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));

        // Set Project Description
        _project.setDescription(projectDescription, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));

        setupEntries(monitor, hasJavaNature || createJavaProject);

        // Manifest
        if (hasPluginNature && _project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR).exists()) {
            updateManifestFile(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        } else {
            createManifestFile(_project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR), subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        }

        // build.properties
        if (hasPluginNature && _project.getFile(ICoreConstants.BUILD_FILENAME_DESCRIPTOR).exists()) {
            updateBuildFile(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        } else {
            createBuildFile(_project.getFile(ICoreConstants.BUILD_FILENAME_DESCRIPTOR), subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
        }

    }

    private void setupEntries(IProgressMonitor monitor, boolean isJavaProject) throws CoreException {

        SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.ConvertProjectOperation_setupClasspath, 400);

        // Current variables
        boolean isInitiallyEmpty = classpathEntries.isEmpty();
        boolean hasRequiredPluginsContainer = false;

        // Classpath analysis
        for (IClasspathEntry currentClassPath : classpathEntries) {
            switch (currentClassPath.getEntryKind()) {
            case IClasspathEntry.CPE_SOURCE:
                // Process existing source folder
                String relativePath = getRelativePath(currentClassPath, _project);
                // Create a src source folder if none
                if (EGFCommonConstants.EMPTY_STRING.equals(relativePath)) {
                    IPath src = new Path("src"); //$NON-NLS-1$
                    IContainer sourceContainer = _project.getFolder(src);
                    if (sourceContainer.exists() == false) {
                        ((IFolder) sourceContainer).create(false, true, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
                    }
                    sourceFolders.add(src.toString() + EGFCommonConstants.SLASH_CHARACTER);
                    IClasspathEntry sourceClasspathEntry = JavaCore.newSourceEntry(sourceContainer.getFullPath());
                    for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext();) {
                        IClasspathEntry classpathEntry = i.next();
                        if (classpathEntry.getPath().isPrefixOf(sourceContainer.getFullPath())) {
                            // Remove previous source folder if any
                            i.remove();
                        }
                    }
                    classpathEntries.add(0, sourceClasspathEntry);
                } else {
                    sourceFolders.add(relativePath + EGFCommonConstants.SLASH_CHARACTER);
                }
                break;
            case IClasspathEntry.CPE_LIBRARY:
                // Process existing library
                String path = getRelativePath(currentClassPath, _project);
                if (path.length() > 0)
                    libraries.add(path);
                else
                    libraries.add(EGFCommonConstants.DOT_STRING);
                break;
            case IClasspathEntry.CPE_CONTAINER:
                hasRequiredPluginsContainer = EGFCommonConstants.REQUIRED_PLUGINS_CLASSPATH_CONTAINER.equals(currentClassPath.getPath().toString());
                break;
            }
        }
        subMonitor.worked(100);

        // Create source folders if necessary
        if (isJavaProject && initialSourceFolders != null) {
            for (String sourceFolder : initialSourceFolders) {
                IPath src = new Path(sourceFolder);
                IContainer sourceContainer = _project.getFolder(src);
                // Create folder if it doesn't exist
                if (sourceContainer.exists() == false) {
                    ((IFolder) sourceContainer).create(false, true, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
                }
                // Classpath processing
                sourceFolders.add(src.toString() + EGFCommonConstants.SLASH_CHARACTER);
                IClasspathEntry sourceClasspathEntry = JavaCore.newSourceEntry(sourceContainer.getFullPath());
                for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext();) {
                    IClasspathEntry classpathEntry = i.next();
                    if (classpathEntry.getPath().isPrefixOf(sourceContainer.getFullPath())) {
                        // Remove previous source folder if any
                        i.remove();
                    }
                }
                classpathEntries.add(0, sourceClasspathEntry);
            }
        } else {
            subMonitor.worked(100);
        }

        // Folder analysis
        for (IResource resource : _project.members()) {
            if (resource instanceof IContainer) {
                String path = resource.getFullPath().removeFirstSegments(1).toString() + EGFCommonConstants.SLASH_CHARACTER;
                // Ignore directories who are either a source folder, an output
                // folder or a directory who starts with a dot
                if (sourceFolders.contains(path) == false && outputFolders.contains(path) == false && path.startsWith(EGFCommonConstants.DOT_STRING) == false) {
                    directories.add(path);
                }
            }
        }

        // Finally setup classpath if necessary
        if (isJavaProject) {
            try {
                // Process JRE if necessary
                if (isInitiallyEmpty) {
                    IClasspathEntry jreClasspathEntry = JavaCore.newVariableEntry(new Path(JavaRuntime.JRELIB_VARIABLE), new Path(JavaRuntime.JRESRC_VARIABLE), new Path(JavaRuntime.JRESRCROOT_VARIABLE));
                    for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext();) {
                        IClasspathEntry classpathEntry = i.next();
                        if (classpathEntry.getPath().isPrefixOf(jreClasspathEntry.getPath())) {
                            i.remove();
                        }
                    }
                    String jreContainer = JavaRuntime.JRE_CONTAINER;
                    String complianceLevel = CodeGenUtil.EclipseUtil.getJavaComplianceLevel(_project);
                    if (JavaCore.VERSION_1_5.equals(complianceLevel)) {
                        jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5"; //$NON-NLS-1$
                    } else if (JavaCore.VERSION_1_6.equals(complianceLevel)) {
                        jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6"; //$NON-NLS-1$
                    } else if (JavaCore.VERSION_1_7.equals(complianceLevel)) {
                        jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7"; //$NON-NLS-1$        
                    }
                    classpathEntries.add(JavaCore.newContainerEntry(new Path(jreContainer)));
                }
                // Process Required Plugins Container if necessary
                if (hasRequiredPluginsContainer == false) {
                    classpathEntries.add(JavaCore.newContainerEntry(new Path(EGFCommonConstants.REQUIRED_PLUGINS_CLASSPATH_CONTAINER)));
                }
                // Classpath setup
                IJavaProject javaProject = null;
                try {
                    javaProject = JavaCore.create(_project);
                    javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
                } finally {
                    if (javaProject != null) {
                        javaProject.close();
                    }
                }
            } catch (JavaModelException jme) {
                throw new CoreException(EGFPDEPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, jme));
            }
        } else {
            subMonitor.worked(100);
        }

    }

    private String getRelativePath(IClasspathEntry classpathEntry, IProject project) {
        return project.getFile(classpathEntry.getPath()).getProjectRelativePath().removeFirstSegments(1).toString();
    }

    private void organizeExports(IProgressMonitor monitor) {
        PDEModelUtility.modifyModel(new ModelModification(_project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR)) {

            @Override
            protected void modifyModel(IBaseModel model, IProgressMonitor innerMonitor) throws CoreException {
                SubMonitor.convert(innerMonitor, EGFCoreMessages.ConvertProjectOperation_organizeExport, 100);
                if (model instanceof IBundlePluginModelBase == false) {
                    return;
                }
                OrganizeManifest.organizeExportPackages(((IBundlePluginModelBase) model).getBundleModel().getBundle(), _project, true, true);
            }
        }, monitor);
    }

    protected String createInitialName(String id) {
        int loc = id.lastIndexOf(EGFCommonConstants.DOT_STRING);
        if (loc == -1) {
            return id;
        }
        StringBuffer buf = new StringBuffer(id.substring(loc + 1));
        buf.setCharAt(0, Character.toUpperCase(buf.charAt(0)));
        return buf.toString();
    }

    private void createBuildFile(IFile file, IProgressMonitor monitor) throws CoreException {
        SubMonitor.convert(monitor, EGFCoreMessages.ConvertProjectOperation_setupBuildfile, 100);
        if (file.exists() == false) {
            WorkspaceBuildModel model = new WorkspaceBuildModel(file);
            manageBuildFile(model);
            model.save();
        }
    }

    private void updateBuildFile(IProgressMonitor monitor) {
        PDEModelUtility.modifyModel(new ModelModification(_project.getFile(ICoreConstants.BUILD_FILENAME_DESCRIPTOR)) {

            @Override
            protected void modifyModel(IBaseModel base, IProgressMonitor innerMonitor) throws CoreException {
                SubMonitor.convert(innerMonitor, EGFCoreMessages.ConvertProjectOperation_setupBuildfile, 100);
                if (base instanceof IBuildModel == false) {
                    return;
                }
                manageBuildFile((IBuildModel) base);
            }

        }, monitor);
    }

    protected void processFolders(IBuildModel model, String prefix, List<String> folders) throws CoreException {
        IBuild build = model.getBuild();
        List<String> defaultFolders = new UniqueEList<String>(folders);
        // Filter already assigned folders if any
        for (IBuildEntry entry : build.getBuildEntries()) {
            // Ignore non jar prefix or default library if any
            if (entry.getName().startsWith(prefix) == false || entry.getName().equals(prefix + DEFAULT_LIBRARY)) {
                continue;
            }
            // detect empty folders
            boolean hasFolders = false;
            // Filter tokens
            for (String token : entry.getTokens()) {
                hasFolders = defaultFolders.remove(token);
            }
            // Remove useless entry
            if (hasFolders == false) {
                build.remove(entry);
            }
        }
        // Retrieve default
        IBuildEntry entry = build.getEntry(prefix + DEFAULT_LIBRARY);
        // Process remaining folders in default library
        if (defaultFolders.size() > 0) {
            // Create if necessary
            if (entry == null) {
                entry = model.getFactory().createEntry(prefix + DEFAULT_LIBRARY);
                build.add(entry);
            }
            // Add remaining folders
            for (String folder : defaultFolders) {
                addToken(entry, folder);
            }
        } else if (entry != null) {
            // Remove useless entry
            build.remove(entry);
        }
    }

    protected void manageBuildFile(IBuildModel model) throws CoreException {
        IBuild build = model.getBuild();
        // source
        processFolders(model, IBuildEntry.JAR_PREFIX, sourceFolders);
        // output
        processFolders(model, IBuildEntry.OUTPUT_PREFIX, outputFolders);
        // bin.includes
        IBuildEntry binIncludesEntry = build.getEntry(IBuildEntry.BIN_INCLUDES);
        boolean newBinIncludesEntry = false;
        // Create if necessary
        if (binIncludesEntry == null) {
            newBinIncludesEntry = true;
            binIncludesEntry = model.getFactory().createEntry(IBuildEntry.BIN_INCLUDES);
        }
        if (_project.getFile(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR).exists()) {
            addToken(binIncludesEntry, ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR);
        }
        if (_project.getFile(EGFCommonConstants.PLUGIN_PROPERTIES_DESCRIPTOR).exists()) {
            addToken(binIncludesEntry, EGFCommonConstants.PLUGIN_PROPERTIES_DESCRIPTOR);
        }
        if (_project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR).exists()) {
            addToken(binIncludesEntry, EGFCommonConstants.BUNDLE_FILENAME_DIRECTORY_DESCRIPTOR);
        }
        // About.html in bin includes (eclipse EPL open source project
        // convention)
        if (_project.getFile(EGFCommonConstants.ABOUT_HTML_DESCRIPTOR).exists()) {
            addToken(binIncludesEntry, EGFCommonConstants.ABOUT_HTML_DESCRIPTOR);
        }
        for (String directory : directories) {
            addToken(binIncludesEntry, directory);
        }
        for (String library : libraries) {
            addToken(binIncludesEntry, library);
        }
        if (sourceFolders.size() > 0) {
            addToken(binIncludesEntry, DEFAULT_LIBRARY);
        }
        if (newBinIncludesEntry && binIncludesEntry.getTokens().length > 0) {
            // add it to build model if necessary
            build.add(binIncludesEntry);
        } else if (binIncludesEntry.getTokens().length == 0) {
            // remove it from build model if necessary
            build.remove(binIncludesEntry);
        }
        // src.includes
        IBuildEntry srcIncludesEntry = build.getEntry(IBuildEntry.SRC_INCLUDES);
        boolean newSrcIncludesEntry = false;
        // Create if necessary
        if (srcIncludesEntry == null) {
            newSrcIncludesEntry = true;
            srcIncludesEntry = model.getFactory().createEntry(IBuildEntry.SRC_INCLUDES);
        }
        // About.html in src includes (eclipse EPL open source project
        // convention)
        if (_project.getFile(EGFCommonConstants.ABOUT_HTML_DESCRIPTOR).exists()) {
            addToken(srcIncludesEntry, EGFCommonConstants.ABOUT_HTML_DESCRIPTOR);
        }
        if (newSrcIncludesEntry && srcIncludesEntry.getTokens().length > 0) {
            // add it to build model if necessary
            build.add(srcIncludesEntry);
        } else if (srcIncludesEntry.getTokens().length == 0) {
            // remove it from build model if necessary
            build.remove(srcIncludesEntry);
        }
    }

    protected void addToken(IBuildEntry entry, String descriptor) throws CoreException {
        boolean found = false;
        for (String token : entry.getTokens()) {
            if (token.equals(descriptor)) {
                found = true;
                break;
            }
        }
        if (found == false) {
            entry.addToken(descriptor);
        }
    }

    private void createManifestFile(IFile file, IProgressMonitor monitor) throws CoreException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.ConvertProjectOperation_setupManifestfile, 200);
        WorkspaceBundlePluginModel model = new WorkspaceBundlePluginModel(file, null);
        model.load();
        manageManifestFile(model);
        model.save();
        subMonitor.worked(100);
        organizeExports(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    }

    private void updateManifestFile(IProgressMonitor monitor) {
        PDEModelUtility.modifyModel(new ModelModification(_project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR)) {

            @Override
            protected void modifyModel(IBaseModel model, IProgressMonitor innerMonitor) throws CoreException {
                SubMonitor subMonitor = SubMonitor.convert(innerMonitor, EGFCoreMessages.ConvertProjectOperation_setupManifestfile, 200);
                if (model instanceof IBundlePluginModelBase == false) {
                    return;
                }
                manageManifestFile((IBundlePluginModelBase) model);
                subMonitor.worked(100);
                OrganizeManifest.organizeExportPackages(((IBundlePluginModelBase) model).getBundleModel().getBundle(), _project, true, true);
            }

        }, monitor);
    }

    protected void manageManifestFile(IBundlePluginModelBase model) throws CoreException {

        IBundle bundle = model.getBundleModel().getBundle();

        String pluginId = bundle.getHeader(Constants.BUNDLE_SYMBOLICNAME);
        String pluginName = bundle.getHeader(Constants.BUNDLE_NAME);
        String pluginVersion = bundle.getHeader(Constants.BUNDLE_VERSION);
        String complianceLevel = bundle.getHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT);

        // Strip singleton keyword to avoid redundancy
        if (pluginId != null && pluginId.indexOf(';') != -1) {
            pluginId = pluginId.substring(0, pluginId.indexOf(';'));
        }

        // Avoid empty string
        if (pluginId != null && pluginId.trim().length() == 0) {
            pluginId = null;
        }

        boolean missingInfo = (pluginId == null || pluginName == null || pluginVersion == null);

        // If no ID exists, create one
        if (pluginId == null) {
            pluginId = getValidId(_project.getName());
        }
        // At this point, the plug-in ID is not null

        // Process Version
        processManifestVersion(model);

        // If no name exists, create one using the non-null pluginID
        if (pluginName == null) {
            pluginName = createInitialName(pluginId);
        }
        // Bundle Name
        bundle.setHeader(Constants.BUNDLE_NAME, pluginName);

        // Bundle Symbolic Name
        IManifestHeader header = bundle.getManifestHeader(Constants.BUNDLE_SYMBOLICNAME);
        if (header != null && header instanceof BundleSymbolicNameHeader) {
            BundleSymbolicNameHeader symbolic = (BundleSymbolicNameHeader) header;
            if (symbolic.getId() == null || symbolic.getId().trim().length() == 0) {
                symbolic.setId(pluginId);
            }
            // This will clean the header if multiple singleton exists
            // If multiple singleton exists like
            // ;singleton:=true;singleton:=true
            // PDE is broken, typically the Plug-in Dependencies classpath
            // container is missing
            // and/or the plugin.xml could display a message like
            // 'A plug-in manifest must contain at least one extension or
            // extension point'
            bundle.setHeader(Constants.BUNDLE_SYMBOLICNAME, pluginId + ";singleton:=true"); //$NON-NLS-1$
        } else {
            bundle.setHeader(Constants.BUNDLE_SYMBOLICNAME, pluginId + ";singleton:=true"); //$NON-NLS-1$
        }

        if (complianceLevel == null && createJavaProject) {
            complianceLevel = CodeGenUtil.EclipseUtil.getJavaComplianceLevel(_project);
            if (JavaCore.VERSION_1_5.equals(complianceLevel)) {
                bundle.setHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, "J2SE-1.5"); //$NON-NLS-1$        
            } else if (JavaCore.VERSION_1_6.equals(complianceLevel)) {
                bundle.setHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, "JavaSE-1.6"); //$NON-NLS-1$
            } else if (JavaCore.VERSION_1_7.equals(complianceLevel)) {
                bundle.setHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, "JavaSE-1.7"); //$NON-NLS-1$        
            }
        }

        IPluginModelFactory factory = model.getPluginFactory();
        IPluginBase base = model.getPluginBase();

        if (missingInfo) {
            for (String library : libraries) {
                IPluginLibrary pluginLibrary = factory.createLibrary();
                pluginLibrary.setName(library);
                pluginLibrary.setExported(true);
                base.add(pluginLibrary);
            }
            bundle.setHeader(Constants.BUNDLE_MANIFESTVERSION, "2"); //$NON-NLS-1$
        }

        // Add Dependencies
        if (createJavaProject && initialDependencies != null) {
            LOOP: for (String dependency : initialDependencies) {
                if (base.getImports() != null) {
                    for (IPluginImport plugin : base.getImports()) {
                        if (plugin.getId().equals(dependency)) {
                            continue LOOP;
                        }
                    }
                }
                // At this stage dependency is not found, create one
                IPluginImport plugin = factory.createImport();
                plugin.setId(dependency);
                plugin.setName(dependency);
                plugin.setReexported(true);
                base.add(plugin);
            }
        }

    }

    protected void processManifestVersion(IBundlePluginModelBase model) {
        // Locate Bundle
        IBundle bundle = model.getBundleModel().getBundle();
        // Locate Version
        String pluginVersion = bundle.getHeader(Constants.BUNDLE_VERSION);
        // Process Version
        if (pluginVersion == null) {
            pluginVersion = "0.1.0.qualifier"; //$NON-NLS-1$
        } else {
            Version version = Version.parseVersion(pluginVersion);
            String major = version.getMajor() != 0 ? Integer.toString(version.getMajor()) : "0"; //$NON-NLS-1$
            String minor = version.getMinor() != 0 ? Integer.toString(version.getMinor()) : "1"; //$NON-NLS-1$
            String micro = version.getMicro() != 0 ? Integer.toString(version.getMicro()) : "0"; //$NON-NLS-1$      
            String qualifier = version.getQualifier() != null && version.getQualifier().trim().length() != 0 ? version.getQualifier() : "qualifier"; //$NON-NLS-1$
            pluginVersion = major + "." + minor + "." + micro + "." + qualifier; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        bundle.setHeader(Constants.BUNDLE_VERSION, pluginVersion);
    }

    public void setInitialSourceFolders(String[] initialSourceFolders) {
        this.initialSourceFolders = initialSourceFolders;
    }

    public void setInitialDependencies(String[] initialDependencies) {
        this.initialDependencies = initialDependencies;
    }

}
