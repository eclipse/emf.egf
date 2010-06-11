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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EcoreSelectionDialog extends SelectionStatusDialog {

    private static final String DIALOG_SETTINGS = "org.eclipse.egf.core.ui.dialogs.EcoreSelectionDialog"; //$NON-NLS-1$    

    private static final String SHOW_STATUS_LINE = "ShowStatusLine"; //$NON-NLS-1$

    private class ToggleStatusLineAction extends Action {

        /**
         * Creates a new instance of the class.
         */
        public ToggleStatusLineAction() {
            super(CoreUIMessages.EcoreSelectionDialog_toggleStatusAction, IAction.AS_CHECK_BOX);
        }

        @Override
        public void run() {
            _details.setVisible(isChecked());
        }

    }

    /**
     * A content provider that does nothing.
     */
    private class NullContentProvider implements IContentProvider {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose() {
            // Nothing to do
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
         * java.lang.Object, java.lang.Object)
         */
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            // Nothing to do
        }

    }

    protected class EcoreLabelProvider implements ITableLabelProvider, ILabelProvider {

        public EcoreLabelProvider() {
            // Nothing to do
        }

        public Image getColumnImage(Object element, int columnIndex) {
            return _labelProvider.getImage(element);
        }

        public String getColumnText(Object element, int columnIndex) {
            return _labelProvider.getText(element);
        }

        public void addListener(ILabelProviderListener listener) {
            // Nothing to do
        }

        public void dispose() {
            // Nothing to do
        }

        public boolean isLabelProperty(Object element, String property) {
            return false;
        }

        public void removeListener(ILabelProviderListener listener) {
            // Nothing to do
        }

        public Image getImage(Object element) {
            return getColumnImage(element, 0);
        }

        public String getText(Object element) {
            return getColumnText(element, 0);
        }

    }

    protected class EcoreContentProvider implements ITreeContentProvider {

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            // Nothing to do
        }

        public void dispose() {
            // Nothing to do
        }

        public Object[] getElements(Object inputElement) {
            return getChildren(inputElement);
        }

        public boolean hasChildren(Object element) {
            return getChildren(element).length > 0;
        }

        public Object getParent(Object element) {
            if (element instanceof EObject) {
                return ((EObject) element).eContainer();
            }
            return null;
        }

        public Object[] getChildren(Object parentElement) {
            if (parentElement instanceof Resource) {
                Resource res = (Resource) parentElement;
                return res.getContents().toArray();
            }
            if (parentElement instanceof List<?>)
                return ((List<?>) parentElement).toArray();
            if (parentElement instanceof EPackage) {
                EPackage ePackage = (EPackage) parentElement;
                return ePackage.eContents().toArray();
            }
            return new Object[0];
        }
    }

    /**
     * DetailsContentViewer objects are wrappers for labels.
     * DetailsContentViewer provides means to change label's image and text when
     * the attached LabelProvider is updated.
     */
    private class DetailsContentViewer extends ContentViewer {

        private CLabel label;

        /**
         * Unfortunately, it was impossible to delegate displaying border to
         * label. The <code>ViewForm</code> is used because
         * <code>CLabel</code> displays shadow when border is present.
         */
        private ViewForm viewForm;

        /**
         * Constructs a new instance of this class given its parent and a style
         * value describing its behavior and appearance.
         * 
         * @param parent
         *            the parent component
         * @param style
         *            SWT style bits
         */
        public DetailsContentViewer(Composite parent, int style) {
            viewForm = new ViewForm(parent, style);
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.horizontalSpan = 2;
            viewForm.setLayoutData(gd);
            label = new CLabel(viewForm, SWT.FLAT);
            label.setFont(parent.getFont());
            viewForm.setContent(label);
            hookControl(label);
        }

        /**
         * Shows/hides the content viewer.
         * 
         * @param visible
         *            if the content viewer should be visible.
         */
        public void setVisible(boolean visible) {
            GridData gd = (GridData) viewForm.getLayoutData();
            gd.exclude = !visible;
            viewForm.getParent().layout();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.Viewer#inputChanged(java.lang.Object,
         * java.lang.Object)
         */
        @Override
        protected void inputChanged(Object input, Object oldInput) {
            if (oldInput == null) {
                if (input == null) {
                    return;
                }
                refresh();
                return;
            }
            refresh();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.ContentViewer#handleLabelProviderChanged(org.eclipse.jface.viewers.LabelProviderChangedEvent)
         */
        @Override
        protected void handleLabelProviderChanged(LabelProviderChangedEvent event) {
            if (event != null) {
                refresh(event.getElements());
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.Viewer#getControl()
         */
        @Override
        public Control getControl() {
            return label;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.Viewer#getSelection()
         */
        @Override
        public ISelection getSelection() {
            // not supported
            return null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.Viewer#refresh()
         */
        @Override
        public void refresh() {
            Object input = this.getInput();
            if (input != null) {
                ILabelProvider labelProvider = (ILabelProvider) getLabelProvider();
                doRefresh(labelProvider.getText(input), labelProvider.getImage(input));
            } else {
                doRefresh(null, null);
            }
        }

        /**
         * Sets the given text and image to the label.
         * 
         * @param text
         *            the new text or null
         * @param image
         *            the new image
         */
        private void doRefresh(String text, Image image) {
            label.setText(text);
            label.setImage(image);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection,
         * boolean)
         */
        @Override
        public void setSelection(ISelection selection, boolean reveal) {
            // not supported
        }

        /**
         * Refreshes the label if currently chosen element is on the list.
         * 
         * @param objs
         *            list of changed object
         */
        private void refresh(Object[] objs) {
            if (objs == null || getInput() == null) {
                return;
            }
            Object input = getInput();
            for (int i = 0; i < objs.length; i++) {
                if (objs[i].equals(input)) {
                    refresh();
                    break;
                }
            }
        }

    }

    private class EcoreDetailsLabelProvider extends LabelProvider {

        public EcoreDetailsLabelProvider() {
            // Nothing to do
        }

        @Override
        public Image getImage(Object element) {
            return _labelProvider.getImage(element);
        }

        @Override
        public String getText(Object element) {
            return EcoreUtil.getURI((EObject) element).toString();
        }

    }

    private static final String EMPTY_STRING = ""; //$NON-NLS-1$    

    private MenuManager _menuManager;

    private ToolBar _toolBar;

    private ToolItem _toolItem;

    private boolean _multi;

    private EditingDomain _editingDomain;

    protected TreeViewer _ecoreTypeTreeViewer;

    private IStatus _status;

    private Object[] _currentSelection;

    private DetailsContentViewer _details;

    private ToggleStatusLineAction _toggleStatusLineAction;

    private IHandlerActivation _showViewHandler;

    private ILabelProvider _labelProvider;

    /**
     * It is a duplicate of a field in the CLabel class in DetailsContentViewer.
     * It is maintained, because the <code>setDetailsLabelProvider()</code>
     * could be called before content area is created.
     */
    private ILabelProvider _detailsLabelProvider;

    private List<ISelectionDialogListener> _selectionListeners = new UniqueEList<ISelectionDialogListener>();

    /**
     * Creates a new instance of the class.
     * 
     * @param shell
     *            shell to parent the dialog on
     * @param multi
     *            indicates whether dialog allows to select more than one
     *            position in its list of items
     */
    public EcoreSelectionDialog(Shell shell, boolean multi, EditingDomain editingDomain) {
        super(shell);
        _multi = multi;
        _editingDomain = editingDomain;
        _labelProvider = new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory());
    }

    /**
     * Creates a new instance of the class. Created dialog won't allow to select
     * more than one item.
     * 
     * @param shell
     *            shell to parent the dialog on
     */
    public EcoreSelectionDialog(Shell shell, EditingDomain editingDomain) {
        this(shell, false, editingDomain);
    }

    /**
     * Restores dialog using persisted settings. The default implementation
     * restores the status of the details line and the selection history.
     * 
     * @param settings
     *            settings used to restore dialog
     */
    protected void restoreDialog(IDialogSettings settings) {
        boolean toggleStatusLine = true;
        if (settings.get(SHOW_STATUS_LINE) != null) {
            toggleStatusLine = settings.getBoolean(SHOW_STATUS_LINE);
        }
        _toggleStatusLineAction.setChecked(toggleStatusLine);
        _details.setVisible(toggleStatusLine);
    }

    /**
     * Stores dialog settings.
     * 
     * @param settings
     *            settings used to store dialog
     */
    protected void storeDialog(IDialogSettings settings) {
        settings.put(SHOW_STATUS_LINE, _toggleStatusLineAction.isChecked());
    }

    protected IDialogSettings getDialogSettings() {
        IDialogSettings settings = EGFCoreUIPlugin.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
        if (settings == null) {
            settings = EGFCoreUIPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
        }
        return settings;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#close()
     */
    @Override
    public boolean close() {
        if (_showViewHandler != null) {
            IHandlerService service = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
            service.deactivateHandler(_showViewHandler);
            _showViewHandler.getHandler().dispose();
            _showViewHandler = null;
        }
        storeDialog(getDialogSettings());
        return super.close();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {

        Composite container = (Composite) super.createDialogArea(parent);

        Composite content = new Composite(container, SWT.NONE);
        content.setLayoutData(new GridData(GridData.FILL_BOTH));

        GridLayout layout = new GridLayout();
        layout.marginWidth = 5;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        content.setLayout(layout);

        createHeader(content);

        Composite viewer = new Composite(content, SWT.NONE);
        viewer.setLayoutData(new GridData(GridData.FILL_BOTH));

        layout = new GridLayout();
        layout.marginWidth = 5;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        viewer.setLayout(layout);

        Tree tree = new Tree(viewer, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER | (_multi ? SWT.MULTI : SWT.SINGLE));
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = tree.getItemHeight() * 11;
        tree.setLayoutData(gd);

        _ecoreTypeTreeViewer = new TreeViewer(tree);
        _ecoreTypeTreeViewer.setContentProvider(new EcoreContentProvider());
        _ecoreTypeTreeViewer.setLabelProvider(new EcoreLabelProvider());
        _ecoreTypeTreeViewer.setComparator(new ViewerComparator() {

            private final EcoreSwitch<Integer> _switch = new EcoreSwitch<Integer>() {

                @Override
                public Integer caseEClassifier(EClassifier object) {
                    return 2;
                }

                @Override
                public Integer caseEPackage(EPackage object) {
                    return 1;
                }

            };

            @Override
            public int category(Object element) {
                if (element instanceof EObject) {
                    return _switch.doSwitch((EObject) element);
                }
                return 10;
            }

        });
        _ecoreTypeTreeViewer.addFilter(new ViewerFilter() {

            @Override
            public boolean select(Viewer innerViewer, Object parentElement, Object element) {
                // TODO at present time, we don't support DataType as type for
                // PatternParameter
                return element instanceof EClass || element instanceof EPackage;
            }

        });
        _ecoreTypeTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection selection = (StructuredSelection) event.getSelection();
                handleSelected(selection);
            }

        });

        _ecoreTypeTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                handleDoubleClick();
            }

        });

        Button button = new Button(viewer, SWT.PUSH);
        button.setText(CoreUIMessages.EcoreSelectionDialog_choose_model_button_title);
        button.addListener(SWT.Selection, new Listener() {

            public void handleEvent(Event event) {
                LoadEcoreDialog chooseModelDialog = new LoadEcoreDialog(getShell(), _editingDomain);
                if (chooseModelDialog.open() == Window.OK) {
                    searchTypeModel(chooseModelDialog.getURIText());
                }
            }

        });

        _details = new DetailsContentViewer(content, SWT.BORDER | SWT.FLAT);
        _details.setVisible(_toggleStatusLineAction.isChecked());
        _details.setContentProvider(new NullContentProvider());
        _details.setLabelProvider(getDetailsLabelProvider());

        applyDialogFont(content);

        restoreDialog(getDialogSettings());

        return container;

    }

    /**
     * Create a new header which is labelled by headerLabel.
     * 
     * @param parent
     * @return Label the label of the header
     */
    private Label createHeader(Composite parent) {
        Composite header = new Composite(parent, SWT.NONE);

        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        header.setLayout(layout);

        Label headerLabel = new Label(header, SWT.NONE);
        headerLabel.setText((getMessage() != null && getMessage().trim().length() > 0) ? getMessage() : CoreUIMessages.EcoreSelectionDialog_select);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        headerLabel.setLayoutData(gd);

        createViewMenu(header);
        header.setLayoutData(gd);
        return headerLabel;
    }

    private void createViewMenu(Composite parent) {

        _toolBar = new ToolBar(parent, SWT.FLAT);
        _toolItem = new ToolItem(_toolBar, SWT.PUSH, 0);

        GridData data = new GridData();
        data.horizontalAlignment = GridData.END;
        _toolBar.setLayoutData(data);

        _toolBar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDown(MouseEvent e) {
                showViewMenu();
            }

        });

        _toolItem.setImage(EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_VIEW_MENU));
        _toolItem.setToolTipText(CoreUIMessages.EcoreSelectionDialog_menu);
        _toolItem.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showViewMenu();
            }

        });

        _menuManager = new MenuManager();

        fillViewMenu(_menuManager);

        IHandlerService service = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
        IHandler handler = new AbstractHandler() {

            public Object execute(ExecutionEvent event) {
                showViewMenu();
                return null;
            }
        };
        _showViewHandler = service.activateHandler("org.eclipse.egf.core.ui.dialogs.EcoreSelectionDialog", handler, new ActiveShellExpression(getShell())); //$NON-NLS-1$

    }

    /**
     * Fills the menu of the dialog.
     * 
     * @param menuManager
     *            the menu manager
     */
    protected void fillViewMenu(IMenuManager menuManager) {
        _toggleStatusLineAction = new ToggleStatusLineAction();
        menuManager.add(_toggleStatusLineAction);
    }

    private void showViewMenu() {
        Menu menu = _menuManager.createContextMenu(getShell());
        Rectangle bounds = _toolItem.getBounds();
        Point topLeft = new Point(bounds.x, bounds.y + bounds.height);
        topLeft = _toolBar.toDisplay(topLeft);
        menu.setLocation(topLeft.x, topLeft.y);
        menu.setVisible(true);
    }

    /**
     * Sets label provider for the details field.
     * 
     * For a single selection, the element sent to {@link ILabelProvider#getImage(Object)} and {@link ILabelProvider#getText(Object)} is the selected object, for
     * multiple selection a {@link String} with amount of selected items is the
     * element.
     * 
     * @see #getSelectedItems() getSelectedItems() can be used to retrieve
     *      selected items and get the items count.
     * 
     * @param detailsLabelProvider
     *            the label provider for the details field
     */
    public void setDetailsLabelProvider(ILabelProvider detailsLabelProvider) {
        this._detailsLabelProvider = detailsLabelProvider;
        if (_details != null) {
            _details.setLabelProvider(detailsLabelProvider);
        }
    }

    private ILabelProvider getDetailsLabelProvider() {
        if (_detailsLabelProvider == null) {
            _detailsLabelProvider = new EcoreDetailsLabelProvider();
        }
        return _detailsLabelProvider;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.dialogs.SelectionStatusDialog#computeResult()
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void computeResult() {
        List<Object> selectedElements = ((StructuredSelection) _ecoreTypeTreeViewer.getSelection()).toList();
        List<Object> objectsToReturn = new ArrayList<Object>();
        for (Object object : selectedElements) {
            URI uri = null;
            if (object instanceof EObject) {
                uri = EcoreUtil.getURI((EObject) object);
            }
            if (uri != null && uri.isEmpty() == false && "#//".equals(uri.toString()) == false) { //$NON-NLS-1$
                objectsToReturn.add(uri.toString());
            }
        }
        setResult(objectsToReturn);
    }

    protected void searchTypeModel(String uriText) {
        String[] uris = uriText.split("  "); //$NON-NLS-1$
        List<EObject> resources = new ArrayList<EObject>();
        for (String uri : uris) {
            Resource resource = _editingDomain.loadResource(uri);
            if (resource != null) {
                resources.addAll(resource.getContents());
            }
        }
        _ecoreTypeTreeViewer.setInput(resources);
        _ecoreTypeTreeViewer.expandToLevel(2);
    }

    /**
     * Handle selection in the items list by updating labels of selected and
     * unselected items and refresh the details field using the selection.
     * 
     * @param selection
     *            the new selection
     */
    protected void handleSelected(StructuredSelection selection) {
        IStatus status = new Status(IStatus.OK, EGFCoreUIPlugin.getDefault().getPluginID(), IStatus.OK, EMPTY_STRING, null);
        Object[] lastSelection = _currentSelection;
        _currentSelection = selection.toArray();
        if (selection.size() == 0) {
            status = new Status(IStatus.ERROR, EGFCoreUIPlugin.getDefault().getPluginID(), IStatus.ERROR, EMPTY_STRING, null);
            if (lastSelection != null) {
                _ecoreTypeTreeViewer.update(lastSelection, null);
            }
            _currentSelection = null;
        } else {
            status = new Status(IStatus.ERROR, EGFCoreUIPlugin.getDefault().getPluginID(), IStatus.ERROR, EMPTY_STRING, null);
            List<?> items = selection.toList();
            IStatus tempStatus = null;
            for (Object item : items) {
                tempStatus = validateItem(item);
                if (tempStatus.isOK()) {
                    status = new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, EMPTY_STRING, null);
                } else {
                    status = tempStatus;
                    // if any selected element is not valid status is set to
                    // ERROR
                    break;
                }
            }
            notifySelectionListeners(items.toArray());
            if (lastSelection != null) {
                _ecoreTypeTreeViewer.update(lastSelection, null);
            }
        }
        refreshDetails();
        updateStatus(status);
    }

    /*
     * @see org.eclipse.ui.dialogs.SelectionStatusDialog#updateStatus(org.eclipse.core.runtime.IStatus)
     */
    @Override
    protected void updateStatus(IStatus status) {
        _status = status;
        super.updateStatus(status);
    }

    /*
     * @see Dialog#okPressed()
     */
    @Override
    protected void okPressed() {
        if (_status != null && (_status.isOK() || _status.getCode() == IStatus.INFO)) {
            super.okPressed();
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
     * This method is a hook for subclasses to override default dialog behavior.
     * The <code>handleDoubleClick()</code> method handles double clicks on
     * the list of filtered elements.
     * <p>
     * Current implementation makes double-clicking on the list do the same as
     * pressing <code>OK</code> button on the dialog.
     */
    protected void handleDoubleClick() {
        okPressed();
    }

    protected IStatus validateItem(Object item) {
        return new Status(IStatus.OK, EGFCoreUIPlugin.getDefault().getPluginID(), 0, "", null); //$NON-NLS-1$
    }

    /**
     * Returns the current selection.
     * 
     * @return the current selection
     */
    protected StructuredSelection getSelectedItems() {
        return new StructuredSelection(((StructuredSelection) _ecoreTypeTreeViewer.getSelection()).toList());
    }

    /**
     * Refreshes the details field according to the current selection in the
     * items list.
     */
    private void refreshDetails() {
        StructuredSelection selection = getSelectedItems();
        switch (selection.size()) {
            case 0:
                _details.setInput(null);
                break;
            case 1:
                _details.setInput(selection.getFirstElement());
                break;
            default:
                _details.setInput(NLS.bind(CoreUIMessages.EcoreSelectionDialog_nItemsSelected, new Integer(selection.size())));
                break;
        }
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

    public boolean addSelectionListeners(ISelectionDialogListener listener) {
        if (listener == null) {
            return false;
        }
        return _selectionListeners.add(listener);
    }

    public boolean removeSelectionListeners(ISelectionDialogListener listener) {
        if (listener == null) {
            return false;
        }
        return _selectionListeners.remove(listener);
    }

    public void notifySelectionListeners(Object[] selected) {
        for (ISelectionDialogListener listener : _selectionListeners) {
            listener.handleSelected(selected);
        }
    }

}
