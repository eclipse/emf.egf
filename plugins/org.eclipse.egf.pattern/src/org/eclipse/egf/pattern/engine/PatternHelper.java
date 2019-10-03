/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.EgfResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.collector.PatternElementCollector;
import org.eclipse.egf.pattern.collector.PatternLibraryCollector;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 */
public class PatternHelper {

	private final ResourceSet resourceSet;

	public static String getFullLibraryName(Pattern pattern) {
		return pattern.getContainer().getName();
	}

	public static String getFactoryComponentName(PatternLibrary library) {
		return library.getPatternViewpoint().getViewpointContainer().getFactoryComponent().getName();
	}

	public static String getFactoryComponentName(Pattern pattern) {
		return getFactoryComponentName(pattern.getContainer());
	}

	// TODO quick implementation ...
	public Pattern getPattern(String id) {
		for (Pattern p : getAllPatterns())
			if (p.getID().equals(id))
				return p;
		return null;
	}

	public List<Pattern> getPatterns(URI uri) {
		List<Pattern> result = new ArrayList<Pattern>();
		collectPatterns(uri, PatternCollector.EMPTY_ID_SET, result);
		return result;
	}

	public Map<String, PatternElement> getPatternElements(Set<String> ids) {
		List<PatternElement> result = new ArrayList<PatternElement>(200);
		IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores();
		for (IPlatformFcore platformFcore : platformFcores) {
			URI uri = platformFcore.getURI();
			try {
				Resource res = resourceSet.getResource(uri, true);
				PatternElementCollector.INSTANCE.collect(res.getContents(), result, ids);
			} catch (Exception e) {
				EGFPatternPlugin.getDefault().logError(NLS.bind(EGFPatternMessages.collect_error2, uri.toString()), e);
			}
		}
		Map<String, PatternElement> map = new HashMap<String, PatternElement>(200);
		for (PatternElement pe : result) {
			map.put(pe.getID(), pe);
		}
		return map;
	}

	/**
	 * Reads FC models from the given project and return the patterns with the
	 * given ids if any. If the ids set is null all patterns are returned.
	 */
	public List<Pattern> getPatterns(IProject project, Set<String> ids) {
		if (ids == null) {
			ids = new HashSet<String>();
		}
		List<Pattern> result = new ArrayList<Pattern>();
		IPlatformFcore[] platformFcores = EGFCorePlugin.getWorkspacePlatformFcores(project);
		for (IPlatformFcore platformFcore : platformFcores) {
			collectPatterns(platformFcore.getURI(), ids, result);
		}
		return result;
	}

	/**
	 * Reads all FC models and return the patterns.
	 */
	public List<Pattern> getAllPatterns() {
		List<Pattern> result = new ArrayList<Pattern>(200);
		IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores();
		for (IPlatformFcore platformFcore : platformFcores) {
			URI uri = platformFcore.getURI();
			try {
				collectPatterns(uri, PatternCollector.EMPTY_ID_SET, result);
			} catch (Exception e) {
				EGFPatternPlugin.getDefault().logError(NLS.bind(EGFPatternMessages.collect_error1, uri.toString()), e);
			}
		}
		return result;
	}

	/**
	 * Reads all FC models and return the pattern libraries.
	 */
	public List<PatternLibrary> getAllLibraries() {
		List<PatternLibrary> result = new ArrayList<PatternLibrary>(200);
		IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores();
		for (IPlatformFcore platformFcore : platformFcores) {
			URI uri = platformFcore.getURI();
			try {
				Resource res = resourceSet.getResource(uri, true);
				PatternLibraryCollector.INSTANCE.collect(res.getContents(), result, PatternCollector.EMPTY_ID_SET);
			} catch (Exception e) {
				EGFPatternPlugin.getDefault().logError(NLS.bind(EGFPatternMessages.collect_error2, uri.toString()), e);
			}
		}
		return result;
	}

	private void collectPatterns(URI uri, Set<String> ids, List<Pattern> collector) {
		Resource res = resourceSet.getResource(uri, true);
		PatternCollector.INSTANCE.collect(res.getContents(), collector, ids);
	}

	public static String generateID() {
		return EcoreUtil.generateUUID().replaceAll("\\W", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String uniqueName(NamedModelElement parameter) {
		return parameter.getName().replaceAll("\\W", "") + "_" + parameter.getID().replaceAll("\\W", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}

	public static String localizeName(org.eclipse.egf.model.pattern.PatternParameter parameter) {
		return parameter.getName() + "Parameter"; //$NON-NLS-1$
	}

	public static List<PatternMethod> getUserMethods(Pattern pattern) {
		ArrayList<PatternMethod> result = new ArrayList<PatternMethod>();
		for (PatternMethod m : pattern.getMethods()) {
			String name = m.getName();
			if (PatternFactory.isSpecialMethod(name))
				continue;
			result.add(m);

		}
		return result;
	}

	public void clear() {
		for (Resource res : resourceSet.getResources())
			res.unload();
		resourceSet.getResources().clear();
	}

	private PatternHelper(TransactionalEditingDomain domain) {
		this(domain.getResourceSet());
	}

	private PatternHelper(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public static final PatternHelper TRANSACTIONNAL_COLLECTOR = new PatternHelper(TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID));

	public static final PatternHelper createCollector() {
		return new PatternHelper(new EgfResourceSet());
	}

}
