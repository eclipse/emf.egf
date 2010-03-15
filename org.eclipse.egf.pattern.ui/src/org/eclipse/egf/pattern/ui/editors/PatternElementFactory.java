/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.egf.core.EGFCorePlugin;
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
    final String patternMethodId = memento.getString(PatternMethodEditorInput.PATTERN_METHOD_ID);
    final String resourceURI = memento.getString(PatternEditorInput.RESSOURCE_URI);
    URI uri = URI.createURI(resourceURI);
    TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);

    Resource res = editingDomain.getResourceSet().getResource(uri, true);
    if (patternId != null)
      return new PatternEditorInput(res, patternId);
    if (patternMethodId != null)
      return new PatternMethodEditorInput(res, patternMethodId);
    throw new IllegalStateException();
  }

}
