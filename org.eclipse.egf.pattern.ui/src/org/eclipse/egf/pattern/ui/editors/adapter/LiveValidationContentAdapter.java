/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.adapter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.selector.PatternValidationDelegateClientSelector;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class LiveValidationContentAdapter extends EContentAdapter {
    private ILiveValidator validator = null;

    private Control control;

    private IMessageManager mmng;

    private String key;

    private Pattern pattern;

    public LiveValidationContentAdapter(Control control, IMessageManager mmng, String key, Pattern pattern) {
        this.control = control;
        this.mmng = mmng;
        this.key = key;
        this.pattern = pattern;
    }

    public void notifyChanged(final Notification notification) {
        Object notifier = notification.getNotifier();
        super.notifyChanged(notification);

        if (!(notification.getFeature() instanceof EAttribute)) {
            return;
        }

        if (notifier instanceof PatternParameter || notifier instanceof PatternVariable) {
            checkTableInput(notifier);
            return;
        }

        if (validator == null) {
            validator = (ILiveValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
        }

        if (Messages.PatternUIHelper_key_NonPatternEmptyName.equals(key) && notifier instanceof Pattern && control instanceof Text && isNameChange(notification)) {
            PatternValidationDelegateClientSelector.running = true;
            IStatus status = validator.validate(notification);
            executeValidate(status);
            PatternValidationDelegateClientSelector.running = false;
        }
    }

    private void executeValidate(IStatus status) {
        if (control != null && !control.isDisposed()) {
            PatternUIHelper.setErrorMessage(status, mmng, key, control);
        }
    }

    /**
     * If the notifier is PatternParameter type, check the decoration control
     * whether is the right one.
     */
    private void checkTableInput(Object notifier) {
        if (control != null && !control.isDisposed() && control instanceof Table) {
            Table table = ((Table) control);
            if (table.getItemCount() > 0) {
                Object data = table.getItem(0).getData();
                if (data.getClass().equals(notifier.getClass())) {
                    PatternUIHelper.validationContent(mmng, pattern, key, control);
                    return;
                }
            }
        }
    }

    /**
     * Check whether the feature of notification is name feature.
     */
    private boolean isNameChange(Notification notification) {
        Object feature = notification.getFeature();
        if (feature instanceof EAttribute) {
            EAttribute eAttribute = ((EAttribute) feature);
            if ("name".equals(eAttribute.getName())) {
                return true;
            }
        }
        return false;
    }
}
