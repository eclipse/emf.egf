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
package org.eclipse.egf.pattern.refactoring.internal.move.change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.pattern.ecore.AbstractPatternGenerator;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.production.GeneratedContentProducer;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.pattern.plugin.command.PatternConditionExtensionFactory;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;


/**
 * Enhance the {@link PatternHandler} with refactoring specific functions.
 * @author Guillaume Brocard
 */
public class RefactoringPatternHandler extends PatternHandler {
  
  /**
   * Refactor pattern full id.<br>
   * The new full id must point to the same pattern file, that is the short id must be identical.<br>
   * If not an {@link IllegalArgumentException} is thrown.
   * @param newPatternFullId_p
   * @param updateExtensions_p true to update the associated extensions, false otherwise. If an update is required, then it is assumed that the containing
   *          factory component (and thus its plug-in) has not changed.
   * @throws IllegalArgumentException if given new full id is not compliant with the pattern deployment.
   */
  public void refactorFullId(String newPatternFullId_p, boolean updateExtensions_p) throws Exception {
    if (newPatternFullId_p == null) {
      return;
    }
    PatternData patternData = getPatternData();
    // Check that short id has not changed.
    String newShortId = PatternHelper.deresolveId(newPatternFullId_p).getValue();  
    String oldFullId = patternData.getPattern().getId();
    if (newShortId.equals(patternData.getPattern().getShortId())) {
      patternData.getPattern().setId(newPatternFullId_p);
    } else {
      throw new IllegalArgumentException("Pattern short id cannot be changed ! Only containing libraries can be modified."); //$NON-NLS-1$
    }
    // Update generated pattern extension if required.
    if (updateExtensions_p) {
      // Command runner.
      IPluginChangesCommandRunner pluginChangesCommandRunner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
      // Commands to run.
      List<IPluginChangesCommand> updateExtensionsCommands = new ArrayList<IPluginChangesCommand>(3);
      // Update pattern condition extension.
      updateExtensionsCommands.add(
        PatternConditionExtensionFactory.updatePatternConditionExtension(
          oldFullId, 
          newPatternFullId_p
        )
      );
      pluginChangesCommandRunner.performChangesOnPlugin(patternData.getPluginId(), updateExtensionsCommands);
    }
  }

  /**
   * Refactor pattern containing factory component (from id).<br>
   * List of refactored items :<br>
   * <ul>
   * <li>User templates code</li>
   * <li>Condition class</li>
   * <li>Condition class extension</li>
   * <li>Pattern model file</li>
   * </ul>
   * @param previousFcId_p
   * @param destinationFcId_p
   * @throws Exception
   */
  public void refactorContainingFactoryComponent(String previousFcId_p, String destinationFcId_p) throws Exception {
    // Precondition.
    if ((null == previousFcId_p) || (null == destinationFcId_p) || previousFcId_p.equals(destinationFcId_p)) {
      // You don't want to go on.
      // TODO Guillaume.
      // Throw an exception that can be taken into account by the refactoring process.
      // Maybe it's better then to undo the whole process.
      return;
    }
    PatternData patternData = getPatternData();
    // Get previous (actually current) plug-in id.
    String previousPluginId = patternData.getPluginId();
    // Get new plug-in id.
    String newPluginId = EgfPdeActivator.getDefault().getPluginIdForFactoryComponent(destinationFcId_p);
    // Move user templates folder to new factory component.
    // Get current user templates folder.
    String userTemplatesRelativePath = TemplateHelper.getPatternTemplatesFolderRelativePaths(
        patternData.getPattern().getShortId(), 
        previousPluginId
    ).getKey();
    // Move it to new destination.
    IFolder userTemplatesFolder = FileHelper.getPlatformFolder(userTemplatesRelativePath);
    boolean userTemplatesFolderMoved = true;
    if (userTemplatesFolder.exists()) {
      IPath newPath = new Path(
          ICommonConstants.SLASH_CHARACTER 
        + TemplateHelper.getPatternTemplatesFolderRelativePaths(
            patternData.getPattern().getShortId(), 
            newPluginId
          ).getKey()
      );
      userTemplatesFolderMoved = FileHelper.moveResource(userTemplatesFolder, newPath);
    }
    // TODO Guillaume.
    // Throw an exception that can be taken into account by the refactoring process.
    // Maybe it's better then to undo the whole process.
    if (!userTemplatesFolderMoved) {
      return;
    }
    // Move condition class, if any.
    String conditionClassRelativePath = GeneratedContentProducer.getConditionFileRelativePath(patternData);
    IFile conditionClassFile = FileHelper.getPlatformFile(conditionClassRelativePath);
    boolean conditionClassMoved = true;
    if (conditionClassFile.exists()) {
      // New condition class path.
      IPath conditionClassDestinationPath = 
        new Path(
          ICommonConstants.SLASH_CHARACTER 
        + newPluginId
        ).append(
          conditionClassFile.getFullPath().removeFirstSegments(1)
        );
      // Make sure destination folder exists.
      // Create it if so, so that the move operation may continue.
      ProjectHelper.createFolder(
        conditionClassDestinationPath.removeLastSegments(1).removeFirstSegments(1).removeFileExtension().toString(), 
        ProjectHelper.getProject(newPluginId), 
        new NullProgressMonitor()
      );
      // Then move the class.
      conditionClassMoved = FileHelper.moveResource(conditionClassFile, conditionClassDestinationPath);
    }
    // TODO Guillaume.
    // Throw an exception that can be taken into account by the refactoring process.
    // Maybe it's better then to undo the whole process.
    if (!conditionClassMoved) {
      return;
    }
    // Delete condition class extension point (new one is created at save time).
    IPluginChangesCommand unsetPatternConditionExtensionCommand = PatternConditionExtensionFactory.unsetPatternConditionExtension(
      patternData.getPattern().getId()
    );
    // Command runner.
    IPluginChangesCommandRunner pluginChangesCommandRunner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
    // Execute removal command.
    pluginChangesCommandRunner.performChangesOnPlugin(
      previousPluginId, 
      Collections.singletonList(unsetPatternConditionExtensionCommand)
    );
    // Move model file.
    String patternFileRelativePath = patternData.getRealRelativePath();
    IFile patternFile = FileHelper.getPlatformFile(patternFileRelativePath);
    boolean patternFileMoved = true;
    IPath newPatternPath = 
      new Path(
          ICommonConstants.SLASH_CHARACTER 
        + ICommonConstants.EMPTY_STRING
      ).append(
        AbstractPatternGenerator.getPatternModelRelativePath(
          newPluginId, 
          patternData.getPattern().getShortId()
        )
      );
    // Pattern model folder might not exist in destination FC.
    // Create it if so, so that the move operation may continue.
    ProjectHelper.createFolder(
      newPatternPath.removeLastSegments(1).removeFirstSegments(1).toString(), 
      ProjectHelper.getProject(newPluginId),
      new NullProgressMonitor()
    );
    if (patternFile.exists()) {
      patternFileMoved = FileHelper.moveResource(patternFile, newPatternPath);
    }
    // TODO Guillaume.
    // Throw an exception that can be taken into account by the refactoring process.
    // Maybe it's better then to undo the whole process.
    if (patternFileMoved == false) {
      return;
    }
    // Reload the whole thing (that is taking into account the new path).
    String expectedPath = 
        ICommonConstants.SLASH_CHARACTER 
      + destinationFcId_p 
      + ICommonConstants.SLASH_CHARACTER
      + newPatternPath.removeFirstSegments(1).toString();
    load(expectedPath);
    // Change operations paths from old factory component id to new one.
    recomputeOperationsPaths(previousFcId_p, destinationFcId_p);
  }

