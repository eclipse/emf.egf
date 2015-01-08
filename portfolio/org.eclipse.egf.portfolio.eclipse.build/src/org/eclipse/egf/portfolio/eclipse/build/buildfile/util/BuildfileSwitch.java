/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildfile.util;

import java.util.List;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.Item;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage
 * @generated
 */
public class BuildfileSwitch<T> {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static BuildfilePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildfileSwitch() {
        if (modelPackage == null) {
            modelPackage = BuildfilePackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case BuildfilePackage.ANT_PARAMETER: {
                AntParameter antParameter = (AntParameter)theEObject;
                T result = caseAntParameter(antParameter);
                if (result == null) result = caseKeyValue(antParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.FILE_STEP: {
                FileStep fileStep = (FileStep)theEObject;
                T result = caseFileStep(fileStep);
                if (result == null) result = caseStep(fileStep);
                if (result == null) result = caseItem(fileStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.FILESET_PROVIDER: {
                FilesetProvider filesetProvider = (FilesetProvider)theEObject;
                T result = caseFilesetProvider(filesetProvider);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.ZIP_STEP: {
                ZipStep zipStep = (ZipStep)theEObject;
                T result = caseZipStep(zipStep);
                if (result == null) result = caseFileStep(zipStep);
                if (result == null) result = caseFilesetProvider(zipStep);
                if (result == null) result = caseStep(zipStep);
                if (result == null) result = caseItem(zipStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.UNZIP_STEP: {
                UnzipStep unzipStep = (UnzipStep)theEObject;
                T result = caseUnzipStep(unzipStep);
                if (result == null) result = caseFileStep(unzipStep);
                if (result == null) result = caseStep(unzipStep);
                if (result == null) result = caseItem(unzipStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.MOVE_STEP: {
                MoveStep moveStep = (MoveStep)theEObject;
                T result = caseMoveStep(moveStep);
                if (result == null) result = caseFileStep(moveStep);
                if (result == null) result = caseFilesetProvider(moveStep);
                if (result == null) result = caseStep(moveStep);
                if (result == null) result = caseItem(moveStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.RENAME_STEP: {
                RenameStep renameStep = (RenameStep)theEObject;
                T result = caseRenameStep(renameStep);
                if (result == null) result = caseFileStep(renameStep);
                if (result == null) result = caseStep(renameStep);
                if (result == null) result = caseItem(renameStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.DELETE_STEP: {
                DeleteStep deleteStep = (DeleteStep)theEObject;
                T result = caseDeleteStep(deleteStep);
                if (result == null) result = caseFileStep(deleteStep);
                if (result == null) result = caseFilesetProvider(deleteStep);
                if (result == null) result = caseStep(deleteStep);
                if (result == null) result = caseItem(deleteStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.COPY_STEP: {
                CopyStep copyStep = (CopyStep)theEObject;
                T result = caseCopyStep(copyStep);
                if (result == null) result = caseFileStep(copyStep);
                if (result == null) result = caseFilesetProvider(copyStep);
                if (result == null) result = caseStep(copyStep);
                if (result == null) result = caseItem(copyStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.DOWNLOAD_STEP: {
                DownloadStep downloadStep = (DownloadStep)theEObject;
                T result = caseDownloadStep(downloadStep);
                if (result == null) result = caseFileStep(downloadStep);
                if (result == null) result = caseStep(downloadStep);
                if (result == null) result = caseItem(downloadStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.CREATE_FOLDER_STEP: {
                CreateFolderStep createFolderStep = (CreateFolderStep)theEObject;
                T result = caseCreateFolderStep(createFolderStep);
                if (result == null) result = caseFileStep(createFolderStep);
                if (result == null) result = caseStep(createFolderStep);
                if (result == null) result = caseItem(createFolderStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BuildfilePackage.TAR_STEP: {
                TarStep tarStep = (TarStep)theEObject;
                T result = caseTarStep(tarStep);
                if (result == null) result = caseFileStep(tarStep);
                if (result == null) result = caseFilesetProvider(tarStep);
                if (result == null) result = caseStep(tarStep);
                if (result == null) result = caseItem(tarStep);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ant Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ant Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAntParameter(AntParameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileStep(FileStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Fileset Provider</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Fileset Provider</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFilesetProvider(FilesetProvider object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Zip Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Zip Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseZipStep(ZipStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unzip Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unzip Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnzipStep(UnzipStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Move Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Move Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMoveStep(MoveStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Rename Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rename Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRenameStep(RenameStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Delete Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delete Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDeleteStep(DeleteStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Copy Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Copy Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCopyStep(CopyStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Download Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Download Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDownloadStep(DownloadStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Create Folder Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Create Folder Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCreateFolderStep(CreateFolderStep object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tar Step</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tar Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTarStep(TarStep object) {
        return null;
    }

				/**
     * Returns the result of interpreting the object as an instance of '<em>Key Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyValue(KeyValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem(Item object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStep(Step object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
   public T defaultCase(EObject object) {
        return null;
    }

} //BuildfileSwitch
