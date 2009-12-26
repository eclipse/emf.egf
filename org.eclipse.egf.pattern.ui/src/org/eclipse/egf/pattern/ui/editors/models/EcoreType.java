/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui.editors.models;

import java.util.Vector;

/**
 * @author xrchen
 * 
 */
public class EcoreType {
    private String type;
    
    private EcoreType parent;
    
    private Vector underlings;
    
    public EcoreType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EcoreType getParent() {
        return parent;
    }

    public void setParent(EcoreType parent) {
        this.parent = parent;
    }
    
    public Vector getUnderlings() {
        if(underlings == null)
            underlings = new Vector();
        return underlings;
    }   
}
