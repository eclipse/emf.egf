/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui;

import java.util.Map;

import org.eclipse.egf.core.ui.contributor.ViewpointContributor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternTemplateEditor;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternViewpointContributor extends ViewpointContributor {

    public static final String EDIT_ACTION_ID = "edit-pattern";
    public static final String EDIT_TEMPLATE_ACTION_ID = "edit-template-pattern";

    private final EditPatternAction editAction = new EditPatternAction();
    private final EditTemplatePatternAction editTemplateAction = new EditTemplatePatternAction();

    private boolean addActions() {
        if (selection == null)
            return false;
        IStructuredSelection sselection = (IStructuredSelection) selection;
        if (sselection.size() != 1 || !(sselection.getFirstElement() instanceof PatternElement))
            return false;

        return true;
    }

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        IStructuredSelection selection2 = (IStructuredSelection) selection;
        if (addActions()) {
            if (selection2.getFirstElement() instanceof PatternLibrary) {
                PatternLibrary lib = (PatternLibrary) selection2.getFirstElement();
                MenuManager createChildMenuManager = new MenuManager("New Child"); //$NON-NLS-1$
                menuManager.insertBefore("edit", createChildMenuManager); //$NON-NLS-1$
                Map<String, PatternExtension> extensions = ExtensionHelper.getExtensions();
                for (String nature : extensions.keySet()) {
                    PatternExtension patternExtension = extensions.get(nature);
                    CommandParameter descriptor = new CommandParameter(null, PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS, patternExtension.getFactory().createPattern(null, "myPattern"));
                    CreateChildAction createChildAction = new CreateChildAction(activeEditorPart, selection, descriptor);
                    createChildAction.setText(nature + " Pattern");
                    createChildMenuManager.add(createChildAction);
                }
                // menuManager.insertBefore("edit", createChildAction);
            } else if (selection2.getFirstElement() instanceof Pattern) {
                menuManager.insertBefore("edit", editAction);
                menuManager.insertBefore("edit", editTemplateAction);
            }
        }
    }

    private final class TestAction extends Action {

        public TestAction(String text) {
            super(text);
            setId(text);

        }

        @Override
        public void run() {

            super.run();
        }
    }

    private abstract class PatternAction extends Action {

        public PatternAction(String label, String id) {
            super(label);
            setId(id);
        }

        // @Override
        // public boolean isEnabled() {
        // if (selection == null)
        // return false;
        // IStructuredSelection sselection = (IStructuredSelection) selection;
        // if (sselection.size() != 1 || !(sselection.getFirstElement()
        // instanceof Pattern))
        // return false;
        //
        // return true;
        // }

        protected Pattern getPattern() {
            if (selection == null)
                throw new IllegalStateException();
            IStructuredSelection sselection = (IStructuredSelection) selection;
            if (sselection.size() != 1 || !(sselection.getFirstElement() instanceof Pattern))
                throw new IllegalStateException();
            return (Pattern) sselection.getFirstElement();
        }
    }

    private final class EditTemplatePatternAction extends PatternAction {

        public EditTemplatePatternAction() {
            super("Edit template", EDIT_TEMPLATE_ACTION_ID);
        }

        @Override
        public void run() {
            PatternTemplateEditor.openEditor(parent.getPage(), getPattern(), null);
        }
    }

    private final class EditPatternAction extends PatternAction {

        public EditPatternAction() {
            super("Edit", EDIT_ACTION_ID);
        }

        @Override
        public void run() {
            PatternEditor.openEditor(parent.getPage(), getPattern());
        }
    }

}
