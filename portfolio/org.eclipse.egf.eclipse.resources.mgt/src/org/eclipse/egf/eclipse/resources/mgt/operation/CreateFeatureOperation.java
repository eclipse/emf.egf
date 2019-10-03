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

package org.eclipse.egf.eclipse.resources.mgt.operation;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.egf.eclipse.resources.mgt.util.EclipseModelsAccessor;

/**
 * @author Boubekeur Zendagui
 */

@SuppressWarnings("restriction")
public class CreateFeatureOperation extends WorkspaceModifyOperation {
	// Feature project
	protected IProject _project;
	// General data about feature 
	protected String _ID;
	protected String _label;
	protected String _provider;
	protected String _version;
	// Include sections data
	protected List<String> _pluginList;
	protected List<String> _includedFeaturesList;
	// Description data
	protected String _descriptionFileUri;
	protected String _descriptionUrl;
	// Copyright data
	protected String _copyrightFileUri;
	protected String _copyrightUrl;
	// License data
	protected String _licenseFileUri;
	protected String _licenseUrl;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		Assert.isNotNull(_ID, "Feature ID can't be null");
		Assert.isLegal(! (_ID != null && _ID.length() == 0), "Feature ID can't be empty");
		_project = createFeature(monitor);
	}
	
	/**
	 * Allows to create a feature project and to set it properties
	 * @param monitor an {@link IProgressMonitor}
	 * @return the created feature project
	 * @throws CoreException
	 */
	protected IProject createFeature(IProgressMonitor monitor) throws CoreException{
		IProject afFeature = ResourcesPlugin.getWorkspace().getRoot().getProject(_ID);
		afFeature.refreshLocal(2, monitor);
		if (! afFeature.exists())
		{
			afFeature.create(monitor);
			afFeature.open(monitor);
			// Adding Feature Nature
			IProjectDescription projectDescription = afFeature.getWorkspace().newProjectDescription(afFeature.getName());
			String[] newIds = {PDE.FEATURE_NATURE};
			projectDescription.setNatureIds(newIds);
			afFeature.setDescription(projectDescription,monitor);
			// Create build.properties file 
			createBuildPropertiesFile(afFeature);
			// create feature.properties
			createFeaturePropertiesFile(afFeature);
			// Create feature.xml file 
			createFeatureXMLFile(afFeature);
			// Refresh the feature project
			afFeature.refreshLocal(IProject.DEPTH_ONE, monitor);
		}

		return afFeature;
	}
	
	/**
	 * Allows to create build.properties file
	 * @param iProject the project wherein the file will be created
	 * @throws CoreException
	 */
	protected void createBuildPropertiesFile(IProject iProject) throws CoreException{
		IFile buildProperties = iProject.getFile("build.properties");
		StringBuffer contents = new StringBuffer();
		contents.append("bin.includes = feature.xml,\\").append("\n");
		contents.append("               ").append("feature.properties\n");
		buildProperties.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
	/**
	 * Allows to create feature.properties file
	 * @param iProject the project wherein the file will be created
	 * @throws CoreException
	 */
	protected void createFeaturePropertiesFile(IProject iProject)  throws CoreException{
		IFile buildProperties = iProject.getFile("feature.properties");
		StringBuffer contents = new StringBuffer();
		contents.append("");
		contents.append("#"+ _ID +" prorpeties \n");
		contents.append("# Name of the feature \n");
		contents.append("featureName=");
		contents.append("# Name of the company that provides the feature \n");
		contents.append("providerName=").append(getFeatureProvider()).append("\n\n");
		
		contents.append("# URL of the \"Feature Description\"\n");
		contents.append("descriptionURL=").append(getDescriptionUrl()).append("\n\n");
		contents.append("# Description of the feature \n");
		contents.append("description=").append(getDescription()).append("\n\n");
		
		contents.append("# URL of the \"Feature License\"\n");
		contents.append("licenseURL=").append(getLicenseUrl()).append("\n\n");
		contents.append("# License of the feature \n");
		contents.append("license=").append(getLicense()).append("\n\n");
		
		contents.append("# URL of the \"Feature Copyright\"\n");
		contents.append("copyrightURL=").append(getCopyrightUrl()).append("\n\n");
		contents.append("# Copyright of the feature \n");
		contents.append("copyright=").append(getCopyright()).append("\n\n");
			
		buildProperties.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
	/**
	 * Allows to create feature.xml file
	 * @param iProject the project wherein the file will be created
	 * @throws CoreException
	 */
	protected void createFeatureXMLFile(IProject iProject) throws CoreException{
		/** Content creation **/
		StringBuffer contents = createFeatureXMLContent();
		
		// Check if the content is OK
		Assert.isNotNull(contents, "A problem is occured when creating feature xml file content");
		
		/** File creation **/
		IFile featureXml = iProject.getFile("feature.xml");
		featureXml.create(new ByteArrayInputStream(contents.toString().getBytes()), false, null);
	}
	
	protected StringBuffer createFeatureXMLContent(){
		StringBuffer contents = new StringBuffer();
		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		contents.append("<feature\n");
		contents.append("	id=\""+getFeatureID()+"\"\n");
		contents.append("	version=\""+ getFeatureVersion()+"\"\n");
		contents.append("	label=\"%featureName\"\n");
		contents.append("	provider-name=\"%providerName\">\n");

		contents.append("	<description url=\"%descriptionURL\">\n");
		contents.append("		%description\n");
		contents.append("	</description>\n");

		contents.append("	<copyright url=\"%copyrightURL\">\n");
		contents.append("		%copyright\n");
		contents.append("	</copyright>\n");

		contents.append("	<license url=\"%licenseURL\">\n");
		contents.append("		%license\n");
		contents.append("	</license>\n");
		
		// 2- Create included features data content
		StringBuffer featureIncludeContent = createIncludeFeatureXMLContent();
		if (featureIncludeContent != null && featureIncludeContent.length() > 0)
			contents.append(featureIncludeContent);
		
		// 3- Create included plug-ins data content
		StringBuffer pluginIncludeContent = createIncludePluginXMLContent();
		if (pluginIncludeContent != null && pluginIncludeContent.length() > 0)
			contents.append(pluginIncludeContent);
		
		// 4- Close feature data content
		contents.append("</feature>\n");
		
		return contents;
	}
	
	/**
	 * Create include feature section
	 * @return a {@link StringBuffer} object containing the include feature section
	 */
	protected StringBuffer createIncludeFeatureXMLContent(){
		final StringBuffer contents = new StringBuffer();
		final List<String> includedFeatures = new ArrayList<String>();
		if (_includedFeaturesList != null)
		{
			for (final String featureID : _includedFeaturesList) 
			{
				if (! includedFeatures.contains(featureID))
				{
					String version = EclipseModelsAccessor.getFeatureVersion(featureID);
					contents.append("	<includes\n");
					contents.append("		id=\""+featureID+"\"\n");
					contents.append("		version=\""+version+"\"/> \n");
					includedFeatures.add(featureID);
				}
			}
		}
		return contents;
	}
	
	/**
	 * Create include plugin section
	 * @return a {@link StringBuffer} object containing the include plugin section
	 */
	protected StringBuffer createIncludePluginXMLContent(){
		final StringBuffer contents = new StringBuffer();
		final List<String> includedPlugins = new ArrayList<String>();
		if (_pluginList != null)
		{
			for (final String pluginID : _pluginList) 
			{
				if (! includedPlugins.contains(pluginID))
				{
					final String version = EclipseModelsAccessor.getPluginVersion(pluginID);
					contents.append("	<plugin\n");
					contents.append("		id=\""+pluginID+"\"\n");
					contents.append("		download-size=\"0\" \n");
					contents.append("		install-size=\"0\" \n");
					contents.append("		version=\""+version+"\" \n");
					contents.append("		unpack=\"false\" /> \n");
					includedPlugins.add(pluginID);
				}
			}
		}
		return contents;	
	}
	
	/***********************************************************************/
	/********************* Getters and Setters section *********************/
	/***********************************************************************/
	
	public IProject getFeatureProject(){
		return _project;
	}
	
	public String getFeatureID() {
		return _ID;
	}
	
	public void setFeatureID(String featureID) {
		_ID = featureID;
	}
	
	public String getFeatureLabel() {
		return _label;
	}
	public void setFeatureLabel(String featureLabel) {
		_label = featureLabel;
	}
	
	public String getFeatureProvider() {
		return _provider;
	}
	
	public void setFeatureProvider(String featureProvider) {
		_provider = featureProvider;
	}
	
	public String getFeatureVersion() {
		if (_version != null && _version.length() > 0)
			return _version;
		else
			return "0.1.0";
	}

	public void setFeatureVersion(String featureVersion) {
		this._version = featureVersion;
	}

	public List<String> getPluginList() {
		return _pluginList;
	}
	
	public void setPluginList(List<String> pluginList) {
		_pluginList = pluginList;
	}
	
	public List<String> getIncludedFeaturesList() {
		return _includedFeaturesList;
	}
	
	public void setIncludedFeaturesList(List<String> includedFeaturesList) {
		_includedFeaturesList = includedFeaturesList;
	}
	
	public String getDescriptionFileUri() {
		return _descriptionFileUri;
	}
	
	public String getDescription(){
		if (_descriptionFileUri != null && _descriptionFileUri.length() > 0)
		{
			String descriptionFileContent = "";
			// TODO: Load file content
			return descriptionFileContent;
		}
		else
			return "[Enter Feature Description here.]";
	}
	
	public void setDescriptionFileUri(String descriptionFileUri) {
		_descriptionFileUri = descriptionFileUri;
	}
	
	public String getDescriptionUrl() {
		if (_descriptionUrl != null && _descriptionUrl.length() > 0)
			return _descriptionUrl;
		else
			return "http://www.example.com/description";
	}
	
	public void setDescriptionUrl(String descriptionUrl) {
		_descriptionUrl = descriptionUrl;
	}
	
	public String getCopyrightFileUri() {
		return _copyrightFileUri;
	}
	
	public String getCopyright(){
		if (_copyrightFileUri != null && _copyrightFileUri.length() > 0)
		{
			String copyrightFileContent = "";
			// TODO: Load Copyright file content
			return copyrightFileContent;
		}
		else
			return "[Enter Copyright Description here.]";
	}
	
	public void setCopyrightFileUri(String copyrightFileUri) {
		_copyrightFileUri = copyrightFileUri;
	}
	
	public String getCopyrightUrl() {
		if (_copyrightUrl != null && _copyrightUrl.length() > 0)
			return _copyrightUrl;
		else
			return "http://www.example.com/copyright";
	}
	
	public void setCopyrightUrl(String copyrightUrl) {
		_copyrightUrl = copyrightUrl;
	}
	
	public String getLicenseFileUri() {
		return _licenseFileUri;
	}
	
	public void setLicenseFileUri(String licenseFileUri) {
		_licenseFileUri = licenseFileUri;
	}
	
	public String getLicense(){
		if (_licenseFileUri != null && _licenseFileUri.length() > 0)
		{
			String licenseFileContent = "";
			// TODO: Load license file content
			return licenseFileContent;
		}
		else
			return "[Enter License Description here.]";
	}
	
	public String getLicenseUrl() {
		if (_licenseUrl != null && _licenseUrl.length() > 0)
			return _licenseUrl;
		else
			return "http://www.example.com/license";
	}
	
	public void setLicenseUrl(String licenseUrl) {
		_licenseUrl = licenseUrl;
	}
}
