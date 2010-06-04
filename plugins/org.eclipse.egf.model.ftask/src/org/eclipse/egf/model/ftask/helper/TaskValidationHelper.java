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
package org.eclipse.egf.model.ftask.helper;

import org.eclipse.egf.model.ftask.task.TaskNature;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TaskValidationHelper {

  private TaskValidationHelper() {
    // Prevent Instantiation
  }

  public static boolean isValidKind(String kind) {
    if (kind == null || kind.trim().length() == 0) {
      return false;
    }
    if (TaskNature.REGISTRY.getKinds().contains(kind.trim()) == false) {
      return false;
    }
    return true;
  }

}
