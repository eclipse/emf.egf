/**
 * <copyright>
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
 * </copyright>
 */

package org.eclipse.egf.pattern.trace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.egf.core.trace.Category;
import org.eclipse.egf.core.trace.Configuration;
import org.eclipse.egf.core.trace.Filter;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Node.DataLeaf;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class TraceHelper {
    public static final String DEFAULT_TRACE_PROCESSOR_ID = "default.trace.processor";
    public static final TracePreferencesManager PREFERENCES = new TracePreferencesManager();

    private final Map<Pattern, String> patterns;

    private final boolean enable;

    private TraceHelper(boolean enable) {
        this.enable = enable;
        patterns = null;
    }

    private TraceHelper(Configuration configuration) {
        super();
        enable = true;
        // this.configuration = configuration;
        patterns = new LinkedHashMap<Pattern, String>();
        for (Category cat : configuration.getCategories()) {
            if (cat.isActive()) {
                for (Filter filter : cat.getFilters()) {
                    final String pattern = filter.getPattern();
                    if (pattern != null) {
                        final Pattern compile = Pattern.compile(pattern);
                        patterns.put(compile, filter.getComment());
                    }
                }
            }
        }
    }

    private void addTrace(Node.DataLeaf node) {
        if (!enable)
            return;
        Node.Container parent = (Node.Container) node.getParent();
        if (parent == null)
            return; // this is the root node

        final int index = parent.getChildren().indexOf(node);
        String cls = node.getPatternClass();
        String comment = getComment2use(cls);
        if (comment != null) {
            if ("".equals(comment))
                comment = "[{}]";
            final String method = node.getMethod();
            if (method != null)
                cls = cls + ":" + method;
            String startComment = null;
            String endComment = null;
            if (comment.contains("{}")) {
                final int indexOf = comment.indexOf("{}");
                String begin = comment.substring(0, indexOf);
                String end = comment.substring(indexOf + 2);
                startComment = begin + "begin of pattern '" + cls + "'" + end;
                endComment = begin + "end of pattern '" + cls + "'" + end;
            } else {
                startComment = comment + "begin of pattern '" + cls;
                endComment = comment + "end of pattern '" + cls + "'";
            }
            TraceNode previous = new TraceNode(parent, startComment);
            TraceNode next = new TraceNode(parent, endComment);
            parent.getChildren().add(index, previous);
            parent.getChildren().add(index + 2, next);
        }
    }

    private String getComment2use(String cls) {
        if (patterns == null)
            return "";
        for (Entry<Pattern, String> entry : patterns.entrySet()) {
            Pattern p = entry.getKey();
            if (p.matcher(cls).matches())
                return entry.getValue();
        }
        return null;
    }

    private void process(Node node) {
        node.getAppliedOutputProcessors().add(DEFAULT_TRACE_PROCESSOR_ID);
        final String patternClass = node.getPatternClass();
        if (patternClass != null) {
            // for (Pattern pattern : patterns)
            // if (pattern.matcher(patternClass).matches())
            if (node instanceof Node.DataLeaf)
                addTrace((DataLeaf) node);
        }
    }

    public void apply(Node.Container node) {
        if (!enable || node.getAppliedOutputProcessors().contains(DEFAULT_TRACE_PROCESSOR_ID))
            return;
        process(node);
        for (Node child : new ArrayList<Node>(node.getChildren())) {
            if (child instanceof Node.Container)
                apply((Node.Container) child);
            else
                process(child);
        }
    }

    public static TraceHelper createInstance() throws IOException {
        switch (PREFERENCES.loadState()) {
        case ALWAYS:
            return new TraceHelper(true);
        case FILTERS:
            return new TraceHelper(PREFERENCES.loadConfiguration());
        default:
            return new TraceHelper(false);
        }
    }

    public static class TraceNode extends Node.Leaf {

        private final String message;

        public TraceNode(Node.Container parent, String message) {
            super(parent, null);
            this.message = message;
        }

        @Override
        public String toString() {
            return "Trace [msg=" + message + "]";
        }

        @Override
        public void toString(StringBuilder builder) {
            builder.append(message).append("\n");
        }

    }
}
