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

package parsejet.test2;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;

/**
 * @author Matthieu Helleboid
 * 
 */
public class PrintVisitor extends ASTVisitor {

    private final CodegenJetParser codegenJetParser;

    PrintVisitor(CodegenJetParser codegenJetParser) {
        this.codegenJetParser = codegenJetParser;
    }

    private StringBuilder builder = new StringBuilder();
    
    @Override
    public boolean visit(ClassInstanceCreation node) {
        Mark mark = codegenJetParser.getMark(node);

        if (mark == null)
            return true;
        
        List<String> arguments = codegenJetParser.getArguments(node);
        String file = null;
        int index = -1;
        
        switch (mark) {
        case EGFMarkChars:
            index = Integer.valueOf(arguments.get(0)).intValue();
            builder.append(codegenJetParser.charsList.get(index));
            break;
        case EGFMarkExpression:
            index = Integer.valueOf(arguments.get(0)).intValue();
            builder.append("<%");
            builder.append(codegenJetParser.charsList.get(index));
            builder.append("%>");
        case EGFMarkInclude:
            file = arguments.get(0);
            break;
        case EGFMarkIncludeSilent:
            file = arguments.get(0);
            break;
        }

        return true;
    }
    
    @Override
    public String toString() {
        return builder.toString();
    }

}