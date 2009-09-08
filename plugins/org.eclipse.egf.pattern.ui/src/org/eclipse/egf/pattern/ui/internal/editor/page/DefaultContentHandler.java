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
package org.eclipse.egf.pattern.ui.internal.editor.page;

import java.beans.PropertyChangeListener;

import org.eclipse.egf.common.ui.viewers.IContentHandler;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;


/**
 * Default content handler implementation for pattern page.<br>
 * Returns null to the creation of a new element.
 * @author Guillaume Brocard
 */
public class DefaultContentHandler implements IContentHandler {
  
  /**
   * Pattern data reference.
   */
  private PatternData _patternData;
  
  /**
   * Pattern page.
   */
  private AbstractPatternPage _page;

  /**
   * Constructor.
   * @param patternData_p
   * @param page_p Can be null, in this case, the page is guessed at modification time.
   */
  public DefaultContentHandler(PatternData patternData_p, AbstractPatternPage page_p) {
    setPatternData(patternData_p);
    setPatternPage(page_p);
  }

  /**
   * Set pattern data proxy.
   * @param patternData_p
   */
  public void setPatternData(PatternData patternData_p) {
    _patternData = patternData_p;
  }

  /**
   * Set owner pattern page.
   * @param page_p
   */
  public void setPatternPage(AbstractPatternPage page_p) {
    _page = page_p;
    if ((null != _page) && (null == _patternData)) {
      setPatternData(_page.getPatternData());
    } else if (null == _page) {
      IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      if (editorPart instanceof FormEditor) {
        IFormPage page = ((FormEditor) editorPart).getActivePageInstance();
        if (page instanceof AbstractPatternPage) {
          _page = (AbstractPatternPage) page;
        }
      }
    }
  }

  /**
   * A modification that requires a save occurred.<br>
   * Set page as dirty.
   */
  protected void notifyModification() {
    // Set page to dirty.
    if (null != _page) {
      _page.setDirty(true);
    }
  }

  /**
   * Get page.
   * @return
   */
  public AbstractPatternPage getPage() {
    return _page;
  }

  /**
   * Get pattern data.
   * @return
   */
  public PatternData getPatternData() {
    return _patternData;
  }

  /**
   * Get pattern.
   * @return
   */
  public Pattern getPattern() {
    Pattern result = null;
    if (null != _patternData) {
      result = _patternData.getPattern();
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.IContentHandler#createNewElement()<br>
   *      This implementation returns null and should be overridden by implementors.
   */
  public Object createNewElement() {
    return null;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.IContentHandler#removeElement(java.lang.Object)<br>
   *      This implementation does nothing and should be overridden by implementors.
   */
  public void removeElement(Object element_p) {
    // Nothing to do here.
  }

  /**
   * Silly JFace data binding counter measure.
   * @param propertyName_p
   * @param listener_p
   */
  public void addPropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Avoid the JFace data-binding not very nice error message.
  }

  /**
   * Silly JFace data binding counter measure.
   * @param propertyName_p
   * @param listener_p
   */
  public void removePropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Avoid the JFace data-binding not very nice error message.
  }
  
}
