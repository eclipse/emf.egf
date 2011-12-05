/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.eclipse.build;

import java.util.Iterator;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Item;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Property;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildLocation;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Matthieu Helleboid
 * 
 */
public class GenerationHelper {
    
    public boolean hasBinaryBuildLocation(EObject eObject) {
        return containsClass(eObject, BuildstepPackage.eINSTANCE.getBinaryBuildLocation());
    }
    
    public boolean hasTargetPlatformBuildLocation(EObject eObject) {
        return containsClass(eObject, BuildstepPackage.eINSTANCE.getTargetPlatformBuildLocation());
    }

    public boolean hasRunningPlatformBuildLocation(EObject eObject) {
        return containsClass(eObject, BuildstepPackage.eINSTANCE.getRunningPlatformBuildLocation());
    }

    public boolean hasInstallStepBuildLocation(EObject eObject) {
        return containsClass(eObject, BuildstepPackage.eINSTANCE.getInstallStepBuildLocation());
    }

    private boolean containsClass(EObject eObject, EClass eClass) {
        TreeIterator<EObject> eAllContents = eObject.eAllContents();
        while (eAllContents.hasNext()) {
            EClass currentEClass = eAllContents.next().eClass();
            if (eClass.equals(currentEClass) || currentEClass.getESuperTypes().contains(eClass))
                return true;
        }
        return false;
    }

    public Job getNextChainJob(Job job) {
        Chain chain = (Chain) job.eContainer();
        if (chain == null)
            return null;
        EList<EObject> eContents = chain.eContents();
        for (int i = eContents.indexOf(job) + 1; i < eContents.size(); i++) {
            EObject next = eContents.get(i);
            if (next instanceof Job) {
                Job nextJob = (Job) next;
                if (nextJob.isEnabled())
                    return nextJob;
            }
        }
        return null;
    }

    public String getJobName(PatternContext context, Job job) {
        boolean prefixJobNameWithChainName = (Boolean) context.getValue("prefixJobNameWithChainName"); //$NON-NLS-1$
        Chain chain = (Chain) job.eContainer();
        if (prefixJobNameWithChainName && chain != null)
            return chain.getName() + "_" + job.getName();
        else
            return job.getName();
    }

    public String generateJobStepsString(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job, char separator) {
        StringBuffer buffer = new StringBuffer("init");
        Iterator<EObject> iterator = job.eContents().iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next instanceof Step) {
                Step step = (Step) next;
                if (buffer.length() > 0)
                    buffer.append(separator);
                buffer.append(getIdOrPositionString(step));
            }
        }
        return buffer.toString();
    }

    public String getStringIfNotNull(String input) {
        if (input == null)
            return ""; //$NON-NLS-1$
        return input;
    }

    public String getPatternString(BuildLocation buildLocation) {
        String patternString = buildLocation.getPattern();
        if (patternString == null)
            return ""; //$NON-NLS-1$
        patternString = patternString.replaceAll("\\.", "\\\\.");
        patternString = patternString.replaceAll("\\?", ".");
        patternString = patternString.replaceAll("\\*", ".*");
        return "pattern=\"^" + patternString + "\""; //$NON-NLS-1$ //$NON-NLS-2$
    }

    private int getPositionInParent(EObject eObject, EClass eClass) {
        int result = 0;
        for (EObject object : eObject.eContainer().eContents()) {
            if (object.eClass().equals(eClass) || object.eClass().getEAllSuperTypes().contains(eClass))
                result++;
            if (object == eObject)
                return result;
        }
        return -1;
    }

    public String getIdOrPositionString(Step step) {
        if (step.getId() != null) 
            return step.getId().replace(' ', '_');
        return "step" + getPositionInParent(step, BuildcorePackage.eINSTANCE.getStep());
    }

    public String getIdOrPositionString(BuildLocation buildLocation) {
        return getIdOrPositionString(buildLocation.getBuildStep()) + "location" + getPositionInParent(buildLocation, BuildstepPackage.eINSTANCE.getBuildLocation());
    }

    public String replaceProperties(EObject eObject, String input) {
        if (input == null)
            return null;
        
        while (eObject != null) {
            if (eObject instanceof Item) {
                Item item = (Item) eObject;
                for (Property property : item.getProperties()) {
                    String propertyExpression = "${" + property.getKey() + "}";
                    if (input.contains(propertyExpression))
                        input = input.replace(propertyExpression, property.getValue());
                }
            }
            eObject = eObject.eContainer();
        }
        return input;
    }
   
    // Copied from org.eclipse.buckminster.pde.tasks.SourceFeatureCreator
    private static final String FEATURE_SUFFIX = ".feature"; //$NON-NLS-1$
    private static final String SOURCE_SUFFIX = ".source"; //$NON-NLS-1$
    public String createSourceFeatureId(String originalId) {
        StringBuilder sourceIdBld = new StringBuilder();
        if (originalId.endsWith(FEATURE_SUFFIX)) {
            sourceIdBld.append(originalId, 0, originalId.length() - FEATURE_SUFFIX.length());
            sourceIdBld.append(SOURCE_SUFFIX);
            sourceIdBld.append(FEATURE_SUFFIX);
        } else {
            sourceIdBld.append(originalId);
            sourceIdBld.append(SOURCE_SUFFIX);
        }
        return sourceIdBld.toString();
    }

}
