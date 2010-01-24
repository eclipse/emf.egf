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

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.eval.IEvaluationContext;
import org.eclipse.jdt.internal.ui.text.java.AbstractJavaCompletionProposal;
import org.eclipse.jdt.ui.text.java.CompletionProposalCollector;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jet.compiler.CompileOptionsManager;
import org.eclipse.jet.core.compiler.JETCompilerOptions;
import org.eclipse.jet.core.parser.ProblemSeverity;
import org.eclipse.jet.core.parser.ast.JETASTElement;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.JavaDeclaration;
import org.eclipse.jet.core.parser.ast.JavaExpression;
import org.eclipse.jet.core.parser.ast.JavaScriptlet;
import org.eclipse.jet.core.parser.ast.Problem;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IFileEditorInput;

/**
 * Helper class for code completion and JET compilation unit processing
 * purposespurposes
 * 
 * @author Joel
 * 
 */
public class JETEditorHelper {
    /**
     * Problem requestor for java expressions of the JET template
     * 
     * @author Joel
     * 
     */
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

                // Retrieve the corresponding JET AST Element and its position
                // in the JET source
                JETASTElement astElement = getElementForJavaOffset(javaProblemOffset);
                Position pos = (Position) mappingPositions.get(astElement);

                // jetOffset =
                // start position of the AST element in JET Code +
                // offset till the position delimited by the javaProblemOffset
                // The offset till the position delimited by the
                // javaProblemOffset
                // depends on the starting offset of the java content in the JET
                // AST element.
                // This is due to the fact that the JET AST element first
                // position does not represents the starting offset of
                // offset of its java content.

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

    /**
     * @param astElement
     * @param jetDocument
     * @return
     */
    public static int getASTElementContentStart(JETASTElement astElement, IDocument jetDocument) {
        int jetStart = astElement.getStart();
        if (astElement instanceof JavaDeclaration)
            jetStart += 3;
        if ((astElement instanceof JavaExpression) || (astElement instanceof JavaScriptlet))
            try {
                String jetSnippet = jetDocument.get(jetStart, astElement.getEnd() - jetStart);
                String javaContent = (astElement instanceof JavaExpression) ? ((JavaExpression) astElement).getJavaContent() : ((JavaScriptlet) astElement).getJavaContent();
                int idx = jetSnippet.indexOf(javaContent);
                jetStart += idx;
            } catch (BadLocationException e) {
                Activator.log(e);
            }
        return jetStart;
    }

    public static boolean checkOffsetPositions(String javaSource, String jetSource, int jetOffset, int javaOffset, int checkDepth) {
        boolean result = false;

        String javaCheckString = javaSource.substring(javaOffset, Math.min(javaSource.length(), javaOffset + checkDepth));
        String jetCheckString = jetSource.substring(jetOffset, Math.min(jetSource.length(), jetOffset + checkDepth));
        result = javaCheckString.compareTo(jetCheckString) == 0;
        if (!result) {
            System.err.println("position matching error");
            System.err.println("JET Check String  : " + jetCheckString);
            System.err.println("Java Check String  : " + javaCheckString);
        }
        return result;
    }

