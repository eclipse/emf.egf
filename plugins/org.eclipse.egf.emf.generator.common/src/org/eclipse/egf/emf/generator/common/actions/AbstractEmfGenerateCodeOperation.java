/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.emf.generator.common.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.generator.EmfProjectGenerator;
import org.eclipse.egf.common.generator.EmfProjectType;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.core.ui.actions.AbstractGenerateCodeOperation;
import org.eclipse.egf.pde.emf.PdeEmfActivator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;


/**
 * This operation provides a template to perform EMF code generation that modifies the workspace content.<br>
 * For instance EMF Edit and EMF Editor generate operations can be based on this class.
 * @author Guillaume Brocard
 */
public abstract class AbstractEmfGenerateCodeOperation extends AbstractGenerateCodeOperation {
  
  /**
   * @see org.eclipse.egf.core.ui.actions.AbstractGenerateCodeOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor monitor_p) throws CoreException, InvocationTargetException, InterruptedException {
    boolean result = false;
    String modelPath = getModelPath();
    GeneratorAdapterFactory generatorAdapterFactory = getGeneratorAdapterFactory();
    // Preconditions.
    // Get genModel file full URI.
    URI genModelFileFullUri = FileHelper.getFileFullUri(modelPath);
    // Unable to get it, return.
    if (genModelFileFullUri == null) {
      return result;
    }
    // Load the genModel.
    GenModel genModel = loadExistingGenModel(new Path(modelPath), PdeEmfActivator.getDefault().getAllEmfExtensionDescriptors());
    if (genModel == null) {
      return result;
    }
    // All conditions are fulfilled.
    // Generate EMF Edit project for given genModel.
    EmfProjectGenerator generator = new EmfProjectGenerator(generatorAdapterFactory, getProjectType());
    result = generator.generate(BasicMonitor.toMonitor(monitor_p), genModel);
    return result;
  }

  /**
   * Return the project type representing the generation type to perform.
   * @return
   */
  protected abstract EmfProjectType getProjectType();
  
}
