package org.eclipse.emf.codegen.ecore.templates.model;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import java.util.*;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.*;

public class ResourceClass
{
  protected static String nl;
  public static synchronized ResourceClass create(String lineSeparator)
  {
    nl = lineSeparator;
    ResourceClass result = new ResourceClass();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = "/**" + NL; //$NON-NLS-1$
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + " * "; //$NON-NLS-1$
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + " *" + NL + " *  Copyright (c) 2009 Thales Corporate Services S.A.S." + NL + " *  All rights reserved. This program and the accompanying materials" + NL + " *  are made available under the terms of the Eclipse Public License v1.0" + NL + " *  which accompanies this distribution, and is available at" + NL + " *  http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " *  Contributors:" + NL + " *      Thales Corporate Services S.A.S - initial API and implementation" + NL + " * " + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
  protected final String TEXT_6 = NL + " */" + NL; //$NON-NLS-1$
  protected final String TEXT_7 = "package "; //$NON-NLS-1$
  protected final String TEXT_8 = ";" + NL + NL; //$NON-NLS-1$
  protected final String TEXT_9 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Resource </b> associated with the package." + NL + " * <!-- end-user-doc -->" + NL + " * @see "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
  protected final String TEXT_10 = NL + " * @generated" + NL + " */" + NL + "public class "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_11 = " extends "; //$NON-NLS-1$
  protected final String TEXT_12 = NL + "{" + NL; //$NON-NLS-1$
  protected final String TEXT_13 = "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_14 = " copyright = "; //$NON-NLS-1$
  protected final String TEXT_15 = ";"; //$NON-NLS-1$
  protected final String TEXT_16 = NL + NL;
  protected final String TEXT_17 = "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
  protected final String TEXT_18 = "<Object> lookupTable = new "; //$NON-NLS-1$
  protected final String TEXT_19 = "<Object>();" + NL + NL; //$NON-NLS-1$
  protected final String TEXT_20 = "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated NOT" + NL + "\t */" + NL + "\tprivate XMLParserPool parserPool = new XMLParserPoolImpl();" + NL + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
  protected final String TEXT_21 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
  protected final String TEXT_22 = "<Object, Object> nameToFeatureMap = new "; //$NON-NLS-1$
  protected final String TEXT_23 = "<Object, Object>();" + NL + NL + "\t/**" + NL + "\t * Creates an instance of the resource." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param uri the URI of the new resource." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
  protected final String TEXT_24 = "(URI uri)" + NL + "\t{" + NL + "\t\tsuper(uri);" + NL + "\t}" + NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
  protected final String TEXT_25 = "\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_26 = "\tprotected boolean useIDAttributes() " + NL + "\t{" + NL + "\t\treturn false;" + NL + "\t}" + NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
  protected final String TEXT_27 = "\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_28 = "\tprotected boolean useUUIDs() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_29 = "\t/**" + NL + "\t * A load option that turns of the use of the generate data converters." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String OPTION_USE_DATA_CONVERTER = \"USE_DATA_CONVERTER\";" + NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$
  protected final String TEXT_30 = "\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_31 = "\tpublic void doLoad(InputStream inputStream, "; //$NON-NLS-1$
  protected final String TEXT_32 = " options) throws IOException" + NL + "\t{" + NL + "\t\tif (options != null && Boolean.TRUE.equals(options.get(OPTION_USE_DATA_CONVERTER)))" + NL + "\t\t{" + NL + "\t\t  getContents().add" + NL + "\t\t\t (load" + NL + "\t\t\t\t (new InputSource(inputStream), " + NL + "\t\t\t\t  ("; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
  protected final String TEXT_33 = ")options.get(XMLResource.OPTION_PARSER_FEATURES), " + NL + "\t\t\t\t  ("; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_34 = ")options.get(XMLResource.OPTION_PARSER_PROPERTIES), " + NL + "\t\t\t\t  Boolean.TRUE.equals(options.get(XMLResource.OPTION_USE_LEXICAL_HANDLER))).eContainer());" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{  " + NL + "\t\t\tsuper.doLoad(inputStream, options);" + NL + "\t\t}" + NL + "\t}" + NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$
  protected final String TEXT_35 = "\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_36 = "\tpublic void doLoad(InputSource inputSource, "; //$NON-NLS-1$
  protected final String TEXT_37 = " options) throws IOException" + NL + "\t{" + NL + "\t\tif (options != null && Boolean.TRUE.equals(options.get(OPTION_USE_DATA_CONVERTER)))" + NL + "\t\t{" + NL + "\t\t  getContents().add" + NL + "\t\t\t (load" + NL + "\t\t\t\t (inputSource," + NL + "\t\t\t\t  ("; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
  protected final String TEXT_38 = ")options.get(XMLResource.OPTION_PARSER_FEATURES), " + NL + "\t\t\t\t  ("; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_39 = ")options.get(XMLResource.OPTION_PARSER_PROPERTIES), " + NL + "\t\t\t\t  Boolean.TRUE.equals(options.get(XMLResource.OPTION_USE_LEXICAL_HANDLER))).eContainer());" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{  " + NL + "\t\t\tsuper.doLoad(inputSource, options);" + NL + "\t\t}" + NL + "\t}" + NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static final XMLParserPool parserPool = new XMLParserPoolImpl();" + NL + NL + "\t/**" + NL + "\t * Loads an instance from the input." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param inputSource the input from which to load." + NL + "\t * @param features a map of the parser features and their values." + NL + "\t * @param properties a map of a parser properties and their values." + NL + "\t * @param useLexicalHandler whether a lexical handler should be used during loading." + NL + "\t * @return the root object; for the case of a document root, the child of that document root is return." + NL + "\t * @throws ParserConfigurationException" + NL + "\t * @throws SAXException" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static EObject load(InputSource inputSource, "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$ //$NON-NLS-25$ //$NON-NLS-26$ //$NON-NLS-27$ //$NON-NLS-28$
  protected final String TEXT_40 = " features, "; //$NON-NLS-1$
  protected final String TEXT_41 = " properties, boolean useLexicalHandler) throws IOException" + NL + "\t{" + NL + "\t\t"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_42 = " requiredFeatures = new "; //$NON-NLS-1$
  protected final String TEXT_43 = "();" + NL + "\t\trequiredFeatures.put(\"http://xml.org/sax/features/namespaces\", Boolean.TRUE); " + NL + "\t\tif (features != null)" + NL + "\t\t{" + NL + "\t\t\trequiredFeatures.putAll(features);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif (properties == null)" + NL + "\t\t{" + NL + "\t\t\tproperties = Collections."; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
  protected final String TEXT_44 = "emptyMap()"; //$NON-NLS-1$
  protected final String TEXT_45 = "EMPTY_MAP"; //$NON-NLS-1$
  protected final String TEXT_46 = ";" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tSAXParser saxParser = null;" + NL + "\t\ttry" + NL + "\t\t{" + NL + "\t\t\tsaxParser = parserPool.get(requiredFeatures, properties, useLexicalHandler);" + NL + "\t\t\tfinal FrameFactory.DocumentRootStackFrame documentRoot = FrameFactory.INSTANCE.pushDocumentRoot(null, null);" + NL + "\t\t\tXMLTypeResourceImpl.Handler handler = new XMLTypeResourceImpl.Handler(documentRoot);" + NL + "\t\t\tsaxParser.parse(inputSource, handler);" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
  protected final String TEXT_47 = "\t\t\treturn (EObject)((EObject)FrameFactory.INSTANCE.popDocumentRoot(documentRoot)).eContents().get(0);" + NL; //$NON-NLS-1$
  protected final String TEXT_48 = "\t\t\treturn FrameFactory.INSTANCE.popDocumentRoot(documentRoot).eContents().get(0);" + NL; //$NON-NLS-1$
  protected final String TEXT_49 = "\t\t}" + NL + "\t\tcatch (Exception exception)" + NL + "\t\t{" + NL + "\t\t\tthrow new IOWrappedException(exception);" + NL + "\t\t}" + NL + "\t\tfinally" + NL + "\t\t{" + NL + "\t\t\tparserPool.release(saxParser, requiredFeatures, properties, useLexicalHandler);" + NL + "\t\t}" + NL + "\t}" + NL + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
  protected final String TEXT_50 = "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final static class FrameFactory" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final FrameFactory INSTANCE = new FrameFactory();" + NL + "\t" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$
  protected final String TEXT_51 = "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_52 = "StackFrame "; //$NON-NLS-1$
  protected final String TEXT_53 = ";" + NL + NL; //$NON-NLS-1$
  protected final String TEXT_54 = "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_55 = " "; //$NON-NLS-1$
  protected final String TEXT_56 = ";" + NL + NL; //$NON-NLS-1$
  protected final String TEXT_57 = "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_58 = "StackFrame push"; //$NON-NLS-1$
  protected final String TEXT_59 = "("; //$NON-NLS-1$
  protected final String TEXT_60 = " previous, Attributes attributes)" + NL + "\t\t{" + NL + "\t\t\t "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_61 = "StackFrame result"; //$NON-NLS-1$
  protected final String TEXT_62 = " = "; //$NON-NLS-1$
  protected final String TEXT_63 = " == null ? new "; //$NON-NLS-1$
  protected final String TEXT_64 = "StackFrame() : "; //$NON-NLS-1$
  protected final String TEXT_65 = ";" + NL + "\t\t\t "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_66 = " = null;" + NL + "\t\t\t result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_67 = ".pushOnto(previous);" + NL + "\t\t\t result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_68 = ".handleAttributes(attributes);" + NL + "\t\t\t return result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_69 = ";" + NL + "\t\t}" + NL + NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
  protected final String TEXT_70 = " pop"; //$NON-NLS-1$
  protected final String TEXT_71 = "("; //$NON-NLS-1$
  protected final String TEXT_72 = "StackFrame "; //$NON-NLS-1$
  protected final String TEXT_73 = ")" + NL + "\t\t{" + NL + "\t\t\t"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_74 = " result"; //$NON-NLS-1$
  protected final String TEXT_75 = "Value = "; //$NON-NLS-1$
  protected final String TEXT_76 = ".pop"; //$NON-NLS-1$
  protected final String TEXT_77 = "();" + NL + "\t\t\tthis."; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_78 = " = "; //$NON-NLS-1$
  protected final String TEXT_79 = ";" + NL + "\t\t\treturn result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_80 = "Value;" + NL + "\t\t}" + NL + NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static class "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
  protected final String TEXT_81 = "StackFrame extends "; //$NON-NLS-1$
  protected final String TEXT_82 = NL + "\t\t{" + NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
  protected final String TEXT_83 = " the"; //$NON-NLS-1$
  protected final String TEXT_84 = ";" + NL + "\t\t" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_85 = "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_86 = ".FrameFactory."; //$NON-NLS-1$
  protected final String TEXT_87 = "StackFrame "; //$NON-NLS-1$
  protected final String TEXT_88 = ";" + NL + NL; //$NON-NLS-1$
  protected final String TEXT_89 = "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_90 = " "; //$NON-NLS-1$
  protected final String TEXT_91 = ";" + NL + "\t\t" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_92 = "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
  protected final String TEXT_93 = "\t\t\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_94 = "\t\t\tpublic void handleAttributes(Attributes attributes)" + NL + "\t\t\t{" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_95 = "\t\t\t\tString theValue = attributes.getValue("; //$NON-NLS-1$
  protected final String TEXT_96 = ", \""; //$NON-NLS-1$
  protected final String TEXT_97 = "\");" + NL; //$NON-NLS-1$
  protected final String TEXT_98 = "\t\t\t\ttheValue = attributes.getValue("; //$NON-NLS-1$
  protected final String TEXT_99 = ", \""; //$NON-NLS-1$
  protected final String TEXT_100 = "\");" + NL; //$NON-NLS-1$
  protected final String TEXT_101 = "\t\t\t\tif (theValue != null)" + NL + "\t\t\t\t{" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_102 = "\t\t\t\t\tthe"; //$NON-NLS-1$
  protected final String TEXT_103 = ".set"; //$NON-NLS-1$
  protected final String TEXT_104 = "("; //$NON-NLS-1$
  protected final String TEXT_105 = ".create"; //$NON-NLS-1$
  protected final String TEXT_106 = "(theValue));" + NL; //$NON-NLS-1$
  protected final String TEXT_107 = "\t\t\t\t\tthe"; //$NON-NLS-1$
  protected final String TEXT_108 = ".set"; //$NON-NLS-1$
  protected final String TEXT_109 = "(("; //$NON-NLS-1$
  protected final String TEXT_110 = ")"; //$NON-NLS-1$
  protected final String TEXT_111 = ".createFromString("; //$NON-NLS-1$
  protected final String TEXT_112 = ", theValue));" + NL; //$NON-NLS-1$
  protected final String TEXT_113 = "\t\t\t\t}" + NL; //$NON-NLS-1$
  protected final String TEXT_114 = "\t\t\t\t// There are attributes to handle." + NL; //$NON-NLS-1$
  protected final String TEXT_115 = "\t\t\t}" + NL + "\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
  protected final String TEXT_116 = "\t\t\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_117 = "\t\t\tpublic "; //$NON-NLS-1$
  protected final String TEXT_118 = " startElement(String namespace, String localName, String qName, Attributes attributes) throws SAXException" + NL + "\t\t\t{" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_119 = "\t\t\t\t"; //$NON-NLS-1$
  protected final String TEXT_120 = "else "; //$NON-NLS-1$
  protected final String TEXT_121 = "if (\""; //$NON-NLS-1$
  protected final String TEXT_122 = "\".equals(localName) && "; //$NON-NLS-1$
  protected final String TEXT_123 = ".equals(namespace))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\treturn "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_124 = " = "; //$NON-NLS-1$
  protected final String TEXT_125 = ".FrameFactory.INSTANCE.push"; //$NON-NLS-1$
  protected final String TEXT_126 = "(this, attributes);" + NL + "\t\t\t\t}" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_127 = "\t\t\t\treturn super.startElement(namespace, localName, qName, attributes);" + NL; //$NON-NLS-1$
  protected final String TEXT_128 = "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\treturn super.startElement(namespace, localName, qName, attributes);" + NL + "\t\t\t\t}" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_129 = "\t\t\t}" + NL + NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_130 = "\t\t\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_131 = "\t\t\tpublic void endElement("; //$NON-NLS-1$
  protected final String TEXT_132 = " child) throws SAXException" + NL + "\t\t\t{" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_133 = "\t\t\t\t"; //$NON-NLS-1$
  protected final String TEXT_134 = "else "; //$NON-NLS-1$
  protected final String TEXT_135 = "if (child == "; //$NON-NLS-1$
  protected final String TEXT_136 = ")" + NL + "\t\t\t\t{" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_137 = "\t\t\t\t\tthe"; //$NON-NLS-1$
  protected final String TEXT_138 = "."; //$NON-NLS-1$
  protected final String TEXT_139 = "().add("; //$NON-NLS-1$
  protected final String TEXT_140 = ".FrameFactory.INSTANCE.pop"; //$NON-NLS-1$
  protected final String TEXT_141 = "("; //$NON-NLS-1$
  protected final String TEXT_142 = "));" + NL; //$NON-NLS-1$
  protected final String TEXT_143 = "\t\t\t\t\tthe"; //$NON-NLS-1$
  protected final String TEXT_144 = ".set"; //$NON-NLS-1$
  protected final String TEXT_145 = "("; //$NON-NLS-1$
  protected final String TEXT_146 = ".FrameFactory.INSTANCE.pop"; //$NON-NLS-1$
  protected final String TEXT_147 = "("; //$NON-NLS-1$
  protected final String TEXT_148 = "));" + NL; //$NON-NLS-1$
  protected final String TEXT_149 = "\t\t\t\t\t"; //$NON-NLS-1$
  protected final String TEXT_150 = " = null;" + NL + "\t\t\t\t}" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_151 = "\t\t\t\tsuper.endElement(child);" + NL; //$NON-NLS-1$
  protected final String TEXT_152 = "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tsuper.endElement(child);" + NL + "\t\t\t\t}" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_153 = "\t\t\t}" + NL + NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_154 = "\t\t\t@Override" + NL; //$NON-NLS-1$
  protected final String TEXT_155 = "\t\t\tpublic void create()" + NL + "\t\t\t{" + NL + "\t\t\t\tthe"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_156 = " = "; //$NON-NLS-1$
  protected final String TEXT_157 = ".create"; //$NON-NLS-1$
  protected final String TEXT_158 = "();" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * <!-- begin-user-doc -->" + NL + "\t\t\t * <!-- end-user-doc -->" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
  protected final String TEXT_159 = " pop"; //$NON-NLS-1$
  protected final String TEXT_160 = "()" + NL + "\t\t\t{" + NL + "\t\t\t\tpop();" + NL + "\t\t\t\t"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_161 = " result"; //$NON-NLS-1$
  protected final String TEXT_162 = "Value = the"; //$NON-NLS-1$
  protected final String TEXT_163 = ";" + NL + "\t\t\t\tthe"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_164 = " = null;" + NL + "\t\t\t\treturn result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_165 = "Value;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
  protected final String TEXT_166 = "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_167 = " push"; //$NON-NLS-1$
  protected final String TEXT_168 = "("; //$NON-NLS-1$
  protected final String TEXT_169 = " previous, Attributes attributes)" + NL + "\t\t{" + NL + "\t\t\t "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  protected final String TEXT_170 = " result"; //$NON-NLS-1$
  protected final String TEXT_171 = " = "; //$NON-NLS-1$
  protected final String TEXT_172 = " == null ? new "; //$NON-NLS-1$
  protected final String TEXT_173 = "() : "; //$NON-NLS-1$
  protected final String TEXT_174 = ";" + NL + "\t\t\t "; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_175 = " = null;" + NL + "\t\t\t result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_176 = ".pushOnto(previous);" + NL + "\t\t\t result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_177 = ".handleAttributes(attributes);" + NL + "\t\t\t return result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_178 = ";" + NL + "\t\t}" + NL + NL + "\t\t/**" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
  protected final String TEXT_179 = " pop"; //$NON-NLS-1$
  protected final String TEXT_180 = "("; //$NON-NLS-1$
  protected final String TEXT_181 = " "; //$NON-NLS-1$
  protected final String TEXT_182 = ")" + NL + "\t\t{" + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_183 = "\t\t\t"; //$NON-NLS-1$
  protected final String TEXT_184 = " result"; //$NON-NLS-1$
  protected final String TEXT_185 = "Value = "; //$NON-NLS-1$
  protected final String TEXT_186 = ".create"; //$NON-NLS-1$
  protected final String TEXT_187 = "("; //$NON-NLS-1$
  protected final String TEXT_188 = ".popValue());" + NL; //$NON-NLS-1$
  protected final String TEXT_189 = "\t\t\t"; //$NON-NLS-1$
  protected final String TEXT_190 = " result"; //$NON-NLS-1$
  protected final String TEXT_191 = "Value = (("; //$NON-NLS-1$
  protected final String TEXT_192 = ")"; //$NON-NLS-1$
  protected final String TEXT_193 = ".createFromString("; //$NON-NLS-1$
  protected final String TEXT_194 = ", "; //$NON-NLS-1$
  protected final String TEXT_195 = ".popValue()))."; //$NON-NLS-1$
  protected final String TEXT_196 = "();" + NL; //$NON-NLS-1$
  protected final String TEXT_197 = "\t\t\t"; //$NON-NLS-1$
  protected final String TEXT_198 = " result"; //$NON-NLS-1$
  protected final String TEXT_199 = "Value = ("; //$NON-NLS-1$
  protected final String TEXT_200 = ")"; //$NON-NLS-1$
  protected final String TEXT_201 = ".createFromString("; //$NON-NLS-1$
  protected final String TEXT_202 = ", "; //$NON-NLS-1$
  protected final String TEXT_203 = ".popValue());" + NL; //$NON-NLS-1$
  protected final String TEXT_204 = "\t\t\tthis."; //$NON-NLS-1$
  protected final String TEXT_205 = " = "; //$NON-NLS-1$
  protected final String TEXT_206 = ";" + NL + "\t\t\treturn result"; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_207 = "Value;" + NL + "\t\t}" + NL + NL; //$NON-NLS-1$ //$NON-NLS-2$
  protected final String TEXT_208 = "\t}" + NL + NL; //$NON-NLS-1$
  protected final String TEXT_209 = NL + "\t/**" + NL + "\t * Called when the object is unloaded." + NL + "\t * This implementation" + NL + "\t * {@link InternalEObject#eSetProxyURI sets} the object to be a proxy" + NL + "\t * and clears the {@link #eAdapters adapters}." + NL + "\t * https://bugs.eclipse.org/bugs/show_bug.cgi?id=292866" + NL + "\t * Fix available in HEAD: 2.6.0.I200911020144" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated\t " + NL + "\t */" + NL + "\t@Override" + NL + "\tprotected void unloaded(InternalEObject internalEObject) {" + NL + "\t\t// Ensure that an unresolved containment proxy's URI isn't reset." + NL + "\t\t//" + NL + "\t\tif (!internalEObject.eIsProxy()) {" + NL + "\t\t\tinternalEObject.eSetProxyURI(uri.appendFragment(getURIFragment(internalEObject)));" + NL + "\t\t}" + NL + "\t\tinternalEObject.eAdapters().clear();" + NL + "\t}" + NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Override" + NL + "\tprotected void init() {" + NL + "\t\tsuper.init();" + NL + "\t\tsetTrackingModification(true);" + NL + "\t\tsetEncoding(\"UTF-8\");"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$ //$NON-NLS-25$ //$NON-NLS-26$ //$NON-NLS-27$ //$NON-NLS-28$ //$NON-NLS-29$ //$NON-NLS-30$ //$NON-NLS-31$ //$NON-NLS-32$
  protected final String TEXT_210 = NL;
  protected final String TEXT_211 = "\t\tsetXMIVersion(\"2.1\");"; //$NON-NLS-1$
  protected final String TEXT_212 = NL;
  protected final String TEXT_213 = "\t\t// Save Options" + NL + "    getDefaultSaveOptions().put(XMLResource.OPTION_DISABLE_NOTIFY, Boolean.TRUE);\t\t" + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);" + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, lookupTable);" + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "\t\tgetDefaultSaveOptions().put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);" + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, new XMLTypeInfo() {" + NL + "\t\t\tpublic boolean shouldSaveType(EClass objectType, EClassifier featureType, EStructuralFeature feature) {" + NL + "\t\t\t\treturn objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;" + NL + "\t\t\t}" + NL + "\t\t\tpublic boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature) {" + NL + "\t\t\t\treturn objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, new Integer(80));" + NL + "\t\t// Avoid relative paths from workspace resources to plugin resources." + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new ModelSchemeAware());" + NL + "\t\tgetDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);" + NL + "\t\tgetDefaultSaveOptions().put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);" + NL + "\t\t// Load Options" + NL + "    getDefaultLoadOptions().put(XMLResource.OPTION_DISABLE_NOTIFY, Boolean.TRUE);\t\t" + NL + "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.FALSE);" + NL + "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.FALSE);" + NL + "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);" + NL; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$
  protected final String TEXT_214 = "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_USE_PARSER_POOL, parserPool);" + NL; //$NON-NLS-1$
  protected final String TEXT_215 = "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, nameToFeatureMap);" + NL + "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);" + NL + "\t\tgetDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);" + NL + "\t}" + NL + "} //"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
  protected final String TEXT_216 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();

/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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

GenPackage genPackage = (GenPackage)argument; GenModel genModel=genPackage.getGenModel(); ExtendedMetaData extendedMetaData= genModel.getExtendedMetaData();
    stringBuffer.append(TEXT_1);
{GenBase copyrightHolder = argument instanceof GenBase ? (GenBase)argument : argument instanceof Object[] && ((Object[])argument)[0] instanceof GenBase ? (GenBase)((Object[])argument)[0] : null;
    stringBuffer.append(TEXT_2);
if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_4);
} else {
    stringBuffer.append(TEXT_5);
}}
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genPackage.getUtilitiesPackageName());
    stringBuffer.append(TEXT_8);
