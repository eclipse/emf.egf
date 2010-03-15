/**
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 */

package org.eclipse.egf.core.internal.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.PlatformObject;


/**
 */
public abstract class BaseProject extends PlatformObject implements IProjectNature {

  private IProject _project;

  public BaseProject() {
    super();
  }
  
  public IProject getProject() {
    return _project;
  }  
  
  public void setProject(IProject project_p) {
    _project = project_p;
  }
  
}
