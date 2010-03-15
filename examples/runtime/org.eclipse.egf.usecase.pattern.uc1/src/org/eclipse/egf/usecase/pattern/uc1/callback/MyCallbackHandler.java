/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Thomas Guiu
 *
 */
public class MyCallbackHandler implements CallBackHandler {

	public void handleCall(PatternContext ctx, Object model) {
		System.out.println("Callback on "+((EClass)model).getName());
	}

}
