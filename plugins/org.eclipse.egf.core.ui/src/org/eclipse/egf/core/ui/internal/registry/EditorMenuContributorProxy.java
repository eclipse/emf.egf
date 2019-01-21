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
package org.eclipse.egf.core.ui.internal.registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.core.ui.contributor.IMenuEditorActionBarContributor;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EditorMenuContributorProxy {

    private IConfigurationElement _element;

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private String _class;

    private Map<IMenuEditorActionBarContributor, EditorMenuContributor> _executables = new HashMap<IMenuEditorActionBarContributor, EditorMenuContributor>();

    /**
     * @return the _uniqueIdentifier
     */
    public String getUniqueIdentifier() {
        return _uniqueIdentifier;
    }

    /**
     * @return the _handleId
     */
    public int getHandleId() {
        return _handleId;
    }

    /**
     * @return a list of EditorMenuContributor
     */
    public EditorMenuContributor createEditorMenuContributor(IMenuEditorActionBarContributor parent) {
        if (parent == null) {
            return null;
        }
        EditorMenuContributor menu = _executables.get(parent);
        if (menu != null) {
            return menu;
        }
        if (_element.isValid() == false) {
            return null;
        }
        try {
            Object object = _element.createExecutableExtension(EditorMenuContributorRegistry.INVOKER_ATT_CLASS);
            if (object == null) {
                return null;
            }
            if (object instanceof EditorMenuContributor == false) {
                EGFCoreUIPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Wrong_Class_Sub_Type_Message, EditorMenuContributor.class.getName()), 1);
                EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            menu = (EditorMenuContributor) object;
            menu.setParentContributor(parent);
            _executables.put(parent, menu);
            return menu;
        } catch (CoreException e) {
            EGFCoreUIPlugin.getDefault().logError(e);
        }
        return null;
    }

    /**
     * Creates a new EditorMenuContributor proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static EditorMenuContributorProxy createProxy(IConfigurationElement element) {
        if (element == null || element.isValid() == false) {
            return null;
        }
        // Store identifier
        IExtension declaringExtension = element.getDeclaringExtension();
        String uniqueIdentifier = declaringExtension.getUniqueIdentifier();
        int handleId = -1;
        if (declaringExtension instanceof Handle) {
            handleId = ((Handle) declaringExtension).getId();
        }
        // see platform:/plugin//org.eclipse.egf.core.ui/schema/editor.menu.contributor.exsd
        String clazz = element.getAttribute(EditorMenuContributorRegistry.INVOKER_ATT_CLASS);
        // 'class' attribute is mandatory
        if (clazz == null || clazz.trim().length() == 0) {
            return null;
        }
        return new EditorMenuContributorProxy(element, clazz, uniqueIdentifier, handleId);
    }

    public EditorMenuContributorProxy(IConfigurationElement element, String clazz, String uniqueIdentifier, int handleId) {
        _element = element;
        _class = clazz.trim();
        if (uniqueIdentifier != null && uniqueIdentifier.trim().length() != 0) {
            _uniqueIdentifier = uniqueIdentifier.trim();
        }
        _handleId = handleId;
    }

    public boolean originatesFrom(IExtension extension) {
        String id = extension.getUniqueIdentifier();
        if (id != null) {
            return id.equals(_uniqueIdentifier);
        }
        if (extension instanceof Handle == false) {
            return false;
        }
        return (_handleId == ((Handle) extension).getId());
    }

    public void disposeEditorMenuContributor(IMenuEditorActionBarContributor parent) {
        _executables.remove(parent);
    }

    public void dispose() {
        for (Map.Entry<IMenuEditorActionBarContributor, EditorMenuContributor> entry : _executables.entrySet()) {
            entry.getKey().removeEditorMenuContributors(Collections.singletonList(entry.getValue()));
        }
        _executables = null;
    }

}
