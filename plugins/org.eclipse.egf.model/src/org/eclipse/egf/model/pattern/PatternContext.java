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

package org.eclipse.egf.model.pattern;

/**
 * TODO Ici on ne devrait avoir qu'une pauvre map avec name-valeur. Son
 * initialisation étant à la charge de l'orchestrateur. TODO il faudrait ajouetr
 * un peu de control pour savoir les noms en lecture et ceux en écriture.
 * 
 * 
 * @author Thomas Guiu
 * 
 */
public interface PatternContext {

    /**
     * Public Keys to manage the patter execution reporter.
     */
    final String PATTERN_REPORTER = "pattern.execution.reporter"; //$NON-NLS-1$
    final String PATTERN_ID = "pattern.id"; //$NON-NLS-1$
    final String CALL_BACK_HANDLER = "pattern.call.back.handler"; //$NON-NLS-1$
    final String MODEL_DRIVEN_DOMAIN_VISITOR = "pattern.modeldriven.visitor"; //$NON-NLS-1$
    final String PATTERN_IDS_PARAMETER = "pattern.ids"; //$NON-NLS-1$
    final String PATTERN_SUBSTITUTIONS = "pattern.substitutions"; //$NON-NLS-1$
    final String DOMAIN_OBJECTS = "domain"; //$NON-NLS-1$

    /**
     * keys to manage the context injected to a pattern.
     */
    final String INJECTED_CONTEXT = "internal.injected.context"; //$NON-NLS-1$

    /**
     * key to manage the object collection to perform queries on.
     */

    void setValue(String name, Object value);

    Object getValue(String name);

}
