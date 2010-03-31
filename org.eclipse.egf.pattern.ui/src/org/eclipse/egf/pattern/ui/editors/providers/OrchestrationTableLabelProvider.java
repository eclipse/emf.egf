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

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.InjectedContext;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.SuperCall;
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
            return ImageShop.get(ImageShop.IMG_KIND_METHODCALL);
        else if (element instanceof PatternCall)
            return ImageShop.get(ImageShop.IMG_KIND_PATTERNCALL);
        else if (element instanceof PatternInjectedCall)
            return ImageShop.get(ImageShop.IMG_KIND_PATTERNINJECTEDCALL);
        else if (element instanceof SuperCall)
            return ImageShop.get(ImageShop.IMG_KIND_SUPERPATTERNCALL);
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
            return (pattern == null ? "" : pattern.getName() + " -> " + injectCtx.getName()) + Messages.OrchestrationTableLabelProvider_PatternInjectedCall; //$NON-NLS-1$
        } else if (element instanceof SuperCall) {
            return Messages.OrchestrationTableLabelProvider_SuperPatternCall; //$NON-NLS-1$
        }
        return ""; //$NON-NLS-1$
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {

        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

}
