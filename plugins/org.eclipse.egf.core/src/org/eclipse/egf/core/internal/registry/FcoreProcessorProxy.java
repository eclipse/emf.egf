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

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.processor.IFcoreProcessor;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreProcessorProxy {

    private IConfigurationElement _element;

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private String _class;

    private IFcoreProcessor _executable;

    /**
     * Creates a new FcoreProcessingProxy proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static FcoreProcessorProxy createProxy(IConfigurationElement element) {
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
        // see platform:/plugin/org.eclipse.egf.core/schema/fcoreProcessor.exsd
        String clazz = element.getAttribute(FcoreProcessorRegistry.INVOKER_ATT_CLASS);
        // 'class' attribute is mandatory
        if (clazz == null || clazz.trim().length() == 0) {
            return null;
        }
        return new FcoreProcessorProxy(element, clazz, uniqueIdentifier, handleId);
    }

    public FcoreProcessorProxy(IConfigurationElement element, String clazz, String uniqueIdentifier, int handleId) {
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
    public IFcoreProcessor getIFcoreProcessor() {
        if (_executable == null && _element.isValid()) {
            try {
                Object object = _element.createExecutableExtension(FcoreProcessorRegistry.INVOKER_ATT_CLASS);
                if (object == null) {
                    return null;
                }
                if (object instanceof IFcoreProcessor == false) {
                    EGFCorePlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                    EGFCorePlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Wrong_Class_Sub_Type_Message, IFcoreProcessor.class.getName()), 1);
                    EGFCorePlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                    EGFCorePlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                    EGFCorePlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                    return null;
                }
                _executable = (IFcoreProcessor) object;
            } catch (CoreException e) {
                EGFCorePlugin.getDefault().logError(e);
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
