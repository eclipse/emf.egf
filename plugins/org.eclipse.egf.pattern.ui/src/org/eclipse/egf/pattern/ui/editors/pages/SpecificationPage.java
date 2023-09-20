/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.pages;

import java.util.List;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternInitializer;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.contributions.EditHelper;
import org.eclipse.egf.pattern.ui.editors.adapter.LiveValidationContentAdapter;
import org.eclipse.egf.pattern.ui.editors.dialogs.ParametersEditDialog;
import org.eclipse.egf.pattern.ui.editors.dialogs.PatternSelectionDialog;
import org.eclipse.egf.pattern.ui.editors.models.QueryContent;
import org.eclipse.egf.pattern.ui.editors.modifiers.ParametersTableCellModifier;
import org.eclipse.egf.pattern.ui.editors.providers.ComboListLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.CommonListContentProvider;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.TableObservableListContentProvider;
import org.eclipse.egf.pattern.ui.editors.validation.ValidationConstants;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
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
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

/**
 * @author Thomas Guiu
 * 
 */
public class SpecificationPage extends PatternEditorPage {

    public static final String ID = "org.eclipse.egf.pattern.ui.editors.pages.specification.page.id"; //$NON-NLS-1$

    private Link parentLink;

    private Button add;

    private Button edit;

    private Button remove;

    private Button up;

    private Button down;

    private Button browse;

    private Button removeParent;

    private Combo natureCombo;

    private TableViewer parametersViewer;

    private FormColors colors = new FormColors(Display.getDefault());

    public static final String NAME_COLUMN_ID = "Name"; //$NON-NLS-1$

    public static final String TYPE_COLUMN_ID = "Type"; //$NON-NLS-1$

    public static final String QUERY_COLUMN_ID = "Query"; //$NON-NLS-1$

    private static final String NO_QUERY_VALUE = ""; //$NON-NLS-1$

    private static final String PARAMETER_NAME_DEFAULT_VALUE = "parameter"; //$NON-NLS-1$

    private static final String PARAMETER_TYPE_DEFAULT_VALUE = "http://www.eclipse.org/emf/2002/Ecore#//EClass"; //$NON-NLS-1$

    private int dragIndex = -1;

    private ISelectionChangedListener changedListener;

    private ParametersTableCellModifier modifier;

    private TextCellEditor nameEditor;

    private DialogCellEditor typeEditor;

    private ComboBoxViewerCellEditor queryEditor;

    private LiveValidationContentAdapter parameterNameEmptyValidationAdapter;

    private IMessageManager messageManager;

    public SpecificationPage(FormEditor editor) {
        super(editor, ID, Messages.SpecificationPage_title);
    }

