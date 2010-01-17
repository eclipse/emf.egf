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
package org.eclipse.egf.core.producer;

/**
 * @author Xavier Maysonnave
 * 
 */
public class MissingExtensionException extends Exception {

  static final long serialVersionUID = 8310777379305723688L;

  public MissingExtensionException(String message) {
    super(message);
  }

  public MissingExtensionException(String message, Throwable t) {
    super(message, t);
  }

}
