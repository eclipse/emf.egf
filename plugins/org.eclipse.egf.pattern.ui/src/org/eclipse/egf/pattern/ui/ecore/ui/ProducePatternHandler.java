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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;


/**
 * @author brocard
 */
public class ProducePatternHandler extends AbstractHandler {
  /**
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent executionEvent_p) throws ExecutionException {
    EvaluationContext applicationContext = (EvaluationContext) executionEvent_p.getApplicationContext();
    // Precondition.
    if (null == applicationContext) {
      return null;
    }
    CoreActivator.getDefault();
    // Get default variable as context.
    Collection<?> defaultVariable = (Collection<?>) applicationContext.getDefaultVariable();
    // Cycle through the context variables.
    for (Object currentVariable : defaultVariable) {
      // If a java project is selected, deal with it as a potential pattern generator.
      if (currentVariable instanceof IJavaProject) {
        IProject project = ((IJavaProject) currentVariable).getProject();
        IPluginModelBase pluginModel = PluginRegistry.findModel(project);
        if (null != pluginModel) {
          String pluginId = pluginModel.getPluginBase().getId();
          IConfigurationElement root =
              ExtensionPointHelper.getConfigurationElement(PatternUiActivator.getDefault().getPluginID(), "patternProduction", pluginId); //$NON-NLS-1$
          if (null != root) {
            IConfigurationElement[] productionReferences = root.getChildren();
            for (IConfigurationElement reference : productionReferences) {
              String fullId = reference.getAttribute(ExtensionPointHelper.ATT_ID);
              if (null != fullId) {
                PatternActivator.getDefault().producePatterns(fullId, true, null);
              }
            }
          }
        }
      }
    }
    return null;
  }
}
