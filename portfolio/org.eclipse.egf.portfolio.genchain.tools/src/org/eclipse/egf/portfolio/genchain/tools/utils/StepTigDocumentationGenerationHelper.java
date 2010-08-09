/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.utils;

import org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration;

/**
 * 
 * @author Thomas Guiu
 */
public class StepTigDocumentationGenerationHelper {
    public static String getGenerationPlugin(DocumentationGeneration step) {

        String path = step.getOutputDirectoryPath();
        int index = path.indexOf('/');
        if (index >= 0)
            return path.substring(0, index);
        return path;
    }
}
