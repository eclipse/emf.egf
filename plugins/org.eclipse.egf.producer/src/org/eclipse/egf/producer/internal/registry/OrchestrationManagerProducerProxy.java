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
package org.eclipse.egf.producer.internal.registry;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OrchestrationManagerProducerProxy {

    private IConfigurationElement _element;

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private String _orchestration;

    private String _class;

    private Object _executable;

    /**
     * Creates a new OrchestrationManagerProducerProxy proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static OrchestrationManagerProducerProxy createProxy(IConfigurationElement element) {
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
        // see platform:/plugin/org.eclipse.egf.producer/schema/orchestrationManagerProducer.exsd
        String orchestration = element.getAttribute(OrchestrationManagerProducerRegistry.INVOKER_ATT_ORCHESTRATION);
        // 'orchestration' attribute is mandatory
        if (orchestration == null || orchestration.trim().length() == 0) {
            return null;
        }
        String clazz = element.getAttribute(OrchestrationManagerProducerRegistry.INVOKER_ATT_CLASS);
        // 'class' attribute is mandatory
        if (clazz == null || clazz.trim().length() == 0) {
            return null;
        }
        return new OrchestrationManagerProducerProxy(element, orchestration, clazz, uniqueIdentifier, handleId);
    }

    public OrchestrationManagerProducerProxy(IConfigurationElement element, String activity, String clazz, String uniqueIdentifier, int handleId) {
        _element = element;
        _orchestration = activity.trim();
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
     * @return the _producer
     */
    @SuppressWarnings("unchecked")
    public <P extends Orchestration> OrchestrationManagerProducer<P> getOrchestrationManagerProducer(P orchestration) throws CoreException {
        if (_executable == null && _element.isValid()) {
            Object object = _element.createExecutableExtension(OrchestrationManagerProducerRegistry.INVOKER_ATT_CLASS);
            if (object == null) {
                return null;
            }
            // Make sure this is the correct resulting type.
            if (object instanceof OrchestrationManagerProducer<?> == false) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Wrong_Class_Sub_Type_Message, OrchestrationManagerProducer.class.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            // Make sure that aorchestration and producer orchestration match
            if (((OrchestrationManagerProducer<?>) object).getOrchestration() == null) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Missing_Element_Message, Orchestration.class.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            if (((OrchestrationManagerProducer<?>) object).getOrchestration() != EMFHelper.solveAgainstStaticPackage(orchestration.eClass())) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Type_mismatch_Message, orchestration.getClass().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            _executable = object;
        }
        return (OrchestrationManagerProducer<P>) _executable;
    }

    public String getOrchestration() {
        return _orchestration;
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
