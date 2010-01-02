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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.ui.editors.adapter.LiveValidationContentAdapter;
import org.eclipse.egf.pattern.ui.editors.selector.ParameterValidationDelegateClientSelector;
import org.eclipse.egf.pattern.ui.editors.selector.PatternValidationDelegateClientSelector;
import org.eclipse.egf.pattern.ui.editors.selector.VariableValidationDelegateClientSelector;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessageManager;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class PatternUIHelper {
    /**
     * Get the pattern's parent methods.
     */
    public static List<String> getPatternParentMethodsNameList(Pattern pattern) {
        List<String> parentMethods = new ArrayList<String>();
        Pattern parent = pattern == null ? null : pattern.getSuperPattern();
        if (parent != null) {
            for (PatternMethod patternMethod : parent.getMethods()) {
                String name = patternMethod.getName();
                parentMethods.add(name);
            }
        }
        return parentMethods;
    }

    /**
     * Get the pattern's parent methods with out header/init/footer methods.
     */
    public static List<PatternMethod> getAllUseablePatternMethods(Pattern pattern) {
        List<PatternMethod> parentMethods = new ArrayList<PatternMethod>();
        if (pattern != null) {
            for (PatternMethod patternMethod : pattern.getAllMethods()) {
                String name = patternMethod.getName();
                if (!(Messages.ImplementationPage_header.equals(name) || Messages.ImplementationPage_init.equals(name) || Messages.ImplementationPage_footer.equals(name))) {
                    parentMethods.add(patternMethod);
                }
            }
        }
        return parentMethods;
    }

    /**
     * Get the pattern's parent methods name list with out header/init/footer
     * methods.
     */
    public static List<String> getUseablePatternMethodsNameList(Pattern pattern) {
        List<String> parentMethods = new ArrayList<String>();
        if (pattern != null) {
            for (PatternMethod patternMethod : pattern.getMethods()) {
                String name = patternMethod.getName();
                if (!(Messages.ImplementationPage_header.equals(name) || Messages.ImplementationPage_init.equals(name) || Messages.ImplementationPage_footer.equals(name))) {
                    parentMethods.add(name);
                }
            }
        }
        return parentMethods;
    }

    /**
     * Add the refresher adapter for object.
     */
    public static void addAdapter(Object object, AdapterImpl refresher) {
        if (object instanceof EObject) {
            EList<Adapter> eAdapters = ((EObject) object).eAdapters();
            addIntoAdapters(eAdapters, refresher);
            addChildAdapter(object, refresher);
        }
    }

    /**
     * Remove the refresher adapter for object.
     */
    public static void removeAdapter(Object object, AdapterImpl refresher) {
        if (object instanceof EObject) {
            EList<Adapter> eAdapters = ((EObject) object).eAdapters();
            removeFromeAdapters(eAdapters, refresher);
            removeChildAdapter(object, refresher);
        }
    }

    /**
     * Add adapter for the MethodCall's called or PatternInjectedCall's context.
     */
    public static void addChildAdapter(Object object, AdapterImpl refresher) {
        if (object instanceof MethodCall) {
            EList<Adapter> eAdapters = ((MethodCall) object).getCalled().eAdapters();
            addIntoAdapters(eAdapters, refresher);

        } else if (object instanceof PatternInjectedCall) {
            EList<Adapter> eAdapters = ((PatternInjectedCall) object).getContext().eAdapters();
            addIntoAdapters(eAdapters, refresher);
        }
    }

    /**
     * Remove the MethodCall's called or PatternInjectedCall's context adapters.
     */
    public static void removeChildAdapter(Object object, AdapterImpl refresher) {
        if (object instanceof MethodCall) {
            EList<Adapter> eAdapters = ((MethodCall) object).getCalled().eAdapters();
            removeFromeAdapters(eAdapters, refresher);

        } else if (object instanceof PatternInjectedCall) {
            EList<Adapter> eAdapters = ((PatternInjectedCall) object).getContext().eAdapters();
            removeFromeAdapters(eAdapters, refresher);
        }
    }

    /**
     * Add the refresher into the eAdapters.
     */
    public static void addIntoAdapters(EList<Adapter> eAdapters, AdapterImpl refresher) {
        if (!eAdapters.contains(refresher)) {
            eAdapters.add(refresher);
        }
    }

    /**
     * Remove the refresher into the eAdapters.
     */
    public static void removeFromeAdapters(EList<Adapter> eAdapters, AdapterImpl refresher) {
        if (eAdapters.contains(refresher)) {
            eAdapters.remove(refresher);
        }
    }

    /**
     * Add adapter for pattern.
     */
    public static void addAdapterForPattern(Pattern pattern, AdapterImpl liveValidationContentAdapter) {
        if (pattern != null) {
            EList<Adapter> eAdapters = pattern.eAdapters();
            addIntoAdapters(eAdapters, liveValidationContentAdapter);
        }
    }

    /**
     * Remove adapter for pattern.
     */
    public static void removeAdapterForPattern(Pattern pattern, AdapterImpl adapter) {
        if (pattern != null) {
            EList<Adapter> eAdapters = pattern.eAdapters();
            removeFromeAdapters(eAdapters, adapter);
        }
    }

    /**
     * Create validation for object.
     */
    public static void validationContent(IMessageManager mmng, EObject object, String key, Control control) {

        if (Messages.PatternUIHelper_key_NonPatternEmptyName.equals(key)) {
            PatternValidationDelegateClientSelector.running = true;
        } else if (Messages.PatternUIHelper_key_NonPatternParameterEmptyName.equals(key)) {
            ParameterValidationDelegateClientSelector.running = true;
        } else if (Messages.PatternUIHelper_key_NonPatternVariableEmptyName.equals(key)) {
            VariableValidationDelegateClientSelector.running = true;
        }

        IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
        validator.setIncludeLiveConstraints(true);

        IStatus status = validator.validate(object);
        if (control != null && !control.isDisposed()) {
            setErrorMessage(status, mmng, key, control);
        }

        if (Messages.PatternUIHelper_key_NonPatternEmptyName.equals(key)) {
            PatternValidationDelegateClientSelector.running = false;
        } else if (Messages.PatternUIHelper_key_NonPatternParameterEmptyName.equals(key)) {
            ParameterValidationDelegateClientSelector.running = false;
        } else if (Messages.PatternUIHelper_key_NonPatternVariableEmptyName.equals(key)) {
            VariableValidationDelegateClientSelector.running = false;
        }

    }

    /**
     * Set decoration for contorl.
     * 
     * @param control
     * @param key
     * @param mmng
     */
    public static void setErrorMessage(IStatus status, IMessageManager mmng, String key, Control control) {
        if (!status.isOK()) {
            if (status.isMultiStatus()) {
                status = status.getChildren()[0];
            }
            if ((status.getCode() == 1 && Messages.PatternUIHelper_key_NonPatternEmptyName.equals(key)) || (status.getCode() == 2 && Messages.PatternUIHelper_key_NonPatternParameterEmptyName.equals(key)) || (status.getCode() == 3 && Messages.PatternUIHelper_key_NonPatternVariableEmptyName.equals(key)))
                mmng.addMessage(key, status.getMessage(), null, IMessageProvider.ERROR, control);
        } else {
            mmng.removeMessage(key, control);
        }
    }

    /**
     * Add EMF validation.
     */
    public static LiveValidationContentAdapter addEMFValidation(IMessageManager mmng, Pattern pattern, String key, Control control, LiveValidationContentAdapter liveValidationContentAdapter) {
        validationContent(mmng, pattern, key, control);
        liveValidationContentAdapter = new LiveValidationContentAdapter(control, mmng, key, pattern);
        PatternUIHelper.addAdapterForPattern(pattern, liveValidationContentAdapter);
        return liveValidationContentAdapter;
    }
}
