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

public class ValidatorClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized ValidatorClass create(String lineSeparator) {
		nl = lineSeparator;
		ValidatorClass result = new ValidatorClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Validator</b> for the model." + NL + " * <!-- end-user-doc -->" + NL + " * @see ";
	protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_6 = " extends ";
	protected final String TEXT_7 = NL + "{";
	protected final String TEXT_8 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_9 = " copyright = ";
	protected final String TEXT_10 = ";";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL + "\t/**" + NL + "\t * The cached model package" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_13 = " INSTANCE = new ";
	protected final String TEXT_14 = "();" + NL + "" + NL + "\t/**" + NL + "\t * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see org.eclipse.emf.common.util.Diagnostic#getSource()" + NL + "\t * @see org.eclipse.emf.common.util.Diagnostic#getCode()" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String DIAGNOSTIC_SOURCE = \"";
	protected final String TEXT_15 = "\";";
	protected final String TEXT_16 = NL;
	protected final String TEXT_17 = NL + "\t/**" + NL + "\t * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint '";
	protected final String TEXT_18 = "' of '";
	protected final String TEXT_19 = "'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int ";
	protected final String TEXT_20 = " = ";
	protected final String TEXT_21 = ";" + NL;
	protected final String TEXT_22 = NL + "\t/**" + NL + "\t * A constant with a fixed name that can be used as the base value for additional hand written constants." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final int GENERATED_DIAGNOSTIC_CODE_COUNT = ";
	protected final String TEXT_23 = ";" + NL + "" + NL + "\t/**" + NL + "\t * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;" + NL;
	protected final String TEXT_24 = NL + "\t/**" + NL + "\t * The cached base package validator." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_25 = " ";
	protected final String TEXT_26 = "Validator;" + NL;
	protected final String TEXT_27 = NL + "\t/**" + NL + "\t * Delegates evaluation of the given invariant expression against the object in the given context." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean validate(";
	protected final String TEXT_28 = " eClass, ";
	protected final String TEXT_29 = " eObject, DiagnosticChain diagnostics, ";
	protected final String TEXT_30 = " context, ";
	protected final String TEXT_31 = " validationDelegate, ";
	protected final String TEXT_32 = " invariant, ";
	protected final String TEXT_33 = " expression, int severity, ";
	protected final String TEXT_34 = " source, int code)" + NL + "\t{" + NL + "\t\treturn ";
	protected final String TEXT_35 = ".validate(eClass, eObject, diagnostics, context, validationDelegate, invariant, expression, severity, source, code);" + NL + "\t}" + NL;
	protected final String TEXT_36 = NL + "\t/**" + NL + "\t * Creates an instance of the switch." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_37 = "()" + NL + "\t{" + NL + "\t\tsuper();";
	protected final String TEXT_38 = NL + "\t\t";
	protected final String TEXT_39 = "Validator = ";
	protected final String TEXT_40 = ".INSTANCE;";
	protected final String TEXT_41 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the package of this validator switch." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_42 = NL + "\t@Override";
	protected final String TEXT_43 = NL + "\tprotected EPackage getEPackage()" + NL + "\t{" + NL + "\t  return ";
	protected final String TEXT_44 = ".eINSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Calls <code>validateXXX</code> for the corresponding classifier of the model." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_45 = NL + "\t@Override";
	protected final String TEXT_46 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_47 = NL + "\tprotected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, ";
	protected final String TEXT_48 = " context)" + NL + "\t{" + NL + "\t\tswitch (classifierID)" + NL + "\t\t{";
	protected final String TEXT_49 = NL + "\t\t\tcase ";
	protected final String TEXT_50 = ".";
	protected final String TEXT_51 = ":";
	protected final String TEXT_52 = NL + "\t\t\t\treturn validate";
	protected final String TEXT_53 = "(((";
	protected final String TEXT_54 = ")value).";
	protected final String TEXT_55 = "(), diagnostics, context);";
	protected final String TEXT_56 = NL + "\t\t\t\treturn validate";
	protected final String TEXT_57 = "((";
	protected final String TEXT_58 = ")value, diagnostics, context);";
	protected final String TEXT_59 = NL + "\t\t\t\treturn validate";
	protected final String TEXT_60 = "(value, diagnostics, context);";
	protected final String TEXT_61 = NL + "\t\t\t\treturn validate";
	protected final String TEXT_62 = "((";
	protected final String TEXT_63 = ")value, diagnostics, context);";
	protected final String TEXT_64 = NL + "\t\t\t\treturn validate";
	protected final String TEXT_65 = "((";
	protected final String TEXT_66 = ")value, diagnostics, context);";
	protected final String TEXT_67 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn true;" + NL + "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_68 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean validate";
	protected final String TEXT_69 = "(";
	protected final String TEXT_70 = " ";
	protected final String TEXT_71 = ", DiagnosticChain ";
	protected final String TEXT_72 = ", ";
	protected final String TEXT_73 = " ";
	protected final String TEXT_74 = ")" + NL + "\t{";
	protected final String TEXT_75 = NL + "\t\treturn true;";
	protected final String TEXT_76 = NL + "\t\treturn validate_EveryDefaultConstraint(";
	protected final String TEXT_77 = "(";
	protected final String TEXT_78 = ")";
	protected final String TEXT_79 = ", ";
	protected final String TEXT_80 = ", ";
	protected final String TEXT_81 = ");";
	protected final String TEXT_82 = NL + "\t\tif (!validate_NoCircularContainment(";
	protected final String TEXT_83 = "(";
	protected final String TEXT_84 = ")";
	protected final String TEXT_85 = ", ";
	protected final String TEXT_86 = ", ";
	protected final String TEXT_87 = ")) return false;";
	protected final String TEXT_88 = NL + "\t\tboolean ";
	protected final String TEXT_89 = " = ";
	protected final String TEXT_90 = "validate";
	protected final String TEXT_91 = "_";
	protected final String TEXT_92 = "(";
	protected final String TEXT_93 = ", ";
	protected final String TEXT_94 = ", ";
	protected final String TEXT_95 = ");";
	protected final String TEXT_96 = NL + "\t\tif (";
	protected final String TEXT_97 = " || ";
	protected final String TEXT_98 = " != null) result &= ";
	protected final String TEXT_99 = "validate";
	protected final String TEXT_100 = "_";
	protected final String TEXT_101 = "(";
	protected final String TEXT_102 = ", ";
	protected final String TEXT_103 = ", ";
	protected final String TEXT_104 = ");";
	protected final String TEXT_105 = NL + "\t\treturn ";
	protected final String TEXT_106 = ";";
	protected final String TEXT_107 = NL + "\t}" + NL;
	protected final String TEXT_108 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
	protected final String TEXT_109 = "_";
	protected final String TEXT_110 = NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_111 = " ";
	protected final String TEXT_112 = "__VALUE = ";
	protected final String TEXT_113 = ";" + NL;
	protected final String TEXT_114 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
	protected final String TEXT_115 = "_";
	protected final String TEXT_116 = NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_117 = " ";
	protected final String TEXT_118 = "__VALUE = ";
	protected final String TEXT_119 = ";" + NL;
	protected final String TEXT_120 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
	protected final String TEXT_121 = "_";
	protected final String TEXT_122 = NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_123 = " ";
	protected final String TEXT_124 = "__UPPER_BOUND = ";
	protected final String TEXT_125 = ";" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
	protected final String TEXT_126 = "_";
	protected final String TEXT_127 = NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_128 = " ";
	protected final String TEXT_129 = "__LOWER_BOUND = ";
	protected final String TEXT_130 = ";" + NL;
	protected final String TEXT_131 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
	protected final String TEXT_132 = "_";
	protected final String TEXT_133 = NL + "\t */" + NL + "\tpublic static final  PatternMatcher [][] ";
	protected final String TEXT_134 = "__VALUES =" + NL + "\t\tnew PatternMatcher [][]" + NL + "\t\t{";
	protected final String TEXT_135 = NL + "\t\t\tnew PatternMatcher []" + NL + "\t\t\t{";
	protected final String TEXT_136 = NL + "\t\t\t\t";
	protected final String TEXT_137 = ".createPatternMatcher(";
	protected final String TEXT_138 = ")";
	protected final String TEXT_139 = NL + "\t\t\t}";
	protected final String TEXT_140 = NL + "\t\t};" + NL;
	protected final String TEXT_141 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
	protected final String TEXT_142 = "_";
	protected final String TEXT_143 = NL + "\t */";
	protected final String TEXT_144 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_145 = NL + "\tpublic static final ";
	protected final String TEXT_146 = " ";
	protected final String TEXT_147 = "__VALUES =" + NL + "\t\twrapEnumerationValues" + NL + "\t\t\t(new Object[]" + NL + "\t\t\t {";
	protected final String TEXT_148 = NL + "\t\t\t\t ";
	protected final String TEXT_149 = "new ";
	protected final String TEXT_150 = "(";
	protected final String TEXT_151 = ")";
	protected final String TEXT_152 = NL + "\t\t\t });" + NL;
	protected final String TEXT_153 = NL + "\t/**" + NL + "\t * The cached validation expression for the ";
	protected final String TEXT_154 = " constraint of '<em>";
	protected final String TEXT_155 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static final ";
	protected final String TEXT_156 = " ";
	protected final String TEXT_157 = "__";
	protected final String TEXT_158 = "__EEXPRESSION = \"";
	protected final String TEXT_159 = "\";";
	protected final String TEXT_160 = NL;
	protected final String TEXT_161 = NL + "\t/**" + NL + "\t * Validates the ";
	protected final String TEXT_162 = " constraint of '<em>";
	protected final String TEXT_163 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean validate";
	protected final String TEXT_164 = "_";
	protected final String TEXT_165 = "(";
	protected final String TEXT_166 = " ";
	protected final String TEXT_167 = ", DiagnosticChain ";
	protected final String TEXT_168 = ", ";
	protected final String TEXT_169 = " ";
	protected final String TEXT_170 = ")" + NL + "\t{";
	protected final String TEXT_171 = NL + "\t\tboolean ";
	protected final String TEXT_172 = " = true;" + NL + "\t\tfor (";
	protected final String TEXT_173 = " i = ";
	protected final String TEXT_174 = ".iterator(); i.hasNext() && (result || diagnostics != null); )" + NL + "\t\t{" + NL + "\t\t\tObject item = i.next();";
	protected final String TEXT_175 = NL + "\t\t\tif (";
	protected final String TEXT_176 = ".isInstance(item))" + NL + "\t\t\t{" + NL + "\t\t\t\tresult &= ";
	protected final String TEXT_177 = "validate";
	protected final String TEXT_178 = "(";
	protected final String TEXT_179 = "(";
	protected final String TEXT_180 = "(";
	protected final String TEXT_181 = ")";
	protected final String TEXT_182 = ").";
	protected final String TEXT_183 = "()";
	protected final String TEXT_184 = ", ";
	protected final String TEXT_185 = ", ";
	protected final String TEXT_186 = ");" + NL + "\t\t\t}" + NL + "\t\t\telse";
	protected final String TEXT_187 = NL + "\t\t\tif (!";
	protected final String TEXT_188 = ".isInstance(item))";
	protected final String TEXT_189 = NL + "\t\t\t{" + NL + "\t\t\t\tresult = false;" + NL + "\t\t\t\treportDataValueTypeViolation(";
	protected final String TEXT_190 = ", item, ";
	protected final String TEXT_191 = ", ";
	protected final String TEXT_192 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;";
	protected final String TEXT_193 = NL + "\t\tif (diagnostics != null)" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_194 = " tempDiagnostics = new BasicDiagnostic();";
	protected final String TEXT_195 = NL + "\t\t\tif (";
	protected final String TEXT_196 = "validate";
	protected final String TEXT_197 = "(";
	protected final String TEXT_198 = ", tempDiagnostics, ";
	protected final String TEXT_199 = ")) return true;";
	protected final String TEXT_200 = NL + "\t\t\tif (";
	protected final String TEXT_201 = ".isInstance(";
	protected final String TEXT_202 = "))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_203 = "if (";
	protected final String TEXT_204 = "validate";
	protected final String TEXT_205 = "(";
	protected final String TEXT_206 = "(";
	protected final String TEXT_207 = "(";
	protected final String TEXT_208 = ")";
	protected final String TEXT_209 = ").";
	protected final String TEXT_210 = "()";
	protected final String TEXT_211 = ", tempDiagnostics, ";
	protected final String TEXT_212 = ")) ";
	protected final String TEXT_213 = "return true;" + NL + "\t\t\t}";
	protected final String TEXT_214 = NL + "\t\t\tfor (";
	protected final String TEXT_215 = " diagnostic : tempDiagnostics.getChildren())" + NL + "\t\t\t{" + NL + "\t\t\t\tdiagnostics.add(diagnostic);" + NL + "\t\t\t}";
	protected final String TEXT_216 = NL + "\t\t\t";
	protected final String TEXT_217 = " children = tempDiagnostics.getChildren();" + NL + "\t\t\tfor (int i = 0; i < children.size(); i++)" + NL + "\t\t\t{" + NL + "\t\t\t\tdiagnostics.add((";
	protected final String TEXT_218 = ")children.get(i));" + NL + "\t\t\t}";
	protected final String TEXT_219 = NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{";
	protected final String TEXT_220 = NL + "\t\t\tif (";
	protected final String TEXT_221 = "validate";
	protected final String TEXT_222 = "(";
	protected final String TEXT_223 = ", null, ";
	protected final String TEXT_224 = ")) return true;";
	protected final String TEXT_225 = NL + "\t\t\tif (";
	protected final String TEXT_226 = ".isInstance(";
	protected final String TEXT_227 = "))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_228 = "if (";
	protected final String TEXT_229 = "validate";
	protected final String TEXT_230 = "(";
	protected final String TEXT_231 = "(";
	protected final String TEXT_232 = "(";
	protected final String TEXT_233 = ")";
	protected final String TEXT_234 = ").";
	protected final String TEXT_235 = "()";
	protected final String TEXT_236 = ", null, ";
	protected final String TEXT_237 = ")) ";
	protected final String TEXT_238 = "return true;" + NL + "\t\t\t}";
	protected final String TEXT_239 = NL + "\t\t}" + NL + "\t\treturn false;";
	protected final String TEXT_240 = NL + "\t\treturn validatePattern(";
	protected final String TEXT_241 = ", ";
	protected final String TEXT_242 = "new ";
	protected final String TEXT_243 = "(";
	protected final String TEXT_244 = ")";
	protected final String TEXT_245 = ", ";
	protected final String TEXT_246 = "__VALUES, ";
	protected final String TEXT_247 = ", ";
	protected final String TEXT_248 = ");";
	protected final String TEXT_249 = NL + "\t\t";
	protected final String TEXT_250 = " ";
	protected final String TEXT_251 = " = new ";
	protected final String TEXT_252 = "(";
	protected final String TEXT_253 = ");";
	protected final String TEXT_254 = NL + "\t\tboolean ";
	protected final String TEXT_255 = " = ";
	protected final String TEXT_256 = "__VALUES.contains(";
	protected final String TEXT_257 = ");" + NL + "\t\tif (!";
	protected final String TEXT_258 = " && ";
	protected final String TEXT_259 = " != null)" + NL + "\t\t\treportEnumerationViolation(";
	protected final String TEXT_260 = ", ";
	protected final String TEXT_261 = ", ";
	protected final String TEXT_262 = "__VALUES, ";
	protected final String TEXT_263 = ", ";
	protected final String TEXT_264 = ");" + NL + "\t\treturn ";
	protected final String TEXT_265 = ";";
	protected final String TEXT_266 = NL + "\t\tboolean ";
	protected final String TEXT_267 = " = ";
	protected final String TEXT_268 = " ";
	protected final String TEXT_269 = " ";
	protected final String TEXT_270 = "__VALUE;" + NL + "\t\tif (!";
	protected final String TEXT_271 = " && ";
	protected final String TEXT_272 = " != null)";
	protected final String TEXT_273 = NL + "\t\t\treportMinViolation(";
	protected final String TEXT_274 = ", new ";
	protected final String TEXT_275 = "(";
	protected final String TEXT_276 = "), new ";
	protected final String TEXT_277 = "(";
	protected final String TEXT_278 = "__VALUE), ";
	protected final String TEXT_279 = ", ";
	protected final String TEXT_280 = ", ";
	protected final String TEXT_281 = ");";
	protected final String TEXT_282 = NL + "\t\t\treportMinViolation(";
	protected final String TEXT_283 = ", ";
	protected final String TEXT_284 = ", ";
	protected final String TEXT_285 = "__VALUE, ";
	protected final String TEXT_286 = ", ";
	protected final String TEXT_287 = ", ";
	protected final String TEXT_288 = ");";
	protected final String TEXT_289 = NL + "\t\treturn ";
	protected final String TEXT_290 = ";";
	protected final String TEXT_291 = NL + "\t\tint ";
	protected final String TEXT_292 = " = ";
	protected final String TEXT_293 = ".compareCalendar(";
	protected final String TEXT_294 = ", ";
	protected final String TEXT_295 = "__VALUE);" + NL + "\t\tboolean ";
	protected final String TEXT_296 = " = ";
	protected final String TEXT_297 = " == 0 || ";
	protected final String TEXT_298 = " == 1;";
	protected final String TEXT_299 = NL + "\t\tint ";
	protected final String TEXT_300 = " = ";
	protected final String TEXT_301 = ".compareDuration(";
	protected final String TEXT_302 = ", ";
	protected final String TEXT_303 = "__VALUE);" + NL + "\t\tboolean ";
	protected final String TEXT_304 = " = ";
	protected final String TEXT_305 = " == 0 || ";
	protected final String TEXT_306 = " == 1;";
	protected final String TEXT_307 = NL + "\t\tboolean ";
	protected final String TEXT_308 = " = ";
	protected final String TEXT_309 = ".compareTo(";
	protected final String TEXT_310 = "__VALUE) ";
	protected final String TEXT_311 = " 0;";
	protected final String TEXT_312 = NL + "\t\tif (!";
	protected final String TEXT_313 = " && ";
	protected final String TEXT_314 = " != null)" + NL + "\t\t\treportMinViolation(";
	protected final String TEXT_315 = ", ";
	protected final String TEXT_316 = ", ";
	protected final String TEXT_317 = "__VALUE, ";
	protected final String TEXT_318 = ", ";
	protected final String TEXT_319 = ", ";
	protected final String TEXT_320 = ");" + NL + "\t\treturn ";
	protected final String TEXT_321 = ";";
	protected final String TEXT_322 = NL + "\t\tboolean ";
	protected final String TEXT_323 = " = ";
	protected final String TEXT_324 = " ";
	protected final String TEXT_325 = " ";
	protected final String TEXT_326 = "__VALUE;" + NL + "\t\tif (!";
	protected final String TEXT_327 = " && ";
	protected final String TEXT_328 = " != null)";
	protected final String TEXT_329 = NL + "\t\t\treportMaxViolation(";
	protected final String TEXT_330 = ", new ";
	protected final String TEXT_331 = "(";
	protected final String TEXT_332 = "), new ";
	protected final String TEXT_333 = "(";
	protected final String TEXT_334 = "__VALUE), ";
	protected final String TEXT_335 = ", ";
	protected final String TEXT_336 = ", ";
	protected final String TEXT_337 = ");";
	protected final String TEXT_338 = NL + "\t\t\treportMaxViolation(";
	protected final String TEXT_339 = ", ";
	protected final String TEXT_340 = ", ";
	protected final String TEXT_341 = "__VALUE, ";
	protected final String TEXT_342 = ", ";
	protected final String TEXT_343 = ", ";
	protected final String TEXT_344 = ");";
	protected final String TEXT_345 = NL + "\t\treturn ";
	protected final String TEXT_346 = ";";
	protected final String TEXT_347 = NL + "\t\tint ";
	protected final String TEXT_348 = " = ";
	protected final String TEXT_349 = ".compareCalendar(";
	protected final String TEXT_350 = ", ";
	protected final String TEXT_351 = "__VALUE);" + NL + "\t\tboolean ";
	protected final String TEXT_352 = " = ";
	protected final String TEXT_353 = " == 0 || ";
	protected final String TEXT_354 = " == -1;";
	protected final String TEXT_355 = NL + "\t\tint ";
	protected final String TEXT_356 = " = ";
	protected final String TEXT_357 = ".compareDuration(";
	protected final String TEXT_358 = ", ";
	protected final String TEXT_359 = "__VALUE);" + NL + "\t\tboolean ";
	protected final String TEXT_360 = " = ";
	protected final String TEXT_361 = " == 0 || ";
	protected final String TEXT_362 = " == -1;";
	protected final String TEXT_363 = NL + "\t\tboolean ";
	protected final String TEXT_364 = " = ";
	protected final String TEXT_365 = ".compareTo(";
	protected final String TEXT_366 = "__VALUE) ";
	protected final String TEXT_367 = " 0;";
	protected final String TEXT_368 = NL + "\t\tif (!";
	protected final String TEXT_369 = " && ";
	protected final String TEXT_370 = " != null)" + NL + "\t\t\treportMaxViolation(";
	protected final String TEXT_371 = ", ";
	protected final String TEXT_372 = ", ";
	protected final String TEXT_373 = "__VALUE, ";
	protected final String TEXT_374 = ", ";
	protected final String TEXT_375 = ", ";
	protected final String TEXT_376 = ");" + NL + "\t\treturn ";
	protected final String TEXT_377 = ";";
	protected final String TEXT_378 = NL + "\t\tint length = ";
	protected final String TEXT_379 = ".";
	protected final String TEXT_380 = ";" + NL + "\t\tboolean ";
	protected final String TEXT_381 = " = length >= ";
	protected final String TEXT_382 = ";" + NL + "\t\tif (!";
	protected final String TEXT_383 = " && ";
	protected final String TEXT_384 = " != null)" + NL + "\t\t\treportMinLengthViolation(";
	protected final String TEXT_385 = ", ";
	protected final String TEXT_386 = ", length, ";
	protected final String TEXT_387 = ", ";
	protected final String TEXT_388 = ", ";
	protected final String TEXT_389 = ");" + NL + "\t\treturn ";
	protected final String TEXT_390 = ";";
	protected final String TEXT_391 = NL + "\t\tint length = ";
	protected final String TEXT_392 = ".";
	protected final String TEXT_393 = ";" + NL + "\t\tboolean ";
	protected final String TEXT_394 = " = length <= ";
	protected final String TEXT_395 = ";" + NL + "\t\tif (!";
	protected final String TEXT_396 = " && ";
	protected final String TEXT_397 = " != null)" + NL + "\t\t\treportMaxLengthViolation(";
	protected final String TEXT_398 = ", ";
	protected final String TEXT_399 = ", length, ";
	protected final String TEXT_400 = ", ";
	protected final String TEXT_401 = ", ";
	protected final String TEXT_402 = ");" + NL + "\t\treturn ";
	protected final String TEXT_403 = ";";
	protected final String TEXT_404 = NL + "\t\tboolean ";
	protected final String TEXT_405 = " = ";
	protected final String TEXT_406 = " > ";
	protected final String TEXT_407 = "__LOWER_BOUND && ";
	protected final String TEXT_408 = " < ";
	protected final String TEXT_409 = "__UPPER_BOUND;" + NL + "\t\tif (!";
	protected final String TEXT_410 = " && ";
	protected final String TEXT_411 = " != null)";
	protected final String TEXT_412 = NL + "\t\t\treportTotalDigitsViolation(";
	protected final String TEXT_413 = ", new ";
	protected final String TEXT_414 = "(";
	protected final String TEXT_415 = "), ";
	protected final String TEXT_416 = ", ";
	protected final String TEXT_417 = ", ";
	protected final String TEXT_418 = ");";
	protected final String TEXT_419 = NL + "\t\t\treportTotalDigitsViolation(";
	protected final String TEXT_420 = ", ";
	protected final String TEXT_421 = ", ";
	protected final String TEXT_422 = ", ";
	protected final String TEXT_423 = ", ";
	protected final String TEXT_424 = ");";
	protected final String TEXT_425 = NL + "\t\tboolean ";
	protected final String TEXT_426 = " = ";
	protected final String TEXT_427 = ".unscaledValue().abs().toString().length() <= ";
	protected final String TEXT_428 = ";" + NL + "\t\tif (!";
	protected final String TEXT_429 = " && ";
	protected final String TEXT_430 = " != null)" + NL + "\t\t\treportTotalDigitsViolation(";
	protected final String TEXT_431 = ", ";
	protected final String TEXT_432 = ", ";
	protected final String TEXT_433 = ", ";
	protected final String TEXT_434 = ", ";
	protected final String TEXT_435 = ");";
	protected final String TEXT_436 = NL + "\t\tboolean ";
	protected final String TEXT_437 = " = ";
	protected final String TEXT_438 = ".compareTo(";
	protected final String TEXT_439 = "__LOWER_BOUND) > 0 && ";
	protected final String TEXT_440 = ".compareTo(";
	protected final String TEXT_441 = "__UPPER_BOUND) < 0;" + NL + "\t\tif (!";
	protected final String TEXT_442 = " && ";
	protected final String TEXT_443 = " != null)" + NL + "\t\t\treportTotalDigitsViolation(";
	protected final String TEXT_444 = ", ";
	protected final String TEXT_445 = ", ";
	protected final String TEXT_446 = ", ";
	protected final String TEXT_447 = ", ";
	protected final String TEXT_448 = ");";
	protected final String TEXT_449 = NL + "\t\treturn ";
	protected final String TEXT_450 = ";";
	protected final String TEXT_451 = NL + "\t\tboolean ";
	protected final String TEXT_452 = " = ";
	protected final String TEXT_453 = ".scale() <= ";
	protected final String TEXT_454 = ";" + NL + "\t\tif (!";
	protected final String TEXT_455 = " && ";
	protected final String TEXT_456 = " != null)" + NL + "\t\t\treportFractionDigitsViolation(";
	protected final String TEXT_457 = ", ";
	protected final String TEXT_458 = ", ";
	protected final String TEXT_459 = ", ";
	protected final String TEXT_460 = ", ";
	protected final String TEXT_461 = ");" + NL + "\t\treturn ";
	protected final String TEXT_462 = ";";
	protected final String TEXT_463 = NL + "\t\t// TODO override the constraint, if desired" + NL + "\t\t// -> uncomment the scaffolding" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_464 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_465 = ".add";
	protected final String TEXT_466 = NL + "\t\t\t\t\t(createDiagnostic" + NL + "\t\t\t\t\t\t(";
	protected final String TEXT_467 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t \"_UI_GenericConstraint_diagnostic\",";
	protected final String TEXT_468 = NL + "\t\t\t\t\t\t new Object[] { \"";
	protected final String TEXT_469 = "\", getValueLabel(";
	protected final String TEXT_470 = ", ";
	protected final String TEXT_471 = ", ";
	protected final String TEXT_472 = ") },";
	protected final String TEXT_473 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_474 = " }," + NL + "\t\t\t\t\t\t context));";
	protected final String TEXT_475 = NL + "\t\t\t\t\t(new ";
	protected final String TEXT_476 = NL + "\t\t\t\t\t\t(";
	protected final String TEXT_477 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_478 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
	protected final String TEXT_479 = "\", getValueLabel(";
	protected final String TEXT_480 = ", ";
	protected final String TEXT_481 = ", ";
	protected final String TEXT_482 = ") }),";
	protected final String TEXT_483 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_484 = " }));";
	protected final String TEXT_485 = NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn ";
	protected final String TEXT_486 = "validate";
	protected final String TEXT_487 = "_";
	protected final String TEXT_488 = "(";
	protected final String TEXT_489 = ", ";
	protected final String TEXT_490 = ", ";
	protected final String TEXT_491 = ");";
	protected final String TEXT_492 = NL + "\t\treturn" + NL + "\t\t\tvalidate" + NL + "\t\t\t\t(";
	protected final String TEXT_493 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_494 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_495 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_496 = "," + NL + "\t\t\t\t \"";
	protected final String TEXT_497 = "\",";
	protected final String TEXT_498 = NL + "\t\t\t\t \"";
	protected final String TEXT_499 = "\",";
	protected final String TEXT_500 = NL + "\t\t\t\t ";
	protected final String TEXT_501 = "__";
	protected final String TEXT_502 = "__EEXPRESSION," + NL + "\t\t\t\t ";
	protected final String TEXT_503 = ".ERROR," + NL + "\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t 0);";
	protected final String TEXT_504 = NL + "\t\t// TODO implement the constraint" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_505 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_506 = ".add";
	protected final String TEXT_507 = NL + "\t\t\t\t\t(createDiagnostic" + NL + "\t\t\t\t\t\t(";
	protected final String TEXT_508 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t \"_UI_GenericConstraint_diagnostic\",";
	protected final String TEXT_509 = NL + "\t\t\t\t\t\t new Object[] { \"";
	protected final String TEXT_510 = "\", getValueLabel(";
	protected final String TEXT_511 = ", ";
	protected final String TEXT_512 = ", ";
	protected final String TEXT_513 = ") },";
	protected final String TEXT_514 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_515 = " }," + NL + "\t\t\t\t\t\t context));";
	protected final String TEXT_516 = NL + "\t\t\t\t\t(new ";
	protected final String TEXT_517 = NL + "\t\t\t\t\t\t(";
	protected final String TEXT_518 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_519 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
	protected final String TEXT_520 = "\", getValueLabel(";
	protected final String TEXT_521 = ", ";
	protected final String TEXT_522 = ", ";
	protected final String TEXT_523 = ") }),";
	protected final String TEXT_524 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_525 = " }));";
	protected final String TEXT_526 = NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
	protected final String TEXT_527 = NL + "\t\t// TODO override the constraint, if desired" + NL + "\t\t// -> uncomment the scaffolding" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_528 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_529 = ".add";
	protected final String TEXT_530 = NL + "\t\t\t\t\t(createDiagnostic" + NL + "\t\t\t\t\t\t(";
	protected final String TEXT_531 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t \"_UI_GenericConstraint_diagnostic\",";
	protected final String TEXT_532 = NL + "\t\t\t\t\t\t new Object[] { \"";
	protected final String TEXT_533 = "\", getObjectLabel(";
	protected final String TEXT_534 = ", ";
	protected final String TEXT_535 = ") },";
	protected final String TEXT_536 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_537 = " }," + NL + "\t\t\t\t\t\t context));";
	protected final String TEXT_538 = NL + "\t\t\t\t\t(new ";
	protected final String TEXT_539 = NL + "\t\t\t\t\t\t(";
	protected final String TEXT_540 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_541 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
	protected final String TEXT_542 = "\", getObjectLabel(";
	protected final String TEXT_543 = ", ";
	protected final String TEXT_544 = ") }),";
	protected final String TEXT_545 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_546 = " }));";
	protected final String TEXT_547 = NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn ";
	protected final String TEXT_548 = "validate";
	protected final String TEXT_549 = "_";
	protected final String TEXT_550 = "(";
	protected final String TEXT_551 = ", ";
	protected final String TEXT_552 = ", ";
	protected final String TEXT_553 = ");";
	protected final String TEXT_554 = NL + "\t\treturn ";
	protected final String TEXT_555 = ".";
	protected final String TEXT_556 = "(";
	protected final String TEXT_557 = ", ";
	protected final String TEXT_558 = ");";
	protected final String TEXT_559 = NL + "\t\treturn" + NL + "\t\t\tvalidate" + NL + "\t\t\t\t(";
	protected final String TEXT_560 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_561 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_562 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_563 = "," + NL + "\t\t\t\t \"";
	protected final String TEXT_564 = "\",";
	protected final String TEXT_565 = NL + "\t\t\t\t \"";
	protected final String TEXT_566 = "\",";
	protected final String TEXT_567 = NL + "\t\t\t\t ";
	protected final String TEXT_568 = "__";
	protected final String TEXT_569 = "__EEXPRESSION," + NL + "\t\t\t\t ";
	protected final String TEXT_570 = ".ERROR," + NL + "\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t 0);";
	protected final String TEXT_571 = NL + "\t\t// TODO implement the constraint" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_572 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_573 = ".add";
	protected final String TEXT_574 = NL + "\t\t\t\t\t(createDiagnostic" + NL + "\t\t\t\t\t\t(";
	protected final String TEXT_575 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t \"_UI_GenericConstraint_diagnostic\",";
	protected final String TEXT_576 = NL + "\t\t\t\t\t\t new Object[] { \"";
	protected final String TEXT_577 = "\", getObjectLabel(";
	protected final String TEXT_578 = ", ";
	protected final String TEXT_579 = ") },";
	protected final String TEXT_580 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_581 = " }," + NL + "\t\t\t\t\t\t context));";
	protected final String TEXT_582 = NL + "\t\t\t\t\t(new ";
	protected final String TEXT_583 = NL + "\t\t\t\t\t\t(";
	protected final String TEXT_584 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_585 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
	protected final String TEXT_586 = "\", getObjectLabel(";
	protected final String TEXT_587 = ", ";
	protected final String TEXT_588 = ") }),";
	protected final String TEXT_589 = NL + "\t\t\t\t\t\t new Object[] { ";
	protected final String TEXT_590 = " }));";
	protected final String TEXT_591 = NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
	protected final String TEXT_592 = NL + "\t}" + NL;
	protected final String TEXT_593 = NL + "\t/**" + NL + "\t * Returns the resource locator that will be used to fetch messages for this validator's diagnostics." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_594 = NL + "\t@Override";
	protected final String TEXT_595 = NL + "\tpublic ";
	protected final String TEXT_596 = " getResourceLocator()" + NL + "\t{";
	protected final String TEXT_597 = NL + "\t\treturn ";
	protected final String TEXT_598 = ".INSTANCE;";
	protected final String TEXT_599 = NL + "\t\t// TODO" + NL + "\t\t// Specialize this to return a resource locator for messages specific to this validator." + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\treturn super.getResourceLocator();";
	protected final String TEXT_600 = NL + "\t}" + NL;
	protected final String TEXT_601 = NL + "} //";
	protected final String TEXT_602 = NL;
	protected final String TEXT_603 = NL;
	protected final String TEXT_604 = NL;

	public ValidatorClass() {
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

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_603);
		stringBuffer.append(TEXT_604);
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

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getModelDirectory();
		packageName = genPackage.getUtilitiesPackageName();
		className = genPackage.getValidatorClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		argument = parameter;

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
		 * <copyright>
		 *
		 * Copyright (c) 2002-2010 IBM Corporation and others.
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

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();
		final String singleWildcard = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? "<?>" : "";
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

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getUtilitiesPackageName());
		stringBuffer.append(TEXT_3);
		genModel.addImport("java.util.Map");
		final String _Map = genModel.useGenerics() ? "Map<" + genModel.getImportedName("java.lang.Object") + ", " + genModel.getImportedName("java.lang.Object") + ">" : "Map";
		final String objectArgument = genModel.useGenerics() ? "<" + genModel.getImportedName("java.lang.Object") + ">" : "";
		genModel.addImport("org.eclipse.emf.common.util.DiagnosticChain");
		genModel.addImport("org.eclipse.emf.ecore.EPackage");
		if (!genPackage.hasJavaLangConflict() && !genPackage.getUtilitiesPackageName().equals(genPackage.getInterfacePackageName()))
			genModel.addImport(genPackage.getInterfacePackageName() + ".*");
		genModel.markImportLocation(stringBuffer);
		genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.Descriptor");
		genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.Registry");
		genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider");
		genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.PatternMatcher");
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genPackage.getValidatorClassName());
		stringBuffer.append(TEXT_6);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
		stringBuffer.append(TEXT_7);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_11);
		}
		stringBuffer.append(TEXT_12);
		stringBuffer.append(genPackage.getValidatorClassName());
		stringBuffer.append(TEXT_13);
		stringBuffer.append(genPackage.getValidatorClassName());
		stringBuffer.append(TEXT_14);
		stringBuffer.append(genPackage.getInterfacePackageName());
		stringBuffer.append(TEXT_15);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_16);
		int count = 0;
		for (GenClass genClass : genPackage.getGenClasses()) {
			for (GenOperation genOperation : genClass.getInvariantOperations()) {
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genOperation.getFormattedName());
				stringBuffer.append(TEXT_18);
				stringBuffer.append(genClass.getFormattedName());
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genClass.getOperationID(genOperation));
				stringBuffer.append(TEXT_20);
				stringBuffer.append(++count);
				stringBuffer.append(TEXT_21);
			}
		}
		stringBuffer.append(TEXT_22);
		stringBuffer.append(count);
		stringBuffer.append(TEXT_23);
		for (GenPackage baseGenPackage : genPackage.getAllValidatorBaseGenPackages()) {
			stringBuffer.append(TEXT_24);
			stringBuffer.append(baseGenPackage.getImportedValidatorClassName());
			stringBuffer.append(TEXT_25);
			stringBuffer.append(genPackage.getValidatorPackageUniqueSafeName(baseGenPackage));
			stringBuffer.append(TEXT_26);
		}
		if (genPackage.hasInvariantExpressions()) {
			stringBuffer.append(TEXT_27);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
			stringBuffer.append(TEXT_29);
			stringBuffer.append(_Map);
			stringBuffer.append(TEXT_30);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_31);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EOperation"));
			stringBuffer.append(TEXT_32);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_33);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_34);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
			stringBuffer.append(TEXT_35);
		}
		stringBuffer.append(TEXT_36);
		stringBuffer.append(genPackage.getValidatorClassName());
		stringBuffer.append(TEXT_37);
		for (GenPackage baseGenPackage : genPackage.getAllValidatorBaseGenPackages()) {
			stringBuffer.append(TEXT_38);
			stringBuffer.append(genPackage.getValidatorPackageUniqueSafeName(baseGenPackage));
			stringBuffer.append(TEXT_39);
			stringBuffer.append(baseGenPackage.getImportedValidatorClassName());
			stringBuffer.append(TEXT_40);
		}
		stringBuffer.append(TEXT_41);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_42);
		}
		stringBuffer.append(TEXT_43);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_44);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_45);
		}
		for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
			if (genClassifier.isUncheckedCast()) {
				stringBuffer.append(TEXT_46);
				break;
			}
		}
		stringBuffer.append(TEXT_47);
		stringBuffer.append(_Map);
		stringBuffer.append(TEXT_48);
		for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
			stringBuffer.append(TEXT_49);
			stringBuffer.append(genPackage.getImportedPackageInterfaceName());
			stringBuffer.append(TEXT_50);
			stringBuffer.append(genPackage.getClassifierID(genClassifier));
			stringBuffer.append(TEXT_51);
			if (genClassifier instanceof GenDataType) {
				GenDataType genDataType = (GenDataType) genClassifier;
				if (genDataType.isPrimitiveType()) {
					if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
						stringBuffer.append(TEXT_52);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_53);
						stringBuffer.append(genDataType.getObjectInstanceClassName());
						stringBuffer.append(TEXT_54);
						stringBuffer.append(genDataType.getPrimitiveValueFunction());
						stringBuffer.append(TEXT_55);
					} else {
						stringBuffer.append(TEXT_56);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_57);
						stringBuffer.append(genDataType.getObjectInstanceClassName());
						stringBuffer.append(TEXT_58);
					}
				} else if (genDataType.isObjectType()) {
					stringBuffer.append(TEXT_59);
					stringBuffer.append(genDataType.getName());
					stringBuffer.append(TEXT_60);
				} else {
					stringBuffer.append(TEXT_61);
					stringBuffer.append(genDataType.getName());
					stringBuffer.append(TEXT_62);
					stringBuffer.append(genDataType.getObjectType().getImportedWildcardInstanceClassName());
					stringBuffer.append(TEXT_63);
				}
			} else {
				GenClass genClass = (GenClass) genClassifier;
				stringBuffer.append(TEXT_64);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_65);
				stringBuffer.append(genClass.getImportedWildcardInstanceClassName());
				stringBuffer.append(TEXT_66);
			}
		}
		stringBuffer.append(TEXT_67);
		for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
			String result = "result".equals(genClassifier.getSafeUncapName()) ? "theResult" : "result";
			String diagnostics = "diagnostics".equals(genClassifier.getSafeUncapName()) ? "theDiagnostics" : "diagnostics";
			String item = "item".equals(genClassifier.getSafeUncapName()) ? "theItem" : "item";
			String context = "context".equals(genClassifier.getSafeUncapName()) ? "theContext" : "context";
			stringBuffer.append(TEXT_68);
			stringBuffer.append(genClassifier.getName());
			stringBuffer.append(TEXT_69);
			stringBuffer.append(genClassifier.getImportedWildcardInstanceClassName());
			stringBuffer.append(TEXT_70);
			stringBuffer.append(genClassifier.getSafeUncapName());
			stringBuffer.append(TEXT_71);
			stringBuffer.append(diagnostics);
			stringBuffer.append(TEXT_72);
			stringBuffer.append(_Map);
			stringBuffer.append(TEXT_73);
			stringBuffer.append(context);
			stringBuffer.append(TEXT_74);
			if (genClassifier.getAllGenConstraints().isEmpty()) {
				stringBuffer.append(TEXT_75);
			} else if (genClassifier.hasOnlyDefaultConstraints()) {
				stringBuffer.append(TEXT_76);
				if (!((GenClass) genClassifier).isEObjectExtension()) {
					stringBuffer.append(TEXT_77);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
					stringBuffer.append(TEXT_78);
				}
				stringBuffer.append(genClassifier.getSafeUncapName());
				stringBuffer.append(TEXT_79);
				stringBuffer.append(diagnostics);
				stringBuffer.append(TEXT_80);
				stringBuffer.append(context);
				stringBuffer.append(TEXT_81);
			} else {
				boolean first = true;
				for (String constraint : genClassifier.getAllGenConstraints()) {
					GenClassifier constraintImplementor = genClassifier.getConstraintImplementor(constraint);
					String delegate = constraintImplementor == null || constraintImplementor.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(constraintImplementor.getGenPackage()) + "Validator.";
					String cast = constraintImplementor == null && genClassifier instanceof GenClass && !((GenClass) genClassifier).isEObjectExtension() ? "(" + genModel.getImportedName("org.eclipse.emf.ecore.EObject") + ")" : "";
					String accessor = constraintImplementor != null && genClassifier instanceof GenDataType && !((GenDataType) genClassifier).isPrimitiveType() && ((GenDataType) constraintImplementor).isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50 ? "." + ((GenDataType) constraintImplementor).getPrimitiveValueFunction() + "()" : "";
					if ("NoCircularContainment".equals(constraint)) {
						stringBuffer.append(TEXT_82);
						if (!((GenClass) genClassifier).isEObjectExtension()) {
							stringBuffer.append(TEXT_83);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
							stringBuffer.append(TEXT_84);
						}
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_85);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_86);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_87);
					} else if (first) {
						first = false;
						stringBuffer.append(TEXT_88);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_89);
						stringBuffer.append(delegate);
						stringBuffer.append(TEXT_90);
						stringBuffer.append(constraintImplementor == null ? "" : constraintImplementor.getName());
						stringBuffer.append(TEXT_91);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_92);
						stringBuffer.append(cast);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(accessor);
						stringBuffer.append(TEXT_93);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_94);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_95);
					} else {
						stringBuffer.append(TEXT_96);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_97);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_98);
						stringBuffer.append(delegate);
						stringBuffer.append(TEXT_99);
						stringBuffer.append(constraintImplementor == null ? "" : constraintImplementor.getName());
						stringBuffer.append(TEXT_100);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_101);
						stringBuffer.append(cast);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(accessor);
						stringBuffer.append(TEXT_102);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_103);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_104);
					}
				}
				stringBuffer.append(TEXT_105);
				stringBuffer.append(result);
				stringBuffer.append(TEXT_106);
			}
			stringBuffer.append(TEXT_107);
			for (String constraint : genClassifier.getGenConstraints()) {
				GenClassifier constraintDelegate = genClassifier.getConstraintDelegate(constraint);
				String constant = genClassifier.getClassifierID() + "__" + CodeGenUtil.format(constraint, '_', null, false, false).toUpperCase(genClassifier.getGenModel().getLocale());
				String delegate = constraintDelegate == null || constraintDelegate.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(constraintDelegate.getGenPackage()) + "Validator.";
				String cast = constraintDelegate == null && genClassifier instanceof GenClass && !((GenClass) genClassifier).isEObjectExtension() ? "(" + genModel.getImportedName("org.eclipse.emf.ecore.EObject") + ")" : "";
				String accessor = constraintDelegate != null && genClassifier instanceof GenDataType && !((GenDataType) genClassifier).isPrimitiveType() && ((GenDataType) constraintDelegate).isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50 ? "." + ((GenDataType) constraintDelegate).getPrimitiveValueFunction() + "()" : "";
				if (genClassifier instanceof GenDataType) {
					GenDataType genDataType = (GenDataType) genClassifier;
					if (constraint.equals("Min") && genDataType.getMinLiteral() != null) {
						stringBuffer.append(TEXT_108);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_109);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_110);
						stringBuffer.append(genDataType.getImportedInstanceClassName());
						stringBuffer.append(TEXT_111);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_112);
						stringBuffer.append(genDataType.getStaticValue(genDataType.getMinLiteral()));
						stringBuffer.append(TEXT_113);
					} else if (constraint.equals("Max") && genDataType.getMaxLiteral() != null) {
						stringBuffer.append(TEXT_114);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_115);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_116);
						stringBuffer.append(genDataType.getImportedInstanceClassName());
						stringBuffer.append(TEXT_117);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_118);
						stringBuffer.append(genDataType.getStaticValue(genDataType.getMaxLiteral()));
						stringBuffer.append(TEXT_119);
					} else if (constraint.equals("TotalDigits") && genDataType.getTotalDigits() != -1 && !"java.math.BigDecimal".equals(genDataType.getQualifiedInstanceClassName())) {
						String value = "1";
						for (int digitCount = genDataType.getTotalDigits(); digitCount > 0; --digitCount)
							value += "0";
						stringBuffer.append(TEXT_120);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_121);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_122);
						stringBuffer.append(genDataType.getImportedInstanceClassName());
						stringBuffer.append(TEXT_123);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_124);
						stringBuffer.append(genDataType.getStaticValue(value));
						stringBuffer.append(TEXT_125);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_126);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_127);
						stringBuffer.append(genDataType.getImportedInstanceClassName());
						stringBuffer.append(TEXT_128);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_129);
						stringBuffer.append(genDataType.getStaticValue("-" + value));
						stringBuffer.append(TEXT_130);
					} else if (constraint.equals("Pattern") && !genDataType.getPatterns().isEmpty()) {
						stringBuffer.append(TEXT_131);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_132);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_133);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_134);
						for (Iterator<List<String>> k = genDataType.getPatterns().iterator(); k.hasNext();) {
							List<String> patternList = k.next();
							stringBuffer.append(TEXT_135);
							for (Iterator<String> p = patternList.iterator(); p.hasNext();) {
								String pattern = p.next();
								stringBuffer.append(TEXT_136);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
								stringBuffer.append(TEXT_137);
								stringBuffer.append(pattern);
								stringBuffer.append(TEXT_138);
								stringBuffer.append(p.hasNext() ? "," : "");
							}
							stringBuffer.append(TEXT_139);
							stringBuffer.append(k.hasNext() ? "," : "");
						}
						stringBuffer.append(TEXT_140);
					} else if (constraint.equals("Enumeration") && !genDataType.getEnumerationLiterals().isEmpty()) {
						stringBuffer.append(TEXT_141);
						stringBuffer.append(genDataType.getName());
						stringBuffer.append(TEXT_142);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_143);
						if (genDataType.isUncheckedCast()) {
							stringBuffer.append(TEXT_144);
						}
						stringBuffer.append(TEXT_145);
						stringBuffer.append(genModel.getImportedName("java.util.Collection"));
						stringBuffer.append(objectArgument);
						stringBuffer.append(TEXT_146);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_147);
						for (Iterator<String> k = genDataType.getEnumerationLiterals().iterator(); k.hasNext();) {
							String literal = k.next();
							stringBuffer.append(TEXT_148);
							if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_149);
								stringBuffer.append(genDataType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_150);
							}
							stringBuffer.append(genDataType.getStaticValue(literal, false));
							if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_151);
							}
							stringBuffer.append(k.hasNext() ? "," : "");
						}
						stringBuffer.append(TEXT_152);
					}
				}
				if (genClassifier.hasConstraintExpression(constraint)) {
					stringBuffer.append(TEXT_153);
					stringBuffer.append(constraint);
					stringBuffer.append(TEXT_154);
					stringBuffer.append(genClassifier.getFormattedName());
					stringBuffer.append(TEXT_155);
					stringBuffer.append(genModel.getImportedName("java.lang.String"));
					stringBuffer.append(TEXT_156);
					stringBuffer.append(genClassifier.getClassifierID());
					stringBuffer.append(TEXT_157);
					stringBuffer.append(CodeGenUtil.upperName(constraint));
					stringBuffer.append(TEXT_158);
					stringBuffer.append(genClassifier.getConstraintExpression(constraint, "\t\t"));
					stringBuffer.append(TEXT_159);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(TEXT_160);
				}
				stringBuffer.append(TEXT_161);
				stringBuffer.append(constraint);
				stringBuffer.append(TEXT_162);
				stringBuffer.append(genClassifier.getFormattedName());
				stringBuffer.append(TEXT_163);
				stringBuffer.append(genClassifier.getName());
				stringBuffer.append(TEXT_164);
				stringBuffer.append(constraint);
				stringBuffer.append(TEXT_165);
				stringBuffer.append(genClassifier.getImportedWildcardInstanceClassName());
				stringBuffer.append(TEXT_166);
				stringBuffer.append(genClassifier.getSafeUncapName());
				stringBuffer.append(TEXT_167);
				stringBuffer.append(diagnostics);
				stringBuffer.append(TEXT_168);
				stringBuffer.append(_Map);
				stringBuffer.append(TEXT_169);
				stringBuffer.append(context);
				stringBuffer.append(TEXT_170);
				if (genClassifier instanceof GenDataType) {
					GenDataType genDataType = (GenDataType) genClassifier;
					if (constraint.equals("ItemType") && genDataType.getItemType() != null) {
						GenDataType itemType = genDataType.getItemType();
						String itemDelegate = itemType.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(itemType.getGenPackage()) + "Validator.";
						stringBuffer.append(TEXT_171);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_172);
						stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
						stringBuffer.append(singleWildcard);
						stringBuffer.append(TEXT_173);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_174);
						if (itemType.getGenPackage().hasConstraints()) {
							stringBuffer.append(TEXT_175);
							stringBuffer.append(itemType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_176);
							stringBuffer.append(itemDelegate);
							stringBuffer.append(TEXT_177);
							stringBuffer.append(itemType.getName());
							stringBuffer.append(TEXT_178);
							if (itemType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_179);
							}
							if (!itemType.isObjectType()) {
								stringBuffer.append(TEXT_180);
								stringBuffer.append(itemType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_181);
							}
							stringBuffer.append(item);
							if (itemType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_182);
								stringBuffer.append(itemType.getPrimitiveValueFunction());
								stringBuffer.append(TEXT_183);
							}
							stringBuffer.append(TEXT_184);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_185);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_186);
						} else {
							stringBuffer.append(TEXT_187);
							stringBuffer.append(itemType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_188);
						}
						stringBuffer.append(TEXT_189);
						stringBuffer.append(itemType.getQualifiedClassifierAccessor());
						stringBuffer.append(TEXT_190);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_191);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_192);
					} else if (constraint.equals("MemberTypes") && !genDataType.getMemberTypes().isEmpty()) {
						stringBuffer.append(TEXT_193);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
						stringBuffer.append(TEXT_194);
						for (ListIterator<GenDataType> k = genDataType.getMemberTypes().listIterator(); k.hasNext();) {
							GenDataType memberType = k.next();
							String memberDelegate = memberType.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(memberType.getGenPackage()) + "Validator.";
							if (genDataType.isPrimitiveType()) {
								stringBuffer.append(TEXT_195);
								stringBuffer.append(memberDelegate);
								stringBuffer.append(TEXT_196);
								stringBuffer.append(memberType.getName());
								stringBuffer.append(TEXT_197);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_198);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_199);
							} else {
								stringBuffer.append(TEXT_200);
								stringBuffer.append(memberType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_201);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_202);
								if (memberType.getGenPackage().hasConstraints()) {
									stringBuffer.append(TEXT_203);
									stringBuffer.append(memberDelegate);
									stringBuffer.append(TEXT_204);
									stringBuffer.append(memberType.getName());
									stringBuffer.append(TEXT_205);
									if (memberType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
										stringBuffer.append(TEXT_206);
									}
									if (!memberType.isObjectType() && !memberType.getQualifiedInstanceClassName().equals(genDataType.getQualifiedInstanceClassName())) {
										stringBuffer.append(TEXT_207);
										stringBuffer.append(memberType.getImportedWildcardObjectInstanceClassName());
										stringBuffer.append(TEXT_208);
									}
									stringBuffer.append(genClassifier.getSafeUncapName());
									if (memberType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
										stringBuffer.append(TEXT_209);
										stringBuffer.append(memberType.getPrimitiveValueFunction());
										stringBuffer.append(TEXT_210);
									}
									stringBuffer.append(TEXT_211);
									stringBuffer.append(context);
									stringBuffer.append(TEXT_212);
								}
								stringBuffer.append(TEXT_213);
							}
						}
						if (genModel.useGenerics()) {
							stringBuffer.append(TEXT_214);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
							stringBuffer.append(TEXT_215);
						} else {
							stringBuffer.append(TEXT_216);
							stringBuffer.append(genModel.getImportedName("java.util.List"));
							stringBuffer.append(TEXT_217);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
							stringBuffer.append(TEXT_218);
						}
						stringBuffer.append(TEXT_219);
						for (ListIterator<GenDataType> k = genDataType.getMemberTypes().listIterator(); k.hasNext();) {
							GenDataType memberType = k.next();
							String memberDelegate = memberType.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(memberType.getGenPackage()) + "Validator.";
							if (genDataType.isPrimitiveType()) {
								stringBuffer.append(TEXT_220);
								stringBuffer.append(memberDelegate);
								stringBuffer.append(TEXT_221);
								stringBuffer.append(memberType.getName());
								stringBuffer.append(TEXT_222);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_223);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_224);
							} else {
								stringBuffer.append(TEXT_225);
								stringBuffer.append(memberType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_226);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_227);
								if (memberType.getGenPackage().hasConstraints()) {
									stringBuffer.append(TEXT_228);
									stringBuffer.append(memberDelegate);
									stringBuffer.append(TEXT_229);
									stringBuffer.append(memberType.getName());
									stringBuffer.append(TEXT_230);
									if (memberType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
										stringBuffer.append(TEXT_231);
									}
									if (!memberType.isObjectType() && !memberType.getQualifiedInstanceClassName().equals(genDataType.getQualifiedInstanceClassName())) {
										stringBuffer.append(TEXT_232);
										stringBuffer.append(memberType.getImportedWildcardObjectInstanceClassName());
										stringBuffer.append(TEXT_233);
									}
									stringBuffer.append(genClassifier.getSafeUncapName());
									if (memberType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
										stringBuffer.append(TEXT_234);
										stringBuffer.append(memberType.getPrimitiveValueFunction());
										stringBuffer.append(TEXT_235);
									}
									stringBuffer.append(TEXT_236);
									stringBuffer.append(context);
									stringBuffer.append(TEXT_237);
								}
								stringBuffer.append(TEXT_238);
							}
						}
						stringBuffer.append(TEXT_239);
					} else if (constraint.equals("Pattern") && !genDataType.getPatterns().isEmpty()) {
						stringBuffer.append(TEXT_240);
						stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
						stringBuffer.append(TEXT_241);
						if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
							stringBuffer.append(TEXT_242);
							stringBuffer.append(genDataType.getObjectInstanceClassName());
							stringBuffer.append(TEXT_243);
						}
						stringBuffer.append(genDataType.getSafeUncapName());
						if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
							stringBuffer.append(TEXT_244);
						}
						stringBuffer.append(TEXT_245);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_246);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_247);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_248);
					} else if (constraint.equals("Enumeration") && !genDataType.getEnumerationLiterals().isEmpty()) {
						String variable = genDataType.getSafeUncapName();
						if (genDataType.isPrimitiveType() && genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
							variable = variable + "Object";
							stringBuffer.append(TEXT_249);
							stringBuffer.append(genDataType.getObjectInstanceClassName());
							stringBuffer.append(TEXT_250);
							stringBuffer.append(variable);
							stringBuffer.append(TEXT_251);
							stringBuffer.append(genDataType.getObjectInstanceClassName());
							stringBuffer.append(TEXT_252);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_253);
						}
						stringBuffer.append(TEXT_254);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_255);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_256);
						stringBuffer.append(variable);
						stringBuffer.append(TEXT_257);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_258);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_259);
						stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
						stringBuffer.append(TEXT_260);
						stringBuffer.append(variable);
						stringBuffer.append(TEXT_261);
						stringBuffer.append(constant);
						stringBuffer.append(TEXT_262);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_263);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_264);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_265);
					} else if (constraint.equals("Min") && genDataType.getMinLiteral() != null) {
						if (genDataType.isPrimitiveType()) {
							stringBuffer.append(TEXT_266);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_267);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_268);
							stringBuffer.append(genDataType.isMinInclusive() ? ">=" : ">");
							stringBuffer.append(TEXT_269);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_270);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_271);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_272);
							if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_273);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_274);
								stringBuffer.append(genDataType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_275);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_276);
								stringBuffer.append(genDataType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_277);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_278);
								stringBuffer.append(genDataType.isMinInclusive() ? "true" : "false");
								stringBuffer.append(TEXT_279);
								stringBuffer.append(diagnostics);
								stringBuffer.append(TEXT_280);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_281);
							} else {
								stringBuffer.append(TEXT_282);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_283);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_284);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_285);
								stringBuffer.append(genDataType.isMinInclusive() ? "true" : "false");
								stringBuffer.append(TEXT_286);
								stringBuffer.append(diagnostics);
								stringBuffer.append(TEXT_287);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_288);
							}
							stringBuffer.append(TEXT_289);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_290);
						} else {
							String comparison = "comparison".equals(genClassifier.getSafeUncapName()) ? "theComparison" : "comparison";
							if (genDataType.isXMLCalendar()) {
								stringBuffer.append(TEXT_291);
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_292);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
								stringBuffer.append(TEXT_293);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_294);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_295);
								stringBuffer.append(result);
								stringBuffer.append(TEXT_296);
								if (genDataType.isMinInclusive()) {
									stringBuffer.append(comparison);
									stringBuffer.append(TEXT_297);
								}
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_298);
							} else if (genDataType.isXMLDuration()) {
								stringBuffer.append(TEXT_299);
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_300);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
								stringBuffer.append(TEXT_301);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_302);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_303);
								stringBuffer.append(result);
								stringBuffer.append(TEXT_304);
								if (genDataType.isMinInclusive()) {
									stringBuffer.append(comparison);
									stringBuffer.append(TEXT_305);
								}
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_306);
							} else {
								stringBuffer.append(TEXT_307);
								stringBuffer.append(result);
								stringBuffer.append(TEXT_308);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_309);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_310);
								stringBuffer.append(genDataType.isMinInclusive() ? ">=" : ">");
								stringBuffer.append(TEXT_311);
							}
							stringBuffer.append(TEXT_312);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_313);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_314);
							stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_315);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_316);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_317);
							stringBuffer.append(genDataType.isMinInclusive() ? "true" : "false");
							stringBuffer.append(TEXT_318);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_319);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_320);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_321);
						}
					} else if (constraint.equals("Max") && genDataType.getMaxLiteral() != null) {
						if (genDataType.isPrimitiveType()) {
							stringBuffer.append(TEXT_322);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_323);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_324);
							stringBuffer.append(genDataType.isMaxInclusive() ? "<=" : "<");
							stringBuffer.append(TEXT_325);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_326);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_327);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_328);
							if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_329);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_330);
								stringBuffer.append(genDataType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_331);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_332);
								stringBuffer.append(genDataType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_333);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_334);
								stringBuffer.append(genDataType.isMaxInclusive() ? "true" : "false");
								stringBuffer.append(TEXT_335);
								stringBuffer.append(diagnostics);
								stringBuffer.append(TEXT_336);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_337);
							} else {
								stringBuffer.append(TEXT_338);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_339);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_340);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_341);
								stringBuffer.append(genDataType.isMaxInclusive() ? "true" : "false");
								stringBuffer.append(TEXT_342);
								stringBuffer.append(diagnostics);
								stringBuffer.append(TEXT_343);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_344);
							}
							stringBuffer.append(TEXT_345);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_346);
						} else {
							String comparison = "comparison".equals(genClassifier.getSafeUncapName()) ? "theComparison" : "comparison";
							if (genDataType.isXMLCalendar()) {
								stringBuffer.append(TEXT_347);
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_348);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
								stringBuffer.append(TEXT_349);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_350);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_351);
								stringBuffer.append(result);
								stringBuffer.append(TEXT_352);
								if (genDataType.isMaxInclusive()) {
									stringBuffer.append(comparison);
									stringBuffer.append(TEXT_353);
								}
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_354);
							} else if (genDataType.isXMLDuration()) {
								stringBuffer.append(TEXT_355);
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_356);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
								stringBuffer.append(TEXT_357);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_358);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_359);
								stringBuffer.append(result);
								stringBuffer.append(TEXT_360);
								if (genDataType.isMaxInclusive()) {
									stringBuffer.append(comparison);
									stringBuffer.append(TEXT_361);
								}
								stringBuffer.append(comparison);
								stringBuffer.append(TEXT_362);
							} else {
								stringBuffer.append(TEXT_363);
								stringBuffer.append(result);
								stringBuffer.append(TEXT_364);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_365);
								stringBuffer.append(constant);
								stringBuffer.append(TEXT_366);
								stringBuffer.append(genDataType.isMaxInclusive() ? "<=" : "<");
								stringBuffer.append(TEXT_367);
							}
							stringBuffer.append(TEXT_368);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_369);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_370);
							stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_371);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_372);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_373);
							stringBuffer.append(genDataType.isMaxInclusive() ? "true" : "false");
							stringBuffer.append(TEXT_374);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_375);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_376);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_377);
						}
					} else if (constraint.equals("MinLength") && genDataType.getMinLength() != -1) {
						stringBuffer.append(TEXT_378);
						stringBuffer.append(genDataType.getSafeUncapName());
						stringBuffer.append(TEXT_379);
						stringBuffer.append(genDataType.getLengthAccessorFunction());
						stringBuffer.append(TEXT_380);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_381);
						stringBuffer.append(genDataType.getMinLength());
						stringBuffer.append(TEXT_382);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_383);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_384);
						stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
						stringBuffer.append(TEXT_385);
						stringBuffer.append(genDataType.getSafeUncapName());
						stringBuffer.append(TEXT_386);
						stringBuffer.append(genDataType.getMinLength());
						stringBuffer.append(TEXT_387);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_388);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_389);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_390);
					} else if (constraint.equals("MaxLength") && genDataType.getMaxLength() != -1) {
						stringBuffer.append(TEXT_391);
						stringBuffer.append(genDataType.getSafeUncapName());
						stringBuffer.append(TEXT_392);
						stringBuffer.append(genDataType.getLengthAccessorFunction());
						stringBuffer.append(TEXT_393);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_394);
						stringBuffer.append(genDataType.getMaxLength());
						stringBuffer.append(TEXT_395);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_396);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_397);
						stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
						stringBuffer.append(TEXT_398);
						stringBuffer.append(genDataType.getSafeUncapName());
						stringBuffer.append(TEXT_399);
						stringBuffer.append(genDataType.getMaxLength());
						stringBuffer.append(TEXT_400);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_401);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_402);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_403);
					} else if (constraint.equals("TotalDigits") && genDataType.getTotalDigits() != -1) {
						if (genDataType.isPrimitiveType()) {
							stringBuffer.append(TEXT_404);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_405);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_406);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_407);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_408);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_409);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_410);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_411);
							if (genModel.getComplianceLevel().getValue() < GenJDKLevel.JDK50) {
								stringBuffer.append(TEXT_412);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_413);
								stringBuffer.append(genDataType.getObjectInstanceClassName());
								stringBuffer.append(TEXT_414);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_415);
								stringBuffer.append(genDataType.getTotalDigits());
								stringBuffer.append(TEXT_416);
								stringBuffer.append(diagnostics);
								stringBuffer.append(TEXT_417);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_418);
							} else {
								stringBuffer.append(TEXT_419);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_420);
								stringBuffer.append(genDataType.getSafeUncapName());
								stringBuffer.append(TEXT_421);
								stringBuffer.append(genDataType.getTotalDigits());
								stringBuffer.append(TEXT_422);
								stringBuffer.append(diagnostics);
								stringBuffer.append(TEXT_423);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_424);
							}
						} else if ("java.math.BigDecimal".equals(genDataType.getQualifiedInstanceClassName())) {
							stringBuffer.append(TEXT_425);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_426);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_427);
							stringBuffer.append(genDataType.getTotalDigits());
							stringBuffer.append(TEXT_428);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_429);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_430);
							stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_431);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_432);
							stringBuffer.append(genDataType.getTotalDigits());
							stringBuffer.append(TEXT_433);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_434);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_435);
						} else {
							stringBuffer.append(TEXT_436);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_437);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_438);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_439);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_440);
							stringBuffer.append(constant);
							stringBuffer.append(TEXT_441);
							stringBuffer.append(result);
							stringBuffer.append(TEXT_442);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_443);
							stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_444);
							stringBuffer.append(genDataType.getSafeUncapName());
							stringBuffer.append(TEXT_445);
							stringBuffer.append(genDataType.getTotalDigits());
							stringBuffer.append(TEXT_446);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_447);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_448);
						}
						stringBuffer.append(TEXT_449);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_450);
					} else if (constraint.equals("FractionDigits") && genDataType.getFractionDigits() != -1 && "java.math.BigDecimal".equals(genDataType.getQualifiedInstanceClassName())) {
						stringBuffer.append(TEXT_451);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_452);
						stringBuffer.append(genDataType.getSafeUncapName());
						stringBuffer.append(TEXT_453);
						stringBuffer.append(genDataType.getFractionDigits());
						stringBuffer.append(TEXT_454);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_455);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_456);
						stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
						stringBuffer.append(TEXT_457);
						stringBuffer.append(genDataType.getSafeUncapName());
						stringBuffer.append(TEXT_458);
						stringBuffer.append(genDataType.getFractionDigits());
						stringBuffer.append(TEXT_459);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_460);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_461);
						stringBuffer.append(result);
						stringBuffer.append(TEXT_462);
					} else if (constraintDelegate != null) {
						stringBuffer.append(TEXT_463);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_464);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_465);
						if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF24_VALUE) {
							stringBuffer.append(TEXT_466);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
							stringBuffer.append(TEXT_467);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(TEXT_468);
							stringBuffer.append(constraint);
							stringBuffer.append(TEXT_469);
							stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_470);
							stringBuffer.append(genClassifier.getSafeUncapName());
							stringBuffer.append(TEXT_471);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_472);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(TEXT_473);
							stringBuffer.append(genClassifier.getSafeUncapName());
							stringBuffer.append(TEXT_474);
						} else {
							stringBuffer.append(TEXT_475);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
							stringBuffer.append(TEXT_476);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
							stringBuffer.append(TEXT_477);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
							stringBuffer.append(TEXT_478);
							stringBuffer.append(constraint);
							stringBuffer.append(TEXT_479);
							stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_480);
							stringBuffer.append(genClassifier.getSafeUncapName());
							stringBuffer.append(TEXT_481);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_482);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(genModel.getNonNLS(2));
							stringBuffer.append(TEXT_483);
							stringBuffer.append(genClassifier.getSafeUncapName());
							stringBuffer.append(TEXT_484);
						}
						stringBuffer.append(TEXT_485);
						stringBuffer.append(delegate);
						stringBuffer.append(TEXT_486);
						stringBuffer.append(constraintDelegate.getName());
						stringBuffer.append(TEXT_487);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_488);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(accessor);
						stringBuffer.append(TEXT_489);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_490);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_491);
					} else {
						if (genClassifier.hasConstraintExpression(constraint)) {
							stringBuffer.append(TEXT_492);
							stringBuffer.append(genClassifier.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_493);
							stringBuffer.append(genClassifier.getSafeUncapName());
							stringBuffer.append(TEXT_494);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_495);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_496);
							stringBuffer.append(genClassifier.getValidationDelegate(constraint));
							stringBuffer.append(TEXT_497);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(TEXT_498);
							stringBuffer.append(constraint);
							stringBuffer.append(TEXT_499);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(TEXT_500);
							stringBuffer.append(genClassifier.getClassifierID());
							stringBuffer.append(TEXT_501);
							stringBuffer.append(CodeGenUtil.upperName(constraint));
							stringBuffer.append(TEXT_502);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
							stringBuffer.append(TEXT_503);
						} else {
							stringBuffer.append(TEXT_504);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_505);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_506);
							if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF24_VALUE) {
								stringBuffer.append(TEXT_507);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
								stringBuffer.append(TEXT_508);
								stringBuffer.append(genModel.getNonNLS());
								stringBuffer.append(TEXT_509);
								stringBuffer.append(constraint);
								stringBuffer.append(TEXT_510);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_511);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_512);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_513);
								stringBuffer.append(genModel.getNonNLS());
								stringBuffer.append(TEXT_514);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_515);
							} else {
								stringBuffer.append(TEXT_516);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
								stringBuffer.append(TEXT_517);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
								stringBuffer.append(TEXT_518);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
								stringBuffer.append(TEXT_519);
								stringBuffer.append(constraint);
								stringBuffer.append(TEXT_520);
								stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
								stringBuffer.append(TEXT_521);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_522);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_523);
								stringBuffer.append(genModel.getNonNLS());
								stringBuffer.append(genModel.getNonNLS(2));
								stringBuffer.append(TEXT_524);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_525);
							}
							stringBuffer.append(TEXT_526);
						}
					}
				} else if (constraintDelegate != null) {
					stringBuffer.append(TEXT_527);
					stringBuffer.append(diagnostics);
					stringBuffer.append(TEXT_528);
					stringBuffer.append(diagnostics);
					stringBuffer.append(TEXT_529);
					if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF24_VALUE) {
						stringBuffer.append(TEXT_530);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
						stringBuffer.append(TEXT_531);
						stringBuffer.append(genModel.getNonNLS());
						stringBuffer.append(TEXT_532);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_533);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_534);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_535);
						stringBuffer.append(genModel.getNonNLS());
						stringBuffer.append(TEXT_536);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_537);
					} else {
						stringBuffer.append(TEXT_538);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
						stringBuffer.append(TEXT_539);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
						stringBuffer.append(TEXT_540);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
						stringBuffer.append(TEXT_541);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_542);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_543);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_544);
						stringBuffer.append(genModel.getNonNLS());
						stringBuffer.append(genModel.getNonNLS(2));
						stringBuffer.append(TEXT_545);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_546);
					}
					stringBuffer.append(TEXT_547);
					stringBuffer.append(delegate);
					stringBuffer.append(TEXT_548);
					stringBuffer.append(constraintDelegate.getName());
					stringBuffer.append(TEXT_549);
					stringBuffer.append(constraint);
					stringBuffer.append(TEXT_550);
					stringBuffer.append(cast);
					stringBuffer.append(genClassifier.getSafeUncapName());
					stringBuffer.append(TEXT_551);
					stringBuffer.append(diagnostics);
					stringBuffer.append(TEXT_552);
					stringBuffer.append(context);
					stringBuffer.append(TEXT_553);
				} else {
					GenOperation genOperation = ((GenClass) genClassifier).getInvariantOperation(constraint);
					if (genOperation != null) {
						stringBuffer.append(TEXT_554);
						stringBuffer.append(genClassifier.getSafeUncapName());
						stringBuffer.append(TEXT_555);
						stringBuffer.append(constraint);
						stringBuffer.append(TEXT_556);
						stringBuffer.append(diagnostics);
						stringBuffer.append(TEXT_557);
						stringBuffer.append(context);
						stringBuffer.append(TEXT_558);
					} else {
						if (genClassifier.hasConstraintExpression(constraint)) {
							stringBuffer.append(TEXT_559);
							stringBuffer.append(genClassifier.getQualifiedClassifierAccessor());
							stringBuffer.append(TEXT_560);
							stringBuffer.append(genClassifier.getSafeUncapName());
							stringBuffer.append(TEXT_561);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_562);
							stringBuffer.append(context);
							stringBuffer.append(TEXT_563);
							stringBuffer.append(genClassifier.getValidationDelegate(constraint));
							stringBuffer.append(TEXT_564);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(TEXT_565);
							stringBuffer.append(constraint);
							stringBuffer.append(TEXT_566);
							stringBuffer.append(genModel.getNonNLS());
							stringBuffer.append(TEXT_567);
							stringBuffer.append(genClassifier.getClassifierID());
							stringBuffer.append(TEXT_568);
							stringBuffer.append(CodeGenUtil.upperName(constraint));
							stringBuffer.append(TEXT_569);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
							stringBuffer.append(TEXT_570);
						} else {
							stringBuffer.append(TEXT_571);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_572);
							stringBuffer.append(diagnostics);
							stringBuffer.append(TEXT_573);
							if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF24_VALUE) {
								stringBuffer.append(TEXT_574);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
								stringBuffer.append(TEXT_575);
								stringBuffer.append(genModel.getNonNLS());
								stringBuffer.append(TEXT_576);
								stringBuffer.append(constraint);
								stringBuffer.append(TEXT_577);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_578);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_579);
								stringBuffer.append(genModel.getNonNLS());
								stringBuffer.append(TEXT_580);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_581);
							} else {
								stringBuffer.append(TEXT_582);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
								stringBuffer.append(TEXT_583);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
								stringBuffer.append(TEXT_584);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
								stringBuffer.append(TEXT_585);
								stringBuffer.append(constraint);
								stringBuffer.append(TEXT_586);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_587);
								stringBuffer.append(context);
								stringBuffer.append(TEXT_588);
								stringBuffer.append(genModel.getNonNLS());
								stringBuffer.append(genModel.getNonNLS(2));
								stringBuffer.append(TEXT_589);
								stringBuffer.append(genClassifier.getSafeUncapName());
								stringBuffer.append(TEXT_590);
							}
							stringBuffer.append(TEXT_591);
						}
					}
				}
				stringBuffer.append(TEXT_592);
			}
		}
		if (genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF24_VALUE) {
			stringBuffer.append(TEXT_593);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_594);
			}
			stringBuffer.append(TEXT_595);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.ResourceLocator"));
			stringBuffer.append(TEXT_596);
			if (genModel.hasModelPluginClass()) {
				stringBuffer.append(TEXT_597);
				stringBuffer.append(genModel.getImportedName(genModel.getQualifiedModelPluginClassName()));
				stringBuffer.append(TEXT_598);
			} else {
				stringBuffer.append(TEXT_599);
			}
			stringBuffer.append(TEXT_600);
		}
		stringBuffer.append(TEXT_601);
		stringBuffer.append(genPackage.getValidatorClassName());
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_602);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		GenPackage genPackage = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.hasConstraints());
		return canGenerate;
	}
}