    /**
     * Check whether the editor is on a read only pattern.
     */
    @Override
    protected void checkReadOnlyModel() {
        if (isReadOnly()) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    private void setEnabled(boolean enabled) {
        browse.setEnabled(enabled);
        removeParent.setEnabled(enabled);
        add.setEnabled(enabled);
        edit.setEnabled(enabled);
        remove.setEnabled(enabled);
        up.setEnabled(enabled);
        down.setEnabled(enabled);
        natureCombo.setEnabled(enabled);
        if (enabled) {
            parametersViewer.addSelectionChangedListener(changedListener);
            parametersViewer.setCellModifier(modifier);
            parametersViewer.setCellEditors(new CellEditor[] {
                    nameEditor, typeEditor, queryEditor
            });
        } else {
            parametersViewer.removeSelectionChangedListener(changedListener);
            parametersViewer.setCellModifier(null);
            parametersViewer.setCellEditors(null);
        }
    }

    protected void openParentPatternEditor() {
        EditHelper.openPatternEditor(getSite().getPage(), getPattern().getSuperPattern());
    }

    @Override
    protected void doCreateFormContent(IManagedForm managedForm) {

        FormToolkit toolkit = managedForm.getToolkit();
        messageManager = managedForm.getMessageManager();
        ScrolledForm form = managedForm.getForm();
        toolkit.decorateFormHeading(form.getForm());
        Composite body = form.getBody();

        TableWrapLayout twl = new TableWrapLayout();
        twl.numColumns = 2;
        body.setLayout(twl);
        form.setImage(Activator.getDefault().getImage(ImageShop.IMG_PLUGIN_MF_OBJ));
        form.setText(Messages.SpecificationPage_title);

        createInheritanceSection(toolkit, body);
        createPatternNatureSection(toolkit, body);
        createParametersSection(toolkit, body);

        form.reflow(true);

    }

    private void createInheritanceSection(FormToolkit toolkit, Composite parent) {

        Section section = toolkit.createSection(parent, Section.TITLE_BAR);
        section.setText(Messages.SpecificationPage_inherSection_title);
        section.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        section.setLayout(new TableWrapLayout());

        Composite container = toolkit.createComposite(section, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        TableWrapLayout twl = new TableWrapLayout();
        twl.numColumns = 2;
        container.setLayout(twl);

        Label title = toolkit.createLabel(container, Messages.SpecificationPage_inherSection_discrip_label);
        TableWrapData twd = new TableWrapData(TableWrapData.FILL_GRAB);
        twd.colspan = 2;
        title.setLayoutData(twd);

        Label parentLabel = toolkit.createLabel(container, Messages.SpecificationPage_inherSection_parent_label);
        parentLabel.setLayoutData(new TableWrapData(TableWrapData.LEFT, TableWrapData.MIDDLE));
        parentLabel.setForeground(colors.getColor(IFormColors.TITLE));

        // TODO: should use Hyperlink when it will be supported by databinding
        parentLink = new Link(container, SWT.WRAP);
        parentLink.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.MIDDLE));
        parentLink.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                openParentPatternEditor();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        createInheritanceButtons(toolkit, container);

        section.setClient(container);

    }