genModel.getImportedName("org.eclipse.emf.common.util.URI");
genModel.getImportedName("org.eclipse.emf.ecore.EClass");
genModel.getImportedName("org.eclipse.emf.ecore.EClassifier");
genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature");
genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource");
genModel.getImportedName("org.eclipse.egf.model.uri.ModelSchemeAware");
genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject");
genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genPackage.getQualifiedResourceFactoryClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genPackage.getImportedResourceBaseClassName());
    stringBuffer.append(TEXT_12);
if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_16);
}
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_19);
if (genPackage.getResource() == GenResourceKind.XMI_LITERAL) {
    stringBuffer.append(TEXT_20);
}
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genModel.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genModel.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_24);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_25);
}
    stringBuffer.append(TEXT_26);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_27);
}
    stringBuffer.append(TEXT_28);
if (genPackage.isDataTypeConverters() && (genPackage.hasDocumentRoot() || org.eclipse.emf.ecore.xml.type.XMLTypePackage.eNS_URI.equals(genPackage.getNSURI()))) { boolean isXMLTypePackage = org.eclipse.emf.ecore.xml.type.XMLTypePackage.eNS_URI.equals(genPackage.getNSURI());
final String _Map = genModel.useGenerics() ? "Map<?, ?>" : "Map";
final String _MapStringBoolean = genModel.useGenerics() ? "Map<String, Boolean>" : "Map";
final String _MapStringWildcard = genModel.useGenerics() ? "Map<String, ?>" : "Map";
if (!isXMLTypePackage) {
genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource");
genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLParserPool");
genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl");
genModel.getImportedName("java.io.InputStream");
genModel.getImportedName("java.io.IOException");
genModel.getImportedName("org.eclipse.emf.ecore.EObject");
genModel.getImportedName("java.util.Collections");
genModel.getImportedName("java.util.HashMap");
genModel.getImportedName("java.util.Map");
genModel.getImportedName("org.xml.sax.InputSource");
genModel.getImportedName("javax.xml.parsers.SAXParser");
}
genModel.getImportedName("org.xml.sax.Attributes");
genModel.getImportedName("org.xml.sax.SAXException");
String _StackFrame = genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeResourceImpl")+".StackFrame";
String _DataFrame = genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeResourceImpl")+".DataFrame";
if (!isXMLTypePackage) {
    stringBuffer.append(TEXT_29);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_30);
}
    stringBuffer.append(TEXT_31);
    stringBuffer.append(_Map);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(_MapStringBoolean);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(_MapStringWildcard);
    stringBuffer.append(TEXT_34);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_35);
}
    stringBuffer.append(TEXT_36);
    stringBuffer.append(_Map);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(_MapStringBoolean);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(_MapStringWildcard);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(_MapStringBoolean);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(_MapStringWildcard);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(_MapStringBoolean);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(_MapStringBoolean.replaceAll("Map","HashMap"));
    stringBuffer.append(TEXT_43);
