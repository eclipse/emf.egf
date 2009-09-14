/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.pattern.production;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.pattern.plugin.command.PatternTemplateExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;


public class PatternTemplateProducer {
  
  /**
   * Debug mode.
   */  
  private static boolean DEBUG = PatternActivator.getDefault().isDebugging(); 
  
  /**
   * Emf factory create methods prefix.
   */
  protected static final String PATTERN_FACTORY_CREATE_METHOD_PREFIX = "create"; //$NON-NLS-1$
  
  /**
   * Emf factory name prefix.
   */
  protected static final String PATTERN_FACTORY_NAME_SUFFIX = "Factory"; //$NON-NLS-1$
  
  /**
   * Emf factory attribute name from interface to implementation.
   */
  protected static final String PATTERN_FACTORY_ATTRIBUTE_NAME = "eINSTANCE"; //$NON-NLS-1$
      
  /**
   * Generate resulting template for given pattern data.
   * @param patternData_p
   * @return
   */
  public static boolean generateTemplate(final PatternData patternData_p) {
    try {
      // Do produce the pattern.
      // That is instantiate its generated class, and invoke production method.
      String patternTemplatePath = doProducePattern(patternData_p);
      if (patternTemplatePath == null) {
        return false;
      }
      // Should template be compiled ?
      if (patternData_p.getProductionOptionsHandler().shouldCompileTemplate()) {
        // Now that the template is created, compile it.
        if (compileResultingTemplate(patternTemplatePath, patternData_p) == false) {
          return false;
        }
      }
    } catch (Exception e) {
      if (DEBUG) {
        EGFConsolePlugin.getConsole().logThrowable(
          NLS.bind(Messages.PatternTemplateProducer_PatternProductionErrorMessage, patternData_p.getPatternLogicalName()), 
          e
        );
      }
      PatternActivator.getDefault().log(e);      
      return false;
    }
    return true;
  }  
  
  /**
   * Produce identified pattern.<br>
   * Do instantiate pattern generated class, and call its production method.<br>
   * As a result, a new template file is created.
   * @param patternData_p
   * @return Resulting template file (relative to workspace) path.
   * @throws Exception
   */
  public static String doProducePattern(PatternData patternData_p) throws Exception {
    // Instantiate pattern.
    ClassLoader classLoader[] = new ClassLoader[] { null };
    Pattern pattern = instantiatePattern(patternData_p, classLoader);
    // Unable to instantiate pattern.
    if (pattern == null) {
      return null;
    }
    // Call the pattern 'produce' method.
    String templateContent = pattern.produce(classLoader[0]);
    // Write a new template file to the project, with the content set to new one.
    String patternTemplatePath = TemplateHelper.getPatternTemplatePath(patternData_p);
    if (FileHelper.writeFile(patternTemplatePath, true, templateContent)) {
      return patternTemplatePath;
    }
    return null;
  }
  
  /**
   * Instantiate identified pattern.
   * @param patternData_p The pattern required data.
   * @param classLoader_p The class loader used to instantiate the pattern as an array of one element.<br>
   *          Can be null, it is then created using given pattern path java project, and returned in given array (as the only element).
   * @return
   * @throws Exception
   */
  public static Pattern instantiatePattern(PatternData patternData_p, ClassLoader[] classLoader_p) throws Exception {
    // Precondition.
    if (patternData_p == null) {
      return null;
    }
    // Set some useful variables
    IJavaProject javaProject = patternData_p.getJavaProject();
    ClassLoader classLoader = classLoader_p[0];    
    // Build the path string to the java resource we need to instantiate
    String pathString = new StringBuilder(PatternConstants.PATTERN_GENERATED_BASE_PACKAGE)
    .append(ICommonConstants.DOT_CHARACTER)
    .append(GeneratedContentHelper.getPatternPackageName(patternData_p.getPattern()))
    .append(ICommonConstants.DOT_CHARACTER)
    .append(GeneratedContentHelper.getPatternClassName(patternData_p.getPattern()))
    .append(PATTERN_FACTORY_NAME_SUFFIX)
    .toString();
    // Locate the resource to instantiate, if not found, we skip it
    // This check is less expensive than a classloader building and the according loading attempt
    IFile file = JavaHelper.getJavaSourceFile(
      javaProject, 
      new Path(FileHelper.convertPackageNameToFolderPath(pathString)).addFileExtension(IPatternConstants.JAVA_SOURCE_FILE_EXTENSION)
    );
    if (file == null) {
      return null;
    }
    // Build a classloader able to load our pattern
    // Only build and create class loader for an in-development pattern.
    if (javaProject != null) {
      // Create the class loader.
      // Use pattern plugin classloader as parent one.
      classLoader = ProjectHelper.getClassLoaderFor(javaProject, PatternActivator.getDefault().getClass().getClassLoader());
      if (classLoader == null) { // Try using given one instead.
        classLoader = classLoader_p[0];
      } else {
        // Return created class loader.
        classLoader_p[0] = classLoader;
      }
    }
    // Precondition.
    if (classLoader == null) {
      return null;
    }
    // Get the pattern factory.
    Class<?> factoryInterface = null;
    try {
      factoryInterface = classLoader.loadClass(pathString);
    } catch (ClassNotFoundException cnfe) {
      // We can do nothing so we leave
      return null;
    }    
    // And its instance through the eInstance EMF factory attribute.
    Field factoryEInstance = factoryInterface.getDeclaredField(PATTERN_FACTORY_ATTRIBUTE_NAME);
    Object factoryObject = factoryEInstance.get(factoryInterface);
    // Now instantiate the pattern java class, previously generated and compiled.
    Method createMethod = factoryInterface.getDeclaredMethod(
      new StringBuilder(PATTERN_FACTORY_CREATE_METHOD_PREFIX)
        .append(patternData_p.getPatternName())
        .toString(), 
      (Class[]) null
    );
    // Invoke and return it
    return (Pattern) createMethod.invoke(factoryObject, (Object[]) null);
  }  
  
