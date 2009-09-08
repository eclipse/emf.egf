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
package org.eclipse.egf.model.contract.type;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.helper.ClassLoadingHelper;
import org.osgi.framework.Bundle;


/**
 * Default class type holder.<br>
 * Must be subclassed so as to provide the expected type.<br>
 * The expected type is the one used to check class name value (as string representation) in the method{@link #isValidType(String)}
 * @author brocard
 */
public abstract class ClassTypeHolder extends AbstractTypeHolder {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(ClassTypeHolder.class.getPackage().getName());
  
  /**
   * Plug-in id value.
   */
  private String _pluginId;
  
  /**
   * Potential class loader used to load class name.
   */
  private ClassLoader _classLoader;

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#setPluginId(java.lang.String)
   */
  public void setPluginId(String pluginId_p) {
    _pluginId = pluginId_p;
  }

  /**
   * Set the class loader.
   * @param classLoader_p the classLoader to set
   */
  public void setClassLoader(ClassLoader classLoader_p) {
    _classLoader = classLoader_p;
  }

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#getValue(java.lang.String)
   */
  public Object getValue(String value_p) {
    Object result = null;
    // Precondition.
    if (null == value_p) {
      return result;
    }
    // Loading the class...
    result = loadClass(value_p);
    return result;
  }

  /**
   * Load a class from given class name.<br>
   * Class loading is delegated either to the target platform if plug-in id is provided or to provided class loader if any.
   * @param className_p
   * @return
   */
  private Object loadClass(String className_p) {
    Object result = null;
    Class<?> class_ = null;
    // Load the class from the target platform if the plug-in id is provided.
    if (null != _pluginId) {
      class_ = loadClassFromRuntimePlatform(className_p);
    }
    // Else load the class from class loader if any.
    else if (null != _classLoader) {
      class_ = ClassLoadingHelper.loadClass(className_p, _classLoader);
    }
    // If the class for specified class name was successfully loaded, instantiate it.
    if (null != class_) {
      try {
        result = class_.newInstance();
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("ClassTypeHolder.loadClass(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
    return result;
  }

  /**
   * Load a class from the target platform for given class name.<br>
   * Class loading is delegated to the retrieved bundle from the plug-in id.
   * @param className_p
   * @return
   */
  private Class<?> loadClassFromRuntimePlatform(String className_p) {
    Class<?> result = null;
    // Get the bundle from the plug-in id.
    Bundle bundle = Platform.getBundle(_pluginId);
    if (null != bundle) {
      // Load given class from its fully qualified class name.
      try {
        result = bundle.loadClass(className_p);
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("ClassTypeHolder.loadClassFromRuntimePlatform(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#isJava()
   */
  public boolean isJava() {
    return true;
  }

  /**
   * @see org.eclipse.egf.model.contract.type.ITypeHolder#isValid(java.lang.String)
   */
  public boolean isValid(String value_p) {
    // Get the class from given string representation.
    Object class_ = getValue(value_p);
    // Is the class correctly instantiated ?
    boolean result = (null != class_);
    if (result) {
      // Is type compatible with expected one ?
      result = isValidType(class_);
    }
    return result;
  }

  /**
   * Is given class instance valid ?
   * @param classInstance_p
   * @return true means valid; false otherwise.
   * @see #getExpectedType()
   */
  protected boolean isValidType(Object classInstance_p) {
    boolean result = false;
    // Check given object is an instance the returned expected type.
    Class<?> expectedType = getExpectedType();
    if (expectedType.isInstance(classInstance_p)) {
      result = true;
    }
    return result;
  }

  /**
   * Get the expected java type.<br>
   * The returned type must have a default constructor.
   * @return The expected Java class tested in {@link #isValidType(Object)}.
   */
  public abstract Class<?> getExpectedType();
  
}
