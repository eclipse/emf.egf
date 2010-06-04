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

package parsejet.test2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.IfStatement;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenJetParser extends JETCompiler {

    private static final String DIRECTIVE_JET = "jet"; //$NON-NLS-1$
    private static final String DIRECTIVE_INCLUDE = "include"; //$NON-NLS-1$
    private static final String DIRECTIVE_END = "end"; //$NON-NLS-1$
    private static final String DIRECTIVE_START = "start"; //$NON-NLS-1$

    private static final String ATTRIBUTE_FAIL = "fail"; //$NON-NLS-1$
    private static final String ATTRIBUTE_FILE = "file"; //$NON-NLS-1$

    private static final String FAIL_ALTERNATIVE = "alternative"; //$NON-NLS-1$
    private static final String FAIL_SILENT = "silent"; //$NON-NLS-1$

    private StringBuilder buffer = new StringBuilder();
    protected List<char[]> charsList = new ArrayList<char[]>();

    public CodegenJetParser(String templateURI) throws JETException {
        super(templateURI);
    }

    @Override
    public void parse() throws JETException {
        super.parse();
        findAstNodes();
    }

    @Override
    public void handleCharData(char[] chars) throws JETException {
        addMarkStatement(Mark.EGFMarkChars, this.charsList.size());
        this.charsList.add(chars);
    }

    @Override
    public void handleExpression(JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        addMarkStatement(Mark.EGFMarkExpression, this.charsList.size());
        this.charsList.add(reader.getChars(start, stop));
    }

    @Override
    public void handleScriptlet(JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        buffer.append(reader.getChars(start, stop));
        buffer.append("\n"); //$NON-NLS-1$
    }

    @Override
    public void handleDirective(String directive, JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (DIRECTIVE_INCLUDE.equals(directive)) {
            String file = attributes.get(ATTRIBUTE_FILE);
            String fail = attributes.get(ATTRIBUTE_FAIL);

            if (FAIL_ALTERNATIVE.equals(fail)) {
                buffer.append("{\n"); //$NON-NLS-1$
                addMarkStatement(Mark.EGFMarkIncludeAlternative, file);
            } else if (FAIL_SILENT.equals(fail)) {
                addMarkStatement(Mark.EGFMarkIncludeSilent, file);
            } else {
                addMarkStatement(Mark.EGFMarkInclude, file);
            }
        } else if (DIRECTIVE_START.equals(directive)) {
            addMarkStatement(Mark.EGFMarkStart);
        } else if (DIRECTIVE_END.equals(directive)) {
            addMarkStatement(Mark.EGFMarkEnd);
            buffer.append("}\n"); //$NON-NLS-1$
        } else if (DIRECTIVE_JET.equals(directive)) {
            // ignore me
        } else
            throw new IllegalStateException("Unknown directive " + directive); //$NON-NLS-1$
    }

    protected void addMarkStatement(Mark mark, Object... attributes) {
        buffer.append("new "); //$NON-NLS-1$
        buffer.append(mark.toString());
        buffer.append("("); //$NON-NLS-1$
        for (int i = 0; i < attributes.length; i++) {
            Object attribute = attributes[i];
            buffer.append("\""); //$NON-NLS-1$
            buffer.append(attribute);
            buffer.append("\""); //$NON-NLS-1$
            if (i < attributes.length - 1)
                buffer.append(","); //$NON-NLS-1$
        }
        buffer.append(");\n"); //$NON-NLS-1$
    }

    protected void findAstNodes() {
        ASTParser astParser = ASTParser.newParser(AST.JLS3);
        astParser.setKind(ASTParser.K_STATEMENTS);
        astParser.setSource(buffer.toString().toCharArray());
        Map<String, String> options = new HashMap<String, String>();
        JavaCore.setComplianceOptions("1.5", options); //$NON-NLS-1$
        astParser.setCompilerOptions(options);
        ASTNode astNode = astParser.createAST(new NullProgressMonitor());

        StructureVisitor structureVisitor = new StructureVisitor(this);
        structureVisitor.section = new Section((Block) astNode);
        astNode.accept(structureVisitor);

        PrintVisitor printVisitor = new PrintVisitor(this);
        astNode.accept(printVisitor);

        try {
            FileWriter fileWriter = new FileWriter("C:/test");
            fileWriter.write(buffer.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("C:/test2");
            fileWriter.write(printVisitor.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        
        printSection(structureVisitor.section, 0);
    }

    List<ASTNode> nodes = new ArrayList<ASTNode>();

    private void printSection(Section section, int i) {
        for (int j = 0; j < i; j++)
            System.out.print("  ");

        System.out.print("section ");
        if (section.node instanceof ClassInstanceCreation) {
            ClassInstanceCreation cic = (ClassInstanceCreation) section.node;
            System.out.print(getMark(cic));
            System.out.print(" ");
            System.out.print(getArguments(cic).get(0));
        } else if (section.node instanceof EnhancedForStatement) {
            EnhancedForStatement efs = (EnhancedForStatement) section.node;
            System.out.print("foreach " + efs.getExpression());
        } else if (section.node instanceof IfStatement) {
            IfStatement is = (IfStatement) section.node;
            System.out.print("if " + is.getExpression());
        }

        for (ASTNode node : nodes)
            if (node == section.node)
                System.out.print("************");

        nodes.add(section.node);

        System.out.println("");

        for (Section subSection : section.subSections) {
            printSection(subSection, i + 1);
        }
    }

    protected Mark getMark(ClassInstanceCreation node) {
        try {
            return Mark.valueOf(node.getType().toString());
        } catch (Exception e) {
            return null;
        }
    }

    protected List<String> getArguments(ClassInstanceCreation node) {
        List<String> arguments = new ArrayList<String>();
        for (Object object : node.arguments()) {
            String string = object.toString();
            arguments.add(string.substring(1, string.length() - 1));
        }
        return arguments;
    }
}