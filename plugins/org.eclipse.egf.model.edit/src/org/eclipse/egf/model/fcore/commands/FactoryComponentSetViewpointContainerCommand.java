/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.commands.PatternLibraryAddPatternCommand;
import org.eclipse.egf.model.pattern.commands.PatternLibraryRemovePatternCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 */
public class FactoryComponentSetViewpointContainerCommand extends SetCommand {

    protected Resource _resource;

    protected Map<PatternLibrary, List<Pattern>> _patterns;

    protected Map<PatternMethod, URI[]> _methods;

    protected boolean _copy;

    /**
     * This constructs a primitive command to insert a collection of values into the specified many-valued feature of the owner.
     */
    public FactoryComponentSetViewpointContainerCommand(EditingDomain domain, FactoryComponent factoryComponent, Object value) {
        super(domain, factoryComponent, FcorePackage.Literals.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, value);
    }

    /**
     * This constructs a primitive command to insert a collection of values into the specified many-valued feature of the owner.
     */
    public FactoryComponentSetViewpointContainerCommand(EditingDomain domain, FactoryComponent factoryComponent, Object value, int index) {
        super(domain, factoryComponent, FcorePackage.Literals.FACTORY_COMPONENT__VIEWPOINT_CONTAINER, value, index);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof FactoryComponent == false) {
            return false;
        }
        if (feature != FcorePackage.Literals.FACTORY_COMPONENT__VIEWPOINT_CONTAINER) {
            return false;
        }
        FactoryComponent factoryComponent = (FactoryComponent) owner;
        if (factoryComponent.eResource() == null || EMFHelper.getProject(factoryComponent.eResource()) == null) {
            return false;
        }
        // Populate
        _patterns = new HashMap<PatternLibrary, List<Pattern>>();
        _methods = new HashMap<PatternMethod, URI[]>();
        if (value instanceof EObject == false) {
            return false;
        }
        Collection<EObject> eObjects = EMFHelper.getAllProperContents(PatternPackage.eINSTANCE.getPattern(), (EObject) value);
        for (EObject eObject : eObjects) {
            Pattern pattern = (Pattern) eObject;
            List<Pattern> patterns = _patterns.get(pattern.getContainer());
            if (patterns == null) {
                patterns = new UniqueEList<Pattern>();
                _patterns.put(pattern.getContainer(), patterns);
            }
            patterns.add(pattern);
            try {
                for (PatternMethod method : pattern.getMethods()) {
                    _methods.put(method, new URI[] {
                            method.getPatternFilePath(), null
                    });
                }
            } catch (Throwable t) {
                return false;
            }
        }
        _resource = factoryComponent.eResource();
        return true;
    }

    @Override
    public void doExecute() {
        super.doExecute();
        _copy = PatternLibraryAddPatternCommand.performCreatePatternTemplates(_resource, _methods);
    }

    @Override
    public void doUndo() {
        if (_copy) {
            for (Map.Entry<PatternLibrary, List<Pattern>> entry : _patterns.entrySet()) {
                PatternLibraryRemovePatternCommand.performDeletePatterns(_resource, entry.getValue());
            }
        }
        super.doUndo();
    }

    @Override
    public void doRedo() {
        if (_copy) {
            for (List<Pattern> patterns : _patterns.values()) {
                PatternLibraryRemovePatternCommand.performRestorePatterns(_resource, patterns);
            }
        }
        super.doRedo();
    }

}
