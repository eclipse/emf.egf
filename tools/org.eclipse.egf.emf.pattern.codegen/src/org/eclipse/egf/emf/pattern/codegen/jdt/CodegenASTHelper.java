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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.emf.pattern.base.ContentType;
import org.eclipse.egf.emf.pattern.codegen.CodegenFcoreUtil;
import org.eclipse.egf.emf.pattern.codegen.model.GIFPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.VariableInfo;
import org.eclipse.egf.emf.pattern.util.PartType;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.internal.core.search.JavaSearchParticipant;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

/**
 * @author Matthieu Helleboid
 * 
 */
@SuppressWarnings("restriction")
public class CodegenASTHelper {

    protected static final String GENERATOR_ABSTRACT_GENERATOR_ADAPTER_CLASSNAME = ".generator.AbstractGeneratorAdapter"; //$NON-NLS-1$

    protected static final String JET_EMITTER_DESCRIPTORS = "JET_EMITTER_DESCRIPTORS"; //$NON-NLS-1$

    protected static final String INPUT_PATH_NAMES = "INPUT_PATH_NAMES"; //$NON-NLS-1$

    protected static final String GENERATE = "generate"; //$NON-NLS-1$

    protected static final String TYPE_GIF_EMITTER = "QGIFEmitter;"; //$NON-NLS-1$

    protected static final String TYPE_JET_EMITTER = "QJETEmitter;"; //$NON-NLS-1$

    protected static final String TYPE_MONITOR = "QMonitor;"; //$NON-NLS-1$

    protected static final String CONDITION_BEGIN = "("; //$NON-NLS-1$

    protected static final String CONDITION_END = ")"; //$NON-NLS-1$

    protected static final String CONDITION_NOT_BEGIN = "(!("; //$NON-NLS-1$

    protected static final String CONDITION_NOT_END = "))"; //$NON-NLS-1$

    protected static final String CONDITION_AND = " && "; //$NON-NLS-1$

    protected CodegenCompilationUnitHelper compilationUnitHelper = new CodegenCompilationUnitHelper();

    public List<PatternInfo> createPatternInfo(IProject codegenProject, IProgressMonitor monitor) throws Exception {
        List<PatternInfo> result = new ArrayList<PatternInfo>();

        IJavaProject javaProject = JavaCore.create(codegenProject);
        Collection<IMethod> contentMethods = computeContentMethods(javaProject);
        for (final IMethod contentMethod : contentMethods) {

            final Map<SearchMatch, IMethod> patternMethods = computeCallingMethods(contentMethod);
            for (final SearchMatch patternMethodSearchMatch : patternMethods.keySet()) {
                IMethod patternMethod = patternMethods.get(patternMethodSearchMatch);
                MethodInvocation contentMethodInvocation = getMethodInvocation(patternMethod, patternMethodSearchMatch);
                MethodDeclaration patternMethodDeclaration = getMethodDeclaration(patternMethod);

                Map<SearchMatch, IMethod> partMethods = computeCallingMethods(patternMethod);
                if (partMethods.size() != 1)
                    throw new IllegalStateException("We should find only one Calling method for " + patternMethod.getElementName()); //$NON-NLS-1$
                Entry<SearchMatch, IMethod> next = partMethods.entrySet().iterator().next();
                SearchMatch partMethodSearchMatch = next.getKey();
                IMethod partMethod = next.getValue();
                MethodInvocation patternMethodInvocation = getMethodInvocation(partMethod, partMethodSearchMatch);

                PatternInfo patternInfo = createPatternInfo(contentMethod);
                patternInfo.setPartType(computePartType(partMethod));
                patternInfo.setMethodName(getNameWithoutGenerate(patternMethod));
                patternInfo.setParameterType(computeParameterType(patternMethod));
                patternInfo.setParameterName(computeParameterName(patternMethod));
                analyseContentMethodParameters(patternInfo, contentMethod, contentMethodInvocation);
                replaceLocalVariables(patternMethodDeclaration, patternInfo);

                if (ContentType.GIF.equals(patternInfo.getContentType()))
                    ((GIFPatternInfo) patternInfo).setMethodContent(computeMethodContent(patternMethodDeclaration));
                else {
                    ArrayList<String> conditions = new ArrayList<String>();
                    conditions.addAll(getMethodInvocationCondition(patternMethodInvocation));
                    conditions.addAll(getMethodInvocationCondition(contentMethodInvocation));
                    ((JetPatternInfo) patternInfo).setCondition(getConditionString(conditions));
                }

                result.add(patternInfo);

                monitor.worked(20);
            }
        }

        return result;
    }

    protected void replaceLocalVariables(MethodDeclaration methodDeclaration, final PatternInfo patternInfo) {
        if (patternInfo instanceof GIFPatternInfo)
            return;

        ASTVisitor astVisitor = new ASTVisitor() {

            @SuppressWarnings("unchecked")
            @Override
            public boolean visit(VariableDeclarationStatement node) {
                List<VariableDeclarationFragment> fragments = node.fragments();
                for (VariableDeclarationFragment fragment : fragments) {
                    String name = fragment.getName().toString();
                    String expression = fragment.getInitializer().toString();
                    List<VariableInfo> variableInfos = patternInfo.getVariableInfos();
                    for (VariableInfo variableInfo : variableInfos) {
                        variableInfo.setValue(variableInfo.getValue().replace(name, expression));
                    }
                }
                return true;
            }
        };
        methodDeclaration.accept(astVisitor);
    }

