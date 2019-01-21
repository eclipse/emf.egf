/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.util;

import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;

/**
 * @author Xavier Maysonnave
 *
 */
public class FcoreXMISaveImpl extends XMISaveImpl {

    public FcoreXMISaveImpl(XMLHelper helper) {
        super(helper);
    }

    @Override
    protected String getDatatypeValue(Object value, EStructuralFeature f, boolean isAttribute) {
        // Ignore
        if (value == null) {
            return null;
        }
        // Default Processing
        if (f != PatternPackage.Literals.PATTERN_METHOD__PATTERN_FILE_PATH) {
            return super.getDatatypeValue(value, f, isAttribute);
        }
        String svalue = URIHelper.toPlatformProjectString((URI) value, true);
        if (escape != null) {
            if (isAttribute) {
                svalue = escape.convert(svalue);
            } else {
                svalue = escape.convertText(svalue);
            }
        }
        return svalue;
    }

}
