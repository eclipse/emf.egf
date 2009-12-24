/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */

package org.eclipse.egf.console;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.log.IEGFLogger;
import org.eclipse.egf.console.internal.ConsoleDocument;
import org.eclipse.egf.console.internal.ConsoleFactory;
import org.eclipse.egf.console.internal.IEGFConsoleConstants;
import org.eclipse.egf.console.l10n.ConsoleMessages;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * Console that shows the output of CVS commands. It is shown as a page in the
 * generic console view. It supports coloring for message, command, and error
 * lines in addition the font can be configured.
 * 
 * @since 3.0
 */
public class Console extends MessageConsole implements IPropertyChangeListener, IEGFLogger {

  private Color _errorColor;

  private Color _infoColor;

  private Color _warningColor;

  // streams for each command type - each stream has its own color

  private MessageConsoleStream _errorStream;

  private MessageConsoleStream _infoStream;

  private MessageConsoleStream _warningStream;

  private boolean _showOnMessage;

  private ConsoleDocument _document;

  private IConsoleManager _consoleManager;

  // format for timings printed to console
  @SuppressWarnings("unused")
  private static final DateFormat TIME_FORMAT;

  static {
    DateFormat format;
    try {
      format = new SimpleDateFormat(ConsoleMessages.Console_resultTimeFormat);
    } catch (RuntimeException e) {
      // This can happen if the bundle contains an invalid format
      //
      format = new SimpleDateFormat("'(took 'm:ss.SSS')')"); //$NON-NLS-1$
    }
    TIME_FORMAT = format;
  }

  // Indicates whether the console is visible in the Console view
  private boolean _visible = false;

  // Indicates whether the console's streams have been initialized
  private boolean _initialized = false;

  /*
   * Constant used for indenting error status printing
   */
  private static final String NESTING = "  "; //$NON-NLS-1$

  public class MyLifecycle implements org.eclipse.ui.console.IConsoleListener {

    public void consolesAdded(IConsole[] consoles) {
      for (int i = 0; i < consoles.length; i++) {
        IConsole console = consoles[i];
        if (console == Console.this) {
          init();
        }
      }
    }

    public void consolesRemoved(IConsole[] consoles) {
      for (int i = 0; i < consoles.length; i++) {
        IConsole console = consoles[i];
        if (console == Console.this) {
          ConsolePlugin.getDefault().getConsoleManager().removeConsoleListener(this);
          dispose();
        }
      }
    }

  }

  /**
   * Constructor initializes preferences and colors but doesn't create the
   * console page yet.
   */
  public Console() {
    super(ConsoleMessages.EGF_Console, EGFConsolePlugin.getDefault().getImageDescriptor(IEGFConsoleConstants.IMG_SEARCH_CONSOLE));
    setType("EGF"); //$NON-NLS-1$
    _showOnMessage = EGFConsolePlugin.getDefault().getPreferenceStore().getBoolean(IEGFConsoleConstants.CONSOLE_SHOW_ON_MESSAGE);
    _document = new ConsoleDocument();
    _consoleManager = ConsolePlugin.getDefault().getConsoleManager();
    EGFConsolePlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
  }

  public MessageConsoleStream getErrorStream() {
    return _errorStream;
  }

  public MessageConsoleStream getInfoStream() {
    return _infoStream;
  }

  public MessageConsoleStream getWarningStream() {
    return _warningStream;
  }

  public void logError(String line) {
    logError(line, 0);
  }

  public void logError(String line, int nesting) {
    if (_showOnMessage) {
      bringConsoleToFront();
    }
    appendLine(ConsoleDocument.ERROR, line, nesting);
  }

  public void logStatus(IStatus status) {
    logStatus(status, 0);
  }

