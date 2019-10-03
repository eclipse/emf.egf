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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import test.FileOutputTestResult;
import test.TestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Output Test Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.impl.FileOutputTestResultImpl#getIFilePath <em>IFile Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileOutputTestResultImpl extends OutputTestResultImpl implements FileOutputTestResult {
	/**
     * The default value of the '{@link #getIFilePath() <em>IFile Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIFilePath()
     * @generated
     * @ordered
     */
	protected static final String IFILE_PATH_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getIFilePath() <em>IFile Path</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIFilePath()
     * @generated
     * @ordered
     */
	protected String iFilePath = IFILE_PATH_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FileOutputTestResultImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TestPackage.Literals.FILE_OUTPUT_TEST_RESULT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getIFilePath() {
        return iFilePath;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIFilePath(String newIFilePath) {
        String oldIFilePath = iFilePath;
        iFilePath = newIFilePath;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.FILE_OUTPUT_TEST_RESULT__IFILE_PATH, oldIFilePath, iFilePath));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TestPackage.FILE_OUTPUT_TEST_RESULT__IFILE_PATH:
                return getIFilePath();
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
            case TestPackage.FILE_OUTPUT_TEST_RESULT__IFILE_PATH:
                setIFilePath((String)newValue);
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
            case TestPackage.FILE_OUTPUT_TEST_RESULT__IFILE_PATH:
                setIFilePath(IFILE_PATH_EDEFAULT);
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
            case TestPackage.FILE_OUTPUT_TEST_RESULT__IFILE_PATH:
                return IFILE_PATH_EDEFAULT == null ? iFilePath != null : !IFILE_PATH_EDEFAULT.equals(iFilePath);
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
        result.append(" (iFilePath: ");
        result.append(iFilePath);
        result.append(')');
        return result.toString();
    }

} //FileOutputTestResultImpl
