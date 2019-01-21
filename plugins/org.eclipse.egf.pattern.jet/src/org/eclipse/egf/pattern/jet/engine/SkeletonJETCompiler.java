/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
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
@SuppressWarnings("deprecation")
public class SkeletonJETCompiler extends JetTagsCompiler {

    private static final String GENERATOR_SKELETON = "platform:/plugin/org.eclipse.egf.pattern.jet/templates/generator.skeleton"; //$NON-NLS-1$

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
    @Override
    public void handleDirective(String directive, JETMark start, JETMark stop, Map<String, String> attributes) throws JETException {
        if (directive.equals("jet") && skeleton == null) { //$NON-NLS-1$
            skeleton = new CustomJETSkeleton();
            String skeletonURI = attributes.get("skeleton"); //$NON-NLS-1$
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
                if (entry.getKey().equals("skeleton")) { //$NON-NLS-1$
                    // Ignore
                } else if (entry.getKey().equals("package")) { //$NON-NLS-1$
                    skeleton.setPackageName(entry.getValue());
                } else if (entry.getKey().equals("imports")) { //$NON-NLS-1$
                    skeleton.addImports(entry.getValue());
                } else if (entry.getKey().equals("class")) { //$NON-NLS-1$
                    skeleton.setClassName(entry.getValue());
                } else if (entry.getKey().equals("nlString")) { //$NON-NLS-1$
                    skeleton.setNLString(entry.getValue());
                } else if (entry.getKey().equals("startTag")) { //$NON-NLS-1$
                    parser.setStartTag(entry.getValue());
                } else if (entry.getKey().equals("endTag")) { //$NON-NLS-1$
                    parser.setEndTag(entry.getValue());
                } else if (entry.getKey().equals("version")) { //$NON-NLS-1$
                    // Ignore the version
                } else {
                    throw new JETException(CodeGenPlugin.getPlugin().getString("jet.error.bad.attribute", new Object[] { //$NON-NLS-1$
                                    entry.getKey(), start.format("jet.mark.file.line.column") //$NON-NLS-1$
                            }));
                }
            }

            handleNewSkeleton();
        }
        super.handleDirective(directive, start, stop, attributes);
    }

}