  public void logStatus(IStatus status, int nesting) {
    if (_showOnMessage) {
      bringConsoleToFront();
    }
    outputStatus(status, nesting);
    // In case of IStatus.ERROR with a defined exception, we print a final
    // Message
    if (status != null && status.getSeverity() == IStatus.ERROR && status.getException() != null) {
      logError(ConsoleMessages.Console_see_your_log_file, nesting);
    }
  }

  public void logInfo(String line) {
    logInfo(line, 0);
  }

  public void logInfo(String line, int nesting) {
    if (_showOnMessage) {
      bringConsoleToFront();
    }
    appendLine(ConsoleDocument.INFO, line, nesting);
  }

  public void logWarning(String line) {
    logWarning(line, 0);
  }

  public void logWarning(String line, int nesting) {
    appendLine(ConsoleDocument.WARNING, line, nesting);
  }

  private void bringConsoleToFront() {
    if (_visible == false) {
      _consoleManager.addConsoles(new IConsole[] { this });
    }
    _consoleManager.showConsoleView(this);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.console.AbstractConsole#init()
   */
  @Override
  protected void init() {
    // Called when console is added to the console view
    super.init();

    initLimitOutput();
    initWrapSetting();

    // Ensure that initialization occurs in the ui thread
    EGFConsolePlugin.getWorkbenchDisplay().asyncExec(new Runnable() {

      public void run() {
        JFaceResources.getFontRegistry().addListener(Console.this);
        initializeStreams();
        dump();
      }
    });
  }

  private void initWrapSetting() {
    IPreferenceStore store = EGFConsolePlugin.getDefault().getPreferenceStore();
    if (store.getBoolean(IEGFConsoleConstants.CONSOLE_WRAP)) {
      setConsoleWidth(store.getInt(IEGFConsoleConstants.CONSOLE_WIDTH));
    } else {
      setConsoleWidth(-1);
    }
  }

  private void initLimitOutput() {
    IPreferenceStore store = EGFConsolePlugin.getDefault().getPreferenceStore();
    if (store.getBoolean(IEGFConsoleConstants.CONSOLE_LIMIT_OUTPUT)) {
      int lowWater = store.getInt(IEGFConsoleConstants.CONSOLE_LOW_WATER_MARK);
      int highWater = store.getInt(IEGFConsoleConstants.CONSOLE_HIGH_WATER_MARK);
      setWaterMarks(lowWater, highWater);
    } else {
      setWaterMarks(-1, 0);
    }
  }

  /*
   * Initialize thre streams of the console. Must be called from the UI thread.
   */
  protected void initializeStreams() {
    synchronized (_document) {
      if (_initialized == false) {
        _errorStream = newMessageStream();
        _infoStream = newMessageStream();
        _warningStream = newMessageStream();
        // install colors
        _errorColor = createColor(EGFConsolePlugin.getWorkbenchDisplay(), IEGFConsoleConstants.CONSOLE_ERROR_COLOR);
        _errorStream.setColor(_errorColor);
        _infoColor = createColor(EGFConsolePlugin.getWorkbenchDisplay(), IEGFConsoleConstants.CONSOLE_INFO_COLOR);
        _infoStream.setColor(_infoColor);
        _warningColor = createColor(EGFConsolePlugin.getWorkbenchDisplay(), IEGFConsoleConstants.CONSOLE_WARNING_COLOR);
        _warningStream.setColor(_warningColor);
        // install font
        Font f = PlatformUI.getWorkbench().getThemeManager().getCurrentTheme().getFontRegistry().get(IEGFConsoleConstants.CONSOLE_FONT);
        setFont(f);
        _initialized = true;
      }
    }
  }

  protected void dump() {
    synchronized (_document) {
      _visible = true;
      ConsoleDocument.ConsoleLine[] lines = _document.getLines();
      for (int i = 0; i < lines.length; i++) {
        ConsoleDocument.ConsoleLine line = lines[i];
        appendLine(line._type, line._line, line._nesting);
      }
      _document.clear();
    }
  }

  private void appendLine(int type, String line, int nesting) {
    final StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < nesting; i++) {
      buffer.append(NESTING);
    }
    if (_showOnMessage) {
      bringConsoleToFront();
    }
    showConsole();
    synchronized (_document) {
      if (_visible) {
        switch (type) {
        case ConsoleDocument.ERROR:
          buffer.append(line);
          getErrorStream().println(buffer.toString());
          break;
        case ConsoleDocument.INFO:
          buffer.append(line);
          getInfoStream().println(buffer.toString());
          break;
        case ConsoleDocument.WARNING:
          buffer.append(line);
          getWarningStream().println(buffer.toString());
          break;
        }
      } else {
        _document.appendConsoleLine(type, line, nesting);
      }
    }
  }

