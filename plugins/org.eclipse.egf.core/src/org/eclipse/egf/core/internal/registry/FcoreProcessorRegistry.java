/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.internal.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.core.processor.IFcoreProcessor;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class FcoreProcessorRegistry implements IRegistryEventListener {

    private List<FcoreProcessorProxy> _proxies;

    /**
     * Define a constant for the processor extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.core.fcoreProcessor"; //$NON-NLS-1$      

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$

    public FcoreProcessorRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    public List<IFcoreProcessor> getIFcoreProcessors() {
        List<IFcoreProcessor> loggers = new ArrayList<IFcoreProcessor>();
        for (FcoreProcessorProxy proxy : _proxies) {
            IFcoreProcessor processor = proxy.getIFcoreProcessor();
            if (processor != null) {
                loggers.add(processor);
            }
        }
        return loggers;
    }

    private void initialize() {
        if (_proxies != null) {
            return;
        }
        _proxies = new ArrayList<FcoreProcessorProxy>();
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
        FcoreProcessorProxy proxy = FcoreProcessorProxy.createProxy(element);
        if (proxy != null) {
            _proxies.add(proxy);
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
            for (Iterator<FcoreProcessorProxy> it = _proxies.iterator(); it.hasNext();) {
                FcoreProcessorProxy proxy = it.next();
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
