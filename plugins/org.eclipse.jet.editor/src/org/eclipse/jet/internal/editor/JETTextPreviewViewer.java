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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelItemProviderAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class JETTextPreviewViewer extends Viewer {

  private SourceViewer sourceViewer;

  private Object fInput;

  private ScrolledForm sForm;

  private Text inputResource;

  private Button browseWorkspace;

  private Tree tree;

  private TreeViewer treeViewer;

  private ISelection selection;

  public JETTextPreviewViewer(Composite parent) {
    inputResource = null;
    browseWorkspace = null;
    tree = null;
    treeViewer = null;
    org.eclipse.swt.widgets.Display display = parent.getDisplay();
    FormToolkit formToolkit = new FormToolkit(display);
    sForm = formToolkit.createScrolledForm(parent);
    ManagedForm overviewForm = new ManagedForm(formToolkit, sForm);
    Composite body = sForm.getBody();
    GridLayout layout = new GridLayout();
    layout.numColumns = 1;
    layout.marginWidth = 10;
    layout.horizontalSpacing = 10;
    layout.verticalSpacing = 10;
    body.setLayout(layout);
    createInputArgumentsSection(overviewForm, body, formToolkit);
    createTextViewerSection(overviewForm, body, formToolkit);
    overviewForm.initialize();
    overviewForm.refresh();
  }

  private void createInputArgumentsSection(ManagedForm mForm, Composite body, FormToolkit formToolkit) {
    final Section section = formToolkit.createSection(body, 256);
    section.setText("Input Argument");
    Composite client = formToolkit.createComposite(section);
    GridLayout layout = new GridLayout();
    layout.marginWidth = formToolkit.getBorderStyle() == 0 ? 2 : 0;
    layout.numColumns = 2;
    client.setLayout(layout);
    inputResource = formToolkit.createText(client, "<Empty>");
    inputResource.setEditable(false);
    GridData gd = new GridData();
    gd.horizontalSpan = 1;
    gd.grabExcessHorizontalSpace = true;
    gd.horizontalAlignment = 4;
    gd.grabExcessVerticalSpace = false;
    inputResource.setLayoutData(gd);
    browseWorkspace = formToolkit.createButton(client, "Browse ...", 0);
    browseWorkspace.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        ResourceSelectionDialog resSelectionDialog = new ResourceSelectionDialog(section.getShell(),
            ResourcesPlugin.getWorkspace().getRoot(), "Select a workspace resource");
        if (resSelectionDialog.open() == 0) {
          Object result[] = resSelectionDialog.getResult();
          if (result.length == 1) {
            String inputFile = ((IResource) result[0]).getFullPath().toString();
            inputResource.setText(inputFile);
            ResourceSet resourceSet = new ResourceSetImpl();
            URI uri = URI.createPlatformResourceURI(inputFile, true);
            org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(uri, true);
            if (resource != null)
              treeViewer.setInput(resourceSet);
          }
        }
      }
    });
    tree = formToolkit.createTree(client, 2052);
    gd = new GridData();
    gd.horizontalSpan = 2;
    gd.horizontalAlignment = 4;
    gd.verticalAlignment = 4;
    gd.grabExcessVerticalSpace = true;
    tree.setLayoutData(gd);
    treeViewer = new TreeViewer(tree);
    List factories = new ArrayList();
    factories.add(new ResourceItemProviderAdapterFactory());
    factories.add(new GenModelItemProviderAdapterFactory());
    factories.add(new ReflectiveItemProviderAdapterFactory());
    org.eclipse.emf.common.notify.AdapterFactory adapterFactory = new ComposedAdapterFactory(factories);
    treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
    treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
    Button button = formToolkit.createButton(client, "Apply", 0x800008);
    button.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        IFileEditorInput fileInput = (IFileEditorInput) getInput();
        IFile file = fileInput.getFile();
        JavaCore.create(file.getProject());
      }
    });
    section.setClient(client);
    gd = new GridData();
    gd.grabExcessHorizontalSpace = true;
    gd.horizontalAlignment = 4;
    gd.verticalAlignment = 1;
    section.setLayoutData(gd);
    SectionPart sectionPart = new SectionPart(section);
    mForm.addPart(sectionPart);
  }

  private void createTextViewerSection(ManagedForm mForm, Composite body, FormToolkit formToolkit) {
    Section section = formToolkit.createSection(body, 256);
    section.setText("Preview");
    org.eclipse.jface.preference.IPreferenceStore store = EditorsUI.getPreferenceStore();
    sourceViewer = new SourceViewer(section, null, 768);
    sourceViewer.configure(new TextSourceViewerConfiguration(store));
    sourceViewer.getTextWidget().setFont(JFaceResources.getFont("org.eclipse.jdt.ui.editors.textfont"));
    sourceViewer.setEditable(false);
    section.setClient(sourceViewer.getControl());
    GridData gd = new GridData();
    gd.horizontalAlignment = 4;
    gd.verticalAlignment = 4;
    gd.grabExcessHorizontalSpace = true;
    gd.grabExcessVerticalSpace = true;
    section.setLayoutData(gd);
    SectionPart sectionPart = new SectionPart(section);
    mForm.addPart(sectionPart);
  }

  public Control getControl() {
    return sForm;
  }

  public void setInput(Object input) {
    fInput = input;
  }

  public Object getInput() {
    return fInput;
  }

  public ISelection getSelection() {
    return selection;
  }

  public void setSelection(ISelection s, boolean reveal) {
    selection = s;
  }

  public void refresh() {
  }

}