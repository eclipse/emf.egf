//Generated with EGF 1.5.0.qualifier
package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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
	protected final String TEXT_6 = ")object;";
	protected final String TEXT_7 = NL + "\t\treturn new ";
	protected final String TEXT_8 = "(\"\" + ";
	protected final String TEXT_9 = ".getKey()).append(\" -> \", ";
	protected final String TEXT_10 = ".QUALIFIER_STYLER).append(\"\" + ";
	protected final String TEXT_11 = ".getValue());";
	protected final String TEXT_12 = NL + "\t\tString key = crop(\"\" + ";
	protected final String TEXT_13 = ".getKey());";
	protected final String TEXT_14 = NL + "\t\tString key = \"\" + ";
	protected final String TEXT_15 = ".getKey();";
	protected final String TEXT_16 = NL + "\t\tString value = crop(\"\" + ";
	protected final String TEXT_17 = NL + "\t\tString value = \"\" + ";
	protected final String TEXT_18 = ".getValue();";
	protected final String TEXT_19 = "(key).append(\" -> \", ";
	protected final String TEXT_20 = ".QUALIFIER_STYLER).append(value);";
	protected final String TEXT_21 = ")object;" + NL + "\t\treturn new ";
	protected final String TEXT_22 = "(getString(\"_UI_";
	protected final String TEXT_23 = "_type\"), ";
	protected final String TEXT_24 = ".QUALIFIER_STYLER).append(\" \").append(";
	protected final String TEXT_25 = ".toString(";
	protected final String TEXT_26 = ".";
	protected final String TEXT_27 = "()));";
	protected final String TEXT_28 = NL + "\t\tString label = crop(((";
	protected final String TEXT_29 = ")object).";
	protected final String TEXT_30 = "());";
	protected final String TEXT_31 = NL + "\t\tString label = ((";
	protected final String TEXT_32 = "();";
	protected final String TEXT_33 = " labelValue = ((";
	protected final String TEXT_34 = ")object).eGet(";
	protected final String TEXT_35 = ");";
	protected final String TEXT_36 = NL + "\t\tString label = labelValue == null ? null : labelValue.toString();";
	protected final String TEXT_37 = NL + "    \t";
	protected final String TEXT_38 = " styledLabel = new ";
	protected final String TEXT_39 = "();" + NL + "\t\tif (label == null || label.length() == 0)" + NL + "\t\t{" + NL
			+ "\t\t\tstyledLabel.append(getString(\"_UI_";
	protected final String TEXT_40 = ".QUALIFIER_STYLER); ";
	protected final String TEXT_41 = NL + "\t\t} else {" + NL + "\t\t\tstyledLabel.append(getString(\"_UI_";
	protected final String TEXT_42 = ".QUALIFIER_STYLER).append(\" \" + label);";
	protected final String TEXT_43 = NL + "\t\t}" + NL + "\t\treturn styledLabel;";
	protected final String TEXT_44 = "_type\"));";
	protected final String TEXT_45 = NL;
	protected final String TEXT_46 = NL;

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
		List<Object> isJDK50List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _ListList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genClassParameter : genClassList) {
			for (Object genPackageParameter : genPackageList) {
				for (Object genModelParameter : genModelList) {
					for (Object isJDK50Parameter : isJDK50List) {
						for (Object _ListParameter : _ListList) {

							this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
							this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
							this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
							this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
							this._List = (java.lang.String) _ListParameter;

							if (preCondition(ctx)) {
								ctx.setNode(new Node.Container(currentNode, getClass()));
								orchestration(ctx);
							}

						}
					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_46);
		stringBuffer.append(TEXT_46);
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
			parameterValues.put("isJDK50", this.isJDK50);
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

	protected java.lang.Boolean isJDK50 = null;

	public void set_isJDK50(java.lang.Boolean object) {
		this.isJDK50 = object;
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
		parameters.put("isJDK50", this.isJDK50);
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
				stringBuffer.append(TEXT_3);
			}
			stringBuffer.append(TEXT_6);
			if (!genClass.getMapEntryKeyFeature().isPropertyMultiLine()
					&& !genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_8);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_9);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_10);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_11);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
			} else {
				if (genClass.getMapEntryKeyFeature().isPropertyMultiLine()) {
					stringBuffer.append(TEXT_12);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_13);
					stringBuffer.append(genModel.getNonNLS());
				} else {
					stringBuffer.append(TEXT_14);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_15);
					stringBuffer.append(genModel.getNonNLS());
				}
				if (genClass.getMapEntryValueFeature().isPropertyMultiLine()) {
					stringBuffer.append(TEXT_16);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_11);
					stringBuffer.append(genModel.getNonNLS());
				} else {
					stringBuffer.append(TEXT_17);
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genModel.getNonNLS());
				}
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_20);
				stringBuffer.append(genModel.getNonNLS());
			}
		} else if (genClass.getLabelFeature() != null) {
			GenFeature labelFeature = genClass.getLabelFeature();
			if (labelFeature.isPrimitiveType() && !labelFeature.getGenClass().isDynamic()
					&& !labelFeature.isSuppressedGetVisibility()) {
				stringBuffer.append(TEXT_2);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_5);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_21);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_24);
				stringBuffer.append(labelFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_25);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genClass.getLabelFeature().getGetAccessor());
				stringBuffer.append(TEXT_27);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
			} else {
				if (labelFeature.isStringType() && !labelFeature.getGenClass().isDynamic()
						&& !labelFeature.isSuppressedGetVisibility()) {
					if (labelFeature.isPropertyMultiLine()) {
						stringBuffer.append(TEXT_28);
						stringBuffer.append(genClass.getImportedInterfaceName());
						stringBuffer.append(genClass.getInterfaceWildTypeArguments());
						stringBuffer.append(TEXT_29);
						stringBuffer.append(labelFeature.getGetAccessor());
						stringBuffer.append(TEXT_30);
					} else {
						stringBuffer.append(TEXT_31);
						stringBuffer.append(genClass.getImportedInterfaceName());
						stringBuffer.append(genClass.getInterfaceWildTypeArguments());
						stringBuffer.append(TEXT_29);
						stringBuffer.append(labelFeature.getGetAccessor());
						stringBuffer.append(TEXT_32);
					}
				} else {
					if (labelFeature.isSuppressedGetVisibility() || labelFeature.getGenClass().isDynamic()) {
						stringBuffer.append(TEXT_2);
						stringBuffer.append(genModel.getImportedName("java.lang.Object"));
						stringBuffer.append(TEXT_33);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
						stringBuffer.append(TEXT_34);
						stringBuffer.append(labelFeature.getQualifiedFeatureAccessor());
						stringBuffer.append(TEXT_35);
					} else {
						stringBuffer.append(TEXT_2);
						stringBuffer.append(labelFeature.getRawImportedType());
						stringBuffer.append(TEXT_33);
						stringBuffer.append(genClass.getImportedInterfaceName());
						stringBuffer.append(genClass.getInterfaceWildTypeArguments());
						stringBuffer.append(TEXT_29);
						stringBuffer.append(labelFeature.getGetAccessor());
						stringBuffer.append(TEXT_32);
					}
					stringBuffer.append(TEXT_36);
				}
				stringBuffer.append(TEXT_37);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_38);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
				stringBuffer.append(TEXT_39);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_40);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_41);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString$Style"));
				stringBuffer.append(TEXT_42);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(genModel.getNonNLS(2));
				stringBuffer.append(TEXT_43);
			}
		} else {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.provider.StyledString"));
			stringBuffer.append(TEXT_22);
			stringBuffer.append(genClass.getName());
			stringBuffer.append(TEXT_44);
			stringBuffer.append(genModel.getNonNLS());
		}
		stringBuffer.append(TEXT_45);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}