/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
