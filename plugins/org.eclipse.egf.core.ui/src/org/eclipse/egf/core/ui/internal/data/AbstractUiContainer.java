/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.internal.data;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.graphics.Image;

/**
 * Defines an API to describe an UI container displayed in TreeViewer.
 * @author fournier
 */
public abstract class AbstractUiContainer {
  /**
   * Parent of this container.
   */
  private Object _parent;
  /**
   * Set of children.
   */
  private Set<Object> _children;

  /**
   * Constructor.
   * @param parent_p
   * @param children_p
   */
  protected AbstractUiContainer(Object parent_p, Set<Object> children_p) {
    _parent = parent_p;
    _children = children_p;
  }

  /**
   * Constructor.
   * @param parent_p
   */
  protected AbstractUiContainer(Object parent_p) {
    this(parent_p, new HashSet<Object>(0));
  }

  /**
   * Add a child in the children set.
   * @param child_p
   */
  public boolean addChild(Object child_p) {
    return _children.add(child_p);
  }

  /**
   * Remove a child from the children set.
   * @param child_p
   */
  public boolean removeChild(Object child_p) {
    return _children.remove(child_p);
  }

  /**
   * Return true if this container contains no elements.
   * @return
   */
  public boolean isEmpty() {
    return _children.isEmpty();
  }

  /**
   * Return the parent of this container or null if none.
   * @return
   */
  public Object getParent() {
    return _parent;
  }

  /**
   * Return the children as an array of objects.
   * @return
   */
  public Object[] getChildren() {
    return _children.toArray();
  }

  /**
   * Return whether or not this container has children.
   * @return
   */
  public boolean hasChildren() {
    return !_children.isEmpty();
  }

  /**
   * Return the text used as label for this UI container.
   * @return
   */
  public abstract String getText();

  /**
   * Return the image used as icon for this UI container.<br>
   * Default implementation returns <code>null</code>.
   * @return an image or null if not provided.
   */
  public Image getImage() {
    return null;
  }
}
