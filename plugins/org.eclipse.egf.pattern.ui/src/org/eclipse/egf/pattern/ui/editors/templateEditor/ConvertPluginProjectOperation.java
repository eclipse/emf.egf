/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * PanPan Liu, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.templateEditor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.helper.EclipseBuilderHelper;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.CPListElement;
import org.eclipse.pde.core.IModel;
import org.eclipse.pde.core.IModelChangeProvider;
import org.eclipse.pde.core.IModelChangedEvent;
import org.eclipse.pde.core.ModelChangedEvent;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.ibundle.IManifestHeader;
import org.eclipse.pde.internal.core.plugin.WorkspaceExtensionsModel;
import org.eclipse.pde.internal.core.text.bundle.BundleSymbolicNameHeader;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;
import org.osgi.framework.Constants;

/**
 * @author PanPan.Liu
 */
public class ConvertPluginProjectOperation extends ConvertProjectOperation {

  public static final String JET_NATURE_ID = "org.eclipse.jet.jet2Nature";

  private static final String PLUGIN_ID = "org.eclipse.jet";
  private static final String EXTENSION_NAME = "transform";
  private static final String EXTENSION_POINT_ID = PLUGIN_ID + "." + EXTENSION_NAME;

  private int K_SOURCE = 1;

  private boolean _hasJetNature;

  private IProject _project;

  private IPlatformBundle platformBundle;

  public ConvertPluginProjectOperation(IProject project, IPlatformBundle platformBundle) {
    super(project, false, false);
    this._project = project;
    this.platformBundle = platformBundle;
  }

  @Override
  public List<String> addDependencies() {
    return super.addDependencies();
  }

  @Override
  public List<String> addSourceFolders() {
    return super.addSourceFolders();
  }

  @Override
  public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {

    IPluginBase pluginBase = platformBundle.getPluginBase();
    IPluginImport[] imports = pluginBase.getImports();
    IPluginLibrary[] libraries = pluginBase.getLibraries();
    IProject project = platformBundle.getProject();

    // Copy the original manifest, see manageManifestFile
    IFile pluginFile = project.getFile(PDEModelUtility.F_MANIFEST_FP);
    IFile plugin = _project.getFile(PDEModelUtility.F_MANIFEST_FP);
    if (plugin.exists() == false) {
      if (pluginFile.exists()) {
        IFolder folder = _project.getFolder(EGFCommonConstants.BUNDLE_FILENAME_DIRECTORY_DESCRIPTOR);
        if (folder == null) {
          throw new IllegalStateException();
        }
        if (folder.exists() == false) {
          folder.create(true, true, monitor);
        }
        pluginFile.copy(plugin.getFullPath(), true, monitor);
      }
    }

    super.execute(monitor);

    _hasJetNature = false;
    IProjectDescription description = _project.getDescription();
    String[] natureIds = description.getNatureIds();
    for (String natureID : natureIds) {
      if (natureID.equals(JET_NATURE_ID)) {
        _hasJetNature = true;
      }
    }

    if (_hasJetNature == false) {
      EclipseBuilderHelper.addNature(description, JET_NATURE_ID, monitor);
      _project.setDescription(description, monitor);
    }

    addLinkedSource(project, _project, monitor);
  }

  protected void fireStructureChanged(IPluginObject child, WorkspaceExtensionsModel workspaceExtensionModel, int changeType) {
    IModel model = workspaceExtensionModel;
    if (model.isEditable() && model instanceof IModelChangeProvider) {
      IModelChangedEvent e = new ModelChangedEvent((IModelChangeProvider) model, changeType, new Object[] { child }, null);
      if (model.isEditable() && model instanceof IModelChangeProvider) {
        IModelChangeProvider provider = (IModelChangeProvider) model;
        provider.fireModelChanged(e);
      }
    }
  }

  @Override
  protected void manageManifestFile(IBundlePluginModelBase model) throws CoreException {
    IBundle bundle = model.getBundleModel().getBundle();
    // Patch copied manifest
    String pluginId = getValidId(_project.getName());
    String pluginName = createInitialName(pluginId);
    // Bundle Name
    bundle.setHeader(Constants.BUNDLE_NAME, pluginName);
    // Bundle Symbolic Name
    IManifestHeader header = bundle.getManifestHeader(Constants.BUNDLE_SYMBOLICNAME);
    if (header != null && header instanceof BundleSymbolicNameHeader) {
      BundleSymbolicNameHeader symbolic = (BundleSymbolicNameHeader) header;
      if (symbolic.getId() == null || symbolic.getId().trim().length() == 0) {
        symbolic.setId(pluginId);
      }
      if (symbolic.isSingleton() == false) {
        symbolic.setSingleton(true);
      }
    } else {
      bundle.setHeader(Constants.BUNDLE_SYMBOLICNAME, pluginId + ";singleton:=true"); //$NON-NLS-1$
    }
  }

  private void addLinkedSource(IProject userProject, IProject tempProject, IProgressMonitor monitor) throws CoreException {
    List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
    IJavaProject userJavaProject = JavaCore.create(userProject);
    IJavaProject tempJavaProject = JavaCore.create(tempProject);
    try {
      IPackageFragmentRoot[] allPackageFragmentRoots = userJavaProject.getAllPackageFragmentRoots();

      CPListElement[] existing = CPListElement.createFromExisting(tempJavaProject);
      List<CPListElement> cpListElements = new ArrayList<CPListElement>();
      for (CPListElement elment : existing) {
        cpListElements.add(elment);
      }

      if (allPackageFragmentRoots != null && allPackageFragmentRoots.length > 0) {
        for (IPackageFragmentRoot packageFragmentRoot : allPackageFragmentRoots) {
          int kind = packageFragmentRoot.getKind();
          if (kind == K_SOURCE) {

            IClasspathEntry rawClasspathEntry = packageFragmentRoot.getRawClasspathEntry();
            IPath fullPath = packageFragmentRoot.getResource().getLocation();
            IPath path = rawClasspathEntry.getPath();
            IPath removeLastSegments = path.removeLastSegments(path.segmentCount() - 1);
            IPath pathFolder = path.removeFirstSegments(path.segmentCount() - 1);
            pathFolder = createFolder(fullPath, pathFolder.toString(), tempProject, monitor);

            CPListElement newEntrie = new CPListElement(tempJavaProject, IClasspathEntry.CPE_SOURCE);
            newEntrie.setLinkTarget(fullPath);
            newEntrie.setPath(pathFolder);
            newEntrie.setExported(true);

            cpListElements.add(newEntrie);
          }
        }
      }
      BuildPathsBlock.flush(cpListElements, tempJavaProject.getOutputLocation(), tempJavaProject, null, monitor);
    } finally {
      userJavaProject.close();
      tempJavaProject.close();
    }
  }

  private IPath createFolder(IPath path, String fName, IProject tempProject, IProgressMonitor monitor) throws CoreException {
    String folderName = fName;
    IFolder tempFolder = tempProject.getFolder(folderName);
    IPath fullPath = tempFolder.getFullPath();
    if (tempFolder.exists()) {
      folderName = "temp" + folderName;
      fullPath = createFolder(path, folderName, tempProject, monitor);
    }
    return fullPath;
  }

}
