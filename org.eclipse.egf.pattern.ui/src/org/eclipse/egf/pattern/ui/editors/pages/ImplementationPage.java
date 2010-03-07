/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.adapter.LiveValidationContentAdapter;
import org.eclipse.egf.pattern.ui.editors.dialogs.MethodAddOrEditDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.VariablesEditDialog;
import org.eclipse.egf.pattern.ui.editors.editor.MethodsComboBoxViewerCellEditor;
import org.eclipse.egf.pattern.ui.editors.modifiers.MethodTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.modifiers.VariablesTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.MethodLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.MethodsTableObservableListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.OrchestrationTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TableObservableListContentProvider;
import org.eclipse.egf.pattern.ui.editors.templateEditor.AbstractTemplateEditor;
import org.eclipse.egf.pattern.ui.editors.templateEditor.TemplateExtensionRegistry;
import org.eclipse.egf.pattern.ui.editors.validation.ValidationConstants;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.egf.pattern.ui.editors.wizards.OrchestrationWizard;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.CallTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.ide.IDE;

/**
 * @author Thomas Guiu
 * 
 */
@SuppressWarnings("restriction")
public class ImplementationPage extends PatternEditorPage {
    public static final String ID = "ImplementationPage"; //$NON-NLS-1$

    private TableViewer methodsTableViewer;

    private TableViewer variablesTableViewer;

    private TableViewer orchestrationTableViewer;

    public static final String NAME_COLUMN_ID = "Name"; //$NON-NLS-1$

    public static final String TYPE_COLUMN_ID = "Type"; //$NON-NLS-1$

    private Button methodsAdd;

    private Button methodsEdit;

    private Button methodsRemove;

    private Button methodsUp;

    private Button methodsDown;

    private Button methodsOpenTemplate;

    private Button orchestrationAdd;

    private Button orchestrationEdit;

    private Button orchestrationRemove;

    private Button orchestrationUp;

    private Button orchestrationDown;

    private Button variablesAdd;

    private Button variablesEdit;

    private Button variablesRemove;

    private MethodsComboBoxViewerCellEditor nameEditor;

    private PatternMethod dropEntry;

    private int methodsDragIndex = -1;

    private int orchestrationDragIndex = -1;

    private boolean isChangMethodsOrder;

    private boolean isChangOrchestrationeOrder;

    private boolean isReadOnly;

    private static final String VARIABLE_NAME_DEFAULT_VALUE = "variable"; //$NON-NLS-1$

    private static final String VARIABLE_TYPE_DEFAULT_VALUE = "http://www.eclipse.org/emf/2002/Ecore#//EClass"; //$NON-NLS-1$

    private LiveValidationContentAdapter variableNameEmpetyValidationAdapter;

    private IMessageManager mmng;

    public ImplementationPage(FormEditor editor) {
        super(editor, ID, Messages.ImplementationPage_title);
    }

    @Override
    protected void doCreateFormContent(IManagedForm managedForm) {
        PatternEditorInput editorInput = (PatternEditorInput) getEditorInput();
        isReadOnly = editorInput.isReadOnly();
        mmng = managedForm.getMessageManager();

        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();

        toolkit.decorateFormHeading(form.getForm());

        GridLayout layout = new GridLayout(2, true);
        form.getBody().setLayout(layout);
        form.setImage(ImageShop.get(ImageShop.IMG_PLUGIN_MF_OBJ));
        form.setText(Messages.ImplementationPage_title);

        Composite containerLeft = createComposite(toolkit, form);
        createMethodsSection(toolkit, containerLeft);
        createVariablesSection(toolkit, containerLeft);

        Composite containerRight = createComposite(toolkit, form);
        createOrchestrationSection(toolkit, containerRight);

        checkReadOnlyModel();

        form.reflow(true);
    }

    /**
     * Check whether the editor is on a read only pattern.
     */
    private void checkReadOnlyModel() {
        if (!isReadOnly) {
            return;
        }
        methodsAdd.setEnabled(false);
        methodsEdit.setEnabled(false);
        methodsRemove.setEnabled(false);
        methodsOpenTemplate.setEnabled(false);

        orchestrationAdd.setEnabled(false);
        orchestrationEdit.setEnabled(false);
        orchestrationUp.setEnabled(false);
        orchestrationDown.setEnabled(false);

        variablesAdd.setEnabled(false);
        variablesEdit.setEnabled(false);
        variablesRemove.setEnabled(false);
    }

    private Composite createComposite(FormToolkit toolkit, ScrolledForm form) {
        Composite composite = toolkit.createComposite(form.getBody(), SWT.NONE);
        GridLayout layout = new GridLayout(1, true);
        composite.setLayout(layout);
        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        composite.setLayoutData(gd);
        return composite;
    }

    private void createMethodsSection(FormToolkit toolkit, Composite composite) {

        Section methSection = toolkit.createSection(composite, Section.TITLE_BAR);
        methSection.setText(Messages.ImplementationPage_Methods);

        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        methSection.setLayoutData(gd);

        Composite methods = createMethodComposite(toolkit, methSection);

        createLabel(toolkit, methods, Messages.ImplementationPage_Methods_2, 1);
        createLabel(toolkit, methods, Messages.ImplementationPage_Methods_3, 2);

        createPatternMethodsArea(toolkit, methods);
        createImplementationMethodsTable(toolkit, methods);
        createImplementationMethodsButtons(toolkit, methods);

        methSection.setClient(methods);
    }

