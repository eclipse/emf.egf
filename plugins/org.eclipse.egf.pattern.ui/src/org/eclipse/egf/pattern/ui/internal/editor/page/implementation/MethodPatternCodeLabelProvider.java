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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.editor.page.util.DisplayHelper;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jface.viewers.LabelProvider;


/**
 * @author Guillaume Brocard
 */
public class MethodPatternCodeLabelProvider extends LabelProvider {
  /**
   * Pattern data.
   */
  private PatternData _patternData;
  /**
   * Display helper.
   */
  private DisplayHelper _displayHelper;

  /**
   * Set pattern data.
   * @param patternData_p
   */
  public void setPatternData(PatternData patternData_p) {
    _patternData = patternData_p;
  }

  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
   */
  @Override
  public String getText(Object element_p) {
    String result = null;
    Couple<String, String> action = getAction(element_p);
    String actionType = action.getKey();
    if (PatternConstants.PC_TAG_CALL.equals(actionType)) {
      result =
               MessageFormatHelper.formatMessage(Messages.MethodPatternCodeLabelProvider_PatternCode_CALL_Message,
                                                 new Object[] { getMethodeNameFromReference(action.getValue()) });
    } else if (PatternConstants.PC_TAG_PATTERN.equals(actionType)) {
      result =
               MessageFormatHelper.formatMessage(Messages.MethodPatternCodeLabelProvider_PatternCode_PATTERN_Message,
                                                 new Object[] { getPatternNameFromFullId(action.getValue()) });
    } else if (PatternConstants.PC_TAG_READ.equals(actionType)) {
      result =
               MessageFormatHelper.formatMessage(Messages.MethodPatternCodeLabelProvider_PatternCode_READ_Message,
                                                 new Object[] { getMethodNameFromTemplateRelativePath(action.getValue()) });
    } else if (PatternConstants.PC_TAG_SUPER.equals(actionType)) {
      result =
               MessageFormatHelper.formatMessage(Messages.MethodPatternCodeLabelProvider_PatternCode_SUPER_CALL_Message,
                                                 new Object[] { getMethodeNameFromReference(action.getValue()) });
    }
    return result;
  }

  /**
   * Get code action (code type, parameter) from given object.
   * @param object_p
   * @return
   */
  protected static Couple<String, String> getAction(Object object_p) {
    return ((MethodActionHandler) object_p).getAction();
  }

  /**
   * Get method name from its reference in the action.
   * @param reference_p
   * @return
   */
  protected String getMethodeNameFromReference(String reference_p) {
    if (null == reference_p) {
      return ICommonConstants.EMPTY_STRING;
    }
    return reference_p;
  }

  /**
   * Get method name from template file relative path.
   * @param templateRelativePath_p
   * @return
   */
  protected String getMethodNameFromTemplateRelativePath(String templateRelativePath_p) {
    if (null == templateRelativePath_p) {
      return ICommonConstants.EMPTY_STRING;
    }
    String methodId = new Path(templateRelativePath_p).removeFileExtension().lastSegment();
    // Search method by id.
    EOperation method = null;
    if (null != methodId) {
      AnnotationHandler handler = new AnnotationHandler();
      List<EOperation> operations = _patternData.getPattern().getEAllOperations();
      for (EOperation operation : operations) {
        if (methodId.equals(handler.getUid(operation))) {
          method = operation;
          break;
        }
      }
    }
    return (null != method) ? method.getName() : methodId;
  }

  /**
   * Get pattern name from full id.
   * @param patternFullId_p
   * @return
   */
  protected String getPatternNameFromFullId(String patternFullId_p) {
    if (null == _displayHelper) {
      _displayHelper = new DisplayHelper();
    }
    return _displayHelper.getPatternOrLibraryFullName(patternFullId_p);
  }
}
