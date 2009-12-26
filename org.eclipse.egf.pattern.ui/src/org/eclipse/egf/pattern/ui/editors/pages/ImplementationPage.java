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
import org.eclipse.egf.model.pattern.SuperPatternCall;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.dialogs.MethodAddOrEditDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.VariablesEditDialog;
import org.eclipse.egf.pattern.ui.editors.modifiers.MethodTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.modifiers.VariablesTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.MethodLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.OrchestrationTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TableObservableListContentProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.egf.pattern.ui.editors.wizards.OrchestrationWizard;
import org.eclipse.egf.pattern.ui.editors.wizards.pages.CallTypeEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

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

    private Button methodsEdit;

    private Button methodsRemove;

    private Button orchestrationEdit;

    private Button orchestrationRemove;

    private Button orchestrationUp;

    private Button orchestrationDown;

    private Button variablesEdit;

    private Button variablesRemove;

    private ComboBoxViewerCellEditor nameEditor;

    private PatternMethod dropEntry;

    private int dragIndex = -1;

    private boolean isChangeOder;

    private static final String VARIABLE_NAME_DEFAULT_VALUE = "variable"; //$NON-NLS-1$

    private static final String VARIABLE_TYPE_DEFAULT_VALUE = "http://www.eclipse.org/emf/2002/Ecore#//EClass"; //$NON-NLS-1$

    public ImplementationPage(FormEditor editor) {
        super(editor, ID, Messages.ImplementationPage_title);

    }

    @Override
    protected void doCreateFormContent(IManagedForm managedForm) {
        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();

        toolkit.decorateFormHeading(form.getForm());

        GridLayout layout = new GridLayout(2, true);
        form.getBody().setLayout(layout);
        form.setImage(ImageShop.get(ImageShop.IMG_PLUGIN_MF_OBJ));
        form.setText(Messages.ImplementationPage_title);

        createMethodsSection(toolkit, form);
        createOrchestrationSection(toolkit, form);
        createVariablesSection(toolkit, form);

        form.reflow(true);
    }

    private void createMethodsSection(FormToolkit toolkit, ScrolledForm form) {
        Section methSection = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
        methSection.setText(Messages.ImplementationPage_Methods);
        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        methSection.setLayoutData(gd);

        String label = Messages.ImplementationPage_methSection_label;
        Composite methods = createLabel(toolkit, methSection, label);

        createMethodsTable(toolkit, methods);
        createMethodsButtons(toolkit, methods);

        methSection.setClient(methods);
    }

    private void createMethodsTable(FormToolkit toolkit, Composite methods) {
        Table table = toolkit.createTable(methods, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);

        methodsTableViewer = new TableViewer(table);
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setWidth(200);
        initMethodsTableEditor();

        methodsTableViewer.setContentProvider(new TableObservableListContentProvider(methodsTableViewer));

        methodsTableViewer.addDoubleClickListener(new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                // TODO: open a method editor.
            }
        });
        methodsTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                setMethodsButtonsStatus();
            }
        });

        methodsTableViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new DragSourceListener() {

            public void dragStart(DragSourceEvent event) {
                isChangeOder = false;
                if (methodsTableViewer.getSelection() == null) {
                    event.doit = false;
                }
            }

            public void dragSetData(DragSourceEvent event) {
                if (methodsTableViewer.getSelection() != null) {
                    int Index = methodsTableViewer.getTable().getSelectionIndex();
                    dropEntry = (PatternMethod) methodsTableViewer.getElementAt(Index);
                }
            }

            public void dragFinished(DragSourceEvent event) {
            }
        });

    }

    private void initMethodsTableEditor() {
        methodsTableViewer.setColumnProperties(new String[] { NAME_COLUMN_ID });
        nameEditor = new ComboBoxViewerCellEditor(methodsTableViewer.getTable(), SWT.READ_ONLY);
        nameEditor.setLabelProvider(new LabelProvider());
        nameEditor.setContenProvider(new CommonListContentProvider());

        methodsTableViewer.setCellEditors(new CellEditor[] { nameEditor });
        methodsTableViewer.setCellModifier(new MethodTableCellModifier(getEditingDomain(), methodsTableViewer));
    }

    /**
     * Create the Methods section's buttons.
     */
    private void createMethodsButtons(FormToolkit toolkit, Composite methods) {
        Composite buttons = toolkit.createComposite(methods, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;
        Button methAdd = toolkit.createButton(buttons, Messages.ImplementationPage_button_add, SWT.PUSH);
        methAdd.setLayoutData(gd);
        methAdd.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                MethodAddOrEditDialog dialog = new MethodAddOrEditDialog(new Shell(), getParentMethods(), ""); //$NON-NLS-1$
                dialog.setTitle(Messages.ImplementationPage_methAdd_dialog_title);
                if (dialog.open() == Window.OK) {
                    executeMethodsAdd(dialog.getName());
                    setMethodsButtonsStatus();
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });

        methodsEdit = toolkit.createButton(buttons, Messages.ImplementationPage_button_edit, SWT.PUSH);
        methodsEdit.setLayoutData(gd);
        methodsEdit.setEnabled(false);
        methodsEdit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                int index = methodsTableViewer.getTable().getSelectionIndex();
                String selectName = ""; //$NON-NLS-1$
                if (index > 0) {
                    Object entry = methodsTableViewer.getElementAt(index);
                    if (entry instanceof PatternMethod) {
                        selectName = ((PatternMethod) entry).getName();
                    }
                }
                MethodAddOrEditDialog dialog = new MethodAddOrEditDialog(new Shell(), getParentMethods(), selectName);
                dialog.setTitle(Messages.ImplementationPage_methEdit_dialog_title);
                if (dialog.open() == Window.OK) {
                    executeMethodsEdit(dialog.getName());
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {

            }
        });

        methodsRemove = toolkit.createButton(buttons, Messages.ImplementationPage_button_remove, SWT.PUSH);
        methodsRemove.setLayoutData(gd);
        methodsRemove.setEnabled(false);
        methodsRemove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeMethodsRemove();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    /**
     * Set the Methods section's button status.
     */
    private void setMethodsButtonsStatus() {
        int selectIndex = methodsTableViewer.getTable().getSelectionIndex();
        if (selectIndex == -1) {
            methodsRemove.setEnabled(false);
            methodsEdit.setEnabled(false);
            return;
        }
        int length = methodsTableViewer.getTable().getItemCount();
        if (length > 0) {
            methodsRemove.setEnabled(true);
            methodsEdit.setEnabled(true);
        } else {
            methodsRemove.setEnabled(false);
            methodsEdit.setEnabled(false);
        }
    }

    private void executeMethodsRemove() {
        int index = methodsTableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            final Pattern pattern = getPattern();
            final Object selectItem = methodsTableViewer.getElementAt(index);
            TransactionalEditingDomain editingDomain = getEditingDomain();
            RecordingCommand cmd = new RecordingCommand(editingDomain) {
                protected void doExecute() {
                    if (selectItem instanceof PatternMethod) {
                        pattern.getMethods().remove(selectItem);
                    }
                }
            };
            editingDomain.getCommandStack().execute(cmd);
            EList<PatternMethod> allVariables = pattern.getMethods();
            setDefaultSelection(allVariables, methodsTableViewer, index);
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
            }
        };
        editingDomain.getCommandStack().execute(cmd);

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

    private void createOrchestrationSection(FormToolkit toolkit, ScrolledForm form) {
        Section orchSection = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
        orchSection.setText(Messages.ImplementationPage_orchSection_title);
        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        orchSection.setLayoutData(gd);

        String label = Messages.ImplementationPage_orchSection_label;
        Composite orchestration = createLabel(toolkit, orchSection, label);

        createOrchestrationTable(toolkit, orchestration);
        createOrchestrationButtons(toolkit, orchestration);

        orchSection.setClient(orchestration);
    }

    private void createOrchestrationTable(FormToolkit toolkit, Composite orchestration) {
        Table table = toolkit.createTable(orchestration, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);
        orchestrationTableViewer = new TableViewer(table);
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setWidth(400);

        orchestrationTableViewer.setContentProvider(new TableObservableListContentProvider(orchestrationTableViewer));
        orchestrationTableViewer.setLabelProvider(new OrchestrationTableLabelProvider());
        orchestrationTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                setOrchestrationButtonsStatus();
            }
        });
        addDragDrop();
    }

    /**
     * Add drag and drop listener to orchTableViewer.
     */
    private void addDragDrop() {
        orchestrationTableViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new DragSourceListener() {

            public void dragStart(DragSourceEvent event) {
                isChangeOder = true;
                if (orchestrationTableViewer.getSelection() == null) {
                    event.doit = false;
                }
            }

            public void dragSetData(DragSourceEvent event) {
                if (orchestrationTableViewer.getSelection() != null) {
                    dragIndex = orchestrationTableViewer.getTable().getSelectionIndex();
                }
            }

            public void dragFinished(DragSourceEvent event) {
            }
        });

        orchestrationTableViewer.addDropSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new ViewerDropAdapter(orchestrationTableViewer) {

            public boolean validateDrop(Object target, int operation, TransferData transferType) {
                if (!isChangeOder) {
                    return checkDuplicate();
                }
                return true;
            }

            public boolean performDrop(Object data) {
                if (isChangeOder) {
                    Object currentTarget = getCurrentTarget();
                    executeChangeOrder(currentTarget);
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
    protected void executeChangeOrder(Object currentTarget) {
        EList<Call> orchestration = getPattern().getOrchestration();
        int targetIndex = 0;
        int index = 0;
        if (currentTarget == null) {
            targetIndex = orchestrationTableViewer.getTable().getItemCount() - 1;
            currentTarget = orchestrationTableViewer.getElementAt(targetIndex);
        } else {
            for (Object enty : orchestration) {
                if (currentTarget.equals(enty)) {
                    targetIndex = index;
                    break;
                }
                index++;
            }
        }
        updateOrchestration(orchestration, targetIndex);
        orchestrationTableViewer.getTable().setSelection(targetIndex);
        setOrchestrationButtonsStatus();
    }

    /**
     * Refresh the pattern's Orchestration after change orchestrationTableViewer
     * order's.
     */
    private void updateOrchestration(final EList<Call> orchestration, final int targetIndex) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                orchestration.move(targetIndex, dragIndex);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    /**
     * While drop the method from methTableViewer to orchTableViewer,check
     * whether the method already exist in orchTableViewer.
     */
    protected boolean checkDuplicate() {
        int index = methodsTableViewer.getTable().getSelectionIndex();
        PatternMethod drop = (PatternMethod) methodsTableViewer.getElementAt(index);
        for (Object call : getPattern().getOrchestration()) {
            if (call instanceof MethodCall) {
                MethodCall methodCall = (MethodCall) call;
                PatternMethod target = methodCall.getCalled();
                if (drop.equals(target)) {
                    return false;
                }
            }
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

        Button orchestrationAdd = toolkit.createButton(buttons, Messages.ImplementationPage_button_add, SWT.PUSH);
        orchestrationAdd.setLayoutData(gd);
        orchestrationAdd.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                OrchestrationWizard wizard = new OrchestrationWizard(getPattern(), CallTypeEnum.Add, null);
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

        orchestrationEdit = toolkit.createButton(buttons, Messages.ImplementationPage_button_edit, SWT.PUSH);
        orchestrationEdit.setLayoutData(gd);
        orchestrationEdit.setEnabled(false);
        orchestrationEdit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                int index = orchestrationTableViewer.getTable().getSelectionIndex();
                Object selectItem = orchestrationTableViewer.getElementAt(index);

                CallTypeEnum kind = CallTypeEnum.Add;
                if (selectItem instanceof MethodCall) {
                    kind = CallTypeEnum.METHOD_CALL;
                } else if (selectItem instanceof PatternCall) {
                    kind = CallTypeEnum.PATTERN_CALL;
                } else if (selectItem instanceof PatternInjectedCall) {
                    kind = CallTypeEnum.PATTERNINJECTED_CALL;
                } else if (selectItem instanceof SuperPatternCall) {
                    kind = CallTypeEnum.SUPERPATTERN_CALL;
                }
                OrchestrationWizard wizard = new OrchestrationWizard(getPattern(), kind, selectItem);
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                int returnValue = dialog.open();
                if (Window.OK == returnValue) {
                    final Call selectCall = wizard.getSelectCall();
                    exectuteOrchestrationEdit(selectCall, selectItem);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationRemove = toolkit.createButton(buttons, Messages.ImplementationPage_button_remove, SWT.PUSH);
        orchestrationRemove.setLayoutData(gd);
        orchestrationRemove.setEnabled(false);
        orchestrationRemove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                exectueOrchestrationRemove();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationUp = toolkit.createButton(buttons, Messages.ImplementationPage_button_up, SWT.PUSH);
        orchestrationUp.setLayoutData(gd);
        orchestrationUp.setEnabled(false);
        orchestrationUp.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeOrchestrationUpOrDown(-1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        orchestrationDown = toolkit.createButton(buttons, Messages.ImplementationPage_button_down, SWT.PUSH);
        orchestrationDown.setLayoutData(gd);
        orchestrationDown.setEnabled(false);
        orchestrationDown.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeOrchestrationUpOrDown(1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    protected void exectuteOrchestrationAdd(OrchestrationWizard wizard) {
        final Call selectCall = wizard.getSelectCall();
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                selectCall.setPattern(getPattern());
                getPattern().getOrchestration().add(selectCall);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
        int len = getPattern().getOrchestration().size();
        orchestrationTableViewer.getTable().setSelection(len - 1);
        setOrchestrationButtonsStatus();
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
            setDefaultSelection(orchestration, orchestrationTableViewer, index);
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
    }

    private void createVariablesSection(FormToolkit toolkit, ScrolledForm form) {
        Section varSection = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
        varSection.setText(Messages.ImplementationPage_varSection_title);
        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        varSection.setLayoutData(gd);

        String label = Messages.ImplementationPage_varSection_label;
        Composite variables = createLabel(toolkit, varSection, label);

        createVariablesTable(toolkit, variables);
        createVariablesButtons(toolkit, variables);

        varSection.setClient(variables);
    }

    private void createVariablesTable(FormToolkit toolkit, Composite variables) {
        Table table = toolkit.createTable(variables, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);

        variablesTableViewer = new TableViewer(table);
        String[] colNames = { "Name", "Type" }; //$NON-NLS-1$ //$NON-NLS-2$
        int[] colWidths = { 130, 135 };
        for (int i = 0; i < colNames.length; i++) {
            TableColumn tableColumn = new TableColumn(table, SWT.NONE);
            tableColumn.setWidth(colWidths[i]);
            tableColumn.setText(colNames[i]);
        }
        initVariablesTableEditor();
        variablesTableViewer.setContentProvider(new TableObservableListContentProvider(variablesTableViewer));
        variablesTableViewer.setLabelProvider(new ParametersTableLabelProvider());

    }

    private void initVariablesTableEditor() {
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
        return "";
    }

    /**
     * Create the Variables section's buttons.
     */
    private void createVariablesButtons(FormToolkit toolkit, Composite variables) {
        Composite buttons = toolkit.createComposite(variables, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;

        Button variablesAdd = toolkit.createButton(buttons, Messages.ImplementationPage_button_add, SWT.PUSH);
        variablesAdd.setLayoutData(gd);
        variablesAdd.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeVariablesAdd();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        variablesEdit = toolkit.createButton(buttons, Messages.ImplementationPage_button_edit, SWT.PUSH);
        variablesEdit.setLayoutData(gd);
        variablesEdit.setEnabled(false);
        variablesEdit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                ISelection selection = variablesTableViewer.getSelection();
                final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
                final VariablesEditDialog dialog = new VariablesEditDialog(new Shell(), selectItem, getEditingDomain());
                dialog.setTitle("Edit Variable");
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

        variablesRemove = toolkit.createButton(buttons, Messages.ImplementationPage_button_remove, SWT.PUSH);
        variablesRemove.setLayoutData(gd);
        variablesRemove.setEnabled(false);
        variablesRemove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeVariablesRemove();
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

    protected void executeVariablesRemove() {
        int index = variablesTableViewer.getTable().getSelectionIndex();
        if (index >= 0) {
            final Pattern pattern = getPattern();
            ISelection selection = variablesTableViewer.getSelection();
            final Object[] removeThem = ((IStructuredSelection) selection).toArray();
            TransactionalEditingDomain editingDomain = getEditingDomain();
            RecordingCommand cmd = new RecordingCommand(editingDomain) {
                protected void doExecute() {
                    for (Object object : removeThem) {
                        if (object instanceof PatternVariable) {
                            pattern.getVariables().remove(object);
                        }
                    }
                }
            };
            editingDomain.getCommandStack().execute(cmd);
            EList<PatternVariable> allParameters = pattern.getAllVariables();
            setDefaultSelection(allParameters, variablesTableViewer, index);
        }
        setVariablesButtonsStatus();
    }

    private Composite createLabel(FormToolkit toolkit, Section section, String label) {
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
     * Get the pattern's parent methods.
     */
    private List<String> getParentMethods() {
        List<String> parentMethods = new ArrayList<String>();
        Pattern parent = getPattern() == null ? null : getPattern().getSuperPattern();
        if (parent != null) {
            for (PatternMethod patternMethod : parent.getMethods()) {
                String name = patternMethod.getName();
                parentMethods.add(name);
            }
        }
        return parentMethods;
    }

    /**
     * Set default selection after remove operation.
     */
    private void setDefaultSelection(EList<?> model, TableViewer tableViewer, int index) {
        int len = model.size();
        if (index < len) {
            tableViewer.getTable().setSelection(index);
        } else if (index >= len) {
            tableViewer.getTable().setSelection(index - 1);
        }
    }

    @Override
    protected void bind() {
        addBinding(null);
        Pattern pattern = getPattern();
        if (pattern != null) {
            bindMethodsTable(pattern);
            bindOrchestrationTable(pattern);
            bindVariablesTableViewer(pattern);
        }
    }

    void bindMethodsTable(Pattern pattern) {
        if (nameEditor != null) {
            nameEditor.setInput(getParentMethods());
        }
        if (methodsTableViewer != null) {
            methodsTableViewer.setInput(null);
            methodsTableViewer.setLabelProvider(new MethodLabelProvider(getParentMethods()));
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

}
