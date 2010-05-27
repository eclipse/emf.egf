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

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.provider.PatternItemProviderAdapterFactory;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternElementLabelProvider implements ILabelProvider {

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {

        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }

    public Image getImage(Object element) {

        return imageSwitch.doSwitch((EObject) element);
    }

    public String getText(Object element) {

        return textSwitch.doSwitch((EObject) element);
    }

    private final PatternSwitch<Image> imageSwitch = new PatternSwitch<Image>() {
        private final PatternItemProviderAdapterFactory patternItemProviderAdapterFactory = new PatternItemProviderAdapterFactory();

        @Override
        public Image casePattern(Pattern object) {
            ItemProviderAdapter prov = ((ItemProviderAdapter) patternItemProviderAdapterFactory.createPatternAdapter());
            return ExtendedImageRegistry.getInstance().getImage(prov.getImage(object));
        }

        @Override
        public Image casePatternLibrary(PatternLibrary object) {
            ItemProviderAdapter prov = ((ItemProviderAdapter) patternItemProviderAdapterFactory.createPatternLibraryAdapter());
            return ExtendedImageRegistry.getInstance().getImage(prov.getImage(object));
        }
    };

    private final PatternSwitch<String> textSwitch = new PatternSwitch<String>() {

        @Override
        public String casePattern(Pattern object) {

            return object.getName() + Messages.common_mark1 + object.getContainer().getName() + Messages.common_mark2;
        }

        @Override
        public String casePatternLibrary(PatternLibrary object) {
            return object.getName() + Messages.common_mark1 + PatternHelper.getFactoryConponentName(object) + Messages.common_mark2 + " - " + object.eResource().getURI();
        }
    };
}
