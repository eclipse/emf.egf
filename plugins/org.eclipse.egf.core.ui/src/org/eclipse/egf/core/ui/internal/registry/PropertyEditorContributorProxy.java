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

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.contributor.PropertyEditorContributor;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class PropertyEditorContributorProxy {

    private IConfigurationElement _element;

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private String _class;

    private PropertyEditorContributor _executable;

    /**
     * Creates a new PropertyEditorContributorProxy proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static PropertyEditorContributorProxy createProxy(IConfigurationElement element) {
        if (element == null) {
            return null;
        }
        // Store identifier
        IExtension declaringExtension = element.getDeclaringExtension();
        String uniqueIdentifier = declaringExtension.getUniqueIdentifier();
        int handleId = -1;
        if (declaringExtension instanceof Handle) {
            handleId = ((Handle) declaringExtension).getId();
        }
        // see platform:/plugin/org.eclipse.egf.core.ui/schema/editor.property.contributor.exsd
        String clazz = element.getAttribute(PropertyEditorContributorRegistry.INVOKER_ATT_CLASS);
        // 'class' attribute is mandatory
        if (clazz == null || clazz.trim().length() == 0) {
            return null;
        }
        return new PropertyEditorContributorProxy(element, clazz, uniqueIdentifier, handleId);
    }

    public PropertyEditorContributorProxy(IConfigurationElement element, String clazz, String uniqueIdentifier, int handleId) {
        _element = element;
        _class = clazz.trim();
        if (uniqueIdentifier != null && uniqueIdentifier.trim().length() != 0) {
            _uniqueIdentifier = uniqueIdentifier.trim();
        }
        _handleId = handleId;
    }

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
     * @return the _executable
     */
    public PropertyEditorContributor getPropertyEditorContributor() {
        if (_executable == null) {
            try {
                Object object = _element.createExecutableExtension(PropertyEditorContributorRegistry.INVOKER_ATT_CLASS);
                if (object == null) {
                    return null;
                }
                if (object instanceof PropertyEditorContributor == false) {
                    EGFCoreUIPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                    EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Wrong_Class_Sub_Type_Message, PropertyEditorContributor.class.getName()), 1);
                    EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                    EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                    EGFCoreUIPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                    return null;
                }
                _executable = (PropertyEditorContributor) object;
            } catch (CoreException e) {
                EGFCoreUIPlugin.getDefault().logError(e);
            }
        }
        return _executable;
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

}
