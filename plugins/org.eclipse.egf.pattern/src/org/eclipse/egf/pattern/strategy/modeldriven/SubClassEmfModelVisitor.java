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

package org.eclipse.egf.pattern.strategy.modeldriven;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * An EMF model visitor to also match all subclasses of an EMF parameter's eClass
 * 
 * @author Matthieu Helleboid
 * 
 */
public class SubClassEmfModelVisitor extends DefaultDomainVisitor {

    @Override
    protected List<Pattern> findPatterns(Object model) {
        if (model instanceof EObject) {
            List<Pattern> list = new ArrayList<Pattern>();

            for (EClass superType : getSuperTypes(model)) {
                String fullName = EcoreUtil.getURI(superType).toString();
                List<Pattern> patterns = type2patterns.get(fullName);
                if (patterns != null)
                    list.addAll(patterns);
            }

            return list;
        }

        return super.findPatterns(model);
    }

    protected List<EClass> getSuperTypes(Object model) {
        EClass eClass = ((EObject) model).eClass();
        List<EClass> types = new ArrayList<EClass>(eClass.getEAllSuperTypes());
        types.add(eClass);
        //EObject is also an implicit super type
        types.add(EcorePackage.eINSTANCE.getEObject());
        return types;
    }
}
