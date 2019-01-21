/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.core.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;

/**
 * Copied from org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider
 * 
 * @author Thomas Guiu
 * 
 */
public class FilteredFileSystemStructureProvider implements IImportStructureProvider {

    private final Set<String> filters = new HashSet<String>();
    private final FilenameFilter filenameFilter = new FilenameFilter() {

        public boolean accept(File dir, String name) {

            return !filters.contains(name);
        }
    };

    protected FilteredFileSystemStructureProvider(String[] filters) {
        super();
        if (filters != null) {
            for (String filter : filters) {
                if (filter != null)
                    this.filters.add(filter);
            }
        }
    }

    public List getChildren(Object element) {
        File folder = (File) element;
        String[] children = folder.list(filenameFilter);
        int childrenLength = children == null ? 0 : children.length;
        List result = new ArrayList(childrenLength);

        for (int i = 0; i < childrenLength; i++) {
            result.add(new File(folder, children[i]));
        }

        return result;
    }

    public InputStream getContents(Object element) {
        try {
            return new FileInputStream((File) element);
        } catch (FileNotFoundException e) {
            IDEWorkbenchPlugin.log(e.getLocalizedMessage(), e);
            return null;
        }
    }

    public String getFullPath(Object element) {
        return ((File) element).getPath();
    }

    public String getLabel(Object element) {

        // Get the name - if it is empty then return the path as it is a file
        // root
        File file = (File) element;
        String name = file.getName();
        if (name.length() == 0) {
            return file.getPath();
        }
        return name;
    }

    public boolean isFolder(Object element) {
        return ((File) element).isDirectory();
    }
}
