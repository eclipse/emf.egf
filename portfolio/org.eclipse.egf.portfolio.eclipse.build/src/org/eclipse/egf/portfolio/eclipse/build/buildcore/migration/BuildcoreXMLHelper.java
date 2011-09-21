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

import org.eclipse.egf.portfolio.eclipse.build.buildcore.util.BuildcoreResourceImpl;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmFactory;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;

/**
 * @author Matthieu Helleboid
 * 
 */
public class BuildcoreXMLHelper extends XMIHelperImpl {

	public BuildcoreXMLHelper(BuildcoreResourceImpl buildcoreResourceImpl) {
		super(buildcoreResourceImpl);
	}
	
	@Override
	public EObject createObject(EFactory eFactory, String classXMIName) {
		//replace SCMBuildLocation by SVNBuildLocation
		if ("SCMBuildLocation".equals(classXMIName)) {
			return BuildscmFactory.eINSTANCE.createSVNBuildLocation();
		}
		return createObject(eFactory, getType(eFactory, classXMIName));
	}
	
}
