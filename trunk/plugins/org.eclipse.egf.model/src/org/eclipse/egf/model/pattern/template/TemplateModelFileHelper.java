/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.model.pattern.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.pattern.PatternFolders;
import org.eclipse.egf.model.l10n.EGFModelMessages;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 */
public class TemplateModelFileHelper {

    public static String PATTERN_UNIT_FILE_EXTENSION = "pt"; //$NON-NLS-1$

    private static final String PATTERN_TOKEN = "pattern."; //$NON-NLS-1$

    private static final String METHOD_TOKEN = "method."; //$NON-NLS-1$

    public static class FilenameFormatException extends Exception {

        private static final long serialVersionUID = 1L;

        private FilenameFormatException(String message) {
            super(message);
        }

    }

    private TemplateModelFileHelper() {
        // Prevent Instantiation
    }

    public static URI computeFileURI(IPlatformFcore fcore, PatternMethod method) {
        if (fcore == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error20);
        }
        if (method == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error4);
        }
        if (method.getID() == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error6);
        }
        if (method.getPattern() == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error7);
        }
        if (method.getPattern().getID() == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error8);
        }
        URI relativeURI = URI.createURI(PatternFolders.getTemplatesFolderName() + EGFCommonConstants.SLASH_CHARACTER + PATTERN_TOKEN + method.getPattern().getID() + EGFCommonConstants.SLASH_CHARACTER + METHOD_TOKEN + method.getID() + EGFCommonConstants.DOT_CHARACTER
                + PATTERN_UNIT_FILE_EXTENSION);
        return URI.createURI(fcore.getPlatformBundle().getRootedBase().toString() + relativeURI.toString());
    }

    public static String extractPatternId(IPath patternMethodPath) throws FilenameFormatException {
        if (patternMethodPath == null) {
            throw new FilenameFormatException(EGFModelMessages.PatternFilename_error1);
        }
        int segmentCount = patternMethodPath.segmentCount();
        if (segmentCount < 3) {
            throw new FilenameFormatException(NLS.bind(EGFModelMessages.PatternFilename_error2, patternMethodPath));
        }
        String segment = patternMethodPath.segment(segmentCount - 2);
        if (segment == null || "".equals(segment) || !segment.startsWith(PATTERN_TOKEN) || PATTERN_TOKEN.length() == segment.length()) { //$NON-NLS-1$
            throw new FilenameFormatException(NLS.bind(EGFModelMessages.PatternFilename_error3, segment, PATTERN_TOKEN));
        }
        return segment.substring(PATTERN_TOKEN.length());
    }

    public static String extractPatternMethodId(IPath patternMethodPath) throws FilenameFormatException {
        if (patternMethodPath == null) {
            throw new FilenameFormatException(EGFModelMessages.PatternFilename_error1);
        }
        int segmentCount = patternMethodPath.segmentCount();
        if (segmentCount < 3) {
            throw new FilenameFormatException(NLS.bind(EGFModelMessages.PatternFilename_error2, patternMethodPath));
        }
        String segment = patternMethodPath.removeFileExtension().lastSegment();
        if (segment == null || "".equals(segment) || !segment.startsWith(METHOD_TOKEN) || METHOD_TOKEN.length() == segment.length()) { //$NON-NLS-1$
            throw new FilenameFormatException(NLS.bind(EGFModelMessages.PatternFilename_error4, segment, METHOD_TOKEN));
        }
        return segment.substring(METHOD_TOKEN.length());
    }

    /**
     * get an input stream from a plugin who lives in the workspace or RT.
     */
    public static URI getTemplateURI(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error3);
        }
        if (uri.isRelative()) {
            throw new IllegalArgumentException(NLS.bind(EGFModelMessages.fileHelper_error5, uri.toString()));
        }
        return uri;

    }

    /**
     * get an input stream from a plugin who lives in the workspace or RT.
     */
    public static URI getTemplateURI(PatternMethod method) {
        if (method == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error4);
        }
        return getTemplateURI(method.getPatternFilePath());
    }

    /**
     * get an input stream from a plugin who lives in the workspace or RT.
     */
    public static InputStream getInputStream(PatternMethod method) throws IOException {
        if (method == null) {
            throw new IllegalArgumentException(EGFModelMessages.fileHelper_error4);
        }
        return EGFCorePlugin.getTargetPlatformURIConverter().createInputStream(getTemplateURI(method));

    }

    public static void restoreTemplates(IProgressMonitor monitor, IPlatformFcore fcore, List<PatternMethod> methods) throws CoreException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, methods != null ? 200 * methods.size() : 200);
        subMonitor.beginTask(null, methods != null ? 200 * methods.size() : 200);
        // Nothing to do
        if (fcore == null || methods == null || methods.isEmpty()) {
            subMonitor.worked(200);
            return;
        }
        IProject project = fcore.getPlatformBundle().getProject();
        if (project == null) {
            subMonitor.worked(200);
            return;
        }
        // Restore pt files
        for (PatternMethod method : methods) {
            if (method.getPatternFilePath() == null) {
                subMonitor.worked(200);
                continue;
            }
            IFile file = project.getFile(URIHelper.toPlatformProjectString(method.getPatternFilePath(), true));
            if (file.exists() == false) {
                IFileState[] states = file.getHistory(monitor);
                if (states != null && states.length > 0) {
                    for (IFileState state : states) {
                        if (state.exists() == false) {
                            continue;
                        }
                        FileHelper.createContainers(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), file);
                        file.create(state.getContents(), false, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
                        break;
                    }
                }
            }
            subMonitor.worked(200);
        }
    }

    public static void removeTemplates(IProgressMonitor monitor, List<PatternMethod> methods) throws CoreException {
        SubMonitor subMonitor = SubMonitor.convert(monitor, methods != null ? 100 * methods.size() : 100);
        subMonitor.beginTask(null, methods != null ? 100 * methods.size() : 100);
        // Nothing to do
        if (methods == null || methods.isEmpty()) {
            subMonitor.worked(100);
            return;
        }
        // Remove pt files
        for (PatternMethod method : methods) {
            if (method.getPatternFilePath() == null) {
                subMonitor.worked(100);
                continue;
            }
            // Remove pt file
            IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(method.getPatternFilePath().toPlatformString(true));
            if (resource != null) {
                FileHelper.deleteResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), resource, true);
            } else {
                subMonitor.worked(100);
            }
        }
    }

}
