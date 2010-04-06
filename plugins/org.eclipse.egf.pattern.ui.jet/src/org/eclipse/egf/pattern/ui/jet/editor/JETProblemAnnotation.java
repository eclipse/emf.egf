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

package org.eclipse.egf.pattern.ui.jet.editor;

import org.eclipse.jet.core.parser.ProblemSeverity;
import org.eclipse.jet.core.parser.ast.Problem;
import org.eclipse.jface.text.source.Annotation;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JETProblemAnnotation extends Annotation {

    public static final String ERROR_ANNOTATION_TYPE = "org.eclipse.jet.editor.error";

    public static final String WARNING_ANNOTATION_TYPE = "org.eclipse.jet.editor.warning";

    public static final String INFO_ANNOTATION_TYPE = "org.eclipse.jet.editor.info";

    public JETProblemAnnotation(Problem problem) {
        if (problem.getProblemSeverity() == ProblemSeverity.ERROR)
            setType(ERROR_ANNOTATION_TYPE);
        else if (problem.getProblemSeverity() == ProblemSeverity.WARNING)
            setType(WARNING_ANNOTATION_TYPE);
        setText(problem.getMessage());
    }

}
