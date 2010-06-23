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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.emf.pattern.codegen.model.GIFPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetAbstractPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.MethodInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.pattern.jet.JetTagsConstants;
import org.osgi.framework.Constants;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternDescriptionHandler {

    private static final String ORG_ECLIPSE_EMF_ECORE_VISIBILITY_REEXPORT_BUNDLE_VERSION = "org.eclipse.emf.ecore;visibility:=\"reexport\";bundle-version=\"["; //$NON-NLS-1$

    private static final Pattern MANIFEST_REGEX = Pattern.compile("([a-zA-Z\\-]*):(.*)"); //$NON-NLS-1$

    protected static final Pattern EGF_REGEX = Pattern.compile(".fcore#" + JetTagsConstants.LOGICAL_NAME + "=([^\\\"]*)\\\""); //$NON-NLS-1$ //$NON-NLS-2$

    protected IProject codegenProject;

    protected String codegenEMFVersion;

    public CodegenPatternDescriptionHandler(IProject codegenProject) {
        this.codegenProject = codegenProject;
    }

    public void addCodegenEMFVersion(StringBuilder builder) throws Exception {
        if (codegenEMFVersion == null) {
            StringBuilder codegenEMFVersionBuilder = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                InputStream inputStream = codegenProject.getFile("META-INF/MANIFEST.MF").getContents(); //$NON-NLS-1$
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                Map<String, String> map = new HashMap<String, String>();

                String line;
                String lastKey = ""; //$NON-NLS-1$
                while ((line = bufferedReader.readLine()) != null) {
                    Matcher matcher = MANIFEST_REGEX.matcher(line);
                    if (matcher.matches()) {
                        lastKey = matcher.group(1);
                        map.put(lastKey, matcher.group(2).trim());
                    } else {
                        map.put(lastKey, map.get(lastKey) + line.trim());
                    }
                }

                codegenEMFVersionBuilder.append(map.get(Constants.BUNDLE_VERSION));

                int indexOf = map.get(Constants.REQUIRE_BUNDLE).indexOf(ORG_ECLIPSE_EMF_ECORE_VISIBILITY_REEXPORT_BUNDLE_VERSION);
                if (indexOf > -1) {
                    indexOf = indexOf + ORG_ECLIPSE_EMF_ECORE_VISIBILITY_REEXPORT_BUNDLE_VERSION.length();
                    codegenEMFVersionBuilder.append(" from EMF "); //$NON-NLS-1$
                    codegenEMFVersionBuilder.append(map.get(Constants.REQUIRE_BUNDLE).substring(indexOf, indexOf + 5));
                }
            } finally {
                if (bufferedReader != null)
                    bufferedReader.close();
            }

            codegenEMFVersion = codegenEMFVersionBuilder.toString();
        }

        builder.append(codegenEMFVersion);
    }

    public void computeDescription(List<PatternInfo> patternInfos) throws Exception {
        for (PatternInfo patternInfo : patternInfos) {
            computeDescription(patternInfo);
        }
    }

    protected void computeDescription(PatternInfo patternInfo) throws Exception {
        StringBuilder builder = new StringBuilder();
        addGeneratedFrom(patternInfo, builder);
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

    private void addGeneratedFrom(PatternInfo patternInfo, StringBuilder builder) throws Exception {
        builder.append("This pattern was generated from "); //$NON-NLS-1$
        addTemplatePath(builder, patternInfo);
        builder.append("project "); //$NON-NLS-1$
        builder.append(codegenProject.getName());
        builder.append(" "); //$NON-NLS-1$
        addCodegenEMFVersion(builder);
        builder.append("."); //$NON-NLS-1$
    }

    protected void addTemplatePath(StringBuilder builder, PatternInfo patternInfo) {
        if (patternInfo instanceof GIFPatternInfo)
            return;

        if (patternInfo instanceof JetPatternInfo) {
            builder.append("file \""); //$NON-NLS-1$
            builder.append(((JetPatternInfo) patternInfo).getJetTemplatePath());
            builder.append("\" in "); //$NON-NLS-1$
        } else if (patternInfo instanceof JetSubPatternInfo) {
            JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
            JetAbstractPatternInfo rootPatternInfo = jetSubPatternInfo.getSection().getRoot().getPatternInfo();
            addTemplatePath(builder, rootPatternInfo);
        }

    }

}
