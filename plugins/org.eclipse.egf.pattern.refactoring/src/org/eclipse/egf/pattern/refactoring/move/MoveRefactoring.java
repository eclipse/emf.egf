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
package org.eclipse.egf.pattern.refactoring.move;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;

/**
 * Move pattern or library refactoring based on a processor.
 * @author Guillaume Brocard
 */
public class MoveRefactoring extends ProcessorBasedRefactoring {
  /**
   * The processor to use.
   */
  private MoveProcessor _processor;

  /**
   * Constructor.
   * @param processor_p
   */
  public MoveRefactoring(MoveProcessor processor_p) {
    super(processor_p);
    Assert.isNotNull(processor_p);
    _processor = processor_p;
  }

  /**
   * @see org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring#getProcessor()
   */
  @Override
  public RefactoringProcessor getProcessor() {
    return _processor;
  }
}
