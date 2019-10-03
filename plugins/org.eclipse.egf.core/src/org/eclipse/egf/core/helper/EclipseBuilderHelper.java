/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */
package org.eclipse.egf.core.helper;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;

public class EclipseBuilderHelper {

    private EclipseBuilderHelper() {
     // Prevent Instantiation
    }

    public static void removeFromBuildSpec(IProjectDescription description, String builder, IProgressMonitor monitor) {
        SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_removeBuilder, 100);
        Assert.isNotNull(description);
        Assert.isNotNull(builder);
        Assert.isLegal(builder.trim().length() > 0);
        Assert.isNotNull(monitor);
        ICommand[] commands = description.getBuildSpec();
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(builder.trim())) {
                ICommand[] newCommands = new ICommand[commands.length - 1];
                System.arraycopy(commands, 0, newCommands, 0, i);
                System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
                description.setBuildSpec(newCommands);
                break;
            }
        }
        return;
    }

}
