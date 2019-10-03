/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.base;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.domain.TypeGenPackages;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.ftask.tasks.DomainDrivenStrategyTask;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Matthieu Helleboid
 * 
 */
public class ModelDrivenStrategyTaskForGenModel extends DomainDrivenStrategyTask {

    private List<GenPackage> _usedGenPackages;

    @Override
    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
        super.preExecute(context, monitor);
        TypeGenPackages usedGenPackages = context.getInputValue("usedGenPackages", TypeGenPackages.class); //$NON-NLS-1$
        if (usedGenPackages != null)
            _usedGenPackages = usedGenPackages.getElements();
    }

    @Override
    protected void readContext(ITaskProductionContext context, PatternContext ctx) throws InvocationException {
        super.readContext(context, ctx);
        @SuppressWarnings("rawtypes")
        List objects = (List) ctx.getValue(PatternContext.DOMAIN_OBJECTS);
        // TODO: genmodel reconcile is done multiple times while it could be done once
        for (Object object : objects) {
            if (object instanceof GenModel) {
                GenModel genModel = (GenModel) object;
                genModel.reconcile();
                genModel.setCanGenerate(true);
                genModel.setValidateModel(true);
                genModel.diagnose();
                genModel.validate();
                // usedGenPackages is exposed as a contract to adress the following bugzilla
                // https://bugs.eclipse.org/bugs/show_bug.cgi?id=274884
                if (_usedGenPackages != null) {
                    for (GenPackage genPackage : _usedGenPackages) {
                        genPackage = (GenPackage) genModel.eResource().getResourceSet().getEObject(EcoreUtil.getURI(genPackage), true);
                        if (genModel.getUsedGenPackages().contains(genPackage) == false) {
                            genModel.getUsedGenPackages().add(genPackage);
                        }
                    }
                }
            }
        }
    }

}
