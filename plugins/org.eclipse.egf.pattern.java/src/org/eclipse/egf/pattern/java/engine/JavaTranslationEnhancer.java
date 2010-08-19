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

import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.utils.JavaMethodGenerationHelper;
import org.eclipse.egf.pattern.utils.ParameterTypeHelper;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaTranslationEnhancer {

    private final Pattern pattern;

    public JavaTranslationEnhancer(Pattern pattern) {
        this.pattern = pattern;
    }

    public String enhance(String source) throws PatternException {
        if (canEnhance(source)) {
            Document document = new Document(source);
            ASTParser parser = ASTParser.newParser(AST.JLS3);
            parser.setKind(ASTParser.K_COMPILATION_UNIT);
            parser.setSource(document.get().toCharArray());
            CompilationUnit cu = (CompilationUnit) parser.createAST(null);
            cu.recordModifications();
            if ((cu.getFlags() & ASTNode.MALFORMED) != 0)
                throw new PatternException("Translated class is malformed "); //$NON-NLS-1$
            TypeDeclaration type = (TypeDeclaration) cu.types().get(0);

            performEnhancement(type);

            TextEdit rewrite = cu.rewrite(document, null);
            try {
                rewrite.apply(document);
            } catch (BadLocationException e1) {
                throw new PatternException(e1);
            }
            return document.get();

        }
        return source;
    }

    @SuppressWarnings("unused")
    protected boolean canEnhance(String source) throws PatternException {
        return pattern.getSuperPattern() != null || !pattern.getParameters().isEmpty() || !pattern.getVariables().isEmpty();
    }

    protected void performEnhancement(TypeDeclaration type) throws PatternException {
        addSuperClass(type);
        addParameterFieldsAndSetter(type);
        addVariableFieldsAndSetter(type);
        addGetParametersMethod(type);

    }

    private void addGetParametersMethod(TypeDeclaration type) {
        AST ast = type.getAST();
        MethodDeclaration getter = ast.newMethodDeclaration();
        getter.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
        getter.setName(ast.newSimpleName("getParameters"));

        // 1 - return type
        getter.setReturnType2(createMapType(ast));

        // 2 - body
        Block body = ast.newBlock();
        getter.setBody(body);
        type.bodyDeclarations().add(getter);

        // 3 - body statements

        // 3.1 - result declaration and initialisation
        VariableDeclarationFragment paramsFragment = ast.newVariableDeclarationFragment();
        paramsFragment.setName(ast.newSimpleName("parameters"));
        ClassInstanceCreation initializer = ast.newClassInstanceCreation();
        initializer.setType(createHashMapType(ast));

        paramsFragment.setInitializer(initializer);
        VariableDeclarationStatement params = ast.newVariableDeclarationStatement(paramsFragment);
        params.setType(createMapType(ast));
        body.statements().add(params);

        // 3.2 - statement for parameter addition in the map
        for (PatternParameter parameter : pattern.getAllParameters()) {
            String name = parameter.getName();
            MethodInvocation invocation = ast.newMethodInvocation();
            invocation.setName(ast.newSimpleName("put"));
            StringLiteral literal = ast.newStringLiteral();
            literal.setLiteralValue(name);
            invocation.arguments().add(literal);
            FieldAccess fieldAccess = ast.newFieldAccess();
            fieldAccess.setName(ast.newSimpleName(name));
            fieldAccess.setExpression(ast.newThisExpression());
            invocation.arguments().add(fieldAccess);
            invocation.setExpression(ast.newSimpleName("parameters"));
            body.statements().add(ast.newExpressionStatement(invocation));

        }

        // 3.3 - return statement
        ReturnStatement returnStatement = ast.newReturnStatement();
        returnStatement.setExpression(ast.newSimpleName("parameters"));
        body.statements().add(returnStatement);

    }

    private ParameterizedType createMapType(AST ast) {
        return createType(ast, "Map");
    }

    private ParameterizedType createHashMapType(AST ast) {
        return createType(ast, "HashMap");
    }

    private ParameterizedType createType(AST ast, String type) {
        SimpleType mapType = ast.newSimpleType(ast.newName(type));
        ParameterizedType parameterizedType = ast.newParameterizedType(mapType);
        parameterizedType.typeArguments().add(ast.newSimpleType(ast.newName("String")));
        parameterizedType.typeArguments().add(ast.newSimpleType(ast.newName("Object")));
        return parameterizedType;
    }

    protected void addVariableFieldsAndSetter(TypeDeclaration type) {
        for (PatternVariable var : pattern.getVariables()) {
            String typeValue = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(var.getType());

            // 1 - Add fields
            addField(type, var.getName(), typeValue, Modifier.PROTECTED);

            // 2 - add setter methods
            addSetter(type, var, typeValue);
        }
    }

    protected void addParameterFieldsAndSetter(TypeDeclaration type) {
        for (PatternParameter param : pattern.getParameters()) {
            String typeValue = ParameterTypeHelper.INSTANCE.getSourceTypeLiteral(param.getType());

            // 1 - Add fields
            addField(type, param.getName(), typeValue, Modifier.PROTECTED);

            // 2 - add setter methods
            addSetter(type, param, typeValue);
        }
    }

    @SuppressWarnings("unchecked")
    private void addSetter(TypeDeclaration typeDeclaration, NamedModelElement paramOrVariable, String type) {
        AST ast = typeDeclaration.getAST();
        MethodDeclaration setter = ast.newMethodDeclaration();
        setter.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
        setter.setName(ast.newSimpleName(JavaMethodGenerationHelper.getSetterMethod(paramOrVariable)));

        // 2.1 - method parameters
        SingleVariableDeclaration variableDeclaration = ast.newSingleVariableDeclaration();
        // variableDeclaration.modifiers()(Modifier.NONE);
        variableDeclaration.setType(ast.newSimpleType(ast.newName(type)));
        variableDeclaration.setName(ast.newSimpleName(paramOrVariable.getName()));
        setter.parameters().add(variableDeclaration);

        // 2.2 - body declaration
        Block body = ast.newBlock();

        Assignment assignment = ast.newAssignment();
        FieldAccess fieldAccess = ast.newFieldAccess();
        fieldAccess.setName(ast.newSimpleName(paramOrVariable.getName()));
        fieldAccess.setExpression(ast.newThisExpression());
        assignment.setLeftHandSide(fieldAccess);
        assignment.setOperator(Assignment.Operator.ASSIGN);
        assignment.setRightHandSide(ast.newSimpleName(paramOrVariable.getName()));

        body.statements().add(ast.newExpressionStatement(assignment));
        setter.setBody(body);
        typeDeclaration.bodyDeclarations().add(setter);
    }

    @SuppressWarnings("unchecked")
    private void addField(TypeDeclaration typeDeclaration, String name, String type, int modifiers) {
        AST ast = typeDeclaration.getAST();
        VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
        fragment.setName(ast.newSimpleName(name));
        FieldDeclaration field = ast.newFieldDeclaration(fragment);
        field.modifiers().addAll(ast.newModifiers(modifiers));
        field.setType(ast.newSimpleType(ast.newName(type)));
        typeDeclaration.bodyDeclarations().add(field);
    }

    protected void addSuperClass(TypeDeclaration type) throws PatternException {
        if (pattern.getSuperPattern() != null) {
            String parentClassName = JavaNatureHelper.getClassName(pattern.getSuperPattern());
            AST ast = type.getAST();
            SimpleType newSimpleType = ast.newSimpleType(ast.newName(parentClassName));
            type.setSuperclassType(newSimpleType);
        }
    }

}
