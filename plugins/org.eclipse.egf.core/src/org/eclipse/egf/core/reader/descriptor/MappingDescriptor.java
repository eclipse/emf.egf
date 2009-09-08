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
package org.eclipse.egf.core.reader.descriptor;

import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;


/**
 * Describe the content of a mapping read from an {@link IFactoryComponentReader} instance.<br>
 * Finally, we only use the generic API but for an inheritance issue we can't directly use a {@link GenericDescriptor}.<br>
 * We have to use something that inherits from {@link AbstractDescriptor}.
 * @author Guillaume Brocard
 */
public class MappingDescriptor extends AbstractDescriptor {
  /**
   * Constructor.
   */
  public MappingDescriptor() {
    super();
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public MappingDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
  }
}