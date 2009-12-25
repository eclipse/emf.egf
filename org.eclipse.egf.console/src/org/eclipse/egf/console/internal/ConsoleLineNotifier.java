/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Thales Corporate Services S.A.S
 */

package org.eclipse.egf.console.internal;

import java.util.StringTokenizer;

import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.console.util.ConsoleUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.IHyperlink;
import org.eclipse.ui.console.IPatternMatchListener;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;

/**
 * Tracks text appended to the console and notifies listeners in terms of whole
 * lines.
 */
public class ConsoleLineNotifier implements IPatternMatchListener {

  /**
   * The console this notifier is tracking
   */
  private Console _console = null;

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.console.IPatternMatchListenerDelegate#connect(org.eclipse
   * .ui.console.TextConsole)
   */
  public void connect(TextConsole console) {
    if (console instanceof Console) {
      _console = (Console) console;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.console.IPatternMatchListener#disconnect()
   */
  public synchronized void disconnect() {
    _console = null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.console.IPatternMatchListener#matchFound(org.eclipse.ui.
   * console.PatternMatchEvent)
   */
  public void matchFound(PatternMatchEvent event) {
    try {
      int offset = event.getOffset();
      int length = event.getLength();
      String text = _console.getDocument().get(offset, length);
      // Platform
      //
      int index = text.indexOf("platform:/"); //$NON-NLS-1$
      if (index != -1) {
        buildLink(text, offset, length, "platform:/"); //$NON-NLS-1$
        return;
      }
      // Plugin
      //      
      index = text.indexOf("plugin:/"); //$NON-NLS-1$
      if (index != -1) {
        buildLink(text, offset, length, "plugin:/"); //$NON-NLS-1$
        return;
      }
    } catch (BadLocationException e) {
      // ignore
    }
  }

  private void buildLink(String text, int offset, int length, String type) {
    try {
      int index = text.indexOf(type);
      StringTokenizer tokenizer = new StringTokenizer(text, " "); //$NON-NLS-1$
      while (tokenizer.hasMoreElements()) {
        String elementName = tokenizer.nextToken();
        if (elementName.startsWith(type)) {
          URIHyperlink link = new URIHyperlink(URI.createURI(elementName));
          _console.addHyperlink(link, offset + index, elementName.length());
          return;
        }
      }
    } catch (Exception e) {
      // ignore
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.console.IPatternMatchListener#getPattern()
   */
  public String getPattern() {
    return ".*\\r(\\n?)|.*\\n"; //$NON-NLS-1$
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.console.IPatternMatchListener#getCompilerFlags()
   */
  public int getCompilerFlags() {
    return 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.console.IPatternMatchListener#getLineQualifier()
   */
  public String getLineQualifier() {
    return "\\n|\\r"; //$NON-NLS-1$
  }

  private static class URIHyperlink implements IHyperlink {

    private URI _uri;

    public URIHyperlink(URI uri) {
      _uri = uri;
    }

    public void linkEntered() {
      // Nothing to do
    }

    public void linkExited() {
      // Nothing to do
    }

    public void linkActivated() {
      try {
        if (_uri != null) {
          IEditorPart part = ConsoleUtil.openEditor(_uri);
          if (part != null && part instanceof IEditingDomainProvider) {
            ConsoleUtil.setSelectionToViewer(part, _uri);
          }
        }
      } catch (PartInitException pie) {
        EGFConsolePlugin.getDefault().logError(pie);
      }
    }

  }

}
