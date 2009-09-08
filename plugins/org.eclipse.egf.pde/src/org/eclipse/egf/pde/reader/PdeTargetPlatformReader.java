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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.core.reader.descriptor.AbstractDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentInvocationDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentDescriptor;
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
import org.eclipse.egf.pde.internal.ui.util.PDEModelUtility;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.plugin.ExternalPluginModel;
import org.eclipse.pde.internal.ui.editor.JarEntryFile;


/**
 * @author Guillaume Brocard
 */
public class PdeTargetPlatformReader extends WorkspaceFactoryComponentReader {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PdeTargetPlatformReader.class.getPackage().getName());
  /**
   * Shared default instance.
   */
  private static PdeTargetPlatformReader __default;

  /**
   * Return a shared default instance.
   * @return
   */
  public static PdeTargetPlatformReader getDefault() {
    if (null == __default) {
      __default = new PdeTargetPlatformReader();
    }
    return __default;
  }

  /**
   * Constructor.
   */
  private PdeTargetPlatformReader() {
    // Singleton.
  }

  /**
   * @see org.eclipse.egf.pde.reader.PdeAbstractReader#readDescriptor(org.eclipse.egf.pde.reader.CreateDescriptorOperation)
   */
  @Override
  protected IDescriptor readDescriptor(CreateDescriptorOperation createDescriptorOperation_p) {
    IDescriptor result = null;
    if (null != createDescriptorOperation_p) {
      try {
        // Execute the request.
        IPluginModelBase pluginModelBase = createDescriptorOperation_p.getPluginModelBase();
        // Are extensions defined ?
        if (pluginModelBase.getPluginBase().getExtensions().length > 0) {
          // Create a temporary plug-in model.
          IPluginModel tempPluginModel = createTemporaryPluginModel(pluginModelBase);
          // If plugin.xml file exists, try to read extensions in it.
          if (null != tempPluginModel) {
            createDescriptorOperation_p.modifyModel(tempPluginModel, new NullProgressMonitor());
            // Dispose the temporary plug-in model.
            tempPluginModel.dispose();
            tempPluginModel = null;
          }
        }
      } catch (CoreException exception_p) {
        StringBuilder loggerMessage = new StringBuilder("PdeTargetPlatformReader.readDescriptor(..) _ "); //$NON-NLS-1$
        __logger.error(loggerMessage.toString(), exception_p);
      }
      result = createDescriptorOperation_p.getDescriptor();
      // If result is not null, set the reader on it for later usage.
      if (null != result) {
        ((AbstractDescriptor) result).setFactoryComponentReader(this);
      }
    }
    return result;
  }

  /**
   * Load plug-in file content from a target-platform.
   * @param pluginModelBase_p
   */
  protected IPluginModel createTemporaryPluginModel(IPluginModelBase pluginModelBase_p) {
    File location = new File(pluginModelBase_p.getInstallLocation());
    InputStream pluginInputStream = null;
    // Temporary plug-in model. Use that to avoid side-effects in PDE code due to the load operation that indirectly reset the model if already set.
    ExternalPluginModel extModel = null;
    // Is the location a java archive or a folder that contains plug-in file?
    if (location.isFile()) {
      try {
        ZipFile zipFile = new ZipFile(location);
        // Get the plug-in file content from the jar.
        if (null != zipFile.getEntry(PDEModelUtility.F_PLUGIN)) {
          JarEntryFile jarEntryFile = new JarEntryFile(zipFile, PDEModelUtility.F_PLUGIN);
          pluginInputStream = jarEntryFile.getContents();
        }
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("PdeTargetPlatformReader.createTemporaryPluginModel(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    } else {
      // Create a file input stream from the folder that hosts this plug-in.
      File pluginFile = new File(location, PDEModelUtility.F_PLUGIN);
      if (pluginFile.exists()) {
        try {
          pluginInputStream = new FileInputStream(pluginFile);
        } catch (FileNotFoundException exception_p) {
          StringBuilder loggerMessage = new StringBuilder("PdeTargetPlatformReader.createTemporaryPluginModel(..) _ "); //$NON-NLS-1$
          __logger.warn(loggerMessage.toString(), exception_p);
        }
      }
    }
    // If input stream was successfully created, try to instantiate a temporary plug-in model.
    if (null != pluginInputStream) {
      extModel = new ExternalPluginModel();
      extModel.setBundleDescription(pluginModelBase_p.getBundleDescription());
      extModel.setInstallLocation(pluginModelBase_p.getInstallLocation());
      try {
        extModel.load(pluginInputStream, false);
        // Close the input stream to release any associated resources.
        pluginInputStream.close();
      } catch (Exception exception_p) {
        StringBuilder loggerMessage = new StringBuilder("PdeTargetPlatformReader.createTemporaryPluginModel(..) _ "); //$NON-NLS-1$
        __logger.warn(loggerMessage.toString(), exception_p);
      }
    }
    return extModel;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponent(java.lang.String)
   */
  @Override
  public IFactoryComponentDescriptor readFactoryComponent(String fcId_p) {
    return readFactoryComponent(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
  }

  /**
   * Read a factory component.
   * @param pluginModel_p
   * @return
   */
  public IFactoryComponentDescriptor readFactoryComponent(IPluginModelBase pluginModel_p) {
    IFactoryComponentDescriptor result = null;
    // Precondition
    if (null == pluginModel_p) {
      return result;
    }
    CreateFactoryComponentDescriptorOperation descriptorOperation = new CreateFactoryComponentDescriptorOperation(null);
    descriptorOperation.setPluginModelBase(pluginModel_p);
    result = (IFactoryComponentDescriptor) readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readFactoryComponentInvocation(java.lang.String, java.lang.String)
   */
  @Override
  public IFactoryComponentInvocationDescriptor readFactoryComponentInvocation(String factoryComponentInvocation_p, String fcId_p) {
    CreateFactoryComponentInvocationDescriptorOperation descriptorOperation = new CreateFactoryComponentInvocationDescriptorOperation(null, factoryComponentInvocation_p);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    IFactoryComponentInvocationDescriptor result = (IFactoryComponentInvocationDescriptor) readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContext(java.lang.String, java.lang.String)
   */
  @Override
  public IContextDescriptor readContext(String contextId_p, String fcId_p) {
    CreateContextDescriptorOperation descriptorOperation = new CreateContextDescriptorOperation(null, contextId_p);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    IContextDescriptor result = (IContextDescriptor) readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContract(java.lang.String, java.lang.String)
   */
  @Override
  public IContractDescriptor readContract(String contractId_p, String fcId_p) {
    CreateContractDescriptorOperation descriptorOperation = new CreateContractDescriptorOperation(null, contractId_p);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    IContractDescriptor result = (IContractDescriptor) readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readContractElementReference(java.lang.String, java.lang.String)
   */
  @Override
  public IContractElementReferenceDescriptor readContractElementReference(String contractReferenceId_p, String fcId_p) {
    CreateContractElementReferenceOperation descriptorOperation = new CreateContractElementReferenceOperation(null, contractReferenceId_p);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    IContractElementReferenceDescriptor result = (IContractElementReferenceDescriptor) readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readMappings(java.lang.String)
   */
  @Override
  public IDescriptor readMappings(String fcId_p) {
    CreateMappingDescriptorOperation descriptorOperation = new CreateMappingDescriptorOperation(null);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    IDescriptor result = readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readPatternLibraries(java.lang.String)
   */
  @Override
  public IDescriptor readPatternLibraries(String fcId_p) {
    // Do nothing.
    return null;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readProductionPlan(java.lang.String, java.lang.String)
   */
  @Override
  public IProductionPlanDescriptor readProductionPlan(String productionPlanId_p, String fcId_p) {
    CreateProductionPlanDescriptorOperation descriptorOperation = new CreateProductionPlanDescriptorOperation(null, productionPlanId_p);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    IProductionPlanDescriptor result = (IProductionPlanDescriptor) readDescriptor(descriptorOperation);
    return result;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader#readTaskFactory(java.lang.String, java.lang.String)
   */
  @Override
  public ITaskFactoryDescriptor readTaskFactory(String taskFactoryId_p, String fcId_p) {
    CreateTaskFactoryDescriptorOperation descriptorOperation = new CreateTaskFactoryDescriptorOperation(null, taskFactoryId_p);
    descriptorOperation.setPluginModelBase(EgfPdeActivator.getDefault().getPluginModelForFactoryComponent(fcId_p));
    ITaskFactoryDescriptor result = (ITaskFactoryDescriptor) readDescriptor(descriptorOperation);
    return result;
  }
}