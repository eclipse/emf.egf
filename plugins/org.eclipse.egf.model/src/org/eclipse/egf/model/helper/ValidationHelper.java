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
package org.eclipse.egf.model.helper;

import java.util.Map;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.preferences.IEGFModelConstants;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ValidationHelper {

    private ValidationHelper() {
        // Prevent Instantiation
    }

    public static boolean isLoadableClass(EObject eObject, String value, Map<Object, Object> context) {
        if (context != null && context.get(IEGFModelConstants.VALIDATE_TYPES) == Boolean.FALSE) {
            return true;
        }
        if (eObject.eResource() == null || value == null || value.trim().length() == 0) {
            return true;
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) eObject.eResource()).getIPlatformFcore();
        if (fcore == null) {
            return true;
        }
        // Retrieve Session if any
        if (context.get(ProjectBundleSession.PROJECT_BUNDLE_SESSION) == null) {
            return true;
        }
        ProjectBundleSession session = (ProjectBundleSession) context.get(ProjectBundleSession.PROJECT_BUNDLE_SESSION);
        try {
            Bundle bundle = BundleSessionHelper.getBundle(session, fcore);
            if (bundle == null) {
                return true;
            }
            // Load Class
            Class<?> clazz = null;
            try {
                clazz = bundle.loadClass(value.trim());
            } catch (Throwable t) {
                // Nothing to do
            }
            if (clazz == null) {
                return false;
            }
        } catch (Throwable t) {
            EGFModelPlugin.getPlugin().logError(t);
            return false;
        }
        return true;
    }

    public static boolean isValidClass(EObject eObject, Class<?> type, String value, Map<Object, Object> context) {
        if (eObject == null || context == null || type == null || value == null || value.trim().length() == 0) {
            return true;
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) eObject.eResource()).getIPlatformFcore();
        if (fcore == null) {
            return true;
        }
        // Retrieve Session if any
        if (context.get(ProjectBundleSession.PROJECT_BUNDLE_SESSION) == null) {
            return true;
        }
        ProjectBundleSession session = (ProjectBundleSession) context.get(ProjectBundleSession.PROJECT_BUNDLE_SESSION);
        try {
            Bundle bundle = BundleSessionHelper.getBundle(session, fcore);
            if (bundle == null) {
                return true;
            }
            // Load Class
            Class<?> clazz = null;
            try {
                clazz = bundle.loadClass(value.trim());
            } catch (Throwable t) {
                // Nothing to do
            }
            if (clazz == null) {
                return true;
            }
            // Valid Value
            if (ClassHelper.isSubClass(clazz, type) == false) {
                return false;
            }
        } catch (Throwable t) {
            EGFModelPlugin.getPlugin().logError(t);
            return false;
        }
        return true;
    }

}
