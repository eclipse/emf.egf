/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.extension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.portfolio.genchain.Messages;
import org.eclipse.egf.portfolio.genchain.generationChain.DocumentationGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

/**
 * @author Thomas Guiu
 * 
 */
public class DefaultEmfDocumentationExtension extends ExtensionHelper {

    private static final List<String> CONFLICT_LIST = Arrays.asList(new String[] { "sample.extension" });

    public List<String> getConflictingExtensions() {
        return CONFLICT_LIST;
    }

    @Override
    public String getLabel() {

        return Messages.emfDocumentation_extension_label;
    }

    @Override
    protected void computeDefaultProperties(Map<String, String> context) {
        final String project = context.get(CONTEXT_PROJECT_NAME);
        properties.put(GenerationChainPackage.eINSTANCE.getDocumentationGeneration_OutputDirectoryPath(), "output");
        properties.put(GenerationChainPackage.eINSTANCE.getDocumentationGeneration_PluginName(), project + ".doc");
    };

    @Override
    public EcoreElement createEcoreElement(Map<String, String> properties) {
        DocumentationGeneration element = GenerationChainFactory.eINSTANCE.createDocumentationGeneration();
        String modelPath = properties.get(MODEL_PATH);
        element.setModelPath(modelPath);

        String out = properties.get(GenerationChainPackage.eINSTANCE.getDocumentationGeneration_OutputDirectoryPath().getName());
        element.setOutputDirectoryPath(out);

        String plugin = properties.get(GenerationChainPackage.eINSTANCE.getDocumentationGeneration_PluginName().getName());
        element.setPluginName(plugin);

        return element;
    }

}
