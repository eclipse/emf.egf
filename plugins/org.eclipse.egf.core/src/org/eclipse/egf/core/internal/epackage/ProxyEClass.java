/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.internal.epackage;

import org.eclipse.egf.core.epackage.IProxyEClass;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 *
 */
public class ProxyEClass extends ProxyEClassifier implements IProxyEClass {

    public ProxyEClass(IProxyEPackage parent, String name, String instanceClassName, URI nsURI) {
        super(parent, name, instanceClassName, nsURI);
    }

}
