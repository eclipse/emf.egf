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

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.PatternFactory;
import org.eclipse.egf.pattern.ecore.PatternHandler.ProductionOptionsHandler;
import org.eclipse.egf.pattern.production.GeneratedContentHelper;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


/**
 * Ecore pattern generator.
 * @author brocard
 */
public abstract class AbstractPatternGenerator {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractPatternGenerator.class.getPackage().getName());
  
  /**
   * Ecore ecore file absolute path.
   */
  protected static final String ECORE_ECORE_FILE_ABSOLUTE_PATH = "/org.eclipse.emf.ecore/model/Ecore.ecore"; //$NON-NLS-1$
  
  /**
   * Pattern ecore file absolute path.
   */
  protected static final String PATTERN_ECORE_FILE_RELATIVE_PATH = "/org.eclipse.egf.model/model/pattern.ecore"; //$NON-NLS-1$
  
  /**
   * Pattern parent class name, that is 'Pattern'.
   */
  protected static final String PATTERN_PARENT_CLASS_NAME = "Pattern"; //$NON-NLS-1$
  
  /**
   * Templates folder name.
   */
  protected static final String TEMPLATES_FOLDER_NAME = "/templates/"; //$NON-NLS-1$
  
  /**
   * Generated templates sub-folder path.
   */
  protected static final String GENERATED_TEMPLATE_FOLDER_PATH = ICommonConstants.GENERATED_FOLDER_PATH; 

  /**
   * Find the class corresponding to given name in pointed ecore file.
   * @param name_p
   * @param ecoreURI_p
   * @param resourceSet_p
   * @return
   */
  protected static EClass getDependencyFromName(String name_p, String ecoreURI_p, ResourceSet resourceSet_p) {
    EClass result = null;
    // Preconditions.
    if (name_p == null || ecoreURI_p == null || resourceSet_p == null) {
      return result;
    }
    try {
      URI patternURI = FileHelper.getFileFullUri(ecoreURI_p);
      Resource parentResource = resourceSet_p.getResource(patternURI, true);
      // Extract pattern as type from reloaded resource.
      TreeIterator<EObject> content = parentResource.getAllContents();
      while (content.hasNext() && result == null) {
        EObject object = content.next();
        if (object instanceof EClass) {
          EClass class_ = (EClass) object;
          // Retrieve the pattern EClass.
          // Do not use something like '...'Package.Literals.'...' because it is not the instance stored in the resource.
          // Otherwise, the persisted type URI leads to an invalid genmodel.
          if (name_p.equals(class_.getName())) {
            result = class_;
          }
        }
      }
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("AbstractPatternGenerator.getDependencyFromName(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return result;
  }

  /**
   * Get pattern parameters.<br>
   * Ordered.
   * @param resourceSet_p
   * @return
   */
  protected List<ParameterRelation> getPatternParameters(ResourceSet resourceSet_p) {
    return null;
  }

  /**
   * Set pattern parent to identified one.<br>
   * Default parent is {@link Pattern}.
   * @param pattern_p The pattern that should be updated.
   * @param parentClassName_p Parent class name, literally, or null if parent is to be reset.
   * @param parentEcoreURI_p Parent class containing ecore uri, or null if parent is to be reset.
   * @param resourceSet_p An existing one, or null if none is available.
   */
  public static void setPatternParent(Pattern pattern_p, String parentClassName_p, String parentEcoreURI_p, ResourceSet resourceSet_p) {
    ResourceSet resourceSet = resourceSet_p;
    // Precondition.
    if (pattern_p == null) {
      return;
    }
    // Create resource set if none given.
    if (resourceSet == null) {
      resourceSet = new ResourceSetImpl();
    }
    String parentClassName = parentClassName_p;
    String parentEcoreURI = parentEcoreURI_p;
    // Default parent is Pattern.
    if (parentClassName == null || parentEcoreURI == null) {
      parentClassName = PATTERN_PARENT_CLASS_NAME;
      parentEcoreURI = PATTERN_ECORE_FILE_RELATIVE_PATH;
    }
    // Load pattern superclass.
    EClass parent = getDependencyFromName(parentClassName, parentEcoreURI, resourceSet);
    // Clear previous one, so that if no parent is found, then pattern parent is reset to none.
    pattern_p.getESuperTypes().clear();
    if (parent != null) {
      // Add new one.
      pattern_p.getESuperTypes().add(parent);
    }
  }

  /**
   * Generate pattern ecore file.
   */
  public boolean generateEcoreFile() {   
    
    // Create resource set for future use.
    ResourceSet resourceSet = new ResourceSetImpl();

    // Create new pattern structure.
    Pattern newPattern = PatternFactory.eINSTANCE.createPattern();
    // Set pattern id.
    newPattern.setId(getPatternFullId());
    // Set pattern superclass.
    setPatternParent(newPattern, getParentClassName(), getParentEcoreURI(), resourceSet);

    // Load pattern parameters.
    List<ParameterRelation> parameters = getPatternParameters(resourceSet);
    if (parameters != null) {
      newPattern.getParameters().addAll(parameters);
    }

    // Create annotation handler.
    AnnotationHandler annotationHandler = new AnnotationHandler();
    // Add mandatory generate method to the new pattern.
    EOperation generateOperation = addOperation(newPattern, PatternConstants.GENERATE_METHOD_NAME);
    EParameter classLoaderParameter = EcoreFactory.eINSTANCE.createEParameter();
    classLoaderParameter.setName(PatternConstants.GENERATE_METHOD_PARAMETER_NAME);
    classLoaderParameter.setEType(EcorePackage.Literals.EJAVA_OBJECT);
    generateOperation.getEParameters().add(classLoaderParameter);
    
    // Add mandatory generate pre-matching method to the new pattern.
    addOperation(newPattern, PatternConstants.GENERATE_PRE_MATCHING_METHOD_NAME);
    
    // Add mandatory generate post-matching method to the new pattern.
    addOperation(newPattern, PatternConstants.GENERATE_POST_MATCHING_METHOD_NAME);
    
    // Add mandatory generate header method to the new pattern.
    EOperation generateHeader = addOperation(newPattern, PatternConstants.GENERATE_HEADER_METHOD_NAME);
    annotationHandler.addUidAnnotation(generateHeader);
    
    // Add mandatory generate footer method to the new pattern.
    EOperation generateFooter = addOperation(newPattern, PatternConstants.GENERATE_FOOTER_METHOD_NAME);
    annotationHandler.addUidAnnotation(generateFooter);

    // Fill pattern with specific content.
    fillPattern(newPattern, annotationHandler, generateOperation);

    String patternContainingPluginId = getPatternContainingPluginId();
    // Initialize both pattern code and java code annotations for all pattern operations, excluding the generate one.
    FactoryComponent containingFc = EgfPdeActivator.getDefault().getFactoryComponentForPluginId(patternContainingPluginId);
    computeOperationsAnnotations(
      newPattern, 
      containingFc == null ? patternContainingPluginId : containingFc.getId(), 
      annotationHandler
    );

    // Write pattern structure to ecore file.
    return writePatternModelToFile(
      newPattern, 
      getPatternModelRelativePath(
        patternContainingPluginId, 
        PatternHelper.deresolveId(newPattern.getId()).getValue()
      )
    );
    
  }

  /**
   * (Re)Compute annotations for all pattern operations.
   * @param pattern_p
   * @param fcId_p
   * @param annotationHandler_p
   */
  public static void computeOperationsAnnotations(Pattern pattern_p, String fcId_p, AnnotationHandler annotationHandler_p) {
    // Precondition.
    if (pattern_p == null) {
      return;
    }
    // Get annotation handler.
    AnnotationHandler handler = annotationHandler_p;
    if (handler == null) {
      handler = new AnnotationHandler();
    }
    // Get pattern name.
    String patternShortId = PatternHelper.deresolveId(pattern_p.getId()).getValue();
    // Cycle through pattern operations :
    // 1) Remove all existing annotations if any.
    // 2) Add pattern code annotation that reads the corresponding template file.
    // 2bis) Or replace its content with respect to the new pattern properties.
    List<EOperation> operations = pattern_p.getEOperations();
    for (EOperation operation : operations) {
      String templateRelativePath = TemplateHelper.getTemplateRelativePath(
        patternShortId, 
        fcId_p, 
        operation.getName(), 
        handler.getUid(operation)
      );
      if (templateRelativePath != null) {
        if (handler.hasPatternCode(operation) == false) {
          // Add read template file pattern code annotation.
          handler.addReadFilePatternCode(operation, templateRelativePath);
        }
      }
    }
    // Now translate pattern code annotations to java code annotations.
    handler.translateAnnotations(operations);
  }

  /**
   * Compute and add production annotation for given pattern.
   * @param pattern_p The pattern needing to be tagged with a production annotation.
   * @param handler_p The production options handler, containing the annotation value.
   * @param annotationHandler_p A possibly existing annotation handler, null if none to provide at call time.
   */
  public static void computeProductionAnnotation(Pattern pattern_p, ProductionOptionsHandler handler_p, AnnotationHandler annotationHandler_p) {
    // Get annotation handler.
    AnnotationHandler annotationHandler = annotationHandler_p;
    if (annotationHandler == null) {
      annotationHandler = new AnnotationHandler();
    }
    // Add/replace production annotation.
    boolean successful = annotationHandler.addProductionAnnotation(pattern_p, handler_p);
    if (successful == false) {
      __logger.warn(
        new StringBuilder("AbstractPatternGenerator.computeProductionAnnotation(..) _ ") //$NON-NLS-1$
          .append("Could not set production annotation for pattern ") //$NON-NLS-1$
          .append(pattern_p != null ? pattern_p.getName() : null)
          .toString()
      );
    }
  }

  /**
   * Get pattern model relative path.
   * @param containerId_p either the factory component or the plug-in id, depending on the caller.<br>
   *          It is up to the caller to make sure that given plug-in id (if so) is up-to-date (for instance after a refactoring).
   * @param patternId_p
   * @return null if one of the given parameter is null.
   */
  public static String getPatternModelRelativePath(String containerId_p, String patternId_p) {
    // Preconditions.
    if (containerId_p == null || patternId_p == null) {
      return null;
    }
    return 
      new StringBuilder(containerId_p)
        .append(PatternConstants.PATTERN_MODEL_FOLDER)
        .append(StringHelper.replaceNonWordCharactersWithDot(patternId_p))
        .append(ICommonConstants.DOT_CHARACTER)
        .append(PatternConstants.PATTERN_MODEL_FILE_EXTENSION)
        .toString();
  }

  /**
   * Write pattern model to file.
   * @param pattern_p
   * @param fileRelativePath_p
   * @return true if successfully written, false otherwise.
   */
  static boolean writePatternModelToFile(Pattern pattern_p, String fileRelativePath_p) {
    boolean result = false;
    // Check if file is writable first.
    boolean writable = FileHelper.makeFileWritable(fileRelativePath_p);
    // File was not granted rights for modification (either by the system or by the user), stop here.
    if (writable == false) {
      return result;
    }
    // Create package that contains the pattern.
    EPackage container = EcoreFactory.eINSTANCE.createEPackage();
    container.setName(GeneratedContentHelper.getPatternPackageName(pattern_p));
    container.setNsURI(GeneratedContentHelper.getPatternPackageNsURI(pattern_p));
    container.setNsPrefix(GeneratedContentHelper.getPatternPackageNsPrefix(pattern_p));
    container.getEClassifiers().add(pattern_p);
    // Write pattern structure to ecore file.
    try {
      // Get file full URI.
      URI fileFullUri = FileHelper.getFileFullUri(fileRelativePath_p);
      ResourceSet resourceSet = new ResourceSetImpl();
      // Create associated resource.
      Resource patternResource = resourceSet.createResource(fileFullUri);
      patternResource.getContents().add(container);
      patternResource.save(null);
      result = true;
    } catch (Exception exception_p) {
      result = false;
      StringBuilder loggerMessage = new StringBuilder("AbstractPatternGenerator.writePatternModelToFile(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return result;
  }

  /**
   * Add a new operation to handled pattern.
   * @param operationName_p
   * @return The annotation that will contain the resulting method contents (as defined by the pattern annotation grammar).<br>
   *         Empty at this time.
   */
  public static EOperation addOperation(Pattern pattern_p, String operationName_p) {
    EOperation newOperation = EcoreFactory.eINSTANCE.createEOperation();
    newOperation.setName(operationName_p);
    newOperation.setEType(EcorePackage.eINSTANCE.getEString());
    pattern_p.getEOperations().add(newOperation);
    return newOperation;
  }

  /**
   * Remove operation from given pattern.
   * @param pattern_p
   * @param operation_p
   */
  public static void removeOperation(Pattern pattern_p, EOperation operation_p) {
    if (pattern_p != null && operation_p != null) {
      pattern_p.getEOperations().remove(operation_p);
    }
  }

  /**
   * Get pattern short id.
   * @param pattern_p
   * @return
   */
  protected String getPatternShortId(Pattern pattern_p) {
    String result = null;
    // Precondition.
    if (pattern_p == null) {
      return result;
    }
    result = PatternHelper.deresolveId(pattern_p.getId()).getValue();
    return result;
  }

  /**
   * Get template relative path from operation name.
   * @param patternShortId_p
   * @param operationName_p
   * @param operationId_p
   * @return
   */
  protected String getTemplateRelativePath(String patternShortId_p, String operationName_p, String operationId_p) {
    return TemplateHelper.getTemplateRelativePath(
      patternShortId_p, 
      getPatternContainingPluginId(), 
      operationName_p, 
      operationId_p
    );
  }

  /**
   * Fill newly created pattern with expected content.<br>
   * The given operation is the 'generate' one, as defined by the pattern metamodel.
   * @param newPattern_p
   * @param handler_p
   * @param generateContent_p
   */
  protected abstract void fillPattern(Pattern newPattern_p, AnnotationHandler handler_p, EOperation generate_p);

  /**
   * Get parent parent class name.
   * @return
   */
  protected String getParentClassName() {
    return null;
  }

  /**
   * Get pattern parent class ecore URI.
   * @return
   */
  protected String getParentEcoreURI() {
    return null;
  }

  /**
   * Get pattern containing plug-in id.
   * @return
   */
  protected abstract String getPatternContainingPluginId();

  /**
   * Get pattern full id.
   * @return
   */
  protected abstract String getPatternFullId();
  
}
