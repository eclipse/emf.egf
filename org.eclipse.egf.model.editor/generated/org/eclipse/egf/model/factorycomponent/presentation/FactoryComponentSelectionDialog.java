/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.factorycomponent.presentation;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.model.edit.EGFModelsEditPlugin;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FactoryComponentSelectionDialog extends FilteredItemsSelectionDialog {

  private static final String DIALOG_SETTINGS = "org.eclipse.egf.model.factorycomponent.presentation.FactoryComponentSelectionDialog"; //$NON-NLS-1$

  private class FactoryComponentSearchItemsFilter extends ItemsFilter {
    public boolean isConsistentItem(Object item) {
      return true;
    }

    public boolean matchItem(Object item) {
      String id = null;
      if (item instanceof IPlatformFactoryComponent) {
        IPlatformFactoryComponent model = (IPlatformFactoryComponent) item;
        id = model.getURI().toString();
      }

      return (matches(id));
    }

    protected boolean matches(String text) {
      String pattern = patternMatcher.getPattern();
      if (pattern.indexOf("*") != 0 & pattern.indexOf("?") != 0 & pattern.indexOf(".") != 0) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        pattern = "*" + pattern; //$NON-NLS-1$
        patternMatcher.setPattern(pattern);
      }
      return patternMatcher.matches(text);
    }
  }

  private class FactoryComponentSearchComparator implements Comparator<IPlatformFactoryComponent> {
    public int compare(IPlatformFactoryComponent fc1, IPlatformFactoryComponent fc2) {
      return fc1.compareTo(fc2);
    }
  }

  private IPlatformFactoryComponent[] _fcs;

  private ILabelProvider _labelProvider = new LabelProvider() {
    @Override
    public Image getImage(Object element) {
      return ExtendedImageRegistry.getInstance().getImage(EGFModelsEditPlugin.INSTANCE.getImage("full/obj16/FactoryComponent")); //$NON-NLS-1$
    }

    @Override
    public String getText(Object element) {
      if (element instanceof IPlatformFactoryComponent == false) {
        return super.getText(element);
      }
      return ((IPlatformFactoryComponent) element).getURI().toString();
    }
  };

  private ILabelProvider _detailsLabelProvider = new LabelProvider() {
    @Override
    public Image getImage(Object element) {
      return ExtendedImageRegistry.getInstance().getImage(EGFModelsEditPlugin.INSTANCE.getImage("full/obj16/FactoryComponent")); //$NON-NLS-1$
    }

    @Override
    public String getText(Object element) {
      if (element instanceof IPlatformFactoryComponent == false) {
        return super.getText(element);
      }
      return ((IPlatformFactoryComponent) element).getPlatformPlugin().getLocation();
    }
  };

  public FactoryComponentSelectionDialog(Shell parentShell, boolean multipleSelection) {
    this(parentShell, getElements(), multipleSelection);
  }

  public FactoryComponentSelectionDialog(Shell parentShell, IPlatformFactoryComponent[] fcs, boolean multipleSelection) {
    super(parentShell, multipleSelection);
    _fcs = fcs;
    setTitle(EGFModelsEditorPlugin.INSTANCE.getString("_UI_FactoryComponentSelection_label"));
    setMessage(EGFModelsEditorPlugin.INSTANCE.getString("_UI_SelectRegisteredFactoryComponentURI"));
    setListLabelProvider(_labelProvider);
    setDetailsLabelProvider(_detailsLabelProvider);
  }

  private static IPlatformFactoryComponent[] getElements() {
    return EGFPlatformPlugin.getDefault().getFactoryComponents();
  }

  protected Control createExtendedContentArea(Composite parent) {
    return null;
  }

  protected ItemsFilter createFilter() {
    return new FactoryComponentSearchItemsFilter();
  }

  protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
    for (int i = 0; i < _fcs.length; i++) {
      contentProvider.add(_fcs[i], itemsFilter);
      progressMonitor.worked(1);
    }
    progressMonitor.done();
  }

  protected IDialogSettings getDialogSettings() {
    IDialogSettings settings = EGFModelsEditorPlugin.getPlugin().getDialogSettings().getSection(DIALOG_SETTINGS);
    if (settings == null) {
      settings = EGFModelsEditorPlugin.getPlugin().getDialogSettings().addNewSection(DIALOG_SETTINGS);
    }
    return settings;
  }

  public String getElementName(Object item) {
    if (item instanceof IPlatformFactoryComponent) {
      IPlatformFactoryComponent fc = (IPlatformFactoryComponent) item;
      return fc.getURI().toString();
    }
    return null;
  }

  protected Comparator<IPlatformFactoryComponent> getItemsComparator() {
    return new FactoryComponentSearchComparator();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang
   * .Object)
   */
  protected IStatus validateItem(Object item) {
    return new Status(IStatus.OK, EGFModelsEditorPlugin.getPlugin().getSymbolicName(), 0, "", null); //$NON-NLS-1$
  }

}