  /**
   * Do compile/interpret resulting template, if applicable, into a resulting java class.<br>
   * Resulting class is not compiled, until a java compiler is applied.
   * @param patternTemplatePath_p
   * @param patternData_p
   * @return
   * @throws Exception
   */
  public static boolean compileResultingTemplate(String patternTemplatePath_p, PatternData patternData_p) throws Exception {
    return new GeneratedContentProducer().getProductionContributor().compileTemplate(patternTemplatePath_p, patternData_p);
  } 
    
  /**
   * Get pattern template as a string.
   * @param patternData_p
   * @param classLoader_p
   * @return the resulting template as a string, or empty string if an error occurred.
   */
  protected static String getPatternTemplateAsString(PatternData patternData_p, ClassLoader classLoader_p) {
    String result = ICommonConstants.EMPTY_STRING;
    // Instantiate pattern.
    ClassLoader classLoader[] = new ClassLoader[] { classLoader_p };
    try {
      Pattern pattern = instantiatePattern(patternData_p, classLoader);
      // Get result by generating instantiated pattern.
      if (pattern != null) {
        result = pattern.generate(classLoader[0]);
      }
    } catch (Exception e) {
      String msg = new String("PatternTemplateProducer.getPatternTemplateAsString(..) _ "); //$NON-NLS-1$
      if (DEBUG) {
        EGFConsolePlugin.getConsole().logThrowable(msg, e);
      }
      PatternActivator.getDefault().log(e);      
    }
    return result;
  }  
  
  /**
   * Clean pattern template structure.
   * @param javaProject_p
   * @param descriptor_p
   */  
  public static void cleanGeneratedStructures(IJavaProject javaProject_p, IDescriptor descriptor_p) {
    if (javaProject_p == null || descriptor_p == null) {
      return;
    }
    // Process only Workspace Plugin
    IPluginModelBase model = PluginRegistry.findModel(javaProject_p.getProject());
    if (model == null) {
      return;
    }
    // Retrieve needed informations from IDescriptor
    String patternShortId = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_ID);
    String patternTemplatePath = (String) descriptor_p.getValue(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_PATH);
    String patternTemplateClass = (String) descriptor_p.getValue(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS);    
    // Clean templates if any (this value is mandatory, but who knows...)
    if (patternTemplatePath != null && patternTemplatePath.trim().length() > 0) {
      FileHelper.deleteResource(
        TemplateHelper.getTemplateRootIFolder(javaProject_p),
        FileHelper.getPlatformResource(new Path(patternTemplatePath)),
        true
      );      
    }
    // Clean template resulting class if necessary (this value is optional)    
    if (patternTemplateClass != null && patternTemplateClass.trim().length() > 0) {
      JavaHelper.deleteJavaClass(
        javaProject_p, 
        new Path(FileHelper.convertPackageNameToFolderPath(patternTemplateClass)).addFileExtension(IPatternConstants.JAVA_SOURCE_FILE_EXTENSION), 
        true
      );
    }
    // Suppress generated pattern extension if any (this value is mandatory, but who knows...)
    if (patternShortId != null && patternShortId.trim().length() > 0) {
      IPluginChangesCommandRunner pluginChangesCommandRunner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();    
      pluginChangesCommandRunner.performChangesOnPlugin(
        model.getBundleDescription().getSymbolicName(), 
        Collections.singletonList(
          PatternTemplateExtensionFactory.unsetPatternTemplateExtension(patternShortId)
        )
      );
    }
  }

}
