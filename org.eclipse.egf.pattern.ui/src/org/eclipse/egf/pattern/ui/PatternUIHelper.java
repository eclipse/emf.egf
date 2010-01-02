/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;

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
}
