/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.usecase.pattern.uc1.callback;

import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;

/**
 * @author Thomas Guiu
 * 
 */
public class MyCallbackHandler implements CallBackHandler {

    public void handleCall(PatternContext ctx, Map<String, Object> parameters) throws PatternException {
        String message = "Callback on "; //$NON-NLS-1$
        for (String name : parameters.keySet()) {
            message += (name + " "); //$NON-NLS-1$
        }

        // Message on the default console
        System.out.println(message);

        // Message on the EGF console
        EGFCorePlugin.getDefault().logInfo(message);
    }

}
