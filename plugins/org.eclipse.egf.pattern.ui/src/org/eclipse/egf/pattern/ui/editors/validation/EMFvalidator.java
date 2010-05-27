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
package org.eclipse.egf.pattern.ui.editors.validation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.pattern.ui.editors.selector.DefaultClientSelector;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintFilter;
import org.eclipse.emf.validation.service.ModelValidationService;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class EMFvalidator {

    private static final Map<String, IBatchValidator> batchValidatorCache = new HashMap<String, IBatchValidator>();
//    private static final Map<String, ILiveValidator> liveValidatorCache = new HashMap<String, ILiveValidator>();

//    public static IStatus liveValidate(Notification msg, String key) {
//        DefaultClientSelector.running = true;
//        IStatus result = getLive(key).validate(msg);
//        DefaultClientSelector.running = false;
//        return result;
//    }

    public static IStatus batchValidate(EObject obj, String key) {
        DefaultClientSelector.running = true;
        IBatchValidator batch = getBatch(key);
        IStatus result = batch.validate(obj);
        DefaultClientSelector.running = false;
        return result;
    }

//    public static ILiveValidator getLive(String key) {
//        ILiveValidator liveValidator = liveValidatorCache.get(key);
//        if (liveValidator == null) {
//            liveValidator = ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
//            liveValidator.addConstraintFilter(getFilter(key));
//            liveValidatorCache.put(key, liveValidator);
//        }
//        return liveValidator;
//    }

    public static IBatchValidator getBatch(String key) {
        IBatchValidator batchValidator = batchValidatorCache.get(key);
        if (batchValidator == null) {
            batchValidator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
            batchValidator.setIncludeLiveConstraints(true);
            batchValidator.addConstraintFilter(getFilter(key));
            batchValidatorCache.put(key, batchValidator);
        }
        return batchValidator;
    }

    public static IConstraintFilter getFilter(final String key) {
        return new IConstraintFilter() {
            public boolean accept(IConstraintDescriptor constraint, EObject target) {
                String id = constraint.getId();
                return id.equals(key);
            }
        };
    }
}
