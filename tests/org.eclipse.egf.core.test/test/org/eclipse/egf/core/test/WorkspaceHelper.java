/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.ProjectHelper;

/**
 * @author Xavier Maysonnave
 *
 */
public class WorkspaceHelper {

    public static void closeWorkspaceProjects() throws Exception {

        IProject fc = ProjectHelper.getProject("org.eclipse.egf.example.fcs"); //$NON-NLS-1$
        if (fc != null && fc.exists() && fc.isOpen()) {
            fc.close(new NullProgressMonitor());
        }

        IProject h1 = ProjectHelper.getProject("org.eclipse.egf.example.task.h1"); //$NON-NLS-1$
        if (h1 != null && h1.exists() && h1.isOpen()) {
            h1.close(new NullProgressMonitor());
        }

        IProject h2 = ProjectHelper.getProject("org.eclipse.egf.example.task.h2"); //$NON-NLS-1$
        if (h2 != null && h2.exists() && h2.isOpen()) {
            h2.close(new NullProgressMonitor());
        }

    }

    public static void openWorkspaceProjects() throws Exception {

        IProject fc = ProjectHelper.getProject("org.eclipse.egf.example.fcs"); //$NON-NLS-1$
        if (fc != null && fc.exists() && fc.isOpen() == false) {
            fc.open(new NullProgressMonitor());
        }

        IProject h1 = ProjectHelper.getProject("org.eclipse.egf.example.task.h1"); //$NON-NLS-1$
        if (h1 != null && h1.exists() && h1.isOpen() == false) {
            h1.open(new NullProgressMonitor());
        }

        IProject h2 = ProjectHelper.getProject("org.eclipse.egf.example.task.h2"); //$NON-NLS-1$
        if (h2 != null && h2.exists() && h2.isOpen() == false) {
            h2.open(new NullProgressMonitor());
        }

    }

}
