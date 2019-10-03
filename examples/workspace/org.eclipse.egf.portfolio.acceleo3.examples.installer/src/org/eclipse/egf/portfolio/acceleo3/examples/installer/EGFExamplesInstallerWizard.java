/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.acceleo3.examples.installer;

import org.eclipse.egf.common.ui.wizard.AllZipsBundleExampleWizard;

/**
 * @author Matthieu Helleboid
 *
 */
public class EGFExamplesInstallerWizard extends AllZipsBundleExampleWizard {

	@Override
	protected String getBundleId() {
		return "org.eclipse.egf.portfolio.acceleo3.examples.installer"; //$NON-NLS-1$
	}

}
