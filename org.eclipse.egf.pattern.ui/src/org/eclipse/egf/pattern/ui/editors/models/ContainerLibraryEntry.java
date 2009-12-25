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

import org.eclipse.egf.model.pattern.PatternLibrary;

/**
 * @author xrchen
 * 
 */
public class ContainerLibraryEntry {
    private PatternLibrary container;
    private String factoryConponentName;

    public ContainerLibraryEntry(PatternLibrary container, String factoryConponentName) {
        this.container = container;
        this.factoryConponentName = factoryConponentName;
    }

    public PatternLibrary getContainer() {
        return container;
    }

    public void setContainer(PatternLibrary container) {
        this.container = container;
    }
    
    public String getFactoryConponentName() {
        return factoryConponentName;
    }
    
    public void setFactoryConponentName(String factoryConponentName) {
        this.factoryConponentName = factoryConponentName;
    }
}
