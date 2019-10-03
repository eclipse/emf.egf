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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenPatternNameResolver {

    private static final String ORG_ECLIPSE_EGF_EMF_PATTERN = "org.eclipse.egf.emf.pattern."; //$NON-NLS-1$

    protected CodegenPatternHelper codegenPatternHelper;

    public CodegenPatternNameResolver(CodegenPatternHelper codegenPatternHelper) {
        super();
        this.codegenPatternHelper = codegenPatternHelper;
    }

    public void computePatternName(Collection<PatternInfo> patternInfos) {
        // try to use JetClassName for Name
        findUniqueNameInLibrary(patternInfos, new JetClassNameResolver());
        // else try to use methodName
        findUniqueNameInLibrary(patternInfos, new MethodNameResolver());
        // else try to use GIF for parameter
        findUniqueNameInLibrary(patternInfos, new MethodNameForParameterTypeNameResolver());
        // else try to use fileAttribute
        findUniqueNameInLibrary(patternInfos, new FileAttributeNameResolver());

        for (PatternInfo patternInfo : patternInfos) {
            if (patternInfo.getName() == null || patternInfo.getLibraryName() == null) {
                throw new IllegalStateException("The name wasn't resolved for " + patternInfo); //$NON-NLS-1$
            }
        }
    }

    protected void findUniqueNameInLibrary(Collection<PatternInfo> patternInfos, NameResolver nameResolver) {
        Map<String, List<PatternInfo>> map = new HashMap<String, List<PatternInfo>>();
        for (PatternInfo patternInfo : patternInfos) {
            if ((patternInfo.getName() == null || patternInfo.getLibraryName() == null) && nameResolver.canResolve(patternInfo)) {
                String tempName = nameResolver.getName(patternInfo);
                String tempLibraryName = nameResolver.getLibraryName(patternInfo);
                if (tempName != null && tempLibraryName != null) {
                    String key = tempLibraryName + "." + tempName; //$NON-NLS-1$
                    List<PatternInfo> list = map.get(key);
                    if (list == null) {
                        list = new ArrayList<PatternInfo>();
                        map.put(key, list);
                    }
                    list.add(patternInfo);
                }
            }
        }

        for (String key : map.keySet()) {
            List<PatternInfo> list = map.get(key);
            if (list.size() == 1)
                nameResolver.assignNames(list.get(0));
        }
    }

    protected abstract class NameResolver {

        public abstract boolean canResolve(PatternInfo patternInfo);

        public abstract String getName(PatternInfo patternInfo);

        public String getLibraryName(PatternInfo patternInfo) {
            return ORG_ECLIPSE_EGF_EMF_PATTERN + patternInfo.getPartType().toString().toLowerCase();
        }

        public void assignNames(PatternInfo patternInfo) {
            patternInfo.setName(getName(patternInfo));
            patternInfo.setLibraryName(getLibraryName(patternInfo));
        }
    }

    protected class JetClassNameResolver extends NameResolver {

        @Override
        public boolean canResolve(PatternInfo patternInfo) {
            if (patternInfo instanceof JetPatternInfo) {
                JetPatternInfo jetPatternInfo = (JetPatternInfo) patternInfo;
                return jetPatternInfo.getJetClassName() != null;
            }
            return false;
        }

        @Override
        public String getName(PatternInfo patternInfo) {
            JetPatternInfo jetPatternInfo = (JetPatternInfo) patternInfo;
            return jetPatternInfo.getJetClassName().substring(jetPatternInfo.getJetClassName().lastIndexOf(".") + 1); //$NON-NLS-1$
        }

    }

    protected class MethodNameForParameterTypeNameResolver extends NameResolver {

        @Override
        public boolean canResolve(PatternInfo patternInfo) {
            return patternInfo.getMethodName() != null && patternInfo.getParameterType() != null;
        }

        @Override
        public String getName(PatternInfo patternInfo) {
            return patternInfo.getMethodName() + "For" + patternInfo.getParameterType(); //$NON-NLS-1$
        }

    }

    protected class MethodNameResolver extends NameResolver {

        @Override
        public boolean canResolve(PatternInfo patternInfo) {
            return patternInfo.getMethodName() != null;
        }

        @Override
        public String getName(PatternInfo patternInfo) {
            return patternInfo.getMethodName();
        }

    }

    protected class FileAttributeNameResolver extends NameResolver {

        @Override
        public boolean canResolve(PatternInfo patternInfo) {
            if (patternInfo instanceof JetSubPatternInfo) {
                JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
                if (jetSubPatternInfo.getSection() == null)
                    return false;
                String fileAttribute = jetSubPatternInfo.getSection().getFileAttribute();
                if (fileAttribute == null)
                    return false;
                return new Path(fileAttribute).segmentCount() == 2;
            }
            return false;
        }

        @Override
        public String getName(PatternInfo patternInfo) {
            JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
            Path path = new Path(jetSubPatternInfo.getSection().getFileAttribute());
            return path.segment(0) + "." + path.removeFileExtension().segment(1); //$NON-NLS-1$
        }

        @Override
        public String getLibraryName(PatternInfo patternInfo) {
            JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
            Path path = new Path(jetSubPatternInfo.getSection().getFileAttribute());
            return super.getLibraryName(jetSubPatternInfo) + ".call." + path.segment(0); //$NON-NLS-1$
        }
    }
}
