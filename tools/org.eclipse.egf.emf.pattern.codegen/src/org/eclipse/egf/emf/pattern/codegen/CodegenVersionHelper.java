/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Constants;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenVersionHelper {

    private static final String ORG_ECLIPSE_EMF_ECORE = "org.eclipse.emf.ecore"; //$NON-NLS-1$

    private static final String META_INF_MANIFEST_MF = "META-INF/MANIFEST.MF"; //$NON-NLS-1$

    private static final String DOT = "."; //$NON-NLS-1$

    private static final String QUALIFIER = "qualifier"; //$NON-NLS-1$

    private static final Pattern MANIFEST_REGEX = Pattern.compile("([a-zA-Z\\-]*):(.*)"); //$NON-NLS-1$

    private IProject codegenProject;

    private IProject fcoreProject;

    public CodegenVersionHelper(IProject codegenProject, IProject fcoreProject) {
        this.codegenProject = codegenProject;
        this.fcoreProject = fcoreProject;
    }

    public Map<String, String> getManifestKeyValues(IProject project) throws CoreException, IOException {
        Map<String, String> manifestKeyValues = new HashMap<String, String>();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = project.getFile(META_INF_MANIFEST_MF).getContents();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            String lastKey = ""; //$NON-NLS-1$
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = MANIFEST_REGEX.matcher(line);
                if (matcher.matches()) {
                    lastKey = matcher.group(1);
                    manifestKeyValues.put(lastKey, matcher.group(2).trim());
                } else {
                    manifestKeyValues.put(lastKey, manifestKeyValues.get(lastKey) + line.trim());
                }
            }

            return manifestKeyValues;
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
    }

    public String getEMFCodegenEcoreVersion() throws CoreException, IOException {
        return getManifestKeyValues(codegenProject).get(Constants.BUNDLE_VERSION);
    }

    public String getEMFEcoreVersion() throws CoreException, IOException {
        Map<String, String> manifestKeyValues = getManifestKeyValues(codegenProject);

        String requireValue = manifestKeyValues.get(Constants.REQUIRE_BUNDLE);
        String version = null;
        int indexOf = requireValue.indexOf(ORG_ECLIPSE_EMF_ECORE);
        if (indexOf > -1) {
            indexOf = requireValue.indexOf("[", indexOf) + 1; //$NON-NLS-1$
            version = requireValue.substring(indexOf, indexOf + 5);
        }

        return version;
    }

    public void replaceManifestVersion() throws CoreException, IOException {
        BufferedReader bufferedReader = null;
        try {
            IFile file = fcoreProject.getFile(META_INF_MANIFEST_MF);
            InputStream inputStream = file.getContents();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            Map<String, String> manifestKeyValues = getManifestKeyValues(fcoreProject);
            String textToReplace = manifestKeyValues.get(Constants.BUNDLE_VERSION);
            String textReplacement = null;
            int indexOf = textToReplace.lastIndexOf(DOT);
            if (indexOf > -1) {
                String emfCodegenEcoreVersion = getEMFCodegenEcoreVersion().replace('.', '_');
                textReplacement = textToReplace.substring(0, indexOf + 1) + emfCodegenEcoreVersion + "_" + QUALIFIER; //$NON-NLS-1$
            }

            StringBuilder buffer = new StringBuilder();
            int ch;
            while ((ch = bufferedReader.read()) != -1)
                buffer.append((char) ch);

            String newContent = buffer.toString().replace(textToReplace, textReplacement);

            InputStream byteArrayInputStream = new ByteArrayInputStream(newContent.getBytes(file.getCharset()));
            file.setContents(byteArrayInputStream, IResource.KEEP_HISTORY, new NullProgressMonitor());
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
    }

    public String getTemplateVersion(String jetTemplatePath) throws IOException, CoreException {
        String result = null;
        IFile file = codegenProject.getFile(new Path("templates").append(jetTemplatePath)); //$NON-NLS-1$
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(file.getContents()));

            String firstline = bufferedReader.readLine();
            if (firstline.contains("jet,")) //$NON-NLS-1$
                result = firstline.substring(firstline.indexOf("jet,") + 4, firstline.length() - 10); //$NON-NLS-1$
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
        return result;
    }
}
