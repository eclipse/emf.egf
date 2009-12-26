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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.Messages;

/**
 * @author Thomas Guiu
 * 
 */
public interface QueryManager {

    List<Object> executeQuery(Map<String, String> queryContext, PatternContext context);

    Helper INSTANCE = new Helper();

    public class Helper {

        public QueryManager loadQuery(String id) {
            QueryKind queryKind = getQueryKind(id);
            if (queryKind == null)
                throw new IllegalStateException(Messages.query_error6);
            // queryKind.getPlatformBundle().

            return null;
        }

        public QueryKind getQueryKindByName(String name) {
            for (QueryKind queryKind : getAvailableQueries()) {
                if (name.equals(queryKind.getName())) {
                    return queryKind;
                }
            }
            return null;
        }

        public QueryKind getQueryKind(String id) {
            for (QueryKind queryKind : getAvailableQueries()) {
                if (id.equals(queryKind.getId())) {
                    return queryKind;
                }
            }
            return null;
        }

        public List<QueryKind> getAvailableQueries() {
            List<QueryKind> queries = new ArrayList<QueryKind>(50);
            for (QueryKind kind : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(QueryKind.class)) {
                queries.add(kind);
            }
            return queries;
        }

        public String getQueryManagerClassName(String queryID) throws PatternException {
            if (queryID == null || "".equals(queryID))
                throw new PatternException(Messages.query_error2);
            for (QueryKind kind : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(QueryKind.class)) {
                if (queryID.equals(kind.getId())) {
                    if (kind.getClassName() == null || "".equals(kind.getClassName()))
                        throw new PatternException(Messages.query_error5);
                    return kind.getClassName();
                }
            }
            throw new PatternException(Messages.bind(Messages.query_error3, queryID));
        }

        private Helper() {
        }
    }

}
