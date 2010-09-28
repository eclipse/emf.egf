/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.extension;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.emf.common.util.URI;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IPatternExtensionFactory {

    public Pattern createPattern(PatternLibrary lib, String patternName);

    public URI createURI(PatternMethod method);

    public void addNature(Pattern pattern);

}
