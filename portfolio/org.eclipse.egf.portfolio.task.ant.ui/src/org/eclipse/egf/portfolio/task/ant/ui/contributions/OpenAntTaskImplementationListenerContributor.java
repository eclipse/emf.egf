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
 */
package org.eclipse.egf.portfolio.task.ant.ui.contributions;

import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.portfolio.task.ant.Activator;
import org.eclipse.egf.task.ui.contributions.TaskListenerContributor;

/**
 * @author xiaoru chen
 * 
 */
public class OpenAntTaskImplementationListenerContributor extends TaskListenerContributor {

    @Override
    protected void doDoubleClick(Task task) {
        new OpenAntTaskImplementationMenuContributor.OpenAction(task).run();
    }

    @Override
    protected String getExpectedKind() {
        return Activator.KIND_ANT;
    }

}
