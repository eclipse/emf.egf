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
package org.eclipse.egf.model.editor.dialogs;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.core.ui.dialogs.AbstractFilteredItemsSelectionDialog;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.provider.FcoreItemProviderAdapterFactory;
import org.eclipse.egf.model.fcore.provider.FcoreResourceItemProviderAdapterFactory;
import org.eclipse.egf.model.fprod.provider.FprodItemProviderAdapterFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ActivitySelectionDialog extends AbstractFilteredItemsSelectionDialog {

	private static final String DIALOG_SETTINGS = "org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog"; //$NON-NLS-1$

	private Button _targetButton;

	private Button _runtimeButton;

	private boolean _hasRuntimeSupport;

	private boolean _isTargetPlatformVersion;

	private Activity _activity;

	private ResourceSet _resourceSet;

	private ComposedAdapterFactory _adapterFactory;

	private IPlatformFcore[] _content = null;

	private IPlatformFcore[] _runtimeFcores = EGFPlatformPlugin.getPlatformManager().getRuntimePlatformExtensionPoints(IPlatformFcore.class);

	private IPlatformFcore[] _targetFcores = concat(_runtimeFcores, EGFPlatformPlugin.getPlatformManager().getWorkspacePlatformExtensionPoints(IPlatformFcore.class));

	private static <T> T[] concat(T[] first, T[] second) {
		  T[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
		}
	/**
	 * <code>ActivitySelectionHistory</code> provides behavior specific to
	 * Activity - storing and restoring <code>Activity</code>s state
	 * to/from XML (memento).
	 */
	private class ActivitySelectionHistory extends SelectionHistory {

		private static final String TAG_TARGET_PLATFORM = "target"; //$NON-NLS-1$

		private static final String TAG_URI = "path"; //$NON-NLS-1$

		public ActivitySelectionHistory() {
			super();
		}

		@Override
		protected Object restoreItemFromMemento(IMemento memento) {
			// Memento analysis
			String tagURI = memento.getString(TAG_URI);
			// Nothing to restore
			if (tagURI == null) {
				return null;
			}
			Boolean tagMode = memento.getBoolean(TAG_TARGET_PLATFORM);
			// Nothing to restore
			if (tagMode == null) {
				return null;
			}
			// Update mode
			if (_hasRuntimeSupport) {
				_isTargetPlatformVersion = tagMode;
				_targetButton.setSelection(_isTargetPlatformVersion);
				_runtimeButton.setSelection(_isTargetPlatformVersion == false);
				updateMode();
			}
			try {
				Activity activity = (Activity) _resourceSet.getEObject(URI.createURI(tagURI), true);
				// Check whether or not this activity belongs to our fcores
				if (activity.eResource() instanceof IPlatformFcoreProvider) {
					IPlatformFcore fcore = ((IPlatformFcoreProvider) activity.eResource()).getIPlatformFcore();
					if (fcore != null) {
						for (IPlatformFcore innerFcore : _content) {
							if (innerFcore.equals(fcore)) {
								return activity;
							}
						}
					}
				}
			} catch (Exception e) {
				// Just ignore, a retrieved activity could have been deleted,
			}
			return null;
		}

		@Override
		protected void storeItemToMemento(Object item, IMemento element) {
			// Save
			if (_hasRuntimeSupport) {
				element.putString(TAG_TARGET_PLATFORM, Boolean.toString(_isTargetPlatformVersion));
			} else {
				element.putString(TAG_TARGET_PLATFORM, Boolean.toString(true));
			}
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
			if (filter instanceof ActivitySearchItemsFilter && filter == this) {
				return true;
			}
			return false;
		}

		@Override
		public boolean equalsFilter(ItemsFilter filter) {
			if (super.equalsFilter(filter) == false) {
				return false;
			}
			if (filter instanceof ActivitySearchItemsFilter && filter == this) {
				return true;
			}
			return false;
		}

	}

	private static class ActivitySearchComparator implements Comparator<Activity>, Serializable {

		public static final long serialVersionUID = 1L;

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
		return new ActivityLabelProvider(_adapterFactory);
	}

	protected ILabelDecorator getSelectionLabelProvider() {
		return new ActivitySelectionLabelProvider(_adapterFactory);
	}

	protected ILabelProvider getDetailsLabelProvider() {
		return new ActivityDetailsLabelProvider(_adapterFactory);
	}

	private class ActivityLabelProvider extends AdapterFactoryLabelProvider implements ILabelDecorator {

		public ActivityLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof Activity)
				return ((Activity) element).getName() == null ? "" : ((Activity) element).getName();
			return super.getText(element);
		}

		public String decorateText(String text, Object element) {
			return getText(element);
		}

		public Image decorateImage(Image image, Object element) {
			return getImage(element);
		}

	}

	private class ActivityDetailsLabelProvider extends LabelProvider {

		ILabelProvider _adapterFactoryLabelProvider;

		public ActivityDetailsLabelProvider(AdapterFactory adapterFactory) {
			_adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		}

		@Override
		public Image getImage(Object element) {
			// This shouldn't happen
			if (element instanceof Activity == false) {
				return _adapterFactoryLabelProvider.getImage(element);
			}
			// In memory activity, in case of...
			Activity activity = (Activity) element;
			if (activity.eResource() == null || activity.eResource() instanceof IPlatformFcoreProvider == false) {
				return _adapterFactoryLabelProvider.getImage(activity);
			}
			// Retrieve Fcore
			IPlatformFcore fcore = ((IPlatformFcoreProvider) activity.eResource()).getIPlatformFcore();
			if (fcore == null) {
				return _adapterFactoryLabelProvider.getImage(activity);
			}
			File file = new File(fcore.getPlatformBundle().getInstallLocation());
			if (file.exists() && file.isDirectory()) {
				return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_DIRECTORY);
			} else if (file.exists() && file.isFile()) {
				return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_JAR);
			}
			return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FCORE);
		}

		@Override
		public String getText(Object element) {
			// This shouldn't happen
			if (element instanceof Activity == false) {
				return _adapterFactoryLabelProvider.getText(element);
			}
			// In memory activity, in case of...
			Activity activity = (Activity) element;
			if (activity.eResource() == null || activity.eResource() instanceof IPlatformFcoreProvider == false) {
				return _adapterFactoryLabelProvider.getText(activity);
			}
			// Retrieve Fcore
			IPlatformFcore fcore = ((IPlatformFcoreProvider) activity.eResource()).getIPlatformFcore();
			if (fcore == null) {
				return _adapterFactoryLabelProvider.getText(activity);
			}
			StringBuffer buffer = new StringBuffer();
			if (fcore.isTarget()) {
				buffer.append(" [Target]"); //$NON-NLS-1$
			} else if (fcore.isRuntime()) {
				buffer.append(" [Runtime]"); //$NON-NLS-1$                
			} else {
				buffer.append(" [Workspace]"); //$NON-NLS-1$
			}
			buffer.append(" ["); //$NON-NLS-1$
			buffer.append(fcore.getPlatformBundle().getInstallLocation());
			buffer.append("]"); //$NON-NLS-1$      
			return buffer.toString();
		}

	}

	private class ActivitySelectionLabelProvider extends AdapterFactoryLabelProvider implements ILabelDecorator {

		public ActivitySelectionLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		public String decorateText(String text, Object element) {
			if (element instanceof Activity == false) {
				return getText(element);
			}
			return getText(element) + " -> " + EcoreUtil.getURI((Activity) element).trimFragment(); //$NON-NLS-1$
		}

		public Image decorateImage(Image image, Object element) {
			return getImage(element);
		}

	}

	public ActivitySelectionDialog(Shell shell, boolean multipleSelection) {
		this(shell, (Activity) null, multipleSelection);
	}

	public ActivitySelectionDialog(Shell shell, IPlatformFcore fcore, boolean multipleSelection) {
		this(shell, multipleSelection);
		if (fcore != null) {
			_targetFcores = new IPlatformFcore[] { fcore };
			setSeparatorLabel(NLS.bind(CoreUIMessages._UI_FilteredItemsSelectionDialog_separatorLabel, fcore.getPlatformBundle().getBundleId()));
		}
	}

	public ActivitySelectionDialog(Shell shell, Activity activity, boolean multipleSelection) {
		this(shell, activity, multipleSelection, false);
	}

	public ActivitySelectionDialog(Shell shell, Activity activity, boolean multipleSelection, boolean runtime) {
		super(shell, multipleSelection);
		// Default ResourceSet
		_resourceSet = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID).getResourceSet();
		_content = _targetFcores;
		if (activity != null) {
			_activity = (Activity) _resourceSet.getEObject(EcoreUtil.getURI(activity), true);
		}
		// Create an adapter factory that yields item providers.
		_adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		_adapterFactory.addAdapterFactory(new FcoreResourceItemProviderAdapterFactory());
		_adapterFactory.addAdapterFactory(new FprodItemProviderAdapterFactory());
		_adapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
		_adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		_hasRuntimeSupport = runtime;
		setListLabelProvider(getLabelProvider());
		setListSelectionLabelDecorator(getSelectionLabelProvider());
		setDetailsLabelProvider(getDetailsLabelProvider());
		setSelectionHistory(new ActivitySelectionHistory());
		setTitle(NLS.bind(CoreUIMessages._UI_GenericSelectionDialog_dialogTitle, Activity.class.getSimpleName()));
		setMessage(NLS.bind(CoreUIMessages._UI_GenericSelectionDialog_dialogMessage, Activity.class.getSimpleName()));
		if (_activity != null && _activity.eResource() != null && _activity.eResource() instanceof IPlatformFcoreProvider) {
			IPlatformFcore fcore = ((IPlatformFcoreProvider) _activity.eResource()).getIPlatformFcore();
			setSeparatorLabel(NLS.bind(CoreUIMessages._UI_FilteredItemsSelectionDialog_separatorLabel, fcore.getPlatformBundle().getBundleId()));
		} else {
			setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_platformSeparatorLabel);
		}
	}

	/**
	 * Handle selection
	 * 
	 * @param selection
	 *            the new selection
	 */
	@Override
	protected void handleSelected(StructuredSelection selection) {
		if (selection == null || selection.isEmpty()) {
			return;
		}
		super.handleSelected(selection);
		if (selection.size() != 0) {
			List<Activity> activities = new UniqueEList<Activity>();
			for (Object object : selection.toList()) {
				if (object instanceof Activity) {
					activities.add((Activity) object);
				}
			}
			notifySelectionListeners(activities.toArray());
		}
	}

	/**
	 * Hack to use a dialog in a wizard page
	 * 
	 * @return the current shell or its parent shell
	 */
	@Override
	public Shell getShell() {
		return super.getShell() != null ? super.getShell() : getParentShell();
	}

	/**
	 * Hack to use a dialog in a wizard page
	 * 
	 * @return Control
	 * 
	 */
	public Control createPage(Composite parent) {
		return dialogArea = createDialogArea(parent);
	}

	/**
	 * Returns the list of selections made by the user, or <code>null</code> if
	 * the selection was canceled. A computeResult is done when this dialog
	 * is used in a wizard page
	 * 
	 * @return the array of selected elements, or <code>null</code> if Cancel
	 *         was pressed
	 */
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
		if (_hasRuntimeSupport) {
			Composite buttonGroup = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			buttonGroup.setLayout(layout);
			_targetButton = new Button(buttonGroup, SWT.RADIO);
			_targetButton.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					_isTargetPlatformVersion = _targetButton.getSelection();
					updateMode();
					SelectionHistory history = getSelectionHistory();
					if (history != null) {
						for (Object object : history.getHistoryItems()) {
							history.remove(object);
						}
					}
					applyFilter();
				}

			});
			_targetButton.setText(ModelEditorMessages._UI_TargetPlatformVersion_label);
			_targetButton.setSelection(true);
			_isTargetPlatformVersion = true;
			_runtimeButton = new Button(buttonGroup, SWT.RADIO);
			_runtimeButton.setText(ModelEditorMessages._UI_RuntimePlatformVersion_label);
			_runtimeButton.setSelection(false);
		}
		return parent;
	}

	protected void updateMode() {
		if (_isTargetPlatformVersion) {
			_resourceSet = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID).getResourceSet();
			_content = _targetFcores;
			setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_platformSeparatorLabel);
		} else {
			_resourceSet = new RuntimePlatformResourceSet();
			_content = _runtimeFcores;
			setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_runtimeSeparatorLabel);
		}
	}

	@Override
	protected ItemsFilter createFilter() {
		return new ActivitySearchItemsFilter();
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor monitor) throws CoreException {
		SubMonitor innerMonitor = SubMonitor.convert(monitor, null, _content.length * 100);
		try {
			for (IPlatformFcore fcore : _content) {
				// Load Fcore
				Resource resource = null;
				try {
					// Retrieve the in-memory resource if any or load it from
					// disk
					resource = _resourceSet.getResource(fcore.getURI(), true);
				} catch (OperationCanceledException e) {
					return;
				} catch (Exception e) {
					EGFModelEditorPlugin.getPlugin().logError(e);
					continue;
				}
				if (resource == null) {
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
						if (selectElement(eObject)) {
							contentProvider.add(eObject, itemsFilter);
						}
					} catch (OperationCanceledException e) {
						return;
					} catch (ClassCastException cce) {
						// Ignore
						continue;
					}
				}
				innerMonitor.worked(100);
			}
		} catch (OperationCanceledException e) {
			return;
		}
	}

	protected boolean selectElement(EObject eObject) {
		return true;
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
