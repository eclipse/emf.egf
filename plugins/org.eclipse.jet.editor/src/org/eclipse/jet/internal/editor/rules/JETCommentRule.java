/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.rules;

import org.eclipse.jface.text.rules.*;

public class JETCommentRule extends MultiLineRule {

	public JETCommentRule(IToken token) {
		super("<%--", "--%>", token, '\\');
	}
}
