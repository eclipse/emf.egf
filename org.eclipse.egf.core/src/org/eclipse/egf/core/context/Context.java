/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.context;

import java.util.HashMap;
import java.util.Map;


/**
 * TODO Ici on ne devrait avoir qu'une pauvre map avec name-valeur. Son
 * initialisation étant à la charge de l'orchestrateur. TODO il faudrait
 * ajoueter un peu de control pour savoir les noms en lecture et ceux en
 * écriture.
 * 
 * @author Guiu
 * 
 */
public class Context implements IContext {

  private IContext _parent;

  private final Map<String, Object> _data = new HashMap<String, Object>();

  public Context() {
    // Nothing to do
  }

  public Context(IContext parent) {
    _parent = parent;
  }

  public IContext getParent() {
    return _parent;
  }

  public void setValue(String name, Object value) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    _data.put(name, value);
    // TODO how to deal with parent ctx ?
  }

  public Object getValue(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    if (_data.containsKey(name)) {
      return _data.get(name);
    }
    return _parent == null ? null : _parent.getValue(name);
  }

}
