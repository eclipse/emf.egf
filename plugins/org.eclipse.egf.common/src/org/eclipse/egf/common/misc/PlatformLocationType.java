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
package org.eclipse.egf.common.misc;

/**
 * This enumeration offers 4 types to identify platform locations.
 * @author Guillaume Brocard
 */
public enum PlatformLocationType {
  /**
   * Define the target platform.<br>
   * Process handlers that use this type, will only perform against the target platform.
   */
  TARGET_PLATFORM_ONLY,
  /**
   * Define the workspace.<br>
   * Process handlers that use this type, will only perform against the workspace.
   */
  WORKSPACE_ONLY,
  /**
   * Define the target platform then the workspace.<br>
   * Process handlers that use this type will only perform against the target platform then workspace.
   */
  TARGET_PLATFORM_THEN_WORKSPACE,
  /**
   * Define the workspace then the target platform.<br>
   * Process handlers that use this type will only perform against the workspace then target platform.
   */
  WORKSPACE_THEN_TARGET_PLATFORM
}