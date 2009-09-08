/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.generator.java.helper;

import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.constant.ICommonConstants;


/**
 * Generated file names helper.
 * @author Guillaume Brocard
 */
public class FileNameHelper {
  
  /**
   * Get generation model path from ecore one.<br>
   * @param ecorePath_p May be absolute or relative path.
   * @return null if given ecore path is null.
   */
  public static String getGenModelPath(IPath ecorePath_p) {
    String result = null;
    // Precondition.
    if (null == ecorePath_p) {
      return result;
    }
    // Switch from ecore path to genModel path.
    result = ecorePath_p.removeFileExtension().addFileExtension(ICommonConstants.GENMODEL_FILE_EXTENSION).toString();
    return result;
  }
  
}
