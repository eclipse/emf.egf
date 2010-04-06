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
package org.eclipse.egf.model.fcore.provider;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.IChildCreationExtender;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IResourceChildCreationExtender extends IChildCreationExtender {

  public Collection<EClass> getRoots();

}
