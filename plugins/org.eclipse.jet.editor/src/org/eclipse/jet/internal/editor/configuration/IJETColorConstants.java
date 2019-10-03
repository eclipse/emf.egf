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
package org.eclipse.jet.internal.editor.configuration;

import org.eclipse.swt.graphics.RGB;

public interface IJETColorConstants {
  RGB JET_CUSTOM_TAG_FG = new RGB(180, 128, 0);
  RGB JET_COMMENT_FG = new RGB(0, 155, 50);
  RGB JET_DIRECTIVE_FG = new RGB(180, 128, 0);
  RGB JET_EXPRESSION_FG = new RGB (180, 128, 0);
  RGB JET_SCRIPTLET_FG = new RGB(180, 128, 0);
  
  RGB JET_EXPRESSION_BG = new RGB(220, 230, 255);
  RGB JET_DEFAULT_BG = new RGB(230, 230, 230);
  
  RGB JET_JAVA_CODE = new RGB(128, 128, 128);
  RGB PROC_INSTR = new RGB(128, 128, 128);
}