/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.production.template;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;


/**
 * @author Guillaume Brocard
 */
public class TemplateHelper {
    
  /**
   * Generated templates relative root path.
   */
  public static final String TEMPLATES_ROOT_PATH = "/templates/"; //$NON-NLS-1$
  
  /**
   * Generated templates relative root IPath.
   */
  public static final IPath TEMPLATES_ROOT_IPATH = new Path("templates"); //$NON-NLS-1$  
  
  /**
   * Generated templates relative path.
   */
  protected static final String GENERATED_TEMPLATES_PATH = TEMPLATES_ROOT_PATH + "generated/"; //$NON-NLS-1$
  
  /**
   * Generated templates relative IPath.
   */
  protected static final IPath GENERATED_TEMPLATES_IPATH = TEMPLATES_ROOT_IPATH.append("generated"); //$NON-NLS-1$  
  
  /**
   * Get generated template root IFolder for given project.<br>
   * @param javaProject_p
   * @return
   */
  public static IFolder getTemplateRootIFolder(IJavaProject javaProject_p) {
    // Check
    if (javaProject_p == null) {
      return null;
    }
    // Find template root path member
    IResource resource = ResourcesPlugin
      .getWorkspace()
      .getRoot()
      .findMember(
        javaProject_p
        .getPath()
        .append(TEMPLATES_ROOT_IPATH)
      );
    if (resource != null && resource instanceof IFolder) {
      return (IFolder) resource;
    }
    return null;    
  }
  
  /**
   * Get generated template IFolder for given project.<br>
   * @param javaProject_p
   * @return
   */
  public static IFolder getGeneratedTemplateIFolder(IJavaProject javaProject_p) {
    // Check
    if (javaProject_p == null) {
      return null;
    }
    // Find template generated path member
    IResource resource = ResourcesPlugin
      .getWorkspace()
      .getRoot()
      .findMember(
        javaProject_p
        .getPath()
        .append(GENERATED_TEMPLATES_IPATH)
      );
    if (resource != null && resource instanceof IFolder) {
      return (IFolder) resource;
    }
    return null;    
  }
  
  /**
   * Get generated template IFolder for given pattern short id.<br>
   * @param javaProject_p
   * @param patternShortId_p
   * @return
   */
  public static IFolder getGeneratedPatternTemplateIFolder(IJavaProject javaProject_p, String patternShortId_p) {
    // Check
    if (javaProject_p == null || patternShortId_p == null) {
      return null;
    }
    IFolder folder = getGeneratedTemplateIFolder(javaProject_p);
    if (folder == null) {
      return null;
    }
    IResource resource = folder.findMember(patternShortId_p);
    if (resource != null && resource instanceof IFolder) {
      return (IFolder) resource;
    }
    return null;    
  }    

  /**
   * Get generated template file path for given pattern data.<br>
   * Only usable for in-development patterns.<br>
   * Deployed patterns templates should be dealt with differently.<br>
   * TODO Guillaume Write a unique helper method that can deal with both cases.
   * @param patternData_p
   * @return
   */
  public static String getPatternTemplatePath(PatternData patternData_p) {
    String result = null;
    // Precondition.
    if (patternData_p == null) {
      return result;
    }
    // Get overriding template path.
    String templatePath = patternData_p.getProductionOptionsHandler().getPatternTemplatePath();
    if (templatePath != null && templatePath.trim().length() > 0) { // Use given template file path.
      // Location is local to the java project hosting the pattern.
      IPath patternTemplatePath = patternData_p.getJavaProject().getPath();
      patternTemplatePath = patternTemplatePath.append(TEMPLATES_ROOT_PATH).append(templatePath);
      result = patternTemplatePath.toString();
    } else { // Use default template file construction.
      result = computeTemplatePath(
        patternData_p.getPluginId(), 
        GENERATED_TEMPLATES_PATH, 
        patternData_p.getPattern().getShortId()
      );
    }
    return result;
  }

  /**
   * Read template file.
   * @param templateRelativePath_p the template relative path, prefixed by the factory component id.
   * @return
   */
  public static String readTemplateFile(String templateRelativePath_p) {
    String result = ICommonConstants.EMPTY_STRING;
    // Precondition.
    if (templateRelativePath_p == null) {
      return result;
    }
    // Get plug-in id.
    String fcId = new Path(templateRelativePath_p).segment(0);
    String pluginId = FactoryComponentHelper.getPluginId(fcId, PlatformLocationType.WORKSPACE_THEN_TARGET_PLATFORM);
    // Compatibility issue with the old way (v1.0.1) of referencing the templates.
    if (pluginId == null) {
      pluginId = fcId;
    }
    // Recompute physical path.
    String physicalTemplateRelativePath = getPhysicalRelativePath(templateRelativePath_p, pluginId);
    // Then read file at this relative path.
    return FileHelper.readFile(physicalTemplateRelativePath);
  }

