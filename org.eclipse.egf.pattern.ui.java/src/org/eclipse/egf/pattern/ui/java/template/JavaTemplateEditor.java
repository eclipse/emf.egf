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

package org.eclipse.egf.pattern.ui.java.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.editors.PatternMethodEditorInput;
import org.eclipse.egf.pattern.ui.editors.templateEditor.AbstractTemplateEditor;
import org.eclipse.egf.pattern.ui.java.Activator;
import org.eclipse.egf.pattern.ui.java.editor.JavaTextEditor;
import org.eclipse.egf.pattern.ui.java.editor.JavaTextEditorHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorPart;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaTemplateEditor extends AbstractTemplateEditor {

    private final static String TEMPLATE_FILE_EXTENTION = ".java";

    private Map<String, JavaTextEditor> javaEditorMap = new HashMap<String, JavaTextEditor>();

    private List<JavaTextEditor> javaEditorList = new ArrayList<JavaTextEditor>();

    private IAnnotationModel javaAnnotationModel;

    private Map<String, Map> methodJavaAnnotations = new HashMap<String, Map>();

    private static Map<String, Map> METHODJAVAANNOTATIONS = new HashMap<String, Map>();

    protected void createPages() {
        Pattern pattern = getPattern();
        EList<PatternMethod> methods = pattern.getMethods();
        try {
            setPublicTemplateEditor(pattern, methods, TEMPLATE_FILE_EXTENTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initProblems();
        divideByMethods();
        for (int i = 0; i < methods.size(); i++) {
            createPage(methods.get(i), pattern);
        }
        String patternName = pattern.getName();
        setTitle(patternName);
    }

    void createPage(PatternMethod method, Pattern pattern) {
        try {
            JavaTextEditor editor = new JavaTextEditor(pattern);
            int index = addPage(editor, new PatternMethodEditorInput(method.eResource(), method.getID()));
            setPageText(index, method.getName());
            javaEditorMap.put(method.getID(), editor);
            javaEditorList.add(editor);
        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }
    }

    protected void initProblems() {
        IEditorPart editorPart = openEditor;
        JavaEditor javaEditor = (JavaEditor) editorPart;
        javaAnnotationModel = JavaTextEditorHelper.getAnnotationModel(javaEditor);
    }

    protected void divideByMethods() {
        methodJavaAnnotations.clear();
        METHODJAVAANNOTATIONS.clear();
        for (String key : startPositions.keySet()) {
            Position position = startPositions.get(key);
            int startOffset = position.offset;
            int endOffset = position.offset + position.length;
            Map javaAnnotations = new HashMap();
            if (javaAnnotationModel == null) {
                continue;
            }
            Iterator annotationIterator = javaAnnotationModel.getAnnotationIterator();
            while (annotationIterator.hasNext()) {
                Annotation annotation = (Annotation) annotationIterator.next();
                Position posi = javaAnnotationModel.getPosition(annotation);
                if (posi == null) {
                    continue;
                }
                int offset = posi.offset;
                int length = posi.length;
                if (startOffset == 0 && offset == -1) {
                    javaAnnotations.put(annotation, posi);
                }
                if (offset >= startOffset && offset <= endOffset) {
                    posi.setOffset(offset - startOffset);
                    javaAnnotations.put(annotation, posi);
                }
            }
            methodJavaAnnotations.put(key, javaAnnotations);
            METHODJAVAANNOTATIONS = methodJavaAnnotations;
        }
    }

    public static Map<String, Map> getMETHODJAVAANNOTATIONS() {
        return METHODJAVAANNOTATIONS;
    }

    public IEditorPart getTemplateFileEditorPart() {
        return openEditor;
    }

    public Map<String, JavaTextEditor> getEditorMap() {
        return javaEditorMap;
    }

    public List<JavaTextEditor> getEditorList() {
        return javaEditorList;
    }

    @Override
    public void setActivePage(String methodId) {
        if (methodId != null && !"".equals(methodId)) {
            JavaTextEditor javaTextEditor = javaEditorMap.get(methodId);
            if (javaTextEditor != null) {
                this.setActiveEditor(javaTextEditor);
            }
        }
    }

}
