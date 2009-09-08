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
package org.eclipse.egf.core.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.actions.WorkspaceModifyOperation;


/**
 * This operation provides a template to perform code generation that modifies the workspace content.
 * @author Guillaume Brocard
 */
public abstract class AbstractGenerateCodeOperation extends WorkspaceModifyOperation {
  /**
   * The relative path against the eclipse platform to locate the Ecore file.
   */
  private String _modelPath;
  /**
   * Generator adapter factory.
   */
  private GeneratorAdapterFactory _generatorAdapterFactory;

  /**
   * Is the execution successful or not ?
   */
  private boolean _result;

  /**
   * Constructor.
   */
  protected AbstractGenerateCodeOperation() {
    // Set the ISchedulingRule to null to avoid the workspace to be locked.
    super(null);
  }

  /**
   * Return if the Emf generation is successful or not.
   * @return
   */
  public boolean getResult() {
    return _result;
  }

  /**
   * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  final protected void execute(IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException {
    _result = doExecute(monitor_p);
  }

  /**
   * Performs the steps that are to be treated as a single logical workspace change.
   * <p>
   * Subclasses must implement this method.
   * </p>
   * @param monitor_p
   * @return
   * @throws CoreException
   * @throws InvocationTargetException
   * @throws InterruptedException
   */
  protected abstract boolean doExecute(IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException;

  /**
   * Load potentially existing GenModel for given model file path.
   * @param modelFileName_p
   * @param extensions_p existing EMF generated_package extensions, whether in the workspace or in target platform.
   * @return
   */
  protected GenModel loadExistingGenModel(IPath modelFileName_p, Collection<IEmfExtensionDescriptor> extensions_p) {
    GenModel result = null;
    // Get file full URI.
    URI fileFullUri = FileHelper.getFileFullUri(modelFileName_p.toString());
    // Unable to get it, return.
    if (null == fileFullUri) {
      return result;
    }
    // Load resource from this path.
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource resource = resourceSet.getResource(fileFullUri, true);
    // Get resource contents.
    List<EObject> contents = resource.getContents();
    // First element should be of EPackage type.
    if (!contents.isEmpty()) {
      EPackage rootPackage = (EPackage) contents.get(0);
      // Get namespace URI so as to get existing GenModel from registered extension point.
      String nsURI = rootPackage.getNsURI();
      // Cycle through existing extensions for a possible match.
      for (IEmfExtensionDescriptor descriptor : extensions_p) {
        Couple<String, URI> generatedPackage = descriptor.getGeneratedPackage();
        // Found namespace URI match.
        if (nsURI.equals(generatedPackage.getKey())) {
          Resource genModelResource = resourceSet.getResource(generatedPackage.getValue(), true);
          EList<EObject> genModelContents = genModelResource.getContents();
          if (!genModelContents.isEmpty()) {
            result = (GenModel) genModelContents.get(0);
          }
          break;
        }
      }
    }
    return result;
  }

  /**
   * Return the model path against the eclipse platform.
   * @return the modelPath
   */
  protected String getModelPath() {
    return _modelPath;
  }

  /**
   * Set the model path against the eclipse platform.
   * @param modelPath_p the modelPath to set
   */
  public void setModelPath(String modelPath_p) {
    _modelPath = modelPath_p;
  }

  /**
   * Return the generator adapter factory.
   * @return the generatorAdapterFactory
   */
  protected GeneratorAdapterFactory getGeneratorAdapterFactory() {
    return _generatorAdapterFactory;
  }

  /**
   * Set the the generator adapter factory.
   * @param generatorAdapterFactory_p the generatorAdapterFactory to set
   */
  public void setGeneratorAdapterFactory(GeneratorAdapterFactory generatorAdapterFactory_p) {
    _generatorAdapterFactory = generatorAdapterFactory_p;
  }
}
