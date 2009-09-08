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
package org.eclipse.egf.batch.application.taskdefs;

import org.eclipse.egf.batch.application.headless.FactoryComponentHeadlessApplication;


/**
 * Run a factory component from provided factory component id.<br>
 * It instantiates {@link FactoryComponentRunnerApplication} to run the provided FC.<br>
 * <P>
 * This task is supposed to be executed by the Eclipse {@link AntRunner} application.<br>
 * The following command line will start the {@link AntRunner} application and run the specified Ant script.
 * </p>
 * <p>
 * <i>eclipseDir</i>/eclipse -noSplash -data <i>worspaceDir</i> -application org.eclipse.ant.core.antRunner -buildfile <i>antScript</i>
 * </p>
 * <p>
 * Usage example:
 * </p>
 * 
 * <pre>
 * &lt;egf.FactoryComponentRunnerInHeadlessMode factoryComponentId=&quot;fc.1197474451873.101&quot; /&gt;
 * </pre>
 * 
 * In examples folder, you will find an Ant script example (i.e build.xml) that you can use to write your own one.
 * @author Guillaume Brocard
 */
public class FactoryComponentHeadlessRunnerTask extends AbstractFactoryComponentRunnerTask {
  
  /**
   * @see org.eclipse.egf.common.ant.AbstractAntTask#doExecute()
   */
  @Override
  protected void doExecute() throws Exception {
    new FactoryComponentHeadlessApplication().run(getFactoryComponentId());
  }
  
}