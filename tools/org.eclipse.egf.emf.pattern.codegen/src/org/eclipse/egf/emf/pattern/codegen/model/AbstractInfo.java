/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.emf.pattern.PartType;
import org.eclipse.egf.emf.pattern.base.ContentType;

/**
 * @author Matthieu Helleboid
 * 
 */
public class AbstractInfo {

    protected ContentType contentType;
    protected PartType partType;

    public AbstractInfo() {
        super();
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    @Override
    public String toString() {
        Map<String, Object> toStringProperties = getToStringProperties();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getSimpleName());
        stringBuffer.append(" "); //$NON-NLS-1$
        stringBuffer.append("\n"); //$NON-NLS-1$

        stringBuffer.append("  <Properties>"); //$NON-NLS-1$
        stringBuffer.append("\n"); //$NON-NLS-1$

        for (String key : toStringProperties.keySet()) {
            stringBuffer.append("    "); //$NON-NLS-1$
            stringBuffer.append(key);
            stringBuffer.append("="); //$NON-NLS-1$
            stringBuffer.append(toStringProperties.get(key));
            stringBuffer.append("\n"); //$NON-NLS-1$
        }

        stringBuffer.append("  </Properties>"); //$NON-NLS-1$
        stringBuffer.append("\n"); //$NON-NLS-1$

        return stringBuffer.toString();
    }

    protected Map<String, Object> getToStringProperties() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("contentType", contentType); //$NON-NLS-1$
        result.put("partType", partType); //$NON-NLS-1$
        return result;
    }
}