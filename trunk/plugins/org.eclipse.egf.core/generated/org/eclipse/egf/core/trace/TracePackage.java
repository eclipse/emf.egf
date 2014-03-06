/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.core.trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.core.trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "trace";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/trace";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "trace";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    TracePackage eINSTANCE = org.eclipse.egf.core.trace.impl.TracePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.core.trace.impl.ConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.core.trace.impl.ConfigurationImpl
     * @see org.eclipse.egf.core.trace.impl.TracePackageImpl#getConfiguration()
     * @generated
     */
    int CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Categories</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION__CATEGORIES = 0;

    /**
     * The number of structural features of the '<em>Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.core.trace.impl.FilterImpl <em>Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.core.trace.impl.FilterImpl
     * @see org.eclipse.egf.core.trace.impl.TracePackageImpl#getFilter()
     * @generated
     */
    int FILTER = 1;

    /**
     * The feature id for the '<em><b>Comment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILTER__COMMENT = 0;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILTER__PATTERN = 1;

    /**
     * The number of structural features of the '<em>Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILTER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.core.trace.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.core.trace.impl.CategoryImpl
     * @see org.eclipse.egf.core.trace.impl.TracePackageImpl#getCategory()
     * @generated
     */
    int CATEGORY = 2;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__FILTERS = 0;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__ACTIVE = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY__NAME = 2;

    /**
     * The number of structural features of the '<em>Category</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORY_FEATURE_COUNT = 3;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.core.trace.Configuration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration</em>'.
     * @see org.eclipse.egf.core.trace.Configuration
     * @generated
     */
    EClass getConfiguration();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.core.trace.Configuration#getCategories <em>Categories</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Categories</em>'.
     * @see org.eclipse.egf.core.trace.Configuration#getCategories()
     * @see #getConfiguration()
     * @generated
     */
    EReference getConfiguration_Categories();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.core.trace.Filter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Filter</em>'.
     * @see org.eclipse.egf.core.trace.Filter
     * @generated
     */
    EClass getFilter();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.core.trace.Filter#getComment <em>Comment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Comment</em>'.
     * @see org.eclipse.egf.core.trace.Filter#getComment()
     * @see #getFilter()
     * @generated
     */
    EAttribute getFilter_Comment();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.core.trace.Filter#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.eclipse.egf.core.trace.Filter#getPattern()
     * @see #getFilter()
     * @generated
     */
    EAttribute getFilter_Pattern();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.core.trace.Category <em>Category</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Category</em>'.
     * @see org.eclipse.egf.core.trace.Category
     * @generated
     */
    EClass getCategory();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.core.trace.Category#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Filters</em>'.
     * @see org.eclipse.egf.core.trace.Category#getFilters()
     * @see #getCategory()
     * @generated
     */
    EReference getCategory_Filters();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.core.trace.Category#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.eclipse.egf.core.trace.Category#isActive()
     * @see #getCategory()
     * @generated
     */
    EAttribute getCategory_Active();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.core.trace.Category#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.core.trace.Category#getName()
     * @see #getCategory()
     * @generated
     */
    EAttribute getCategory_Name();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    TraceFactory getTraceFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.egf.core.trace.impl.ConfigurationImpl <em>Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.core.trace.impl.ConfigurationImpl
         * @see org.eclipse.egf.core.trace.impl.TracePackageImpl#getConfiguration()
         * @generated
         */
        EClass CONFIGURATION = eINSTANCE.getConfiguration();

        /**
         * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIGURATION__CATEGORIES = eINSTANCE.getConfiguration_Categories();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.core.trace.impl.FilterImpl <em>Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.core.trace.impl.FilterImpl
         * @see org.eclipse.egf.core.trace.impl.TracePackageImpl#getFilter()
         * @generated
         */
        EClass FILTER = eINSTANCE.getFilter();

        /**
         * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILTER__COMMENT = eINSTANCE.getFilter_Comment();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILTER__PATTERN = eINSTANCE.getFilter_Pattern();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.core.trace.impl.CategoryImpl <em>Category</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.core.trace.impl.CategoryImpl
         * @see org.eclipse.egf.core.trace.impl.TracePackageImpl#getCategory()
         * @generated
         */
        EClass CATEGORY = eINSTANCE.getCategory();

        /**
         * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CATEGORY__FILTERS = eINSTANCE.getCategory_Filters();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORY__ACTIVE = eINSTANCE.getCategory_Active();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

    }

} //TracePackage
