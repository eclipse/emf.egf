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

package org.eclipse.egf.usecase.pattern.uc1.callback;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Thomas Guiu
 *
 */
public class MyCallbackHandler implements CallBackHandler {

	public void handleCall(PatternContext ctx, Object element) {
		  String message = new String ("Callback on "+ ((EClass)element).getName());

		  // Message on the default console
		  System.out.println(message); //$NON-NLS-1$

		  // Message on the EGF console
		  EGFCorePlugin.getDefault().logInfo(message);
	}

}
