/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.strategy.domaindriven;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * TODO: improve pattern selection: At present time, the selection is done via
 * type matching. We can imagine a custom matching policy (for example a pattern
 * can apply if and only if the model element is named 'toto')
 * 
 * This is the default implementation. It supports built-in domain kinds.
 * 
 * @author Thomas Guiu
 * 
 */
public class DefaultDomainVisitor extends AbstractDomainVisitor {

    public Object[] getChildren(Object model) {
        // a implementer par les users en fct du model
        if (model instanceof EObject)
            return ((EObject) model).eContents().toArray();
        if (model instanceof List<?>)
            return ((List<?>) model).toArray();
        if (model instanceof File) {
            final File[] result = ((File) model).listFiles();
            return result == null ? EMPTY_ARRAY : result;
        }

        if (model instanceof IContainer) {

            try {
                IContainer container = (IContainer) model;
                if (container.isAccessible())
                	return container.members();
            } catch (CoreException e) {
                EGFPatternPlugin.getDefault().logError(e);
            }
        }
        return EMPTY_ARRAY;
    }

    @Override
    protected List<Pattern> findPatterns(Object model) {
        if (model instanceof EObject) {
            String fullName = EcoreUtil.getURI(((EObject) model).eClass()).toString();
            return type2patterns.get(fullName);
        }

        return super.findPatterns(model);
    }
}
