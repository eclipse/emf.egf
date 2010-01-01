package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.fcore.ActivityContract;
import org.eclipse.egf.model.pattern.BundleAccessor;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;

public abstract class AbstractPatternTask implements ITaskProduction {

    private Resource domainResource;

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
    }

    protected void writeContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (ActivityContract ac : context.getOutputValueKeys()) {
            context.setOutputValue(ac.getName(), ctx.getValue(ac.getName()));
        }
        if (domainResource != null) {
            domainResource.unload();
            domainResource = null;
        }
    }

    protected void readContext(final ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        for (ActivityContract ac : context.getInputValueKeys()) {
            String name = ac.getName();
            if (PatternContext.DOMAIN_OBJECTS.equals(name)) {
                DomainURI uri = (DomainURI) context.getInputValue(name, ac.getType().getType());
                ResourceSetImpl set = new ResourceSetImpl();
                domainResource = ResourceHelper.loadResource(set, uri.getUri());
                ctx.setValue(PatternContext.DOMAIN_OBJECTS, domainResource.getContents());
            } else
                ctx.setValue(name, context.getInputValue(name, ac.getType().getType()));
        }
    }

    protected PatternContext createPatternContext(final ITaskProductionContext prodCtx) {
        return new PatternContext(new BundleAccessor() {

            @Override
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
