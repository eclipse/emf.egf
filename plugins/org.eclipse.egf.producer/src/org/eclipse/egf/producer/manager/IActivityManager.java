/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.manager;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IActivityManager<P extends Activity> extends IModelElementManager<P, Contract> {
  // Nothing to do
}
