/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore.migration;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.util.BuildcoreResourceImpl;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.BuilddeployFactory;
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
        //move SCMTrigger
        if ("SCMTrigger".equals(classXMIName)) {
            return BuilddeployFactory.eINSTANCE.createSCMTrigger();
        }
        //move CronTrigger
        if ("CronTrigger".equals(classXMIName)) {
            return BuilddeployFactory.eINSTANCE.createCronTrigger();
        }
        return createObject(eFactory, getType(eFactory, classXMIName));
	}
	
}
