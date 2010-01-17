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