if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_44);
} else {
    stringBuffer.append(TEXT_45);
}
    stringBuffer.append(TEXT_46);
if (genModel.isSuppressEMFTypes()) {
    stringBuffer.append(TEXT_47);
} else {
    stringBuffer.append(TEXT_48);
}
    stringBuffer.append(TEXT_49);
}
    stringBuffer.append(TEXT_50);
for (GenClass genClass : genPackage.getGenClasses()) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_53);
}
for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(_DataFrame);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_56);
}
for (GenClass genClass : genPackage.getGenClasses()) {
List<EStructuralFeature> attributes = extendedMetaData.getAllAttributes(genClass.getEcoreClass());
List<EStructuralFeature> elements = extendedMetaData.getAllElements(genClass.getEcoreClass());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(_StackFrame);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(_StackFrame);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_84);
for (GenFeature genFeature : genClass.getAllGenFeatures()) {
String name = extendedMetaData.getName(genFeature.getEcoreFeature());
if ((elements.contains(genFeature.getEcoreFeature()) || attributes.contains(genFeature.getEcoreFeature())) && name.indexOf(":") == -1) {
if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getTypeGenClass().getGenPackage().getImportedResourceClassName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genFeature.getTypeGenClass().getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_88);
} else {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(_DataFrame);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_91);
}
}
}
    stringBuffer.append(TEXT_92);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_93);
}
    stringBuffer.append(TEXT_94);
