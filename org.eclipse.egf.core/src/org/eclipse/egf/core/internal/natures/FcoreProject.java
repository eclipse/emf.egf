/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */

package org.eclipse.egf.core.internal.natures;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.helper.EclipseBuilderHelper;
import org.eclipse.egf.core.natures.EGFNatures;

public class FcoreProject extends BaseProject {

  /**
   * FcoreNature constructor comment.
   */
  public FcoreProject() {
    super();
  }

  public void configure() throws CoreException {
    IProjectDescription description = getProject().getDescription();
    EclipseBuilderHelper.addToFrontOfBuildSpec(description, EGFNatures.PATTERN_BUILDER_ID, new NullProgressMonitor());
    getProject().setDescription(description, new NullProgressMonitor());
  }

  public void deconfigure() throws CoreException {
    IProjectDescription description = getProject().getDescription();
    EclipseBuilderHelper.removeFromBuildSpec(description, EGFNatures.PATTERN_BUILDER_ID, new NullProgressMonitor());
    getProject().setDescription(description, new NullProgressMonitor());
  }

}
