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
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ActivityManagerProducerProxy {

    private IConfigurationElement _element;

    private String _uniqueIdentifier;

    private int _handleId = -1;

    private String _activity;

    private String _class;

    private Object _executable;

    /**
     * Creates a new ActivityManagerProducerProxy proxy based on the given configuration element.
     * Returns the new proxy, or null if the element could not be created.
     */
    public static ActivityManagerProducerProxy createProxy(IConfigurationElement element) {
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
        // see platform:/plugin/org.eclipse.egf.producer/schema/activityManagerProducer.exsd
        String activity = element.getAttribute(ActivityManagerProducerRegistry.INVOKER_ATT_ACTIVITY);
        // 'activity' attribute is mandatory
        if (activity == null || activity.trim().length() == 0) {
            return null;
        }
        String clazz = element.getAttribute(ActivityManagerProducerRegistry.INVOKER_ATT_CLASS);
        // 'class' attribute is mandatory
        if (clazz == null || clazz.trim().length() == 0) {
            return null;
        }
        return new ActivityManagerProducerProxy(element, activity, clazz, uniqueIdentifier, handleId);
    }

    public ActivityManagerProducerProxy(IConfigurationElement element, String activity, String clazz, String uniqueIdentifier, int handleId) {
        _element = element;
        _activity = activity.trim();
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
    public <P extends Activity> ActivityManagerProducer<P> getActivityManagerProducer(P activity) throws CoreException {
        if (_executable == null && _element.isValid()) {
            Object object = _element.createExecutableExtension(ActivityManagerProducerRegistry.INVOKER_ATT_CLASS);
            if (object == null) {
                return null;
            }
            // Make sure this is the correct resulting type.
            if (object instanceof ActivityManagerProducer<?> == false) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Wrong_Class_Sub_Type_Message, ActivityManagerProducer.class.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            // Make sure that activity and producer activity match
            if (((ActivityManagerProducer<?>) object).getActivity() == null) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Missing_Element_Message, Activity.class.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            if (((ActivityManagerProducer<?>) object).getActivity() != EMFHelper.solveAgainstStaticPackage(activity.eClass())) {
                EGFProducerPlugin.getDefault().logError(NLS.bind(EGFCommonMessages.Wrong_Class_Message, object.getClass().getName()));
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Type_mismatch_Message, activity.getClass().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Bundle_Message, _element.getContributor().getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Extension_Point_Message, _element.getName()), 1);
                EGFProducerPlugin.getDefault().logInfo(NLS.bind(EGFCommonMessages.Attribute_Message, _class), 1);
                return null;
            }
            _executable = object;
        }
        return (ActivityManagerProducer<P>) _executable;
    }

    public String getActivity() {
        return _activity;
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
