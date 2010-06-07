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
package org.eclipse.egf.producer.internal.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class OrchestrationManagerProducerRegistry implements IRegistryEventListener {

    private Map<String, OrchestrationManagerProducerProxy> _producers;

    /**
     * Define a constant for the orchestrationManagerProducer extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.producer.orchestrationManagerProducer"; //$NON-NLS-1$

    /**
     * Define a constant for the 'orchestration' attribute.
     */
    public static final String INVOKER_ATT_ORCHESTRATION = "orchestration"; //$NON-NLS-1$        

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$    

    public OrchestrationManagerProducerRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    public <P extends Orchestration> OrchestrationManagerProducer<P> getOrchestrationManagerProducer(P orchestration) throws CoreException {
        OrchestrationManagerProducerProxy proxy = _producers.get(orchestration.eClass().getInstanceTypeName());
        if (proxy == null) {
            throw new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.OrchestrationManagerProducer_extension_error, orchestration.eClass().getInstanceTypeName()), null));
        }
        return proxy.getOrchestrationManagerProducer(orchestration);
    }

    private void initialize() {
        if (_producers != null) {
            return;
        }
        _producers = new HashMap<String, OrchestrationManagerProducerProxy>();
        IExtensionPoint point = RegistryFactory.getRegistry().getExtensionPoint(EXTENSION_ID);
        if (point != null) {
            for (IExtension extension : point.getExtensions()) {
                for (IConfigurationElement element : extension.getConfigurationElements()) {
                    register(element);
                }
            }
        }
    }

    private void register(IConfigurationElement element) {
        if (element == null) {
            return;
        }
        OrchestrationManagerProducerProxy proxy = OrchestrationManagerProducerProxy.createProxy(element);
        if (proxy != null) {
            if (_producers.get(proxy.getOrchestration()) != null) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Duplicate_Element_Message, proxy.getOrchestration()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, element.getName()), 1);
            }
            _producers.put(proxy.getOrchestration(), proxy);
        }
    }

    public void added(IExtension[] extensions) {
        if (extensions == null) {
            return;
        }
        for (IExtension extension : extensions) {
            for (IConfigurationElement element : extension.getConfigurationElements()) {
                register(element);
            }
        }
    }

    public void removed(IExtension[] extensions) {
        for (int i = 0; i < extensions.length; i++) {
            for (Iterator<OrchestrationManagerProducerProxy> it = _producers.values().iterator(); it.hasNext();) {
                OrchestrationManagerProducerProxy proxy = it.next();
                if (proxy.originatesFrom(extensions[i])) {
                    it.remove();
                }
            }
        }
    }

    public void added(IExtensionPoint[] extensionPoints) {
        // Nothing to do
    }

    public void removed(IExtensionPoint[] extensionPoints) {
        // Nothing to do
    }

    public void dispose() {
        RegistryFactory.getRegistry().removeListener(this);
        _producers = null;
    }

}
