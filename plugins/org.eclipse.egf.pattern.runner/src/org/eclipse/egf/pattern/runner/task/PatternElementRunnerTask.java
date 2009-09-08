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
package org.eclipse.egf.pattern.runner.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.MathHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.PatternLibrarySequenceHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.progress.ProductionProgressMonitor;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.preferences.IPreferenceConstants;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternSeeker;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.egf.pattern.execution.PatternExecutionHelper;
import org.eclipse.egf.pattern.execution.PatternExecutionHelper.ArgumentKey;
import org.eclipse.egf.pattern.validation.PatternValidationHelper;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


/**
 * Task that performs a pattern execution or a pattern library execution.
 * @author Guillaume Brocard
 */
public class PatternElementRunnerTask extends AbstractTask {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternElementRunnerTask.class.getPackage().getName());
  
  /**
   * Define a constant according to contract defined by <code>Pattern Runner</code> factory component.
   */
  private static final String PATTERN_ELEMENT_FULL_ID = "patternOrLibraryFullId"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by <code>Pattern Runner</code> factory component.
   */
  private static final String PATTERN_EXECUTION_REPORTER = "executionReporter"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by <code>Pattern Runner</code> factory components.
   */
  private static final String MODEL_PATH = "modelPath"; //$NON-NLS-1$
  
  /**
   * Pattern seeker.
   */
  private PatternSeeker _seeker;

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    // Get the execution reporter.
    IPatternExecutionReporter executionReporter = getPatternExecutionReporter();
    // Get the model.
    Resource model = getModel();
    // Get the pattern element full id.
    String patternElementFullId = getPatternElementFullId();
    // Preconditions.
    if (patternElementFullId == null) {
      return false;
    }
    // Instantiate pattern seeker.
    if (_seeker == null) {
      // Do not search in workspace for patterns to execute should be deployed.
      _seeker = new PatternSeeker(false);
    }
    // Get the ticks count allocated to run this task.
    int allocatedTicksCount = getTicksCount();
    // Convert progress monitor to sub monitor.
    SubMonitor subMonitor = SubMonitor.convert(progressMonitor_p, patternElementFullId, allocatedTicksCount);
    int lookUpTicksCount = MathHelper.multiply(allocatedTicksCount, 0.1f);
    List<String> patternFullIds = lookupPatterns(patternElementFullId);
    // Acknowledge lookup process.
    subMonitor.worked(lookUpTicksCount);
    int patternsTicksCount = allocatedTicksCount - lookUpTicksCount;
    subMonitor.setWorkRemaining(patternsTicksCount);
    // Run retrieved patterns.
    return runPatterns(patternFullIds, model, executionReporter, subMonitor, patternsTicksCount);
  }

  /**
   * Execute given list of pattern.
   * @param patternFullIds_p a list of pattern full id (ie the absolute id)
   * @param model_p the model that patterns are executed against.
   * @param reporter_p the execution reporter to emit the pattern output.
   * @param monitor_p the parent sub monitor.
   * @param totalWork_p numlber of ticks allocate to run all patterns.
   * @return <code>true</code> if the execution is successfully performed; <code>false</code> otherwise.
   */
  protected boolean runPatterns(List<String> patternFullIds_p, Resource model_p, IPatternExecutionReporter reporter_p, SubMonitor monitor_p, int totalWork_p) {
    boolean isOk = true;
    // Get context.
    ProductionContext context = getProductionContext();
    // How many ticks should monitor eat each time ?
    int stepCount = totalWork_p / patternFullIds_p.size();
    Map<ArgumentKey, Object> argument = new HashMap<ArgumentKey, Object>(3);
    argument.put(ArgumentKey.EMF_RESOURCE, model_p);
    argument.put(ArgumentKey.PRODUCTION_CONTEXT, context);
    argument.put(ArgumentKey.EXECUTION_REPORTER, reporter_p);
    for (Iterator<String> patternFullIds = patternFullIds_p.iterator(); patternFullIds.hasNext() && isOk;) {
      String currentPatternId = patternFullIds.next();
      // Monitor each pattern to execute.
      String message = MessageFormatHelper.formatMessage(Messages.PatternElementRunnerTask_Execution_Title, new String[] { currentPatternId });
      ProductionProgressMonitor currentPatternMonitor = new ProductionProgressMonitor(monitor_p, message, stepCount);
      // Create a new couple each time, so that it could be corrupted by the execution of a pattern.
      isOk = runPattern(currentPatternId, argument);
      // Acknowledge each pattern execution..
      currentPatternMonitor.end();
    }
    return isOk;
  }

  /**
   * Execute given pattern by its full id.
   * @param patternFullId_p the pattern absolute id.
   * @param data_p the model used for the pattern execution and an exchange context, as a {@link Couple}.
   * @return <code>true</code> if the execution is successfully performed; <code>false</code> otherwise.
   */
  protected boolean runPattern(String patternFullId_p, Map<ArgumentKey, Object> data_p) {
    boolean isOk = false;
    // Try and validate pattern first.
    // Should pattern be validated before running ?
    // Get it from the preference store.
    IPreferenceStore preferenceStore = EgfUiActivator.getDefault().getPreferenceStore();
    boolean validationRequested = preferenceStore.getBoolean(IPreferenceConstants.PATTERN_EXECUTION_MODE);
    boolean executionGranted = true;
    if (validationRequested) {
      // TODO Guillaume.
      // This is poor performance achievement.
      // Instead, patterns data should be loaded when IDs are resolved.
      // See to it in next version (above 1.2.0_M5).
      List<PatternData> patternsData = _seeker.getPatternsData(patternFullId_p);
      // There should be only one pattern.
      Pattern pattern = patternsData.get(0).getPattern();
      final Object[] patternName = new Object[] { pattern.getName() };
      final Diagnostic validatePattern = PatternValidationHelper.validatePattern(pattern, null);
      if (Diagnostic.ERROR == validatePattern.getSeverity()) {
        executionGranted = false;
        final Display display = PlatformUI.getWorkbench().getDisplay();
        final String validationErrorMessage = StringHelper.formatMessage(Messages.PatternElementRunnerTask_Validation_ErrorMessage, patternName);
        if (display != null) {
          display.asyncExec(
            new Runnable() {
              public void run() {
                DiagnosticDialog.open(
                  display.getActiveShell(), 
                  StringHelper.formatMessage(Messages.PatternElementRunnerTask_Validation_ErrorTitle, patternName), 
                  validationErrorMessage,
                  validatePattern
                );
              }
            }
          );
        } else {
          StringBuilder loggerMessage = new StringBuilder("PatternElementRunnerTask.runPattern(..) _ "); //$NON-NLS-1$
          loggerMessage.append(validationErrorMessage).append(ICommonConstants.EOL_CHARACTER);
          loggerMessage.append(validatePattern.getMessage());
          __logger.warn(loggerMessage.toString());
        }
      } else {
        if (__logger.isDebugEnabled()) {
          StringBuilder loggerMessage = new StringBuilder("PatternElementRunnerTask.runPattern(..) _ "); //$NON-NLS-1$
          loggerMessage.append(StringHelper.formatMessage(Messages.PatternElementRunnerTask_Validation_OkLogMessage, patternName));
          __logger.debug(loggerMessage.toString());
        }
      }
    }
    // Simply run pattern, without taking care of its result.
    // That should be handled by the reporter in given arguments data.
    try {
      if (executionGranted) {
        PatternExecutionHelper.doRunPattern(patternFullId_p, data_p);
        isOk = true;
      }
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("PatternElementRunnerTask.runPattern(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return isOk;
  }

  /**
   * Lookup for a pattern element matching given full id.
   * @param patternElementFullId_p
   * @return a List of pattern full id ready to be executed.
   */
  private List<String> lookupPatterns(String patternElementFullId_p) {
    // Get all available libraries.
    IDescriptor rootDescriptor = getAllPatternLibraries();
    // Instantiate a pattern descriptor handler to retrieve the right elements according to given full id.
    PatternDescriptorHandler patternDescriptorHandler = new PatternDescriptorHandler(patternElementFullId_p);
    // Execute a pattern strategy to collect data.
    PatternDescriptorStrategy strategy = new PatternDescriptorStrategy();
    strategy.iterateThroughPatternExtensionDescriptor(patternDescriptorHandler, rootDescriptor);
    // Data are collected, let's compute the patterns order now.
    return patternDescriptorHandler.getOrderedPatternIds();
  }

  /**
   * Return all patterns libraries located in both workspace and target platform.
   * @return a {@link IDescriptor} that only contains root libraries with their children.
   */
  private IDescriptor getAllPatternLibraries() {
    // Create root descriptor.
    GenericDescriptor rootDescriptor = new GenericDescriptor();
    // Read descriptors from workspace and platform.
    PatternDescriptorStrategy.retainRootOnly(
      rootDescriptor, 
      new WorkspacePatternExtensionReader().getPatternLibraries()
    );
    PatternDescriptorStrategy.retainRootOnly(
      rootDescriptor, 
      new PlatformPatternExtensionReader().getPatternLibraries()
    );
    return rootDescriptor;
  }

  /**
   * Return the pattern element full id ie : either a pattern id or library id.
   * @return
   */
  protected String getPatternElementFullId() {
    String fullId = (String) getContextElementValue(PATTERN_ELEMENT_FULL_ID);
    return fullId;
  }

  /**
   * Returns the pattern execution reporter.
   * @return
   */
  protected IPatternExecutionReporter getPatternExecutionReporter() {
    return (IPatternExecutionReporter) getContextElementValue(PATTERN_EXECUTION_REPORTER);
  }

  /**
   * Return the model.
   * @return a {@link Resource} or null if the model is not found.
   */
  protected Resource getModel() {
    Resource resource = null;
    // Get the model relative path.
    String modelPath = getModelPath();
    if (modelPath != null) {
      // Get the model URI
      URI modelURI = FileHelper.getFileFullUri(modelPath);
      if (modelURI != null) {
        // Load the resource related to the domain.
        ResourceSet resourceSet = new ResourceSetImpl();
        try {
          long startTime = System.currentTimeMillis();
          resource = resourceSet.getResource(modelURI, true);
          long duration = System.currentTimeMillis() - startTime;
          if (__logger.isDebugEnabled()) {
            StringBuilder loggerMessage = new StringBuilder("PatternElementRunnerTask.getModel(..) _ "); //$NON-NLS-1$
            loggerMessage.append("Loading ressource elapsed time (in ms) ").append(duration); //$NON-NLS-1$
            __logger.debug(loggerMessage.toString());
          }
        } catch (RuntimeException exception_p) {
          StringBuilder loggerMessage = new StringBuilder("PatternElementRunnerTask.getDomain(..) _ "); //$NON-NLS-1$
          __logger.warn(loggerMessage.toString(), exception_p);
        }
      }
    }
    return resource;
  }

  /**
   * Returns the platform relative path of the model used as input for pattern execution.
   * @return
   */
  protected String getModelPath() {
    return (String) getContextElementValue(MODEL_PATH);
  }

  /**
   * Handler that collects the patterns to process.
   */
  class PatternDescriptorHandler implements IPatternDescriptorHandler {
    
    /**
     * Searched pattern element full id.
     */
    private String _searchedPatternElementFullId;
    
    /**
     * List of ordered pattern element, this list contains either pattern identifiers or library identifiers.
     */
    private List<String> _orderedPatternElementIds;
    
    /**
     * Map of pattern libraries that match given id and they have a 'runtime' orchestration.<br>
     * <LibraryFullId, runtimeOrchestration>.
     */
    private Map<String, String> _orchestratedLibraries;
    
    /**
     * Map of pattern libraries that match given id and without 'runtime' orchestration but they are involved in ordered pattern elements or in a runtime
     * library.<br>
     * <LibraryFullId, List<PatternElementId>>.
     */
    private Map<String, List<String>> _involvedLibraries;

    /**
     * Constructor.
     * @param searchedPatternElementFullId_p
     */
    public PatternDescriptorHandler(String searchedPatternElementFullId_p) {
      _searchedPatternElementFullId = searchedPatternElementFullId_p;
      _orderedPatternElementIds = new ArrayList<String>(0);
      _orchestratedLibraries = new HashMap<String, String>(0);
      _involvedLibraries = new HashMap<String, List<String>>(0);
    }

    /**
     * Get the ordered pattern identifiers.
     * @return a not null list.
     */
    public List<String> getOrderedPatternIds() {
      return computePatternsOrder();
    }

    /**
     * Compute the pattern order with collected data.<br>
     * This methods must be called after the
     * {@link PatternDescriptorStrategy#iterateThroughPatternExtensionDescriptor(IPatternDescriptorHandler, IDescriptor) call.
     */
    private List<String> computePatternsOrder() {
      // The goal here, is to replace in the ordered pattern elements, the id of libraries by their content.
      ArrayList<String> orderedPatternList = new ArrayList<String>(0);
      // Loop over collected pattern elements.
      for (String currentElementFullId : _orderedPatternElementIds) {
        addPatternElement(currentElementFullId, orderedPatternList);
      }
      // Return the resolved list.
      return orderedPatternList;
    }

    /**
     * Add given pattern element in the resulting pattern list.
     * @param patternElementId_p
     * @param resultingPatterns_p
     */
    private void addPatternElement(String patternElementId_p, List<String> resultingPatterns_p) {
      // If given pattern element is a pattern, add it in resulting list.
      if (isPattern(patternElementId_p)) {
        resultingPatterns_p.add(patternElementId_p);
      } else {
        // If the pattern element is a library contained that has a runtime orchestration.
        String runtimeOrchestration = _orchestratedLibraries.get(patternElementId_p);
        if (null != runtimeOrchestration) {
          // Convert the runtime string into an array of pattern element ids.
          String[] patternElementIds = StringHelper.getTokens(runtimeOrchestration, PatternLibrarySequenceHelper.SEQUENCE_SEPARATORS);
          // Loop over extracted pattern element id : either pattern or library.
          for (String patternElementId : patternElementIds) {
            addPatternElement(patternElementId, resultingPatterns_p);
          }
        } else {
          // Last case : the pattern element is a library contained in included libraries.
          List<String> containedElements = _involvedLibraries.get(patternElementId_p);
          for (String containedElement : containedElements) {
            addPatternElement(containedElement, resultingPatterns_p);
          }
        }
      }
    }

    /**
     * Is given pattern element a 'Pattern' ?
     * @param patternElementId_p
     * @return <code>true</code> means it's a pattern.
     */
    private boolean isPattern(String patternElementId_p) {
      // A pattern is not a library.
      return 
           _orchestratedLibraries.containsKey(patternElementId_p) == false 
        && _involvedLibraries.containsKey(patternElementId_p) == false;
    }

    /**
     * @see org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler#handleDescriptor(org.eclipse.egf.common.descriptor.IDescriptor)
     */
    public void handleDescriptor(IDescriptor descriptor_p) {
      // Not interested in this handle.
    }

    /**
     * @see org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler#handleLibraryDescriptor(org.eclipse.egf.common.descriptor.IDescriptor,
     *      java.lang.String)
     */
    public void handleLibraryDescriptor(IDescriptor descriptor_p, String libraryFullId_p) {
      // Precondition : the current library has an id that starts with the searched one.
      if (libraryFullId_p.startsWith(_searchedPatternElementFullId) == false) {
        return;
      }
      // Does the current library have a runtime orchestration ?
      String runtimeOrchestration = (String) descriptor_p.getValue(IPatternConstants.LIBRARY_RUNTIME_ORCHESTRATION_ATTRIBUTE_NAME);
      if (runtimeOrchestration != null) {
        // Put the current library in the map of orchestrated ones.
        _orchestratedLibraries.put(libraryFullId_p, runtimeOrchestration);
      } else {
        // Put the current library in the included map.
        _involvedLibraries.put(libraryFullId_p, new ArrayList<String>(0));
      }
      // Extract its parent library id.
      String parentLibraryId = PatternHelper.deresolveId(libraryFullId_p).getKey();
      // Detect the case of a root library ie parentLibrary == libraryfullId, reset the parent id to null.
      if (parentLibraryId.equals(libraryFullId_p)) {
        parentLibraryId = null;
      }
      // Get potential sibling elements for the current pattern.
      List<String> siblingElements = _involvedLibraries.get(parentLibraryId);
      // Is the parent library contained in runtime or included ones ?
      if (_orchestratedLibraries.containsKey(parentLibraryId) == false) {
        if (siblingElements == null) {
          // Add it in the list that contained all ordered pattern elements.
          _orderedPatternElementIds.add(libraryFullId_p);
        } else {
          // Sibling elements exist, let's add the current library as a new one.
          siblingElements.add(libraryFullId_p);
        }
      }
    }

    /**
     * @see org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler#handlePatternDescriptor(org.eclipse.egf.common.descriptor.IDescriptor,
     *      java.lang.String)
     */
    public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
      // Precondition : the current pattern has an id that starts with the searched one.
      if (patternFullId_p.startsWith(_searchedPatternElementFullId) == false) {
        return;
      }
      // Extract its parent library id.
      String parentLibraryId = PatternHelper.deresolveId(patternFullId_p).getKey();
      if (_orchestratedLibraries.containsKey(parentLibraryId) == false) {
        // Get potential sibling elements for the current pattern.
        List<String> siblingElements = _involvedLibraries.get(parentLibraryId);
        if (siblingElements != null) {
          // Sibling elements exist, let's add the current pattern as a new one.
          siblingElements.add(patternFullId_p);
        } else {
          // Case where searched full id is a pattern one.
          _orderedPatternElementIds.add(patternFullId_p);
        }
      }
    }
    
  }
  
}