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
package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.execution.ExecutionContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 */
public abstract class AbstractPatternTask implements ITaskProduction {

    protected final PatternHelper helper = PatternHelper.createCollector();

    private Resource domainResource;

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        // There is no guaranty that this method get called
        helper.clear();
    }

    protected void writeContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (Contract contract : context.getOutputValueKeys()) {
            context.setOutputValue(contract.getName(), ctx.getValue(contract.getName()));
        }
        if (domainResource != null) {
            domainResource.unload();
            domainResource = null;
        }
        ResourceSet resourceSet = (ResourceSet)ctx.getValue(PatternContext.PATTERN_RESOURCESET);
        for (Resource res : resourceSet.getResources())
            res.unload();
        resourceSet.getResources().clear();
    }

    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (Object object : context.getInputValueKeys()) {
            Contract contract = (Contract) object;
            String name = contract.getName();
            if (PatternContext.DOMAIN_OBJECTS.equals(name)) {
                URI uri = (URI) context.getInputValue(name, contract.getType().getType());
                if (uri == null)
                    continue; // Weird behavior: unfilled contracts are
                // available ...
                ResourceSetImpl set = new ResourceSetImpl();
                domainResource = ResourceHelper.loadResource(set, uri);
                ctx.setValue(PatternContext.DOMAIN_OBJECTS, domainResource.getContents());
            } else
                ctx.setValue(name, context.getInputValue(name, contract.getType().getType()));
        }
        // add a resourcet to load pattern to be called
        ResourceSetImpl resourceSet = new ResourceSetImpl();
        resourceSet.setURIConverter(EGFCorePlugin.getPlatformURIConverter());
        ctx.setValue(PatternContext.PATTERN_RESOURCESET, resourceSet);
    }

    protected PatternContext createPatternContext(final ITaskProductionContext prodCtx) {
        return new ExecutionContext(new BundleAccessor() {
            public Bundle getBundle(String id) throws PatternException {

                try {
                    return prodCtx.getBundle(id);
                } catch (InvocationException e) {
                    // TODO on devrait pouvoir mieux gérer les exceptions,
                    // là on empile .. ce serait mieux de transmettre
                    // l'exception originale
                    throw new PatternException(e);
                }
            }
        });
    }

}
