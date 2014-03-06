/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Validation Error Severity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see test.TestPackage#getValidationErrorSeverity()
 * @model
 * @generated
 */
public enum ValidationErrorSeverity implements Enumerator {
  /**
     * The '<em><b>INFO</b></em>' literal object.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #INFO_VALUE
     * @generated
     * @ordered
     */
  INFO(1, "INFO", "INFO"),

  /**
     * The '<em><b>WARNING</b></em>' literal object.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #WARNING_VALUE
     * @generated
     * @ordered
     */
  WARNING(2, "WARNING", "WARNING"),

  /**
     * The '<em><b>ERROR</b></em>' literal object.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #ERROR_VALUE
     * @generated
     * @ordered
     */
  ERROR(4, "ERROR", "ERROR");

  /**
     * The '<em><b>INFO</b></em>' literal value.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INFO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @see #INFO
     * @model
     * @generated
     * @ordered
     */
  public static final int INFO_VALUE = 1;

  /**
     * The '<em><b>WARNING</b></em>' literal value.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WARNING</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @see #WARNING
     * @model
     * @generated
     * @ordered
     */
  public static final int WARNING_VALUE = 2;

  /**
     * The '<em><b>ERROR</b></em>' literal value.
     * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ERROR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
     * @see #ERROR
     * @model
     * @generated
     * @ordered
     */
  public static final int ERROR_VALUE = 4;

  /**
     * An array of all the '<em><b>Validation Error Severity</b></em>' enumerators.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private static final ValidationErrorSeverity[] VALUES_ARRAY =
    new ValidationErrorSeverity[] {
            INFO,
            WARNING,
            ERROR,
        };

  /**
     * A public read-only list of all the '<em><b>Validation Error Severity</b></em>' enumerators.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public static final List<ValidationErrorSeverity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
     * Returns the '<em><b>Validation Error Severity</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public static ValidationErrorSeverity get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ValidationErrorSeverity result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

  /**
     * Returns the '<em><b>Validation Error Severity</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public static ValidationErrorSeverity getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ValidationErrorSeverity result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

  /**
     * Returns the '<em><b>Validation Error Severity</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public static ValidationErrorSeverity get(int value) {
        switch (value) {
            case INFO_VALUE: return INFO;
            case WARNING_VALUE: return WARNING;
            case ERROR_VALUE: return ERROR;
        }
        return null;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private final int value;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private final String name;

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private final String literal;

  /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private ValidationErrorSeverity(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public int getValue() {
      return value;
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
  public String getLiteral() {
      return literal;
    }

  /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public String toString() {
        return literal;
    }
  
} //ValidationErrorSeverity
