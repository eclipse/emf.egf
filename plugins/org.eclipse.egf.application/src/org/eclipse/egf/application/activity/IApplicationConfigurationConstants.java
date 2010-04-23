/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.application.activity;

import org.eclipse.egf.application.internal.activator.EGFApplicationPlugin;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IApplicationConfigurationConstants {

  /**
   * Exit object indicating normal termination
   */
  public static final Integer EXIT_ERROR = Integer.valueOf(-1);

  /**
   * Launch configuration attribute key. The value is a name of
   * an EGF Activity associated with an EGF Task launch configuration.
   */
  public static final String ATTRIBUTE_ACTIVITY_NAME = EGFApplicationPlugin.getDefault().getPluginID() + ".ACTIVITY_ATTRIBUTE"; //$NON-NLS-1$

  public static final String ACTIVITIES_PROGRAM_ARGUMENTS = "-activities"; //$NON-NLS-1$

}
