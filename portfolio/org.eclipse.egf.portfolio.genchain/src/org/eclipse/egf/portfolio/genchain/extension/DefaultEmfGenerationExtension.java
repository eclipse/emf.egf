/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.extension;

import java.util.Map;

import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory;

/**
 * @author Thomas Guiu
 * 
 */
public class DefaultEmfGenerationExtension extends ExtensionHelper {

    @Override
    public String getLabel() {

        return "Emf Generation";
    }

    @Override
    public EcoreElement createEcoreElement(Map<String, String> properties) {
        EmfGeneration element = GenerationChainFactory.eINSTANCE.createEmfGeneration();
        String modelPath = properties.get(MODEL_PATH);
        element.setModelPath(modelPath);
        return element;
    }

}
