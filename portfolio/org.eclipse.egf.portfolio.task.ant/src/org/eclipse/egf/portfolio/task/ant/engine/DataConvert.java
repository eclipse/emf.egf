/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.ant.engine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.StringUtils;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;

public class DataConvert {
    // simplest case - setAttribute expects String
    public final static String TYPE_String = "type:string";

    // setAttribute expects Integer
    public final static String TYPE_Integer = "type:integer";

    // setAttribute expects BigInteger
    public final static String TYPE_BigInteger = "type:biginteger";

    // setAttribute expects BigDecimal
    public final static String TYPE_BigDecimal = "type:bigdecimal";

    // setAttribute expects Float
    public final static String TYPE_Float = "type:float";

    // setAttribute expects Byte
    public final static String TYPE_Byte = "type:byte";

    // setAttribute expects Short
    public final static String TYPE_Short = "type:short";

    // setAttribute expects Double
    public final static String TYPE_Double = "type:double";

    // setAttribute expects Long
    public final static String TYPE_Long = "type:long";

    // char and Character get special treatment - take the first character
    public final static String TYPE_Character = "type:character";

    // boolean and Boolean get special treatment
    public final static String TYPE_Boolean = "type:boolean";

    // setAttribute expects BigDecimal
    public final static String TYPE_Date = "type:date";

    // setAttribute expects URI
    public final static String TYPE_URI = "type:uri";

    /**
     * Creates an implementation of AttributeSetter for the given
     * attribute type. Conversions (where necessary) are automatically
     * made for the following types:(When there is no type mapping, throw
     * exception).
     * <ul>
     * <li>String (left as it is)
     * <li>Character (first character is used)
     * <li>Boolean ({@link Project#toBoolean(String)
     * Project.toBoolean(String)} is used)
     * <li>Long
     * <li>Integer
     * <li>BigInteger
     * <li>BigDecimal
     * <li>Float
     * <li>Byte
     * <li>Double
     * <li>Date (java.util.Date)
     * <li>URI (org.eclipse.emf.common.util.URI)
     * </ul>
     */
    public static Object getConvertVaule(String type, String value) throws Exception {

        type = type.toLowerCase();

        if (TYPE_String.equals(type)) {
            return value;
        }

        if (TYPE_Long.equals(type)) {
            Long longValue = new Long(StringUtils.parseHumanSizes(value));
            return longValue;
        }

        if (TYPE_Integer.equals(type)) {
            Integer integerValue = Integer.valueOf(value);
            return integerValue;
        }

        if (TYPE_BigInteger.equals(type)) {
            BigInteger bigIntegerValue = BigInteger.valueOf(new Long(StringUtils.parseHumanSizes(value)));
            return bigIntegerValue;
        }

        if (TYPE_BigDecimal.equals(type)) {
            BigDecimal bigIntegerValue = new BigDecimal(value);
            return bigIntegerValue;
        }

        if (TYPE_Float.equals(type)) {
            Float floatValue = Float.valueOf(value);
            return floatValue;
        }

        if (TYPE_Byte.equals(type)) {
            Byte byteValue = Byte.valueOf(value);
            return byteValue;
        }

        if (TYPE_Short.equals(type)) {
            Short shortValue = Short.valueOf(value);
            return shortValue;
        }

        if (TYPE_Double.equals(type)) {
            Double doubleValue = Double.valueOf(value);
            return doubleValue;
        }

        if (TYPE_Boolean.equals(type)) {
            Boolean booleanValue = Project.toBoolean(value) ? Boolean.TRUE : Boolean.FALSE;
            return booleanValue;
        }

        if (TYPE_Character.equals(type)) {
            Character characterValue = new Character(value.charAt(0));
            return characterValue;
        }

        if (TYPE_Date.equals(type)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateValue = simpleDateFormat.parse(value.replace("/", "-"));
            return dateValue;
        }

        if (TYPE_URI.equals(type)) {
            URI uriValue = URI.createURI(value);
            return uriValue;
        }

        throw new ExecutionException("It dosen't support to rewriting the contract with the type:\'" + type + "\' in ant script directly, please rewrite it in the task class.");
    }

    /**
     * Get the Class<?> for the given attribute type.Conversions (where
     * necessary) are automatically made for the following Class<?>:(When there
     * is no type mapping, throw exception).
     * <ul>
     * <li>String.class
     * <li>Character.class
     * <li>Boolean.class
     * <li>Long.class
     * <li>Integer.class
     * <li>BigInteger.class (java.math.BigInteger)
     * <li>BigDecimal.class (java.math.BigDecimal)
     * <li>Float.class
     * <li>Byte.class
     * <li>Double.class
     * <li>Date.class
     * <li>URI.class (org.eclipse.emf.common.util.URI)
     * </ul>
     */
    public static Class<?> getType(String type) throws Exception {

        type = type.toLowerCase();

        if (TYPE_String.equals(type)) {
            return String.class;
        }

        if (TYPE_Long.equals(type)) {
            return Long.class;
        }

        if (TYPE_Integer.equals(type)) {
            return Integer.class;
        }

        if (TYPE_BigInteger.equals(type)) {
            return BigInteger.class;
        }

        if (TYPE_BigDecimal.equals(type)) {
            return BigDecimal.class;
        }

        if (TYPE_Float.equals(type)) {
            return Float.class;
        }

        if (TYPE_Byte.equals(type)) {
            return Byte.class;
        }

        if (TYPE_Short.equals(type)) {
            return Short.class;
        }

        if (TYPE_Double.equals(type)) {
            return Double.class;
        }

        if (TYPE_Boolean.equals(type)) {
            return Boolean.class;
        }

        if (TYPE_Character.equals(type)) {
            return Character.class;
        }

        if (TYPE_Date.equals(type)) {
            return Date.class;
        }

        if (TYPE_URI.equals(type)) {
            return URI.class;
        }

        throw new ExecutionException("It dosen't support to read the contract with the type:\'" + type + "\' in ant script directly, please read it in the task class.");
    }
}
