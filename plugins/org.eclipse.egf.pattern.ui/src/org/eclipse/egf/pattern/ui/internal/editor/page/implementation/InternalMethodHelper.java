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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.editor.jet.PatternJETEditor;


/**
 * Pattern internal method helper.
 * @author Guillaume Brocard
 */
public class InternalMethodHelper {
  
  private static boolean DEBUG = PatternUiActivator.getDefault().isDebugging();  

  /**
   * Open pattern internal method content.
   * @param patternData_p Data about containing pattern.
   * @param handler_p The handler of the internal method.
   * @param editable_p Should the content be editable (true) or not (false) ?
   */
  public static void openMethodContent(PatternData patternData_p, InternalMethodHandler handler_p, boolean editable_p) {
    String methodName = handler_p.getMethodName();
    // Get annotation handler.
    AnnotationHandler handler = new AnnotationHandler();
    String operationUid = handler.getUid(handler_p.getMethod());
    if (null == operationUid) {
      operationUid = methodName;
    }
    // Compute file path.
    String fileRelativePath = TemplateHelper.getTemplateRelativePath(
        patternData_p.getPattern().getShortId(), 
        patternData_p.getPluginId(), 
        methodName, 
        operationUid
    );
    // Build an EMF URI
    URI fileURI = FileHelper.getFileFullUri(fileRelativePath);    
    // If the pattern is not editable, simply open its editor.
    boolean openEditor = !editable_p;
    // Test file existence.
    if (openEditor == false) {
      // Maybe current method has already been edited.
      openEditor = FileHelper.exists(fileRelativePath);
      if (openEditor == false) {
        // No, current file does not exist yet.
        // Simply create an empty one.
        openEditor = FileHelper.writeFile(fileRelativePath, true, ICommonConstants.EMPTY_STRING);
      }
    }
    // TODO Guillaume
    // Use editor id according to the type of developed templates.
    // IOC needed here.
    // Should template editor be opened ?
    if (openEditor) {
      if (editable_p) {
        try {
          // Refresh project.
          patternData_p.getJavaProject().getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
        } catch (CoreException ce) {
          PatternUiActivator.getDefault().log(ce);
          if (DEBUG) {
            EGFConsolePlugin.getConsole().logThrowable(
              NLS.bind(
                "Unable to refresh project ''{0}''", //$NON-NLS-1$
                patternData_p.getJavaProject().getProject().getName()
              ),
              ce
            );
          }          
        } catch (OperationCanceledException oce) {
          return;
        }
      }
      IEditorPart openFileEditor = WorkbenchHelper.openFileEditor(
        fileRelativePath, 
        PatternJETEditor.EDITOR_ID, 
        editable_p
      );
      // TODO Guillaume.
      // Change cast according to type of developed templates.
      // That is, do not use a cast at all. IOC needed here.
      if (openFileEditor != null) {
        String templateFullName = patternData_p.getPattern().getName() + ICommonConstants.DOT_CHARACTER + methodName;
        ((PatternJETEditor) openFileEditor).setPartName(templateFullName);
      }      
    }
  }

  /**
   * Get internal methods array from pattern data input.
   * @param patternData_p The input containing the methods to handle.
   * @param factory_p The factory for creating a new handler for each method.
   * @return
   */
  public static InternalMethodHandler[] getInternalMethodsFromInput(PatternData patternData_p, IInternalMethodHandlerFactory factory_p) {
    InternalMethodHandler[] result = null;
    List<InternalMethodHandler> handlers = new ArrayList<InternalMethodHandler>(0);
    List<EOperation> operations = patternData_p.getPattern().getEOperations();
    // Cycle through pattern methods, excluding those that do not need to be handled here.
    for (EOperation operation : operations) {
      String operationName = operation.getName();
      // Should be filtered. We don't want generate here, neither preMatching nor postMatching.
      if (!(PatternConstants.GENERATE_METHOD_NAME.equals(operationName) || PatternConstants.GENERATE_PRE_MATCHING_METHOD_NAME.equals(operationName) || PatternConstants.GENERATE_POST_MATCHING_METHOD_NAME
          .equals(operationName))) {
        handlers.add(factory_p.createNewHandler(operation));
      }
    }
    result = handlers.toArray(new InternalMethodHandler[handlers.size()]);
    return result;
  }

  /**
   * Internal method handler factory.
   * @author Guillaume Brocard
   */
  public interface IInternalMethodHandlerFactory {
    /**
     * Create new handler for given method.
     * @param method_p
     * @return
     */
    public InternalMethodHandler createNewHandler(EOperation method_p);
  }
}