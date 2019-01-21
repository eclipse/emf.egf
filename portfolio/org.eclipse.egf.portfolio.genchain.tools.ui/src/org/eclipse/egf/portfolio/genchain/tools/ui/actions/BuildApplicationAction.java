/**
 * <copyright>
 *
 *  Copyright (c) 2014 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;


/**
 * 
 * @author Thomas Guiu
 */
public class BuildApplicationAction extends  CreateFcoreAction {
	private IStructuredSelection selection;
	
	public void run(IAction action) {
        IFile modelFile = (IFile) selection.getFirstElement();
        URI modelURI = URI.createPlatformPluginURI(modelFile.getFullPath().toString(), false);
        convertProject(modelFile.getProject());
        BuildApplicationHelper.INSTANCE.build(modelURI);
	}
	
    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = (IStructuredSelection) selection;
        
        super.selectionChanged(action, selection);
    }


}
