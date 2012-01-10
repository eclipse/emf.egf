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

package org.eclipse.egf.model.pattern;

/**
 * @author Thomas Guiu
 * 
 */
public interface PatternOutputProcessor {
    String EXTENSION_ID = "org.eclipse.egf.model.trace.output.processor";

    void applyOnLoopResult(Node.Container node);

    void applyOnExecutionResult(Node.Container node);

    String getProcessorId();
}
