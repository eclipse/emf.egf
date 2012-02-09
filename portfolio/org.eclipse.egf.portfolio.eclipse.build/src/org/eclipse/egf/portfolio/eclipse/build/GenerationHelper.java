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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Item;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.AntParameter;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.FileStep;
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
                return (Job) next;
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

    public String getNameOrGeneratedIdString(EObject eObject) {
        StringBuilder result = new StringBuilder();
        
        while (eObject != null) {
            EObject eContainer = eObject.eContainer();
            
            String nameOrGeneratedId = null;
            if (eObject instanceof Step) {
				nameOrGeneratedId = ((Step) eObject).getName();
			}
            if (eObject instanceof Item) {
            	nameOrGeneratedId = ((Item) eObject).getName();
            }
            
            if (nameOrGeneratedId == null || nameOrGeneratedId.trim().length() == 0) {
            	if (eContainer instanceof AbstractStepContainer) {
					AbstractStepContainer abstractStepContainer = (AbstractStepContainer) eContainer;
					nameOrGeneratedId = Integer.toString(abstractStepContainer.getSteps().indexOf(eObject) + 1);
				} else if (eContainer != null) { 
					nameOrGeneratedId = Integer.toString(eContainer.eContents().indexOf(eObject) + 1);
				}

            	nameOrGeneratedId = eObject.eClass().getName() + "_" + nameOrGeneratedId;
            }
            
            if (nameOrGeneratedId != null) {
            	if (result.length() > 0)
            		result.insert(0, '_');
            	result.insert(0, nameOrGeneratedId.replace(' ', '_').replace('\\', '_').replace('/', '_'));
            }

            eObject = eContainer;
            
            if (eObject instanceof Job || eObject instanceof Chain) {
            	eObject = null; //stop here
            }
        }
        
        return result.toString();
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

    public Job getJob(EObject eObject) {
        EObject container = eObject.eContainer();
        if (container instanceof Job) {
            return (Job) container;
        } else if (container != null) {
            return getJob(container);
        } else {
            return null;
        }
    }
    
    public String getPublishPath(PatternContext context, EObject targetEObject, EObject sourceEObject) {
        if (getJob(sourceEObject) == getJob(targetEObject)) 
            return "${publish}/";
        //if the source and the target object are not part of the same job
        //then we try to provide a valid relative path (but won't work on a hudson slave)
        return "${build.root}/../../" + getJobName(context, getJob(targetEObject)) + "/workspace/result/publish/";
    }
    
    public List<Step> getAllSteps(Job job) {
        List<Step> result = new ArrayList<Step>();
        
        TreeIterator<EObject> iterator = job.eAllContents();
        while (iterator.hasNext()) {
            EObject eObject = iterator.next();
            if (eObject instanceof Step) {
                result.add((Step) eObject);
            }
        }
        
        return result ;
    }
    
    public String getAdditionalParametersString(FileStep fileStep) {
        StringBuilder builder = new StringBuilder();
        for (AntParameter antParameter : fileStep.getAdditionalParameters()) {
            if (builder.length() > 0)
                builder.append(' ');
            builder.append(antParameter.getKey());
            builder.append("=\"");
            builder.append(antParameter.getValue());
            builder.append("\"");
        }
        return builder.toString();
    }
}
