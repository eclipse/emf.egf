/**
 * <copyright>
 *
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
 * 
 * </copyright>
 */

package parsejet.test2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.codegen.jet.JETException;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenJetCompilerTestCase extends TestCase {

     public void testDev() throws Exception {
            internalTest("model/Class.javajet"); //$NON-NLS-1$
     }

    private void internalTest(String path) throws JETException, Exception, IOException {
        String templateURI = getTemplateURI(path);
        CodegenJetParser parser = new CodegenJetParser(templateURI);
        parser.parse();
    }

    private String getTemplateURI(String templateRelativePath) throws MalformedURLException {
        URL url = new URL("platform:/plugin/org.eclipse.emf.codegen.ecore/templates/" + templateRelativePath); //$NON-NLS-1$
        return FileLocator.find(url).toString();
    }
}
