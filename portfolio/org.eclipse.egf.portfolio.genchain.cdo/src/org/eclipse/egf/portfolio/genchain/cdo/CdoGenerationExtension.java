/**
 * <copyright>
 *
 *  Copyright (c) 2018 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.genchain.cdo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionFactory;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.emf.common.util.URI;

/**
 * @author Thomas Guiu
 * 
 */
public class CdoGenerationExtension extends ExtensionHelper {
	private static final URI PATTERN_CDO = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.cdo/egf/cdoExtension.fcore#_n-2OUPW_EeGfnK-UqqQwfQ", false);

	@Override
	public String getLabel() {
		return "CDO Emf Generation";
	}

	@Override
	public List<Substitution> getSubstitutions() {
		TargetPlatformResourceSet set = new TargetPlatformResourceSet();
		List<Substitution> substitutions = new ArrayList<Substitution>();
		final Substitution substitution = PatternFactory.eINSTANCE.createSubstitution();
		substitutions.add(substitution);
		Pattern pattern = (Pattern) set.getEObject(getCdoPattern(), true);
		substitution.getReplacement().add(pattern);
		return substitutions;
	}

	protected CdoGeneration doCreateEcoreElement() {
		return CdoExtensionFactory.eINSTANCE.createCdoGeneration();
	}

	public EcoreElement createEcoreElement(Map<String, String> properties) {
		CdoGeneration elt = doCreateEcoreElement();
		String modelPath = properties.get(MODEL_PATH);
		elt.setModelPath(modelPath);
		return elt;
	};

	@Override
	protected void computeDefaultProperties(Map<String, String> context) {
		properties.put(CdoExtensionPackage.eINSTANCE.getCdoGeneration_CdoSuffix(), "cdo");
		properties.put(CdoExtensionPackage.eINSTANCE.getCdoGeneration_FeatureDelegation(), "Dynamic");
	}

	protected URI getCdoPattern() {
		return PATTERN_CDO;
	};

}
