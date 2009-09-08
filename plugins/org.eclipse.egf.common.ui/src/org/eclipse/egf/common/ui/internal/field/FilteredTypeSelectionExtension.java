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
package org.eclipse.egf.common.ui.internal.field;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ClassLoadingHelper;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension;
import org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;


/**
 * Filter end-user selection in a {@link FilteredTypesSelectionDialog} according to a Java type.
 * @author fournier
 * @deprecated
 */
public class FilteredTypeSelectionExtension extends TypeSelectionExtension {
  
  /**
   * Log4j reference logger.
   */
  protected static final Logger __logger = Logger.getLogger(FilteredTypeSelectionExtension.class.getPackage().getName());
  
  /**
   * Classloader that is able to load end-user class selection.
   */
  protected ClassLoader _classLoader;
  
  /**
   * Class use to filter end-user selection.
   */
  protected Class<?> _classTypeFilter;

  /**
   * Constructor.
   * @param classTypeFilter_p
   */
  public FilteredTypeSelectionExtension(ClassLoader classLoader_p, Class<?> classTypeFilter_p) {
    _classLoader = classLoader_p;
    _classTypeFilter = classTypeFilter_p;
  }

  /**
   * @see org.eclipse.jdt.ui.dialogs.TypeSelectionExtension#getFilterExtension()
   */
  @Override
  public ITypeInfoFilterExtension getFilterExtension() {
    return new ITypeInfoFilterExtension() {
      /**
       * @see org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension#select(org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor)
       */
      public boolean select(ITypeInfoRequestor typeInfoRequestor_p) {
        boolean result = false;
        // Build the fully qualified class name.
        StringBuilder classNameBuilder = 
          new StringBuilder(
            typeInfoRequestor_p.getPackageName()
          ).append(
            ICommonConstants.DOT_CHARACTER
          ).append(
            typeInfoRequestor_p.getTypeName()
          );
        // Get the fully qualified class name.
        String className = classNameBuilder.toString();
        Object object = ClassLoadingHelper.instantiate(className, _classLoader);
        // Check if instantiated object is an instance of the filtered class type.
        if ((null != object) && _classTypeFilter.isInstance(object)) {
          // Allow the end-user to finish the dialog, its choice meets the required class type.
          result = true;
        }
        return result;
      }
    };
  }
  
}
