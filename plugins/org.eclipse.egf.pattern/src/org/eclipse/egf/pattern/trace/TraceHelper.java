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

package org.eclipse.egf.pattern.trace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.egf.core.trace.Category;
import org.eclipse.egf.core.trace.Configuration;
import org.eclipse.egf.core.trace.Filter;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Node.DataLeaf;

/**
 * @author Thomas Guiu
 * 
 */
public class TraceHelper {
    public static final TracePreferencesManager PREFERENCES = new TracePreferencesManager();

    private final List<Pattern> patterns;

    private final boolean enable;

    private TraceHelper(boolean enable) {
        this.enable = enable;
        patterns = null;
    }

    private TraceHelper(Configuration configuration) {
        super();
        enable = true;
        // this.configuration = configuration;
        patterns = new ArrayList<Pattern>();
        for (Category cat : configuration.getCategories()) {
            if (cat.isActive()) {
                for (Filter filter : cat.getFilters()) {
                    final String pattern = filter.getPattern();
                    if (pattern != null) {
                        final Pattern compile = Pattern.compile(pattern);
                        patterns.add(compile);
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
        if (matchesPatterns(cls)) {
            final String method = node.getMethod();
            if (method != null)
                cls = cls + ":" + method;
            TraceNode previous = new TraceNode(parent, "[start pattern '" + cls + "']\n");
            TraceNode next = new TraceNode(parent, "[end pattern '" + cls + "']\n");
            parent.getChildren().add(index, previous);
            parent.getChildren().add(index + 2, next);
        }
    }

    private boolean matchesPatterns(String cls) {
        if (patterns == null)
            return true;
        for (Pattern p : patterns) {
            if (p.matcher(cls).matches())
                return true;
        }
        return false;
    }

    private void process(Node node) {
        final String patternClass = node.getPatternClass();
        if (patternClass != null) {
            // for (Pattern pattern : patterns)
            // if (pattern.matcher(patternClass).matches())
            if (node instanceof Node.DataLeaf)
                addTrace((DataLeaf) node);
        }
    }

    public void apply(Node.Container node) {
        if (!enable)
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
