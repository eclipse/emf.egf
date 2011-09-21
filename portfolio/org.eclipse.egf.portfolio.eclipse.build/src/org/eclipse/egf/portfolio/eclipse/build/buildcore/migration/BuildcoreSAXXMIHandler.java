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

package org.eclipse.egf.portfolio.eclipse.build.buildcore.migration;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMIHandler;

/**
 * @author Matthieu Helleboid
 * 
 */
public class BuildcoreSAXXMIHandler extends SAXXMIHandler {

	public BuildcoreSAXXMIHandler(XMLResource resource, XMLHelper helper,
			Map<?, ?> options) {
		super(resource, helper, options);
	}

	@Override
	protected void setAttribValue(EObject object, String name, String value) {
		//replace scmLocation by svnLocation
		if ("scmLocation".equals(name)) {
			name = "svnLocation";
		}
		super.setAttribValue(object, name, value);
	}

}
