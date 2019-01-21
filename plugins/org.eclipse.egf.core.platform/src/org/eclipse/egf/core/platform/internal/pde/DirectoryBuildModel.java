/**
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
 */
package org.eclipse.egf.core.platform.internal.pde;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.pde.core.IEditableModel;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.build.Build;
import org.eclipse.pde.internal.core.build.BuildModel;

public class DirectoryBuildModel extends BuildModel implements IEditableModel {

    private static final long serialVersionUID = 1L;

    private File _file;

    public DirectoryBuildModel(File file) {
        _file = file;
    }

    public String getContents() {
        StringWriter swriter = new StringWriter();
        PrintWriter writer = new PrintWriter(swriter);
        save(writer);
        writer.flush();
        try {
            swriter.close();
            writer.close();
        } catch (IOException e) {
            PDECore.logException(e);
        }
        return swriter.toString();
    }

    public boolean isDirty() {
        return false;
    }

    public boolean isEditable() {
        return true;
    }

    @Override
    public void load() {
        if (_file.exists()) {
            InputStream stream = null;
            try {
                stream = new FileInputStream(_file);
                load(stream, false);
            } catch (Exception e) {
                PDECore.logException(e);
            } finally {
                try {
                    if (stream != null)
                        stream.close();
                } catch (IOException e) {
                    PDECore.logException(e);
                }
            }
        } else {
            fBuild = new Build() {

                @Override
                public IBuildModel getModel() {
                    return DirectoryBuildModel.this;
                }

            };
            setLoaded(true);
        }
    }

    public boolean isInSync() {
        return true;
    }

    @Override
    protected void updateTimeStamp() {
        // Do nothing
    }

    public void save() {
        // Do nothing
    }

    public void save(PrintWriter writer) {
        getBuild().write("", writer); //$NON-NLS-1$
    }

    public void setDirty(boolean dirty) {
        // Do nothing
    }

    public void setEditable(boolean editable) {
        // Do nothing
    }

    /* (non-Javadoc)
     * @see org.eclipse.pde.core.build.IBuildModel#getInstallLocation()
     */
    public String getInstallLocation() {
        return null;
    }

}
