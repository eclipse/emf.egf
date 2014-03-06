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
package org.eclipse.egf.pattern.internal.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class PatternExtensionRegistry implements IRegistryEventListener {

    private Map<String, PatternExtensionProxy> _proxies;

    /**
     * Define a constant for the pattern extension extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.pattern.extension"; //$NON-NLS-1$  

    /**
     * Define a constant for the 'nature' attribute.
     */
    public static final String ATT_NATURE = "nature"; //$NON-NLS-1$    

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String ATT_CLASS = "class"; //$NON-NLS-1$    

    public PatternExtensionRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    public Set<String> getPatternNatures() {
        return _proxies.keySet();
    }

    public PatternExtension getPatternExtension(PatternNature nature) throws CoreException {
        PatternExtensionProxy proxy = _proxies.get(nature.eClass().getName());
        if (proxy == null) {
            throw new CoreException(EGFModelPlugin.getPlugin().newStatus(IStatus.ERROR, NLS.bind(EGFPatternMessages.PatternExtensionRegistry_extension_error, nature.eClass().getInstanceTypeName()), null));
        }
        return proxy.getPatternExtension();
    }

    public PatternExtension getPatternExtension(String name) throws CoreException {
        for (PatternExtensionProxy proxy : _proxies.values()) {
            if (name.equals(proxy.getName())) {
                return proxy.getPatternExtension();
            }
        }
        return null;
    }

    private void initialize() {
        if (_proxies != null) {
            return;
        }
        _proxies = new HashMap<String, PatternExtensionProxy>();
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
        PatternExtensionProxy proxy = PatternExtensionProxy.createProxy(element);
        if (proxy != null) {
            if (_proxies.get(proxy.getName()) != null) {
                EGFPatternPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Duplicate_Element_Message, proxy.getNature()));
                EGFPatternPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, element.getContributor().getName()), 1);
                EGFPatternPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, element.getName()), 1);
            }
            _proxies.put(proxy.getName(), proxy);
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
            for (Iterator<PatternExtensionProxy> it = _proxies.values().iterator(); it.hasNext();) {
                PatternExtensionProxy proxy = it.next();
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
