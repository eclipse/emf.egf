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

package org.eclipse.egf.task.ui.contributions;

import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.editor.contributions.AbstractTypeEditorContributor;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractTaskEditorContributor extends AbstractTypeEditorContributor {

  private final String _kind;

  protected AbstractTaskEditorContributor(String kind) {
    super();
    _kind = kind;
    if (kind == null) {
      throw new IllegalArgumentException();
    }
  }

  public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
    // It should be a Task in a non null resource
    if (object instanceof Task == false || ((Task) object).eResource() == null) {
      return false;
    }
    // Check Current Feature
    if (checkFeature(object, descriptor, FtaskPackage.Literals.TASK__IMPLEMENTATION)) {
      Task task = (Task) object;
      return getKind().equals(task.getKindValue());
    }
    return false;
  }

  @Override
  protected String getValue(Object object) {
    return ((Task) object).getImplementation();
  }

  @Override
  protected String getFilteredType(Object object) {
    return ITaskProduction.class.getName();
  }

  protected String getKind() {
    return _kind;
  }

}
