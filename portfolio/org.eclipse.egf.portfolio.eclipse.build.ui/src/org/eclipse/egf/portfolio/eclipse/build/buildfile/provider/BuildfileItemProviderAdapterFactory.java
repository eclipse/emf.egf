/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildfile.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.util.BuildcoreSwitch;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfileFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.util.BuildfileAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildfileItemProviderAdapterFactory extends BuildfileAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(BuildFileEditPlugin.INSTANCE, BuildfilePackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildfileItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.AntParameter} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AntParameterItemProvider antParameterItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.AntParameter}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAntParameterAdapter() {
        if (antParameterItemProvider == null) {
            antParameterItemProvider = new AntParameterItemProvider(this);
        }

        return antParameterItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ZipStepItemProvider zipStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createZipStepAdapter() {
        if (zipStepItemProvider == null) {
            zipStepItemProvider = new ZipStepItemProvider(this);
        }

        return zipStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UnzipStepItemProvider unzipStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createUnzipStepAdapter() {
        if (unzipStepItemProvider == null) {
            unzipStepItemProvider = new UnzipStepItemProvider(this);
        }

        return unzipStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MoveStepItemProvider moveStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createMoveStepAdapter() {
        if (moveStepItemProvider == null) {
            moveStepItemProvider = new MoveStepItemProvider(this);
        }

        return moveStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RenameStepItemProvider renameStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRenameStepAdapter() {
        if (renameStepItemProvider == null) {
            renameStepItemProvider = new RenameStepItemProvider(this);
        }

        return renameStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DeleteStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DeleteStepItemProvider deleteStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DeleteStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDeleteStepAdapter() {
        if (deleteStepItemProvider == null) {
            deleteStepItemProvider = new DeleteStepItemProvider(this);
        }

        return deleteStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CopyStepItemProvider copyStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createCopyStepAdapter() {
        if (copyStepItemProvider == null) {
            copyStepItemProvider = new CopyStepItemProvider(this);
        }

        return copyStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DownloadStepItemProvider downloadStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDownloadStepAdapter() {
        if (downloadStepItemProvider == null) {
            downloadStepItemProvider = new DownloadStepItemProvider(this);
        }

        return downloadStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CreateFolderStepItemProvider createFolderStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createCreateFolderStepAdapter() {
        if (createFolderStepItemProvider == null) {
            createFolderStepItemProvider = new CreateFolderStepItemProvider(this);
        }

        return createFolderStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep} instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TarStepItemProvider tarStepItemProvider;

				/**
     * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Adapter createTarStepAdapter() {
        if (tarStepItemProvider == null) {
            tarStepItemProvider = new TarStepItemProvider(this);
        }

        return tarStepItemProvider;
    }

				/**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
        return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator() {
        return childCreationExtenderManager;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (antParameterItemProvider != null) antParameterItemProvider.dispose();
        if (zipStepItemProvider != null) zipStepItemProvider.dispose();
        if (unzipStepItemProvider != null) unzipStepItemProvider.dispose();
        if (moveStepItemProvider != null) moveStepItemProvider.dispose();
        if (renameStepItemProvider != null) renameStepItemProvider.dispose();
        if (deleteStepItemProvider != null) deleteStepItemProvider.dispose();
        if (copyStepItemProvider != null) copyStepItemProvider.dispose();
        if (downloadStepItemProvider != null) downloadStepItemProvider.dispose();
        if (createFolderStepItemProvider != null) createFolderStepItemProvider.dispose();
        if (tarStepItemProvider != null) tarStepItemProvider.dispose();
    }

    /**
     * A child creation extender for the {@link BuildcorePackage}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class BuildcoreChildCreationExtender implements IChildCreationExtender {
        /**
         * The switch for creating child descriptors specific to each extended class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static class CreationSwitch extends BuildcoreSwitch<Object> {
            /**
             * The child descriptors being populated.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected List<Object> newChildDescriptors;

            /**
             * The domain in which to create the children.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected EditingDomain editingDomain;

            /**
             * Creates the a switch for populating child descriptors in the given domain.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
                this.newChildDescriptors = newChildDescriptors;
                this.editingDomain = editingDomain;
            }
            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            @Override
            public Object caseAbstractStepContainer(AbstractStepContainer object) {

                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createZipStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createUnzipStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createMoveStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createRenameStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createDeleteStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createCopyStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createDownloadStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createCreateFolderStep()));




                newChildDescriptors.add
                    (createChildParameter
                        (BuildcorePackage.Literals.ABSTRACT_STEP_CONTAINER__STEPS,
                         BuildfileFactory.eINSTANCE.createTarStep()));



                return null;
            }
 
            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected CommandParameter createChildParameter(Object feature, Object child) {
                return new CommandParameter(null, feature, child);
            }

        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
            ArrayList<Object> result = new ArrayList<Object>();
           new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
           return result;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ResourceLocator getResourceLocator() {
            return BuildFileEditPlugin.INSTANCE;
        }
    }

}
