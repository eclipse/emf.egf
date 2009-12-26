package org.eclipse.egf.pattern.ui.editors.dialogs;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

public class ParametersEditDialog extends SelectionStatusDialog {

    private Text nameText;

    private Text typeText;

    private Combo queryCombo;

    private String name;

    private String type;

    private String query;

    private TransactionalEditingDomain editingDomain;

    public ParametersEditDialog(Shell shell, Object selectItem, TransactionalEditingDomain editingDomain) {
        super(shell);
        this.editingDomain = editingDomain;
        if (selectItem instanceof PatternParameter) {
            PatternParameter selection = (PatternParameter) selectItem;
            name = selection.getName();

            String itemType = selection.getType();
            type = ParametersTableLabelProvider.getType(itemType);

            Query itemQuery = selection.getQuery();
            query = itemQuery == null ? "" : itemQuery.getExtensionId(); //$NON-NLS-1$
        }
    }

    @Override
    protected void computeResult() {
    }

    protected Control createDialogArea(Composite parent) {
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        dialogArea.setLayout(layout);

        createLabel(dialogArea, Messages.ParametersEditDialog_Name);
        nameText = new Text(dialogArea, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        nameText.setLayoutData(gd);
        nameText.setText(name);
        nameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                name = nameText.getText();
            }
        });

        createLabel(dialogArea, Messages.ParametersEditDialog_Type);
        typeText = new Text(dialogArea, SWT.READ_ONLY | SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        typeText.setLayoutData(gd);
        typeText.setText(type);
        typeText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                type = typeText.getText();
            }
        });
        Button typeButton = new Button(dialogArea, SWT.PUSH);
        gd = new GridData();
        typeButton.setLayoutData(gd);
        typeButton.setText(Messages.ParametersEditDialog_Browse);
        typeButton.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                OpenTypeWizard wizard = new OpenTypeWizard(editingDomain, typeText.getText());
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                int returnValue = dialog.open();
                if (Window.OK == returnValue) {
                    typeText.setText(wizard.getSelectType());
                }

            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        createLabel(dialogArea, Messages.ParametersEditDialog_Query);
        queryCombo = new Combo(dialogArea, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        queryCombo.setLayoutData(gd);
        queryCombo.add(query);
        setQueryComboList(queryCombo, query);
        queryCombo.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                query = queryCombo.getText();
            }
        });
        queryCombo.select(0);
        return dialogArea;
    }

    private Label createLabel(Composite parent, String content) {
        Label label = new Label(parent, SWT.NONE);
        label.setText(content);
        return label;
    }

    private void setQueryComboList(Combo combo, String query) {
        for (QueryKind kind : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(QueryKind.class)) {
            String id = kind.getId();
            if (!id.equals(query)) {
                combo.add(id);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }
}
