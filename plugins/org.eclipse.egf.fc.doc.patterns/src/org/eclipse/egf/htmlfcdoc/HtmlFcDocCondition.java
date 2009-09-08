/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.htmlfcdoc;

import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.pattern.ecore.condition.AbstractPatternCondition;



/**
*Condition class implementation.
*A merge occurs each time the corresponding pattern parameters are changed.
*Both check methods are subject to merge (see associated comments).
*Any other method is left untouched as a result of the merging operation.
*/
public class HtmlFcDocCondition extends AbstractPatternCondition {
/**
* Generated check method.<br>
* User should left this code untouched for it is lost when a merge is performed.
* @unmodifiable
*/
public boolean check(Object... parameters_p) {
     return check((FactoryComponent)parameters_p[0]);
   }

/**
* Check method user implementation.<br>
* User must implement and comment between delimiters only !
* Public signature and comments are lost when a merge is performed.
* @unmodifiable
*/
protected boolean check(FactoryComponent factoryComponent) {
     // begin-user-code
return true;
// end-user-code
   }
}