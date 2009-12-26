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
package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.SuperPatternCall;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author xrchen
 * 
 */
public class OrchestrationTableLabelProvider implements ITableLabelProvider {

    public Image getColumnImage(Object element, int columnIndex) {
        if (element instanceof MethodCall)
            return ImageShop.get(ImageShop.IMG_KIND_METODCALL_OBJ);
        else if (element instanceof PatternCall)
            return ImageShop.get(ImageShop.IMG_KIND_PATTERNCALL_OBJ);
        else if (element instanceof PatternInjectedCall)
            return ImageShop.get(ImageShop.IMG_KIND_PATTERNINJECTEDCALL_OBJ);
        else if (element instanceof SuperPatternCall)
            return ImageShop.get(ImageShop.IMG_KIND_SUPERPATTERNCALL_OBJ);
        return null;
    }

    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof MethodCall) {
            MethodCall methodCall = (MethodCall) element;
            PatternMethod patternMethod = methodCall.getCalled();
            return patternMethod.getName() + " - [MethodCall]";
        } else if (element instanceof PatternCall) {
            PatternCall patternCall = (PatternCall) element;
            Pattern patten = patternCall.getCalled();
            return patten.getName() + " - [PatternCall]";
        } else if (element instanceof PatternInjectedCall) {
            PatternInjectedCall patternInjectedCall = (PatternInjectedCall) element;
            Pattern pattern = patternInjectedCall.getCalled();
            PatternVariable patternVariable = patternInjectedCall.getContext();
            return pattern.getName() + patternVariable.getName() + " - [PatternInjectedCall]";
        } else if (element instanceof SuperPatternCall) {
            SuperPatternCall superPatternCall = (SuperPatternCall) element;
            Pattern superPattern = superPatternCall.getCalled();
            return superPattern.getName() + " - [SuperPatternCall]";
        }
        return "";
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
