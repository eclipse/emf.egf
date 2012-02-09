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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Job;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Property;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Matthieu Helleboid 
 *
 */
public class PropertiesHelper {

    public List<PropertyWrapper> getAllProperties(Job job) {
        List<PropertyWrapper> list = new ArrayList<PropertyWrapper>();
        
        addPropertyWrapperToList(list, new PropertyWrapper("relengDir", "${baseDir}"));
        addPropertyWrapperToList(list, new PropertyWrapper("build.root", "${relengDir}/../workspace", PropertyWrapper.BUILTIN, "WORKSPACE"));
        addPropertyWrapperToList(list, new PropertyWrapper("timestamp", "${myTimestamp}", PropertyWrapper.BUILTIN, "BUILD_ID"));
        addPropertyWrapperToList(list, new PropertyWrapper("tools", "${build.root}/tools"));
        addPropertyWrapperToList(list, new PropertyWrapper("result", "${build.root}/result"));
        addPropertyWrapperToList(list, new PropertyWrapper("publish", "${result}/publish"));
        addPropertyWrapperToList(list, new PropertyWrapper("workspace", "${result}/workspace", PropertyWrapper.BUILTIN, "ECLIPSE_WORKSPACE"));

        if (job.eContainer() instanceof Chain) {
            for (Property property : ((Chain) job.eContainer()).getProperties()) {
                addPropertyWrapperToList(list, new PropertyWrapper(property));
            }
        }
        
        TreeIterator<Object> treeIterator = EcoreUtil.getAllContents(job, false);
        while (treeIterator.hasNext()) {
            Object next = treeIterator.next();
            if (next instanceof Property) {
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

//    List<EAttribute> eAllAttributes = eObject.eClass().getEAllAttributes();
//    for (EAttribute eAttribute : eAllAttributes) {
//        if ("EString".equals(eAttribute.getEType().getName())) {
//            if (eAttribute.getUpperBound() == 1) {
//                String string = (String) eObject.eGet(eAttribute);
//                eObject.eSet(eAttribute, new GenerationHelper().replaceProperties(eObject, string));
//            } else {
//                List<String> stringList = (List<String>) eObject.eGet(eAttribute);
//                for (int i = 0; i < stringList.size(); i++) {
//                    String string = stringList.get(i);
//                    stringList.set(i, new GenerationHelper().replaceProperties(eObject, string));
//                }
//            }
//        }
//    }
    
//    public String replaceProperties(EObject eObject, String input) {
//        if (input == null)
//            return null;
//        
//        while (eObject != null) {
//            if (eObject instanceof ItemProperties) {
//                ItemProperties itemProperties = (ItemProperties) eObject;
//                for (Property property : itemProperties.getProperties()) {
//                    String propertyExpression = "${" + property.getKey() + "}";
//                    if (input.contains(propertyExpression))
//                        input = input.replace(propertyExpression, property.getValue());
//                }
//            }
//            eObject = eObject.eContainer();
//        }
//        return input;
//    }
   


    
}
