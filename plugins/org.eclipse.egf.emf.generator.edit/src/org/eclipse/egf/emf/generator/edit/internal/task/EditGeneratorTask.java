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
package org.eclipse.egf.emf.generator.edit.internal.task;

import org.eclipse.egf.core.ui.actions.AbstractGenerateCodeOperation;
import org.eclipse.egf.emf.generator.common.task.AbstractEmfGeneratorTask;
import org.eclipse.egf.emf.generator.edit.internal.actions.GenerateEditCodeOperation;


/**
 * Generates the EMF Edit plug-in.
 * @author Guillaume Brocard
 */
public class EditGeneratorTask extends AbstractEmfGeneratorTask {
  /**
   * @see org.eclipse.egf.emf.generator.common.task.AbstractEmfGeneratorTask#getEmfGenerateCodeOperation()
   */
  @Override
  protected AbstractGenerateCodeOperation getEmfGenerateCodeOperation() {
    return new GenerateEditCodeOperation();
  }
}