    @SuppressWarnings("unchecked")
    protected String computeMethodContent(MethodDeclaration methodDeclaration) {
        StringBuffer buffer = new StringBuffer();

        List<Statement> statements = methodDeclaration.getBody().statements();
        for (Statement statement : statements) {
            buffer.append(statement.toString());
        }

        return buffer.toString();
    }

    protected PartType computePartType(IMethod partMethod) {
        String partTypeString = getNameWithoutGenerate(partMethod);
        return PartType.valueOf(partTypeString);
    }

    protected PatternInfo createPatternInfo(IMethod contentMethod) {
        String contentString = getNameWithoutGenerate(contentMethod);
        ContentType contentType = ContentType.valueOf(contentString);

        PatternInfo patternInfo = null;
        if (ContentType.GIF.equals(contentType)) {
            patternInfo = new GIFPatternInfo();
        } else {
            patternInfo = new JetPatternInfo();
        }

        patternInfo.setContentType(contentType);
        return patternInfo;
    }

    protected String computeParameterName(IMethod patternMethod) throws JavaModelException {
        return patternMethod.getParameterNames()[0];
    }

    protected String computeParameterType(final IMethod patternMethod) {
        String patternMethodObjectType = patternMethod.getParameterTypes()[0];
        return patternMethodObjectType.substring(1, patternMethodObjectType.length() - 1);
    }

    protected void analyseContentMethodParameters(PatternInfo patternInfo, final IMethod contentMethod, MethodInvocation contentMethodInvocation) throws JavaModelException {
        if (contentMethodInvocation.arguments().size() != contentMethod.getParameterTypes().length)
            throw new IllegalStateException("Method and Method invocations should have the same number of arguments"); //$NON-NLS-1$
        for (int i = 0; i < contentMethod.getParameterTypes().length; i++) {
            String parameterType = contentMethod.getParameterTypes()[i];
            String parameterName = contentMethod.getParameterNames()[i];
            Expression argumentExpression = (Expression) contentMethodInvocation.arguments().get(i);

            if (TYPE_MONITOR.equals(parameterType)) {
                // ignore the monitor argument
            } else if (TYPE_JET_EMITTER.equals(parameterType)) {
                computeTemplatePath((JetPatternInfo) patternInfo, argumentExpression);
            } else if (TYPE_GIF_EMITTER.equals(parameterType)) {
                computeGIFPath((GIFPatternInfo) patternInfo, argumentExpression);
            } else {
                patternInfo.getVariableInfos().add(computeVariable(parameterType, parameterName, argumentExpression));
            }
        }
    }

    protected VariableInfo computeVariable(String parameterType, String parameterName, Expression argumentExpression) {
        String value = null;

        Object resolveConstantExpressionValue = argumentExpression.resolveConstantExpressionValue();
        if (resolveConstantExpressionValue != null && argumentExpression instanceof SimpleName)
            value = "\"" + resolveConstantExpressionValue + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        else if (resolveConstantExpressionValue != null)
            value = resolveConstantExpressionValue.toString();
        else
            value = argumentExpression.toString();

        return new VariableInfo(parameterType, parameterName, value);
    }

    protected void computeGIFPath(GIFPatternInfo patternInfo, Expression argumentExpression) {
        int idValue = getArrayIndex(argumentExpression);

        List<Expression> arrayValues = new ArrayList<Expression>();
        computeArrayValues(argumentExpression, INPUT_PATH_NAMES, arrayValues);

        String gifPath = ((StringLiteral) arrayValues.get(idValue)).getLiteralValue();

        patternInfo.setGifPath(gifPath);
    }

    protected void computeTemplatePath(JetPatternInfo patternInfo, Expression argumentExpression) {
        int idValue = getArrayIndex(argumentExpression);

        List<Expression> arrayValues = new ArrayList<Expression>();
        computeArrayValues(argumentExpression, JET_EMITTER_DESCRIPTORS, arrayValues);

        ClassInstanceCreation arrayValue = (ClassInstanceCreation) arrayValues.get(idValue);
        String templatePath = ((StringLiteral) arrayValue.arguments().get(0)).getLiteralValue();
        String className = ((StringLiteral) arrayValue.arguments().get(1)).getLiteralValue();

        patternInfo.setJetTemplatePath(templatePath);
        patternInfo.setJetClassName(className);
    }

