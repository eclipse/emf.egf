/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.jet.extension;

import org.eclipse.egf.model.jetpattern.JetPatternFactory;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.extension.PatternExtensionFactory;

/**
 * @author Guiu
 * 
 */
public class JetPatternExtensionFactory extends PatternExtensionFactory {

    public void addNature(Pattern pattern) {
        pattern.setNature(JetPatternFactory.eINSTANCE.createJetNature());
    }

}
