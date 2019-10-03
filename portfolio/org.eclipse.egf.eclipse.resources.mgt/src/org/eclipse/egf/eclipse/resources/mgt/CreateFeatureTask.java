/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.eclipse.resources.mgt;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.eclipse.resources.mgt.operation.CreateFeatureOperation;
import org.eclipse.egf.eclipse.resources.mgt.util.IFeatureConstants;

/** 
 * @author Boubekeur Zendagui
 */

public class CreateFeatureTask implements ITaskProduction{
	protected String FeatureID;
	protected String FeatureLabel;
	protected String FeatureProvider;
	protected String FeatureVersion;
	protected ArrayList<String> PluginList;
	protected ArrayList<String> IncludedFeaturesList;
	protected String descriptionUrl;
	protected String descriptionUri;
	protected String licenseUrl;
	protected String licenseUri;
	protected String copyrightUrl;
	protected String copyrightUri;
	
	protected IProject feature;
	
	@SuppressWarnings("unchecked")
	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		FeatureID = productionContext.getInputValue(IFeatureConstants.CONTRACT_FEATURE_ID, String.class);
		FeatureLabel = productionContext.getInputValue(IFeatureConstants.CONTRACT_FEATURE_LABEL, String.class);
		FeatureProvider = productionContext.getInputValue(IFeatureConstants.CONTRACT_FEATURE_PROVIDER, String.class);
		FeatureVersion = productionContext.getInputValue(IFeatureConstants.CONTRACT_FEATURE_VERSION, String.class);
		PluginList = (ArrayList<String>) productionContext.getInputValue(IFeatureConstants.CONTRACT_PLUGINS_LIST, ArrayList.class);
		IncludedFeaturesList = (ArrayList<String>) productionContext.getInputValue(IFeatureConstants.CONTRACT_INCLUDED_FEATURE, ArrayList.class);
		descriptionUrl = productionContext.getInputValue(IFeatureConstants.CONTRACT_DESCRIPTION_URL, String.class);
		descriptionUri = productionContext.getInputValue(IFeatureConstants.CONTRACT_DESCRIPTION_URI, String.class);
		licenseUrl = productionContext.getInputValue(IFeatureConstants.CONTRACT_LICENSE_URL, String.class);
		licenseUri = productionContext.getInputValue(IFeatureConstants.CONTRACT_LICENSE_URI, String.class);
		copyrightUrl = productionContext.getInputValue(IFeatureConstants.CONTRACT_COPYRIGHT_URL, String.class);
		copyrightUri = productionContext.getInputValue(IFeatureConstants.CONTRACT_COPYRIGHT_URI, String.class);
	}

	public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
		Assert.isNotNull(FeatureID, "Feature ID must be not Null");
		Assert.isTrue(! (FeatureID != null && FeatureID.length() == 0), "Feature ID must be not Empty");
		
		CreateFeatureOperation operation = new CreateFeatureOperation();
		operation.setFeatureID(FeatureID);
		operation.setFeatureLabel(FeatureLabel);
		operation.setFeatureProvider(FeatureProvider);
		operation.setFeatureVersion(FeatureVersion);
		operation.setPluginList(PluginList);
		operation.setIncludedFeaturesList(IncludedFeaturesList);
		operation.setCopyrightFileUri(copyrightUri);
		operation.setCopyrightUrl(copyrightUrl);
		operation.setDescriptionFileUri(descriptionUri);
		operation.setDescriptionUrl(descriptionUrl);
		operation.setLicenseFileUri(licenseUri);
		operation.setLicenseUrl(licenseUrl);
		
		try {
			operation.run(monitor);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
		
		feature = operation.getFeatureProject();
	}

	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
	}
}
