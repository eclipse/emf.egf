/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
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
public interface IQuery {

    List<Object> execute(ParameterDescription parameter, Map<String, String> queryCtx, PatternContext context);

    Helper INSTANCE = new Helper();

    public class ParameterDescription {

        private String name;

        private String type;

        public ParameterDescription(String name, String type) {
            super();
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

    }

    public class Helper {

        public IQuery loadQuery(String id) {
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

        public String getQueryClassName(String queryID) throws PatternException {
            if (queryID == null || "".equals(queryID)) //$NON-NLS-1$
                throw new PatternException(Messages.query_error2);
            for (QueryKind kind : EGFPlatformPlugin.getPlatformManager().getPlatformExtensionPoints(QueryKind.class)) {
                if (queryID.equals(kind.getId())) {
                    if (kind.getClassName() == null || "".equals(kind.getClassName())) //$NON-NLS-1$
                        throw new PatternException(Messages.query_error5);
                    return kind.getClassName();
                }
            }
            throw new PatternException(Messages.bind(Messages.query_error3, queryID));
        }

        private Helper() {
            // Nothing to do
        }
    }

}
