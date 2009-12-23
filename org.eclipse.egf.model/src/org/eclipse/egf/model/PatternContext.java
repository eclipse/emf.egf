/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.model;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Ici on ne devrait avoir qu'une pauvre map avec name-valeur. Son
 * initialisation étant à la charge de l'orchestrateur. TODO il faudrait ajouetr
 * un peu de control pour savoir les noms en lecture et ceux en écriture.
 * 
 * 
 * @author Guiu
 * 
 */
public class PatternContext {

    public static final String INTERNAL_PATTERN_REPORTER = "internal.pattern.reporter";
    public static final String INTERNAL_PATTERN_PARAMETER_ALIAS = "internal.pattern.parameter.alias";

    private PatternContext parent;
    private final Map<String, Object> data = new HashMap<String, Object>();

    public PatternContext() {
    }

    public PatternContext(PatternContext parent) {
        this.parent = parent;
    }

    public void setValue(String name, Object value) {
        if (name == null)
            throw new IllegalArgumentException();
        throw new UnsupportedOperationException();
        // TODO how to deal with parent ctx ?

    }

    public Object getValue(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        if (data.containsKey(name))
            return data.get(name);
        return parent == null ? null : parent.getValue(name);
    }

}
