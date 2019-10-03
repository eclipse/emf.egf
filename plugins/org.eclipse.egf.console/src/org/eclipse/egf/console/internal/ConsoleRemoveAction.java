/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.console.internal;

import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.console.l10n.ConsoleMessages;
import org.eclipse.jface.action.Action;

public class ConsoleRemoveAction extends Action {

    public static final String _id = "org.eclipse.egf.console.internal.ConsoleRemoveAction"; //$NON-NLS-1$  

    ConsoleRemoveAction() {
        super(ConsoleMessages.Console_close);
        setId(_id);
        setImageDescriptor(EGFConsolePlugin.getDefault().getImageDescriptor(IEGFConsoleConstants.IMG_ENABLED_CLOSE_CONSOLE));
        setDisabledImageDescriptor(EGFConsolePlugin.getDefault().getImageDescriptor(IEGFConsoleConstants.IMG_DISABLED_CLOSE_CONSOLE));
    }

    @Override
    public void run() {
        ConsoleFactory.closeConsole();
    }

}
