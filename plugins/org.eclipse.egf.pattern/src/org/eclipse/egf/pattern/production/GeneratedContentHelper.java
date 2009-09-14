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
package org.eclipse.egf.pattern.production;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.generator.IEgfGeneratorConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternTemplateExtensionReader;


/**
 * @author Guillaume Brocard
 */
public class GeneratedContentHelper {
  
  /**
   * Get the pattern model output IFolder.
   * @param project_p
   * @return null if given parameter is null.
   */
  public static IFolder getPatternOutputPath(IProject project_p) {
    // Precondition.
    if (project_p == null) {
      return null;
    }  
    IResource resource = project_p.findMember(PatternConstants.PATTERN_MODEL_FOLDER_IPATH);
    if (resource != null && resource instanceof IFolder) {
      return (IFolder) resource;
    }
    return null;
  }    
  
  /**
   * Get the binary output pattern generated IPath.
   * @param project_p
   * @return null if given parameter is null.
   */
  public static IPath getBinaryOutputPatternGeneratedFolder(IJavaProject project_p) {
    // Precondition.
    if (project_p == null) {
      return null;
    }  
    IPath path = null;
    try {
      path = project_p.getOutputLocation()
        .append( 
          FileHelper.convertPackageNameToFolderPath(
            PatternConstants.PATTERN_GENERATED_BASE_PACKAGE 
          )
      );
    } catch (JavaModelException jme) {
      // Just Ignore
    }
    return path;
  }  
  
  /**
   * Get an IFile as a normalized Pattern shortID.
   * This implementation is the opposite transformation of
   * the getPatternClassName method.
   * @param pattern_p
   * @return null if given parameter is null.
   */
  public static String getPatternIdentifier(IFile element_p) {
    // Precondition.
    if (element_p == null || element_p.getFullPath() == null) {
      return null;
    }        
    return StringHelper.replaceNonWordCharactersWithDot(element_p.getFullPath().removeFileExtension().lastSegment());
  }    
    
  /**
   * Get pattern generated EMF class name.
   * This implementation is the opposite transformation of
   * the getPatternIdentifier method. 
   * @param pattern_p
   * @return null if given parameter is null.
   */
  public static String getPatternClassName(Pattern pattern_p) {
    // Precondition.
    if (pattern_p == null) {
      return null;
    }    
    return StringHelper.replaceNonWordCharactersWithUnderscore(pattern_p.getShortId());
  }
  
  /**
   * Get an IFolder as a normalized Pattern shortID.
   * This implementation is the opposite transformation of
   * the getPatternPackageName method.  
   * @param pattern_p
   * @return null if given parameter is null.
   */
  public static String getPatternIdentifier(IFolder element_p) {
    // Precondition.
    if (element_p == null || element_p.getName() == null) {
      return null;
    }        
    return StringHelper.replaceNonWordCharactersWithDot(StringHelper.toUpperFirst(element_p.getName()));
  }  
  
  /**
   * Get pattern generated EMF package name.
   * This implementation is the opposite transformation of
   * the getPatternIdentifier method.   
   * @param pattern_p
   * @return null if given parameter is null.
   */
  public static String getPatternPackageName(Pattern pattern_p) {
    // Precondition.
    if (pattern_p == null || pattern_p.getShortId() == null) {
      return null;
    }        
    return StringHelper.replaceNonWordCharactersWithUnderscore(StringHelper.toLowerFirst(pattern_p.getShortId()));
  }  
  
  /**
   * Get pattern generated EMF package namespace prefix.
   * @param pattern_p
   * @return null if given parameter is null.
   */
  public static String getPatternPackageNsPrefix(Pattern pattern_p) {
    return getPatternPackageName(pattern_p);
  }    

  /**
   * Get pattern generated EMF package namespace URI.
   * @param pattern_p
   * @return null if given parameter is null.
   */
  public static String getPatternPackageNsURI(Pattern pattern_p) {
    // Precondition.
    if (pattern_p == null || pattern_p.getShortId() == null) {
      return null;
    }            
    return PatternConstants.PATTERN_GENERATED_ECORE_NS_URI_PREFIX + pattern_p.getShortId();
  }  
  