int count = 0; for (GenFeature genFeature : genClass.getAllGenFeatures()) {
String name = extendedMetaData.getName(genFeature.getEcoreFeature());
if (attributes.contains(genFeature.getEcoreFeature()) && !genFeature.isDerived() && name.indexOf(":") == -1) {
String namespace = Literals.toStringLiteral(extendedMetaData.getNamespace(genFeature.getEcoreFeature()), genModel); if ("null".equals(namespace)) namespace = "\"\"";
if (!genFeature.isReferenceType()) { GenClassifier genClassifier = genFeature.getTypeGenClassifier();
if (count++ == 0) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(namespace);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_97);
} else {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(namespace);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_100);
}
    stringBuffer.append(TEXT_101);
if (genClassifier.getGenPackage().isDataTypeConverters()) {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genClassifier.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genClassifier.getName());
    stringBuffer.append(TEXT_106);
} else {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genFeature.getImportedType(null));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(genClassifier.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genClassifier.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_112);
}
    stringBuffer.append(TEXT_113);
}
}
}
if (count == 0) {
    stringBuffer.append(TEXT_114);
}
    stringBuffer.append(TEXT_115);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_116);
}
    stringBuffer.append(TEXT_117);
    stringBuffer.append(_StackFrame);
    stringBuffer.append(TEXT_118);
