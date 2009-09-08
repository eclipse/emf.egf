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
package org.eclipse.egf.common.ui.viewers;

/**
 * A default abstract implementation of the tree node.<br>
 * Parent node is as specified at construction time.<br>
 * By default assumes that there is no child, thus returns null to {@link #getChildren()} implementation.
 * @author t007626
 */
public abstract class DefaultTreeNode implements ITreeNode {
  /**
   * Parent tree node.
   */
  private ITreeNode _parent;

  /**
   * Constructor.
   * @param parent_p
   */
  public DefaultTreeNode(ITreeNode parent_p) {
    _parent = parent_p;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.ITreeNode#getChildren()
   */
  public ITreeNode[] getChildren() {
    return null;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.ITreeNode#getParent()
   */
  public ITreeNode getParent() {
    return _parent;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.ITreeNode#hasChildren()
   */
  public boolean hasChildren() {
    return true;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.ITreeNode#isHandling(java.lang.Object)
   */
  public boolean isHandling(Object element_p) {
    return false;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.ITreeNode#comparisonPriority()
   */
  public int comparisonPriority() {
    return 0;
  }
}
