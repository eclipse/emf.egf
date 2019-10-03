/*******************************************************************************
 *  Copyright (c) 2005, 2008 IBM Corporation and others.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.platform.internal.pde;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.ClasspathUtilCore;
import org.eclipse.pde.internal.core.JavadocLocationManager;
import org.eclipse.pde.internal.core.PDECore;

public class PlatformClasspathContainer {

    public class Rule {

        IPath path;

        boolean discouraged;

        @Override
        public boolean equals(Object other) {
            if (other instanceof Rule == false) {
                return false;
            }
            return discouraged == ((Rule) other).discouraged && path.equals(((Rule) other).path);
        }

        @Override
        public String toString() {
            return discouraged ? path.toString() + " [discouraged]" : path.toString(); //$NON-NLS-1$
        }

    }

    private static Map<IPath, IAccessRule> ACCESSIBLE_RULES = new HashMap<IPath, IAccessRule>();

    private static Map<IPath, IAccessRule> DISCOURAGED_RULES = new HashMap<IPath, IAccessRule>();

    private static final IAccessRule EXCLUDE_ALL_RULE = JavaCore.newAccessRule(new Path("**/*"), IAccessRule.K_NON_ACCESSIBLE | IAccessRule.IGNORE_IF_BETTER); //$NON-NLS-1$

    protected void addProjectEntry(IProject project, Rule[] rules, List<IClasspathEntry> entries) throws CoreException {
        if (project.hasNature(JavaCore.NATURE_ID)) {
            IClasspathEntry entry = null;
            if (rules != null) {
                IAccessRule[] accessRules = getAccessRules(rules);
                entry = JavaCore.newProjectEntry(project.getFullPath(), accessRules, true, new IClasspathAttribute[0], false);
            } else {
                entry = JavaCore.newProjectEntry(project.getFullPath());
            }
            if (entries.contains(entry) == false) {
                entries.add(entry);
            }
        }
    }

    public static IClasspathEntry[] getExternalEntries(IPluginModelBase model) {
        List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
        addExternalPlugin(model, new Rule[0], entries);
        return entries.toArray(new IClasspathEntry[entries.size()]);
    }

    protected static void addExternalPlugin(IPluginModelBase model, Rule[] rules, List<IClasspathEntry> entries) {
        // Check whether or not we face a directory or a file
        IPath location = new Path(model.getInstallLocation());
        if (location.toFile() != null && location.toFile().isDirectory() == false) {
            IPath srcPath = ClasspathUtilCore.getSourceAnnotation(model, "."); //$NON-NLS-1$
            if (srcPath == null) {
                srcPath = new Path(model.getInstallLocation());
            }
            addLibraryEntry(new Path(model.getInstallLocation()), srcPath, rules, getClasspathAttributes(model), entries);
        } else {
            // Process Libraries
            IPluginLibrary[] libraries = model.getPluginBase().getLibraries();
            for (int i = 0; i < libraries.length; i++) {
                if (IPluginLibrary.RESOURCE.equals(libraries[i].getType())) {
                    continue;
                }
                // Analyse
                model = (IPluginModelBase) libraries[i].getModel();
                String name = libraries[i].getName();
                String expandedName = ClasspathUtilCore.expandLibraryName(name);
                IPath path = ClasspathUtilCore.getPath(model, expandedName);
                if (path == null && model.isFragmentModel() == false && ClasspathUtilCore.containsVariables(name)) {
                    model = resolveLibraryInFragments(model, expandedName);
                    if (model != null && model.isEnabled())
                        path = ClasspathUtilCore.getPath(model, expandedName);
                }
                if (path != null) {
                    addLibraryEntry(path, ClasspathUtilCore.getSourceAnnotation(model, expandedName), rules, getClasspathAttributes(model), entries);
                }
            }
        }
    }

    public static void addLibraryEntry(IPath path, IPath srcPath, Rule[] rules, IClasspathAttribute[] attributes, List<IClasspathEntry> entries) {
        IClasspathEntry entry = null;
        if (rules != null) {
            entry = JavaCore.newLibraryEntry(path, srcPath, null, getAccessRules(rules), attributes, false);
        } else {
            entry = JavaCore.newLibraryEntry(path, srcPath, null, new IAccessRule[0], attributes, false);
        }
        if (entries.contains(entry) == false) {
            entries.add(entry);
        }
    }

    protected static IAccessRule[] getAccessRules(Rule[] rules) {
        IAccessRule[] accessRules = new IAccessRule[rules.length + 1];
        for (int i = 0; i < rules.length; i++) {
            Rule rule = rules[i];
            accessRules[i] = rule.discouraged ? getDiscouragedRule(rule.path) : getAccessibleRule(rule.path);
        }
        accessRules[rules.length] = EXCLUDE_ALL_RULE;
        return accessRules;
    }

    public static synchronized IAccessRule getAccessibleRule(IPath path) {
        IAccessRule rule = ACCESSIBLE_RULES.get(path);
        if (rule == null) {
            rule = JavaCore.newAccessRule(path, IAccessRule.K_ACCESSIBLE);
            ACCESSIBLE_RULES.put(path, rule);
        }
        return rule;
    }

    public static IClasspathAttribute[] getClasspathAttributes(IPluginModelBase model) {
        JavadocLocationManager manager = PDECore.getDefault().getJavadocLocationManager();
        String location = manager.getJavadocLocation(model);
        if (location == null) {
            return new IClasspathAttribute[0];
        }
        return new IClasspathAttribute[] {
            JavaCore.newClasspathAttribute(IClasspathAttribute.JAVADOC_LOCATION_ATTRIBUTE_NAME, location)
        };
    }

    private static synchronized IAccessRule getDiscouragedRule(IPath path) {
        IAccessRule rule = DISCOURAGED_RULES.get(path);
        if (rule == null) {
            rule = JavaCore.newAccessRule(path, IAccessRule.K_DISCOURAGED);
            DISCOURAGED_RULES.put(path, rule);
        }
        return rule;
    }

    protected static IPluginModelBase resolveLibraryInFragments(IPluginModelBase model, String libraryName) {
        BundleDescription desc = model.getBundleDescription();
        if (desc != null) {
            BundleDescription[] fragments = desc.getFragments();
            for (int i = 0; i < fragments.length; i++) {
                if (new File(fragments[i].getLocation(), libraryName).exists()) {
                    return PluginRegistry.findModel(fragments[i]);
                }
            }
        }
        return null;
    }

}
