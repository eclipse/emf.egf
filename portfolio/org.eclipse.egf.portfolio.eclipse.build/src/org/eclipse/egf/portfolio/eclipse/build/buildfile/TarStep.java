/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.portfolio.eclipse.build.buildfile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tar Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep#getDestfile <em>Destfile</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep#getBaseDir <em>Base Dir</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep#getCompression <em>Compression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getTarStep()
 * @model
 * @generated
 */
public interface TarStep extends FileStep, FilesetProvider {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

	/**
     * Returns the value of the '<em><b>Destfile</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destfile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Destfile</em>' attribute.
     * @see #setDestfile(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getTarStep_Destfile()
     * @model required="true"
     * @generated
     */
	String getDestfile();

	/**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep#getDestfile <em>Destfile</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Destfile</em>' attribute.
     * @see #getDestfile()
     * @generated
     */
	void setDestfile(String value);

	/**
     * Returns the value of the '<em><b>Base Dir</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Base Dir</em>' attribute.
     * @see #setBaseDir(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getTarStep_BaseDir()
     * @model required="true"
     * @generated
     */
	String getBaseDir();

	/**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep#getBaseDir <em>Base Dir</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Dir</em>' attribute.
     * @see #getBaseDir()
     * @generated
     */
	void setBaseDir(String value);

	/**
     * Returns the value of the '<em><b>Compression</b></em>' attribute.
     * The default value is <code>""</code>.
     * The literals are from the enumeration {@link org.eclipse.egf.portfolio.eclipse.build.buildfile.CompressionMethod}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Compression</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.CompressionMethod
     * @see #setCompression(CompressionMethod)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getTarStep_Compression()
     * @model default="" required="true"
     * @generated
     */
	CompressionMethod getCompression();

	/**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep#getCompression <em>Compression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Compression</em>' attribute.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.CompressionMethod
     * @see #getCompression()
     * @generated
     */
    void setCompression(CompressionMethod value);

} // TarStep
