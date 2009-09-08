/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.ui.ecore.ui;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.pattern.production.GeneratedContentProducer;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;


/**
 * @author Guillaume Brocard
 */
public class GenerateConditionClassHandler extends AbstractHandler {
  /**
   * Log4j reference logger.
   */
  protected static final Logger __logger = Logger.getLogger(GenerateConditionClassHandler.class.getPackage().getName());

  /**
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent arg0_p) throws ExecutionException {
    // Enable log4j support.
    CoreActivator.getDefault();
    // Cycle through patterns so as to produce found patterns structures.
    WorkspacePatternExtensionReader reader = new WorkspacePatternExtensionReader();
    IDescriptor descriptor = reader.getPatternLibraries();
    final GeneratedContentProducer conditionProducer = new GeneratedContentProducer();
    PatternDescriptorStrategy strategy = new PatternDescriptorStrategy();
    strategy.iterateThroughPatternExtensionDescriptor(
      new IPatternDescriptorHandler() {
        public void handleDescriptor(IDescriptor descriptor_p) {
          // Nothing to do.
        }
        public void handleLibraryDescriptor(IDescriptor descriptor_p, String parentLibraryId_p) {
          // Nothing to do.
        }
        public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
          String ecoreRelativePath = (String) descriptor_p.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
          try {
            conditionProducer.produceConditionStructures(ecoreRelativePath);
          } catch (Exception exception_p) {
            StringBuilder loggerMessage = new StringBuilder("GenerateEcoreHandler.doExecute(..) _ "); //$NON-NLS-1$
            __logger.warn(loggerMessage.toString(), exception_p);
          }
        }
      }, 
      descriptor
    );
    return null;
  }
}
