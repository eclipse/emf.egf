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
package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.io.Serializable;
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
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.fcore.provider.FcoreItemProviderAdapterFactory;
import org.eclipse.egf.model.fcore.provider.FcoreResourceItemProviderAdapterFactory;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.provider.PatternCustomItemProviderAdapterFactory;
import org.eclipse.egf.model.pattern.provider.PatternItemProviderAdapterFactory;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelDecorator;
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
public class PatternSelectionDialog extends FilteredItemsSelectionDialog {

    private static final String DIALOG_SETTINGS = "org.eclipse.egf.pattern.ui.editors.dialogs.PatternSelectionDialog"; //$NON-NLS-1$

    private Pattern _pattern;

    private EditingDomain _editingDomain;

    private IPlatformFcore[] _fcores = EGFCorePlugin.getPlatformFcores();

    protected ComposedAdapterFactory _adapterFactory;

    protected ComposedAdapterFactory _selectionAdapterFactory;

    private class PatternLabelProvider extends AdapterFactoryLabelProvider implements ILabelDecorator {

        public PatternLabelProvider(AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        @Override
        public String getText(Object element) {
            if (element instanceof Pattern == false) {
                return super.getText(element);
            }
            return ((Pattern) element).getName();
        }

        public String decorateText(String text, Object element) {
            return getText(element);
        }

        public Image decorateImage(Image image, Object element) {
            return getImage(element);
        }

    }

    private class PatternSelectionLabelProvider extends AdapterFactoryLabelProvider implements ILabelDecorator {

        public PatternSelectionLabelProvider(AdapterFactory adapterFactory) {
            super(adapterFactory);
        }

        public String decorateText(String text, Object element) {
            return getText(element);
        }

        public Image decorateImage(Image image, Object element) {
            return getImage(element);
        }
    }

    /**
     * <code>PatternSelectionHistory</code> provides behavior specific to
     * Pattern - storing and restoring <code>Pattern</code>s state
     * to/from XML (memento).
     */
    private class PatternSelectionHistory extends SelectionHistory {

        private static final String TAG_URI = "path"; //$NON-NLS-1$

        public PatternSelectionHistory() {
            super();
        }

        @Override
        protected Object restoreItemFromMemento(IMemento memento) {
            // Restore
            String tag = memento.getString(TAG_URI);
            if (tag == null) {
                return null;
            }
            try {
                _pattern = (Pattern) _editingDomain.getResourceSet().getEObject(URI.createURI(tag), true);
                // Check whether or not this activity belongs to our fcores
                IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(_pattern.eResource());
                if (fcore != null) {
                    for (IPlatformFcore innerFcore : _fcores) {
                        if (innerFcore.equals(fcore)) {
                            return _pattern;
                        }
                    }
                }
            } catch (Exception e) {
                // Just ignore, a retrieved activity could have been deleted,
            } finally {
                _pattern = null;
            }
            return null;
        }

        @Override
        protected void storeItemToMemento(Object item, IMemento element) {
            // Save
            if (getReturnCode() == OK) {
                Object[] items = getHistoryItems();
                for (int i = 0; i < items.length; i++) {
                    element.putString(TAG_URI, EcoreUtil.getURI((Pattern) items[i]).toString());
                }
            } else if (_pattern != null) {
                element.putString(TAG_URI, EcoreUtil.getURI(_pattern).toString());
            }
        }

    }

    private class PatternSearchItemsFilter extends ItemsFilter {

        @Override
        public boolean matchItem(Object item) {
            if (item instanceof Pattern == false) {
                return false;
            }
            Pattern pattern = (Pattern) item;
            if (pattern.getName() == null) {
                return true;
            }
            return (matches(pattern.getName()));
        }

        @Override
        public boolean isConsistentItem(Object item) {
            if (item instanceof Pattern) {
                return true;
            }
            return false;
        }

        @Override
        public boolean isSubFilter(ItemsFilter filter) {
            if (super.isSubFilter(filter) == false) {
                return false;
            }
            if (filter instanceof PatternSearchItemsFilter) {
                return true;
            }
            return false;
        }

        @Override
        public boolean equalsFilter(ItemsFilter filter) {
            if (super.equalsFilter(filter) == false) {
                return false;
            }
            if (filter instanceof PatternSearchItemsFilter) {
                return true;
            }
            return false;
        }

    }

    private static class PatternSearchComparator implements Comparator<Pattern>, Serializable {

        public static final long serialVersionUID = 1L;

        public int compare(Pattern p1, Pattern p2) {
            if (p1.getName() == null && p2.getName() == null) {
                return 0;
            }
            if (p1.getName() != null && p2.getName() == null) {
                return -1;
            }
            if (p1.getName() == null && p2.getName() != null) {
                return 1;
            }
            return p1.getName().compareTo(p2.getName());
        }
    }

    protected ILabelProvider getLabelProvider() {
        return new PatternLabelProvider(_adapterFactory);
    }

    protected ILabelDecorator getSelectionLabelProvider() {
        return new PatternSelectionLabelProvider(_selectionAdapterFactory);
    }

    protected ILabelProvider getDetailsLabelProvider() {
        return new PatternDetailsLabelProvider(_adapterFactory);
    }

    private class PatternDetailsLabelProvider extends LabelProvider {

        ILabelProvider _adapterFactoryLabelProvider;

        public PatternDetailsLabelProvider(AdapterFactory adapterFactory) {
            _adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
        }

