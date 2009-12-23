/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.core.helper;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;


public class EclipseBuilderHelper {
  
  public static void addNatureToProject(IProject proj, String natureId, IProgressMonitor monitor) throws CoreException {
    IProjectDescription description = proj.getDescription();
    String[] prevNatures = description.getNatureIds();
    String[] newNatures = new String[prevNatures.length + 1];
    System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
    newNatures[prevNatures.length] = natureId;
    description.setNatureIds(newNatures);
    proj.setDescription(description, monitor);
  }  
  
  public static void addToFrontofBuildSpec(IProject project_p, String builderId_p) throws CoreException {
    if (project_p == null || builderId_p == null) {
      return;
    }
    IProjectDescription description = project_p.getDescription();
    ICommand builderCommand = getBuilderCommand(description, builderId_p);
    if (builderCommand == null) {
      // Add a new build spec
      ICommand command = description.newCommand();
      command.setBuilderName(builderId_p);
      setFrontBuilderCommand(project_p, description, command);
    }
  }  

  public static void addToBuildSpec(IProject project_p, String builderId_p) throws CoreException {
    if (project_p == null || builderId_p == null) {
      return;
    }    
    IProjectDescription description = project_p.getDescription();
    ICommand builderCommand = getBuilderCommand(description, builderId_p);
    if (builderCommand == null) {
      // Add a new build spec
      ICommand command = description.newCommand();
      command.setBuilderName(builderId_p);
      setBuilderCommand(project_p, description, command);
    }
  }

  public static ICommand getBuilderCommand(IProjectDescription description_p, String builderId_p) {
    ICommand[] commands = description_p.getBuildSpec();
    for (int i = 0; i < commands.length; ++i) {
      if (commands[i].getBuilderName().equals(builderId_p)) {
        return commands[i];
      }
    }
    return null;
  }

  public static void removeFromBuildSpec(IProject project_p, String builderId_p) throws CoreException {
    if (project_p == null || builderId_p == null) {
      return;
    }        
    IProjectDescription description = project_p.getDescription();
    ICommand[] commands = description.getBuildSpec();
    for (int i = 0; i < commands.length; ++i) {
      if (commands[i].getBuilderName().equals(builderId_p)) {
        ICommand[] newCommands = new ICommand [commands.length - 1];
        System.arraycopy(commands, 0, newCommands, 0, i);
        System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
        description.setBuildSpec(newCommands);
        return;
      }
    }
  }

  public static void setBuilderCommand(IProject project_p, IProjectDescription description_p, ICommand newCommand_p) throws CoreException {
    if (project_p == null || description_p == null || newCommand_p == null) {
      return;
    }
    ICommand[] oldCommands = description_p.getBuildSpec();
    ICommand oldBuilderCommand = getBuilderCommand(description_p, newCommand_p.getBuilderName());
    ICommand[] newCommands;
    if (oldBuilderCommand == null) {
      // Add a build spec after other builders
      newCommands = new ICommand [oldCommands.length + 1];
      System.arraycopy(oldCommands, 0, newCommands, 0, oldCommands.length);
      newCommands[oldCommands.length] = newCommand_p;
    } else {
      for (int i = 0, max = oldCommands.length; i < max; i++) {
        if (oldCommands[i] == oldBuilderCommand) {
          oldCommands[i] = newCommand_p;
          break;
        }
      }
      newCommands = oldCommands;
    }
    // Commit the spec change into the project
    description_p.setBuildSpec(newCommands);
    project_p.setDescription(description_p, null);    
  }
  
  public static void setFrontBuilderCommand(IProject project_p, IProjectDescription description_p, ICommand newCommand_p) throws CoreException {
    if (project_p == null || description_p == null || newCommand_p == null) {
      return;
    }
    ICommand[] oldCommands = description_p.getBuildSpec();
    ICommand oldBuilderCommand = getBuilderCommand(description_p, newCommand_p.getBuilderName());
    ICommand[] newCommands;
    if (oldBuilderCommand == null) {
      // Add a build spec in front of other builders      
      newCommands = new ICommand [oldCommands.length + 1];
      System.arraycopy(oldCommands, 0, newCommands, 1, oldCommands.length);
      newCommands[0] = newCommand_p;
    } else {
      for (int i = 0, max = oldCommands.length; i < max; i++) {
        if (oldCommands[i] == oldBuilderCommand) {
          oldCommands[i] = newCommand_p;
          break;
        }
      }
      newCommands = oldCommands;
    }
    // Commit the spec change into the project
    description_p.setBuildSpec(newCommands);
    project_p.setDescription(description_p, null);    
  }    

}
