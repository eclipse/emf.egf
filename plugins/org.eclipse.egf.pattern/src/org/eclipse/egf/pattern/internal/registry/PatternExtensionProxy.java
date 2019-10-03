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
package org.eclipse.egf.pattern.internal.registry;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class PatternExtensionProxy {

    private IConfigurationElement _element;

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private String _nature;

    private String _class;

    private Object _executable;

    private String _name;

    /**
     * Creates a new PatternExtensionProxy proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static PatternExtensionProxy createProxy(IConfigurationElement element) {
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
        // see platform:/plugin/org.eclipse.egf.pattern/schema/org.eclipse.egf.pattern.extension.exsd
        String nature = element.getAttribute(PatternExtensionRegistry.ATT_NATURE);
        // 'nature' attribute is mandatory
        if (nature == null || nature.trim().length() == 0) {
            return null;
        }
        String clazz = element.getAttribute(PatternExtensionRegistry.ATT_CLASS);
        // 'class' attribute is mandatory
        if (clazz == null || clazz.trim().length() == 0) {
            return null;
        }
        return new PatternExtensionProxy(element, nature, clazz, uniqueIdentifier, handleId);
    }

    public PatternExtensionProxy(IConfigurationElement element, String nature, String clazz, String uniqueIdentifier, int handleId) {
        _element = element;
        _nature = nature.trim();
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
     * @return the PatternExtension
     */
    public PatternExtension getPatternExtension() throws CoreException {
        if (_executable == null && _element.isValid()) {
            Object object = _element.createExecutableExtension(PatternExtensionRegistry.ATT_CLASS);
            if (object == null) {
                return null;
            }
            // Make sure this is the correct resulting type.
            if (object instanceof PatternExtension == false) {
                EGFPatternPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFPatternPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Wrong_Class_Sub_Type_Message, PatternExtension.class.getName()), 1);
                EGFPatternPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFPatternPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFPatternPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            _executable = object;
        }
        return (PatternExtension) _executable;
    }

    public String getNature() {
        return _nature;
    }

    public String getName() {
        if (_name == null) {
            int index = _nature.lastIndexOf('.');
            if (index == -1) {
                _name = _nature;
            } else {
                _name = _nature.substring(index + 1);
            }
        }
        return _name;
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
