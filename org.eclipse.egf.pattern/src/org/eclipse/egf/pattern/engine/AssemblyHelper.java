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

package org.eclipse.egf.pattern.engine;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.utils.FileHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AssemblyHelper {

    protected final Pattern pattern;
    protected final StringBuilder content = new StringBuilder(1000);
    protected int orchestrationIndex;

    public AssemblyHelper(Pattern pattern) {
        super();
        this.pattern = pattern;
    }

    public String visit() throws PatternException {
        orchestrationIndex = -1;
        String read = getMethodContent(pattern.getHeaderMethod());
        if (read != null)
            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);

        addVariableInitialization();
        beginOrchestration();
        if (orchestrationIndex == -1)
            throw new PatternException(Messages.assembly_error6);

        visitOrchestration(pattern);

        endOrchestration();

        read = getMethodContent(pattern.getFooterMethod());
        if (read != null)
            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);

        return content.toString();
    }

    /**
     * This method may code to handle parameter at the orchestrationIndex and at
     * the current index. The inserted code is mainly a kind of loop containing
     * the pattern body over the result of the query.
     */
    protected void endOrchestration() throws PatternException {
    }

    protected void beginOrchestration() throws PatternException {
        orchestrationIndex = content.length();
    }

    protected abstract void addVariableInitialization() throws PatternException;

    protected final void handleParameters(int insertionIndex) throws PatternException {
    }

    /**
     * This method handles pattern calls.<br>
     * We must provide the expected parameters or throw an exception if we
     * can't.
     */
    protected abstract void call(PatternCall object) throws PatternException;

    protected abstract void call(SuperCall object) throws PatternException;

    /**
     * This method handles pattern calls.<br>
     * We must provide a context so the called pattern can perform a query to
     * fill its paremeters.
     */
    protected abstract void call(PatternInjectedCall call) throws PatternException;

    // TODO mark this method abstract as its implementation depends on the
    // nature of pattern.

    protected void visitOrchestration(Pattern pattern) throws PatternException {
        EList<Call> orchestration = pattern.getOrchestration();
        while (orchestration.isEmpty() && pattern.getSuperPattern() != null) {
            orchestration = pattern.getSuperPattern().getOrchestration();
            pattern = pattern.getSuperPattern();
        }
        if (orchestration.isEmpty())
            throw new PatternException(Messages.bind(Messages.assembly_error8, pattern.getName()));

        for (Call element : orchestration) {
            String read = getContent(element);
            if (read != null)
                content.append(read);
        }
    }

    private String getContent(Call unit) throws PatternException {
        final ObjectHolder<PatternException> holder = new ObjectHolder<PatternException>();
        String result = new PatternSwitch<String>() {

            @Override
            public String caseMethodCall(MethodCall object) {
                try {
                    PatternMethod called = object.getCalled();
                    // this statement is used to look up for overridden methods.
                    called = pattern.getMethod(called.getName());
                    return getMethodContent(called);
                } catch (PatternException e) {
                    holder.object = e;
                }
                return EGFCommonConstants.EMPTY_STRING;
            }

            @Override
            public String casePatternInjectedCall(PatternInjectedCall object) {
                try {
                    call(object);
                } catch (PatternException e) {
                    holder.object = e;
                }
                return EGFCommonConstants.EMPTY_STRING;
            }

            @Override
            public String casePatternCall(PatternCall object) {
                try {
                    call(object);
                } catch (PatternException e) {
                    holder.object = e;
                }
                return EGFCommonConstants.EMPTY_STRING;
            }

            @Override
            public String defaultCase(EObject object) {

                throw new IllegalStateException(Messages.bind(Messages.assembly_error1, object.eClass().getName()));
            }

        }.doSwitch(unit);

        if (holder.object != null)
            throw holder.object;
        return result;
    }

    protected String getMethodContent(PatternMethod object) throws PatternException {
        URI uri = object.getPatternFilePath();
        try {
            return FileHelper.getContent(PatternHelper.getPlatformFcore(object.getPattern()), uri);
        } catch (CoreException e) {
            throw new PatternException(e);
        } catch (IOException e) {
            throw new PatternException(e);
        }
    }

}
