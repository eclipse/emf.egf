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
package org.eclipse.egf.pde.reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentInvocationDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContextDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IContractElementReferenceDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IProductionPlanDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.ITaskFactoryDescriptor;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.internal.reader.CreateFactoryComponentInvocationDescriptorOperation;
import org.eclipse.egf.pde.internal.reader.CreateFactoryComponentDescriptorOperation;
import org.eclipse.egf.pde.internal.reader.CreateContextDescriptorOperation;
import org.eclipse.egf.pde.internal.reader.CreateContractDescriptorOperation;
import org.eclipse.egf.pde.internal.reader.CreateContractElementReferenceOperation;
import org.eclipse.egf.pde.internal.reader.CreateMappingDescriptorOperation;
import org.eclipse.egf.pde.internal.reader.CreateProductionPlanDescriptorOperation;
import org.eclipse.egf.pde.internal.reader.CreateTaskFactoryDescriptorOperation;


/**
 * This implementation reads EGF elements in using PDE services.<br>
 * It is typically used to retrieve factory components defined in projects located in the workspace.
 * @author fournier
 */
public class WorkspaceFactoryComponentReader extends PdeAbstractReader implements IFactoryComponentReader {
  /**
   * Shared default instance when this reader is not instantiated through Eclipse extension mechanism.
   */
  private static WorkspaceFactoryComponentReader __default;

  /**
   * Return a shared default instance.
   * @return
   */
  public static WorkspaceFactoryComponentReader getDefault() {
    if (null == __default) {
      __default = new WorkspaceFactoryComponentReader();
    }
    return __default;
  }

  /**
   * Read a factory component description from given project.
   * @param project_p
   * @return an {@link FactoryComponentDescriptor} instance or null if data are not found.
   */
  public IFactoryComponentDescriptor readFactoryComponent(IProject project_p) {
    IFactoryComponentDescriptor result = null;
    // Precondition
    if (null == project_p) {
      return result;
    }
    IFile pluginFile = EgfPdeActivator.getDefault().getFile(project_p);
    // Does the plug-in file exist ?
    if (null != pluginFile) {
      result = (IFactoryComponentDescriptor) readDescriptor(new CreateFactoryComponentDescriptorOperation(pluginFile));
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponent(java.lang.String)
   */
  public IFactoryComponentDescriptor readFactoryComponent(String factoryComponentId_p) {
    return readFactoryComponent(EgfPdeActivator.getDefault().getProjectForFactoryComponent(factoryComponentId_p));
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readProductionPlan(java.lang.String, java.lang.String)
   */
  public IProductionPlanDescriptor readProductionPlan(final String productionPlanId_p, String factoryComponentId_p) {
    IProductionPlanDescriptor result =
                                       (IProductionPlanDescriptor) readDescriptor(new CreateProductionPlanDescriptorOperation(EgfPdeActivator.getDefault()
                                           .getFile(factoryComponentId_p), productionPlanId_p));
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public IFactoryComponentInvocationDescriptor readFactoryComponentInvocation(final String factoryComponentInvocation_p, String factoryComponentId_p) {
    IFactoryComponentInvocationDescriptor result =
                                           (IFactoryComponentInvocationDescriptor) readDescriptor(new CreateFactoryComponentInvocationDescriptorOperation(EgfPdeActivator
                                               .getDefault().getFile(factoryComponentId_p), factoryComponentInvocation_p));
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContract(java.lang.String, java.lang.String)
   */
  public IContractDescriptor readContract(final String contractId_p, String factoryComponentId_p) {
    IContractDescriptor result =
                                 (IContractDescriptor) readDescriptor(new CreateContractDescriptorOperation(EgfPdeActivator.getDefault().getFile(factoryComponentId_p),
                                                                                                            contractId_p));
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContext(java.lang.String, java.lang.String)
   */
  public IContextDescriptor readContext(final String contextId_p, String factoryComponentId_p) {
    IContextDescriptor result =
                                (IContextDescriptor) readDescriptor(new CreateContextDescriptorOperation(EgfPdeActivator.getDefault().getFile(factoryComponentId_p),
                                                                                                         contextId_p));
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readTaskFactory(java.lang.String, java.lang.String)
   */
  public ITaskFactoryDescriptor readTaskFactory(final String taskFactoryId_p, String factoryComponentId_p) {
    ITaskFactoryDescriptor result =
                                    (ITaskFactoryDescriptor) readDescriptor(new CreateTaskFactoryDescriptorOperation(EgfPdeActivator.getDefault()
                                        .getFile(factoryComponentId_p), taskFactoryId_p));
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readPatternLibraries(java.lang.String)
   */
  public IDescriptor readPatternLibraries(String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readMappings(java.lang.String)
   */
  public IDescriptor readMappings(String factoryComponentId_p) {
    IDescriptor result = readDescriptor(new CreateMappingDescriptorOperation(EgfPdeActivator.getDefault().getFile(factoryComponentId_p)));
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContractElementReference(java.lang.String, java.lang.String)
   */
  public IContractElementReferenceDescriptor readContractElementReference(final String contractReferenceId_p, String factoryComponentId_p) {
    IContractElementReferenceDescriptor result =
                                                 (IContractElementReferenceDescriptor) readDescriptor(new CreateContractElementReferenceOperation(
                                                                                                                                                  EgfPdeActivator
                                                                                                                                                      .getDefault()
                                                                                                                                                      .getFile(
                                                                                                                                                               factoryComponentId_p),
                                                                                                                                                  contractReferenceId_p));
    return result;
  }

  /**
   * @see org.eclipse.egf.pde.reader.PdeAbstractReader#readDescriptor(org.eclipse.egf.pde.reader.CreateDescriptorOperation)
   */
  @Override
  protected IDescriptor readDescriptor(CreateDescriptorOperation createDescriptorOperation_p) {
    IDescriptor result = super.readDescriptor(createDescriptorOperation_p);
    // If result is not null, set the reader on it for later usage.
    if (null != result) {
      ((AbstractDescriptor) result).setFactoryComponentReader(this);
    }
    return result;
  }
}