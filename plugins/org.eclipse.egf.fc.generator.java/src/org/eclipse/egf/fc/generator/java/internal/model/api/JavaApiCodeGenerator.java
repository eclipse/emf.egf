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
package org.eclipse.egf.fc.generator.java.internal.model.api;

import org.eclipse.egf.common.generator.EmfProjectGenerator;
import org.eclipse.egf.common.generator.EmfProjectType;
import org.eclipse.egf.fc.generator.java.internal.AbstractGenerator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Monitor;


/**
 * Provides services to generate a model Java API from an EMF genmodel.
 * @author fournier
 */
public class JavaApiCodeGenerator extends AbstractGenerator {
  
  /**
   * Generator adapter factory.
   */
  private GeneratorAdapterFactory _generatorAdapterFactory;

  /**
   * Constructor.
   * @param generatorAdapterFactory_p
   */
  public JavaApiCodeGenerator(GeneratorAdapterFactory generatorAdapterFactory_p) {
    _generatorAdapterFactory = generatorAdapterFactory_p;
  }

  /**
   * Generate a Java model API for given genModel.
   * @param genModel_p
   */
  public boolean generate(Monitor monitor_p, GenModel genModel_p) {
    // check if model API generation is possible
    EmfProjectGenerator generator = new EmfProjectGenerator(_generatorAdapterFactory, EmfProjectType.MODEL_PROJECT_TYPE);
    return generator.generate(monitor_p, genModel_p);
  }
  
}