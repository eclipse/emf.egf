/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern;

import java.util.List;

/**
 * @author Thomas Guiu
 * 
 */
public interface DomainVisitor {

    Object[] getChildren(Object model);

    void setPatterns(List<Pattern> patterns) throws PatternException;

    void visit(PatternContext context, Object model) throws PatternException;

    void dispose();

}
