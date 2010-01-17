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

package org.eclipse.egf.pattern.java.extension;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.extension.PatternFactory;

/**
 * @author Guiu
 * 
 */
public class JavaPatternFactory extends PatternFactory {

    @Override
    protected void addNature(Pattern pattern) {
        pattern.setNature(org.eclipse.egf.model.javapattern.JavaPatternFactory.eINSTANCE.createJavaNature());
    }

}
