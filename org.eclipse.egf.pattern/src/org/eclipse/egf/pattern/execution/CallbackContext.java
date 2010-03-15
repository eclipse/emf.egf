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

package org.eclipse.egf.pattern.execution;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Thomas Guiu
 * 
 */
public class CallbackContext extends DefaultPatternContext implements InternalPatternContext {

    private final StringBuilder buffer = new StringBuilder(1000);

    public CallbackContext(InternalPatternContext parent) {
        super((PatternContext) parent);

    }

    public StringBuilder getBuffer() {

        return buffer;
    }

    public PatternExecutionReporter getReporter() {

        return getParent().getReporter();
    }

    public boolean hasReporter() {

        return getParent().hasReporter();
    }

    public void setReporter(PatternExecutionReporter reporter) {
        throw new UnsupportedOperationException("unexpected");
    }

    public boolean useReporter() {

        return true;
    }

    private InternalPatternContext getParent() {
        return (InternalPatternContext) parent;
    }
}
