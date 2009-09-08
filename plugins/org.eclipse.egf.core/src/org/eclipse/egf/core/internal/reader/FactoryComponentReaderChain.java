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
package org.eclipse.egf.core.internal.reader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.core.reader.descriptor.FactoryComponentInvocationDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContextDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractDescriptor;
import org.eclipse.egf.core.reader.descriptor.ContractElementReferenceDescriptor;
import org.eclipse.egf.core.reader.descriptor.ProductionPlanDescriptor;
import org.eclipse.egf.core.reader.descriptor.TaskFactoryDescriptor;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IProductionPlanDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.ITypedDescriptor;
import org.eclipse.egf.model.internal.data.ModelElement;

/**
 * Factory Component reader chain entry point.<br>
 * For every service, the factory component reader chain delegates the called service to registered {@link IFactoryComponentReader} instances until one of them
 * succeeds in instantiating a result.
 * @author fournier
 */
public class FactoryComponentReaderChain implements IFactoryComponentReader {
  /**
   * Extension-point id to contribute other reader.
   */
  private static final String FACTORY_COMPONENT_READER_EXTENSION_POINT_ID = "factoryComponentReader"; //$NON-NLS-1$
  private static FactoryComponentReaderChain __instance;
  private List<IFactoryComponentReader> _factoryComponentReaders;

  /**
   * Private constructor for singleton pattern.
   */
  private FactoryComponentReaderChain() {
    _factoryComponentReaders = new ArrayList<IFactoryComponentReader>(1);
    // Add default reader
    _factoryComponentReaders.add(new DefaultFactoryComponentReader());
    // Load other readers provided by contribution.
    IConfigurationElement[] configurationElementReaders =
        ExtensionPointHelper.getConfigurationElements(CoreActivator.getDefault().getPluginID(), FACTORY_COMPONENT_READER_EXTENSION_POINT_ID);
    for (IConfigurationElement configurationElement : configurationElementReaders) {
      IFactoryComponentReader reader = (IFactoryComponentReader) ExtensionPointHelper.createInstance(configurationElement, ExtensionPointHelper.ATT_CLASS);
      _factoryComponentReaders.add(reader);
    }
  }

  /**
   * Get the singleton instance.
   * @return
   */
  public static IFactoryComponentReader getInstance() {
    if (null == __instance) {
      __instance = new FactoryComponentReaderChain();
    }
    return __instance;
  }

