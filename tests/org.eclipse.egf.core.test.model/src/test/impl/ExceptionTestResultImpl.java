/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import test.ExceptionTestResult;
import test.TestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception Test Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.impl.ExceptionTestResultImpl#getExceptionClass <em>Exception Class</em>}</li>
 *   <li>{@link test.impl.ExceptionTestResultImpl#getExceptionMessage <em>Exception Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExceptionTestResultImpl extends TestResultImpl implements ExceptionTestResult {
  /**
     * The cached value of the '{@link #getExceptionClass() <em>Exception Class</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getExceptionClass()
     * @generated
     * @ordered
     */
  protected Class<?> exceptionClass;

  /**
     * The default value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getExceptionMessage()
     * @generated
     * @ordered
     */
  protected static final String EXCEPTION_MESSAGE_EDEFAULT = null;

  /**
     * The cached value of the '{@link #getExceptionMessage() <em>Exception Message</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getExceptionMessage()
     * @generated
     * @ordered
     */
  protected String exceptionMessage = EXCEPTION_MESSAGE_EDEFAULT;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected ExceptionTestResultImpl() {
        super();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected EClass eStaticClass() {
        return TestPackage.Literals.EXCEPTION_TEST_RESULT;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public Class<?> getExceptionClass() {
        return exceptionClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void setExceptionClass(Class<?> newExceptionClass) {
        Class<?> oldExceptionClass = exceptionClass;
        exceptionClass = newExceptionClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_CLASS, oldExceptionClass, exceptionClass));
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public String getExceptionMessage() {
        return exceptionMessage;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void setExceptionMessage(String newExceptionMessage) {
        String oldExceptionMessage = exceptionMessage;
        exceptionMessage = newExceptionMessage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE, oldExceptionMessage, exceptionMessage));
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_CLASS:
                return getExceptionClass();
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE:
                return getExceptionMessage();
        }
        return super.eGet(featureID, resolve, coreType);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_CLASS:
                setExceptionClass((Class<?>)newValue);
                return;
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE:
                setExceptionMessage((String)newValue);
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
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_CLASS:
                setExceptionClass((Class<?>)null);
                return;
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE:
                setExceptionMessage(EXCEPTION_MESSAGE_EDEFAULT);
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
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_CLASS:
                return exceptionClass != null;
            case TestPackage.EXCEPTION_TEST_RESULT__EXCEPTION_MESSAGE:
                return EXCEPTION_MESSAGE_EDEFAULT == null ? exceptionMessage != null : !EXCEPTION_MESSAGE_EDEFAULT.equals(exceptionMessage);
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
        result.append(" (exceptionClass: ");
        result.append(exceptionClass);
        result.append(", exceptionMessage: ");
        result.append(exceptionMessage);
        result.append(')');
        return result.toString();
    }

} //ExceptionTestResultImpl
