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
package org.eclipse.egf.pattern.runner.ui;

import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.misc.ISelectionHandler;

/**
 * Handle pattern descriptor object.
 * @author Guillaume Brocard
 */
public class PatternSelectionHandler implements ISelectionHandler {

  /**
   * @see org.eclipse.egf.common.misc.ISelectionHandler#handleSelection(java.lang.Object)
   */
  public String handleSelection(Object selectedObject_p) {
    if (selectedObject_p instanceof GenericDescriptor) {
      return PatternDescriptorStrategy.getDescriptorFullId((GenericDescriptor) selectedObject_p);
    }
    return null;
  }
  
}
