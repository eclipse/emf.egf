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

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.Component;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMIHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * @author Matthieu Helleboid
 * 
 */
public class BuildcoreSAXXMIHandler extends SAXXMIHandler {

	private boolean migrateCleanStep = false;
    private boolean migrateNameId = false;
	
	public BuildcoreSAXXMIHandler(XMLResource resource, XMLHelper helper,
			Map<?, ?> options) {
		super(resource, helper, options);
	}

	@Override
	protected void handleXMLNSAttribute(String attrib, String value) {
        if ("http://www.eclipse.org/egf/1.0.0/buildstep".equals(value)) {
            value = "http://www.eclipse.org/egf/1.0.1/buildstep";
            migrateCleanStep = true;
        }
        if ("http://www.eclipse.org/egf/1.0.0/buildcore".equals(value)) {
            value = "http://www.eclipse.org/egf/1.0.1/buildcore";
            migrateNameId  = true;
        }
        if ("http://www.eclipse.org/egf/1.0.1/buildstep".equals(value)) {
            value = "http://www.eclipse.org/egf/1.0.2/buildstep";
            migrateNameId = true;
        }
		super.handleXMLNSAttribute(attrib, value);
	}
	
	@Override
	protected void processObject(EObject object) {
		super.processObject(object);
		
		if (migrateCleanStep && object instanceof BuildStep) {
			AnyType anyType = eObjectToExtensionMap.get(object);
			if (anyType != null) {
				FeatureMap anyAttribute = anyType.getAnyAttribute();
				for (Entry entry : anyAttribute) {
					if ("cleanBeforeBuild".equals(entry.getEStructuralFeature().getName())) {
						//already a cleanBeforeBuild value
						return;
					}
				}
			}
			//was default value
			setAttribValue(object, "cleanBeforeBuild", "Result");
		}
	}
	
	@Override
	protected void setAttribValue(EObject object, String name, String value) {
		//replace scmLocation by svnLocation
		if ("scmLocation".equals(name)) {
			name = "svnLocation";
		}
		
		if (migrateNameId) {
		    if ("name".equals(name)) {
		        if (object instanceof Step || object instanceof AggregateStep || object instanceof InstallStep || object instanceof Component)
		            name = "id";
		    } else if ("id".equals(name)) {
                if (object instanceof Step)
                    name = "name";
            }
		}
		
		super.setAttribValue(object, name, value);
	}

}
