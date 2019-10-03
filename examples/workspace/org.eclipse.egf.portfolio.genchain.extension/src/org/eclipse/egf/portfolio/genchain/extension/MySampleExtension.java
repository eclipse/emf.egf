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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement;
import org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleExtensionFactory;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.emf.common.util.URI;

/**
 * @author Thomas Guiu
 * 
 */
public class MySampleExtension extends ExtensionHelper {
    private static final URI PATTERN = URIHelper.createPlatformPluginURI("org.eclipse.egf.portfolio.genchain.extension/egf/sampleExtension.fcore#_fMAHcKYjEd-c68Bv_MO43Q", false);

    @Override
    public String getLabel() {

        return "Sample extension";
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
    public EcoreElement createEcoreElement(Map<String, String> properties) {

        final SampleElement sampleElement = SampleExtensionFactory.eINSTANCE.createSampleElement();
        String modelPath = properties.get(MODEL_PATH);
        sampleElement.setModelPath(modelPath);
        return sampleElement;
    }

}
