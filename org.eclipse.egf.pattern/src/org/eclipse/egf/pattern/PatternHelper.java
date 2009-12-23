/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Library;
import org.eclipse.egf.model.pattern.Parameter;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternUnit;
import org.eclipse.egf.model.pattern.SuperMethod;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Guiu
 * 
 */
public abstract class PatternHelper {
	protected final Pattern pattern;
	protected final StringBuilder content = new StringBuilder(1000);
	// Every called pattern owns its list of parameters, we need to create all
	// needed alias (Validation ensure that they can be matched)
	protected List<List<String>> parameterAlias;

	public PatternHelper(Pattern pattern) {
		super();
		this.pattern = pattern;
	}

	public String visit() {
		String read = getContent(pattern.getHeaderMethod());
		if (read != null)
			content.append(read);

		int insertionIndex = content.length();

		doVisit(pattern);

		if (!parameterAlias.isEmpty())
			handleParameters(insertionIndex);

		read = getContent(pattern.getFooterMethod());
		if (read != null)
			content.append(read);

		return content.toString();
	}

	/**
	 * This method may code to handle parameter at the insertionIndex and at the
	 * current index. The inserted code is mainly a kind of loop containing the
	 * pattern body over the result of the query.
	 */
	protected abstract void handleParameters(int insertionIndex);

	// TODO mark this method abstract as its implementation depends on the
	// nature of pattern.

	private void doVisit(Pattern pattern) {
		if (parameterAlias == null) {
			parameterAlias = new ArrayList<List<String>>();
			for (Parameter param : pattern.getParameters()) {
				List<String> names = new ArrayList<String>();
				names.add(param.getName());
				parameterAlias.add(names);
			}
		} else {
			for (int i = 0; i < pattern.getParameters().size(); i++) {
				List<String> names = parameterAlias.get(i);
				names.add(pattern.getParameters().get(i).getName());
			}
		}
		for (PatternUnit element : pattern.getOrchestration()) {
			String read = getContent(element);
			if (read != null)
				content.append(read);
		}
	}

	private String getContent(PatternUnit unit) {
		return new PatternSwitch<String>() {

			@Override
			public String caseLibrary(Library object) {
				throw new UnsupportedOperationException("not implemented yet");
			}

			@Override
			public String casePattern(Pattern object) {
				doVisit(object);
				return "";
			}

			@Override
			public String casePatternMethod(PatternMethod object) {
				URI uri = object.getPatternFilePath();
				return FileHelper_to_be_upgraded.getContent(Registry_to_be_upgraded.getProjectName(object.getPattern()), uri);
			}

			@Override
			public String caseSuperMethod(SuperMethod object) {
				String name = object.getName();
				if (name == null)
					throw new IllegalArgumentException();
				PatternMethod method = pattern.getMethod(name);
				if (method == null)
					throw new IllegalStateException("Cannot find method '" + name + "'");
				return casePatternMethod(method);
			}

			@Override
			public String defaultCase(EObject object) {

				throw new IllegalStateException("unexpected type: " + object.eClass().getName());
			}

		}.doSwitch(unit);
	}
}
