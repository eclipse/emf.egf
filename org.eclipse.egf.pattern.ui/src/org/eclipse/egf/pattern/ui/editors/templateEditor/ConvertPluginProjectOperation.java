/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      PanPan Liu, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.templateEditor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.helper.EclipseBuilderHelper;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.bundle.BundlePluginModel;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundleModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.osgi.framework.Constants;

/**
 * @author PanPan.Liu
 */
public class ConvertPluginProjectOperation extends ConvertProjectOperation {
    
    public static final String F_MANIFEST = "MANIFEST.MF"; 
    public static final String MANIFEST_FOLDER_NAME = "META-INF/"; 
    public static final String F_MANIFEST_FP = MANIFEST_FOLDER_NAME + F_MANIFEST; 
    public static final String JET_NATURE_ID = "org.eclipse.jet.jet2Nature";
    public static final String F_PLUGIN = "plugin.xml"; 
    public static final String F_PROPERTIES = ".properties"; 
    public static final String F_BUILD = "build" + F_PROPERTIES; 
    
    private boolean _hasJetNature;
    
    private IProject _project;
    
    private IPlatformBundle platformBundle; 

    public ConvertPluginProjectOperation(IProject project,IPlatformBundle platformBundle) {
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
        super.execute(monitor);
        
        _hasJetNature = false;
        IProjectDescription description = _project.getDescription();
        String[] natureIds = description.getNatureIds();
        for(String natureID:natureIds){
            if(natureID.equals(JET_NATURE_ID)){
                _hasJetNature = true;
            }
        }
        
        if (_hasJetNature == false) {
            EclipseBuilderHelper.addNature(description,JET_NATURE_ID , monitor);
        }
        _project.setDescription(description, monitor);
        
        
        IPluginBase pluginBase = platformBundle.getPluginBase();
        IPluginExtensionPoint[] extensionPoints = pluginBase.getExtensionPoints();
        IPluginExtension[] extensions = pluginBase.getExtensions();
        IPluginImport[] imports = pluginBase.getImports();
        IPluginLibrary[] libraries = pluginBase.getLibraries();
        IProject project = platformBundle.getProject();
        IFile pluginFile = project.getFile(F_PLUGIN);
        
        IPluginModelBase model = PluginRegistry.findModel(_project);
        if(model instanceof BundlePluginModel){
            BundlePluginModel bundlePluginModel = (BundlePluginModel)model;
            WorkspaceBundleModel workspaceBundleModel = (WorkspaceBundleModel) bundlePluginModel.getBundleModel();
            workspaceBundleModel.setEditable(true);
            IBundle bundle = workspaceBundleModel.getBundle();
            IPluginBase templatePluginBase = model.getPluginBase(true);
            updateManifest(bundle);
            for(IPluginExtensionPoint extensionPoint:extensionPoints){
                templatePluginBase.add(extensionPoint);
            }
            for(IPluginExtension extension:extensions){
                templatePluginBase.add(extension);
            }
            for(IPluginImport pluginImport:imports){
                templatePluginBase.add(pluginImport);
            }
            for(IPluginLibrary librarie:libraries){
                templatePluginBase.add(librarie);
            }
            IFile plugin = _project.getFile(ConvertPluginProjectOperation.F_PLUGIN);
            if(!plugin.exists()){
                if(pluginFile.exists()){
                    pluginFile.copy(plugin.getFullPath(), true, monitor);
                }
            }
            workspaceBundleModel.save();
            workspaceBundleModel.setEditable(false);
        }
    }
    
    private void updateManifest(IBundle bundle){
        String pluginId = bundle.getHeader(Constants.BUNDLE_SYMBOLICNAME);
        String projectName = _project.getName();
        if(projectName.startsWith(".")){
            projectName = projectName.substring(1, projectName.length()-1);
        }

        bundle.setHeader(Constants.BUNDLE_SYMBOLICNAME, projectName+";singleton:=true");
    }
}
