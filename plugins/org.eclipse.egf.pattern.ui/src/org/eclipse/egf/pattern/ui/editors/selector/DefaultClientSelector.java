/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.selector;

import org.eclipse.emf.validation.model.IClientSelector;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class DefaultClientSelector implements IClientSelector {

    // Avoid validation from Transaction, the transaction will be rollbacked
    // when executing validation without use 'running' in DefaultClientSelector.
    public static boolean running = false;

    public boolean selects(Object object) {
        return running;
    }
}
