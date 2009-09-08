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
package org.eclipse.egf.core;

import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.log4j.ILog4jConfigurer;
import org.osgi.framework.Bundle;


/**
 * Log4J configurator.
 * @author Guillaume Brocard
 */
public class Log4JConfigurator {
  /**
   * Extension point "log4jConfigurer" short id.
   */
  private static final String EXTENSION_POINT_SHORT_ID_LOG4J_CONFIGURER = "log4jConfigurer"; //$NON-NLS-1$

  private static final String LOG4J_APPENDER_FILE_APPEND = "log4j.appender.FILE.Append"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_FILE_MAX_BACKUP_INDEX = "log4j.appender.FILE.MaxBackupIndex"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_FILE_MAX_FILE_SIZE = "log4j.appender.FILE.MaxFileSize"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_FILE_LAYOUT_CONVERSION_PATTERN = "log4j.appender.FILE.layout.ConversionPattern"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_FILE_LAYOUT = "log4j.appender.FILE.layout"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_FILE_FILE = "log4j.appender.FILE.File"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_FILE = "log4j.appender.FILE"; //$NON-NLS-1$
  public static final String LOG4J_ROOT_LOGGER = "log4j.rootLogger"; //$NON-NLS-1$
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(Log4JConfigurator.class.getPackage().getName());

  public static void configure(Bundle bundle_p) throws Exception {
    // Configure LOG4J output.
    URL log4jConfigurationURL = bundle_p.getEntry("/log4j.properties"); //$NON-NLS-1$
    // Resolve the URL against the platform.
    URL resolvedURL = FileLocator.resolve(log4jConfigurationURL);
    // Load given log4j configuration as properties.
    Properties log4jProperties = new Properties();
    log4jProperties.load(resolvedURL.openStream());
    // Configure log4j with a file appender located in the workspace.
    addFileAppender(log4jProperties);
    // Configure log4j to trace in the Eclipse Console.
    ILog4jConfigurer log4jConfigurer = handleContributedLog4jConfigurer(log4jProperties);
    // Change the context class loader to allow log4J plug-in to load our Eclipse console appender class.
    Thread currentThread = Thread.currentThread();
    ClassLoader initialContextClassLoader = currentThread.getContextClassLoader();
    currentThread.setContextClassLoader(log4jConfigurer.getClass().getClassLoader());
    try {
      // Initialize log4j with loaded properties.
      PropertyConfigurator.configure(log4jProperties);
    } finally {
      currentThread.setContextClassLoader(initialContextClassLoader);
    }
    if (__logger.isDebugEnabled()) {
      StringBuffer loggerMessage = new StringBuffer("CoreActivator.start(..) _ LOG4J is correctly configured!"); //$NON-NLS-1$
      __logger.debug(loggerMessage.toString());
    }
  }

  /**
   * Add a file appender to log EGF traces in a file in workspace.
   * @param properties_p
   */
  private static void addFileAppender(Properties properties_p) {
    // Add a Rolling file appender.
    properties_p.put(LOG4J_APPENDER_FILE, "org.apache.log4j.RollingFileAppender"); //$NON-NLS-1$
    // Set the file path.
    URL workspaceURL = Platform.getInstanceLocation().getURL();
    String logFilePath = new StringBuilder(workspaceURL.getPath()).append(".metadata/egf.log").toString(); //$NON-NLS-1$
    properties_p.put(LOG4J_APPENDER_FILE_FILE, logFilePath);
    // Set the layout pattern.
    properties_p.put(LOG4J_APPENDER_FILE_LAYOUT, "org.apache.log4j.PatternLayout"); //$NON-NLS-1$
    properties_p.put(LOG4J_APPENDER_FILE_LAYOUT_CONVERSION_PATTERN, "%d %5p [%t] - %m%n"); //$NON-NLS-1$
    // Max size set to 1Mo.
    properties_p.put(LOG4J_APPENDER_FILE_MAX_FILE_SIZE, "1024KB"); //$NON-NLS-1$
    // Keep one backup file.
    properties_p.put(LOG4J_APPENDER_FILE_MAX_BACKUP_INDEX, "1"); //$NON-NLS-1$
    // Erase file at each startup.
    properties_p.put(LOG4J_APPENDER_FILE_APPEND, "false"); //$NON-NLS-1$
    // Update the root logger declaration.
    StringBuilder rootLogger = new StringBuilder((String) properties_p.get(LOG4J_ROOT_LOGGER));
    rootLogger.append(ICommonConstants.COMMA_CHARACTER).append(ICommonConstants.WHITE_SPACE_CHARACTER).append("FILE"); //$NON-NLS-1$
    properties_p.put(LOG4J_ROOT_LOGGER, rootLogger.toString());
  }

  /**
   * Add an appender to trace into the Eclipse Console.
   * @param properties_p
   */
  private static ILog4jConfigurer handleContributedLog4jConfigurer(Properties properties_p) {
    ILog4jConfigurer log4jConfigurer = null;
    // Get extensions abiding to user helper extension point.
    IConfigurationElement[] configurationElements =
                                                    ExtensionPointHelper.getConfigurationElements(CoreActivator.getDefault().getPluginID(),
                                                                                                  EXTENSION_POINT_SHORT_ID_LOG4J_CONFIGURER);
    if ((null != configurationElements) && (configurationElements.length > 0)) {
      // There should be one implementation only !
      // So take the first one, as expected.
      Object instantiatedClass = ExtensionPointHelper.createInstance(configurationElements[0], ExtensionPointHelper.ATT_CLASS);
      // Make sure this is the correct resulting type.
      if (instantiatedClass instanceof ILog4jConfigurer) {
        log4jConfigurer = (ILog4jConfigurer) instantiatedClass;
        log4jConfigurer.handleConfiguration(properties_p);
      }
    }
    return log4jConfigurer;
  }
}