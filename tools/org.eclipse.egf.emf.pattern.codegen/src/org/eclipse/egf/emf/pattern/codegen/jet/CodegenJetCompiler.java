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

import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.ATTRIBUTE_FAIL;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.ATTRIBUTE_FILE;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.BEGIN_EXP;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.BEGIN_JET;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.DIRECTIVE_END;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.DIRECTIVE_INCLUDE;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.DIRECTIVE_JET;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.DIRECTIVE_START;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.END_JET;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.FAIL_ALTERNATIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetTemplateSection.InternalSection;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;


/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenJetCompiler extends JETCompiler {

    private InternalSection currentSection;
    private CodegenJetTemplateSection parentSection;

    protected List<InternalSection> allSections = new ArrayList<InternalSection>();
    protected StringBuffer javaBuffer = new StringBuffer();
    protected IProject codegenProject;

    protected boolean skipNextLine = false;

    public CodegenJetCompiler(IProject codegenProject, String templateURI) throws JETException {
        super(templateURI);
        this.codegenProject = codegenProject;
    }

    @Override
    public void handleCharData(char[] chars) throws JETException {
        if (skipNextLine ) {
            skipNextLine = false;
            if (chars.length > 0 && chars[0] == '\n') {
                if (chars.length == 1)
                    return;
                
                char[] newChars = new char[chars.length - 1];
                System.arraycopy(chars, 1, newChars, 0, chars.length - 1);
                chars = newChars;
            }
        }

        if (currentSection == null)
            enterSection();

        currentSection.getTemplateBuffer().append(chars);
    }

    @Override
    public void handleExpression(JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (currentSection == null)
            enterSection();

        currentSection.getTemplateBuffer().append(BEGIN_EXP);
        currentSection.getTemplateBuffer().append(reader.getChars(start, stop));
        currentSection.getTemplateBuffer().append(END_JET);
    }

    @Override
    public void handleScriptlet(JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (currentSection == null)
            enterSection();

        javaBuffer.append(reader.getChars(start, stop));
        javaBuffer.append("\n"); //$NON-NLS-1$

        currentSection.getTemplateBuffer().append(BEGIN_JET);
        currentSection.getTemplateBuffer().append(reader.getChars(start, stop));
        currentSection.getTemplateBuffer().append(END_JET);
    }

    @Override
    public void handleDirective(String directive, JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (DIRECTIVE_INCLUDE.equals(directive)) {
            String file = attributes.get(ATTRIBUTE_FILE);
            String fail = attributes.get(ATTRIBUTE_FAIL);

            exitSection();
            enterSection();
            currentSection.setFileAttribute(file);
            currentSection.setFailAttribute(fail);

            if (FAIL_ALTERNATIVE.equals(fail)) {
                skipNextLine = true;
                parentSection = currentSection;
            }
            exitSection();
        } else if (DIRECTIVE_START.equals(directive)) {
            skipNextLine = true;
            // ignore me
        } else if (DIRECTIVE_END.equals(directive)) {
            skipNextLine = true;
            parentSection = parentSection.getParent();
            exitSection();
        } else if (DIRECTIVE_JET.equals(directive)) {
            skipNextLine = true;
            javaBuffer.append("package default;\n"); //$NON-NLS-1$
            String[] imports = attributes.get("imports").split(" "); //$NON-NLS-1$ //$NON-NLS-2$
            for (String myImport : imports) {
                javaBuffer.append("import "); //$NON-NLS-1$
                javaBuffer.append(myImport);
                javaBuffer.append(";\n"); //$NON-NLS-1$
            }
            javaBuffer.append("public class MyClass {\n"); //$NON-NLS-1$
            javaBuffer.append("public void myMethod(Object argument) {\n"); //$NON-NLS-1$
        } else
            throw new IllegalStateException("Unknown directive " + directive); //$NON-NLS-1$
    }

    @Override
    public void beginPageProcessing() {
        parentSection = new CodegenJetTemplateSection();
    }

    @Override
    public void parse() throws JETException {
        super.parse();
        exitSection();
        javaBuffer.append("};\n"); //$NON-NLS-1$
        javaBuffer.append("};\n"); //$NON-NLS-1$
        new CodegenJetVariablesResolver(this, codegenProject).computeVariables();
    }

    public CodegenJetTemplateSection getSection() {
        return parentSection;
    }

    protected void enterSection() {
        currentSection = new InternalSection();
        currentSection.setParent(parentSection);
        parentSection.getSections().add(currentSection);

        allSections.add(currentSection);

        currentSection.beginJavaOffset = javaBuffer.length();
        javaBuffer.append(CodegenJetConstants.MARK_STATEMENT);
    }

    protected void exitSection() throws JETException {
        currentSection.endJavaOffset = javaBuffer.length();
        javaBuffer.append(CodegenJetConstants.MARK_STATEMENT);

        currentSection = null;
    }

    public List<InternalSection> getAllSections() {
        return allSections;
    }

    public void setAllSections(List<InternalSection> allSections) {
        this.allSections = allSections;
    }

    public StringBuffer getJavaBuffer() {
        return javaBuffer;
    }

    public void setJavaBuffer(StringBuffer javaBuffer) {
        this.javaBuffer = javaBuffer;
    }

}