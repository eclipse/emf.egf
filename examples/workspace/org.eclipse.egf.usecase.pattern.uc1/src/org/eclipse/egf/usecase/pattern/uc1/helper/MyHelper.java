/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.usecase.pattern.uc1.helper;

import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.model.pattern.PatternContext;

/**
 * @author Benoit Langlois
 */

public class MyHelper {

    private static final String KEY_COUNTER = "counter"; //$NON-NLS-1$

    public static void resetCounter(PatternContext ctx) {
        ObjectHolder<Integer> holder = new ObjectHolder<Integer>(new Integer(0));
        ctx.setValue(KEY_COUNTER, holder);
    }

    @SuppressWarnings("unchecked")
    public static void incCounter(PatternContext ctx) {
        ObjectHolder<Integer> holder = (ObjectHolder<Integer>) ctx.getValue(KEY_COUNTER);
        holder.object = new Integer(holder.object.intValue() + 1);
    }

    @SuppressWarnings("unchecked")
    public static Integer getCounter(PatternContext ctx) {
        ObjectHolder<Integer> holder = (ObjectHolder<Integer>) ctx.getValue(KEY_COUNTER);
        return holder.object;
    }

}
