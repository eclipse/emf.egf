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

package org.eclipse.egf.core.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.ui.activator.AbstractUIActivator;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.core.ui.data.ElementAdapterFactory;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentInWorkspace;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet;
import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSetManager;
import org.eclipse.egf.core.ui.data.fc.FactoryComponentInPlatform;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.provider.ModelItemProviderAdapterFactory;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
public class EgfUiActivator extends AbstractUIActivator {

  /**
   * The shared instance
   */
  private static EgfUiActivator __plugin;

  /**
   * Edit domain used to deal with EGF data.
   */
  private AdapterFactoryEditingDomain _editingDomain;

  /**
   * Edit domain used to deal with EGF data in a read only context.
   */
  private AdapterFactoryEditingDomain _editingDomainInReadOnly;

  /**
   * Reference to the container that holds factory components located in the workspace.
   */
  private FactoryComponentInWorkspace _factoryComponentInWorkspace;

  /**
   * Container where working sets are managed for the current workspace.
   */
  private FactoryComponentWorkingSetManager _factoryComponentWorkingSetManager;

  /**
   * Reference to the container that holds factory components located in the running Eclipse instance.
   */
  private FactoryComponentInPlatform _factoryComponentInPlatform;

  /**
   * Adapter factory for non EMF objects.
   */
  private static final ElementAdapterFactory _factory = new ElementAdapterFactory();

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
    // Force to load the Core plug-in.
    CoreActivator.getDefault();
    // Register adapter
    Platform.getAdapterManager().registerAdapters(_factory, FactoryComponentInWorkspace.class);
    Platform.getAdapterManager().registerAdapters(_factory, FactoryComponentInPlatform.class);
    Platform.getAdapterManager().registerAdapters(_factory, FactoryComponentWorkingSetManager.class);
    Platform.getAdapterManager().registerAdapters(_factory, FactoryComponentWorkingSet.class);
    // Force to load the editing domains that seem to be time consuming when instantiating.
    getEditingDomain();
    getEditingDomainInReadOnly();
  }

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    try {
      // Unregister the adapter factory.
      Platform.getAdapterManager().unregisterAdapters(_factory);
      // Dispose working set manager.
      if (null != _factoryComponentWorkingSetManager) {
        _factoryComponentWorkingSetManager.dispose();
        _factoryComponentWorkingSetManager = null;
      }
    } finally {
      __plugin = null;      
      super.stop(context);
    }
  }

  /**
   * Returns the shared instance
   * @return the shared instance
   */
  public static EgfUiActivator getDefault() {
    return __plugin;
  }

  /**
   * Return an input related to factory components in the workspace.
   * @return not null object.
   */
  public IAdaptable getFactoryComponentInWorkspaceInput() {
    return getFactoryComponentInWorkspace();
  }

  /**
   * Return an input related to factory components in the workspace.
   * @return not null object.
   */
  public IAdaptable getWorkingSetsInput() {
    if (null == _factoryComponentWorkingSetManager) {
      _factoryComponentWorkingSetManager = new FactoryComponentWorkingSetManager();
    }
    return _factoryComponentWorkingSetManager;
  }

  /**
   * Return an input related to factory components in the platform.
   * @return a not null object.
   */
  public IAdaptable getFactoryComponentInPlatormInput() {
    return getFactoryComponentInPlatform();
  }

  /**
   * Return all factory components located in both workspace and running Eclipse platform.
   * @return a not null list.
   */
  public List<FactoryComponent> getAllFactoryComponents() {
    // Get factory components from the workspace.
    List<FactoryComponent> allFcs = getWorkspaceFactoryComponents();
    // Append factory components from the platform.
    allFcs.addAll(getTargetPlatformFactoryComponents());
    return allFcs;
  }

  /**
   * Return all factory components located in the running Eclipse platform.
   * @return a not null list.
   */
  public List<FactoryComponent> getTargetPlatformFactoryComponents() {
    // Get factory components from the target platform.
    return new ArrayList<FactoryComponent>(getFactoryComponentInPlatform().getFactoryComponents());
  }

  /**
   * Return all factory components located in the workspace.
   * @return a not null list.
   */
  public List<FactoryComponent> getWorkspaceFactoryComponents() {
    // Get factory components from the workspace.
    return new ArrayList<FactoryComponent>(getFactoryComponentInWorkspace().getFactoryComponents());
  }

  /**
   * Get the object that manages all factory components located in the workspace.
   * @return
   */
  private FactoryComponentInWorkspace getFactoryComponentInWorkspace() {
    // Lazy creation pattern.
    if (null == _factoryComponentInWorkspace) {
      _factoryComponentInWorkspace = new FactoryComponentInWorkspace();
    }
    return _factoryComponentInWorkspace;
  }

  /**
   * Get the object that manages all factory components located in the target platform.
   * @return
   */
  private FactoryComponentInPlatform getFactoryComponentInPlatform() {
    // Lazy creation pattern.
    if (null == _factoryComponentInPlatform) {
      _factoryComponentInPlatform = new FactoryComponentInPlatform();
    }
    return _factoryComponentInPlatform;
  }

  /**
   * Get the editing domain to deal with EGF model elements. <br>
   * This editing domain supports model elements modifications.
   * @return a not null {@link AdapterFactoryEditingDomain} instance.
   */
  public AdapterFactoryEditingDomain getEditingDomain() {
    if (null == _editingDomain) {
      // Create the adapter factory.
      ExtendedComposedAdapterFactory adapterFactory = createAdapterFactory();
      // Create the editing domain.
      _editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
      // Initialize the created editing domain.
      initializeEditingDomain(_editingDomain, adapterFactory);
    }
    return _editingDomain;
  }

  /**
   * Initialize the editing domain.
   * @param editingDomain_p
   * @param adapterFactory_p
   */
  private void initializeEditingDomain(AdapterFactoryEditingDomain editingDomain_p, ExtendedComposedAdapterFactory adapterFactory_p) {
    // Set the editing domain on the adapter factory.
    // Without this trick, all changes made on model element objects by the property sheet page are not performed through the EMF command mechanism.
    // We must do that because our model elements objects are not stored in resources (ResourceSet).
    adapterFactory_p.setEditingDomainProvider(editingDomain_p);
  }

  /**
   * Get the editing domain to deal with EGF model elements in a read only context. *
   * @return a not null {@link AdapterFactoryEditingDomain} instance.
   */
  public AdapterFactoryEditingDomain getEditingDomainInReadOnly() {
    if (null == _editingDomainInReadOnly) {
      // Create the adapter factory
      ExtendedComposedAdapterFactory adapterFactory = createAdapterFactory();
      // Create the editing domain.
      _editingDomainInReadOnly = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack()) {

        /**
         * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#isReadOnly(org.eclipse.emf.ecore.resource.Resource)
         */
        @Override
        public boolean isReadOnly(Resource resource_p) {
          return true;
        }
      };
      // Initialize the created editing domain.
      initializeEditingDomain(_editingDomainInReadOnly, adapterFactory);
    }
    return _editingDomainInReadOnly;
  }

  /**
   * Create adapter factory.
   */
  private ExtendedComposedAdapterFactory createAdapterFactory() {
    // Create an adapter factory that yields item providers.
    return new ExtendedComposedAdapterFactory(new ModelItemProviderAdapterFactory());
  }

  /**
   * Implements a {@link ComposedAdapterFactory} which is also an editing domain provider.
   * @author fournier
   */
  private class ExtendedComposedAdapterFactory extends ComposedAdapterFactory implements IEditingDomainProvider {

    private EditingDomain _editingDomainProvider;

    /**
     * Constructor.
     * @param adapterFactories_p
     */
    public ExtendedComposedAdapterFactory(AdapterFactory adapterFactory_p) {
      super(adapterFactory_p);
    }

    /**
     * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
     */
    public EditingDomain getEditingDomain() {
      return _editingDomainProvider;
    }

    /**
     * Set given editing domain.
     * @param editingDomainProvider_p
     */
    protected void setEditingDomainProvider(EditingDomain editingDomainProvider_p) {
      _editingDomainProvider = editingDomainProvider_p;
    }
  }
}
