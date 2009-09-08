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
package org.eclipse.egf.pattern.runner.nsuri.task;

import java.util.Collection;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.egf.pattern.runner.contract.type.PatternExecutionReporter;
import org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask;
import org.eclipse.egf.pde.emf.PdeEmfActivator;
import org.eclipse.egf.pde.emf.reader.descriptor.IEmfExtensionDescriptor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


/**
 * @author Guillaume Brocard
 */
public class PatternRunnerNsUriTask extends PatternElementRunnerTask {
  /**
   * Pattern element key.
   */
  private static final String PATTERN_OR_LIBRARY_ELEMENT = "patternOrLibrary"; //$NON-NLS-1$
  /**
   * Model name-space URI key.
   */
  private static final String MODEL_NS_URI = "modelNsUri"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask#getModel()
   */
  @Override
  protected Resource getModel() {
    // Make sure resulting resource can't be null.
    Resource result = new ResourceImpl();
    // Get meta-model name-space URI.
    String modelNsUri = (String) getContextElementValue(MODEL_NS_URI);
    // Precondition.
    if (null == modelNsUri) {
      return result;
    }
    // Load generation model from URI.
    Collection<IEmfExtensionDescriptor> emfExtensions = PdeEmfActivator.getDefault().getAllEmfExtensionDescriptors();
    // Cycle through possible extensions.
    for (IEmfExtensionDescriptor emfExtensionDescriptor : emfExtensions) {
      Couple<String, URI> generatedPackage = emfExtensionDescriptor.getGeneratedPackage();
      // Get registered name-space URI.
      String nsUri = generatedPackage.getKey();
      if (modelNsUri.equals(nsUri)) {
        // Found expected URI, load corresponding resource.
        ResourceSet resourceSet = new ResourceSetImpl();
        // Should be a generation model.
        Resource genModelResource = resourceSet.getResource(generatedPackage.getValue(), true);
        EList<EObject> contents = genModelResource.getContents();
        if (!contents.isEmpty()) {
          GenModel genModel = (GenModel) contents.get(0);
          // Cycle through generation packages, thus accessing the real Ecore packages.
          for (GenPackage genPackage : genModel.getGenPackages()) {
            // Got it.
            if (modelNsUri.equals(genPackage.getNSURI())) {
              result = genPackage.getEcorePackage().eResource();
              break;
            }
          }
        }
        break;
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask#getPatternElementFullId()
   */
  @Override
  protected String getPatternElementFullId() {
    return (String) getContextElementValue(PATTERN_OR_LIBRARY_ELEMENT);
  }

  /**
   * @see org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask#getPatternExecutionReporter()
   */
  @Override
  protected IPatternExecutionReporter getPatternExecutionReporter() {
    IPatternExecutionReporter result = super.getPatternExecutionReporter();
    // Use default execution reporter, if none could be found.
    if (null == result) {
      result = new PatternExecutionReporter();
    }
    return result;
  }
}