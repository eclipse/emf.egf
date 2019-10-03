/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.engine;

import java.io.IOException;

import org.eclipse.egf.model.pattern.BackCall;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.model.pattern.util.PatternSwitch;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.TemplateFileHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 */
public abstract class AssemblyContentProvider extends PatternSwitch<String> {

    protected static final String OK = "ok"; //$NON-NLS-1$

    protected final Pattern pattern;

    protected StringBuilder content;

    public AssemblyContentProvider(Pattern pattern) {
        super();
        this.pattern = pattern;
    }

    protected abstract void call(MethodCall object) throws PatternException;

    protected abstract void call(PatternCall object) throws PatternException;

    protected abstract void call(BackCall object) throws PatternException;

    protected abstract void call(SuperCall object) throws PatternException;

    protected abstract void addMethodBodies() throws PatternException;

    /**
     * This method handles pattern calls.<br>
     * We must provide a context so the called pattern can perform a query to
     * fill its paremeters.
     */
    protected abstract void call(PatternInjectedCall call) throws PatternException;

    @Override
    public String caseMethodCall(MethodCall object) {
        try {
            // PatternMethod called = object.getCalled();
            // // this statement is used to look up for overridden methods.
            // called = pattern.getMethod(called.getName());
            // return getMethodContent(called);
            call(object);
            return OK;
        } catch (PatternException e) {
            throw new WrappedException(e);
        }
    }

    @Override
    public String casePatternInjectedCall(PatternInjectedCall object) {
        try {
            call(object);
        } catch (PatternException e) {
            throw new WrappedException(e);
        }
        return OK;
    }

    @Override
    public String caseBackCall(BackCall object) {
        try {
            call(object);
        } catch (PatternException e) {
            throw new WrappedException(e);
        }
        return OK;
    }

    @Override
    public String casePatternCall(PatternCall object) {
        try {
            call(object);
        } catch (PatternException e) {
            throw new WrappedException(e);
        }
        return OK;
    }

    @Override
    public String caseSuperCall(SuperCall object) {
        try {
            call(object);
        } catch (PatternException e) {
            throw new WrappedException(e);
        }
        return OK;
    }

    @Override
    public String defaultCase(EObject object) {
        throw new IllegalStateException(NLS.bind(EGFPatternMessages.assembly_error1, object.eClass().getName()));
    }

    protected String getMethodContent(PatternMethod method) throws PatternException {
        try {
            return TemplateFileHelper.getContent(method);
        } catch (IOException e) {
            throw new PatternException(e);
        }
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    static class WrappedException extends RuntimeException {

        static final long serialVersionUID = 1L;

        public WrappedException(Throwable cause) {
            super(cause);
        }

    }

}
