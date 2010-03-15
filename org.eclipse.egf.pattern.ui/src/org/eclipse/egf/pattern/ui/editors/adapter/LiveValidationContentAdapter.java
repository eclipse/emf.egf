/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
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

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessageManager;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class LiveValidationContentAdapter extends EContentAdapter {
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
        super.notifyChanged(notification);

        Object feature = notification.getFeature();
        if (feature == null) {
            return;
        }

        PatternUIHelper.validationContent(mmng, pattern, key, control);
    }
}
