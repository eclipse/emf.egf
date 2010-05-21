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
package org.eclipse.egf.model.helper;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeDomainURIHelper {

  private TypeDomainURIHelper() {
    // Prevent Instantiation
  }

  public static Collection<DomainURI> getAvailableDomainURI(TypeDomainURI typeDomainURI) {
    Collection<DomainURI> result = new UniqueEList<DomainURI>();
    if (typeDomainURI != null) {
      for (Iterator<EObject> iterator = EcoreUtil.getAllProperContents(EcoreUtil.getRootContainer(typeDomainURI, true), true); iterator.hasNext();) {
        EObject eObject = iterator.next();
        if (eObject instanceof DomainURI) {
          result.add((DomainURI) eObject);
        }
      }
    }
    return result;
  }

}
