/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model.editor.actions;

import java.util.Collection;

import org.eclipse.egf.model.fcore.commands.resource.FcoreResourcePasteFromClipboardCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Multi-rooted resources support.
 * This action allows the user to paste a valid element at the resource level.
 */
public class FcoreResourcePasteAction extends PasteAction {

    /**
     * Constructor
     */
    public FcoreResourcePasteAction() {
        super();
    }

    /**
     * @since 2.1.0
     */
    @Override
    public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
        super.setActiveWorkbenchPart(workbenchPart);
        domain = null;
        if (workbenchPart instanceof IEditingDomainProvider) {
            domain = ((IEditingDomainProvider) workbenchPart).getEditingDomain();
        }
    }

    /**
     * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#createCommand(java.util.Collection)
     */
    @Override
    public Command createCommand(Collection<?> selection) {
        if (selection == null || selection.size() != 1) {
            return UnexecutableCommand.INSTANCE;
        }
        return FcoreResourcePasteFromClipboardCommand.create(domain, selection.iterator().next(), null);
    }

}
