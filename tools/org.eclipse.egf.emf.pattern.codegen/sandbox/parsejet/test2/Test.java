/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package parsejet.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;

/**
 * @author Matthieu Helleboid
 * 
 */
public class Test {

    class EGFMarkChars {

        public EGFMarkChars(String string) {
        }

    }
    class EGFMarkStart {

        public EGFMarkStart() {
        }

    }
    class EGFMarkEnd {

        public EGFMarkEnd() {
        }

    }

    class EGFMarkInclude {

        public EGFMarkInclude(String string) {
        }

    }

    class EGFMarkIncludeSilent {

        public EGFMarkIncludeSilent(String string) {
        }

    }

    class EGFMarkExpression {

        public EGFMarkExpression(String string, String string2) {
        }

    }

    class EGFMarkIncludeAlternative {

        public EGFMarkIncludeAlternative(String string) {
        }

    }

    void main(Object argument, StringBuffer stringBuffer) {

        new EGFMarkChars("0");

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2007 IBM Corporation and others.
         * This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v2.0
         * which accompanies this distribution, and is available at
         * https://www.eclipse.org/legal/epl-2.0
         *
         * SPDX-License-Identifier: EPL-2.0
         *
         * Contributors:
         *   IBM - Initial API and implementation
         *
         * </copyright>
         */

        new EGFMarkChars("1");
        final GenClass genClass = (GenClass)((Object[])argument)[0]; final GenPackage genPackage = genClass.getGenPackage(); final GenModel genModel=genPackage.getGenModel();
        new EGFMarkChars("2");
        final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
        new EGFMarkChars("3");
        final boolean isInterface = Boolean.TRUE.equals(((Object[])argument)[1]); final boolean isImplementation = Boolean.TRUE.equals(((Object[])argument)[2]);
        new EGFMarkChars("4");
        final String publicStaticFinalFlag = isImplementation ? "public static final " : "";
        new EGFMarkChars("5");
        final String singleWildcard = isJDK50 ? "<?>" : "";
        new EGFMarkChars("6");
        final String negativeOffsetCorrection = genClass.hasOffsetCorrection() ? " - " + genClass.getOffsetCorrectionField(null) : "";
        new EGFMarkChars("7");
        final String positiveOffsetCorrection = genClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(null) : "";
        new EGFMarkChars("8");
        new EGFMarkInclude("../Header.javajetinc");
        new EGFMarkChars("9");
        if (isInterface) {
        new EGFMarkChars("10");
        new EGFMarkExpression("1531","1567");
        new EGFMarkChars("11");
        } else {
        new EGFMarkChars("12");
        new EGFMarkExpression("1595","1627");
        new EGFMarkChars("13");
        }
        new EGFMarkChars("14");
        genModel.markImportLocation(stringBuffer, genPackage);
        new EGFMarkChars("15");
        if (isImplementation) { genClass.addClassPsuedoImports(); }
        new EGFMarkChars("16");
        if (isInterface) {
        new EGFMarkChars("17");
        new EGFMarkExpression("1867","1894");
        new EGFMarkChars("18");
        if (genClass.hasDocumentation()) {
        new EGFMarkChars("19");
        new EGFMarkExpression("2009","2073");
        new EGFMarkChars("20");
        }
        new EGFMarkChars("21");
        if (!genClass.getGenFeatures().isEmpty()) {
        new EGFMarkChars("22");
        for (GenFeature genFeature : genClass.getGenFeatures()) {
        new EGFMarkChars("23");
        if (!genFeature.isSuppressedGetVisibility()) {
        new EGFMarkChars("24");
        new EGFMarkExpression("2349","2385");
        new EGFMarkChars("25");
        new EGFMarkExpression("2391","2418");
        new EGFMarkChars("26");
        new EGFMarkExpression("2428","2457");
        new EGFMarkChars("27");
        }
        new EGFMarkChars("28");
        }
        new EGFMarkChars("29");
        }
        new EGFMarkChars("30");
        if (!genModel.isSuppressEMFMetaData()) {
        new EGFMarkChars("31");
        new EGFMarkExpression("2567","2612");
        new EGFMarkChars("32");
        new EGFMarkExpression("2621","2657");
        new EGFMarkChars("33");
        }
        new EGFMarkChars("34");
        if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
        new EGFMarkChars("35");
        new EGFMarkExpression("2955","2964");
        new EGFMarkChars("36");
        } else {
        new EGFMarkChars("37");
        new EGFMarkExpression("2993","3002");
        new EGFMarkChars("38");
        }} if (first) {
        new EGFMarkChars("39");
        }}
        new EGFMarkChars("40");
        if (genClass.needsRootExtendsInterfaceExtendsTag()) {
        new EGFMarkChars("41");
        new EGFMarkExpression("3115","3175");
        new EGFMarkChars("42");
        }
        new EGFMarkChars("43");
        } else {
        new EGFMarkChars("44");
        new EGFMarkExpression("3298","3325");
        new EGFMarkChars("45");
        if (!genClass.getImplementedGenFeatures().isEmpty()) {
        new EGFMarkChars("46");
        for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
        new EGFMarkChars("47");
        new EGFMarkExpression("3573","3605");
        new EGFMarkChars("48");
        new EGFMarkExpression("3611","3638");
        new EGFMarkChars("49");
        new EGFMarkExpression("3648","3677");
        new EGFMarkChars("50");
        }
        new EGFMarkChars("51");
        }
        new EGFMarkChars("52");
        }
        new EGFMarkChars("53");
        if (isImplementation) {
        new EGFMarkChars("54");
        if (genClass.isAbstract()) {
        new EGFMarkChars("55");
        }
        new EGFMarkChars("56");
        new EGFMarkExpression("3837","3860");
        new EGFMarkExpression("3865","3900");
        new EGFMarkExpression("3905","3931");
        new EGFMarkExpression("3936","3965");
        new EGFMarkChars("57");
        } else {
        new EGFMarkChars("58");
        new EGFMarkExpression("4001","4028");
        new EGFMarkExpression("4033","4068");
        new EGFMarkExpression("4073","4103");
        new EGFMarkChars("59");
        }
        new EGFMarkChars("60");
        if (genModel.hasCopyrightField()) {
        new EGFMarkChars("61");
        new EGFMarkExpression("4237","4258");
        new EGFMarkExpression("4263","4307");
        new EGFMarkChars("62");
        new EGFMarkExpression("4325","4360");
        new EGFMarkChars("63");
        new EGFMarkExpression("4366","4386");
        new EGFMarkChars("64");
        }
        new EGFMarkChars("65");
        if (isImplementation && genModel.getDriverNumber() != null) {
        new EGFMarkChars("66");
        new EGFMarkExpression("4565","4609");
        new EGFMarkChars("67");
        new EGFMarkExpression("4634","4660");
        new EGFMarkChars("68");
        new EGFMarkExpression("4667","4687");
        new EGFMarkChars("69");
        }
        new EGFMarkChars("70");
        if (isImplementation && genClass.isJavaIOSerializable()) {
        new EGFMarkChars("71");
        }
        new EGFMarkChars("72");
        if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
        new EGFMarkChars("73");
        if (eVirtualValuesField != null) {
        new EGFMarkChars("74");
        new EGFMarkExpression("5240","5259");
        new EGFMarkChars("75");
        }
        new EGFMarkChars("76");
        { List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
        new EGFMarkChars("77");
        if (!eVirtualIndexBitFields.isEmpty()) {
        new EGFMarkChars("78");
        for (String eVirtualIndexBitField : eVirtualIndexBitFields) {
        new EGFMarkChars("79");
        new EGFMarkExpression("5671","5692");
        new EGFMarkChars("80");
        }
        new EGFMarkChars("81");
        }
        new EGFMarkChars("82");
        }
        new EGFMarkChars("83");
        }
        new EGFMarkChars("84");
        if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
        new EGFMarkChars("85");
        new EGFMarkExpression("6097","6128");
        new EGFMarkChars("86");
        }
        new EGFMarkChars("87");
        if (isImplementation && !genModel.isReflectiveDelegation()) {
        new EGFMarkChars("88");
        for (GenFeature genFeature : genClass.getDeclaredFieldGenFeatures()) {
        new EGFMarkChars("89");
        new EGFMarkIncludeAlternative("Class/declaredFieldGenFeature.override.javajetinc");
        new EGFMarkChars("90");
        new EGFMarkStart();
        new EGFMarkChars("91");
        if (genFeature.isListType() || genFeature.isReferenceType()) {
        new EGFMarkChars("92");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("93");
        new EGFMarkExpression("6552","6579");
        new EGFMarkChars("94");
        new EGFMarkExpression("6591","6620");
        new EGFMarkChars("95");
        new EGFMarkExpression("6633","6660");
        new EGFMarkChars("96");
        new EGFMarkExpression("6731","6758");
        new EGFMarkChars("97");
        new EGFMarkExpression("6810","6854");
        new EGFMarkChars("98");
        new EGFMarkExpression("6860","6884");
        new EGFMarkChars("99");
        }
        new EGFMarkChars("100");
        if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) { String rawListItemType = genFeature.getRawListItemType(); int index = rawListItemType.indexOf('['); String head = rawListItemType; String tail = ""; if (index != -1) { head = rawListItemType.substring(0, index); tail = rawListItemType.substring(index); } 
        new EGFMarkChars("101");
        new EGFMarkExpression("7335","7367");
        new EGFMarkChars("102");
        new EGFMarkExpression("7379","7408");
        new EGFMarkChars("103");
        new EGFMarkExpression("7501","7533");
        new EGFMarkChars("104");
        if (genFeature.getQualifiedListItemType(genClass).contains("<")) {
        new EGFMarkChars("105");
        }
        new EGFMarkChars("106");
        new EGFMarkExpression("7723","7738");
        new EGFMarkChars("107");
        new EGFMarkExpression("7746","7771");
        new EGFMarkChars("108");
        new EGFMarkExpression("7796","7800");
        new EGFMarkChars("109");
        new EGFMarkExpression("7809","7813");
        new EGFMarkChars("110");
        }
        new EGFMarkChars("111");
        } else {
        new EGFMarkChars("112");
        if (genFeature.hasEDefault() && (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable()))) { String staticDefaultValue = genFeature.getStaticDefaultValue();
        new EGFMarkChars("113");
        new EGFMarkExpression("8135","8162");
        new EGFMarkChars("114");
        new EGFMarkExpression("8174","8203");
        new EGFMarkChars("115");
        new EGFMarkExpression("8216","8243");
        new EGFMarkChars("116");
        new EGFMarkExpression("8314","8341");
        new EGFMarkChars("117");
        if (genModel.useGenerics() && genFeature.isListDataType() && genFeature.isSetDefaultValue()) {
        new EGFMarkChars("118");
        }
        new EGFMarkChars("119");
        new EGFMarkExpression("8559","8595");
        new EGFMarkChars("120");
        new EGFMarkExpression("8601","8625");
        if ("".equals(staticDefaultValue)) {
        new EGFMarkChars("121");
        new EGFMarkExpression("8707","8760");
        new EGFMarkChars("122");
        } else {
        new EGFMarkChars("123");
        new EGFMarkExpression("8795","8813");
        new EGFMarkChars("124");
        new EGFMarkExpression("8819","8857");
        }
        new EGFMarkChars("125");
        }
        new EGFMarkChars("126");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("127");
        if (genClass.isFlag(genFeature)) { int flagIndex = genClass.getFlagIndex(genFeature);
        new EGFMarkChars("128");
        if (flagIndex > 31 && flagIndex % 32 == 0) {
        new EGFMarkChars("129");
        new EGFMarkExpression("9319","9353");
        new EGFMarkChars("130");
        }
        new EGFMarkChars("131");
        if (genFeature.isEnumType()) {
        new EGFMarkChars("132");
        new EGFMarkExpression("9498","9525");
        new EGFMarkChars("133");
        new EGFMarkExpression("9537","9566");
        new EGFMarkChars("134");
        new EGFMarkExpression("9579","9606");
        new EGFMarkChars("135");
        new EGFMarkExpression("9728","9753");
        new EGFMarkChars("136");
        new EGFMarkExpression("9774","9788");
        new EGFMarkChars("137");
        new EGFMarkExpression("9862","9889");
        new EGFMarkChars("138");
        new EGFMarkExpression("9901","9930");
        new EGFMarkChars("139");
        new EGFMarkExpression("9943","9970");
        new EGFMarkChars("140");
        new EGFMarkExpression("10092","10117");
        new EGFMarkChars("141");
        if (isJDK50) {
        new EGFMarkExpression("10157","10181");
        new EGFMarkChars("142");
        } else {
        new EGFMarkExpression("10208","10244");
        new EGFMarkChars("143");
        new EGFMarkExpression("10265","10289");
        new EGFMarkChars("144");
        }
        new EGFMarkChars("145");
        new EGFMarkExpression("10304","10329");
        new EGFMarkChars("146");
        new EGFMarkExpression("10403","10439");
        new EGFMarkChars("147");
        new EGFMarkExpression("10445","10497");
        new EGFMarkChars("148");
        new EGFMarkExpression("10614","10650");
        new EGFMarkChars("149");
        new EGFMarkExpression("10658","10683");
        new EGFMarkChars("150");
        if (isJDK50) {
        new EGFMarkExpression("10722","10758");
        new EGFMarkChars("151");
        } else {
        new EGFMarkChars("152");
        new EGFMarkExpression("10785","10821");
        new EGFMarkChars("153");
        new EGFMarkExpression("10829","10865");
        new EGFMarkChars("154");
        new EGFMarkExpression("10890","10926");
        new EGFMarkChars("155");
        new EGFMarkExpression("10932","10968");
        new EGFMarkChars("156");
        }
        new EGFMarkChars("157");
        }
        new EGFMarkChars("158");
        new EGFMarkExpression("11030","11077");
        new EGFMarkChars("159");
        new EGFMarkExpression("11122","11149");
        new EGFMarkChars("160");
        new EGFMarkExpression("11161","11190");
        new EGFMarkChars("161");
        new EGFMarkExpression("11203","11230");
        new EGFMarkChars("162");
        new EGFMarkExpression("11301","11328");
        new EGFMarkChars("163");
        new EGFMarkExpression("11397","11422");
        new EGFMarkChars("164");
        new EGFMarkExpression("11436","11468");
        new EGFMarkChars("165");
        if (genFeature.isEnumType()) {
        new EGFMarkExpression("11511","11536");
        new EGFMarkChars("166");
        } else {
        new EGFMarkExpression("11566","11580");
        }
        new EGFMarkChars("167");
        } else {
        new EGFMarkChars("168");
        new EGFMarkExpression("11656","11683");
        new EGFMarkChars("169");
        new EGFMarkExpression("11695","11724");
        new EGFMarkChars("170");
        new EGFMarkExpression("11737","11764");
        new EGFMarkChars("171");
        new EGFMarkExpression("11835","11862");
        new EGFMarkChars("172");
        new EGFMarkExpression("11914","11950");
        new EGFMarkChars("173");
        new EGFMarkExpression("11956","11980");
        if (genFeature.hasEDefault()) {
        new EGFMarkChars("174");
        new EGFMarkExpression("12023","12047");
        }
        new EGFMarkChars("175");
        }
        new EGFMarkChars("176");
        }
        new EGFMarkChars("177");
        }
        new EGFMarkChars("178");
        if (genClass.isESetField(genFeature)) {
        new EGFMarkChars("179");
        if (genClass.isESetFlag(genFeature)) { int flagIndex = genClass.getESetFlagIndex(genFeature);
        new EGFMarkChars("180");
        if (flagIndex > 31 && flagIndex % 32 == 0) {
        new EGFMarkChars("181");
        new EGFMarkExpression("12540","12578");
        new EGFMarkChars("182");
        }
        new EGFMarkChars("183");
        new EGFMarkExpression("12647","12676");
        new EGFMarkChars("184");
        new EGFMarkExpression("12682","12709");
        new EGFMarkChars("185");
        new EGFMarkExpression("12844","12869");
        new EGFMarkChars("186");
        new EGFMarkExpression("12891","12906");
        new EGFMarkChars("187");
        } else {
        new EGFMarkChars("188");
        new EGFMarkExpression("12962","12991");
        new EGFMarkChars("189");
        new EGFMarkExpression("12997","13024");
        new EGFMarkChars("190");
        new EGFMarkExpression("13150","13175");
        new EGFMarkChars("191");
        }
        new EGFMarkChars("192");
        }
        new EGFMarkChars("193");
        new EGFMarkIncludeSilent("Class/declaredFieldGenFeature.insert.javajetinc");
        new EGFMarkChars("194");
        new EGFMarkEnd();
        //Class/declaredFieldGenFeature.override.javajetinc
        new EGFMarkChars("195");
        }
        new EGFMarkChars("196");
        }
        new EGFMarkChars("197");
        if (isImplementation && genClass.hasOffsetCorrection() && !genClass.getImplementedGenFeatures().isEmpty()) {
        new EGFMarkChars("198");
        new EGFMarkExpression("13591","13630");
        new EGFMarkChars("199");
        new EGFMarkExpression("13638","13679");
        new EGFMarkChars("200");
        new EGFMarkExpression("13698","13771");
        new EGFMarkChars("201");
        new EGFMarkExpression("13780","13855");
        new EGFMarkChars("202");
        }
        new EGFMarkChars("203");
        if (isImplementation && genClass.hasOffsetCorrection() && !genModel.isReflectiveDelegation()) {
        new EGFMarkChars("204");
        for (GenFeature genFeature : genClass.getImplementedGenFeatures()) { GenFeature reverseFeature = genFeature.getReverse();
        new EGFMarkChars("205");
        if (reverseFeature != null && reverseFeature.getGenClass().hasOffsetCorrection()) {
        new EGFMarkChars("206");
        new EGFMarkExpression("14294","14339");
        new EGFMarkChars("207");
        new EGFMarkExpression("14347","14408");
        new EGFMarkChars("208");
        new EGFMarkExpression("14427","14471");
        new EGFMarkChars("209");
        new EGFMarkExpression("14480","14546");
        new EGFMarkChars("210");
        }
        new EGFMarkChars("211");
        }
        new EGFMarkChars("212");
        }
        new EGFMarkChars("213");
        if (isImplementation) {
        new EGFMarkChars("214");
        if (genModel.isPublicConstructors()) {
        new EGFMarkChars("215");
        } else {
        new EGFMarkChars("216");
        }
        new EGFMarkChars("217");
        new EGFMarkExpression("14761","14784");
        new EGFMarkChars("218");
        for (GenFeature genFeature : genClass.getFlagGenFeaturesWithDefault()) {
        new EGFMarkChars("219");
        new EGFMarkExpression("14887","14921");
        new EGFMarkChars("220");
        new EGFMarkExpression("14930","14955");
        new EGFMarkChars("221");
        if (!genFeature.isBooleanType()) {
        new EGFMarkChars("222");
        }
        new EGFMarkChars("223");
        }
        new EGFMarkChars("224");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("225");
        }
        new EGFMarkChars("226");
        new EGFMarkExpression("15191","15247");
        new EGFMarkChars("227");
        new EGFMarkExpression("15280","15321");
        new EGFMarkChars("228");
        }
        new EGFMarkChars("229");
        new EGFMarkIncludeAlternative("Class/reflectiveDelegation.override.javajetinc");
        new EGFMarkChars("230");
        new EGFMarkStart();
        new EGFMarkChars("231");
        if (isImplementation && (genModel.getFeatureDelegation() == GenDelegationKind.REFLECTIVE_LITERAL || genModel.isDynamicDelegation()) && (genClass.getClassExtendsGenClass() == null || (genClass.getClassExtendsGenClass().getGenModel().getFeatureDelegation() != GenDelegationKind.REFLECTIVE_LITERAL && !genClass.getClassExtendsGenClass().getGenModel().isDynamicDelegation()))) {
        new EGFMarkChars("232");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("233");
        }
        new EGFMarkChars("234");
        new EGFMarkExpression("16016","16126");
        new EGFMarkChars("235");
        }
        new EGFMarkChars("236");
        new EGFMarkEnd();
        //Class/reflectiveDelegation.override.javajetinc
        new EGFMarkChars("237");
        new Runnable() { public void run() {
        new EGFMarkChars("238");
        for (GenFeature genFeature : (isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures())) {
        new EGFMarkChars("239");
        new EGFMarkIncludeAlternative("Class/genFeature.override.javajetinc");
        new EGFMarkChars("240");
        new EGFMarkStart();
        new EGFMarkChars("241");
        if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
        new EGFMarkChars("242");
        if (!isImplementation) {
        new EGFMarkChars("243");
        new EGFMarkExpression("16710","16746");
        new EGFMarkChars("244");
        new EGFMarkExpression("16754","16786");
        new EGFMarkChars("245");
        } else {
        new EGFMarkChars("246");
        new EGFMarkExpression("16821","16857");
        new EGFMarkChars("247");
        new EGFMarkExpression("16865","16897");
        new EGFMarkChars("248");
        if (genFeature.isVolatile()) {
        new EGFMarkChars("249");
        new EGFMarkExpression("16951","17017");
        new EGFMarkExpression("17022","17067");
        new EGFMarkChars("250");
        new EGFMarkExpression("17081","17147");
        new EGFMarkExpression("17152","17197");
        new EGFMarkChars("251");
        new EGFMarkExpression("17203","17230");
        new EGFMarkChars("252");
        if (genModel.useGenerics() && !genFeature.getListItemType(genClass).contains("<") && !genFeature.getListItemType(null).equals(genFeature.getListItemType(genClass))) {
        new EGFMarkChars("253");
        new EGFMarkExpression("17439","17475");
        new EGFMarkChars("254");
        }
        new EGFMarkExpression("17488","17513");
        new EGFMarkChars("255");
        } else {
        new EGFMarkChars("256");
        new EGFMarkExpression("17558","17582");
        new EGFMarkChars("257");
        new EGFMarkExpression("17599","17623");
        new EGFMarkChars("258");
        if (genModel.useGenerics() && !genFeature.getListItemType(genClass).contains("<") && !genFeature.getListItemType(null).equals(genFeature.getListItemType(genClass))) {
        new EGFMarkChars("259");
        new EGFMarkExpression("17818","17854");
        new EGFMarkChars("260");
        }
        new EGFMarkExpression("17867","17892");
        new EGFMarkChars("261");
        new EGFMarkExpression("17914","17980");
        new EGFMarkExpression("17985","18030");
        new EGFMarkChars("262");
        new EGFMarkExpression("18044","18110");
        new EGFMarkExpression("18115","18160");
        new EGFMarkChars("263");
        new EGFMarkExpression("18166","18190");
        new EGFMarkChars("264");
        }
        new EGFMarkChars("265");
        new EGFMarkExpression("18236","18272");
        new EGFMarkChars("266");
        }
        new EGFMarkChars("267");
        if (!isImplementation) {
        new EGFMarkChars("268");
        new EGFMarkExpression("18420","18456");
        new EGFMarkChars("269");
        new EGFMarkExpression("18465","18493");
        new EGFMarkChars("270");
        } else {
        new EGFMarkChars("271");
        new EGFMarkExpression("18537","18573");
        new EGFMarkChars("272");
        new EGFMarkExpression("18582","18610");
        new EGFMarkChars("273");
        if (!genModel.useGenerics()) {
        new EGFMarkChars("274");
        new EGFMarkExpression("18674","18710");
        new EGFMarkChars("275");
        }
        new EGFMarkExpression("18721","18748");
        new EGFMarkChars("276");
        }
        new EGFMarkChars("277");
        if (!isImplementation) {
        new EGFMarkChars("278");
        new EGFMarkExpression("18902","18930");
        new EGFMarkChars("279");
        } else {
        new EGFMarkChars("280");
        new EGFMarkExpression("18978","19006");
        new EGFMarkChars("281");
        if (genFeature.isVolatile()) {
        new EGFMarkChars("282");
        new EGFMarkExpression("19073","19100");
        new EGFMarkChars("283");
        } else {
        new EGFMarkChars("284");
        new EGFMarkExpression("19144","19168");
        new EGFMarkChars("285");
        new EGFMarkExpression("19188","19212");
        new EGFMarkChars("286");
        }
        new EGFMarkChars("287");
        }
        new EGFMarkChars("288");
        if (!isImplementation) {
        new EGFMarkChars("289");
        new EGFMarkExpression("19373","19401");
        new EGFMarkChars("290");
        new EGFMarkExpression("19407","19443");
        new EGFMarkChars("291");
        new EGFMarkExpression("19454","19477");
        new EGFMarkChars("292");
        } else {
        new EGFMarkChars("293");
        new EGFMarkExpression("19519","19547");
        new EGFMarkChars("294");
        new EGFMarkExpression("19553","19589");
        new EGFMarkChars("295");
        new EGFMarkExpression("19600","19623");
        new EGFMarkChars("296");
        new EGFMarkExpression("19637","19703");
        new EGFMarkExpression("19708","19753");
        new EGFMarkChars("297");
        new EGFMarkExpression("19759","19786");
        new EGFMarkChars("298");
        new EGFMarkExpression("19806","19829");
        new EGFMarkChars("299");
        new EGFMarkExpression("19846","19869");
        new EGFMarkChars("300");
        }
        new EGFMarkChars("301");
        if (!isImplementation) {
        new EGFMarkChars("302");
        new EGFMarkExpression("20012","20040");
        new EGFMarkChars("303");
        new EGFMarkExpression("20057","20093");
        new EGFMarkChars("304");
        } else {
        new EGFMarkChars("305");
        new EGFMarkExpression("20143","20171");
        new EGFMarkChars("306");
        new EGFMarkExpression("20188","20224");
        new EGFMarkChars("307");
        new EGFMarkExpression("20244","20271");
        new EGFMarkChars("308");
        }
        new EGFMarkChars("309");
        }
        new EGFMarkChars("310");
        if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
        new EGFMarkChars("311");
        new EGFMarkIncludeAlternative("Class/getGenFeature.override.javajetinc");
        new EGFMarkChars("312");
        new EGFMarkStart();
        new EGFMarkChars("313");
        if (isInterface) {
        new EGFMarkChars("314");
        new EGFMarkIncludeAlternative("Class/getGenFeature.javadoc.override.javajetinc");
        new EGFMarkChars("315");
        new EGFMarkStart();
        new EGFMarkChars("316");
        new EGFMarkExpression("20680","20709");
        new EGFMarkChars("317");
        new EGFMarkExpression("20725","20752");
        new EGFMarkChars("318");
        if (genFeature.isListType()) {
        new EGFMarkChars("319");
        if (genFeature.isMapType()) { GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature(); GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature(); 
        new EGFMarkChars("320");
        if (keyFeature.isListType()) {
        new EGFMarkChars("321");
        new EGFMarkExpression("21087","21132");
        new EGFMarkChars("322");
        } else {
        new EGFMarkChars("323");
        new EGFMarkExpression("21157","21185");
        new EGFMarkChars("324");
        }
        new EGFMarkChars("325");
        if (valueFeature.isListType()) {
        new EGFMarkChars("326");
        new EGFMarkExpression("21278","21325");
        new EGFMarkChars("327");
        } else {
        new EGFMarkChars("328");
        new EGFMarkExpression("21350","21380");
        new EGFMarkChars("329");
        }
        new EGFMarkChars("330");
        } else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType(genClass)))) {
        String typeName = genFeature.getQualifiedListItemType(genClass); String head = typeName; String tail = ""; int index = typeName.indexOf('<'); if (index == -1) { index = typeName.indexOf('['); } 
        if (index != -1) { head = typeName.substring(0, index); tail = typeName.substring(index).replaceAll("<", "&lt;"); }

        new EGFMarkChars("331");
        new EGFMarkExpression("21936","21940");
        new EGFMarkChars("332");
        new EGFMarkExpression("21946","21950");
        new EGFMarkChars("333");
        }
        new EGFMarkChars("334");
        } else if (genFeature.isSetDefaultValue()) {
        new EGFMarkChars("335");
        new EGFMarkExpression("22053","22081");
        new EGFMarkChars("336");
        }
        new EGFMarkChars("337");
        if (genFeature.getTypeGenEnum() != null) {
        new EGFMarkChars("338");
        new EGFMarkExpression("22205","22251");
        new EGFMarkChars("339");
        }
        new EGFMarkChars("340");
        if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
        new EGFMarkChars("341");
        if (!reverseGenFeature.isSuppressedGetVisibility()) {
        new EGFMarkChars("342");
        new EGFMarkExpression("22541","22600");
        new EGFMarkChars("343");
        new EGFMarkExpression("22606","22640");
        new EGFMarkChars("344");
        new EGFMarkExpression("22650","22686");
        new EGFMarkChars("345");
        }
        new EGFMarkChars("346");
        }
        new EGFMarkChars("347");
        new EGFMarkIncludeSilent("Class/getGenFeature.javadoc.insert.javajetinc");
        new EGFMarkChars("348");
        if (!genFeature.hasDocumentation()) {
        new EGFMarkChars("349");
        new EGFMarkExpression("22917","22946");
        new EGFMarkChars("350");
        new EGFMarkExpression("22958","22985");
        new EGFMarkChars("351");
        }
        new EGFMarkChars("352");
        if (genFeature.hasDocumentation()) {
        new EGFMarkChars("353");
        new EGFMarkExpression("23184","23250");
        new EGFMarkChars("354");
        }
        new EGFMarkChars("355");
        new EGFMarkExpression("23327","23356");
        new EGFMarkChars("356");
        new EGFMarkExpression("23368","23395");
        new EGFMarkChars("357");
        if (genFeature.getTypeGenEnum() != null) {
        new EGFMarkChars("358");
        new EGFMarkExpression("23462","23508");
        new EGFMarkChars("359");
        }
        new EGFMarkChars("360");
        if (genFeature.isUnsettable()) {
        new EGFMarkChars("361");
        if (!genFeature.isSuppressedIsSetVisibility()) {
        new EGFMarkChars("362");
        new EGFMarkExpression("23639","23667");
        new EGFMarkChars("363");
        }
        new EGFMarkChars("364");
        if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
        new EGFMarkChars("365");
        new EGFMarkExpression("23790","23818");
        new EGFMarkChars("366");
        }
        new EGFMarkChars("367");
        }
        new EGFMarkChars("368");
        if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
        new EGFMarkChars("369");
        new EGFMarkExpression("23973","24001");
        new EGFMarkChars("370");
        new EGFMarkExpression("24007","24043");
        new EGFMarkChars("371");
        }
        new EGFMarkChars("372");
        if (!genModel.isSuppressEMFMetaData()) {
        new EGFMarkChars("373");
        new EGFMarkExpression("24118","24163");
        new EGFMarkChars("374");
        new EGFMarkExpression("24172","24207");
        new EGFMarkChars("375");
        }
        new EGFMarkChars("376");
        if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
        new EGFMarkChars("377");
        if (!reverseGenFeature.isSuppressedGetVisibility()) {
        new EGFMarkChars("378");
        new EGFMarkExpression("24454","24513");
        new EGFMarkChars("379");
        new EGFMarkExpression("24519","24553");
        new EGFMarkChars("380");
        }
        new EGFMarkChars("381");
        }
        new EGFMarkChars("382");
        if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
        new EGFMarkChars("383");
        new EGFMarkExpression("24872","24881");
        new EGFMarkChars("384");
        } else {
        new EGFMarkChars("385");
        new EGFMarkExpression("24915","24924");
        new EGFMarkChars("386");
        }} if (first) {
        new EGFMarkChars("387");
        }}
        new EGFMarkChars("388");
        new EGFMarkEnd();
        //Class/getGenFeature.javadoc.override.javajetinc
        new EGFMarkChars("389");
        } else {
        new EGFMarkChars("390");
        if (isJDK50) { //Class/getGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("391");
        new EGFMarkIncludeSilent("Class/getGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("392");
        }
        new EGFMarkChars("393");
        }
        new EGFMarkChars("394");
        if (!isImplementation) {
        new EGFMarkChars("395");
        new EGFMarkExpression("25351","25387");
        new EGFMarkChars("396");
        new EGFMarkExpression("25393","25420");
        new EGFMarkChars("397");
        } else {
        new EGFMarkChars("398");
        if (genModel.useGenerics() && ((genFeature.isContainer() || genFeature.isResolveProxies()) && !genFeature.isListType() && !(genModel.isReflectiveDelegation() && genModel.isDynamicDelegation()) && genFeature.isUncheckedCast(genClass) || genFeature.isListType() && !genFeature.isFeatureMapType() && (genModel.isReflectiveDelegation() || genModel.isVirtualDelegation() || genModel.isDynamicDelegation()) || genFeature.isListDataType() && genFeature.hasDelegateFeature())) {
        new EGFMarkChars("399");
        }
        new EGFMarkChars("400");
        new EGFMarkExpression("25968","26004");
        new EGFMarkChars("401");
        new EGFMarkExpression("26010","26037");
        if (genClass.hasCollidingGetAccessorOperation(genFeature)) {
        new EGFMarkChars("402");
        }
        new EGFMarkChars("403");
        new EGFMarkIncludeSilent("Class/getGenFeature.pre.insert.javajetinc");
        new EGFMarkChars("404");
        if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("405");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("406");
        }
        new EGFMarkChars("407");
        new EGFMarkExpression("26309","26343");
        new EGFMarkChars("408");
        new EGFMarkExpression("26361","26403");
        new EGFMarkChars("409");
        new EGFMarkExpression("26410","26450");
        new EGFMarkChars("410");
        new EGFMarkExpression("26463","26504");
        new EGFMarkChars("411");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("412");
        new EGFMarkExpression("26563","26601");
        new EGFMarkChars("413");
        }
        new EGFMarkChars("414");
        } else if (genModel.isReflectiveDelegation()) {
        new EGFMarkChars("415");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("416");
        }
        new EGFMarkChars("417");
        new EGFMarkExpression("26738","26772");
        new EGFMarkChars("418");
        new EGFMarkExpression("26783","26823");
        new EGFMarkChars("419");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("420");
        new EGFMarkExpression("26888","26926");
        new EGFMarkChars("421");
        }
        new EGFMarkChars("422");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("423");
        if (genFeature.isListType()) {
        new EGFMarkChars("424");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("425");
        new EGFMarkExpression("27080","27116");
        new EGFMarkChars("426");
        new EGFMarkExpression("27122","27146");
        new EGFMarkChars("427");
        new EGFMarkExpression("27155","27191");
        new EGFMarkChars("428");
        new EGFMarkExpression("27209","27251");
        new EGFMarkExpression("27256","27280");
        new EGFMarkChars("429");
        }
        new EGFMarkChars("430");
        new EGFMarkExpression("27308","27332");
        new EGFMarkChars("431");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("432");
        new EGFMarkExpression("27416","27458");
        new EGFMarkExpression("27463","27487");
        new EGFMarkChars("433");
        new EGFMarkExpression("27494","27518");
        new EGFMarkChars("434");
        new EGFMarkExpression("27530","27569");
        new EGFMarkChars("435");
        } else {
        new EGFMarkChars("436");
        new EGFMarkExpression("27601","27625");
        new EGFMarkChars("437");
        new EGFMarkExpression("27637","27676");
        new EGFMarkChars("438");
        }
        new EGFMarkChars("439");
        new EGFMarkExpression("27710","27734");
        new EGFMarkExpression("27739","27821");
        new EGFMarkChars("440");
        } else if (genFeature.isContainer()) {
        new EGFMarkChars("441");
        new EGFMarkExpression("27908","27950");
        new EGFMarkExpression("27955","27979");
        new EGFMarkChars("442");
        new EGFMarkExpression("28009","28045");
        new EGFMarkChars("443");
        } else {
        new EGFMarkChars("444");
        if (genFeature.isResolveProxies()) {
        new EGFMarkChars("445");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("446");
        new EGFMarkExpression("28187","28223");
        new EGFMarkChars("447");
        new EGFMarkExpression("28229","28253");
        new EGFMarkChars("448");
        new EGFMarkExpression("28262","28298");
        new EGFMarkChars("449");
        new EGFMarkExpression("28316","28358");
        new EGFMarkExpression("28363","28387");
        if (genFeature.hasEDefault()) {
        new EGFMarkChars("450");
        new EGFMarkExpression("28429","28453");
        }
        new EGFMarkChars("451");
        }
        new EGFMarkChars("452");
        new EGFMarkExpression("28488","28512");
        new EGFMarkChars("453");
        new EGFMarkExpression("28529","28562");
        new EGFMarkChars("454");
        new EGFMarkExpression("28587","28652");
        new EGFMarkChars("455");
        new EGFMarkExpression("28661","28684");
        new EGFMarkChars("456");
        new EGFMarkExpression("28693","28758");
        new EGFMarkChars("457");
        new EGFMarkExpression("28764","28788");
        new EGFMarkChars("458");
        new EGFMarkExpression("28798","28822");
        new EGFMarkChars("459");
        new EGFMarkExpression("28830","28880");
        new EGFMarkChars("460");
        new EGFMarkExpression("28902","28925");
        new EGFMarkChars("461");
        new EGFMarkExpression("28940","28964");
        new EGFMarkChars("462");
        new EGFMarkExpression("28976","28999");
        new EGFMarkChars("463");
        if (genFeature.isEffectiveContains()) {
        new EGFMarkChars("464");
        new EGFMarkExpression("29069","29134");
        new EGFMarkChars("465");
        new EGFMarkExpression("29143","29166");
        new EGFMarkChars("466");
        new EGFMarkExpression("29175","29240");
        new EGFMarkChars("467");
        new EGFMarkExpression("29246","29270");
        new EGFMarkChars("468");
        if (!genFeature.isBidirectional()) {
        new EGFMarkChars("469");
        new EGFMarkExpression("29332","29407");
        new EGFMarkChars("470");
        new EGFMarkExpression("29423","29446");
        new EGFMarkChars("471");
        new EGFMarkExpression("29498","29540");
        new EGFMarkExpression("29545","29569");
        new EGFMarkChars("472");
        } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("473");
        new EGFMarkExpression("29855","29930");
        new EGFMarkChars("474");
        new EGFMarkExpression("29947","29970");
        new EGFMarkChars("475");
        new EGFMarkExpression("29997","30046");
        new EGFMarkExpression("30051","30074");
        new EGFMarkChars("476");
        new EGFMarkExpression("30081","30122");
        new EGFMarkChars("477");
        }
        new EGFMarkChars("478");
        new EGFMarkExpression("30169","30192");
        new EGFMarkChars("479");
        if (!genFeature.isBidirectional()) {
        new EGFMarkChars("480");
        new EGFMarkExpression("30300","30323");
        new EGFMarkChars("481");
        new EGFMarkExpression("30372","30414");
        new EGFMarkExpression("30419","30443");
        new EGFMarkChars("482");
        } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("483");
        new EGFMarkExpression("30741","30764");
        new EGFMarkChars("484");
        new EGFMarkExpression("30788","30837");
        new EGFMarkExpression("30842","30865");
        new EGFMarkChars("485");
        new EGFMarkExpression("30872","30913");
        new EGFMarkChars("486");
        }
        new EGFMarkChars("487");
        } else if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("488");
        new EGFMarkExpression("31069","31111");
        new EGFMarkExpression("31116","31140");
        new EGFMarkChars("489");
        new EGFMarkExpression("31147","31171");
        new EGFMarkChars("490");
        }
        new EGFMarkChars("491");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("492");
        new EGFMarkExpression("31301","31373");
        new EGFMarkChars("493");
        new EGFMarkExpression("31385","31455");
        new EGFMarkChars("494");
        new EGFMarkExpression("31470","31512");
        new EGFMarkExpression("31517","31541");
        new EGFMarkChars("495");
        new EGFMarkExpression("31551","31574");
        new EGFMarkChars("496");
        new EGFMarkExpression("31581","31605");
        new EGFMarkChars("497");
        }
        new EGFMarkChars("498");
        }
        new EGFMarkChars("499");
        if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("500");
        new EGFMarkExpression("31780","31816");
        new EGFMarkChars("501");
        new EGFMarkExpression("31834","31876");
        new EGFMarkExpression("31881","31905");
        if (genFeature.hasEDefault()) {
        new EGFMarkChars("502");
        new EGFMarkExpression("31947","31971");
        }
        new EGFMarkChars("503");
        } else if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("504");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("505");
        new EGFMarkExpression("32096","32130");
        new EGFMarkChars("506");
        new EGFMarkExpression("32138","32163");
        new EGFMarkChars("507");
        } else {
        new EGFMarkChars("508");
        new EGFMarkExpression("32214","32239");
        new EGFMarkChars("509");
        new EGFMarkExpression("32259","32293");
        new EGFMarkChars("510");
        new EGFMarkExpression("32301","32326");
        new EGFMarkChars("511");
        new EGFMarkExpression("32343","32368");
        new EGFMarkChars("512");
        }
        new EGFMarkChars("513");
        } else {
        new EGFMarkChars("514");
        new EGFMarkExpression("32435","32459");
        new EGFMarkChars("515");
        }
        new EGFMarkChars("516");
        }
        new EGFMarkChars("517");
        } else {//volatile
        new EGFMarkChars("518");
        if (genFeature.isResolveProxies() && !genFeature.isListType()) {
        new EGFMarkChars("519");
        new EGFMarkExpression("32596","32632");
        new EGFMarkChars("520");
        new EGFMarkExpression("32638","32662");
        new EGFMarkChars("521");
        new EGFMarkExpression("32678","32706");
        new EGFMarkChars("522");
        new EGFMarkExpression("32724","32748");
        new EGFMarkChars("523");
        new EGFMarkExpression("32765","32798");
        new EGFMarkChars("524");
        new EGFMarkExpression("32817","32867");
        new EGFMarkChars("525");
        new EGFMarkExpression("32887","32952");
        new EGFMarkChars("526");
        new EGFMarkExpression("32958","32982");
        new EGFMarkChars("527");
        new EGFMarkExpression("32991","33015");
        new EGFMarkChars("528");
        } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
        new EGFMarkChars("529");
        if (genFeature.isFeatureMapType()) {
        new EGFMarkChars("530");
        String featureMapEntryTemplateArgument = isJDK50 ? "<" + genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap") + ".Entry>" : "";
        new EGFMarkChars("531");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("532");
        new EGFMarkExpression("33418","33473");
        new EGFMarkChars("533");
        new EGFMarkExpression("33480","33545");
        new EGFMarkChars("534");
        new EGFMarkExpression("33562","33627");
        new EGFMarkChars("535");
        new EGFMarkExpression("33653","33686");
        new EGFMarkChars("536");
        new EGFMarkExpression("33708","33739");
        new EGFMarkChars("537");
        new EGFMarkExpression("33749","33789");
        new EGFMarkChars("538");
        } else {
        new EGFMarkChars("539");
        new EGFMarkExpression("33831","33896");
        new EGFMarkChars("540");
        new EGFMarkExpression("33905","33938");
        new EGFMarkChars("541");
        new EGFMarkExpression("33946","33977");
        new EGFMarkChars("542");
        new EGFMarkExpression("33987","34027");
        new EGFMarkChars("543");
        }
        new EGFMarkChars("544");
        } else if (genFeature.isListType()) {
        new EGFMarkChars("545");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("546");
        new EGFMarkExpression("34175","34240");
        new EGFMarkChars("547");
        new EGFMarkExpression("34266","34299");
        new EGFMarkChars("548");
        new EGFMarkExpression("34326","34366");
        new EGFMarkChars("549");
        } else {
        new EGFMarkChars("550");
        new EGFMarkExpression("34409","34442");
        new EGFMarkChars("551");
        new EGFMarkExpression("34455","34495");
        new EGFMarkChars("552");
        }
        new EGFMarkChars("553");
        } else {
        new EGFMarkChars("554");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("555");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("556");
        }
        if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
        new EGFMarkChars("557");
        new EGFMarkExpression("34771","34805");
        new EGFMarkChars("558");
        }
        new EGFMarkChars("559");
        new EGFMarkExpression("34818","34883");
        new EGFMarkChars("560");
        new EGFMarkExpression("34909","34942");
        new EGFMarkChars("561");
        new EGFMarkExpression("34968","35008");
        new EGFMarkChars("562");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("563");
        new EGFMarkExpression("35073","35111");
        new EGFMarkChars("564");
        }
        new EGFMarkChars("565");
        } else {
        new EGFMarkChars("566");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("567");
        }
        if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
        new EGFMarkChars("568");
        new EGFMarkExpression("35316","35350");
        new EGFMarkChars("569");
        }
        new EGFMarkChars("570");
        new EGFMarkExpression("35364","35397");
        new EGFMarkChars("571");
        new EGFMarkExpression("35409","35449");
        new EGFMarkChars("572");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("573");
        new EGFMarkExpression("35514","35552");
        new EGFMarkChars("574");
        }
        new EGFMarkChars("575");
        }
        new EGFMarkChars("576");
        }
        new EGFMarkChars("577");
        } else if (genClass.getGetAccessorOperation(genFeature) != null) {
        new EGFMarkChars("578");
        new EGFMarkExpression("35675","35766");
        new EGFMarkChars("579");
        } else {
        new EGFMarkChars("580");
        new EGFMarkIncludeAlternative("Class/getGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("581");
        new EGFMarkStart();
        new EGFMarkChars("582");
        new EGFMarkExpression("35938","35967");
        new EGFMarkChars("583");
        new EGFMarkExpression("35974","36001");
        new EGFMarkChars("584");
        if (genFeature.isListType()) {
        new EGFMarkChars("585");
        if (genFeature.isMapType()) {
        new EGFMarkChars("586");
        } else if (genFeature.isFeatureMapType()) {
        new EGFMarkChars("587");
        } else {
        new EGFMarkChars("588");
        }
        new EGFMarkChars("589");
        }
        new EGFMarkChars("590");
        new EGFMarkEnd();
        //Class/getGenFeature.todo.override.javajetinc
        new EGFMarkChars("591");
        }
        new EGFMarkChars("592");
        }
        new EGFMarkChars("593");
        }
        new EGFMarkChars("594");
        new EGFMarkEnd();
        //Class/getGenFeature.override.javajetinc
        new EGFMarkChars("595");
        }
        new EGFMarkChars("596");
        if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
        new EGFMarkChars("597");
        new EGFMarkIncludeAlternative("Class/basicGetGenFeature.override.javajetinc");
        new EGFMarkChars("598");
        new EGFMarkStart();
        new EGFMarkChars("599");
        if (isJDK50) { //Class/basicGetGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("600");
        new EGFMarkIncludeSilent("Class/basicGetGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("601");
        }
        new EGFMarkChars("602");
        new EGFMarkExpression("37145","37181");
        new EGFMarkChars("603");
        new EGFMarkExpression("37195","37223");
        new EGFMarkChars("604");
        new EGFMarkIncludeSilent("Class/basicGetGenFeature.pre.insert.javajetinc");
        new EGFMarkChars("605");
        if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("606");
        new EGFMarkExpression("37373","37409");
        new EGFMarkChars("607");
        new EGFMarkExpression("37427","37469");
        new EGFMarkChars("608");
        new EGFMarkExpression("37476","37516");
        new EGFMarkChars("609");
        new EGFMarkExpression("37530","37571");
        new EGFMarkChars("610");
        } else if (genFeature.isContainer()) {
        new EGFMarkChars("611");
        new EGFMarkExpression("37657","37699");
        new EGFMarkExpression("37704","37728");
        new EGFMarkChars("612");
        new EGFMarkExpression("37758","37794");
        new EGFMarkChars("613");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("614");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("615");
        new EGFMarkExpression("37927","37963");
        new EGFMarkChars("616");
        new EGFMarkExpression("37981","38023");
        new EGFMarkExpression("38028","38052");
        new EGFMarkChars("617");
        } else {
        new EGFMarkChars("618");
        new EGFMarkExpression("38088","38112");
        new EGFMarkChars("619");
        }
        new EGFMarkChars("620");
        } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
        new EGFMarkChars("621");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("622");
        new EGFMarkExpression("38316","38352");
        new EGFMarkChars("623");
        new EGFMarkExpression("38360","38425");
        new EGFMarkChars("624");
        new EGFMarkExpression("38451","38484");
        new EGFMarkChars("625");
        new EGFMarkExpression("38510","38550");
        new EGFMarkChars("626");
        } else {
        new EGFMarkChars("627");
        new EGFMarkExpression("38594","38630");
        new EGFMarkChars("628");
        new EGFMarkExpression("38639","38672");
        new EGFMarkChars("629");
        new EGFMarkExpression("38684","38724");
        new EGFMarkChars("630");
        }
        new EGFMarkChars("631");
        } else {
        new EGFMarkChars("632");
        new EGFMarkIncludeAlternative("Class/basicGetGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("633");
        new EGFMarkStart();
        new EGFMarkChars("634");
        new EGFMarkExpression("38920","38949");
        new EGFMarkChars("635");
        new EGFMarkExpression("38956","38983");
        new EGFMarkChars("636");
        new EGFMarkEnd();
        //Class/basicGetGenFeature.todo.override.javajetinc
        new EGFMarkChars("637");
        }
        new EGFMarkChars("638");
        new EGFMarkEnd();
        //Class/basicGetGenFeature.override.javajetinc
        new EGFMarkChars("639");
        }
        new EGFMarkChars("640");
        if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
        new EGFMarkChars("641");
        new EGFMarkIncludeAlternative("Class/basicSetGenFeature.override.javajetinc");
        new EGFMarkChars("642");
        new EGFMarkStart();
        new EGFMarkChars("643");
        if (isJDK50) { //Class/basicSetGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("644");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("645");
        }
        new EGFMarkChars("646");
        new EGFMarkExpression("39742","39817");
        new EGFMarkChars("647");
        new EGFMarkExpression("39831","39859");
        new EGFMarkChars("648");
        new EGFMarkExpression("39865","39909");
        new EGFMarkChars("649");
        new EGFMarkExpression("39918","39941");
        new EGFMarkChars("650");
        new EGFMarkExpression("39948","40023");
        new EGFMarkChars("651");
        if (genFeature.isContainer()) {
        new EGFMarkChars("652");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.pre.insert.javajetinc");
        new EGFMarkChars("653");
        new EGFMarkExpression("40190","40255");
        new EGFMarkChars("654");
        new EGFMarkExpression("40264","40287");
        new EGFMarkChars("655");
        new EGFMarkExpression("40294","40336");
        new EGFMarkExpression("40341","40365");
        new EGFMarkChars("656");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.post.insert.javajetinc");
        new EGFMarkChars("657");
        } else if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("658");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.pre.insert.javajetinc");
        new EGFMarkChars("659");
        new EGFMarkExpression("40643","40708");
        new EGFMarkChars("660");
        new EGFMarkExpression("40717","40740");
        new EGFMarkChars("661");
        new EGFMarkExpression("40747","40789");
        new EGFMarkExpression("40794","40818");
        new EGFMarkChars("662");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.post.insert.javajetinc");
        new EGFMarkChars("663");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("664");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.pre.insert.javajetinc");
        new EGFMarkChars("665");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("666");
        new EGFMarkExpression("41121","41144");
        new EGFMarkChars("667");
        new EGFMarkExpression("41164","41206");
        new EGFMarkExpression("41211","41235");
        new EGFMarkChars("668");
        new EGFMarkExpression("41245","41268");
        new EGFMarkChars("669");
        } else {
        new EGFMarkChars("670");
        new EGFMarkExpression("41297","41333");
        new EGFMarkChars("671");
        new EGFMarkExpression("41342","41365");
        new EGFMarkChars("672");
        new EGFMarkExpression("41373","41397");
        new EGFMarkChars("673");
        new EGFMarkExpression("41406","41430");
        new EGFMarkChars("674");
        new EGFMarkExpression("41441","41464");
        new EGFMarkChars("675");
        }
        new EGFMarkChars("676");
        if (genFeature.isUnsettable()) {
        new EGFMarkChars("677");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("678");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("679");
        new EGFMarkExpression("41659","41682");
        new EGFMarkChars("680");
        }
        new EGFMarkChars("681");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("682");
        new EGFMarkExpression("41797","41820");
        new EGFMarkChars("683");
        new EGFMarkExpression("41833","41871");
        new EGFMarkChars("684");
        new EGFMarkExpression("41879","41904");
        new EGFMarkChars("685");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("686");
        new EGFMarkExpression("41984","42022");
        new EGFMarkChars("687");
        new EGFMarkExpression("42031","42056");
        new EGFMarkChars("688");
        }
        new EGFMarkChars("689");
        } else {
        new EGFMarkChars("690");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("691");
        new EGFMarkExpression("42178","42201");
        new EGFMarkChars("692");
        new EGFMarkExpression("42213","42238");
        new EGFMarkChars("693");
        }
        new EGFMarkChars("694");
        new EGFMarkExpression("42267","42292");
        new EGFMarkChars("695");
        }
        new EGFMarkChars("696");
        }
        new EGFMarkChars("697");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("698");
        if (genFeature.isUnsettable()) {
        new EGFMarkChars("699");
        new EGFMarkExpression("42471","42543");
        new EGFMarkChars("700");
        new EGFMarkExpression("42568","42640");
        new EGFMarkChars("701");
        new EGFMarkExpression("42652","42722");
        new EGFMarkChars("702");
        new EGFMarkExpression("42733","42775");
        new EGFMarkExpression("42780","42804");
        new EGFMarkChars("703");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("704");
        new EGFMarkExpression("42876","42899");
        } else {
        new EGFMarkChars("705");
        new EGFMarkExpression("42919","42942");
        }
        new EGFMarkChars("706");
        new EGFMarkExpression("42957","42980");
        new EGFMarkChars("707");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("708");
        } else {
        new EGFMarkChars("709");
        new EGFMarkExpression("43055","43078");
        new EGFMarkChars("710");
        }
        new EGFMarkChars("711");
        } else {
        new EGFMarkChars("712");
        new EGFMarkExpression("43119","43191");
        new EGFMarkChars("713");
        new EGFMarkExpression("43216","43288");
        new EGFMarkChars("714");
        new EGFMarkExpression("43300","43370");
        new EGFMarkChars("715");
        new EGFMarkExpression("43381","43423");
        new EGFMarkExpression("43428","43452");
        new EGFMarkChars("716");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("717");
        new EGFMarkExpression("43503","43526");
        new EGFMarkChars("718");
        new EGFMarkExpression("43565","43588");
        } else {
        new EGFMarkChars("719");
        new EGFMarkExpression("43608","43631");
        }
        new EGFMarkChars("720");
        new EGFMarkExpression("43646","43669");
        new EGFMarkChars("721");
        }
        new EGFMarkChars("722");
        }
        new EGFMarkChars("723");
        new EGFMarkIncludeSilent("Class/basicSetGenFeature.post.insert.javajetinc");
        new EGFMarkChars("724");
        } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
        new EGFMarkChars("725");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("726");
        new EGFMarkExpression("44063","44128");
        new EGFMarkChars("727");
        new EGFMarkExpression("44145","44210");
        new EGFMarkChars("728");
        new EGFMarkExpression("44236","44269");
        new EGFMarkChars("729");
        new EGFMarkExpression("44301","44341");
        new EGFMarkChars("730");
        new EGFMarkExpression("44351","44374");
        new EGFMarkChars("731");
        } else {
        new EGFMarkChars("732");
        new EGFMarkExpression("44418","44483");
        new EGFMarkChars("733");
        new EGFMarkExpression("44501","44534");
        new EGFMarkChars("734");
        new EGFMarkExpression("44552","44592");
        new EGFMarkChars("735");
        new EGFMarkExpression("44602","44625");
        new EGFMarkChars("736");
        }
        new EGFMarkChars("737");
        } else {
        new EGFMarkChars("738");
        new EGFMarkIncludeAlternative("Class/basicSetGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("739");
        new EGFMarkStart();
        new EGFMarkChars("740");
        new EGFMarkExpression("44827","44856");
        new EGFMarkChars("741");
        new EGFMarkExpression("44863","44890");
        new EGFMarkChars("742");
        new EGFMarkEnd();
        //Class/basicSetGenFeature.todo.override.javajetinc
        new EGFMarkChars("743");
        }
        new EGFMarkChars("744");
        new EGFMarkEnd();
        //Class/basicSetGenFeature.override.javajetinc
        new EGFMarkChars("745");
        }
        new EGFMarkChars("746");
        if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
        new EGFMarkChars("747");
        new EGFMarkIncludeAlternative("Class/setGenFeature.override.javajetinc");
        new EGFMarkChars("748");
        new EGFMarkStart();
        new EGFMarkChars("749");
        if (isInterface) { 
        new EGFMarkChars("750");
        new EGFMarkIncludeAlternative("Class/setGenFeature.javadoc.override.javajetinc");
        new EGFMarkChars("751");
        new EGFMarkStart();
        new EGFMarkChars("752");
        new EGFMarkExpression("45772","45808");
        new EGFMarkChars("753");
        new EGFMarkExpression("45814","45841");
        new EGFMarkChars("754");
        new EGFMarkExpression("45851","45880");
        new EGFMarkChars("755");
        new EGFMarkExpression("45893","45920");
        new EGFMarkChars("756");
        new EGFMarkIncludeSilent("Class/setGenFeature.javadoc.insert.javajetinc");
        new EGFMarkChars("757");
        new EGFMarkExpression("46106","46135");
        new EGFMarkChars("758");
        new EGFMarkExpression("46147","46174");
        new EGFMarkChars("759");
        if (genFeature.isEnumType()) {
        new EGFMarkChars("760");
        new EGFMarkExpression("46229","46275");
        new EGFMarkChars("761");
        }
        new EGFMarkChars("762");
        if (genFeature.isUnsettable()) {
        new EGFMarkChars("763");
        if (!genFeature.isSuppressedIsSetVisibility()) {
        new EGFMarkChars("764");
        new EGFMarkExpression("46406","46434");
        new EGFMarkChars("765");
        }
        new EGFMarkChars("766");
        if (!genFeature.isSuppressedUnsetVisibility()) {
        new EGFMarkChars("767");
        new EGFMarkExpression("46528","46556");
        new EGFMarkChars("768");
        }
        new EGFMarkChars("769");
        }
        new EGFMarkChars("770");
        new EGFMarkExpression("46596","46623");
        new EGFMarkChars("771");
        new EGFMarkEnd();
        //Class/setGenFeature.javadoc.override.javajetinc
        new EGFMarkChars("772");
        } else {
        new EGFMarkChars("773");
        if (isJDK50) { //Class/setGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("774");
        new EGFMarkIncludeSilent("Class/setGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("775");
        }
        new EGFMarkChars("776");
        }
        new EGFMarkChars("777");
        if (!isImplementation) { 
        new EGFMarkChars("778");
        new EGFMarkExpression("47015","47043");
        new EGFMarkChars("779");
        new EGFMarkExpression("47049","47085");
        new EGFMarkChars("780");
        } else { GenOperation setAccessorOperation = genClass.getSetAccessorOperation(genFeature);
        new EGFMarkChars("781");
        new EGFMarkExpression("47211","47239");
        if (genClass.hasCollidingSetAccessorOperation(genFeature)) {
        new EGFMarkChars("782");
        }
        new EGFMarkChars("783");
        new EGFMarkExpression("47315","47351");
        new EGFMarkChars("784");
        new EGFMarkExpression("47357","47478");
        new EGFMarkChars("785");
        new EGFMarkIncludeSilent("Class/setGenFeature.pre.insert.javajetinc");
        new EGFMarkChars("786");
        if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("787");
        new EGFMarkExpression("47626","47668");
        new EGFMarkChars("788");
        new EGFMarkExpression("47675","47715");
        new EGFMarkChars("789");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("790");
        new EGFMarkExpression("47777","47811");
        new EGFMarkChars("791");
        }
        new EGFMarkChars("792");
        new EGFMarkExpression("47825","47848");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("793");
        }
        new EGFMarkChars("794");
        } else if (genModel.isReflectiveDelegation()) {
        new EGFMarkChars("795");
        new EGFMarkExpression("47976","48016");
        new EGFMarkChars("796");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("797");
        new EGFMarkExpression("48078","48112");
        new EGFMarkChars("798");
        }
        new EGFMarkChars("799");
        new EGFMarkExpression("48126","48149");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("800");
        }
        new EGFMarkChars("801");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("802");
        if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("803");
        new EGFMarkExpression("48551","48574");
        new EGFMarkChars("804");
        new EGFMarkExpression("48633","48675");
        new EGFMarkExpression("48680","48704");
        new EGFMarkChars("805");
        new EGFMarkExpression("48716","48739");
        new EGFMarkChars("806");
        new EGFMarkExpression("48766","48830");
        new EGFMarkChars("807");
        new EGFMarkExpression("48853","48880");
        new EGFMarkChars("808");
        new EGFMarkExpression("48888","48911");
        new EGFMarkChars("809");
        new EGFMarkExpression("48933","48995");
        new EGFMarkChars("810");
        new EGFMarkExpression("49056","49076");
        new EGFMarkChars("811");
        new EGFMarkExpression("49085","49160");
        new EGFMarkChars("812");
        new EGFMarkExpression("49270","49293");
        new EGFMarkChars("813");
        new EGFMarkExpression("49321","49386");
        new EGFMarkChars("814");
        new EGFMarkExpression("49395","49418");
        new EGFMarkChars("815");
        new EGFMarkExpression("49443","49492");
        new EGFMarkExpression("49497","49520");
        new EGFMarkChars("816");
        new EGFMarkExpression("49527","49568");
        new EGFMarkChars("817");
        new EGFMarkExpression("49606","49634");
        new EGFMarkChars("818");
        new EGFMarkExpression("49640","49672");
        new EGFMarkChars("819");
        new EGFMarkExpression("49680","49703");
        new EGFMarkChars("820");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("821");
        new EGFMarkExpression("49864","49936");
        new EGFMarkChars("822");
        new EGFMarkExpression("49948","50018");
        new EGFMarkChars("823");
        new EGFMarkExpression("50029","50071");
        new EGFMarkExpression("50076","50100");
        new EGFMarkChars("824");
        new EGFMarkExpression("50110","50133");
        new EGFMarkChars("825");
        new EGFMarkExpression("50143","50166");
        new EGFMarkChars("826");
        }
        new EGFMarkChars("827");
        } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
        new EGFMarkChars("828");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("829");
        new EGFMarkExpression("50330","50366");
        new EGFMarkChars("830");
        new EGFMarkExpression("50372","50396");
        new EGFMarkChars("831");
        new EGFMarkExpression("50405","50441");
        new EGFMarkChars("832");
        new EGFMarkExpression("50459","50501");
        new EGFMarkExpression("50506","50530");
        new EGFMarkChars("833");
        }
        new EGFMarkChars("834");
        new EGFMarkExpression("50561","50584");
        new EGFMarkChars("835");
        new EGFMarkExpression("50593","50617");
        new EGFMarkChars("836");
        new EGFMarkExpression("50631","50706");
        new EGFMarkChars("837");
        new EGFMarkExpression("50732","50756");
        new EGFMarkChars("838");
        if (!genFeature.isBidirectional()) {
        new EGFMarkChars("839");
        new EGFMarkExpression("50833","50898");
        new EGFMarkChars("840");
        new EGFMarkExpression("50904","50928");
        new EGFMarkChars("841");
        new EGFMarkExpression("50981","51023");
        new EGFMarkExpression("51028","51052");
        new EGFMarkChars("842");
        new EGFMarkExpression("51082","51105");
        new EGFMarkChars("843");
        new EGFMarkExpression("51133","51198");
        new EGFMarkChars("844");
        new EGFMarkExpression("51207","51230");
        new EGFMarkChars("845");
        new EGFMarkExpression("51280","51322");
        new EGFMarkExpression("51327","51351");
        new EGFMarkChars("846");
        } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("847");
        new EGFMarkExpression("51644","51709");
        new EGFMarkChars("848");
        new EGFMarkExpression("51715","51739");
        new EGFMarkChars("849");
        new EGFMarkExpression("51767","51816");
        new EGFMarkExpression("51821","51844");
        new EGFMarkChars("850");
        new EGFMarkExpression("51851","51892");
        new EGFMarkChars("851");
        new EGFMarkExpression("51922","51945");
        new EGFMarkChars("852");
        new EGFMarkExpression("51973","52038");
        new EGFMarkChars("853");
        new EGFMarkExpression("52047","52070");
        new EGFMarkChars("854");
        new EGFMarkExpression("52095","52144");
        new EGFMarkExpression("52149","52172");
        new EGFMarkChars("855");
        new EGFMarkExpression("52179","52220");
        new EGFMarkChars("856");
        }
        new EGFMarkChars("857");
        new EGFMarkExpression("52272","52300");
        new EGFMarkChars("858");
        new EGFMarkExpression("52306","52338");
        new EGFMarkChars("859");
        new EGFMarkExpression("52346","52369");
        new EGFMarkChars("860");
        if (genFeature.isUnsettable()) {
        new EGFMarkChars("861");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("862");
        new EGFMarkExpression("52547","52570");
        new EGFMarkChars("863");
        new EGFMarkExpression("52596","52638");
        new EGFMarkExpression("52643","52667");
        new EGFMarkChars("864");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("865");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("866");
        new EGFMarkExpression("52807","52830");
        new EGFMarkChars("867");
        new EGFMarkExpression("52843","52881");
        new EGFMarkChars("868");
        new EGFMarkExpression("52889","52914");
        new EGFMarkChars("869");
        }
        new EGFMarkChars("870");
        new EGFMarkExpression("52957","52995");
        new EGFMarkChars("871");
        new EGFMarkExpression("53004","53029");
        new EGFMarkChars("872");
        } else {
        new EGFMarkChars("873");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("874");
        new EGFMarkExpression("53140","53163");
        new EGFMarkChars("875");
        new EGFMarkExpression("53175","53200");
        new EGFMarkChars("876");
        }
        new EGFMarkChars("877");
        new EGFMarkExpression("53232","53257");
        new EGFMarkChars("878");
        }
        new EGFMarkChars("879");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("880");
        new EGFMarkExpression("53395","53467");
        new EGFMarkChars("881");
        new EGFMarkExpression("53479","53549");
        new EGFMarkChars("882");
        new EGFMarkExpression("53560","53602");
        new EGFMarkExpression("53607","53631");
        new EGFMarkChars("883");
        new EGFMarkExpression("53641","53664");
        new EGFMarkChars("884");
        new EGFMarkExpression("53674","53697");
        new EGFMarkChars("885");
        new EGFMarkExpression("53708","53731");
        new EGFMarkChars("886");
        }
        new EGFMarkChars("887");
        } else {
        new EGFMarkChars("888");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("889");
        new EGFMarkExpression("53892","53964");
        new EGFMarkChars("890");
        new EGFMarkExpression("53976","54046");
        new EGFMarkChars("891");
        new EGFMarkExpression("54057","54099");
        new EGFMarkExpression("54104","54128");
        new EGFMarkChars("892");
        new EGFMarkExpression("54138","54161");
        new EGFMarkChars("893");
        new EGFMarkExpression("54171","54194");
        new EGFMarkChars("894");
        }
        new EGFMarkChars("895");
        }
        new EGFMarkChars("896");
        } else {
        new EGFMarkChars("897");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("898");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("899");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("900");
        new EGFMarkExpression("54407","54443");
        new EGFMarkChars("901");
        new EGFMarkExpression("54452","54475");
        new EGFMarkChars("902");
        new EGFMarkExpression("54484","54518");
        new EGFMarkChars("903");
        new EGFMarkExpression("54526","54551");
        new EGFMarkChars("904");
        } else {
        new EGFMarkChars("905");
        new EGFMarkExpression("54597","54633");
        new EGFMarkChars("906");
        new EGFMarkExpression("54642","54665");
        new EGFMarkChars("907");
        new EGFMarkExpression("54673","54698");
        new EGFMarkChars("908");
        new EGFMarkExpression("54718","54752");
        new EGFMarkChars("909");
        new EGFMarkExpression("54760","54785");
        new EGFMarkChars("910");
        new EGFMarkExpression("54802","54827");
        new EGFMarkChars("911");
        }
        new EGFMarkChars("912");
        }
        new EGFMarkChars("913");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("914");
        new EGFMarkExpression("54939","54962");
        new EGFMarkChars("915");
        new EGFMarkExpression("54969","55003");
        new EGFMarkChars("916");
        new EGFMarkExpression("55012","55037");
        new EGFMarkChars("917");
        new EGFMarkExpression("55055","55089");
        new EGFMarkChars("918");
        new EGFMarkExpression("55099","55124");
        new EGFMarkChars("919");
        } else {
        new EGFMarkChars("920");
        new EGFMarkExpression("55169","55192");
        new EGFMarkChars("921");
        new EGFMarkExpression("55210","55233");
        new EGFMarkChars("922");
        new EGFMarkExpression("55241","55266");
        new EGFMarkChars("923");
        new EGFMarkExpression("55284","55318");
        new EGFMarkChars("924");
        new EGFMarkExpression("55326","55360");
        new EGFMarkChars("925");
        new EGFMarkExpression("55369","55394");
        new EGFMarkChars("926");
        if (isJDK50) {
        new EGFMarkChars("927");
        new EGFMarkExpression("55429","55452");
        new EGFMarkChars("928");
        } else {
        new EGFMarkExpression("55479","55515");
        new EGFMarkChars("929");
        new EGFMarkExpression("55539","55562");
        new EGFMarkChars("930");
        }
        new EGFMarkChars("931");
        new EGFMarkExpression("55577","55602");
        new EGFMarkChars("932");
        }
        new EGFMarkChars("933");
        } else {
        new EGFMarkChars("934");
        if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
        new EGFMarkChars("935");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("936");
        new EGFMarkExpression("55804","55840");
        new EGFMarkChars("937");
        new EGFMarkExpression("55849","55872");
        new EGFMarkChars("938");
        new EGFMarkExpression("55880","55904");
        new EGFMarkChars("939");
        }
        new EGFMarkChars("940");
        }
        new EGFMarkChars("941");
        if (genFeature.isEnumType()) {
        new EGFMarkChars("942");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("943");
        new EGFMarkExpression("56046","56082");
        new EGFMarkChars("944");
        new EGFMarkExpression("56088","56112");
        new EGFMarkChars("945");
        new EGFMarkExpression("56123","56146");
        new EGFMarkChars("946");
        new EGFMarkExpression("56162","56186");
        new EGFMarkChars("947");
        new EGFMarkExpression("56197","56220");
        new EGFMarkChars("948");
        } else {
        new EGFMarkChars("949");
        new EGFMarkExpression("56254","56278");
        new EGFMarkChars("950");
        new EGFMarkExpression("56289","56312");
        new EGFMarkChars("951");
        new EGFMarkExpression("56328","56352");
        new EGFMarkChars("952");
        new EGFMarkExpression("56363","56386");
        new EGFMarkChars("953");
        }
        new EGFMarkChars("954");
        } else {
        new EGFMarkChars("955");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("956");
        new EGFMarkExpression("56523","56559");
        new EGFMarkChars("957");
        new EGFMarkExpression("56565","56589");
        new EGFMarkChars("958");
        new EGFMarkExpression("56597","56629");
        new EGFMarkChars("959");
        new EGFMarkExpression("56637","56660");
        new EGFMarkChars("960");
        } else {
        new EGFMarkChars("961");
        new EGFMarkExpression("56694","56718");
        new EGFMarkChars("962");
        new EGFMarkExpression("56726","56758");
        new EGFMarkChars("963");
        new EGFMarkExpression("56766","56789");
        new EGFMarkChars("964");
        }
        new EGFMarkChars("965");
        }
        new EGFMarkChars("966");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("967");
        new EGFMarkExpression("56927","56950");
        new EGFMarkChars("968");
        new EGFMarkExpression("56970","57012");
        new EGFMarkExpression("57017","57041");
        new EGFMarkChars("969");
        new EGFMarkExpression("57048","57072");
        new EGFMarkChars("970");
        }
        new EGFMarkChars("971");
        }
        new EGFMarkChars("972");
        if (genFeature.isUnsettable()) {
        new EGFMarkChars("973");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("974");
        new EGFMarkExpression("57267","57290");
        new EGFMarkChars("975");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("976");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("977");
        new EGFMarkExpression("57449","57472");
        new EGFMarkChars("978");
        new EGFMarkExpression("57485","57523");
        new EGFMarkChars("979");
        new EGFMarkExpression("57531","57556");
        new EGFMarkChars("980");
        }
        new EGFMarkChars("981");
        new EGFMarkExpression("57598","57636");
        new EGFMarkChars("982");
        new EGFMarkExpression("57645","57670");
        new EGFMarkChars("983");
        } else {
        new EGFMarkChars("984");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("985");
        new EGFMarkExpression("57780","57803");
        new EGFMarkChars("986");
        new EGFMarkExpression("57815","57840");
        new EGFMarkChars("987");
        }
        new EGFMarkChars("988");
        new EGFMarkExpression("57871","57896");
        new EGFMarkChars("989");
        }
        new EGFMarkChars("990");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("991");
        new EGFMarkExpression("58032","58104");
        new EGFMarkChars("992");
        new EGFMarkExpression("58116","58186");
        new EGFMarkChars("993");
        new EGFMarkExpression("58197","58239");
        new EGFMarkExpression("58244","58268");
        new EGFMarkChars("994");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("995");
        new EGFMarkExpression("58363","58387");
        new EGFMarkChars("996");
        new EGFMarkExpression("58398","58421");
        } else {
        new EGFMarkChars("997");
        new EGFMarkExpression("58441","58464");
        }
        new EGFMarkChars("998");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("999");
        new EGFMarkExpression("58517","58540");
        } else {
        new EGFMarkExpression("58557","58581");
        }
        new EGFMarkChars("1000");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1001");
        } else {
        new EGFMarkChars("1002");
        new EGFMarkExpression("58694","58717");
        new EGFMarkChars("1003");
        }
        new EGFMarkChars("1004");
        }
        new EGFMarkChars("1005");
        } else {
        new EGFMarkChars("1006");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1007");
        new EGFMarkExpression("58874","58946");
        new EGFMarkChars("1008");
        new EGFMarkExpression("58958","59028");
        new EGFMarkChars("1009");
        new EGFMarkExpression("59039","59081");
        new EGFMarkExpression("59086","59110");
        new EGFMarkChars("1010");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1011");
        new EGFMarkExpression("59194","59217");
        new EGFMarkChars("1012");
        new EGFMarkExpression("59246","59270");
        new EGFMarkChars("1013");
        new EGFMarkExpression("59281","59304");
        } else {
        new EGFMarkChars("1014");
        new EGFMarkExpression("59324","59347");
        }
        new EGFMarkChars("1015");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("1016");
        new EGFMarkExpression("59400","59423");
        } else {
        new EGFMarkExpression("59440","59464");
        }
        new EGFMarkChars("1017");
        }
        new EGFMarkChars("1018");
        }
        new EGFMarkChars("1019");
        }
        new EGFMarkChars("1020");
        new EGFMarkIncludeSilent("Class/setGenFeature.post.insert.javajetinc");
        new EGFMarkChars("1021");
        } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
        new EGFMarkChars("1022");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1023");
        new EGFMarkExpression("59778","59843");
        new EGFMarkChars("1024");
        new EGFMarkExpression("59860","59925");
        new EGFMarkChars("1025");
        new EGFMarkExpression("59951","59984");
        new EGFMarkChars("1026");
        new EGFMarkExpression("60011","60051");
        new EGFMarkChars("1027");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("1028");
        new EGFMarkExpression("60113","60147");
        new EGFMarkChars("1029");
        }
        new EGFMarkChars("1030");
        new EGFMarkExpression("60161","60184");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("1031");
        }
        new EGFMarkChars("1032");
        } else {
        new EGFMarkChars("1033");
        new EGFMarkExpression("60272","60337");
        new EGFMarkChars("1034");
        new EGFMarkExpression("60355","60388");
        new EGFMarkChars("1035");
        new EGFMarkExpression("60401","60441");
        new EGFMarkChars("1036");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("1037");
        new EGFMarkExpression("60503","60537");
        new EGFMarkChars("1038");
        }
        new EGFMarkChars("1039");
        new EGFMarkExpression("60551","60574");
        if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("1040");
        }
        new EGFMarkChars("1041");
        }
        new EGFMarkChars("1042");
        } else if (setAccessorOperation != null) {
        new EGFMarkChars("1043");
        new EGFMarkExpression("60704","60771");
        new EGFMarkChars("1044");
        } else {
        new EGFMarkChars("1045");
        new EGFMarkIncludeAlternative("Class/setGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("1046");
        new EGFMarkStart();
        new EGFMarkChars("1047");
        new EGFMarkExpression("60938","60967");
        new EGFMarkChars("1048");
        new EGFMarkExpression("60974","61001");
        new EGFMarkChars("1049");
        new EGFMarkEnd();
        //Class/setGenFeature.todo.override.javajetinc
        new EGFMarkChars("1050");
        }
        new EGFMarkChars("1051");
        }
        new EGFMarkChars("1052");
        new EGFMarkEnd();
        //Class/setGenFeature.override.javajetinc
        new EGFMarkChars("1053");
        }
        new EGFMarkChars("1054");
        if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
        new EGFMarkChars("1055");
        new EGFMarkIncludeAlternative("Class/basicUnsetGenFeature.override.javajetinc");
        new EGFMarkChars("1056");
        new EGFMarkStart();
        new EGFMarkChars("1057");
        if (isJDK50) { //Class/basicUnsetGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("1058");
        new EGFMarkIncludeSilent("Class/basicUnsetGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("1059");
        }
        new EGFMarkChars("1060");
        new EGFMarkExpression("61724","61799");
        new EGFMarkChars("1061");
        new EGFMarkExpression("61815","61843");
        new EGFMarkChars("1062");
        new EGFMarkExpression("61849","61924");
        new EGFMarkChars("1063");
        if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("1064");
        new EGFMarkExpression("62017","62082");
        new EGFMarkChars("1065");
        if (genFeature.isResolveProxies()) {
        new EGFMarkChars("1066");
        new EGFMarkExpression("62136","62164");
        } else {
        new EGFMarkExpression("62181","62208");
        }
        new EGFMarkChars("1067");
        new EGFMarkExpression("62222","62264");
        new EGFMarkExpression("62269","62293");
        new EGFMarkChars("1068");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("1069");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1070");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1071");
        new EGFMarkExpression("62465","62488");
        new EGFMarkChars("1072");
        }
        new EGFMarkChars("1073");
        new EGFMarkExpression("62515","62557");
        new EGFMarkExpression("62562","62586");
        new EGFMarkChars("1074");
        } else {
        new EGFMarkChars("1075");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1076");
        new EGFMarkExpression("62669","62705");
        new EGFMarkChars("1077");
        new EGFMarkExpression("62714","62737");
        new EGFMarkChars("1078");
        new EGFMarkExpression("62745","62769");
        new EGFMarkChars("1079");
        }
        new EGFMarkChars("1080");
        new EGFMarkExpression("62792","62816");
        new EGFMarkChars("1081");
        }
        new EGFMarkChars("1082");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1083");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1084");
        new EGFMarkExpression("62971","62994");
        new EGFMarkChars("1085");
        }
        new EGFMarkChars("1086");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1087");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1088");
        new EGFMarkExpression("63159","63182");
        new EGFMarkChars("1089");
        new EGFMarkExpression("63195","63233");
        new EGFMarkChars("1090");
        new EGFMarkExpression("63241","63266");
        new EGFMarkChars("1091");
        }
        new EGFMarkChars("1092");
        new EGFMarkExpression("63304","63342");
        new EGFMarkChars("1093");
        new EGFMarkExpression("63352","63377");
        new EGFMarkChars("1094");
        } else {
        new EGFMarkChars("1095");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1096");
        new EGFMarkExpression("63479","63502");
        new EGFMarkChars("1097");
        new EGFMarkExpression("63514","63539");
        new EGFMarkChars("1098");
        }
        new EGFMarkChars("1099");
        new EGFMarkExpression("63566","63591");
        new EGFMarkChars("1100");
        }
        new EGFMarkChars("1101");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1102");
        new EGFMarkExpression("63714","63786");
        new EGFMarkChars("1103");
        new EGFMarkExpression("63811","63883");
        new EGFMarkChars("1104");
        new EGFMarkExpression("63895","63965");
        new EGFMarkChars("1105");
        new EGFMarkExpression("63978","64020");
        new EGFMarkExpression("64025","64049");
        new EGFMarkChars("1106");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1107");
        new EGFMarkExpression("64114","64137");
        new EGFMarkChars("1108");
        } else {
        new EGFMarkChars("1109");
        new EGFMarkExpression("64164","64187");
        }
        new EGFMarkChars("1110");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1111");
        } else {
        new EGFMarkChars("1112");
        new EGFMarkExpression("64272","64295");
        new EGFMarkChars("1113");
        }
        new EGFMarkChars("1114");
        }
        new EGFMarkChars("1115");
        } else {
        new EGFMarkChars("1116");
        new EGFMarkIncludeAlternative("Class/basicUnsetGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("1117");
        new EGFMarkStart();
        new EGFMarkChars("1118");
        new EGFMarkExpression("64596","64625");
        new EGFMarkChars("1119");
        new EGFMarkExpression("64632","64659");
        new EGFMarkChars("1120");
        new EGFMarkEnd();
        //Class/basicUnsetGenFeature.todo.override.javajetinc
        new EGFMarkChars("1121");
        }
        new EGFMarkChars("1122");
        new EGFMarkEnd();
        //Class.basicUnsetGenFeature.override.javajetinc
        new EGFMarkChars("1123");
        }
        new EGFMarkChars("1124");
        if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
        new EGFMarkChars("1125");
        new EGFMarkIncludeAlternative("Class/unsetGenFeature.override.javajetinc");
        new EGFMarkChars("1126");
        new EGFMarkStart();
        new EGFMarkChars("1127");
        if (isInterface) {
        new EGFMarkChars("1128");
        new EGFMarkIncludeAlternative("Class/unsetGenFeature.javadoc.override.javajetinc");
        new EGFMarkChars("1129");
        new EGFMarkStart();
        new EGFMarkChars("1130");
        new EGFMarkExpression("65554","65590");
        new EGFMarkChars("1131");
        new EGFMarkExpression("65596","65623");
        new EGFMarkChars("1132");
        new EGFMarkExpression("65633","65662");
        new EGFMarkChars("1133");
        new EGFMarkExpression("65675","65702");
        new EGFMarkChars("1134");
        new EGFMarkIncludeSilent("Class/unsetGenFeature.javadoc.insert.javajetinc");
        new EGFMarkChars("1135");
        if (!genFeature.isSuppressedIsSetVisibility()) {
        new EGFMarkChars("1136");
        new EGFMarkExpression("65917","65945");
        new EGFMarkChars("1137");
        }
        new EGFMarkChars("1138");
        new EGFMarkExpression("65971","65998");
        new EGFMarkChars("1139");
        if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
        new EGFMarkChars("1140");
        new EGFMarkExpression("66100","66128");
        new EGFMarkChars("1141");
        new EGFMarkExpression("66134","66170");
        new EGFMarkChars("1142");
        }
        new EGFMarkChars("1143");
        new EGFMarkEnd();
        //Class/unsetGenFeature.javadoc.override.javajetinc
        new EGFMarkChars("1144");
        } else {
        new EGFMarkChars("1145");
        if (isJDK50) { //Class/unsetGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("1146");
        new EGFMarkIncludeSilent("Class/unsetGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("1147");
        }
        new EGFMarkChars("1148");
        }
        new EGFMarkChars("1149");
        if (!isImplementation) {
        new EGFMarkChars("1150");
        new EGFMarkExpression("66576","66604");
        new EGFMarkChars("1151");
        } else {
        new EGFMarkChars("1152");
        new EGFMarkExpression("66645","66673");
        if (genClass.hasCollidingUnsetAccessorOperation(genFeature)) {
        new EGFMarkChars("1153");
        }
        new EGFMarkChars("1154");
        if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("1155");
        new EGFMarkExpression("66818","66860");
        new EGFMarkChars("1156");
        new EGFMarkExpression("66867","66907");
        new EGFMarkChars("1157");
        } else if (genModel.isReflectiveDelegation()) {
        new EGFMarkChars("1158");
        new EGFMarkExpression("66980","67020");
        new EGFMarkChars("1159");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("1160");
        if (genFeature.isListType()) {
        new EGFMarkChars("1161");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1162");
        new EGFMarkExpression("67168","67204");
        new EGFMarkChars("1163");
        new EGFMarkExpression("67210","67234");
        new EGFMarkChars("1164");
        new EGFMarkExpression("67243","67279");
        new EGFMarkChars("1165");
        new EGFMarkExpression("67297","67339");
        new EGFMarkExpression("67344","67368");
        new EGFMarkChars("1166");
        }
        new EGFMarkChars("1167");
        new EGFMarkExpression("67396","67420");
        new EGFMarkChars("1168");
        new EGFMarkExpression("67437","67505");
        new EGFMarkChars("1169");
        new EGFMarkExpression("67521","67535");
        new EGFMarkChars("1170");
        new EGFMarkExpression("67541","67565");
        new EGFMarkChars("1171");
        } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
        new EGFMarkChars("1172");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1173");
        new EGFMarkExpression("67722","67758");
        new EGFMarkChars("1174");
        new EGFMarkExpression("67764","67788");
        new EGFMarkChars("1175");
        new EGFMarkExpression("67797","67833");
        new EGFMarkChars("1176");
        new EGFMarkExpression("67851","67893");
        new EGFMarkExpression("67898","67922");
        new EGFMarkChars("1177");
        }
        new EGFMarkChars("1178");
        new EGFMarkExpression("67950","67974");
        new EGFMarkChars("1179");
        new EGFMarkExpression("67996","68071");
        new EGFMarkChars("1180");
        if (!genFeature.isBidirectional()) {
        new EGFMarkChars("1181");
        new EGFMarkExpression("68151","68216");
        new EGFMarkChars("1182");
        new EGFMarkExpression("68222","68246");
        new EGFMarkChars("1183");
        new EGFMarkExpression("68299","68341");
        new EGFMarkExpression("68346","68370");
        new EGFMarkChars("1184");
        } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("1185");
        new EGFMarkExpression("68662","68727");
        new EGFMarkChars("1186");
        new EGFMarkExpression("68733","68757");
        new EGFMarkChars("1187");
        new EGFMarkExpression("68785","68834");
        new EGFMarkExpression("68839","68862");
        new EGFMarkChars("1188");
        new EGFMarkExpression("68869","68910");
        new EGFMarkChars("1189");
        }
        new EGFMarkChars("1190");
        new EGFMarkExpression("68964","68992");
        new EGFMarkChars("1191");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1192");
        new EGFMarkExpression("69122","69145");
        new EGFMarkChars("1193");
        new EGFMarkExpression("69171","69213");
        new EGFMarkExpression("69218","69242");
        new EGFMarkChars("1194");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1195");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1196");
        new EGFMarkExpression("69378","69401");
        new EGFMarkChars("1197");
        new EGFMarkExpression("69414","69452");
        new EGFMarkChars("1198");
        new EGFMarkExpression("69460","69485");
        new EGFMarkChars("1199");
        }
        new EGFMarkChars("1200");
        new EGFMarkExpression("69526","69564");
        new EGFMarkChars("1201");
        new EGFMarkExpression("69574","69599");
        new EGFMarkChars("1202");
        } else {
        new EGFMarkChars("1203");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1204");
        new EGFMarkExpression("69706","69729");
        new EGFMarkChars("1205");
        new EGFMarkExpression("69741","69766");
        new EGFMarkChars("1206");
        }
        new EGFMarkChars("1207");
        new EGFMarkExpression("69796","69821");
        new EGFMarkChars("1208");
        }
        new EGFMarkChars("1209");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1210");
        new EGFMarkExpression("69956","70028");
        new EGFMarkChars("1211");
        new EGFMarkExpression("70040","70110");
        new EGFMarkChars("1212");
        new EGFMarkExpression("70123","70165");
        new EGFMarkExpression("70170","70194");
        new EGFMarkChars("1213");
        new EGFMarkExpression("70216","70239");
        new EGFMarkChars("1214");
        }
        new EGFMarkChars("1215");
        } else {
        new EGFMarkChars("1216");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("1217");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1218");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("1219");
        new EGFMarkExpression("70444","70480");
        new EGFMarkChars("1220");
        new EGFMarkExpression("70489","70512");
        new EGFMarkChars("1221");
        new EGFMarkExpression("70521","70555");
        new EGFMarkChars("1222");
        new EGFMarkExpression("70563","70588");
        new EGFMarkChars("1223");
        } else {
        new EGFMarkChars("1224");
        new EGFMarkExpression("70634","70670");
        new EGFMarkChars("1225");
        new EGFMarkExpression("70679","70702");
        new EGFMarkChars("1226");
        new EGFMarkExpression("70710","70735");
        new EGFMarkChars("1227");
        new EGFMarkExpression("70755","70789");
        new EGFMarkChars("1228");
        new EGFMarkExpression("70797","70822");
        new EGFMarkChars("1229");
        new EGFMarkExpression("70839","70864");
        new EGFMarkChars("1230");
        }
        new EGFMarkChars("1231");
        }
        new EGFMarkChars("1232");
        } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1233");
        new EGFMarkExpression("71021","71044");
        new EGFMarkChars("1234");
        new EGFMarkExpression("71066","71108");
        new EGFMarkExpression("71113","71137");
        new EGFMarkChars("1235");
        } else {
        new EGFMarkChars("1236");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1237");
        new EGFMarkExpression("71224","71260");
        new EGFMarkChars("1238");
        new EGFMarkExpression("71269","71292");
        new EGFMarkChars("1239");
        new EGFMarkExpression("71300","71324");
        new EGFMarkChars("1240");
        }
        new EGFMarkChars("1241");
        }
        new EGFMarkChars("1242");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1243");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1244");
        new EGFMarkExpression("71524","71547");
        new EGFMarkChars("1245");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1246");
        new EGFMarkExpression("71648","71671");
        new EGFMarkChars("1247");
        new EGFMarkExpression("71684","71722");
        new EGFMarkChars("1248");
        new EGFMarkExpression("71730","71755");
        new EGFMarkChars("1249");
        } else {
        new EGFMarkChars("1250");
        new EGFMarkExpression("71813","71836");
        new EGFMarkChars("1251");
        new EGFMarkExpression("71848","71873");
        new EGFMarkChars("1252");
        }
        new EGFMarkChars("1253");
        }
        new EGFMarkChars("1254");
        if (genFeature.isReferenceType()) {
        new EGFMarkChars("1255");
        new EGFMarkExpression("71964","71988");
        new EGFMarkChars("1256");
        if (!genModel.isVirtualDelegation()) {
        new EGFMarkChars("1257");
        if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1258");
        new EGFMarkExpression("72112","72150");
        new EGFMarkChars("1259");
        new EGFMarkExpression("72160","72185");
        new EGFMarkChars("1260");
        } else {
        new EGFMarkChars("1261");
        new EGFMarkExpression("72228","72253");
        new EGFMarkChars("1262");
        }
        new EGFMarkChars("1263");
        }
        new EGFMarkChars("1264");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1265");
        new EGFMarkExpression("72408","72480");
        new EGFMarkChars("1266");
        new EGFMarkExpression("72492","72562");
        new EGFMarkChars("1267");
        new EGFMarkExpression("72575","72617");
        new EGFMarkExpression("72622","72646");
        new EGFMarkChars("1268");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1269");
        new EGFMarkExpression("72711","72734");
        new EGFMarkChars("1270");
        } else {
        new EGFMarkChars("1271");
        new EGFMarkExpression("72761","72784");
        }
        new EGFMarkChars("1272");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1273");
        } else {
        new EGFMarkChars("1274");
        new EGFMarkExpression("72869","72892");
        new EGFMarkChars("1275");
        }
        new EGFMarkChars("1276");
        }
        new EGFMarkChars("1277");
        } else {
        new EGFMarkChars("1278");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("1279");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("1280");
        new EGFMarkExpression("73052","73076");
        new EGFMarkChars("1281");
        new EGFMarkExpression("73083","73117");
        new EGFMarkChars("1282");
        new EGFMarkExpression("73126","73151");
        new EGFMarkChars("1283");
        new EGFMarkExpression("73169","73203");
        new EGFMarkChars("1284");
        new EGFMarkExpression("73213","73238");
        new EGFMarkChars("1285");
        } else {
        new EGFMarkChars("1286");
        new EGFMarkExpression("73278","73312");
        new EGFMarkChars("1287");
        new EGFMarkExpression("73320","73354");
        new EGFMarkChars("1288");
        new EGFMarkExpression("73363","73388");
        new EGFMarkChars("1289");
        new EGFMarkExpression("73402","73427");
        new EGFMarkChars("1290");
        }
        new EGFMarkChars("1291");
        } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
        new EGFMarkChars("1292");
        new EGFMarkExpression("73560","73584");
        new EGFMarkChars("1293");
        new EGFMarkExpression("73592","73616");
        new EGFMarkChars("1294");
        }
        new EGFMarkChars("1295");
        if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
        new EGFMarkChars("1296");
        if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1297");
        new EGFMarkExpression("73781","73819");
        new EGFMarkChars("1298");
        new EGFMarkExpression("73829","73854");
        new EGFMarkChars("1299");
        } else {
        new EGFMarkChars("1300");
        new EGFMarkExpression("73897","73922");
        new EGFMarkChars("1301");
        }
        new EGFMarkChars("1302");
        }
        new EGFMarkChars("1303");
        if (!genModel.isSuppressNotification()) {
        new EGFMarkChars("1304");
        new EGFMarkExpression("74077","74149");
        new EGFMarkChars("1305");
        new EGFMarkExpression("74161","74231");
        new EGFMarkChars("1306");
        new EGFMarkExpression("74244","74286");
        new EGFMarkExpression("74291","74315");
        new EGFMarkChars("1307");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1308");
        new EGFMarkExpression("74413","74436");
        new EGFMarkChars("1309");
        new EGFMarkExpression("74444","74468");
        } else {
        new EGFMarkChars("1310");
        new EGFMarkExpression("74488","74511");
        }
        new EGFMarkChars("1311");
        new EGFMarkExpression("74523","74547");
        new EGFMarkChars("1312");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1313");
        } else {
        new EGFMarkChars("1314");
        new EGFMarkExpression("74654","74677");
        new EGFMarkChars("1315");
        }
        new EGFMarkChars("1316");
        }
        new EGFMarkChars("1317");
        }
        new EGFMarkChars("1318");
        }
        new EGFMarkChars("1319");
        } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
        new EGFMarkChars("1320");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1321");
        new EGFMarkExpression("74916","74981");
        new EGFMarkChars("1322");
        new EGFMarkExpression("74998","75063");
        new EGFMarkChars("1323");
        new EGFMarkExpression("75089","75122");
        new EGFMarkChars("1324");
        new EGFMarkExpression("75151","75191");
        new EGFMarkChars("1325");
        } else {
        new EGFMarkChars("1326");
        new EGFMarkExpression("75222","75287");
        new EGFMarkChars("1327");
        new EGFMarkExpression("75305","75338");
        new EGFMarkChars("1328");
        new EGFMarkExpression("75353","75393");
        new EGFMarkChars("1329");
        }
        new EGFMarkChars("1330");
        } else if (genClass.getUnsetAccessorOperation(genFeature) != null) {
        new EGFMarkChars("1331");
        new EGFMarkExpression("75492","75585");
        new EGFMarkChars("1332");
        } else {
        new EGFMarkChars("1333");
        new EGFMarkIncludeAlternative("Class/unsetGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("1334");
        new EGFMarkStart();
        new EGFMarkChars("1335");
        new EGFMarkExpression("75756","75785");
        new EGFMarkChars("1336");
        new EGFMarkExpression("75792","75819");
        new EGFMarkChars("1337");
        new EGFMarkEnd();
        //Class/unsetGenFeature.todo.override.javajetinc
        new EGFMarkChars("1338");
        }
        new EGFMarkChars("1339");
        }
        new EGFMarkChars("1340");
        new EGFMarkEnd();
        //Class/unsetGenFeature.override.javajetinc
        new EGFMarkChars("1341");
        }
        new EGFMarkChars("1342");
        if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
        new EGFMarkChars("1343");
        new EGFMarkIncludeAlternative("Class/isSetGenFeature.override.javajetinc");
        new EGFMarkChars("1344");
        new EGFMarkStart();
        new EGFMarkChars("1345");
        if (isInterface) {
        new EGFMarkChars("1346");
        new EGFMarkIncludeAlternative("Class/isSetGenFeature.javadoc.override.javajetinc");
        new EGFMarkChars("1347");
        new EGFMarkStart();
        new EGFMarkChars("1348");
        new EGFMarkExpression("76458","76494");
        new EGFMarkChars("1349");
        new EGFMarkExpression("76500","76527");
        new EGFMarkChars("1350");
        new EGFMarkExpression("76537","76566");
        new EGFMarkChars("1351");
        new EGFMarkExpression("76579","76606");
        new EGFMarkChars("1352");
        new EGFMarkIncludeSilent("Class/isSetGenFeature.javadoc.insert.javajetinc");
        new EGFMarkChars("1353");
        new EGFMarkExpression("76800","76829");
        new EGFMarkChars("1354");
        new EGFMarkExpression("76841","76868");
        new EGFMarkChars("1355");
        if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
        new EGFMarkChars("1356");
        new EGFMarkExpression("76983","77011");
        new EGFMarkChars("1357");
        }
        new EGFMarkChars("1358");
        new EGFMarkExpression("77039","77066");
        new EGFMarkChars("1359");
        if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
        new EGFMarkChars("1360");
        new EGFMarkExpression("77199","77227");
        new EGFMarkChars("1361");
        new EGFMarkExpression("77233","77269");
        new EGFMarkChars("1362");
        }
        new EGFMarkChars("1363");
        new EGFMarkEnd();
        //Class/isSetGenFeature.javadoc.override.javajetinc
        new EGFMarkChars("1364");
        } else {
        new EGFMarkChars("1365");
        if (isJDK50) { //Class/isSetGenFeature.annotations.insert.javajetinc
        new EGFMarkChars("1366");
        new EGFMarkIncludeSilent("Class/isSetGenFeature.annotations.insert.javajetinc");
        new EGFMarkChars("1367");
        }
        new EGFMarkChars("1368");
        }
        new EGFMarkChars("1369");
        if (!isImplementation) {
        new EGFMarkChars("1370");
        new EGFMarkExpression("77680","77708");
        new EGFMarkChars("1371");
        } else {
        new EGFMarkChars("1372");
        new EGFMarkExpression("77752","77780");
        if (genClass.hasCollidingIsSetAccessorOperation(genFeature)) {
        new EGFMarkChars("1373");
        }
        new EGFMarkChars("1374");
        if (genModel.isDynamicDelegation()) {
        new EGFMarkChars("1375");
        new EGFMarkExpression("77932","77974");
        new EGFMarkChars("1376");
        new EGFMarkExpression("77981","78021");
        new EGFMarkChars("1377");
        } else if (genModel.isReflectiveDelegation()) {
        new EGFMarkChars("1378");
        new EGFMarkExpression("78101","78141");
        new EGFMarkChars("1379");
        } else if (!genFeature.isVolatile()) {
        new EGFMarkChars("1380");
        if (genFeature.isListType()) {
        new EGFMarkChars("1381");
        if (genModel.isVirtualDelegation()) {
        new EGFMarkChars("1382");
        new EGFMarkExpression("78289","78325");
        new EGFMarkChars("1383");
        new EGFMarkExpression("78331","78355");
        new EGFMarkChars("1384");
        new EGFMarkExpression("78364","78400");
        new EGFMarkChars("1385");
        new EGFMarkExpression("78418","78460");
        new EGFMarkExpression("78465","78489");
        new EGFMarkChars("1386");
        }
        new EGFMarkChars("1387");
        new EGFMarkExpression("78520","78544");
        new EGFMarkChars("1388");
        new EGFMarkExpression("78563","78631");
        new EGFMarkChars("1389");
        new EGFMarkExpression("78647","78661");
        new EGFMarkChars("1390");
        new EGFMarkExpression("78667","78691");
        new EGFMarkChars("1391");
        } else {
        new EGFMarkChars("1392");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1393");
        new EGFMarkExpression("78832","78874");
        new EGFMarkExpression("78879","78903");
        new EGFMarkChars("1394");
        } else if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1395");
        new EGFMarkExpression("78979","79017");
        new EGFMarkChars("1396");
        new EGFMarkExpression("79025","79050");
        new EGFMarkChars("1397");
        } else {
        new EGFMarkChars("1398");
        new EGFMarkExpression("79102","79127");
        new EGFMarkChars("1399");
        }
        new EGFMarkChars("1400");
        }
        new EGFMarkChars("1401");
        } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
        new EGFMarkChars("1402");
        if (delegateFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1403");
        new EGFMarkExpression("79351","79416");
        new EGFMarkChars("1404");
        new EGFMarkExpression("79433","79498");
        new EGFMarkChars("1405");
        new EGFMarkExpression("79524","79557");
        new EGFMarkChars("1406");
        new EGFMarkExpression("79588","79628");
        new EGFMarkChars("1407");
        } else {
        new EGFMarkChars("1408");
        new EGFMarkExpression("79667","79732");
        new EGFMarkChars("1409");
        new EGFMarkExpression("79750","79783");
        new EGFMarkChars("1410");
        new EGFMarkExpression("79800","79840");
        new EGFMarkChars("1411");
        }
        new EGFMarkChars("1412");
        } else if (genClass.getIsSetAccessorOperation(genFeature) != null) {
        new EGFMarkChars("1413");
        new EGFMarkExpression("79939","80032");
        new EGFMarkChars("1414");
        } else {
        new EGFMarkChars("1415");
        new EGFMarkIncludeAlternative("Class/isSetGenFeature.TODO.override.javajetinc");
        new EGFMarkChars("1416");
        new EGFMarkStart();
        new EGFMarkChars("1417");
        new EGFMarkExpression("80212","80241");
        new EGFMarkChars("1418");
        new EGFMarkExpression("80248","80275");
        new EGFMarkChars("1419");
        new EGFMarkEnd();
        //Class/isSetGenFeature.todo.override.javajetinc
        new EGFMarkChars("1420");
        }
        new EGFMarkChars("1421");
        }
        new EGFMarkChars("1422");
        new EGFMarkEnd();
        //Class/isSetGenFeature.override.javajetinc
        new EGFMarkChars("1423");
        }
        new EGFMarkChars("1424");
        new EGFMarkIncludeSilent("Class/genFeature.insert.javajetinc");
        new EGFMarkChars("1425");
        new EGFMarkEnd();
        //Class/genFeature.override.javajetinc
        new EGFMarkChars("1426");
        }//for
        new EGFMarkChars("1427");
        }}.run();
        new EGFMarkChars("1428");
        for (GenOperation genOperation : (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations())) {
        new EGFMarkChars("1429");
        new EGFMarkIncludeAlternative("Class/genOperation.override.javajetinc");
        new EGFMarkChars("1430");
        new EGFMarkStart();
        new EGFMarkChars("1431");
        if (isInterface) {
        new EGFMarkChars("1432");
        new EGFMarkIncludeAlternative("Class/genOperation.javadoc.override.javajetinc");
        new EGFMarkChars("1433");
        new EGFMarkStart();
        new EGFMarkChars("1434");
        new EGFMarkIncludeSilent("Class/genOperation.javadoc.insert.javajetinc");
        new EGFMarkChars("1435");
        if (genOperation.hasDocumentation() || genOperation.hasParameterDocumentation()) {
        new EGFMarkChars("1436");
        if (genOperation.hasDocumentation()) {
        new EGFMarkChars("1437");
        new EGFMarkExpression("81360","81428");
        new EGFMarkChars("1438");
        }
        new EGFMarkChars("1439");
        for (GenParameter genParameter : genOperation.getGenParameters()) {
        new EGFMarkChars("1440");
        if (genParameter.hasDocumentation()) { String documentation = genParameter.getDocumentation("");
        new EGFMarkChars("1441");
        if (documentation.contains("\n") || documentation.contains("\r")) {
        new EGFMarkChars("1442");
        new EGFMarkExpression("81718","81740");
        new EGFMarkChars("1443");
        new EGFMarkExpression("81752","81820");
        new EGFMarkChars("1444");
        } else {
        new EGFMarkChars("1445");
        new EGFMarkExpression("81858","81880");
        new EGFMarkChars("1446");
        new EGFMarkExpression("81886","81954");
        new EGFMarkChars("1447");
        }
        new EGFMarkChars("1448");
        }
        new EGFMarkChars("1449");
        }
        new EGFMarkChars("1450");
        }
        new EGFMarkChars("1451");
        if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
        new EGFMarkChars("1452");
        new EGFMarkExpression("82322","82331");
        new EGFMarkChars("1453");
        } else {
        new EGFMarkChars("1454");
        new EGFMarkExpression("82363","82372");
        new EGFMarkChars("1455");
        }} if (first) {
        new EGFMarkChars("1456");
        }}
        new EGFMarkChars("1457");
        new EGFMarkEnd();
        //Class/genOperation.javadoc.override.javajetinc
        new EGFMarkChars("1458");
        } else {
        new EGFMarkChars("1459");
        if (isJDK50) { //Class/genOperation.annotations.insert.javajetinc
        new EGFMarkChars("1460");
        new EGFMarkIncludeSilent("Class/genOperation.annotations.insert.javajetinc");
        new EGFMarkChars("1461");
        }
        new EGFMarkChars("1462");
        }
        new EGFMarkChars("1463");
        if (!isImplementation) {
        new EGFMarkChars("1464");
        new EGFMarkExpression("82792","82832");
        new EGFMarkExpression("82837","82875");
        new EGFMarkChars("1465");
        new EGFMarkExpression("82881","82903");
        new EGFMarkChars("1466");
        new EGFMarkExpression("82909","82945");
        new EGFMarkChars("1467");
        new EGFMarkExpression("82951","82983");
        new EGFMarkChars("1468");
        } else {
        new EGFMarkChars("1469");
        new EGFMarkExpression("83012","83052");
        new EGFMarkExpression("83057","83095");
        new EGFMarkChars("1470");
        new EGFMarkExpression("83101","83123");
        new EGFMarkChars("1471");
        new EGFMarkExpression("83129","83165");
        new EGFMarkChars("1472");
        new EGFMarkExpression("83171","83203");
        new EGFMarkChars("1473");
        if (genOperation.hasBody()) {
        new EGFMarkChars("1474");
        new EGFMarkExpression("83250","83309");
        new EGFMarkChars("1475");
        } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = genOperation.getGenParameters().get(0).getName(); String context = genOperation.getGenParameters().get(1).getName();
        new EGFMarkChars("1476");
        new EGFMarkExpression("83803","83814");
        new EGFMarkChars("1477");
        new EGFMarkExpression("83838","83849");
        new EGFMarkChars("1478");
        new EGFMarkExpression("83869","83940");
        new EGFMarkChars("1479");
        new EGFMarkExpression("83953","84019");
        new EGFMarkChars("1480");
        new EGFMarkExpression("84039","84094");
        new EGFMarkChars("1481");
        new EGFMarkExpression("84126","84181");
        new EGFMarkChars("1482");
        new EGFMarkExpression("84187","84223");
        new EGFMarkChars("1483");
        new EGFMarkExpression("84237","84305");
        new EGFMarkChars("1484");
        new EGFMarkExpression("84381","84403");
        new EGFMarkChars("1485");
        new EGFMarkExpression("84411","84482");
        new EGFMarkChars("1486");
        new EGFMarkExpression("84509","84516");
        new EGFMarkChars("1487");
        new EGFMarkExpression("84526","84546");
        new EGFMarkExpression("84551","84572");
        new EGFMarkChars("1488");
        } else {
        new EGFMarkChars("1489");
        new EGFMarkIncludeAlternative("Class/implementedGenOperation.TODO.override.javajetinc");
        new EGFMarkChars("1490");
        new EGFMarkStart();
        new EGFMarkChars("1491");
        new EGFMarkEnd();
        //Class/implementedGenOperation.todo.override.javajetinc
        new EGFMarkChars("1492");
        }
        new EGFMarkChars("1493");
        }
        new EGFMarkChars("1494");
        new EGFMarkIncludeSilent("Class/genOperation.insert.javajetinc");
        new EGFMarkChars("1495");
        new EGFMarkEnd();
        //Class/implementedGenOperation.override.javajetinc
        new EGFMarkChars("1496");
        }//for
        new EGFMarkChars("1497");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
        new EGFMarkChars("1498");
        if (genModel.useGenerics()) {
        new EGFMarkChars("1499");
        for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
        new EGFMarkChars("1500");
        if (genFeature.isUncheckedCast(genClass)) {
        new EGFMarkChars("1501");
        break; }
        new EGFMarkChars("1502");
        }
        new EGFMarkChars("1503");
        }
        new EGFMarkChars("1504");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1505");
        }
        new EGFMarkChars("1506");
        new EGFMarkExpression("85681","85756");
        new EGFMarkChars("1507");
        new EGFMarkExpression("85774","85839");
        new EGFMarkChars("1508");
        new EGFMarkExpression("85870","85945");
        new EGFMarkChars("1509");
        new EGFMarkExpression("85979","86003");
        new EGFMarkChars("1510");
        for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
        new EGFMarkChars("1511");
        new EGFMarkExpression("86095","86137");
        new EGFMarkChars("1512");
        if (genFeature.isListType()) { String cast = "("  + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList") + (!genModel.useGenerics() ? ")" : "<" + genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject") + ">)(" + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList") + "<?>)");
        new EGFMarkChars("1513");
        if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
        new EGFMarkChars("1514");
        new EGFMarkExpression("86563","86567");
        new EGFMarkChars("1515");
        new EGFMarkExpression("86573","86633");
        new EGFMarkChars("1516");
        new EGFMarkExpression("86654","86706");
        new EGFMarkChars("1517");
        new EGFMarkExpression("86712","86739");
        new EGFMarkChars("1518");
        } else {
        new EGFMarkChars("1519");
        new EGFMarkExpression("86811","86815");
        new EGFMarkExpression("86820","86847");
        new EGFMarkChars("1520");
        }
        new EGFMarkChars("1521");
        } else if (genFeature.isContainer()) {
        new EGFMarkChars("1522");
        if (genFeature.isBasicSet()) {
        new EGFMarkChars("1523");
        new EGFMarkExpression("87078","87106");
        new EGFMarkChars("1524");
        new EGFMarkExpression("87113","87149");
        new EGFMarkChars("1525");
        } else {
        new EGFMarkChars("1526");
        new EGFMarkExpression("87229","87271");
        new EGFMarkExpression("87276","87300");
        new EGFMarkChars("1527");
        }
        new EGFMarkChars("1528");
        } else {
        new EGFMarkChars("1529");
        if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1530");
        new EGFMarkExpression("87425","87461");
        new EGFMarkChars("1531");
        new EGFMarkExpression("87467","87491");
        new EGFMarkChars("1532");
        new EGFMarkExpression("87500","87536");
        new EGFMarkChars("1533");
        new EGFMarkExpression("87554","87596");
        new EGFMarkExpression("87601","87625");
        new EGFMarkChars("1534");
        } else if (genFeature.isVolatile() || genClass.getImplementingGenModel(genFeature).isDynamicDelegation()) {
        new EGFMarkChars("1535");
        new EGFMarkExpression("87753","87789");
        new EGFMarkChars("1536");
        new EGFMarkExpression("87795","87819");
        new EGFMarkChars("1537");
        if (genFeature.isResolveProxies()) {
        new EGFMarkChars("1538");
        new EGFMarkExpression("87875","87903");
        } else {
        new EGFMarkExpression("87920","87947");
        }
        new EGFMarkChars("1539");
        }
        new EGFMarkChars("1540");
        new EGFMarkExpression("87979","88003");
        new EGFMarkChars("1541");
        if (genFeature.isEffectiveContains()) {
        new EGFMarkChars("1542");
        new EGFMarkExpression("88080","88145");
        new EGFMarkChars("1543");
        new EGFMarkExpression("88151","88175");
        new EGFMarkChars("1544");
        new EGFMarkExpression("88228","88270");
        new EGFMarkExpression("88275","88299");
        new EGFMarkChars("1545");
        } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("1546");
        new EGFMarkExpression("88589","88654");
        new EGFMarkChars("1547");
        new EGFMarkExpression("88660","88684");
        new EGFMarkChars("1548");
        new EGFMarkExpression("88712","88761");
        new EGFMarkExpression("88766","88789");
        new EGFMarkChars("1549");
        new EGFMarkExpression("88796","88837");
        new EGFMarkChars("1550");
        }
        new EGFMarkChars("1551");
        new EGFMarkExpression("88886","88914");
        new EGFMarkChars("1552");
        new EGFMarkExpression("88921","88957");
        new EGFMarkChars("1553");
        }
        new EGFMarkChars("1554");
        }
        new EGFMarkChars("1555");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1556");
        } else {
        new EGFMarkChars("1557");
        }
        new EGFMarkChars("1558");
        }
        new EGFMarkChars("1559");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
        new EGFMarkChars("1560");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1561");
        }
        new EGFMarkChars("1562");
        new EGFMarkExpression("89477","89552");
        new EGFMarkChars("1563");
        new EGFMarkExpression("89573","89638");
        new EGFMarkChars("1564");
        new EGFMarkExpression("89669","89744");
        new EGFMarkChars("1565");
        new EGFMarkExpression("89778","89802");
        new EGFMarkChars("1566");
        for (GenFeature genFeature : genClass.getEInverseRemoveGenFeatures()) {
        new EGFMarkChars("1567");
        new EGFMarkExpression("89897","89939");
        new EGFMarkChars("1568");
        if (genFeature.isListType()) {
        new EGFMarkChars("1569");
        if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
        new EGFMarkChars("1570");
        new EGFMarkExpression("90078","90146");
        new EGFMarkExpression("90151","90165");
        new EGFMarkChars("1571");
        new EGFMarkExpression("90173","90233");
        new EGFMarkChars("1572");
        new EGFMarkExpression("90254","90306");
        new EGFMarkChars("1573");
        new EGFMarkExpression("90312","90339");
        new EGFMarkChars("1574");
        } else if (genFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1575");
        new EGFMarkExpression("90457","90525");
        new EGFMarkExpression("90530","90544");
        new EGFMarkChars("1576");
        new EGFMarkExpression("90552","90617");
        new EGFMarkChars("1577");
        new EGFMarkExpression("90640","90667");
        new EGFMarkChars("1578");
        } else {
        new EGFMarkChars("1579");
        new EGFMarkExpression("90749","90817");
        new EGFMarkExpression("90822","90836");
        new EGFMarkChars("1580");
        new EGFMarkExpression("90842","90869");
        new EGFMarkChars("1581");
        }
        new EGFMarkChars("1582");
        } else if (genFeature.isContainer() && !genFeature.isBasicSet()) {
        new EGFMarkChars("1583");
        new EGFMarkExpression("91026","91068");
        new EGFMarkExpression("91073","91097");
        new EGFMarkChars("1584");
        } else if (genFeature.isUnsettable()) {
        new EGFMarkChars("1585");
        new EGFMarkExpression("91178","91206");
        new EGFMarkChars("1586");
        } else {
        new EGFMarkChars("1587");
        new EGFMarkExpression("91253","91281");
        new EGFMarkChars("1588");
        }
        new EGFMarkChars("1589");
        }
        new EGFMarkChars("1590");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1591");
        } else {
        new EGFMarkChars("1592");
        }
        new EGFMarkChars("1593");
        }
        new EGFMarkChars("1594");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
        new EGFMarkChars("1595");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1596");
        }
        new EGFMarkChars("1597");
        new EGFMarkExpression("91814","91889");
        new EGFMarkChars("1598");
        new EGFMarkExpression("91928","92003");
        new EGFMarkChars("1599");
        new EGFMarkExpression("92049","92073");
        new EGFMarkChars("1600");
        for (GenFeature genFeature : genClass.getEBasicRemoveFromContainerGenFeatures()) {
        new EGFMarkChars("1601");
        GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
        new EGFMarkChars("1602");
        new EGFMarkExpression("92424","92466");
        new EGFMarkChars("1603");
        new EGFMarkExpression("92526","92575");
        new EGFMarkExpression("92580","92603");
        new EGFMarkChars("1604");
        new EGFMarkExpression("92610","92651");
        new EGFMarkChars("1605");
        }
        new EGFMarkChars("1606");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1607");
        } else {
        new EGFMarkChars("1608");
        }
        new EGFMarkChars("1609");
        }
        new EGFMarkChars("1610");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEGetGenFeatures())) {
        new EGFMarkChars("1611");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1612");
        }
        new EGFMarkChars("1613");
        new EGFMarkExpression("93227","93251");
        new EGFMarkChars("1614");
        for (GenFeature genFeature : genClass.getEGetGenFeatures()) {
        new EGFMarkChars("1615");
        new EGFMarkExpression("93336","93378");
        new EGFMarkChars("1616");
        if (genFeature.isPrimitiveType()) {
        new EGFMarkChars("1617");
        if (isJDK50) {
        new EGFMarkChars("1618");
        new EGFMarkExpression("93461","93488");
        new EGFMarkChars("1619");
        } else if (genFeature.isBooleanType()) {
        new EGFMarkChars("1620");
        new EGFMarkExpression("93557","93584");
        new EGFMarkChars("1621");
        } else {
        new EGFMarkChars("1622");
        new EGFMarkExpression("93656","93690");
        new EGFMarkChars("1623");
        new EGFMarkExpression("93696","93723");
        new EGFMarkChars("1624");
        }
        new EGFMarkChars("1625");
        } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
        new EGFMarkChars("1626");
        new EGFMarkExpression("93845","93872");
        new EGFMarkChars("1627");
        new EGFMarkExpression("93900","93928");
        new EGFMarkChars("1628");
        } else if (genFeature.isMapType()) {
        new EGFMarkChars("1629");
        if (genFeature.isEffectiveSuppressEMFTypes()) {
        new EGFMarkChars("1630");
        new EGFMarkExpression("94063","94123");
        new EGFMarkChars("1631");
        new EGFMarkExpression("94144","94196");
        new EGFMarkChars("1632");
        new EGFMarkExpression("94202","94229");
        new EGFMarkChars("1633");
        new EGFMarkExpression("94262","94289");
        new EGFMarkChars("1634");
        } else {
        new EGFMarkChars("1635");
        new EGFMarkExpression("94340","94367");
        new EGFMarkChars("1636");
        new EGFMarkExpression("94392","94419");
        new EGFMarkChars("1637");
        }
        new EGFMarkChars("1638");
        } else if (genFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1639");
        new EGFMarkExpression("94528","94593");
        new EGFMarkChars("1640");
        new EGFMarkExpression("94616","94643");
        new EGFMarkChars("1641");
        new EGFMarkExpression("94677","94704");
        new EGFMarkChars("1642");
        } else if (genFeature.isFeatureMapType()) {
        new EGFMarkChars("1643");
        new EGFMarkExpression("94788","94815");
        new EGFMarkChars("1644");
        new EGFMarkExpression("94837","94902");
        new EGFMarkChars("1645");
        new EGFMarkExpression("94917","94944");
        new EGFMarkChars("1646");
        } else {
        new EGFMarkChars("1647");
        new EGFMarkExpression("94993","95020");
        new EGFMarkChars("1648");
        }
        new EGFMarkChars("1649");
        }
        new EGFMarkChars("1650");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1651");
        } else {
        new EGFMarkChars("1652");
        }
        new EGFMarkChars("1653");
        }
        new EGFMarkChars("1654");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
        new EGFMarkChars("1655");
        if (genModel.useGenerics()) {
        new EGFMarkChars("1656");
        for (GenFeature genFeature : genClass.getESetGenFeatures()) {
        new EGFMarkChars("1657");
        if (genFeature.isUncheckedCast(genClass) && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
        new EGFMarkChars("1658");
        break; }
        new EGFMarkChars("1659");
        }
        new EGFMarkChars("1660");
        }
        new EGFMarkChars("1661");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1662");
        }
        new EGFMarkChars("1663");
        new EGFMarkExpression("95862","95886");
        new EGFMarkChars("1664");
        for (GenFeature genFeature : genClass.getESetGenFeatures()) {
        new EGFMarkChars("1665");
        new EGFMarkExpression("95973","96015");
        new EGFMarkChars("1666");
        if (genFeature.isListType()) {
        new EGFMarkChars("1667");
        if (genFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1668");
        new EGFMarkExpression("96121","96186");
        new EGFMarkChars("1669");
        new EGFMarkExpression("96203","96268");
        new EGFMarkChars("1670");
        new EGFMarkExpression("96291","96318");
        new EGFMarkChars("1671");
        } else if (genFeature.isFeatureMapType()) {
        new EGFMarkChars("1672");
        new EGFMarkExpression("96416","96481");
        new EGFMarkChars("1673");
        new EGFMarkExpression("96496","96523");
        new EGFMarkChars("1674");
        } else if (genFeature.isMapType()) {
        new EGFMarkChars("1675");
        if (genFeature.isEffectiveSuppressEMFTypes()) {
        new EGFMarkChars("1676");
        new EGFMarkExpression("96660","96728");
        new EGFMarkChars("1677");
        new EGFMarkExpression("96744","96804");
        new EGFMarkChars("1678");
        new EGFMarkExpression("96825","96877");
        new EGFMarkChars("1679");
        new EGFMarkExpression("96883","96910");
        new EGFMarkChars("1680");
        } else {
        new EGFMarkChars("1681");
        new EGFMarkExpression("96969","97037");
        new EGFMarkChars("1682");
        new EGFMarkExpression("97051","97078");
        new EGFMarkChars("1683");
        }
        new EGFMarkChars("1684");
        } else {
        new EGFMarkChars("1685");
        new EGFMarkExpression("97139","97166");
        new EGFMarkChars("1686");
        new EGFMarkExpression("97187","97214");
        new EGFMarkChars("1687");
        new EGFMarkExpression("97230","97278");
        if (isJDK50) {
        new EGFMarkChars("1688");
        new EGFMarkExpression("97312","97348");
        new EGFMarkChars("1689");
        }
        new EGFMarkChars("1690");
        }
        new EGFMarkChars("1691");
        } else if (!isJDK50 && genFeature.isPrimitiveType()) {
        new EGFMarkChars("1692");
        new EGFMarkExpression("97453","97481");
        new EGFMarkChars("1693");
        new EGFMarkExpression("97489","97523");
        new EGFMarkChars("1694");
        new EGFMarkExpression("97539","97577");
        new EGFMarkChars("1695");
        } else {
        new EGFMarkChars("1696");
        new EGFMarkExpression("97611","97639");
        new EGFMarkChars("1697");
        if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType() || !genFeature.getRawType().equals(genFeature.getType(genClass))) {
        new EGFMarkChars("1698");
        new EGFMarkExpression("97812","97846");
        new EGFMarkChars("1699");
        }
        new EGFMarkChars("1700");
        }
        new EGFMarkChars("1701");
        }
        new EGFMarkChars("1702");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1703");
        } else {
        new EGFMarkChars("1704");
        }
        new EGFMarkChars("1705");
        }
        new EGFMarkChars("1706");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEUnsetGenFeatures())) {
        new EGFMarkChars("1707");
        new EGFMarkIncludeAlternative("Class/eUnset.override.javajetinc");
        new EGFMarkChars("1708");
        new EGFMarkStart();
        new EGFMarkChars("1709");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1710");
        }
        new EGFMarkChars("1711");
        new EGFMarkExpression("98475","98499");
        new EGFMarkChars("1712");
        for (GenFeature genFeature : genClass.getEUnsetGenFeatures()) {
        new EGFMarkChars("1713");
        new EGFMarkExpression("98588","98630");
        new EGFMarkChars("1714");
        if (genFeature.isListType() && !genFeature.isUnsettable()) {
        new EGFMarkChars("1715");
        if (genFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1716");
        new EGFMarkExpression("98766","98831");
        new EGFMarkChars("1717");
        new EGFMarkExpression("98854","98881");
        new EGFMarkChars("1718");
        } else {
        new EGFMarkChars("1719");
        new EGFMarkExpression("98935","98962");
        new EGFMarkChars("1720");
        }
        new EGFMarkChars("1721");
        } else if (genFeature.isUnsettable()) {
        new EGFMarkChars("1722");
        new EGFMarkExpression("99048","99076");
        new EGFMarkChars("1723");
        } else if (!genFeature.hasEDefault()) {
        new EGFMarkChars("1724");
        new EGFMarkExpression("99140","99168");
        new EGFMarkChars("1725");
        new EGFMarkExpression("99175","99211");
        new EGFMarkChars("1726");
        } else {
        new EGFMarkChars("1727");
        new EGFMarkExpression("99248","99276");
        new EGFMarkChars("1728");
        new EGFMarkExpression("99282","99306");
        new EGFMarkChars("1729");
        }
        new EGFMarkChars("1730");
        }
        new EGFMarkChars("1731");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1732");
        } else {
        new EGFMarkChars("1733");
        }
        new EGFMarkChars("1734");
        new EGFMarkEnd();
        //Class/eUnset.override.javajetinc
        new EGFMarkChars("1735");
        }
        new EGFMarkChars("1736");
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEIsSetGenFeatures())) {
        new EGFMarkChars("1737");
        new EGFMarkIncludeAlternative("Class/eIsSet.override.javajetinc");
        new EGFMarkChars("1738");
        new EGFMarkStart();
        new EGFMarkChars("1739");
        if (genModel.useGenerics()) {
        new EGFMarkChars("1740");
        for (GenFeature genFeature : genClass.getEIsSetGenFeatures()) {
        new EGFMarkChars("1741");
        if (genFeature.isListType() && !genFeature.isUnsettable() && !genFeature.isWrappedFeatureMapType() && !genClass.isField(genFeature) && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1742");
        break; }
        new EGFMarkChars("1743");
        }
        new EGFMarkChars("1744");
        }
        new EGFMarkChars("1745");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1746");
        }
        new EGFMarkChars("1747");
        new EGFMarkExpression("100373","100397");
        new EGFMarkChars("1748");
        for (GenFeature genFeature : genClass.getEIsSetGenFeatures()) { String safeNameAccessor = genFeature.getSafeName(); if ("featureID".equals(safeNameAccessor)) { safeNameAccessor = "this." + safeNameAccessor; }
        new EGFMarkChars("1749");
        new EGFMarkExpression("100629","100671");
        new EGFMarkChars("1750");
        if (genFeature.isListType() && !genFeature.isUnsettable()) {
        new EGFMarkChars("1751");
        if (genFeature.isWrappedFeatureMapType()) {
        new EGFMarkChars("1752");
        if (genFeature.isVolatile()) {
        new EGFMarkChars("1753");
        new EGFMarkExpression("100852","100917");
        new EGFMarkChars("1754");
        new EGFMarkExpression("100940","100967");
        new EGFMarkChars("1755");
        } else {
        new EGFMarkChars("1756");
        new EGFMarkExpression("101030","101046");
        new EGFMarkChars("1757");
        new EGFMarkExpression("101064","101080");
        new EGFMarkChars("1758");
        }
        new EGFMarkChars("1759");
        } else {
        new EGFMarkChars("1760");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("1761");
        new EGFMarkExpression("101196","101212");
        new EGFMarkChars("1762");
        new EGFMarkExpression("101230","101246");
        new EGFMarkChars("1763");
        } else {
        new EGFMarkChars("1764");
        if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1765");
        new EGFMarkExpression("101396","101432");
        new EGFMarkChars("1766");
        new EGFMarkExpression("101438","101454");
        new EGFMarkChars("1767");
        new EGFMarkExpression("101463","101499");
        new EGFMarkChars("1768");
        new EGFMarkExpression("101517","101559");
        new EGFMarkExpression("101564","101588");
        new EGFMarkChars("1769");
        new EGFMarkExpression("101607","101623");
        new EGFMarkChars("1770");
        new EGFMarkExpression("101641","101657");
        new EGFMarkChars("1771");
        } else {
        new EGFMarkChars("1772");
        new EGFMarkExpression("101707","101734");
        new EGFMarkChars("1773");
        }
        new EGFMarkChars("1774");
        }
        new EGFMarkChars("1775");
        }
        new EGFMarkChars("1776");
        } else if (genFeature.isUnsettable()) {
        new EGFMarkChars("1777");
        new EGFMarkExpression("101851","101879");
        new EGFMarkChars("1778");
        } else if (genFeature.isResolveProxies()) {
        new EGFMarkChars("1779");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("1780");
        new EGFMarkExpression("101993","102009");
        new EGFMarkChars("1781");
        } else {
        new EGFMarkChars("1782");
        if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1783");
        new EGFMarkExpression("102172","102214");
        new EGFMarkExpression("102219","102243");
        new EGFMarkChars("1784");
        } else {
        new EGFMarkChars("1785");
        new EGFMarkExpression("102297","102325");
        new EGFMarkChars("1786");
        }
        new EGFMarkChars("1787");
        }
        new EGFMarkChars("1788");
        } else if (!genFeature.hasEDefault()) {
        new EGFMarkChars("1789");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("1790");
        new EGFMarkExpression("102465","102481");
        new EGFMarkChars("1791");
        } else {
        new EGFMarkChars("1792");
        if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1793");
        new EGFMarkExpression("102644","102686");
        new EGFMarkExpression("102691","102715");
        new EGFMarkChars("1794");
        } else {
        new EGFMarkChars("1795");
        new EGFMarkExpression("102761","102788");
        new EGFMarkChars("1796");
        }
        new EGFMarkChars("1797");
        }
        new EGFMarkChars("1798");
        } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
        new EGFMarkChars("1799");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("1800");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("1801");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("1802");
        new EGFMarkExpression("103051","103085");
        new EGFMarkChars("1803");
        new EGFMarkExpression("103093","103118");
        new EGFMarkChars("1804");
        new EGFMarkExpression("103140","103164");
        new EGFMarkChars("1805");
        } else {
        new EGFMarkChars("1806");
        new EGFMarkExpression("103204","103238");
        new EGFMarkChars("1807");
        new EGFMarkExpression("103246","103271");
        new EGFMarkChars("1808");
        new EGFMarkExpression("103287","103312");
        new EGFMarkChars("1809");
        }
        new EGFMarkChars("1810");
        } else {
        new EGFMarkChars("1811");
        new EGFMarkExpression("103377","103393");
        new EGFMarkChars("1812");
        new EGFMarkExpression("103402","103426");
        new EGFMarkChars("1813");
        }
        new EGFMarkChars("1814");
        } else {
        new EGFMarkChars("1815");
        if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1816");
        new EGFMarkExpression("103620","103662");
        new EGFMarkExpression("103667","103691");
        new EGFMarkChars("1817");
        new EGFMarkExpression("103698","103722");
        new EGFMarkChars("1818");
        new EGFMarkExpression("103732","103756");
        new EGFMarkChars("1819");
        } else {
        new EGFMarkChars("1820");
        new EGFMarkExpression("103793","103820");
        new EGFMarkChars("1821");
        new EGFMarkExpression("103831","103855");
        new EGFMarkChars("1822");
        }
        new EGFMarkChars("1823");
        }
        new EGFMarkChars("1824");
        } else {//datatype
        new EGFMarkChars("1825");
        if (genClass.isField(genFeature)) {
        new EGFMarkChars("1826");
        new EGFMarkExpression("103964","103988");
        new EGFMarkChars("1827");
        new EGFMarkExpression("104004","104020");
        new EGFMarkChars("1828");
        new EGFMarkExpression("104037","104061");
        new EGFMarkChars("1829");
        new EGFMarkExpression("104074","104090");
        new EGFMarkChars("1830");
        } else {
        new EGFMarkChars("1831");
        if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
        new EGFMarkChars("1832");
        new EGFMarkExpression("104227","104263");
        new EGFMarkChars("1833");
        new EGFMarkExpression("104269","104285");
        new EGFMarkChars("1834");
        new EGFMarkExpression("104294","104330");
        new EGFMarkChars("1835");
        new EGFMarkExpression("104348","104390");
        new EGFMarkExpression("104395","104419");
        new EGFMarkChars("1836");
        new EGFMarkExpression("104426","104450");
        new EGFMarkChars("1837");
        new EGFMarkExpression("104469","104493");
        new EGFMarkChars("1838");
        new EGFMarkExpression("104509","104525");
        new EGFMarkChars("1839");
        new EGFMarkExpression("104542","104566");
        new EGFMarkChars("1840");
        new EGFMarkExpression("104579","104595");
        new EGFMarkChars("1841");
        } else {
        new EGFMarkChars("1842");
        new EGFMarkExpression("104633","104657");
        new EGFMarkChars("1843");
        new EGFMarkExpression("104673","104700");
        new EGFMarkChars("1844");
        new EGFMarkExpression("104719","104743");
        new EGFMarkChars("1845");
        new EGFMarkExpression("104756","104783");
        new EGFMarkChars("1846");
        }
        new EGFMarkChars("1847");
        }
        new EGFMarkChars("1848");
        }
        new EGFMarkChars("1849");
        }
        new EGFMarkChars("1850");
        if (genModel.isMinimalReflectiveMethods()) {
        new EGFMarkChars("1851");
        } else {
        new EGFMarkChars("1852");
        }
        new EGFMarkChars("1853");
        new EGFMarkEnd();
        //Class/eIsSet.override.javajetinc
        new EGFMarkChars("1854");
        }
        new EGFMarkChars("1855");
        if (isImplementation && (!genClass.getMixinGenFeatures().isEmpty() || genClass.hasOffsetCorrection() && !genClass.getGenFeatures().isEmpty())) {
        new EGFMarkChars("1856");
        if (!genClass.getMixinGenFeatures().isEmpty()) {
        new EGFMarkChars("1857");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1858");
        }
        new EGFMarkChars("1859");
        new EGFMarkExpression("105450","105464");
        new EGFMarkChars("1860");
        for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
        new EGFMarkChars("1861");
        new EGFMarkExpression("105574","105617");
        new EGFMarkChars("1862");
        new EGFMarkExpression("105661","105685");
        new EGFMarkChars("1863");
        for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
        new EGFMarkChars("1864");
        new EGFMarkExpression("105779","105821");
        new EGFMarkChars("1865");
        new EGFMarkExpression("105835","105882");
        new EGFMarkChars("1866");
        }
        new EGFMarkChars("1867");
        }
        new EGFMarkChars("1868");
        }
        new EGFMarkChars("1869");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1870");
        }
        new EGFMarkChars("1871");
        new EGFMarkExpression("106239","106253");
        new EGFMarkChars("1872");
        for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
        new EGFMarkChars("1873");
        new EGFMarkExpression("106361","106404");
        new EGFMarkChars("1874");
        for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
        new EGFMarkChars("1875");
        new EGFMarkExpression("106532","106579");
        new EGFMarkChars("1876");
        new EGFMarkExpression("106593","106635");
        new EGFMarkExpression("106640","106664");
        new EGFMarkChars("1877");
        }
        new EGFMarkChars("1878");
        }
        new EGFMarkChars("1879");
        if (genClass.hasOffsetCorrection() && !genClass.getGenFeatures().isEmpty()) {
        new EGFMarkChars("1880");
        new EGFMarkExpression("106825","106863");
        new EGFMarkChars("1881");
        new EGFMarkExpression("106904","106928");
        new EGFMarkChars("1882");
        for (GenFeature genFeature : genClass.getGenFeatures()) {
        new EGFMarkChars("1883");
        new EGFMarkExpression("107015","107057");
        new EGFMarkChars("1884");
        new EGFMarkExpression("107071","107113");
        new EGFMarkExpression("107118","107142");
        new EGFMarkChars("1885");
        }
        new EGFMarkChars("1886");
        }
        new EGFMarkChars("1887");
        }
        new EGFMarkChars("1888");
        if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
        new EGFMarkChars("1889");
        if (eVirtualValuesField != null) {
        new EGFMarkChars("1890");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1891");
        }
        new EGFMarkChars("1892");
        new EGFMarkExpression("107645","107664");
        new EGFMarkChars("1893");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1894");
        }
        new EGFMarkChars("1895");
        new EGFMarkExpression("107883","107902");
        new EGFMarkChars("1896");
        }
        new EGFMarkChars("1897");
        { List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
        new EGFMarkChars("1898");
        if (!eVirtualIndexBitFields.isEmpty()) { List<String> allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList<String>());
        new EGFMarkChars("1899");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1900");
        }
        new EGFMarkChars("1901");
        for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
        new EGFMarkChars("1902");
        new EGFMarkExpression("108492","108493");
        new EGFMarkChars("1903");
        new EGFMarkExpression("108512","108544");
        new EGFMarkChars("1904");
        }
        new EGFMarkChars("1905");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1906");
        }
        new EGFMarkChars("1907");
        for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
        new EGFMarkChars("1908");
        new EGFMarkExpression("108947","108948");
        new EGFMarkChars("1909");
        new EGFMarkExpression("108960","108992");
        new EGFMarkChars("1910");
        }
        new EGFMarkChars("1911");
        }
        new EGFMarkChars("1912");
        }
        new EGFMarkChars("1913");
        }
        new EGFMarkChars("1914");
        if (!genClass.hasImplementedToStringGenOperation() && isImplementation && !genModel.isReflectiveDelegation() && !genModel.isDynamicDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
        new EGFMarkChars("1915");
        if (genModel.useClassOverrideAnnotation()) {
        new EGFMarkChars("1916");
        }
        new EGFMarkChars("1917");
        { boolean first = true;
        new EGFMarkChars("1918");
        for (GenFeature genFeature : genClass.getToStringGenFeatures()) {
        new EGFMarkChars("1919");
        if (first) { first = false;
        new EGFMarkChars("1920");
        new EGFMarkExpression("109767","109787");
        new EGFMarkChars("1921");
        new EGFMarkExpression("109797","109817");
        new EGFMarkChars("1922");
        } else {
        new EGFMarkChars("1923");
        new EGFMarkExpression("109861","109881");
        new EGFMarkChars("1924");
        new EGFMarkExpression("109891","109911");
        new EGFMarkChars("1925");
        }
        new EGFMarkChars("1926");
        if (genFeature.isUnsettable() && !genFeature.isListType()) {
        new EGFMarkChars("1927");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1928");
        new EGFMarkExpression("110103","110145");
        new EGFMarkExpression("110150","110174");
        new EGFMarkChars("1929");
        new EGFMarkExpression("110208","110250");
        new EGFMarkExpression("110255","110279");
        new EGFMarkChars("1930");
        new EGFMarkExpression("110318","110338");
        new EGFMarkChars("1931");
        } else {
        new EGFMarkChars("1932");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("1933");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("1934");
        if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1935");
        new EGFMarkExpression("110513","110551");
        new EGFMarkChars("1936");
        new EGFMarkExpression("110559","110584");
        new EGFMarkChars("1937");
        } else {
        new EGFMarkExpression("110616","110641");
        new EGFMarkChars("1938");
        }
        new EGFMarkChars("1939");
        new EGFMarkExpression("110672","110706");
        new EGFMarkChars("1940");
        new EGFMarkExpression("110714","110739");
        new EGFMarkChars("1941");
        new EGFMarkExpression("110789","110809");
        new EGFMarkChars("1942");
        } else {
        new EGFMarkChars("1943");
        if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1944");
        new EGFMarkExpression("110889","110927");
        new EGFMarkChars("1945");
        new EGFMarkExpression("110935","110960");
        new EGFMarkChars("1946");
        } else {
        new EGFMarkExpression("110992","111017");
        new EGFMarkChars("1947");
        }
        new EGFMarkChars("1948");
        new EGFMarkExpression("111047","111072");
        new EGFMarkChars("1949");
        new EGFMarkExpression("111092","111126");
        new EGFMarkChars("1950");
        new EGFMarkExpression("111134","111159");
        new EGFMarkChars("1951");
        new EGFMarkExpression("111176","111201");
        new EGFMarkChars("1952");
        new EGFMarkExpression("111253","111273");
        new EGFMarkChars("1953");
        }
        new EGFMarkChars("1954");
        } else {
        new EGFMarkChars("1955");
        if (genClass.isESetFlag(genFeature)) {
        new EGFMarkChars("1956");
        new EGFMarkExpression("111369","111407");
        new EGFMarkChars("1957");
        new EGFMarkExpression("111415","111440");
        new EGFMarkChars("1958");
        } else {
        new EGFMarkExpression("111472","111497");
        new EGFMarkChars("1959");
        }
        new EGFMarkChars("1960");
        new EGFMarkExpression("111527","111551");
        new EGFMarkChars("1961");
        new EGFMarkExpression("111589","111609");
        new EGFMarkChars("1962");
        }
        new EGFMarkChars("1963");
        }
        new EGFMarkChars("1964");
        } else {
        new EGFMarkChars("1965");
        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
        new EGFMarkChars("1966");
        new EGFMarkExpression("111775","111817");
        new EGFMarkExpression("111822","111846");
        if (!genFeature.isListType() && !genFeature.isReferenceType()){
        new EGFMarkChars("1967");
        new EGFMarkExpression("111920","111944");
        }
        new EGFMarkChars("1968");
        } else {
        new EGFMarkChars("1969");
        if (genClass.isFlag(genFeature)) {
        new EGFMarkChars("1970");
        if (genFeature.isBooleanType()) {
        new EGFMarkChars("1971");
        new EGFMarkExpression("112093","112127");
        new EGFMarkChars("1972");
        new EGFMarkExpression("112135","112160");
        new EGFMarkChars("1973");
        } else {
        new EGFMarkChars("1974");
        new EGFMarkExpression("112219","112244");
        new EGFMarkChars("1975");
        new EGFMarkExpression("112264","112298");
        new EGFMarkChars("1976");
        new EGFMarkExpression("112306","112331");
        new EGFMarkChars("1977");
        new EGFMarkExpression("112348","112373");
        new EGFMarkChars("1978");
        }
        new EGFMarkChars("1979");
        } else {
        new EGFMarkChars("1980");
        new EGFMarkExpression("112450","112474");
        new EGFMarkChars("1981");
        }
        new EGFMarkChars("1982");
        }
        new EGFMarkChars("1983");
        }
        new EGFMarkChars("1984");
        }
        new EGFMarkChars("1985");
        }
        new EGFMarkChars("1986");
        }
        new EGFMarkChars("1987");
        if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
        new EGFMarkChars("1988");
        String objectType = genModel.getImportedName("java.lang.Object");
        new EGFMarkChars("1989");
        String keyType = isJDK50 ? keyFeature.getObjectType(genClass) : objectType;
        new EGFMarkChars("1990");
        String valueType = isJDK50 ? valueFeature.getObjectType(genClass) : objectType;
        new EGFMarkChars("1991");
        String eMapType = genModel.getImportedName("org.eclipse.emf.common.util.EMap") + (isJDK50 ? "<" + keyType + ", " + valueType + ">" : "");
        new EGFMarkChars("1992");
        new EGFMarkExpression("113386","113396");
        new EGFMarkChars("1993");
        new EGFMarkExpression("113720","113727");
        new EGFMarkChars("1994");
        if (!isJDK50 && keyFeature.isPrimitiveType()) {
        new EGFMarkChars("1995");
        new EGFMarkExpression("113812","113846");
        new EGFMarkChars("1996");
        } else {
        new EGFMarkChars("1997");
        }
        new EGFMarkChars("1998");
        new EGFMarkExpression("114018","114025");
        new EGFMarkChars("1999");
        if (keyFeature.isListType()) {
        new EGFMarkChars("2000");
        if (!genModel.useGenerics()) {
        new EGFMarkChars("2001");
        new EGFMarkExpression("114134","114182");
        new EGFMarkChars("2002");
        }
        new EGFMarkChars("2003");
        } else if (isJDK50) {
        new EGFMarkChars("2004");
        } else if (keyFeature.isPrimitiveType()) {
        new EGFMarkChars("2005");
        new EGFMarkExpression("114312","114346");
        new EGFMarkChars("2006");
        new EGFMarkExpression("114357","114395");
        new EGFMarkChars("2007");
        } else {
        new EGFMarkChars("2008");
        new EGFMarkExpression("114435","114471");
        new EGFMarkChars("2009");
        }
        new EGFMarkChars("2010");
        new EGFMarkExpression("114582","114591");
        new EGFMarkChars("2011");
        if (!isJDK50 && valueFeature.isPrimitiveType()) {
        new EGFMarkChars("2012");
        new EGFMarkExpression("114680","114716");
        new EGFMarkChars("2013");
        } else {
        new EGFMarkChars("2014");
        }
        new EGFMarkChars("2015");
        new EGFMarkExpression("114880","114889");
        new EGFMarkChars("2016");
        new EGFMarkExpression("114904","114913");
        new EGFMarkChars("2017");
        new EGFMarkExpression("114931","114940");
        new EGFMarkChars("2018");
        if (valueFeature.isListType()) {
        new EGFMarkChars("2019");
        if (!genModel.useGenerics()) {
        new EGFMarkChars("2020");
        new EGFMarkExpression("115095","115143");
        new EGFMarkChars("2021");
        }
        new EGFMarkChars("2022");
        } else if (isJDK50) {
        new EGFMarkChars("2023");
        } else if (valueFeature.isPrimitiveType()) {
        new EGFMarkChars("2024");
        new EGFMarkExpression("115283","115319");
        new EGFMarkChars("2025");
        new EGFMarkExpression("115332","115372");
        new EGFMarkChars("2026");
        } else {
        new EGFMarkChars("2027");
        new EGFMarkExpression("115414","115452");
        new EGFMarkChars("2028");
        }
        new EGFMarkChars("2029");
        if (genModel.useGenerics()) {
        new EGFMarkChars("2030");
        }
        new EGFMarkChars("2031");
        new EGFMarkExpression("115660","115668");
        new EGFMarkChars("2032");
        new EGFMarkExpression("115689","115746");
        new EGFMarkChars("2033");
        new EGFMarkExpression("115815","115823");
        new EGFMarkChars("2034");
        }
        new EGFMarkChars("2035");
        new EGFMarkIncludeSilent("Class/insert.javajetinc");
        new EGFMarkChars("2036");
        new EGFMarkExpression("115942","116015");
        new EGFMarkChars("2037");
        // TODO fix the space above
        new EGFMarkChars("2038");
        genModel.emitSortedImports();
        new EGFMarkChars("2039");

        
    }
}