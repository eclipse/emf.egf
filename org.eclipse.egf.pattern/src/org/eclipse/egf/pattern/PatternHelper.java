/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternSuperMethod;
import org.eclipse.egf.model.pattern.PatternUnit;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Guiu
 * 
 */
public abstract class PatternHelper {
    protected final Pattern pattern;
    protected final StringBuilder content = new StringBuilder(1000);
    // Every called pattern owns its list of parameters, we need to create all
    // needed alias (Validation ensure that they can be matched)
    protected List<List<String>> parameterAlias;

    public PatternHelper(Pattern pattern) {
        super();
        this.pattern = pattern;
    }

    public String visit() throws PatternException {
        String read = getContent(pattern.getHeaderMethod());
        if (read != null)
            content.append(read);

        int insertionIndex = content.length();

        doVisit(pattern);

        if (!parameterAlias.isEmpty())
            handleParameters(insertionIndex);

        read = getContent(pattern.getFooterMethod());
        if (read != null)
            content.append(read);

        return content.toString();
    }

    /**
     * This method may code to handle parameter at the insertionIndex and at the
     * current index. The inserted code is mainly a kind of loop containing the
     * pattern body over the result of the query.
     */
    protected abstract void handleParameters(int insertionIndex);

    // TODO mark this method abstract as its implementation depends on the
    // nature of pattern.

    private void doVisit(Pattern pattern) throws PatternException {
        if (parameterAlias == null) {
            parameterAlias = new ArrayList<List<String>>();
            for (PatternParameter param : pattern.getParameters()) {
                List<String> names = new ArrayList<String>();
                names.add(param.getName());
                parameterAlias.add(names);
            }
        } else {
            for (int i = 0; i < pattern.getParameters().size(); i++) {
                List<String> names = parameterAlias.get(i);
                names.add(pattern.getParameters().get(i).getName());
            }
        }
        for (PatternUnit element : pattern.getOrchestration()) {
            String read = getContent(element);
            if (read != null)
                content.append(read);
        }
    }

    private String getContent(PatternUnit unit) throws PatternException {
        final ObjectHolder<PatternException> holder = new ObjectHolder<PatternException>();
        String result = new PatternSwitch<String>() {

            @Override
            public String casePatternLibrary(PatternLibrary object) {
                throw new UnsupportedOperationException("not implemented yet");
            }

            @Override
            public String casePattern(Pattern object) {
                try {
                    doVisit(object);
                } catch (PatternException e) {
                    holder.object = new PatternException(e);
                }
                return "";
            }

            @Override
            public String casePatternMethod(PatternMethod object) {
                URI uri = object.getPatternFilePath();
                try {
                    return FileHelper_to_be_upgraded.getContent(getPlatformFactoryComponent(object.getPattern()), uri);
                } catch (CoreException e) {
                    holder.object = new PatternException(e);
                } catch (IOException e) {
                    holder.object = new PatternException(e);
                }
                return "";
            }

            @Override
            public String casePatternSuperMethod(PatternSuperMethod object) {
                String name = object.getName();
                if (name == null)
                    throw new IllegalArgumentException();
                PatternMethod method = pattern.getMethod(name);
                if (method == null)
                    throw new IllegalStateException("Cannot find method '" + name + "'");
                return casePatternMethod(method);
            }

            @Override
            public String defaultCase(EObject object) {

                throw new IllegalStateException("unexpected type: " + object.eClass().getName());
            }

        }.doSwitch(unit);

        if (holder.object != null)
            throw holder.object;
        return result;
    }

    /**
     * This method return a string from the libraries who contain the pattern.
     * For example: myLib.mySubLib
     */
    public static String getFullLibraryName(Pattern pattern) {
        List<PatternLibrary> libs = new ArrayList<PatternLibrary>();
        PatternLibrary lib = pattern.getContainer();
        while (lib != null) {
            libs.add(lib);
            lib = lib.getContainer();
        }
        if (libs.isEmpty())
            return "";
        if (libs.size() == 1)
            return libs.get(0).getName();
        StringBuffer buf = new StringBuffer();
        for (PatternLibrary mylib : libs) {
            buf.append(mylib.getName()).append('.');
        }
        return buf.deleteCharAt(buf.length() - 1).toString();
    }

    public static IPlatformFactoryComponent getPlatformFactoryComponent(Pattern pattern) {
        return EGFPlatformPlugin.getPlatformFactoryComponent(pattern.eResource());
    }

}
