/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 */
public class PatternAddPatternMethodCommand extends AddCommand {

    protected List<PatternMethod> _methods;

    protected Resource _resource;

    public PatternAddPatternMethodCommand(EditingDomain domain, Pattern pattern, Collection<?> collection, int index) {
        super(domain, pattern, PatternPackage.Literals.PATTERN__METHODS, collection, index);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof Pattern == false) {
            return false;
        }
        if (feature != PatternPackage.Literals.PATTERN__METHODS) {
            return false;
        }
        Pattern pattern = (Pattern) owner;
        Resource resource = pattern.eResource();
        if (resource == null || EMFHelper.getProject(resource) == null || resource instanceof IPlatformFcoreProvider == false) {
            return false;
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
        if (fcore == null) {
            return false;
        }
        _methods = new UniqueEList<PatternMethod>();
        for (Object object : collection) {
            if (object instanceof PatternMethod == false) {
                continue;
            }
            _methods.add((PatternMethod) object);
        }
        _resource = pattern.eResource();
        return true;
    }

    @Override
    public void doExecute() {
        super.doExecute();
        for (PatternMethod method : _methods) {
            method.setPatternFilePath(TemplateModelFileHelper.computeFileURI(((IPlatformFcoreProvider) _resource).getIPlatformFcore(), method));
        }
    }

    @Override
    public void doUndo() {
        super.doUndo();
        PatternRemovePatternMethodCommand.performDeletePatternMethods(_resource, _methods);
    }

    @Override
    public void doRedo() {
        super.doRedo();
        PatternRemovePatternMethodCommand.performRestorePatternMethods(_resource, _methods);
    }

}
