/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package parsejet.test2;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;

/**
 * @author Matthieu Helleboid
 * 
 */
public class StructureVisitor extends ASTVisitor {

    private final CodegenJetParser codegenJetParser;

    StructureVisitor(CodegenJetParser codegenJetParser) {
        this.codegenJetParser = codegenJetParser;
    }

    Section section;
    int depth;

    @Override
    public boolean visit(ClassInstanceCreation node) {
        Mark mark = this.codegenJetParser.getMark(node);
        if (mark == null)
            return true;

        Section includeSection = new Section(node);

        switch (mark) {
        case EGFMarkInclude:
        case EGFMarkIncludeSilent:
            section.subSections.add(includeSection);
            includeSection.parentSection = section;
            break;
        case EGFMarkIncludeAlternative:
            includeSection.parentSection = section;
            section.subSections.add(includeSection);

            section = includeSection;
            depth++;
            break;
        case EGFMarkStart:
            break;
        case EGFMarkEnd:
            section = section.parentSection;
            depth--;
            break;
        }

        return true;
    }

}