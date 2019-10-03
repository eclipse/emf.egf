/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern.commands;

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.CreateCopyCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Xavier Maysonnave
 *
 */
public class PatternCreateCopyCommand extends CreateCopyCommand {

    /**
     * This creates and instance in the given domain and for the given owner
     */
    public PatternCreateCopyCommand(EditingDomain domain, Pattern owner, CopyCommand.Helper copyHelper) {
        super(domain, owner, copyHelper);
    }

    @Override
    protected boolean prepare() {
        if (super.prepare() == false) {
            return false;
        }
        Pattern pattern = (Pattern) owner;
        // Ignore
        if (pattern.eResource() == null) {
            return true;
        }
        // Checking
        String bundleId = EcoreUtil.getURI(pattern).segment(1);
        try {
            for (PatternMethod method : pattern.getMethods()) {
                // Pattern File Path checking
                URI uri = method.getPatternFilePath();
                // if a pattern file path is null, do not perform
                if (uri == null) {
                    return false;
                }
                // if a pattern file path do not belong to the pattern bundle, do not perform
                if (bundleId.equals(uri.segment(1)) == false) {
                    return false;
                }
                // if a pattern file path do not match the pattern id, do not perform
                if (pattern.getID().equals(TemplateModelFileHelper.extractPatternId(new Path(method.getPatternFilePath().toPlatformString(true)))) == false) {
                    return false;
                }
                // if a pattern file path do not match the method id, do not perform
                if (method.getID().equals(TemplateModelFileHelper.extractPatternMethodId(new Path(method.getPatternFilePath().toPlatformString(true)))) == false) {
                    return false;
                }
            }
        } catch (Throwable t) {
            return false;
        }
        return true;
    }

}
