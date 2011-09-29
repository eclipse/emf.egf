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
import java.util.List;

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
            builder.append(leaf.getData()).append("\n");
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
            builder.append(leaf.getData());
            return;
        }
        throw new IllegalStateException();
    }

    public static String flatten(Node.Container node) {
        StringBuilder builder = new StringBuilder();
        doFlatten(builder, node, true);
        return builder.toString();
    }

    public static String flattenWithoutCallback(Node.Container node) {
        StringBuilder builder = new StringBuilder();
        doFlatten(builder, node, false);
        return builder.toString();
    }

    public static class Leaf extends Node {
        private String data;

        public Leaf(Node.Container parent, Class patternClass, String data) {
            super(parent, patternClass.getName());
            this.data = data;
            if (data != null && !"".equals(data))
                parent.getChildren().add(this);
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Leaf [data=" + data + "]";
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
