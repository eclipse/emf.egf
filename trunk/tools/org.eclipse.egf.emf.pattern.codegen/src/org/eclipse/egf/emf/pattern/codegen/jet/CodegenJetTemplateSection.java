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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.emf.pattern.codegen.model.JetAbstractPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.VariableInfo;
import org.eclipse.jdt.core.dom.ASTNode;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenJetTemplateSection {

    protected String fileAttribute;
    protected String failAttribute;
    protected CodegenJetTemplateSection parent;

    protected JetAbstractPatternInfo patternInfo;
    
    protected StringBuffer templateBuffer = new StringBuffer();
    protected List<CodegenJetTemplateSection> sections = new ArrayList<CodegenJetTemplateSection>();
    protected List<VariableInfo> beginVariables = new ArrayList<VariableInfo>();
    protected List<VariableInfo> endVariables = new ArrayList<VariableInfo>();

    public static class InternalSection extends CodegenJetTemplateSection {
        
        protected int beginJavaOffset = -1;
        protected int endJavaOffset = -1;

        protected ASTNode beginNode;
        protected ASTNode endNode;

        public int getBeginJavaOffset() {
            return beginJavaOffset;
        }

        public void setBeginJavaOffset(int beginJavaOffset) {
            this.beginJavaOffset = beginJavaOffset;
        }

        public int getEndJavaOffset() {
            return endJavaOffset;
        }

        public void setEndJavaOffset(int endJavaOffset) {
            this.endJavaOffset = endJavaOffset;
        }

        public ASTNode getBeginNode() {
            return beginNode;
        }

        public void setBeginNode(ASTNode beginNode) {
            this.beginNode = beginNode;
        }

        public ASTNode getEndNode() {
            return endNode;
        }

        public void setEndNode(ASTNode endNode) {
            this.endNode = endNode;
        }
    }

    public CodegenJetTemplateSection getRoot() {
        CodegenJetTemplateSection root = parent;
        while (root.getParent() != null)
            root = root.getParent();
        return root;
    }
    
    public CodegenJetTemplateSection getParent() {
        return parent;
    }
    
    public void setParent(CodegenJetTemplateSection parent) {
        this.parent = parent;
    }

    public String getFileAttribute() {
        return fileAttribute;
    }

    public void setFileAttribute(String fileAttribute) {
        this.fileAttribute = fileAttribute;
    }

    public String getFailAttribute() {
        return failAttribute;
    }

    public void setFailAttribute(String failAttribute) {
        this.failAttribute = failAttribute;
    }

    public StringBuffer getTemplateBuffer() {
        return templateBuffer;
    }

    public void setTemplateBuffer(StringBuffer templateBuffer) {
        this.templateBuffer = templateBuffer;
    }

    public void setSections(List<CodegenJetTemplateSection> sections) {
        this.sections = sections;
    }

    public List<CodegenJetTemplateSection> getSections() {
        return sections;
    }

    public List<VariableInfo> getBeginVariables() {
        return beginVariables;
    }

    public List<VariableInfo> getEndVariables() {
        return endVariables;
    }

    public JetAbstractPatternInfo getPatternInfo() {
        return patternInfo;
    }

    public void setPatternInfo(JetAbstractPatternInfo patternInfo) {
        this.patternInfo = patternInfo;
    }

    @Override
    public String toString() {
        return "JetTemplateSection [fileAttribute=" + fileAttribute + ", failAttribute=" + failAttribute + ", templateBufferLength=" + templateBuffer.length() + ", beginVariablesSize=" + beginVariables.size() + ", endVariablesSize=" + endVariables.size() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
    }
}