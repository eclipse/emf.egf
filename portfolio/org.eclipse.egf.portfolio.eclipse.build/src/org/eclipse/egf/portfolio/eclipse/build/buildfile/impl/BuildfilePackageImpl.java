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

package org.eclipse.egf.portfolio.eclipse.build.buildfile.impl;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

import org.eclipse.egf.portfolio.eclipse.build.buildfile.AntParameter;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfileFactory;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.DeleteStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.FileStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep;
import org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildstepPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuildfilePackageImpl extends EPackageImpl implements BuildfilePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass antParameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fileStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass filesetProviderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass zipStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unzipStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass moveStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass renameStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deleteStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass copyStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass downloadStepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass createFolderStepEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BuildfilePackageImpl() {
        super(eNS_URI, BuildfileFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link BuildfilePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BuildfilePackage init() {
        if (isInited) return (BuildfilePackage)EPackage.Registry.INSTANCE.getEPackage(BuildfilePackage.eNS_URI);

        // Obtain or create and register package
        BuildfilePackageImpl theBuildfilePackage = (BuildfilePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BuildfilePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BuildfilePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        BuildstepPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theBuildfilePackage.createPackageContents();

        // Initialize created meta-data
        theBuildfilePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theBuildfilePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(BuildfilePackage.eNS_URI, theBuildfilePackage);
        return theBuildfilePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAntParameter() {
        return antParameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFileStep() {
        return fileStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFileStep_AdditionalParameters() {
        return (EReference)fileStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFilesetProvider() {
        return filesetProviderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFilesetProvider_FilePaths() {
        return (EAttribute)filesetProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFilesetProvider_DirPaths() {
        return (EAttribute)filesetProviderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFilesetProvider_ResultSteps() {
        return (EReference)filesetProviderEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFilesetProvider_InstallSteps() {
        return (EReference)filesetProviderEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getZipStep() {
        return zipStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getZipStep_BaseDir() {
        return (EAttribute)zipStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getZipStep_DestinationFilePath() {
        return (EAttribute)zipStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUnzipStep() {
        return unzipStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUnzipStep_SourceFilePath() {
        return (EAttribute)unzipStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUnzipStep_DestinationFolderPath() {
        return (EAttribute)unzipStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMoveStep() {
        return moveStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMoveStep_DestinationFolderPath() {
        return (EAttribute)moveStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRenameStep() {
        return renameStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRenameStep_SourcePath() {
        return (EAttribute)renameStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRenameStep_DestinationPath() {
        return (EAttribute)renameStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDeleteStep() {
        return deleteStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCopyStep() {
        return copyStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCopyStep_DestinationFolderPath() {
        return (EAttribute)copyStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDownloadStep() {
        return downloadStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDownloadStep_SourceFilePath() {
        return (EAttribute)downloadStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDownloadStep_DestinationFilePath() {
        return (EAttribute)downloadStepEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCreateFolderStep() {
        return createFolderStepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCreateFolderStep_FolderPath() {
        return (EAttribute)createFolderStepEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildfileFactory getBuildfileFactory() {
        return (BuildfileFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        antParameterEClass = createEClass(ANT_PARAMETER);

        fileStepEClass = createEClass(FILE_STEP);
        createEReference(fileStepEClass, FILE_STEP__ADDITIONAL_PARAMETERS);

        filesetProviderEClass = createEClass(FILESET_PROVIDER);
        createEAttribute(filesetProviderEClass, FILESET_PROVIDER__FILE_PATHS);
        createEAttribute(filesetProviderEClass, FILESET_PROVIDER__DIR_PATHS);
        createEReference(filesetProviderEClass, FILESET_PROVIDER__RESULT_STEPS);
        createEReference(filesetProviderEClass, FILESET_PROVIDER__INSTALL_STEPS);

        zipStepEClass = createEClass(ZIP_STEP);
        createEAttribute(zipStepEClass, ZIP_STEP__BASE_DIR);
        createEAttribute(zipStepEClass, ZIP_STEP__DESTINATION_FILE_PATH);

        unzipStepEClass = createEClass(UNZIP_STEP);
        createEAttribute(unzipStepEClass, UNZIP_STEP__SOURCE_FILE_PATH);
        createEAttribute(unzipStepEClass, UNZIP_STEP__DESTINATION_FOLDER_PATH);

        moveStepEClass = createEClass(MOVE_STEP);
        createEAttribute(moveStepEClass, MOVE_STEP__DESTINATION_FOLDER_PATH);

        renameStepEClass = createEClass(RENAME_STEP);
        createEAttribute(renameStepEClass, RENAME_STEP__SOURCE_PATH);
        createEAttribute(renameStepEClass, RENAME_STEP__DESTINATION_PATH);

        deleteStepEClass = createEClass(DELETE_STEP);

        copyStepEClass = createEClass(COPY_STEP);
        createEAttribute(copyStepEClass, COPY_STEP__DESTINATION_FOLDER_PATH);

        downloadStepEClass = createEClass(DOWNLOAD_STEP);
        createEAttribute(downloadStepEClass, DOWNLOAD_STEP__SOURCE_FILE_PATH);
        createEAttribute(downloadStepEClass, DOWNLOAD_STEP__DESTINATION_FILE_PATH);

        createFolderStepEClass = createEClass(CREATE_FOLDER_STEP);
        createEAttribute(createFolderStepEClass, CREATE_FOLDER_STEP__FOLDER_PATH);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        BuildcorePackage theBuildcorePackage = (BuildcorePackage)EPackage.Registry.INSTANCE.getEPackage(BuildcorePackage.eNS_URI);
        BuildstepPackage theBuildstepPackage = (BuildstepPackage)EPackage.Registry.INSTANCE.getEPackage(BuildstepPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        antParameterEClass.getESuperTypes().add(theBuildcorePackage.getKeyValue());
        fileStepEClass.getESuperTypes().add(theBuildcorePackage.getStep());
        zipStepEClass.getESuperTypes().add(this.getFileStep());
        zipStepEClass.getESuperTypes().add(this.getFilesetProvider());
        unzipStepEClass.getESuperTypes().add(this.getFileStep());
        moveStepEClass.getESuperTypes().add(this.getFileStep());
        moveStepEClass.getESuperTypes().add(this.getFilesetProvider());
        renameStepEClass.getESuperTypes().add(this.getFileStep());
        deleteStepEClass.getESuperTypes().add(this.getFileStep());
        deleteStepEClass.getESuperTypes().add(this.getFilesetProvider());
        copyStepEClass.getESuperTypes().add(this.getFileStep());
        copyStepEClass.getESuperTypes().add(this.getFilesetProvider());
        downloadStepEClass.getESuperTypes().add(this.getFileStep());
        createFolderStepEClass.getESuperTypes().add(this.getFileStep());

        // Initialize classes and features; add operations and parameters
        initEClass(antParameterEClass, AntParameter.class, "AntParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(fileStepEClass, FileStep.class, "FileStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFileStep_AdditionalParameters(), this.getAntParameter(), null, "additionalParameters", null, 0, -1, FileStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(filesetProviderEClass, FilesetProvider.class, "FilesetProvider", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFilesetProvider_FilePaths(), ecorePackage.getEString(), "filePaths", null, 0, -1, FilesetProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFilesetProvider_DirPaths(), ecorePackage.getEString(), "dirPaths", null, 0, -1, FilesetProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFilesetProvider_ResultSteps(), theBuildstepPackage.getResultStep(), null, "resultSteps", null, 0, -1, FilesetProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFilesetProvider_InstallSteps(), theBuildstepPackage.getInstallStep(), null, "installSteps", null, 0, -1, FilesetProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(zipStepEClass, ZipStep.class, "ZipStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getZipStep_BaseDir(), ecorePackage.getEString(), "baseDir", null, 1, 1, ZipStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getZipStep_DestinationFilePath(), ecorePackage.getEString(), "destinationFilePath", null, 1, 1, ZipStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(unzipStepEClass, UnzipStep.class, "UnzipStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getUnzipStep_SourceFilePath(), ecorePackage.getEString(), "sourceFilePath", null, 1, 1, UnzipStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getUnzipStep_DestinationFolderPath(), ecorePackage.getEString(), "destinationFolderPath", null, 1, 1, UnzipStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(moveStepEClass, MoveStep.class, "MoveStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMoveStep_DestinationFolderPath(), ecorePackage.getEString(), "destinationFolderPath", null, 1, 1, MoveStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(renameStepEClass, RenameStep.class, "RenameStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRenameStep_SourcePath(), ecorePackage.getEString(), "sourcePath", null, 1, 1, RenameStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRenameStep_DestinationPath(), ecorePackage.getEString(), "destinationPath", null, 1, 1, RenameStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(deleteStepEClass, DeleteStep.class, "DeleteStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(copyStepEClass, CopyStep.class, "CopyStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCopyStep_DestinationFolderPath(), ecorePackage.getEString(), "destinationFolderPath", null, 1, 1, CopyStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(downloadStepEClass, DownloadStep.class, "DownloadStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDownloadStep_SourceFilePath(), ecorePackage.getEString(), "sourceFilePath", null, 1, 1, DownloadStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDownloadStep_DestinationFilePath(), ecorePackage.getEString(), "destinationFilePath", null, 1, 1, DownloadStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(createFolderStepEClass, CreateFolderStep.class, "CreateFolderStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCreateFolderStep_FolderPath(), ecorePackage.getEString(), "folderPath", null, 1, 1, CreateFolderStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //BuildfilePackageImpl
