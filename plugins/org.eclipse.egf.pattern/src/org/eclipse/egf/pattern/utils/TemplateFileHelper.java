/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.model.l10n.EGFModelMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 *
 */
public class TemplateFileHelper {

    private TemplateFileHelper() {
        // Prevent Instantiation
    }

    public static void setContent(IFile file, String source) throws CoreException {
        setContent(file, source, true);
    }

    public static void setContent(IFile file, String source, boolean keepHistory) throws CoreException {
        setContent(file, new ByteArrayInputStream(source.getBytes()), keepHistory);
    }

    public static void setContent(IFile file, InputStream source, boolean keepHistory) throws CoreException {
        if (file.exists()) {
            file.setContents(source, true, keepHistory, null);
        } else {
            createParentfolders(file.getProject(), file.getProjectRelativePath().removeLastSegments(1));
            file.create(source, true, null);
        }
    }

    public static void createParentfolders(IProject project, IPath folderPath) throws CoreException {
        if (folderPath.isEmpty()) {
            return;
        }
        IFolder folder = project.getFolder(folderPath);
        if (folder == null) {
            throw new IllegalStateException();
        }
        if (!folder.exists()) {
            createParentfolders(project, folderPath.removeLastSegments(1));
            folder.create(true, true, null);
        }
    }

    /**
     * This method tries to read a file from the project and then from the
     * plugins.
     */
    public static String getContent(String pluginId, IProject project, IPath templatePath) throws CoreException, IOException {
        IFile file = project.getFile(templatePath);
        if (file == null) {
            throw new IllegalStateException();
        }
        if (file.exists()) {
            return getFileContent(file);
        }
        URI uri = URIHelper.getPlatformPluginURI(pluginId, templatePath.toPortableString(), false);
        return getContent(EGFPlatformPlugin.getPlatformURIConverter().createInputStream(uri));
    }

    /**
     * Reads a file from a plugin who lives in the workspace or RT. If the file
     * doesn't exist an empty string is returned.
     */
    public static String getContent(PatternMethod method) throws IOException {
        if (method == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error4);
        }
        return getContent(TemplateModelFileHelper.getInputStream(method));

    }

    public static String getFileContent(IFile file) throws CoreException, IOException {
        return getContent(file.getContents());
    }

    private static String getContent(InputStream contents) throws IOException {
        byte[] buf = null;
        try {
            buf = new byte[contents.available()];
            contents.read(buf);
        } finally {
            if (contents != null) {
                contents.close();
            }
        }
        return new String(buf);
    }

    public static void touchHeaderTemplates(IProgressMonitor monitor, IPlatformFcore fcore, List<Pattern> patterns) throws CoreException {
        // Nothing to do
        if (fcore == null || patterns == null || patterns.isEmpty()) {
            return;
        }
        IProject project = fcore.getPlatformBundle().getProject();
        if (project == null) {
            return;
        }
        SubMonitor subMonitor = SubMonitor.convert(monitor, 100 * patterns.size());
        subMonitor.beginTask(null, 100 * patterns.size());
        for (Pattern pattern : patterns) {
            // Touch header method
            IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(pattern.getHeaderMethod().getPatternFilePath().toPlatformString(true));
            if (resource != null) {
                resource.touch(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
            }
            subMonitor.worked(100);
        }
    }

}
