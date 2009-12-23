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
 * $Id$
 */
package org.eclipse.egf.model.domain.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.factorycomponent.ModelElement;
import org.eclipse.egf.model.uri.EGFURIPlatformSchemeAware;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.domain.util.DomainResourceFactoryImpl
 * @generated
 */
public class DomainResourceImpl extends XMIResourceImpl {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private List<Object> lookupTable = new ArrayList<Object>();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private XMLParserPool parserPool = new XMLParserPoolImpl();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  private Map<Object, Object> nameToFeatureMap = new HashMap<Object, Object>();

  /**
   * Creates an instance of the resource.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param uri the URI of the new resource.
   * @generated NOT
   */
  public DomainResourceImpl(URI uri) {
    super(uri);
    setEncoding("UTF-8"); //$NON-NLS-1$
    setXMIVersion("2.1"); //$NON-NLS-1$
    setIntrinsicIDToEObjectMap(new HashMap<String, EObject>());
    ((ResourceSetImpl) resourceSet).setURIResourceMap(new HashMap<URI, Resource>());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  protected boolean useIDAttributes() {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  protected boolean useUUIDs() {
    return false;
  }

  /**
   * <!-- begin-user-doc -->
   * @see {@link org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#getID(org.eclipse.emf.ecore.EObject)}
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getID(EObject eObject) {
    return eObject instanceof ModelElement ? ((ModelElement) eObject).getID() : super.getID(eObject);
  }

  /**
   * <!-- begin-user-doc -->
   * @see {@link org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#setID(org.eclipse.emf.ecore.EObject, java.lang.String)}
   * <!-- end-user-doc -->
   * @generated NOT
   */
  /*  @Override
    public void setID(EObject eObject, String id) {
      Object oldID = getID(eObject);
      if (oldID != null) {
        getIDToEObjectMap().remove(oldID);
      }
      if (id != null) {
        getIDToEObjectMap().put(id, eObject);
      }
    }*/

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  protected void init() {
    super.init();
    // Save Options
    //
    getDefaultSaveOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
    getDefaultSaveOptions().put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, lookupTable);
    getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
    getDefaultSaveOptions().put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, new XMLTypeInfo() {
      public boolean shouldSaveType(EClass objectType, EClassifier featureType, EStructuralFeature feature) {
        return objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;
      }

      public boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature) {
        return objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;
      }
    });
    getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, new Integer(80));
    // Avoid relative paths from workspace resources to plugin resources.    
    getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new EGFURIPlatformSchemeAware());
    getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
    getDefaultSaveOptions().put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
    // Load Options
    //
    getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
    getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
    getDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);
    getDefaultLoadOptions().put(XMLResource.OPTION_USE_PARSER_POOL, parserPool);
    getDefaultLoadOptions().put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, nameToFeatureMap);
    getDefaultLoadOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
    getDefaultLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
  }

} //DomainResourceImpl
