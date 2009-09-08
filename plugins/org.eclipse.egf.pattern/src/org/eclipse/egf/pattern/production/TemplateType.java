/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.production;

/**
 * Defines an enumeration to list all available template engines.
 * @author Guillaume Brocard
 */
public enum TemplateType {
  
  /**
   * ACCELEO template engine.
   */
  ACCELEO("ACCELEO", "acceleo"), //$NON-NLS-1$ //$NON-NLS-2$  
  
  /**
   * JET template engine.
   */
  JET("JET", "jet"), //$NON-NLS-1$ //$NON-NLS-2$
  
  /**
   * JET2 template engine.
   */
  JET2("JET2", "jet2"), //$NON-NLS-1$ //$NON-NLS-2$   
  
  /**
   * VELOCITY template engine.
   */
  VELOCITY("VELOCITY", "velocity"), //$NON-NLS-1$ //$NON-NLS-2$  

  /**
   * XPAND template engine.
   */
  XPAND("XPAND", "xpand"); //$NON-NLS-1$ //$NON-NLS-2$    
  
  /**
   * Simple description.
   */
  private String _description;

  /**
   * Identifier.
   */
  private String _id;

  /**
   * Constructor.
   * @param description_p
   * @param id_p
   */
  private TemplateType(String description_p, String id_p) {
    _description = description_p;
    _id = id_p;
  }

  /**
   * Get the description of this enumeration.
   * @return the description
   */
  public String getDescription() {
    return _description;
  }

  /**
   * Get the identifier of this enumeration.
   * @return the id
   */
  public String getId() {
    return _id;
  }
  
}