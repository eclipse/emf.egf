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
package org.eclipse.egf.producer.internal.context;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.context.IProductionContext;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.context.IModelElementProductionContext;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ModelElementProductionContext<P extends ModelElement, T extends ModelElement> extends ProductionContext<P, T> implements IModelElementProductionContext<P, T> {

	public ModelElementProductionContext(ProjectBundleSession projectBundleSession, P element, String name) {
		super(projectBundleSession, element, name);
	}

	public ModelElementProductionContext(IProductionContext<?, ?> parent, ProjectBundleSession projectBundleSession, P element, String name) {
		super(parent, projectBundleSession, element, name);
	}

	@Override
	public Bundle getBundle(String id) throws InvocationException {
		try {
			ModelElement modelElement = getElement();
			IPlatformFcore fcore = null;
			if (modelElement.eResource() != null && modelElement.eResource() instanceof IPlatformFcoreProvider) {
				fcore = ((IPlatformFcoreProvider) modelElement.eResource()).getIPlatformFcore();
			}
			if (fcore == null) {
				throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.Fcore_not_found, EcoreUtil.getURI(modelElement).trimFragment()), null)));
			}
			// Runtime
			if (fcore.isRuntime()) {
				return Platform.getBundle(id);
			}
			// Target or workspace
			IPlatformBundle bundle = EGFPlatformPlugin.getPlatformManager().getPlatformBundle(id);
			if (bundle != null) {
				// Workspace
				if (bundle.isWorkspace()) {
					return _projectBundleSession.getBundle(id);
				}
				// Target associated with a runtime bundle
				else if (bundle.getBundle() != null) {
					return bundle.getBundle();
				}
			}
			// Cannot associate a runtime bundle to a target bundle
			throw new InvocationException(new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.TargetPlatform_ExtensionPoint_no_bundle, id), null)));
		} catch (CoreException ce) {
			throw new InvocationException(ce);
		}
	}

}
