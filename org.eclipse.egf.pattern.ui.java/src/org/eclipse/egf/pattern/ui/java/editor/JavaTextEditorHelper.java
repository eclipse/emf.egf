/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.ui.java.Activator;
import org.eclipse.egf.pattern.ui.java.template.JavaTemplateEditor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jdt.internal.ui.text.java.IProblemRequestorExtension;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.MultiPageEditorSite;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaTextEditorHelper {
    /**
     * Get the words which will be used in code completion.
     */
    public static String[] getAllWords(char c, JavaDocumentReader reader) {
        ArrayList<String> all = new ArrayList<String>(20);
        char currChar = c;
        currChar = trimBlanksBackward(reader, currChar);
        for (boolean done = false; !done;) {
            Stack stack = new Stack();
            for (; currChar != '\uFFFF' && !Character.isWhitespace(currChar); currChar = reader.readBackward())
                stack.push(new Character(currChar));

            String s;
            for (s = new String(); !stack.empty(); s = (new StringBuilder(String.valueOf(s))).append(((Character) stack.pop()).toString()).toString())
                ;
            all.add(s);
            currChar = trimBlanksBackward(reader, currChar);
            if (currChar == '\uFFFF' || currChar == '@')
                done = true;
        }

        return (String[]) all.toArray(new String[all.size()]);
    }

    public static char trimBlanksBackward(JavaDocumentReader reader, char currChar) {
        for (; currChar != '\uFFFF' && Character.isWhitespace(currChar); currChar = reader.readBackward())
            ;
        return currChar;
    }

    /**
     * While do code completion, refresh the template file's content via the
     * content of method editor.
     */
    public static void refreshPublicTemplateEditor(Pattern pattern, IFile templateFile, JavaTextEditor editor) {
        MultiPageEditorPart multiPageEditorPart = getMultiPageEditorPart(editor);
        List<TextEditor> editors = ((JavaTemplateEditor) multiPageEditorPart).getEditorList();
        if (templateFile.exists()) {
            try {
                templateFile.setContents(new ByteArrayInputStream(new byte[0]), true, false, null);
                if (editors == null) {
                    return;
                }
                int size = editors.size();
                if (size == 0) {
                    return;
                }
                JavaTextEditor footerEditor = null;
                for (int i = 0; i < size; i++) {
                    JavaTextEditor currentEditor = (JavaTextEditor) editors.get(i);
                    String partName = currentEditor.getPartName();
                    if (partName.equals(PatternFactory.FOOTER_METHOD_NAME)) {
                        footerEditor = currentEditor;
                        continue;
                    }
                    visitMethod(currentEditor, templateFile, true);
                }
                visitMethod(footerEditor, templateFile, false);
            } catch (Exception e) {
            }
        } else {
            try {
                templateFile.create(new ByteArrayInputStream(new byte[0]), true, null);
            } catch (CoreException e) {
                Activator.getDefault().log(e);
            }
            refreshPublicTemplateEditor(pattern, templateFile, editor);
        }
    }

    private static void visitMethod(JavaTextEditor currentEditor, IFile templateFile, boolean seprator) throws CoreException {
        if (currentEditor == null) {
            return;
        }
        if (currentEditor != null) {
            InputStream inputStreamOfEditor = getInputStreamOfEditor(currentEditor);
            if (inputStreamOfEditor == null) {
                return;
            }
            templateFile.appendContents(inputStreamOfEditor, false, false, null);
            if (seprator) {
                templateFile.appendContents(new StringBufferInputStream("\n"), true, false, null);
            }
        }
    }

    /**
     * add by PanPan.Liu
     * mapping errors from TemplateEditor to sub editors.
     */
    public static void mappingErrorFromTemplateEditor(JavaTextEditor editor) {
        MultiPageEditorPart multiPageEditorPart = JavaTextEditorHelper.getMultiPageEditorPart(editor);
        if (multiPageEditorPart == null)
            return;
        JavaTemplateEditor javaTemplateEditor = (JavaTemplateEditor) multiPageEditorPart;
        IEditorPart templateEditorPart = javaTemplateEditor.getTemplateFileEditorPart();
        Pattern pattern = editor.getPattern();
        Map<String, TextEditor> editors = javaTemplateEditor.getEditorMap();
        if (!(templateEditorPart instanceof JavaEditor)) {
            return;
        }
        JavaEditor fEditor = (JavaEditor) templateEditorPart;

        IDocumentProvider p = fEditor.getDocumentProvider();
        if (p == null) {
            IFile templateFile = javaTemplateEditor.getTemplateFile();
            WorkbenchPage templateActivePage = javaTemplateEditor.getTemplateActivePage();
            try {
                if (templateActivePage == null || templateFile == null) {
                    return;
                }
                fEditor = (JavaEditor) IDE.openEditor(templateActivePage, templateFile, false);
                templateActivePage.setEditorAreaVisible(false);
            } catch (Exception e) {
                Activator.getDefault().log(e);
            }
            p = fEditor.getDocumentProvider();
        }
        IEditorInput editorInput = fEditor.getEditorInput();
        if (editorInput == null) {
            return;
        }
        if (p == null) {
            return;
        }
        IAnnotationModel javaAnnotationModel = p.getAnnotationModel(editorInput);
        if (javaAnnotationModel == null) {
            return;
        }

        Map<String, Position> mappings = getMappings(pattern, editors);
        if (mappings == null || mappings.size() == 0) {
            return;
        }

        EList<PatternParameter> allParameters = pattern.getAllParameters();
        EList<PatternVariable> allVariables = pattern.getAllVariables();

        javaAnnotationModel = clearDirtyAnnotationForPatternVariAndParam(javaAnnotationModel, allParameters);
        javaAnnotationModel = clearDirtyAnnotationForPatternVariAndParam(javaAnnotationModel, allVariables);

        for (String id : editors.keySet()) {
            TextEditor textEditor = editors.get(id);
            IDocumentProvider documentProvider = textEditor.getDocumentProvider();
            if (documentProvider == null) {
                continue;
            }
            IAnnotationModel annotationModel = documentProvider.getAnnotationModel(textEditor.getEditorInput());
            Iterator iter = annotationModel.getAnnotationIterator();
            while (iter.hasNext()) {
                Annotation annotation = (Annotation) iter.next();
                annotationModel.removeAnnotation(annotation);
            }
            Iterator annotationIterator = javaAnnotationModel.getAnnotationIterator();
            Position position = mappings.get(id);
            int startOffset = position.offset;
            int endOffset = position.offset + position.length - 1;

            if (annotationModel != null) {
                while (annotationIterator.hasNext()) {
                    Annotation annotation = (Annotation) annotationIterator.next();
                    if (!annotation.getType().equals("org.eclipse.jdt.ui.error")) {
                        continue;
                    }
                    String text = annotation.getText();
                    if (text != null) {
                        if (text.startsWith("The declared package ") || text.startsWith("The public type ")) {
                            continue;
                        }
                    }
                    Position posi = javaAnnotationModel.getPosition(annotation);
                    if (posi == null) {
                        continue;
                    }
                    int offset = posi.offset;
                    if (startOffset == 0 && offset == -1) {
                        annotationModel.addAnnotation(annotation, posi);
                    }
                    if (offset >= startOffset && offset <= endOffset) {
                        posi.setOffset(offset - startOffset);
                        annotationModel.addAnnotation(annotation, posi);
                    }
                }
            }
        }
    }

    private static IAnnotationModel clearDirtyAnnotationForPatternVariAndParam(IAnnotationModel javaAnnotationModel, EList list) {
        if (list == null || list.size() == 0) {
            return javaAnnotationModel;
        }
        List<Annotation> annotations = new ArrayList<Annotation>();
        Iterator annotationIterator = javaAnnotationModel.getAnnotationIterator();
        while (annotationIterator.hasNext()) {
            Object next = annotationIterator.next();
            if (next instanceof Annotation) {
                Annotation annotation = (Annotation) next;
                if (annotation == null) {
                    continue;
                }
                if (annotation.getText() == null) {
                    continue;
                }
                String filter = "";
                for (Object obj : list) {
                    if (obj instanceof PatternParameter) {
                        filter = ((PatternParameter) obj).getName();
                    } else if (obj instanceof PatternVariable) {
                        filter = ((PatternVariable) obj).getName();
                    }
                    filter = filter + " ";
                    if (annotation.getText().startsWith(filter)) {
                        javaAnnotationModel.removeAnnotation(annotation);
                    }
                }
            }
        }
        return javaAnnotationModel;
    }

    /**
     * add by PanPan.Liu
     * do the refresh sync. job
     */
    public static void refreshPublicTemplateEditor(JavaTextEditor editor) {
        MultiPageEditorPart multiPageEditorPart = JavaTextEditorHelper.getMultiPageEditorPart(editor);
        if (multiPageEditorPart == null)
            return;
        IEditorPart templateEditorPart = ((JavaTemplateEditor) multiPageEditorPart).getTemplateFileEditorPart();
        
        if(templateEditorPart == null){
            return;
        }
        
        Pattern pattern = editor.getPattern();
        IEditorInput editorInput = templateEditorPart.getEditorInput();
        if (editorInput instanceof IFileEditorInput) {
            IFile templateFile = ((IFileEditorInput) editorInput).getFile();
            refreshPublicTemplateEditor(pattern, templateFile, editor);
        }
    }

    /**
     * Get the inputStream of the editor.
     */
    public static InputStream getInputStreamOfEditor(JavaTextEditor editor) {
        ISourceViewer viewer = ((JavaTextEditor) editor).getViewer();
        if (viewer == null) {
            return null;
        }
        IDocument document = viewer.getDocument();
        return new ByteArrayInputStream(document.get().getBytes());
    }

    /**
     * Get the new offset which mapping from the template file to method file.
     * 
     * @param editors
     */
    public static Map<String, Position> getMappings(Pattern pattern, Map<String, TextEditor> editors) {
        EList<PatternMethod> methods = pattern.getMethods();
        Map<String, Position> mappings = new HashMap<String, Position>();
        int startOffset = 0;
        for (PatternMethod method : methods) {
            String id = method.getID();
            TextEditor textEditor = editors.get(id);
            if (textEditor == null) {
                continue;
            }
            ISourceViewer viewer = ((JavaTextEditor) textEditor).getViewer();
            if (viewer == null || viewer.getDocument() == null) {
                return null;
            }
            int length = viewer.getDocument().getLength();
            mappings.put(id, new Position(startOffset, length));
            startOffset = startOffset + length + 1;
        }
        return mappings;
    }

    /**
     * Get the offset which mapping to the template file.
     */
    public static int getMappingOffset(Pattern pattern, JavaTextEditor editor, int offset) {
        MultiPageEditorPart multiPageEditorPart = getMultiPageEditorPart(editor);
        if (multiPageEditorPart == null)
            return offset;

        Map<String, TextEditor> editors = ((JavaTemplateEditor) multiPageEditorPart).getEditorMap();
        int mappingOffset = offset;

        int activePage = multiPageEditorPart.getActivePage();
        EList<PatternMethod> methods = pattern.getMethods();
        for (int i = 0; i < activePage; i++) {
            PatternMethod method = methods.get(i);
            String id = method.getID();
            JavaTextEditor currentEditor = (JavaTextEditor) editors.get(id);
            if (currentEditor != null && !(editor).equals(currentEditor)) {
                ISourceViewer viewer = currentEditor.getViewer();
                int length = viewer.getDocument().getLength();
                mappingOffset = mappingOffset + length + 1;
            } else {
                return mappingOffset;
            }
        }

        return mappingOffset;
    }

    public static MultiPageEditorPart getMultiPageEditorPart(TextEditor editor) {
        IWorkbenchPartSite site = editor.getSite();
        if (site instanceof MultiPageEditorSite) {
            return ((MultiPageEditorSite) site).getMultiPageEditor();
        }
        return null;
    }

    /**
     * Get the active page index of MultiPageEditor.
     */
    public static int getActivePageIndex(ITextEditor editor) {
        IWorkbenchPartSite site = ((JavaTextEditor) editor).getSite();
        MultiPageEditorPart multiPageEditor = ((MultiPageEditorSite) site).getMultiPageEditor();
        return multiPageEditor.getActivePage();
    }

    public static IAnnotationModel getAnnotationModel(JavaEditor fEditor) {
        if(fEditor == null){
            return null;
        }
        IDocumentProvider p = fEditor.getDocumentProvider();
        if (p == null) {
            p = JavaPlugin.getDefault().getCompilationUnitDocumentProvider();
        }
        IAnnotationModel m = p.getAnnotationModel(fEditor.getEditorInput());
        if (m instanceof IProblemRequestorExtension)
            return m;
        return null;
    }
}
