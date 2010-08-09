/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.genchain.tools;

import org.eclipse.emf.common.util.URI;

/**
 * 
 * @author Thomas Guiu
 */
public interface Uris {
    URI EEF_EDIT_GEN_TASK_URI = URI.createPlatformPluginURI("com.thalesgroup.mde.tig.genchain.egf.eefgen.edit.fc/model/EEFEditGen.fcore", false);
    URI EEF_EDITOR_GEN_TASK_URI = URI.createPlatformPluginURI("com.thalesgroup.mde.tig.genchain.egf.eefgen.editor.fc/model/EEFEditorGen.fcore", false);

    URI MODEL_GEN_TASK_URI = URI.createPlatformPluginURI("", false);
    URI EDIT_GEN_TASK_URI = URI.createPlatformPluginURI("", false);
    URI EDITOR_GEN_TASK_URI = URI.createPlatformPluginURI("", false);

}
