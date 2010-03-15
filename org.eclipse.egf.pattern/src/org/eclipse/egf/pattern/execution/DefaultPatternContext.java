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

package org.eclipse.egf.pattern.execution;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class DefaultPatternContext implements PatternContext {
    protected PatternContext parent;
    private final Map<String, Object> data = new HashMap<String, Object>();
    private final BundleAccessor accessor;

    public DefaultPatternContext(BundleAccessor accessor) {
        if (accessor == null)
            throw new IllegalArgumentException();
        this.accessor = accessor;
    }

    public DefaultPatternContext(PatternContext parent) {
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
