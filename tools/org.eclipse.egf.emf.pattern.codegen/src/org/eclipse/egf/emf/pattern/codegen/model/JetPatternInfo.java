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
public class JetPatternInfo extends JetAbstractPatternInfo {
    protected String condition;
    protected String jetClassName;
    protected String jetTemplatePath;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setJetTemplatePath(String jetTemplatePath) {
        this.jetTemplatePath = jetTemplatePath;
    }

    public String getJetClassName() {
        return jetClassName;
    }

    public String getJetTemplatePath() {
        return jetTemplatePath;
    }

    public void setJetClassName(String jetClassName) {
        this.jetClassName = jetClassName;
    }

    @Override
    protected Map<String, Object> getToStringProperties() {
        Map<String, Object> toStringProperties = super.getToStringProperties();
        toStringProperties.put("condition", condition); //$NON-NLS-1$
        toStringProperties.put("jetClassName", jetClassName); //$NON-NLS-1$
        toStringProperties.put("jetTemplatePath", jetTemplatePath); //$NON-NLS-1$
        return toStringProperties;
    }
}