  /**
   * Get physical relative path from logical one.
   * @param logicalRelativePath_p
   * @return
   */
  public static String getPhysicalRelativePath(String logicalRelativePath_p) {
    String result = null;
    if (logicalRelativePath_p == null) {
      return result;
    }
    // Get plug-in id.
    String fcId = new Path(logicalRelativePath_p).segment(0);
    String pluginId = FactoryComponentHelper.getPluginId(fcId, PlatformLocationType.WORKSPACE_THEN_TARGET_PLATFORM);
    // If plug-in id can not be resolved, then the logical path is not relative to an existing factory component.
    // Try with first segment of the logical path directly (which is likely to be a plug-in id).
    if (pluginId == null) {
      pluginId = fcId;
    }
    // Then return physical relative path.
    return getPhysicalRelativePath(logicalRelativePath_p, pluginId);
  }

  /**
   * Get physical relative path from logical given one.
   * @param logicalRelativePath_p
   * @param pluginId_p
   * @return
   */
  public static String getPhysicalRelativePath(String logicalRelativePath_p, String pluginId_p) {
    String result = null;
    if (logicalRelativePath_p == null || pluginId_p == null) {
      return result;
    }
    // Exclude factory component id from logical relative path.
    IPath relativePath = new Path(logicalRelativePath_p).removeFirstSegments(1);
    // Then recompute relative path using the plug-in id as a prefix.
    return 
      new Path(pluginId_p + ICommonConstants.EMPTY_STRING)
      .append(relativePath)
      .toString();
  }

  /**
   * Get template relative path for identified operation.
   * @param patternShortId_p
   * @param pluginId_p
   * @param operationName_p
   * @param operationId_p
   * @return
   */
  public static String getTemplateRelativePath(String patternShortId_p, String pluginId_p, String operationName_p, String operationId_p) {
    String result = null;
    // Preconditions.
    if (patternShortId_p == null || pluginId_p == null || operationName_p == null) {
      return result;
    }
    // Unexpected entry. Generate method code does not point to a template but to other pattern methods.
    if (PatternConstants.GENERATE_METHOD_NAME.equals(operationName_p)) {
      return result;
    }
    Couple<String, String> folderNames = getTemplatesFolderNames(patternShortId_p);
    String folderName = null;
    // In case template is also generated, then add generated folder path before.
    if (
         PatternConstants.GENERATE_PRE_MATCHING_METHOD_NAME.equals(operationName_p)
      || PatternConstants.GENERATE_POST_MATCHING_METHOD_NAME.equals(operationName_p)
    ) {
      folderName = folderNames.getValue();
      // Compute correct relative path.
      result = computeTemplatePath(pluginId_p, folderName, operationName_p);
    } else if (operationId_p != null) { // By default, folder name is pattern one.
      folderName = folderNames.getKey();
      // Compute correct relative path.
      result = computeTemplatePath(pluginId_p, folderName, operationId_p);
    }
    return result;
  }

  /**
   * Get templates folder names from pattern name.
   * @param patternShortId_p
   * @return A couple of (User templates folder path (whatever the containing plug-in may be), Generated templates folder path (whatever the containing plug-in
   *         may be)), null if given pattern name is.
   */
  private static Couple<String, String> getTemplatesFolderNames(String patternShortId_p) {
    if (patternShortId_p == null) {
      return null;
    }
    return 
      new Couple<String, String>(
        new StringBuilder(TEMPLATES_ROOT_PATH).append(patternShortId_p).toString(), 
        new StringBuilder(GENERATED_TEMPLATES_PATH).append(patternShortId_p).toString()
      );
  }

  /**
   * Get templates folder relative paths.<br>
   * @param patternShortId_p
   * @param pluginId_p
   * @return A couple of (User templates relative (to workspace) path, Generated templates relative (to workspace) path).
   */
  public static Couple<String, String> getPatternTemplatesFolderRelativePaths(String patternShortId_p, String pluginId_p) {
    Couple<String, String> folderNames = getTemplatesFolderNames(patternShortId_p);
    // Precondition.
    if (folderNames == null) {
      return null;
    }
    return 
      new Couple<String, String>(
        computeTemplateFolderPath(pluginId_p, folderNames.getKey()),
        computeTemplateFolderPath(pluginId_p, folderNames.getValue())
      );
  }

  /**
   * Compute template file relative path from containing plugin id, containing folder path, and template file name.
   * @param containingPluginId_p
   * @param subFolderPath_p
   * @param templateFileName_p
   * @return
   */
  private static String computeTemplatePath(
    String containingPluginId_p, 
    String subFolderPath_p, 
    String templateFileName_p
  ) {
    return 
      new StringBuilder(
        computeTemplateFolderPath(
          containingPluginId_p, 
          subFolderPath_p
        )
      )
      .append(ICommonConstants.SLASH_CHARACTER)
      .append(templateFileName_p)
      .append(ICommonConstants.DOT_CHARACTER)
      .append(PatternConstants.PATTERN_METHOD_FILE_EXTENSION)
      .toString();
  }

  /**
   * Compute template folder relative path from containing plugin id.
   * @param containingPluginId_p
   * @param subFolderPath_p
   * @return
   */
  private static String computeTemplateFolderPath(String containingPluginId_p, String subFolderPath_p) {
    return 
      new StringBuilder(ICommonConstants.SLASH_CHARACTER)
      .append(containingPluginId_p)
      .append(subFolderPath_p)
      .toString();
  }
  
}
