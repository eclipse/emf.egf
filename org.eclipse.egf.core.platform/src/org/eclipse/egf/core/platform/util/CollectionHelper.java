/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.platform.util;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class CollectionHelper {

  @SuppressWarnings("unchecked")
  public static <T> T[] toArray(Collection<Object> collection, Class<T> clazz) {
    if (clazz == null || collection == null) {
      return null;
    }
    return collection.toArray((T[]) Array.newInstance(clazz, collection.size()));
  }

}
