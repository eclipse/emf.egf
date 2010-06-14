/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * @author fournier
 */
public class FileHelper {

    private FileHelper() {
        // Prevent Instantiation
    }

    /**
     * Get file full url from relative one.
     * 
     * @param fileRelativePath
     *            File path relative to workspace.<br>
     *            It <b>must</b> start with <i>pluginId</i>. It is also recommended
     *            that both plug-in id and plug-in project names are the same.<br>
     *            As a convenience, the full path will refer to the plug-in id.<br>
     *            <b>Example</b> :
     *            <i>com.thalesgroup.mde.mdsofa/model/example.ecore</i> is a path
     *            relative to the workspace that refers to the
     *            <i>com.thalesgroup.mde.mdsofa plug-in</i>, having a
     *            <i>model/example.ecore</i> file in its project.<br>
     *            In Eclipse resource system, such a path is considered as an
     *            absolute one against the workspace root.<br>
     *            It's still referred to as a relative path, since the returned URL
     *            is absolute in the file system.
     * @return URL
     */
    public static URL getFileFullUrl(String fileRelativePath) {
        // Get the URI for given relative path.
        return getFileFullUrl(getFileFullUri(fileRelativePath));
    }

    /**
     * Get file full url from its full uri.<br>
     * See {@link #getFileFullUri(String)} method.
     * 
     * @param fileFullUri
     * @return URL
     */
    public static URL getFileFullUrl(URI fileFullUri) {
        URL result = null;
        // Resolve url from returned uri.
        try {
            result = FileLocator.resolve(new URL(fileFullUri.toString()));
        } catch (Exception e) {
            EGFCommonPlugin.getDefault().logError(NLS.bind("FileHelper.getFileFullPath(..) _ Unable to resolve the url for ''{0}''", fileFullUri.toString()), e); //$NON-NLS-1$
        }
        return result;
    }

    /**
     * Get a file uri from relative one which is not resolved against the eclipse
     * platform.<br>
     * The returned uri starts with either 'platform:/plug-in/' or
     * 'platform:/resource/'.
     * 
     * @param fileRelativePath
     *            File path relative to workspace.<br>
     *            It <b>must</b> start with <i>pluginId</i>. It is also recommended
     *            that both plug-in id and plug-in project names are the same.<br>
     *            As a convenience, the full path will refer to the plug-in id.<br>
     *            <b>Example</b> :
     *            <i>com.thalesgroup.mde.mdsofa/model/example.ecore</i> is a path
     *            relative to the workspace that refers to the
     *            <i>com.thalesgroup.mde.mdsofa plug-in</i>, having a
     *            <i>model/example.ecore</i> file in its project.
     * @return an {@link URI} not resolved against the eclipse platform.<br>
     */
    public static URI getFileFullUri(String fileRelativePath) {
        URI fileUri = null;
        // Precondition.
        if (fileRelativePath == null) {
            return fileUri;
        }
        // Find plug-in model base from relative first segment.
        IPath path = new Path(fileRelativePath);
        IPluginModelBase modelBase = PluginRegistry.findModel(path.segment(0));
        // Get underlying resource.
        IResource resource = modelBase != null ? modelBase.getUnderlyingResource() : null;
        if (resource != null) { // Resource found, the file is in the workspace.
            fileUri = URI.createPlatformResourceURI(fileRelativePath, true);
        } else { // Resource not found, the file is deployed elsewhere.
            fileUri = URI.createPlatformPluginURI(fileRelativePath, true);
        }
        return fileUri;
    }

    /**
     * Convert package name to a correct java folder path.
     * 
     * @param packageName
     * @return String
     */
    public static String convertPackageNameToFolderPath(String packageName) {
        return packageName != null ? packageName.replace(EGFCommonConstants.DOT_CHARACTER, EGFCommonConstants.SLASH_CHARACTER) : null;
    }

