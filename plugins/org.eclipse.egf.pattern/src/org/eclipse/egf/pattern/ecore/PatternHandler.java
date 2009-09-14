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
package org.eclipse.egf.pattern.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.misc.PlatformLocationType;
import org.eclipse.egf.common.ui.helper.MessageFormatHelper;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.fc.generator.java.helper.FileNameHelper;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.edit.helper.FactoryComponentHelper;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.PatternPackage;
import org.eclipse.egf.pattern.production.GeneratedContentHelper;
import org.eclipse.egf.pattern.production.GeneratedContentProducer;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.relations.CallParameter;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.egf.pde.emf.plugin.command.EmfExtensionFactory;
import org.eclipse.egf.pde.pattern.plugin.command.PatternConditionExtensionFactory;
import org.eclipse.egf.pde.pattern.plugin.command.PatternTemplateExtensionFactory;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommand;
import org.eclipse.egf.pde.plugin.command.IPluginChangesCommandRunner;
import org.eclipse.egf.pde.plugin.manifest.command.ManifestChangeCommandFactory;


/**
 * Load a pattern from its ecore relative path.<br>
 * Also creates a new one from its name.<br>
 * After a pattern has been loaded or created, the instance of {@link PatternHandler} used is bound to this pattern.<br>
 * Should another pattern be loaded/created, a new instance of {@link PatternHandler} would be used.
 * @author Guillaume Brocard
 */
