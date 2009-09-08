/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.mapping.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.mapping.MappingPackage;
import org.eclipse.emf.mapping.MappingRoot;
import org.eclipse.emf.mapping.domain.AdapterFactoryMappingDomain;
import org.eclipse.emf.mapping.ecore2ecore.Ecore2EcoreMappingRoot;
import org.eclipse.emf.mapping.ecore2ecore.presentation.Ecore2EcoreEditor;
import org.eclipse.emf.mapping.ecore2ecore.provider.Ecore2EcoreItemProviderAdapterFactory;
import org.eclipse.emf.mapping.provider.MappingItemProviderAdapterFactory;

/**
 * Editor to create mapping between two Ecore models.
 * @author Guillaume Brocard
 */
public class EGFMappingEditor extends Ecore2EcoreEditor {
  /**
   * Constant used to define this editor in the plug-in file.
   */
  public static final String ID = "org.eclipse.egf.mapping.ui.editor.mappingEditorId"; //$NON-NLS-1$

  /**
   * @see org.eclipse.emf.mapping.presentation.MappingEditor#getDefaultCheckedShowTopFirst()
   */
  @Override
  public boolean getDefaultCheckedShowTopFirst() {
    return true;
  }

  /**
   * @see org.eclipse.emf.mapping.ecore2ecore.presentation.Ecore2EcoreEditor#createMappingDomain()
   */
  @Override
  protected AdapterFactoryMappingDomain createMappingDomain() {
    AdapterFactory mappingAdapterFactory =
                                           new ComposedAdapterFactory(new AdapterFactory[] { new ResourceItemProviderAdapterFactory(),
                                                                                            new MappingItemProviderAdapterFactory(),
                                                                                            new Ecore2EcoreItemProviderAdapterFactory() });
    AdapterFactory ecoreAdapterFactory = new EcoreItemProviderAdapterFactory();

    return new Ecore2EcoreMappingDomain(mappingAdapterFactory, ecoreAdapterFactory, ecoreAdapterFactory, new BasicCommandStack(), null);
  }

  /**
   * @see org.eclipse.emf.mapping.ecore2ecore.presentation.Ecore2EcoreEditor#setMappingRoot(org.eclipse.emf.mapping.MappingRoot)
   */
  @Override
  protected void setMappingRoot(MappingRoot mappingRoot_p) {
    // Call standard behavior.
    super.setMappingRoot(mappingRoot_p);
    // Add root packages from compound input (respectively output) model if necessary.
    if (mappingRoot instanceof Ecore2EcoreMappingRoot) {
      // Get the ecore2ecore root element.
      Ecore2EcoreMappingRoot ecore2ecore = (Ecore2EcoreMappingRoot) mappingRoot;
      // Get the editing domain.
      EditingDomain editingDomain = getEditingDomain();
      // Get the command stack.
      CommandStack commandStack = editingDomain.getCommandStack();
      // Get the output package.
      EPackage outputEPackage = ecore2ecore.getOutputEPackage();
      // Get additional packages for the output package ie output model.
      List<Object> additionalOutputPackages = getAdditionalPackages(outputEPackage, ecore2ecore.getOutputs());
      // Add additional packages for the output package.
      addAdditionalPackages(additionalOutputPackages, MappingPackage.eINSTANCE.getMapping_Outputs(), editingDomain, commandStack);
      // Get the input package.
      EPackage inputEPackage = ecore2ecore.getInputEPackage();
      // Get additional packages for the input package ie input model.
      List<Object> additionalInputPackages = getAdditionalPackages(inputEPackage, ecore2ecore.getInputs());
      // Add additional packages for the input package.
      addAdditionalPackages(additionalInputPackages, MappingPackage.eINSTANCE.getMapping_Inputs(), editingDomain, commandStack);
    }
  }

  /**
   * Get all loaded resource by given package.
   * @param package_p
   * @return a not null list.
   */
  protected List<Resource> getPackageResources(EPackage package_p) {
    // Create a temporary resource set to retrieve all resources loaded by given package.
    ResourceSet resourceSet = new ResourceSetImpl();
    // Get the package URI.
    URI mainResourceURI = package_p.eResource().getURI();
    // Load the package resource from the temporary resource set.
    Resource packageResource = resourceSet.getResource(mainResourceURI, true);
    // Resolve all the resource set content.
    if (null != packageResource) {
      EcoreUtil.resolveAll(packageResource);
      EcoreUtil.resolveAll(resourceSet);
    }
    return resourceSet.getResources();
  }

  /**
   * Add additional packages to this mapping model.
   * @param additionalPackages_p
   * @param containerReference_p
   * @param editingDomain_p
   * @param commandStack_p
   */
  protected void addAdditionalPackages(List<Object> additionalPackages_p, EReference containerReference_p, EditingDomain editingDomain_p,
      CommandStack commandStack_p) {
    // If the list is not empty, add its content.
    if (!additionalPackages_p.isEmpty()) {
      Command createCommand = AddCommand.create(editingDomain_p, mappingRoot, containerReference_p, additionalPackages_p);
      commandStack_p.execute(createCommand);
    }
  }

  /**
   * Get the additional root packages contained in the model (ie resource) related to the specified package.<br>
   * If the resource, that contains the specified package, has dependencies to other models, we try to get their root packages.
   * @param package_p
   * @param packagesResources_p
   * @return
   */
  protected List<Object> getAdditionalPackages(EPackage package_p, EList<EObject> existingPackages_p) {
    ArrayList<Object> additionalPackages = new ArrayList<Object>(0);
    // Get the package resources.
    List<Resource> packageResources = getPackageResources(package_p);
    // Loop over loaded resources by given package.
    for (Resource currentResource : packageResources) {
      // Lookup in resources that contain an EPackage as root object.
      EPackage rootPackage = (EPackage) EcoreUtil.getObjectByType(currentResource.getContents(), EcorePackage.Literals.EPACKAGE);
      if (null != rootPackage) {
        String nsURI = rootPackage.getNsURI();
        boolean found = false;
        Iterator<EObject> iterator = existingPackages_p.iterator();
        // Loop over existing packages, trying to find current one.
        while (iterator.hasNext() && !found) {
          EObject currentObject = iterator.next();
          // Be sure current object is an EPackage.
          if (currentObject instanceof EPackage) {
            EPackage currentPackage = (EPackage) currentObject;
            // Check package name space uri.
            if (nsURI.equals(currentPackage.getNsURI())) {
              found = true;
            }
          }
        }
        // If the package is not found, add it.
        if (!found) {
          additionalPackages.addAll(currentResource.getContents());
        }
      }
    }
    return additionalPackages;
  }
}