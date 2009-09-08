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
package org.eclipse.egf.mapping.data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * A MappingElement is a data holder. It stores both sources and targets for a specified {@link EModelElement} instance in a mapping request.<br>
 * Sources contain the specified {@link EModelElement} instance and its sibling {@link EModelElement} elements if any.<br>
 * Targets contain the result of the mapping request.
 * @see MappingServices
 * @author Guillaume Brocard
 */
public class MappingElement {
  /**
   * Set containing the specified {@link EModelElement} in the mapping request + its sibling elements if any.
   */
  private Set<EObject> _sources;
  /**
   * Contain the result of the mapping request.
   */
  private Set<EObject> _targets;

  public MappingElement() {
    _sources = new HashSet<EObject>(0);
    _targets = new HashSet<EObject>(0);
  }

  /**
   * Add given sources to this mapping element.
   * @param sources_p
   */
  public void addSources(Collection<EObject> sources_p) {
    _sources.addAll(sources_p);
  }

  /**
   * Add given targets to this mapping element.
   * @param targets_p
   */
  public void addTargets(Collection<EObject> targets_p) {
    _targets.addAll(targets_p);
  }

  /**
   * Return the specified {@link EModelElement} in a mapping request and it sibling elements if any.
   * @return a not null {@link Collection}.
   */
  public Collection<EObject> getSources() {
    return _sources;
  }

  /**
   * Return the result of a mapping request.
   * @return a not null {@link Collection}.
   */
  public Collection<EObject> getTargets() {
    return _targets;
  }
}