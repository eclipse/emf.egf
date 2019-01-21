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
package org.eclipse.egf.model.ftask.task;

import java.util.List;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.ftask.Task;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface ITaskNatureRegistry {

    public List<String> getKinds();

    public ITaskNature getTaskNature(Task task) throws InvocationException;

}
