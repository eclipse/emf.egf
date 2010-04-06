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
package org.eclipse.jet.internal.editor.configuration.delegates;

import org.eclipse.jet.internal.editor.partition.ITokenScannerProvider;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.swt.graphics.Image;

public interface IJETDefaultTextColorerDelegate extends ITokenScannerProvider {
  IPredicateRule[] getPartitioningRules();
  String getName();
  Image getImage();
}