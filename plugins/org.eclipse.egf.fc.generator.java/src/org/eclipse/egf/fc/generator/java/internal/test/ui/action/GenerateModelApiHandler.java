/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.generator.java.internal.test.ui.action;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author fournier
 */
public class GenerateModelApiHandler extends AbstractHandler {

  /**
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent event_p) throws ExecutionException {
    // Get the selection
    IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    ISelection currentSelection = activeWorkbenchWindow.getSelectionService().getSelection();
    // At the moment, delegates execution to an old-fashion action.
    ModelApiGenerationAction action = new ModelApiGenerationAction();
    action.init(activeWorkbenchWindow);
    // Set the selection
    action.selectionChanged(null, currentSelection);
    action.run(null);
    return null;
  }
}
