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
 * A default tree node interface for tree viewers.<br>
 * Forces the use of tree nodes all along the tree.
 * @author Guillaume Brocard
 */
public interface ITreeNode {
  /**
   * Get children nodes.
   * @return null if none.
   */
  ITreeNode[] getChildren();
  /**
   * Get parent node.
   * @return null if none.
   */
  ITreeNode getParent();
  /**
   * Has current node any children ?
   * @return true if so, false otherwise.
   */
  boolean hasChildren();
  /**
   * Is node handling/representing given element ?
   * @param element_p
   * @return
   */
  boolean isHandling(Object element_p);
  /**
   * An integer value that represents the priority of this kind of node.<br>
   * Should always be the same for objects of the same implementation of {@link ITreeNode}.
   * @return 0 stands for neutral priority.
   */
  int comparisonPriority();
}