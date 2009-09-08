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
package org.eclipse.egf.pattern.ui.editor;

import org.apache.log4j.Logger;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;


/**
 * Pattern editor input.
 * @author Guillaume Brocard
 */
public class PatternEditorInput implements IEditorInput {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternEditorInput.class.getPackage().getName());
  
  /**
   * Pattern handler reference.
   */
  private PatternHandler _patternHandler;
  
  /**
   * Pattern data.
   */
  private PatternData _patternData;
  
  /**
   * Pattern model (link with the component factory explorer).
   */
  private PatternModel _patternModel;

  /**
   * Mark Editor dirty
   */
  private boolean _dirty;
  
  
  /**
   * Constructor.
   * @param fcId_p
   * @param patternModel_p Pattern model used to open an existing pattern in edition (then it must contain a pattern relative path)
   * or to create a new one (then it must contain a name, plus the parent library id).<br>
   * The relative path form must be /factory component id/path to pattern ecore file<br>
   * For instance <i>/FactoryComponent.2314321412354415455.60/model/Pattern1/pattern.pattern1.ecore</i> is a correct relative path.
   * @param editable_p
   */
  public PatternEditorInput(String fcId_p, PatternModel patternModel_p, boolean editable_p) {
    initialize(fcId_p, patternModel_p, editable_p);
  }

  /**
   * Initialize pattern data.
   * @param fcId_p
   * @param patternModel_p
   * @param editable_p
   */
  protected void initialize(String fcId_p, PatternModel patternModel_p, boolean editable_p) {
    if (_patternHandler == null) {
      _patternHandler = new PatternHandler(editable_p);
    }
    _patternModel = patternModel_p;
    try {
      _patternData = _patternHandler.load(patternModel_p.getPath());
      // Priority to the pattern logical name exposed as an extension point attribute
      // This should be done in editable mode
      // The dirty state will be checked once and reseted
      // It's up to the editorPart to analyse set stuff accordingly
      // See PatternOverviewPage.doCreateFormContent
      // This should be more deeply analysed as it is related to migration strategy
      if (editable_p) {
        if (_patternData.getPatternLogicalName() == null || _patternData.getPatternLogicalName().trim().length() == 0) {
          _patternData.getPattern().setLogicalName(patternModel_p.getName());
          _patternData.setPatternLogicalName(patternModel_p.getName());         
          _dirty = true;
        } else if (_patternModel.getName() == null || _patternModel.getName().trim().length() == 0) {
          if (_patternData.getPatternLogicalName() != null && _patternData.getPatternLogicalName().trim().length() > 0) {
            _dirty = true;
          }
        }
      }
    } catch (Exception exception_p) {
      // Pattern could not be created, create a new one.
      try {
        _patternData = _patternHandler.createPattern(fcId_p, patternModel_p);
      } catch (Exception exception_p1) {
        _patternData = null;
        StringBuilder loggerMessage = new StringBuilder("PatternEditorInput.initialize(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p1);
      }
    }
  }

  /**
   * @see org.eclipse.ui.IEditorInput#getName()
   */
  public String getName() {
    return _patternData.getPatternName();
  }

  /**
   * @see org.eclipse.ui.IEditorInput#getToolTipText()
   */
  public String getToolTipText() {
    return getName();
  }

  /**
   * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
   */
  public ImageDescriptor getImageDescriptor() {
    return ImageDescriptor.getMissingImageDescriptor();
  }

  /**
   * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter_p) {
    Object result = null;
    if (adapter_p == PatternData.class) {
      try {
        result = _patternData;
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("PatternEditorInput.getAdapter(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    } else if (adapter_p == PatternModel.class) {
      result = _patternModel;
    } else if (adapter_p == PatternHandler.class) {
      result = _patternHandler;
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.IEditorInput#exists()
   */
  public boolean exists() {
    return false;
  }

  /**
   * @see org.eclipse.ui.IEditorInput#getPersistable()
   */
  public IPersistableElement getPersistable() {
    return null;
  }
  
  public boolean isDirty() {
    return _dirty;
  }
  
}
