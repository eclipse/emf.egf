/**
 *  Copyright (c) 2007, 2009 La Carotte Et Le Baton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      La Carotte Et Le Baton - initial API and implementation
 */
package org.eclipse.egf.common.ui.activator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Base class for plug-ins that integrate with the Eclipse platform UI.<br>
 * 
 * @author fournier
 */
public abstract class EGFAbstractUIPlugin extends AbstractUIPlugin {

    private static final String ICONS_PATH = "$nl$/icons/"; //$NON-NLS-1$ 

    /**
     * Returns the workbench display to be used.
     */
    public static Display getWorkbenchDisplay() {
        return PlatformUI.getWorkbench().getDisplay();
    }

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
     * Get an image descriptor for given key.<br>
     * Images must be located in 'plug-in folder'/icons
     * 
     * @param key_p
     *            the key must be the file name of the related image.
     * @return an {@link ImageDescriptor} or null if not found
     */
    public ImageDescriptor getImageDescriptor(String key_p) {
        ImageRegistry imageRegistry = getImageRegistry();
        ImageDescriptor imageDescriptor = imageRegistry.getDescriptor(key_p);
        if (imageDescriptor == null) {
            imageDescriptor = createImageDescriptor(key_p);
            imageRegistry.put(key_p, imageDescriptor);
        }
        return imageDescriptor;
    }

    /**
     * Get an image for given key.<br>
     * Images must be located in 'plug-in folder'/icons
     * 
     * @param key_p
     *            the key must be the file name of the related image.
     * @return an {@link Image} or null if not found
     */
    public Image getImage(String key_p) {
        ImageRegistry imageRegistry = getImageRegistry();
        Image image = imageRegistry.get(key_p);
        if (image == null) {
            // Create an image descriptor for given id.
            ImageDescriptor imageDescriptor = createImageDescriptor(key_p);
            // Store the (id, imageDescriptor) rather than (id,image)
            // because with storing (id,image) the getDescriptor method will
            // return null in later usage
            // this way, everything is correctly initialized.
            imageRegistry.put(key_p, imageDescriptor);
            // Everything is all right at this step, let's get the real image
            image = imageRegistry.get(key_p);
        }
        return image;
    }

    /**
     * Create an image descriptor for given key.<br>
     * Images must be located in 'plug-in folder'/icons
     * 
     * @param key_p
     *            the key must be the file name of the related image.
     * @return an {@link ImageDescriptor} or null if error occurred
     */
    protected ImageDescriptor createImageDescriptor(String key_p) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(getPluginID(), ICONS_PATH + key_p);
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