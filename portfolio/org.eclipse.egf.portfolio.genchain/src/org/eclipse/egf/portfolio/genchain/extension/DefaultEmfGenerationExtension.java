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

import org.eclipse.egf.portfolio.genchain.Messages;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;
import org.eclipse.egf.portfolio.genchain.utils.StringUtils;

/**
 * @author Thomas Guiu
 * 
 */
public class DefaultEmfGenerationExtension extends ExtensionHelper {

	@Override
	public String getLabel() {

		return Messages.emfGeneration_extension_label;
	}

	protected EmfGeneration doCreateEcoreElement() {
		return GenerationChainFactory.eINSTANCE.createEmfGeneration();
	}

	@Override
	public EcoreElement createEcoreElement(Map<String, String> properties) {
		EmfGeneration element = doCreateEcoreElement();
		String modelPath = properties.get(MODEL_PATH);
		element.setModelPath(modelPath);

		String base = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_BasePackage().getName());
		element.setBasePackage(base);

		String plugin = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_PluginName().getName());
		element.setPluginName(plugin);

		String edit = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateEdit().getName());
		element.setGenerateEdit(Boolean.parseBoolean(edit));

		String editor = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateEditor().getName());
		element.setGenerateEditor(Boolean.parseBoolean(editor));

		String model = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateModel().getName());
		element.setGenerateModel(Boolean.parseBoolean(model));

		String test = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateTest().getName());
		element.setGenerateTest(Boolean.parseBoolean(test));
		
		String javadoc = properties.get(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateJavadoc().getName());
		element.setGenerateJavadoc(Boolean.parseBoolean(javadoc));

		return element;
	}

	@Override
	protected void computeDefaultProperties(Map<String, String> context) {
		final String project = context.get(CONTEXT_PROJECT_NAME);
		final String modelName = context.get(CONTEXT_MODEL_NAME);
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_BasePackage(), project);
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateEdit(), "true");
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateEditor(), "false");
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateModel(), "true");
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateTest(), "false");
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_GenerateJavadoc(), "false");
		properties.put(GenerationChainPackage.eINSTANCE.getEmfGeneration_PluginName(), StringUtils.format1(project + '.' + modelName));
	};
}
