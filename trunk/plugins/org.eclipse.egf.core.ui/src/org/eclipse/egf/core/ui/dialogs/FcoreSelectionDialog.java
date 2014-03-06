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
package org.eclipse.egf.core.ui.dialogs;

import java.io.File;
import java.io.Serializable;
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
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreSelectionDialog extends AbstractFilteredItemsSelectionDialog {

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
            for (IPlatformFcore fcore : EGFCorePlugin.getTargetPlatformFcores()) {
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

    }

    private static class FcoreSearchComparator implements Comparator<IPlatformFcore>, Serializable {

        public static final long serialVersionUID = 1L;

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

    private static IPlatformFcore[] getElements() {
        return EGFCorePlugin.getTargetPlatformFcores();
    }

    private ILabelProvider _labelProvider = new LabelProvider() {

        @Override
        public Image getImage(Object element) {
            if (element instanceof IPlatformFcore == false) {
                return super.getImage(element);
            }
            return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FCORE);
        }

        @Override
        public String getText(Object element) {
            if (element instanceof IPlatformFcore == false) {
                return super.getText(element);
            }
            return ((IPlatformFcore) element).getName();
        }
    };

    private class ResourceSelectionLabelProvider extends LabelProvider implements ILabelDecorator {

        public ResourceSelectionLabelProvider() {
            // Nothing to do
        }

        public String decorateText(String text, Object element) {
            if (element instanceof IPlatformFcore == false) {
                return getText(element);
            }
            return ((IPlatformFcore) element).getURI().toString();
        }

        public Image decorateImage(Image image, Object element) {
            if (element instanceof IPlatformFcore == false) {
                return getImage(element);
            }
            return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FCORE);
        }

    }

    private ILabelProvider _detailsLabelProvider = new LabelProvider() {

        @Override
        public Image getImage(Object element) {
            if (element instanceof IPlatformFcore == false) {
                return super.getImage(element);
            }
            IPlatformFcore fc = (IPlatformFcore) element;
            File file = new File(fc.getPlatformBundle().getInstallLocation());
            if (file.exists() && file.isDirectory()) {
                return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_DIRECTORY);
            } else if (file.exists() && file.isFile()) {
                return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_JAR);
            }
            return EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FCORE);
        }

        @Override
        public String getText(Object element) {
            if (element instanceof IPlatformFcore == false) {
                return super.getText(element);
            }
            StringBuffer buffer = new StringBuffer();
            IPlatformFcore fcore = (IPlatformFcore) element;
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
    };

    private IPlatformFcore[] _fcores;

    public FcoreSelectionDialog(Shell parentShell, boolean multipleSelection) {
        this(parentShell, getElements(), multipleSelection);
    }

    public FcoreSelectionDialog(Shell parentShell, IPlatformFcore[] factoryComponents, boolean multipleSelection) {
        super(parentShell, multipleSelection);
        _fcores = factoryComponents;
        setTitle(CoreUIMessages._UI_FcoreSelection_label);
        setMessage(CoreUIMessages._UI_SelectRegisteredFcore);
        setListLabelProvider(getLabelProvider());
        setListSelectionLabelDecorator(getSelectionLabelProvider());
        setDetailsLabelProvider(getDetailsLabelProvider());
        setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_platformSeparatorLabel);
        setSelectionHistory(new FcoreSelectionHistory());
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
            List<IPlatformFcore> fcores = new UniqueEList<IPlatformFcore>();
            for (Object object : selection.toList()) {
                if (object instanceof IPlatformFcore) {
                    fcores.add((IPlatformFcore) object);
                }
            }
            notifySelectionListeners(fcores.toArray());
        }
    }

    protected ILabelProvider getLabelProvider() {
        return _labelProvider;
    }

    protected ILabelDecorator getSelectionLabelProvider() {
        return new ResourceSelectionLabelProvider();
    }

    protected ILabelProvider getDetailsLabelProvider() {
        return _detailsLabelProvider;
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
