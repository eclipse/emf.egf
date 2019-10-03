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
package org.eclipse.egf.model.fcore.util;

import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;

/**
 * @author Xavier Maysonnave
 */
public class FcoreXMIHelperImpl extends XMIHelperImpl {

    public FcoreXMIHelperImpl() {
        super();
    }

    public FcoreXMIHelperImpl(FcoreResourceImpl resource) {
        super(resource);
    }

    @Override
    public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
        if (feature != PatternPackage.Literals.PATTERN_METHOD__PATTERN_FILE_PATH || ((IPlatformFcoreProvider) resource).getIPlatformFcore() == null) {
            super.setValue(object, feature, value, position);
            return;
        }
        URI uri = URI.createURI((String) value);
        if (uri.isRelative()) {
            object.eSet(feature, URI.createURI(((IPlatformFcoreProvider) resource).getIPlatformFcore().getPlatformBundle().getRootedBase().toString() + uri.toString()));
        } else {
            object.eSet(feature, uri);
        }
    }

}
