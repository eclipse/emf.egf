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

package org.eclipse.egf.portfolio.eclipse.build;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.ItemProperties;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Property;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.PropertyType;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Matthieu Helleboid 
 *
 */
public class PropertiesHelper {

    public List<PropertyWrapper> getRuntimeProperties(Job job) {
        List<PropertyWrapper> list = new ArrayList<PropertyWrapper>();
        
        addPropertyWrapperToList(list, new PropertyWrapper("build.root", "${relengDir}/../workspace", PropertyWrapper.RUNTIME_BUILTIN, "WORKSPACE"));
        addPropertyWrapperToList(list, new PropertyWrapper("tools", "${build.root}/tools"));
        addPropertyWrapperToList(list, new PropertyWrapper("result", "${build.root}/result"));
        addPropertyWrapperToList(list, new PropertyWrapper("publish", "${result}/publish"));
        addPropertyWrapperToList(list, new PropertyWrapper("workspace", "${result}/workspace", PropertyWrapper.RUNTIME_BUILTIN, "ECLIPSE_WORKSPACE"));
        addPropertyWrapperToList(list, new PropertyWrapper("timestamp", "${myTimestamp}", PropertyWrapper.RUNTIME_BUILTIN, "BUILD_ID"));

        if (job.eContainer() instanceof Chain) {
            for (Property property : ((Chain) job.eContainer()).getProperties()) {
                if (PropertyType.RUNTIME.equals(property.getType()))
                    addPropertyWrapperToList(list, new PropertyWrapper(property));
            }
        }
        
        TreeIterator<Object> treeIterator = EcoreUtil.getAllContents(job, false);
        while (treeIterator.hasNext()) {
            Object next = treeIterator.next();
            if (next instanceof Property) {
                Property property = (Property) next;
                if (PropertyType.RUNTIME.equals(property.getType()))
                    addPropertyWrapperToList(list, new PropertyWrapper((Property) next));
            }
        }
        
        return list;
    }

    private void addPropertyWrapperToList(List<PropertyWrapper> list, PropertyWrapper propertyWrapper) {
        for (PropertyWrapper element : list) {
            if (element.getKey().equalsIgnoreCase(propertyWrapper.getKey())) {
                return;
            }
        }
        list.add(propertyWrapper);
    }

    public void replaceInlinedProperties(EObject eObject) {
        List<EAttribute> eAllAttributes = eObject.eClass().getEAllAttributes();
        for (EAttribute eAttribute : eAllAttributes) {
            if ("EString".equals(eAttribute.getEType().getName())) {
                if (eAttribute.getUpperBound() == 1) {
                    String string = (String) eObject.eGet(eAttribute);
                    eObject.eSet(eAttribute, replaceInlinedProperties(eObject, string));
                } else {
                    List<String> stringList = (List<String>) eObject.eGet(eAttribute);
                    for (int i = 0; i < stringList.size(); i++) {
                        String string = stringList.get(i);
                        stringList.set(i, replaceInlinedProperties(eObject, string));
                    }
                }
            }
        }
    }    
    
    private String replaceInlinedProperties(EObject eObject, String input) {
        if (input == null)
            return null;
        
        while (eObject != null) {
            if (eObject instanceof ItemProperties) {
                ItemProperties itemProperties = (ItemProperties) eObject;
                for (Property property : itemProperties.getProperties()) {
                    if (PropertyType.INLINED.equals(property.getType())) {
                        String propertyExpression = "${" + property.getKey() + "}";
                        if (input.contains(propertyExpression))
                            input = input.replace(propertyExpression, property.getValue());
                    }
                }
            }
            eObject = eObject.eContainer();
        }
        return input;
    }
    
}
