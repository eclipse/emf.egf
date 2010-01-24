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
package org.eclipse.egf.producer.internal.context;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.context.IFactoryComponentProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProducerContextFactory {

  private ProducerContextFactory() {
    // Prevent Instantiation
  }

  // FactoryComponent
  public static IFactoryComponentProductionContext createContext(ProjectBundleSession projectBundleSession, FactoryComponent element) {
    return new FactoryComponentProductionContext(projectBundleSession, element, EMFHelper.getText(element));
  }

}
