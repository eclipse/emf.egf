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
package org.eclipse.egf.fc.generator.java.model;

import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.emf.codegen.ecore.generator.Generator.Options;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.osgi.framework.Bundle;


/**
 * Base class to implement a generator adapter factory for the {@link org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage} GenModel package.<br>
 * Implementors have to override {@link #getBundle()} method to provide the bundle instance responsible for providing additional templates.<br>
 * Implementors must provide a default constructor. Have a look to {@link GenModelGeneratorAdapterFactory} class to know to extend, change,... the EMF default
 * code generation.
 * @author Guillaume Brocard
 */
public abstract class AbstractGenModelGeneratorAdapterFactory extends GenModelGeneratorAdapterFactory {
  /**
   * Constant that defines the name of the templates folder.
   */
  private static final String TEMPLATES = "templates"; //$NON-NLS-1$
  /**
   * Merge rules relative path.
   */
  private String _mergeRulesRelativePath;

  /**
   * Return template paths in taking into account an additional template path coming from provided bundle.
   * @param existingTemplatePaths_p existing template path.
   * @see #getBundle().
   * @return
   */
  protected String[] getAdditionalTemplatePath(String[] existingTemplatePaths_p) {
    String[] resultingTemplatePaths = new String[existingTemplatePaths_p.length + 1];
    System.arraycopy(existingTemplatePaths_p, 0, resultingTemplatePaths, 0, existingTemplatePaths_p.length);
    resultingTemplatePaths[existingTemplatePaths_p.length] = resultingTemplatePaths[existingTemplatePaths_p.length - 1];
    resultingTemplatePaths[existingTemplatePaths_p.length - 1] = getBundle().getEntry(TEMPLATES).toString();
    return resultingTemplatePaths;
  }

  /**
   * Return a bundle where additional templates can be found in a plug-in sub-folder named '<code>templates</code>'.<br>
   * Must not return null.
   * @return a correctly initialized bundle.
   */
  protected abstract Bundle getBundle();

  /**
   * @see org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory#getTemplatePath(org.eclipse.emf.codegen.ecore.genmodel.GenModel)
   */
  @SuppressWarnings("deprecation")
  @Override
  protected String[] getTemplatePath(GenModel genModel) {
    return getAdditionalTemplatePath(super.getTemplatePath(genModel));
  }

  /**
   * @see org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory#getMergeRulesURI(org.eclipse.emf.codegen.ecore.genmodel.GenModel)
   */
  @Override
  protected String getMergeRulesURI(GenModel genModel_p) {
    // Precondition : default behavior.
    if (null == _mergeRulesRelativePath) {
      return super.getMergeRulesURI(genModel_p);
    }
    return FileHelper.getFileFullUri(_mergeRulesRelativePath).toString();
  }

  /**
   * Set the merge rules relative path.
   * @param mergeRulesRelativePath_p
   */
  public void setMergeRulesRelativePath(String mergeRulesRelativePath_p) {
    _mergeRulesRelativePath = mergeRulesRelativePath_p;
  }

  /**
   * @see org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory#initialize(java.lang.Object)
   */
  @Override
  public void initialize(Object input_p) {
    super.initialize(input_p);
    // If new merge rules are provided, make sure the file is used due to getMergeRulesURI method is not called if templatePath is not equals to default
    // template path.
    if (null != _mergeRulesRelativePath) {
      Options options = generator.getOptions();
      options.mergeRulesURI = getMergeRulesURI((GenModel) input_p);
    }
  }
}