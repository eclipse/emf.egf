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

package org.eclipse.egf.pattern.execution;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.constant.CharacterConstants;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AssemblyHelper {

    protected final Pattern pattern;
    protected final StringBuilder content = new StringBuilder(1000);

    public AssemblyHelper(Pattern pattern) {
        super();
        this.pattern = pattern;
    }

    public String visit() throws PatternException {
        String read = getMethodContent(pattern.getHeaderMethod());
        if (read != null)
            content.append(read);

        int insertionIndex = content.length();

        addVariable(pattern);
        visitOrchestration(pattern);

        if (!pattern.getParameters().isEmpty())
            handleParameters(insertionIndex);

        read = getMethodContent(pattern.getFooterMethod());
        if (read != null)
            content.append(read);

        return content.toString();
    }

    protected void addVariable(Pattern pattern) throws PatternException {
        content.append(getMethodContent(pattern.getInitMethod()));

    }

    /**
     * This method may code to handle parameter at the insertionIndex and at the
     * current index. The inserted code is mainly a kind of loop containing the
     * pattern body over the result of the query.
     */
    protected abstract void handleParameters(int insertionIndex);

    /**
     * This method handles pattern calls.<br>
     * We must provide the expected parameters or throw an exception if we
     * can't.
     */
    protected abstract void call(PatternCall object) throws PatternException;

    /**
     * This method handles pattern calls.<br>
     * We must provide a context so the called pattern can perform a query to
     * fill its paremeters.
     */
    protected abstract void call(PatternInjectedCall call) throws PatternException;

    // TODO mark this method abstract as its implementation depends on the
    // nature of pattern.

    protected void visitOrchestration(Pattern pattern) throws PatternException {
        for (Call element : pattern.getOrchestration()) {
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
                    return getMethodContent(object.getCalled());
                } catch (PatternException e) {
                    holder.object = e;
                }
                return CharacterConstants.EMPTY_STRING;
            }

            @Override
            public String casePatternInjectedCall(PatternInjectedCall object) {
                try {
                    call(object);
                } catch (PatternException e) {
                    holder.object = e;
                }
                return CharacterConstants.EMPTY_STRING;
            }

            @Override
            public String casePatternCall(PatternCall object) {
                try {
                    call(object);
                } catch (PatternException e) {
                    holder.object = e;
                }
                return CharacterConstants.EMPTY_STRING;
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

    private String getMethodContent(PatternMethod object) throws PatternException {
        URI uri = object.getPatternFilePath();
        try {
            return FileHelper_to_be_upgraded.getContent(PatternHelper.getPlatformFactoryComponent(object.getPattern()), uri);
        } catch (CoreException e) {
            throw new PatternException(e);
        } catch (IOException e) {
            throw new PatternException(e);
        }
    }

}
