/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.domain;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Xavier Maysonnave
 * 
 */
public class DiagnosticResourceException extends WrappedException implements Resource.Diagnostic {

  private Resource _resource;

  private static final long serialVersionUID = 1L;

  public DiagnosticResourceException(Resource resource, Exception exception) {
    super(exception);
    _resource = resource;
  }

  public String getLocation() {
    return _resource.getURI() == null ? null : _resource.getURI().toString();
  }

  public int getColumn() {
    return 0;
  }

  public int getLine() {
    return 0;
  }

}
