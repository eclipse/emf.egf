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
package org.eclipse.egf.core.ui.internal.validators;

import java.util.Iterator;

import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternViewpoint;


/**
 * Implements a validator that checks {@link AbstractPatternElement} valid state.
 * @author Guillaume Brocard
 */
public class PatternElementValidator extends NotEmptyStringValidator {
  /**
   * The parent.
   */
  private NamedModelElementWithId _parent;
  /**
   * Pattern that the validation is performed against.
   */
  private AbstractPatternElement _pattern;

  /**
   * Constructor.
   * @param patternElement_p
   * @param errorMessage_p
   */
  public PatternElementValidator(NamedModelElementWithId parent_p, AbstractPatternElement pattern_p, String errorMessage_p) {
    super(errorMessage_p);
    _parent = parent_p;
    _pattern = pattern_p;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator#isValid(java.lang.Object)
   */
  @Override
  public String isValid(Object value_p) {
    String errorMessage = super.isValid(value_p);
    if (null != errorMessage) {
      return errorMessage;
    }
    // Check: the pattern element's parent does not have the same name.
    String name = (String) value_p;
    if (null != _parent) {
      // Check sibling elements: they do not have the same name.
      Iterator<? extends AbstractPatternElement> siblingElements = null;
      // Parent is either a ParentLibrary or the PatternViewpoint.
      if (_parent instanceof PatternLibrary) {
        siblingElements = ((PatternLibrary) _parent).getPatternElements().iterator();
      } else if (_parent instanceof PatternViewpoint) {
        siblingElements = ((PatternViewpoint) _parent).getLibraries().iterator();
      }
      if (null != siblingElements) {
        // check no sibling element of the same type do not have the same name.
        while (siblingElements.hasNext() && (null == errorMessage)) {
          AbstractPatternElement currentPattern = siblingElements.next();
          if ((_pattern != currentPattern) && (_pattern.getClass() == currentPattern.getClass()) && (currentPattern.getName().equals(name))) {
            errorMessage = formatErrorMessage(name, Messages.PatternElementValidator_Sibling_EndMessage);
          }
        }
      }
    }
    return errorMessage;
  }

  /**
   * Format error message with given parameters.
   * @param alreadyUsedName_p the already used name value.
   * @param messageEndPart_p the message end part i.e who is already using the same name value.
   * @return
   */
  private String formatErrorMessage(String alreadyUsedName_p, String messageEndPart_p) {
    String errorMessage = Messages.PatternElementValidator_Name_Already_Used_ErrorMessage;
    return MessageFormatHelper.formatMessage(errorMessage, new String[] { alreadyUsedName_p, messageEndPart_p });
  }
}
