/**
 * <copyright>
 *
 *  Copyright (c) 2011 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.genchain.ecoretools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionFactory;
import org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsExtensionPackage;
import org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.emf.common.util.URI;

public class EcoreToolsExtension extends ExtensionHelper {
	/** Sirius representation files extension **/
	private final static String _AIRD_FILE_EXTENSION = "aird";
	
    private static final URI PATTERN = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.ecoretools/egf/ecoreToolsExtension.fcore#_Mf1nEHyqEeC0R_Dv0EljeA", false);

    @Override
    public EcoreElement createEcoreElement(Map<String, String> properties) {
        String fileName;
        final EcoreToolsGeneration ecoreToolsGeneration = EcoreToolsExtensionFactory.eINSTANCE.createEcoreToolsGeneration();
        String modelPath = properties.get(MODEL_PATH);
        if (properties.get("fileName") != null && properties.get("fileName").length() > 0) {
            fileName = properties.get("fileName");
        } else {
            fileName = modelPath.concat(_AIRD_FILE_EXTENSION);
        }
        ecoreToolsGeneration.setModelPath(modelPath);
        ecoreToolsGeneration.setFileName(fileName);
        return ecoreToolsGeneration;
    }

    @Override
    public String getLabel() {

        return "EcoreTools extension";
    }

    @Override
    public List<Substitution> getSubstitutions() {
        TargetPlatformResourceSet set = new TargetPlatformResourceSet();
        List<Substitution> substitutions = new ArrayList<Substitution>();
        final Substitution substitution = PatternFactory.eINSTANCE.createSubstitution();
        final Pattern pattern = (Pattern) set.getEObject(PATTERN, true);
        substitution.getReplacement().add(pattern);
        substitutions.add(substitution);
        return substitutions;
    }

    @Override
    protected void computeDefaultProperties(Map<String, String> context) {
        final String modelPath = context.get(CONTEXT_MODEL_NAME);
        final String projectName = context.get(CONTEXT_PROJECT_NAME);
        properties.put(EcoreToolsExtensionPackage.eINSTANCE.getEcoreToolsGeneration_FileName(), projectName + "/model/" + modelPath.concat("."+_AIRD_FILE_EXTENSION));
    }

}
