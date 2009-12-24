/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.dialogs;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
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
public class FcoreSelectionDialog extends FilteredItemsSelectionDialog {

  private static final String DIALOG_SETTINGS = "org.eclipse.egf.model.fcore.presentation.FcoreSelectionDialog"; //$NON-NLS-1$

  private class FcoreSearchItemsFilter extends ItemsFilter {
    @Override
    public boolean isConsistentItem(Object item) {
      return true;
    }

    @Override
    public boolean matchItem(Object item) {
      String id = null;
      if (item instanceof IPlatformFcore) {
        IPlatformFcore model = (IPlatformFcore) item;
        id = model.getURI().toString();
      }

      return (matches(id));
    }

    @Override
    protected boolean matches(String text) {
      String pattern = patternMatcher.getPattern();
      if (pattern.indexOf("*") != 0 & pattern.indexOf("?") != 0 & pattern.indexOf(".") != 0) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        pattern = "*" + pattern; //$NON-NLS-1$
        patternMatcher.setPattern(pattern);
      }
      return patternMatcher.matches(text);
    }
  }

  private class FcoreSearchComparator implements Comparator<IPlatformFcore> {
    public int compare(IPlatformFcore fc1, IPlatformFcore fc2) {
      return fc1.compareTo(fc2);
    }
  }

  private IPlatformFcore[] _fcores;

  private ILabelProvider _labelProvider = new LabelProvider() {
    @Override
    public Image getImage(Object element) {
      return ExtendedImageRegistry.getInstance().getImage(EGFModelsEditPlugin.INSTANCE.getImage("full/obj16/FactoryComponent")); //$NON-NLS-1$
    }

    @Override
    public String getText(Object element) {
      if (element instanceof IPlatformFcore == false) {
        return super.getText(element);
      }
      return ((IPlatformFcore) element).getURI().toString();
    }
  };

  private ILabelProvider _detailsLabelProvider = new LabelProvider() {
    @Override
    public Image getImage(Object element) {
      return ExtendedImageRegistry.getInstance().getImage(EGFModelsEditPlugin.INSTANCE.getImage("full/obj16/FactoryComponent")); //$NON-NLS-1$
    }

    @Override
    public String getText(Object element) {
      if (element instanceof IPlatformFcore == false) {
        return super.getText(element);
      }
      StringBuffer buffer = new StringBuffer();
      IPlatformFcore fc = (IPlatformFcore) element;
      if (fc.getPlatformBundle().isTarget()) {
        buffer.append(" [Target]"); //$NON-NLS-1$
      } else {
        buffer.append(" [Workspace]"); //$NON-NLS-1$
      }
      buffer.append(" ["); //$NON-NLS-1$
      buffer.append(fc.getPlatformBundle().getBundleLocation());
      buffer.append("]"); //$NON-NLS-1$      
      return buffer.toString();
    }
  };

  public FcoreSelectionDialog(Shell parentShell, boolean multipleSelection) {
    this(parentShell, getElements(), multipleSelection);
  }

  public FcoreSelectionDialog(Shell parentShell, IPlatformFcore[] factoryComponents, boolean multipleSelection) {
    super(parentShell, multipleSelection);
    _fcores = factoryComponents;
    setTitle(EGFModelsEditorPlugin.INSTANCE.getString("_UI_FcoreSelection_label")); //$NON-NLS-1$
    setMessage(EGFModelsEditorPlugin.INSTANCE.getString("_UI_SelectRegisteredFcoreURI")); //$NON-NLS-1$
    setListLabelProvider(_labelProvider);
    setDetailsLabelProvider(_detailsLabelProvider);
  }

  private static IPlatformFcore[] getElements() {
    return EGFCorePlugin.getPlatformFcores();
  }

  @Override
  protected Control createExtendedContentArea(Composite parent) {
    return null;
  }

  @Override
  protected ItemsFilter createFilter() {
    return new FcoreSearchItemsFilter();
  }

  @Override
  protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
    for (int i = 0; i < _fcores.length; i++) {
      contentProvider.add(_fcores[i], itemsFilter);
      progressMonitor.worked(1);
    }
    progressMonitor.done();
  }

  @Override
  protected IDialogSettings getDialogSettings() {
    IDialogSettings settings = EGFModelsEditorPlugin.getPlugin().getDialogSettings().getSection(DIALOG_SETTINGS);
    if (settings == null) {
      settings = EGFModelsEditorPlugin.getPlugin().getDialogSettings().addNewSection(DIALOG_SETTINGS);
    }
    return settings;
  }

  @Override
  public String getElementName(Object item) {
    if (item instanceof IPlatformFcore) {
      IPlatformFcore fc = (IPlatformFcore) item;
      return fc.getURI().toString();
    }
    return null;
  }

  @Override
  protected Comparator<IPlatformFcore> getItemsComparator() {
    return new FcoreSearchComparator();
  }

  @Override
  protected IStatus validateItem(Object item) {
    return new Status(IStatus.OK, EGFModelsEditorPlugin.getPlugin().getSymbolicName(), 0, "", null); //$NON-NLS-1$
  }

}
