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
package org.eclipse.egf.core.ui.dialogs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreSelectionDialog extends FilteredItemsSelectionDialog {

  private static final String DIALOG_SETTINGS = "org.eclipse.egf.core.ui.dialogs.FcoreSelectionDialog"; //$NON-NLS-1$

  /**
   * <code>FcoreSelectionHistory</code> provides behavior specific to
   * fcores - storing and restoring <code>IPlatformFcore</code>s state
   * to/from XML (memento).
   */
  private class FcoreSelectionHistory extends SelectionHistory {

    private static final String TAG_URI = "path"; //$NON-NLS-1$

    private IPlatformFcore _previous;

    public FcoreSelectionHistory() {
      super();
    }

    @Override
    protected Object restoreItemFromMemento(IMemento memento) {
      // Get the IPlatformFcore URI
      String tag = memento.getString(TAG_URI);
      if (tag == null) {
        return null;
      }
      URI uri = URI.createURI(tag);
      // TODO: We should have an index to improve such control
      for (IPlatformFcore fcore : EGFCorePlugin.getPlatformFcores()) {
        if (fcore.getURI().equals(uri)) {
          _previous = fcore;
          return fcore;
        }
      }
      return null;
    }

    @Override
    protected void storeItemToMemento(Object item, IMemento element) {
      if (getReturnCode() == OK) {
        Object[] items = getHistoryItems();
        for (int i = 0; i < items.length; i++) {
          IPlatformFcore fcore = (IPlatformFcore) items[i];
          element.putString(TAG_URI, fcore.getURI().toString());
        }
      } else if (_previous != null) {
        element.putString(TAG_URI, _previous.getURI().toString());
      }
    }

  }

  private class FcoreSearchItemsFilter extends ItemsFilter {

    @Override
    public boolean matchItem(Object item) {
      if (item instanceof IPlatformFcore == false) {
        return false;
      }
      return (matches(((IPlatformFcore) item).getName()));
    }

    @Override
    public boolean isConsistentItem(Object item) {
      if (item instanceof IPlatformFcore) {
        return true;
      }
      return false;
    }

    @Override
    public boolean isSubFilter(ItemsFilter filter) {
      if (super.isSubFilter(filter) == false) {
        return false;
      }
      if (filter instanceof FcoreSearchItemsFilter) {
        return true;
      }
      return false;
    }

    @Override
    public boolean equalsFilter(ItemsFilter filter) {
      if (super.equalsFilter(filter) == false) {
        return false;
      }
      if (filter instanceof FcoreSearchItemsFilter) {
        return true;
      }
      return false;
    }

    // Activate to run a full load when dialog is opened
    // @Override
    // protected boolean matches(String text) {
    // String pattern = patternMatcher.getPattern();
    //      if (pattern.indexOf("*") != 0 & pattern.indexOf("?") != 0 & pattern.indexOf(".") != 0) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    //        pattern = "*" + pattern; //$NON-NLS-1$
    // patternMatcher.setPattern(pattern);
    // }
    // return patternMatcher.matches(text);
    // }

  }

  private class FcoreSearchComparator implements Comparator<IPlatformFcore> {
    public int compare(IPlatformFcore fc1, IPlatformFcore fc2) {
      if (fc1.getName() == null) {
        return -1;
      }
      if (fc2.getName() == null) {
        return 1;
      }
      return fc1.getName().compareTo(fc2.getName());
    }
  }

  private IPlatformFcore[] _fcores;

  private ILabelProvider _labelProvider = new LabelProvider() {
    @Override
    public Image getImage(Object element) {
      return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FACTORY_COMPONENT);
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
      return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FACTORY_COMPONENT);
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
    setTitle(CoreUIMessages._UI_FcoreSelection_label);
    setMessage(CoreUIMessages._UI_SelectRegisteredFcoreURI);
    setListLabelProvider(_labelProvider);
    setDetailsLabelProvider(_detailsLabelProvider);
    setSelectionHistory(new FcoreSelectionHistory());
  }

  private static IPlatformFcore[] getElements() {
    return EGFCorePlugin.getPlatformFcores();
  }

  @Override
  public Object[] getResult() {
    Object[] result = super.getResult();
    if (result == null) {
      return null;
    }
    List<IPlatformFcore> resultToReturn = new ArrayList<IPlatformFcore>();
    for (int i = 0; i < result.length; i++) {
      if (result[i] instanceof IPlatformFcore) {
        resultToReturn.add(((IPlatformFcore) result[i]));
      }
    }
    return resultToReturn.toArray();
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
    IDialogSettings settings = EGFCoreUIPlugin.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
    if (settings == null) {
      settings = EGFCoreUIPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
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
    return new Status(IStatus.OK, EGFCoreUIPlugin.getDefault().getBundle().getSymbolicName(), 0, "", null); //$NON-NLS-1$
  }

}
