/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.internal.registry.PatternExtensionRegistry;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Guiu
 */
public class EGFPatternPlugin extends EGFAbstractPlugin {

    /**
     * Keep track of the PatternExtensionRegistry
     */
    private static PatternExtensionRegistry __patternExtensionRegistry;

    // The shared instance
    private static EGFPatternPlugin __plugin;

    /**
     * Returns known PatternNatures
     * @return a List<PatternNature>
     */
    public static Set<String> getPatternNatures() {
        if (__patternExtensionRegistry == null) {
            __patternExtensionRegistry = new PatternExtensionRegistry();
        }
        return __patternExtensionRegistry.getPatternNatures();
    }

    /**
     * Returns an PatternExtension based on a PatterNature
     * @return a PatternExtension
     * 
     */
    public static PatternExtension getPatternExtension(PatternNature nature) throws CoreException {
        if (nature == null) {
            return null;
        }
        if (__patternExtensionRegistry == null) {
            __patternExtensionRegistry = new PatternExtensionRegistry();
        }
        return __patternExtensionRegistry.getPatternExtension(nature);
    }

    /**
     * Returns an PatternExtension based on a PatternNature name
     * @return a PatternExtension
     */
    public static PatternExtension getPatternExtension(String name) throws CoreException {
        if (name == null) {
            return null;
        }
        if (__patternExtensionRegistry == null) {
            __patternExtensionRegistry = new PatternExtensionRegistry();
        }
        return __patternExtensionRegistry.getPatternExtension(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * 
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        if (__patternExtensionRegistry != null) {
            __patternExtensionRegistry.dispose();
            __patternExtensionRegistry = null;
        }
        super.stop(context);
        __plugin = null;
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EGFPatternPlugin getDefault() {
        return __plugin;
    }

}
