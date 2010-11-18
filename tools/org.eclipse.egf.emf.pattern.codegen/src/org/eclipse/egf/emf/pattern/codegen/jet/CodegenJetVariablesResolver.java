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

package org.eclipse.egf.emf.pattern.codegen.jet;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetTemplateSection.InternalSection;
import org.eclipse.egf.emf.pattern.codegen.model.VariableInfo;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenJetVariablesResolver {

    protected CodegenJetCompiler codegenJetCompiler;

    protected IProject codegenProject;

    public CodegenJetVariablesResolver(CodegenJetCompiler codegenJetCompiler, IProject codegenProject) {
        this.codegenJetCompiler = codegenJetCompiler;
        this.codegenProject = codegenProject;
    }

    public void computeVariables() {
        findAstNodes();
        findVariables();
    }

    protected void findVariablesInScope(ASTNode node, final List<VariableInfo> variables) {
        ASTNode parent = node.getParent();
        while (parent != null) {
            VariablesScopeVisitor visitor = createVariablesScopeVisitor(node, variables);
            parent.accept(visitor);
            parent = parent.getParent();
        }
    }

    protected VariablesScopeVisitor createVariablesScopeVisitor(ASTNode node, final List<VariableInfo> variables) {
        return new VariablesScopeVisitor(node, variables);
    }

    protected void findVariables() {
        for (InternalSection section : codegenJetCompiler.allSections) {
            findVariablesInScope(section.beginNode, section.getBeginVariables());
            findVariablesInScope(section.endNode, section.getEndVariables());
        }
    }

    protected void findAstNodes() {
        ASTParser astParser = ASTParser.newParser(AST.JLS3);
        astParser.setSource(codegenJetCompiler.javaBuffer.toString().toCharArray());
        astParser.setResolveBindings(true);
        astParser.setUnitName("MyClass"); //$NON-NLS-1$
        IJavaProject javaProject = JavaCore.create(codegenProject);
        astParser.setProject(javaProject);
        astParser.setCompilerOptions(Collections.EMPTY_MAP);
        ASTNode astNode = astParser.createAST(new NullProgressMonitor());

        ASTVisitor visitor = new ASTVisitor() {

            @Override
            public boolean visit(ExpressionStatement node) {
                if (CodegenJetConstants.MARK_STATEMENT.equals(node.toString())) {
                    for (InternalSection section : codegenJetCompiler.allSections) {
                        if (section.beginNode == null && section.beginJavaOffset == node.getStartPosition())
                            section.beginNode = node;
                        if (section.endNode == null && section.endJavaOffset == node.getStartPosition())
                            section.endNode = node;
                    }
                }
                return super.visit(node);
            }
        };
        astNode.accept(visitor);

        for (InternalSection section : codegenJetCompiler.allSections)
            if (section.beginNode == null || section.endNode == null)
                throw new IllegalStateException("Some ast nodes weren't found"); //$NON-NLS-1$
    }

    protected class VariablesScopeVisitor extends ASTVisitor {

        private ASTNode finalNode;

        private List<VariableInfo> variables;

        public VariablesScopeVisitor(ASTNode finalNode, List<VariableInfo> variables) {
            this.finalNode = finalNode;
            this.variables = variables;
        }

        protected String getTypeString(Type type) {
            ITypeBinding resolveBinding = type.resolveBinding();
            if (resolveBinding == null)
                throw new IllegalStateException("Unable to resolve bindings"); //$NON-NLS-1$
            String typeString = resolveBinding.getBinaryName();
            if ("Z".equals(typeString)) //$NON-NLS-1$
                return "java.lang.Boolean"; //$NON-NLS-1$
            return typeString;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean visit(Block node) {
            List<Statement> statements = node.statements();
            for (Statement blockStatement : statements) {
                if (blockStatement.getStartPosition() < finalNode.getStartPosition()) {
                    if (blockStatement instanceof VariableDeclarationStatement) {
                        VariableDeclarationStatement statement = (VariableDeclarationStatement) blockStatement;
                        if (statement.fragments().size() != 1)
                            throw new IllegalStateException("Not supported."); //$NON-NLS-1$
                        String type = getTypeString(statement.getType());
                        VariableDeclarationFragment fragment = (VariableDeclarationFragment) statement.fragments().get(0);
                        String name = fragment.getName().getIdentifier();
                        variables.add(new VariableInfo(type, name, null));
                    }
                }
            }
            return false;
        }

        @Override
        public boolean visit(EnhancedForStatement node) {
            SingleVariableDeclaration parameter = node.getParameter();
            String type = getTypeString(parameter.getType());
            String name = parameter.getName().getIdentifier();
            variables.add(new VariableInfo(type, name, null));
            return false;
        }

        @Override
        public boolean visit(IfStatement node) {
            return false;
        }

        @Override
        public boolean visit(MethodDeclaration node) {
            return false;
        }

        @Override
        public boolean visit(Initializer node) {
            return false;
        }

        @Override
        public boolean visit(TypeDeclaration node) {
            return false;
        }

        @Override
        public boolean visit(CompilationUnit node) {
            return false;
        }
    }
}
