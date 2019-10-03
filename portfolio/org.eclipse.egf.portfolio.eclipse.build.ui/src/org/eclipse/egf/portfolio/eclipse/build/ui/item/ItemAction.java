/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.eclipse.build.ui.item;

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CommandAction;

/**
 * @author Matthieu Helleboid
 * 
 */
public abstract class ItemAction extends CommandAction {

    @Override
    protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {
        CompoundCommand compoundCommand = new CompoundCommand();
        for (Object object : collection) {
            compoundCommand.append(new SetCommand(editingDomain, (EObject) object, BuildcorePackage.eINSTANCE.getItem_Enabled(), getNewValue()));
        }
        return compoundCommand;
    }

    protected abstract boolean getNewValue();
}
