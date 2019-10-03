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
package org.eclipse.egf.model.ftask.helper;

import org.eclipse.egf.model.EGFFtaskPlugin;

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
        if (EGFFtaskPlugin.getTaskNatureRegistry().getKinds().contains(kind.trim()) == false) {
            return false;
        }
        return true;
    }

}