    private Composite createMethodComposite(FormToolkit toolkit, Section section) {
        Composite container = toolkit.createComposite(section, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        container.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        container.setLayoutData(gd);
        return container;
    }

    private void createPatternMethodsArea(FormToolkit toolkit, Composite methods) {
        Composite patternMethodsArea = toolkit.createComposite(methods, SWT.NONE);
        GridLayout layout = new GridLayout();
        patternMethodsArea.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 20;
        patternMethodsArea.setLayoutData(gd);

        createPatternMethodsLink(toolkit, patternMethodsArea);
    }

    private void createPatternMethodsLink(FormToolkit toolkit, Composite container) {
        ImageHyperlink headerLink = createPatternMethodLink(toolkit, container, org.eclipse.egf.pattern.extension.PatternFactory.HEADER_METHOD_NAME);
        headerLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
            }

            public void linkEntered(HyperlinkEvent e) {
            }

            public void linkActivated(HyperlinkEvent e) {
                PatternMethod headerMethod = getPattern().getHeaderMethod();
                String headerMethodId = headerMethod.getID();
                openMethodTemplate(headerMethodId);
            }
        });

        ImageHyperlink initLink = createPatternMethodLink(toolkit, container, org.eclipse.egf.pattern.extension.PatternFactory.INIT_METHOD_NAME);
        initLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
            }

            public void linkEntered(HyperlinkEvent e) {
            }

            public void linkActivated(HyperlinkEvent e) {
                PatternMethod initMethod = getPattern().getInitMethod();
                String initMethodId = initMethod.getID();
                openMethodTemplate(initMethodId);
            }
        });

        ImageHyperlink preConditionLink = createPatternMethodLink(toolkit, container, org.eclipse.egf.pattern.extension.PatternFactory.PRECONDITION_METHOD_NAME);
        preConditionLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
            }

            public void linkEntered(HyperlinkEvent e) {
            }

            public void linkActivated(HyperlinkEvent e) {
                // TODO
            }
        });

        ImageHyperlink footerLink = createPatternMethodLink(toolkit, container, org.eclipse.egf.pattern.extension.PatternFactory.FOOTER_METHOD_NAME);
        footerLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
            }

            public void linkEntered(HyperlinkEvent e) {
            }

            public void linkActivated(HyperlinkEvent e) {
                PatternMethod footerMethod = getPattern().getFooterMethod();
                String footerMethodId = footerMethod.getID();
                openMethodTemplate(footerMethodId);
            }
        });

    }

    private ImageHyperlink createPatternMethodLink(FormToolkit toolkit, Composite methods, String label) {
        ImageHyperlink patternMethodLink = toolkit.createImageHyperlink(methods, SWT.NULL);
        patternMethodLink.setText(label);
        patternMethodLink.setImage(ImageShop.get(ImageShop.IMG_METHOD));
        GridData gd = new GridData();
        gd.verticalIndent = 0;
        patternMethodLink.setLayoutData(gd);
        return patternMethodLink;
    }

    private void createLabel(FormToolkit toolkit, Composite container, String label, int horizontalSpan) {
        Label discrip = toolkit.createLabel(container, label, SWT.WRAP);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalSpan = horizontalSpan;
        gd.horizontalIndent = 4;
        discrip.setLayoutData(gd);
    }

    private void createImplementationMethodsTable(FormToolkit toolkit, Composite methods) {
        Composite tableComp = new Composite(methods, SWT.NONE);
        TableColumnLayout layout = new TableColumnLayout();
        tableComp.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        tableComp.setLayoutData(gd);

        Table table = toolkit.createTable(tableComp, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);

        methodsTableViewer = new TableViewer(table);
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        layout.setColumnData(tableColumn, new ColumnWeightData(200, true));

        methodsTableViewer.setContentProvider(new MethodsTableObservableListContentProvider(methodsTableViewer, 3));
        initMethodsTableEditor();

        methodsTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (isReadOnly)
                    return;
                openPatternTemplate();
            }
        });
        methodsTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                if (isReadOnly)
                    return;
                setMethodsButtonsStatus();
                CCombo control = (CCombo) nameEditor.getControl();
                if (control != null && !control.isDisposed()) {
                    PatternMethod selectItem = getmethodsSelectItem();
                    control.setText(selectItem == null ? "" : selectItem.getName()); //$NON-NLS-1$
                }
            }
        });

        addDragDropForMethodsTable();
    }

    /**
     * Add drag and drop listener to methodsTableViewer.
     */
    private void addDragDropForMethodsTable() {
        if (isReadOnly)
            return;

        methodsTableViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new DragSourceListener() {

            public void dragStart(DragSourceEvent event) {
                isChangOrchestrationeOrder = false;
                isChangMethodsOrder = true;
                if (methodsTableViewer.getSelection() == null) {
                    event.doit = false;
                }
            }

            public void dragSetData(DragSourceEvent event) {
                if (methodsTableViewer.getSelection() != null) {
                    dropEntry = getmethodsSelectItem();
                    methodsDragIndex = methodsTableViewer.getTable().getSelectionIndex();
                }
            }

            public void dragFinished(DragSourceEvent event) {
            }
        });

        methodsTableViewer.addDropSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new ViewerDropAdapter(methodsTableViewer) {

            public boolean validateDrop(Object target, int operation, TransferData transferType) {
                if (isChangMethodsOrder) {
                    return true;
                }
                return false;
            }

            public boolean performDrop(Object data) {
                Object currentTarget = getCurrentTarget();
                EList<PatternMethod> methods = getPattern().getMethods();
                executeChangeOrder(currentTarget, methodsTableViewer, methods, methodsDragIndex);
                setMethodsButtonsStatus();
                return false;
            }
        });
    }

    private void initMethodsTableEditor() {
        if (isReadOnly)
            return;
        methodsTableViewer.setColumnProperties(new String[] { NAME_COLUMN_ID });
        nameEditor = new MethodsComboBoxViewerCellEditor(methodsTableViewer.getTable(), getEditingDomain(), methodsTableViewer, this);
        nameEditor.setLabelProvider(new LabelProvider());
        nameEditor.setContenProvider(new CommonListContentProvider());

        methodsTableViewer.setCellEditors(new CellEditor[] { nameEditor });
        methodsTableViewer.setCellModifier(new MethodTableCellModifier(getEditingDomain(), methodsTableViewer));
    }

    /**
     * Create the Methods section's buttons.
     */
    private void createImplementationMethodsButtons(FormToolkit toolkit, final Composite methods) {
        Composite buttons = toolkit.createComposite(methods, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;
        methodsAdd = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        methodsAdd.setLayoutData(gd);
        methodsAdd.setImage(ImageShop.get(ImageShop.IMG_ADD_OBJ));
        methodsAdd.setToolTipText(Messages.ImplementationPage_button_add);
        methodsAdd.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                Pattern parent = getPatternParent();
                MethodAddOrEditDialog dialog = new MethodAddOrEditDialog(new Shell(), PatternUIHelper.getUseablePatternMethodsNameList(parent), ""); //$NON-NLS-1$
                dialog.setTitle(Messages.ImplementationPage_methAdd_dialog_title);
                if (dialog.open() == Window.OK) {
                    executeMethodsAdd(dialog.getName());
                    setMethodsButtonsStatus();
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });

        methodsEdit = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        methodsEdit.setLayoutData(gd);
        methodsEdit.setEnabled(false);
        methodsEdit.setImage(ImageShop.get(ImageShop.IMG_EDIT_OBJ));
        methodsEdit.setToolTipText(Messages.ImplementationPage_button_edit);
        methodsEdit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                int index = methodsTableViewer.getTable().getSelectionIndex();
                String selectName = ""; //$NON-NLS-1$
                if (index >= 0) {
                    Object entry = methodsTableViewer.getElementAt(index);
                    if (entry instanceof PatternMethod) {
                        selectName = ((PatternMethod) entry).getName();
                    }
                }
                Pattern parent = getPatternParent();
                MethodAddOrEditDialog dialog = new MethodAddOrEditDialog(new Shell(), PatternUIHelper.getUseablePatternMethodsNameList(parent), selectName);
                dialog.setTitle(Messages.ImplementationPage_methEdit_dialog_title);
                if (dialog.open() == Window.OK) {
                    executeMethodsEdit(dialog.getName());
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });

        methodsOpenTemplate = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        methodsOpenTemplate.setLayoutData(gd);
        methodsOpenTemplate.setEnabled(false);
        methodsOpenTemplate.setImage(ImageShop.get(ImageShop.IMG_METHOD_CONTENT_EDIT));
        methodsOpenTemplate.setToolTipText(Messages.ImplementationPage_button_methodsOpenTemplate);
        methodsOpenTemplate.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                openPatternTemplate();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        methodsRemove = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        methodsRemove.setLayoutData(gd);
        methodsRemove.setEnabled(false);
        methodsRemove.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        methodsRemove.setToolTipText(Messages.ImplementationPage_button_remove);
        methodsRemove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeMethodsRemove(methods);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        methodsUp = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        methodsUp.setLayoutData(gd);
        methodsUp.setEnabled(false);
        methodsUp.setImage(ImageShop.get(ImageShop.IMG_UPWARD_OBJ));
        methodsUp.setToolTipText(Messages.ImplementationPage_button_up);
        methodsUp.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeMethodsUpOrDown(-1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        methodsDown = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        methodsDown.setLayoutData(gd);
        methodsDown.setEnabled(false);
        methodsDown.setImage(ImageShop.get(ImageShop.IMG_DOWNWARD_OBJ));
        methodsDown.setToolTipText(Messages.ImplementationPage_button_down);
        methodsDown.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeMethodsUpOrDown(1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

    }

    /**
     * Execute methods table up or down operation.
     */
    protected void executeMethodsUpOrDown(int num) {
        final EList<PatternMethod> methods = getPattern().getMethods();

        int oldIndex = methodsTableViewer.getTable().getSelectionIndex();
        final int fromIndex = getIndexOfPatternMethodsMappingTable(oldIndex, methods);

        int newIndex = oldIndex + num;
        final int toIndex = getIndexOfPatternMethodsMappingTable(newIndex, methods);

        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                methods.move(toIndex, fromIndex);
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        methodsTableViewer.refresh();
        methodsTableViewer.getTable().setSelection(newIndex);
        setMethodsButtonsStatus();
    }

    /**
     * Cet the method's index in pattern mapping methodsTable.
     */
    private int getIndexOfPatternMethodsMappingTable(int indexOfTable, EList<PatternMethod> patternMethods) {
        PatternMethod item = getTableItem(indexOfTable);
        int index = patternMethods.indexOf(item);
        if (index == -1) {
            System.out.println();
        }
        return index;
    }

    /**
     * Get the method of index in table.
     */
    private PatternMethod getTableItem(int index) {
        Object selectItem = methodsTableViewer.getElementAt(index);
        if (selectItem instanceof PatternMethod) {
            return (PatternMethod) selectItem;
        }
        return null;
    }

    /**
     * Set the Methods section's button status.
     */
    private void setMethodsButtonsStatus() {
        int selectIndex = methodsTableViewer.getTable().getSelectionIndex();
        int length = methodsTableViewer.getTable().getItemCount();
        if (selectIndex == -1) {
            methodsRemove.setEnabled(false);
            methodsEdit.setEnabled(false);
            methodsUp.setEnabled(false);
            methodsDown.setEnabled(false);
            methodsOpenTemplate.setEnabled(false);
            return;
        } else {
            PatternMethod selectMethod = (PatternMethod) (methodsTableViewer.getElementAt(selectIndex));
            if (PatternUIHelper.isRenameDisable(selectMethod)) {
                methodsEdit.setEnabled(false);
                methodsRemove.setEnabled(false);
            } else {
                methodsEdit.setEnabled(true);
                methodsRemove.setEnabled(true);
            }

            if (selectIndex <= 0) {
                methodsUp.setEnabled(false);
            } else {
                methodsUp.setEnabled(true);
            }
            if ((selectIndex + 1) == length) {
                methodsDown.setEnabled(false);
            } else {
                methodsDown.setEnabled(true);
            }
            methodsOpenTemplate.setEnabled(true);
        }
    }

    private void executeMethodsRemove(Composite methods) {
        int index = methodsTableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            final Object selectItem = methodsTableViewer.getElementAt(index);
            if (selectItem instanceof PatternMethod) {
                if (isMethodDeleteDisable((PatternMethod) selectItem)) {
                    String message = Messages.ImplementationPage_method_cannot_delete_message;
                    showErrorMessage(methods, message);
                    return;
                }
                final Pattern pattern = getPattern();
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {
                    protected void doExecute() {
                        pattern.getMethods().remove(selectItem);
                    }
                };
                editingDomain.getCommandStack().execute(cmd);
                EList<PatternMethod> allMethods = pattern.getMethods();
                setDefaultSelection(allMethods.size() - 3, methodsTableViewer, index);
            }
        }
        setMethodsButtonsStatus();
    }

    private void executeMethodsAdd(final String name) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                PatternMethod newMethod = PatternFactory.eINSTANCE.createPatternMethod();
                newMethod.setName(name);
                newMethod.setPattern(getPattern());
                getPattern().getMethods().add(newMethod);
                newMethod.setPatternFilePath(PatternHelper.Filename.computeFileURI(newMethod));
                PatternUIHelper.addAdapterForNewItem(methodsTableViewer, newMethod);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
        methodsTableViewer.refresh();
        methodsTableViewer.getTable().setSelection((methodsTableViewer.getTable().getItemCount()) - 1);
    }

    protected void executeMethodsEdit(final String name) {
        int index = methodsTableViewer.getTable().getSelectionIndex();
        final PatternMethod editPatternMethod = (PatternMethod) (methodsTableViewer.getElementAt(index));
        // Execute edit.
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                editPatternMethod.setName(name);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    /**
     * tO open a pattern template editor.
     */
    private void openPatternTemplate() {
        ISelection selection = methodsTableViewer.getSelection();
        String methodId = null;
        if (selection != null && !selection.isEmpty()) {
            PatternMethod method = (PatternMethod) ((IStructuredSelection) selection).getFirstElement();
            methodId = method.getID();
        }
        openMethodTemplate(methodId);
    }

    private void openMethodTemplate(String methodId) {
        Pattern pattern = getPattern();
        String editor = TemplateExtensionRegistry.getEditor(pattern);
        if (editor != null) {
            IWorkbench workbench = PlatformUI.getWorkbench();
            IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
            IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
            IEditorPart[] editorParts = activePage.getEditors();
            if (editorParts.length > 1) {
                for (int i = editorParts.length - 1; i >= 0; i--) {
                    if (editorParts[i] instanceof AbstractTemplateEditor) {
                        Pattern templateEdtiorPattern = ((AbstractTemplateEditor) editorParts[i]).getPattern();
                        if ((getPattern()).equals(templateEdtiorPattern)) {
                            // Switch to the already opened editor.
                            activePage.activate(editorParts[i]);
                            ((AbstractTemplateEditor) editorParts[i]).setActivePage(methodId);
                            return;
                        }
                    }
                }
            }
            // Open a new template editor.
            try {
                PatternEditorInput input = new PatternEditorInput(pattern.eResource(), pattern.getID());
                AbstractTemplateEditor editorPart = (AbstractTemplateEditor) IDE.openEditor(getEditorSite().getPage(), input, editor);
                editorPart.setActivePage(methodId);
            } catch (PartInitException e) {
                Activator.getDefault().logError(e);
            }

        }
    }

    private void createOrchestrationSection(FormToolkit toolkit, Composite composite) {
        Section orchSection = toolkit.createSection(composite, Section.TITLE_BAR);
        orchSection.setText(Messages.ImplementationPage_orchSection_title);

        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        orchSection.setLayoutData(gd);

        String label = Messages.ImplementationPage_orchSection_label;
        Composite orchestration = createComposite(toolkit, orchSection, label);

        createOrchestrationTable(toolkit, orchestration);
        createOrchestrationButtons(toolkit, orchestration);

        orchSection.setClient(orchestration);
    }

    private void createOrchestrationTable(FormToolkit toolkit, Composite orchestration) {
        Composite tableComp = new Composite(orchestration, SWT.NONE);
        TableColumnLayout layout = new TableColumnLayout();
        tableComp.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        tableComp.setLayoutData(gd);

        Table table = toolkit.createTable(tableComp, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);

        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);
        orchestrationTableViewer = new TableViewer(table);
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        layout.setColumnData(tableColumn, new ColumnWeightData(230, true));

        orchestrationTableViewer.setContentProvider(new TableObservableListContentProvider(orchestrationTableViewer));
        orchestrationTableViewer.setLabelProvider(new OrchestrationTableLabelProvider());

        orchestrationTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                if (isReadOnly)
                    return;
                setOrchestrationButtonsStatus();
            }
        });
        orchestrationTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (isReadOnly)
                    return;
                openOrchestrationWizard();
            }
        });
        addDragDropForOrchestrationTable();
    }

    /**
     * Add drag and drop listener to orchTableViewer.
     */
    private void addDragDropForOrchestrationTable() {
        if (isReadOnly)
            return;
        orchestrationTableViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new DragSourceListener() {

            public void dragStart(DragSourceEvent event) {
                isChangOrchestrationeOrder = true;
                isChangMethodsOrder = false;
                if (orchestrationTableViewer.getSelection() == null) {
                    event.doit = false;
                }
            }

            public void dragSetData(DragSourceEvent event) {
                if (orchestrationTableViewer.getSelection() != null) {
                    orchestrationDragIndex = orchestrationTableViewer.getTable().getSelectionIndex();
                }
            }

            public void dragFinished(DragSourceEvent event) {
            }
        });

        orchestrationTableViewer.addDropSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new ViewerDropAdapter(orchestrationTableViewer) {

            public boolean validateDrop(Object target, int operation, TransferData transferType) {
                if (!isChangOrchestrationeOrder) {
                    return checkDropSupport();
                }
                return true;
            }

            public boolean performDrop(Object data) {
                if (isChangOrchestrationeOrder) {
                    Object currentTarget = getCurrentTarget();
                    EList<Call> orchestration = getPattern().getOrchestration();
                    executeChangeOrder(currentTarget, orchestrationTableViewer, orchestration, orchestrationDragIndex);
                    setOrchestrationButtonsStatus();
                } else {
                    executeDrop();
                }
                return false;
            }
        });
    }

    /**
     * Execute the drag and drop operation to change the order of the table
     * rows.
     */
    protected void executeChangeOrder(Object currentTarget, TableViewer tableViewer, EList<?> list, int sourceIndex) {
        int targetIndex = 0;
        if (currentTarget == null) {
            targetIndex = tableViewer.getTable().getItemCount() - 1;
        } else {
            TableItem[] items = tableViewer.getTable().getItems();
            for (TableItem item : items) {
                if (currentTarget.equals(item.getData())) {
                    targetIndex = tableViewer.getTable().indexOf(item);
                    break;
                }
            }
        }
        Object item = list.get(0);
        if (item != null && item instanceof PatternMethod) {
            int fromIndex = getIndexOfPatternMethodsMappingTable(sourceIndex, (EList<PatternMethod>) list);
            int toIndex = getIndexOfPatternMethodsMappingTable(targetIndex, (EList<PatternMethod>) list);
            refreshTableContent(list, toIndex, fromIndex);
        } else {
            refreshTableContent(list, targetIndex, sourceIndex);
        }
        tableViewer.refresh();
        tableViewer.getTable().setSelection(targetIndex);
    }

    /**
     * Refresh the table content after change the tables order.
     */
    private void refreshTableContent(final EList<?> list, final int targetIndex, final int sourceIndex) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                list.move(targetIndex, sourceIndex);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    /**
     * While drag the method from methTableViewer to orchTableViewer,check
     * whether the method is header/init/footer methods.
     */
    protected boolean checkDropSupport() {
        int index = methodsTableViewer.getTable().getSelectionIndex();
        PatternMethod drag = (PatternMethod) methodsTableViewer.getElementAt(index);
        String name = drag.getName();
        if (Messages.ImplementationPage_header.equals(name) || Messages.ImplementationPage_init.equals(name) || Messages.ImplementationPage_footer.equals(name)) {
            return false;
        }
        return true;
    }

    /**
     * Drag a method from the methods section and drop it to the orechestration
     * section.
     */
    protected void executeDrop() {
        if (dropEntry != null) {
            TransactionalEditingDomain editingDomain = getEditingDomain();
            RecordingCommand cmd = new RecordingCommand(editingDomain) {
                protected void doExecute() {
                    MethodCall methodCallNew = PatternFactory.eINSTANCE.createMethodCall();
                    methodCallNew.setCalled(dropEntry);
                    methodCallNew.setPattern(getPattern());
                    getPattern().getOrchestration().add(methodCallNew);
                    PatternUIHelper.addAdapterForNewItem(orchestrationTableViewer, methodCallNew);
                }
            };
            editingDomain.getCommandStack().execute(cmd);
            setOrchestrationButtonsStatus();
        }
    }

    /**
     * Create the Orchestration section's buttons.
     */
    private void createOrchestrationButtons(FormToolkit toolkit, Composite orchestration) {
        Composite buttons = toolkit.createComposite(orchestration, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;

        orchestrationAdd = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        orchestrationAdd.setLayoutData(gd);
        orchestrationAdd.setImage(ImageShop.get(ImageShop.IMG_ADD_OBJ));
        orchestrationAdd.setToolTipText(Messages.ImplementationPage_button_add);
        orchestrationAdd.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                OrchestrationWizard wizard = new OrchestrationWizard(getPattern(), CallTypeEnum.Add, null, getEditingDomain());
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                int returnValue = dialog.open();
                if (Window.OK == returnValue) {
                    exectuteOrchestrationAdd(wizard);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationEdit = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        orchestrationEdit.setLayoutData(gd);
        orchestrationEdit.setEnabled(false);
        orchestrationEdit.setImage(ImageShop.get(ImageShop.IMG_EDIT_OBJ));
        orchestrationEdit.setToolTipText(Messages.ImplementationPage_button_edit);
        orchestrationEdit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                openOrchestrationWizard();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationRemove = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        orchestrationRemove.setLayoutData(gd);
        orchestrationRemove.setEnabled(false);
        orchestrationRemove.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        orchestrationRemove.setToolTipText(Messages.ImplementationPage_button_remove);
        orchestrationRemove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                exectueOrchestrationRemove();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationUp = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        orchestrationUp.setLayoutData(gd);
        orchestrationUp.setEnabled(false);
        orchestrationUp.setImage(ImageShop.get(ImageShop.IMG_UPWARD_OBJ));
        orchestrationUp.setToolTipText(Messages.ImplementationPage_button_up);
        orchestrationUp.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeOrchestrationUpOrDown(-1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationDown = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        orchestrationDown.setLayoutData(gd);
        orchestrationDown.setEnabled(false);
        orchestrationDown.setImage(ImageShop.get(ImageShop.IMG_DOWNWARD_OBJ));
        orchestrationDown.setToolTipText(Messages.ImplementationPage_button_down);
        orchestrationDown.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeOrchestrationUpOrDown(1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    /**
     * To open the Orchestration wizard.
     */
    private void openOrchestrationWizard() {
        int index = orchestrationTableViewer.getTable().getSelectionIndex();
        Object selectItem = orchestrationTableViewer.getElementAt(index);

        CallTypeEnum kind = CallTypeEnum.Add;
        if (selectItem instanceof MethodCall) {
            kind = CallTypeEnum.METHOD_CALL;
        } else if (selectItem instanceof PatternCall) {
            kind = CallTypeEnum.PATTERN_CALL;
        } else if (selectItem instanceof PatternInjectedCall) {
            kind = CallTypeEnum.PATTERNINJECTED_CALL;
        } else if (selectItem instanceof SuperCall) {
            kind = CallTypeEnum.SUPERPATTERN_CALL;
            // Prevent the wizard from pops up from BackCall objects.
            return;
        }
        OrchestrationWizard wizard = new OrchestrationWizard(getPattern(), kind, selectItem, getEditingDomain());
        wizard.init(PlatformUI.getWorkbench(), null);
        WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
        int returnValue = dialog.open();
        if (Window.OK == returnValue) {
            final Call selectCall = wizard.getSelectCall();
            exectuteOrchestrationEdit(selectCall, selectItem);
        }
    }

    protected void exectuteOrchestrationAdd(OrchestrationWizard wizard) {
        List selectCallList = new ArrayList();
        if (wizard.getDefaultKind() == CallTypeEnum.Add && wizard.getSelectCall() instanceof MethodCall) {
            selectCallList = wizard.getSelectMethodCallList();
        } else {
            Call selectCall = wizard.getSelectCall();
            selectCallList.add(selectCall);
        }

        for (Object selectCall : selectCallList) {
            exectuteOrchestrationAddCall((Call) selectCall);
        }

        int len = getPattern().getOrchestration().size();
        orchestrationTableViewer.getTable().setSelection(len - 1);
        setOrchestrationButtonsStatus();
    }

    private void exectuteOrchestrationAddCall(final Call selectCall) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                selectCall.setPattern(getPattern());
                getPattern().getOrchestration().add(selectCall);
                PatternUIHelper.addAdapterForNewItem(orchestrationTableViewer, selectCall);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    protected void exectuteOrchestrationEdit(final Call selectCall, final Object selectItem) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                if (selectItem instanceof Call) {
                    int modifyIndex = getPattern().getOrchestration().indexOf(selectItem);
                    if (modifyIndex >= 0) {
                        getPattern().getOrchestration().set(modifyIndex, selectCall);
                        orchestrationTableViewer.getTable().setSelection(modifyIndex);
                    }
                    setOrchestrationButtonsStatus();
                }
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    protected void executeOrchestrationUpOrDown(int num) {
        final int oldIndex = orchestrationTableViewer.getTable().getSelectionIndex();
        final int newIndex = oldIndex + num;
        final EList<Call> orchestration = getPattern().getOrchestration();

        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                orchestration.move(newIndex, oldIndex);
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        orchestrationTableViewer.getTable().setSelection(newIndex);
        setOrchestrationButtonsStatus();
    }

    protected void exectueOrchestrationRemove() {
        int index = orchestrationTableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            final Object selectItem = orchestrationTableViewer.getElementAt(index);
            TransactionalEditingDomain editingDomain = getEditingDomain();
            RecordingCommand cmd = new RecordingCommand(editingDomain) {
                protected void doExecute() {
                    if (selectItem instanceof Call) {
                        getPattern().getOrchestration().remove(selectItem);
                    }
                }
            };
            editingDomain.getCommandStack().execute(cmd);
            EList<Call> orchestration = getPattern().getOrchestration();
            setDefaultSelection(orchestration.size(), orchestrationTableViewer, index);
        }
        setOrchestrationButtonsStatus();
    }

    private void setOrchestrationButtonsStatus() {
        int selectIndex = orchestrationTableViewer.getTable().getSelectionIndex();
        if (selectIndex == -1) {
            orchestrationRemove.setEnabled(false);
            orchestrationEdit.setEnabled(false);
            orchestrationUp.setEnabled(false);
            orchestrationDown.setEnabled(false);
            return;
        }

        int length = orchestrationTableViewer.getTable().getItemCount();
        if (length > 0) {
            orchestrationRemove.setEnabled(true);
            orchestrationEdit.setEnabled(true);
        } else {
            orchestrationRemove.setEnabled(false);
            orchestrationEdit.setEnabled(false);
        }
        if (selectIndex <= 0) {
            orchestrationUp.setEnabled(false);
        } else {
            orchestrationUp.setEnabled(true);
        }
        if ((selectIndex + 1) == length) {
            orchestrationDown.setEnabled(false);
        } else {
            orchestrationDown.setEnabled(true);
        }

        // Prevent the wizard from pops up from BackCall objects.
        Object selectItem = orchestrationTableViewer.getElementAt(selectIndex);
        if (selectItem instanceof BackCall) {
            orchestrationEdit.setEnabled(false);
        }
    }

    private void createVariablesSection(FormToolkit toolkit, Composite composite) {
        Section varSection = toolkit.createSection(composite, Section.TITLE_BAR);
        varSection.setText(Messages.ImplementationPage_varSection_title);
        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        varSection.setLayoutData(gd);

        String label = Messages.ImplementationPage_varSection_label;
        Composite variables = createComposite(toolkit, varSection, label);

        createVariablesTable(toolkit, variables);
        createVariablesButtons(toolkit, variables);

        varSection.setClient(variables);
    }

    private void createVariablesTable(FormToolkit toolkit, Composite variables) {
        Composite tableComp = new Composite(variables, SWT.NONE);
        TableColumnLayout layout = new TableColumnLayout();
        tableComp.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        tableComp.setLayoutData(gd);

        Table table = toolkit.createTable(tableComp, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);

        variablesTableViewer = new TableViewer(table);
        String[] colNames = { Messages.ImplementationPage_column_title_name, Messages.ImplementationPage_column_title_type };
        int[] colWidths = { 130, 135 };
        for (int i = 0; i < colNames.length; i++) {
            TableColumn tableColumn = new TableColumn(table, SWT.NONE);
            tableColumn.setWidth(colWidths[i]);
            tableColumn.setText(colNames[i]);
            layout.setColumnData(tableColumn, new ColumnWeightData(colWidths[i], true));
        }
        initVariablesTableEditor();

        variablesTableViewer.setContentProvider(new TableObservableListContentProvider(variablesTableViewer));//
        variablesTableViewer.setLabelProvider(new ParametersTableLabelProvider());
    }

    private void initVariablesTableEditor() {
        if (isReadOnly)
            return;
        variablesTableViewer.setColumnProperties(new String[] { NAME_COLUMN_ID, TYPE_COLUMN_ID });
        final TextCellEditor nameEditor = new TextCellEditor(variablesTableViewer.getTable());
        final DialogCellEditor typeEditor = new DialogCellEditor(variablesTableViewer.getTable()) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                OpenTypeWizard wizard = new OpenTypeWizard(getEditingDomain(), getSelectItemType());
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                int returnValue = dialog.open();
                if (Window.OK == returnValue) {
                    if (wizard.getSelectType() instanceof String) {
                        final String selectType = (String) wizard.getSelectType();
                        updateType(selectType);
                    } else if (wizard.getSelectType() instanceof BinaryType) {
                        final String selectType = ((BinaryType) wizard.getSelectType()).getFullyQualifiedName();
                        updateType(selectType);
                    }

                }
                return null;
            }
        };
        variablesTableViewer.setCellEditors(new CellEditor[] { nameEditor, typeEditor });
        variablesTableViewer.setCellModifier(new VariablesTableCellModifier(getEditingDomain(), variablesTableViewer));

        variablesTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                setVariablesButtonsStatus();
            }
        });
    }

    protected void updateType(final String selectType) {
        if (selectType != null && !"".equals(selectType)) { //$NON-NLS-1$
            ISelection selection = variablesTableViewer.getSelection();
            final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
            if (selectItem instanceof PatternVariable) {
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {
                    protected void doExecute() {
                        ((PatternVariable) selectItem).setType(selectType);
                    }
                };
                editingDomain.getCommandStack().execute(cmd);
                variablesTableViewer.refresh();
            }
        }
    }

    /**
     * Get the type of selected pattern parameter.
     */
    protected String getSelectItemType() {
        int selectionIndex = variablesTableViewer.getTable().getSelectionIndex();
        Object selectItem = variablesTableViewer.getElementAt(selectionIndex);
        if (selectItem instanceof PatternVariable) {
            return ((PatternVariable) selectItem).getType();
        }
        return ""; //$NON-NLS-1$
    }

    /**
     * Get the methodsTableViewer's selected item.
     */
    protected PatternMethod getmethodsSelectItem() {
        int selectionIndex = methodsTableViewer.getTable().getSelectionIndex();
        Object selectItem = methodsTableViewer.getElementAt(selectionIndex);
        if (selectItem instanceof PatternMethod) {
            return (PatternMethod) selectItem;
        }
        return null; //$NON-NLS-1$
    }

    /**
     * Create the Variables section's buttons.
     */
    private void createVariablesButtons(FormToolkit toolkit, final Composite variables) {
        Composite buttons = toolkit.createComposite(variables, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;

        variablesAdd = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        variablesAdd.setLayoutData(gd);
        variablesAdd.setImage(ImageShop.get(ImageShop.IMG_ADD_OBJ));
        variablesAdd.setToolTipText(Messages.ImplementationPage_button_add);
        variablesAdd.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeVariablesAdd();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        variablesEdit = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        variablesEdit.setLayoutData(gd);
        variablesEdit.setEnabled(false);
        variablesEdit.setImage(ImageShop.get(ImageShop.IMG_EDIT_OBJ));
        variablesEdit.setToolTipText(Messages.ImplementationPage_button_edit);
        variablesEdit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                ISelection selection = variablesTableViewer.getSelection();
                final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
                final VariablesEditDialog dialog = new VariablesEditDialog(new Shell(), selectItem, getEditingDomain());
                dialog.setTitle(Messages.ImplementationPage_variablesEditDialog_title);
                if (dialog.open() == Window.OK) {
                    TransactionalEditingDomain editingDomain = getEditingDomain();
                    RecordingCommand cmd = new RecordingCommand(editingDomain) {
                        protected void doExecute() {
                            executeVariableEdit(dialog, selectItem);
                        }
                    };
                    editingDomain.getCommandStack().execute(cmd);
                    variablesTableViewer.refresh();
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        variablesRemove = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        variablesRemove.setLayoutData(gd);
        variablesRemove.setEnabled(false);
        variablesRemove.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        variablesRemove.setToolTipText(Messages.ImplementationPage_button_remove);
        variablesRemove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeVariablesRemove(variables);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    /**
     * Set the Variables section's button status.
     */
    private void setVariablesButtonsStatus() {
        int selectIndex = variablesTableViewer.getTable().getSelectionIndex();
        if (selectIndex == -1) {
            variablesRemove.setEnabled(false);
            variablesEdit.setEnabled(false);
            return;
        }

        int length = variablesTableViewer.getTable().getItemCount();
        if (length > 0) {
            variablesRemove.setEnabled(true);
            variablesEdit.setEnabled(true);
        } else {
            variablesRemove.setEnabled(false);
            variablesEdit.setEnabled(false);
        }
    }

    protected void executeVariablesAdd() {
        final Pattern pattern = getPattern();
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                PatternVariable patternVariableNew = PatternFactory.eINSTANCE.createPatternVariable();
                patternVariableNew.setName(VARIABLE_NAME_DEFAULT_VALUE);
                patternVariableNew.setType(VARIABLE_TYPE_DEFAULT_VALUE);
                pattern.getVariables().add(patternVariableNew);
                PatternUIHelper.addAdapterForNewItem(variablesTableViewer, patternVariableNew);
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        EList<PatternVariable> allVariables = pattern.getAllVariables();
        int len = allVariables.size();
        variablesTableViewer.getTable().setSelection(len - 1);
        setVariablesButtonsStatus();
    }

    private void executeVariableEdit(VariablesEditDialog dialog, Object selectItem) {
        String newName = dialog.getName();
        String newType = dialog.getType();

        if (selectItem instanceof PatternVariable) {
            PatternVariable item = (PatternVariable) selectItem;
            item.setName(newName);
            item.setType(newType);
        }
    }

    protected void executeVariablesRemove(Composite variables) {
        int index = variablesTableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            ISelection selection = variablesTableViewer.getSelection();
            final Object removeit = ((IStructuredSelection) selection).getFirstElement();
            if (removeit instanceof PatternVariable) {
                if (isVariableDeleteDisable((PatternVariable) removeit)) {
                    String message = Messages.ImplementationPage_variable_cannot_delete_message;
                    showErrorMessage(variables, message);
                    return;
                }
                final Pattern pattern = getPattern();
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {
                    protected void doExecute() {
                        pattern.getVariables().remove(removeit);
                    }
                };
                editingDomain.getCommandStack().execute(cmd);
                EList<PatternVariable> allParameters = pattern.getAllVariables();
                setDefaultSelection(allParameters.size(), variablesTableViewer, index);
            }
        }
        setVariablesButtonsStatus();
    }

    private Composite createComposite(FormToolkit toolkit, Section section, String label) {
        Composite container = toolkit.createComposite(section, SWT.NONE);

        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        container.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        container.setLayoutData(gd);

        Label discrip = toolkit.createLabel(container, label, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.horizontalIndent = 4;
        discrip.setLayoutData(gd);

        return container;
    }

    /**
     * Set default selection after remove operation.
     */
    private void setDefaultSelection(int len, TableViewer tableViewer, int index) {
        if (index < len) {
            tableViewer.getTable().setSelection(index);
        } else if (index >= len) {
            tableViewer.getTable().setSelection(index - 1);
        }
    }

    /**
     * When can't delete the select item, show a message dialog.
     */
    private void showErrorMessage(Composite composite, String message) {
        MessageDialog.openError(composite.getShell(), Messages.ImplementationPage_Error, message);
    }

    /**
     * Check whether the method can be deleted.
     */
    private boolean isMethodDeleteDisable(PatternMethod deleteItem) {
        Pattern pattern = getPattern();
        if (pattern != null) {
            EList<Call> orchestration = pattern.getOrchestration();
            for (Call call : orchestration) {
                if (call instanceof MethodCall) {
                    PatternMethod currentCalled = ((MethodCall) call).getCalled();
                    if (deleteItem.equals(currentCalled)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check whether the variable can be deleted.
     */
    private boolean isVariableDeleteDisable(PatternVariable deleteItem) {
        Pattern pattern = getPattern();
        if (pattern != null) {
            EList<Call> orchestration = pattern.getOrchestration();
            for (Call call : orchestration) {
                if (call instanceof PatternInjectedCall) {
                    PatternVariable currentVariable = ((PatternInjectedCall) call).getContext();
                    if (deleteItem.equals(currentVariable)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void bind() {
        addBinding(null);
        Pattern pattern = getPattern();
        if (pattern != null) {
            bindMethodsTable(pattern);
            bindOrchestrationTable(pattern);
            bindVariablesTableViewer(pattern);
            variableNameEmpetyValidationAdapter = PatternUIHelper.addValidationAdapeter(mmng, getPattern(), ValidationConstants.CONSTRAINTS_PATTERN_VARIABLE_NAME_NOT_EMPTY_ID, variablesTableViewer.getTable());
        }
    }

    void bindMethodsTable(Pattern pattern) {
        if (nameEditor != null) {
            List<String> useablePatternMethods = PatternUIHelper.getUseablePatternMethodsNameList(getPatternParent());
            nameEditor.setInput(useablePatternMethods);
        }
        if (methodsTableViewer != null) {
            methodsTableViewer.setInput(null);
            methodsTableViewer.setLabelProvider(new MethodLabelProvider());
            IEMFListProperty input = EMFProperties.list(PatternPackage.Literals.PATTERN__METHODS);
            IObservableList observe = input.observe(pattern);
            methodsTableViewer.setInput(observe);
        }
    }

    void bindOrchestrationTable(Pattern pattern) {
        if (orchestrationTableViewer != null) {
            IEMFListProperty modelProperty = EMFProperties.list(PatternPackage.Literals.PATTERN__ORCHESTRATION);
            IObservableList observe = modelProperty.observe(pattern);
            orchestrationTableViewer.setInput(observe);
        }
    }

    void bindVariablesTableViewer(Pattern pattern) {
        if (variablesTableViewer != null) {
            IEMFListProperty input = EMFProperties.list(PatternPackage.Literals.PATTERN__VARIABLES);
            IObservableList observe = input.observe(pattern);
            variablesTableViewer.setInput(observe);
        }
    }

    public Button getEditButton() {
        return methodsEdit;
    }

    private Pattern getPatternParent() {
        Pattern pattern = getPattern();
        return pattern == null ? null : pattern.getSuperPattern();
    }

    @Override
    public void dispose() {
        PatternUIHelper.removeAdapterForPattern(getPattern(), variableNameEmpetyValidationAdapter);
        super.dispose();
    }
}
