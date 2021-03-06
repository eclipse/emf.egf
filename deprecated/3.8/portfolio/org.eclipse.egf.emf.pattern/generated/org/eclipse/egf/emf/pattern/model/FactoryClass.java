//Generated on Mon May 28 11:57:58 CEST 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.model;

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

public class FactoryClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
    protected static String nl;

    public static synchronized FactoryClass create(String lineSeparator) {
        nl = lineSeparator;
        FactoryClass result = new FactoryClass();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + "package ";
    protected final String TEXT_3 = ";";
    protected final String TEXT_4 = NL + "package ";
    protected final String TEXT_5 = ";";
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL;
    protected final String TEXT_8 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Factory</b> for the model." + NL + " * It provides a create method for each non-abstract class of the model." + NL + " * <!-- end-user-doc -->";
    protected final String TEXT_9 = NL + " * @see ";
    protected final String TEXT_10 = NL + " * @generated" + NL + " */";
    protected final String TEXT_11 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model <b>Factory</b>." + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */";
    protected final String TEXT_12 = NL + "public class ";
    protected final String TEXT_13 = " extends ";
    protected final String TEXT_14 = " implements ";
    protected final String TEXT_15 = NL + "public interface ";
    protected final String TEXT_16 = " extends ";
    protected final String TEXT_17 = NL + "{";
    protected final String TEXT_18 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_19 = " copyright = ";
    protected final String TEXT_20 = ";";
    protected final String TEXT_21 = NL;
    protected final String TEXT_22 = NL + "\t/**" + NL + "\t * The singleton instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_23 = " eINSTANCE = init();" + NL;
    protected final String TEXT_24 = NL + "\t/**" + NL + "\t * The singleton instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_25 = " INSTANCE = ";
    protected final String TEXT_26 = ".eINSTANCE;" + NL;
    protected final String TEXT_27 = NL + "\t/**" + NL + "\t * The singleton instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_28 = " eINSTANCE = ";
    protected final String TEXT_29 = ".init();" + NL;
    protected final String TEXT_30 = NL + "\t/**" + NL + "\t * Creates the default factory implementation." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_31 = NL + "\tpublic static ";
    protected final String TEXT_32 = " init()" + NL + "\t{" + NL + "\t\ttry" + NL + "\t\t{" + NL + "\t\t\t";
    protected final String TEXT_33 = " the";
    protected final String TEXT_34 = " = (";
    protected final String TEXT_35 = ")";
    protected final String TEXT_36 = ".Registry.INSTANCE.getEFactory(\"";
    protected final String TEXT_37 = "\");";
    protected final String TEXT_38 = " " + NL + "\t\t\tif (the";
    protected final String TEXT_39 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\treturn the";
    protected final String TEXT_40 = ";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (Exception exception)" + NL + "\t\t{" + NL + "\t\t\t";
    protected final String TEXT_41 = ".INSTANCE.log(exception);" + NL + "\t\t}" + NL + "\t\treturn new ";
    protected final String TEXT_42 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates an instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_43 = "()" + NL + "\t{" + NL + "\t\tsuper();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_44 = NL + "\t@Override";
    protected final String TEXT_45 = NL + "\tpublic EObject create(EClass eClass)" + NL + "\t{" + NL + "\t\tswitch (eClass.getClassifierID())" + NL + "\t\t{";
    protected final String TEXT_46 = NL + "\t\t\tcase ";
    protected final String TEXT_47 = ".";
    protected final String TEXT_48 = ": return ";
    protected final String TEXT_49 = "create";
    protected final String TEXT_50 = "();";
    protected final String TEXT_51 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The class '\" + eClass.getName() + \"' is not a valid classifier\");";
    protected final String TEXT_52 = NL + "\t\t}" + NL + "\t}" + NL;
    protected final String TEXT_53 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_54 = NL + "\t@Override";
    protected final String TEXT_55 = NL + "\tpublic Object createFromString(";
    protected final String TEXT_56 = " eDataType, String initialValue)" + NL + "\t{" + NL + "\t\tswitch (eDataType.getClassifierID())" + NL + "\t\t{";
    protected final String TEXT_57 = NL + "\t\t\tcase ";
    protected final String TEXT_58 = ".";
    protected final String TEXT_59 = ":" + NL + "\t\t\t\treturn create";
    protected final String TEXT_60 = "FromString(eDataType, initialValue);";
    protected final String TEXT_61 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The datatype '\" + eDataType.getName() + \"' is not a valid classifier\");";
    protected final String TEXT_62 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_63 = NL + "\t@Override";
    protected final String TEXT_64 = NL + "\tpublic String convertToString(";
    protected final String TEXT_65 = " eDataType, Object instanceValue)" + NL + "\t{" + NL + "\t\tswitch (eDataType.getClassifierID())" + NL + "\t\t{";
    protected final String TEXT_66 = NL + "\t\t\tcase ";
    protected final String TEXT_67 = ".";
    protected final String TEXT_68 = ":" + NL + "\t\t\t\treturn convert";
    protected final String TEXT_69 = "ToString(eDataType, instanceValue);";
    protected final String TEXT_70 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The datatype '\" + eDataType.getName() + \"' is not a valid classifier\");";
    protected final String TEXT_71 = NL + "\t\t}" + NL + "\t}" + NL;
    protected final String TEXT_72 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_73 = " create";
    protected final String TEXT_74 = "()" + NL + "\t{";
    protected final String TEXT_75 = NL + "\t\t";
    protected final String TEXT_76 = " ";
    protected final String TEXT_77 = " = ";
    protected final String TEXT_78 = "super.create(";
    protected final String TEXT_79 = ");";
    protected final String TEXT_80 = NL + "\t\t";
    protected final String TEXT_81 = " ";
    protected final String TEXT_82 = " = new ";
    protected final String TEXT_83 = "()";
    protected final String TEXT_84 = "{}";
    protected final String TEXT_85 = ";";
    protected final String TEXT_86 = NL + "\t\treturn ";
    protected final String TEXT_87 = ";" + NL + "\t}" + NL;
    protected final String TEXT_88 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_89 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_90 = NL + "\tpublic ";
    protected final String TEXT_91 = " create";
    protected final String TEXT_92 = "(String ";
    protected final String TEXT_93 = "it";
    protected final String TEXT_94 = "literal";
    protected final String TEXT_95 = ")" + NL + "\t{";
    protected final String TEXT_96 = NL + "\t\t";
    protected final String TEXT_97 = NL + "\t\t";
    protected final String TEXT_98 = " result = ";
    protected final String TEXT_99 = ".get(literal);" + NL + "\t\tif (result == null) throw new IllegalArgumentException(\"The value '\" + literal + \"' is not a valid enumerator of '\" + ";
    protected final String TEXT_100 = ".getName() + \"'\");";
    protected final String TEXT_101 = NL + "\t\treturn result;";
    protected final String TEXT_102 = NL + "\t\treturn new ";
    protected final String TEXT_103 = "(create";
    protected final String TEXT_104 = "(literal));";
    protected final String TEXT_105 = NL + "\t\treturn create";
    protected final String TEXT_106 = "(literal);";
    protected final String TEXT_107 = NL + "\t\treturn new ";
    protected final String TEXT_108 = "(";
    protected final String TEXT_109 = ".create";
    protected final String TEXT_110 = "(literal));";
    protected final String TEXT_111 = NL + "\t\treturn ";
    protected final String TEXT_112 = ".create";
    protected final String TEXT_113 = "(literal);";
    protected final String TEXT_114 = NL + "\t\treturn ";
    protected final String TEXT_115 = "(";
    protected final String TEXT_116 = ")";
    protected final String TEXT_117 = ".createFromString(";
    protected final String TEXT_118 = ", literal);";
    protected final String TEXT_119 = NL + "\t\tif (literal == null) return null;" + NL + "\t\t";
    protected final String TEXT_120 = " result = new ";
    protected final String TEXT_121 = "<";
    protected final String TEXT_122 = ">";
    protected final String TEXT_123 = "();";
    protected final String TEXT_124 = NL + "\t\tfor (";
    protected final String TEXT_125 = " stringTokenizer = new ";
    protected final String TEXT_126 = "(literal); stringTokenizer.hasMoreTokens(); )";
    protected final String TEXT_127 = NL + "\t\tfor (String item : split(literal))";
    protected final String TEXT_128 = NL + "\t\t{";
    protected final String TEXT_129 = NL + "\t\t\tString item = stringTokenizer.nextToken();";
    protected final String TEXT_130 = NL + "\t\t\tresult.add(create";
    protected final String TEXT_131 = "(item));";
    protected final String TEXT_132 = NL + "\t\t\tresult.add(create";
    protected final String TEXT_133 = "FromString(";
    protected final String TEXT_134 = ", item));";
    protected final String TEXT_135 = NL + "\t\t\tresult.add(";
    protected final String TEXT_136 = ".create";
    protected final String TEXT_137 = "(item));";
    protected final String TEXT_138 = NL + "\t\t\tresult.add(";
    protected final String TEXT_139 = ".createFromString(";
    protected final String TEXT_140 = ", item));";
    protected final String TEXT_141 = NL + "\t\t}" + NL + "\t\treturn result;";
    protected final String TEXT_142 = NL + "\t\tif (literal == null) return ";
    protected final String TEXT_143 = ";" + NL + "\t\t";
    protected final String TEXT_144 = " result = ";
    protected final String TEXT_145 = ";" + NL + "\t\tRuntimeException exception = null;";
    protected final String TEXT_146 = NL + "\t\ttry" + NL + "\t\t{";
    protected final String TEXT_147 = NL + "\t\t\tresult = create";
    protected final String TEXT_148 = "(literal);";
    protected final String TEXT_149 = NL + "\t\t\tresult = (";
    protected final String TEXT_150 = ")create";
    protected final String TEXT_151 = "FromString(";
    protected final String TEXT_152 = ", literal);";
    protected final String TEXT_153 = NL + "\t\t\tresult = ";
    protected final String TEXT_154 = ".create";
    protected final String TEXT_155 = "(literal);";
    protected final String TEXT_156 = NL + "\t\t\tresult = (";
    protected final String TEXT_157 = ")";
    protected final String TEXT_158 = ".createFromString(";
    protected final String TEXT_159 = ", literal);";
    protected final String TEXT_160 = NL + "\t\t\tif (";
    protected final String TEXT_161 = "result != null && ";
    protected final String TEXT_162 = ".INSTANCE.validate(";
    protected final String TEXT_163 = ", ";
    protected final String TEXT_164 = "new ";
    protected final String TEXT_165 = "(result)";
    protected final String TEXT_166 = "result";
    protected final String TEXT_167 = ", null, null))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (RuntimeException e)" + NL + "\t\t{" + NL + "\t\t\texception = e;" + NL + "\t\t}";
    protected final String TEXT_168 = NL + "\t\tif (";
    protected final String TEXT_169 = "result != null || ";
    protected final String TEXT_170 = "exception == null) return result;" + NL + "    " + NL + "\t\tthrow exception;";
    protected final String TEXT_171 = NL + "\t\treturn (";
    protected final String TEXT_172 = ")super.createFromString(literal);";
    protected final String TEXT_173 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
    protected final String TEXT_174 = "();";
    protected final String TEXT_175 = NL + "\t\treturn ((";
    protected final String TEXT_176 = ")super.createFromString(";
    protected final String TEXT_177 = ", literal)).";
    protected final String TEXT_178 = "();";
    protected final String TEXT_179 = NL + "\t\treturn ";
    protected final String TEXT_180 = "(";
    protected final String TEXT_181 = ")";
    protected final String TEXT_182 = "super.createFromString(";
    protected final String TEXT_183 = ", literal);";
    protected final String TEXT_184 = NL + "\t}" + NL;
    protected final String TEXT_185 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_186 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_187 = NL + "\tpublic ";
    protected final String TEXT_188 = " create";
    protected final String TEXT_189 = "FromString(";
    protected final String TEXT_190 = " eDataType, String initialValue)" + NL + "\t{";
    protected final String TEXT_191 = NL + "\t\treturn create";
    protected final String TEXT_192 = "(initialValue);";
    protected final String TEXT_193 = NL + "\t\t";
    protected final String TEXT_194 = " result = ";
    protected final String TEXT_195 = ".get(initialValue);" + NL + "\t\tif (result == null) throw new IllegalArgumentException(\"The value '\" + initialValue + \"' is not a valid enumerator of '\" + eDataType.getName() + \"'\");";
    protected final String TEXT_196 = NL + "\t\treturn result;";
    protected final String TEXT_197 = NL + "\t\treturn ";
    protected final String TEXT_198 = "(";
    protected final String TEXT_199 = ")";
    protected final String TEXT_200 = "create";
    protected final String TEXT_201 = "FromString(";
    protected final String TEXT_202 = ", initialValue);";
    protected final String TEXT_203 = NL + "\t\treturn ";
    protected final String TEXT_204 = "(";
    protected final String TEXT_205 = ")";
    protected final String TEXT_206 = ".createFromString(";
    protected final String TEXT_207 = ", initialValue);";
    protected final String TEXT_208 = NL + "\t\treturn create";
    protected final String TEXT_209 = "(initialValue);";
    protected final String TEXT_210 = NL + "\t\tif (initialValue == null) return null;" + NL + "\t\t";
    protected final String TEXT_211 = " result = new ";
    protected final String TEXT_212 = "<";
    protected final String TEXT_213 = ">";
    protected final String TEXT_214 = "();";
    protected final String TEXT_215 = NL + "\t\tfor (";
    protected final String TEXT_216 = " stringTokenizer = new ";
    protected final String TEXT_217 = "(initialValue); stringTokenizer.hasMoreTokens(); )";
    protected final String TEXT_218 = NL + "\t\tfor (String item : split(initialValue))";
    protected final String TEXT_219 = NL + "\t\t{";
    protected final String TEXT_220 = NL + "\t\t\tString item = stringTokenizer.nextToken();";
    protected final String TEXT_221 = NL + "\t\t\tresult.add(create";
    protected final String TEXT_222 = "FromString(";
    protected final String TEXT_223 = ", item));";
    protected final String TEXT_224 = NL + "\t\t\tresult.add(";
    protected final String TEXT_225 = "(";
    protected final String TEXT_226 = ")";
    protected final String TEXT_227 = ".createFromString(";
    protected final String TEXT_228 = ", item));";
    protected final String TEXT_229 = NL + "\t\t}" + NL + "\t\treturn result;";
    protected final String TEXT_230 = NL + "\t\treturn new ";
    protected final String TEXT_231 = "(create";
    protected final String TEXT_232 = "(initialValue));";
    protected final String TEXT_233 = NL + "\t\treturn create";
    protected final String TEXT_234 = "(initialValue);";
    protected final String TEXT_235 = NL + "\t\tif (initialValue == null) return null;" + NL + "\t\t";
    protected final String TEXT_236 = " result = null;" + NL + "\t\tRuntimeException exception = null;";
    protected final String TEXT_237 = NL + "\t\ttry" + NL + "\t\t{";
    protected final String TEXT_238 = NL + "\t\t\tresult = ";
    protected final String TEXT_239 = "(";
    protected final String TEXT_240 = ")";
    protected final String TEXT_241 = "create";
    protected final String TEXT_242 = "FromString(";
    protected final String TEXT_243 = ", initialValue);";
    protected final String TEXT_244 = NL + "\t\t\tresult = ";
    protected final String TEXT_245 = "(";
    protected final String TEXT_246 = ")";
    protected final String TEXT_247 = ".createFromString(";
    protected final String TEXT_248 = ", initialValue);";
    protected final String TEXT_249 = NL + "\t\t\tif (result != null && ";
    protected final String TEXT_250 = ".INSTANCE.validate(eDataType, result, null, null))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (RuntimeException e)" + NL + "\t\t{" + NL + "\t\t\texception = e;" + NL + "\t\t}";
    protected final String TEXT_251 = NL + "\t\tif (result != null || exception == null) return result;" + NL + "    " + NL + "\t\tthrow exception;";
    protected final String TEXT_252 = NL + "\t\treturn create";
    protected final String TEXT_253 = "(initialValue);";
    protected final String TEXT_254 = NL + "\t\treturn ";
    protected final String TEXT_255 = "(";
    protected final String TEXT_256 = ")";
    protected final String TEXT_257 = "super.createFromString(initialValue);";
    protected final String TEXT_258 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
    protected final String TEXT_259 = "();";
    protected final String TEXT_260 = NL + "\t\treturn ";
    protected final String TEXT_261 = "(";
    protected final String TEXT_262 = ")";
    protected final String TEXT_263 = "super.createFromString(eDataType, initialValue);";
    protected final String TEXT_264 = NL + "\t}" + NL;
    protected final String TEXT_265 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convert";
    protected final String TEXT_266 = "(";
    protected final String TEXT_267 = " ";
    protected final String TEXT_268 = "it";
    protected final String TEXT_269 = "instanceValue";
    protected final String TEXT_270 = ")" + NL + "\t{";
    protected final String TEXT_271 = NL + "\t\t";
    protected final String TEXT_272 = NL + "\t\treturn instanceValue == null ? null : instanceValue.toString();";
    protected final String TEXT_273 = NL + "\t\treturn instanceValue == null ? null : convert";
    protected final String TEXT_274 = "(instanceValue";
    protected final String TEXT_275 = ".";
    protected final String TEXT_276 = "()";
    protected final String TEXT_277 = ");";
    protected final String TEXT_278 = NL + "\t\treturn convert";
    protected final String TEXT_279 = "(instanceValue);";
    protected final String TEXT_280 = NL + "\t\treturn ";
    protected final String TEXT_281 = ".convert";
    protected final String TEXT_282 = "(instanceValue);";
    protected final String TEXT_283 = NL + "\t\treturn ";
    protected final String TEXT_284 = ".convertToString(";
    protected final String TEXT_285 = ", instanceValue);";
    protected final String TEXT_286 = NL + "\t\tif (instanceValue == null) return null;" + NL + "\t\tif (instanceValue.isEmpty()) return \"\";" + NL + "\t\t";
    protected final String TEXT_287 = " result = new ";
    protected final String TEXT_288 = "();";
    protected final String TEXT_289 = NL + "\t\tfor (";
    protected final String TEXT_290 = " i = instanceValue.iterator(); i.hasNext(); )";
    protected final String TEXT_291 = NL + "\t\tfor (";
    protected final String TEXT_292 = " item : instanceValue)";
    protected final String TEXT_293 = NL + "\t\t{";
    protected final String TEXT_294 = NL + "\t\t\tresult.append(convert";
    protected final String TEXT_295 = "((";
    protected final String TEXT_296 = ")";
    protected final String TEXT_297 = "));";
    protected final String TEXT_298 = NL + "\t\t\tresult.append(convert";
    protected final String TEXT_299 = "ToString(";
    protected final String TEXT_300 = ", ";
    protected final String TEXT_301 = "));";
    protected final String TEXT_302 = NL + "\t\t\tresult.append(";
    protected final String TEXT_303 = ".convert";
    protected final String TEXT_304 = "((";
    protected final String TEXT_305 = ")";
    protected final String TEXT_306 = "));";
    protected final String TEXT_307 = NL + "\t\t\tresult.append(";
    protected final String TEXT_308 = ".convertToString(";
    protected final String TEXT_309 = ", ";
    protected final String TEXT_310 = "));";
    protected final String TEXT_311 = NL + "\t\t\tresult.append(' ');" + NL + "\t\t}" + NL + "\t\treturn result.substring(0, result.length() - 1);";
    protected final String TEXT_312 = NL + "\t\tif (instanceValue == null) return null;";
    protected final String TEXT_313 = NL + "\t\tif (";
    protected final String TEXT_314 = ".isInstance(instanceValue))" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{";
    protected final String TEXT_315 = NL + "\t\t\t\tString value = convert";
    protected final String TEXT_316 = "(instanceValue);";
    protected final String TEXT_317 = NL + "\t\t\t\tString value = convert";
    protected final String TEXT_318 = "(((";
    protected final String TEXT_319 = ")instanceValue).";
    protected final String TEXT_320 = "());";
    protected final String TEXT_321 = NL + "\t\t\t\tString value = convert";
    protected final String TEXT_322 = "((";
    protected final String TEXT_323 = ")instanceValue);";
    protected final String TEXT_324 = NL + "\t\t\t\tString value = convert";
    protected final String TEXT_325 = "ToString(";
    protected final String TEXT_326 = ", instanceValue);";
    protected final String TEXT_327 = NL + "\t\t\t\tString value = ";
    protected final String TEXT_328 = ".convert";
    protected final String TEXT_329 = "((";
    protected final String TEXT_330 = ")instanceValue);";
    protected final String TEXT_331 = NL + "\t\t\t\tString value = ";
    protected final String TEXT_332 = ".convertToString(";
    protected final String TEXT_333 = ", instanceValue);";
    protected final String TEXT_334 = NL + "\t\t\t\tif (value != null) return value;" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t\t// Keep trying other member types until all have failed." + NL + "\t\t\t}" + NL + "\t\t}";
    protected final String TEXT_335 = NL + "\t\ttry" + NL + "\t\t{";
    protected final String TEXT_336 = NL + "\t\t\tString value = convert";
    protected final String TEXT_337 = "(instanceValue);";
    protected final String TEXT_338 = NL + "\t\t\tString value = convert";
    protected final String TEXT_339 = "ToString(";
    protected final String TEXT_340 = ", ";
    protected final String TEXT_341 = "new ";
    protected final String TEXT_342 = "(instanceValue)";
    protected final String TEXT_343 = "instanceValue";
    protected final String TEXT_344 = ");";
    protected final String TEXT_345 = NL + "\t\t\tString value = ";
    protected final String TEXT_346 = ".convert";
    protected final String TEXT_347 = "(instanceValue);";
    protected final String TEXT_348 = NL + "\t\t\tString value = ";
    protected final String TEXT_349 = ".convertToString(";
    protected final String TEXT_350 = ", ";
    protected final String TEXT_351 = "new ";
    protected final String TEXT_352 = "(instanceValue)";
    protected final String TEXT_353 = "instanceValue";
    protected final String TEXT_354 = ");";
    protected final String TEXT_355 = NL + "\t\t\tif (value != null) return value;" + NL + "\t\t}" + NL + "\t\tcatch (Exception e)" + NL + "\t\t{" + NL + "\t\t\t// Keep trying other member types until all have failed." + NL + "\t\t}";
    protected final String TEXT_356 = NL + "\t\tthrow new IllegalArgumentException(\"Invalid value: '\"+instanceValue+\"' for datatype :\"+";
    protected final String TEXT_357 = ".getName());";
    protected final String TEXT_358 = NL + "\t\treturn super.convertToString(instanceValue);";
    protected final String TEXT_359 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
    protected final String TEXT_360 = "();";
    protected final String TEXT_361 = NL + "\t\treturn super.convertToString(";
    protected final String TEXT_362 = ", new ";
    protected final String TEXT_363 = "(instanceValue));";
    protected final String TEXT_364 = NL + "\t\treturn super.convertToString(";
    protected final String TEXT_365 = ", instanceValue);";
    protected final String TEXT_366 = NL + "\t}" + NL;
    protected final String TEXT_367 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_368 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_369 = NL + "\tpublic String convert";
    protected final String TEXT_370 = "ToString(";
    protected final String TEXT_371 = " eDataType, Object instanceValue)" + NL + "\t{";
    protected final String TEXT_372 = NL + "\t\treturn convert";
    protected final String TEXT_373 = "((";
    protected final String TEXT_374 = ")instanceValue);";
    protected final String TEXT_375 = NL + "\t\treturn instanceValue == null ? null : instanceValue.toString();";
    protected final String TEXT_376 = NL + "\t\treturn convert";
    protected final String TEXT_377 = "ToString(";
    protected final String TEXT_378 = ", instanceValue);";
    protected final String TEXT_379 = NL + "\t\treturn ";
    protected final String TEXT_380 = ".convertToString(";
    protected final String TEXT_381 = ", instanceValue);";
    protected final String TEXT_382 = NL + "\t\treturn convert";
    protected final String TEXT_383 = "((";
    protected final String TEXT_384 = ")instanceValue);";
    protected final String TEXT_385 = NL + "\t\tif (instanceValue == null) return null;" + NL + "\t\t";
    protected final String TEXT_386 = " list = (";
    protected final String TEXT_387 = ")instanceValue;" + NL + "\t\tif (list.isEmpty()) return \"\";" + NL + "\t\t";
    protected final String TEXT_388 = " result = new ";
    protected final String TEXT_389 = "();";
    protected final String TEXT_390 = NL + "\t\tfor (";
    protected final String TEXT_391 = " i = list.iterator(); i.hasNext(); )";
    protected final String TEXT_392 = NL + "\t\tfor (";
    protected final String TEXT_393 = " item : list)";
    protected final String TEXT_394 = NL + "\t\t{";
    protected final String TEXT_395 = NL + "\t\t\tresult.append(convert";
    protected final String TEXT_396 = "ToString(";
    protected final String TEXT_397 = ", ";
    protected final String TEXT_398 = "));";
    protected final String TEXT_399 = NL + "\t\t\tresult.append(";
    protected final String TEXT_400 = ".convertToString(";
    protected final String TEXT_401 = ", ";
    protected final String TEXT_402 = "));";
    protected final String TEXT_403 = NL + "\t\t\tresult.append(' ');" + NL + "\t\t}" + NL + "\t\treturn result.substring(0, result.length() - 1);";
    protected final String TEXT_404 = NL + "\t\treturn instanceValue == null ? null : convert";
    protected final String TEXT_405 = "(((";
    protected final String TEXT_406 = ")instanceValue)";
    protected final String TEXT_407 = ".";
    protected final String TEXT_408 = "()";
    protected final String TEXT_409 = ");";
    protected final String TEXT_410 = NL + "\t\treturn convert";
    protected final String TEXT_411 = "(instanceValue);";
    protected final String TEXT_412 = NL + "\t\tif (instanceValue == null) return null;";
    protected final String TEXT_413 = NL + "\t\tif (";
    protected final String TEXT_414 = ".isInstance(instanceValue))" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{";
    protected final String TEXT_415 = NL + "\t\t\t\tString value = convert";
    protected final String TEXT_416 = "ToString(";
    protected final String TEXT_417 = ", instanceValue);";
    protected final String TEXT_418 = NL + "\t\t\t\tString value = ";
    protected final String TEXT_419 = ".convertToString(";
    protected final String TEXT_420 = ", instanceValue);";
    protected final String TEXT_421 = NL + "\t\t\t\tif (value != null) return value;" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t\t// Keep trying other member types until all have failed." + NL + "\t\t\t}" + NL + "\t\t}";
    protected final String TEXT_422 = NL + "\t\tthrow new IllegalArgumentException(\"Invalid value: '\"+instanceValue+\"' for datatype :\"+eDataType.getName());";
    protected final String TEXT_423 = NL + "\t\treturn instanceValue == null ? null : convert";
    protected final String TEXT_424 = "(";
    protected final String TEXT_425 = "(";
    protected final String TEXT_426 = "(";
    protected final String TEXT_427 = ")instanceValue";
    protected final String TEXT_428 = ").";
    protected final String TEXT_429 = "()";
    protected final String TEXT_430 = ");";
    protected final String TEXT_431 = NL + "\t\treturn convert";
    protected final String TEXT_432 = "((";
    protected final String TEXT_433 = ")instanceValue);";
    protected final String TEXT_434 = NL + "\t\treturn super.convertToString(instanceValue);";
    protected final String TEXT_435 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
    protected final String TEXT_436 = "();";
    protected final String TEXT_437 = NL + "\t\treturn super.convertToString(eDataType, instanceValue);";
    protected final String TEXT_438 = NL + "\t}" + NL;
    protected final String TEXT_439 = NL + "\t/**" + NL + "\t * Returns a new object of class '<em>";
    protected final String TEXT_440 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return a new object of class '<em>";
    protected final String TEXT_441 = "</em>'." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_442 = " create";
    protected final String TEXT_443 = "();" + NL;
    protected final String TEXT_444 = NL + "\t/**" + NL + "\t * Returns an instance of data type '<em>";
    protected final String TEXT_445 = "</em>' corresponding the given literal." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param literal a literal of the data type." + NL + "\t * @return a new instance value of the data type." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_446 = " create";
    protected final String TEXT_447 = "(String literal);" + NL + "" + NL + "\t/**" + NL + "\t * Returns a literal representation of an instance of data type '<em>";
    protected final String TEXT_448 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param instanceValue an instance value of the data type." + NL + "\t * @return a literal representation of the instance value." + NL + "\t * @generated" + NL + "\t */" + NL + "\tString convert";
    protected final String TEXT_449 = "(";
    protected final String TEXT_450 = " instanceValue);" + NL;
    protected final String TEXT_451 = NL + "\t/**" + NL + "\t * Returns the package supported by this factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the package supported by this factory." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_452 = " get";
    protected final String TEXT_453 = "();" + NL;
    protected final String TEXT_454 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_455 = " get";
    protected final String TEXT_456 = "()" + NL + "\t{" + NL + "\t\treturn (";
    protected final String TEXT_457 = ")getEPackage();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @deprecated" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_458 = NL + "\t@Deprecated";
    protected final String TEXT_459 = NL + "\tpublic static ";
    protected final String TEXT_460 = " getPackage()" + NL + "\t{" + NL + "\t\treturn ";
    protected final String TEXT_461 = ".eINSTANCE;" + NL + "\t}" + NL;
    protected final String TEXT_462 = NL + "} //";
    protected final String TEXT_463 = NL;
    protected final String TEXT_464 = NL;
    protected final String TEXT_465 = NL;

    public FactoryClass() {
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

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_464);
        stringBuffer.append(TEXT_465);
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

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenPackage genPackage = parameter;
        targetPath = genPackage.getGenModel().getModelDirectory();
        packageName = genPackage.getReflectionClassPackageName();
        className = genPackage.getFactoryClassName();

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenPackage genPackage = parameter;
        argument = ((Object[]) new Object[] { new Object[] { genPackage, genPackage.getGenModel().isSuppressInterfaces() ? Boolean.TRUE : Boolean.FALSE, Boolean.TRUE } })[0];

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * Copyright (c) 2002-2010 IBM Corporation and others.
         * This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v2.0
         * which accompanies this distribution, and is available at
         * https://www.eclipse.org/legal/epl-2.0
         *
         * SPDX-License-Identifier: EPL-2.0
         *
         * Contributors:
         *   IBM - Initial API and implementation
         */

        GenPackage genPackage = (GenPackage) ((Object[]) argument)[0];
        GenModel genModel = genPackage.getGenModel(); /* Trick to import java.util.* without warnings */
        Iterator.class.getName();
        boolean isInterface = Boolean.TRUE.equals(((Object[]) argument)[1]);
        boolean isImplementation = Boolean.TRUE.equals(((Object[]) argument)[2]);
        String publicStaticFinalFlag = isImplementation ? "public static final " : "";
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        if (isInterface || genModel.isSuppressInterfaces()) {
            stringBuffer.append(TEXT_2);
            stringBuffer.append(genPackage.getReflectionPackageName());
            stringBuffer.append(TEXT_3);
        } else {
            stringBuffer.append(TEXT_4);
            stringBuffer.append(genPackage.getClassPackageName());
            stringBuffer.append(TEXT_5);
        }
        stringBuffer.append(TEXT_6);
        if (isImplementation) {
            genModel.addPseudoImport("org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container");
            genModel.addPseudoImport("org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container.Dynamic");
            genModel.addImport("org.eclipse.emf.ecore.EClass");
            genModel.addImport("org.eclipse.emf.ecore.EObject");
            if (!genPackage.hasJavaLangConflict() && !genPackage.hasInterfaceImplConflict() && !genPackage.getClassPackageName().equals(genPackage.getInterfacePackageName()))
                genModel.addImport(genPackage.getInterfacePackageName() + ".*");
        }
        genModel.markImportLocation(stringBuffer);
        stringBuffer.append(TEXT_7);
        if (isInterface) {
            stringBuffer.append(TEXT_8);
            if (!genModel.isSuppressEMFMetaData()) {
                stringBuffer.append(TEXT_9);
                stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
            }
            stringBuffer.append(TEXT_10);
        } else {
            stringBuffer.append(TEXT_11);
        }
        if (isImplementation) {
            stringBuffer.append(TEXT_12);
            stringBuffer.append(genPackage.getFactoryClassName());
            stringBuffer.append(TEXT_13);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.EFactoryImpl"));
            if (!genModel.isSuppressInterfaces()) {
                stringBuffer.append(TEXT_14);
                stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
            }
        } else {
            stringBuffer.append(TEXT_15);
            stringBuffer.append(genPackage.getFactoryInterfaceName());
            if (!genModel.isSuppressEMFMetaData()) {
                stringBuffer.append(TEXT_16);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EFactory"));
            }
        }
        stringBuffer.append(TEXT_17);
        if (genModel.hasCopyrightField()) {
            stringBuffer.append(TEXT_18);
            stringBuffer.append(publicStaticFinalFlag);
            stringBuffer.append(genModel.getImportedName("java.lang.String"));
            stringBuffer.append(TEXT_19);
            stringBuffer.append(genModel.getCopyrightFieldLiteral());
            stringBuffer.append(TEXT_20);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_21);
        }
        if (isImplementation && (genModel.isSuppressEMFMetaData() || genModel.isSuppressInterfaces())) {
            stringBuffer.append(TEXT_22);
            stringBuffer.append(publicStaticFinalFlag);
            stringBuffer.append(genPackage.getFactoryClassName());
            stringBuffer.append(TEXT_23);
        }
        if (isInterface && genModel.isSuppressEMFMetaData()) {
            stringBuffer.append(TEXT_24);
            stringBuffer.append(publicStaticFinalFlag);
            stringBuffer.append(genPackage.getFactoryInterfaceName());
            stringBuffer.append(TEXT_25);
            stringBuffer.append(genPackage.getQualifiedFactoryClassName());
            stringBuffer.append(TEXT_26);
        } else if (isInterface && !genModel.isSuppressInterfaces()) {
            stringBuffer.append(TEXT_27);
            stringBuffer.append(publicStaticFinalFlag);
            stringBuffer.append(genPackage.getFactoryInterfaceName());
            stringBuffer.append(TEXT_28);
            stringBuffer.append(genPackage.getQualifiedFactoryClassName());
            stringBuffer.append(TEXT_29);
        }
        if (isImplementation) {
            stringBuffer.append(TEXT_30);
            String factoryType = genModel.isSuppressEMFMetaData() ? genPackage.getFactoryClassName() : genPackage.getImportedFactoryInterfaceName();
            stringBuffer.append(TEXT_31);
            stringBuffer.append(factoryType);
            stringBuffer.append(TEXT_32);
            stringBuffer.append(factoryType);
            stringBuffer.append(TEXT_33);
            stringBuffer.append(genPackage.getFactoryName());
            stringBuffer.append(TEXT_34);
            stringBuffer.append(factoryType);
            stringBuffer.append(TEXT_35);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
            stringBuffer.append(TEXT_36);
            stringBuffer.append(genPackage.getNSURI());
            stringBuffer.append(TEXT_37);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_38);
            stringBuffer.append(genPackage.getFactoryName());
            stringBuffer.append(TEXT_39);
            stringBuffer.append(genPackage.getFactoryName());
            stringBuffer.append(TEXT_40);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
            stringBuffer.append(TEXT_41);
            stringBuffer.append(genPackage.getImportedFactoryClassName());
            stringBuffer.append(TEXT_42);
            stringBuffer.append(genPackage.getFactoryClassName());
            stringBuffer.append(TEXT_43);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_44);
            }
            stringBuffer.append(TEXT_45);
            for (GenClass genClass : genPackage.getGenClasses()) {
                if (!genClass.isAbstract()) {
                    stringBuffer.append(TEXT_46);
                    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
                    stringBuffer.append(TEXT_47);
                    stringBuffer.append(genClass.getClassifierID());
                    stringBuffer.append(TEXT_48);
                    stringBuffer.append(!genClass.isEObjectExtension() ? "(EObject)" : "");
                    stringBuffer.append(TEXT_49);
                    stringBuffer.append(genClass.getName());
                    stringBuffer.append(TEXT_50);
                }
            }
            stringBuffer.append(TEXT_51);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(genModel.getNonNLS(2));
            stringBuffer.append(TEXT_52);
            if (!genPackage.getAllGenDataTypes().isEmpty()) {
                stringBuffer.append(TEXT_53);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_54);
                }
                stringBuffer.append(TEXT_55);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
                stringBuffer.append(TEXT_56);
                for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
                    if (genDataType.isSerializable()) {
                        stringBuffer.append(TEXT_57);
                        stringBuffer.append(genPackage.getImportedPackageInterfaceName());
                        stringBuffer.append(TEXT_58);
                        stringBuffer.append(genDataType.getClassifierID());
                        stringBuffer.append(TEXT_59);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_60);
                    }
                }
                stringBuffer.append(TEXT_61);
                stringBuffer.append(genModel.getNonNLS());
                stringBuffer.append(genModel.getNonNLS(2));
                stringBuffer.append(TEXT_62);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_63);
                }
                stringBuffer.append(TEXT_64);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
                stringBuffer.append(TEXT_65);
                for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
                    if (genDataType.isSerializable()) {
                        stringBuffer.append(TEXT_66);
                        stringBuffer.append(genPackage.getImportedPackageInterfaceName());
                        stringBuffer.append(TEXT_67);
                        stringBuffer.append(genDataType.getClassifierID());
                        stringBuffer.append(TEXT_68);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_69);
                    }
                }
                stringBuffer.append(TEXT_70);
                stringBuffer.append(genModel.getNonNLS());
                stringBuffer.append(genModel.getNonNLS(2));
                stringBuffer.append(TEXT_71);
            }
            for (GenClass genClass : genPackage.getGenClasses()) {
                if (!genClass.isAbstract()) {
                    stringBuffer.append(TEXT_72);
                    stringBuffer.append(genClass.getTypeParameters());
                    stringBuffer.append(genClass.getImportedInterfaceName());
                    stringBuffer.append(genClass.getInterfaceTypeArguments());
                    stringBuffer.append(TEXT_73);
                    stringBuffer.append(genClass.getName());
                    stringBuffer.append(TEXT_74);
                    if (genClass.isDynamic()) {
                        stringBuffer.append(TEXT_75);
                        stringBuffer.append(genClass.getImportedInterfaceName());
                        stringBuffer.append(genClass.getInterfaceTypeArguments());
                        stringBuffer.append(TEXT_76);
                        stringBuffer.append(genClass.getSafeUncapName());
                        stringBuffer.append(TEXT_77);
                        stringBuffer.append(genClass.getCastFromEObject());
                        stringBuffer.append(TEXT_78);
                        stringBuffer.append(genClass.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_79);
                    } else {
                        stringBuffer.append(TEXT_80);
                        stringBuffer.append(genClass.getImportedClassName());
                        stringBuffer.append(genClass.getClassTypeArguments());
                        stringBuffer.append(TEXT_81);
                        stringBuffer.append(genClass.getSafeUncapName());
                        stringBuffer.append(TEXT_82);
                        stringBuffer.append(genClass.getImportedClassName());
                        stringBuffer.append(genClass.getClassTypeArguments());
                        stringBuffer.append(TEXT_83);
                        if (genModel.isSuppressInterfaces() && !genPackage.getReflectionPackageName().equals(genPackage.getInterfacePackageName())) {
                            stringBuffer.append(TEXT_84);
                        }
                        stringBuffer.append(TEXT_85);
                    }
                    stringBuffer.append(TEXT_86);
                    stringBuffer.append(genClass.getSafeUncapName());
                    stringBuffer.append(TEXT_87);
                }
            }
            for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
                if (genDataType.isSerializable()) {
                    if (genPackage.isDataTypeConverters() || genDataType.hasCreatorBody()) {
                        String eDataType = genDataType.getQualifiedClassifierAccessor();
                        stringBuffer.append(TEXT_88);
                        if (genModel.useGenerics() && genDataType.isUncheckedCast() && !genDataType.hasCreatorBody()) {
                            stringBuffer.append(TEXT_89);
                        }
                        stringBuffer.append(TEXT_90);
                        stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
                        stringBuffer.append(TEXT_91);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_92);
                        if (genDataType.hasCreatorBody()) {
                            stringBuffer.append(TEXT_93);
                        } else {
                            stringBuffer.append(TEXT_94);
                        }
                        stringBuffer.append(TEXT_95);
                        if (genDataType.hasCreatorBody()) {
                            stringBuffer.append(TEXT_96);
                            stringBuffer.append(genDataType.getCreatorBody(genModel.getIndentation(stringBuffer)));
                        } else if (genDataType instanceof GenEnum) {
                            stringBuffer.append(TEXT_97);
                            stringBuffer.append(genDataType.getImportedInstanceClassName());
                            stringBuffer.append(TEXT_98);
                            stringBuffer.append(genDataType.getImportedInstanceClassName());
                            stringBuffer.append(TEXT_99);
                            stringBuffer.append(eDataType);
                            stringBuffer.append(TEXT_100);
                            stringBuffer.append(genModel.getNonNLS());
                            stringBuffer.append(genModel.getNonNLS(2));
                            stringBuffer.append(genModel.getNonNLS(3));
                            stringBuffer.append(TEXT_101);
                        } else if (genDataType.getBaseType() != null) {
                            GenDataType genBaseType = genDataType.getBaseType();
                            boolean isPrimitiveConversion = !genDataType.isPrimitiveType() && genBaseType.isPrimitiveType();
                            if (genBaseType.getGenPackage() == genPackage) {
                                if (isPrimitiveConversion && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                    stringBuffer.append(TEXT_102);
                                    stringBuffer.append(genDataType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_103);
                                    stringBuffer.append(genBaseType.getName());
                                    stringBuffer.append(TEXT_104);
                                } else {
                                    stringBuffer.append(TEXT_105);
                                    stringBuffer.append(genBaseType.getName());
                                    stringBuffer.append(TEXT_106);
                                }
                            } else if (genBaseType.getGenPackage().isDataTypeConverters()) {
                                if (isPrimitiveConversion && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                    stringBuffer.append(TEXT_107);
                                    stringBuffer.append(genDataType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_108);
                                    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_109);
                                    stringBuffer.append(genBaseType.getName());
                                    stringBuffer.append(TEXT_110);
                                } else {
                                    stringBuffer.append(TEXT_111);
                                    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_112);
                                    stringBuffer.append(genBaseType.getName());
                                    stringBuffer.append(TEXT_113);
                                }
                            } else {
                                stringBuffer.append(TEXT_114);
                                if (!genDataType.isObjectType()) {
                                    stringBuffer.append(TEXT_115);
                                    stringBuffer.append(genDataType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_116);
                                }
                                stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                stringBuffer.append(TEXT_117);
                                stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_118);
                            }
                        } else if (genDataType.getItemType() != null) {
                            GenDataType genItemType = genDataType.getItemType();
                            stringBuffer.append(TEXT_119);
                            stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
                            stringBuffer.append(TEXT_120);
                            stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
                            if (genModel.useGenerics()) {
                                stringBuffer.append(TEXT_121);
                                stringBuffer.append(genItemType.getObjectType().getImportedParameterizedInstanceClassName());
                                stringBuffer.append(TEXT_122);
                            }
                            stringBuffer.append(TEXT_123);
                            if (genModel.getRuntimeVersion().getValue() < GenRuntimeVersion.EMF26_VALUE) {
                                stringBuffer.append(TEXT_124);
                                stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
                                stringBuffer.append(TEXT_125);
                                stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
                                stringBuffer.append(TEXT_126);
                            } else {
                                stringBuffer.append(TEXT_127);
                            }
                            stringBuffer.append(TEXT_128);
                            if (genModel.getRuntimeVersion().getValue() < GenRuntimeVersion.EMF26_VALUE) {
                                stringBuffer.append(TEXT_129);
                            }
                            if (genItemType.getGenPackage() == genPackage) {
                                if (genPackage.isDataTypeConverters()) {
                                    genItemType = genItemType.getObjectType();
                                    stringBuffer.append(TEXT_130);
                                    stringBuffer.append(genItemType.getName());
                                    stringBuffer.append(TEXT_131);
                                } else {
                                    stringBuffer.append(TEXT_132);
                                    stringBuffer.append(genItemType.getName());
                                    stringBuffer.append(TEXT_133);
                                    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_134);
                                }
                            } else {
                                if (genItemType.getGenPackage().isDataTypeConverters()) {
                                    genItemType = genItemType.getObjectType();
                                    stringBuffer.append(TEXT_135);
                                    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_136);
                                    stringBuffer.append(genItemType.getName());
                                    stringBuffer.append(TEXT_137);
                                } else {
                                    stringBuffer.append(TEXT_138);
                                    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_139);
                                    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_140);
                                }
                            }
                            stringBuffer.append(TEXT_141);
                        } else if (!genDataType.getMemberTypes().isEmpty()) {
                            stringBuffer.append(TEXT_142);
                            stringBuffer.append(genDataType.getStaticValue(null));
                            stringBuffer.append(TEXT_143);
                            stringBuffer.append(genDataType.getImportedInstanceClassName());
                            stringBuffer.append(TEXT_144);
                            stringBuffer.append(genDataType.getStaticValue(null));
                            stringBuffer.append(TEXT_145);
                            for (GenDataType genMemberType : genDataType.getMemberTypes()) {
                                stringBuffer.append(TEXT_146);
                                if (genMemberType.getGenPackage() == genPackage) {
                                    if (genPackage.isDataTypeConverters()) {
                                        if (!genDataType.isPrimitiveType())
                                            genMemberType = genMemberType.getObjectType();
                                        stringBuffer.append(TEXT_147);
                                        stringBuffer.append(genMemberType.getName());
                                        stringBuffer.append(TEXT_148);
                                    } else {
                                        stringBuffer.append(TEXT_149);
                                        stringBuffer.append(genDataType.getObjectInstanceClassName());
                                        stringBuffer.append(TEXT_150);
                                        stringBuffer.append(genMemberType.getName());
                                        stringBuffer.append(TEXT_151);
                                        stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                        stringBuffer.append(TEXT_152);
                                    }
                                } else {
                                    if (genPackage.isDataTypeConverters()) {
                                        if (!genDataType.isPrimitiveType())
                                            genMemberType = genMemberType.getObjectType();
                                        stringBuffer.append(TEXT_153);
                                        stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                        stringBuffer.append(TEXT_154);
                                        stringBuffer.append(genMemberType.getName());
                                        stringBuffer.append(TEXT_155);
                                    } else {
                                        stringBuffer.append(TEXT_156);
                                        stringBuffer.append(genDataType.getObjectInstanceClassName());
                                        stringBuffer.append(TEXT_157);
                                        stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                        stringBuffer.append(TEXT_158);
                                        stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                        stringBuffer.append(TEXT_159);
                                    }
                                }
                                stringBuffer.append(TEXT_160);
                                if (!genDataType.isPrimitiveType()) {
                                    stringBuffer.append(TEXT_161);
                                }
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician"));
                                stringBuffer.append(TEXT_162);
                                stringBuffer.append(eDataType);
                                stringBuffer.append(TEXT_163);
                                if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                    stringBuffer.append(TEXT_164);
                                    stringBuffer.append(genDataType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_165);
                                } else {
                                    stringBuffer.append(TEXT_166);
                                }
                                stringBuffer.append(TEXT_167);
                            }
                            stringBuffer.append(TEXT_168);
                            if (!genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_169);
                            }
                            stringBuffer.append(TEXT_170);
                        } else if (genModel.useGenerics() && (genDataType.isArrayType() || !genDataType.getEcoreDataType().getETypeParameters().isEmpty() || genDataType.getEcoreDataType().getInstanceTypeName().contains("<"))) {
                            stringBuffer.append(TEXT_171);
                            stringBuffer.append(genDataType.getImportedParameterizedObjectInstanceClassName());
                            stringBuffer.append(TEXT_172);
                        } else if (genDataType.isArrayType()) {
                            stringBuffer.append(TEXT_173);
                            stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
                            stringBuffer.append(TEXT_174);
                        } else if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                            stringBuffer.append(TEXT_175);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_176);
                            stringBuffer.append(eDataType);
                            stringBuffer.append(TEXT_177);
                            stringBuffer.append(genDataType.getPrimitiveValueFunction());
                            stringBuffer.append(TEXT_178);
                        } else {
                            stringBuffer.append(TEXT_179);
                            if (!genDataType.isObjectType()) {
                                stringBuffer.append(TEXT_180);
                                stringBuffer.append(genDataType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_181);
                            }
                            stringBuffer.append(TEXT_182);
                            stringBuffer.append(eDataType);
                            stringBuffer.append(TEXT_183);
                        }
                        stringBuffer.append(TEXT_184);
                    }
                    stringBuffer.append(TEXT_185);
                    if (!genPackage.isDataTypeConverters() && genModel.useGenerics() && genDataType.isUncheckedCast() && !genDataType.hasCreatorBody()) {
                        stringBuffer.append(TEXT_186);
                    }
                    stringBuffer.append(TEXT_187);
                    stringBuffer.append(genDataType.getImportedParameterizedObjectInstanceClassName());
                    stringBuffer.append(TEXT_188);
                    stringBuffer.append(genDataType.getName());
                    stringBuffer.append(TEXT_189);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
                    stringBuffer.append(TEXT_190);
                    if (genDataType instanceof GenEnum) {
                        if (genPackage.isDataTypeConverters() || genDataType.hasCreatorBody()) {
                            stringBuffer.append(TEXT_191);
                            stringBuffer.append(genDataType.getName());
                            stringBuffer.append(TEXT_192);
                        } else {
                            stringBuffer.append(TEXT_193);
                            stringBuffer.append(((GenEnum) genDataType).getImportedInstanceClassName());
                            stringBuffer.append(TEXT_194);
                            stringBuffer.append(((GenEnum) genDataType).getImportedInstanceClassName());
                            stringBuffer.append(TEXT_195);
                            stringBuffer.append(genModel.getNonNLS());
                            stringBuffer.append(genModel.getNonNLS(2));
                            stringBuffer.append(genModel.getNonNLS(3));
                            stringBuffer.append(TEXT_196);
                        }
                    } else if (genDataType.getBaseType() != null) {
                        GenDataType genBaseType = genDataType.getBaseType();
                        if (genBaseType.getGenPackage() == genPackage) {
                            stringBuffer.append(TEXT_197);
                            if (!genDataType.getObjectInstanceClassName().equals(genBaseType.getObjectInstanceClassName())) {
                                stringBuffer.append(TEXT_198);
                                stringBuffer.append(genDataType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_199);
                            }
                            stringBuffer.append(TEXT_200);
                            stringBuffer.append(genBaseType.getName());
                            stringBuffer.append(TEXT_201);
                            stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_202);
                        } else {
                            stringBuffer.append(TEXT_203);
                            if (!genDataType.isObjectType()) {
                                stringBuffer.append(TEXT_204);
                                stringBuffer.append(genDataType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_205);
                            }
                            stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                            stringBuffer.append(TEXT_206);
                            stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_207);
                        }
                    } else if (genDataType.getItemType() != null) {
                        GenDataType genItemType = genDataType.getItemType();
                        if (genPackage.isDataTypeConverters()) {
                            stringBuffer.append(TEXT_208);
                            stringBuffer.append(genDataType.getName());
                            stringBuffer.append(TEXT_209);
                        } else {
                            stringBuffer.append(TEXT_210);
                            stringBuffer.append(genDataType.getImportedParameterizedObjectInstanceClassName());
                            stringBuffer.append(TEXT_211);
                            stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
                            if (genModel.useGenerics()) {
                                stringBuffer.append(TEXT_212);
                                stringBuffer.append(genItemType.getObjectType().getImportedParameterizedInstanceClassName());
                                stringBuffer.append(TEXT_213);
                            }
                            stringBuffer.append(TEXT_214);
                            if (genModel.getRuntimeVersion().getValue() < GenRuntimeVersion.EMF26_VALUE) {
                                stringBuffer.append(TEXT_215);
                                stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
                                stringBuffer.append(TEXT_216);
                                stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
                                stringBuffer.append(TEXT_217);
                            } else {
                                stringBuffer.append(TEXT_218);
                            }
                            stringBuffer.append(TEXT_219);
                            if (genModel.getRuntimeVersion().getValue() < GenRuntimeVersion.EMF26_VALUE) {
                                stringBuffer.append(TEXT_220);
                            }
                            if (genItemType.getGenPackage() == genPackage) {
                                stringBuffer.append(TEXT_221);
                                stringBuffer.append(genItemType.getName());
                                stringBuffer.append(TEXT_222);
                                stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_223);
                            } else {
                                stringBuffer.append(TEXT_224);
                                if (!genItemType.isObjectType()) {
                                    stringBuffer.append(TEXT_225);
                                    stringBuffer.append(genItemType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_226);
                                }
                                stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                stringBuffer.append(TEXT_227);
                                stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_228);
                            }
                            stringBuffer.append(TEXT_229);
                        }
                    } else if (!genDataType.getMemberTypes().isEmpty()) {
                        if (genPackage.isDataTypeConverters()) {
                            if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                stringBuffer.append(TEXT_230);
                                stringBuffer.append(genDataType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_231);
                                stringBuffer.append(genDataType.getName());
                                stringBuffer.append(TEXT_232);
                            } else {
                                stringBuffer.append(TEXT_233);
                                stringBuffer.append(genDataType.getName());
                                stringBuffer.append(TEXT_234);
                            }
                        } else {
                            stringBuffer.append(TEXT_235);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_236);
                            for (GenDataType genMemberType : genDataType.getMemberTypes()) {
                                stringBuffer.append(TEXT_237);
                                if (genMemberType.getGenPackage() == genPackage) {
                                    stringBuffer.append(TEXT_238);
                                    if (!genDataType.isObjectType() && !genDataType.getObjectInstanceClassName().equals(genMemberType.getObjectInstanceClassName())) {
                                        stringBuffer.append(TEXT_239);
                                        stringBuffer.append(genDataType.getObjectInstanceClassName());
                                        stringBuffer.append(TEXT_240);
                                    }
                                    stringBuffer.append(TEXT_241);
                                    stringBuffer.append(genMemberType.getName());
                                    stringBuffer.append(TEXT_242);
                                    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_243);
                                } else {
                                    stringBuffer.append(TEXT_244);
                                    if (!genDataType.isObjectType()) {
                                        stringBuffer.append(TEXT_245);
                                        stringBuffer.append(genDataType.getObjectInstanceClassName());
                                        stringBuffer.append(TEXT_246);
                                    }
                                    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_247);
                                    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_248);
                                }
                                stringBuffer.append(TEXT_249);
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician"));
                                stringBuffer.append(TEXT_250);
                            }
                            stringBuffer.append(TEXT_251);
                        }
                    } else if (genPackage.isDataTypeConverters() || genDataType.hasCreatorBody()) {
                        stringBuffer.append(TEXT_252);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_253);
                    } else if (genModel.useGenerics() && (genDataType.isArrayType() || !genDataType.getEcoreDataType().getETypeParameters().isEmpty() || genDataType.getEcoreDataType().getInstanceTypeName().contains("<"))) {
                        stringBuffer.append(TEXT_254);
                        if (!genDataType.isObjectType()) {
                            stringBuffer.append(TEXT_255);
                            stringBuffer.append(genDataType.getImportedParameterizedObjectInstanceClassName());
                            stringBuffer.append(TEXT_256);
                        }
                        stringBuffer.append(TEXT_257);
                    } else if (genDataType.isArrayType()) {
                        stringBuffer.append(TEXT_258);
                        stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
                        stringBuffer.append(TEXT_259);
                    } else {
                        stringBuffer.append(TEXT_260);
                        if (!genDataType.isObjectType()) {
                            stringBuffer.append(TEXT_261);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_262);
                        }
                        stringBuffer.append(TEXT_263);
                    }
                    stringBuffer.append(TEXT_264);
                    if (genPackage.isDataTypeConverters() || genDataType.hasConverterBody()) {
                        String eDataType = genDataType.getQualifiedClassifierAccessor();
                        stringBuffer.append(TEXT_265);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_266);
                        stringBuffer.append(genDataType.getImportedBoundedWildcardInstanceClassName());
                        stringBuffer.append(TEXT_267);
                        if (genDataType.hasConverterBody()) {
                            stringBuffer.append(TEXT_268);
                        } else {
                            stringBuffer.append(TEXT_269);
                        }
                        stringBuffer.append(TEXT_270);
                        if (genDataType.hasConverterBody()) {
                            stringBuffer.append(TEXT_271);
                            stringBuffer.append(genDataType.getConverterBody(genModel.getIndentation(stringBuffer)));
                        } else if (genDataType instanceof GenEnum) {
                            stringBuffer.append(TEXT_272);
                        } else if (genDataType.getBaseType() != null) {
                            GenDataType genBaseType = genDataType.getBaseType();
                            boolean isPrimitiveConversion = !genDataType.isPrimitiveType() && genBaseType.isPrimitiveType();
                            if (genBaseType.getGenPackage() == genPackage) {
                                if (isPrimitiveConversion) {
                                    stringBuffer.append(TEXT_273);
                                    stringBuffer.append(genBaseType.getName());
                                    stringBuffer.append(TEXT_274);
                                    if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                        stringBuffer.append(TEXT_275);
                                        stringBuffer.append(genBaseType.getPrimitiveValueFunction());
                                        stringBuffer.append(TEXT_276);
                                    }
                                    stringBuffer.append(TEXT_277);
                                } else {
                                    stringBuffer.append(TEXT_278);
                                    stringBuffer.append(genBaseType.getName());
                                    stringBuffer.append(TEXT_279);
                                }
                            } else if (genBaseType.getGenPackage().isDataTypeConverters()) {
                                stringBuffer.append(TEXT_280);
                                stringBuffer.append(genBaseType.getGenPackage().getQualifiedFactoryInstanceAccessor());
                                stringBuffer.append(TEXT_281);
                                stringBuffer.append(genBaseType.getName());
                                stringBuffer.append(TEXT_282);
                            } else {
                                stringBuffer.append(TEXT_283);
                                stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                stringBuffer.append(TEXT_284);
                                stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_285);
                            }
                        } else if (genDataType.getItemType() != null) {
                            GenDataType genItemType = genDataType.getItemType();
                            stringBuffer.append(TEXT_286);
                            stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
                            stringBuffer.append(TEXT_287);
                            stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
                            stringBuffer.append(TEXT_288);
                            String item;
                            if (!genModel.useGenerics()) {
                                item = "i.next()";
                                stringBuffer.append(TEXT_289);
                                stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
                                stringBuffer.append(TEXT_290);
                            } else {
                                item = "item";
                                stringBuffer.append(TEXT_291);
                                stringBuffer.append(genModel.getImportedName("java.lang.Object"));
                                stringBuffer.append(TEXT_292);
                            }
                            stringBuffer.append(TEXT_293);
                            if (genItemType.getGenPackage() == genPackage) {
                                if (genPackage.isDataTypeConverters()) {
                                    genItemType = genItemType.getObjectType();
                                    stringBuffer.append(TEXT_294);
                                    stringBuffer.append(genItemType.getName());
                                    stringBuffer.append(TEXT_295);
                                    stringBuffer.append(genItemType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_296);
                                    stringBuffer.append(item);
                                    stringBuffer.append(TEXT_297);
                                } else {
                                    stringBuffer.append(TEXT_298);
                                    stringBuffer.append(genItemType.getName());
                                    stringBuffer.append(TEXT_299);
                                    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_300);
                                    stringBuffer.append(item);
                                    stringBuffer.append(TEXT_301);
                                }
                            } else {
                                if (genItemType.getGenPackage().isDataTypeConverters()) {
                                    genItemType = genItemType.getObjectType();
                                    stringBuffer.append(TEXT_302);
                                    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_303);
                                    stringBuffer.append(genItemType.getName());
                                    stringBuffer.append(TEXT_304);
                                    stringBuffer.append(genItemType.getObjectInstanceClassName());
                                    stringBuffer.append(TEXT_305);
                                    stringBuffer.append(item);
                                    stringBuffer.append(TEXT_306);
                                } else {
                                    stringBuffer.append(TEXT_307);
                                    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_308);
                                    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_309);
                                    stringBuffer.append(item);
                                    stringBuffer.append(TEXT_310);
                                }
                            }
                            stringBuffer.append(TEXT_311);
                        } else if (!genDataType.getMemberTypes().isEmpty()) {
                            if (!genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_312);
                                for (GenDataType genMemberType : genDataType.getMemberTypes()) {
                                    stringBuffer.append(TEXT_313);
                                    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_314);
                                    if (genMemberType.getGenPackage() == genPackage) {
                                        if (genPackage.isDataTypeConverters()) {
                                            if (genMemberType.getQualifiedInstanceClassName().equals(genDataType.getQualifiedInstanceClassName())) {
                                                stringBuffer.append(TEXT_315);
                                                stringBuffer.append(genMemberType.getName());
                                                stringBuffer.append(TEXT_316);
                                            } else if (genMemberType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                                stringBuffer.append(TEXT_317);
                                                stringBuffer.append(genMemberType.getName());
                                                stringBuffer.append(TEXT_318);
                                                stringBuffer.append(genMemberType.getObjectType().getImportedInstanceClassName());
                                                stringBuffer.append(TEXT_319);
                                                stringBuffer.append(genMemberType.getPrimitiveValueFunction());
                                                stringBuffer.append(TEXT_320);
                                            } else {
                                                stringBuffer.append(TEXT_321);
                                                stringBuffer.append(genMemberType.getName());
                                                stringBuffer.append(TEXT_322);
                                                stringBuffer.append(genMemberType.getObjectType().getImportedBoundedWildcardInstanceClassName());
                                                stringBuffer.append(TEXT_323);
                                            }
                                        } else {
                                            stringBuffer.append(TEXT_324);
                                            stringBuffer.append(genMemberType.getName());
                                            stringBuffer.append(TEXT_325);
                                            stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                            stringBuffer.append(TEXT_326);
                                        }
                                    } else {
                                        if (genMemberType.getGenPackage().isDataTypeConverters()) {
                                            genMemberType = genMemberType.getObjectType();
                                            stringBuffer.append(TEXT_327);
                                            stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                            stringBuffer.append(TEXT_328);
                                            stringBuffer.append(genMemberType.getName());
                                            stringBuffer.append(TEXT_329);
                                            stringBuffer.append(genMemberType.getObjectInstanceClassName());
                                            stringBuffer.append(TEXT_330);
                                        } else {
                                            stringBuffer.append(TEXT_331);
                                            stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                            stringBuffer.append(TEXT_332);
                                            stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                            stringBuffer.append(TEXT_333);
                                        }
                                    }
                                    stringBuffer.append(TEXT_334);
                                }
                            } else {
                                for (GenDataType genMemberType : genDataType.getMemberTypes()) {
                                    stringBuffer.append(TEXT_335);
                                    if (genMemberType.getGenPackage() == genPackage) {
                                        if (genPackage.isDataTypeConverters()) {
                                            stringBuffer.append(TEXT_336);
                                            stringBuffer.append(genMemberType.getName());
                                            stringBuffer.append(TEXT_337);
                                        } else {
                                            stringBuffer.append(TEXT_338);
                                            stringBuffer.append(genMemberType.getName());
                                            stringBuffer.append(TEXT_339);
                                            stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                            stringBuffer.append(TEXT_340);
                                            if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                                stringBuffer.append(TEXT_341);
                                                stringBuffer.append(genMemberType.getObjectInstanceClassName());
                                                stringBuffer.append(TEXT_342);
                                            } else {
                                                stringBuffer.append(TEXT_343);
                                            }
                                            stringBuffer.append(TEXT_344);
                                        }
                                    } else {
                                        if (genMemberType.getGenPackage().isDataTypeConverters()) {
                                            stringBuffer.append(TEXT_345);
                                            stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                            stringBuffer.append(TEXT_346);
                                            stringBuffer.append(genMemberType.getName());
                                            stringBuffer.append(TEXT_347);
                                        } else {
                                            stringBuffer.append(TEXT_348);
                                            stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                            stringBuffer.append(TEXT_349);
                                            stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                            stringBuffer.append(TEXT_350);
                                            if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                                stringBuffer.append(TEXT_351);
                                                stringBuffer.append(genMemberType.getObjectInstanceClassName());
                                                stringBuffer.append(TEXT_352);
                                            } else {
                                                stringBuffer.append(TEXT_353);
                                            }
                                            stringBuffer.append(TEXT_354);
                                        }
                                    }
                                    stringBuffer.append(TEXT_355);
                                }
                            }
                            stringBuffer.append(TEXT_356);
                            stringBuffer.append(eDataType);
                            stringBuffer.append(TEXT_357);
                        } else if (genModel.useGenerics() && (genDataType.isArrayType() || !genDataType.getEcoreDataType().getETypeParameters().isEmpty() || genDataType.getEcoreDataType().getInstanceTypeName().contains("<"))) {
                            stringBuffer.append(TEXT_358);
                        } else if (genDataType.isArrayType()) {
                            stringBuffer.append(TEXT_359);
                            stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
                            stringBuffer.append(TEXT_360);
                        } else if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                            stringBuffer.append(TEXT_361);
                            stringBuffer.append(eDataType);
                            stringBuffer.append(TEXT_362);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_363);
                        } else {
                            stringBuffer.append(TEXT_364);
                            stringBuffer.append(eDataType);
                            stringBuffer.append(TEXT_365);
                        }
                        stringBuffer.append(TEXT_366);
                    }
                    stringBuffer.append(TEXT_367);
                    if (genModel.useGenerics() && (genDataType.getItemType() != null || genDataType.isUncheckedCast()) && (genPackage.isDataTypeConverters() || genDataType.hasCreatorBody())) {
                        stringBuffer.append(TEXT_368);
                    }
                    stringBuffer.append(TEXT_369);
                    stringBuffer.append(genDataType.getName());
                    stringBuffer.append(TEXT_370);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
                    stringBuffer.append(TEXT_371);
                    if (genDataType instanceof GenEnum) {
                        if (genPackage.isDataTypeConverters() || genDataType.hasConverterBody()) {
                            stringBuffer.append(TEXT_372);
                            stringBuffer.append(genDataType.getName());
                            stringBuffer.append(TEXT_373);
                            stringBuffer.append(genDataType.getImportedInstanceClassName());
                            stringBuffer.append(TEXT_374);
                        } else {
                            stringBuffer.append(TEXT_375);
                        }
                    } else if (genDataType.getBaseType() != null) {
                        GenDataType genBaseType = genDataType.getBaseType();
                        if (genBaseType.getGenPackage() == genPackage) {
                            stringBuffer.append(TEXT_376);
                            stringBuffer.append(genBaseType.getName());
                            stringBuffer.append(TEXT_377);
                            stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_378);
                        } else {
                            stringBuffer.append(TEXT_379);
                            stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                            stringBuffer.append(TEXT_380);
                            stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_381);
                        }
                    } else if (genDataType.getItemType() != null) {
                        GenDataType genItemType = genDataType.getItemType();
                        if (genPackage.isDataTypeConverters() || genDataType.hasCreatorBody()) {
                            stringBuffer.append(TEXT_382);
                            stringBuffer.append(genDataType.getName());
                            stringBuffer.append(TEXT_383);
                            stringBuffer.append(genDataType.getImportedBoundedWildcardInstanceClassName());
                            stringBuffer.append(TEXT_384);
                        } else {
                            final String singleWildcard = genModel.useGenerics() ? "<?>" : "";
                            stringBuffer.append(TEXT_385);
                            stringBuffer.append(genModel.getImportedName("java.util.List"));
                            stringBuffer.append(singleWildcard);
                            stringBuffer.append(TEXT_386);
                            stringBuffer.append(genModel.getImportedName("java.util.List"));
                            stringBuffer.append(singleWildcard);
                            stringBuffer.append(TEXT_387);
                            stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
                            stringBuffer.append(TEXT_388);
                            stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
                            stringBuffer.append(TEXT_389);
                            String item;
                            if (!genModel.useGenerics()) {
                                item = "i.next()";
                                stringBuffer.append(TEXT_390);
                                stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
                                stringBuffer.append(TEXT_391);
                            } else {
                                item = "item";
                                stringBuffer.append(TEXT_392);
                                stringBuffer.append(genModel.getImportedName("java.lang.Object"));
                                stringBuffer.append(TEXT_393);
                            }
                            stringBuffer.append(TEXT_394);
                            if (genItemType.getGenPackage() == genPackage) {
                                stringBuffer.append(TEXT_395);
                                stringBuffer.append(genItemType.getName());
                                stringBuffer.append(TEXT_396);
                                stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_397);
                                stringBuffer.append(item);
                                stringBuffer.append(TEXT_398);
                            } else {
                                stringBuffer.append(TEXT_399);
                                stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                stringBuffer.append(TEXT_400);
                                stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_401);
                                stringBuffer.append(item);
                                stringBuffer.append(TEXT_402);
                            }
                            stringBuffer.append(TEXT_403);
                        }
                    } else if (!genDataType.getMemberTypes().isEmpty()) {
                        if (genPackage.isDataTypeConverters() || genDataType.hasConverterBody()) {
                            if (genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_404);
                                stringBuffer.append(genDataType.getName());
                                stringBuffer.append(TEXT_405);
                                stringBuffer.append(genDataType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_406);
                                if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                    stringBuffer.append(TEXT_407);
                                    stringBuffer.append(genDataType.getPrimitiveValueFunction());
                                    stringBuffer.append(TEXT_408);
                                }
                                stringBuffer.append(TEXT_409);
                            } else {
                                stringBuffer.append(TEXT_410);
                                stringBuffer.append(genDataType.getName());
                                stringBuffer.append(TEXT_411);
                            }
                        } else {
                            stringBuffer.append(TEXT_412);
                            for (GenDataType genMemberType : genDataType.getMemberTypes()) {
                                stringBuffer.append(TEXT_413);
                                stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_414);
                                if (genMemberType.getGenPackage() == genPackage) {
                                    stringBuffer.append(TEXT_415);
                                    stringBuffer.append(genMemberType.getName());
                                    stringBuffer.append(TEXT_416);
                                    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_417);
                                } else {
                                    stringBuffer.append(TEXT_418);
                                    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
                                    stringBuffer.append(TEXT_419);
                                    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
                                    stringBuffer.append(TEXT_420);
                                }
                                stringBuffer.append(TEXT_421);
                            }
                            stringBuffer.append(TEXT_422);
                        }
                    } else if (genPackage.isDataTypeConverters() || genDataType.hasConverterBody()) {
                        if (genDataType.isPrimitiveType()) {
                            stringBuffer.append(TEXT_423);
                            stringBuffer.append(genDataType.getName());
                            stringBuffer.append(TEXT_424);
                            if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                stringBuffer.append(TEXT_425);
                            }
                            stringBuffer.append(TEXT_426);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_427);
                            if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
                                stringBuffer.append(TEXT_428);
                                stringBuffer.append(genDataType.getPrimitiveValueFunction());
                                stringBuffer.append(TEXT_429);
                            }
                            stringBuffer.append(TEXT_430);
                        } else {
                            stringBuffer.append(TEXT_431);
                            stringBuffer.append(genDataType.getName());
                            stringBuffer.append(TEXT_432);
                            stringBuffer.append(genDataType.getImportedBoundedWildcardInstanceClassName());
                            stringBuffer.append(TEXT_433);
                        }
                    } else if (genModel.useGenerics() && (genDataType.isArrayType() || !genDataType.getEcoreDataType().getETypeParameters().isEmpty() || genDataType.getEcoreDataType().getInstanceTypeName().contains("<"))) {
                        stringBuffer.append(TEXT_434);
                    } else if (genDataType.isArrayType()) {
                        stringBuffer.append(TEXT_435);
                        stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
                        stringBuffer.append(TEXT_436);
                    } else {
                        stringBuffer.append(TEXT_437);
                    }
                    stringBuffer.append(TEXT_438);
                }
            }
        } else {
            for (GenClass genClass : genPackage.getGenClasses()) {
                if (genClass.hasFactoryInterfaceCreateMethod()) {
                    stringBuffer.append(TEXT_439);
                    stringBuffer.append(genClass.getFormattedName());
                    stringBuffer.append(TEXT_440);
                    stringBuffer.append(genClass.getFormattedName());
                    stringBuffer.append(TEXT_441);
                    stringBuffer.append(genClass.getTypeParameters());
                    stringBuffer.append(genClass.getImportedInterfaceName());
                    stringBuffer.append(genClass.getInterfaceTypeArguments());
                    stringBuffer.append(TEXT_442);
                    stringBuffer.append(genClass.getName());
                    stringBuffer.append(TEXT_443);
                }
            }
            if (genPackage.isDataTypeConverters()) {
                for (GenDataType genDataType : genPackage.getAllGenDataTypes()) {
                    if (genDataType.isSerializable()) {
                        stringBuffer.append(TEXT_444);
                        stringBuffer.append(genDataType.getFormattedName());
                        stringBuffer.append(TEXT_445);
                        stringBuffer.append(genDataType.getImportedParameterizedInstanceClassName());
                        stringBuffer.append(TEXT_446);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_447);
                        stringBuffer.append(genDataType.getFormattedName());
                        stringBuffer.append(TEXT_448);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_449);
                        stringBuffer.append(genDataType.getImportedBoundedWildcardInstanceClassName());
                        stringBuffer.append(TEXT_450);
                    }
                }
            }
        }
        if (!isImplementation && !genModel.isSuppressEMFMetaData()) {
            stringBuffer.append(TEXT_451);
            stringBuffer.append(genPackage.getPackageInterfaceName());
            stringBuffer.append(TEXT_452);
            stringBuffer.append(genPackage.getBasicPackageName());
            stringBuffer.append(TEXT_453);
        } else if (isImplementation) {
            stringBuffer.append(TEXT_454);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_455);
            stringBuffer.append(genPackage.getBasicPackageName());
            stringBuffer.append(TEXT_456);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_457);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_458);
            }
            stringBuffer.append(TEXT_459);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_460);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_461);
        }
        stringBuffer.append(TEXT_462);
        stringBuffer.append(isInterface ? genPackage.getFactoryInterfaceName() : genPackage.getFactoryClassName());
        genModel.emitSortedImports();
        stringBuffer.append(TEXT_463);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        GenPackage genPackage = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
        canGenerate = canGenerate && (genPackage.hasClassifiers());
        return canGenerate;
    }
}