    protected void computeArrayValues(Expression argumentExpression, final String VariableName, final List<Expression> arrayValues) {
        ASTVisitor astVisitor = new ASTVisitor() {

            @Override
            @SuppressWarnings("unchecked")
            public boolean visit(VariableDeclarationFragment node) {
                if (VariableName.equals(node.getName().getIdentifier())) {
                    if (node.getInitializer() != null && node.getInitializer() instanceof ArrayInitializer) {
                        ArrayInitializer arrayInitializer = (ArrayInitializer) node.getInitializer();
                        for (Iterator<Object> iterator = arrayInitializer.expressions().iterator(); iterator.hasNext();)
                            arrayValues.add((Expression) iterator.next());
                    }
                }
                return true;
            }
        };
        CompilationUnit compilationUnit = (CompilationUnit) argumentExpression.getRoot();
        compilationUnit.accept(astVisitor);
    }

    protected int getArrayIndex(Expression argumentExpression) {
        SimpleName id = (SimpleName) ((MethodInvocation) argumentExpression).arguments().get(1);
        return (Integer) id.resolveConstantExpressionValue();
    }

    protected List<String> getMethodInvocationCondition(ASTNode node) {
        List<String> conditions = new ArrayList<String>();
        while (true) {
            ASTNode parent = node.getParent();
            if (parent == null)
                throw new IllegalStateException("We should have found a Method Declaration as a parent"); //$NON-NLS-1$

            if (node instanceof MethodDeclaration) {
                return conditions;
            }

            if (parent instanceof IfStatement) {
                IfStatement ifStatement = (IfStatement) parent;
                if (ifStatement.getThenStatement() == node)
                    conditions.add(CONDITION_BEGIN + ifStatement.getExpression() + CONDITION_END);
                else if (ifStatement.getElseStatement() == node)
                    conditions.add(CONDITION_NOT_BEGIN + ifStatement.getExpression() + CONDITION_NOT_END);
                else
                    throw new IllegalStateException("Node should be part of the parent IfStatement"); //$NON-NLS-1$
            }

            node = parent;
        }
    }

    protected String getConditionString(List<String> conditions) {
        if (conditions.size() == 0)
            return null;

        StringBuffer buffer = new StringBuffer();
        for (String string : conditions) {
            if (buffer.length() > 0)
                buffer.append(CONDITION_AND);
            buffer.append(string);
        }
        return buffer.toString();
    }

    protected MethodInvocation getMethodInvocation(final IMethod patternMethod, final SearchMatch searchMatch) throws JavaModelException {
        MethodDeclaration methodDeclaration = getMethodDeclaration(patternMethod);

        final List<MethodInvocation> invocations = new ArrayList<MethodInvocation>();

        ASTVisitor astVisitor = new ASTVisitor() {

            @Override
            public boolean visit(MethodInvocation node) {
                if (node.getStartPosition() == searchMatch.getOffset() && node.getLength() == searchMatch.getLength()) {
                    invocations.add(node);
                }
                return true;
            }
        };
        methodDeclaration.accept(astVisitor);

        if (invocations.size() != 1)
            throw new IllegalStateException("One method invocation should be found"); //$NON-NLS-1$

        return invocations.get(0);
    }

    protected String getNameWithoutGenerate(IMethod method) {
        if (!method.getElementName().startsWith(GENERATE))
            throw new IllegalStateException("The method name should start with " + GENERATE); //$NON-NLS-1$
        return method.getElementName().substring(GENERATE.length());
    }

    protected MethodDeclaration getMethodDeclaration(final IMethod method) throws JavaModelException {
        CompilationUnit compilationUnit = compilationUnitHelper.getCompilationUnit(method);
        return ASTNodeSearchUtil.getMethodDeclarationNode(method, compilationUnit);
    }

    protected Map<SearchMatch, IMethod> computeCallingMethods(final IMethod method) throws CoreException {
        final Map<SearchMatch, IMethod> callingMethods = new HashMap<SearchMatch, IMethod>();
        IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaProject[] {
            method.getJavaProject()
        }, IJavaSearchScope.SOURCES);
        SearchPattern pattern = SearchPattern.createPattern(method, IJavaSearchConstants.REFERENCES);
        SearchRequestor requestor = new SearchRequestor() {

            @Override
            public void acceptSearchMatch(SearchMatch match) throws CoreException {
                Object element = match.getElement();
                if (element instanceof IMethod) {
                    IMethod callingMethod = (IMethod) element;
                    callingMethods.put(match, callingMethod);
                }
            }

        };
        new SearchEngine().search(pattern, new SearchParticipant[] {
            new JavaSearchParticipant()
        }, scope, requestor, null);
        return callingMethods;
    }

    protected Collection<IMethod> computeContentMethods(IJavaProject javaProject) throws JavaModelException {
        IType type = javaProject.findType(CodegenFcoreUtil.ORG_ECLIPSE_EMF_CODEGEN_ECORE + GENERATOR_ABSTRACT_GENERATOR_ADAPTER_CLASSNAME);
        Collection<IMethod> generateContentMethods = new ArrayList<IMethod>();
        for (IMethod method : type.getMethods()) {
            if (method.getElementName().startsWith(GENERATE) && method.getElementName().length() > GENERATE.length()) {
                generateContentMethods.add(method);
            }
        }
        return generateContentMethods;
    }

}
