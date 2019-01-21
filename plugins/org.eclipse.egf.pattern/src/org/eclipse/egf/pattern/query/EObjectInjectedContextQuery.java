/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.query;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Matthieu Helleboid
 * 
 */
public class EObjectInjectedContextQuery extends BasicQueryDelegate {

    @Override
    protected Collection<EObject> getDomain(PatternContext context) {
        ArrayList<EObject> arrayList = new ArrayList<EObject>();
        arrayList.add((EObject) context.getValue(PatternContext.INJECTED_CONTEXT));
        return arrayList;
    }

}
