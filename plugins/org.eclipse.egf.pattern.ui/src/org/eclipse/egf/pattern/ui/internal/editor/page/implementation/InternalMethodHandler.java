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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage;
import org.eclipse.egf.pattern.ui.internal.editor.DefaultPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jface.viewers.IContentProvider;


/**
 * @author Guillaume Brocard
 */
public class InternalMethodHandler extends DefaultContentHandler {
  
  /**
   * Method.
   */
  private EOperation _method;
  
  /**
   * Previously known name.
   */
  private String _previousName;
  
  /**
   * Is method modifiable or not ?
   */
  private boolean _isModifiable;
  
  /**
   * Is method overriding a parent one ?
   */
  private boolean _overrides;
  
  /**
   * Content provider.
   */
  private IContentProvider _provider;

  /**
   * Constructor.
   * @param page_p
   * @param method_p
   * @param patternData_p
   * @param provider_p
   */
  public InternalMethodHandler(AbstractPatternPage page_p, EOperation method_p, PatternData patternData_p, IContentProvider provider_p) {
    super(patternData_p, page_p);
    setMethodAndcomputeExtraData(method_p);
    _provider = provider_p;
  }

  /**
   * Constructor.
   * @param method_p
   * @param patternData_p
   */
  public InternalMethodHandler(EOperation method_p, PatternData patternData_p) {
    super(patternData_p, null);
    setMethodAndcomputeExtraData(method_p);
  }

  /**
   * Set method and compute method-centric data.
   * @param method_p
   */
  protected void setMethodAndcomputeExtraData(EOperation method_p) {
    // Precondition.
    Assert.isNotNull(method_p);
    // Set method.
    _method = method_p;
    // Compute modifiable flag, based on method name.
    String methodName = method_p.getName();
    _isModifiable = !(PatternConstants.GENERATE_HEADER_METHOD_NAME.equals(methodName) || PatternConstants.GENERATE_FOOTER_METHOD_NAME.equals(methodName));
    // Find out if method overrides an existing one.
    _overrides = computeOverriding(getPatternData().getParentPattern());
  }

  /**
   * Compute overriding status.
   * @param parentPattern_p
   * @return
   */
  protected boolean computeOverriding(Pattern parentPattern_p) {
    boolean result = false;
    // Precondition.
    if (null == parentPattern_p) {
      return result;
    }
    // Search for operations one parent below at first (so as to find latest implementation).
    EList<EOperation> operations = parentPattern_p.getEOperations();
    for (EOperation operation : operations) {
      result = getMethodName().equals(operation.getName());
      // Stop at first result.
      if (result) {
        break;
      }
    }
    // If this fails, go one level up (parent's parent).
    if (!result) {
      EList<EClass> superTypes = parentPattern_p.getESuperTypes();
      // There should be only one parent.
      // Anyway go for the full list.
      for (EClass superType : superTypes) {
        result = (superType instanceof Pattern) && computeOverriding((Pattern) superType);
        // Stop at first result.
        if (result) {
          break;
        }
      }
    }
    return result;
  }

  /**
   * Is handled method overriding a parents one ?
   * @return
   */
  public boolean isOverriding() {
    return _overrides;
  }

  /**
   * Get method.
   * @return
   */
  public EOperation getMethod() {
    return _method;
  }

  /**
   * Set new method name.
   * @param newName_p
   */
  public void setMethodName(String newName_p) {
    // Precondition.
    if (!isModifiable()) {
      return;
    }
    // Test new name validity.
    if ((null != newName_p) && !ICommonConstants.EMPTY_STRING.equals(newName_p.trim())) {
      String oldName = getMethodName();
      if (!newName_p.equals(oldName)) {
        if (null == _previousName) {
          _previousName = _method.getName();
        }
        // Set new name.
        _method.setName(newName_p);
        // Recompute overriding status.
        _overrides = computeOverriding(getPatternData().getParentPattern());
        // Notify content provider.
        if (null != _provider) {
          _provider.inputChanged(null, this, this);
        }
        // Notify editor.
        notifyModification();
        // Notify modification listeners.
        notifyNameChanged(oldName, newName_p);
      }
    }
  }

  /**
   * Notify name changed to modification listeners.
   * @param oldName_p
   * @param newName_p
   */
  protected void notifyNameChanged(String oldName_p, String newName_p) {
    // Create notification first.
    DefaultPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
      IPatternModificationNotification.RENAMED,
      getMethod(), 
      oldName_p, 
      newName_p
    );
    // Then send it to listeners.
    getPage().getEditor().sendNotification(notification);
  }

  /**
   * Get method name.
   * @return
   */
  public String getMethodName() {
    return _method.getName();
  }

  /**
   * Is method modifiable or not ?<br>
   * Note that the content of a method is always modifiable.
   * @return
   */
  public boolean isModifiable() {
    return _isModifiable;
  }

  /**
   * Is given method handled by current handler ?
   * @param method_p
   * @return
   */
  public boolean isHandlerFor(EOperation method_p) {
    return getMethod().equals(method_p);
  }

  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj_p) {
    return (obj_p instanceof InternalMethodHandler) && ((InternalMethodHandler) obj_p).isHandlerFor(getMethod());
  }

  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return getMethod().hashCode();
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return getMethodName() + ICommonConstants.PARENTHESIS_OPEN_CHARACTER + ICommonConstants.PARENTHESIS_CLOSE_CHARACTER;
  }
  
}
