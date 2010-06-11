/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen.jdt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.emf.pattern.codegen.CodegenFcoreUtil;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenCompilationUnitHelper {

    protected Map<ITypeRoot, CompilationUnit> cache = new HashMap<ITypeRoot, CompilationUnit>();

    protected class MyProblemRequestor implements IProblemRequestor {

        private List<IProblem> problems;

        public MyProblemRequestor(List<IProblem> problems) {
            this.problems = problems;
        }

        public boolean isActive() {
            return true;
        }

        public void endReporting() {
        }

        public void beginReporting() {
        }

        public void acceptProblem(IProblem problem) {
            if (problem.isError())
                problems.add(problem);
        }
    }

    protected final class MyWorkingCopyOwner extends WorkingCopyOwner {
        private List<IProblem> problems;

        public MyWorkingCopyOwner(List<IProblem> problems) {
            this.problems = problems;
        }

        @Override
        public IProblemRequestor getProblemRequestor(ICompilationUnit workingCopy) {
            return new MyProblemRequestor(problems);
        }
    }

    public CompilationUnit getCompilationUnit(IMethod implementingMethod) throws JavaModelException {
        ITypeRoot typeRoot = implementingMethod.getTypeRoot();

        if (cache.containsKey(typeRoot))
            return cache.get(typeRoot);

        List<IProblem> problems = new ArrayList<IProblem>();
        WorkingCopyOwner owner = new MyWorkingCopyOwner(problems);
        ICompilationUnit workingCopy = typeRoot.getWorkingCopy(owner, new NullProgressMonitor());

        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(workingCopy);
        parser.setResolveBindings(true);
        CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(new NullProgressMonitor());

        // TODO show errors
        if (!problems.isEmpty())
            throw new IllegalStateException("Compilation problems on plugin " + CodegenFcoreUtil.ORG_ECLIPSE_EMF_CODEGEN_ECORE); //$NON-NLS-1$

        cache.put(typeRoot, compilationUnit);

        return compilationUnit;
    }

}
