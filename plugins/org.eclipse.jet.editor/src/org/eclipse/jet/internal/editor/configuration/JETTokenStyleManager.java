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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jdt.ui.text.IColorManagerExtension;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class JETTokenStyleManager implements IColorManager, IColorManagerExtension {
  private IPreferenceStore preferenceStore;
  
  protected Map colorTable = new HashMap(10);
  protected Map keyTable= new HashMap(10);
  protected Map tokenMap = new HashMap(10);
  
  public JETTokenStyleManager(IPreferenceStore store) {
    this.preferenceStore = store;
  }
	public void dispose() {
		Iterator e = colorTable.values().iterator();
		while (e.hasNext())
			 ((Color) e.next()).dispose();
	}
	public Color getColor(RGB rgb) {
		Color color = (Color) colorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}
		return color;
	}
  public Color getColor(String key) {
    if (key == null)
      return null;    
    RGB rgb= (RGB) keyTable.get(key);
    if (rgb == null) {
      rgb= PreferenceConverter.getColor(preferenceStore, key);
      if (rgb == null)
        return null;
      keyTable.put(key, rgb);
    }
    return getColor(rgb);
  }
  
  /*
   * @see IColorManagerExtension#bindColor(String, RGB)
   */
  public void bindColor(String key, RGB rgb) {
    Object value= keyTable.get(key);
    if (value != null)
      throw new UnsupportedOperationException();
    keyTable.put(key, rgb);
  }

  /*
   * @see IColorManagerExtension#unbindColor(String)
   */
  public void unbindColor(String key) {
    keyTable.remove(key);
  }
  
  public IToken getCachedToken(String id) {
    return ((IToken)tokenMap.get(id));
  }
  
  public IToken requestToken(String id, 
      String fgColorKey, 
      String bgColorKey, 
      String boldKey, 
      String italicKey, 
      String strikethroughKey, 
      String underlineKey) {
    if (fgColorKey != null && getColor(fgColorKey) == null) {
      RGB rgb= PreferenceConverter.getColor(preferenceStore, fgColorKey);
      unbindColor(fgColorKey);
      bindColor(fgColorKey, rgb);      
    }
    
    if (bgColorKey != null && getColor(bgColorKey) == null) {
      RGB rgb= PreferenceConverter.getColor(preferenceStore, bgColorKey);
      unbindColor(bgColorKey);
      bindColor(bgColorKey, rgb);      
    }    
    
    Token token= ((Token)tokenMap.get(id));
    if (token == null) {
      token = new Token(createTextAttribute(fgColorKey, bgColorKey, boldKey, italicKey, strikethroughKey, underlineKey));
      tokenMap.put(id, token);            
    } else {
      token.setData(createTextAttribute(fgColorKey, bgColorKey, boldKey, italicKey, strikethroughKey, underlineKey));
    }
    return token;
  }

  /**
   * Create a text attribute based on the given color, bold, italic, strikethrough and underline preference keys.
   *
   * @param fgColorKey the fg color preference key
   * @param bgColorKey the fg color preference key
   * @param boldKey the bold preference key
   * @param italicKey the italic preference key
   * @param strikethroughKey the strikethrough preference key
   * @param underlineKey the italic preference key
   * @return the created text attribute
   * @since 3.0
   */
  private TextAttribute createTextAttribute(String fgColorKey, String bgColorKey, String boldKey, String italicKey, String strikethroughKey, String underlineKey) {
    Color fgColor= null;
    if (fgColorKey != null)
      fgColor= getColor(fgColorKey);
    Color bgColor= null;
    if (bgColorKey != null)
      bgColor= getColor(bgColorKey);
    
    int style = (boldKey != null && preferenceStore.getBoolean(boldKey))? SWT.BOLD : SWT.NORMAL;
    
    if (italicKey != null && preferenceStore.getBoolean(italicKey))
      style |= SWT.ITALIC;

    if (strikethroughKey != null && preferenceStore.getBoolean(strikethroughKey))
      style |= TextAttribute.STRIKETHROUGH;

    if (underlineKey != null && preferenceStore.getBoolean(underlineKey))
      style |= TextAttribute.UNDERLINE;

    return new TextAttribute(fgColor, bgColor, style);
  }
  
  public IToken requestDefaultToken() {
    return requestToken("__jet_default_return_token", 
        AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, 
        null, 
        null, 
        null, 
        null);
    
  }
}
