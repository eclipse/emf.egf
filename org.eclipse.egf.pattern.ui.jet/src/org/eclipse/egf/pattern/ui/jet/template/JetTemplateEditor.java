package org.eclipse.egf.pattern.ui.jet.template;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.editors.templateEditor.AbstractTemplateEditor;
import org.eclipse.egf.pattern.ui.jet.Activator;
import org.eclipse.egf.pattern.ui.jet.editor.JetEditorHelper;
import org.eclipse.egf.pattern.ui.jet.editor.JetTextEditor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jet.core.parser.ProblemSeverity;
import org.eclipse.jet.core.parser.ast.Problem;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JetTemplateEditor extends AbstractTemplateEditor {

    private String TEMPLATE_FILE_EXTENTION = ".jet";

    private List<Problem> problems = new ArrayList<Problem>();

    private Map<String, List<Problem>> methodProblems = new HashMap<String, List<Problem>>();

    private IFile templateFile;

    private static Map<String, List<Problem>> METHODPROBLEMS = new HashMap<String, List<Problem>>();

    protected void createPages() {
        Pattern pattern = getPattern();
        addPatternChangeAdapter(pattern);
        EList<PatternMethod> methods = pattern.getMethods();
        try {
            templateFile = setPublicTemplateEditor(pattern, methods, TEMPLATE_FILE_EXTENTION);
        } catch (Exception e) {
            Activator.getDefault().log(e);
        }
        initProblems();
        divideByMethods();
        for (int i = 0; i < methods.size(); i++) {
            createPage(methods.get(i));
        }
        String patternName = pattern.getName();
        setTitle(patternName);
    }

    void createPage(PatternMethod method) {
        try {
            JetTextEditor editor = new JetTextEditor(getPattern());
            addEditor(editor, method);
        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }
    }

    protected void initProblems() {
        IEditorPart editorPart = openEditor;
        JETTextEditor jetTextEditor = (JETTextEditor) editorPart;
        if(jetTextEditor == null){
            return;
        }
        IDocumentProvider documentProvider = jetTextEditor.getDocumentProvider();
        IEditorInput editorInput = jetTextEditor.getEditorInput();
        if (documentProvider == null || editorInput == null) {
            return;
        }
        IDocument document = documentProvider.getDocument(editorInput);
        List javaContentProblems = JETEditorHelper.evaluateProblems(jetTextEditor, document);
        problems.addAll(javaContentProblems);
    }

    protected void divideByMethods() {
        methodProblems.clear();
        METHODPROBLEMS.clear();
        for (String key : startPositions.keySet()) {
            Position position = startPositions.get(key);
            List<Problem> methodproblems = new LinkedList<Problem>();
            int startOffset = position.offset;
            int endOffset = position.offset + position.length;
            Iterator<Problem> iterator = problems.iterator();
            while (iterator.hasNext()) {
                Problem problem = iterator.next();
                int offset = problem.getStart();
                if (startOffset == 0 && offset == -1) {
                    methodproblems.add(problem);
                }
                if (offset >= startOffset && offset <= endOffset) {
                    problem = translateOffsetForProblem(problem, offset - startOffset);
                    methodproblems.add(problem);
                }
            }
            methodProblems.put(key, methodproblems);
        }
        METHODPROBLEMS = methodProblems;
    }

    private Problem translateOffsetForProblem(Problem problem, int newStart) {
        int colOffset = problem.getColOffset();
        int end = problem.getEnd();
        int id = problem.getId();
        int lineNumber = problem.getLineNumber();
        String message = problem.getMessage();
        Object[] messageArgs = problem.getMessageArgs();
        ProblemSeverity problemSeverity = problem.getProblemSeverity();
        if (templateFile == null) {
            return null;
        }
        URI locationURI = templateFile.getProject().getLocationURI();
        String string = templateFile.getProjectRelativePath().toString();
        Problem newProblem = new Problem(locationURI, string, problemSeverity, id, message, messageArgs, newStart, end, lineNumber, colOffset);
        return newProblem;
    }

    public static Map<String, List<Problem>> getMethodProblems() {
        return METHODPROBLEMS;
    }

    public IEditorPart getTemplateFileEditorPart() {
        return openEditor;
    }

    public IFile getTemplateFile() {
        return templateFile;
    }

    @Override
    public void setFocus() {
        super.setFocus();
//        JetEditorHelper.mappingErrorFromTemplateEditor((JetTextEditor) this.getActiveEditor());
    }

    @Override
    public void setActivePage(String methodId) {
        if (methodId != null && !"".equals(methodId)) {
            JetTextEditor javaTextEditor = (JetTextEditor) editorMap.get(methodId);
            if (javaTextEditor != null) {
                this.setActiveEditor(javaTextEditor);
            }
        }
    }
    @Override
    protected void executeMethodEditorAdd(PatternMethod addMethod) {
        try {
            if (addMethod.getID() == null)
                return;
            // Add the pattern file path to method in order to create add
            // editor's input file.
            setPatternFilePath(addMethod);
            JetTextEditor newEditor = new JetTextEditor(getPattern());
            addEditor(newEditor, addMethod);
            super.executeMethodEditorAdd(addMethod);
        } catch (CoreException e) {
            Activator.getDefault().logError(e);
        } catch (IOException e) {
            Activator.getDefault().logError(e);
        }
    }

    protected TextEditor createNewEditor() {
        JetTextEditor newEditor;
        try {
            newEditor = new JetTextEditor(getPattern());
            return newEditor;
        } catch (CoreException e) {
            Activator.getDefault().logError(e);
        } catch (IOException e) {
            Activator.getDefault().logError(e);
        }
        return null;
    }
}
