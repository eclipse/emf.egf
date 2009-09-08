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
package org.eclipse.egf.common.helper;

/**
 * This helper provides high-level services to deal with class loading.
 * @author fournier
 */
public class ClassLoadingHelper {
  
  /**
   * Instantiate given fully qualified class name using given class loader.
   * @param fullyQualifiedClassName_p the class name with its package name (dot separated syntax).
   * @param classLoader_p class loader which can load given class name.
   * @return an instance of given class name or null if instantiation failed.
   */
  public static Object instantiate(String fullyQualifiedClassName_p, ClassLoader classLoader_p) {
    Object result = null;
    // Precondition.
    if (classLoader_p == null) {
      return result;
    }
    try {    
      // Try loading a class according to the class name.
      Class<?> class_ = loadClass(fullyQualifiedClassName_p, classLoader_p);
      // Try instantiating an object of loaded class.
      if (null != class_) {
        result = class_.newInstance();
      }
    } catch (Throwable exception_p) {
      // Failed silently.
    }
    return result;
  }

  /**
   * Load given fully qualified class name using given class loader.
   * @param fullyQualifiedClassName_p the class name with its package name (dot separated syntax).
   * @param classLoader_p class loader which can load given class name.
   * @return loaded Class according to given class name or null if loading failed.
   */
  public static Class<?> loadClass(String fullyQualifiedClassName_p, ClassLoader classLoader_p) {
    Class<?> class_ = null;
    // Precondition.
    if (classLoader_p == null) {
      return class_;
    }
    try {       
      // Try loading a class according to the class name.
      class_ = classLoader_p.loadClass(fullyQualifiedClassName_p);
    } catch (Throwable exception_p) {
      // Failed silently.
    }
    return class_;
  }
  
}