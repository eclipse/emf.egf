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

package org.eclipse.egf.pattern.engine;

import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternMethod;

/**
 * @author Thomas Guiu
 * 
 */
public class AssemblyContentHelper {
    private AssemblyContentProvider provider;

    public AssemblyContentHelper(AssemblyContentProvider provider) {
        super();
        this.provider = provider;
    }

    public void addContent(Call call) throws PatternException {
        try {
            provider.doSwitch(call);
        } catch (AssemblyContentProvider.WrappedException e) {
            Throwable cause = e.getCause();
            if (cause instanceof PatternException)
                throw (PatternException) cause;
            throw new PatternException(cause);
        }

    }

    public String getMethodContent(PatternMethod object) throws PatternException {
        return provider.getMethodContent(object);
    }

    public AssemblyContentProvider getProvider() {
        return provider;
    }

    public void addMethodBodies() throws PatternException {
        provider.addMethodBodies();
    }

}
