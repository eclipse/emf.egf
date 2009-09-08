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

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension;
import org.eclipse.jdt.ui.dialogs.ITypeInfoRequestor;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;

import org.eclipse.egf.common.constant.ICommonConstants;


/**
 * Filter end-user selection in a {@link FilteredTypesSelectionDialog} according to a Java type.
 * @author Xavier Maysonnave
 */
public class FilteredJavaTypeSelectionExtension extends TypeSelectionExtension {
  
  /**
   * Log4j reference logger.
   */
  protected static final Logger __logger = Logger.getLogger(FilteredJavaTypeSelectionExtension.class.getPackage().getName()); 
    
  /**
   * classTypeFilter
   */
  protected Class<?> _classTypeFilter;
  
  /**
   * IJavaProject
   */
  protected IJavaProject _javaProject;  

  /**
   * Constructor.
   * @param classTypeFilter_p
   */
  public FilteredJavaTypeSelectionExtension(IJavaProject javaProject_p, Class<?> classTypeFilter_p) {
    Assert.isNotNull(javaProject_p);
    Assert.isNotNull(classTypeFilter_p);    
    _javaProject = javaProject_p;
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
        // Build the fully qualified class name.
        StringBuilder fqn = 
          new StringBuilder(
            typeInfoRequestor_p.getPackageName()
          ).append(
            ICommonConstants.DOT_CHARACTER
          ).append(
            typeInfoRequestor_p.getTypeName()
          );
        try {
          IType type = _javaProject.findType(fqn.toString());
          if (type != null) {
            for (String i : type.getSuperInterfaceNames()) {
              if (_classTypeFilter.getName().equals(i)) {
                return true;
              }
            }
          }
        } catch (JavaModelException jme) {
          return true;
        }
        return false;
      }           
    };
        
  }
  
  public static boolean implementInterface(Class<?> clazz, String interfaceName) {
    if (clazz == null || interfaceName == null) {
      return false;
    }
    for (Class<?> interfaces : clazz.getInterfaces()) {
      if (interfaceName.equals(interfaces.getName())) {
        return true;
      }
    }
    return implementInterface(clazz.getSuperclass(), interfaceName);
  }  
  
}
