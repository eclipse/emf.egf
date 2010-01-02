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

package org.eclipse.egf.pattern.ui.editors.adapter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.pattern.ui.editors.selector.ValidationDelegateClientSelector;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class LiveValidationContentAdapter extends EContentAdapter {
    private ILiveValidator validator = null;

    LiveValidationContentAdapter() {
    }

    public void notifyChanged(final Notification notification) {
        super.notifyChanged(notification);

        if (validator == null) {
            validator = (ILiveValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
        }

        ValidationDelegateClientSelector.running = true;

        IStatus status = validator.validate(notification);

        if (!status.isOK()) {
            if (status.isMultiStatus()) {
                status = status.getChildren()[0];
            }
            // TODO
        }

        ValidationDelegateClientSelector.running = false;

    }

}
