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

import test.TestPackage;
import test.ValidationErrorSeverity;
import test.ValidationErrorTestResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validation Error Test Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.impl.ValidationErrorTestResultImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidationErrorTestResultImpl extends TestResultImpl implements ValidationErrorTestResult {
  /**
     * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getSeverity()
     * @generated
     * @ordered
     */
  protected static final ValidationErrorSeverity SEVERITY_EDEFAULT = ValidationErrorSeverity.INFO;

  /**
     * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #getSeverity()
     * @generated
     * @ordered
     */
  protected ValidationErrorSeverity severity = SEVERITY_EDEFAULT;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected ValidationErrorTestResultImpl() {
        super();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected EClass eStaticClass() {
        return TestPackage.Literals.VALIDATION_ERROR_TEST_RESULT;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ValidationErrorSeverity getSeverity() {
        return severity;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void setSeverity(ValidationErrorSeverity newSeverity) {
        ValidationErrorSeverity oldSeverity = severity;
        severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.VALIDATION_ERROR_TEST_RESULT__SEVERITY, oldSeverity, severity));
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TestPackage.VALIDATION_ERROR_TEST_RESULT__SEVERITY:
                return getSeverity();
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
            case TestPackage.VALIDATION_ERROR_TEST_RESULT__SEVERITY:
                setSeverity((ValidationErrorSeverity)newValue);
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
            case TestPackage.VALIDATION_ERROR_TEST_RESULT__SEVERITY:
                setSeverity(SEVERITY_EDEFAULT);
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
            case TestPackage.VALIDATION_ERROR_TEST_RESULT__SEVERITY:
                return severity != SEVERITY_EDEFAULT;
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
        result.append(" (severity: ");
        result.append(severity);
        result.append(')');
        return result.toString();
    }

} //ValidationErrorTestResultImpl
