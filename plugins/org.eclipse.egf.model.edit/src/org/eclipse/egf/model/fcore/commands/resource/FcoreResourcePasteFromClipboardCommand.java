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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.fcore.provider.FcoreResourceItemProviderAdapterFactory;
import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.StrictCompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;

/**
 * Multi-rooted resources support.
 * This works exactly like an {@link AddCommand} but the things to be added are copied from the {@link EditingDomain} clipboard.
 */
public class FcoreResourcePasteFromClipboardCommand extends PasteFromClipboardCommand {

    /**
     * This creates a command to add copies from the clipboard to the specified feature of the owner.
     */
    public static Command create(EditingDomain domain, Object owner, Object feature) {
        return create(domain, owner, feature, CommandParameter.NO_INDEX);
    }

    /**
     * This creates a command to add copies from the clipboard to the specified feature of the owner
     * and at the given index.
     */
    public static Command create(EditingDomain domain, Object owner, Object feature, int index) {
        return new FcoreResourcePasteFromClipboardCommand(domain, owner, feature, index, true);
    }

    private FcoreResourceItemProviderAdapterFactory factory;

    /**
     * Constructor
     * 
     * @param domain
     *          the editing domain
     * @param owner
     *          the owner
     * @param feature
     *          the feature
     * @param index
     *          the index
     * 
     *          This constructs an instance from the domain, which provides access the clipboard
     *          collection
     *          via {@link EditingDomain#getCommandStack}.
     */
    public FcoreResourcePasteFromClipboardCommand(EditingDomain domain, Object owner, Object feature, int index) {
        this(domain, owner, feature, index, true);
    }

    /**
     * Constructor
     * 
     * @param domain
     *          the editing domain
     * @param owner
     *          the owner
     * @param feature
     *          the feature
     * @param index
     *          the index
     * @param optimize
     *          optimize
     * 
     *          This constructs an instance from the domain, which provides access the clipboard
     *          collection
     *          via {@link EditingDomain#getCommandStack}.
     */
    public FcoreResourcePasteFromClipboardCommand(EditingDomain domain, Object owner, Object feature, int index, boolean optimize) {
        super(domain, owner, feature, index, optimize);
        this.owner = unwrap(owner);
        factory = new FcoreResourceItemProviderAdapterFactory();
    }

