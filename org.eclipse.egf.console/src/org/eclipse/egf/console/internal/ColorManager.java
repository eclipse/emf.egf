/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Thales Corporate Services S.A.S
 */

package org.eclipse.egf.console.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


/**
 * Generic color manager.
 */
public class ColorManager {

  private static ColorManager fgColorManager;

  protected Map<RGB, Color> fColorTable = new HashMap<RGB, Color>(10);

  private ColorManager() {
    // Nothing to do
  }

  public static ColorManager getDefault() {
    if (fgColorManager == null) {
      fgColorManager = new ColorManager();
    }
    return fgColorManager;
  }

  public Color getColor(RGB rgb) {
    Color color = fColorTable.get(rgb);
    if (color == null) {
      color = new Color(Display.getCurrent(), rgb);
      fColorTable.put(rgb, color);
    }
    return color;
  }

  public void dispose() {
    Iterator<Color> e = fColorTable.values().iterator();
    while (e.hasNext()) {
      e.next().dispose();
    }
  }

}
