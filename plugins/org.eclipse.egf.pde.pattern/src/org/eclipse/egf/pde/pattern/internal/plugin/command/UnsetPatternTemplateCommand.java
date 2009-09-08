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
package org.eclipse.egf.pde.pattern.internal.plugin.command;

/**
 * This command removes a generated pattern in an extension matching <code>generatedPattern</code> extension-point.
 * @author Guillaume Brocard
 */
public class UnsetPatternTemplateCommand extends AbstractPatternTemplateCommand {

  /**
   * Constructor.
   * @param patternFullId_p
   */
  public UnsetPatternTemplateCommand(String patternFullId_p) {
    super(patternFullId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractUnsetExtensionCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    removeExtension(getPatternFullId());
  }
  
}