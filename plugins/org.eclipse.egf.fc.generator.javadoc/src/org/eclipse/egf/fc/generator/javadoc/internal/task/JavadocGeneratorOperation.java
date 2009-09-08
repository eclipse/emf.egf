/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.generator.javadoc.internal.task;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.sun.tools.javadoc.Main;

/**
 * @author brocard
 */
public class JavadocGeneratorOperation extends WorkspaceModifyOperation {
  /**
   * Javadoc package names separator.
   */
  private static final String JAVADOC_PACKAGE_NAME_SEPARATOR = " "; //$NON-NLS-1$
  /**
   * Javadoc classpath separator.
   */
  private static final String JAVADOC_CLASSPATH_SEPARATOR = ";"; //$NON-NLS-1$
  /**
   * Author paragraphs option flag.
   */
  private static final String JAVADOC_AUTHOR_OPTION_FLAG = " -author "; //$NON-NLS-1$
  /**
   * Version paragraphs option flag.
   */
  private static final String JAVADOC_VERSION_OPTION_FLAG = " -version "; //$NON-NLS-1$
  /**
   * Usage pages generation option flag.
   */
  private static final String JAVADOC_USE_OPTION_FLAG = " -use "; //$NON-NLS-1$
  /**
   * Source compatibility version.
   */
  private static final String SOURCE_VERSION_5_0 = "1.5"; //$NON-NLS-1$
  /**
   * Source compatibility option flag.
   */
  private static final String JAVADOC_SOURCE_VERSION_OPTION_FLAG = " -source "; //$NON-NLS-1$
  /**
   * Generation scope.
   */
  private static final String JAVADOC_SCOPE_OPTION_FLAG = " -public "; //$NON-NLS-1$
  /**
   * Generation classpath.
   */
  private static final String JAVADOC_CLASSPATH_OPTION_FLAG = " -classpath "; //$NON-NLS-1$
  /**
   * Source folder path option flag.
   */
  private static final String JAVADOC_SOURCE_PATH_OPTION_FLAG = " -sourcepath "; //$NON-NLS-1$
  /**
   * Documentation folder suffix.
   */
  private static final String JAVADOC_OUTPUT_FOLDER_SUFFIX = "/doc"; //$NON-NLS-1$
  /**
   * Documentation output folder option flag.
   */
  private static final String JAVADOC_OUTPUT_FOLDER_OPTION_FLAG = " -d "; //$NON-NLS-1$
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(JavadocGeneratorOperation.class.getPackage().getName());
  /**
   * FactoryComponent project name.
   */
  private String _fcProjectName;
  /**
   * Source directory.
   */
  private String _sourceDirectory;
  /**
   * Execution result.
   */
  private boolean _result;
  /**
   * Temporary file absolute path.
   */
  private String _temporaryFilePath;
  /**
   * Ticks count.
   */
  private int _ticksCount;

  /**
   * Constructor.
   * @param fcProjectName_p
   */
  public JavadocGeneratorOperation(String fcProjectName_p, String sourceDirectory_p) {
    _fcProjectName = fcProjectName_p;
    _sourceDirectory = sourceDirectory_p;
  }

  /**
   * Do execution operation.
   * @return
   */
  private boolean doExecute(IProgressMonitor monitor_p) {
    boolean result = false;
    monitor_p.subTask(Messages.JavadocGeneratorOperation_ProgressReporting_Message);
    // Get workspace root.
    // Could not get java element.
    IJavaProject fcProject = ProjectHelper.getJavaProject(_fcProjectName);
    if (null == fcProject) {
      StringBuffer loggerMessage = new StringBuffer("JavadocGeneratorOperation.doExecute(..) _ "); //$NON-NLS-1$
      loggerMessage.append(_fcProjectName);
      loggerMessage.append(" is not a java project. Javadoc can't be generated !"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return result;
    }
    String[] classPath = null;
    try {
      classPath = JavaRuntime.computeDefaultRuntimeClassPath(fcProject);
    } catch (CoreException exception_p) {
      StringBuffer loggerMessage = new StringBuffer("JavadocGeneratorOperation.doExecute(..) _ "); //$NON-NLS-1$
      __logger.error(loggerMessage.toString(), exception_p);
    }
    // Class path is resolved for factory component project.
    if ((null == classPath) || (classPath.length <= 0)) {
      return result;
    }
    // Parameters.
    StringBuffer parameters = new StringBuffer();
    // Javadoc output folder.
    parameters.append(JAVADOC_OUTPUT_FOLDER_OPTION_FLAG);
    parameters.append(getJavadocOutputFolder(_fcProjectName));
    // Javadoc source path.
    parameters.append(JAVADOC_SOURCE_PATH_OPTION_FLAG);
    parameters.append(getJavadocInputSourceFolder(_fcProjectName, _sourceDirectory));
    // FactoryComponent project classpath.
    parameters.append(JAVADOC_CLASSPATH_OPTION_FLAG);
    for (String path : classPath) {
      parameters.append(path).append(JAVADOC_CLASSPATH_SEPARATOR);
    }
    // Remove latest separator character.
    parameters.deleteCharAt(parameters.length() - 1);
    // Javadoc scope.
    parameters.append(JAVADOC_SCOPE_OPTION_FLAG);
    // Java source compatibility version.
    parameters.append(JAVADOC_SOURCE_VERSION_OPTION_FLAG);
    parameters.append(SOURCE_VERSION_5_0);
    // Javadoc usage pages.
    parameters.append(JAVADOC_USE_OPTION_FLAG);
    // Javadoc version paragraphs.
    parameters.append(JAVADOC_VERSION_OPTION_FLAG);
    // Javadoc author paragraphs.
    parameters.append(JAVADOC_AUTHOR_OPTION_FLAG);
    // Package names.
    String[] packageNames = getPackageNames(fcProject);
    for (String packageName : packageNames) {
      parameters.append(packageName).append(JAVADOC_PACKAGE_NAME_SEPARATOR);
    }
    try {
      // Add command parameters.
      // Create parameters file.
      String parametersFileName = createParametersFile(parameters.toString());
      // Add parameters to process arguments.
      String processArgs[] = new String[] { parametersFileName };
      // Execute javadoc from programmatic api.
      Main.execute(processArgs);
      // Delete parameters file.
      deleteParametersFile();
      // Refresh project.
      fcProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor_p);
    } catch (Exception exception_p) {
      StringBuffer loggerMessage = new StringBuffer("JavadocGeneratorOperation.doExecute(..) _ "); //$NON-NLS-1$
      __logger.error(loggerMessage.toString(), exception_p);
    } finally {
      // Acknowledge that some work is done.
      monitor_p.worked(_ticksCount);
    }
    return result;
  }

