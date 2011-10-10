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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.RegistryFactory;

/**
 * 
 * orchestration d'un pattern:
 * - methodCall -> ajout d'un dataNode (sans fils)
 * - patternCall, callback, superCall -> Node
 * 
 * @author Thomas Guiu
 * 
 */

public abstract class Node {
    private final Node parent;
    private Pattern pattern;
    private final String patternClass;
    private final Set<String> appliedOutputProcessors = new HashSet<String>();

    protected Node(Node parent, String patternClass) {
        this.parent = parent;
        this.patternClass = patternClass;
    }

    public Node getParent() {
        return parent;
    }

    public Node getContainer(Class cls) {
        if (parent == null)
            return null;
        if (getClass().equals(cls))
            return this;
        return parent.getContainer(cls);
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getPatternClass() {
        return patternClass;
    }

    public Set<String> getAppliedOutputProcessors() {
        return appliedOutputProcessors;
    }

    @Override
    public String toString() {
        return "Node [patternClass=" + patternClass + "]";
    }

    public static String getHierarchy(Node node) {
        StringBuilder builder = new StringBuilder();
        getHierarchy(builder, node, 0);
        return builder.toString();
    }

    public static void getHierarchy(StringBuilder builder, Node node, int nb) {
        for (int n = 0; n < nb; n++)
            builder.append('\t');
        builder.append("[").append(node.getPatternClass()).append("] > \n");
        nb++;
        if (node instanceof Container) {
            Container container = (Container) node;
            for (Node node1 : container.getChildren())
                getHierarchy(builder, node1, nb);
            return;
        }
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            leaf.toString(builder);
            builder.append("\n");
        }

    }

    private static void doFlatten(StringBuilder builder, Node node, boolean deep) {
        if (!deep && node instanceof CallBackContainer) {
            return;
        }
        if (node instanceof Container) {
            Container container = (Container) node;
            for (Node node1 : container.getChildren())
                doFlatten(builder, node1, deep);
            return;
        }
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            leaf.toString(builder);
            return;
        }
        throw new IllegalStateException();
    }

    public static String flatten(Node.Container node) {

        StringBuilder builder = new StringBuilder();
        try {
            for (PatternOutputProcessor traceProcessor : getTraceProcessors()) {
                traceProcessor.execute(node);
            }
        } catch (CoreException e) {
            throw new PatternRuntimeException(e);
        }
        doFlatten(builder, node, true);
        return builder.toString();
    }

    public static String flattenWithoutCallback(Node.Container node) {
        StringBuilder builder = new StringBuilder();
        doFlatten(builder, node, false);
        return builder.toString();
    }

    private static List<PatternOutputProcessor> getTraceProcessors() throws CoreException {
        List<PatternOutputProcessor> result = new ArrayList<PatternOutputProcessor>();
        IExtensionPoint point = RegistryFactory.getRegistry().getExtensionPoint(PatternOutputProcessor.EXTENSION_ID);
        if (point != null) {
            for (IExtension extension : point.getExtensions()) {
                for (IConfigurationElement element : extension.getConfigurationElements()) {
                    result.add((PatternOutputProcessor) element.createExecutableExtension("class"));
                }
            }
        }
        return result;
    }

    // TODO make the class abstract, the toString method too
    public static class Leaf extends Node {

        // TODO to be removed
        public Leaf(Node.Container parent, Class cls, String value) {
            super(parent, null);
        }

        protected Leaf(Node.Container parent, String patternClass) {
            super(parent, patternClass);
        }

        public void toString(StringBuilder builder) {
        }
    }

    public static final class DataLeaf extends Leaf {
        private final String method;
        private String data;

        public DataLeaf(Node.Container parent, Class patternClass, String method, String data) {
            super(parent, patternClass.getName());
            this.method = method;
            this.data = data;
            if (data != null && !"".equals(data))
                parent.getChildren().add(this);
        }

        public String getMethod() {
            return method;
        }

        @Override
        public String toString() {
            return "Leaf [method=" + method + ", data=" + data + " ]";
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public void toString(StringBuilder builder) {
            builder.append(data);
        }

    }

    public static class CallBackContainer extends Container {

        public CallBackContainer(Container parent) {
            super(parent, (String) null);

        }

    }

    public static class SuperOrchestrationContainer extends Container {

        public SuperOrchestrationContainer(Container parent) {
            super(parent, (String) null);

        }

    }

    public static class Container extends Node {
        private final List<Node> children = new ArrayList<Node>();

        public Container(Node.Container parent, Class patternClass) {
            this(parent, patternClass.getName());
        }

        public Container(Node.Container parent, String patternClass) {
            super(parent, patternClass);
            if (parent != null)
                parent.getChildren().add(this);
        }

        public List<Node> getChildren() {
            return children;
        }

    }

}