    /**
     * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
     */
    @Override
    public boolean prepare() {

        if (domain.getClipboard() == null) {
            return false;
        }

        // Resource lookup based on owner
        final FcoreResourceImpl[] resource = new FcoreResourceImpl[] {
            null
        };
        final Boolean[] analyseRoot = new Boolean[] {
            false
        };
        if (owner instanceof EObject && ((EObject) owner).eResource() != null || ((EObject) owner).eResource() instanceof FcoreResourceImpl) {
            resource[0] = (FcoreResourceImpl) ((EObject) owner).eResource();
        }
        // Are we on a root object
        analyseRoot[0] = domain.getParent(owner) instanceof FcoreResourceImpl;

        // Find the index of the sibling.
        final Collection<EObject> children = resource[0].getContents();
        final Integer[] siblingIndex = new Integer[] {
            -1
        };
        if (resource[0] != null && analyseRoot[0]) {
            int i = 0;
            // Sibling lookup
            CHILDREN_LOOP: for (EObject child : children) {
                if (child == owner) {
                    siblingIndex[0] = i;
                    break CHILDREN_LOOP;
                }
                ++i;
            }
        }

        // Create a strict compound command to do a copy and then add the result
        command = new StrictCompoundCommand();
        // Create a command to copy the clipboard.
        final Command copyCommand = CopyCommand.create(domain, domain.getClipboard());
        command.append(copyCommand);
        // Create a proxy that will create an add command.
        command.append(

        new CommandWrapper() {

            protected Collection<Object> _original;

            protected Collection<Object> _copy;

            @Override
            protected Command createCommand() {

                _original = domain.getClipboard();

                _copy = new ArrayList<Object>(copyCommand.getResult());

                // Use the original to do the add, but only if it's of the same type as the copy.
                // This ensures that if there is conversion being done as part of the copy,
                // as would be the case for a cross domain copy in the mapping framework,
                // that we do actually use the converted instance.
                if (_original.size() == _copy.size()) {
                    for (Iterator<Object> j = _original.iterator(), k = _copy.iterator(); j.hasNext();) {
                        Object originalObject = j.next();
                        Object copyObject = k.next();
                        if (originalObject.getClass() != copyObject.getClass()) {
                            _original = null;
                            break;
                        }
                    }
                }

                Command addCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
                Iterator<?> iter = null;
                if (_original != null) {
                    iter = _original.iterator();
                } else {
                    iter = _copy.iterator();
                }
                while (iter.hasNext()) {
                    // Root Object
                    Object object = iter.next();
                    EObject eObject = null;
                    if (object instanceof EObject) {
                        eObject = (EObject) object;
                    }
                    if (analyseRoot[0]) {
                        Collection<EClass> roots = factory.getRoots();
                        if (resource[0] != null && eObject != null && roots.contains(EMFHelper.solveAgainstStaticPackage(eObject.eClass()))) {
                            ((CompoundCommand) addCommand).append(new FcoreResourceAddCommand(domain, resource[0], eObject, siblingIndex[0] + 1));
                        } else {
                            ((CompoundCommand) addCommand).append(AddCommand.create(domain, owner, feature, object, index));
                        }
                    } else {
                        ((CompoundCommand) addCommand).append(AddCommand.create(domain, owner, feature, object, index));
                    }
                }
                return addCommand;

            }

            @Override
            public void execute() {
                if (_original != null) {
                    domain.setClipboard(_copy);
                }
                super.execute();
            }

            @Override
            public void undo() {
                super.undo();
                if (_original != null) {
                    domain.setClipboard(_original);
                }
            }

            @Override
            public void redo() {
                if (_original != null) {
                    domain.setClipboard(_copy);
                }
                super.redo();
            }

        }

        );

        boolean result;

        if (optimize) {
            // This will determine canExecute as efficiently as possible.
            result = optimizedCanExecute();
        } else {
            // This will actually execute the copy command in order to check if the add can execute.
            result = command.canExecute();
        }

        return result;

    }

    /**
     * We'll assume that the copy command can execute and that adding a copy of the clipboard
     * is the same test as adding the clipboard contents itself.
     */
    @Override
    protected boolean optimizedCanExecute() {
        if (domain.getClipboard() == null) {
            return false;
        }
        // Resource lookup based on owner
        FcoreResourceImpl resource = null;
        if (owner instanceof EObject && ((EObject) owner).eResource() != null || ((EObject) owner) instanceof FcoreResourceImpl) {
            resource = (FcoreResourceImpl) ((EObject) owner).eResource();
        }
        // Check
        if (resource == null) {
            return false;
        }
        // Are we on a root object
        boolean analyseRoot = domain.getParent(owner) instanceof FcoreResourceImpl;
        // temporary command
        Command addCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
        // Clipboard should contain Root elements
        Iterator<?> iter = domain.getClipboard().iterator();
        while (iter.hasNext()) {
            // Root Object
            Object object = iter.next();
            EObject eObject = null;
            if (object instanceof EObject) {
                eObject = (EObject) object;
            }
            if (analyseRoot) {
                Collection<EClass> roots = factory.getRoots();
                if (eObject != null && roots.contains(EMFHelper.solveAgainstStaticPackage(eObject.eClass()))) {
                    ((CompoundCommand) addCommand).append(new FcoreResourceAddCommand(domain, resource, eObject));
                } else {
                    ((CompoundCommand) addCommand).append(AddCommand.create(domain, owner, feature, object));
                }
            } else {
                ((CompoundCommand) addCommand).append(AddCommand.create(domain, owner, feature, object));
            }
        }
        // Check addCommand
        boolean result = addCommand.canExecute();
        // Clean temporary command
        addCommand.dispose();
        return result;
    }

    /**
     * If the given object implements {@link IWrapperItemProvider}, it is unwrapped by obtaining a value from {@link IWrapperItemProvider#getValue getValue}. The unwrapping continues until a non-wrapper value is returned. This
     * iterative unwrapping is required because values may be repeatedly wrapped, as children of a delegating wrapper.
     */
    protected Object unwrap(Object object) {
        while (object instanceof IWrapperItemProvider) {
            object = ((IWrapperItemProvider) object).getValue();
        }
        return object;
    }

}
