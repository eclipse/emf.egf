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

package org.eclipse.egf.core.ui;

import java.util.List;

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.egf.core.ui.contributor.EditorListenerContributor;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.core.ui.contributor.IMenuEditorActionBarContributor;
import org.eclipse.egf.core.ui.contributor.PropertyEditorContributor;
import org.eclipse.egf.core.ui.internal.registry.EditorListenerContributorRegistry;
import org.eclipse.egf.core.ui.internal.registry.EditorMenuContributorRegistry;
import org.eclipse.egf.core.ui.internal.registry.PropertyEditorContributorRegistry;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFCoreUIPlugin extends EGFAbstractUIPlugin {

    /**
     * Duplicate id for decoupling reason
     */
    public static final String FCORE_EDITOR_ID = "org.eclipse.egf.model.fcore.presentation.fcore.editor.id"; //$NON-NLS-1$

    /**
     * Keep track of the EditorListenerContributorRegistry
     */
    private static EditorListenerContributorRegistry __editorListenerContributorRegistry;

    /**
     * Keep track of the EditorMenuContributorRegistry
     */
    private static EditorMenuContributorRegistry __editorMenuContributorRegistry;

    /**
     * Keep track of the PropertyEditorContributorRegistry
     */
    private static PropertyEditorContributorRegistry __propertyEditorContributorRegistry;

    /**
     * The shared instance
     */
    private static EGFCoreUIPlugin __plugin;

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EGFCoreUIPlugin getDefault() {
        return __plugin;
    }

    /**
     * 
     * Returns the currently active window for this workbench (if any). Returns
     * <code>null</code> if there is no active workbench window. Returns
     * <code>null</code> if called from a non-UI thread.
     * 
     * @return the active workbench window, or <code>null</code> if there is
     *         no active workbench window or if called from a non-UI thread
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        return getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    /**
     * Returns the currently active shell for this workbench (if any).
     * 
     * @return the active workbench shell.
     */
    public static Shell getActiveWorkbenchShell() {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = getDefault().getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0].getShell();
            }
        } else {
            return window.getShell();
        }
        return null;
    }

    /**
     * Get editor listener contributors implementations.
     * 
     * @return an empty list if none could be found.
     */
    public static List<EditorListenerContributor> getEditorListenerContributors() {
        if (__editorListenerContributorRegistry == null) {
            __editorListenerContributorRegistry = new EditorListenerContributorRegistry();
        }
        return __editorListenerContributorRegistry.getEditorListenerContributors();
    }

    /**
     * Create editor menu contributors implementations.
     * 
     * @return an empty list if none could be found.
     */
    public static List<EditorMenuContributor> createEditorMenuContributors(IMenuEditorActionBarContributor parent) {
        if (__editorMenuContributorRegistry == null) {
            __editorMenuContributorRegistry = new EditorMenuContributorRegistry();
        }
        return __editorMenuContributorRegistry.createEditorMenuContributors(parent);
    }

    /**
     * Dispose editor menu contributors implementations.
     */
    public static void disposeEditorMenuContributors(IMenuEditorActionBarContributor parent) {
        if (__editorMenuContributorRegistry == null) {
            return;
        }
        __editorMenuContributorRegistry.disposeEditorMenuContributors(parent);
    }

    /**
     * Create property editor contributors implementations.
     * 
     * @return an empty list if none could be found.
     */
    public static PropertyEditorContributor selectPropertyEditor(Object object, IItemPropertyDescriptor descriptor) {
        if (__propertyEditorContributorRegistry == null) {
            __propertyEditorContributorRegistry = new PropertyEditorContributorRegistry();
        }
        return __propertyEditorContributorRegistry.selectPropertyEditor(object, descriptor);
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        if (__editorListenerContributorRegistry != null) {
            __editorListenerContributorRegistry.dispose();
            __editorListenerContributorRegistry = null;
        }
        if (__editorMenuContributorRegistry != null) {
            __editorMenuContributorRegistry.dispose();
            __editorMenuContributorRegistry = null;
        }
        if (__propertyEditorContributorRegistry != null) {
            __propertyEditorContributorRegistry.dispose();
            __propertyEditorContributorRegistry = null;
        }
        super.stop(context);
        __plugin = null;
    }

}
