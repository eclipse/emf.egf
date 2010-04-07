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
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * @author brocard
 */
public class FileHelper {

  private FileHelper() {
    // Prevent Instantiation
  }

  /**
   * Get file full url from relative one.
   * 
   * @param fileRelativePath_p
   *          File path relative to workspace.<br>
   *          It <b>must</b> start with <i>pluginId</i>. It is also recommended
   *          that both plug-in id and plug-in project names are the same.<br>
   *          As a convenience, the full path will refer to the plug-in id.<br>
   *          <b>Example</b> :
   *          <i>com.thalesgroup.mde.mdsofa/model/example.ecore</i> is a path
   *          relative to the workspace that refers to the
   *          <i>com.thalesgroup.mde.mdsofa plug-in</i>, having a
   *          <i>model/example.ecore</i> file in its project.<br>
   *          In Eclipse resource system, such a path is considered as an
   *          absolute one against the workspace root.<br>
   *          It's still referred to as a relative path, since the returned URL
   *          is absolute in the file system.
   * @return
   */
  public static URL getFileFullUrl(String fileRelativePath_p) {
    // Get the URI for given relative path.
    return getFileFullUrl(getFileFullUri(fileRelativePath_p));
  }

  /**
   * Get file full url from its full uri.<br>
   * See {@link #getFileFullUri(String)} method.
   * 
   * @param fileFullUri_p
   * @return
   */
  public static URL getFileFullUrl(URI fileFullUri_p) {
    URL result = null;
    // Resolve url from returned uri.
    try {
      result = FileLocator.resolve(new URL(fileFullUri_p.toString()));
    } catch (Exception e) {
      StringBuilder msg = new StringBuilder("FileHelper.getFileFullPath(..) _ "); //$NON-NLS-1$
      msg.append("Unable to resolve the url for ").append(fileFullUri_p.toString()); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), e);
    }
    return result;
  }

  /**
   * Get a file uri from relative one which is not resolved against the eclipse
   * platform.<br>
   * The returned uri starts with either 'platform:/plug-in/' or
   * 'platform:/resource/'.
   * 
   * @param fileRelativePath_p
   *          File path relative to workspace.<br>
   *          It <b>must</b> start with <i>pluginId</i>. It is also recommended
   *          that both plug-in id and plug-in project names are the same.<br>
   *          As a convenience, the full path will refer to the plug-in id.<br>
   *          <b>Example</b> :
   *          <i>com.thalesgroup.mde.mdsofa/model/example.ecore</i> is a path
   *          relative to the workspace that refers to the
   *          <i>com.thalesgroup.mde.mdsofa plug-in</i>, having a
   *          <i>model/example.ecore</i> file in its project.
   * @return an {@link URI} not resolved against the eclipse platform.<br>
   */
  public static URI getFileFullUri(String fileRelativePath_p) {
    URI fileUri = null;
    // Precondition.
    if (fileRelativePath_p == null) {
      return fileUri;
    }
    // Find plug-in model base from relative first segment.
    IPath path = new Path(fileRelativePath_p);
    IPluginModelBase modelBase = PluginRegistry.findModel(path.segment(0));
    // Get underlying resource.
    IResource resource = modelBase != null ? modelBase.getUnderlyingResource() : null;
    if (resource != null) { // Resource found, the file is in the workspace.
      fileUri = URI.createPlatformResourceURI(fileRelativePath_p, true);
    } else { // Resource not found, the file is deployed elsewhere.
      fileUri = URI.createPlatformPluginURI(fileRelativePath_p, true);
    }
    return fileUri;
  }

  /**
   * Convert package name to a correct java folder path.
   * 
   * @param packageName_p
   * @return
   */
  public static String convertPackageNameToFolderPath(String packageName_p) {
    return packageName_p != null ? packageName_p.replace(EGFCommonConstants.DOT_CHARACTER, EGFCommonConstants.SLASH_CHARACTER) : null;
  }

  /**
   * Read given input stream as an array of bytes.
   * 
   * @param inputStream_p
   * @return a not null array.
   */
  public static byte[] readFile(InputStream inputStream_p) {
    byte[] data = null;
    try {
      data = new byte[inputStream_p.available()];
      inputStream_p.read(data);
    } catch (Exception e) {
      StringBuilder msg = new StringBuilder("FileHelper.readFile(..) _ "); //$NON-NLS-1$
      msg.append("Failed to read the input stream ! "); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), e);
    } finally {
      if (inputStream_p != null) {
        try {
          inputStream_p.close();
        } catch (IOException ioe) {
          StringBuilder msg = new StringBuilder("FileHelper.readFile(..) _ "); //$NON-NLS-1$
          msg.append("Failed to close input stream ! "); //$NON-NLS-1$
          EGFCommonPlugin.getDefault().logError(msg.toString(), ioe);
        }
      }
    }
    // Ensure to return a not null array.
    return (null == data) ? new byte[0] : data;
  }

  /**
   * Read file as a string.
   * 
   * @param filePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return If an error occurred {@link EGFCommonConstants#EMPTY_STRING} is
   *         returned.
   */
  public static String readFile(String filePath_p) {
    byte[] rawContent = readRawFile(filePath_p);
    return rawContent.length == 0 ? EGFCommonConstants.EMPTY_STRING : new String(rawContent);
  }

  /**
   * Get file as a stream.
   * 
   * @param filePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return If an error occurred null is returned.
   */
  public static InputStream readFileAsStream(String filePath_p) {
    InputStream result = null;
    // Get input stream and copy its content to resulting string.
    URL fileURL = getFileFullUrl(filePath_p);
    try {
      result = fileURL.openStream();
    } catch (Exception e) {
      StringBuilder msg = new StringBuilder("FileHelper.readFileAsStream(..) _ "); //$NON-NLS-1$
      msg.append("Failed to load ").append(filePath_p); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), e);
    }
    return result;
  }

  /**
   * Read file as an array of bytes.
   * 
   * @param filePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return a not null array.
   */
  public static byte[] readRawFile(String filePath_p) {
    byte[] result = null;
    // Get stream from file.
    InputStream inputStream = readFileAsStream(filePath_p);
    // Ensure the input stream got from the file path is not null.
    if (inputStream != null) {
      result = readFile(inputStream);
    }
    return (null == result) ? new byte[0] : result;
  }

  /**
   * Copy given source file content in given target file.
   * 
   * @param sourceFileRelativePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @param targetFileRelativePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   */
  public static void copyFile(String sourceFileRelativePath_p, String targetFileRelativePath_p) {
    writeFile(targetFileRelativePath_p, true, readRawFile(sourceFileRelativePath_p));
  }

  /**
   * Write given string contents at specified path.
   * 
   * @param filePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @param ensureFolders_p
   *          Make sure all parent folders exist by creating all necessary ones.
   * @param contents_p
   *          Contents that should be written to pointed file.
   * @return
   */
  public static boolean writeFile(String filePath_p, boolean ensureFolders_p, String contents_p) {
    return writeFile(filePath_p, ensureFolders_p, contents_p.getBytes());
  }

  /**
   * Write given contents of bytes at specified path.
   * 
   * @param filePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @param ensureFolders_p
   *          Make sure all parent folders exist by creating all necessary ones.
   * @param contents_p
   *          Contents that should be written to pointed file.
   * @return
   */
  public static boolean writeFile(String filePath_p, boolean ensureFolders_p, byte[] contents_p) {
    FileChannel channel = null;
    try {
      // Get file full path from its relative one.
      String fileFullPath = getFileFullUrl(filePath_p).getFile();
      // Should path be enforced ?
      if (ensureFolders_p) {
        ensurePathAvailability(fileFullPath);
      }
      // Try and open the resulting file.
      channel = new FileOutputStream(fileFullPath).getChannel();
      // Write contents.
      channel.write(ByteBuffer.wrap(contents_p));
    } catch (Exception e) {
      StringBuilder msg = new StringBuilder("FileHelper.writeFile(..) _ "); //$NON-NLS-1$
      msg.append("Failed to open channel in write mode for "); //$NON-NLS-1$
      msg.append(filePath_p).append(" !"); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), e);
      return false;
    } finally {
      if (channel != null && channel.isOpen()) {
        try {
          // Close the channel.
          channel.close();
        } catch (IOException e) {
          StringBuilder msg = new StringBuilder("FileHelper.writeFile(..) _ "); //$NON-NLS-1$
          msg.append("Failed to close opened channel in write mode ! "); //$NON-NLS-1$
          msg.append(filePath_p).append(" may no longer be usable."); //$NON-NLS-1$
          EGFCommonPlugin.getDefault().logError(msg.toString(), e);
        }
      }
    }
    return true;
  }

  /**
   * Rename file from source file relative path to destination relative path.
   * 
   * @param sourceFileRelativePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @param destinationFileRelativePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return
   */
  public static boolean renameFile(String sourceFileRelativePath_p, String destinationFileRelativePath_p) {
    // Preconditions.
    if (sourceFileRelativePath_p == null || destinationFileRelativePath_p == null) {
      return false;
    }
    IFile sourceFile = getPlatformFile(sourceFileRelativePath_p);
    IPath destinationPath = getPlatformFile(destinationFileRelativePath_p).getFullPath();
    return moveResource(sourceFile, destinationPath);
  }

  /**
   * Rename folder from source folder relative path to destination relative
   * path.
   * 
   * @param sourceFolderRelativePath_p
   *          Folder path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @param destinationFolderRelativePath_p
   *          Folder path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return
   */
  public static boolean renameFolder(String sourceFolderRelativePath_p, String destinationFolderRelativePath_p) {
    // Preconditions.
    if (sourceFolderRelativePath_p == null || destinationFolderRelativePath_p == null) {
      return false;
    }
    IFolder sourceFolder = getPlatformFolder(sourceFolderRelativePath_p);
    IPath destinationPath = getPlatformFolder(destinationFolderRelativePath_p).getFullPath();
    return moveResource(sourceFolder, destinationPath);
  }

  /**
   * Move resource to given destination path.
   * 
   * @param resource_p
   * @param destinationPath_p
   * @return true if move occurred with no exception, false otherwise.
   */
  public static boolean moveResource(IResource resource_p, IPath destinationPath_p) {
    boolean result = false;
    try {
      resource_p.move(destinationPath_p, true, new NullProgressMonitor());
      result = true;
    } catch (Exception e) {
      StringBuilder msg = new StringBuilder("FileHelper.moveResource(..) _ "); //$NON-NLS-1$
      msg.append("Could not move ").append(resource_p.getFullPath()); //$NON-NLS-1$
      msg.append(" to ").append(destinationPath_p); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), e);
    }
    return result;
  }

  /**
   * Is given file relative path pointing to an existing file ?
   * 
   * @param fileRelativePath_p
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return
   */
  public static boolean exists(String fileRelativePath_p) {
    IFile file = getPlatformFile(fileRelativePath_p);
    return file != null ? file.exists() : false;
  }

  /**
   * Make sure that given path is safe to use, ie ensure that all parent folders
   * exist.
   * 
   * @param fileFullPath_p
   */
  public static void ensurePathAvailability(String fileFullPath_p) {
    // Get rid of file extension and file name, for this has no meaning in the
    // parent folders chain.
    IPath parentFolderPath = new Path(fileFullPath_p).removeFileExtension().removeLastSegments(1);
    // If it still makes sense to create a folder, go for it.
    if (parentFolderPath.isEmpty() == false) {
      File parentFolder = parentFolderPath.toFile();
      // Create the chain of parent folders.
      parentFolder.mkdirs();
    }
  }

  /**
   * Delete a workspace Resource. Optionally delete its parent folder if they
   * are empty. Root folder is never deleted.
   * 
   * @param javaProject_p
   * @param resourcePath_p
   */
  public static boolean deleteResource(IFolder root_p, IResource resource_p, boolean deleteParent_p) {
    if (resource_p == null) {
      return false;
    }
    // Delete found resource member
    if (FileHelper.deleteResource(resource_p) == false) {
      return false;
    }
    // Delete children container if they are empty
    if (root_p != null && deleteParent_p) {
      IContainer container = resource_p.getParent();
      while (container.equals(root_p) == false) {
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
   * @param fileRelativePath_p
   */
  public static boolean deleteFile(String fileRelativePath_p) {
    if (fileRelativePath_p == null || fileRelativePath_p.trim().length() == 0) {
      return false;
    }
    return deleteResource(getPlatformFile(fileRelativePath_p));
  }

  /**
   * Delete given relative folder in the workspace.
   * 
   * @param workspaceRelativePath_p
   * @return true if successfully deleted, false otherwise.
   */
  public static boolean deleteFolder(String folderRelativePath_p) {
    if (folderRelativePath_p == null || folderRelativePath_p.trim().length() == 0) {
      return false;
    }
    return deleteResource(getPlatformFolder(folderRelativePath_p));
  }

  /**
   * Delete given relative resource in the workspace.
   * 
   * @param resource_p
   */
  public static boolean deleteResource(IResource resource_p) {
    if (resource_p == null || resource_p.exists() == false) {
      return false;
    }
    try {
      resource_p.delete(true, new NullProgressMonitor());
      return true;
    } catch (CoreException ce) {
      StringBuilder msg = new StringBuilder("FileHelper.deleteFile(..) _ "); //$NON-NLS-1$
      msg.append("Unable to delete file:").append(resource_p.getFullPath()); //$NON-NLS-1$
      EGFCommonPlugin.getDefault().logError(msg.toString(), ce);
    }
    return false;
  }

  /**
   * Get platform IResource as an {@link IResource} from its relative IPath.
   * 
   * @param path_p
   *          IPath relative to workspace.<br>
   * @return
   */
  public static IResource getPlatformResource(IPath path_p) {
    // Precondition.
    if (path_p == null) {
      return null;
    }
    return ResourcesPlugin.getWorkspace().getRoot().findMember(path_p);
  }

  /**
   * Get platform file as an {@link IResource} from its relative path.
   * 
   * @param fileRelativePath
   *          File path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return
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
   * @param folderRelativePath_p
   *          Folder path relative to the plug-in, plug-in id included.<br>
   *          See {@link #getFileFullUrl(String)} documentation.
   * @return
   */
  public static IFolder getPlatformFolder(String folderRelativePath_p) {
    // Precondition.
    if (folderRelativePath_p == null) {
      return null;
    }
    return ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(folderRelativePath_p));
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
   * @param filePath_p
   * @return the file extension or <code>null</code>
   */
  public static String getFileExtension(String filePath_p) {
    // Precondition.
    if (filePath_p == null) {
      return null;
    }
    return new Path(filePath_p).getFileExtension();
  }

}