/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.selector;

import org.eclipse.emf.validation.model.IClientSelector;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ValidationDelegateClientSelector implements IClientSelector {

    public static boolean running = false;

    public boolean selects(Object object) {

        return running;
    }
}