  /**
   * Get the factory component reader for given factory component id.
   * @param factoryComponentId_p
   * @return an {@link IFactoryComponentReader} instance or null if not found.
   */
  private IFactoryComponentReader getFactoryComponentReader(String factoryComponentId_p) {
    IFactoryComponentReader retrievedReader = null;
    FactoryComponent fc = CoreActivator.getDefault().getFactoryComponent(factoryComponentId_p);
    if (null != fc) {
      retrievedReader = ((ModelElement) fc).getFactoryComponentReader();
    }
    return retrievedReader;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponent(java.lang.String)
   */
  public IFactoryComponentDescriptor readFactoryComponent(String fcId_p) {
    IFactoryComponentDescriptor descriptor = null;
    // Iterate over all registered factory component readers.
    Iterator<IFactoryComponentReader> readers = _factoryComponentReaders.iterator();
    // Stop iterating as soon as a descriptor is instantiated.
    while (readers.hasNext() && (null == descriptor)) {
      IFactoryComponentReader reader = readers.next();
      descriptor = reader.readFactoryComponent(fcId_p);
    }
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readProductionPlan(java.lang.String, java.lang.String)
   */
  public IProductionPlanDescriptor readProductionPlan(final String productionPlanId_p, final String fcId_p) {
    IProductionPlanDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public ITypedDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readProductionPlan(productionPlanId_p, fcId_p);
      }
    };
    // Do proceed.
    descriptor = (ProductionPlanDescriptor) doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  public FactoryComponentInvocationDescriptor readFactoryComponentInvocation(final String factoryComponentInvocationId_p, final String fcId_p) {
    FactoryComponentInvocationDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public ITypedDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readFactoryComponentInvocation(factoryComponentInvocationId_p, fcId_p);
      }
    };
    // Do proceed.
    descriptor = (FactoryComponentInvocationDescriptor) doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContract(java.lang.String, java.lang.String)
   */
  public ContractDescriptor readContract(final String contractId_p, final String fcId_p) {
    ContractDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public ITypedDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readContract(contractId_p, fcId_p);
      }
    };
    // Do proceed.
    descriptor = (ContractDescriptor) doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContext(java.lang.String, java.lang.String)
   */
  public ContextDescriptor readContext(final String contextId_p, final String fcId_p) {
    ContextDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public ITypedDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readContext(contextId_p, fcId_p);
      }
    };
    // Do proceed.
    descriptor = (ContextDescriptor) doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readTaskFactory(java.lang.String, java.lang.String)
   */
  public TaskFactoryDescriptor readTaskFactory(final String taskFactoryId_p, final String fcId_p) {
    TaskFactoryDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public ITypedDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readTaskFactory(taskFactoryId_p, fcId_p);
      }
    };
    // Do proceed.
    descriptor = (TaskFactoryDescriptor) doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContractElementReference(java.lang.String, java.lang.String)
   */
  public ContractElementReferenceDescriptor readContractElementReference(final String contractReferenceId_p, final String fcId_p) {
    ContractElementReferenceDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public ITypedDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readContractElementReference(contractReferenceId_p, fcId_p);
      }
    };
    // Do proceed.
    descriptor = (ContractElementReferenceDescriptor) doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readPatternLibraries(java.lang.String)
   */
  public IDescriptor readPatternLibraries(final String fcId_p) {
    IDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public IDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readPatternLibraries(fcId_p);
      }
    };
    // Do proceed.
    descriptor = doRead(fcId_p, command, false);
    return descriptor;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readMappings(java.lang.String)
   */
  public IDescriptor readMappings(final String fcId_p) {
    IDescriptor descriptor = null;
    AbstractReadingCommand command = new AbstractReadingCommand() {
      @Override
      public IDescriptor execute(IFactoryComponentReader reader_p) {
        return reader_p.readMappings(fcId_p);
      }
    };
    // Do proceed.
    descriptor = doRead(fcId_p, command, true);
    return descriptor;
  }

  /**
   * Execute the reading command provided as parameter.
   * @param fcId_p
   * @param command_p
   * @param usefactoryComponentReader_p <code>true</code> means re-use the factory component reader of the factory component related to given factory component id.<br>
   *          Re-using the factory component reader improves the performances but caller must be sure the reader that is able to process the command is the same as the one
   *          used to read the factory component.
   * @return
   */
  private IDescriptor doRead(String fcId_p, AbstractReadingCommand command_p, boolean usefactoryComponentReader_p) {
    IDescriptor descriptor = null;
    // Retrieve the factory component reader if defined (it should).
    IFactoryComponentReader retrievedfactoryComponentReader = (usefactoryComponentReader_p) ? getFactoryComponentReader(fcId_p) : null;
    if (null != retrievedfactoryComponentReader) {
      descriptor = command_p.execute(retrievedfactoryComponentReader);
    } else {
      // Iterate over all registered factory component readers.
      Iterator<IFactoryComponentReader> readers = _factoryComponentReaders.iterator();
      // Stop iterating as soon as a descriptor is instantiated.
      while (readers.hasNext() && (null == descriptor)) {
        IFactoryComponentReader reader = readers.next();
        descriptor = command_p.execute(reader);
      }
    }
    return descriptor;
  }

  /**
   * Base class to implement reading commands
   * @author fournier
   */
  abstract class AbstractReadingCommand {
    /**
     * Execute a reading command with given reader.
     * @param reader_p
     * @return an {@link AbstractDescriptor} instance or null.
     */
    public abstract IDescriptor execute(IFactoryComponentReader reader_p);
  }
}
