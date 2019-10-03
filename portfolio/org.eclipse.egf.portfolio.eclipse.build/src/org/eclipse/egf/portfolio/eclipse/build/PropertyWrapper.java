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

package org.eclipse.egf.portfolio.eclipse.build;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Property;

/**
 * @author Matthieu Helleboid 
 *
 */public class PropertyWrapper {
    public static final String RUNTIME_BUILTIN = "Builtin";
    public static final String RUNTIME_PROVIDED = "Provided";
    
    private String key;
    private String value;
    private String type;
    private String envKey;
    
    public PropertyWrapper(String key, String value, String type, String envKey) {
        this.key = key;
        this.value = value;
        this.type = type;
        this.envKey = "env." + envKey;
    }
    
    public PropertyWrapper(String key, String value) {
        this(key, value, RUNTIME_BUILTIN, key);
    }

    public PropertyWrapper(Property property) {
        this(property.getKey(), property.getValue(), RUNTIME_PROVIDED, property.getKey());
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getEnvKey() {
        return envKey;
    }
}