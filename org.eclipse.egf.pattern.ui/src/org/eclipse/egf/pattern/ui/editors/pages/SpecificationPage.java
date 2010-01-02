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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.query.QueryManager;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.dialogs.ParametersEditDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.PatternSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.modifiers.ParametersTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.providers.ComboListLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TableObservableListContentProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
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
public class SpecificationPage extends PatternEditorPage {
    public static final String ID = "SpecificationPage"; //$NON-NLS-1$

    private Text parentText;

    private Button add;

    private Button edit;

    private Button remove;

    private Button up;

    private Button down;

    private Button browse;

    private Button removeParent;

    private Combo combo;

    private TableViewer tableViewer;

    private FormColors colors = new FormColors(Display.getDefault());

    public static final String NAME_COLUMN_ID = "Name"; //$NON-NLS-1$

    public static final String TYPE_COLUMN_ID = "Type"; //$NON-NLS-1$

    public static final String QUERY_COLUMN_ID = "Query"; //$NON-NLS-1$

    private static final String NO_QUERY_VALUE = ""; //$NON-NLS-1$

    private static final String PARAMETER_NAME_DEFAULT_VALUE = "parameter"; //$NON-NLS-1$

    private static final String PARAMETER_TYPE_DEFAULT_VALUE = "http://www.eclipse.org/emf/2002/Ecore#//EClass"; //$NON-NLS-1$

    private int dragIndex = -1;

    private ComboBoxViewerCellEditor queryEditor;

    private boolean isReadOnly;

    public SpecificationPage(FormEditor editor) {
        super(editor, ID, Messages.SpecificationPage_title);

    }

    @Override
    protected void doCreateFormContent(IManagedForm managedForm) {
        PatternEditorInput editorInput = (PatternEditorInput) getEditorInput();
        isReadOnly = editorInput.isReadOnly();

        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();

        toolkit.decorateFormHeading(form.getForm());
        GridLayout layout = new GridLayout(2, true);
        form.getBody().setLayout(layout);
        form.setImage(ImageShop.get(ImageShop.IMG_PLUGIN_MF_OBJ));
        form.setText(Messages.SpecificationPage_title);

        createInheritanceSection(toolkit, form);
        createPatternSection(toolkit, form);
        createParametersSection(toolkit, form);

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
        parentText.setEnabled(false);

        browse.setEnabled(false);
        removeParent.setEnabled(false);

        add.setEnabled(false);
        edit.setEnabled(false);
        remove.setEnabled(false);
        up.setEnabled(false);
        down.setEnabled(false);
        combo.setEnabled(false);
    }

