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
package org.eclipse.egf.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.egf.model.AbstractViewpoint;
import org.eclipse.egf.model.ModelFactory;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.egf.model.Specification;
import org.eclipse.egf.model.ViewpointType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.impl.SpecificationImpl#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.egf.model.impl.SpecificationImpl#getViewpointIds <em>Viewpoint Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends NamedModelElementWithIdImpl implements Specification {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SpecificationImpl.class.getPackage().getName());
  /**
   * The cached value of the '{@link #getViewpoints() <em>Viewpoints</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getViewpoints()
   * @generated
   * @ordered
   */
  protected EList<AbstractViewpoint> viewpoints;

  /**
   * The cached value of the '{@link #getViewpointIds() <em>Viewpoint Ids</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getViewpointIds()
   * @generated
   * @ordered
   */
  protected Map<ViewpointType, EList<String>> viewpointIds;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SpecificationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public EList<AbstractViewpoint> getViewpoints() {
    // If null, try loading the production plan from the extension registry.
    if (viewpoints == null) {
      viewpoints = new EObjectContainmentEList<AbstractViewpoint>(AbstractViewpoint.class, this, ModelPackage.SPECIFICATION__VIEWPOINTS);
      viewpoints.addAll(loadViewpoints());
    }
    return viewpoints;
  }

  /**
   * Load all viewpoints.
   * @return a not null {@link List}.
   */
  private List<AbstractViewpoint> loadViewpoints() {
    List<AbstractViewpoint> result = new ArrayList<AbstractViewpoint>(0);
    // Get the viewpoint ids.
    if (null != viewpointIds) {
      // Iterate over couples of < viewpoint type, List of viewpoint ids for this type>.
      Iterator<Entry<ViewpointType, EList<String>>> entries = viewpointIds.entrySet().iterator();
      while (entries.hasNext()) {
        // Get current entry.
        Entry<ViewpointType, EList<String>> currentEntry = entries.next();
        // Get current viewpoint type for current entry.
        ViewpointType currentType = currentEntry.getKey();
        // Get current viewpoint ids for current entry
        EList<String> currentViewpointIds = currentEntry.getValue();
        // Load each viewpoint id depending on its type.
        for (String viewpointId : currentViewpointIds) {
          AbstractViewpoint loadedViewpoint = null;
          switch (currentType.getValue()) {
            case ViewpointType.CONTRACT_VALUE:
              loadedViewpoint = ModelFactory.eINSTANCE.createContract();
            break;
            case ViewpointType.PATTERN_VALUE:
              loadedViewpoint = ModelFactory.eINSTANCE.createPatternViewpoint();
            break;
            case ViewpointType.MAPPING_VALUE:
              loadedViewpoint = ModelFactory.eINSTANCE.createMappingViewpoint();
            break;
            default:
              StringBuilder loggerMessage = new StringBuilder("SpecificationImpl.loadViewpoints(..) _ "); //$NON-NLS-1$
              loggerMessage.append("Viewpoint type #: "); //$NON-NLS-1$
              loggerMessage.append("unknwown"); //$NON-NLS-1$
              __logger.error(loggerMessage.toString());
            break;
          }
          // If loaded, store it.
          if (null != loadedViewpoint) {
            // Set the viewpoint id.
            loadedViewpoint.setId(viewpointId);
            result.add(loadedViewpoint);
          }
        }
      }
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Map<ViewpointType, EList<String>> getViewpointIds() {
    return viewpointIds;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setViewpointIds(Map<ViewpointType, EList<String>> newViewpointIds) {
    Map<ViewpointType, EList<String>> oldViewpointIds = viewpointIds;
    viewpointIds = newViewpointIds;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SPECIFICATION__VIEWPOINT_IDS, oldViewpointIds, viewpointIds));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackage.SPECIFICATION__VIEWPOINTS:
        return ((InternalEList<?>)getViewpoints()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.SPECIFICATION__VIEWPOINTS:
        return getViewpoints();
      case ModelPackage.SPECIFICATION__VIEWPOINT_IDS:
        return getViewpointIds();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.SPECIFICATION__VIEWPOINTS:
        getViewpoints().clear();
        getViewpoints().addAll((Collection<? extends AbstractViewpoint>)newValue);
        return;
      case ModelPackage.SPECIFICATION__VIEWPOINT_IDS:
        setViewpointIds((Map<ViewpointType, EList<String>>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelPackage.SPECIFICATION__VIEWPOINTS:
        getViewpoints().clear();
        return;
      case ModelPackage.SPECIFICATION__VIEWPOINT_IDS:
        setViewpointIds((Map<ViewpointType, EList<String>>)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      // Due to our own persistence mechanism, eIsSet for ModelPackage.SPECIFICATION__VIEWPOINTS feature is based on
      // ModelPackage.SPECIFICATION__VIEWPOINT_IDS.
      case ModelPackage.SPECIFICATION__VIEWPOINTS:
      case ModelPackage.SPECIFICATION__VIEWPOINT_IDS:
        return viewpointIds != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (viewpointIds: "); //$NON-NLS-1$
    result.append(viewpointIds);
    result.append(')');
    return result.toString();
  }

} // SpecificationImpl
