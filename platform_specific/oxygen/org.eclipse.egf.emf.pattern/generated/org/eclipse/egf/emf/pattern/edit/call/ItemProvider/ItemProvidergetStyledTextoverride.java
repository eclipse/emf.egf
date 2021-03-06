//Generated with EGF 1.5.0.qualifier
package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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

public class ItemProvidergetStyledTextoverride {
	protected static String nl;

	public static synchronized ItemProvidergetStyledTextoverride create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvidergetStyledTextoverride result = new ItemProvidergetStyledTextoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "\t\t";
	protected final String TEXT_3 = "<?, ?>";
	protected final String TEXT_4 = " ";
	protected final String TEXT_5 = " = (";
	protected final String TEXT_6 = "<?, ?>";
	protected final String TEXT_7 = ")object;";
	protected final String TEXT_8 = NL + "\t\treturn new ";
	protected final String TEXT_9 = "(\"\" + ";
	protected final String TEXT_10 = ".getKey()).append(\" -> \", ";
	protected final String TEXT_11 = ".QUALIFIER_STYLER).append(\"\" + ";
	protected final String TEXT_12 = ".getValue());";
	protected final String TEXT_13 = NL + "\t\tString key = crop(\"\" + ";
	protected final String TEXT_14 = ".getKey());";
	protected final String TEXT_15 = NL + "\t\tString key = \"\" + ";
	protected final String TEXT_16 = ".getKey();";
	protected final String TEXT_17 = NL + "\t\tString value = crop(\"\" + ";
	protected final String TEXT_18 = ".getValue());";
	protected final String TEXT_19 = NL + "\t\tString value = \"\" + ";
	protected final String TEXT_20 = ".getValue();";
	protected final String TEXT_21 = NL + "\t\treturn new ";
	protected final String TEXT_22 = "(key).append(\" -> \", ";
	protected final String TEXT_23 = ".QUALIFIER_STYLER).append(value);";
	protected final String TEXT_24 = NL + "\t\t";
	protected final String TEXT_25 = " ";
	protected final String TEXT_26 = " = (";
	protected final String TEXT_27 = ")object;" + NL + "\t\treturn new ";
	protected final String TEXT_28 = "(getString(\"_UI_";
	protected final String TEXT_29 = "_type\"), ";
	protected final String TEXT_30 = ".QUALIFIER_STYLER).append(\" \").append(";
	protected final String TEXT_31 = ".toString(";
	protected final String TEXT_32 = ".";
	protected final String TEXT_33 = "()));";
	protected final String TEXT_34 = NL + "\t\tString label = crop(((";
	protected final String TEXT_35 = ")object).";
	protected final String TEXT_36 = "());";
	protected final String TEXT_37 = NL + "\t\tString label = ((";
	protected final String TEXT_38 = ")object).";
	protected final String TEXT_39 = "();";
	protected final String TEXT_40 = NL + "\t\t";
	protected final String TEXT_41 = " labelValue = ((";
	protected final String TEXT_42 = ")object).eGet(";
	protected final String TEXT_43 = ");";
	protected final String TEXT_44 = NL + "\t\t";
	protected final String TEXT_45 = " labelValue = ((";
	protected final String TEXT_46 = ")object).";
	protected final String TEXT_47 = "();";
	protected final String TEXT_48 = NL + "\t\tString label = labelValue == null ? null : labelValue.toString();";
	protected final String TEXT_49 = NL + "    \t";
	protected final String TEXT_50 = " styledLabel = new ";
	protected final String TEXT_51 = "();" + NL + "\t\tif (label == null || label.length() == 0) " + NL + "\t\t{" + NL
			+ "\t\t\tstyledLabel.append(getString(\"_UI_";
	protected final String TEXT_52 = "_type\"), ";
	protected final String TEXT_53 = ".QUALIFIER_STYLER); ";
	protected final String TEXT_54 = NL + "\t\t} else {" + NL + "\t\t\tstyledLabel.append(getString(\"_UI_";
	protected final String TEXT_55 = "_type\"), ";
	protected final String TEXT_56 = ".QUALIFIER_STYLER).append(\" \" + label);";
	protected final String TEXT_57 = NL + "\t\t}" + NL + "\t\treturn styledLabel;";
	protected final String TEXT_58 = NL + "\t\treturn new ";
	protected final String TEXT_59 = "(getString(\"_UI_";
	protected final String TEXT_60 = "_type\"));";
	protected final String TEXT_61 = NL;
	protected final String TEXT_62 = NL;
	protected final String TEXT_63 = NL;

