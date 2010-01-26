/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ui.editors.templateEditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.util.CoreUtility;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathsBlock;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModelFactory;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.core.bundle.BundlePluginBase;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginBase;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.pde.internal.core.natures.PluginProject;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.osgi.framework.Constants;
/**
 * @author Yahong Song - Soyatec
 * 
 */
public class TemplateEditorUtility {
    /**
     * @param startPositions2
     * @return current method's contents start lines in the dummy whole
     *         contents.
     */
    public static int getStartPosition(Map<String, Position> startPositions) {
        int startOffset = 0;
        if (startPositions == null || startPositions.size() == 0) {
            return startOffset;
        } else {
            Collection<Position> starts = (Collection<Position>) startPositions.values();
            Iterator<Position> e = starts.iterator();
            while (e.hasNext()) {
                Position position = e.next();
                startOffset = startOffset + position.length + 1;
            }
        }
        return startOffset;
    }

    public static int getSourceLength(InputStream inputstream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));
        int length = 0;
        while (br.read() != -1) {
            ++length;
        }
        br.close();
        return length;
    }

    /**
     * Get the words which will be used in code completion.
     */
    public static String[] getAllWords(ITextViewer viewer, int offset) {
        IDocument doc = viewer.getDocument();
        DocumentReader reader = new DocumentReader(doc, offset);
        char c = reader.readBackward();

        ArrayList<String> all = new ArrayList<String>(20);
        char currChar = c;
        currChar = trimBlanksBackward(reader, currChar);
        for (boolean done = false; !done;) {
            Stack stack = new Stack();
            for (; currChar != '\uFFFF' && !Character.isWhitespace(currChar); currChar = reader.readBackward())
                stack.push(new Character(currChar));

            String s;
            for (s = new String(); !stack.empty(); s = (new StringBuilder(String.valueOf(s))).append(((Character) stack.pop()).toString()).toString())
                ;
            int jePt = s.indexOf("<%=");
            if (jePt >= 0) {
                s = s.substring(jePt + 3);
                done = true;
            } else {
                int jspPt = s.indexOf("<%");
                if (jspPt >= 0) {
                    s = s.substring(jspPt + 2);
                    done = true;
                }
            }
            all.add(s);
            currChar = trimBlanksBackward(reader, currChar);
            if (currChar == '\uFFFF' || currChar == '@')
                done = true;
        }

        return (String[]) all.toArray(new String[all.size()]);
    }

    public static char trimBlanksBackward(DocumentReader reader, char currChar) {
        for (; currChar != '\uFFFF' && Character.isWhitespace(currChar); currChar = reader.readBackward())
            ;
        return currChar;
    }
    
    public static IPluginModelBase getPluginModelBase(IProject project) {
        return PluginRegistry.findModel(project);
    }

    public static IPluginBase getPluginBase(IProject project) {
        IPluginModelBase model = getPluginModelBase(project);
        if (model != null) {
            return model.getPluginBase(true);
        }
        return null;
    }
    
    public static PluginProject createPluginProject(String name, IProgressMonitor monitor) throws CoreException{
        
        PluginProject pluginProject = null;
        
        // create project
        IJavaProject javaProject = createJavaProject(name,monitor);
        IProject project = javaProject.getProject();
        
        if (!project.hasNature(PDE.PLUGIN_NATURE)){
            IProjectDescription description = project.getDescription();
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 1];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            newNatures[prevNatures.length] = PDE.PLUGIN_NATURE;
            description.setNatureIds(newNatures);
            project.setDescription(description, monitor);
        }
        
        //createManifest
        WorkspacePluginModelBase fModel;
        fModel = new WorkspaceBundlePluginModel(project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR), project.getFile(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR));
        IPluginBase pluginBase = fModel.getPluginBase();
        String targetVersion = "3.5";
        pluginBase.setSchemaVersion(TargetPlatformHelper.getSchemaVersionForTargetVersion(targetVersion));
        pluginBase.setId(name);
        pluginBase.setVersion(targetVersion);
        pluginBase.setName(name);
        pluginBase.setProviderName("");
        if (fModel instanceof IBundlePluginModelBase) {
            IBundlePluginModelBase bmodel = ((IBundlePluginModelBase) fModel);
            ((IBundlePluginBase) bmodel.getPluginBase()).setTargetVersion(targetVersion);
            bmodel.getBundleModel().getBundle().setHeader(Constants.BUNDLE_MANIFESTVERSION, "2"); //$NON-NLS-1$
        }
        ((IPlugin) pluginBase).setClassName(name+".Activator");
        IBundle bundle = ((BundlePluginBase) pluginBase).getBundle();
