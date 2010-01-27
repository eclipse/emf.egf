/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.emf.wrapper;

import java.util.ArrayList;

import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;

public class EgfEmfAllTask extends EgfEmfAbstractTask {

	@Override
	protected ArrayList<String> getProjectTypeList() {
		ArrayList<String> projectTypeList = new ArrayList<String>();
		projectTypeList.add(GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE);
		projectTypeList.add(GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE);
		projectTypeList.add(GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE);
		projectTypeList.add(GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE);
		return projectTypeList;
	}

}