	public ItemProvidergetStyledTextoverride() {
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

		List<Object> genClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genClassParameter : genClassList) {
			for (Object genPackageParameter : genPackageList) {
				for (Object genModelParameter : genModelList) {
					for (Object _ListParameter : _ListList) {

						this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
						this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
						this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
						this._List = (java.lang.String) _ListParameter;

						if (preCondition(ctx)) {
							ctx.setNode(new Node.Container(currentNode, getClass()));
							orchestration(ctx);
						}

					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_62);
		stringBuffer.append(TEXT_63);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("_List", this._List);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass = null;

	public void set_genClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
		this.genClass = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;

	public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
		this.genPackage = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
		this.genModel = object;
	}

	protected java.lang.String _List = null;

	public void set__List(java.lang.String object) {
		this._List = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("_List", this._List);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		if (genClass.isMapEntry()) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genClass.getImportedInterfaceName());
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_3);
			}
			stringBuffer.append(TEXT_4);
			stringBuffer.append(genClass.getSafeUncapName());
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genClass.getImportedInterfaceName());
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_6);
			}
			stringBuffer.append(TEXT_7);
			if (!genClass.getMapEntryKeyFeature().isPropertyMultiLine()
					&& !genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
				stringBuffer.append(TEXT_8);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_9);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_10);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_11);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
			} else {
				if (genClass.getMapEntryKeyFeature().isPropertyMultiLine()) {
					stringBuffer.append(TEXT_13);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_14);
					stringBuffer.append(genModel.getNonNLS());
				} else {
					stringBuffer.append(TEXT_15);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_16);
					stringBuffer.append(genModel.getNonNLS());
				}
				if (genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
					stringBuffer.append(TEXT_17);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genModel.getNonNLS());
				} else {
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_20);
					stringBuffer.append(genModel.getNonNLS());
				}
				stringBuffer.append(TEXT_21);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genModel.getNonNLS());
			}
		} else if (genClass.getLabelFeature() != null) {
			GenFeature labelFeature = genClass.getLabelFeature();
			if (labelFeature.isPrimitiveType() && !labelFeature.getGenClass().isDynamic()
					&& !labelFeature.isSuppressedGetVisibility()) {
				stringBuffer.append(TEXT_24);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_25);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_27);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_28);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_29);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_30);
				stringBuffer.append(labelFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_31);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_32);
				stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
				stringBuffer.append(TEXT_33);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
			} else {
				if (labelFeature.isStringType() && !labelFeature.getGenClass().isDynamic()
						&& !labelFeature.isSuppressedGetVisibility()) {
					if (labelFeature.isPropertyMultiLine()) {
						stringBuffer.append(TEXT_34);
						stringBuffer.append(genClass.getImportedInterfaceName());
						stringBuffer.append(genClass.getInterfaceWildTypeArguments());
						stringBuffer.append(TEXT_35);
						stringBuffer.append(labelFeature.getGetAccessor());
						stringBuffer.append(TEXT_36);
					} else {
						stringBuffer.append(TEXT_37);
						stringBuffer.append(genClass.getImportedInterfaceName());
						stringBuffer.append(genClass.getInterfaceWildTypeArguments());
						stringBuffer.append(TEXT_38);
						stringBuffer.append(labelFeature.getGetAccessor());
						stringBuffer.append(TEXT_39);
					}
				} else {
					if (labelFeature.isSuppressedGetVisibility() || labelFeature.getGenClass().isDynamic()) {
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genModel.getImportedName("java.lang.Object"));
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
						stringBuffer.append(TEXT_42);
						stringBuffer.append(labelFeature.getQualifiedFeatureAccessor());
						stringBuffer.append(TEXT_43);
					} else {
						stringBuffer.append(TEXT_44);
						stringBuffer.append(labelFeature.getRawImportedType());
						stringBuffer.append(TEXT_45);
						stringBuffer.append(genClass.getImportedInterfaceName());
						stringBuffer.append(genClass.getInterfaceWildTypeArguments());
						stringBuffer.append(TEXT_46);
						stringBuffer.append(labelFeature.getGetAccessor());
						stringBuffer.append(TEXT_47);
					}
					stringBuffer.append(TEXT_48);
				}
				stringBuffer.append(TEXT_49);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_50);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_51);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_52);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_53);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_54);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_55);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_56);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
				stringBuffer.append(TEXT_57);
			}
		} else {
			stringBuffer.append(TEXT_58);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
			stringBuffer.append(TEXT_59);
			stringBuffer.append(genClass.getName());
			stringBuffer.append(TEXT_60);
			stringBuffer.append(genModel.getNonNLS());
		}
		stringBuffer.append(TEXT_61);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}