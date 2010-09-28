/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.pages;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.PatternUIHelper;
import org.eclipse.egf.pattern.ui.editors.adapter.LiveValidationContentAdapter;
import org.eclipse.egf.pattern.ui.editors.dialogs.ContainerLibrarySelectionDialog;
import org.eclipse.egf.pattern.ui.editors.validation.ValidationConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
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
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

/**
 * @author Thomas Guiu
 */
public class OverviewPage extends PatternEditorPage {

    public static final String ID = "org.eclipse.egf.pattern.ui.editors.pages.overview.page.id"; //$NON-NLS-1$

    private FormEditor editor;

    private Text patternNameText;

    private Text fullLibraryNameText;

    private Text description;

    private Button browse;

    private FormColors colors = new FormColors(Display.getDefault());

    private LiveValidationContentAdapter patternNameEmptyValidationAdapter;

    private IMessageManager messageManager;

    public OverviewPage(FormEditor editor) {
        super(editor, ID, Messages.OverviewPage_title);
        this.editor = editor;
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
        patternNameText.setEnabled(enabled);
        fullLibraryNameText.setEnabled(enabled);
        description.setEnabled(enabled);
        browse.setEnabled(enabled);
    }

    @Override
    protected void doCreateFormContent(IManagedForm managedForm) {

        FormToolkit toolkit = managedForm.getToolkit();
        messageManager = managedForm.getMessageManager();
        ScrolledForm form = managedForm.getForm();
        toolkit.decorateFormHeading(form.getForm());
        Composite body = managedForm.getForm().getBody();

        TableWrapLayout twl = new TableWrapLayout();
        twl.numColumns = 2;
        body.setLayout(twl);
        form.setImage(Activator.getDefault().getImage(ImageShop.IMG_PLUGIN_MF_OBJ));
        form.setText(Messages.OverviewPage_title);

        createLeftContainer(toolkit, body);
        createRightContainer(toolkit, body);
        createDescriptionContainer(toolkit, body);

        form.reflow(true);

    }

    private void createLeftContainer(FormToolkit toolkit, Composite parent) {

        Section section = toolkit.createSection(parent, Section.TITLE_BAR);
        section.setText(Messages.OverviewPage_sectionLeft_title);
        section.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        section.setLayout(new TableWrapLayout());

        Composite container = toolkit.createComposite(section, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        container.setLayout(new TableWrapLayout());

        Label title = toolkit.createLabel(container, Messages.OverviewPage_sectionLeft_title_label, SWT.WRAP);
        title.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        createPatternInfoContainer(toolkit, container);

        section.setClient(container);

    }

    private void createPatternInfoContainer(FormToolkit toolkit, Composite parent) {

        Composite container = toolkit.createComposite(parent, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        container.setLayout(new GridLayout(3, false));

        Label nameLabel = toolkit.createLabel(container, Messages.OverviewPage_sectionLeft_name_label, SWT.WRAP);
        GridData gd = new GridData();
        gd.widthHint = 80;
        nameLabel.setLayoutData(gd);
        nameLabel.setForeground(colors.getColor(IFormColors.TITLE));

        patternNameText = toolkit.createText(container, getPattern() == null ? "" : getPattern().getName(), SWT.BORDER); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 20;
        gd.horizontalIndent = 5;
        gd.horizontalSpan = 2;
        patternNameText.setLayoutData(gd);

        Label fullNameLabel = toolkit.createLabel(container, Messages.OverviewPage_sectionLeft_fullName_label, SWT.WRAP);
        gd = new GridData();
        gd.widthHint = 80;
        fullNameLabel.setLayoutData(gd);
        fullNameLabel.setForeground(colors.getColor(IFormColors.TITLE));

        Color color = Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY);
        String fullLibraryName = PatternHelper.getFullLibraryName(getPattern());
        fullLibraryNameText = toolkit.createText(container, fullLibraryName == null ? "" : fullLibraryName, SWT.BORDER | SWT.READ_ONLY); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalIndent = 5;
        fullLibraryNameText.setLayoutData(gd);
        fullLibraryNameText.setForeground(color);

        browse = toolkit.createButton(container, Messages.OverviewPage_button_browse, SWT.PUSH);
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

                        @Override
                        protected void doExecute() {
                            Pattern pattern = getPattern();
                            pattern.setContainer(patternLibrary);
                        }

                    };
                    editingDomain.getCommandStack().execute(cmd);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        Label idLabel = toolkit.createLabel(container, Messages.OverviewPage_sectionLeft_id_label, SWT.WRAP);
        gd = new GridData();
        idLabel.setLayoutData(gd);
        idLabel.setForeground(colors.getColor(IFormColors.TITLE));

        Text idText = toolkit.createText(container, getPattern() == null ? "" : getPattern().getID(), SWT.BORDER | SWT.READ_ONLY); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        gd.widthHint = 20;
        gd.horizontalIndent = 5;
        idText.setLayoutData(gd);
        idText.setForeground(color);

    }

