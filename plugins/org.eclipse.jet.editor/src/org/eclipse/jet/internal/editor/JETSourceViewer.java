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
package org.eclipse.jet.internal.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class JETSourceViewer extends ProjectionViewer implements IPropertyChangeListener {
  
  private IPreferenceStore preferenceStore;
  private Color foregroundColor;
  private Color backgroundColor;
  private Color selectionForegroundColor;
  private Color selectionBackgroundColor;
  
  public JETSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
      boolean showsAnnotationOverview, int styles, IPreferenceStore store) {
    super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
    setPreferenceStore(store);
  }

  public void setPreferenceStore(IPreferenceStore store) {
    if (preferenceStore != null)
      preferenceStore.removePropertyChangeListener(this);
    preferenceStore = store;
    if (preferenceStore != null) {
      preferenceStore.addPropertyChangeListener(this);
      initializeViewerColors();
    }
  }

  private void initializeViewerColors() {
    if (preferenceStore != null) {
      StyledText styledText = getTextWidget();
      if (styledText == null || styledText.isDisposed())
        return;
      Color color = preferenceStore.getBoolean("AbstractTextEditor.Color.Foreground.SystemDefault") ? null
          : createColor(preferenceStore, "AbstractTextEditor.Color.Foreground", styledText.getDisplay());
      styledText.setForeground(color);
      if (foregroundColor != null)
        foregroundColor.dispose();
      foregroundColor = color;
      color = preferenceStore.getBoolean("AbstractTextEditor.Color.Background.SystemDefault") ? null : createColor(
          preferenceStore, "AbstractTextEditor.Color.Background", styledText.getDisplay());
      styledText.setBackground(color);
      if (backgroundColor != null)
        backgroundColor.dispose();
      backgroundColor = color;
      color = preferenceStore.getBoolean("AbstractTextEditor.Color.SelectionForeground.SystemDefault") ? null
          : createColor(preferenceStore, "AbstractTextEditor.Color.SelectionForeground", styledText.getDisplay());
      styledText.setSelectionForeground(color);
      if (selectionForegroundColor != null)
        selectionForegroundColor.dispose();
      selectionForegroundColor = color;
      color = preferenceStore.getBoolean("AbstractTextEditor.Color.SelectionBackground.SystemDefault") ? null
          : createColor(preferenceStore, "AbstractTextEditor.Color.SelectionBackground", styledText.getDisplay());
      styledText.setSelectionBackground(color);
      if (selectionBackgroundColor != null)
        selectionBackgroundColor.dispose();
      selectionBackgroundColor = color;
    }
  }

  private Color createColor(IPreferenceStore store, String key, Display display) {
    org.eclipse.swt.graphics.RGB rgb = null;
    if (store.contains(key)) {
      if (store.isDefault(key))
        rgb = PreferenceConverter.getDefaultColor(store, key);
      else
        rgb = PreferenceConverter.getColor(store, key);
      if (rgb != null)
        return new Color(display, rgb);
    }
    return null;
  }

  public void propertyChange(PropertyChangeEvent event) {
    String property = event.getProperty();
    if ("AbstractTextEditor.Color.Foreground".equals(property)
        || "AbstractTextEditor.Color.Foreground.SystemDefault".equals(property)
        || "AbstractTextEditor.Color.Background".equals(property)
        || "AbstractTextEditor.Color.Background.SystemDefault".equals(property)
        || "AbstractTextEditor.Color.SelectionForeground".equals(property)
        || "AbstractTextEditor.Color.SelectionForeground.SystemDefault".equals(property)
        || "AbstractTextEditor.Color.SelectionBackground".equals(property)
        || "AbstractTextEditor.Color.SelectionBackground.SystemDefault".equals(property))
      initializeViewerColors();
  }
}