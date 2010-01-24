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
package org.eclipse.egf.model.editor.dialogs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.provider.FcoreItemProviderAdapterFactory;
import org.eclipse.egf.model.fprod.provider.FprodItemProviderAdapterFactory;
import org.eclipse.egf.model.resource.ModelResourceItemProviderAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
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
public class ActivitySelectionDialog extends FilteredItemsSelectionDialog {

  private static final String DIALOG_SETTINGS = "org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog"; //$NON-NLS-1$

  private Class<?> _clazz;

  private Resource _context;

  private Activity _activity;

  private ResourceSet _resourceSet;

  private ComposedAdapterFactory _adapterFactory;

  /**
   * <code>ActivitySelectionHistory</code> provides behavior specific to
   * Activity - storing and restoring <code>Activity</code>s state
   * to/from XML (memento).
   */
  private class ActivitySelectionHistory extends SelectionHistory {

    private static final String TAG_URI = "path"; //$NON-NLS-1$

    private boolean _doNotSave = false;

    public ActivitySelectionHistory() {
      super();
    }

    @Override
    protected Object restoreItemFromMemento(IMemento memento) {
      // If a previous has been set, ignore memento
      if (_clazz != null) {
        _doNotSave = true;
        return _activity;
      }
      // Restore
      String tag = memento.getString(TAG_URI);
      if (tag == null) {
        return null;
      }
      try {
        _activity = (Activity) _resourceSet.getEObject(URI.createURI(tag), true);
      } catch (Exception e) {
        EGFModelEditorPlugin.getPlugin().logError(e);
      }
      return _activity;
    }

    @Override
    protected void storeItemToMemento(Object item, IMemento element) {
      // Ignore memento
      if (_doNotSave) {
        return;
      }
      // Save
      if (getReturnCode() == OK) {
        Object[] items = getHistoryItems();
        for (int i = 0; i < items.length; i++) {
          element.putString(TAG_URI, EcoreUtil.getURI((Activity) items[i]).toString());
        }
      } else if (_activity != null) {
        element.putString(TAG_URI, EcoreUtil.getURI(_activity).toString());
      }
    }

  }

  private class ActivitySearchItemsFilter extends ItemsFilter {

    @Override
    public boolean matchItem(Object item) {
      if (item instanceof Activity == false) {
        return false;
      }
      Activity activity = (Activity) item;
      if (activity.getName() == null) {
        return true;
      }
      return (matches(activity.getName()));
    }

    @Override
    public boolean isConsistentItem(Object item) {
      if (item instanceof Activity) {
        return true;
      }
      return false;
    }

    @Override
    public boolean isSubFilter(ItemsFilter filter) {
      if (super.isSubFilter(filter) == false) {
        return false;
      }
      if (filter instanceof ActivitySearchItemsFilter) {
        return true;
      }
      return false;
    }

    @Override
    public boolean equalsFilter(ItemsFilter filter) {
      if (super.equalsFilter(filter) == false) {
        return false;
      }
      if (filter instanceof ActivitySearchItemsFilter) {
        return true;
      }
      return false;
    }

    // Activate to run a full load when dialog is opened
    // @Override
    // protected boolean matches(String text) {
    // String pattern = patternMatcher.getPattern();
    //    if (pattern.indexOf("*") != 0 & pattern.indexOf("?") != 0 & pattern.indexOf(".") != 0) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    //      pattern = "*" + pattern; //$NON-NLS-1$
    // patternMatcher.setPattern(pattern);
    // }
    // return patternMatcher.matches(text);
    // }

  }

