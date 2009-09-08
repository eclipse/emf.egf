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
package org.eclipse.egf.core.internal.helper;

import org.eclipse.egf.model.Contract;
import org.eclipse.egf.model.Domain;
import org.eclipse.egf.model.Factory;
import org.eclipse.egf.model.MappingModel;
import org.eclipse.egf.model.MappingViewpoint;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.egf.model.Specification;
import org.eclipse.egf.model.util.ModelSwitch;

/**
 * Helper to sort model elements defined in EGF model.
 * @author fournier
 */
public class FactoryComponentSortingPriorityHelper {
  /**
   * Sorting priority for the Domain model element.
   */
  private static final int SORTING_PRIORITY_DOMAIN = 0;
  /**
   * Sorting priority for the Specification model element.
   */
  private static final int SORTING_PRIORITY_SPECIFICATION = 1;
  /**
   * Sorting priority for the Factory model element.
   */
  private static final int SORTING_PRIORITY_FACTORY = 2;
  /**
   * Sorting priority for the Contract model element.
   */
  private static final int SORTING_PRIORITY_CONTRACT = 3;
  /**
   * Sorting priority for the Pattern viewpoint model element.
   */
  private static final int SORTING_PRIORITY_PATTERN_VIEWPOINT = 4;
  /**
   * Sorting priority for the Pattern library model element.
   */
  private static final int SORTING_PRIORITY_PATTERN_LIBRARY = 5;
  /**
   * Sorting priority for the Pattern model element.
   */
  private static final int SORTING_PRIORITY_PATTERN_MODEL = 6;
  /**
   * Sorting priority for the Mapping viewpoint model element.
   */
  private static final int SORTING_PRIORITY_MAPPING_VIEWPOINT = 7;
  /**
   * Sorting priority for the Mapping model element.
   */
  private static final int SORTING_PRIORITY_MAPPING_MODEL = 8;
  /**
   * Singleton instance.
   */
  private static FactoryComponentSortingPriorityHelper __instance;

  /**
   * The switch delegates to the <code>createXXX</code> methods.
   */
  private ModelSwitch<Integer> _modelSwitch;

  private FactoryComponentSortingPriorityHelper() {
    initialize();
  }

  /**
   * Get the unique instance.
   * @return a not null instance.
   */
  public static FactoryComponentSortingPriorityHelper getInstance() {
    if (null == __instance) {
      __instance = new FactoryComponentSortingPriorityHelper();
    }
    return __instance;
  }

  /**
   * Initialize the model switch.
   */
  private void initialize() {
    _modelSwitch = new ModelSwitch<Integer>() {
      /**
       * @see org.eclipse.egf.core.model.util.ModelSwitch#caseDomain(org.eclipse.egf.core.model.Domain)
       */
      @Override
      public Integer caseDomain(Domain object_p) {
        return Integer.valueOf(SORTING_PRIORITY_DOMAIN);
      }

      /**
       * @see org.eclipse.egf.core.model.util.ModelSwitch#caseFactory(org.eclipse.egf.core.model.Factory)
       */
      @Override
      public Integer caseFactory(Factory object_p) {
        return Integer.valueOf(SORTING_PRIORITY_FACTORY);
      }

      /**
       * @see org.eclipse.egf.core.model.util.ModelSwitch#caseSpecification(org.eclipse.egf.core.model.Specification)
       */
      @Override
      public Integer caseSpecification(Specification object_p) {
        return Integer.valueOf(SORTING_PRIORITY_SPECIFICATION);
      }

      @Override
      public Integer caseContract(Contract object_p) {
        return Integer.valueOf(SORTING_PRIORITY_CONTRACT);
      }

      @Override
      public Integer casePatternLibrary(PatternLibrary object_p) {
        return Integer.valueOf(SORTING_PRIORITY_PATTERN_LIBRARY);
      }

      @Override
      public Integer casePatternModel(PatternModel object_p) {
        return Integer.valueOf(SORTING_PRIORITY_PATTERN_MODEL);
      }

      @Override
      public Integer casePatternViewpoint(PatternViewpoint object_p) {
        return Integer.valueOf(SORTING_PRIORITY_PATTERN_VIEWPOINT);
      }

      /**
       * @see org.eclipse.egf.model.util.ModelSwitch#caseMappingModel(org.eclipse.egf.model.MappingModel)
       */
      @Override
      public Integer caseMappingModel(MappingModel object_p) {
        return Integer.valueOf(SORTING_PRIORITY_MAPPING_MODEL);
      }

      /**
       * @see org.eclipse.egf.model.util.ModelSwitch#caseMappingViewpoint(org.eclipse.egf.model.MappingViewpoint)
       */
      @Override
      public Integer caseMappingViewpoint(MappingViewpoint object_p) {
        return Integer.valueOf(SORTING_PRIORITY_MAPPING_VIEWPOINT);
      }
    };
  }

  /**
   * Get the sorting priority for the <code>target</code>.
   * @param target_p the object that a priority is got for.
   * @return an integer or -1 if no priority is defined for given element.
   */
  public int getSortingPriority(NamedModelElementWithId modelElement_p) {
    Integer doSwitch = _modelSwitch.doSwitch(modelElement_p);
    return (null != doSwitch) ? doSwitch.intValue() : -1;
  }
}
