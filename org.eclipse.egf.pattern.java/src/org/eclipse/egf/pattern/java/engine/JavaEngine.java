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

package org.eclipse.egf.pattern.java.engine;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.common.java.AbstractJavaEngine;
import org.eclipse.egf.pattern.engine.AssemblyHelper;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.java.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaEngine extends AbstractJavaEngine {

    public JavaEngine(Pattern pattern) throws PatternException {
        super(pattern);
    }

    public void translate() throws PatternException {
        Pattern pattern = getPattern();
        if (pattern == null)
            throw new IllegalStateException();

        // **************************************************************************
        // 1 - put together all pt files
        AssemblyHelper helper = new JavaAssemblyHelper(pattern, new JavaAssemblyContentProvider(pattern));
        String templatecontent = helper.visit();

        if (getPattern().getSuperPattern() != null || !getPattern().getAllParameters().isEmpty()) {
            Document document = new Document(templatecontent);
            ASTParser parser = ASTParser.newParser(AST.JLS3);
            parser.setKind(ASTParser.K_COMPILATION_UNIT);
            parser.setSource(document.get().toCharArray());
            CompilationUnit cu = (CompilationUnit) parser.createAST(null);
            cu.recordModifications();
            if ((cu.getFlags() & ASTNode.MALFORMED) == 0) {
                TypeDeclaration type = (TypeDeclaration) cu.types().get(0);
                if (getPattern().getSuperPattern() != null) {
                    String parentClassName = JavaNatureHelper.getClassName(getPattern().getSuperPattern());
                    AST ast = type.getAST();
                    SimpleType newSimpleType = ast.newSimpleType(ast.newName(parentClassName));
                    type.setSuperclassType(newSimpleType);
                }
                for (PatternParameter param : getPattern().getParameters()) {
                    AST ast = type.getAST();
                    String typeValue = ParameterTypeHelper.INSTANCE.getTypeLiteral(param.getType());

                    // 1 - Add fields
                    VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
                    fragment.setName(ast.newSimpleName(param.getName()));
                    FieldDeclaration field = ast.newFieldDeclaration(fragment);
                    field.modifiers().addAll(ast.newModifiers(Modifier.PRIVATE));
                    field.setType(ast.newSimpleType(ast.newName(typeValue)));

                    type.bodyDeclarations().add(field);

                    // 2 - add setter methods
                    MethodDeclaration setter = ast.newMethodDeclaration();
                    setter.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
                    setter.setName(ast.newSimpleName(JavaMethodGenerationHelper.getSetterMethod(param)));

                    // 2.1 - method parameters
                    SingleVariableDeclaration variableDeclaration = ast.newSingleVariableDeclaration();
                    // variableDeclaration.modifiers()(Modifier.NONE);
                    variableDeclaration.setType(ast.newSimpleType(ast.newName(typeValue)));
                    variableDeclaration.setName(ast.newSimpleName(param.getName()));
                    setter.parameters().add(variableDeclaration);

                    // 2.2 - body declaration
                    Block body = ast.newBlock();

                    Assignment assignment = ast.newAssignment();
                    FieldAccess fieldAccess = ast.newFieldAccess();
                    fieldAccess.setName(ast.newSimpleName(param.getName()));
                    fieldAccess.setExpression(ast.newThisExpression());
                    assignment.setLeftHandSide(fieldAccess);
                    assignment.setOperator(Assignment.Operator.ASSIGN);
                    assignment.setRightHandSide(ast.newSimpleName(param.getName()));

                    body.statements().add(ast.newExpressionStatement(assignment));
                    setter.setBody(body);
                    type.bodyDeclarations().add(setter);
                }
            }
            TextEdit rewrite = cu.rewrite(document, null);
            try {
                rewrite.apply(document);
            } catch (BadLocationException e1) {
                throw new PatternException(e1);
            }
            templatecontent = document.get();
        }

        // 2 - put the result in the right file
        try {

            IPlatformFcore platformFactoryComponent = PatternHelper.getPlatformFcore(pattern);
            if (platformFactoryComponent == null)
                throw new PatternException(Messages.bind(Messages.assembly_error4, pattern.getName(), pattern.getID()));
            IProject project = platformFactoryComponent.getPlatformBundle().getProject();
            if (project == null)
                throw new PatternException(Messages.bind(Messages.assembly_error5, pattern.getName(), pattern.getID()));
            String classname = JavaNatureHelper.getClassName(pattern);
            IPath outputPath = computeFilePath(classname);
            FileHelper.setContent(project.getFile(outputPath), templatecontent);
        } catch (PatternException e) {
            throw e;
        } catch (Exception e) {
            throw new PatternException(e);
        }

    }

    @Override
    protected String getPatternClassname() throws PatternException {

        return JavaNatureHelper.getClassName(getPattern());
    }

}
