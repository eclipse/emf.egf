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

package org.eclipse.egf.pattern;

import org.eclipse.egf.model.pattern.Pattern;

/**
 * D'une maniere ou d'une autre je dois pouvoir savoir où vit mon pattern i.e.
 * son FC puis le projet ou plugins où celui ci se trouve
 * 
 * @author Guiu
 * 
 */
public class Registry_to_be_upgraded {

    public static String getProjectName(Pattern pattern) {
        return "test5";
    }
}
