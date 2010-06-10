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
package org.eclipse.egf.core.ui.internal.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.core.ui.contributor.EditorListenerContributor;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class EditorListenerContributorRegistry implements IRegistryEventListener {

    private ArrayList<EditorListenerContributorProxy> _listeners;

    /**
     * Define a constant for the Editor Listener Contributor extension-point id.
     */
    public static final String EXTENSION_ID = "org.eclipse.egf.core.ui.editor.listener.contributor"; //$NON-NLS-1$

    /**
     * Define a constant for the 'class' attribute.
     */
    public static final String INVOKER_ATT_CLASS = "class"; //$NON-NLS-1$    

    public List<EditorListenerContributor> getEditorListenerContributors() {
        List<EditorListenerContributor> listeners = new ArrayList<EditorListenerContributor>();
        for (EditorListenerContributorProxy proxy : _listeners) {
            listeners.add(proxy.getEditorListenerContributor());
        }
        return listeners;
    }

    public EditorListenerContributorRegistry() {
        initialize();
        RegistryFactory.getRegistry().addListener(this, EXTENSION_ID);
    }

    private void initialize() {
        if (_listeners != null) {
            return;
        }
        _listeners = new ArrayList<EditorListenerContributorProxy>();
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
        EditorListenerContributorProxy proxy = EditorListenerContributorProxy.createProxy(element);
        if (proxy != null) {
            _listeners.add(proxy);
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
            for (Iterator<EditorListenerContributorProxy> it = _listeners.iterator(); it.hasNext();) {
                EditorListenerContributorProxy proxy = it.next();
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
        for (EditorListenerContributorProxy proxy : _listeners) {
            proxy.dispose();
        }
        _listeners = null;
    }

}
