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
		Pattern pattern = (Pattern) set.getEObject(PATTERN_CDO, true);
		substitution.getReplacement().add(pattern);
		return substitutions;
	}

	public EcoreElement createEcoreElement(Map<String, String> properties) {
		CdoGeneration elt = CdoExtensionFactory.eINSTANCE.createCdoGeneration();
		String modelPath = properties.get(MODEL_PATH);
		elt.setModelPath(modelPath);
		return elt;
	};

	@Override
	protected void computeDefaultProperties(Map<String, String> context) {
		properties.put(CdoExtensionPackage.eINSTANCE.getCdoGeneration_CdoSuffix(), "cdo");
		properties.put(CdoExtensionPackage.eINSTANCE.getCdoGeneration_FeatureDelegation(), "Dynamic");
	};

}
