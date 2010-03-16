/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import test.Test;
import test.TestPackage;
import test.TestSuite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.impl.TestSuiteImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.impl.TestSuiteImpl#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestSuiteImpl extends EObjectImpl implements TestSuite {
  /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
  protected static final String NAME_EDEFAULT = null;

  /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
  protected String name = NAME_EDEFAULT;

  /**
     * The cached value of the '{@link #getTests() <em>Tests</em>}' containment reference list.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getTests()
     * @generated
     * @ordered
     */
  protected EList<Test> tests;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected TestSuiteImpl() {
        super();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected EClass eStaticClass() {
        return TestPackage.Literals.TEST_SUITE;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public String getName() {
        return name;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.TEST_SUITE__NAME, oldName, name));
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EList<Test> getTests() {
        if (tests == null) {
            tests = new EObjectContainmentEList<Test>(Test.class, this, TestPackage.TEST_SUITE__TESTS);
        }
        return tests;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TestPackage.TEST_SUITE__TESTS:
                return ((InternalEList<?>)getTests()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TestPackage.TEST_SUITE__NAME:
                return getName();
            case TestPackage.TEST_SUITE__TESTS:
                return getTests();
        }
        return super.eGet(featureID, resolve, coreType);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TestPackage.TEST_SUITE__NAME:
                setName((String)newValue);
                return;
            case TestPackage.TEST_SUITE__TESTS:
                getTests().clear();
                getTests().addAll((Collection<? extends Test>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public void eUnset(int featureID) {
        switch (featureID) {
            case TestPackage.TEST_SUITE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TestPackage.TEST_SUITE__TESTS:
                getTests().clear();
                return;
        }
        super.eUnset(featureID);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public boolean eIsSet(int featureID) {
        switch (featureID) {
            case TestPackage.TEST_SUITE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TestPackage.TEST_SUITE__TESTS:
                return tests != null && !tests.isEmpty();
        }
        return super.eIsSet(featureID);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //TestSuiteImpl
