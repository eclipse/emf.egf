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