    private void createDescriptionContainer(FormToolkit toolkit, Composite parent) {

        Section section = toolkit.createSection(parent, Section.TITLE_BAR);
        section.setText(Messages.OverviewPage_sectionLeft_description_label_title);
        TableWrapData twd = new TableWrapData(TableWrapData.FILL);
        twd.colspan = 2;
        section.setLayoutData(twd);
        section.setLayout(new TableWrapLayout());

        Composite container = toolkit.createComposite(section, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        container.setLayout(new TableWrapLayout());

        Label title = toolkit.createLabel(container, Messages.OverviewPage_sectionLeft_description_label, SWT.WRAP);
        title.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        String patternDescription = getPattern() == null ? "" : getPattern().getDescription(); //$NON-NLS-1$
        description = toolkit.createText(container, patternDescription, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
        twd = new TableWrapData(TableWrapData.FILL_GRAB);
        twd.heightHint = 280;
        description.setLayoutData(twd);

        section.setClient(container);

    }

    private void createRightContainer(FormToolkit toolkit, Composite parent) {

        Section section = toolkit.createSection(parent, Section.TITLE_BAR);
        section.setText(Messages.OverviewPage_sectionRight_title);
        section.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        section.setLayout(new TableWrapLayout());

        Composite container = toolkit.createComposite(section, SWT.NONE);
        container.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        container.setLayout(new TableWrapLayout());

        Label title = toolkit.createLabel(container, Messages.OverviewPage_sectionRight_title_label, SWT.WRAP);
        title.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        Composite containerLink = toolkit.createComposite(container, SWT.NONE);
        containerLink.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        TableWrapLayout twl = new TableWrapLayout();
        twl.numColumns = 2;
        containerLink.setLayout(twl);

        ImageHyperlink specLink = toolkit.createImageHyperlink(containerLink, SWT.NONE);
        specLink.setText(Messages.OverviewPage_sectionRight_specLink_label);
        specLink.setImage(Activator.getDefault().getImage(ImageShop.IMG_LOCALVARIABLE_OBJ));
        specLink.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        specLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
                // Nothing to do
            }

            public void linkEntered(HyperlinkEvent e) {
                // Nothing to do
            }

            public void linkActivated(HyperlinkEvent e) {
                editor.setActivePage(SpecificationPage.ID);
            }

        });
        Label specLabel = toolkit.createLabel(containerLink, Messages.OverviewPage_sectionRight_spec_label, SWT.WRAP);
        specLabel.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        ImageHyperlink implLink = toolkit.createImageHyperlink(containerLink, SWT.NONE);
        implLink.setText(Messages.OverviewPage_sectionRight_implLink_label);
        implLink.setImage(Activator.getDefault().getImage(ImageShop.IMG_METHPUB_OBJ));
        implLink.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        implLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
                // Nothing to do
            }

            public void linkEntered(HyperlinkEvent e) {
                // Nothing to do
            }

            public void linkActivated(HyperlinkEvent e) {
                editor.setActivePage(ImplementationPage.ID);
            }

        });
        Label implLabel = toolkit.createLabel(containerLink, Messages.OverviewPage_sectionRight_impl_label, SWT.WRAP);
        implLabel.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        ImageHyperlink selectLink = toolkit.createImageHyperlink(containerLink, SWT.NONE);
        selectLink.setText(Messages.OverviewPage_sectionRight_selectLink_label);
        selectLink.setImage(EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_FCORE));
        selectLink.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        selectLink.addHyperlinkListener(new IHyperlinkListener() {

            public void linkExited(HyperlinkEvent e) {
                // Nothing to do
            }

            public void linkEntered(HyperlinkEvent e) {
                // Nothing to do
            }

            public void linkActivated(HyperlinkEvent e) {
                try {
                    URI uri = EcoreUtil.getURI(getPattern());
                    // Try to open it if any
                    if (uri != null) {
                        // Create or activate an fcore editor
                        IEditorPart part = EditorHelper.openEditor(getPattern().eResource().getResourceSet().getURIConverter().normalize(uri), EGFCoreUIPlugin.FCORE_EDITOR_ID);
                        if (part != null && part instanceof IEditingDomainProvider) {
                            EditorHelper.setSelectionToViewer(part, uri);
                        }
                    }
                } catch (PartInitException pie) {
                    ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), pie);
                }
            }
        });
        Label selectLabel = toolkit.createLabel(containerLink, Messages.OverviewPage_sectionRight_select_label, SWT.WRAP);
        selectLabel.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        section.setClient(container);

    }

    void bindName() {
        Pattern pattern = getPattern();
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, patternNameText);
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
        IObservableValue uiObs = textProp.observeDelayed(400, description);
        IObservableValue mObs = mprop.observe(getPattern());

        addBinding(ctx.bindValue(uiObs, mObs, new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {

            public IStatus validate(Object value) {
                return Status.OK_STATUS;
            }

        }), null));
    }

    void bindContainer() {
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), PatternPackage.Literals.PATTERN__CONTAINER);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, fullLibraryNameText);
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
            patternNameEmptyValidationAdapter = PatternUIHelper.addValidationAdapter(messageManager, getPattern(), ValidationConstants.CONSTRAINTS_PATTERN_NAME_NOT_EMPTY_ID, patternNameText);
        }
        checkReadOnlyModel();
    }

    @Override
    public void dispose() {
        PatternUIHelper.removeAdapterForPattern(getPattern(), patternNameEmptyValidationAdapter);
        colors.dispose();
        super.dispose();
    }

}
