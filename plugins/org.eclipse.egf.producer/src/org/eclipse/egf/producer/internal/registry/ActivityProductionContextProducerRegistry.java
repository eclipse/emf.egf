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
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.ActivityProductionContextProducer;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class ActivityProductionContextProducerRegistry implements IRegistryEventListener {

    private Map<String, ActivityProductionContextProducerProxy> _proxies;

    /**
     * Define a constant for the activityProductionContextProducer extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.producer.activityProductionContextProducer"; //$NON-NLS-1$

    /**
     * Define a constant for the 'activity' attribute.
     */
    public static final String INVOKER_ATT_ACTIVITY = "activity"; //$NON-NLS-1$        

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$    

    public ActivityProductionContextProducerRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    public <P extends Activity> ActivityProductionContextProducer<P> getActivityProductionContextProducer(P activity) throws CoreException {
        ActivityProductionContextProducerProxy proxy = _proxies.get(activity.eClass().getInstanceTypeName());
        if (proxy == null) {
            throw new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ProducerMessages.ActivityProductionContextProducer_extension_error, activity.eClass().getInstanceTypeName()), null));
        }
        return proxy.getActivityProductionContextProducer(activity);
    }

    private void initialize() {
        if (_proxies != null) {
            return;
        }
        _proxies = new HashMap<String, ActivityProductionContextProducerProxy>();
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
        ActivityProductionContextProducerProxy proxy = ActivityProductionContextProducerProxy.createProxy(element);
        if (proxy != null) {
            if (_proxies.get(proxy.getActivity()) != null) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Duplicate_Element_Message, proxy.getActivity()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, element.getName()), 1);
            }
            _proxies.put(proxy.getActivity(), proxy);
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
            for (Iterator<ActivityProductionContextProducerProxy> it = _proxies.values().iterator(); it.hasNext();) {
                ActivityProductionContextProducerProxy proxy = it.next();
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
        _proxies = null;
    }

}
