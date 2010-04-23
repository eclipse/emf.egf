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

package org.eclipse.egf.dev.pattern.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.dev.Activator;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * @author Thomas Guiu
 */
public class TranslateAllAction implements IWorkbenchWindowActionDelegate {

  private IWorkbenchWindow _window;

  public TranslateAllAction() {
  }

  public void run(IAction action) {
    List<Pattern> result = new ArrayList<Pattern>(200);
    IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores();
    ResourceSet resourceSet = new ResourceSetImpl();
    try {
      for (IPlatformFcore platformFcore : platformFcores) {
        URI uri = platformFcore.getURI();
        Resource res = resourceSet.getResource(uri, true);
        PatternCollector.INSTANCE.collect(res.getContents(), result, PatternCollector.EMPTY_ID_SET);
      }
      new TranslationHelper().translate(result);
    } catch (Exception e) {
      MessageDialog.openError(_window.getShell(), "Error", e.getMessage()); //$NON-NLS-1$
      Activator.getDefault().logError(e);
    }

  }

  /**
   * Selection in the workbench has been changed. We
   * can change the state of the 'real' action here
   * if we want, but this can only happen after
   * the delegate has been created.
   * 
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action, ISelection selection) {
    // Nothing to do
  }

  /**
   * We can use this method to dispose of any system
   * resources we previously allocated.
   * 
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose() {
    // Nothing to do
  }

  /**
   * We will cache window object in order to
   * be able to provide parent shell for the message dialog.
   * 
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window) {
    _window = window;
  }

}