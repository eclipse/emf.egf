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

package org.eclipse.egf.core.test.pattern.inheritance_2;

import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.EclipseFileReporter;

/**
 * @author Matthieu Helleboid
 * 
 */
public class Inheritance_2_Reporter extends EclipseFileReporter {

    public void executionFinished(String output, PatternContext context) {
    }

    public void loopFinished(String output, PatternContext context, Map<String, Object> parameterValues) {
        String targetFile = (String) context.getValue("targetFile");
        String targetDirectory = new Path(targetFile).removeLastSegments(1).toString();
        writeOutput(output, targetDirectory, targetFile);
    }

}
