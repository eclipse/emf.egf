/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

    final String DEFAULT_TRACE_LITERAL__KEY = "org.eclipse.egf.core.trace.default.literal";

    final String FILTER__KEY = "org.eclipse.egf.core.trace.filters";

}
