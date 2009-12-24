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

package org.eclipse.egf.pattern.query;

import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.PatternContext;

/**
 * @author Thomas Guiu
 * 
 */
public interface QueryManager {

    List<Object> executeQuery(Map<String, String> queryContext, PatternContext context);

}
