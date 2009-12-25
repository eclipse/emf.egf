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

package org.eclipse.egf.pattern.ui.editors;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternElementFactory implements IElementFactory {

    public IAdaptable createElement(IMemento memento) {
        final String patternId = memento.getString(PatternEditorInput.PATTERN_ID);
        final String resourceURI = memento.getString(PatternEditorInput.RESSOURCE_URI);
        // TODO charger la resource et trouver le bon pattern, toutes les info
        // sont dans le memento
        URI uri = URI.createURI(resourceURI);
        TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.eclipse.egf.pattern.ui.editors.PatternEditingDomain");

        Resource res = editingDomain.getResourceSet().getResource(uri, true);
        return new PatternEditorInput(res, patternId);
        // final Pattern collect =
        // PatternCollector.INSTANCE.collect(res.getContents(), patternId);
        // return null;
    }

}
