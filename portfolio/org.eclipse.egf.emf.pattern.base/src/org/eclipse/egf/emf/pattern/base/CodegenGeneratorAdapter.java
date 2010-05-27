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

package org.eclipse.egf.emf.pattern.base;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenGeneratorAdapter extends GenBaseGeneratorAdapter {

  protected Generator _generator;

  protected GenModel _genModel;

  protected URI _mergeRulesURI;

  public CodegenGeneratorAdapter(GenBase generatingObject) {
    super(null);
    this.generatingObject = generatingObject;
    _genModel = generatingObject.getGenModel();
  }

  public void setMergeRulesURI(URI mergeRulesURI) {
    _mergeRulesURI = mergeRulesURI;
  }

  @Override
  public Generator getGenerator() {
    if (_generator == null) {
      _generator = GenModelUtil.createGenerator(_genModel, _mergeRulesURI);
    }
    return _generator;
  }

  public boolean canGenerate(Object projectType) {
    return super.canGenerate(generatingObject, projectType);
  }

  @Override
  public URI toURI(String pathName) {
    return super.toURI(pathName);
  }

  @Override
  public boolean exists(URI workspacePath) {
    return super.exists(workspacePath);
  }

  @Override
  public void ensureProjectExists(String workspacePath, Object object, Object projectType, boolean force, Monitor monitor) {
    super.ensureProjectExists(workspacePath, object, projectType, force, monitor);
  }

  public void generateJava(String targetPath, String packageName, String className, String output) {
    generateJava(targetPath, packageName, className, new StringJETEmitter(output), (Object[]) null, new BasicMonitor());
  }

  public void generateText(String targetPathName, boolean overwrite, String encoding, String output) {
    generateText(targetPathName, new StringJETEmitter(output), (Object[]) null, overwrite, encoding, new BasicMonitor());
  }

  public void generateProperties(String targetPathName, String output) {
    generateProperties(targetPathName, new StringJETEmitter(output), (Object[]) null, new BasicMonitor());
  }

  public void generateGIF(String inputPathName, String targetPathName, String parentKey, String childKey, boolean overwrite) {
    generateGIF(targetPathName, createGIFEmitter(inputPathName), parentKey, childKey, overwrite, new BasicMonitor());
  }

}