  /**
   * Create temporary javadoc parameters file using given content.
   * @param parameters_p
   * @return
   * @throws Exception
   */
  private String createParametersFile(String parameters_p) throws Exception {
    _temporaryFilePath = ICommonConstants.EMPTY_STRING;
    File file = File.createTempFile("javadoc-arguments", ".tmp"); //$NON-NLS-1$//$NON-NLS-2$
    FileWriter writer = new FileWriter(file);
    try {
      writer.write(parameters_p);
      _temporaryFilePath = file.getAbsolutePath();
    } finally {
      writer.close();
    }
    return '@' + _temporaryFilePath;
  }

  /**
   * Delete temporary javadoc parameters file.
   */
  private void deleteParametersFile() {
    File parametersFile = new File(_temporaryFilePath);
    if (parametersFile.exists() && parametersFile.isFile()) {
      parametersFile.delete();
      _temporaryFilePath = null;
    }
  }

  /**
   * Get all valid package names for javadoc generation.
   * @param javaProject_p
   * @return
   */
  private String[] getPackageNames(IJavaProject javaProject_p) {
    List<String> packageNames = new ArrayList<String>(0);
    try {
      IPackageFragmentRoot[] roots = javaProject_p.getPackageFragmentRoots();
      for (int i = 0; i < roots.length; i++) {
        IPackageFragmentRoot root = roots[i];
        if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
          IJavaElement[] packs = root.getChildren();
          for (int k = 0; k < packs.length; k++) {
            IJavaElement curr = packs[k];
            if (curr.getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
              IPackageFragment packageFragment = (IPackageFragment) curr;
              // default packages are always incomplete
              String packageName = curr.getElementName();
              if (packageFragment.containsJavaResources() && (packageName.length() > 0)) {
                packageNames.add(packageName);
              }
            }
          }
        }
      }
    } catch (Exception exception_p) {
      StringBuffer loggerMessage = new StringBuffer("JavadocGeneratorOperation.getPackageNames(..) _ "); //$NON-NLS-1$
      __logger.error(loggerMessage.toString(), exception_p);
    }
    return packageNames.toArray(new String[packageNames.size()]);
  }

  /**
   * Get javadoc output folder absolute path.
   * @param fcProjectName_p
   * @return
   */
  private String getJavadocOutputFolder(String fcProjectName_p) {
    return getResolvedAbsolutePath(fcProjectName_p + JAVADOC_OUTPUT_FOLDER_SUFFIX);
  }

  /**
   * Get javadoc input source folder absolute path.
   * @param fcProjectName_p
   * @return
   */
  private String getJavadocInputSourceFolder(String fcProjectName_p, String sourceDirectory_p) {
    return getResolvedAbsolutePath(fcProjectName_p + ensurePath(sourceDirectory_p));
  }

  /**
   * Ensure given source directory starts wit ha slash character.
   * @param sourceDirectory_p
   * @return
   */
  private String ensurePath(String sourceDirectory_p) {
    String result = null;
    if (sourceDirectory_p.startsWith(String.valueOf(ICommonConstants.SLASH_CHARACTER))) {
      result = sourceDirectory_p;
    } else {
      result = new StringBuilder().append(ICommonConstants.SLASH_CHARACTER).append(sourceDirectory_p).toString();
    }
    return result;
  }

  /**
   * Get resolved absolute path from platform relative one (excluding 'platform:/resource' part).
   * @param platformRelativePath_p
   * @return
   */
  private String getResolvedAbsolutePath(String platformRelativePath_p) {
    String result = null;
    try {
      URL outputUrl = new URL(ICommonConstants.PLATFORM_RESOURCE + platformRelativePath_p);
      URL resolvedOutputUrl = FileLocator.resolve(outputUrl);
      result = resolvedOutputUrl.getFile();
    } catch (Exception exception_p) {
      StringBuffer loggerMessage = new StringBuffer("JavadocGeneratorOperation.getJavadocOutputFolder(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected void execute(IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException {
    // Do execute javadoc generation.
    _result = doExecute(monitor_p);
  }

  /**
   * Return if the execution is successful or not.
   * @return
   */
  public boolean getResult() {
    return _result;
  }

  /**
   * @param ticksCount_p
   */
  public void setTicksCount(int ticksCount_p) {
    _ticksCount = ticksCount_p;
  }
}