count = 0; for (GenFeature genFeature : genClass.getAllGenFeatures()) {
String name = extendedMetaData.getName(genFeature.getEcoreFeature());
if (elements.contains(genFeature.getEcoreFeature()) && name.indexOf(":") == -1) {
String namespace = Literals.toStringLiteral(extendedMetaData.getNamespace(genFeature.getEcoreFeature()), genModel); if ("null".equals(namespace)) namespace = "\"\"";
    stringBuffer.append(TEXT_119);
if (count++ != 0) {
    stringBuffer.append(TEXT_120);
}
    stringBuffer.append(TEXT_121);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(namespace);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genFeature.getTypeGenClassifier().getGenPackage().getImportedResourceClassName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genFeature.getTypeGenClassifier().getName());
    stringBuffer.append(TEXT_126);
}
}
if (count == 0) {
    stringBuffer.append(TEXT_127);
} else {
    stringBuffer.append(TEXT_128);
}
    stringBuffer.append(TEXT_129);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_130);
}
    stringBuffer.append(TEXT_131);
    stringBuffer.append(_StackFrame);
    stringBuffer.append(TEXT_132);
count = 0; for (GenFeature genFeature : genClass.getAllGenFeatures()) {
String name = extendedMetaData.getName(genFeature.getEcoreFeature());
if (elements.contains(genFeature.getEcoreFeature()) && name.indexOf(":") == -1) {
    stringBuffer.append(TEXT_133);
if (count++ != 0) {
    stringBuffer.append(TEXT_134);
}
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_136);
if (genFeature.isListType()) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genFeature.getTypeGenClassifier().getGenPackage().getImportedResourceClassName());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getTypeGenClassifier().getName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_142);
} else {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genFeature.getTypeGenClassifier().getGenPackage().getImportedResourceClassName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genFeature.getTypeGenClassifier().getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_148);
}
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_150);
}
}
if (count == 0) {
    stringBuffer.append(TEXT_151);
} else {
    stringBuffer.append(TEXT_152);
}
    stringBuffer.append(TEXT_153);
if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_154);
}
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genPackage.getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_165);
}
for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(_DataFrame);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(_StackFrame);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(_DataFrame);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(_DataFrame);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(_DataFrame);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_182);
if (genDataType.getGenPackage().isDataTypeConverters()) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(genDataType.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_188);
} else if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genDataType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_196);
} else {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_203);
}
    stringBuffer.append(TEXT_204);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_207);
}
    stringBuffer.append(TEXT_208);
}
    stringBuffer.append(TEXT_209);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_210);
if (genPackage.getResource() == GenResourceKind.XMI_LITERAL) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_212);
}
    stringBuffer.append(TEXT_213);
if (genPackage.getResource() == GenResourceKind.XMI_LITERAL) {
    stringBuffer.append(TEXT_214);
}
    stringBuffer.append(TEXT_215);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_216);
genModel.emitSortedImports();
    return stringBuffer.toString();
  }
}
