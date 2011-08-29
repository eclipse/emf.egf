/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
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
		return "org.eclipse.egf.examples.installer"; //$NON-NLS-1$
	}

}
