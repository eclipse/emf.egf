/**
 * <copyright>
 *
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
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen.model;

import java.util.Map;

/**
 * @author Matthieu Helleboid
 * 
 */
public class GIFPatternInfo extends PatternInfo {
    protected String gifPath;
    protected String methodContent;

    @Override
    protected Map<String, Object> getToStringProperties() {
        Map<String, Object> toStringProperties = super.getToStringProperties();
        toStringProperties.put("gifPath", gifPath); //$NON-NLS-1$
        toStringProperties.put("methodContent", methodContent); //$NON-NLS-1$
        return toStringProperties;
    }

    public void setGifPath(String gifPath) {
        this.gifPath = gifPath;
    }

    public String getGifPath() {
        return gifPath;
    }

    public void setMethodContent(String methodContent) {
        this.methodContent = methodContent;
    }

    public String getMethodContent() {
        return methodContent;
    }
}
