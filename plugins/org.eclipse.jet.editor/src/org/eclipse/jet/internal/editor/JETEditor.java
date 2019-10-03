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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.ui.*;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.MultiPageSelectionProvider;
import org.eclipse.ui.texteditor.IStatusField;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class JETEditor extends FormEditor implements ITextEditorExtension, IMenuListener, IGotoMarker {

  public static final String ID = "org.eclipse.jet.internal.editor";
  public static final String copyright = "(c) 2006 Joel Cheuoua & Contributors";
  protected IStatusLineManager contentOutlineStatusLineManager;
  protected TreeViewer contentOutlineViewer;
  protected PropertySheetPage propertySheetPage;
  protected ISelectionChangedListener selectionChangedListener;
  protected JETTextEditor jetTextEditor;
  
  public JETEditor() {
    jetTextEditor = new JETTextEditor();
  }

  public JETTextEditor getJetTextEditor() {
    return jetTextEditor;
  }

  public void addPages() {
    try {
      int pageIndex = addPage(jetTextEditor, getEditorInput());
      setPageText(pageIndex, "Edition");
    } catch (PartInitException e) {
      e.printStackTrace();
    }
    Viewer viewer = new JETTextPreviewViewer(getContainer());
    viewer.setInput(getEditorInput());
    int pageIndex = addPage(viewer.getControl());
    setPageText(pageIndex, "Preview");
  }

  public Object getAdapter(Class key) {
    if (key.equals(IContentOutlinePage.class))
      return jetTextEditor.getAdapter(key);
    if (key.equals(IPropertySheetPage.class))
      return getPropertySheetPage();
    if (key.equals(IGotoMarker.class))
      return this;
    else
      return super.getAdapter(key);
  }

  public IPropertySheetPage getPropertySheetPage() {
    return propertySheetPage;
  }

  public boolean isDirty() {
    return jetTextEditor != null && jetTextEditor.isDirty();
  }

  public void doSave(IProgressMonitor progressMonitor) {
    if (jetTextEditor != null)
      jetTextEditor.doSave(progressMonitor);
  }

  public boolean isSaveAsAllowed() {
    if (jetTextEditor != null)
      return jetTextEditor.isSaveAsAllowed();
    else
      return true;
  }

  public void doSaveAs() {
    if (jetTextEditor != null)
      jetTextEditor.doSaveAs();
  }

  public void gotoMarker(IMarker marker) {
    if (jetTextEditor != null) {
      IGotoMarker gotoMarker = (IGotoMarker) jetTextEditor.getAdapter(IGotoMarker.class);
      if (gotoMarker != null)
        gotoMarker.gotoMarker(marker);
    }
  }

  public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
    setSite(site);
    setInput(editorInput);
    jetTextEditor.init(site, editorInput);
    setPartName(editorInput.getName());
    site.setSelectionProvider(new MultiPageSelectionProvider(this));
  }

  public void menuAboutToShow(IMenuManager menuManager) {
    ((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
  }

  public void dispose() {
    if (jetTextEditor != null)
      jetTextEditor.dispose();
    super.dispose();
  }

  public void setStatusField(IStatusField field, String category) {
    if (jetTextEditor != null)
      jetTextEditor.setStatusField(field, category);
  }

  public boolean isEditorInputReadOnly() {
    if (jetTextEditor != null)
      jetTextEditor.isEditorInputReadOnly();
    return false;
  }

  public void addRulerContextMenuListener(IMenuListener listener) {
    if (jetTextEditor != null)
      jetTextEditor.addRulerContextMenuListener(listener);
  }

  public void removeRulerContextMenuListener(IMenuListener listener) {
    if (jetTextEditor != null)
      jetTextEditor.removeRulerContextMenuListener(listener);
  }
}