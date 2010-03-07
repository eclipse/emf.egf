/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */
package org.eclipse.egf.core.helper;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.l10n.EGFCoreMessages;

public class EclipseBuilderHelper {

  private EclipseBuilderHelper() {
    // Prevent Instantiation
  }

  public static void addNature(IProjectDescription description, String nature, IProgressMonitor monitor) {
    SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_addNature, 100);
    Assert.isNotNull(description);
    Assert.isNotNull(nature);
    Assert.isLegal(nature.trim().length() > 0);
    Assert.isNotNull(monitor);
    String[] prevNatures = description.getNatureIds();
    String[] newNatures = new String[prevNatures.length + 1];
    System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
    newNatures[prevNatures.length] = nature.trim();
    description.setNatureIds(newNatures);
  }

  public static void addToFrontOfBuildSpec(IProjectDescription description, String builder, IProgressMonitor monitor) {
    SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_addBuilder, 300);
    Assert.isNotNull(description);
    Assert.isNotNull(builder);
    Assert.isLegal(builder.trim().length() > 0);
    Assert.isNotNull(monitor);
    ICommand builderCommand = getBuilderCommand(description, builder, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    if (builderCommand == null) {
      // Add a new build spec
      ICommand command = description.newCommand();
      command.setBuilderName(builder.trim());
      setFrontBuilderCommand(description, command, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    }
  }

  public static void addToBuildSpec(IProjectDescription description, String builder, IProgressMonitor monitor) {
    SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_addBuilder, 300);
    Assert.isNotNull(description);
    Assert.isNotNull(builder);
    Assert.isLegal(builder.trim().length() > 0);
    Assert.isNotNull(monitor);
    ICommand builderCommand = getBuilderCommand(description, builder, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    if (builderCommand == null) {
      // Add a new build spec
      ICommand command = description.newCommand();
      command.setBuilderName(builder.trim());
      setBuilderCommand(description, command, subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    }
  }

  public static ICommand getBuilderCommand(IProjectDescription description, String builder, IProgressMonitor monitor) {
    SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_getBuilder, 100);
    Assert.isNotNull(description);
    Assert.isNotNull(builder);
    Assert.isLegal(builder.trim().length() > 0);
    Assert.isNotNull(monitor);
    ICommand[] commands = description.getBuildSpec();
    for (int i = 0; i < commands.length; ++i) {
      if (commands[i].getBuilderName().equals(builder)) {
        return commands[i];
      }
    }
    return null;
  }

  public static void removeFromBuildSpec(IProjectDescription description, String builder, IProgressMonitor monitor) {
    SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_removeBuilder, 100);
    Assert.isNotNull(description);
    Assert.isNotNull(builder);
    Assert.isLegal(builder.trim().length() > 0);
    Assert.isNotNull(monitor);
    ICommand[] commands = description.getBuildSpec();
    for (int i = 0; i < commands.length; ++i) {
      if (commands[i].getBuilderName().equals(builder.trim())) {
        ICommand[] newCommands = new ICommand[commands.length - 1];
        System.arraycopy(commands, 0, newCommands, 0, i);
        System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
        description.setBuildSpec(newCommands);
        break;
      }
    }
    return;
  }

  public static void setBuilderCommand(IProjectDescription description, ICommand command, IProgressMonitor monitor) {
    SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_setBuilder, 200);
    Assert.isNotNull(description);
    Assert.isNotNull(command);
    Assert.isNotNull(monitor);
    ICommand[] oldCommands = description.getBuildSpec();
    ICommand oldBuilderCommand = getBuilderCommand(description, command.getBuilderName(), subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    ICommand[] newCommands;
    if (oldBuilderCommand == null) {
      // Add a build spec after other builders
      newCommands = new ICommand[oldCommands.length + 1];
      System.arraycopy(oldCommands, 0, newCommands, 0, oldCommands.length);
      newCommands[oldCommands.length] = command;
    } else {
      for (int i = 0, max = oldCommands.length; i < max; i++) {
        if (oldCommands[i] == oldBuilderCommand) {
          oldCommands[i] = command;
          break;
        }
      }
      newCommands = oldCommands;
    }
    description.setBuildSpec(newCommands);
  }

  public static void setFrontBuilderCommand(IProjectDescription description, ICommand command, IProgressMonitor monitor) {
    SubMonitor subMonitor = SubMonitor.convert(monitor, EGFCoreMessages.EclipseBuilderHelper_setBuilder, 200);
    Assert.isNotNull(description);
    Assert.isNotNull(command);
    Assert.isNotNull(monitor);
    ICommand[] oldCommands = description.getBuildSpec();
    ICommand oldBuilderCommand = getBuilderCommand(description, command.getBuilderName(), subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE));
    ICommand[] newCommands;
    if (oldBuilderCommand == null) {
      // Add a build spec in front of other builders
      newCommands = new ICommand[oldCommands.length + 1];
      System.arraycopy(oldCommands, 0, newCommands, 1, oldCommands.length);
      newCommands[0] = command;
    } else {
      for (int i = 0, max = oldCommands.length; i < max; i++) {
        if (oldCommands[i] == oldBuilderCommand) {
          oldCommands[i] = command;
          break;
        }
      }
      newCommands = oldCommands;
    }
    description.setBuildSpec(newCommands);
  }

}
