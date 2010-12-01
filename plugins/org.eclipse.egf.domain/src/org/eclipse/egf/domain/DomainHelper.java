/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.domain;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 * 
 */
public interface DomainHelper {

    boolean loadDomain(Domain domain) throws DomainException;

    boolean unLoadDomain(Domain domain) throws DomainException;

    class Helper {

        public void loadDomains(FactoryComponent fc, Bundle bundle) throws DomainException {
            for (Domain domain : getDomains(fc)) {
                final String helperImplementation = domain.getHelperImplementation();
                if (helperImplementation == null || "".equals(helperImplementation)) //$NON-NLS-1$
                    continue;
                // throw new DomainException(Messages.Load_Domain_error2);

                DomainHelper helper = loadHelper(helperImplementation, bundle);
                helper.loadDomain(domain);
            }
        }

        public void unLoadDomains(FactoryComponent fc, Bundle bundle) throws DomainException {
            for (Domain domain : getDomains(fc)) {
                final String helperImplementation = domain.getHelperImplementation();
                if (helperImplementation == null || "".equals(helperImplementation)) //$NON-NLS-1$
                    continue;
                // throw new DomainException(Messages.Load_Domain_error2);
                DomainHelper helper = loadHelper(helperImplementation, bundle);
                helper.unLoadDomain(domain);
            }
        }

        protected DomainHelper loadHelper(String helperImplementation, Bundle bundle) throws DomainException {
            try {
                final Class<?> clazz = Class.forName(helperImplementation);
                return (DomainHelper) clazz.newInstance();
            } catch (Exception e1) {
                try {
                    final Class<?> loadClass = bundle.loadClass(helperImplementation);
                    return (DomainHelper) loadClass.newInstance();
                } catch (Exception e) {
                    throw new DomainException(e);
                }
            }
        }

        private List<Domain> getDomains(FactoryComponent fc) {
            if (fc.getViewpointContainer() == null)
                return new ArrayList<Domain>();
            DomainViewpoint vp = (DomainViewpoint) fc.getViewpointContainer().getViewpoint(DomainViewpoint.class);
            return vp == null ? new ArrayList<Domain>() : vp.getDomains();
        }

    }

    Helper INSTANCE = new Helper();
}