  private void showConsole() {
    show(false);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.console.MessageConsole#dispose()
   */
  @Override
  protected void dispose() {
    // Here we can't call super.dispose() because we actually want the
    // partitioner to remain
    // connected, but we won't show lines until the console is added to the
    // console manager
    // again.

    // Called when console is removed from the console view
    synchronized (_document) {
      _visible = false;
      JFaceResources.getFontRegistry().removeListener(this);
    }
  }

  /**
   * Clean-up created fonts.
   */
  public void shutdown() {
    // Call super dispose because we want the partitioner to be
    // disconnected.
    super.dispose();
    if (_errorColor != null) {
      _errorColor.dispose();
    }
    if (_infoColor != null) {
      _infoColor.dispose();
    }
    if (_warningColor != null) {
      _warningColor.dispose();
    }
    EGFConsolePlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
  }

  private void outputStatus(IStatus status, int nesting) {
    // Nothing to output
    if (status == null) {
      return;
    }
    // Current Status Management
    // Output the Current Status Message
    outputStatusMessage(status, nesting);
    // MultiStatus Management
    if (status.isMultiStatus()) {
      IStatus[] children = status.getChildren();
      for (int i = 0; i < children.length; i++) {
        outputStatus(children[i], nesting + 1);
      }
    }
    // Manage standard InvocationTargetException and CoreException
    if (status.getException() instanceof InvocationTargetException) {
      if (((InvocationTargetException) status.getException()).getTargetException() instanceof CoreException) {
        outputStatus(((CoreException) (((InvocationTargetException) status.getException()).getTargetException())).getStatus(), nesting + 1);
      }
    } else if (status.getException() instanceof CoreException) {
      outputStatus(((CoreException) status.getException()).getStatus(), nesting + 1);
    }
  }

  private void outputStatusMessage(IStatus status, int nesting) {
    // StringBuffer and Indent Management
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < nesting; i++) {
      buffer.append(NESTING);
    }
    // First we print the status message if applicable
    if (status.getMessage() != null && status.getMessage().trim().length() > 0) {
      if (status.getException() == null || status.getException() != null && status.getMessage().equals(status.getException().toString()) == false) {
        buffer.append(status.getMessage());
        if (status.getSeverity() == IStatus.ERROR) {
          appendLine(ConsoleDocument.ERROR, buffer.toString(), 0);
        } else if (status.getSeverity() == IStatus.WARNING) {
          appendLine(ConsoleDocument.WARNING, buffer.toString(), 0);
        } else {
          appendLine(ConsoleDocument.INFO, buffer.toString(), 0);
        }
        buffer = new StringBuffer();
        for (int i = 0; i < nesting + 1; i++) {
          buffer.append(NESTING);
        }
      }
    }
    // Then we process the inner Exception if necessary
    if (status.getException() != null) {
      buffer.append(messageLineForStatus(status));
      if (status.getSeverity() == IStatus.ERROR) {
        appendLine(ConsoleDocument.ERROR, buffer.toString(), 0);
      } else if (status.getSeverity() == IStatus.WARNING) {
        appendLine(ConsoleDocument.WARNING, buffer.toString(), 0);
      } else {
        appendLine(ConsoleDocument.INFO, buffer.toString(), 0);
      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse
   * .jface.util.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent event) {
    String property = event.getProperty();
    // colors
    if (_visible) {
      if (property.equals(IEGFConsoleConstants.CONSOLE_WRAP) || property.equals(IEGFConsoleConstants.CONSOLE_WIDTH)) {
        initWrapSetting();
      } else if (property.equals(IEGFConsoleConstants.CONSOLE_LIMIT_OUTPUT) || property.equals(IEGFConsoleConstants.CONSOLE_HIGH_WATER_MARK) || property.equals(IEGFConsoleConstants.CONSOLE_LOW_WATER_MARK)) {
        initLimitOutput();
      } else if (property.equals(IEGFConsoleConstants.CONSOLE_ERROR_COLOR)) {
        Color newColor = createColor(EGFConsolePlugin.getWorkbenchDisplay(), IEGFConsoleConstants.CONSOLE_ERROR_COLOR);
        _errorStream.setColor(newColor);
        _errorColor.dispose();
        _errorColor = newColor;
      } else if (property.equals(IEGFConsoleConstants.CONSOLE_INFO_COLOR)) {
        Color newColor = createColor(EGFConsolePlugin.getWorkbenchDisplay(), IEGFConsoleConstants.CONSOLE_INFO_COLOR);
        _infoStream.setColor(newColor);
        _infoColor.dispose();
        _infoColor = newColor;
      } else if (property.equals(IEGFConsoleConstants.CONSOLE_WARNING_COLOR)) {
        Color newColor = createColor(EGFConsolePlugin.getWorkbenchDisplay(), IEGFConsoleConstants.CONSOLE_WARNING_COLOR);
        _warningStream.setColor(newColor);
        _warningColor.dispose();
        _warningColor = newColor;
      } else if (property.equals(IEGFConsoleConstants.CONSOLE_FONT)) {
        setFont(JFaceResources.getFont(IEGFConsoleConstants.CONSOLE_FONT));
      } else if (property.equals(IEGFConsoleConstants.CONSOLE_BACKGROUND_COLOR)) {
        setBackground(EGFConsolePlugin.getDefault().getPreferenceColor(IEGFConsoleConstants.CONSOLE_BACKGROUND_COLOR));
      }
    }
    if (property.equals(IEGFConsoleConstants.CONSOLE_SHOW_ON_MESSAGE)) {
      Object value = event.getNewValue();
      if (value instanceof String) {
        _showOnMessage = Boolean.valueOf((String) value).booleanValue();
      } else {
        _showOnMessage = ((Boolean) value).booleanValue();
      }
    }
  }

  private String messageLineForStatus(IStatus status) {
    if (status.getSeverity() == IStatus.ERROR) {
      return NLS.bind(ConsoleMessages.Console_error, new String[] { status.getException().toString() });
    } else if (status.getSeverity() == IStatus.WARNING) {
      return NLS.bind(ConsoleMessages.Console_warning, new String[] { status.getException().toString() });
    } else if (status.getSeverity() == IStatus.INFO) {
      return NLS.bind(ConsoleMessages.Console_info, new String[] { status.getException().toString() });
    }
    return status.getMessage();
  }

  /**
   * Returns a color instance based on data from a preference field.
   */
  private Color createColor(Display display, String preference) {
    RGB rgb = PreferenceConverter.getColor(EGFConsolePlugin.getDefault().getPreferenceStore(), preference);
    return new Color(display, rgb);
  }

  /**
   * Show the console.
   * 
   * @param showNoMatterWhat
   *          ignore preferences if <code>true</code>
   */
  public void show(boolean showNoMatterWhat) {
    if (showNoMatterWhat || _showOnMessage) {
      if (_visible == false) {
        ConsoleFactory.showConsole();
      } else {
        _consoleManager.showConsoleView(this);
      }
    }
  }

}
