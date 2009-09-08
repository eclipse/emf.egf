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
package org.eclipse.egf.pde.reader;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.pde.internal.ui.util.PDEModelUtility;


/**
 * Base class to implement PDE-based bundle readers.
 * @author brocard
 */
public abstract class PdeAbstractReader {
  
  /**
   * Read a descriptor according to given create descriptor operation.
   * @param createDescriptorOperation_p
   * @return
   */
  protected IDescriptor readDescriptor(CreateDescriptorOperation createDescriptorOperation_p) {
    IDescriptor result = null;
    if (createDescriptorOperation_p != null) {
      // Execute the request.
      PDEModelUtility.modifyModel(createDescriptorOperation_p, new NullProgressMonitor());
      result = createDescriptorOperation_p.getDescriptor();
    }
    return result;
  }
  
}
