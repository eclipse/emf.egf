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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.text.java.JavaMethodCompletionProposal;
import org.eclipse.jdt.internal.ui.text.java.ParameterGuessingProposal;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class TemplateEditorUtility {

    private static final String EMF_CODEGEN_JET_NATURE_ID = "org.eclipse.emf.codegen.jet.IJETNature"; //$NON-NLS-1$

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

    public static IClasspathEntry[] getNewIClasspathEntry(IClasspathEntry[] entries, IClasspathEntry[] jreEntry) {
        if (entries != null && jreEntry != null) {
            IClasspathEntry[] newEntries = new IClasspathEntry[entries.length + jreEntry.length];
            System.arraycopy(entries, 0, newEntries, 0, entries.length);
            System.arraycopy(jreEntry, 0, newEntries, entries.length, jreEntry.length);
            return newEntries;
        }
        return null;
    }

    public static void createFolder(IFolder folder, boolean force, boolean local, IProgressMonitor monitor) throws CoreException {
        if (!folder.exists()) {
            IContainer parent = folder.getParent();
            if (parent instanceof IFolder) {
                createFolder((IFolder) parent, force, local, null);
            }
            folder.create(force, local, monitor);
        }
    }

    public static IJavaProject createJavaProject(String name, IProgressMonitor monitor) {
        IJavaProject javaProject = null;
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        URI locationURI = project.getLocationURI();
        try {
            if (monitor == null) {
                monitor = new NullProgressMonitor();
            }
            monitor.beginTask("Creating project...", 10);

            // create the project
            try {
                if (!project.exists()) {
                    IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
                    if (locationURI != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(locationURI)) {
                        locationURI = null;
                    }
                    desc.setLocationURI(locationURI);
                    setProjectNature(desc);
                    project.create(desc, monitor);
                    monitor = null;
                }
                if (!project.isOpen()) {
                    project.open(monitor);
                    monitor = null;
                }
            } finally {
                if (monitor != null) {
                    monitor.done();
                }
            }

            // Nature
            if (monitor != null && monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            if (!project.hasNature(JavaCore.NATURE_ID)) {
                IProjectDescription description = project.getDescription();
                String[] prevNatures = description.getNatureIds();
                String[] newNatures = new String[prevNatures.length + 1];
                System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
                newNatures[prevNatures.length] = JavaCore.NATURE_ID;
                description.setNatureIds(newNatures);
                project.setDescription(description, monitor);
            } else {
                if (monitor != null) {
                    monitor.worked(1);
                }
            }

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
                createFolder(folder, true, true, monitor);
            }
            cpEntries.add(srcEntry);

            // 2. jre
            IClasspathEntry[] jreEntry = PreferenceConstants.getDefaultJRELibrary();
            for (IClasspathEntry entry : jreEntry) {
                cpEntries.add(entry);
            }

            // 3. output
            IPath outputLocationPath = new Path(name).makeAbsolute();
            IPath binPath = new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_BINNAME));
            if (binPath.segmentCount() > 0) {
                outputLocationPath = outputLocationPath.append(binPath);
                IFolder folder = root.getFolder(outputLocationPath);
                createFolder(folder, true, true, monitor);
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

    public static ICompletionProposal[] filterJavaMethodProposals(ICompletionProposal[] javaProposals) {
        if (javaProposals == null) {
            return null;
        }
        List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
        for (ICompletionProposal javaProposal : javaProposals) {
            if (javaProposal instanceof ParameterGuessingProposal || !(javaProposal instanceof JavaMethodCompletionProposal)) {
                proposals.add(javaProposal);
            }
        }
        return (ICompletionProposal[]) proposals.toArray(new IJavaCompletionProposal[proposals.size()]);
    }

    private static void setProjectNature(IProjectDescription desc) {
        String[] natureIds = new String[1];
        natureIds[0] = EMF_CODEGEN_JET_NATURE_ID;
        desc.setNatureIds(natureIds);
    }
}
