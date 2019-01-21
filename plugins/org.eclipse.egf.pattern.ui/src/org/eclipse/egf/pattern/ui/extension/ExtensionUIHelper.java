/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.extension;

import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class ExtensionUIHelper {

    public static Image getImage(PatternExtension pe) {
        return ExtendedImageRegistry.getInstance().getImage(pe.getImageURL());
    }

}
