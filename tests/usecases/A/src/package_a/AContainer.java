/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package package_a;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AContainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link package_a.AContainer#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see package_a.Package_aPackage#getAContainer()
 * @model
 * @generated
 */
public interface AContainer extends A {
    /**
     * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
     * The list contents are of type {@link package_a.A}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Elements</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Elements</em>' containment reference list.
     * @see package_a.Package_aPackage#getAContainer_Elements()
     * @model containment="true"
     * @generated
     */
    EList<A> getElements();

} // AContainer
