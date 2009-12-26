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

import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.query.QueryKind;
import org.eclipse.egf.pattern.query.QueryManager;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public class QueryHelper {
    public static QueryManager load(BundleAccessor accessor, String queryId) {
        try {
            QueryKind queryKind = QueryManager.INSTANCE.getQueryKind(queryId);
            Bundle bundle = accessor.getBundle(queryKind.getPlatformBundle().getBundleId());
            Class loadClass = bundle.loadClass(QueryManager.INSTANCE.getQueryManagerClassName(queryId));
            return (QueryManager) loadClass.newInstance();
        } catch (Exception e) {
            Activator.getDefault().logError(e);
            throw new QueryException(e);
        }
    }

    static class QueryException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public QueryException(Exception e) {
            super(e);
        }
    }
}
