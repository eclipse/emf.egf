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

import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.AT;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.BEGIN_JET;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.END_JET;
import static org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetConstants.SPACE;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.ARGS;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.ARGS_SEPARATOR;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.LOGICAL_NAME;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.MATCH_SEPARATOR;
import static org.eclipse.egf.pattern.jet.JetTagsConstants.PATTERN_ID;

import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.emf.pattern.codegen.CodegenFcoreUtil;
import org.eclipse.egf.emf.pattern.codegen.CodegenPatternHelper;
import org.eclipse.egf.emf.pattern.codegen.model.JetAbstractPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.VariableInfo;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.jet.JetTagsConstants;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenJetPatternHelper {

    protected CodegenPatternHelper codegenPatternHelper;
    protected IProject codegenProject;
    protected Resource emfPatternBaseResource;
    protected Resource emfPatternResource;

    public CodegenJetPatternHelper(CodegenPatternHelper codegenPatternHelper, IProject codegenProject, Resource emfPatternBaseResource, Resource emfPatternResource) {
        this.codegenPatternHelper = codegenPatternHelper;
        this.codegenProject = codegenProject;
        this.emfPatternBaseResource = emfPatternBaseResource;
        this.emfPatternResource = emfPatternResource;
    }

    public void computeJetSubPatternInfo(List<PatternInfo> patternInfos) throws Exception {
        Map<String, JetAbstractPatternInfo> newPatternInfos = new LinkedHashMap<String, JetAbstractPatternInfo>();

        for (PatternInfo patternInfo : patternInfos) {
            if (patternInfo instanceof JetPatternInfo) {
                JetPatternInfo jetPatternInfo = (JetPatternInfo) patternInfo;

                String templateURI = getTemplateURI(jetPatternInfo.getJetTemplatePath());

                CodegenJetCompiler codegenJetCompiler = new CodegenJetCompiler(codegenProject, templateURI);
                codegenJetCompiler.parse();
                computeJetSubPatternInfo(patternInfos, newPatternInfos, jetPatternInfo, jetPatternInfo, codegenJetCompiler.getSection());
            }
        }

        patternInfos.addAll(newPatternInfos.values());
    }

    protected void computeJetSubPatternInfo(List<PatternInfo> patternInfos, Map<String, JetAbstractPatternInfo> newPatternInfos, JetPatternInfo rootPatternInfo, JetAbstractPatternInfo patternInfo, CodegenJetTemplateSection section) {
        if (patternInfo != null) {
            patternInfo.setSection(section);
            section.setPatternInfo(patternInfo);
        } else if (section.fileAttribute != null && CodegenJetConstants.INCLUDE_HEADER_REGEX.matcher(section.fileAttribute).matches()) {
            // ignore predefined Header Pattern
        } else {
            if (section.fileAttribute != null) {
                replaceFileAttribute(patternInfos, section, rootPatternInfo);

                if (newPatternInfos.containsKey(section.fileAttribute)) {
                    CodegenJetTemplateSection previousSection = newPatternInfos.get(section.fileAttribute).getSection();
                    if (CodegenJetConstants.FAIL_ALTERNATIVE.equals(section.failAttribute)) {
                        if (!sameContent(section, previousSection)) {
                            throw new IllegalStateException("Duplicate alternative include declaration with different content"); //$NON-NLS-1$
                        }
                    }
                    //only keep common variablesInfo
                    previousSection.getPatternInfo().getVariableInfos().retainAll(section.beginVariables);
                } else {
                    patternInfo = new JetSubPatternInfo();
                    patternInfo.setSection(section);
                    patternInfo.setContentType(rootPatternInfo.getContentType());
                    patternInfo.setPartType(rootPatternInfo.getPartType());
                    patternInfo.setVariableInfos(section.beginVariables);
                    newPatternInfos.put(section.fileAttribute, patternInfo);
                }

                section.setPatternInfo(newPatternInfos.get(section.fileAttribute));
            }
        }

        for (CodegenJetTemplateSection subSection : section.getSections()) {
            computeJetSubPatternInfo(patternInfos, newPatternInfos, rootPatternInfo, null, subSection);
        }
    }

    protected boolean sameContent(CodegenJetTemplateSection section, CodegenJetTemplateSection previousSection) {
        return getTestContent(section).equals(getTestContent(previousSection));
    }

    protected String getTestContent(CodegenJetTemplateSection section) {
        StringBuilder buffer = new StringBuilder();
        for (CodegenJetTemplateSection subSection : section.getSections()) {
            for (int i =0; i < subSection.templateBuffer.length() ; i++) {
                char charAt = subSection.templateBuffer.charAt(i);
                if (charAt != ' ' && charAt != '\n' && charAt != '\r'  && charAt != '\t' )
                    buffer.append(charAt);
            }
        }
        return buffer.toString();
    }

    protected void replaceFileAttribute(List<PatternInfo> patternInfos, CodegenJetTemplateSection section, JetPatternInfo rootPatternInfo) {
        String rootJetTemplateName = new Path(rootPatternInfo.getJetTemplatePath()).removeFileExtension().lastSegment();
        String fileAttributeParentName = new Path(section.fileAttribute).segment(0);
        String fileAttributeName = new Path(section.fileAttribute).segment(1);

        if (!fileAttributeParentName.equals(rootJetTemplateName)) {
            // the subSection is contained in another template
            // so will find the good one
            rootPatternInfo = null;
            for (PatternInfo patternInfo : patternInfos) {
                if (patternInfo instanceof JetPatternInfo) {
                    JetPatternInfo jetPatternInfo = (JetPatternInfo) patternInfo;
                    rootJetTemplateName = new Path(jetPatternInfo.getJetTemplatePath()).removeFileExtension().lastSegment();
                    if (rootJetTemplateName.equals(fileAttributeParentName)) {
                        if (rootPatternInfo != null)
                            throw new IllegalStateException("Found two jet¨PatternInfo"); //$NON-NLS-1$
                        rootPatternInfo = jetPatternInfo;
                    }
                }
            }
        }

        if (rootPatternInfo == null)
            throw new IllegalStateException("Found no jet¨PatternInfo"); //$NON-NLS-1$

        IPath newPath = new Path(rootPatternInfo.getName()).append(fileAttributeName);
        section.fileAttribute = newPath.toString();
    }

    protected String getTemplateURI(String templateRelativePath) throws MalformedURLException {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(CodegenFcoreUtil.ORG_ECLIPSE_EMF_CODEGEN_ECORE);
        IResource member = project.findMember(new Path("templates").append(templateRelativePath)); //$NON-NLS-1$
        return member.getLocationURI().toString();
    }

    public String getContent(CodegenJetTemplateSection parentSection) {
        StringBuilder buffer = new StringBuilder();
        for (CodegenJetTemplateSection section : parentSection.getSections()) {
            if (section.fileAttribute != null) {
                String id = null;
                String headerName = null;
                String callType = JetTagsConstants.EGF_PATTERN_CALL;

                Matcher matcher = CodegenJetConstants.INCLUDE_HEADER_REGEX.matcher(section.fileAttribute);
                if (matcher.find()) {
                    headerName = matcher.group(1);

                    String patternHeaderName = "Header" + headerName.substring(0, 1).toUpperCase() + headerName.substring(1).toLowerCase(); //$NON-NLS-1$
                    Pattern calledPattern = codegenPatternHelper.findPattern(emfPatternBaseResource, patternHeaderName);
                    id = getPatternURI(emfPatternBaseResource, calledPattern.getName(), calledPattern.getContainer().getName());
                } else {
                    id = getPatternURI(emfPatternResource, section.getPatternInfo().getName(), section.getPatternInfo().getLibraryName());
                }

                buffer.append(BEGIN_JET);
                buffer.append(AT);
                buffer.append(SPACE);
                buffer.append(callType);
                buffer.append(SPACE);
                buffer.append(PATTERN_ID);
                buffer.append("=\""); //$NON-NLS-1$
                buffer.append(id);
                buffer.append("\""); //$NON-NLS-1$
                buffer.append(SPACE);

                if (headerName != null) {
                    buffer.append(ARGS);
                    buffer.append("=\"parameter:argument\""); //$NON-NLS-1$
                } else {
                    if (section.getPatternInfo().getVariableInfos().size() > 0) {
                        buffer.append(ARGS);
                        buffer.append("=\""); //$NON-NLS-1$
                        for (VariableInfo variableInfo : section.getPatternInfo().getVariableInfos()) {
                            if (section.getPatternInfo().getVariableInfos().indexOf(variableInfo) > 0)
                                buffer.append(ARGS_SEPARATOR);
                            buffer.append(variableInfo.getName());
                            buffer.append(MATCH_SEPARATOR);
                            buffer.append(variableInfo.getName());
                        }
                        buffer.append("\""); //$NON-NLS-1$
                    }
                }

                buffer.append(END_JET);
            } else {
                buffer.append(section.templateBuffer.toString());
            }
        }

        return buffer.toString();
    }

    protected String getPatternURI(Resource resource, String name, String libraryName) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(LOGICAL_NAME);
        buffer.append("="); //$NON-NLS-1$
        buffer.append(libraryName);
        buffer.append("."); //$NON-NLS-1$
        buffer.append(name);
        return resource.getURI().appendFragment(buffer.toString()).toString();
    }

}