  /**
   * Recompute operations paths for current pattern, swapping from previous factory component id to new one.
   * @param previousFcId_p
   * @param newFcId_p
   * @return
   */
  protected boolean recomputeOperationsPaths(String previousFcId_p, String newFcId_p) {
    // Get pattern data.
    PatternData patternData = getPatternData();
    // Create a new annotation handler.
    AnnotationHandler annotationHandler = new AnnotationHandler();
    // Get pattern short id.
    String patternShortId = patternData.getPattern().getShortId();
    // Cycle through pattern operations.
    // Replace existing reference to previous template path with new one.
    EList<EOperation> operations = patternData.getPattern().getEOperations();
    for (EOperation operation : operations) {
      if (annotationHandler.hasPatternCode(operation)) {
        // Operation name.
        String name = operation.getName();
        // Operation unique id.
        String uid = annotationHandler.getUid(operation);
        // Get previous template path.
        String previousTemplatePath = TemplateHelper.getTemplateRelativePath(patternShortId, previousFcId_p, name, uid);
        // Get new template path.
        String newTemplatePath = TemplateHelper.getTemplateRelativePath(patternShortId, newFcId_p, name, uid);
        if ((null != previousTemplatePath) && (null != newTemplatePath)) {
          // Decompose operation code actions.
          List<Couple<String, String>> orderedActions = annotationHandler.getOrderedActionsFor(operation);
          // Then replace paths.
          annotationHandler.replaceParameter(previousTemplatePath, newTemplatePath, orderedActions);
          // Finally, compute operation code again.
          annotationHandler.recomputeAnnotationFromActions(operation, orderedActions);
        }
      }
    }
    return true;
  }

  /**
   * @see org.eclipse.egf.pattern.ecore.PatternHandler#updatePatternModel(org.eclipse.egf.model.PatternModel,
   *      org.eclipse.egf.pattern.ecore.PatternHandler.PatternData)
   */
  @Override
  protected void updatePatternModel(PatternModel patternModel_p, PatternData patternData_p) {
    // Preconditions.
    if ((null == patternData_p) || (null == patternModel_p)) {
      return;
    }
    // Update model only for full EMF command will be handled by the add command in PatternElementChange.perform() method.
    // Set pattern path.
    patternModel_p.setPath(patternData_p.getFileRelativePath());
  }
  
}
