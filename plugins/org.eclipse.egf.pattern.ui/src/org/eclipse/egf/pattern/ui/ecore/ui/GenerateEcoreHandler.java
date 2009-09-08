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
package org.eclipse.egf.pattern.ui.ecore.ui;

import org.eclipse.egf.pattern.ecore.AbstractPatternGenerator;

/**
 * @author brocard
 */
public class GenerateEcoreHandler extends AbstractPatternGeneratorHandler {
  /**
   * @see org.eclipse.egf.pattern.ui.ecore.ui.AbstractPatternGeneratorHandler#doExecute(org.eclipse.egf.pattern.ecore.AbstractPatternGenerator)
   */
  @Override
  protected void doExecute(AbstractPatternGenerator generator_p) {
    generator_p.generateEcoreFile();
  }
}
