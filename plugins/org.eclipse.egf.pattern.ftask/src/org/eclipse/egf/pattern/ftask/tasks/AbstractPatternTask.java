/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.execution.ExecutionContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osgi.framework.Bundle;

/**
 * @author Thomas Guiu
 */
public abstract class AbstractPatternTask implements ITaskProduction {

    protected final PatternHelper helper = PatternHelper.createCollector();

    private Resource domainResource;

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        // Nothing to do
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        // Nothing to do
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
        ResourceSet resourceSet = (ResourceSet) ctx.getValue(PatternContext.PATTERN_RESOURCESET);
        for (Resource res : resourceSet.getResources())
            res.unload();
        resourceSet.getResources().clear();
    }

    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (Object object : context.getInputValueKeys()) {
            Contract contract = (Contract) object;
            String name = contract.getName();
            if (PatternContext.DOMAIN_OBJECTS.equals(name)) {
                DomainURI domainURI = (DomainURI) context.getInputValue(name, contract.getType().getType());
                if (domainURI == null || domainURI.getUri() == null)
                    continue; // Weird behavior: unfilled contracts are
                // available ...
                ResourceSet set = new RuntimePlatformResourceSet();
                domainResource = set.getResource(domainURI.getUri(), true);
                ctx.setValue(PatternContext.DOMAIN_OBJECTS, domainResource.getContents());
            } else
                ctx.setValue(name, context.getInputValue(name, contract.getType().getType()));
        }
        // add a resourcet to load pattern to be called
        ctx.setValue(PatternContext.PATTERN_RESOURCESET, new RuntimePlatformResourceSet());
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
