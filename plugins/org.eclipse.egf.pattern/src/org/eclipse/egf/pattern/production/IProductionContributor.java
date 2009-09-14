/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.production;

import java.util.List;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.relations.ParameterRelation;


/**
 * A production contributor.<br>
 * Typically handles a specific platform production code.
 * @author Guillaume Brocard
 */
public interface IProductionContributor {
  
  /**
   * Create pre/post pattern matching templates.<br>
   * Those are supposed to be produced in the generated templates folder.<br>
   * Their physical form depends on the template engine used (as for the file extension for instance).
   * @param patternData_p The structure containing most of the pattern required data for generation.
   * @param parameters_p The fully resolved list of parameters (including parent hierarchy) for considered pattern.
   * @return A couple of (pre-matching, post-matching) {@link StringBuilder} containing resulting template code, null if there is no such content.
   */
  public Couple<StringBuilder, StringBuilder> createPatternMatchingTemplates(PatternData patternData_p, List<ParameterRelation> parameters_p);

  /**
   * Compile given template, if applicable.
   * @param generatedTemplatePath_p
   * @param patternData_p
   * @return
   * @throws Exception
   */
  public boolean compileTemplate(String generatedTemplatePath_p, PatternData patternData_p) throws Exception;

  /**
   * Fill, if applicable, generateHeader method of the pattern, if it does not exist or is empty.<br>
   * Given content should ensure pattern compilation phase, whether this lead to a valid status or not.<br>
   * The user will then be able to choose a more convenient content.
   * @param patternData_p
   * @param handler_p A usable annotation handler, null if none.
   * @throws Exception
   */
  public void fillGenerateHeader(PatternData patternData_p, AnnotationHandler handler_p) throws Exception;
  
}