    private void createInheritanceButtons(FormToolkit toolkit, final Composite parent) {

        Composite container = toolkit.createComposite(parent, SWT.NONE);
        TableWrapData twd = new TableWrapData(TableWrapData.CENTER, TableWrapData.MIDDLE);
        twd.colspan = 2;
        container.setLayoutData(twd);
        container.setLayout(new GridLayout(2, true));

        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 65;

        browse = toolkit.createButton(container, Messages.SpecificationPage_button_browse, SWT.PUSH);
        browse.setLayoutData(gd);
        browse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                PatternSelectionDialog dialog = new PatternSelectionDialog(e.display.getActiveShell(), false);
                dialog.setTitle(Messages.SpecificationPage_browse_dialog_title);
                if (dialog.open() != Window.OK) {
                    return;
                }
                Object result = dialog.getFirstResult();
                if (result instanceof Pattern) {
                    final Pattern pattern = (Pattern) result;
                    TransactionalEditingDomain editingDomain = getEditingDomain();
                    RecordingCommand cmd = new RecordingCommand(editingDomain) {

                        @Override
                        protected void doExecute() {
                            getPattern().setSuperPattern(pattern);
                        }

                    };
                    editingDomain.getCommandStack().execute(cmd);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        removeParent = toolkit.createButton(container, "", SWT.PUSH); //$NON-NLS-1$
        removeParent.setLayoutData(gd);
        removeParent.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        removeParent.setToolTipText(Messages.SpecificationPage_button_remove);
        removeParent.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {

                    @Override
                    protected void doExecute() {
                        getPattern().setSuperPattern(null);
                    }

                };
                editingDomain.getCommandStack().execute(cmd);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

    }

    private void createPatternNatureSection(FormToolkit toolkit, Composite parent) {

        Section section = toolkit.createSection(parent, Section.TITLE_BAR);
        section.setText(Messages.SpecificationPage_patternSection_title);
        section.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        Composite container = toolkit.createComposite(section, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        TableWrapLayout twl = new TableWrapLayout();
        twl.numColumns = 2;
        container.setLayout(twl);

        Label label = toolkit.createLabel(container, Messages.SpecificationPage_patternSection_discrip_label, SWT.WRAP);
        TableWrapData twd = new TableWrapData(TableWrapData.FILL_GRAB);
        twd.colspan = 2;
        label.setLayoutData(twd);

        createTypeArea(toolkit, container);

        section.setClient(container);

    }

    private void createTypeArea(FormToolkit toolkit, final Composite composite) {

        Label type = toolkit.createLabel(composite, Messages.SpecificationPage_patternSection_type_label);
        type.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        type.setForeground(colors.getColor(IFormColors.TITLE));

        natureCombo = new Combo(composite, SWT.NONE | SWT.READ_ONLY);

        for (String name : EGFPatternPlugin.getPatternNatures()) {
            natureCombo.add(name);
        }
        natureCombo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        natureCombo.select(0);

    }

    private void updateNature() {
        // create template files
        final Pattern pattern = getPattern();
        final PatternLibrary library = pattern.getContainer();
        final IProject project = EMFHelper.getProject(library.eResource());
        // Update templates
        WorkspaceJob job = new WorkspaceJob(Messages.PatternNature_update) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                PatternInitializer initializer;
                try {
                    initializer = ExtensionHelper.getExtension(getPattern().getNature()).createInitializer(project, pattern);
                    initializer.updateSpecialMethods(true);
                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        return ((CoreException) t).getStatus();
                    }
                    return EGFModelPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(Messages.PatternNature_update_execute_exception, EcoreUtil.getURI(getPattern())), t);
                }
                return Status.OK_STATUS;
            }

        };
        job.setRule(project);
        job.schedule();
        // Save Resource
        getEditor().doSave(new NullProgressMonitor());
    }

    private void createParametersSection(FormToolkit toolkit, Composite parent) {

        Section section = toolkit.createSection(parent, Section.TITLE_BAR);
        section.setText(Messages.SpecificationPage_paraSection_title);
        section.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        section.setLayout(new TableWrapLayout());

        Composite container = toolkit.createComposite(section, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        container.setLayout(new GridLayout(2, false));

        Label discrip = toolkit.createLabel(container, Messages.SpecificationPage_paraSection_discrip_label, SWT.WRAP);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.horizontalIndent = 4;
        gd.widthHint = 100;
        discrip.setLayoutData(gd);

        createParametersTableArea(toolkit, container);
        createParametersButtons(toolkit, container);

        section.setClient(container);

    }

    private void createParametersTableArea(FormToolkit toolkit, Composite parameters) {

        Composite tableComp = new Composite(parameters, SWT.NONE);
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

        parametersViewer = new TableViewer(table);
        String[] colNames = {
                Messages.SpecificationPage_column_title_name, Messages.SpecificationPage_column_title_type, Messages.SpecificationPage_column_title_query
        };
        int[] colWidths = {
                100, 80, 80
        };
        parametersViewer.setContentProvider(new TableObservableListContentProvider(parametersViewer));
        parametersViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                if (isReadOnly()) {
                    return;
                }
                setButtonsStatus();
            }

        });
        ColumnViewerToolTipSupport.enableFor(parametersViewer, ToolTip.NO_RECREATE);
        CellLabelProvider cellLabelProvider = new ParametersTableLabelProvider();
        for (int i = 0; i < colNames.length; i++) {
            TableViewerColumn column = new TableViewerColumn(parametersViewer, SWT.NONE);
            column.setLabelProvider(cellLabelProvider);
            column.getColumn().setWidth(colWidths[i]);
            column.getColumn().setText(colNames[i]);
            layout.setColumnData(column.getColumn(), new ColumnWeightData(colWidths[i], true));
        }

        initTableEditor();

        addDragDrop();

    }

    /**
     * Add drag and drop listener to tableViewer.
     */
    private void addDragDrop() {

        parametersViewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] {
            LocalSelectionTransfer.getTransfer()
        }, new DragSourceListener() {

            public void dragStart(DragSourceEvent event) {
                if (isReadOnly()) {
                    event.doit = false;
                } else if (parametersViewer.getSelection() == null) {
                    event.doit = false;
                }
                event.doit = true;
            }

            public void dragSetData(DragSourceEvent event) {
                if (parametersViewer.getSelection() != null) {
                    dragIndex = parametersViewer.getTable().getSelectionIndex();
                }
            }

            public void dragFinished(DragSourceEvent event) {
                // Nothing to do
            }

        });

        parametersViewer.addDropSupport(DND.DROP_COPY | DND.DROP_MOVE, new Transfer[] {
            LocalSelectionTransfer.getTransfer()
        }, new ViewerDropAdapter(parametersViewer) {

            @Override
            public boolean validateDrop(Object target, int operation, TransferData transferType) {
                if (isReadOnly()) {
                    return false;
                }
                return true;
            }

            @Override
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
            targetIndex = parametersViewer.getTable().getItemCount() - 1;
            currentTarget = parametersViewer.getElementAt(targetIndex);
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
        parametersViewer.getTable().setSelection(targetIndex);
        setButtonsStatus();
    }

    private void createParametersButtons(FormToolkit toolkit, Composite parameters) {

        Composite buttons = toolkit.createComposite(parameters, SWT.NONE);
        GridLayout layout = new GridLayout();
        buttons.setLayout(layout);

        GridData gd = new GridData();
        gd.widthHint = 65;

        add = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        add.setLayoutData(gd);
        add.setImage(Activator.getDefault().getImage(ImageShop.IMG_ADD_OBJ));
        add.setToolTipText(Messages.SpecificationPage_button_add);
        add.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeAdd();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        edit = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        edit.setLayoutData(gd);
        edit.setEnabled(false);
        edit.setImage(Activator.getDefault().getImage(ImageShop.IMG_EDIT_OBJ));
        edit.setToolTipText(Messages.SpecificationPage_button_edit);
        edit.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                ISelection selection = parametersViewer.getSelection();
                final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
                if (selectItem instanceof PatternParameter) {
                    PatternParameter patternParameter = (PatternParameter) selectItem;
                    final ParametersEditDialog dialog = new ParametersEditDialog(getSite().getShell(), patternParameter);
                    dialog.setTitle(Messages.SpecificationPage_parametersEditDialog_title);
                    if (dialog.open() == Window.OK) {
                        TransactionalEditingDomain editingDomain = getEditingDomain();
                        RecordingCommand cmd = new RecordingCommand(editingDomain) {

                            @Override
                            protected void doExecute() {
                                executeParameterEdit(dialog, selectItem);
                            }

                        };
                        editingDomain.getCommandStack().execute(cmd);
                    }
                }
                parametersViewer.refresh();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        remove = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        remove.setLayoutData(gd);
        remove.setEnabled(false);
        remove.setImage(Activator.getDefault().getImage(ImageShop.IMG_DELETE_OBJ));
        remove.setToolTipText(Messages.SpecificationPage_button_remove);
        remove.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeRemove();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        up = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        up.setLayoutData(gd);
        up.setEnabled(false);
        up.setImage(Activator.getDefault().getImage(ImageShop.IMG_UPWARD_OBJ));
        up.setToolTipText(Messages.SpecificationPage_button_up);
        up.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeUpOrDown(-1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        down = toolkit.createButton(buttons, "", SWT.PUSH); //$NON-NLS-1$
        down.setLayoutData(gd);
        down.setEnabled(false);
        down.setImage(Activator.getDefault().getImage(ImageShop.IMG_DOWNWARD_OBJ));
        down.setToolTipText(Messages.SpecificationPage_button_down);
        down.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                executeUpOrDown(1);
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

    }

    protected void executeParameterEdit(ParametersEditDialog dialog, Object selectItem) {
        String newName = dialog.getName();
        String newType = dialog.getType();
        String newQuey = dialog.getQuery();

        QueryKind queryKind = IQuery.INSTANCE.getQueryKindByName(newQuey);
        if (queryKind != null) {
            newQuey = queryKind.getId();
        }

        if (selectItem instanceof PatternParameter) {
            PatternParameter item = (PatternParameter) selectItem;
            item.setName(newName);
            item.setType(newType);
            Query queryItem = item.getQuery();
            if (queryItem != null) {
                queryItem.setExtensionId(newQuey);
                setQueryContent(dialog, queryItem);
            } else if (!NO_QUERY_VALUE.equals(newQuey)) {
                Query query = PatternFactory.eINSTANCE.createBasicQuery();
                query.setExtensionId(newQuey);
                item.setQuery(query);
                query.setParameter(item);
                setQueryContent(dialog, query);
            }
            if (NO_QUERY_VALUE.equals(queryItem)) {
                item.setQuery(null);
            }
        }
    }

    /**
     * Update the Query Content of the Query.
     */
    private void setQueryContent(ParametersEditDialog dialog, Query query) {
        List<QueryContent> queryContents = dialog.getQueryContents();
        EMap<String, String> queryContext = query.getQueryContext();
        if (queryContext != null && !queryContext.isEmpty()) {
            queryContext.clear();
        }
        for (QueryContent queryContent : queryContents) {
            queryContext.put(queryContent.getKey(), queryContent.getValue());
        }
    }

    private void setButtonsStatus() {
        int selectIndex = parametersViewer.getTable().getSelectionIndex();
        if (selectIndex == -1) {
            edit.setEnabled(false);
            remove.setEnabled(false);
            up.setEnabled(false);
            down.setEnabled(false);
            return;
        }
        int length = parametersViewer.getTable().getItemCount();
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

    protected void executeRemove() {
        int index = parametersViewer.getTable().getSelectionIndex();
        final Pattern pattern = getPattern();
        ISelection selection = parametersViewer.getSelection();
        final Object[] removeThem = ((IStructuredSelection) selection).toArray();
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {

            @Override
            protected void doExecute() {
                for (Object object : removeThem) {
                    if (object instanceof PatternParameter) {
                        pattern.getParameters().remove(object);
                    }
                }
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        int len = parametersViewer.getTable().getItemCount();
        if (index < len) {
            parametersViewer.getTable().setSelection(index);
        } else if (index >= len) {
            parametersViewer.getTable().setSelection(index - 1);
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

            @Override
            protected void doExecute() {
                PatternParameter newPatternParameter = PatternFactory.eINSTANCE.createPatternParameter();
                newPatternParameter.setName(PARAMETER_NAME_DEFAULT_VALUE);
                newPatternParameter.setType(PARAMETER_TYPE_DEFAULT_VALUE);
                pattern.getParameters().add(newPatternParameter);
                PatternUIHelper.addAdapterForNewItem(parametersViewer, newPatternParameter);
            }
        };
        editingDomain.getCommandStack().execute(cmd);

        EList<PatternParameter> allParameters = pattern.getAllParameters();
        int len = allParameters.size();
        parametersViewer.getTable().setSelection(len - 1);
        setButtonsStatus();
    }

    private void executeUpOrDown(int num) {
        int oldIndex = parametersViewer.getTable().getSelectionIndex();
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
        parametersViewer.getTable().setSelection(newIndex);
        setButtonsStatus();
    }

    /**
     * Refresh the pattern's all parameters after change tableViewer order's.
     */
    private void updateAllParameters(final BasicEList<PatternParameter> allParametersNew) {
        TransactionalEditingDomain editingDomain = getEditingDomain();
        RecordingCommand cmd = new RecordingCommand(editingDomain) {

            @Override
            protected void doExecute() {
                getPattern().getParameters().removeAll(getPattern().getParameters());
                getPattern().getParameters().addAll(allParametersNew);
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

    private void initTableEditor() {

        // Column
        parametersViewer.setColumnProperties(new String[] {
                NAME_COLUMN_ID, TYPE_COLUMN_ID, QUERY_COLUMN_ID
        });

        // Name cell editor
        nameEditor = new TextCellEditor(parametersViewer.getTable());

        // Type cell editor
        typeEditor = new DialogCellEditor(parametersViewer.getTable()) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                OpenTypeWizard wizard = new OpenTypeWizard(getSelectItemType(), getPattern());
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                if (dialog.open() == Window.OK) {
                    Object object = wizard.getSelectType();
                    if (object instanceof IProxyEObject) {
                        updateType(((IProxyEObject) object).getURI().toString());
                    } else if (wizard.getSelectType() instanceof IType) {
                        updateType(((IType) object).getFullyQualifiedName());
                    }

                }
                return null;
            }

        };

        // Query cell editor
        queryEditor = new ComboBoxViewerCellEditor(parametersViewer.getTable(), SWT.NONE);
        queryEditor.setLabelProvider(new ComboListLabelProvider());
        queryEditor.setContenProvider(new CommonListContentProvider());
        setComboViewerInput();

        // Cell modifier
        modifier = new ParametersTableCellModifier(getEditingDomain(), parametersViewer);

        // Changed listener
        changedListener = new ISelectionChangedListener() {

            @SuppressWarnings("unchecked")
            public void selectionChanged(SelectionChangedEvent event) {
                @SuppressWarnings("rawtypes")
                List availableQueries = IQuery.INSTANCE.getAvailableQueries();
                availableQueries.add(0, ""); //$NON-NLS-1$
                queryEditor.setInput(availableQueries);
            }

        };

        if (isReadOnly() == false) {
            parametersViewer.addSelectionChangedListener(changedListener);
            parametersViewer.setCellModifier(modifier);
            parametersViewer.setCellEditors(new CellEditor[] {
                    nameEditor, typeEditor, queryEditor
            });
        }

    }

    private void updateType(final String selectType) {
        if (selectType != null && !"".equals(selectType)) { //$NON-NLS-1$
            ISelection selection = parametersViewer.getSelection();
            final Object selectItem = ((IStructuredSelection) selection).getFirstElement();
            if (selectItem instanceof PatternParameter) {
                TransactionalEditingDomain editingDomain = getEditingDomain();
                RecordingCommand cmd = new RecordingCommand(editingDomain) {

                    @Override
                    protected void doExecute() {
                        ((PatternParameter) selectItem).setType(selectType);
                    }

                };
                editingDomain.getCommandStack().execute(cmd);
                parametersViewer.refresh();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void setComboViewerInput() {
        @SuppressWarnings("rawtypes")
        List availableQueries = IQuery.INSTANCE.getAvailableQueries();
        availableQueries.add(0, ""); //$NON-NLS-1$
        queryEditor.setInput(availableQueries);
    }

    /**
     * Get the type of selected pattern parameter.
     */
    private String getSelectItemType() {
        int selectionIndex = parametersViewer.getTable().getSelectionIndex();
        Object selectItem = parametersViewer.getElementAt(selectionIndex);
        if (selectItem instanceof PatternParameter) {
            return ((PatternParameter) selectItem).getType();
        }
        return ""; //$NON-NLS-1$
    }

    @Override
    protected void bind() {
        if (getPattern() != null) {
            bindParent();
            bindNature();
            bindTableViewer();
            parameterNameEmptyValidationAdapter = PatternUIHelper.addValidationAdapter(messageManager, getPattern(), ValidationConstants.CONSTRAINTS_PATTERN_PARAMETER_NOT_EMPTY_NAME_ID, parametersViewer.getTable());
        }
        checkReadOnlyModel();
    }

    protected void bindParent() {

        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), PatternPackage.Literals.PATTERN__SUPER_PATTERN);
        IWidgetValueProperty textProp = WidgetProperties.text();
        IObservableValue uiObs = textProp.observeDelayed(400, parentLink);
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
                    return Messages.SpecificationPage_No_parent;
                }
                return "<a>" + ((Pattern) fromObject).getName() + "</a>"; //$NON-NLS-1$ //$NON-NLS-2$
            }

        });

        addBinding(ctx.bindValue(uiObs, mObs, targetToModel, modelToTarget));

    }

    protected void bindNature() {

        final IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), PatternPackage.Literals.PATTERN__NATURE);
        final IWidgetValueProperty comboProp = WidgetProperties.comboSelection();
        final IObservableValue uiObs = comboProp.observeDelayed(400, natureCombo);
        final IObservableValue mObs = mprop.observe(getPattern());

        UpdateValueStrategy targetToModel = new EMFUpdateValueStrategy() {

            @Override
            protected IStatus doSet(IObservableValue observableValue, Object value) {
                IStatus status = super.doSet(observableValue, value);
                if (status.isOK()) {
                    updateNature();
                }
                return status;
            }
        };

        targetToModel.setBeforeSetValidator(new IValidator() {

            public IStatus validate(Object value) {
                updateNature();
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
                // At this stage fromObject can't be null the targetToModel.setAfterGetValidator sent a CANCEL_STATUS 
                if (fromObject.equals(ExtensionHelper.getName(getPattern().getNature()))) {
                    return getPattern().getNature();
                }
                return ExtensionHelper.createNature((String) fromObject);
            }

        });

        targetToModel = targetToModel.setAfterGetValidator(new IValidator() {

            public IStatus validate(Object value) {
                // Ignore
                if (getPattern().getNature() == null) {
                    return Status.OK_STATUS;
                }
                String currentNature = ExtensionHelper.getName(getPattern().getNature());
                if (value == null) {
                    natureCombo.setText(currentNature);
                    return Status.CANCEL_STATUS;
                }
                // Nothing to do
                if (value.equals(currentNature)) {
                    return Status.CANCEL_STATUS;
                }
                // Confirm update
                if (MessageDialog.openQuestion(getPartControl().getShell(), Messages.SpecificationPage_change_nature_title, Messages.SpecificationPage_change_nature_type)) {
                    return Status.OK_STATUS;
                }
                natureCombo.setText(currentNature);
                return Status.CANCEL_STATUS;
            }

        });

        UpdateValueStrategy modelToTarget = new EMFUpdateValueStrategy();

        modelToTarget.setAfterGetValidator(new IValidator() {

            public IStatus validate(Object value) {
                // Ignore
                if (value == null || value instanceof PatternNature == false) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }

        });

        modelToTarget.setConverter(new IConverter() {

            public Object getToType() {
                return String.class;
            }

            public Object getFromType() {
                return EReference.class;
            }

            public Object convert(Object fromObject) {
                return ExtensionHelper.getName((PatternNature) fromObject);
            }

        });

        addBinding(ctx.bindValue(uiObs, mObs, targetToModel, modelToTarget));

    }

    private void bindTableViewer() {
        Pattern pattern = getPattern();
        if (pattern != null && parametersViewer != null) {
            IEMFListProperty input = EMFProperties.list(PatternPackage.Literals.PATTERN__PARAMETERS);
            IObservableList observe = input.observe(pattern);
            parametersViewer.setInput(observe);
        }
    }

    public Pattern getParentPattern() {
        return getPattern() != null ? getPattern().getSuperPattern() : null;
    }

    @Override
    public void dispose() {
        PatternUIHelper.removeAdapterForPattern(getPattern(), parameterNameEmptyValidationAdapter);
        colors.dispose();
        super.dispose();
    }

}
