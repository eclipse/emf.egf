package org.eclipse.egf.portfolio.eclipse.build.ui.deploy;

import java.util.ArrayList;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.presentation.BuildCoreEditorPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DeployDialog extends Dialog {

	private String actionLabel;

	private Combo serverUrlCombo;

	private Combo jobNameCombo;

	private String serverUrl;

	private String jobName;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public DeployDialog(Shell parentShell, String actionLabel, String initialServerUrl, String initialJobName) {
		super(parentShell);
		this.actionLabel = actionLabel;
		this.serverUrl = initialServerUrl;
		this.jobName = initialJobName;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(2, false);
		gl_container.marginBottom = 5;
		gl_container.marginTop = 5;
		gl_container.marginRight = 5;
		gl_container.marginLeft = 5;
		container.setLayout(gl_container);
		
		Label actionLabel = new Label(container, SWT.NONE);
		actionLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		actionLabel.setText(this.actionLabel);
		
		Label serverUrlLabel = new Label(container, SWT.NONE);
		GridData gd_ServerUrlLabel = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_ServerUrlLabel.widthHint = 77;
		serverUrlLabel.setLayoutData(gd_ServerUrlLabel);
		serverUrlLabel.setText("Server URL :");
		
		serverUrlCombo = new Combo(container, SWT.NONE);
		serverUrlCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label jobNameLabel = new Label(container, SWT.NONE);
		jobNameLabel.setText("Job name :");
		
		jobNameCombo = new Combo(container, SWT.NONE);
		jobNameCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		loadSettings();
		
		return container;
	}

	public String getServerUrl() {
		return serverUrl;
	}
	
	public String getJobName() {
		return jobName;
	}
	
	private void loadSettings() {
		loadCombo(serverUrlCombo, serverUrl, "deployServerUrls");
		loadCombo(jobNameCombo, jobName, "deployJobNames");
	}

	private void loadCombo(Combo combo, String initialValue, String settingsFieldName) {
		ArrayList<String> values = new ArrayList<String>();
		values.add(initialValue);
		
		String[] settingsValues = BuildCoreEditorPlugin.getPlugin().getDialogSettings().getArray(settingsFieldName);
		if (settingsValues != null) {
			for (String value : settingsValues) {
				if (!values.contains(value))
					values.add(value);
			}
		}
		
		combo.setItems(values.toArray(new String[0]));
		combo.select(0);
	}
	
	private void saveSettings() {
		serverUrl = saveCombo(serverUrlCombo, "deployServerUrls");
		jobName = saveCombo(jobNameCombo, "deployJobNames");
	}

	private String saveCombo(Combo combo, String settingsFieldName) {
		ArrayList<String> values = new ArrayList<String>();
		values.add(combo.getText());
		
		for (String value : combo.getItems()) {
			if (!values.contains(value))
				values.add(value);
		}
		
		BuildCoreEditorPlugin.getPlugin().getDialogSettings().put(settingsFieldName, values.toArray(new String[0]));
		
		return values.get(0);
	}

	@Override
	protected void okPressed() {
		saveSettings();
		super.okPressed();
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(483, 158);
	}

}
