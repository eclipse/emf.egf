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
package org.eclipse.egf.producer.manager;

import java.util.List;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.manager.IProducerManager;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.ModelElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IModelElementManager<P extends ModelElement, T extends ModelElement> extends IProducerManager<P, T> {

  public List<Activity> getActivities() throws InvocationException;

}
