/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.common.activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

/**
 * Adds logging methods
 * 
 * @author Guiu
 * 
 */
public abstract class EGFAbstractPlugin extends Plugin {

    public void log(IStatus status) {
        getLog().log(status);
    }

	public void log(String message, Throwable t) {
		getLog().log(newStatus(IStatus.INFO, message, t));
	}

	public void log(Throwable t) {
		getLog().log(newStatus(IStatus.INFO, t.getMessage(), t));
	}

	public void log(String message) {
		getLog().log(newStatus(IStatus.INFO, message, null));
	}

	public void logError(String message, Throwable t) {
		getLog().log(newStatus(IStatus.ERROR, message, t));
	}

	public void logError(Throwable t) {
		getLog().log(newStatus(IStatus.ERROR, t.getMessage(), t));
	}

	public void logError(String message) {
		getLog().log(newStatus(IStatus.ERROR, message, null));
	}

	public void logWarning(String message, Throwable t) {
		getLog().log(newStatus(IStatus.WARNING, message, t));
	}

	public void logWarning(Throwable t) {
		getLog().log(newStatus(IStatus.WARNING, t.getMessage(), t));
	}

	public void logWarning(String message) {
		getLog().log(newStatus(IStatus.WARNING, message, null));
	}

	private IStatus newStatus(int severity, String message, Throwable exception) {
		return new Status(severity, getPluginID(), 0, message, exception);
	}

	/**
	 * Get the plug-in ID according to MANIFEST.MF definition.
	 * 
	 * @return a String containing the plug-in ID.
	 */
	public String getPluginID() {
		return getBundle().getSymbolicName();
	}

}
