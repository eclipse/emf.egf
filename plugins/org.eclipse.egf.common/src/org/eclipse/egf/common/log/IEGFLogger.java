/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.log;

import org.eclipse.core.runtime.IStatus;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IEGFLogger {

  public void logError(String line);

  public void logError(String line, int nesting);

  public void logStatus(IStatus status);

  public void logStatus(IStatus status, int nesting);

  public void logInfo(String line);

  public void logInfo(String line, int nesting);

  public void logWarning(String line);

  public void logWarning(String line, int nesting);

}