    /**
     * Read given input stream as an array of bytes.
     * 
     * @param inputStream
     * @return a not null array.
     */
    public static byte[] readFile(InputStream inputStream) {
        byte[] data = null;
        try {
            data = new byte[inputStream.available()];
            inputStream.read(data);
        } catch (Exception e) {
            EGFCommonPlugin.getDefault().logError("FileHelper.readFile(..) _ Failed to read the input stream !", e); //$NON-NLS-1$
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ioe) {
                    EGFCommonPlugin.getDefault().logError("FileHelper.readFile(..) _ Failed to close input stream !", ioe); //$NON-NLS-1$
                }
            }
        }
        // Ensure to return a not null array.
        return (null == data) ? new byte[0] : data;
    }

    /**
     * Read file as a string.
     * 
     * @param filePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return If an error occurred {@link EGFCommonConstants#EMPTY_STRING} is
     *         returned.
     */
    public static String readFile(String filePath) {
        byte[] rawContent = readRawFile(filePath);
        return rawContent.length == 0 ? EGFCommonConstants.EMPTY_STRING : new String(rawContent);
    }

    /**
     * Get file as a stream.
     * 
     * @param filePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return If an error occurred null is returned.
     */
    public static InputStream readFileAsStream(String filePath) {
        InputStream result = null;
        // Get input stream and copy its content to resulting string.
        URL fileURL = getFileFullUrl(filePath);
        try {
            result = fileURL.openStream();
        } catch (Exception e) {
            EGFCommonPlugin.getDefault().logError(NLS.bind("FileHelper.readFileAsStream(..) _ Failed to load ''{0}''", filePath), e); //$NON-NLS-1$
        }
        return result;
    }

    /**
     * Read file as an array of bytes.
     * 
     * @param filePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return a not null array.
     */
    public static byte[] readRawFile(String filePath) {
        byte[] result = null;
        // Get stream from file.
        InputStream inputStream = readFileAsStream(filePath);
        // Ensure the input stream got from the file path is not null.
        if (inputStream != null) {
            result = readFile(inputStream);
        }
        return (null == result) ? new byte[0] : result;
    }

    /**
     * Copy given source file content in given target file.
     * 
     * @param sourceFileRelativePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @param targetFileRelativePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     */
    public static void copyFile(String sourceFileRelativePath, String targetFileRelativePath) {
        writeFile(targetFileRelativePath, true, readRawFile(sourceFileRelativePath));
    }

    /**
     * Write given string contents at specified path.
     * 
     * @param filePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @param ensureFolders
     *            Make sure all parent folders exist by creating all necessary ones.
     * @param contents
     *            Contents that should be written to pointed file.
     * @return boolean
     */
    public static boolean writeFile(String filePath, boolean ensureFolders, String contents) {
        return writeFile(filePath, ensureFolders, contents.getBytes());
    }

    /**
     * Write given contents of bytes at specified path.
     * 
     * @param filePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @param ensureFolders
     *            Make sure all parent folders exist by creating all necessary ones.
     * @param contents
     *            Contents that should be written to pointed file.
     * @return boolean
     */
    public static boolean writeFile(String filePath, boolean ensureFolders, byte[] contents) {
        FileChannel channel = null;
        try {
            // Get file full path from its relative one.
            String fileFullPath = getFileFullUrl(filePath).getFile();
            // Should path be enforced ?
            if (ensureFolders) {
                ensurePathAvailability(fileFullPath);
            }
            // Try and open the resulting file.
            channel = new FileOutputStream(fileFullPath).getChannel();
            // Write contents.
            channel.write(ByteBuffer.wrap(contents));
        } catch (Exception e) {
            EGFCommonPlugin.getDefault().logError(NLS.bind("FileHelper.writeFile(..) _ Failed to open channel in write mode for ''{0}'' !", filePath), e); //$NON-NLS-1$
            return false;
        } finally {
            if (channel != null && channel.isOpen()) {
                try {
                    // Close the channel.
                    channel.close();
                } catch (IOException e) {
                    EGFCommonPlugin.getDefault().logError(NLS.bind("FileHelper.writeFile(..) _ Failed to close opened channel in write mode ! ''{0}'' may no longer be usable.", filePath), e); //$NON-NLS-1$
                }
            }
        }
        return true;
    }

    /**
     * Rename file from source file relative path to destination relative path.
     * 
     * @param sourceFileRelativePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @param destinationFileRelativePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return boolean
     */
    public static boolean renameFile(String sourceFileRelativePath, String destinationFileRelativePath) {
        // Preconditions.
        if (sourceFileRelativePath == null || destinationFileRelativePath == null) {
            return false;
        }
        IFile sourceFile = getPlatformFile(sourceFileRelativePath);
        IPath destinationPath = getPlatformFile(destinationFileRelativePath).getFullPath();
        return moveResource(sourceFile, destinationPath);
    }

    /**
     * Rename folder from source folder relative path to destination relative
     * path.
     * 
     * @param sourceFolderRelativePath
     *            Folder path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @param destinationFolderRelativePath
     *            Folder path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return boolean
     */
    public static boolean renameFolder(String sourceFolderRelativePath, String destinationFolderRelativePath) {
        // Preconditions.
        if (sourceFolderRelativePath == null || destinationFolderRelativePath == null) {
            return false;
        }
        IFolder sourceFolder = getPlatformFolder(sourceFolderRelativePath);
        IPath destinationPath = getPlatformFolder(destinationFolderRelativePath).getFullPath();
        return moveResource(sourceFolder, destinationPath);
    }

    /**
     * Move resource to given destination path.
     * 
     * @param resource
     * @param destinationPath
     * @return true if move occurred with no exception, false otherwise.
     */
    public static boolean moveResource(IResource resource, IPath destinationPath) {
        boolean result = false;
        try {
            resource.move(destinationPath, true, new NullProgressMonitor());
            result = true;
        } catch (Exception e) {
            EGFCommonPlugin.getDefault().logError(NLS.bind("FileHelper.moveResource(..) _ Could not move ''{0}'' to ''{1}''", resource.getFullPath(), destinationPath), e); //$NON-NLS-1$
        }
        return result;
    }

    /**
     * Is given file relative path pointing to an existing file ?
     * 
     * @param fileRelativePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return boolean
     */
    public static boolean exists(String fileRelativePath) {
        IFile file = getPlatformFile(fileRelativePath);
        return file != null ? file.exists() : false;
    }

    /**
     * Make sure that given path is safe to use, ie ensure that all parent folders
     * exist.
     * 
     * @param fileFullPath
     */
    public static boolean ensurePathAvailability(String fileFullPath) {
        // Get rid of file extension and file name, for this has no meaning in the
        // parent folders chain.
        IPath parentFolderPath = new Path(fileFullPath).removeFileExtension().removeLastSegments(1);
        // If it still makes sense to create a folder, go for it.
        if (parentFolderPath.isEmpty() == false) {
            File parentFolder = parentFolderPath.toFile();
            // Create the chain of parent folders.
            return parentFolder.mkdirs();
        }
        return true;
    }

    /**
     * Delete a workspace Resource. Optionally delete its parent folder if they
     * are empty. Root folder is never deleted.
     * 
     * @param root
     * @param resource
     * @param deleteParent
     */
    public static boolean deleteResource(IFolder root, IResource resource, boolean deleteParent) {
        if (resource == null) {
            return false;
        }
        // Delete found resource member
        if (FileHelper.deleteResource(resource) == false) {
            return false;
        }
        // Delete children container if they are empty
        if (root != null && deleteParent) {
            IContainer container = resource.getParent();
            while (container.equals(root) == false) {
                try {
                    IResource[] members = container.members();
                    if (members == null || members.length == 0) {
                        if (FileHelper.deleteResource(container)) {
                            container = container.getParent();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (CoreException ce) {
                    break;
                }
            }
        }
        return true;
    }

    /**
     * Delete given relative resource in the workspace.
     * 
     * @param fileRelativePath
     */
    public static boolean deleteFile(String fileRelativePath) {
        if (fileRelativePath == null || fileRelativePath.trim().length() == 0) {
            return false;
        }
        return deleteResource(getPlatformFile(fileRelativePath));
    }

    /**
     * Delete given relative folder in the workspace.
     * 
     * @param folderRelativePath
     * @return true if successfully deleted, false otherwise.
     */
    public static boolean deleteFolder(String folderRelativePath) {
        if (folderRelativePath == null || folderRelativePath.trim().length() == 0) {
            return false;
        }
        return deleteResource(getPlatformFolder(folderRelativePath));
    }

    /**
     * Delete given relative resource in the workspace.
     * 
     * @param resource
     */
    public static boolean deleteResource(IResource resource) {
        if (resource == null || resource.exists() == false) {
            return false;
        }
        try {
            resource.delete(IResource.KEEP_HISTORY, new NullProgressMonitor());
            return true;
        } catch (CoreException ce) {
            EGFCommonPlugin.getDefault().logError(NLS.bind("FileHelper.deleteFile(..) _ Unable to delete file ''{0}''", resource.getFullPath()), ce); //$NON-NLS-1$
        }
        return false;
    }

    /**
     * Get platform IResource as an {@link IResource} from its relative IPath.
     * 
     * @param path
     *            IPath relative to workspace.<br>
     * @return IResource
     */
    public static IResource getPlatformResource(IPath path) {
        // Precondition.
        if (path == null) {
            return null;
        }
        return ResourcesPlugin.getWorkspace().getRoot().findMember(path);
    }

    /**
     * Get platform file as an {@link IResource} from its relative path.
     * 
     * @param fileRelativePath
     *            File path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return IFile
     */
    public static IFile getPlatformFile(String fileRelativePath) {
        // Precondition.
        if (fileRelativePath == null) {
            return null;
        }
        return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileRelativePath));
    }

    /**
     * Get platform folder as an {@link IResource} from its relative path.
     * 
     * @param folderRelativePath
     *            Folder path relative to the plug-in, plug-in id included.<br>
     *            See {@link #getFileFullUrl(String)} documentation.
     * @return IFolder
     */
    public static IFolder getPlatformFolder(String folderRelativePath) {
        // Precondition.
        if (folderRelativePath == null) {
            return null;
        }
        return ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(folderRelativePath));
    }

    /**
     * Returns the file extension portion for given file path, <br>
     * or <code>null</code> if there is none.<br>
     * <p>
     * The file extension portion is defined as the string<br>
     * following the last period (".") character in the last segment.<br>
     * If there is no period in the last segment, the path has no<br>
     * file extension portion. If the last segment ends in a period,<br>
     * the file extension portion is the empty string.<br>
     * </p>
     * 
     * @param filePath
     * @return the file extension or <code>null</code>
     */
    public static String getFileExtension(String filePath) {
        // Precondition.
        if (filePath == null) {
            return null;
        }
        return new Path(filePath).getFileExtension();
    }

}