  private class ActivitySearchComparator implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2) {
      if (a1.getName() == null && a2.getName() == null) {
        return 0;
      }
      if (a1.getName() != null && a2.getName() == null) {
        return -1;
      }
      if (a1.getName() == null && a2.getName() != null) {
        return 1;
      }
      return a1.getName().compareTo(a2.getName());
    }
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getLabelProvider()
   */
  protected ILabelProvider getLabelProvider() {
    return new LabelProvider() {
      ILabelProvider _labelProvider = new AdapterFactoryLabelProvider(_adapterFactory);

      @Override
      public String getText(Object object) {
        return _labelProvider.getText(object);
      }

      @Override
      public Image getImage(Object object) {
        return _labelProvider.getImage(object);
      }
    };
  }

  protected ILabelProvider getDetailsLabelProvider() {
    return new LabelProvider() {
      ILabelProvider _labelProvider = new AdapterFactoryLabelProvider(_adapterFactory);

      @Override
      public Image getImage(Object object) {
        return _labelProvider.getImage(object);
      }

      @Override
      public String getText(Object element) {
        // This shouldn't happen
        if (element instanceof Activity == false) {
          return super.getText(element);
        }
        // In memory activity, in case of...
        Activity activity = (Activity) element;
        if (activity.eResource() == null) {
          return super.getText(element);
        }
        // Retrieve Fcore
        IPlatformFcore fc = EGFCorePlugin.getPlatformFcore(activity.eResource());
        if (fc == null) {
          return super.getText(element);
        }
        StringBuffer buffer = new StringBuffer(fc.getURI() == null ? "" : URI.decode(fc.getURI().toString())); //$NON-NLS-1$
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
  }

  public ActivitySelectionDialog(Shell parentShell, boolean multipleSelection) {
    super(parentShell, multipleSelection);
    // Create and init a resourceSet
    _resourceSet = new ResourceSetImpl();
    // Assign a fresh platform aware URIConverter
    _resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Create an adapter factory that yields item providers.
    _adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    _adapterFactory.addAdapterFactory(new ModelResourceItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new FprodItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    setMessage(NLS.bind(ModelEditorMessages._UI_ActivitySelectionDialog_dialogMessage, Activity.class.getSimpleName()));
    setListLabelProvider(getLabelProvider());
    setDetailsLabelProvider(getDetailsLabelProvider());
    setSelectionHistory(new ActivitySelectionHistory());
    setSeparatorLabel(ModelEditorMessages._UI_FilteredItemsSelectionDialog_platformSeparatorLabel);
  }

  public ActivitySelectionDialog(Shell parentShell, Resource context, Activity activity, boolean multipleSelection) {
    this(parentShell, null, context, activity, multipleSelection);
  }

  public ActivitySelectionDialog(Shell parentShell, Class<?> clazz, Resource context, Activity activity, boolean multipleSelection) {
    super(parentShell, multipleSelection);
    _clazz = clazz;
    _context = context;
    _activity = activity;
    // Create and init a resourceSet
    _resourceSet = new ResourceSetImpl();
    // Assign a fresh platform aware URIConverter
    _resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Create an adapter factory that yields item providers.
    _adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    _adapterFactory.addAdapterFactory(new ModelResourceItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new FprodItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
    _adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    if (_clazz != null) {
      setTitle(NLS.bind(ModelEditorMessages._UI_ActivitySelectionDialog_dialogTitle, clazz.getSimpleName()));
      setMessage(NLS.bind(ModelEditorMessages._UI_ActivitySelectionDialog_dialogMessage, clazz.getSimpleName()));
    } else {
      setTitle(NLS.bind(ModelEditorMessages._UI_ActivitySelectionDialog_dialogTitle, Activity.class.getSimpleName()));
      setMessage(NLS.bind(ModelEditorMessages._UI_ActivitySelectionDialog_dialogMessage, Activity.class.getSimpleName()));
    }
    setListLabelProvider(getLabelProvider());
    setDetailsLabelProvider(getDetailsLabelProvider());
    setSelectionHistory(new ActivitySelectionHistory());
    if (_activity != null && _activity.eResource() != null) {
      IPlatformFcore fc = EGFCorePlugin.getPlatformFcore(_activity.eResource());
      setSeparatorLabel(NLS.bind(ModelEditorMessages._UI_FilteredItemsSelectionDialog_separatorLabel, fc.getPlatformBundle().getBundleId()));
    } else {
      setSeparatorLabel(ModelEditorMessages._UI_FilteredItemsSelectionDialog_platformSeparatorLabel);
    }
  }

  @Override
  public Object[] getResult() {
    Object[] result = super.getResult();
    if (result == null) {
      return null;
    }
    List<Activity> resultToReturn = new ArrayList<Activity>();
    for (int i = 0; i < result.length; i++) {
      if (result[i] instanceof Activity) {
        resultToReturn.add(((Activity) result[i]));
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
    return new ActivitySearchItemsFilter();
  }

  @Override
  protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
    try {
      for (IPlatformFcore fc : EGFCorePlugin.getPlatformFcores()) {
        // Load Fcore
        Resource resource = null;
        try {
          // Analyse existing in memory resource if applicable
          if (_context != null && _context.getResourceSet() != null) {
            resource = _context.getResourceSet().getResource(fc.getURI(), false);
          }
          // If no memory resource are found or no _activity
          if (resource == null) {
            resource = _resourceSet.getResource(fc.getURI(), true);
          }
        } catch (OperationCanceledException e) {
          return;
        } catch (Exception e) {
          EGFModelEditorPlugin.getPlugin().logError(e);
          continue;
        }
        // Analyse top contents for Activities
        for (EObject eObject : resource.getContents()) {
          // Ignore current
          if (_activity != null && EcoreUtil.getURI(_activity).equals(EcoreUtil.getURI(eObject))) {
            continue;
          }
          // Process
          try {
            if (_clazz != null) {
              eObject.eClass().getInstanceClass().asSubclass(_clazz);
            }
            contentProvider.add(eObject, itemsFilter);
          } catch (OperationCanceledException e) {
            return;
          } catch (ClassCastException cce) {
            // Ignore
            continue;
          }
        }
        progressMonitor.worked(1);
      }
    } catch (OperationCanceledException e) {
      return;
    } finally {
      progressMonitor.done();
    }
  }

  @Override
  protected IDialogSettings getDialogSettings() {
    IDialogSettings settings = EGFModelEditorPlugin.getPlugin().getDialogSettings().getSection(DIALOG_SETTINGS);
    if (settings == null) {
      settings = EGFModelEditorPlugin.getPlugin().getDialogSettings().addNewSection(DIALOG_SETTINGS);
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
  protected Comparator<Activity> getItemsComparator() {
    return new ActivitySearchComparator();
  }

  @Override
  protected IStatus validateItem(Object item) {
    return new Status(IStatus.OK, EGFModelEditorPlugin.getPlugin().getBundle().getSymbolicName(), 0, "", null); //$NON-NLS-1$
  }

}