    private void createInheritanceSection(FormToolkit toolkit, ScrolledForm form) {
        Section inherSection = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
        inherSection.setText(Messages.SpecificationPage_inherSection_title);
        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        inherSection.setLayoutData(gd);

        Composite Inheritance = toolkit.createComposite(inherSection, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        Inheritance.setLayout(layout);

        Label discrip = toolkit.createLabel(Inheritance, Messages.SpecificationPage_inherSection_discrip_label);
        gd = new GridData();
        gd.horizontalSpan = 3;
        gd.horizontalIndent = 4;
        discrip.setLayoutData(gd);

        Label parentLabel = toolkit.createLabel(Inheritance, Messages.SpecificationPage_inherSection_parent_label);
        gd = new GridData();
        gd.verticalIndent = 10;
        parentLabel.setLayoutData(gd);
        parentLabel.setForeground(colors.getColor(IFormColors.TITLE));

        Pattern superPattern = getPattern() == null ? null : getPattern().getSuperPattern();
        String parentName = superPattern == null ? "" : superPattern.getName(); //$NON-NLS-1$
        parentText = toolkit.createText(Inheritance, parentName, SWT.BORDER | SWT.READ_ONLY);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 10;
        gd.widthHint = 20;
        parentText.setLayoutData(gd);

        createInheritanceButtons(toolkit, Inheritance);

        inherSection.setClient(Inheritance);
    }

    private void createInheritanceButtons(FormToolkit toolkit, Composite Inheritance) {
        Composite buttons = toolkit.createComposite(Inheritance, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.verticalIndent = 10;
        gd.widthHint = 65;

        browse = toolkit.createButton(buttons, Messages.SpecificationPage_button_browse, SWT.PUSH);
        browse.setLayoutData(gd);
        browse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                PatternSelectionDialog dialog = new PatternSelectionDialog(new Shell(), getParentPattern(), getParentName());
                dialog.setTitle(Messages.SpecificationPage_browse_dialog_title);
                if (dialog.open() == Window.OK) {
                    final Pattern parent = dialog.getParent();
                    TransactionalEditingDomain editingDomain = getEditingDomain();
                    RecordingCommand cmd = new RecordingCommand(editingDomain) {
                        protected void doExecute() {
                            getPattern().setSuperPattern(parent);
                        }
                    };
                    editingDomain.getCommandStack().execute(cmd);
                }

            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        removeParent = toolkit.createButton(buttons, "", SWT.PUSH);
        removeParent.setLayoutData(gd);
        removeParent.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        removeParent.setToolTipText(Messages.SpecificationPage_button_remove);
        removeParent.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {
                    protected void doExecute() {
                        getPattern().setSuperPattern(null);
                    }
                };
                editingDomain.getCommandStack().execute(cmd);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    private void createPatternSection(FormToolkit toolkit, ScrolledForm form) {
        Section patternSection = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
        patternSection.setText(Messages.SpecificationPage_patternSection_title);
        GridData gd = new GridData(GridData.FILL_BOTH);
        patternSection.setLayoutData(gd);

        Composite pattern = toolkit.createComposite(patternSection, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        pattern.setLayout(layout);

        Label discrip = toolkit.createLabel(pattern, Messages.SpecificationPage_patternSection_discrip_label, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.horizontalIndent = 4;
        gd.widthHint = 100;
        discrip.setLayoutData(gd);

        createTypeArea(toolkit, pattern);

        patternSection.setClient(pattern);
    }

    private void createTypeArea(FormToolkit toolkit, Composite pattern) {
        Label type = toolkit.createLabel(pattern, Messages.SpecificationPage_patternSection_type_label);
        GridData gd = new GridData();
        gd.verticalIndent = 10;
        type.setLayoutData(gd);
        type.setForeground(colors.getColor(IFormColors.TITLE));

        combo = new Combo(pattern, SWT.NONE | SWT.READ_ONLY);

        Object[] natures = getNatures().keySet().toArray();
        for (int i = 0; i < natures.length; i++) {
            PatternNature currentNature = (PatternNature) natures[i];
            String currentNatureName = ExtensionHelper.getName(currentNature);
            combo.add(currentNatureName);
        }
        combo.select(0);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 10;
        gd.widthHint = 50;
        combo.setLayoutData(gd);
    }

    private void createParametersSection(FormToolkit toolkit, ScrolledForm form) {
        Section paraSection = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
        paraSection.setText(Messages.SpecificationPage_paraSection_title);
        GridData gd = new GridData(GridData.FILL_BOTH);
        paraSection.setLayoutData(gd);

        Composite parameters = toolkit.createComposite(paraSection, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        parameters.setLayout(layout);

        Label discrip = toolkit.createLabel(parameters, Messages.SpecificationPage_paraSection_discrip_label, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.horizontalIndent = 4;
        gd.widthHint = 100;
        discrip.setLayoutData(gd);

        createParametersTableArea(toolkit, parameters);
        createParametersButtons(toolkit, parameters);
        paraSection.setClient(parameters);
    }

    private void createParametersTableArea(FormToolkit toolkit, Composite parameters) {
        Table table = toolkit.createTable(parameters, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.verticalIndent = 10;
        gd.horizontalIndent = 10;
        gd.widthHint = 100;
        table.setLayoutData(gd);

        tableViewer = new TableViewer(table);
        String[] colNames = { "Name", "Type", "Query" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        int[] colWidths = { 100, 100, 100 };
        for (int i = 0; i < colNames.length; i++) {
            TableColumn tableColumn = new TableColumn(table, SWT.NONE);
            tableColumn.setWidth(colWidths[i]);
            tableColumn.setText(colNames[i]);
        }
        initTableEditor();
        tableViewer.setContentProvider(new TableObservableListContentProvider(tableViewer));
        tableViewer.setLabelProvider(new ParametersTableLabelProvider());

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                if (isReadOnly)
                    return;
                setButtonsStatus();
            }
        });
        addDragDrop();
    }

    /**
     * Add drag and drop listener to tableViewer.
     */
    private void addDragDrop() {
        if (isReadOnly)
            return;
        tableViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new DragSourceListener() {

            public void dragStart(DragSourceEvent event) {
                if (tableViewer.getSelection() == null) {
                    event.doit = false;
                }
            }

            public void dragSetData(DragSourceEvent event) {
                if (tableViewer.getSelection() != null) {
                    dragIndex = tableViewer.getTable().getSelectionIndex();
                }
            }

            public void dragFinished(DragSourceEvent event) {
            }
        });

        tableViewer.addDropSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] { LocalSelectionTransfer.getTransfer() }, new ViewerDropAdapter(tableViewer) {

            public boolean validateDrop(Object target, int operation, TransferData transferType) {
                return true;
            }

            public boolean performDrop(Object data) {
                Object currentTarget = getCurrentTarget();
                executeChangeOrder(currentTarget);
                return false;
            }
        });
    }

    /**
     * Execute the drag and drop operation to change the order of the table
     * rows.
     */
    protected void executeChangeOrder(Object currentTarget) {
        EList<PatternParameter> allParameters = getPattern().getAllParameters();
        Object currentSource = allParameters.get(dragIndex);
        BasicEList<PatternParameter> allParametersNew = new BasicEList<PatternParameter>();
        int targetIndex = 0;
        int index = 0;
        if (currentTarget == null) {
            targetIndex = tableViewer.getTable().getItemCount() - 1;
            currentTarget = tableViewer.getElementAt(targetIndex);
        } else {
            for (Object parameter : allParameters) {
                if (currentTarget.equals(parameter)) {
                    targetIndex = index;
                    break;
                }
                index++;
            }
        }
        for (int i = 0; i < allParameters.size(); i++) {
            if (i == targetIndex) {
                if (targetIndex > dragIndex) {
                    allParametersNew.add((PatternParameter) currentTarget);
                    allParametersNew.add((PatternParameter) currentSource);
                } else {
                    allParametersNew.add((PatternParameter) currentSource);
                    allParametersNew.add((PatternParameter) currentTarget);
                }
            } else if (i != dragIndex) {
                allParametersNew.add(allParameters.get(i));
            }
        }

        updateAllParameters(allParametersNew);
        tableViewer.getTable().setSelection(targetIndex);
        setButtonsStatus();
    }

    private void createParametersButtons(FormToolkit toolkit, Composite parameters) {
        Composite buttons = toolkit.createComposite(parameters, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;

        add = toolkit.createButton(buttons, "", SWT.PUSH);
        add.setLayoutData(gd);
        add.setImage(ImageShop.get(ImageShop.IMG_ADD_OBJ));
        add.setToolTipText(Messages.SpecificationPage_button_add);
        add.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeAdd();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        edit = toolkit.createButton(buttons, "", SWT.PUSH);
        edit.setLayoutData(gd);
        edit.setEnabled(false);
        edit.setImage(ImageShop.get(ImageShop.IMG_EDIT_OBJ));
        edit.setToolTipText(Messages.SpecificationPage_button_edit);
        edit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                ISelection selection = tableViewer.getSelection();
                final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
                if (selectItem instanceof PatternParameter) {
                    PatternParameter patternParameter = (PatternParameter) selectItem;
                    final ParametersEditDialog dialog = new ParametersEditDialog(new Shell(), patternParameter, getEditingDomain());
                    dialog.setTitle(Messages.SpecificationPage_parametersEditDialog_title);
                    if (dialog.open() == Window.OK) {
                        TransactionalEditingDomain editingDomain = getEditingDomain();
                        RecordingCommand cmd = new RecordingCommand(editingDomain) {
                            protected void doExecute() {
                                executeParameterEdit(dialog, selectItem);
                            }
                        };
                        editingDomain.getCommandStack().execute(cmd);
                    }
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        remove = toolkit.createButton(buttons, "", SWT.PUSH);
        remove.setLayoutData(gd);
        remove.setEnabled(false);
        remove.setImage(ImageShop.get(ImageShop.IMG_DELETE_OBJ));
        remove.setToolTipText(Messages.SpecificationPage_button_remove);
        remove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                exectueRemove();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        up = toolkit.createButton(buttons, "", SWT.PUSH);
        up.setLayoutData(gd);
        up.setEnabled(false);
        up.setImage(ImageShop.get(ImageShop.IMG_UPWARD_OBJ));
        up.setToolTipText(Messages.SpecificationPage_button_up);
        up.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeUpOrDown(-1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        down = toolkit.createButton(buttons, "", SWT.PUSH);
        down.setLayoutData(gd);
        down.setEnabled(false);
        down.setImage(ImageShop.get(ImageShop.IMG_DOWNWARD_OBJ));
        down.setToolTipText(Messages.SpecificationPage_button_down);
        down.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeUpOrDown(1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    protected void executeParameterEdit(ParametersEditDialog dialog, Object selectItem) {
        String newName = dialog.getName();
        String newType = dialog.getType();
        String newQuey = dialog.getQuery();

        QueryKind queryKind = QueryManager.INSTANCE.getQueryKindByName(newQuey);
        if (queryKind != null) {
            newQuey = queryKind.getId();
        }

        if (selectItem instanceof PatternParameter) {
            PatternParameter item = (PatternParameter) selectItem;
            item.setName(newName);
            item.setType(newType);
            if (item.getQuery() != null) {
                item.getQuery().setExtensionId(newQuey);
            } else if (!NO_QUERY_VALUE.equals(newQuey)) { //$NON-NLS-1$
                Query query = PatternFactory.eINSTANCE.createBasicQuery();
                query.setExtensionId(newQuey);
                item.setQuery(query);
            }
            if (NO_QUERY_VALUE.equals(item.getQuery())) {
                item.setQuery(null);
            }
        }
    }

    private void setButtonsStatus() {
        int selectIndex = tableViewer.getTable().getSelectionIndex();
        if (selectIndex == -1) {
            edit.setEnabled(false);
            remove.setEnabled(false);
            up.setEnabled(false);
            down.setEnabled(false);
            return;
        }
        int length = tableViewer.getTable().getItemCount();
        if (length > 0) {
            remove.setEnabled(true);
            edit.setEnabled(true);
        } else {
            remove.setEnabled(false);
            edit.setEnabled(false);
        }
        if (selectIndex <= 0) {
            up.setEnabled(false);
        } else {
            up.setEnabled(true);
        }
        if ((selectIndex + 1) == length) {
            down.setEnabled(false);
        } else {
            down.setEnabled(true);
        }
    }

    /**
     * Get all the natures.
     */
    private static Map<PatternNature, PatternExtension> getNatures() {

        Map<PatternNature, PatternExtension> result = new HashMap<PatternNature, PatternExtension>();
        for (PatternExtension ext : ExtensionHelper.getExtensions().values())
            result.put(ext.getNature(), ext);
        return result;
    }

    protected void exectueRemove() {
        int index = tableViewer.getTable().getSelectionIndex();
        final Pattern pattern = getPattern();
        ISelection selection = tableViewer.getSelection();
        final Object[] removeThem = ((IStructuredSelection) selection).toArray();
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                for (Object object : removeThem) {
                    if (object instanceof PatternParameter) {
                        pattern.getParameters().remove(object);
                    }
                }
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        int len = tableViewer.getTable().getItemCount();
        if (index < len) {
            tableViewer.getTable().setSelection(index);
        } else if (index >= len) {
            tableViewer.getTable().setSelection(index - 1);
        }
        setButtonsStatus();
    }

    /**
     * Add a new PatternParameter with a default name.
     */
    protected void executeAdd() {
        final Pattern pattern = getPattern();
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                PatternParameter newPatternParameter = PatternFactory.eINSTANCE.createPatternParameter();
                newPatternParameter.setName(PARAMETER_NAME_DEFAULT_VALUE);
                newPatternParameter.setType(PARAMETER_TYPE_DEFAULT_VALUE);
                pattern.getParameters().add(newPatternParameter);
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        EList<PatternParameter> allParameters = pattern.getAllParameters();
        int len = allParameters.size();
        tableViewer.getTable().setSelection(len - 1);
        setButtonsStatus();
    }

    private void executeUpOrDown(int num) {
        int oldIndex = tableViewer.getTable().getSelectionIndex();
        int newIndex = oldIndex + num;

        EList<PatternParameter> allParameters = getPattern().getAllParameters();
        BasicEList<PatternParameter> allParametersNew = new BasicEList<PatternParameter>();
        for (int i = 0; i < allParameters.size(); i++) {
            if (i == newIndex) {
                allParametersNew.add(allParameters.get(oldIndex));
            } else if (i == oldIndex) {
                allParametersNew.add(allParameters.get(newIndex));
            } else {
                allParametersNew.add(allParameters.get(i));
            }
        }
        updateAllParameters(allParametersNew);
        tableViewer.getTable().setSelection(newIndex);
        setButtonsStatus();
    }

    /**
     * Refresh the pattern's all parameters after change tableViewer order's.
     */
    private void updateAllParameters(final BasicEList<PatternParameter> allParametersNew) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                getPattern().getParameters().removeAll(getPattern().getParameters());
                getPattern().getParameters().addAll(allParametersNew);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    private void initTableEditor() {
        if (isReadOnly)
            return;
        tableViewer.setColumnProperties(new String[] { NAME_COLUMN_ID, TYPE_COLUMN_ID, QUERY_COLUMN_ID });
        final TextCellEditor nameEditor = new TextCellEditor(tableViewer.getTable());
        final DialogCellEditor typeEditor = new DialogCellEditor(tableViewer.getTable()) {

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
        queryEditor = new ComboBoxViewerCellEditor(tableViewer.getTable(), SWT.NONE);
        queryEditor.setLabelProvider(new ComboListLabelProvider());
        queryEditor.setContenProvider(new CommonListContentProvider());
        setComboViewerInput();
        tableViewer.setCellEditors(new CellEditor[] { nameEditor, typeEditor, queryEditor });
        ParametersTableCellModifier modifier = new ParametersTableCellModifier(getEditingDomain(), tableViewer);
        tableViewer.setCellModifier(modifier);
    }

    private void updateType(final String selectType) {
        if (selectType != null && !"".equals(selectType)) { //$NON-NLS-1$
            ISelection selection = tableViewer.getSelection();
            final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
            if (selectItem instanceof PatternParameter) {
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {
                    protected void doExecute() {
                        ((PatternParameter) selectItem).setType(selectType);
                    }
                };
                editingDomain.getCommandStack().execute(cmd);
                tableViewer.refresh();
            }
        }
    }

    private void setComboViewerInput() {
        List availableQueries = QueryManager.INSTANCE.getAvailableQueries();
        availableQueries.add(0, "");
        queryEditor.setInput(availableQueries);
    }

    /**
     * Get the type of selected pattern parameter.
     */
    private String getSelectItemType() {
        int selectionIndex = tableViewer.getTable().getSelectionIndex();
        Object selectItem = tableViewer.getElementAt(selectionIndex);
        if (selectItem instanceof PatternParameter) {
            return ((PatternParameter) selectItem).getType();
        }
        return "";
    }

    @Override
    protected void bind() {
        bindParent();
        bindNature();
        bindTableViewer();
    }

    void bindParent() {
        if (getPattern() == null) {
            return;
        }
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), PatternPackage.Literals.PATTERN__SUPER_PATTERN);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, parentText);
        IObservableValue mObs = mprop.observe(getPattern());

        UpdateValueStrategy targetToModel = new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {
            public IStatus validate(Object value) {

                return Status.OK_STATUS;
            }

        });
        UpdateValueStrategy modelToTarget = new UpdateValueStrategy();
        modelToTarget.setConverter(new IConverter() {
            public Object getToType() {
                return String.class;
            }

            public Object getFromType() {
                return EReference.class;
            }

            public Object convert(Object fromObject) {
                if (fromObject == null || !(fromObject instanceof Pattern)) {
                    return ""; //$NON-NLS-1$
                }
                return ((Pattern) fromObject).getName();
            }
        });

        addBinding(ctx.bindValue(uiObs, mObs, targetToModel, modelToTarget));
    }

    void bindNature() {
        if (getPattern() == null) {
            return;
        }
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), PatternPackage.Literals.PATTERN__NATURE);
        IWidgetValueProperty comboProp = WidgetProperties.selection();
        IObservableValue uiObs = comboProp.observeDelayed(400, combo);
        IObservableValue mObs = mprop.observe(getPattern());

        UpdateValueStrategy targetToModel = new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {
            public IStatus validate(Object value) {

                return Status.OK_STATUS;
            }

        });
        targetToModel.setConverter(new IConverter() {
            public Object getToType() {
                return EReference.class;
            }

            public Object getFromType() {
                return String.class;
            }

            public Object convert(Object fromObject) {
                if (fromObject == null || !(fromObject instanceof String)) {
                    return ""; //$NON-NLS-1$
                }
                if (fromObject.equals(ExtensionHelper.getName(getPattern().getNature())))
                    return getPattern().getNature();
                return ExtensionHelper.createNature((String) fromObject);
            }
        });

        UpdateValueStrategy modelToTarget = new UpdateValueStrategy();
        modelToTarget.setConverter(new IConverter() {
            public Object getToType() {
                return String.class;
            }

            public Object getFromType() {
                return EReference.class;
            }

            public Object convert(Object fromObject) {
                if (fromObject == null || !(fromObject instanceof PatternNature)) {
                    return ""; //$NON-NLS-1$
                }
                return ExtensionHelper.getName((PatternNature) fromObject);
            }
        });

        addBinding(ctx.bindValue(uiObs, mObs, targetToModel, modelToTarget));
    }

    private void bindTableViewer() {
        Pattern pattern = getPattern();
        if (pattern != null && tableViewer != null) {
            IEMFListProperty input = EMFProperties.list(PatternPackage.Literals.PATTERN__PARAMETERS);
            IObservableList observe = input.observe(pattern);
            tableViewer.setInput(observe);
        }
    }

    public Pattern getParentPattern() {
        return getPattern() != null ? getPattern().getSuperPattern() : null;
    }

    public String getParentName() {
        return parentText.getText();
    }
}
