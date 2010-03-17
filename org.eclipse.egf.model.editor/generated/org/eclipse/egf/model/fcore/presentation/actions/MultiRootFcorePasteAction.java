/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.egf.model.fcore.presentation.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.PasteAction;

/**
 * Multi-rooted resources support.
 * This action allows the user to paste a valid element at the resource level.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MultiRootFcorePasteAction extends PasteAction {

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcorePasteAction(EditingDomain domain) {
    super(domain);
  }

  /**
   * Constructor
   * 
   * @param domain
   *          the editing domain
   *          <!-- begin-user-doc -->
   *          <!-- end-user-doc -->
   * @generated
   */
  public MultiRootFcorePasteAction() {
    super();
  }

  /**
   * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#createCommand(java.util.Collection)
   *      <!-- begin-user-doc -->
   *      <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Command createCommand(Collection<?> selection) {
    if (selection == null || selection.size() != 1) {
      return UnexecutableCommand.INSTANCE;
    }
    return MultiRootFcorePasteFromClipboardCommand.create(domain, selection.iterator().next(), null);
  }

}
