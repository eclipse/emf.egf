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
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
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
        ArrayList all = new ArrayList(20);
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
        List<JavaTextEditor> editors = ((JavaTemplateEditor) multiPageEditorPart).getEditorList();
        if (templateFile.exists()) {
            try {
                templateFile.setContents(new ByteArrayInputStream(new byte[0]), true, false, null);
                for (JavaTextEditor currentEditor : editors) {
                    if (currentEditor == null) {
                        continue;
                    }
                    if (currentEditor != null) {
                        InputStream inputStreamOfEditor = getInputStreamOfEditor(currentEditor);
                        if (inputStreamOfEditor == null) {
                            continue;
                        }
                        templateFile.appendContents(inputStreamOfEditor, false, false, null);
                        templateFile.appendContents(new StringBufferInputStream("\n"), true, false, null);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
        IEditorPart templateEditorPart = ((JavaTemplateEditor) multiPageEditorPart).getTemplateFileEditorPart();
        Pattern pattern = editor.getPattern();
        Map<String, JavaTextEditor> editors = ((JavaTemplateEditor) multiPageEditorPart).getEditorMap();
        if (!(templateEditorPart instanceof JavaEditor)) {
            return;
        }
        JavaEditor fEditor = (JavaEditor) templateEditorPart;

        IDocumentProvider p = fEditor.getDocumentProvider();
        if (p == null) {
            p = JavaPlugin.getDefault().getCompilationUnitDocumentProvider();
        }
        IAnnotationModel javaAnnotationModel = p.getAnnotationModel(fEditor.getEditorInput());
        if (javaAnnotationModel == null) {
            return;
        }
        Map<String, Position> mappings = getMappings(pattern, editors);
        if (mappings == null || mappings.size() == 0) {
            return;
        }
        for (String id : editors.keySet()) {
            TextEditor textEditor = editors.get(id);
            IDocumentProvider documentProvider = textEditor.getDocumentProvider();
            IDocument document = documentProvider.getDocument(textEditor.getEditorInput());
            IAnnotationModel annotationModel = documentProvider.getAnnotationModel(textEditor.getEditorInput());
            // JavaAnnotationModel annotationModel =
            // (JavaAnnotationModel)iannotationModel;
            // annotationModel.disconnect(document);
            Iterator iter = annotationModel.getAnnotationIterator();
            while (iter.hasNext()) {
                Annotation annotation = (Annotation) iter.next();
                annotationModel.removeAnnotation(annotation);
            }
            Position position = mappings.get(id);
            int startOffset = position.offset;
            int endOffset = position.offset + position.length - 1;
            Iterator annotationIterator = javaAnnotationModel.getAnnotationIterator();
            if (annotationModel != null) {
                // annotationModel.setFireChanges(false);
                while (annotationIterator.hasNext()) {
                    Annotation annotation = (Annotation) annotationIterator.next();
                    if (!annotation.getType().equals("org.eclipse.jdt.ui.error")) {
                        continue;
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
                // annotationModel.connect(document);
                // annotationModel.setFireChanges(true);
                // annotationModel.fireAnnotationModelChanged();
            }
        }
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
        Pattern pattern = editor.getPattern();
        IEditorInput editorInput = templateEditorPart.getEditorInput();
        if (editorInput instanceof IFileEditorInput) {
            IFile templateFile = ((IFileEditorInput) editorInput).getFile();
            JavaTextEditorHelper.refreshPublicTemplateEditor(pattern, templateFile, editor);
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
    public static Map<String, Position> getMappings(Pattern pattern, Map<String, JavaTextEditor> editors) {
        EList<PatternMethod> methods = pattern.getMethods();
        Map<String,Position> mappings = new HashMap<String,Position>();
        int startOffset = 0;
		for (PatternMethod method : methods) {
			String id = method.getID();
			TextEditor textEditor = editors.get(id);
			if(textEditor == null){
				continue;
			}
			ISourceViewer viewer = ((JavaTextEditor) textEditor).getViewer();
			if (viewer == null || viewer.getDocument() == null) {
				return null;
			}
			int length = viewer.getDocument().getLength();
			mappings.put(id, new Position(startOffset, length));
			startOffset = startOffset+length +1 ;
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

        Map<String, JavaTextEditor> editors = ((JavaTemplateEditor) multiPageEditorPart).getEditorMap();
        int mappingOffset = offset;

        int activePage = multiPageEditorPart.getActivePage();
        EList<PatternMethod> methods = pattern.getMethods();
        for (int i = 0; i < activePage; i++) {
            PatternMethod method = methods.get(i);
            String id = method.getID();
            JavaTextEditor currentEditor = editors.get(id);
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
