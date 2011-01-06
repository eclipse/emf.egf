/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.extension;

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.engine.PatternEngine;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 */
public abstract class PatternExtension {

    public static final String EXTENSION_ID = "org.eclipse.egf.pattern.extension"; //$NON-NLS-1$

    public abstract PatternNature getNature();

    public abstract PatternFactory getFactory();

    protected abstract AdapterFactory getAdapterFactory();

    protected abstract PatternEngine doCreateRunner(Pattern pattern) throws PatternException;

    public PatternEngine createEngine(Pattern pattern) throws PatternException {
        if (!matchNature(pattern))
            throw new PatternException(NLS.bind(EGFPatternMessages.extension_error2, getNature().eClass().getName(), pattern.getNature().eClass().getName()));
        return doCreateRunner(pattern);
    }

    protected abstract PatternInitializer doCreateInitializer(IProject project, Pattern pattern);

    public PatternInitializer createInitializer(IProject project, Pattern pattern) throws PatternException {
        if (!matchNature(pattern))
            throw new PatternException(NLS.bind(EGFPatternMessages.extension_error2, getNature().eClass().getName(), pattern.getNature().eClass().getName()));
        return doCreateInitializer(project, pattern);
    }

    public boolean matchNature(Pattern pattern) {
        if (pattern == null || pattern.getNature() == null)
            throw new IllegalArgumentException();
        if (getNature() == null)
            throw new IllegalStateException();

        return getNature().eClass().equals(pattern.getNature().eClass());
    }

    public final URL getImageURL() {
        IItemLabelProvider itemLabelProvider = (IItemLabelProvider) getAdapterFactory().adapt(getNature(), IItemLabelProvider.class);
        return (URL) itemLabelProvider.getImage(getNature());
    }

    /**
     * Tells if the pattern can be translated.
     * 
     * @return the reason who prevents the translation or null if there is no
     *         problem
     */
    public String canTranslate(Pattern pattern) {
        if (pattern.getSuperPattern() != null && pattern.getSuperPattern().eIsProxy()) {
            return NLS.bind(EGFPatternMessages.Super_Pattern_Not_Found, pattern.getSuperPattern().toString());
        }
        IProject project = EMFHelper.getProject(pattern.eResource());
        if (project == null) {
            return NLS.bind(EGFCommonMessages.No_associated_project, EcoreUtil.getURI(pattern).trimFragment());
        }
        IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(pattern.getHeaderMethod().getPatternFilePath().toPlatformString(true));
        if (resource == null) {
            return EGFPatternMessages.assembly_error5;
        }
        return null; // no problem
    }

    /**
     * Tells if the pattern can be executed.
     * 
     * @return the reason who prevents the execution or null if there is no
     *         problem
     */
    public String canExecute(Pattern pattern) {
        // todo it should be in a validation rule...
        return null; // no problem
    }

}
