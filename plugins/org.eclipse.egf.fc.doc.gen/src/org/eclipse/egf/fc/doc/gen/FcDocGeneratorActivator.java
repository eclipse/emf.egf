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
package org.eclipse.egf.fc.doc.gen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.activator.AbstractUIActivator;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.fc.doc.gen.internal.IFcDocGeneratorConstants;
import org.eclipse.egf.fc.doc.gen.internal.plugin.command.SetTocExtensionCommand;
import org.eclipse.egf.model.Context;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.FactoryComponentInvocation;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.osgi.framework.BundleContext;


public class FcDocGeneratorActivator extends AbstractUIActivator {
  /**
   * The shared instance
   */
  private static FcDocGeneratorActivator __plugin;

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    __plugin = this;
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    __plugin = null;
    super.stop(context_p);
  }

  /**
   * Returns the shared instance
   * @return the shared instance
   */
  public static FcDocGeneratorActivator getDefault() {
    return __plugin;
  }

  /**
   * Generate the documentation for specified factory component.
   * @param factoryComponent_p
   * @return <code>false</code> if generation fails.
   */
  public boolean generateDocumentation(FactoryComponent factoryComponent_p) {
    boolean result = false;
    // Precondition
    if (null == factoryComponent_p) {
      return result;
    }
    // Get the factory component id.
    String updatedFactoryComponentId = factoryComponent_p.getId();
    FactoryComponent instantiatedFcDocGenerator = instantiateFcDocGenerator(updatedFactoryComponentId);
    result = CoreActivator.getDefault().generateFactoryComponentSynchronously(instantiatedFcDocGenerator);
    EgfPdeActivator pdeActivator = EgfPdeActivator.getDefault();
    IProject project = pdeActivator.getProjectForFactoryComponent(updatedFactoryComponentId);
    // Add created files in the binary build entry.
    pdeActivator.addEntryInBinaryBuild(project, IFcDocGeneratorConstants.TOC_FILE_RELATIVE_PATH);
    pdeActivator.addEntryInBinaryBuild(project, IFcDocGeneratorConstants.FC_DOC_HTML_FOLDER_PATH);
    // Update the plug-in file to add a new extension for registering the toc file.
    updatePluginFile(updatedFactoryComponentId);
    // Refresh the project that contains the new generated files.
    ProjectHelper.refreshProject(project, new NullProgressMonitor());
    return result;
  }

  /**
   * Update the plug-in file with the created toc file.
   * @param factoryComponentId_p
   */
  private void updatePluginFile(String factoryComponentId_p) {
    IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
    String pluginId = EgfPdeActivator.getDefault().getPluginIdForFactoryComponent(factoryComponentId_p);
    List<IPluginChangesCommand> commands = new ArrayList<IPluginChangesCommand>(1);
    commands.add(new SetTocExtensionCommand(IFcDocGeneratorConstants.TOC_FILE_RELATIVE_PATH));
    runner.performChangesOnPlugin(pluginId, commands);
  }

  /**
   * Instantiate a FC that runs FC Doc Generator with specified context elements values.
   * @param updatedFactoryComponentId_p
   * @return a not <code>null</code> instance.
   */
  private FactoryComponent instantiateFcDocGenerator(String updatedFactoryComponentId_p) {
    // Create a factory component dynamically.
    FactoryComponent fc = ModelHelper.createEmptyMinimalFC(getClass().getName() + "FC Doc Generator Runner"); //$NON-NLS-1$
    // Add required factory component invocation that references FC Documentation Generator
    FactoryComponentInvocation fcInvocation = ModelHelper.addFactoryComponentInvocation(fc, IFcDocGeneratorConstants.FC_DOC_GENERATOR_ID);
    // Add it a context.
    Context context = ModelFactory.eINSTANCE.createContext();
    fcInvocation.setContext(context);
    // Put a plug-in id that is able to instantiate classes involved in context elements.
    String pluginId = getPluginID();
    // Fill 'updatedFactoryComponentId' contract element.
    ModelHelper.addReferencingContractContextElement(context, fcInvocation.getFactoryComponentId(), IFcDocGeneratorConstants.CONTRACT_ELEMENT_UPDATED_FC_ID,
                                                     updatedFactoryComponentId_p, pluginId);
    return fc;
  }
}