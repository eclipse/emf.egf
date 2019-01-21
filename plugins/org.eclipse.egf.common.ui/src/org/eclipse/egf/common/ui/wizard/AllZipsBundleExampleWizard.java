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

package org.eclipse.egf.common.ui.wizard;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.osgi.framework.Bundle;

/**
 * @author Matthieu Helleboid
 *
 */
public abstract class AllZipsBundleExampleWizard extends AbstractExampleWizard {

	@Override
	protected void log(Exception e) {
		EGFCommonPlugin.getDefault().logError(e);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		Collection<ProjectDescriptor> projectDescriptors = new ArrayList<AbstractExampleWizard.ProjectDescriptor>();

		String bundleId = getBundleId();
		Bundle bundle = Platform.getBundle(bundleId);
		Enumeration<URL> urls = bundle.findEntries("zips", "*.zip", false); //$NON-NLS-1$ //$NON-NLS-2$
		while (urls.hasMoreElements()) {
			Path urlPath = new Path(urls.nextElement().toString());
			String zipPath = urlPath.removeFirstSegments(urlPath.segmentCount() - 2).setDevice(null).toPortableString();
			String projectName = urlPath.removeFileExtension().lastSegment();
			projectDescriptors.add(new ProjectDescriptor(bundleId, zipPath, projectName));
		}
		return projectDescriptors;
	}

	protected abstract String getBundleId();

}
