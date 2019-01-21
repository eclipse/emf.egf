/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.InjectedContext;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class OrchestrationTableLabelProvider extends LabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof MethodCall)
            return Activator.getDefault().getImage(ImageShop.IMG_KIND_METHODCALL);
        else if (element instanceof PatternCall)
            return Activator.getDefault().getImage(ImageShop.IMG_KIND_PATTERNCALL);
        else if (element instanceof PatternInjectedCall)
            return Activator.getDefault().getImage(ImageShop.IMG_KIND_PATTERNINJECTEDCALL);
        else if (element instanceof SuperCall)
            return Activator.getDefault().getImage(ImageShop.IMG_KIND_SUPERPATTERNCALL);
        else if (element instanceof BackCall)
            return Activator.getDefault().getImage(ImageShop.IMG_KIND_BACKCALL);
        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof MethodCall) {
            MethodCall methodCall = (MethodCall) element;
            PatternMethod patternMethod = methodCall.getCalled();
            return (patternMethod == null ? "" : patternMethod.getName()) + Messages.OrchestrationTableLabelProvider_MethodCall; //$NON-NLS-1$
        } else if (element instanceof PatternCall) {
            PatternCall patternCall = (PatternCall) element;
            Pattern pattern = patternCall.getCalled();
            return (pattern == null ? "" : pattern.getName()) + Messages.OrchestrationTableLabelProvider_PatternCall; //$NON-NLS-1$
        } else if (element instanceof PatternInjectedCall) {
            PatternInjectedCall patternInjectedCall = (PatternInjectedCall) element;
            Pattern pattern = patternInjectedCall.getCalled();
            InjectedContext injectCtx = patternInjectedCall.getContext();
            return (pattern == null ? "" : pattern.getName() + " -> " + injectCtx.getName()) + Messages.OrchestrationTableLabelProvider_PatternInjectedCall; //$NON-NLS-1$ //$NON-NLS-2$
        } else if (element instanceof SuperCall) {
            return Messages.OrchestrationTableLabelProvider_SuperPatternCall;
        } else if (element instanceof BackCall) {
            return Messages.OrchestrationTableLabelProvider_BackCall;
        }
        return ""; //$NON-NLS-1$
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
        // Nothing to do
    }

    @Override
    public void dispose() {
        // Nothing to do
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        // Nothing to do
    }

}
