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

package org.eclipse.egf.pattern.engine;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.emf.common.util.EList;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AssemblyHelper {

    protected final Pattern pattern;
    protected final StringBuilder content = new StringBuilder(1000);
    protected int orchestrationIndex;
    protected final AssemblyContentHelper contentHelper;

    public AssemblyHelper(Pattern pattern, AssemblyContentProvider contentProvider) {
        super();
        this.pattern = pattern;
        this.contentHelper = new AssemblyContentHelper(contentProvider);
    }

    public String visit() throws PatternException {
        orchestrationIndex = -1;
        String read = contentHelper.getMethodContent(pattern.getHeaderMethod());
        if (read != null)
            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);

        addVariableInitialization();
        beginOrchestration();
        if (orchestrationIndex == -1)
            throw new PatternException(Messages.assembly_error6);

        visitOrchestration();

        endOrchestration();

        read = contentHelper.getMethodContent(pattern.getFooterMethod());
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

    protected void visitOrchestration() throws PatternException {
        EList<Call> orchestration = pattern.getOrchestration();
        if (orchestration.isEmpty())
            return;

        for (Call element : orchestration) {
            String read = contentHelper.getContent(element);
            if (read != null)
                content.append(read);
        }
    }

}
