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

import java.io.OutputStream;
import java.io.Writer;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;

/**
 * Implement a Log4J appender that traces in an Eclipse console.
 * @author Guillaume Brocard
 */
public class EclipseConsoleAppender extends WriterAppender {
  /**
   * Constructor.
   * @param layout_p
   * @param os_p
   */
  public EclipseConsoleAppender() {
    super();
  }

  /**
   * Constructor.
   * @param layout_p
   * @param os_p
   */
  public EclipseConsoleAppender(Layout layout_p, OutputStream os_p) {
    super(layout_p, os_p);
  }

  /**
   * Constructor.
   * @param layout_p
   * @param writer_p
   */
  public EclipseConsoleAppender(Layout layout_p, Writer writer_p) {
    super(layout_p, writer_p);
  }

  /**
   * Prepares the appender for use.
   */
  @Override
  public void activateOptions() {
    IOConsole egfConsole = new IOConsole("EGF Engine", null); //$NON-NLS-1$
    getConsoleManager().addConsoles(new IConsole[] { egfConsole });
    setWriter(createWriter(egfConsole.newOutputStream()));
  }

  /**
   * @see org.apache.log4j.WriterAppender#append(org.apache.log4j.spi.LoggingEvent)
   */
  @Override
  public void append(final LoggingEvent event_p) {
    // Filtering debug events.
    if (!Level.DEBUG.equals(event_p.getLevel())) {
      PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
        @SuppressWarnings("synthetic-access")
        public void run() {
          if (!checkEntryConditions()) {
            return;
          }
          subAppend(event_p);
        }
      });
    }
  }

  /**
   * Returns the console manager.
   * @return the console manager
   */
  private IConsoleManager getConsoleManager() {
    return ConsolePlugin.getDefault().getConsoleManager();
  }
}
