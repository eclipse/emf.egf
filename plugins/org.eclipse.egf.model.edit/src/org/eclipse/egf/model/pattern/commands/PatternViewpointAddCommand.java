/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNameHelper;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 */
public class PatternViewpointAddCommand extends AddCommand {

    protected Resource _resource;

    protected Map<PatternLibrary, List<Pattern>> _patterns;

    protected Map<PatternMethod, URI[]> _methods;

    protected boolean _copy;

    /**
     * This constructs a primitive command to insert a collection of values into the specified many-valued feature of the owner.
     */
    public PatternViewpointAddCommand(EditingDomain domain, PatternViewpoint patternViewpoint, Collection<?> collection, int index) {
        super(domain, patternViewpoint, PatternPackage.Literals.PATTERN_VIEWPOINT__LIBRARIES, collection, index);
    }

    @Override
    protected boolean prepare() {
        boolean result = super.prepare();
        if (result == false) {
            return false;
        }
        if (owner instanceof PatternViewpoint == false) {
            return false;
        }
        if (feature != PatternPackage.Literals.PATTERN_VIEWPOINT__LIBRARIES) {
            return false;
        }
        PatternViewpoint patternViewpoint = (PatternViewpoint) owner;
        Resource resource = patternViewpoint.eResource();
        if (resource == null || EMFHelper.getProject(resource) == null || resource instanceof IPlatformFcoreProvider == false) {
            return false;
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
        if (fcore == null) {
            return false;
        }
        // Populate
        _patterns = new HashMap<PatternLibrary, List<Pattern>>();
        _methods = new HashMap<PatternMethod, URI[]>();
        for (Object object : collection) {
            if (object instanceof EObject == false) {
                continue;
            }
            Collection<EObject> eObjects = EMFHelper.getAllProperContents(PatternPackage.eINSTANCE.getPattern(), (EObject) object);
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
        }
        _resource = patternViewpoint.eResource();
        return true;
    }

    @Override
    public void doExecute() {
        // Check and update pattern name if not unique
        PatternViewpoint patternViewpoint = (PatternViewpoint) owner;
        IPlatformFcore fcore = ((IPlatformFcoreProvider) patternViewpoint.eResource()).getIPlatformFcore();
        for (Map.Entry<PatternLibrary, List<Pattern>> entry : _patterns.entrySet()) {
            List<String> names = PatternNameHelper.getPatternNameWithinBundle(fcore, entry.getKey(), null);
            for (Pattern pattern : entry.getValue()) {
                PatternNameHelper.setUniquePatternName(fcore, pattern, names);
                names.add(pattern.getName());
            }
        }
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
