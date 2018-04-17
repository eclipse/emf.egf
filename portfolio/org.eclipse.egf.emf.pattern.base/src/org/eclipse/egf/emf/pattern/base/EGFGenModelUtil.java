/**
 * Copyright (c) 2009, 2018 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.emf.pattern.base;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFGenModelUtil {

  private EGFGenModelUtil() {
    // Prevent Instantiation
  }

  /**
   * @see org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil#createGenerator(GenModel)
   */
  public static Generator createGenerator(GenModel genModel, URI mergeRulesURI) {
    Generator generator = new Generator();
    generator.setInput(genModel);
    if (mergeRulesURI != null) {
      generator.getOptions().mergeRulesURI = mergeRulesURI.toString();
    }
    JControlModel jControlModel = generator.getJControlModel();
    if (genModel.isCodeFormatting()) {
      jControlModel.setLeadingTabReplacement(null);
      jControlModel.setConvertToStandardBraceStyle(false);
    } else {
      Map<?, ?> options = JavaCore.getOptions();
      String tabSize = (String) options.get(DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE);
      String braceStyle = (String) options.get(DefaultCodeFormatterConstants.FORMATTER_BRACE_POSITION_FOR_TYPE_DECLARATION);
      String tabCharacter = (String) options.get(DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR);
      if (JavaCore.TAB.equals(tabCharacter)) {
        jControlModel.setLeadingTabReplacement("\t"); //$NON-NLS-1$
      } else {
        String spaces = ""; //$NON-NLS-1$
        for (int i = Integer.parseInt(tabSize); i > 0; --i) {
          spaces += " "; //$NON-NLS-1$
        }
        jControlModel.setLeadingTabReplacement(spaces);
      }
      jControlModel.setConvertToStandardBraceStyle(DefaultCodeFormatterConstants.END_OF_LINE.equals(braceStyle));
    }
    return generator;
  }

}