        @Override
        public Image getImage(Object element) {
            // This shouldn't happen
            if (element instanceof Pattern == false) {
                return _adapterFactoryLabelProvider.getImage(element);
            }
            // In memory pattern, in case of...
            Pattern pattern = (Pattern) element;
            if (pattern.eResource() == null) {
                return _adapterFactoryLabelProvider.getImage(pattern);
            }
            return _adapterFactoryLabelProvider.getImage(pattern.eResource());
        }

        @Override
        public String getText(Object element) {
            // This shouldn't happen
            if (element instanceof Pattern == false) {
                return _adapterFactoryLabelProvider.getText(element);
            }
            // In memory pattern, in case of...
            Pattern pattern = (Pattern) element;
            if (pattern.eResource() == null) {
                return _adapterFactoryLabelProvider.getText(pattern);
            }
            // Retrieve Fcore
            IPlatformFcore fc = EGFCorePlugin.getPlatformFcore(pattern.eResource());
            if (fc == null) {
                return _adapterFactoryLabelProvider.getText(pattern);
            }
            StringBuffer buffer = new StringBuffer(fc.getURI() == null ? "" : URI.decode(fc.getURI().toString())); //$NON-NLS-1$
            if (fc.getPlatformBundle().isTarget()) {
                buffer.append(" [Target]"); //$NON-NLS-1$
            } else {
                buffer.append(" [Workspace]"); //$NON-NLS-1$
            }
            buffer.append(" ["); //$NON-NLS-1$
            buffer.append(fc.getPlatformBundle().getInstallLocation());
            buffer.append("]"); //$NON-NLS-1$      
            return buffer.toString();
        }
    };

    public PatternSelectionDialog(Shell parentShell, boolean multipleSelection) {
        this(parentShell, (Pattern) null, multipleSelection);
    }

    public PatternSelectionDialog(Shell parentShell, Pattern pattern, boolean multipleSelection) {
        super(parentShell, multipleSelection);
        // Retrieve our EditingDomain
        _editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
        if (pattern != null) {
            _pattern = (Pattern) _editingDomain.getResourceSet().getEObject(EcoreUtil.getURI(pattern), true);
        }
        // Create an adapter factory that yields label providers.
        _adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        _adapterFactory.addAdapterFactory(new FcoreResourceItemProviderAdapterFactory());
        _adapterFactory.addAdapterFactory(new PatternItemProviderAdapterFactory());
        _adapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
        _adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        // Create an adapter factory that yields selection label providers.
        _selectionAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        _selectionAdapterFactory.addAdapterFactory(new FcoreResourceItemProviderAdapterFactory());
        _selectionAdapterFactory.addAdapterFactory(new PatternCustomItemProviderAdapterFactory());
        _selectionAdapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
        _selectionAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        setTitle(NLS.bind(CoreUIMessages._UI_GenericSelectionDialog_dialogTitle, Pattern.class.getSimpleName()));
        setMessage(NLS.bind(CoreUIMessages._UI_GenericSelectionDialog_dialogMessage, Pattern.class.getSimpleName()));
        setListLabelProvider(getLabelProvider());
        setListSelectionLabelDecorator(getSelectionLabelProvider());
        setDetailsLabelProvider(getDetailsLabelProvider());
        setSelectionHistory(new PatternSelectionHistory());
        if (_pattern != null && _pattern.eResource() != null) {
            IPlatformFcore fc = EGFCorePlugin.getPlatformFcore(_pattern.eResource());
            setSeparatorLabel(NLS.bind(CoreUIMessages._UI_FilteredItemsSelectionDialog_separatorLabel, fc.getPlatformBundle().getBundleId()));
        } else {
            setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_platformSeparatorLabel);
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
     * Returns the list of selections made by the user, or <code>null</code>
     * if the selection was canceled. A computeResult is done when this dialog
     * is used in a wizard page
     * 
     * @return the array of selected elements, or <code>null</code> if Cancel
     *         was pressed
     */
    @Override
    public Object[] getResult() {
        Object[] result = super.getResult();
        if (result == null) {
            computeResult();
        }
        result = super.getResult();
        if (result == null || result.length == 0) {
            return null;
        }
        List<Pattern> resultToReturn = new ArrayList<Pattern>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] instanceof Pattern) {
                resultToReturn.add(((Pattern) result[i]));
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
        return new PatternSearchItemsFilter();
    }

    @Override
    protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
        try {
            for (Pattern pattern : PatternHelper.TRANSACTIONNAL_COLLECTOR.getAllPatterns()) {
                // Ignore current
                if (_pattern != null && EcoreUtil.getURI(_pattern).equals(EcoreUtil.getURI(pattern))) {
                    continue;
                }
                // Process
                try {
                    contentProvider.add(pattern, itemsFilter);
                } catch (OperationCanceledException e) {
                    return;
                } catch (ClassCastException cce) {
                    // Ignore
                    continue;
                }
            }
        } catch (OperationCanceledException e) {
            return;
        }
    }

    @Override
    protected IDialogSettings getDialogSettings() {
        IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
        if (settings == null) {
            settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
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
    protected Comparator<Pattern> getItemsComparator() {
        return new PatternSearchComparator();
    }

    @Override
    protected IStatus validateItem(Object item) {
        return new Status(IStatus.OK, Activator.getDefault().getBundle().getSymbolicName(), 0, "", null); //$NON-NLS-1$
    }

}
