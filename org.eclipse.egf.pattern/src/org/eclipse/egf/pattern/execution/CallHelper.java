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

package org.eclipse.egf.pattern.execution;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.model.pattern.CallBackHandler;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * This is an helper class to ease translation of patterns.
 * 
 * @author Thomas Guiu
 * 
 */
public class CallHelper {

    public static void execute(String patternId, PatternContext ctx) throws MissingExtensionException, PatternException {
        PatternHelper createCollector = PatternHelper.createCollector();
        Pattern pattern = createCollector.getPattern(patternId);
        PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
        String reason = extension.canExecute(pattern);
        if (reason != null)
            throw new PatternException(reason);
        extension.createEngine(pattern).execute(ctx);
    }

    public static void executeWithInjection(String patternId, PatternContext ctx, Map<String, Object> name2parameterValue) throws MissingExtensionException, PatternException {
        PatternHelper createCollector = PatternHelper.createCollector();
        Pattern pattern = createCollector.getPattern(patternId);
        PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
        String reason = extension.canExecute(pattern);
        if (reason != null)
            throw new PatternException(reason);
        Map<PatternParameter, Object> parameters = new HashMap<PatternParameter, Object>();
        for (Map.Entry<String, Object> entry : name2parameterValue.entrySet()) {
            PatternParameter parameter = pattern.getParameter(entry.getKey());
            if (parameter == null)
                throw new PatternException(Messages.bind(Messages.call_execution_error1, entry.getKey(), pattern.getName()));
            parameters.put(parameter, entry.getValue());
        }
        extension.createEngine(pattern).executeWithInjection(ctx, parameters);
    }

    public static void callBack(PatternContext ctx, Map<String, Object> parameters) throws MissingExtensionException, PatternException {
        CallBackHandler handler = (CallBackHandler) ctx.getValue(PatternContext.CALL_BACK_HANDLER);
        if (handler == null)
            Activator.getDefault().logWarning(Messages.missing_callback_handler);
        handler.handleCall(ctx, parameters);
    }

    private CallHelper() {
        super();

    }

}
