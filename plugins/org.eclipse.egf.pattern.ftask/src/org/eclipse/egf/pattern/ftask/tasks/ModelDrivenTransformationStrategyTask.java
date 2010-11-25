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

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * A task to copy domain objects into a temporary resource and apply patterns on them
 * 
 * @author Matthieu Helleboid
 * 
 */
public class ModelDrivenTransformationStrategyTask extends ModelDrivenStrategyTask {

    private URI uri;

    @Override
    @SuppressWarnings("unchecked")
    protected void readContext(ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        Class<Object> type = DomainFactory.eINSTANCE.createTypeDomain().getType();
        EMFDomain domainURI = (EMFDomain) context.getInputValue(PatternContext.DOMAIN_OBJECTS, type);
        uri = domainURI.getUri();

        super.readContext(context, ctx);

        List<EObject> objects = (List<EObject>) ctx.getValue(PatternContext.DOMAIN_OBJECTS);
        objects = (List<EObject>) EcoreUtil.copyAll(objects);
        ctx.setValue(PatternContext.DOMAIN_OBJECTS, objects);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void writeContext(ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.writeContext(context, ctx);

        List<EObject> objects = (List<EObject>) ctx.getValue(PatternContext.DOMAIN_OBJECTS);

        try {
            String outDomainPath = File.createTempFile("eclipseegf", "." + uri.fileExtension()).getAbsolutePath(); //$NON-NLS-1$ //$NON-NLS-2$
            context.setOutputValue("outDomainPath", outDomainPath); //$NON-NLS-1$

            uri = URI.createFileURI(outDomainPath);
            EMFDomain domainURI = DomainFactory.eINSTANCE.createEMFDomain();
            domainURI.setUri(uri);
            context.setOutputValue("outDomain", domainURI); //$NON-NLS-1$

            // Create a standard resource set
            // we just need to save a copy of existing domain objects in a temporary file
            // no runtime or target platform specific strategy here
            ResourceSet set = new ResourceSetImpl();
            Resource resource = set.createResource(uri);
            resource.getContents().addAll(objects);
            resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            throw new InvocationException(e);
        }
    }

}
