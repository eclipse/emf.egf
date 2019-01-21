/**
 * <copyright>
 * 
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
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.egf.pattern.ui.editors.adapter.LiveValidationContentAdapter;
import org.eclipse.egf.pattern.ui.editors.adapter.RefresherAdapter;
import org.eclipse.egf.pattern.ui.editors.models.QueryContent;
import org.eclipse.egf.pattern.ui.editors.validation.EMFvalidator;
import org.eclipse.egf.pattern.ui.editors.validation.ValidationConstants;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.TableViewer;
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
        Set<String> parentMethods = new HashSet<String>();
        while (pattern != null) {
            for (PatternMethod patternMethod : pattern.getMethods()) {
                String name = patternMethod.getName();
                if (PatternFactory.isSpecialMethod(name))
                    continue;
                parentMethods.add(name);
            }
            pattern = pattern.getSuperPattern();
        }
        List<String> result = new ArrayList<String>(parentMethods);
        Collections.sort(result);
        return result;
    }

    /**
     * Get the pattern's parent methods with out header/init/footer methods.
     */
    public static List<PatternMethod> getAllUseablePatternMethods(Pattern pattern) {
        List<PatternMethod> parentMethods = new ArrayList<PatternMethod>();
        Set<String> names = new HashSet<String>();
        if (pattern != null) {
            for (PatternMethod patternMethod : pattern.getAllMethods()) {
                String name = patternMethod.getName();
                if (PatternFactory.isSpecialMethod(name))
                    continue;
                if (!names.contains(name)) {
                    parentMethods.add(patternMethod);
                    names.add(name);
                }
            }
        }
        return parentMethods;
    }

    /**
     * Get the pattern's parents methods name list with out header/init/footer
     * methods.
     */
    public static List<String> getUseablePatternMethodsNameList(Pattern pattern) {
        final List<String> result = getPatternParentMethodsNameList(pattern);
        if (pattern != null) {
            for (PatternMethod patternMethod : pattern.getMethods()) {
                result.remove(patternMethod.getName());
            }
        }
        return result;
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
            if (((MethodCall) object).getCalled() != null) {
                EList<Adapter> eAdapters = ((MethodCall) object).getCalled().eAdapters();
                addIntoAdapters(eAdapters, refresher);
            }
        } else if (object instanceof PatternInjectedCall) {
            if (((PatternInjectedCall) object).getContext() != null) {
                EList<Adapter> eAdapters = ((PatternInjectedCall) object).getContext().eAdapters();
                addIntoAdapters(eAdapters, refresher);
            }
        }
    }

    /**
     * Remove the MethodCall's called or PatternInjectedCall's context adapters.
     */
    public static void removeChildAdapter(Object object, AdapterImpl refresher) {
        if (object instanceof MethodCall) {
            if (((MethodCall) object).getCalled() != null) {
                EList<Adapter> eAdapters = ((MethodCall) object).getCalled().eAdapters();
                removeFromeAdapters(eAdapters, refresher);
            }
        } else if (object instanceof PatternInjectedCall) {
            if (((PatternInjectedCall) object).getContext() != null) {
                EList<Adapter> eAdapters = ((PatternInjectedCall) object).getContext().eAdapters();
                removeFromeAdapters(eAdapters, refresher);
            }
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
    public static void validationContent(IMessageManager mmng, EObject object, final String key, Control control) {
        if (control != null && !control.isDisposed()) {
            IStatus status = EMFvalidator.batchValidate(object, key);
            setErrorMessage(status, mmng, key, control);
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
            if ((status.getCode() == 1 && ValidationConstants.CONSTRAINTS_PATTERN_NAME_NOT_EMPTY_ID.equals(key)) || (status.getCode() == 2 && ValidationConstants.CONSTRAINTS_PATTERN_PARAMETER_NOT_EMPTY_NAME_ID.equals(key))
                    || (status.getCode() == 3 && ValidationConstants.CONSTRAINTS_PATTERN_VARIABLE_NAME_NOT_EMPTY_ID.equals(key)))
                mmng.addMessage(key, status.getMessage(), null, IMessageProvider.ERROR, control);
        } else {
            mmng.removeMessage(key, control);
        }
    }

    /**
     * Return whether the method can be rename.
     */
    public static boolean isRenameDisable(PatternMethod element) {
        return PatternFactory.isSpecialMethod(element.getName());
    }

    /**
     * If the validation adapter is not exist,add a new one.
     */
    public static LiveValidationContentAdapter addValidationAdapter(IMessageManager mmng, Pattern pattern, String key, Control control) {
        LiveValidationContentAdapter liveValidationContentAdapter = new LiveValidationContentAdapter(control, mmng, key, pattern);
        PatternUIHelper.addAdapterForPattern(pattern, liveValidationContentAdapter);
        validationContent(mmng, pattern, key, control);
        return liveValidationContentAdapter;
    }

    /**
     * Add a refresh adapter for the new item.
     */
    public static void addAdapterForNewItem(TableViewer tableViewer, Object newItem) {
        final AdapterImpl refresher = new RefresherAdapter(tableViewer);
        addAdapter(newItem, refresher);
    }

    public static void addEMFValidationAfterRemove(IMessageManager mmng, Pattern pattern, String key, Control control, LiveValidationContentAdapter liveValidationContentAdapter) {
        liveValidationContentAdapter = new LiveValidationContentAdapter(control, mmng, key, pattern);
        PatternUIHelper.addAdapterForPattern(pattern, liveValidationContentAdapter);

    }

    /**
     * Check the queryContents whether has duplicate keys.
     */
    public static boolean hasDuplicateKey(List<QueryContent> queryContents) {
        if (queryContents != null) {
            for (int i = 0; i < queryContents.size(); i++) {
                String key = queryContents.get(i).getKey();
                for (int j = i + 1; j < queryContents.size(); j++) {
                    String currentKey = queryContents.get(j).getKey();
                    if (currentKey.equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
