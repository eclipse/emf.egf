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

package org.eclipse.egf.emf.pattern.codegen;

import static org.eclipse.egf.emf.pattern.codegen.CodegenFcoreUtil.N;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.emf.pattern.codegen.model.GIFPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetAbstractPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.pattern.jet.JetTagsConstants;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternDescriptionHandler {

    private static final Pattern EGF_REGEX = Pattern.compile(".fcore#" + JetTagsConstants.LOGICAL_NAME + "=([^\\\"]*)\\\""); //$NON-NLS-1$ //$NON-NLS-2$

    protected IProject codegenProject;

    protected String codegenEMFVersion;

    public CodegenPatternDescriptionHandler(IProject codegenProject) {
        this.codegenProject = codegenProject;
    }

    public void addCodegenEMFVersion(StringBuilder builder, CodegenVersionHelper codegenVersionHelper) throws Exception {
        if (codegenEMFVersion == null) {
            StringBuilder codegenEMFVersionBuilder = new StringBuilder();
            
            codegenEMFVersionBuilder.append(codegenVersionHelper.getEMFCodegenEcoreVersion());
            
            String emfEcoreVersion = codegenVersionHelper.getEMFEcoreVersion();
            if (emfEcoreVersion != null) {
                codegenEMFVersionBuilder.append(" from EMF "); //$NON-NLS-1$
                codegenEMFVersionBuilder.append(emfEcoreVersion);
            }

            codegenEMFVersion = codegenEMFVersionBuilder.toString();
        }

        builder.append(codegenEMFVersion);
    }

    

    public void computeDescription(List<PatternInfo> patternInfos, CodegenVersionHelper codegenVersionHelper) throws Exception {
        for (PatternInfo patternInfo : patternInfos) {
            computeDescription(patternInfo, codegenVersionHelper);
        }
    }

    protected void computeDescription(PatternInfo patternInfo, CodegenVersionHelper codegenVersionHelper) throws Exception {
        StringBuilder builder = new StringBuilder();
        addGeneratedFrom(patternInfo, builder, codegenVersionHelper);
        builder.append(N);
        addCalls(patternInfo, builder);

        patternInfo.setDescription(builder.toString());
    }

    protected void addCalls(PatternInfo patternInfo, StringBuilder builder) {
        boolean calls = false;
        if (patternInfo instanceof JetAbstractPatternInfo) {
            for (MethodInfo methodInfo : patternInfo.getMethods()) {
                if (CodegenPatternMethodContentResolver.DO_GENERATE.equals(methodInfo.getName())) {
                    Matcher matcher = EGF_REGEX.matcher(methodInfo.getContent());
                    while (matcher.find()) {
                        String name = matcher.group(1);
                        if (!calls) {
                            builder.append("This pattern calls:"); //$NON-NLS-1$
                            builder.append(N);
                            calls = true;
                        }

                        builder.append("    * "); //$NON-NLS-1$
                        builder.append(name);
                        builder.append(N);
                    }
                }
            }
        }
    }

    protected void addGeneratedFrom(PatternInfo patternInfo, StringBuilder builder, CodegenVersionHelper codegenVersionHelper) throws Exception {
        builder.append("This pattern was generated from : "); //$NON-NLS-1$

        builder.append("\n"); //$NON-NLS-1$
        builder.append("    * Bundle "); //$NON-NLS-1$
        builder.append(codegenProject.getName());
        builder.append(" "); //$NON-NLS-1$
        addCodegenEMFVersion(builder, codegenVersionHelper);
        
        builder.append("\n"); //$NON-NLS-1$
        builder.append("    * "); //$NON-NLS-1$
        addTemplatePath(builder, patternInfo);
        
        addTemplateVersion(builder, patternInfo, codegenVersionHelper);
    }

    protected void addTemplateVersion(StringBuilder builder, PatternInfo patternInfo, CodegenVersionHelper codegenVersionHelper) throws IOException, CoreException {
        String templateVersion = null;
        if (patternInfo instanceof JetPatternInfo) {
            JetPatternInfo jetPatternInfo = (JetPatternInfo) patternInfo;
            templateVersion = codegenVersionHelper.getTemplateVersion(jetPatternInfo.getJetTemplatePath());
        } else if (patternInfo instanceof JetSubPatternInfo) {
            JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
            JetPatternInfo jetPatternInfo = (JetPatternInfo) jetSubPatternInfo.getSection().getRoot().getPatternInfo();
            templateVersion = codegenVersionHelper.getTemplateVersion(jetPatternInfo.getJetTemplatePath());
        }
        
        if (templateVersion != null)  {
            builder.append("\n"); //$NON-NLS-1$
            builder.append("    * Version "); //$NON-NLS-1$
            builder.append(templateVersion);
        }
    }

    protected void addTemplatePath(StringBuilder builder, PatternInfo patternInfo) {
        if (patternInfo instanceof GIFPatternInfo)
            return;

        if (patternInfo instanceof JetPatternInfo) {
            builder.append("Template \"templates/"); //$NON-NLS-1$
            builder.append(((JetPatternInfo) patternInfo).getJetTemplatePath());
            builder.append("\""); //$NON-NLS-1$
        } else if (patternInfo instanceof JetSubPatternInfo) {
            JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
            JetAbstractPatternInfo rootPatternInfo = jetSubPatternInfo.getSection().getRoot().getPatternInfo();
            addTemplatePath(builder, rootPatternInfo);
        }

    }

}
