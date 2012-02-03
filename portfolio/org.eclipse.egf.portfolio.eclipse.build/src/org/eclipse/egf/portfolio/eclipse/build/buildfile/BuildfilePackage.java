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

package org.eclipse.egf.portfolio.eclipse.build.buildfile;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage;

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
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfileFactory
 * @model kind="package"
 * @generated
 */
public interface BuildfilePackage extends EPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "buildfile";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/buildfile";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildfile";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildfilePackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.AntParameterImpl <em>Ant Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.AntParameterImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getAntParameter()
     * @generated
     */
    int ANT_PARAMETER = 0;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_PARAMETER__KEY = BuildcorePackage.KEY_VALUE__KEY;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_PARAMETER__VALUE = BuildcorePackage.KEY_VALUE__VALUE;

    /**
     * The number of structural features of the '<em>Ant Parameter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANT_PARAMETER_FEATURE_COUNT = BuildcorePackage.KEY_VALUE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FileStepImpl <em>File Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FileStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getFileStep()
     * @generated
     */
    int FILE_STEP = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_STEP__ID = BuildcorePackage.STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_STEP__DESCRIPTION = BuildcorePackage.STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_STEP__ADDITIONAL_PARAMETERS = BuildcorePackage.STEP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>File Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_STEP_FEATURE_COUNT = BuildcorePackage.STEP_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl <em>Fileset Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getFilesetProvider()
     * @generated
     */
    int FILESET_PROVIDER = 2;

    /**
     * The feature id for the '<em><b>File Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESET_PROVIDER__FILE_PATHS = 0;

    /**
     * The feature id for the '<em><b>Dir Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESET_PROVIDER__DIR_PATHS = 1;

    /**
     * The feature id for the '<em><b>Result Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESET_PROVIDER__RESULT_STEPS = 2;

    /**
     * The feature id for the '<em><b>Install Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESET_PROVIDER__INSTALL_STEPS = 3;

    /**
     * The number of structural features of the '<em>Fileset Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILESET_PROVIDER_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.ZipStepImpl <em>Zip Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.ZipStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getZipStep()
     * @generated
     */
    int ZIP_STEP = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>File Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__FILE_PATHS = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dir Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__DIR_PATHS = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__RESULT_STEPS = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Install Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__INSTALL_STEPS = FILE_STEP_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Base Dir</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__BASE_DIR = FILE_STEP_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Destination File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP__DESTINATION_FILE_PATH = FILE_STEP_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Zip Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ZIP_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.UnzipStepImpl <em>Unzip Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.UnzipStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getUnzipStep()
     * @generated
     */
    int UNZIP_STEP = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNZIP_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNZIP_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNZIP_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>Source File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNZIP_STEP__SOURCE_FILE_PATH = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Destination Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNZIP_STEP__DESTINATION_FOLDER_PATH = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Unzip Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UNZIP_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.MoveStepImpl <em>Move Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.MoveStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getMoveStep()
     * @generated
     */
    int MOVE_STEP = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>File Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__FILE_PATHS = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dir Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__DIR_PATHS = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__RESULT_STEPS = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Install Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__INSTALL_STEPS = FILE_STEP_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Destination Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP__DESTINATION_FOLDER_PATH = FILE_STEP_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Move Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVE_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.RenameStepImpl <em>Rename Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.RenameStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getRenameStep()
     * @generated
     */
    int RENAME_STEP = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>Source Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_STEP__SOURCE_PATH = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Destination Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_STEP__DESTINATION_PATH = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Rename Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RENAME_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DeleteStepImpl <em>Delete Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DeleteStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getDeleteStep()
     * @generated
     */
    int DELETE_STEP = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>File Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__FILE_PATHS = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dir Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__DIR_PATHS = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__RESULT_STEPS = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Install Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP__INSTALL_STEPS = FILE_STEP_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Delete Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DELETE_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CopyStepImpl <em>Copy Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CopyStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getCopyStep()
     * @generated
     */
    int COPY_STEP = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>File Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__FILE_PATHS = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dir Paths</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__DIR_PATHS = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Result Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__RESULT_STEPS = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Install Steps</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__INSTALL_STEPS = FILE_STEP_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Destination Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP__DESTINATION_FOLDER_PATH = FILE_STEP_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Copy Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COPY_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DownloadStepImpl <em>Download Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DownloadStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getDownloadStep()
     * @generated
     */
    int DOWNLOAD_STEP = 9;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOWNLOAD_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOWNLOAD_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOWNLOAD_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>Source File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOWNLOAD_STEP__SOURCE_FILE_PATH = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Destination File Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOWNLOAD_STEP__DESTINATION_FILE_PATH = FILE_STEP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Download Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOWNLOAD_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CreateFolderStepImpl <em>Create Folder Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CreateFolderStepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getCreateFolderStep()
     * @generated
     */
    int CREATE_FOLDER_STEP = 10;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_FOLDER_STEP__ID = FILE_STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_FOLDER_STEP__DESCRIPTION = FILE_STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Additional Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_FOLDER_STEP__ADDITIONAL_PARAMETERS = FILE_STEP__ADDITIONAL_PARAMETERS;

    /**
     * The feature id for the '<em><b>Folder Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_FOLDER_STEP__FOLDER_PATH = FILE_STEP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Create Folder Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREATE_FOLDER_STEP_FEATURE_COUNT = FILE_STEP_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.AntParameter <em>Ant Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ant Parameter</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.AntParameter
     * @generated
     */
    EClass getAntParameter();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FileStep <em>File Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>File Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FileStep
     * @generated
     */
    EClass getFileStep();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FileStep#getAdditionalParameters <em>Additional Parameters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Additional Parameters</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FileStep#getAdditionalParameters()
     * @see #getFileStep()
     * @generated
     */
    EReference getFileStep_AdditionalParameters();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider <em>Fileset Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Fileset Provider</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider
     * @generated
     */
    EClass getFilesetProvider();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getFilePaths <em>File Paths</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>File Paths</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getFilePaths()
     * @see #getFilesetProvider()
     * @generated
     */
    EAttribute getFilesetProvider_FilePaths();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getDirPaths <em>Dir Paths</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Dir Paths</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getDirPaths()
     * @see #getFilesetProvider()
     * @generated
     */
    EAttribute getFilesetProvider_DirPaths();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getResultSteps <em>Result Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Result Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getResultSteps()
     * @see #getFilesetProvider()
     * @generated
     */
    EReference getFilesetProvider_ResultSteps();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getInstallSteps <em>Install Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Install Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider#getInstallSteps()
     * @see #getFilesetProvider()
     * @generated
     */
    EReference getFilesetProvider_InstallSteps();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep <em>Zip Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Zip Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep
     * @generated
     */
    EClass getZipStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getBaseDir <em>Base Dir</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Dir</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getBaseDir()
     * @see #getZipStep()
     * @generated
     */
    EAttribute getZipStep_BaseDir();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getDestinationFilePath <em>Destination File Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Destination File Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep#getDestinationFilePath()
     * @see #getZipStep()
     * @generated
     */
    EAttribute getZipStep_DestinationFilePath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep <em>Unzip Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unzip Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep
     * @generated
     */
    EClass getUnzipStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep#getSourceFilePath <em>Source File Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source File Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep#getSourceFilePath()
     * @see #getUnzipStep()
     * @generated
     */
    EAttribute getUnzipStep_SourceFilePath();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep#getDestinationFolderPath <em>Destination Folder Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Destination Folder Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep#getDestinationFolderPath()
     * @see #getUnzipStep()
     * @generated
     */
    EAttribute getUnzipStep_DestinationFolderPath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep <em>Move Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Move Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep
     * @generated
     */
    EClass getMoveStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep#getDestinationFolderPath <em>Destination Folder Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Destination Folder Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep#getDestinationFolderPath()
     * @see #getMoveStep()
     * @generated
     */
    EAttribute getMoveStep_DestinationFolderPath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep <em>Rename Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rename Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep
     * @generated
     */
    EClass getRenameStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getSourcePath <em>Source Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getSourcePath()
     * @see #getRenameStep()
     * @generated
     */
    EAttribute getRenameStep_SourcePath();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getDestinationPath <em>Destination Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Destination Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.RenameStep#getDestinationPath()
     * @see #getRenameStep()
     * @generated
     */
    EAttribute getRenameStep_DestinationPath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DeleteStep <em>Delete Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Delete Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.DeleteStep
     * @generated
     */
    EClass getDeleteStep();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep <em>Copy Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Copy Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep
     * @generated
     */
    EClass getCopyStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep#getDestinationFolderPath <em>Destination Folder Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Destination Folder Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.CopyStep#getDestinationFolderPath()
     * @see #getCopyStep()
     * @generated
     */
    EAttribute getCopyStep_DestinationFolderPath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep <em>Download Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Download Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep
     * @generated
     */
    EClass getDownloadStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep#getSourceFilePath <em>Source File Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source File Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep#getSourceFilePath()
     * @see #getDownloadStep()
     * @generated
     */
    EAttribute getDownloadStep_SourceFilePath();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep#getDestinationFilePath <em>Destination File Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Destination File Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.DownloadStep#getDestinationFilePath()
     * @see #getDownloadStep()
     * @generated
     */
    EAttribute getDownloadStep_DestinationFilePath();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep <em>Create Folder Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Create Folder Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep
     * @generated
     */
    EClass getCreateFolderStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep#getFolderPath <em>Folder Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Folder Path</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep#getFolderPath()
     * @see #getCreateFolderStep()
     * @generated
     */
    EAttribute getCreateFolderStep_FolderPath();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildfileFactory getBuildfileFactory();

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
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.AntParameterImpl <em>Ant Parameter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.AntParameterImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getAntParameter()
         * @generated
         */
        EClass ANT_PARAMETER = eINSTANCE.getAntParameter();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FileStepImpl <em>File Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FileStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getFileStep()
         * @generated
         */
        EClass FILE_STEP = eINSTANCE.getFileStep();

        /**
         * The meta object literal for the '<em><b>Additional Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILE_STEP__ADDITIONAL_PARAMETERS = eINSTANCE.getFileStep_AdditionalParameters();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl <em>Fileset Provider</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.FilesetProviderImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getFilesetProvider()
         * @generated
         */
        EClass FILESET_PROVIDER = eINSTANCE.getFilesetProvider();

        /**
         * The meta object literal for the '<em><b>File Paths</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILESET_PROVIDER__FILE_PATHS = eINSTANCE.getFilesetProvider_FilePaths();

        /**
         * The meta object literal for the '<em><b>Dir Paths</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILESET_PROVIDER__DIR_PATHS = eINSTANCE.getFilesetProvider_DirPaths();

        /**
         * The meta object literal for the '<em><b>Result Steps</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILESET_PROVIDER__RESULT_STEPS = eINSTANCE.getFilesetProvider_ResultSteps();

        /**
         * The meta object literal for the '<em><b>Install Steps</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FILESET_PROVIDER__INSTALL_STEPS = eINSTANCE.getFilesetProvider_InstallSteps();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.ZipStepImpl <em>Zip Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.ZipStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getZipStep()
         * @generated
         */
        EClass ZIP_STEP = eINSTANCE.getZipStep();

        /**
         * The meta object literal for the '<em><b>Base Dir</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ZIP_STEP__BASE_DIR = eINSTANCE.getZipStep_BaseDir();

        /**
         * The meta object literal for the '<em><b>Destination File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ZIP_STEP__DESTINATION_FILE_PATH = eINSTANCE.getZipStep_DestinationFilePath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.UnzipStepImpl <em>Unzip Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.UnzipStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getUnzipStep()
         * @generated
         */
        EClass UNZIP_STEP = eINSTANCE.getUnzipStep();

        /**
         * The meta object literal for the '<em><b>Source File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UNZIP_STEP__SOURCE_FILE_PATH = eINSTANCE.getUnzipStep_SourceFilePath();

        /**
         * The meta object literal for the '<em><b>Destination Folder Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UNZIP_STEP__DESTINATION_FOLDER_PATH = eINSTANCE.getUnzipStep_DestinationFolderPath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.MoveStepImpl <em>Move Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.MoveStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getMoveStep()
         * @generated
         */
        EClass MOVE_STEP = eINSTANCE.getMoveStep();

        /**
         * The meta object literal for the '<em><b>Destination Folder Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MOVE_STEP__DESTINATION_FOLDER_PATH = eINSTANCE.getMoveStep_DestinationFolderPath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.RenameStepImpl <em>Rename Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.RenameStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getRenameStep()
         * @generated
         */
        EClass RENAME_STEP = eINSTANCE.getRenameStep();

        /**
         * The meta object literal for the '<em><b>Source Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RENAME_STEP__SOURCE_PATH = eINSTANCE.getRenameStep_SourcePath();

        /**
         * The meta object literal for the '<em><b>Destination Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RENAME_STEP__DESTINATION_PATH = eINSTANCE.getRenameStep_DestinationPath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DeleteStepImpl <em>Delete Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DeleteStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getDeleteStep()
         * @generated
         */
        EClass DELETE_STEP = eINSTANCE.getDeleteStep();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CopyStepImpl <em>Copy Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CopyStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getCopyStep()
         * @generated
         */
        EClass COPY_STEP = eINSTANCE.getCopyStep();

        /**
         * The meta object literal for the '<em><b>Destination Folder Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COPY_STEP__DESTINATION_FOLDER_PATH = eINSTANCE.getCopyStep_DestinationFolderPath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DownloadStepImpl <em>Download Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.DownloadStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getDownloadStep()
         * @generated
         */
        EClass DOWNLOAD_STEP = eINSTANCE.getDownloadStep();

        /**
         * The meta object literal for the '<em><b>Source File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOWNLOAD_STEP__SOURCE_FILE_PATH = eINSTANCE.getDownloadStep_SourceFilePath();

        /**
         * The meta object literal for the '<em><b>Destination File Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOWNLOAD_STEP__DESTINATION_FILE_PATH = eINSTANCE.getDownloadStep_DestinationFilePath();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CreateFolderStepImpl <em>Create Folder Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.CreateFolderStepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.impl.BuildfilePackageImpl#getCreateFolderStep()
         * @generated
         */
        EClass CREATE_FOLDER_STEP = eINSTANCE.getCreateFolderStep();

        /**
         * The meta object literal for the '<em><b>Folder Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CREATE_FOLDER_STEP__FOLDER_PATH = eINSTANCE.getCreateFolderStep_FolderPath();

    }

} //BuildfilePackage
