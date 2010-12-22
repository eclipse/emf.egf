/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.core.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.natures.EGFNatures;

/**
 * Used to manage Natures and Builders.
 * 
 * @author Thomas Guiu
 * 
 */
public class ProjectHelper {

    public static void addNatures(IProjectDescription description, List<String> natures, IProgressMonitor monitor) {
        Set<String> allNatures = new HashSet<String>();
        allNatures.addAll(natures);
        allNatures.addAll(Arrays.asList(description.getNatureIds()));
        description.setNatureIds(allNatures.toArray(new String[allNatures.size()]));
    }

    private static int indexOf(List<ICommand> buildSpecs, String builder) {
        for (ICommand cmd : buildSpecs) {
            if (builder.equals(cmd.getBuilderName()))
                return buildSpecs.indexOf(cmd);
        }
        return -1;
    }

    public static void addBuilders(IProjectDescription description, List<String> builders, IProgressMonitor monitor) {
        final List<ICommand> buildSpecs = new ArrayList<ICommand>();
        buildSpecs.addAll(Arrays.asList(description.getBuildSpec()));
        for (String newBuilder : builders) {
            int index = indexOf(buildSpecs, newBuilder);
            if (index < 0) {
                final ICommand newCommand = description.newCommand();
                newCommand.setBuilderName(newBuilder);
                buildSpecs.add(newCommand);
                index = buildSpecs.size() - 1;
            }
        }
        int index = indexOf(buildSpecs, EGFNatures.PATTERN_BUILDER_ID);
        if (index > 0) {
            Collections.swap(buildSpecs, index, 0);
        }
        description.setBuildSpec(buildSpecs.toArray(new ICommand[buildSpecs.size()]));
    }

    private ProjectHelper() {

    }
}
