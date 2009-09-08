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
package org.eclipse.egf.pattern.ui.editor.util;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.pattern.ui.editor.PatternEditor;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;


/**
 * Pattern editor pages hyperlink listener.
 * @author Guillaume Brocard
 */
public class PatternEditorPageLinkListener extends HyperlinkAdapter {
  /**
   * Pattern editor reference.
   */
  private PatternEditor _editor;
  /**
   * Status line manager.
   */
  private IStatusLineManager _statusLineManager;

  /**
   * Constructor.
   * @param editor_p
   */
  public PatternEditorPageLinkListener(PatternEditor editor_p) {
    _editor = editor_p;
    _statusLineManager = _editor.getEditorSite().getActionBars().getStatusLineManager();
  }

  /**
   * @see org.eclipse.ui.forms.events.HyperlinkAdapter#linkEntered(org.eclipse.ui.forms.events.HyperlinkEvent)
   */
  @Override
  public void linkEntered(HyperlinkEvent e_p) {
    String pageId = (String) e_p.getHref();
    IFormPage page = _editor.findPage(pageId);
    if (null != page) {
      _statusLineManager.setMessage(MessageFormatHelper.formatMessage(Messages.PatternEditorPageLinkListener_Hyperlink_Page_StatusMessage, new String[] {page.getTitle()}));
    }
  }

  /**
   * @see org.eclipse.ui.forms.events.HyperlinkAdapter#linkExited(org.eclipse.ui.forms.events.HyperlinkEvent)
   */
  @Override
  public void linkExited(HyperlinkEvent e_p) {
    _statusLineManager.setMessage(ICommonConstants.EMPTY_STRING);
  }

  /**
   * @see org.eclipse.ui.forms.events.HyperlinkAdapter#linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent)
   */
  @Override
  public void linkActivated(HyperlinkEvent e_p) {
    String pageId = (String) e_p.getHref();
    if (null != pageId) {
      _editor.setActivePage(pageId);
    }
  }
}
