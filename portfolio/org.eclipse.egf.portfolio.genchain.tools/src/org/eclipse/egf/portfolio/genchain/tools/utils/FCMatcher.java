/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.genchain.tools.utils;

import java.util.Collection;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain;

/**
 * TODO this is a quick implementation for matching Fc against element from a generationchain model
 * 
 * @author Thomas Guiu
 *
 */
public class FCMatcher {

	public static boolean isLauncherFC (FactoryComponent fc)
	{
		return fc.getName().endsWith(" Launcher");
	}
	
	public static FactoryComponent getFC (Collection<FactoryComponent> fcs, GenerationChain chain)
	{
		for (FactoryComponent fc : fcs)
		{
			if (fc.getName().endsWith(chain.getName()))
			{
				fcs.remove(fc);
				return fc;
			}
		}
		return null;
	}
	
	private FCMatcher() {
		super();
	}
	
}
