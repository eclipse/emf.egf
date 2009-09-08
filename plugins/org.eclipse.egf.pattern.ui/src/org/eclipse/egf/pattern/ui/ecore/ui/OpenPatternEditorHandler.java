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
package org.eclipse.egf.pattern.ui.ecore.ui;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ui.editor.PatternEditor;
import org.eclipse.egf.pattern.ui.editor.PatternEditorInput;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


/**
 * @author Guillaume Brocard
 */
public class OpenPatternEditorHandler extends AbstractHandler {
  
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(OpenPatternEditorHandler.class.getPackage().getName());

  /**
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent executionEvent_p) throws ExecutionException {
    EvaluationContext applicationContext = (EvaluationContext) executionEvent_p.getApplicationContext();
    // Precondition.
    if (applicationContext == null) {
      return null;
    }
    // Enable log4j support.
    CoreActivator.getDefault();
    final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    final String editorId = PatternEditor.ID;
    // Get default variable as context.
    Collection<?> defaultVariable = (Collection<?>) applicationContext.getDefaultVariable();
    // Cycle through the context variables.
    for (Object currentVariable : defaultVariable) {
      // If a java project is selected, deal with it as a potential pattern generator.
      if (currentVariable instanceof IJavaProject) {
        IProject project = ((IJavaProject) currentVariable).getProject();
        IPluginModelBase pluginModel = PluginRegistry.findModel(project);
        final String[] pluginId = new String[] { null };
        if (pluginModel != null) {
          pluginId[0] = pluginModel.getPluginBase().getId();
        }
        WorkspacePatternExtensionReader reader = new WorkspacePatternExtensionReader();
        IDescriptor patternsDescriptor = reader.getPatternLibraries(project);
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
              PatternModel patternModel = ModelFactory.eINSTANCE.createPatternModel();
              patternModel.setPath((String) descriptor_p.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME));
              patternModel.setName((String) descriptor_p.getValue(ExtensionPointHelper.ATT_NAME));
              patternModel.setId(patternFullId_p);
              try {
                page.openEditor(
                  new PatternEditorInput(
                    pluginId[0], 
                    patternModel, 
                    true
                  ), 
                  editorId
                );
              } catch (PartInitException exception_p) {
                StringBuilder loggerMessage = new StringBuilder(".handlePatternDescriptor(..) _ "); //$NON-NLS-1$
                __logger.warn(loggerMessage.toString(), exception_p);
              }
            }
          },
          patternsDescriptor
        );
      }
    }
    return null;
  }
  
}
