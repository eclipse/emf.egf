/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.releng2;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.ui.internal.wizards.datatransfer.ZipFileExporter;

/**
 * @author Matthieu Helleboid
 * 
 */
@SuppressWarnings("all")
public class PublishExamplesTask implements ITaskProduction {
    
    private final class ProjectVisitor implements IResourceVisitor {
        private final ArrayList<IFile> resourceList;

        private ProjectVisitor(ArrayList<IFile> resourceList) {
            this.resourceList = resourceList;
        }

        public boolean visit(IResource resource) {
            if (".svn".equals(resource.getName())) //$NON-NLS-1$
                return false;
            
            if (resource.getType() == IResource.FILE)
                resourceList.add((IFile) resource);
            
            return true;
        }
    }

    private static final String FEATURE_XML = "feature.xml";//$NON-NLS-1$
    private static final String OUTPUT_FOLDER = "outputFolder";//$NON-NLS-1$
    private static final String FEATURE_NAME = "featureName";//$NON-NLS-1$

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

    public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
        String featureName = System.getProperty(FEATURE_NAME);
        String outputFolder = System.getProperty(OUTPUT_FOLDER);
        System.out.println("Will export plugins of feature " + featureName + " to folder " + outputFolder); //$NON-NLS-1$ //$NON-NLS-2$
        publishFeature(featureName, outputFolder);
    }

    protected void publishFeature(String featureName, String outputFolder) {
        new File(outputFolder).mkdirs();
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject featureProject = workspaceRoot.getProject(featureName);
        IFile featureFile = featureProject.getFile(FEATURE_XML);
        WorkspaceFeatureModel featureModel = new WorkspaceFeatureModel(featureFile);
        featureModel.load();
        
        ArrayList<IProject> projects = new ArrayList<IProject>();
        for (IFeaturePlugin featurePlugin : featureModel.getFeature().getPlugins()) {
            IProject pluginProject = workspaceRoot.getProject(featurePlugin.getId());
            projects.add(pluginProject);
        }
        
        for (IProject project : projects) {
            ArrayList<IProject> oneProjectList = new ArrayList<IProject>();
            oneProjectList.add(project);
            zipProjects(oneProjectList, featureFile, project.getName() + " zip", outputFolder + "/" + project.getName() + ".zip");
        }
        if (projects.size() > 1)
            zipProjects(projects, featureFile, "complete examples zip", outputFolder + "/all.zip");
    }

    private void zipProjects(ArrayList<IProject> projects, IFile featureFile, String zipDisplayName, String zipName) {
        ZipFileExporter fileExporter = null;
        try {
            fileExporter = new ZipFileExporter(zipName, true);
            final ArrayList<IFile> resourceList = new ArrayList<IFile>();
            for (IProject project : projects) 
                project.accept(new ProjectVisitor(resourceList));
            for (IFile resource : resourceList)
                fileExporter.write(resource, resource.getFullPath().toString().substring(1));
            fileExporter.finished();
            System.out.println(zipDisplayName + " published"); //$NON-NLS-1$
        } catch (Exception e) {
            try {
                // at least one zipentry to close it
                fileExporter.write(featureFile, FEATURE_XML);
                fileExporter.finished();
            } catch (Exception e2) {
            }
            new File(zipName).delete();
            new RuntimeException("Cannot publish " + zipDisplayName, e).printStackTrace(); //$NON-NLS-1$
        }
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

}
