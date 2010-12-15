/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 * Thales Corporate Services S.A.S
 */
package org.eclipse.egf.model.fcore.commands.resource;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNameHelper;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.commands.PatternLibraryAddPatternCommand;
import org.eclipse.egf.model.pattern.commands.PatternLibraryRemovePatternCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Multi-rooted resources support.
 * This command will add a root defined EObject to the resource.
 */
public class FcoreResourceAddCommand extends AddCommand {

    protected Map<PatternLibrary, List<Pattern>> _patterns;

    protected Map<PatternMethod, URI[]> _methods;

    protected FcoreResourceImpl _resource = null;

    protected boolean _copy;

    /**
     * Constructor
     * 
     * @param domain
     *          the editing domain
     * @param resource
     *          the resource to add to
     * @param collection
     *          the collection to add
     */
    public FcoreResourceAddCommand(EditingDomain domain, FcoreResourceImpl resource, Collection<?> collection) {
        this(domain, resource, collection, CommandParameter.NO_INDEX);
    }

    /**
     * Constructor
     * 
     * @param domain
     *          the editing domain
     * @param resource
     *          the resource to add to
     * @param collection
     *          the collection to add
     * @param index
     *          the index
     */
    public FcoreResourceAddCommand(EditingDomain domain, FcoreResourceImpl resource, Collection<?> collection, int index) {
        super(domain, resource.getContents(), collection, index);
        _resource = resource;
    }

    /**
     * Constructor
     * 
     * @param domain
     *          the editing domain
     * @param resource
     *          the resource to add to
     * @param value
     *          the value to add
     */
    public FcoreResourceAddCommand(EditingDomain domain, FcoreResourceImpl resource, Object value) {
        this(domain, resource, value, CommandParameter.NO_INDEX);
    }

    /**
     * Constructor
     * 
     * @param domain
     *          the editing domain
     * @param resource
     *          the resource to add to
     * @param value
     *          the value to add
     * @param index
     *          the index
     */
    public FcoreResourceAddCommand(EditingDomain domain, FcoreResourceImpl resource, Object value, int index) {
        super(domain, resource.getContents(), value, index);
        _resource = resource;
    }

    @Override
    protected boolean prepare() {
        if (super.prepare() == false) {
            return false;
        }
        if (domain.isReadOnly(_resource)) {
            return false;
        }
        if (_resource == null || EMFHelper.getProject(_resource) == null) {
            return false;
        }
        IPlatformFcore fcore = ((IPlatformFcoreProvider) _resource).getIPlatformFcore();
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
        return true;
    }

    @Override
    public void doExecute() {
        // Check and update pattern name if not unique
        IPlatformFcore fcore = ((IPlatformFcoreProvider) _resource).getIPlatformFcore();
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
