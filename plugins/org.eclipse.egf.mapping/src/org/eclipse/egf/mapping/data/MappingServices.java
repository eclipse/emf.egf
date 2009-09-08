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
package org.eclipse.egf.mapping.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.helper.EcoreHelper;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mapping.Mapping;
import org.eclipse.emf.mapping.ecore2ecore.Ecore2EcoreMappingRoot;
import org.eclipse.emf.mapping.ecore2ecore.Ecore2EcorePackage;


/**
 * Provides services to get a mapped elements for given input.<br>
 * The specified element must be an {@link ENamedElement} object.
 * @author Guillaume Brocard
 */
public class MappingServices {
  /**
   * Mapping relative file path against the workspace root or the target platform.
   */
  private String _mappingRelativeFilePath;
  private Ecore2EcoreMappingRoot _ecore2ecore;

  /**
   * Constructor.
   * @param mappingRelativeFilePath_p File path relative to workspace or to the target platform.<br>
   *          It <b>must</b> start with <i>pluginId</i>. It is also recommended that both plugin id and plugin project names are the same.<br>
   *          As a convenience, the full path will refer to the plugin id.<br>
   *          <b>Example</b> : <i>org.eclipse.egf/model/example.ecore</i> is a path relative to the workspace that refers to the
   *          <i>org.eclipse.egf plugin</i>, having a <i>model/example.ecore</i> file in its project.<br>
   *          In Eclipse resource system, such a path is considered as an absolute one against the workspace root.<br>
   *          It's still referred to as a relative path, since the returned URL is absolute in the file system.
   */
  public MappingServices(String mappingRelativeFilePath_p) {
    _mappingRelativeFilePath = mappingRelativeFilePath_p;
  }

  /**
   * Returns the mapping elements for given model element.
   * @param modelElement_p
   * @return a not null list.
   */
  public List<MappingElement> getMappingElements(EModelElement modelElement_p) {
    Ecore2EcoreMappingRoot ecore2EcoreMappingRoot = getEcore2EcoreMappingRoot();
    List<MappingElement> result = Collections.emptyList();
    if (null != ecore2EcoreMappingRoot) {
      result = getMappingElements(modelElement_p, ecore2EcoreMappingRoot.getNested());
    }
    return result;
  }

  /**
   * Returns the mapped objects for given model element in specified mapping list.
   * @param modelElement_p
   * @param mappings_p
   * @return a not null list.
   */
  protected List<MappingElement> getMappingElements(EModelElement modelElement_p, EList<Mapping> mappings_p) {
    List<MappingElement> result = new ArrayList<MappingElement>(0);
    Iterator<Mapping> iterator = mappings_p.iterator();
    // Iterate over given mappings to find out the ones that contains the given model element.
    while (iterator.hasNext()) {
      Mapping currentMapping = iterator.next();
      // Get mapping element for current mapping.
      MappingElement mappingElement = getMappingElements(modelElement_p, currentMapping);
      List<MappingElement> mappingElements = (null != mappingElement) ? Collections.singletonList(mappingElement) : null;
      // If not found, lookup into its nested elements.
      if (null == mappingElements) {
        mappingElements = getMappingElements(modelElement_p, currentMapping.getNested());
      }
      // Append found mapped elements to the resulting list.
      if (null != mappingElements && !mappingElements.isEmpty()) {
        result.addAll(mappingElements);
      }
    }
    return result;
  }

  /**
   * Returns the mapping element for given model element for specified mapping.
   * @param modelElement_p
   * @param mapping_p
   * @return can be null if not found.
   */
  protected MappingElement getMappingElements(EModelElement modelElement_p, Mapping mapping_p) {
    MappingElement result = null;
    EList<EObject> inputs = mapping_p.getInputs();
    EList<EObject> outputs = mapping_p.getOutputs();
    // Lookup given model element in mapping inputs, result would be the outputs. A --> B
    result = getMappingElements(modelElement_p, inputs, outputs);
    if (null == result) {
      // The model element is not found in inputs, may be in outputs ie the opposite way B --> A
      result = getMappingElements(modelElement_p, outputs, inputs);
    }
    return result;
  }

  /**
   * Get mapped objects for given element.
   * @param modelElement_p element to lookup.
   * @param sources_p
   * @param targets_p
   * @return null if not found.
   */
  protected MappingElement getMappingElements(EModelElement modelElement_p, EList<EObject> sources_p, EList<EObject> targets_p) {
    MappingElement result = null;
    Iterator<EObject> inputs = sources_p.iterator();
    while (inputs.hasNext() && (null == result)) {
      EObject currentSource = inputs.next();
      if (EcoreHelper.equals(currentSource, modelElement_p)) {
        // Found it !!!
        result = new MappingElement();
        // Add in sources all specified ones because our model element is contained in it.
        result.addSources(sources_p);
        // Add in targets the mapped objects ie the targets.
        result.addTargets(targets_p);
      }
    }
    return result;
  }

  /**
   * Load the {@link Ecore2EcoreMappingRoot} element from physical file.
   * @return
   */
  protected Ecore2EcoreMappingRoot getEcore2EcoreMappingRoot() {
    if (null == _ecore2ecore) {
      ResourceSet resourceSet = new ResourceSetImpl();
      // Create the ecore2ecore URI
      URI ecore2ecoreURI = FileHelper.getFileFullUri(_mappingRelativeFilePath);
      // Load the ecore2ecore model.
      Resource resource = resourceSet.getResource(ecore2ecoreURI, true);
      _ecore2ecore = (Ecore2EcoreMappingRoot) EcoreUtil.getObjectByType(resource.getContents(), Ecore2EcorePackage.eINSTANCE.getEcore2EcoreMappingRoot());
      EPackage inputEPackage = _ecore2ecore.getInputEPackage();
      // Initialize input EPackage with its static representation.
      initializeEPackage(inputEPackage, inputEPackage.eResource(), resourceSet);
      EPackage outputEPackage = _ecore2ecore.getOutputEPackage();
      // Initialize output EPackage with its static representation.
      initializeEPackage(outputEPackage, outputEPackage.eResource(), resourceSet);
    }
    return _ecore2ecore;
  }

  /**
   * Initialize given package with its static representation.
   * @param package_p
   * @param resource_p
   * @param resourceSet_p
   */
  private void initializeEPackage(EPackage package_p, Resource resource_p, ResourceSet resourceSet_p) {
    // Get the EPackage resource URI.
    URI eResourceURI = resource_p.getURI();
    // Get the equivalent from the Global EPackage registry.
    EPackage staticPackageInstance = EcoreHelper.getStaticPackage(package_p);
    if (null != staticPackageInstance) {
      // Register the static package instance instead of the serialized package instance.
      // To be able to use equals with meta elements provided by Package model.
      resourceSet_p.getPackageRegistry().put(eResourceURI.toString(), staticPackageInstance);
      resource_p.unload();
      resourceSet_p.getResources().remove(resource_p);
    }
  }
}