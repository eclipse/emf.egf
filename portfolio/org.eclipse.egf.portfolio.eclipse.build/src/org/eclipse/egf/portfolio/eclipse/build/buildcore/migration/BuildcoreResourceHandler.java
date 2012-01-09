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

package org.eclipse.egf.portfolio.eclipse.build.buildcore.migration;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.egf.portfolio.eclipse.build.GenerationHelper;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.CLEAN_TYPE;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.BasicResourceHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * @author Matthieu Helleboid
 * 
 */
@SuppressWarnings("rawtypes")
public class BuildcoreResourceHandler extends BasicResourceHandler {
	
	@Override
	public void postLoad(XMLResource resource, InputStream inputStream,
			Map<?, ?> options) {
		
		final Map extMap = resource.getEObjectToExtensionMap();
		for (Iterator itr = extMap.entrySet().iterator(); itr.hasNext();) {
			Map.Entry entry = (Map.Entry) itr.next();
			EObject key = (EObject) entry.getKey();
			AnyType value = (AnyType) entry.getValue();
			handleUnknownData(key, value);
		}
	}

	private void handleUnknownData(EObject eObj, AnyType unknownData) {
		handleUnknownFeatures(eObj, unknownData.getMixed());
		handleUnknownFeatures(eObj, unknownData.getAnyAttribute());
	}

	private void handleUnknownFeatures(EObject owner, FeatureMap featureMap) {
		for (Iterator iter = featureMap.iterator(); iter.hasNext();) {
			FeatureMap.Entry entry = (FeatureMap.Entry) iter.next();
			EStructuralFeature structuralFeature = entry
					.getEStructuralFeature();
			if (handleUnknownFeature(owner, structuralFeature, entry.getValue())) {
				iter.remove();
			}
		}
	}

	private boolean handleUnknownFeature(EObject owner,
			EStructuralFeature structuralFeature, Object value) {
		if ("activities".equals(structuralFeature.getName()) && owner instanceof EgfStep) {
			//replace activities EString by EGFActivity
			EgfStep egfStep = (EgfStep) owner;
			String uri = (String) ((AnyType) value).getMixed().get(0).getValue();

			EgfActivity egfActivity = BuildstepFactory.eINSTANCE.createEgfActivity();
			egfActivity.setUri(uri);
			egfStep.getEgfActivities().add(egfActivity);

			return true;
		}
		
		if ("cleanBeforeBuild".equals(structuralFeature.getName()) && owner instanceof BuildStep) {
			CLEAN_TYPE cleanType = CLEAN_TYPE.get((String) value);
			if (cleanType == CLEAN_TYPE.NOTHING) {
				//No need for a clean step
				return true;
			}

			BuildStep buildStep = (BuildStep) owner;
			Job job = new GenerationHelper().getJob(buildStep);
			
			CleanStep cleanStep = BuildstepFactory.eINSTANCE.createCleanStep();
			cleanStep.setType(cleanType);
			
			int indexOf = job.getSteps().indexOf(buildStep);
			job.getSteps().add(indexOf, cleanStep);
			
			return true;
		}
		
		return false;
	}
}
