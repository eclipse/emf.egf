/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.jet.engine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.codegen.CodeGenPlugin;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jet.JETMark;
import org.eclipse.emf.codegen.jet.JETSkeleton;
import org.eclipse.jdt.core.jdom.IDOMNode;
import org.eclipse.jdt.core.jdom.IDOMType;

/**
 * @author Thomas Guiu
 * 
 */
public class SkeletonJETCompiler extends JetTagsCompiler {
    private static final String GENERATOR_SKELETON = "platform:/plugin/org.eclipse.egf.pattern.jet/templates/generator.skeleton";

    public static class CustomJETSkeleton extends JETSkeleton {
        public void setParentClass(String classname) {
            for (IDOMNode node = compilationUnit.getFirstChild(); node != null; node = node.getNextNode()) {
                if (node.getNodeType() == IDOMNode.TYPE) {
                    IDOMType type = (IDOMType) node;
                    type.setSuperclass(classname);
                }
            }

        }
    }

    public SkeletonJETCompiler(String templateURI, InputStream inputStream, String encoding) throws JETException {
        super(templateURI, inputStream, encoding);
    }

    /**
     * Overriding the method to enhance the behavior (change the default
     * skeleton)
     */
    public void handleDirective(String directive, JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (directive.equals("jet") && skeleton == null) {
            skeleton = new CustomJETSkeleton();
            String skeletonURI = attributes.get("skeleton");
            if (skeletonURI == null)
                skeletonURI = GENERATOR_SKELETON;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openStream(resolveLocation(templateURIPath, templateURI, skeletonURI)[1]));
                byte[] input = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(input);
                bufferedInputStream.close();
                skeleton.setCompilationUnitContents(new String(input));
            } catch (IOException exception) {
                throw new JETException(exception);
            }

            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                // Ignore this now
                //
                if (entry.getKey().equals("skeleton")) {
                    // Ignore
                } else if (entry.getKey().equals("package")) {
                    skeleton.setPackageName(entry.getValue());
                } else if (entry.getKey().equals("imports")) {
                    skeleton.addImports(entry.getValue());
                } else if (entry.getKey().equals("class")) {
                    skeleton.setClassName(entry.getValue());
                } else if (entry.getKey().equals("nlString")) {
                    skeleton.setNLString(entry.getValue());
                } else if (entry.getKey().equals("startTag")) {
                    parser.setStartTag(entry.getValue());
                } else if (entry.getKey().equals("endTag")) {
                    parser.setEndTag(entry.getValue());
                } else if (entry.getKey().equals("version")) {
                    // Ignore the version
                } else {
                    throw new JETException(CodeGenPlugin.getPlugin().getString("jet.error.bad.attribute", new Object[] { entry.getKey(), start.format("jet.mark.file.line.column") }));
                }
            }

            handleNewSkeleton();
        }
        super.handleDirective(directive, start, stop, attributes);
    }

}
