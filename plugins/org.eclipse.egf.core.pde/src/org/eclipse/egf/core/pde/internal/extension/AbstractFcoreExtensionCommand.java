/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.pde.internal.extension;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.fcore.IPlatformFcoreConstants;
import org.eclipse.egf.core.pde.plugin.AbstractExtensionChangesCommand;
import org.eclipse.emf.common.util.URI;

/**
 * Base class to implement commands that deal with 'fcore' extension-point.
 * 
 * @author Xavier Maysonnave
 */
public abstract class AbstractFcoreExtensionCommand extends AbstractExtensionChangesCommand {

    public IPath _path;

    /**
     * Constructor.
     * 
     * @param uri
     */
    protected AbstractFcoreExtensionCommand(IPath path) throws CoreException {
        super(ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0)));
        _path = path;
    }

    /**
     * @see org.eclipse.egf.core.pde.plugin.AbstractExtensionChangesCommand#getExtensionChildName()
     */
    @Override
    protected String getExtensionChildName() {
        return IPlatformFcoreConstants.FCORE_EXTENSION_CHILD;
    }

    /**
     * @see org.eclipse.egf.core.pde.plugin.AbstractExtensionChangesCommand#getExtensionPointId()
     */
    @Override
    protected String getExtensionPointId() {
        return IPlatformFcoreConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
    }

    /**
     * Get the id attribute of the children for the extension.
     * 
     * @return
     */
    @Override
    protected String getExtensionChildAttribute() {
        return "id"; //$NON-NLS-1$
    }

    @Override
    protected boolean matchValue(String value) {
        if (value == null || value.trim().length() == 0) {
            return false;
        }
        URI uri = URIHelper.getPlatformPluginURI(getBundleId(), URI.decode(value), false);
        if (uri.equals(getURI())) {
            return true;
        }
        return false;
    }

    @Override
    public String getValue() {
        return _path.removeFirstSegments(1).makeRelative().toString();
    }

    /**
     * Get the Fcore URI.
     * 
     * @return
     */
    protected URI getURI() {
        return URIHelper.getPlatformPluginURI(_path);
    }

}
