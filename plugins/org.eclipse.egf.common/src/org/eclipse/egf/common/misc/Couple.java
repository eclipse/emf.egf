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
package org.eclipse.egf.common.misc;

import org.eclipse.egf.common.constant.ICommonConstants;

/**
 * Key, value object.
 * @author brocard
 */
public class Couple<K, V> implements Cloneable {
  
  // Key reference.
  private K _key;
  
  // Value reference.
  private V _value;

  /**
   * Constructor.
   * @param key_p
   * @param value_p
   */
  public Couple(K key_p, V value_p) {
    _key = key_p;
    _value = value_p;
  }

  /**
   * Get key.
   * @return K
   */
  public K getKey() {
    return _key;
  }

  /**
   * Get value.
   * @return V
   */
  public V getValue() {
    return _value;
  }

  /**
   * Set key with given value.
   * @param key_p key to set. void
   */
  public void setKey(K key_p) {
    _key = key_p;
  }

  /**
   * Set value with given value.
   * @param value_p the value to set
   */
  public void setValue(V value_p) {
    _value = value_p;
  }

  /**
   * @see java.lang.Object#clone()
   */
  @SuppressWarnings("unchecked")
  @Override
  public Couple<K, V> clone() {
    try {
      return (Couple<K, V>) super.clone();
    } catch (CloneNotSupportedException exception_p) {
      return null;
    }
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    String keyString =  _key != null ? _key.toString() : ICommonConstants.EMPTY_STRING;
    String valueString = _value != null ? _value.toString() : ICommonConstants.EMPTY_STRING;
    return new StringBuffer(keyString)
      .append(ICommonConstants.PARENTHESIS_OPEN_CHARACTER)
      .append(valueString)
      .append(ICommonConstants.PARENTHESIS_CLOSE_CHARACTER)
      .toString();
  }
  
}
