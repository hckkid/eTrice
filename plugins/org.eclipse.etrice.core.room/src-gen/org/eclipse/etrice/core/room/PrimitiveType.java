/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Primitive Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.room.RoomPackage#getPrimitiveType()
 * @model
 * @generated
 */
public enum PrimitiveType implements Enumerator
{
  /**
   * The '<em><b>Void</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VOID_VALUE
   * @generated
   * @ordered
   */
  VOID(0, "void", "void"),

  /**
   * The '<em><b>Int8</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INT8_VALUE
   * @generated
   * @ordered
   */
  INT8(1, "int8", "int8"),

  /**
   * The '<em><b>Int16</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INT16_VALUE
   * @generated
   * @ordered
   */
  INT16(2, "int16", "int16"),

  /**
   * The '<em><b>Int32</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INT32_VALUE
   * @generated
   * @ordered
   */
  INT32(3, "int32", "int32"),

  /**
   * The '<em><b>Uint8</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UINT8_VALUE
   * @generated
   * @ordered
   */
  UINT8(4, "uint8", "uint8"),

  /**
   * The '<em><b>Uint16</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UINT16_VALUE
   * @generated
   * @ordered
   */
  UINT16(5, "uint16", "uint16"),

  /**
   * The '<em><b>Uint32</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UINT32_VALUE
   * @generated
   * @ordered
   */
  UINT32(6, "uint32", "uint32"),

  /**
   * The '<em><b>Float32</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOAT32_VALUE
   * @generated
   * @ordered
   */
  FLOAT32(7, "float32", "float32"),

  /**
   * The '<em><b>Float64</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOAT64_VALUE
   * @generated
   * @ordered
   */
  FLOAT64(8, "float64", "float64"),

  /**
   * The '<em><b>Boolean</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BOOLEAN_VALUE
   * @generated
   * @ordered
   */
  BOOLEAN(9, "boolean", "boolean"),

  /**
   * The '<em><b>String</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STRING_VALUE
   * @generated
   * @ordered
   */
  STRING(10, "string", "string"),

  /**
   * The '<em><b>Char</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CHAR_VALUE
   * @generated
   * @ordered
   */
  CHAR(11, "char", "char");

  /**
   * The '<em><b>Void</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Void</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VOID
   * @model name="void"
   * @generated
   * @ordered
   */
  public static final int VOID_VALUE = 0;

  /**
   * The '<em><b>Int8</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Int8</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INT8
   * @model name="int8"
   * @generated
   * @ordered
   */
  public static final int INT8_VALUE = 1;

  /**
   * The '<em><b>Int16</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Int16</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INT16
   * @model name="int16"
   * @generated
   * @ordered
   */
  public static final int INT16_VALUE = 2;

  /**
   * The '<em><b>Int32</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Int32</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INT32
   * @model name="int32"
   * @generated
   * @ordered
   */
  public static final int INT32_VALUE = 3;

  /**
   * The '<em><b>Uint8</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Uint8</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UINT8
   * @model name="uint8"
   * @generated
   * @ordered
   */
  public static final int UINT8_VALUE = 4;

  /**
   * The '<em><b>Uint16</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Uint16</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UINT16
   * @model name="uint16"
   * @generated
   * @ordered
   */
  public static final int UINT16_VALUE = 5;

  /**
   * The '<em><b>Uint32</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Uint32</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UINT32
   * @model name="uint32"
   * @generated
   * @ordered
   */
  public static final int UINT32_VALUE = 6;

  /**
   * The '<em><b>Float32</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Float32</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FLOAT32
   * @model name="float32"
   * @generated
   * @ordered
   */
  public static final int FLOAT32_VALUE = 7;

  /**
   * The '<em><b>Float64</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Float64</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FLOAT64
   * @model name="float64"
   * @generated
   * @ordered
   */
  public static final int FLOAT64_VALUE = 8;

  /**
   * The '<em><b>Boolean</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BOOLEAN
   * @model name="boolean"
   * @generated
   * @ordered
   */
  public static final int BOOLEAN_VALUE = 9;

  /**
   * The '<em><b>String</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>String</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STRING
   * @model name="string"
   * @generated
   * @ordered
   */
  public static final int STRING_VALUE = 10;

  /**
   * The '<em><b>Char</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Char</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CHAR
   * @model name="char"
   * @generated
   * @ordered
   */
  public static final int CHAR_VALUE = 11;

  /**
   * An array of all the '<em><b>Primitive Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final PrimitiveType[] VALUES_ARRAY =
    new PrimitiveType[]
    {
      VOID,
      INT8,
      INT16,
      INT32,
      UINT8,
      UINT16,
      UINT32,
      FLOAT32,
      FLOAT64,
      BOOLEAN,
      STRING,
      CHAR,
    };

  /**
   * A public read-only list of all the '<em><b>Primitive Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<PrimitiveType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Primitive Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PrimitiveType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PrimitiveType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Primitive Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PrimitiveType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PrimitiveType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Primitive Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PrimitiveType get(int value)
  {
    switch (value)
    {
      case VOID_VALUE: return VOID;
      case INT8_VALUE: return INT8;
      case INT16_VALUE: return INT16;
      case INT32_VALUE: return INT32;
      case UINT8_VALUE: return UINT8;
      case UINT16_VALUE: return UINT16;
      case UINT32_VALUE: return UINT32;
      case FLOAT32_VALUE: return FLOAT32;
      case FLOAT64_VALUE: return FLOAT64;
      case BOOLEAN_VALUE: return BOOLEAN;
      case STRING_VALUE: return STRING;
      case CHAR_VALUE: return CHAR;
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
  private PrimitiveType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //PrimitiveType
