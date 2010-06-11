/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.pages;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.adapter.LiveValidationContentAdapter;
import org.eclipse.egf.pattern.ui.editors.dialogs.ContainerLibrarySelectionDialog;
import org.eclipse.egf.pattern.ui.editors.validation.ValidationConstants;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author Thomas Guiu
 * 
 */
public class OverviewPage extends PatternEditorPage {

    public static final String ID = "OverviewPage"; //$NON-NLS-1$

    private FormEditor editor;

    private Text nameText;

    private Text fullNameText;

    private Text descripition;

    private Button browse;

    private FormColors colors = new FormColors(Display.getDefault());

    private LiveValidationContentAdapter patternNameEmpetyValidationAdapter;

    private IMessageManager mmng;

    public OverviewPage(FormEditor editor) {
        super(editor, ID, Messages.OverviewPage_title);
        this.editor = editor;
    }

    protected void doCreateFormContent(IManagedForm managedForm) {
        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        mmng = managedForm.getMessageManager();

        GridLayout gridLayout = new GridLayout();
        form.getBody().setLayout(gridLayout);
        form.setImage(Activator.getDefault().getImage(ImageShop.IMG_PLUGIN_MF_OBJ));
        form.setText(Messages.OverviewPage_title);

        Composite container = toolkit.createComposite(form.getBody(), SWT.NONE);
        gridLayout = new GridLayout(2, true);
        container.setLayout(gridLayout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        container.setLayoutData(gd);
        container.setFocus();

        createLeftContainer(toolkit, container);
        createRightContainer(toolkit, container);
        createDescriContainer(toolkit, container);

        checkReadOnlyModel();

        form.reflow(true);
    }

    /**
     * Check whether the editor is on a read only pattern.
     */
    private void checkReadOnlyModel() {
        PatternEditorInput editorInput = (PatternEditorInput) getEditorInput();
        if (!editorInput.isReadOnly()) {
            return;
        }
        nameText.setEnabled(false);
        fullNameText.setEnabled(false);
        descripition.setEnabled(false);
        browse.setEnabled(false);
    }

    private void createLeftContainer(FormToolkit toolkit, Composite container) {
        Section sectionLeft = toolkit.createSection(container, Section.TITLE_BAR);
        sectionLeft.setText(Messages.OverviewPage_sectionLeft_title);

        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
        gd.minimumWidth = 300;
        gd.heightHint = 200;
        sectionLeft.setLayoutData(gd);

        Composite containerLeft = toolkit.createComposite(sectionLeft, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        containerLeft.setLayout(gridLayout);
        gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        containerLeft.setLayoutData(gd);

        String titletext = Messages.OverviewPage_sectionLeft_title_label;
        Label title = toolkit.createLabel(containerLeft, titletext, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.widthHint = 20;
        gd.horizontalSpan = 2;
        title.setLayoutData(gd);

        createPatternInfoContainer(toolkit, containerLeft);

        sectionLeft.setClient(containerLeft);
    }

    private void createPatternInfoContainer(FormToolkit toolkit, Composite containerLeft) {
        Composite patternInfo = toolkit.createComposite(containerLeft, SWT.NONE);
        GridLayout gridLayout = new GridLayout(3, false);
        patternInfo.setLayout(gridLayout);

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        patternInfo.setLayoutData(gd);

        Label nameLabel = toolkit.createLabel(patternInfo, Messages.OverviewPage_sectionLeft_name_label, SWT.WRAP);
        gd = new GridData();
        gd.widthHint = 80;
        nameLabel.setLayoutData(gd);
        nameLabel.setForeground(colors.getColor(IFormColors.TITLE));

        nameText = toolkit.createText(patternInfo, getPattern() == null ? "" : getPattern().getName(), SWT.BORDER); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 20;
        gd.horizontalIndent = 5;
        gd.horizontalSpan = 2;
        nameText.setLayoutData(gd);

        Label fullNameLabel = toolkit.createLabel(patternInfo, Messages.OverviewPage_sectionLeft_fullName_label, SWT.WRAP);
        gd = new GridData();
        gd.widthHint = 80;
        fullNameLabel.setLayoutData(gd);
        fullNameLabel.setForeground(colors.getColor(IFormColors.TITLE));

        Color color = Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY);
        String fullName = PatternHelper.getFullLibraryName(getPattern());

        fullNameText = toolkit.createText(patternInfo, PatternHelper.getFullLibraryName(getPattern()), SWT.BORDER | SWT.READ_ONLY); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalIndent = 5;
        fullNameText.setLayoutData(gd);
        fullNameText.setForeground(color);
        fullNameText.setText(fullName == null ? "" : fullName); //$NON-NLS-1$

        browse = toolkit.createButton(patternInfo, Messages.OverviewPage_button_browse, SWT.PUSH);
        gd = new GridData();
        gd.widthHint = 65;
        browse.setLayoutData(gd);
        browse.setEnabled(false);
        browse.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                ContainerLibrarySelectionDialog dialog = new ContainerLibrarySelectionDialog(new Shell(), getPattern().getContainer());
                dialog.setTitle(Messages.OverviewPage_browse_dialog_title);
                if (dialog.open() == Window.OK) {
                    final PatternLibrary patternLibrary = dialog.getLibraryContainer();
                    TransactionalEditingDomain editingDomain = getEditingDomain();
                    RecordingCommand cmd = new RecordingCommand(editingDomain) {

                        protected void doExecute() {
                            Pattern pattern = getPattern();
                            pattern.setContainer(patternLibrary);
                        }
                    };
                    editingDomain.getCommandStack().execute(cmd);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        Label idLabel = toolkit.createLabel(patternInfo, Messages.OverviewPage_sectionLeft_id_label, SWT.WRAP);
        gd = new GridData();
        idLabel.setLayoutData(gd);
        idLabel.setForeground(colors.getColor(IFormColors.TITLE));

        Text idText = toolkit.createText(patternInfo, getPattern() == null ? "" : getPattern().getID(), SWT.BORDER | SWT.READ_ONLY); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.widthHint = 20;
        gd.horizontalIndent = 5;
        idText.setLayoutData(gd);
        idText.setForeground(color);
    }

    private void createDescriContainer(FormToolkit toolkit, Composite container) {

        Composite containerDesci = toolkit.createComposite(container, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        containerDesci.setLayout(gridLayout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 2;
        containerDesci.setLayoutData(gd);

        Label title = toolkit.createLabel(containerDesci, Messages.OverviewPage_sectionLeft_descripition_label, SWT.WRAP);
        gd = new GridData();
        gd.verticalIndent = 0;
        title.setLayoutData(gd);
        title.setForeground(colors.getColor(IFormColors.TITLE));

        Label desciLabel = toolkit.createLabel(containerDesci, Messages.OverviewPage_sectionLeft_desci_label, SWT.WRAP);
        desciLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

        String patternDescripition = getPattern() == null ? "" : getPattern().getDescription(); //$NON-NLS-1$
        descripition = toolkit.createText(containerDesci, patternDescripition, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 280;
        gd.widthHint = 280;
        gd.verticalIndent = 7;
        gd.horizontalIndent = 3;
        descripition.setLayoutData(gd);
    }

    private void createRightContainer(FormToolkit toolkit, Composite container) {
        Section sectionRight = toolkit.createSection(container, Section.TITLE_BAR);
        sectionRight.setText(Messages.OverviewPage_sectionRight_title);

        GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
        gd.minimumWidth = 300;
        gd.heightHint = 200;
        sectionRight.setLayoutData(gd);

        Composite containerRight = toolkit.createComposite(sectionRight, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        containerRight.setLayout(gridLayout);
        gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
        gd.verticalIndent = 0;
        containerRight.setLayoutData(gd);

        String titletext = Messages.OverviewPage_sectionRight_title_label;
        Label title = toolkit.createLabel(containerRight, titletext, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.widthHint = 100;
        gd.horizontalSpan = 2;
        title.setLayoutData(gd);

        Composite containerLink = toolkit.createComposite(containerRight, SWT.NONE);
        gridLayout = new GridLayout(2, false);
        containerLink.setLayout(gridLayout);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        containerLink.setLayoutData(gd);

        ImageHyperlink specLink = toolkit.createImageHyperlink(containerLink, SWT.NULL);
        specLink.setText(Messages.OverviewPage_sectionRight_specLink_label);
        specLink.setImage(Activator.getDefault().getImage(ImageShop.IMG_LOCALVARIABLE_OBJ));
        gd = new GridData();
        specLink.setLayoutData(gd);
        specLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
            }

            public void linkEntered(HyperlinkEvent e) {
            }

            public void linkActivated(HyperlinkEvent e) {
                editor.setActivePage(SpecificationPage.ID);
            }
        });

        Label specLabel = toolkit.createLabel(containerLink, Messages.OverviewPage_sectionRight_spec_label, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.widthHint = 100;
        specLabel.setLayoutData(gd);

        ImageHyperlink implLink = toolkit.createImageHyperlink(containerLink, SWT.NULL);
        implLink.setText(Messages.OverviewPage_sectionRight_implLink_label);
        implLink.setImage(Activator.getDefault().getImage(ImageShop.IMG_METHPUB_OBJ));
        gd = new GridData();
        gd.verticalIndent = 20;
        implLink.setLayoutData(gd);
        implLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
            }

            public void linkEntered(HyperlinkEvent e) {
            }

            public void linkActivated(HyperlinkEvent e) {
                editor.setActivePage(ImplementationPage.ID);
            }
        });

        Label implLabel = toolkit.createLabel(containerLink, Messages.OverviewPage_sectionRight_impl_label, SWT.WRAP);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.verticalIndent = 18;
        gd.widthHint = 100;
        implLabel.setLayoutData(gd);

        sectionRight.setClient(containerRight);
    }

    void bindName() {
        Pattern pattern = getPattern();
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, nameText);
        IObservableValue mObs = mprop.observe(pattern);

        addBinding(ctx.bindValue(uiObs, mObs, new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {

            public IStatus validate(Object value) {

                return Status.OK_STATUS;
            }
        }), null));
    }

    void bindDescripition() {
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), FcorePackage.Literals.MODEL_ELEMENT__DESCRIPTION);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, descripition);
        IObservableValue mObs = mprop.observe(getPattern());

        addBinding(ctx.bindValue(uiObs, mObs, new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {

            public IStatus validate(Object value) {

                return Status.OK_STATUS;
            }
        }), null));
    }

    void bindContainer() {
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), PatternPackage.Literals.PATTERN_ELEMENT__CONTAINER);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, fullNameText);
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
                if (fromObject == null || !(fromObject instanceof PatternLibrary)) {
                    return ""; //$NON-NLS-1$
                }
                return ((PatternLibrary) fromObject).getName();
            }
        });

        addBinding(ctx.bindValue(uiObs, mObs, targetToModel, modelToTarget));
    }

    @Override
    protected void bind() {
        if (getPattern() != null) {
            bindName();
            bindDescripition();
            bindContainer();
            patternNameEmpetyValidationAdapter = PatternUIHelper.addValidationAdapeter(mmng, getPattern(), ValidationConstants.CONSTRAINTS_PATTERN_NAME_NOT_EMPTY_ID, nameText);
        }
    }

    @Override
    public void dispose() {
        PatternUIHelper.removeAdapterForPattern(getPattern(), patternNameEmpetyValidationAdapter);
        super.dispose();
    }

}
