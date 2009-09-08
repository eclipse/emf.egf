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
package org.eclipse.egf.pattern.execution;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternTemplateConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.pattern.production.TemplateType;
import org.eclipse.egf.pattern.production.jet.IGenerator;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author Guillaume Brocard
 */
public class PatternExecutionHelper {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternExecutionHelper.class.getPackage().getName());

  /**
   * Argument key.<br>
   * Used as a key in the argument map.
   * @author Guillaume Brocard
   */
  public static enum ArgumentKey {
    EMF_RESOURCE, PRODUCTION_CONTEXT, EXECUTION_REPORTER
  }

  /**
   * Get argument value for given key.
   * @param argument_p
   * @param key_p
   * @return
   */
  @SuppressWarnings("unchecked")
  private static Object getValue(Object argument_p, ArgumentKey key_p) {
    Object result = null;
    if (argument_p instanceof Map) {
      Map<ArgumentKey, Object> arguments = (Map<ArgumentKey, Object>) argument_p;
      result = arguments.get(key_p);
    }
    return result;
  }

  /**
   * Get EMF resource from pattern argument.
   * @param argument_p
   * @return
   */
  public static Resource getResource(Object argument_p) {
    return (Resource) getValue(argument_p, ArgumentKey.EMF_RESOURCE);
  }

  /**
   * Get production context from pattern argument.
   * @param argument_p
   * @return
   */
  public static ProductionContext getContext(Object argument_p) {
    return (ProductionContext) getValue(argument_p, ArgumentKey.PRODUCTION_CONTEXT);
  }

  /**
   * Get execution reporter.
   * @param argument_p
   * @return
   */
  public static IPatternExecutionReporter getExecutionReporter(Object argument_p) {
    return (IPatternExecutionReporter) getValue(argument_p, ArgumentKey.EXECUTION_REPORTER);
  }

  /**
   * Invoke identified pattern with given arguments.
   * @param patternFullId_p the pattern full id.
   * @param arguments_p a set of arguments, compatible with the pattern kind.
   * @return The resulting content of the pattern invocation.
   */
  public static Object invokePattern(String patternFullId_p, Object arguments_p) {
    Object result = ICommonConstants.EMPTY_STRING;
    try {
      result = doRunPattern(patternFullId_p, arguments_p);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("PatternElementRunnerTask.invokePattern(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return result;
  }

  /**
   * Do run identified pattern with given arguments_p.
   * @param patternFullId_p the pattern full id.
   * @param arguments_p a set of arguments, compatible with the pattern kind.
   * @return The resulting content of the pattern execution.
   * @throws Exception run failed.
   */
  public static Object doRunPattern(String patternFullId_p, Object arguments_p) throws Exception {
    Object result = ICommonConstants.EMPTY_STRING;
    // Get the configuration element for given pattern.
    IConfigurationElement patternConfigElement = ExtensionPointHelper.getConfigurationElement(
      IPatternTemplateConstants.PATTERN_PLUGIN_ID,
      IPatternTemplateConstants.PATTERN_TEMPLATE_EXTENSION_POINT_ID,
      patternFullId_p
    );
    if (null != patternConfigElement) {
      // Get the template engine type.
      String templateEngineType = patternConfigElement.getAttribute(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_TYPE);
      if (TemplateType.JET.getId().equals(templateEngineType)) {
        // JET template engine is selected, let's load the template code.
        // The template code is a compiled class that implements IGenerator.
        IGenerator templateCode = (IGenerator) patternConfigElement.createExecutableExtension(IPatternTemplateConstants.PATTERN_TEMPLATE_ATT_CLASS);
        // Execute the template
        result = templateCode.generate(arguments_p);
      }
    }
    return result;
  }
  
}
