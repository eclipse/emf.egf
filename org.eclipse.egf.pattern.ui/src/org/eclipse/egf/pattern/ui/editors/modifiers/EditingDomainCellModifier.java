package org.eclipse.egf.pattern.ui.editors.modifiers;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;

public abstract class EditingDomainCellModifier implements ICellModifier {

    private TransactionalEditingDomain editingDomain;
    private TableViewer tableViewer;

    public EditingDomainCellModifier(TransactionalEditingDomain editingDomain, TableViewer tableViewer) {
        this.editingDomain = editingDomain;
        this.tableViewer = tableViewer;
    }

    public void doModify(final Runnable runnable) {
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            protected void doExecute() {
                runnable.run();
                tableViewer.refresh();
            }
        };
        editingDomain.getCommandStack().execute(cmd);
    }

}
