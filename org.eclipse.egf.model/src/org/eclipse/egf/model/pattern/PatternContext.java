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

package org.eclipse.egf.model.pattern;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.Bundle;

/**
 * TODO Ici on ne devrait avoir qu'une pauvre map avec name-valeur. Son
 * initialisation étant à la charge de l'orchestrateur. TODO il faudrait ajouetr
 * un peu de control pour savoir les noms en lecture et ceux en écriture.
 * 
 * 
 * @author Guiu
 * 
 */
public class PatternContext implements BundleAccessor {

    /**
     * Key to manage the patter execution reporter.
     */
    public static final String PATTERN_REPORTER = "pattern.execution.reporter";

    public static final String PATTERN_ID = "pattern.id";
    public static final String PATTERN_IDS_PARAMETER = "pattern.ids";

    /**
     * key to manage the context injected to a pattern.
     */
    public static final String INJECTED_CONTEXT = "internal.injected.context";

    /**
     * key to manage the object collection to perform queries on.
     */
    public static final String DOMAIN_OBJECTS = "domain";

    private PatternContext parent;
    private final Map<String, Object> data = new HashMap<String, Object>();
    private final BundleAccessor accessor;

    public PatternContext(BundleAccessor accessor) {
        if (accessor == null)
            throw new IllegalArgumentException();
        this.accessor = accessor;
    }

    public PatternContext(PatternContext parent) {
        this((BundleAccessor) parent);
        this.parent = parent;
    }

    public void setValue(String name, Object value) {
        if (name == null)
            throw new IllegalArgumentException();
        data.put(name, value);
        // TODO how to deal with parent ctx ?

    }

    public Object getValue(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        if (data.containsKey(name))
            return data.get(name);
        return parent == null ? null : parent.getValue(name);
    }

    public Bundle getBundle(String id) throws PatternException {

        return accessor.getBundle(id);
    }

}
