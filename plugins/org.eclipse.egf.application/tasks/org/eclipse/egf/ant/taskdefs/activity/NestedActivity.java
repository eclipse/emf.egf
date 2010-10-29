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
package org.eclipse.egf.ant.taskdefs.activity;

import org.apache.tools.ant.BuildException;
import org.eclipse.egf.ant.taskdefs.NestedElement;
import org.eclipse.egf.application.internal.l10n.ApplicationMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class NestedActivity extends NestedElement {

    private boolean _isRuntime;

    private String _uri;

    public NestedActivity() {
        // Nothing to do
    }

    public void setRuntime(boolean isRuntime) {
        _isRuntime = isRuntime;
    }

    public boolean isRuntime() {
        return _isRuntime;
    }

    public void setUri(String uri) {
        if (uri != null && uri.trim().length() != 0) {
            _uri = uri.trim();
        }
    }

    public URI getUri() {
        return URI.createURI(_uri);
    }

    @Override
    public void checkAttributes() throws BuildException {
        assertTrue("Activity 'uri' must be specified.", _uri != null); //$NON-NLS-1$
        try {
            getUri();
        } catch (Throwable t) {
            throw new BuildException(NLS.bind(ApplicationMessages.NestedActivity_Invalid_URI_Attribute, _uri), t);
        }
    }

}