  /**
   * Get pattern generated EMF root folder path.
   * @param patternData_p
   * @return null if given parameter is null.
   */
  public static String getEMFGeneratedRootFolderRelativePath(PatternData patternData_p) {
    // Precondition.
    if (patternData_p == null) {
      return null;
    }
    // And its relative path.
    IPath rootGeneratedPackageRelativePath = 
      new Path(
          ICommonConstants.SLASH_CHARACTER 
        + patternData_p.getPluginId()
      ).append(
        PatternConstants.GENERATION_SOURCE_FOLDER
      ).append(
          ICommonConstants.SLASH_CHARACTER 
        + FileHelper.convertPackageNameToFolderPath(
            PatternConstants.PATTERN_GENERATED_BASE_PACKAGE 
          + ICommonConstants.DOT_CHARACTER
          + getPatternPackageName(patternData_p.getPattern())
        )
      );
    return rootGeneratedPackageRelativePath.toString();
  }  
  
  /**
   * Get pattern generated EMF packages names.
   * @param patternData_p
   * @return a list of packages names. Empty if given pattern data is null.
   */
  public static List<String> getEMFGeneratedPackagesNames(PatternData patternData_p) {
    // Precondition.
    List<String> result = Collections.emptyList();
    if (patternData_p == null) {
      return result;
    }
    result = new ArrayList<String>(3);
    // Compute base package name.
    String baseGeneratedPackageName =
        PatternConstants.PATTERN_GENERATED_BASE_PACKAGE 
      + ICommonConstants.DOT_CHARACTER
      + getPatternPackageName(patternData_p.getPattern());
    // Add base package relative path.
    result.add(baseGeneratedPackageName);
    // Add implementation package relative path.
    result.add(
        baseGeneratedPackageName 
      + IEgfGeneratorConstants.GENERATED_IMPL_JAVA_PACKAGE_SUFFIX
    );
    // Add tools package relative path.
    result.add(
        baseGeneratedPackageName 
      + IEgfGeneratorConstants.GENERATED_UTIL_JAVA_PACKAGE_SUFFIX
    );
    return result;
  }

  /**
   * Get generated pattern class description, if applicable.<br>
   * That is, if the pattern engine leads to a compiled Java class, get its package and class names.<br>
   * @param patternData_p
   * @return null if not applicable, or could not be found (not compiled yet). Else, a (package name, class name) couple.
   */
  protected static Couple<String, String> getPatternTemplateClassDescription(PatternData patternData_p) {
    Couple<String, String> result = null;
    if (patternData_p == null) {
      return result;
    }
    IDescriptor classDescriptor = new WorkspacePatternTemplateExtensionReader().readPatternTemplateExtension(
      patternData_p.getJavaProject().getProject(), 
      patternData_p.getPattern().getShortId()
    );
    if (classDescriptor == null) {
      return result;
    }
    String templateClass = (String) classDescriptor.getValue(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS);
    if (templateClass != null) {
      String className = StringHelper.substringAfter(ICommonConstants.DOT_CHARACTER, templateClass);
      String packageName = StringHelper.substringBefore(ICommonConstants.DOT_CHARACTER, templateClass);
      result = new Couple<String, String>(packageName, className);
    }
    return result;
  }

  /**
   * Get generated pattern class relative path, if any.<br>
   * A pattern may not have a generated class, if :<br>
   * <ul>
   * <li>either the pattern engine type does not support a Java class transformation.</li>
   * <li>or the pattern has not been produced yet, and thus no Java class can be found.</li>
   * </ul>
   * @param patternData_p
   * @return null if it could not be found, else the workspace relative path to the Java class.
   */
  public static String getGeneratedPatternClassRelativePath(PatternData patternData_p) {
    Couple<String, String> generatedPatternClassDescription = getPatternTemplateClassDescription(patternData_p);
    if (generatedPatternClassDescription == null) {
      return null;
    }
    IPath generatedPatternClassRelativePath = 
      new Path(
          ICommonConstants.SLASH_CHARACTER 
        + patternData_p.getPluginId()
      ).append(
        PatternConstants.GENERATION_SOURCE_FOLDER
      ).append(
          ICommonConstants.SLASH_CHARACTER
        + FileHelper.convertPackageNameToFolderPath(generatedPatternClassDescription.getKey())
      ).append(
          ICommonConstants.SLASH_CHARACTER 
        + generatedPatternClassDescription.getValue()
      ).addFileExtension(
        IPatternConstants.JAVA_SOURCE_FILE_EXTENSION
      );
    return generatedPatternClassRelativePath.toString();
  }
    
}
