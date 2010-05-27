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

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;

/**
 * @author Matthieu Helleboid
 * 
 */
public abstract class CodegenPatternExecutionReporter implements PatternExecutionReporter {

  protected GenModel genModel;

  protected Boolean canGenerate;

  public void executionFinished(String output, PatternContext context) {
    // Nothing to do
  }

  public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
    genModel = (GenModel) context.getValue("genModel"); //$NON-NLS-1$
    canGenerate = (Boolean) context.getValue("canGenerate"); //$NON-NLS-1$

    if (genModel == null)
      throw new IllegalStateException("Variable genModel must be set."); //$NON-NLS-1$
    if (canGenerate == null)
      throw new IllegalStateException("Variable canGenerate must be set."); //$NON-NLS-1$
  }

  protected void generateText(String output, PatternContext context) {
    String targetPathName = (String) context.getValue("targetPathName"); //$NON-NLS-1$
    Boolean overwrite = (Boolean) context.getValue("overwrite"); //$NON-NLS-1$
    String encoding = (String) context.getValue("encoding"); //$NON-NLS-1$

    if (targetPathName == null)
      throw new IllegalStateException("Variable targetPath must be set."); //$NON-NLS-1$
    if (overwrite == null)
      throw new IllegalStateException("Variable overwrite must be set."); //$NON-NLS-1$
    if (encoding == null)
      throw new IllegalStateException("Variable encoding must be set."); //$NON-NLS-1$

    new CodegenGeneratorAdapter(genModel).generateText(targetPathName, overwrite, encoding, output);
  }

  protected void generateProperties(String output, PatternContext context) {
    String targetPathName = (String) context.getValue("targetPathName"); //$NON-NLS-1$

    if (targetPathName == null)
      throw new IllegalStateException("Variable targetPath must be set."); //$NON-NLS-1$

    new CodegenGeneratorAdapter(genModel).generateProperties(targetPathName, output);
  }

  protected void generateJava(String output, PatternContext context) {
    String targetPath = (String) context.getValue("targetPath"); //$NON-NLS-1$
    String packageName = (String) context.getValue("packageName"); //$NON-NLS-1$
    String className = (String) context.getValue("className"); //$NON-NLS-1$ 

    if (targetPath == null)
      throw new IllegalStateException("Variable targetPath must be set."); //$NON-NLS-1$
    if (packageName == null)
      throw new IllegalStateException("Variable packageName must be set."); //$NON-NLS-1$
    if (className == null)
      throw new IllegalStateException("Variable className must be set."); //$NON-NLS-1$

    CodegenGeneratorAdapter generator = new CodegenGeneratorAdapter(genModel);
    generator.setMergeRulesURI(normalizeAndCheckURI((URI) context.getValue("mergeRulesURI"))); //$NON-NLS-1$
    generator.generateJava(targetPath, packageName, className, output);
  }

  /*
   * Computes the bundle uri
   */
  protected URI normalizeAndCheckURI(URI uri) {
    if (uri == null) {
      return null;
    }
    // TODO: We should handle relative path to its fcore resource
    try {
      InputStream inputStream = EGFCorePlugin.getPlatformURIConverter().createInputStream(uri);
      inputStream.close();
    } catch (IOException ioe) {
      Activator.getDefault().logError(NLS.bind("Unable to locate URI ''{0}''", uri), ioe); //$NON-NLS-1$
      return null;
    }
    return uri;
  }

  protected void generateGIF(String output, PatternContext context) {
    // Nothing to do (done in patterns)
  }

}
