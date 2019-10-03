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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jet.compiler.CompileOptionsManager;
import org.eclipse.jet.core.compiler.JETCompilerOptions;
import org.eclipse.jet.core.parser.ast.Comment;
import org.eclipse.jet.core.parser.ast.JETDirective;
import org.eclipse.jet.core.parser.ast.JavaDeclaration;
import org.eclipse.jet.core.parser.ast.JavaExpression;
import org.eclipse.jet.core.parser.ast.JavaScriptlet;
import org.eclipse.jet.core.parser.ast.TextElement;
import org.eclipse.jet.core.parser.ast.XMLElement;
import org.eclipse.jet.internal.editor.Activator;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.taglib.TagLibraryReference;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;

public class JETOutlineLabelProvider extends LabelProvider {
  private JETTextEditor editor;

  public JETOutlineLabelProvider(JETTextEditor editor) {
    this.editor = editor;
  }

  public Image getImage(Object element) {
    if (element instanceof Comment) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_JAVADOCTAG);
    } else if (element instanceof JavaDeclaration) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_PUBLIC);
    } else if (element instanceof JavaExpression) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_DEFAULT);
    } else if (element instanceof JavaScriptlet) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_PUBLIC);
    } else if (element instanceof JETDirective) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_PROTECTED);
    } else if (element instanceof TextElement) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_IMPDECL);
    } else if (element instanceof XMLElement) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_PROTECTED);
    } else if (element instanceof JETOutlineContentProvider.ImportsContainerInput) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_IMPCONT);
    } else if (element instanceof JETOutlineContentProvider.ImportInput) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_IMPDECL);
    } else if (element instanceof JETOutlineContentProvider.CompilationUnitContainerInput) {
      return Activator.getDefault().getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    } else if (element instanceof JETOutlineContentProvider.OutputPackageInput) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_PACKDECL);
    } else if (element instanceof JETOutlineContentProvider.OutputClassInput) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_CUNIT);
    } else if (element instanceof TagLibraryReference) {
      return JavaUI.getSharedImages().getImage(org.eclipse.jdt.ui.ISharedImages.IMG_OBJS_ANNOTATION);
    }
    return super.getImage(element);
  }

  public String getText(Object element) {
    if (element instanceof Comment)
      return getShortText(((Comment) element).getCommentText());
    if (element instanceof JavaDeclaration)
      return (new StringBuilder("<%!")).append(getShortText(((JavaDeclaration) element).getJavaContent())).append("%>")
          .toString();
    if (element instanceof JavaExpression)
      return (new StringBuilder("<%=")).append(getShortText(((JavaExpression) element).getJavaContent())).append("%>")
          .toString();
    if (element instanceof JavaScriptlet)
      return (new StringBuilder("<%")).append(getShortText(((JavaScriptlet) element).getJavaContent())).append("%>")
          .toString();
    if (element instanceof JETDirective)
      return (new StringBuilder("<%@")).append(((JETDirective) element).getName()).append(" ").append(
          getAttributesText((JETDirective) element)).append("%>").toString();
    if (element instanceof TextElement)
      return getShortText(new String(((TextElement) element).getText()));
    if (element instanceof XMLElement)
      return (new StringBuilder("<")).append(((XMLElement) element).getName()).append(" ").append(
          getAttributesText((XMLElement) element)).append(">").toString();
    if (element instanceof JETOutlineContentProvider.ImportsContainerInput)
      return "import declarations";
    if (element instanceof JETOutlineContentProvider.CompilationUnitContainerInput)
      return "Template AST";
    if (element instanceof JETOutlineContentProvider.OutputPackageInput) {
      String packageName = ((JETOutlineContentProvider.OutputPackageInput) element).getCompilationUnit()
          .getOutputJavaPackage();
      if (packageName == null) {
        Map options = CompileOptionsManager.getOptions(editor.getJavaProject().getProject());
        if (options.isEmpty())
          options = JETCompilerOptions.getDefaultCompilerOptions();
        packageName = (String) options.get("org.eclipse.jet.compiledTemplatePackage");
      }
      return packageName;
    }
    if (element instanceof JETOutlineContentProvider.OutputClassInput) {
      String className = ((JETOutlineContentProvider.OutputClassInput) element).getCompilationUnit()
          .getOutputJavaClassName();
      if (className == null && (editor.getEditorInput() instanceof IFileEditorInput)) {
        IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
        String inputName = file.getFullPath().removeFileExtension().lastSegment();
        String baseClassName = JETEditorHelper.makeJavaClassName(inputName);
        className = baseClassName;
      }
      return className;
    }
    if (element instanceof TagLibraryReference)
      return ((TagLibraryReference) element).getTagLibraryId();
    else
      return super.getText(element);
  }

  private String getShortText(String text) {
    if (text.length() > 25)
      text = text.substring(0, 25) + "...";
    return text;
  }

  private String getAttributesText(XMLElement element) {
    Map attributes = element.getAttributes();
    StringBuffer textBuffer = new StringBuffer(attributes.size() * 5);
    for (Iterator iterator = attributes.keySet().iterator(); iterator.hasNext();) {
      String attrName = (String) iterator.next();
      String attrValue = (String) attributes.get(attrName);
      textBuffer.append(attrName).append("=\"").append(attrValue).append("\"");
      textBuffer.append(' ');
    }
    return textBuffer.toString();
  }

  private String getAttributesText(JETDirective directive) {
    Map attributes = directive.getAttributes();
    StringBuffer textBuffer = new StringBuffer(attributes.size() * 5);
    for (Iterator iterator = attributes.keySet().iterator(); iterator.hasNext();) {
      String attrName = (String) iterator.next();
      String attrValue = (String) attributes.get(attrName);
      textBuffer.append(attrName).append("=\"").append(attrValue).append("\"");
      textBuffer.append(' ');
    }
    return textBuffer.toString();
  }
}
