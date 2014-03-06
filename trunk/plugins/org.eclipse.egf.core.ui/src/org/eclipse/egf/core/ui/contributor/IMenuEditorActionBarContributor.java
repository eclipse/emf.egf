/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.contributor;

import java.util.List;

import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IMenuEditorActionBarContributor extends IEditorActionBarContributor {

    public void removeEditorMenuContributors(List<EditorMenuContributor> menus);

    public IWorkbenchPage getPage();

}
