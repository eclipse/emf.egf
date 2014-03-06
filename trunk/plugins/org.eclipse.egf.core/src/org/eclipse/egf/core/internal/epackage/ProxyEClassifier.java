/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.internal.epackage;

import org.eclipse.egf.core.epackage.IProxyEClassifier;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 *
 */
public abstract class ProxyEClassifier extends ProxyEObject implements IProxyEClassifier {

    public ProxyEClassifier(IProxyEPackage parent, String name, String instanceClassName, URI nsURI) {
        super(parent, name, instanceClassName, nsURI);
    }

}