public class PatternHandler {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternHandler.class.getPackage().getName());
  
  /**
   * Pattern loaded data.
   */
  private PatternData _patternData;
  
  /**
   * Is pattern opened in edition mode (true) or in consultation one (false) ?
   */
  private boolean _editable;

  /**
   * Constructor. Pattern is in edition mode, if required.
   */
  public PatternHandler() {
    this(true);
  }

  /**
   * Constructor.
   * @param editable_p
   */
  public PatternHandler(boolean editable_p) {
    _editable = editable_p;
  }

  /**
   * Get pattern data.
   * @return
   */
  public PatternData getPatternData() {
    return _patternData;
  }

  /**
   * Is pattern handler enabling modifications or not ?
   * @return
   */
  public boolean isEditable() {
    return _editable;
  }

  /**
   * Set ecore file relative path.
   * @param fileRelativePath_p Ecore relative path, must be composed of the plug-in id (preceded by a '/') followed by the path in this plug-in.<br>
   *          For instance <i>/org.eclipse.egf.pattern.g2/model/pattern.g2.ecore</i> is a correct entry.<br>
   *          Setting a new value does require that {@link #load()} be called to get the content of {@link PatternData} updated.
   * @throws IllegalArgumentException if given relative path is null.
   */
  public void setFileRelativePath(String fileRelativePath_p) throws Exception {
    // Illegal argument exception.
    if (fileRelativePath_p == null) {
      throw new IllegalArgumentException("Null file relative path !"); //$NON-NLS-1$
    }
    // If pattern data does not exist yet, create it.
    if (_patternData == null) {
      _patternData = new PatternData();
    }
    // Set relative path name.
    _patternData._fileRelativePath = fileRelativePath_p;
  }

  /**
   * Load pattern structure using previously set ecore path.
   * @param fileRelativePath_p Ecore relative path, must be composed of the factory component id (preceded by a '/') followed by the path in this factory component.<br>
   *          For instance <i>/factoryComponent.121212423141443.54/model/pattern.g2.ecore</i> is a correct entry.
   * @return A {@link PatternData} pointing to loaded pattern structure.
   * @throws Exception
   */
  public PatternData load(String fileRelativePath_p) throws Exception {
    setFileRelativePath(fileRelativePath_p);
    // Set factory component id.
    _patternData._fcId = new Path(_patternData._fileRelativePath).segment(0);
    // Get containing java project.
    _patternData._javaProject = ProjectHelper.getJavaProject(_patternData.getPluginId());
    // Get file full URI.
    URI fileFullUri = FileHelper.getFileFullUri(_patternData.getRealRelativePath());
    // Unable to get it, return.
    if (fileFullUri == null) {
      throw new IllegalArgumentException(
        "File relative path " //$NON-NLS-1$ 
        + _patternData._fileRelativePath 
        + " could not be converted to a full URI" //$NON-NLS-1$
      );
    }
    // Load resource from this path.
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource resource = resourceSet.getResource(fileFullUri, true);
    // First element should be of EPackage type, being the pattern container.
    EPackage containingPackage = (EPackage) resource.getContents().get(0);
    // Look for the pattern element, should be lonely.
    Pattern pattern = (Pattern) containingPackage.getEClassifiers().get(0);
    _patternData._pattern = pattern;
    _patternData._patternName = pattern.getName();
    _patternData._patternLogicalName = pattern.getLogicalName();      
    // Get generate body operation.
    _patternData._generateOperation = getGenerateOperation(pattern);
    // Get all super types.
    List<EClass> superTypes = pattern.getESuperTypes();
    // Try and find the super types that are patterns and get their IDs.
    // There should be only one pattern as parent (at the most).
    _patternData._patternDependenciesIds = new HashSet<String>(0);
    // Set parent pattern.
    _patternData._parentPattern = null;
    for (EClass superType : superTypes) {
      if (superType instanceof Pattern) {
        _patternData._parentPattern = (Pattern) superType;
        String patternId = (String) superType.eGet(PatternPackage.Literals.PATTERN__ID, true);
        _patternData._patternDependenciesIds.add(patternId);
      }
    }
    // Get production options handler.
    ProductionOptionsHandler optionsHandler = _patternData.getProductionOptionsHandler();
    // By default, always compile resulting template (that includes the 'no annotation declared' case).
    optionsHandler._compileTemplate = true;
    // By default, always replace standard buffer, so as to enable reporting call-back.
    optionsHandler._bufferModification = true;
    // Default relative path is empty.
    optionsHandler._patternTemplatePath = ICommonConstants.EMPTY_STRING;
    // Default enablement flag is set to false.
    // That means no annotation locally defined.
    optionsHandler._enabled = false;
    // Then search for the annotation.
    readProductionContext(pattern, _patternData);
    // Compute all pattern matching parameters.
    recomputeAllParameters();
    // Get public method parameters.
    recomputeCallParameters();
    return _patternData;
  }

  /**
   * Save current pattern data to pattern model file.<br>
   * Also update given pattern model with new data.
   * @param patternModel_p
   * @param physicalFileRelativePath_p
   * @return
   * @throws Exception
   */
  public PatternData save(
    PatternModel patternModel_p, 
    String physicalFileRelativePath_p, 
    String logicalFileRelativePath_p
  ) throws Exception {
    if (_patternData == null) {
      throw new IllegalStateException("No pattern to process."); //$NON-NLS-1$
    }
    if (_editable == false) {
      throw new IllegalStateException("Pattern is in read-only mode !"); //$NON-NLS-1$
    }
    // Get pattern to save.
    Pattern pattern = _patternData.getPattern();
    // Create a dedicated instance of the annotation handler.
    AnnotationHandler annotationHandler = new AnnotationHandler();
    // Change operations annotations.
    AbstractPatternGenerator.computeOperationsAnnotations(pattern, _patternData.getFactoryComponentId(), annotationHandler);
    // Proceed with production annotation.
    handleSaveProductionOptions(pattern, annotationHandler);
    // Write new content.
    boolean fileSaved = AbstractPatternGenerator.writePatternModelToFile(pattern, physicalFileRelativePath_p);
    // File could not be written.
    if (fileSaved == false) {
      throw new IllegalStateException("Pattern file can not be modified !"); //$NON-NLS-1$
    }
    // Reload pattern data content.
    PatternData patternData = reloadPatternAndUpdateModel(patternModel_p, logicalFileRelativePath_p);
    // Do post-save processing.
    postSave();
    return patternData;
  }

  /**
   * Handle the production options saving behavior.<br>
   * Default implementation figures out if an annotation should be saved for current pattern or not.
   * @param pattern_p
   * @param handler_p
   */
  protected void handleSaveProductionOptions(Pattern pattern_p, AnnotationHandler handler_p) {
    ProductionOptionsHandler productionOptionsHandler = _patternData.getProductionOptionsHandler();
    if (productionOptionsHandler.isEnabled()) {
      AbstractPatternGenerator.computeProductionAnnotation(pattern_p, productionOptionsHandler, handler_p);
    } else {
      handler_p.removeProductionAnnotation(pattern_p);
    }
  }

  /**
   * Save current pattern data to pattern model file.<br>
   * Also update given pattern model with new data.
   * @param patternModel_p
   * @return
   * @throws Exception
   */
  public PatternData save(PatternModel patternModel_p) throws Exception {
    return save(patternModel_p, _patternData.getRealRelativePath(), _patternData.getFileRelativePath());
  }

  /**
   * Post save processing.
   */
  protected void postSave() {
    // Re-compute condition structures.
    recomputeConditionStructures();
    // Add dependencies to external patterns.
    ensurePluginDependencies();
  }

  /**
   * Recompute condition structures, if needed.
   */
  public void recomputeConditionStructures() {
    GeneratedContentProducer producer = new GeneratedContentProducer();
    try {
      producer.produceConditionStructures(_patternData);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("PatternHandler.recomputeConditionStructures(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
  }

  /**
   * Ensure plug-in dependencies.<br>
   * This is required at save time since the pattern might be produced.<br>
   * This takes into account the inheritance dependency and the references ones (against called patterns).
   */
  protected void ensurePluginDependencies() {
    // Resulting collection of required dependencies.
    Collection<String> pluginIDs = new HashSet<String>(0);
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
    final IDescriptor[] searchedDescriptor = new IDescriptor[] { null };
    final String[] searchedFullId = new String[] { null };
    // Search for corresponding descriptor.
    PatternDescriptorStrategy strategy = new PatternDescriptorStrategy() {
      @Override
      protected boolean stopSearch(IDescriptor parentDescriptor_p) {
        return searchedDescriptor[0] != null;
      }
    };
    IPatternDescriptorHandler handler = new IPatternDescriptorHandler() {
      public void handleDescriptor(IDescriptor descriptor_p) {
        // Nothing to do here.
      }
      public void handleLibraryDescriptor(IDescriptor descriptor_p, String parentLibraryId_p) {
        if (parentLibraryId_p.equals(searchedFullId[0])) {
          searchedDescriptor[0] = descriptor_p;
        }
      }
      public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
        // Nothing to do here.
      }
    };
    // Search dependencies from root library plug-in container.
    for (String patternId : _patternData.getPatternDependenciesIds()) {
      // Get root library id.
      String rootLibraryId = PatternHelper.getRootLibraryId(patternId);
      // Initialize searched full id.
      searchedFullId[0] = rootLibraryId;
      // Initialize resulting descriptor.
      searchedDescriptor[0] = null;
      // Launch search for descriptor.
      strategy.iterateThroughPatternExtensionDescriptor(handler, rootDescriptor);
      // Get resulting descriptor.
      IDescriptor returnedDescriptor = searchedDescriptor[0];
      if (returnedDescriptor != null) {
        // Add plug-in id to known dependencies.
        String pluginId = (String) returnedDescriptor.getValue(IPatternConstants.PATTERN_EXTENSION_CONTAINING_PLUGIN_ID);
        // Do not add null or self dependency.
        if (pluginId != null && pluginId.equals(_patternData.getPluginId()) == false) {
          pluginIDs.add(pluginId);
        }
      }
    }
    // Then write result to the manifest, if it not already registered.
    IPluginChangesCommand commandsOnManifest = ManifestChangeCommandFactory.setRequiredPlugins(
      pluginIDs.toArray(new String[pluginIDs.size()]), 
      false
    );
    EgfPdeActivator.getDefault().getPluginChangesCommandRunner().performChangesOnManifest(
      _patternData.getPluginId(),
      Collections.singletonList(commandsOnManifest)
    );
  }

  /**
   * Reload pattern data and update pattern model accordingly.
   * @param patternModel_p
   * @param fileRelativePath_p
   * @return
   * @throws Exception if pattern data could not be reloaded.
   */
  protected PatternData reloadPatternAndUpdateModel(PatternModel patternModel_p, String fileRelativePath_p) throws Exception {
    PatternData result = load(fileRelativePath_p);
    if (_editable) {
      updatePatternModel(patternModel_p, result);
    }
    return result;
  }

  /**
   * Update pattern model with new pattern name, path and id.
   * @param patternModel_p
   */
  protected void updatePatternModel(PatternModel patternModel_p, PatternData patternData_p) {
    // Preconditions.
    if (patternData_p == null || patternModel_p == null) {
      return;
    }
    // Set pattern path.
    patternModel_p.setPath(patternData_p.getFileRelativePath());
    // Update pattern model through editing domain so as to force modification of the plugin.xml file.
    EditingDomain editingDomain = EgfUiActivator.getDefault().getEditingDomain();
    editingDomain.getCommandStack().execute(
      SetCommand.create(
        editingDomain, 
        patternModel_p, 
        ModelPackage.Literals.NAMED_MODEL_ELEMENT_WITH_ID__NAME,
        patternData_p.getPatternLogicalName()
      )
    );
  }

  /**
   * Create a new pattern out of given pattern model.
   * @param fcId_p
   * @param patternModel_p
   * @return A {@link PatternData} pointing to created pattern structure.
   * @throws Exception.
   */
  public PatternData createPattern(final String fcId_p, final PatternModel patternModel_p) throws Exception {
    // Preconditions.
    if (patternModel_p == null || fcId_p == null || _editable == false) {
      return null;
    }
    // If handled pattern data does not exist yet, create it.
    if (_patternData == null) {
      _patternData = new PatternData();
    }
    // New pattern name.
    final String name = patternModel_p.getName();    // And id.
    final String[] id = new String[] { null };
    // Write model.
    new AbstractPatternGenerator() {
      @Override
      protected void fillPattern(Pattern newPattern_p, AnnotationHandler handler_p, EOperation generate_p) {
        newPattern_p.setName(GeneratedContentHelper.getPatternClassName(newPattern_p));
        newPattern_p.setLogicalName(name);        
        newPattern_p.setDescription(
          MessageFormatHelper.formatMessage(
            Messages.PatternHandler_AutoGeneratedDescriptionText, 
            new Object[] { name }
          )
        );
      }
      @Override
      public String getPatternContainingPluginId() {
        return FactoryComponentHelper.getPluginId(fcId_p, PlatformLocationType.WORKSPACE_ONLY);
      }
      @Override
      public String getPatternFullId() {
        id[0] = patternModel_p.getId();
        // Given pattern model id must be the containing library full id.
        return id[0];
      }
    }.generateEcoreFile();
    // Get relative path.
    String fileRelativePath = AbstractPatternGenerator.getPatternModelRelativePath(
      fcId_p, 
      PatternHelper.deresolveId(id[0]).getValue()
    );
    // Then reload it.
    return reloadPatternAndUpdateModel(patternModel_p, fileRelativePath);
  }

  /**
   * Delete the handled pattern.<br>
   * User is advised to release held pattern data reference, since it is no longer synchronized with the persisted data.
   */
  public void delete() {
    // First of all clean generated structures.
    cleanGeneratedStructures();
    // Then clean user templates.
    String pluginId = _patternData.getPluginId();
    FileHelper.deleteFolder(TemplateHelper.getPatternTemplatesFolderRelativePaths(_patternData.getPattern().getShortId(), pluginId).getKey());
    // Update plugin.xml content accordingly.
    IPluginChangesCommandRunner runner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
    runner.performChangesOnPlugin(
      pluginId, 
      Collections.singletonList(
        PatternConditionExtensionFactory.unsetPatternConditionExtension(_patternData.getPattern().getId())
      )
    );
    // Delete condition class.
    String conditionClassRelativePath = GeneratedContentProducer.getConditionFileRelativePath(_patternData);
    FileHelper.deleteFile(conditionClassRelativePath);
    // Finally, delete pattern model.
    FileHelper.deleteFile(_patternData.getRealRelativePath());
    // Unload pattern data.
    _patternData = null;
  }

  /**
   * Clean pattern generated structures.<br>
   * List of deleted items :<br>
   * <ul>
   * <li>EMF generated classes (based on the pattern model)</li>
   * <li>Exported runtime section for these classes</li>
   * <li>Generated package extension for these classes</li>
   * <li>Generated templates : pre/post matchings and computed whole template file</li>
   * <li>Generated template class, if any</li>
   * <li>Generated pattern extension, if any</li>
   * </ul>
   */
  public void cleanGeneratedStructures() {
    // Plug-in id.
    String pluginId = _patternData.getPluginId();
    // Pattern full id.
    // Pattern name.
    String patternName = _patternData.getPatternName();
    // Command runner.
    IPluginChangesCommandRunner pluginChangesCommandRunner = EgfPdeActivator.getDefault().getPluginChangesCommandRunner();
    // First of all, clean generated classes.
    // Clean generation model.
    String genModelRelativePath = FileNameHelper.getGenModelPath(new Path(_patternData.getRealRelativePath()));
    FileHelper.deleteFile(genModelRelativePath);
    // Clean EMF classes.
    String rootPackageRelativePath = GeneratedContentHelper.getEMFGeneratedRootFolderRelativePath(_patternData);
    FileHelper.deleteFolder(rootPackageRelativePath);
    // Clean the exported runtime section if necessary
    List<String> packageNames = GeneratedContentHelper.getEMFGeneratedPackagesNames(_patternData);
    List<IPluginChangesCommand> suppressRuntimePackagesCommand = Collections.singletonList(
      ManifestChangeCommandFactory.unsetExportedPackages(
        packageNames.toArray(
          new String[packageNames.size()]
        )
      )
    );
    pluginChangesCommandRunner.performChangesOnManifest(
      pluginId, 
      suppressRuntimePackagesCommand
    );
    // Suppress generated package extension.
    List<IPluginChangesCommand> suppressGeneratedPackageCommand = Collections.singletonList(
      EmfExtensionFactory.unsetEmfGeneratedPackageExtension(GeneratedContentHelper.getPatternPackageNsURI(_patternData.getPattern()))
    );
    pluginChangesCommandRunner.performChangesOnPlugin(pluginId, suppressGeneratedPackageCommand);
    // Clean generated templates.
    // Starts with generated template file.
    String generatedTemplateFilePath = TemplateHelper.getPatternTemplatePath(_patternData);
    FileHelper.deleteFile(generatedTemplateFilePath);
    // Then suppress generated templates.
    FileHelper.deleteFolder(TemplateHelper.getPatternTemplatesFolderRelativePaths(_patternData.getPattern().getShortId(), pluginId).getValue());
    // Clean template resulting class.
    String generatedPatternClassRelativePath = GeneratedContentHelper.getGeneratedPatternClassRelativePath(_patternData);
    if (generatedPatternClassRelativePath != null) {
      FileHelper.deleteFile(generatedPatternClassRelativePath);
    }
    // Suppress generated pattern extension.
    pluginChangesCommandRunner.performChangesOnPlugin(
      pluginId, 
      Collections.singletonList(PatternTemplateExtensionFactory.unsetPatternTemplateExtension(_patternData.getPattern().getShortId()))
    );
    // Remove parameters handler class.
    String generatedParametersHandlerClassRelativePath = GeneratedContentProducer.getGeneratedClassRelativePath(
      pluginId, 
      PatternConstants.GENERATION_SOURCE_FOLDER, 
      PatternConstants.PATTERN_GENERATED_BASE_PACKAGE,
      GeneratedContentProducer.getClassName(
        patternName,
        PatternConstants.CLASS_PARAMETERS_HANDLER_SUFFIX
      )
    );
    FileHelper.deleteFile(generatedParametersHandlerClassRelativePath);
    // Remove exported package.
    pluginChangesCommandRunner.performChangesOnManifest(
      pluginId, 
      Collections.singletonList(
        ManifestChangeCommandFactory.unsetExportedPackages(
          new String[] { 
            PatternConstants.PATTERN_GENERATED_BASE_PACKAGE 
          }
        )
      )
    );
  }

  /**
   * Read production context, looking for both given pattern and its parents (patterns).
   * @param pattern_p
   * @param patternData_p
   * @return
   */
  protected boolean readProductionContext(Pattern pattern_p, PatternData patternData_p) {
    boolean result = false;
    // Precondition.
    if (pattern_p == null) {
      return result;
    }
    // Search for given pattern.
    EAnnotation productionAnnotation = pattern_p.getEAnnotation(AnnotationHandler.PATTERN_PRODUCTION_ANNOTATION_SOURCE);
    result = productionAnnotation != null;
    if (result) {
      // Get production options handler.
      ProductionOptionsHandler optionsHandler = patternData_p.getProductionOptionsHandler();
      // Set activation flag.
      optionsHandler._enabled = (pattern_p == patternData_p.getPattern());
      // Get annotation details.
      EMap<String, String> details = productionAnnotation.getDetails();
      // Compilation flag.
      String compileString = details.get(AnnotationHandler.PATTERN_PRODUCTION_ANNOTATION_BODY_COMPILATION);
      // Tested against null because null would return a false boolean, where true should be used.
      if (compileString != null) {
        optionsHandler._compileTemplate = Boolean.valueOf(compileString).booleanValue();
      }
      // Buffer modification flag.
      String modifyBuffer = details.get(AnnotationHandler.PATTERN_PRODUCTION_ANNOTATION_BODY_BUFFER_MODIFICATION);
      if (modifyBuffer != null) {
        optionsHandler._bufferModification = Boolean.valueOf(modifyBuffer).booleanValue();
      }
      // Template path.
      String path = details.get(AnnotationHandler.PATTERN_PRODUCTION_ANNOTATION_BODY_PATH);
      if (path != null) {
        optionsHandler._patternTemplatePath = path;
      }
    } else {
      // Get parent types.
      List<EClass> parentTypes = pattern_p.getESuperTypes();
      if (parentTypes.isEmpty() == false) {
        // Try and find pattern parents.
        for (Iterator<EClass> parents = parentTypes.iterator(); parents.hasNext() && result == false;) {
          EClass parent = parents.next();
          if (parent instanceof Pattern) {
            result = readProductionContext((Pattern) parent, patternData_p);
          }
        }
      }
    }
    return result;
  }

  /**
   * Get all pattern matching parameters for given pattern.<br>
   * Includes all first-level and inherited parameters.<br>
   * Parent parameters are presented first, from the farthest to the nearest.<br>
   * Thus given pattern parameters appear at the end of resulting list.
   * @param pattern_p
   * @return A not null list of {@link ParameterRelation}. Can still be empty.
   */
  protected List<ParameterRelation> getAllParameters(Pattern pattern_p) {
    List<ParameterRelation> result = null;
    // Precondition.
    if (pattern_p == null) {
      result = Collections.emptyList();
    }
    // Initiate search.
    result = new ArrayList<ParameterRelation>(pattern_p.getParameters().size());
    // Get parent types.
    List<EClass> parentTypes = pattern_p.getESuperTypes();
    if (parentTypes.isEmpty() == false) {
      // Try and find pattern parents.
      for (EClass parent : parentTypes) {
        if (parent instanceof Pattern) {
          // Add their parameters first.
          List<ParameterRelation> parentResult = getAllParameters((Pattern) parent);
          result.addAll(parentResult);
        }
      }
    }
    // Add first-level parameters too.
    result.addAll(pattern_p.getParameters());
    return result;
  }

  /**
   * Get all public method parameters for given pattern.<br>
   * Includes at least all first-level parameters.
   * @param pattern_p
   * @return A not null list of {@link CallParameter}. Can nevertheless be empty.
   */
  protected List<CallParameter> getCallParameters(Pattern pattern_p) {
    List<CallParameter> result = null;
    // Precondition.
    if (pattern_p == null) {
      result = Collections.emptyList();
    }
    // Initiate search.
    EList<CallParameter> callParameters = pattern_p.getCallParameters();
    result = new ArrayList<CallParameter>(callParameters.size());
    // For now, simply add current level parameters.
    result.addAll(callParameters);
    return result;
  }

  /**
   * Recompute all pattern matching parameters.<br>
   * As a result, contained pattern data is modified.
   * @return
   */
  public List<ParameterRelation> recomputeAllParameters() {
    _patternData._parameters = getAllParameters(_patternData.getPattern());
    return _patternData._parameters;
  }

  /**
   * Recompute all public method parameters.<br>
   * As a result, contained pattern data is modified.
   * @return
   */
  public List<CallParameter> recomputeCallParameters() {
    _patternData._callParameters = getCallParameters(_patternData.getPattern());
    return _patternData._callParameters;
  }

  /**
   * Get user modifiable generate operation.
   * @param pattern_p
   * @return
   */
  protected EOperation getGenerateOperation(Pattern pattern_p) {
    EOperation result = null;
    // Precondition.
    if (pattern_p == null) {
      return result;
    }
    List<EOperation> operationsList = pattern_p.getEOperations();
    for (Iterator<EOperation> operations = operationsList.iterator(); operations.hasNext() && result == null;) {
      EOperation currentOperation = operations.next();
      if (PatternConstants.GENERATE_METHOD_NAME.equals(currentOperation.getName())) {
        result = currentOperation;
      }
    }
    return result;
  }

  /**
   * Pattern data.<br>
   * Provides with different pieces of information for locating the pattern file and details about its content.
   */
  public class PatternData {
    
    /**
     * Ecore file relative path. It is composed of the factory component id containing the pattern, plus the path inside the factory component to the ecore file.
     */
    protected String _fileRelativePath;
    
    /**
     * The containing factory component id.
     */
    protected String _fcId;
    
    /**
     * Java project containing the pattern.<br>
     * Null means pattern has already been deployed.
     */
    protected IJavaProject _javaProject;
    
    /**
     * Pattern reference as object loaded from the ecore file.<br>
     * Does not stand for the generated one.
     */
    protected Pattern _pattern;
    
    /**
     * Pattern name.
     */
    protected String _patternName;
    
    /**
     * Pattern logical name.
     */
    protected String _patternLogicalName;    
        
    /**
     * Set of parent patterns full ids.
     */
    protected Set<String> _patternDependenciesIds;
    
    /**
     * All pattern matching parameters, including parents ones.
     */
    protected List<ParameterRelation> _parameters;
    
    /**
     * Public method parameters.
     */
    protected List<CallParameter> _callParameters;
    
    /**
     * Generate operation.
     */
    protected EOperation _generateOperation;
    
    /**
     * Parent pattern, if any.
     */
    protected Pattern _parentPattern;
    
    /**
     * Production options handler.
     */
    protected ProductionOptionsHandler _productionOptionsHandler;    

    /**
     * Get generate operation.
     * @return
     */
    public EOperation getGenerateOperation() {
      return _generateOperation;
    }

    /**
     * Get real pattern model file relative path, based on factory component id to plug-in id resolution mechanism.
     * @return
     */
    public String getRealRelativePath() {
      return TemplateHelper.getPhysicalRelativePath(_fileRelativePath, getPluginId());
    }

    /**
     * @return the fileRelativePath
     */
    public String getFileRelativePath() {
      return _fileRelativePath;
    }

    /**
     * @return the pluginId
     */
    public String getPluginId() {
      // Resolve plug-in id from factory component one.
      String result = FactoryComponentHelper.getPluginId(
        _fcId, 
        PlatformLocationType.WORKSPACE_THEN_TARGET_PLATFORM
      );
      // Could not find plug-in from factory component one.
      // Return factory component id, hoping that it is in fact a plug-in id that has not been migrated.
      if (result == null) {
        result = _fcId;
      }
      return result;
    }

    /**
     * Get factory component id.
     * @return
     */
    public String getFactoryComponentId() {
      return _fcId;
    }

    /**
     * @return the javaProject
     */
    public IJavaProject getJavaProject() {
      return _javaProject;
    }

    /**
     * @return the pattern
     */
    public Pattern getPattern() {
      return _pattern;
    }

    /**
     * @return the patternName
     */
    public String getPatternName() {
      return _patternName;
    }
    
    /**
     * @return the patternLogicalName
     */
    public String getPatternLogicalName() {
      return _patternLogicalName;
    }
    
    /**
     * @set the patternLogicalName
     */
    public void setPatternLogicalName(String patternLogicalName_p) {
      _patternLogicalName = patternLogicalName_p;
    }      

    /**
     * @return the patternDependenciesIds
     */
    public Set<String> getPatternDependenciesIds() {
      return _patternDependenciesIds;
    }

    /**
     * Get production options handler.
     * @return
     */
    public ProductionOptionsHandler getProductionOptionsHandler() {
      if (_productionOptionsHandler == null) {
        _productionOptionsHandler = new ProductionOptionsHandler();
      }
      return _productionOptionsHandler;
    }

    /**
     * Get all pattern matching parameters, including parents ones, starting from farthest (higher parent) to closest (current pattern) parameters.
     * @return the parameters
     */
    public List<ParameterRelation> getAllParameters() {
      return _parameters;
    }

    /**
     * Get all public method parameters, also stated as 'Call parameters'.<br>
     * @return
     */
    public List<CallParameter> getCallParameters() {
      return _callParameters;
    }

    /**
     * Get parent pattern.
     * @return the parentPattern
     */
    public Pattern getParentPattern() {
      return _parentPattern;
    }

    /**
     * Clean generated structures.<br>
     * This is a convenient method for fixing inheritance error bug in 1.2.0_M4.<br>
     * There should not be such method in {@link PatternData}.<br>
     * TODO Guillaume. Remove this method from 1.2.0_M5 release and replace it with an access to pattern handlers in pattern producer.
     */
    public void cleanGeneratedStructures() {
      PatternHandler.this.cleanGeneratedStructures();
    }
    
  }

  /**
   * Production options handler.
   */
  public class ProductionOptionsHandler {
    
    /**
     * Pattern template path, if default behavior is to be overridden.
     */
    protected String _patternTemplatePath;
    
    /**
     * Should resulting template file be compiled ?
     */
    protected boolean _compileTemplate;
    
    /**
     * Should buffers be modified, as opposed to using the default declaration.
     */
    protected boolean _bufferModification;
    
    /**
     * Are options enabled (true) or not (false) ?<br>
     * If false, the pattern annotation will be destroyed at next save time.
     */
    protected boolean _enabled;

    /**
     * @return the patternTemplatePath
     */
    public String getPatternTemplatePath() {
      return _patternTemplatePath;
    }

    /**
     * Set pattern template production relative path.<br>
     * If set to a not null, non-empty value, then default pattern production behavior is overridden.<br>
     * The template is no longer produced in <b>templates/generated</b> folder, but in <b>templates/<code>patternTemplatePath_p</code></b> instead. Set again to
     * null or {@link ICommonConstants#EMPTY_STRING} if default behavior must be restored.
     * @param patternTemplatePath_p
     */
    public void setPatternTemplatePath(String patternTemplatePath_p) {
      _patternTemplatePath = patternTemplatePath_p;
    }

    /**
     * @return the compileTemplate
     */
    public boolean shouldCompileTemplate() {
      return _compileTemplate;
    }

    /**
     * Set compile template flag to given one.<br>
     * If set to true (the default value), then the pattern template is compiled into a Java class.<br>
     * If set to false, the pattern template file is assembled, but not compiled into a Java class.
     * @param compile_p
     */
    public void setCompileTemplateTo(boolean compile_p) {
      _compileTemplate = compile_p;
    }

    /**
     * Should template buffer be modified (true), including replacement, or should standard way be used (false) ?
     * @return
     */
    public boolean shouldModifyBuffer() {
      return _bufferModification;
    }

    /**
     * Set modify buffer flag to given one.<br>
     * The buffer modification is required for pattern reporting at runtime.<br>
     * If set to true (the default value), then the reporting of generation at runtime is active.<br>
     * If set to false, the default JET behavior is left untouched. That is compatible with EMF-like patterns, but no longer with Pattern Runner execution.
     * Indeed, EMF-like patterns are expecting JET to behave standardly (and have no use of Pattern Runner as the execution environment).
     * @param modifyBuffer_p
     */
    public void setModifyBufferTo(boolean modifyBuffer_p) {
      _bufferModification = modifyBuffer_p;
    }

    /**
     * Are options locally enabled ?
     * @return
     */
    public boolean isEnabled() {
      return _enabled;
    }

    /**
     * Set options enablement to given value.
     * @param enabled_p
     */
    public void setEnabled(boolean enabled_p) {
      _enabled = enabled_p;
    }
    
  }
  
}