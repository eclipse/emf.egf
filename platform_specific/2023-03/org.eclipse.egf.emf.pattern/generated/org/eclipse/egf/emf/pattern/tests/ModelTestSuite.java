//Generated with EGF 1.6.3.202110291409
package org.eclipse.egf.emf.pattern.tests;

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

public class ModelTestSuite extends org.eclipse.egf.emf.pattern.base.GenModelJava {
  protected static String nl;

  public static synchronized ModelTestSuite create(String lineSeparator) {
    nl = lineSeparator;
    ModelTestSuite result = new ModelTestSuite();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
      + " * A test suite for the '<em><b>";
  protected final String TEXT_5 = "</b></em>' model." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_6 = NL + " * ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */";
  protected final String TEXT_8 = NL + "@Deprecated";
  protected final String TEXT_9 = NL + "@SuppressWarnings(\"deprecation\")";
  protected final String TEXT_10 = NL + "public class ";
  protected final String TEXT_11 = " extends ";
  protected final String TEXT_12 = NL + "{";
  protected final String TEXT_13 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
      + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_14 = " copyright = ";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
      + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
      + "\tpublic static void main(String[] args)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_17 = ".run(suite());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
      + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
      + "\tpublic static ";
  protected final String TEXT_18 = " suite()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_19 = " suite = new ";
  protected final String TEXT_20 = "(\"";
  protected final String TEXT_21 = " Tests\");";
  protected final String TEXT_22 = NL + "\t\tsuite.addTest(";
  protected final String TEXT_23 = ".suite());";
  protected final String TEXT_24 = NL + "\t\treturn suite;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
      + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
      + "\tpublic ";
  protected final String TEXT_25 = "(String name)" + NL + "\t{" + NL + "\t\tsuper(name);" + NL + "\t}" + NL + "" + NL
      + "} //";
  protected final String TEXT_26 = NL;

  public ModelTestSuite() {
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

      this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

      if (preCondition(ctx)) {
        ctx.setNode(new Node.Container(currentNode, getClass()));
        orchestration(ctx);
      }

    }
    ctx.setNode(currentNode);
    if (ctx.useReporter()) {
      ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
    }

    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_26);
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

    GenModel genModel = parameter;
    targetPath = genModel.getTestsDirectory();
    packageName = genModel.getTestSuitePackageName();
    className = genModel.getTestSuiteClassName();

    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
  }

  protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    GenModel genModel = parameter;
    argument = parameter;

    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
  }

  protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
      throws Exception {

    new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getTestsDirectory(), genModel,
        GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
  }

  protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    /**
     * Copyright (c) 2005 IBM Corporation and others.
     * All rights reserved.   This program and the accompanying materials
     * are made available under the terms of the Eclipse Public License v2.0
     * which accompanies this distribution, and is available at
     * http://www.eclipse.org/legal/epl-v20.html
     *
     * Contributors:
     *   IBM - Initial API and implementation
     */

    GenModel genModel = (GenModel) argument;
    /* Trick to import java.util.* without warnings */Iterator.class.getName();
    final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
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
    stringBuffer.append(genModel.getTestSuitePackageName());
    stringBuffer.append(TEXT_3);
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    if (genModel.hasAPITags()) {
      stringBuffer.append(TEXT_6);
      stringBuffer.append(genModel.getAPITags(genModel.getIndentation(stringBuffer)));
    }
    stringBuffer.append(TEXT_7);
    if (isJDK50 && genModel.hasAPIDeprecatedTag()) {
      stringBuffer.append(TEXT_8);
    } else if (isJDK50) {
      boolean needsSuppressDeprecation = false;
      LOOP: for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
        if (genPackage.hasTests()) {
          for (GenClass genClass : genPackage.getGenClasses()) {
            if (!genClass.isExternalInterface() && !genClass.isAbstract() && genClass.hasTests()
                && genClass.hasImplicitAPIDeprecatedTag()) {
              needsSuppressDeprecation = true;
              break LOOP;
            }
          }
        }
      }
      if (needsSuppressDeprecation) {
        stringBuffer.append(TEXT_9);
      }
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genModel.getTestSuiteClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getImportedName("junit.framework.TestSuite"));
    stringBuffer.append(TEXT_12);
    if (genModel.hasCopyrightField()) {
      stringBuffer.append(TEXT_13);
      stringBuffer.append(genModel.getImportedName("java.lang.String"));
      stringBuffer.append(TEXT_14);
      stringBuffer.append(genModel.getCopyrightFieldLiteral());
      stringBuffer.append(TEXT_15);
      stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getImportedName("junit.textui.TestRunner"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genModel.getImportedName("junit.framework.Test"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genModel.getImportedName("junit.framework.TestSuite"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genModel.getTestSuiteClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genModel.getNonNLS());
    for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
      if (genPackage.hasTests()) {
        stringBuffer.append(TEXT_22);
        stringBuffer.append(genModel.getImportedName(genPackage.getImportedTestSuiteClassName()));
        stringBuffer.append(TEXT_23);
      }
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genModel.getTestSuiteClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genModel.getTestSuiteClassName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_26);
    InternalPatternContext ictx = (InternalPatternContext) ctx;
    new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
  }

  public boolean preCondition(PatternContext ctx) throws Exception {
    GenModel genModel = parameter;
    genModel = parameter.getGenModel();
    boolean canGenerate = new CodegenGeneratorAdapter(parameter)
        .canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject");
    canGenerate = canGenerate && (genModel.hasTestSuiteClass());
    return canGenerate;
  }
}