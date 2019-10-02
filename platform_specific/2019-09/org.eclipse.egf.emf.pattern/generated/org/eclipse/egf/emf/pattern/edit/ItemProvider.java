//Generated with EGF 1.6.1.201902111324
package org.eclipse.egf.emf.pattern.edit;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
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
	protected final String TEXT_5 = "} object." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->";
	protected final String TEXT_6 = NL + " * ";
	protected final String TEXT_7 = NL + " * @generated" + NL + " */";
	protected final String TEXT_8 = NL + "@Deprecated";
	protected final String TEXT_9 = NL + "public class ";
	protected final String TEXT_10 = " ";
	protected final String TEXT_11 = "extends ";
	protected final String TEXT_12 = NL + "\textends ";
	protected final String TEXT_13 = NL + "\timplements";
	protected final String TEXT_14 = NL + "\t\t";
	protected final String TEXT_15 = ",";
	protected final String TEXT_16 = NL + "{";
	protected final String TEXT_17 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_18 = " copyright = ";
	protected final String TEXT_19 = ";";
	protected final String TEXT_20 = NL;
	protected final String TEXT_21 = NL + "\t/**" + NL
			+ "\t * This constructs an instance from a factory and a notifier." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_22 = "(AdapterFactory adapterFactory)" + NL + "\t{" + NL + "\t\tsuper(adapterFactory);"
			+ NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * This returns the property descriptors for the adapted class." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_23 = NL + "\t@Override";
	protected final String TEXT_24 = NL + "\tpublic ";
	protected final String TEXT_25 = " getPropertyDescriptors(Object object)" + NL + "\t{" + NL
			+ "\t\tif (itemPropertyDescriptors == null)" + NL + "\t\t{" + NL
			+ "\t\t\tsuper.getPropertyDescriptors(object);" + NL;
	protected final String TEXT_26 = NL + "\t\t\tadd";
	protected final String TEXT_27 = "PropertyDescriptor(object);";
	protected final String TEXT_28 = NL + "\t\t}" + NL + "\t\treturn itemPropertyDescriptors;" + NL + "\t}" + NL;
	protected final String TEXT_29 = NL + "\t/**" + NL + "\t * This adds a property descriptor for the ";
	protected final String TEXT_30 = " feature." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->";
	protected final String TEXT_31 = NL + "\t * ";
	protected final String TEXT_32 = NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_33 = NL + "\t@Deprecated";
	protected final String TEXT_34 = NL + "\tprotected void add";
	protected final String TEXT_35 = "PropertyDescriptor(Object object)" + NL + "\t{";
	protected final String TEXT_36 = NL + "\t}" + NL;
	protected final String TEXT_37 = NL + "\t/**" + NL
			+ "\t * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an"
			+ NL
			+ "\t * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or"
			+ NL + "\t * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_38 = " getChildrenFeatures(Object object)" + NL + "\t{" + NL
			+ "\t\tif (childrenFeatures == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getChildrenFeatures(object);";
	protected final String TEXT_39 = NL + "\t\t\tchildrenFeatures.add(";
	protected final String TEXT_40 = ");";
	protected final String TEXT_41 = NL + "\t\t}" + NL + "\t\treturn childrenFeatures;" + NL + "\t}" + NL;
	protected final String TEXT_42 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_43 = NL + "\tprotected ";
	protected final String TEXT_44 = " getChildFeature(Object object, Object child)" + NL + "\t{" + NL
			+ "\t\t// Check the type of the specified child object and return the proper feature to use for" + NL
			+ "\t\t// adding (see {@link AddCommand}) it as a child." + NL + "" + NL
			+ "\t\treturn super.getChildFeature(object, child);" + NL + "\t}" + NL;
	protected final String TEXT_45 = NL + "\tpublic boolean hasChildren(Object object)" + NL + "\t{" + NL
			+ "\t\treturn hasChildren(object, ";
	protected final String TEXT_46 = ");" + NL + "\t}" + NL;
	protected final String TEXT_47 = NL + "\t/**" + NL + "\t * This returns ";
	protected final String TEXT_48 = ".gif." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->"
			+ NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_49 = NL + "\tpublic Object getImage(Object object)" + NL + "\t{" + NL
			+ "\t\treturn overlayImage(object, getResourceLocator().getImage(\"full/obj16/";
	protected final String TEXT_50 = "\"));";
	protected final String TEXT_51 = NL + "\t/**" + NL
			+ "\t * This returns <code>getImage(object)</code> for the column index <code>0</code> or <code>super.getImage(object)</code> otherwise."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @see #getText(Object)" + NL + "\t * @see #getColumnText(Object, int)" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_52 = NL + "\tpublic Object getColumnImage(Object object, int columnIndex)" + NL + "\t{"
			+ NL + "\t\t// TODO: implement this method to return appropriate information for each column." + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL
			+ "\t\treturn columnIndex == 0 ? getImage(object) : super.getImage(object);" + NL + "\t}" + NL;
	protected final String TEXT_53 = NL + "\tprotected boolean shouldComposeCreationImage()" + NL + "\t{" + NL
			+ "\t\treturn true;" + NL + "\t}" + NL;
	protected final String TEXT_54 = NL + "\t/**" + NL + "\t * This returns the label text for the adapted class." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_55 = NL + "\tpublic String getText(Object object)" + NL + "\t{";
	protected final String TEXT_56 = NL + "\t/**" + NL
			+ "\t * This returns <code>getText(object)</code> for the column index <code>0</code> or <code>super.getText(object)</code> otherwise."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @see #getImage(Object)" + NL + "\t * @see #getColumnImage(Object, int)" + NL + "\t * @generated"
			+ NL + "\t */";
	protected final String TEXT_57 = NL + "\tpublic String getColumnText(Object object, int columnIndex)" + NL + "\t{"
			+ NL + "\t\t// TODO: implement this method to return appropriate information for each column." + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL
			+ "\t\treturn columnIndex == 0 ? getText(object) : super.getText(object);" + NL + "\t}" + NL;
	protected final String TEXT_58 = NL + "\t/**" + NL
			+ "\t * This returns the label styled text for the adapted class." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_59 = NL + "\tpublic Object getStyledText(Object object)" + NL + "\t{";
	protected final String TEXT_60 = NL + "\t}";
	protected final String TEXT_61 = NL + NL + "\t/**" + NL
			+ "\t * This handles model notifications by calling {@link #updateChildren} to update any cached" + NL
			+ "\t * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_62 = NL + "\tpublic void notifyChanged(Notification notification)" + NL + "\t{" + NL
			+ "\t\tupdateChildren(notification);";
	protected final String TEXT_63 = NL + NL + "\t\tswitch (notification.getFeatureID(";
	protected final String TEXT_64 = ".class))" + NL + "\t\t{";
	protected final String TEXT_65 = NL + "\t\t\tcase ";
	protected final String TEXT_66 = ":";
	protected final String TEXT_67 = NL + "\t\t\t\tfireNotifyChanged(new ";
	protected final String TEXT_68 = "(notification, notification.getNotifier(), false, true));" + NL
			+ "\t\t\t\treturn;";
	protected final String TEXT_69 = "(notification, notification.getNotifier(), true, false));" + NL
			+ "\t\t\t\treturn;";
	protected final String TEXT_70 = "(notification, notification.getNotifier(), true, true));" + NL
			+ "\t\t\t\treturn;";
	protected final String TEXT_71 = NL + "\t\t\tdefault:";
	protected final String TEXT_72 = NL + "\t\t}";
	protected final String TEXT_73 = "\t\tsuper.notifyChanged(notification);";
	protected final String TEXT_74 = "\t\treturn;" + NL + "\t\t\t}";
	protected final String TEXT_75 = NL + "\t/**" + NL
			+ "\t * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children" + NL
			+ "\t * that can be created under this object." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_76 = NL + "\tprotected void collectNewChildDescriptors(";
	protected final String TEXT_77 = " newChildDescriptors, Object object)" + NL + "\t{" + NL
			+ "\t\tsuper.collectNewChildDescriptors(newChildDescriptors, object);";
	protected final String TEXT_78 = NL + "\t/**" + NL
			+ "\t * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_79 = NL
			+ "\tpublic String getCreateChildText(Object owner, Object feature, Object child, ";
	protected final String TEXT_80 = " selection)" + NL + "\t{" + NL + "\t\tObject childFeature = feature;" + NL
			+ "\t\tObject childObject = child;" + NL;
	protected final String TEXT_81 = NL + "\t\tif (childFeature instanceof ";
	protected final String TEXT_82 = " && ";
	protected final String TEXT_83 = ".isFeatureMap((EStructuralFeature)childFeature))" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_84 = ".Entry entry = (FeatureMap.Entry)childObject;" + NL
			+ "\t\t\tchildFeature = entry.getEStructuralFeature();" + NL + "\t\t\tchildObject = entry.getValue();" + NL
			+ "\t\t}" + NL;
	protected final String TEXT_85 = NL + "\t\tboolean qualify =";
	protected final String TEXT_86 = NL + "\t\t\tchildFeature == ";
	protected final String TEXT_87 = NL + NL + "\t\tif (qualify)" + NL + "\t\t{" + NL + "\t\t\treturn getString" + NL
			+ "\t\t\t\t(\"_UI_CreateChild_text2\",";
	protected final String TEXT_88 = NL
			+ "\t\t\t\t new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });"
			+ NL + "\t\t}" + NL + "\t\treturn super.getCreateChildText(owner, feature, child, selection);" + NL + "\t}"
			+ NL;
	protected final String TEXT_89 = NL + "\t/**" + NL
			+ "\t * Return the resource locator for this item provider's resources." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_90 = " getResourceLocator()" + NL + "\t{";
	protected final String TEXT_91 = NL + "\t\treturn ((";
	protected final String TEXT_92 = ")adapterFactory).getResourceLocator();";
	protected final String TEXT_93 = NL + "\t\treturn ";
	protected final String TEXT_94 = ".INSTANCE;";
	protected final String TEXT_95 = NL + "}";
	protected final String TEXT_96 = NL;

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
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_96);
		stringBuffer.append(TEXT_96);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(new StringBuffer(), ictx);

		method_doGenerate(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		GenClass genClass = parameter;
		targetPath = genClass.getGenModel().getEditDirectory();
		packageName = genClass.getGenPackage().getProviderPackageName();
		className = genClass.getProviderClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenClass genClass = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel,
				GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2019 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v20.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 *   Alexander Fedorov <alexander.fedorov@arsysop.ru> - Bug 546714
		 */

		GenClass genClass = (GenClass) argument;
		GenPackage genPackage = genClass.getGenPackage();
		GenModel genModel = genPackage.getGenModel();
		final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
		final boolean forceDefaultCase = genModel.isSwitchMissingDefaultCase();
		String indentDefaultCase = forceDefaultCase ? "\t\t" : "";
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getProviderPackageName());
		stringBuffer.append(TEXT_3);
		genModel.addImport("org.eclipse.emf.common.notify.AdapterFactory");
		genModel.addImport("org.eclipse.emf.common.notify.Notification");
		String _List = genModel.getImportedName(
				genModel.useGenerics() ? "java.util.List<org.eclipse.emf.edit.provider.IItemPropertyDescriptor>"
						: "java.util.List");
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genClass.getRawQualifiedInterfaceName());
		stringBuffer.append(TEXT_5);
		if (genClass.hasImplicitAPITags()) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genClass.getImplicitAPITags(genModel.getIndentation(stringBuffer)));
		}
		stringBuffer.append(TEXT_7);
		if (isJDK50 && genClass.hasImplicitAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_8);
		}
		stringBuffer.append(TEXT_9);
		stringBuffer.append(genClass.getProviderClassName());
		stringBuffer.append(TEXT_10);
		if (genClass.getProviderImplementsClassNames().isEmpty()) {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName()
					: genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
		}
		if (!genClass.getProviderImplementsClassNames().isEmpty()) {
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genClass.getProviderBaseClassName() != null ? genClass.getProviderBaseClassName()
					: genModel.getImportedName("org.eclipse.emf.edit.provider.ItemProviderAdapter"));
			stringBuffer.append(TEXT_13);
			for (Iterator<String> i = genClass.getProviderImplementsClassNames().iterator(); i.hasNext();) {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genModel.getImportedName(i.next()));
				if (i.hasNext()) {
					stringBuffer.append(TEXT_15);
				}
			}
		}
		stringBuffer.append(TEXT_16);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_17);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_20);
		}
		stringBuffer.append(TEXT_21);
		stringBuffer.append(genClass.getProviderClassName());
		stringBuffer.append(TEXT_22);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_23);
		}
		stringBuffer.append(TEXT_24);
		stringBuffer.append(_List);
		stringBuffer.append(TEXT_25);
		for (GenFeature genFeature : genClass.getPropertyFeatures()) {
			stringBuffer.append(TEXT_26);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_27);
		}
		stringBuffer.append(TEXT_28);
		for (GenFeature genFeature : genClass.getPropertyFeatures()) {
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genFeature.getFormattedName());
			stringBuffer.append(TEXT_30);
			if (genFeature.hasAPITags()) {
				stringBuffer.append(TEXT_31);
				stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
			}
			stringBuffer.append(TEXT_32);
			if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
				stringBuffer.append(TEXT_33);
			}
			stringBuffer.append(TEXT_34);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_35);
			stringBuffer.append(TEXT_20);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.addPropertyDescriptor.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("forceDefaultCase", forceDefaultCase);
				callParameters.put("indentDefaultCase", indentDefaultCase);
				callParameters.put("_List", _List);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03mkEWJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//ItemProvider/addPropertyDescriptor.override.javajetinc
			stringBuffer.append(TEXT_36);
		}
		if (!genClass.getChildrenFeatures().isEmpty()) {
			stringBuffer.append(TEXT_37);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_24);
			stringBuffer.append(genModel.getImportedName(
					genModel.useGenerics() ? "java.util.Collection<? extends org.eclipse.emf.ecore.EStructuralFeature>"
							: "java.util.Collection"));
			stringBuffer.append(TEXT_38);
			for (GenFeature genFeature : genClass.getChildrenFeatures()) {
				stringBuffer.append(TEXT_39);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_40);
			}
			stringBuffer.append(TEXT_41);
			if (!genClass.getChildrenFeatures().isEmpty()) {
				stringBuffer.append(TEXT_42);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_23);
				}
				stringBuffer.append(TEXT_43);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
				stringBuffer.append(TEXT_44);
			}
		}
		if (genClass.needsHasChildrenMethodOverride()) {
			stringBuffer.append(TEXT_42);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_45);
			stringBuffer.append(genModel.isOptimizedHasChildren());
			stringBuffer.append(TEXT_46);
		}
		if (genClass.isImage()) {
			stringBuffer.append(TEXT_47);
			stringBuffer.append(genClass.getName());
			stringBuffer.append(TEXT_48);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_49);
			stringBuffer.append(genClass.getName());
			stringBuffer.append(TEXT_50);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_36);
		}
		if (genClass.getProviderImplementsClassNames()
				.contains("org.eclipse.emf.edit.provider.ITableItemLabelProvider")) {
			stringBuffer.append(TEXT_51);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_52);
		}
		if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF26_VALUE && !genModel.isCreationIcons()) {
			stringBuffer.append(TEXT_42);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_53);
		}
		stringBuffer.append(TEXT_54);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_23);
		}
		stringBuffer.append(TEXT_55);
		stringBuffer.append(TEXT_20);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.getText.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("forceDefaultCase", forceDefaultCase);
			callParameters.put("indentDefaultCase", indentDefaultCase);
			callParameters.put("_List", _List);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03wVEGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		//ItemProvider/getText.override.javajetinc
		stringBuffer.append(TEXT_36);
		if (genClass.getProviderImplementsClassNames()
				.contains("org.eclipse.emf.edit.provider.ITableItemLabelProvider")) {
			stringBuffer.append(TEXT_56);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_57);
		}
		if (genModel.isStyleProviders()) {
			stringBuffer.append(TEXT_58);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_59);
			stringBuffer.append(TEXT_20);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.getStyledText.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("forceDefaultCase", forceDefaultCase);
				callParameters.put("indentDefaultCase", indentDefaultCase);
				callParameters.put("_List", _List);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_sd5EMKoMEeOCpsO1cKKCxA",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//ItemProvider/getStyledText.override.javajetinc
			stringBuffer.append(TEXT_60);
		}
		stringBuffer.append(TEXT_61);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_23);
		}
		stringBuffer.append(TEXT_62);
		if (!genClass.getLabelNotifyFeatures().isEmpty() || !genClass.getContentNotifyFeatures().isEmpty()
				|| !genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
			stringBuffer.append(TEXT_63);
			stringBuffer.append(genClass.getRawImportedInterfaceName());
			stringBuffer.append(TEXT_64);
			if (!genClass.getLabelNotifyFeatures().isEmpty()) {
				for (GenFeature genFeature : genClass.getLabelNotifyFeatures()) {
					stringBuffer.append(TEXT_65);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_66);
				}
				stringBuffer.append(TEXT_67);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
				stringBuffer.append(TEXT_68);
			}
			if (!genClass.getContentNotifyFeatures().isEmpty()) {
				for (GenFeature genFeature : genClass.getContentNotifyFeatures()) {
					stringBuffer.append(TEXT_65);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_66);
				}
				stringBuffer.append(TEXT_67);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
				stringBuffer.append(TEXT_69);
			}
			if (!genClass.getLabelAndContentNotifyFeatures().isEmpty()) {
				for (GenFeature genFeature : genClass.getLabelAndContentNotifyFeatures()) {
					stringBuffer.append(TEXT_65);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(TEXT_66);
				}
				stringBuffer.append(TEXT_67);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.ViewerNotification"));
				stringBuffer.append(TEXT_70);
			}
			if (forceDefaultCase) {
				stringBuffer.append(TEXT_71);
			} else { // {
				stringBuffer.append(TEXT_72);
			}
			stringBuffer.append(TEXT_20);
			stringBuffer.append(indentDefaultCase);
			stringBuffer.append(TEXT_73);
			if (forceDefaultCase) { // {
				stringBuffer.append(TEXT_20);
				stringBuffer.append(indentDefaultCase);
				stringBuffer.append(TEXT_74);
			} // }
		}
		stringBuffer.append(TEXT_36);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_75);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_76);
			stringBuffer.append(genModel.getImportedName(
					genModel.useGenerics() ? "java.util.Collection<java.lang.Object>" : "java.util.Collection"));
			stringBuffer.append(TEXT_77);
			for (GenClass.ChildCreationData childCreationData : genClass.getChildCreationData()) {
				GenFeature createFeature = childCreationData.createFeature;
				GenFeature delegatedFeature = childCreationData.delegatedFeature;
				GenClassifier createClassifier = childCreationData.createClassifier;
				if (createFeature.isFeatureMapType()) {
					if (delegatedFeature.isReferenceType()) {
						GenClass createClass = (GenClass) createClassifier;
						stringBuffer.append(TEXT_20);
						{
							//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.override" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

							InternalPatternContext ictx = (InternalPatternContext) ctx;
							new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
							stringBuffer.setLength(0);

							final Map<String, Object> callParameters = new HashMap<String, Object>();
							callParameters.put("createClass", createClass);
							callParameters.put("createFeature", createFeature);
							callParameters.put("delegatedFeature", delegatedFeature);
							callParameters.put("createClassifier", createClassifier);
							callParameters.put("childCreationData", childCreationData);
							callParameters.put("genClass", genClass);
							callParameters.put("genPackage", genPackage);
							callParameters.put("genModel", genModel);
							callParameters.put("isJDK50", isJDK50);
							CallHelper.executeWithParameterInjection(
									"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_036GEGJ-Ed-FqczH3ESmRw",
									new ExecutionContext((InternalPatternContext) ctx), callParameters);
							stringBuffer.setLength(0);
						}

						//ItemProvider/newChildDescriptorsReferenceDelegatedFeature.override.javajetinc
					} else {
						GenDataType createDataType = (GenDataType) createClassifier;
						stringBuffer.append(TEXT_20);
						{
							//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsAttributeDelegatedFeature.override" args="createDataType:createDataType,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

							InternalPatternContext ictx = (InternalPatternContext) ctx;
							new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
							stringBuffer.setLength(0);

							final Map<String, Object> callParameters = new HashMap<String, Object>();
							callParameters.put("createDataType", createDataType);
							callParameters.put("createFeature", createFeature);
							callParameters.put("delegatedFeature", delegatedFeature);
							callParameters.put("createClassifier", createClassifier);
							callParameters.put("childCreationData", childCreationData);
							callParameters.put("genClass", genClass);
							callParameters.put("genPackage", genPackage);
							callParameters.put("genModel", genModel);
							callParameters.put("isJDK50", isJDK50);
							CallHelper.executeWithParameterInjection(
									"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04WyAGJ-Ed-FqczH3ESmRw",
									new ExecutionContext((InternalPatternContext) ctx), callParameters);
							stringBuffer.setLength(0);
						}

						//ItemProvider/newChildDescriptorsAttributeDelegatedFeature.override.javajetinc
					}
				} else if (createFeature.isReferenceType()) {
					GenClass createClass = (GenClass) createClassifier;
					stringBuffer.append(TEXT_20);
					{
						//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceFeature.override" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

						InternalPatternContext ictx = (InternalPatternContext) ctx;
						new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
						stringBuffer.setLength(0);

						final Map<String, Object> callParameters = new HashMap<String, Object>();
						callParameters.put("createClass", createClass);
						callParameters.put("createFeature", createFeature);
						callParameters.put("delegatedFeature", delegatedFeature);
						callParameters.put("createClassifier", createClassifier);
						callParameters.put("childCreationData", childCreationData);
						callParameters.put("genClass", genClass);
						callParameters.put("genPackage", genPackage);
						callParameters.put("genModel", genModel);
						callParameters.put("isJDK50", isJDK50);
						CallHelper.executeWithParameterInjection(
								"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04ps8GJ-Ed-FqczH3ESmRw",
								new ExecutionContext((InternalPatternContext) ctx), callParameters);
						stringBuffer.setLength(0);
					}

					//ItemProvider/newChildDescriptorsReferenceFeature.override.javajetinc 
				} else {
					GenDataType createDataType = (GenDataType) createClassifier;
					stringBuffer.append(TEXT_20);
					{
						//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsAttributeFeature.override" args="createDataType:createDataType,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

						InternalPatternContext ictx = (InternalPatternContext) ctx;
						new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
						stringBuffer.setLength(0);

						final Map<String, Object> callParameters = new HashMap<String, Object>();
						callParameters.put("createDataType", createDataType);
						callParameters.put("createFeature", createFeature);
						callParameters.put("delegatedFeature", delegatedFeature);
						callParameters.put("createClassifier", createClassifier);
						callParameters.put("childCreationData", childCreationData);
						callParameters.put("genClass", genClass);
						callParameters.put("genPackage", genPackage);
						callParameters.put("genModel", genModel);
						callParameters.put("isJDK50", isJDK50);
						CallHelper.executeWithParameterInjection(
								"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_048n4GJ-Ed-FqczH3ESmRw",
								new ExecutionContext((InternalPatternContext) ctx), callParameters);
						stringBuffer.setLength(0);
					}

					//ItemProvider/newChildDescriptorsAttributeFeature.override.javajetinc
				}
			}
			stringBuffer.append(TEXT_36);
			if (!genClass.getSharedClassCreateChildFeatures().isEmpty()) {
				stringBuffer.append(TEXT_78);
				if (genModel.useClassOverrideAnnotation()) {
					stringBuffer.append(TEXT_23);
				}
				stringBuffer.append(TEXT_79);
				stringBuffer.append(genModel
						.getImportedName(genModel.useGenerics() ? "java.util.Collection<?>" : "java.util.Collection"));
				stringBuffer.append(TEXT_80);
				if (genClass.hasFeatureMapCreateChildFeatures()) {
					stringBuffer.append(TEXT_81);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
					stringBuffer.append(TEXT_82);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
					stringBuffer.append(TEXT_83);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_84);
				}
				stringBuffer.append(TEXT_85);
				for (Iterator<GenFeature> i = genClass.getSharedClassCreateChildFeatures().iterator(); i.hasNext();) {
					GenFeature createFeature = i.next();
					stringBuffer.append(TEXT_86);
					stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(i.hasNext() ? " ||" : ";");
				}
				stringBuffer.append(TEXT_87);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_88);
			}
		}
		if (genClass.getProviderExtendsGenClass() == null || genClass.getProviderExtendsGenClass()
				.getGenPackage() != genPackage
				&& (!genPackage.isExtensibleProviderFactory() || genClass.getProviderExtendsGenClass().getGenPackage()
						.isExtensibleProviderFactory() != genPackage.isExtensibleProviderFactory())) {
			stringBuffer.append(TEXT_89);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_24);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.ResourceLocator"));
			stringBuffer.append(TEXT_90);
			if (genPackage.isExtensibleProviderFactory()) {
				stringBuffer.append(TEXT_91);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.IChildCreationExtender"));
				stringBuffer.append(TEXT_92);
			} else {
				stringBuffer.append(TEXT_93);
				stringBuffer.append(genPackage.getImportedEditPluginClassName());
				stringBuffer.append(TEXT_94);
			}
			stringBuffer.append(TEXT_36);
		}
		stringBuffer.append(TEXT_20);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.insert" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,_List:_List"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("forceDefaultCase", forceDefaultCase);
			callParameters.put("indentDefaultCase", indentDefaultCase);
			callParameters.put("_List", _List);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_051_wGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_95);
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_20);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenClass genClass = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
		canGenerate = canGenerate && true;
		return canGenerate;
	}
}