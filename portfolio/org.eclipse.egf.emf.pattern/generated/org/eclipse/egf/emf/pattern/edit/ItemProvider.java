package org.eclipse.egf.emf.pattern.edit;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ItemProvider extends org.eclipse.egf.emf.pattern.base.GenClassJava {

    protected static String nl;

    public static synchronized ItemProvider create(String lineSeparator) {
        nl = lineSeparator;
        ItemProvider result = new ItemProvider();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;

    protected final String TEXT_1 = "";

    protected final String TEXT_2 = NL + "package ";

    protected final String TEXT_3 = ";" + NL + NL;

    protected final String TEXT_4 = NL + NL + "/**" + NL + " * This is the item provider adapter for a {@link ";

    protected final String TEXT_5 = "} object." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public class ";

    protected final String TEXT_6 = NL + "\textends ";

    protected final String TEXT_7 = NL + "\timplements";

    protected final String TEXT_8 = NL + "\t\t";

    protected final String TEXT_9 = ",";

    protected final String TEXT_10 = NL + "{";

    protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";

    protected final String TEXT_12 = " copyright = ";

    protected final String TEXT_13 = ";";

    protected final String TEXT_14 = NL;

    protected final String TEXT_15 = NL + "\t/**" + NL + "\t * This constructs an instance from a factory and a notifier." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";

    protected final String TEXT_16 = "(AdapterFactory adapterFactory)" + NL + "\t{" + NL + "\t\tsuper(adapterFactory);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This returns the property descriptors for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL
            + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_17 = NL + "\t@Override";

    protected final String TEXT_18 = NL + "\tpublic ";

    protected final String TEXT_19 = " getPropertyDescriptors(Object object)" + NL + "\t{" + NL + "\t\tif (itemPropertyDescriptors == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getPropertyDescriptors(object);" + NL;

    protected final String TEXT_20 = NL + "\t\t\tadd";

    protected final String TEXT_21 = "PropertyDescriptor(object);";

    protected final String TEXT_22 = NL + "\t\t}" + NL + "\t\treturn itemPropertyDescriptors;" + NL + "\t}" + NL;

    protected final String TEXT_23 = NL + "\t/**" + NL + "\t * This adds a property descriptor for the ";

    protected final String TEXT_24 = " feature." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void add";

    protected final String TEXT_25 = "PropertyDescriptor(Object object)" + NL + "\t{";

    protected final String TEXT_26 = NL;

    protected final String TEXT_27 = NL + "\t}" + NL;

    protected final String TEXT_28 = NL + "\t/**" + NL + "\t * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an" + NL + "\t * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or" + NL
            + "\t * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_29 = NL + "\t@Override";

    protected final String TEXT_30 = NL + "\tpublic ";

    protected final String TEXT_31 = " getChildrenFeatures(Object object)" + NL + "\t{" + NL + "\t\tif (childrenFeatures == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getChildrenFeatures(object);";

    protected final String TEXT_32 = NL + "\t\t\tchildrenFeatures.add(";

    protected final String TEXT_33 = ");";

    protected final String TEXT_34 = NL + "\t\t}" + NL + "\t\treturn childrenFeatures;" + NL + "\t}" + NL;

    protected final String TEXT_35 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_36 = NL + "\t@Override";

    protected final String TEXT_37 = NL + "\tprotected ";

    protected final String TEXT_38 = " getChildFeature(Object object, Object child)" + NL + "\t{" + NL + "\t\t// Check the type of the specified child object and return the proper feature to use for" + NL + "\t\t// adding (see {@link AddCommand}) it as a child." + NL + "" + NL
            + "\t\treturn super.getChildFeature(object, child);" + NL + "\t}" + NL;

    protected final String TEXT_39 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_40 = NL + "\t@Override";

    protected final String TEXT_41 = NL + "\tpublic boolean hasChildren(Object object)" + NL + "\t{" + NL + "\t\treturn hasChildren(object, ";

    protected final String TEXT_42 = ");" + NL + "\t}" + NL;

    protected final String TEXT_43 = NL + "\t/**" + NL + "\t * This returns ";

    protected final String TEXT_44 = ".gif." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_45 = NL + "\t@Override";

    protected final String TEXT_46 = NL + "\tpublic Object getImage(Object object)" + NL + "\t{" + NL + "\t\treturn overlayImage(object, getResourceLocator().getImage(\"full/obj16/";

    protected final String TEXT_47 = "\"));";

    protected final String TEXT_48 = NL + "\t}" + NL;

    protected final String TEXT_49 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_50 = NL + "\t@Override";

    protected final String TEXT_51 = NL + "\tprotected boolean shouldComposeCreationImage() " + NL + "\t{" + NL + "\t\treturn true;" + NL + "\t}" + NL;

    protected final String TEXT_52 = NL + "\t/**" + NL + "\t * This returns the label text for the adapted class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_53 = NL + "\t@Override";

    protected final String TEXT_54 = NL + "\tpublic String getText(Object object)" + NL + "\t{";

    protected final String TEXT_55 = NL;

    protected final String TEXT_56 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This handles model notifications by calling {@link #updateChildren} to update any cached" + NL + "\t * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}." + NL
            + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_57 = NL + "\t@Override";

    protected final String TEXT_58 = NL + "\tpublic void notifyChanged(Notification notification)" + NL + "\t{" + NL + "\t\tupdateChildren(notification);";

    protected final String TEXT_59 = NL + NL + "\t\tswitch (notification.getFeatureID(";

    protected final String TEXT_60 = ".class))" + NL + "\t\t{";

    protected final String TEXT_61 = NL + "\t\t\tcase ";

    protected final String TEXT_62 = ":";

    protected final String TEXT_63 = NL + "\t\t\t\tfireNotifyChanged(new ";

    protected final String TEXT_64 = "(notification, notification.getNotifier(), false, true));" + NL + "\t\t\t\treturn;";

    protected final String TEXT_65 = NL + "\t\t\tcase ";

    protected final String TEXT_66 = ":";

    protected final String TEXT_67 = NL + "\t\t\t\tfireNotifyChanged(new ";

    protected final String TEXT_68 = "(notification, notification.getNotifier(), true, false));" + NL + "\t\t\t\treturn;";

    protected final String TEXT_69 = NL + "\t\t\tcase ";

    protected final String TEXT_70 = ":";

    protected final String TEXT_71 = NL + "\t\t\t\tfireNotifyChanged(new ";

    protected final String TEXT_72 = "(notification, notification.getNotifier(), true, true));" + NL + "\t\t\t\treturn;";

    protected final String TEXT_73 = NL + "\t\t}";

    protected final String TEXT_74 = NL + "\t\tsuper.notifyChanged(notification);" + NL + "\t}" + NL;

    protected final String TEXT_75 = NL + "\t/**" + NL + "\t * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children" + NL + "\t * that can be created under this object." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
            + "\t * @generated" + NL + "\t */";

    protected final String TEXT_76 = NL + "\t@Override";

    protected final String TEXT_77 = NL + "\tprotected void collectNewChildDescriptors(";

    protected final String TEXT_78 = " newChildDescriptors, Object object)" + NL + "\t{" + NL + "\t\tsuper.collectNewChildDescriptors(newChildDescriptors, object);";

    protected final String TEXT_79 = NL;

    protected final String TEXT_80 = NL;

    protected final String TEXT_81 = NL;

    protected final String TEXT_82 = NL;

    protected final String TEXT_83 = NL + "\t}" + NL;

    protected final String TEXT_84 = NL + "\t/**" + NL + "\t * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_85 = NL + "\t@Override";

    protected final String TEXT_86 = NL + "\tpublic String getCreateChildText(Object owner, Object feature, Object child, ";

    protected final String TEXT_87 = " selection)" + NL + "\t{" + NL + "\t\tObject childFeature = feature;" + NL + "\t\tObject childObject = child;" + NL;

    protected final String TEXT_88 = NL + "\t\tif (childFeature instanceof ";

    protected final String TEXT_89 = " && ";

    protected final String TEXT_90 = ".isFeatureMap((EStructuralFeature)childFeature))" + NL + "\t\t{" + NL + "\t\t\t";

    protected final String TEXT_91 = ".Entry entry = (FeatureMap.Entry)childObject;" + NL + "\t\t\tchildFeature = entry.getEStructuralFeature();" + NL + "\t\t\tchildObject = entry.getValue();" + NL + "\t\t}" + NL;

    protected final String TEXT_92 = NL + "\t\tboolean qualify =";

    protected final String TEXT_93 = NL + "\t\t\tchildFeature == ";

    protected final String TEXT_94 = NL + NL + "\t\tif (qualify)" + NL + "\t\t{" + NL + "\t\t\treturn getString" + NL + "\t\t\t\t(\"_UI_CreateChild_text2\",";

    protected final String TEXT_95 = NL + "\t\t\t\t new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });" + NL + "\t\t}" + NL + "\t\treturn super.getCreateChildText(owner, feature, child, selection);" + NL + "\t}" + NL;

    protected final String TEXT_96 = NL + "\t/**" + NL + "\t * Return the resource locator for this item provider's resources." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";

    protected final String TEXT_97 = NL + "\t@Override";

    protected final String TEXT_98 = NL + "\tpublic ";

    protected final String TEXT_99 = " getResourceLocator()" + NL + "\t{";

    protected final String TEXT_100 = NL + "\t\treturn ((";

    protected final String TEXT_101 = ")adapterFactory).getResourceLocator();";

    protected final String TEXT_102 = NL + "\t\treturn ";

    protected final String TEXT_103 = ".INSTANCE;";

    protected final String TEXT_104 = NL + "\t}" + NL;

    protected final String TEXT_105 = NL;

    protected final String TEXT_106 = NL + "}";

    protected final String TEXT_107 = NL;

    protected final String TEXT_108 = NL;

    protected final String TEXT_109 = NL;

    public ItemProvider() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_108);
        stringBuffer.append(TEXT_109);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_preGenerate(ictx.getBuffer(), ictx);

        method_doGenerate(ictx.getBuffer(), ictx);
        {
            ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
            ictx.getExecutionBuffer().append(ictx.getBuffer());
            final Map<String, Object> parameters = getParameters();
            CallbackContext ctx_callback = new CallbackContext(ictx);
            CallHelper.callBack(ctx_callback, parameters);
        }

        method_postGenerate(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenClass genClass = parameter;
        targetPath = genClass.getGenModel().getEditDirectory();
        packageName = genClass.getGenPackage().getProviderPackageName();
        className = genClass.getProviderClassName();

    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenClass genClass = parameter;
        argument = parameter;

    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2007 IBM Corporation and others.
         * All rights reserved.   This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v1.0
         * which accompanies this distribution, and is available at
         * http://www.eclipse.org/legal/epl-v10.html
         *
         * Contributors:
         *   IBM - Initial API and implementation
         *
         * </copyright>
         */

        GenClass genClass = (GenClass) argument;
        GenPackage genPackage = genClass.getGenPackage();
        GenModel genModel = genPackage.getGenModel();
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(genPackage.getProviderPackageName());
        stringBuffer.append(TEXT_3);
        genModel.addImport("org.eclipse.emf.common.notify.AdapterFactory");
        genModel.addImport("org.eclipse.emf.common.notify.Notification");
        genModel.addImport("org.eclipse.emf.edit.provider.IEditingDomainItemProvider");
        genModel.addImport("org.eclipse.emf.edit.provider.IItemLabelProvider");
        genModel.addImport("org.eclipse.emf.edit.provider.IItemPropertySource");
        genModel.addImport("org.eclipse.emf.edit.provider.IStructuredItemContentProvider");
        genModel.addImport("org.eclipse.emf.edit.provider.ITreeItemContentProvider");
        String _List = genModel.getImportedName(genModel.useGenerics() ? "java.util.List<org.eclipse.emf.edit.provider.IItemPropertyDescriptor>" : "java.util.List");
        genModel.markImportLocation(stringBuffer);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genClass.getQualifiedInterfaceName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(genClass.getProviderClassName());
        stringBuffer.append(TEXT_6);
        stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName() : genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
        stringBuffer.append(TEXT_7);
        for (Iterator<String> i = genPackage.getProviderSupportedTypes().iterator(); i.hasNext();) {
            stringBuffer.append(TEXT_8);
            stringBuffer.append(genModel.getImportedName(i.next()));
            if (i.hasNext()) {
                stringBuffer.append(TEXT_9);
            }
        }
        stringBuffer.append(TEXT_10);
        if (genModel.hasCopyrightField()) {
            stringBuffer.append(TEXT_11);
            stringBuffer.append(genModel.getImportedName("java.lang.String"));
            stringBuffer.append(TEXT_12);
            stringBuffer.append(genModel.getCopyrightFieldLiteral());
            stringBuffer.append(TEXT_13);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_14);
        }
        stringBuffer.append(TEXT_15);
        stringBuffer.append(genClass.getProviderClassName());
        stringBuffer.append(TEXT_16);
        if (genModel.useClassOverrideAnnotation()) {
            stringBuffer.append(TEXT_17);
        }
        stringBuffer.append(TEXT_18);
        stringBuffer.append(_List);
        stringBuffer.append(TEXT_19);
        for (GenFeature genFeature : genClass.getPropertyFeatures()) {
            stringBuffer.append(TEXT_20);
            stringBuffer.append(genFeature.getCapName());
            stringBuffer.append(TEXT_21);
        }
        stringBuffer.append(TEXT_22);
        for (GenFeature genFeature : genClass.getPropertyFeatures()) {
            stringBuffer.append(TEXT_23);
            stringBuffer.append(genFeature.getFormattedName());
            stringBuffer.append(TEXT_24);
            stringBuffer.append(genFeature.getCapName());
            stringBuffer.append(TEXT_25);
            stringBuffer.append(TEXT_26);
            {
                //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.addPropertyDescriptor.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,_List:_List"%>

                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genFeature", genFeature);
                callParameters.put("genClass", genClass);
                callParameters.put("genPackage", genPackage);
                callParameters.put("genModel", genModel);
                callParameters.put("_List", _List);
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03mkEWJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //ItemProvider/addPropertyDescriptor.override.javajetinc
            stringBuffer.append(TEXT_27);
        }
        if (!genClass.getChildrenFeatures().isEmpty()) {
            stringBuffer.append(TEXT_28);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_29);
            }
            stringBuffer.append(TEXT_30);
            stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<? extends org.eclipse.emf.ecore.EStructuralFeature>" : "java.util.Collection"));
            stringBuffer.append(TEXT_31);
            for (GenFeature genFeature : genClass.getChildrenFeatures()) {
                stringBuffer.append(TEXT_32);
                stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
                stringBuffer.append(TEXT_33);
            }
            stringBuffer.append(TEXT_34);
            if (!genClass.getChildrenFeatures().isEmpty()) {
                stringBuffer.append(TEXT_35);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_36);
                }
                stringBuffer.append(TEXT_37);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
                stringBuffer.append(TEXT_38);
            }
        }
        if (genClass.needsHasChildrenMethodOverride()) {
            stringBuffer.append(TEXT_39);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_40);
            }
            stringBuffer.append(TEXT_41);
            stringBuffer.append(genModel.isOptimizedHasChildren());
            stringBuffer.append(TEXT_42);
        }
        if (genClass.isImage()) {
            stringBuffer.append(TEXT_43);
            stringBuffer.append(genClass.getName());
            stringBuffer.append(TEXT_44);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_45);
            }
            stringBuffer.append(TEXT_46);
            stringBuffer.append(genClass.getName());
            stringBuffer.append(TEXT_47);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_48);
        }
        if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF26_VALUE && !genModel.isCreationIcons()) {
            stringBuffer.append(TEXT_49);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_50);
            }
            stringBuffer.append(TEXT_51);
        }
        stringBuffer.append(TEXT_52);
        if (genModel.useClassOverrideAnnotation()) {
            stringBuffer.append(TEXT_53);
        }
        stringBuffer.append(TEXT_54);
        stringBuffer.append(TEXT_55);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.getText.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,_List:_List"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genClass", genClass);
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            callParameters.put("_List", _List);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03wVEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        //ItemProvider/getText.override.javajetinc
        stringBuffer.append(TEXT_56);
        if (genModel.useClassOverrideAnnotation()) {
            stringBuffer.append(TEXT_57);
        }
        stringBuffer.append(TEXT_58);
        if (!genClass.getLabelNotifyFeatures().isEmpty() || !genClass.getContentNotifyFeatures().isEmpty() || !genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
            stringBuffer.append(TEXT_59);
            stringBuffer.append(genClass.getRawImportedInterfaceName());
            stringBuffer.append(TEXT_60);
            if (!genClass.getLabelNotifyFeatures().isEmpty()) {
                for (GenFeature genFeature : genClass.getLabelNotifyFeatures()) {
                    stringBuffer.append(TEXT_61);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(TEXT_62);
                }
                stringBuffer.append(TEXT_63);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
                stringBuffer.append(TEXT_64);
            }
            if (!genClass.getContentNotifyFeatures().isEmpty()) {
                for (GenFeature genFeature : genClass.getContentNotifyFeatures()) {
                    stringBuffer.append(TEXT_65);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(TEXT_66);
                }
                stringBuffer.append(TEXT_67);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
                stringBuffer.append(TEXT_68);
            }
            if (!genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
                for (GenFeature genFeature : genClass.getLabelAndContentNotifyFeatures()) {
                    stringBuffer.append(TEXT_69);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(TEXT_70);
                }
                stringBuffer.append(TEXT_71);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
                stringBuffer.append(TEXT_72);
            }
            stringBuffer.append(TEXT_73);
        }
        stringBuffer.append(TEXT_74);
        if (genModel.isCreationCommands()) {
            stringBuffer.append(TEXT_75);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_76);
            }
            stringBuffer.append(TEXT_77);
            stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<java.lang.Object>" : "java.util.Collection"));
            stringBuffer.append(TEXT_78);
            for (GenClass.ChildCreationData childCreationData : genClass.getChildCreationData()) {
                GenFeature createFeature = childCreationData.createFeature;
                GenFeature delegatedFeature = childCreationData.delegatedFeature;
                GenClassifier createClassifier = childCreationData.createClassifier;
                if (createFeature.isFeatureMapType()) {
                    if (delegatedFeature.isReferenceType()) {
                        GenClass createClass = (GenClass) createClassifier;
                        stringBuffer.append(TEXT_79);
                        {
                            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.override" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

                            final Map<String, Object> callParameters = new HashMap<String, Object>();
                            callParameters.put("createClass", createClass);
                            callParameters.put("createFeature", createFeature);
                            callParameters.put("delegatedFeature", delegatedFeature);
                            callParameters.put("createClassifier", createClassifier);
                            callParameters.put("childCreationData", childCreationData);
                            callParameters.put("genClass", genClass);
                            callParameters.put("genPackage", genPackage);
                            callParameters.put("genModel", genModel);
                            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_036GEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                        }

                        //ItemProvider/newChildDescriptorsReferenceDelegatedFeature.override.javajetinc
                    } else {
                        GenDataType createDataType = (GenDataType) createClassifier;
                        stringBuffer.append(TEXT_80);
                        {
                            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsAttributeDelegatedFeature.override" args="createDataType:createDataType,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

                            final Map<String, Object> callParameters = new HashMap<String, Object>();
                            callParameters.put("createDataType", createDataType);
                            callParameters.put("createFeature", createFeature);
                            callParameters.put("delegatedFeature", delegatedFeature);
                            callParameters.put("createClassifier", createClassifier);
                            callParameters.put("childCreationData", childCreationData);
                            callParameters.put("genClass", genClass);
                            callParameters.put("genPackage", genPackage);
                            callParameters.put("genModel", genModel);
                            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04WyAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                        }

                        //ItemProvider/newChildDescriptorsAttributeDelegatedFeature.override.javajetinc
                    }
                } else if (createFeature.isReferenceType()) {
                    GenClass createClass = (GenClass) createClassifier;
                    stringBuffer.append(TEXT_81);
                    {
                        //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceFeature.override" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

                        final Map<String, Object> callParameters = new HashMap<String, Object>();
                        callParameters.put("createClass", createClass);
                        callParameters.put("createFeature", createFeature);
                        callParameters.put("delegatedFeature", delegatedFeature);
                        callParameters.put("createClassifier", createClassifier);
                        callParameters.put("childCreationData", childCreationData);
                        callParameters.put("genClass", genClass);
                        callParameters.put("genPackage", genPackage);
                        callParameters.put("genModel", genModel);
                        CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04ps8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                    }

                    //ItemProvider/newChildDescriptorsReferenceFeature.override.javajetinc 
                } else {
                    GenDataType createDataType = (GenDataType) createClassifier;
                    stringBuffer.append(TEXT_82);
                    {
                        //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsAttributeFeature.override" args="createDataType:createDataType,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

                        final Map<String, Object> callParameters = new HashMap<String, Object>();
                        callParameters.put("createDataType", createDataType);
                        callParameters.put("createFeature", createFeature);
                        callParameters.put("delegatedFeature", delegatedFeature);
                        callParameters.put("createClassifier", createClassifier);
                        callParameters.put("childCreationData", childCreationData);
                        callParameters.put("genClass", genClass);
                        callParameters.put("genPackage", genPackage);
                        callParameters.put("genModel", genModel);
                        CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_048n4GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                    }

                    //ItemProvider/newChildDescriptorsAttributeFeature.override.javajetinc
                }
            }
            stringBuffer.append(TEXT_83);
            if (!genClass.getSharedClassCreateChildFeatures().isEmpty()) {
                stringBuffer.append(TEXT_84);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_85);
                }
                stringBuffer.append(TEXT_86);
                stringBuffer.append(genModel.getImportedName(genModel.useGenerics() ? "java.util.Collection<?>" : "java.util.Collection"));
                stringBuffer.append(TEXT_87);
                if (genClass.hasFeatureMapCreateChildFeatures()) {
                    stringBuffer.append(TEXT_88);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
                    stringBuffer.append(TEXT_89);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
                    stringBuffer.append(TEXT_90);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                    stringBuffer.append(TEXT_91);
                }
                stringBuffer.append(TEXT_92);
                for (Iterator<GenFeature> i = genClass.getSharedClassCreateChildFeatures().iterator(); i.hasNext();) {
                    GenFeature createFeature = i.next();
                    stringBuffer.append(TEXT_93);
                    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
                    stringBuffer.append(i.hasNext() ? " ||" : ";");
                }
                stringBuffer.append(TEXT_94);
                stringBuffer.append(genModel.getNonNLS());
                stringBuffer.append(TEXT_95);
            }
        }
        if (genClass.getProviderExtendsGenClass() == null || genClass.getProviderExtendsGenClass().getGenPackage() != genPackage
                && (!genPackage.isExtensibleProviderFactory() || genClass.getProviderExtendsGenClass().getGenPackage().isExtensibleProviderFactory() != genPackage.isExtensibleProviderFactory())) {
            stringBuffer.append(TEXT_96);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_97);
            }
            stringBuffer.append(TEXT_98);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.ResourceLocator"));
            stringBuffer.append(TEXT_99);
            if (genPackage.isExtensibleProviderFactory()) {
                stringBuffer.append(TEXT_100);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.IChildCreationExtender"));
                stringBuffer.append(TEXT_101);
            } else {
                stringBuffer.append(TEXT_102);
                stringBuffer.append(genPackage.getImportedEditPluginClassName());
                stringBuffer.append(TEXT_103);
            }
            stringBuffer.append(TEXT_104);
        }
        stringBuffer.append(TEXT_105);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.insert" args="genClass:genClass,genPackage:genPackage,genModel:genModel,_List:_List"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genClass", genClass);
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            callParameters.put("_List", _List);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_051_wGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_106);
        genModel.emitSortedImports();
        stringBuffer.append(TEXT_107);
    }

    public boolean preCondition() throws Exception {
        GenClass genClass = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
        canGenerate = canGenerate && true;
        return canGenerate;
    }
}
