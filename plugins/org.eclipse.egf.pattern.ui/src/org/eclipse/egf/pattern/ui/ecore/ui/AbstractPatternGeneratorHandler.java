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

import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.pattern.ecore.AbstractPatternGenerator;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;


/**
 * A command handler that retrieves the abstract pattern generator, and allows to execute a command.
 * @author brocard
 */
public abstract class AbstractPatternGeneratorHandler extends AbstractHandler {
  /**
   * Log4j reference logger.
   */
  protected static final Logger __logger = Logger.getLogger(AbstractPatternGeneratorHandler.class.getPackage().getName());
  /**
   * MDSoFa pattern generator extension point id.
   */
  protected static final String PATTERN_GENERATOR_EXTENSION_POINT_ID = "patternGenerator"; //$NON-NLS-1$

  /**
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  @SuppressWarnings("unchecked")
  public Object execute(ExecutionEvent executionEvent_p) throws ExecutionException {
    EvaluationContext applicationContext = (EvaluationContext) executionEvent_p.getApplicationContext();
    // Precondition.
    if (null == applicationContext) {
      return null;
    }
    CoreActivator.getDefault();
    // Get default variable as context.
    Collection defaultVariable = (Collection) applicationContext.getDefaultVariable();
    // Cycle through the context variables.
    for (Object currentVariable : defaultVariable) {
      // If a java project is selected, deal with it as a potential pattern generator.
      if (currentVariable instanceof IJavaProject) {
        IProject project = ((IJavaProject) currentVariable).getProject();
        IPluginModelBase pluginModel = PluginRegistry.findModel(project);
        if (null != pluginModel) {
          String pluginId = pluginModel.getPluginBase().getId();
          IConfigurationElement root =
              ExtensionPointHelper.getConfigurationElement(PatternUiActivator.getDefault().getPluginID(), PATTERN_GENERATOR_EXTENSION_POINT_ID, pluginId);
          if (null != root) {
            IConfigurationElement[] generators = root.getChildren();
            for (IConfigurationElement generator : generators) {
              AbstractPatternGenerator patternGenerator =
                  (AbstractPatternGenerator) ExtensionPointHelper.createInstance(generator, ExtensionPointHelper.ATT_CLASS);
              if (null != patternGenerator) {
                doExecute(patternGenerator);
                try {
                  project.refreshLocal(IResource.DEPTH_INFINITE, null);
                } catch (CoreException exception_p) {
                  StringBuilder loggerMessage = new StringBuilder("AbstractPatternGeneratorHandler.execute(..) _ "); //$NON-NLS-1$
                  loggerMessage.append("Could not refresh project ").append(project.getName()); //$NON-NLS-1$
                  __logger.warn(loggerMessage.toString(), exception_p);
                }
              } else {
                StringBuilder loggerMessage = new StringBuilder("AbstractPatternGeneratorHandler.execute(..) _ "); //$NON-NLS-1$
                loggerMessage.append("no pattern generator declared for "); //$NON-NLS-1$
                loggerMessage.append(pluginId);
                __logger.warn(loggerMessage.toString());
              }
            }
          }
        }
      }
    }
    return null;
  }

  /**
   * Do execute action for given abstract pattern generator.
   * @param generator_p A not null pattern generator.
   */
  protected abstract void doExecute(AbstractPatternGenerator generator_p);
}
