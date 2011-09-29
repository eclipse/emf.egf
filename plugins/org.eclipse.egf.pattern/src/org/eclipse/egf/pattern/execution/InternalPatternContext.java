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

package org.eclipse.egf.pattern.execution;

import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Thomas Guiu
 * 
 */
public interface InternalPatternContext extends PatternContext, BundleAccessor {

    StringBuffer getBuffer();

    StringBuffer getExecutionBuffer();

    int getExecutionCurrentIndex();

    void setExecutionCurrentIndex(int index);

    void clearBuffer();

    Node.Container getNode();

    void setNode(Node.Container node);

    void setReporter(PatternExecutionReporter reporter);

    boolean hasReporter();

    boolean useReporter();

    PatternExecutionReporter getReporter();

}
