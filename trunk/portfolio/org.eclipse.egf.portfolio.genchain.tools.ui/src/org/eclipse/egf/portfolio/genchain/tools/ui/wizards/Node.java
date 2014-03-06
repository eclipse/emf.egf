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

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas Guiu
 * 
 */
public class Node {

    private final List<Node> children = new ArrayList<Node>();
    private String name;
    private int type;
    private final Node parent;
    private final Map<String, String> properties = new HashMap<String, String>();
    private final Map<String, Object> extendedProperties = new HashMap<String, Object>();

    public Node(int type) {
        this(null, type);
    }

    public Node(Node parent, int type) {
        super();
        this.parent = parent;
        this.type = type;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public Map<String, Object> getExtendedProperties() {
        return extendedProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public Node getParent() {
        return parent;
    }

    public boolean is(int otherType) {
        return type == otherType;
    }
}
