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
package org.eclipse.egf.common.internal.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.common.log.IEGFLogger;
import org.eclipse.egf.common.log.IEGFLoggerRegistry;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class EGFLoggerRegistry implements IEGFLoggerRegistry, IRegistryEventListener {

    private List<EGFLoggerProxy> _loggers;

    /**
     * Define a constant for the Task extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.common.logger"; //$NON-NLS-1$

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$    

    public List<IEGFLogger> getEGFLoggers() {
        List<IEGFLogger> loggers = new ArrayList<IEGFLogger>();
        for (EGFLoggerProxy proxy : _loggers) {
            loggers.add(proxy.getEGFLogger());
        }
        return loggers;
    }

    public EGFLoggerRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    private void initialize() {
        if (_loggers != null) {
            return;
        }
        _loggers = new ArrayList<EGFLoggerProxy>();
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
        EGFLoggerProxy loggerProxy = EGFLoggerProxy.createProxy(element);
        if (loggerProxy != null) {
            _loggers.add(loggerProxy);
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
            for (Iterator<EGFLoggerProxy> it = _loggers.iterator(); it.hasNext();) {
                EGFLoggerProxy proxy = it.next();
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
        _loggers = null;
    }

}
