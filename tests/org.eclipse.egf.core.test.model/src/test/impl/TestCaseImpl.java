/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.impl;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import test.TestCase;
import test.TestPackage;
import test.TestResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.impl.TestCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.impl.TestCaseImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TestCaseImpl extends EObjectImpl implements TestCase {
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
     * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getResult()
     * @generated
     * @ordered
     */
  protected TestResult result;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected TestCaseImpl() {
        super();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected EClass eStaticClass() {
        return TestPackage.Literals.TEST_CASE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.TEST_CASE__NAME, oldName, name));
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public TestResult getResult() {
        return result;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public NotificationChain basicSetResult(TestResult newResult, NotificationChain msgs) {
        TestResult oldResult = result;
        result = newResult;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestPackage.TEST_CASE__RESULT, oldResult, newResult);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void setResult(TestResult newResult) {
        if (newResult != result) {
            NotificationChain msgs = null;
            if (result != null)
                msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestPackage.TEST_CASE__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestPackage.TEST_CASE__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.TEST_CASE__RESULT, newResult, newResult));
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TestPackage.TEST_CASE__RESULT:
                return basicSetResult(null, msgs);
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
            case TestPackage.TEST_CASE__NAME:
                return getName();
            case TestPackage.TEST_CASE__RESULT:
                return getResult();
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
            case TestPackage.TEST_CASE__NAME:
                setName((String)newValue);
                return;
            case TestPackage.TEST_CASE__RESULT:
                setResult((TestResult)newValue);
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
            case TestPackage.TEST_CASE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TestPackage.TEST_CASE__RESULT:
                setResult((TestResult)null);
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
            case TestPackage.TEST_CASE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TestPackage.TEST_CASE__RESULT:
                return result != null;
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

} //TestCaseImpl
