/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v2.0
 *    which accompanies this distribution, and is available at
 *    https://www.eclipse.org/legal/epl-v2.0
 *
 *    SPDX-License-Identifier: EPL-2.0
 * 
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.portfolio.eclipse.build.buildfile.impl;

import java.util.Collection;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.CompressionMethod;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStep;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tar Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getFilePaths <em>File Paths</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getDirPaths <em>Dir Paths</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getResultSteps <em>Result Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getInstallSteps <em>Install Steps</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getDestfile <em>Destfile</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getBaseDir <em>Base Dir</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.TarStepImpl#getCompression <em>Compression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TarStepImpl extends FileStepImpl implements TarStep {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v2.0\r\n   which accompanies this distribution, and is available at\r\n   https://www.eclipse.org/legal/epl-v2.0\r\n  \r\n  SPDX-License-Identifier: EPL-2.0\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

	/**
     * The cached value of the '{@link #getFilePaths() <em>File Paths</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFilePaths()
     * @generated
     * @ordered
     */
	protected EList<String> filePaths;

	/**
     * The cached value of the '{@link #getDirPaths() <em>Dir Paths</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDirPaths()
     * @generated
     * @ordered
     */
	protected EList<String> dirPaths;

	/**
     * The cached value of the '{@link #getResultSteps() <em>Result Steps</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getResultSteps()
     * @generated
     * @ordered
     */
	protected EList<ResultStep> resultSteps;

	/**
     * The cached value of the '{@link #getInstallSteps() <em>Install Steps</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInstallSteps()
     * @generated
     * @ordered
     */
	protected EList<InstallStep> installSteps;

	/**
     * The default value of the '{@link #getDestfile() <em>Destfile</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDestfile()
     * @generated
     * @ordered
     */
	protected static final String DESTFILE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getDestfile() <em>Destfile</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDestfile()
     * @generated
     * @ordered
     */
	protected String destfile = DESTFILE_EDEFAULT;

	/**
     * The default value of the '{@link #getBaseDir() <em>Base Dir</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseDir()
     * @generated
     * @ordered
     */
	protected static final String BASE_DIR_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getBaseDir() <em>Base Dir</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBaseDir()
     * @generated
     * @ordered
     */
	protected String baseDir = BASE_DIR_EDEFAULT;

	/**
     * The default value of the '{@link #getCompression() <em>Compression</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCompression()
     * @generated
     * @ordered
     */
	protected static final CompressionMethod COMPRESSION_EDEFAULT = CompressionMethod.NONE;

	/**
     * The cached value of the '{@link #getCompression() <em>Compression</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCompression()
     * @generated
     * @ordered
     */
	protected CompressionMethod compression = COMPRESSION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TarStepImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BuildfilePackage.Literals.TAR_STEP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<String> getFilePaths() {
        if (filePaths == null) {
            filePaths = new EDataTypeUniqueEList<String>(String.class, this, BuildfilePackage.TAR_STEP__FILE_PATHS);
        }
        return filePaths;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<String> getDirPaths() {
        if (dirPaths == null) {
            dirPaths = new EDataTypeUniqueEList<String>(String.class, this, BuildfilePackage.TAR_STEP__DIR_PATHS);
        }
        return dirPaths;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ResultStep> getResultSteps() {
        if (resultSteps == null) {
            resultSteps = new EObjectResolvingEList<ResultStep>(ResultStep.class, this, BuildfilePackage.TAR_STEP__RESULT_STEPS);
        }
        return resultSteps;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<InstallStep> getInstallSteps() {
        if (installSteps == null) {
            installSteps = new EObjectResolvingEList<InstallStep>(InstallStep.class, this, BuildfilePackage.TAR_STEP__INSTALL_STEPS);
        }
        return installSteps;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDestfile() {
        return destfile;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDestfile(String newDestfile) {
        String oldDestfile = destfile;
        destfile = newDestfile;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.TAR_STEP__DESTFILE, oldDestfile, destfile));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getBaseDir() {
        return baseDir;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBaseDir(String newBaseDir) {
        String oldBaseDir = baseDir;
        baseDir = newBaseDir;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.TAR_STEP__BASE_DIR, oldBaseDir, baseDir));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CompressionMethod getCompression() {
        return compression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCompression(CompressionMethod newCompression) {
        CompressionMethod oldCompression = compression;
        compression = newCompression == null ? COMPRESSION_EDEFAULT : newCompression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, BuildfilePackage.TAR_STEP__COMPRESSION, oldCompression, compression));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BuildfilePackage.TAR_STEP__FILE_PATHS:
                return getFilePaths();
            case BuildfilePackage.TAR_STEP__DIR_PATHS:
                return getDirPaths();
            case BuildfilePackage.TAR_STEP__RESULT_STEPS:
                return getResultSteps();
            case BuildfilePackage.TAR_STEP__INSTALL_STEPS:
                return getInstallSteps();
            case BuildfilePackage.TAR_STEP__DESTFILE:
                return getDestfile();
            case BuildfilePackage.TAR_STEP__BASE_DIR:
                return getBaseDir();
            case BuildfilePackage.TAR_STEP__COMPRESSION:
                return getCompression();
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
            case BuildfilePackage.TAR_STEP__FILE_PATHS:
                getFilePaths().clear();
                getFilePaths().addAll((Collection<? extends String>)newValue);
                return;
            case BuildfilePackage.TAR_STEP__DIR_PATHS:
                getDirPaths().clear();
                getDirPaths().addAll((Collection<? extends String>)newValue);
                return;
            case BuildfilePackage.TAR_STEP__RESULT_STEPS:
                getResultSteps().clear();
                getResultSteps().addAll((Collection<? extends ResultStep>)newValue);
                return;
            case BuildfilePackage.TAR_STEP__INSTALL_STEPS:
                getInstallSteps().clear();
                getInstallSteps().addAll((Collection<? extends InstallStep>)newValue);
                return;
            case BuildfilePackage.TAR_STEP__DESTFILE:
                setDestfile((String)newValue);
                return;
            case BuildfilePackage.TAR_STEP__BASE_DIR:
                setBaseDir((String)newValue);
                return;
            case BuildfilePackage.TAR_STEP__COMPRESSION:
                setCompression((CompressionMethod)newValue);
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
            case BuildfilePackage.TAR_STEP__FILE_PATHS:
                getFilePaths().clear();
                return;
            case BuildfilePackage.TAR_STEP__DIR_PATHS:
                getDirPaths().clear();
                return;
            case BuildfilePackage.TAR_STEP__RESULT_STEPS:
                getResultSteps().clear();
                return;
            case BuildfilePackage.TAR_STEP__INSTALL_STEPS:
                getInstallSteps().clear();
                return;
            case BuildfilePackage.TAR_STEP__DESTFILE:
                setDestfile(DESTFILE_EDEFAULT);
                return;
            case BuildfilePackage.TAR_STEP__BASE_DIR:
                setBaseDir(BASE_DIR_EDEFAULT);
                return;
            case BuildfilePackage.TAR_STEP__COMPRESSION:
                setCompression(COMPRESSION_EDEFAULT);
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
            case BuildfilePackage.TAR_STEP__FILE_PATHS:
                return filePaths != null && !filePaths.isEmpty();
            case BuildfilePackage.TAR_STEP__DIR_PATHS:
                return dirPaths != null && !dirPaths.isEmpty();
            case BuildfilePackage.TAR_STEP__RESULT_STEPS:
                return resultSteps != null && !resultSteps.isEmpty();
            case BuildfilePackage.TAR_STEP__INSTALL_STEPS:
                return installSteps != null && !installSteps.isEmpty();
            case BuildfilePackage.TAR_STEP__DESTFILE:
                return DESTFILE_EDEFAULT == null ? destfile != null : !DESTFILE_EDEFAULT.equals(destfile);
            case BuildfilePackage.TAR_STEP__BASE_DIR:
                return BASE_DIR_EDEFAULT == null ? baseDir != null : !BASE_DIR_EDEFAULT.equals(baseDir);
            case BuildfilePackage.TAR_STEP__COMPRESSION:
                return compression != COMPRESSION_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == FilesetProvider.class) {
            switch (derivedFeatureID) {
                case BuildfilePackage.TAR_STEP__FILE_PATHS: return BuildfilePackage.FILESET_PROVIDER__FILE_PATHS;
                case BuildfilePackage.TAR_STEP__DIR_PATHS: return BuildfilePackage.FILESET_PROVIDER__DIR_PATHS;
                case BuildfilePackage.TAR_STEP__RESULT_STEPS: return BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS;
                case BuildfilePackage.TAR_STEP__INSTALL_STEPS: return BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == FilesetProvider.class) {
            switch (baseFeatureID) {
                case BuildfilePackage.FILESET_PROVIDER__FILE_PATHS: return BuildfilePackage.TAR_STEP__FILE_PATHS;
                case BuildfilePackage.FILESET_PROVIDER__DIR_PATHS: return BuildfilePackage.TAR_STEP__DIR_PATHS;
                case BuildfilePackage.FILESET_PROVIDER__RESULT_STEPS: return BuildfilePackage.TAR_STEP__RESULT_STEPS;
                case BuildfilePackage.FILESET_PROVIDER__INSTALL_STEPS: return BuildfilePackage.TAR_STEP__INSTALL_STEPS;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (filePaths: ");
        result.append(filePaths);
        result.append(", dirPaths: ");
        result.append(dirPaths);
        result.append(", destfile: ");
        result.append(destfile);
        result.append(", baseDir: ");
        result.append(baseDir);
        result.append(", compression: ");
        result.append(compression);
        result.append(')');
        return result.toString();
    }

} //TarStepImpl
