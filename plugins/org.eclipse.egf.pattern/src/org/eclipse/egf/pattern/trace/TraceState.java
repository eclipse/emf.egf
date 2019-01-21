/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.trace;

/**
 * @author Thomas Guiu
 * 
 */
public enum TraceState implements ITracePreferences {
    ALWAYS(ENABLE_TRACE__ALWAYS_VALUE), FILTERS(ENABLE_TRACE__CONFIGURATION_VALUE), NEVER(ENABLE_TRACE__NEVER_VALUE);

    private final String label;

    TraceState(String name) {
        this.label = name;
    }

    public String getLabel() {
        return label;
    }

    public static TraceState get(String label) {
        for (TraceState state : values()) {
            if (label.equals(state.getLabel()))
                return state;
        }
        return null;
    }
}