//        String exeEnvironment = ((AbstractFieldData) fData).getExecutionEnvironment();
//        bundle.setHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, exeEnvironment);
        double version = Double.parseDouble(targetVersion);
        if (version >= 3.4) {
            bundle.setHeader(Constants.BUNDLE_ACTIVATIONPOLICY, Constants.ACTIVATION_LAZY);
        } else {
            bundle.setHeader(ICoreConstants.ECLIPSE_LAZYSTART, "true"); //$NON-NLS-1$
        }
        
        //createBuildProperties
        IFile file = project.getFile(ICoreConstants.BUILD_FILENAME_DESCRIPTOR);
        if (!file.exists()) {
            WorkspaceBuildModel model = new WorkspaceBuildModel(file);
            IBuildModelFactory factory = model.getFactory();

            // BIN.INCLUDES
            IBuildEntry binEntry = factory.createEntry(IBuildEntry.BIN_INCLUDES);
            binEntry.addToken("META-INF/");
            binEntry.addToken(".");
            model.getBuild().add(binEntry);
            model.save();
        }
        fModel.save();
        pluginProject = new PluginProject();
        pluginProject.setProject(project);    
        return pluginProject;
    }
    
    public static IJavaProject createJavaProject(String name, IProgressMonitor monitor) {
        IJavaProject javaProject = null;
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        URI locationURI = project.getLocationURI();
        try {
            BuildPathsBlock.createProject(project, locationURI, monitor);
            
            // Nature
            BuildPathsBlock.addJavaNature(project, monitor);

            // Classpath
            List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
            
            // 1. src
            IPath sourceFolderPath = new Path(name).makeAbsolute();
            IPath srcPath = new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_SRCNAME));
            if (srcPath.segmentCount() > 0) {
                sourceFolderPath = sourceFolderPath.append(srcPath);
            }
            IClasspathEntry srcEntry = JavaCore.newSourceEntry(sourceFolderPath);
            srcPath = srcEntry.getPath();
            if (srcPath.segmentCount() > 1) {
                IFolder folder = root.getFolder(srcPath);
                CoreUtility.createFolder(folder, true, true, new SubProgressMonitor(monitor, 1));
            }
            cpEntries.add(srcEntry);

            // 2. jre
            IClasspathEntry[] jreEntry = PreferenceConstants.getDefaultJRELibrary();
            for (IClasspathEntry entry : jreEntry) {
                cpEntries.add(entry);
            }
            
            IClasspathEntry newContainerEntry = JavaCore.newContainerEntry(PDECore.REQUIRED_PLUGINS_CONTAINER_PATH);
            cpEntries.add(newContainerEntry);

            //3. output
            IPath outputLocationPath = new Path(name).makeAbsolute();
            IPath binPath = new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_BINNAME));
            if (binPath.segmentCount() > 0) {
                outputLocationPath = outputLocationPath.append(binPath);
                IFolder folder = root.getFolder(outputLocationPath);
                CoreUtility.createFolder(folder, true, true, new SubProgressMonitor(monitor, 1));
            }

            javaProject = JavaCore.create(project);
            javaProject.setRawClasspath(cpEntries.toArray(new IClasspathEntry[cpEntries.size()]), outputLocationPath, monitor);
          
        } catch (CoreException e) {
            Activator.getDefault().logError(e);
        } finally {
            if (monitor != null) {
                monitor.done();
            }
        }
        return javaProject;
    }
}
