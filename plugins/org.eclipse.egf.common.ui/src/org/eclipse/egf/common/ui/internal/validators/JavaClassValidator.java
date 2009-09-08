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
package org.eclipse.egf.common.ui.internal.validators;

import org.osgi.framework.Bundle;

import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.ClassLoadingHelper;
import org.eclipse.egf.common.ui.toolkit.validators.NotEmptyStringValidator;


/**
 * Implements a validator that checks if given fully qualified name is able to instantiated.
 * @author Guillaume Brocard
 */
public class JavaClassValidator extends NotEmptyStringValidator {
  
  /**
   * Class loader to check to if given class is not able to instantiated.
   */
  private ClassLoader _classLoader;
  
  /**
   * Bundle to check to if given class is not able to instantiated.
   */
  private Bundle _bundle;  
  
  /**
   * Expected class to check against.
   */
  private Class<?> _expectedClassType;

  /**
   * Constructor.
   * @param errorMessage_p
   * @param classLoader_p
   * @param bundle_p 
   * @param expectedClassType_p
   */
  public JavaClassValidator(
    ClassLoader classLoader_p,
    Bundle bundle_p,
    Class<?> expectedClassType_p
  ) {
    super(Messages.JavaClassValidator_Error_Message_EMPTY_CLASS);
    _classLoader = classLoader_p;
    _bundle = bundle_p;
    _expectedClassType = expectedClassType_p;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.validators.IValidator#isValid(java.lang.Object)
   */
  @Override
  public String isValid(Object value_p) {
    String errorMessage = super.isValid(value_p);
    if (errorMessage == null) {
      // Check given class is able to instantiated.
      Object object = null;
      if (_classLoader != null) {
        object = ClassLoadingHelper.instantiate((String) value_p, _classLoader);
      } else if (_bundle != null) {
        object = BundleHelper.instantiate((String) value_p, _bundle);
      }
      // Check if instantiated object is an instance of the expected class type.
      if (object == null) {
        errorMessage = Messages.JavaClassValidator_Error_Message_UNABLE_TO_LOAD + value_p;
      } else {
        if (_expectedClassType.isInstance(object) == false) {
          errorMessage = value_p + Messages.JavaClassValidator_Error_Message_INSTANCE_OF + _expectedClassType.getName();
        }
      }
    }
    return errorMessage;
  }

  /**
   * Set the expected class type to given one.
   * @param expectedClassType_p the expectedClassType to set
   */
  public void setExpectedClassType(Class<?> expectedClassType_p) {
    _expectedClassType = expectedClassType_p;
  }
  
}