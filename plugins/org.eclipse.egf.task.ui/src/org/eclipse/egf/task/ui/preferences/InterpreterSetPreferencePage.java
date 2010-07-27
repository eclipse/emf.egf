/**
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
 */

package org.eclipse.egf.task.ui.preferences;

import java.io.File;

import org.eclipse.egf.task.ui.EGFTaskUIPlugin;
import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
import org.eclipse.egf.task.ui.preferences.constants.PreferenceConstants;
import org.eclipse.egf.task.ui.preferences.fieldEditors.JRubyInstallPathFieldEditor;
import org.eclipse.egf.task.ui.preferences.fieldEditors.RubyVMLibraryPathsEditor;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author xiaoru chen
 * 
 */
public class InterpreterSetPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private BooleanFieldEditor booleanFieldEditor;
    private DirectoryFieldEditor rubyInstallPathFieldEditor;
    private RubyVMLibraryPathsEditor rubyLibrariesEditor;
    private Composite fieldEditorParent;
    public String[] jrubyVMSuffixes = new String[] { PreferenceConstants.JRUBY_VM_path, PreferenceConstants.JRUBY_VM_SITE_RUBY_PATH, PreferenceConstants.JRUBY_VM_SITE_RUBY_SHARED_PATH };

    public InterpreterSetPreferencePage() {
        super(GRID);
        setPreferenceStore(EGFTaskUIPlugin.getDefault().getPreferenceStore());
        String indicateLabel = EGFTaskUIMessages.InterpreterSetPreferencePage_indicate_label_text_1 + "\r" + EGFTaskUIMessages.InterpreterSetPreferencePage_indicate_label_text_2 + EGFTaskUIMessages.InterpreterSetPreferencePage_indicate_label_text_3 + EGFTaskUIMessages.InterpreterSetPreferencePage_indicate_label_text_4; //$NON-NLS-2$
        setDescription(indicateLabel);
    }

    /**
     * Creates the field editors. Field editors are abstractions of the common
     * GUI blocks needed to manipulate various types of preferences. Each field
     * editor knows how to save and restore itself.
     */
    public void createFieldEditors() {
        fieldEditorParent = getFieldEditorParent();

        booleanFieldEditor = new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN, EGFTaskUIMessages.InterpreterSetPreferencePage_boolean_field_editor_label_text, fieldEditorParent);
        addField(booleanFieldEditor);

        rubyInstallPathFieldEditor = new JRubyInstallPathFieldEditor(PreferenceConstants.P_RUBY_PATH, "", fieldEditorParent); //$NON-NLS-1$
        addField(rubyInstallPathFieldEditor);

        rubyLibrariesEditor = new RubyVMLibraryPathsEditor(PreferenceConstants.P_RUBY_LIBRARIES, "  " + EGFTaskUIMessages.InterpreterSetPreferencePage_rubyVM_library_paths_editor_label_text + ":", EGFTaskUIMessages.InterpreterSetPreferencePage_rubyVM_library_paths_editor_label_text, fieldEditorParent); //$NON-NLS-1$ //$NON-NLS-3$
        addField(rubyLibrariesEditor);

        initializeFieldStatus();

    }

    /**
     * When enter the preference page, refresh the field status;
     */
    protected void initializeFieldStatus() {
        IPreferenceStore store = EGFTaskUIPlugin.getDefault().getPreferenceStore();
        boolean useDefaultRuby = store.getBoolean(PreferenceConstants.P_BOOLEAN);
        setRubySetFieldEnable(!useDefaultRuby, fieldEditorParent);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

        if (event.getSource() instanceof BooleanFieldEditor) {
            setRubySetFieldEnable(!booleanFieldEditor.getBooleanValue(), fieldEditorParent);
        }
        if (event.getSource() instanceof DirectoryFieldEditor) {
            updateLibrariesEditor();
        }
        super.propertyChange(event);
    }

    /**
     * Update the list in the rubyLibrariesEditor.
     */
    protected void updateLibrariesEditor() {
        String jrubyVMPrefix = rubyInstallPathFieldEditor.getStringValue();
        List list = rubyLibrariesEditor.getListControl(fieldEditorParent);
        list.removeAll();
        for (int i = 0; i < jrubyVMSuffixes.length; i++) {
            String LibrariesPath = jrubyVMPrefix + jrubyVMSuffixes[i];
            if (isFile(LibrariesPath)) {
                list.add(LibrariesPath);
            }
        }
        checkLibraryList(list);
    }

    /**
     * Check whether the list in the rubyLibrariesEditor is empty.
     * 
     * @param list
     */
    public void checkLibraryList(List list) {
        if (list.getItemCount() == 0) {
            setValid(false);
            setErrorMessage(EGFTaskUIMessages.InterpreterSetPreferencePage_libraries_empty_error_message);
        } else {
            setValid(true);
            setErrorMessage(null);
        }
    }

    protected boolean isFile(String librariesPath) {
        File file = new File(librariesPath);
        return file.exists();
    }

    @Override
    protected void performDefaults() {
        setRubySetFieldEnable(false, fieldEditorParent);
        super.performDefaults();
    }

    public void setRubySetFieldEnable(boolean enabled, Composite parent) {
        rubyInstallPathFieldEditor.setEnabled(enabled, parent);
        rubyLibrariesEditor.setEnabled(enabled, parent);
        setValid(!enabled);
        if (enabled)
            checkLibraryList(rubyLibrariesEditor.getListControl(parent));
    }

    @Override
    public void setValid(boolean b) {
        super.setValid(b);
        if (b)
            setErrorMessage(null);
    }

}