/**
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
 */
package org.eclipse.egf.pattern.trace;

/**
 * @author Thomas Guiu
 */
public interface ITracePreferences {
    final String ENABLE_TRACE__KEY = "org.eclipse.egf.core.trace.enable";
    final String ENABLE_TRACE__ALWAYS_VALUE = "always";
    final String ENABLE_TRACE__CONFIGURATION_VALUE = "filter";
    final String ENABLE_TRACE__NEVER_VALUE = "never";

    final String FILTER__KEY = "org.eclipse.egf.core.trace.filters";

}
