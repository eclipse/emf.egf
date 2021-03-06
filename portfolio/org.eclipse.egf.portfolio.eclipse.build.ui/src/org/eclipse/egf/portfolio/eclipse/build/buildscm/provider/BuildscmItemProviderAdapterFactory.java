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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.util.BuildcoreSwitch;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployPackage;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.util.BuilddeploySwitch;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.util.BuildscmAdapterFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.AbstractBuildLocationContainer;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.util.BuildstepSwitch;
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
public class BuildscmItemProviderAdapterFactory extends BuildscmAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
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
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(BuildSCMEditPlugin.INSTANCE, BuildscmPackage.eNS_URI);

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
    public BuildscmItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SVNItemProvider svnItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createSVNAdapter() {
		if (svnItemProvider == null) {
			svnItemProvider = new SVNItemProvider(this);
		}

		return svnItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SVNLocationItemProvider svnLocationItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createSVNLocationAdapter() {
		if (svnLocationItemProvider == null) {
			svnLocationItemProvider = new SVNLocationItemProvider(this);
		}

		return svnLocationItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SVNBuildLocationItemProvider svnBuildLocationItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createSVNBuildLocationAdapter() {
		if (svnBuildLocationItemProvider == null) {
			svnBuildLocationItemProvider = new SVNBuildLocationItemProvider(this);
		}

		return svnBuildLocationItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNGenerationLocation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SVNGenerationLocationItemProvider svnGenerationLocationItemProvider;

				/**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNGenerationLocation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSVNGenerationLocationAdapter() {
		if (svnGenerationLocationItemProvider == null) {
			svnGenerationLocationItemProvider = new SVNGenerationLocationItemProvider(this);
		}

		return svnGenerationLocationItemProvider;
	}

				/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected GITItemProvider gitItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createGITAdapter() {
		if (gitItemProvider == null) {
			gitItemProvider = new GITItemProvider(this);
		}

		return gitItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected GITLocationItemProvider gitLocationItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITLocation}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createGITLocationAdapter() {
		if (gitLocationItemProvider == null) {
			gitLocationItemProvider = new GITLocationItemProvider(this);
		}

		return gitLocationItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation} instances.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected GITBuildLocationItemProvider gitBuildLocationItemProvider;

    /**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createGITBuildLocationAdapter() {
		if (gitBuildLocationItemProvider == null) {
			gitBuildLocationItemProvider = new GITBuildLocationItemProvider(this);
		}

		return gitBuildLocationItemProvider;
	}

    /**
	 * This keeps track of the one adapter used for all {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITGenerationLocation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GITGenerationLocationItemProvider gitGenerationLocationItemProvider;

				/**
	 * This creates an adapter for a {@link org.eclipse.egf.portfolio.eclipse.build.buildscm.GITGenerationLocation}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Adapter createGITGenerationLocationAdapter() {
		if (gitGenerationLocationItemProvider == null) {
			gitGenerationLocationItemProvider = new GITGenerationLocationItemProvider(this);
		}

		return gitGenerationLocationItemProvider;
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
		if (svnItemProvider != null) svnItemProvider.dispose();
		if (svnLocationItemProvider != null) svnLocationItemProvider.dispose();
		if (svnBuildLocationItemProvider != null) svnBuildLocationItemProvider.dispose();
		if (svnGenerationLocationItemProvider != null) svnGenerationLocationItemProvider.dispose();
		if (gitItemProvider != null) gitItemProvider.dispose();
		if (gitLocationItemProvider != null) gitLocationItemProvider.dispose();
		if (gitBuildLocationItemProvider != null) gitBuildLocationItemProvider.dispose();
		if (gitGenerationLocationItemProvider != null) gitGenerationLocationItemProvider.dispose();
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
            public Object caseJob(Job object) {

				newChildDescriptors.add
					(createChildParameter
						(BuildcorePackage.Literals.JOB__SCMS,
						 BuildscmFactory.eINSTANCE.createSVN()));




				newChildDescriptors.add
					(createChildParameter
						(BuildcorePackage.Literals.JOB__SCMS,
						 BuildscmFactory.eINSTANCE.createGIT()));



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
			return BuildSCMEditPlugin.INSTANCE;
		}
    }

    /**
	 * A child creation extender for the {@link BuilddeployPackage}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static class BuilddeployChildCreationExtender implements IChildCreationExtender {
        /**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        protected static class CreationSwitch extends BuilddeploySwitch<Object> {
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
            public Object caseHudsonDeployment(HudsonDeployment object) {

				newChildDescriptors.add
					(createChildParameter
						(BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__GENERATION_LOCATION,
						 BuildscmFactory.eINSTANCE.createSVNGenerationLocation()));




				newChildDescriptors.add
					(createChildParameter
						(BuilddeployPackage.Literals.HUDSON_DEPLOYMENT__GENERATION_LOCATION,
						 BuildscmFactory.eINSTANCE.createGITGenerationLocation()));



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
			return BuildSCMEditPlugin.INSTANCE;
		}
    }

    /**
	 * A child creation extender for the {@link BuildstepPackage}.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static class BuildstepChildCreationExtender implements IChildCreationExtender {
        /**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        protected static class CreationSwitch extends BuildstepSwitch<Object> {
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
            public Object caseAbstractBuildLocationContainer(AbstractBuildLocationContainer object) {

				newChildDescriptors.add
					(createChildParameter
						(BuildstepPackage.Literals.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS,
						 BuildscmFactory.eINSTANCE.createSVNBuildLocation()));




				newChildDescriptors.add
					(createChildParameter
						(BuildstepPackage.Literals.ABSTRACT_BUILD_LOCATION_CONTAINER__BUILD_LOCATIONS,
						 BuildscmFactory.eINSTANCE.createGITBuildLocation()));



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
			return BuildSCMEditPlugin.INSTANCE;
		}
    }

}
