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
package org.eclipse.jet.internal.editor.outline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jet.core.parser.ast.JETASTElement;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.TextElement;
import org.eclipse.jet.core.parser.ast.XMLBodyElement;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class JETOutlineContentProvider implements ITreeContentProvider {
  private ImportsContainerInput importContainerInput;
  private CompilationUnitContainerInput astContainerInput;
  private OutputPackageInput outputPackageInput;
  private JETCompilationUnit cu;
  private OutputClassInput outputClassInput;
  private JETTextEditor editor;
  
  public class OutputClassInput {
    private JETCompilationUnit compilationUnit;
    public OutputClassInput(JETCompilationUnit cu) {
      this.compilationUnit = cu;
    }
    public JETCompilationUnit getCompilationUnit() {
      return compilationUnit;
    }
  }

  public class OutputPackageInput {
    private JETCompilationUnit compilationUnit;
    public OutputPackageInput(JETCompilationUnit cu) {
      this.compilationUnit = cu;
    }
    public JETCompilationUnit getCompilationUnit() {
      return compilationUnit;
    }
  }

  public class ImportInput {
    private ImportsContainerInput container;
    private String imp;
    public ImportInput(ImportsContainerInput container, String imp) {
      this.container = container;
      this.imp = imp;
    }
    public ImportsContainerInput getImportsContainerInput() {
      return container;
    }
    public String toString() {
      return imp;
    }
  }

  public class ImportsContainerInput {
    private JETCompilationUnit compilationUnit;
    private Collection importInputs;
    public ImportsContainerInput(JETCompilationUnit cu) {
      this.compilationUnit = cu;
      importInputs = new ArrayList();
      for (Iterator iterator = cu.getImports().iterator(); iterator.hasNext();) {
        String imp = (String) iterator.next();
        importInputs.add(new ImportInput(this, imp));
      }
    }
    public JETCompilationUnit getCompilationUnit() {
      return compilationUnit;
    }
    public Collection getImportImputs() {
      return importInputs;
    }
  }

  public class CompilationUnitContainerInput {
    private Collection bodyElements;

    private JETCompilationUnit compilationUnit;

    public CompilationUnitContainerInput(JETCompilationUnit cu) {
      this.bodyElements = new ArrayList();
      this.compilationUnit = cu;
      for (Iterator iterator = cu.getBodyElements().iterator(); iterator.hasNext();) {
        JETASTElement elt = (JETASTElement) iterator.next();
        if (isFiltered(elt))
          continue;
        bodyElements.add(elt);
      }
    }

    public Collection getFilteredASTElements() {
      return bodyElements;
    }

    public JETCompilationUnit getCompilationUnit() {
      return compilationUnit;
    }

    private boolean isFiltered(JETASTElement elt) {
      if (elt instanceof TextElement) {
        String text = new String(((TextElement) elt).getText());
        text = text.replace('\r', ' ');
        text = text.replace('\n', ' ');
        text = text.replace('\t', ' ');
        text = text.trim();
        return text.length() == 0;
      }
      return false;
    }
  }

  public JETOutlineContentProvider(JETTextEditor editor) {
    this.editor = editor;
  }

  public void dispose() {
    // TODO Auto-generated method stub
  }
  
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    cu = (JETCompilationUnit) newInput;
  }

  public Object[] getElements(Object inputElement) {
    Collection results = new ArrayList();
    if (inputElement instanceof JETCompilationUnit) {
      JETCompilationUnit cu = (JETCompilationUnit) inputElement;
      results.add(outputPackageInput = new OutputPackageInput(cu));
      results.add(importContainerInput = new ImportsContainerInput(cu));
      results.add(astContainerInput = new CompilationUnitContainerInput(cu));
      results.addAll(Arrays.asList(cu.getTagLibraryReferences()));
    }
    return results.toArray();
  }

  public Object[] getChildren(Object parentElement) {
    if (parentElement == outputPackageInput) {
      return new Object[] { outputClassInput = new OutputClassInput(cu) };
    }
    if (parentElement == importContainerInput) {
      return importContainerInput.getImportImputs().toArray();
    }
    if (parentElement == astContainerInput) {
      return astContainerInput.bodyElements.toArray();
    }
    if (parentElement instanceof XMLBodyElement) {
      XMLBodyElement astElement = (XMLBodyElement) parentElement;
      return astElement.getBodyElements().toArray();
    }
    return null;
  }

  public Object getParent(Object element) {
    if (element == outputPackageInput || element == importContainerInput || element == astContainerInput)
      return cu;
    if (element == outputClassInput)
      return outputPackageInput;
    if (element instanceof ImportInput)
      return ((ImportInput) element).getImportsContainerInput();
    if (element instanceof JETASTElement) {
      if (((JETASTElement) element).getParent() == cu)
        return astContainerInput;
      return ((JETASTElement) element).getParent();
    }
    if (importContainerInput.getCompilationUnit().getImports().contains(element))
      return importContainerInput;
    return null;
  }

  public boolean hasChildren(Object element) {
    return (element instanceof XMLBodyElement) || (element == outputPackageInput) || (element == importContainerInput)
        || (element == astContainerInput);
  }
}
