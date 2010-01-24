/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.jet.internal.editor.Activator;
import org.eclipse.jet.internal.editor.JETEditorHelper;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

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
            System.out.println(e);
            Activator.log(e);
        }
        return problems;
    }
}
