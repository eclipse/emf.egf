/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.jet.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.ui.jet.Activator;
import org.eclipse.egf.pattern.ui.jet.template.JetTemplateEditor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jet.core.parser.ProblemSeverity;
import org.eclipse.jet.core.parser.ast.JETASTElement;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.Problem;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.annotations.JETProblemAnnotation;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
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
import org.eclipse.ui.texteditor.MarkerAnnotation;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JetEditorHelper extends JETEditorHelper {

    private static final class JETJavaContentProblemRequestor implements IProblemRequestor {

        /**
         * The JET problems computed from the java problems
         */
        private List problems;

        /**
         * The problems collected from the compiled java source
         */
        private List javaProblems;

        /**
         * The jet source
         */
        private IDocument jetDocument;

        private Map mappingPositions;

        private JETJavaContentProblemRequestor(List problems, Map mappings, IDocument jetDocument) {
            this.problems = problems;
            mappingPositions = mappings;
            javaProblems = new ArrayList();
            this.jetDocument = jetDocument;
        }

        /**
         * @return
         */
        public List getProblems() {
            return problems;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jdt.core.IProblemRequestor#acceptProblem(org.eclipse.
         * jdt.core.compiler.IProblem)
         */
        public void acceptProblem(IProblem problem) {
            javaProblems.add(problem);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jdt.core.IProblemRequestor#beginReporting()
         */
        public void beginReporting() {
            javaProblems.clear();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jdt.core.IProblemRequestor#endReporting()
         */
        public void endReporting() {
            Problem problem;
            // walk through the java problems collected from the generated java
            // source and create the
            // corresponding JET problems in the JET source using the position
            // mappings
            for (Iterator iter = javaProblems.iterator(); iter.hasNext();) {
                IProblem javaProblem = (IProblem) iter.next();

                int javaProblemOffset = javaProblem.getSourceStart();
                int problemLength = (javaProblem.getSourceEnd() - javaProblemOffset) + 1;

                JETASTElement astElement = getElementForJavaOffset(javaProblemOffset);
                Position pos = (Position) mappingPositions.get(astElement);
                int astElementJavaContentStart = pos == null ? -1 : pos.getOffset();
                int jetOffset = pos == null ? 0 : JETEditorHelper.getASTElementContentStart(astElement, jetDocument) + (javaProblemOffset - astElementJavaContentStart);

                // Create the problem at the specified location
                URI baseLocation = URI.create("");
                problem = new Problem(baseLocation, "", javaProblem.isWarning() ? ProblemSeverity.WARNING : ProblemSeverity.ERROR, -1, javaProblem.getMessage(), javaProblem.getArguments(), jetOffset, jetOffset + problemLength, -1, -1);
                // add the problem to the problems list
                problems.add(problem);
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jdt.core.IProblemRequestor#isActive()
         */
        public boolean isActive() {
            return true;
        }

        /**
         * Find the JET AST element that matches the given java offset in the
         * generated java template source
         * 
         * @param javaOffset
         * @return
         */
        private JETASTElement getElementForJavaOffset(int javaOffset) {
            for (Iterator iterator = mappingPositions.keySet().iterator(); iterator.hasNext();) {
                JETASTElement element = (JETASTElement) iterator.next();
                Position pos = (Position) mappingPositions.get(element);
                if (pos.getOffset() <= javaOffset && javaOffset < pos.getOffset() + pos.getLength())
                    return element;
            }
            return null;
        }
    } // End class JETJavaContentProblemRequestor

    public static List evaluateProblems(JETTextEditor jetEditor, IDocument jetDocument) {
        JETCompilationUnit cu = jetEditor.requestCompilationUnit();
        String packageName = cu.getOutputJavaPackage();
        String className = cu.getOutputJavaClassName();
        List problems = new ArrayList();
        if (packageName == null || className == null)
            return problems;
        Map mappingPositions = new HashMap();
        String javaSource = jetEditor.compilationHelper().getJavaCode(cu, mappingPositions);
        JETJavaContentProblemRequestor problemRequestor = new JETJavaContentProblemRequestor(problems, mappingPositions, jetDocument);
        try {
            ICompilationUnit compilationUnit = null;
            IJavaProject javaProject = jetEditor.getJavaProject();
            IPackageFragmentRoot roots[] = javaProject.getPackageFragmentRoots();
            for (int i = 0; i < roots.length; i++) {
                IPackageFragmentRoot root = roots[i];
                if (IPackageFragmentRoot.K_SOURCE != root.getKind()) {
                    continue;
                }
                IPackageFragment packageFragment = root.getPackageFragment(packageName);
                if (packageFragment == null || !packageFragment.exists())
                    packageFragment = root.createPackageFragment(packageName, true, new NullProgressMonitor());
                compilationUnit = packageFragment.createCompilationUnit((new StringBuilder(String.valueOf(className))).append(".java").toString(), javaSource, true, new NullProgressMonitor());
                break;
            }
            WorkingCopyOwner owner = new WorkingCopyOwner() {
            };
            ICompilationUnit copy = compilationUnit.getWorkingCopy(owner, problemRequestor, null);
            copy.reconcile(0, true, owner, null);
        } catch (JavaModelException e) {
            Activator.getDefault().logError(e);
        }
        return problems;
    }

    /**
     * While do code completion, refresh the template file's content via the
     * content of method editor.
     */
    public static void refreshPublicTemplateEditor(Pattern pattern, IFile templateFile, JetTextEditor editor) {
        MultiPageEditorPart multiPageEditorPart = getMultiPageEditorPart(editor);
        List<TextEditor> editors = ((JetTemplateEditor) multiPageEditorPart).getEditorList();
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
                JetTextEditor footerEditor = null;
                for (int i = 0; i < size; i++) {
                    JetTextEditor currentEditor = (JetTextEditor) editors.get(i);
                    String partName = currentEditor.getPartName();
                    if (partName.equals(PatternFactory.FOOTER_METHOD_NAME)) {
                        footerEditor = currentEditor;
                        continue;
                    }
                    visitMethod(currentEditor, templateFile, true);
                }
                visitMethod(footerEditor, templateFile, false);
            } catch (Exception e) {
                Activator.getDefault().logError(e);
            }
        } else {
            try {
                templateFile.create(new ByteArrayInputStream(new byte[0]), true, null);
            } catch (CoreException e) {
                Activator.getDefault().logError(e);
            }
            refreshPublicTemplateEditor(pattern, templateFile, editor);
        }
    }

    private static void visitMethod(JetTextEditor currentEditor, IFile templateFile, boolean seprator) throws CoreException {
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
    public static void mappingErrorFromTemplateEditor(JetTextEditor editor) {
        MultiPageEditorPart multiPageEditorPart = getMultiPageEditorPart(editor);
        if (multiPageEditorPart == null)
            return;
        JetTemplateEditor jetTemplateEditor = (JetTemplateEditor) multiPageEditorPart;
        IEditorPart templateEditorPart = jetTemplateEditor.getTemplateFileEditorPart();
        Pattern pattern = editor.getPattern();
        Map<String, TextEditor> editors = ((JetTemplateEditor) multiPageEditorPart).getEditorMap();
        if (!(templateEditorPart instanceof TextEditor)) {
            return;
        }
        JETTextEditor fEditor = (JETTextEditor) templateEditorPart;
        IDocumentProvider fDocumentProvider = fEditor.getDocumentProvider();
        if (fDocumentProvider == null) {
            IFile templateFile = jetTemplateEditor.getTemplateFile();
            WorkbenchPage templateActivePage = jetTemplateEditor.getTemplateActivePage();
            try {
                if (templateActivePage == null || templateFile == null) {
                    return;
                }
                fEditor = (JETTextEditor) IDE.openEditor(templateActivePage, templateFile, false);
                templateActivePage.setEditorAreaVisible(false);
            } catch (Exception e) {
                Activator.getDefault().logError(e);
            }
            fDocumentProvider = fEditor.getDocumentProvider();
        }
        if (fEditor == null) {
            return;
        }
        IDocument fDocument = fDocumentProvider.getDocument(fEditor.getEditorInput());
        if (fDocument == null) {
            return;
        }

        Map<String, Position> mappings = getMappings(pattern, editors);
        if (mappings == null || mappings.size() == 0) {
            return;
        }
        List<Problem> javaContentProblems = JETEditorHelper.evaluateProblems(fEditor, fDocument);
        JETCompilationUnit cUnit = fEditor.requestCompilationUnit();
        List<Problem> cUnitProblems = cUnit.getProblems();
        javaContentProblems.addAll(cUnitProblems);

        EList<PatternParameter> allParameters = editor.getPattern().getAllParameters();
        EList<PatternVariable> allVariables = editor.getPattern().getAllVariables();

        javaContentProblems = clearProblemsForParameterAndVariable(allParameters, javaContentProblems);
        javaContentProblems = clearProblemsForParameterAndVariable(allVariables, javaContentProblems);

        for (String id : editors.keySet()) {
            JetTextEditor textEditor = (JetTextEditor) editors.get(id);
            List<Problem> problems = javaContentProblems;
            Position position = mappings.get(id);
            if (position == null) {
                continue;
            }
            int startOffset = position.offset;
            int endOffset = position.offset + position.length - 1;

            if (problems == null || problems.size() == 0) {
                continue;
            }

            IDocumentProvider documentProvider = textEditor.getDocumentProvider();
            IAnnotationModel annotationModel = documentProvider.getAnnotationModel(textEditor.getEditorInput());
            JETAnnotationModel jetAnnotationModel = (JETAnnotationModel) annotationModel;
            if (jetAnnotationModel != null) {
                jetAnnotationModel.setFireChanges(false);
                for (Iterator it = jetAnnotationModel.getAnnotationIterator(); it.hasNext();) {
                    Annotation annotation = (Annotation) it.next();
                    if ((annotation instanceof JETProblemAnnotation) || (annotation instanceof MarkerAnnotation))
                        jetAnnotationModel.removeAnnotation(annotation);
                }

                Iterator<Problem> iterator = problems.iterator();
                while (iterator.hasNext()) {
                    Problem problem = iterator.next();
                    JETProblemAnnotation annotation = new JETProblemAnnotation(problem);
                    Position posi = createPositionFromProblem(problem);
                    if (posi == null) {
                        continue;
                    }
                    int offset = posi.offset;
                    if (startOffset == 0 && offset == -1) {
                        jetAnnotationModel.addAnnotation(annotation, posi);
                    }
                    if (offset >= startOffset && offset <= endOffset) {
                        posi.setOffset(offset - startOffset);
                        jetAnnotationModel.addAnnotation(annotation, posi);
                    }
                }
                jetAnnotationModel.setFireChanges(true);
                jetAnnotationModel.fireAnnotationModelChanged();
            }
        }
    }

    public static List<Problem> clearProblemsForParameterAndVariable(EList filters, List<Problem> problems) {
        if (filters == null || filters.size() == 0) {
            return problems;
        }
        Iterator iterator = filters.iterator();
        List<Problem> newProblems = new ArrayList<Problem>();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            String filter = "";
            if (next instanceof PatternParameter) {
                filter = ((PatternParameter) next).getName();
            } else if (next instanceof PatternVariable) {
                filter = ((PatternVariable) next).getName();
            }
            filter = filter + " cannot be resolved";
            for (Problem problem : problems) {
                if (!problem.getMessage().equals(filter)) {
                    newProblems.add(problem);
                }
            }
        }
        return newProblems;
    }

    public static Position createPositionFromProblem(Problem problem) {
        int start = problem.getStart();
        int end = problem.getEnd();

        if (end == 0 && start == 0)
            return new Position(0, 0);

        int length = end - start + 1;
        if (length < 0)
            return null;

        return new Position(start, length);
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
            ISourceViewer viewer = ((JetTextEditor) textEditor).getViewer();
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
     * add by PanPan.Liu
     * do the refresh sync. job
     */
    public static void refreshPublicTemplateEditor(JetTextEditor editor) {
        MultiPageEditorPart multiPageEditorPart = getMultiPageEditorPart(editor);
        if (multiPageEditorPart == null)
            return;
        IEditorPart templateEditorPart = ((JetTemplateEditor) multiPageEditorPart).getTemplateFileEditorPart();
        Pattern pattern = editor.getPattern();
        if (templateEditorPart == null)
            return;
        IEditorInput editorInput = templateEditorPart.getEditorInput();
        if (editorInput instanceof IFileEditorInput) {
            IFile templateFile = ((IFileEditorInput) editorInput).getFile();
            refreshPublicTemplateEditor(pattern, templateFile, editor);
        }
    }

    public static MultiPageEditorPart getMultiPageEditorPart(TextEditor editor) {
        IWorkbenchPartSite site = editor.getSite();
        if (site instanceof MultiPageEditorSite) {
            return ((MultiPageEditorSite) site).getMultiPageEditor();
        }
        return null;
    }

    /**
     * Get the inputStream of the editor.
     */
    public static InputStream getInputStreamOfEditor(JetTextEditor editor) {
        ISourceViewer viewer = ((JetTextEditor) editor).getViewer();
        if (viewer == null) {
            return null;
        }
        IDocument document = viewer.getDocument();
        return new ByteArrayInputStream(document.get().getBytes());
    }

    public static ICompletionProposal[] getAssistResult(ICompletionProposal[] proposals, List<ICompletionProposal> proposalsAdd) {
        ICompletionProposal[] result = new ICompletionProposal[proposalsAdd.size() + proposals.length];

        if (proposalsAdd.size() > 0) {
            for (int i = 0; i < proposalsAdd.size(); i++) {
                result[i] = proposalsAdd.get(i);
            }
        }
        if (proposals.length > 0) {
            for (int i = 0; i < proposals.length; i++) {
                result[i + proposalsAdd.size()] = proposals[i];
            }
        }
        return result;
    }
}