    /**
     * @param jetEditor
     * @param cu
     * @param jetDocument
     * @return
     */
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
            System.out.println(e);
            Activator.log(e);
        }
        return problems;
    }

    /**
     * @param javaProject
     * @param cu
     * @param codeSnippet
     * @param offset
     * @return
     */
    public static CompletionProposalCollector collect(IJavaProject javaProject, JETCompilationUnit cu, String codeSnippet, int offset) {
        IEvaluationContext context;
        CompletionProposalCollector proposalCollector;
        context = javaProject.newEvaluationContext();
        List importList = new ArrayList();
        importList.addAll(cu.getImports());
        importList.add("org.eclipse.jet.JET2Context");
        importList.add("org.eclipse.jet.JET2Template");
        importList.add("org.eclipse.jet.JET2Writer");
        importList.add("org.eclipse.jet.taglib.RuntimeTagElement");
        importList.add("org.eclipse.jet.taglib.TagInfo");
        String imports[] = new String[importList.size()];
        importList.toArray(imports);
        String packageName = cu.getOutputJavaPackage();
        if (packageName == null) {
            Map options = CompileOptionsManager.getOptions(javaProject.getProject());
            if (options.isEmpty())
                options = JETCompilerOptions.getDefaultCompilerOptions();
            packageName = (String) options.get("org.eclipse.jet.compiledTemplatePackage");
        }
        context.setPackageName(packageName);
        context.setImports(imports);
        proposalCollector = new CompletionProposalCollector(javaProject);
        try {
            context.codeComplete(codeSnippet, offset, proposalCollector);
            return proposalCollector;
        } catch (JavaModelException e) {
            Activator.log(e);
        }
        return null;
    }

    /**
     * @param editor
     * @param viewer
     * @param completionOffset
     * @return
     */
    public static IJavaCompletionProposal[] getJavaCompletionProposal(JETTextEditor jetEditor, ITextViewer viewer, int completionOffset) {
        IJavaProject javaProject;
        String packageName;
        String className;
        Map mappingPositions;
        IDocument javaDocument;
        JETCompilationUnit cu = jetEditor.requestCompilationUnit();
        javaProject = jetEditor.getJavaProject();
        packageName = cu.getOutputJavaPackage();
        className = cu.getOutputJavaClassName();
        if (packageName == null) {
            Map options = CompileOptionsManager.getOptions(javaProject.getProject());
            if (options.isEmpty())
                options = JETCompilerOptions.getDefaultCompilerOptions();
            packageName = (String) options.get("org.eclipse.jet.compiledTemplatePackage");
        }
        if (className == null && (jetEditor.getEditorInput() instanceof IFileEditorInput)) {
            IFile file = ((IFileEditorInput) jetEditor.getEditorInput()).getFile();
            String inputName = file.getFullPath().removeFileExtension().lastSegment();
            String baseClassName = makeJavaClassName(inputName);
            className = baseClassName;
        }
        if (packageName == null || className == null)
            return new IJavaCompletionProposal[0];
        mappingPositions = new HashMap();
        javaDocument = new Document(jetEditor.compilationHelper().getJavaCode(cu, mappingPositions));
        IJavaCompletionProposal results[];
        ICompilationUnit compilationUnit = null;
        try {
            IPackageFragmentRoot roots[] = javaProject.getPackageFragmentRoots();
            for (int i = 0; i < roots.length;) {
                IPackageFragmentRoot root = roots[i];
                IPackageFragment packageFragment = root.getPackageFragment(packageName);
                if (packageFragment == null || !packageFragment.exists())
                    packageFragment = root.createPackageFragment(packageName, true, new NullProgressMonitor());
                compilationUnit = packageFragment.createCompilationUnit((new StringBuilder(String.valueOf(className))).append(".java").toString(), javaDocument.get(), true, new NullProgressMonitor());
                break;
            }

            CompletionProposalCollector proposalCollector = new CompletionProposalCollector(compilationUnit);
            JETASTElement astElement = jetEditor.getASTElement(completionOffset);
            Position javaPosition = (Position) mappingPositions.get(astElement);
            int jetStart = getASTElementContentStart(astElement, viewer.getDocument());
            int javaStart = javaPosition.getOffset();
            int javaCompletionOffset = javaStart + (completionOffset - jetStart);
            compilationUnit.codeComplete(javaCompletionOffset, proposalCollector);
            Point selection = viewer.getSelectedRange();
            if (selection.y > 0)
                proposalCollector.setReplacementLength(selection.y);
            IJavaCompletionProposal javaProposals[] = proposalCollector.getJavaCompletionProposals();
            IJavaCompletionProposal keywordsProposals[] = proposalCollector.getKeywordCompletionProposals();
            IJavaCompletionProposal unsortedJavaProposals[] = new IJavaCompletionProposal[javaProposals.length + keywordsProposals.length];
            System.arraycopy(keywordsProposals, 0, unsortedJavaProposals, 0, keywordsProposals.length);
            System.arraycopy(javaProposals, 0, unsortedJavaProposals, keywordsProposals.length, javaProposals.length);
            List sortedJavaProposals = new LinkedList();
            for (int i = 0; i < unsortedJavaProposals.length; i++) {
                IJavaCompletionProposal unsortedJavaProposal = unsortedJavaProposals[i];
                int index = 0;
                for (Iterator iterator = sortedJavaProposals.iterator(); iterator.hasNext();) {
                    IJavaCompletionProposal proposal = (IJavaCompletionProposal) iterator.next();
                    if (proposal.getRelevance() <= unsortedJavaProposal.getRelevance()) {
                        index = sortedJavaProposals.indexOf(proposal);
                        break;
                    }
                }

                sortedJavaProposals.add(index, unsortedJavaProposal);
            }

            results = new IJavaCompletionProposal[sortedJavaProposals.size()];
            sortedJavaProposals.toArray(results);
            adjustResults(results, completionOffset);
            return results;
        } catch (JavaModelException e) {
            Activator.log(e);
        }
        return new IJavaCompletionProposal[0];
    }

    /**
     * @param javaProject
     * @param cu
     * @param codeSnippet
     * @param viewer
     * @param offset
     * @return
     */
    public static IJavaCompletionProposal[] getJavaCompletionProposal(IJavaProject javaProject, JETCompilationUnit cu, String codeSnippet, ITextViewer viewer, int offset) {
        CompletionProposalCollector proposalCollector = collect(javaProject, cu, codeSnippet, offset);
        if (proposalCollector != null) {
            Point selection = viewer.getSelectedRange();
            if (selection.y > 0)
                proposalCollector.setReplacementLength(selection.y);
            IJavaCompletionProposal javaProposals[] = proposalCollector.getJavaCompletionProposals();
            IJavaCompletionProposal keywordsProposals[] = proposalCollector.getKeywordCompletionProposals();
            IJavaCompletionProposal unsortedJavaProposals[] = new IJavaCompletionProposal[javaProposals.length + keywordsProposals.length];
            System.arraycopy(keywordsProposals, 0, unsortedJavaProposals, 0, keywordsProposals.length);
            System.arraycopy(javaProposals, 0, unsortedJavaProposals, keywordsProposals.length, javaProposals.length);
            List sortedJavaProposals = new LinkedList();
            for (int i = 0; i < unsortedJavaProposals.length; i++) {
                IJavaCompletionProposal unsortedJavaProposal = unsortedJavaProposals[i];
                int index = 0;
                for (Iterator iterator = sortedJavaProposals.iterator(); iterator.hasNext();) {
                    IJavaCompletionProposal proposal = (IJavaCompletionProposal) iterator.next();
                    if (proposal.getRelevance() <= unsortedJavaProposal.getRelevance()) {
                        index = sortedJavaProposals.indexOf(proposal);
                        break;
                    }
                }
                sortedJavaProposals.add(index, unsortedJavaProposal);
            }

            IJavaCompletionProposal results[] = new IJavaCompletionProposal[sortedJavaProposals.size()];
            sortedJavaProposals.toArray(results);
            return results;
        } else {
            return new IJavaCompletionProposal[0];
        }
    }

    /**
     * @param results
     * @param offset
     */
    public static void adjustResults(IJavaCompletionProposal[] results, int offset) {
        for (int i = 0; i < results.length; i++)
            if (results[i] instanceof AbstractJavaCompletionProposal) {
                AbstractJavaCompletionProposal proposal = (AbstractJavaCompletionProposal) results[i];
                proposal.setReplacementOffset(offset);
            }
    }

    /**
     * @param results
     * @param offset
     * @param allWords
     */
    public static void adjustJavaScriptletProposalResults(IJavaCompletionProposal[] results, int offset) {
        if (results.length > 0) {
            IJavaCompletionProposal iJavaCompletionProposal = results[0];
            if (iJavaCompletionProposal instanceof AbstractJavaCompletionProposal) {
                AbstractJavaCompletionProposal proposal = (AbstractJavaCompletionProposal) iJavaCompletionProposal;
                int replacementLength = proposal.getReplacementLength();
                adjustResults(results, offset - replacementLength);
            }
        }
    }

    /**
     * @param name
     * @return
     */
    public static String makeJavaClassName(String name) {
        StringBuffer result = new StringBuffer("_jet_");
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isJavaIdentifierPart(c))
                result.append(c);
        }
        return result.toString();
    }
}