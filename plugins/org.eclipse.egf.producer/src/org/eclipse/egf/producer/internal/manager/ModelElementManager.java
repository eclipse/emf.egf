/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.internal.manager;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ModelElementManager<P extends ModelElement, T extends ModelElement> implements IModelElementManager<P, T> {

    protected static BasicDiagnostic getDiagnostic(ModelElement element, boolean runtime) {
        String message = null;
        if (element instanceof NamedModelElement) {
            NamedModelElement namedElement = (NamedModelElement) element;
            if (namedElement.getName() != null && namedElement.getName().trim().length() != 0) {
                if (runtime) {
                    message = NLS.bind(ProducerMessages.RuntimeCanInvoke_Diagnosis_message, namedElement.getName());
                } else {
                    message = NLS.bind(ProducerMessages.CanInvoke_Diagnosis_message, namedElement.getName());
                }
            }
        }
        if (message == null) {
            if (runtime) {
                message = NLS.bind(ProducerMessages.RuntimeCanInvoke_Diagnosis_message, element.eClass().getName());
            } else {
                message = NLS.bind(ProducerMessages.CanInvoke_Diagnosis_message, element.eClass().getName());
            }
        }
        return new BasicDiagnostic(EGFProducerPlugin.getDefault().getPluginID(), 0, message, new Object[] {
            element
        });
    }

    protected static <M extends ModelElement> void populateContext(ProductionContext<?, M> context, Bundle bundle, M key, ContractMode mode, Type type, Object value) throws InvocationException {
        // Class
        if (type instanceof TypeAbstractClass) {
            try {
                // Store
                String fqcn = (String) value;
                TypeAbstractClass abstractClass = (TypeAbstractClass) type;
                // TypeClass with null value are simply ignored and as such not exposed in the ProductionContext
                if (type instanceof TypeClass && (fqcn == null || fqcn.trim().length() == 0)) {
                    return;
                }
                // Do we have an instance value
                Object object = abstractClass.getInstance();
                // Should we instantiate our String value
                if (object == null) {
                    // Null value is a valid value except for TypeClass
                    if (fqcn != null && fqcn.trim().length() != 0) {
                        object = BundleHelper.instantiate(fqcn.trim(), bundle);
                        if (object == null) {
                            throw new InvocationException(NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, fqcn, bundle.getSymbolicName()));
                        }
                    }
                }
                // Type and object are validated in the ProductionContext while added
                if (mode == ContractMode.IN) {
                    context.addInputData(key, abstractClass.getType(), object, true);
                } else if (mode == ContractMode.OUT) {
                    context.addOutputData(key, abstractClass.getType(), null, true);
                } else if (mode == ContractMode.IN_OUT) {
                    context.addInputData(key, abstractClass.getType(), object, true);
                    context.addOutputData(key, abstractClass.getType(), object, true);
                }
            } catch (Throwable t) {
                throw new InvocationException(NLS.bind(EGFCoreMessages.ProjectBundleSession_BundleClassInstantiationFailure, value, bundle.getSymbolicName()), t);
            }
        } else {
            // Type and object are validated in the ProductionContext while added
            if (mode == ContractMode.IN) {
                context.addInputData(key, type.getType(), value, true);
            } else if (mode == ContractMode.OUT) {
                context.addOutputData(key, type.getType(), null, true);
            } else if (mode == ContractMode.IN_OUT) {
                context.addInputData(key, type.getType(), value, true);
                context.addOutputData(key, type.getType(), value, true);
            }
        }
    }

    private P _element;

    protected IModelElementManager<?, ?> _parent;

    protected IProductionContext<P, T> _productionContext;

    private Bundle _bundle;

    private ProjectBundleSession _session;

    private IPlatformFcore _fcore;

    public ModelElementManager(P element) throws InvocationException {
        Assert.isNotNull(element);
        _element = element;
        if (_element.eIsProxy())
        	throw new InvocationException(NLS.bind(EGFCoreMessages.EObject_is_proxy, EcoreUtil.getURI(_element)));
        if (_element.eResource() == null) {
            throw new InvocationException( NLS.bind(EGFCoreMessages.EObject_no_Resource, EcoreUtil.getURI(_element)));
        }
        if (_element.eResource() instanceof IPlatformFcoreProvider) {
            _fcore = ((IPlatformFcoreProvider) _element.eResource()).getIPlatformFcore();
        }
        if (_fcore == null) {
            throw new InvocationException(NLS.bind(EGFCoreMessages.Fcore_not_found, EcoreUtil.getURI(_element).trimFragment()));
        }
    }

    public ModelElementManager(Bundle bundle, P element) {
        Assert.isNotNull(bundle);
        Assert.isNotNull(element);
        _bundle = bundle;
        _element = element;
    }

    public ModelElementManager(IModelElementManager<?, ?> parent, P element) throws InvocationException {
        Assert.isNotNull(parent);
        Assert.isNotNull(element);
        _parent = parent;
        _element = element;
        if (_element.eResource() == null && parent.getBundle() == null) {
            throw new InvocationException(NLS.bind(EGFCoreMessages.EObject_no_Bundle, EcoreUtil.getURI(_element)));
        }
        if (_element.eResource() != null) {
            if (_element.eResource() instanceof IPlatformFcoreProvider) {
                _fcore = ((IPlatformFcoreProvider) _element.eResource()).getIPlatformFcore();
            }
            if (_fcore == null) {
                throw new InvocationException(NLS.bind(EGFCoreMessages.Fcore_not_found, EcoreUtil.getURI(_element).trimFragment()));
            }
        }
    }

    public P getElement() {
        return _element;
    }

    public IProductionContext<P, T> getProductionContext() throws InvocationException {
        return getInternalProductionContext();
    }

    public IModelElementManager<?, ?> getParent() {
        return _parent;
    }

    protected abstract ProductionContext<P, T> getInternalProductionContext() throws InvocationException;

    public String getName() {
        return EMFHelper.getText(getElement());
    }

    public Bundle getBundle() throws InvocationException {
        // Platform
        if (_fcore != null) {
            // Runtime or target associated with a runtime bundle
            if (_fcore.isRuntime() || _fcore.getBundle() != null) {
                return _fcore.getBundle();
            }
            // Workspace Bundle
            if (_fcore.isWorkspace()) {
                try {
                    return BundleSessionHelper.getBundle(getProjectBundleSession(), _fcore);
                } catch (Throwable t) {
                    throw new InvocationException(t);
                }
            }
            // Cannot associate a Bundle to a target platform fcore
            throw new InvocationException(NLS.bind(EGFCoreMessages.TargetPlatform_ExtensionPoint_no_bundle, _fcore.getPlatformBundle().getBundleId()));
        }
        // Memory takes its bundle from its parent
        if (getParent() != null) {
            return getParent().getBundle();
        }
        // Parent
        return _bundle;
    }

    public ProjectBundleSession getProjectBundleSession() {
        if (getParent() != null) {
            return getParent().getProjectBundleSession();
        }
        if (_session == null) {
            _session = new ProjectBundleSession(EGFProducerPlugin.getDefault().getBundle().getBundleContext());
        }
        return _session;
    }

    public void setProjectBundleSession(ProjectBundleSession session) {
        if (getParent() != null) {
            getParent().setProjectBundleSession(session);
        } else {
            _session = session;
        }

    }

    @SuppressWarnings("unused")
    protected BasicDiagnostic checkInputElement(boolean runtime) throws InvocationException {
        return getDiagnostic(getElement(), runtime);
    }

    @SuppressWarnings("unused")
    protected BasicDiagnostic checkOutputElement(BasicDiagnostic diagnostic) throws InvocationException {
        return diagnostic;
    }

    public Diagnostic canInvoke() throws InvocationException {
        return checkInputElement(false);
    }

    public abstract void initializeContext() throws InvocationException;

    public void dispose() throws InvocationException {
        if (_session != null) {
            try {
                _session.dispose();
            } catch (Throwable t) {
                throw new InvocationException(t);
            }
        }
    }

}
