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
package org.eclipse.egf.core.ui.internal.log4j;

import java.util.Properties;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.Log4JConfigurator;
import org.eclipse.egf.core.log4j.ILog4jConfigurer;


/**
 * Configure Log4J to trace in an Eclipse console.
 * @author Guillaume Brocard
 */
public class Log4jConfigurer implements ILog4jConfigurer {
  private static final String LOG4J_APPENDER_ECLIPSE_CONSOLE_APPEND = "log4j.appender.EclipseConsoleAppender"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_ECLIPSE_CONSOLE_LAYOUT = "log4j.appender.EclipseConsoleAppender.layout"; //$NON-NLS-1$
  private static final String LOG4J_APPENDER_ECLIPSE_CONSOLE_LAYOUT_CONVERSION_PATTERN = "log4j.appender.EclipseConsoleAppender.layout.ConversionPattern"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.core.log4j.ILog4jConfigurer#handleConfiguration(java.util.Properties)
   */
  public void handleConfiguration(Properties log4jConfiguration_p) {
    // Add a Eclipse console appender.
    log4jConfiguration_p.put(LOG4J_APPENDER_ECLIPSE_CONSOLE_APPEND, EclipseConsoleAppender.class.getName());
    // Set the layout pattern.
    log4jConfiguration_p.put(LOG4J_APPENDER_ECLIPSE_CONSOLE_LAYOUT, "org.apache.log4j.PatternLayout"); //$NON-NLS-1$
    log4jConfiguration_p.put(LOG4J_APPENDER_ECLIPSE_CONSOLE_LAYOUT_CONVERSION_PATTERN, "%d %5p [%t] - %m%n"); //$NON-NLS-1$
    // Update the root logger declaration.
    StringBuilder rootLogger = new StringBuilder((String) log4jConfiguration_p.get(Log4JConfigurator.LOG4J_ROOT_LOGGER));
    rootLogger.append(ICommonConstants.COMMA_CHARACTER).append(ICommonConstants.WHITE_SPACE_CHARACTER).append("EclipseConsoleAppender"); //$NON-NLS-1$
    log4jConfiguration_p.put(Log4JConfigurator.LOG4J_ROOT_LOGGER, rootLogger.toString());
  }
}
