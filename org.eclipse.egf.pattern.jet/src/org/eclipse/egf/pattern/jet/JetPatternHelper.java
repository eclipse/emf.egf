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

package org.eclipse.egf.pattern.jet;

import java.util.List;

import org.eclipse.egf.model.pattern.Parameter;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.egf.pattern.PatternPreferences;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Guiu
 *
 */
public class JetPatternHelper extends PatternHelper {

	public JetPatternHelper(Pattern pattern) {
		super(pattern);
	}

	@Override
	protected void handleParameters(int insertionIndex) {
		// 1 - Add pre block at insertionIndex
		
		// a revoir l'init ne convient pas ...
/*		
		StringBuilder localContent = new StringBuilder(300);
		for (int i = 0; i< parameterAlias.size(); i++)
		{
			List<String> names = parameterAlias.get(i);
			Parameter parameter = pattern.getParameters().get(i);
			String alias = null;
			for (String name : names)
			{
				EObject type = parameter.getType();
				localContent.append(type.eClass().getEPackage().getName()).append('.').append(type.eClass().getName()).append(' ').append(name);
				if (alias == null)
				{
					localContent.append(" = null; //todo").append(PatternPreferences.NL);
					alias = name;
				}
				else
					localContent.append(" = ").append(alias).append(PatternPreferences.NL);
			}
		}
		
		// 2 - Add post block at current index
		for (int i = 0; i< parameterAlias.size(); i++)
			content.append("}").append(PatternPreferences.NL);
*/
		}

}
