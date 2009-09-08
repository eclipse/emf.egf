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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContextDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContextElementDescriptor;


/**
 * Describe the content of a context read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class ContextDescriptor extends AbstractDescriptor implements IContextDescriptor {
  private List<IContextElementDescriptor> _contextElementDescriptors;

  /**
   * Constructor.
   */
  public ContextDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public ContextDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
    _contextElementDescriptors = new ArrayList<IContextElementDescriptor>(0);
  }

  /**
   * Add given context element descriptor.
   * @param contextElementDescriptor_p
   */
  public void addContextElementDescriptor(IContextElementDescriptor contextElementDescriptor_p) {
    _contextElementDescriptors.add(contextElementDescriptor_p);
  }

  /**
   * Get the context element descriptor list.
   * @return the contextElementDescriptors
   */
  public List<IContextElementDescriptor> getContextElementDescriptors() {
    return _contextElementDescriptors;
  }
}
