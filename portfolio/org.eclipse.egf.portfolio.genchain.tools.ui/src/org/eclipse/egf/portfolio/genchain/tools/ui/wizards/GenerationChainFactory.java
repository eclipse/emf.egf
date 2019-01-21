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

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;

/**
 * @author Thomas Guiu
 * 
 */
public class GenerationChainFactory implements ExtensionProperties {
    public static final GenerationChainFactory INSTANCE = new GenerationChainFactory();

    public void createExtension(GenerationChain container, Node containerNode, Set<Node> activeNodes) {
        final Map<String, ExtensionHelper> extensionsAsMap = ExtensionHelper.getExtensionsAsMap();
        for (Node extensionNode : containerNode.getChildren()) {
            String id = extensionNode.getProperties().get(ID);
            String modelName = getModelName(extensionNode.getProperties().get(MODEL_PATH));
            ExtensionHelper extensionHelper = extensionsAsMap.get(id);
            if (activeNodes.contains(extensionNode)) {
                Map<String, String> properties = new HashMap<String, String>();
                for (Node propertyNode : extensionNode.getChildren()) {
                    properties.put(propertyNode.getName(), propertyNode.getProperties().get(PROPERTY_VALUE));
                }
                properties.putAll(extensionNode.getProperties());
                EcoreElement leaf = extensionHelper.createEcoreElement(properties);
                leaf.setName(Messages.bind(Messages.genchain_wizard_element_name_creation, extensionNode.getName(), modelName));
                container.getElements().add(leaf);
            }
        }

    }

    public void createContainer(GenerationChain root, Node data, Set<Node> activeNodes) {

        for (Node containerNode : data.getChildren()) {
            GenerationChain container = org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainFactory.eINSTANCE.createGenerationChain();

            container.setName(containerNode.getName());
            createExtension(container, containerNode, activeNodes);
            if (!container.getElements().isEmpty())
                root.getElements().add(container);
        }
    }

    public static String getBundleName(String modelPath) {
        return modelPath.substring(1, modelPath.indexOf('/', 1));
    }

    public static String getModelName(String modelPath) {
        return modelPath.substring(modelPath.lastIndexOf('/') + 1, modelPath.lastIndexOf('.'));
    }
}
