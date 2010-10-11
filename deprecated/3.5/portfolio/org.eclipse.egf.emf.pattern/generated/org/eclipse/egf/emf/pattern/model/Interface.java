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

public class Interface extends org.eclipse.egf.emf.pattern.base.GenClassJava {
    protected static String nl;

    public static synchronized Interface create(String lineSeparator) {
        nl = lineSeparator;
        Interface result = new Interface();
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
    protected final String TEXT_8 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A representation of the model object '<em><b>";
    protected final String TEXT_9 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
    protected final String TEXT_10 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
    protected final String TEXT_11 = NL + " * <!-- end-model-doc -->";
    protected final String TEXT_12 = NL + " *";
    protected final String TEXT_13 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * <ul>";
    protected final String TEXT_14 = NL + " *   <li>{@link ";
    protected final String TEXT_15 = "#";
    protected final String TEXT_16 = " <em>";
    protected final String TEXT_17 = "</em>}</li>";
    protected final String TEXT_18 = NL + " * </ul>" + NL + " * </p>";
    protected final String TEXT_19 = NL + " *";
    protected final String TEXT_20 = NL + " * @see ";
    protected final String TEXT_21 = "#get";
    protected final String TEXT_22 = "()";
    protected final String TEXT_23 = NL + " * @model ";
    protected final String TEXT_24 = NL + " *        ";
    protected final String TEXT_25 = NL + " * @model";
    protected final String TEXT_26 = NL + " * @extends ";
    protected final String TEXT_27 = NL + " * @generated" + NL + " */";
    protected final String TEXT_28 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model object '<em><b>";
    protected final String TEXT_29 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
    protected final String TEXT_30 = NL + " * The following features are implemented:" + NL + " * <ul>";
    protected final String TEXT_31 = NL + " *   <li>{@link ";
    protected final String TEXT_32 = "#";
    protected final String TEXT_33 = " <em>";
    protected final String TEXT_34 = "</em>}</li>";
    protected final String TEXT_35 = NL + " * </ul>";
    protected final String TEXT_36 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
    protected final String TEXT_37 = NL + "public";
    protected final String TEXT_38 = " abstract";
    protected final String TEXT_39 = " class ";
    protected final String TEXT_40 = NL + "public interface ";
    protected final String TEXT_41 = NL + "{";
    protected final String TEXT_42 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_43 = " copyright = ";
    protected final String TEXT_44 = ";";
    protected final String TEXT_45 = NL;
    protected final String TEXT_46 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_47 = " mofDriverNumber = \"";
    protected final String TEXT_48 = "\";";
    protected final String TEXT_49 = NL;
    protected final String TEXT_50 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL;
    protected final String TEXT_51 = NL + "\t/**" + NL + "\t * An array of objects representing the values of non-primitive features." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] ";
    protected final String TEXT_52 = ";" + NL;
    protected final String TEXT_53 = NL + "\t/**" + NL + "\t * A bit field representing the indices of non-primitive feature values." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int ";
    protected final String TEXT_54 = ";" + NL;
    protected final String TEXT_55 = NL + "\t/**" + NL + "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
    protected final String TEXT_56 = " = 0;" + NL;
    protected final String TEXT_57 = NL;
    protected final String TEXT_58 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final int ";
    protected final String TEXT_59 = " = ";
    protected final String TEXT_60 = ".getFeatureID(";
    protected final String TEXT_61 = ") - ";
    protected final String TEXT_62 = ";" + NL;
    protected final String TEXT_63 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final int ";
    protected final String TEXT_64 = " = ";
    protected final String TEXT_65 = ".getFeatureID(";
    protected final String TEXT_66 = ") - ";
    protected final String TEXT_67 = ";" + NL;
    protected final String TEXT_68 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
    protected final String TEXT_69 = "public";
    protected final String TEXT_70 = "protected";
    protected final String TEXT_71 = " ";
    protected final String TEXT_72 = "()" + NL + "\t{" + NL + "\t\tsuper();";
    protected final String TEXT_73 = NL + "\t\t";
    protected final String TEXT_74 = " |= ";
    protected final String TEXT_75 = "_EFLAG";
    protected final String TEXT_76 = "_DEFAULT";
    protected final String TEXT_77 = ";";
    protected final String TEXT_78 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_79 = NL + "\t@Override";
    protected final String TEXT_80 = NL + "\tprotected ";
    protected final String TEXT_81 = " eStaticClass()" + NL + "\t{" + NL + "\t\treturn ";
    protected final String TEXT_82 = ";" + NL + "\t}" + NL;
    protected final String TEXT_83 = NL;
    protected final String TEXT_84 = NL;
    protected final String TEXT_85 = NL;
    protected final String TEXT_86 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_87 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_88 = NL + "\t@Override";
    protected final String TEXT_89 = NL + "\tpublic ";
    protected final String TEXT_90 = " eInverseAdd(";
    protected final String TEXT_91 = " otherEnd, int featureID, ";
    protected final String TEXT_92 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID";
    protected final String TEXT_93 = ")" + NL + "\t\t{";
    protected final String TEXT_94 = NL + "\t\t\tcase ";
    protected final String TEXT_95 = ":";
    protected final String TEXT_96 = NL + "\t\t\t\treturn ((";
    protected final String TEXT_97 = "(";
    protected final String TEXT_98 = ".InternalMapView";
    protected final String TEXT_99 = ")";
    protected final String TEXT_100 = "()).eMap()).basicAdd(otherEnd, msgs);";
    protected final String TEXT_101 = NL + "\t\t\t\treturn (";
    protected final String TEXT_102 = "()).basicAdd(otherEnd, msgs);";
    protected final String TEXT_103 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);";
    protected final String TEXT_104 = NL + "\t\t\t\treturn basicSet";
    protected final String TEXT_105 = "((";
    protected final String TEXT_106 = ")otherEnd, msgs);";
    protected final String TEXT_107 = NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
    protected final String TEXT_108 = ", msgs);";
    protected final String TEXT_109 = NL + "\t\t\t\t";
    protected final String TEXT_110 = " ";
    protected final String TEXT_111 = " = (";
    protected final String TEXT_112 = ")eVirtualGet(";
    protected final String TEXT_113 = ");";
    protected final String TEXT_114 = NL + "\t\t\t\t";
    protected final String TEXT_115 = " ";
    protected final String TEXT_116 = " = ";
    protected final String TEXT_117 = "basicGet";
    protected final String TEXT_118 = "();";
    protected final String TEXT_119 = NL + "\t\t\t\tif (";
    protected final String TEXT_120 = " != null)";
    protected final String TEXT_121 = NL + "\t\t\t\t\tmsgs = ((";
    protected final String TEXT_122 = ")";
    protected final String TEXT_123 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
    protected final String TEXT_124 = ", null, msgs);";
    protected final String TEXT_125 = NL + "\t\t\t\t\tmsgs = ((";
    protected final String TEXT_126 = ")";
    protected final String TEXT_127 = ").eInverseRemove(this, ";
    protected final String TEXT_128 = ", ";
    protected final String TEXT_129 = ".class, msgs);";
    protected final String TEXT_130 = NL + "\t\t\t\treturn basicSet";
    protected final String TEXT_131 = "((";
    protected final String TEXT_132 = ")otherEnd, msgs);";
    protected final String TEXT_133 = NL + "\t\t}";
    protected final String TEXT_134 = NL + "\t\treturn super.eInverseAdd(otherEnd, featureID, msgs);";
    protected final String TEXT_135 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, featureID, msgs);";
    protected final String TEXT_136 = NL + "\t}" + NL;
    protected final String TEXT_137 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_138 = NL + "\t@Override";
    protected final String TEXT_139 = NL + "\tpublic ";
    protected final String TEXT_140 = " eInverseRemove(";
    protected final String TEXT_141 = " otherEnd, int featureID, ";
    protected final String TEXT_142 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID";
    protected final String TEXT_143 = ")" + NL + "\t\t{";
    protected final String TEXT_144 = NL + "\t\t\tcase ";
    protected final String TEXT_145 = ":";
    protected final String TEXT_146 = NL + "\t\t\t\treturn ((";
    protected final String TEXT_147 = ")((";
    protected final String TEXT_148 = ".InternalMapView";
    protected final String TEXT_149 = ")";
    protected final String TEXT_150 = "()).eMap()).basicRemove(otherEnd, msgs);";
    protected final String TEXT_151 = NL + "\t\t\t\treturn ((";
    protected final String TEXT_152 = ")((";
    protected final String TEXT_153 = ".Internal.Wrapper)";
    protected final String TEXT_154 = "()).featureMap()).basicRemove(otherEnd, msgs);";
    protected final String TEXT_155 = NL + "\t\t\t\treturn ((";
    protected final String TEXT_156 = ")";
    protected final String TEXT_157 = "()).basicRemove(otherEnd, msgs);";
    protected final String TEXT_158 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
    protected final String TEXT_159 = ", msgs);";
    protected final String TEXT_160 = NL + "\t\t\t\treturn basicUnset";
    protected final String TEXT_161 = "(msgs);";
    protected final String TEXT_162 = NL + "\t\t\t\treturn basicSet";
    protected final String TEXT_163 = "(null, msgs);";
    protected final String TEXT_164 = NL + "\t\t}";
    protected final String TEXT_165 = NL + "\t\treturn super.eInverseRemove(otherEnd, featureID, msgs);";
    protected final String TEXT_166 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, featureID, msgs);";
    protected final String TEXT_167 = NL + "\t}" + NL;
    protected final String TEXT_168 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_169 = NL + "\t@Override";
    protected final String TEXT_170 = NL + "\tpublic ";
    protected final String TEXT_171 = " eBasicRemoveFromContainerFeature(";
    protected final String TEXT_172 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID()";
    protected final String TEXT_173 = ")" + NL + "\t\t{";
    protected final String TEXT_174 = NL + "\t\t\tcase ";
    protected final String TEXT_175 = ":" + NL + "\t\t\t\treturn eInternalContainer().eInverseRemove(this, ";
    protected final String TEXT_176 = ", ";
    protected final String TEXT_177 = ".class, msgs);";
    protected final String TEXT_178 = NL + "\t\t}";
    protected final String TEXT_179 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(msgs);";
    protected final String TEXT_180 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(msgs);";
    protected final String TEXT_181 = NL + "\t}" + NL;
    protected final String TEXT_182 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_183 = NL + "\t@Override";
    protected final String TEXT_184 = NL + "\tpublic Object eGet(int featureID, boolean resolve, boolean coreType)" + NL + "\t{" + NL + "\t\tswitch (featureID";
    protected final String TEXT_185 = ")" + NL + "\t\t{";
    protected final String TEXT_186 = NL + "\t\t\tcase ";
    protected final String TEXT_187 = ":";
    protected final String TEXT_188 = NL + "\t\t\t\treturn ";
    protected final String TEXT_189 = "();";
    protected final String TEXT_190 = NL + "\t\t\t\treturn ";
    protected final String TEXT_191 = "() ? Boolean.TRUE : Boolean.FALSE;";
    protected final String TEXT_192 = NL + "\t\t\t\treturn new ";
    protected final String TEXT_193 = "(";
    protected final String TEXT_194 = "());";
    protected final String TEXT_195 = NL + "\t\t\t\tif (resolve) return ";
    protected final String TEXT_196 = "();" + NL + "\t\t\t\treturn basicGet";
    protected final String TEXT_197 = "();";
    protected final String TEXT_198 = NL + "\t\t\t\tif (coreType) return ((";
    protected final String TEXT_199 = ".InternalMapView";
    protected final String TEXT_200 = ")";
    protected final String TEXT_201 = "()).eMap();" + NL + "\t\t\t\telse return ";
    protected final String TEXT_202 = "();";
    protected final String TEXT_203 = NL + "\t\t\t\tif (coreType) return ";
    protected final String TEXT_204 = "();" + NL + "\t\t\t\telse return ";
    protected final String TEXT_205 = "().map();";
    protected final String TEXT_206 = NL + "\t\t\t\tif (coreType) return ((";
    protected final String TEXT_207 = ".Internal.Wrapper)";
    protected final String TEXT_208 = "()).featureMap();" + NL + "\t\t\t\treturn ";
    protected final String TEXT_209 = "();";
    protected final String TEXT_210 = NL + "\t\t\t\tif (coreType) return ";
    protected final String TEXT_211 = "();" + NL + "\t\t\t\treturn ((";
    protected final String TEXT_212 = ".Internal)";
    protected final String TEXT_213 = "()).getWrapper();";
    protected final String TEXT_214 = NL + "\t\t\t\treturn ";
    protected final String TEXT_215 = "();";
    protected final String TEXT_216 = NL + "\t\t}";
    protected final String TEXT_217 = NL + "\t\treturn super.eGet(featureID, resolve, coreType);";
    protected final String TEXT_218 = NL + "\t\treturn eDynamicGet(featureID, resolve, coreType);";
    protected final String TEXT_219 = NL + "\t}" + NL;
    protected final String TEXT_220 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_221 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_222 = NL + "\t@Override";
    protected final String TEXT_223 = NL + "\tpublic void eSet(int featureID, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (featureID";
    protected final String TEXT_224 = ")" + NL + "\t\t{";
    protected final String TEXT_225 = NL + "\t\t\tcase ";
    protected final String TEXT_226 = ":";
    protected final String TEXT_227 = NL + "\t\t\t\t((";
    protected final String TEXT_228 = ".Internal)((";
    protected final String TEXT_229 = ".Internal.Wrapper)";
    protected final String TEXT_230 = "()).featureMap()).set(newValue);";
    protected final String TEXT_231 = NL + "\t\t\t\t((";
    protected final String TEXT_232 = ".Internal)";
    protected final String TEXT_233 = "()).set(newValue);";
    protected final String TEXT_234 = NL + "\t\t\t\t((";
    protected final String TEXT_235 = ".Setting)((";
    protected final String TEXT_236 = ".InternalMapView";
    protected final String TEXT_237 = ")";
    protected final String TEXT_238 = "()).eMap()).set(newValue);";
    protected final String TEXT_239 = NL + "\t\t\t\t((";
    protected final String TEXT_240 = ".Setting)";
    protected final String TEXT_241 = "()).set(newValue);";
    protected final String TEXT_242 = NL + "\t\t\t\t";
    protected final String TEXT_243 = "().clear();" + NL + "\t\t\t\t";
    protected final String TEXT_244 = "().addAll((";
    protected final String TEXT_245 = "<? extends ";
    protected final String TEXT_246 = ">";
    protected final String TEXT_247 = ")newValue);";
    protected final String TEXT_248 = NL + "\t\t\t\tset";
    protected final String TEXT_249 = "(((";
    protected final String TEXT_250 = ")newValue).";
    protected final String TEXT_251 = "());";
    protected final String TEXT_252 = NL + "\t\t\t\tset";
    protected final String TEXT_253 = "(";
    protected final String TEXT_254 = "(";
    protected final String TEXT_255 = ")";
    protected final String TEXT_256 = "newValue);";
    protected final String TEXT_257 = NL + "\t\t\t\treturn;";
    protected final String TEXT_258 = NL + "\t\t}";
    protected final String TEXT_259 = NL + "\t\tsuper.eSet(featureID, newValue);";
    protected final String TEXT_260 = NL + "\t\teDynamicSet(featureID, newValue);";
    protected final String TEXT_261 = NL + "\t}" + NL;
    protected final String TEXT_262 = NL;
    protected final String TEXT_263 = NL;
    protected final String TEXT_264 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_265 = NL + "\t@Override";
    protected final String TEXT_266 = NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class";
    protected final String TEXT_267 = " baseClass)" + NL + "\t{";
    protected final String TEXT_268 = NL + "\t\tif (baseClass == ";
    protected final String TEXT_269 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID";
    protected final String TEXT_270 = ")" + NL + "\t\t\t{";
    protected final String TEXT_271 = NL + "\t\t\t\tcase ";
    protected final String TEXT_272 = ": return ";
    protected final String TEXT_273 = ";";
    protected final String TEXT_274 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
    protected final String TEXT_275 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}";
    protected final String TEXT_276 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_277 = NL + "\t@Override";
    protected final String TEXT_278 = NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class";
    protected final String TEXT_279 = " baseClass)" + NL + "\t{";
    protected final String TEXT_280 = NL + "\t\tif (baseClass == ";
    protected final String TEXT_281 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
    protected final String TEXT_282 = NL + "\t\t\t\tcase ";
    protected final String TEXT_283 = ": return ";
    protected final String TEXT_284 = ";";
    protected final String TEXT_285 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
    protected final String TEXT_286 = NL + "\t\tif (baseClass == ";
    protected final String TEXT_287 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID";
    protected final String TEXT_288 = ")" + NL + "\t\t\t{";
    protected final String TEXT_289 = NL + "\t\t\t\tcase ";
    protected final String TEXT_290 = ": return ";
    protected final String TEXT_291 = ";";
    protected final String TEXT_292 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
    protected final String TEXT_293 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
    protected final String TEXT_294 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_295 = NL + "\t@Override";
    protected final String TEXT_296 = NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
    protected final String TEXT_297 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_298 = NL + "\t@Override";
    protected final String TEXT_299 = NL + "\tprotected void eSetVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
    protected final String TEXT_300 = " = newValues;" + NL + "\t}" + NL;
    protected final String TEXT_301 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_302 = NL + "\t@Override";
    protected final String TEXT_303 = NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
    protected final String TEXT_304 = NL + "\t\t\tcase ";
    protected final String TEXT_305 = " :" + NL + "\t\t\t\treturn ";
    protected final String TEXT_306 = ";";
    protected final String TEXT_307 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_308 = NL + "\t@Override";
    protected final String TEXT_309 = NL + "\tprotected void eSetVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
    protected final String TEXT_310 = NL + "\t\t\tcase ";
    protected final String TEXT_311 = " :" + NL + "\t\t\t\t";
    protected final String TEXT_312 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
    protected final String TEXT_313 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
    protected final String TEXT_314 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_315 = NL + "\t@Override";
    protected final String TEXT_316 = NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (eIsProxy()) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
    protected final String TEXT_317 = NL + "\t\tresult.append(\" (";
    protected final String TEXT_318 = ": \");";
    protected final String TEXT_319 = NL + "\t\tresult.append(\", ";
    protected final String TEXT_320 = ": \");";
    protected final String TEXT_321 = NL + "\t\tif (eVirtualIsSet(";
    protected final String TEXT_322 = ")) result.append(eVirtualGet(";
    protected final String TEXT_323 = ")); else result.append(\"<unset>\");";
    protected final String TEXT_324 = NL + "\t\tif (";
    protected final String TEXT_325 = "(";
    protected final String TEXT_326 = " & ";
    protected final String TEXT_327 = "_ESETFLAG) != 0";
    protected final String TEXT_328 = "ESet";
    protected final String TEXT_329 = ") result.append((";
    protected final String TEXT_330 = " & ";
    protected final String TEXT_331 = "_EFLAG) != 0); else result.append(\"<unset>\");";
    protected final String TEXT_332 = NL + "\t\tif (";
    protected final String TEXT_333 = "(";
    protected final String TEXT_334 = " & ";
    protected final String TEXT_335 = "_ESETFLAG) != 0";
    protected final String TEXT_336 = "ESet";
    protected final String TEXT_337 = ") result.append(";
    protected final String TEXT_338 = "_EFLAG_VALUES[(";
    protected final String TEXT_339 = " & ";
    protected final String TEXT_340 = "_EFLAG) >>> ";
    protected final String TEXT_341 = "_EFLAG_OFFSET]); else result.append(\"<unset>\");";
    protected final String TEXT_342 = NL + "\t\tif (";
    protected final String TEXT_343 = "(";
    protected final String TEXT_344 = " & ";
    protected final String TEXT_345 = "_ESETFLAG) != 0";
    protected final String TEXT_346 = "ESet";
    protected final String TEXT_347 = ") result.append(";
    protected final String TEXT_348 = "); else result.append(\"<unset>\");";
    protected final String TEXT_349 = NL + "\t\tresult.append(eVirtualGet(";
    protected final String TEXT_350 = ", ";
    protected final String TEXT_351 = "));";
    protected final String TEXT_352 = NL + "\t\tresult.append((";
    protected final String TEXT_353 = " & ";
    protected final String TEXT_354 = "_EFLAG) != 0);";
    protected final String TEXT_355 = NL + "\t\tresult.append(";
    protected final String TEXT_356 = "_EFLAG_VALUES[(";
    protected final String TEXT_357 = " & ";
    protected final String TEXT_358 = "_EFLAG) >>> ";
    protected final String TEXT_359 = "_EFLAG_OFFSET]);";
    protected final String TEXT_360 = NL + "\t\tresult.append(";
    protected final String TEXT_361 = ");";
    protected final String TEXT_362 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
    protected final String TEXT_363 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\t";
    protected final String TEXT_364 = " theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_365 = " getKey()" + NL + "\t{";
    protected final String TEXT_366 = NL + "\t\treturn new ";
    protected final String TEXT_367 = "(getTypedKey());";
    protected final String TEXT_368 = NL + "\t\treturn getTypedKey();";
    protected final String TEXT_369 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(";
    protected final String TEXT_370 = " key)" + NL + "\t{";
    protected final String TEXT_371 = NL + "\t\tgetTypedKey().addAll(";
    protected final String TEXT_372 = "(";
    protected final String TEXT_373 = ")";
    protected final String TEXT_374 = "key);";
    protected final String TEXT_375 = NL + "\t\tsetTypedKey(key);";
    protected final String TEXT_376 = NL + "\t\tsetTypedKey(((";
    protected final String TEXT_377 = ")key).";
    protected final String TEXT_378 = "());";
    protected final String TEXT_379 = NL + "\t\tsetTypedKey((";
    protected final String TEXT_380 = ")key);";
    protected final String TEXT_381 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_382 = " getValue()" + NL + "\t{";
    protected final String TEXT_383 = NL + "\t\treturn new ";
    protected final String TEXT_384 = "(getTypedValue());";
    protected final String TEXT_385 = NL + "\t\treturn getTypedValue();";
    protected final String TEXT_386 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_387 = " setValue(";
    protected final String TEXT_388 = " value)" + NL + "\t{" + NL + "\t\t";
    protected final String TEXT_389 = " oldValue = getValue();";
    protected final String TEXT_390 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll(";
    protected final String TEXT_391 = "(";
    protected final String TEXT_392 = ")";
    protected final String TEXT_393 = "value);";
    protected final String TEXT_394 = NL + "\t\tsetTypedValue(value);";
    protected final String TEXT_395 = NL + "\t\tsetTypedValue(((";
    protected final String TEXT_396 = ")value).";
    protected final String TEXT_397 = "());";
    protected final String TEXT_398 = NL + "\t\tsetTypedValue((";
    protected final String TEXT_399 = ")value);";
    protected final String TEXT_400 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_401 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_402 = NL + "\tpublic ";
    protected final String TEXT_403 = " getEMap()" + NL + "\t{" + NL + "\t\t";
    protected final String TEXT_404 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
    protected final String TEXT_405 = ")container.eGet(eContainmentFeature());" + NL + "\t}" + NL;
    protected final String TEXT_406 = NL;
    protected final String TEXT_407 = NL + "} //";
    protected final String TEXT_408 = NL;
    protected final String TEXT_409 = NL;
    protected final String TEXT_410 = NL;

    public Interface() {
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

        stringBuffer.append(TEXT_409);
        stringBuffer.append(TEXT_410);
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
        targetPath = genClass.getGenModel().getModelDirectory();
        packageName = genClass.getGenPackage().getInterfacePackageName();
        className = genClass.getInterfaceName();

    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenClass genClass = parameter;
        argument = ((Object[]) new Object[] { new Object[] { genClass, Boolean.TRUE, Boolean.FALSE } })[0];

    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

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

        final GenClass genClass = (GenClass) ((Object[]) argument)[0];
        final GenPackage genPackage = genClass.getGenPackage();
        final GenModel genModel = genPackage.getGenModel();
        final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
        final boolean isInterface = Boolean.TRUE.equals(((Object[]) argument)[1]);
        final boolean isImplementation = Boolean.TRUE.equals(((Object[]) argument)[2]);
        final String publicStaticFinalFlag = isImplementation ? "public static final " : "";
        final String singleWildcard = isJDK50 ? "<?>" : "";
        final String negativeOffsetCorrection = genClass.hasOffsetCorrection() ? " - " + genClass.getOffsetCorrectionField(null) : "";
        final String positiveOffsetCorrection = genClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(null) : "";
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        if (isInterface) {
            stringBuffer.append(TEXT_2);
            stringBuffer.append(genPackage.getInterfacePackageName());
            stringBuffer.append(TEXT_3);
        } else {
            stringBuffer.append(TEXT_4);
            stringBuffer.append(genPackage.getClassPackageName());
            stringBuffer.append(TEXT_5);
        }
        stringBuffer.append(TEXT_6);
        genModel.markImportLocation(stringBuffer, genPackage);
        if (isImplementation) {
            genClass.addClassPsuedoImports();
        }
        stringBuffer.append(TEXT_7);
        if (isInterface) {
            stringBuffer.append(TEXT_8);
            stringBuffer.append(genClass.getFormattedName());
            stringBuffer.append(TEXT_9);
            if (genClass.hasDocumentation()) {
                stringBuffer.append(TEXT_10);
                stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
                stringBuffer.append(TEXT_11);
            }
            stringBuffer.append(TEXT_12);
            if (!genClass.getGenFeatures().isEmpty()) {
                stringBuffer.append(TEXT_13);
                for (GenFeature genFeature : genClass.getGenFeatures()) {
                    if (!genFeature.isSuppressedGetVisibility()) {
                        stringBuffer.append(TEXT_14);
                        stringBuffer.append(genClass.getQualifiedInterfaceName());
                        stringBuffer.append(TEXT_15);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_16);
                        stringBuffer.append(genFeature.getFormattedName());
                        stringBuffer.append(TEXT_17);
                    }
                }
                stringBuffer.append(TEXT_18);
            }
            stringBuffer.append(TEXT_19);
            if (!genModel.isSuppressEMFMetaData()) {
                stringBuffer.append(TEXT_20);
                stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
                stringBuffer.append(TEXT_21);
                stringBuffer.append(genClass.getClassifierAccessorName());
                stringBuffer.append(TEXT_22);
            }
            if (!genModel.isSuppressEMFModelTags()) {
                boolean first = true;
                for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens();) {
                    String modelInfo = stringTokenizer.nextToken();
                    if (first) {
                        first = false;
                        stringBuffer.append(TEXT_23);
                        stringBuffer.append(modelInfo);
                    } else {
                        stringBuffer.append(TEXT_24);
                        stringBuffer.append(modelInfo);
                    }
                }
                if (first) {
                    stringBuffer.append(TEXT_25);
                }
            }
            if (genClass.needsRootExtendsInterfaceExtendsTag()) {
                stringBuffer.append(TEXT_26);
                stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
            }
            stringBuffer.append(TEXT_27);
        } else {
            stringBuffer.append(TEXT_28);
            stringBuffer.append(genClass.getFormattedName());
            stringBuffer.append(TEXT_29);
            if (!genClass.getImplementedGenFeatures().isEmpty()) {
                stringBuffer.append(TEXT_30);
                for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
                    stringBuffer.append(TEXT_31);
                    stringBuffer.append(genClass.getQualifiedClassName());
                    stringBuffer.append(TEXT_32);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_33);
                    stringBuffer.append(genFeature.getFormattedName());
                    stringBuffer.append(TEXT_34);
                }
                stringBuffer.append(TEXT_35);
            }
            stringBuffer.append(TEXT_36);
        }
        if (isImplementation) {
            stringBuffer.append(TEXT_37);
            if (genClass.isAbstract()) {
                stringBuffer.append(TEXT_38);
            }
            stringBuffer.append(TEXT_39);
            stringBuffer.append(genClass.getClassName());
            stringBuffer.append(genClass.getTypeParameters().trim());
            stringBuffer.append(genClass.getClassExtends());
            stringBuffer.append(genClass.getClassImplements());
        } else {
            stringBuffer.append(TEXT_40);
            stringBuffer.append(genClass.getInterfaceName());
            stringBuffer.append(genClass.getTypeParameters().trim());
            stringBuffer.append(genClass.getInterfaceExtends());
        }
        stringBuffer.append(TEXT_41);
        if (genModel.hasCopyrightField()) {
            stringBuffer.append(TEXT_42);
            stringBuffer.append(publicStaticFinalFlag);
            stringBuffer.append(genModel.getImportedName("java.lang.String"));
            stringBuffer.append(TEXT_43);
            stringBuffer.append(genModel.getCopyrightFieldLiteral());
            stringBuffer.append(TEXT_44);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_45);
        }
        if (isImplementation && genModel.getDriverNumber() != null) {
            stringBuffer.append(TEXT_46);
            stringBuffer.append(genModel.getImportedName("java.lang.String"));
            stringBuffer.append(TEXT_47);
            stringBuffer.append(genModel.getDriverNumber());
            stringBuffer.append(TEXT_48);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_49);
        }
        if (isImplementation && genClass.isJavaIOSerializable()) {
            stringBuffer.append(TEXT_50);
        }
        if (isImplementation && genModel.isVirtualDelegation()) {
            String eVirtualValuesField = genClass.getEVirtualValuesField();
            if (eVirtualValuesField != null) {
                stringBuffer.append(TEXT_51);
                stringBuffer.append(eVirtualValuesField);
                stringBuffer.append(TEXT_52);
            }
            {
                List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
                if (!eVirtualIndexBitFields.isEmpty()) {
                    for (String eVirtualIndexBitField : eVirtualIndexBitFields) {
                        stringBuffer.append(TEXT_53);
                        stringBuffer.append(eVirtualIndexBitField);
                        stringBuffer.append(TEXT_54);
                    }
                }
            }
        }
        if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
            stringBuffer.append(TEXT_55);
            stringBuffer.append(genModel.getBooleanFlagsField());
            stringBuffer.append(TEXT_56);
        }
        if (isImplementation && !genModel.isReflectiveDelegation()) {
            for (GenFeature genFeature : genClass.getDeclaredFieldGenFeatures()) {
                stringBuffer.append(TEXT_57);
                {
                    //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.declaredFieldGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                    final Map<String, Object> callParameters = new HashMap<String, Object>();
                    callParameters.put("genFeature", genFeature);
                    callParameters.put("genClass", genClass);
                    callParameters.put("genPackage", genPackage);
                    callParameters.put("genModel", genModel);
                    callParameters.put("isJDK50", isJDK50);
                    callParameters.put("isInterface", isInterface);
                    callParameters.put("isImplementation", isImplementation);
                    callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                    callParameters.put("singleWildcard", singleWildcard);
                    callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                    callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                    CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0u0bgWJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                }

                //Class/declaredFieldGenFeature.override.javajetinc
            }
        }
        if (isImplementation && genClass.hasOffsetCorrection() && !genClass.getImplementedGenFeatures().isEmpty()) {
            stringBuffer.append(TEXT_58);
            stringBuffer.append(genClass.getOffsetCorrectionField(null));
            stringBuffer.append(TEXT_59);
            stringBuffer.append(genClass.getQualifiedClassifierAccessor());
            stringBuffer.append(TEXT_60);
            stringBuffer.append(genClass.getImplementedGenFeatures().get(0).getQualifiedFeatureAccessor());
            stringBuffer.append(TEXT_61);
            stringBuffer.append(genClass.getQualifiedFeatureID(genClass.getImplementedGenFeatures().get(0)));
            stringBuffer.append(TEXT_62);
        }
        if (isImplementation && genClass.hasOffsetCorrection() && !genModel.isReflectiveDelegation()) {
            for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
                GenFeature reverseFeature = genFeature.getReverse();
                if (reverseFeature != null && reverseFeature.getGenClass().hasOffsetCorrection()) {
                    stringBuffer.append(TEXT_63);
                    stringBuffer.append(genClass.getOffsetCorrectionField(genFeature));
                    stringBuffer.append(TEXT_64);
                    stringBuffer.append(reverseFeature.getGenClass().getQualifiedClassifierAccessor());
                    stringBuffer.append(TEXT_65);
                    stringBuffer.append(reverseFeature.getQualifiedFeatureAccessor());
                    stringBuffer.append(TEXT_66);
                    stringBuffer.append(reverseFeature.getGenClass().getQualifiedFeatureID(reverseFeature));
                    stringBuffer.append(TEXT_67);
                }
            }
        }
        if (isImplementation) {
            stringBuffer.append(TEXT_68);
            if (genModel.isPublicConstructors()) {
                stringBuffer.append(TEXT_69);
            } else {
                stringBuffer.append(TEXT_70);
            }
            stringBuffer.append(TEXT_71);
            stringBuffer.append(genClass.getClassName());
            stringBuffer.append(TEXT_72);
            for (GenFeature genFeature : genClass.getFlagGenFeaturesWithDefault()) {
                stringBuffer.append(TEXT_73);
                stringBuffer.append(genClass.getFlagsField(genFeature));
                stringBuffer.append(TEXT_74);
                stringBuffer.append(genFeature.getUpperName());
                stringBuffer.append(TEXT_75);
                if (!genFeature.isBooleanType()) {
                    stringBuffer.append(TEXT_76);
                }
                stringBuffer.append(TEXT_77);
            }
            stringBuffer.append(TEXT_78);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_79);
            }
            stringBuffer.append(TEXT_80);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
            stringBuffer.append(TEXT_81);
            stringBuffer.append(genClass.getQualifiedClassifierAccessor());
            stringBuffer.append(TEXT_82);
        }
        stringBuffer.append(TEXT_83);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.reflectiveDelegation.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genClass", genClass);
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            callParameters.put("isJDK50", isJDK50);
            callParameters.put("isInterface", isInterface);
            callParameters.put("isImplementation", isImplementation);
            callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
            callParameters.put("singleWildcard", singleWildcard);
            callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
            callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vQgYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        //Class/reflectiveDelegation.override.javajetinc
        new Runnable() {
            public void run() {
                for (GenFeature genFeature : (isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures())) {
                    stringBuffer.append(TEXT_84);
                    {
                        //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.genFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                        final Map<String, Object> callParameters = new HashMap<String, Object>();
                        callParameters.put("genFeature", genFeature);
                        callParameters.put("genClass", genClass);
                        callParameters.put("genPackage", genPackage);
                        callParameters.put("genModel", genModel);
                        callParameters.put("isJDK50", isJDK50);
                        callParameters.put("isInterface", isInterface);
                        callParameters.put("isImplementation", isImplementation);
                        callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                        callParameters.put("singleWildcard", singleWildcard);
                        callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                        callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                        CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vaRYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                    }

                    //Class/genFeature.override.javajetinc
                }//for
            }
        }.run();
        for (GenOperation genOperation : (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations())) {
            stringBuffer.append(TEXT_85);
            {
                //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.genOperation.override" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genOperation", genOperation);
                callParameters.put("genClass", genClass);
                callParameters.put("genPackage", genPackage);
                callParameters.put("genModel", genModel);
                callParameters.put("isJDK50", isJDK50);
                callParameters.put("isInterface", isInterface);
                callParameters.put("isImplementation", isImplementation);
                callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                callParameters.put("singleWildcard", singleWildcard);
                callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_01-MYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //Class/implementedGenOperation.override.javajetinc
        }//for
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
            stringBuffer.append(TEXT_86);
            if (genModel.useGenerics()) {
                for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
                    if (genFeature.isUncheckedCast(genClass)) {
                        stringBuffer.append(TEXT_87);
                        break;
                    }
                }
            }
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_88);
            }
            stringBuffer.append(TEXT_89);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
            stringBuffer.append(TEXT_90);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
            stringBuffer.append(TEXT_91);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
            stringBuffer.append(TEXT_92);
            stringBuffer.append(negativeOffsetCorrection);
            stringBuffer.append(TEXT_93);
            for (GenFeature genFeature : genClass.getEInverseAddGenFeatures()) {
                stringBuffer.append(TEXT_94);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(TEXT_95);
                if (genFeature.isListType()) {
                    String cast = "(" + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList") + (!genModel.useGenerics() ? ")" : "<" + genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject") + ">)(" + genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList") + "<?>)");
                    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
                        stringBuffer.append(TEXT_96);
                        stringBuffer.append(cast);
                        stringBuffer.append(TEXT_97);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
                        stringBuffer.append(TEXT_98);
                        stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
                        stringBuffer.append(TEXT_99);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_100);
                    } else {
                        stringBuffer.append(TEXT_101);
                        stringBuffer.append(cast);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_102);
                    }
                } else if (genFeature.isContainer()) {
                    stringBuffer.append(TEXT_103);
                    if (genFeature.isBasicSet()) {
                        stringBuffer.append(TEXT_104);
                        stringBuffer.append(genFeature.getAccessorName());
                        stringBuffer.append(TEXT_105);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_106);
                    } else {
                        stringBuffer.append(TEXT_107);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_108);
                    }
                } else {
                    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
                        stringBuffer.append(TEXT_109);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_110);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_111);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_112);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_113);
                    } else if (genFeature.isVolatile() || genClass.getImplementingGenModel(genFeature).isDynamicDelegation()) {
                        stringBuffer.append(TEXT_114);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_115);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_116);
                        if (genFeature.isResolveProxies()) {
                            stringBuffer.append(TEXT_117);
                            stringBuffer.append(genFeature.getAccessorName());
                        } else {
                            stringBuffer.append(genFeature.getGetAccessor());
                        }
                        stringBuffer.append(TEXT_118);
                    }
                    stringBuffer.append(TEXT_119);
                    stringBuffer.append(genFeature.getSafeName());
                    stringBuffer.append(TEXT_120);
                    if (genFeature.isEffectiveContains()) {
                        stringBuffer.append(TEXT_121);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
                        stringBuffer.append(TEXT_122);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_123);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(negativeOffsetCorrection);
                        stringBuffer.append(TEXT_124);
                    } else {
                        GenFeature reverseFeature = genFeature.getReverse();
                        GenClass targetClass = reverseFeature.getGenClass();
                        String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
                        stringBuffer.append(TEXT_125);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
                        stringBuffer.append(TEXT_126);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_127);
                        stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
                        stringBuffer.append(reverseOffsetCorrection);
                        stringBuffer.append(TEXT_128);
                        stringBuffer.append(targetClass.getRawImportedInterfaceName());
                        stringBuffer.append(TEXT_129);
                    }
                    stringBuffer.append(TEXT_130);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_131);
                    stringBuffer.append(genFeature.getImportedType(genClass));
                    stringBuffer.append(TEXT_132);
                }
            }
            stringBuffer.append(TEXT_133);
            if (genModel.isMinimalReflectiveMethods()) {
                stringBuffer.append(TEXT_134);
            } else {
                stringBuffer.append(TEXT_135);
            }
            stringBuffer.append(TEXT_136);
        }
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
            stringBuffer.append(TEXT_137);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_138);
            }
            stringBuffer.append(TEXT_139);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
            stringBuffer.append(TEXT_140);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
            stringBuffer.append(TEXT_141);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
            stringBuffer.append(TEXT_142);
            stringBuffer.append(negativeOffsetCorrection);
            stringBuffer.append(TEXT_143);
            for (GenFeature genFeature : genClass.getEInverseRemoveGenFeatures()) {
                stringBuffer.append(TEXT_144);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(TEXT_145);
                if (genFeature.isListType()) {
                    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
                        stringBuffer.append(TEXT_146);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
                        stringBuffer.append(singleWildcard);
                        stringBuffer.append(TEXT_147);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
                        stringBuffer.append(TEXT_148);
                        stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
                        stringBuffer.append(TEXT_149);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_150);
                    } else if (genFeature.isWrappedFeatureMapType()) {
                        stringBuffer.append(TEXT_151);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
                        stringBuffer.append(singleWildcard);
                        stringBuffer.append(TEXT_152);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                        stringBuffer.append(TEXT_153);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_154);
                    } else {
                        stringBuffer.append(TEXT_155);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
                        stringBuffer.append(singleWildcard);
                        stringBuffer.append(TEXT_156);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_157);
                    }
                } else if (genFeature.isContainer() && !genFeature.isBasicSet()) {
                    stringBuffer.append(TEXT_158);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(positiveOffsetCorrection);
                    stringBuffer.append(TEXT_159);
                } else if (genFeature.isUnsettable()) {
                    stringBuffer.append(TEXT_160);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_161);
                } else {
                    stringBuffer.append(TEXT_162);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_163);
                }
            }
            stringBuffer.append(TEXT_164);
            if (genModel.isMinimalReflectiveMethods()) {
                stringBuffer.append(TEXT_165);
            } else {
                stringBuffer.append(TEXT_166);
            }
            stringBuffer.append(TEXT_167);
        }
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
            stringBuffer.append(TEXT_168);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_169);
            }
            stringBuffer.append(TEXT_170);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
            stringBuffer.append(TEXT_171);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
            stringBuffer.append(TEXT_172);
            stringBuffer.append(negativeOffsetCorrection);
            stringBuffer.append(TEXT_173);
            for (GenFeature genFeature : genClass.getEBasicRemoveFromContainerGenFeatures()) {
                GenFeature reverseFeature = genFeature.getReverse();
                GenClass targetClass = reverseFeature.getGenClass();
                String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
                stringBuffer.append(TEXT_174);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(TEXT_175);
                stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
                stringBuffer.append(reverseOffsetCorrection);
                stringBuffer.append(TEXT_176);
                stringBuffer.append(targetClass.getRawImportedInterfaceName());
                stringBuffer.append(TEXT_177);
            }
            stringBuffer.append(TEXT_178);
            if (genModel.isMinimalReflectiveMethods()) {
                stringBuffer.append(TEXT_179);
            } else {
                stringBuffer.append(TEXT_180);
            }
            stringBuffer.append(TEXT_181);
        }
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEGetGenFeatures())) {
            stringBuffer.append(TEXT_182);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_183);
            }
            stringBuffer.append(TEXT_184);
            stringBuffer.append(negativeOffsetCorrection);
            stringBuffer.append(TEXT_185);
            for (GenFeature genFeature : genClass.getEGetGenFeatures()) {
                stringBuffer.append(TEXT_186);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(TEXT_187);
                if (genFeature.isPrimitiveType()) {
                    if (isJDK50) {
                        stringBuffer.append(TEXT_188);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_189);
                    } else if (genFeature.isBooleanType()) {
                        stringBuffer.append(TEXT_190);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_191);
                    } else {
                        stringBuffer.append(TEXT_192);
                        stringBuffer.append(genFeature.getObjectType(genClass));
                        stringBuffer.append(TEXT_193);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_194);
                    }
                } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
                    stringBuffer.append(TEXT_195);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_196);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_197);
                } else if (genFeature.isMapType()) {
                    if (genFeature.isEffectiveSuppressEMFTypes()) {
                        stringBuffer.append(TEXT_198);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
                        stringBuffer.append(TEXT_199);
                        stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
                        stringBuffer.append(TEXT_200);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_201);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_202);
                    } else {
                        stringBuffer.append(TEXT_203);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_204);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_205);
                    }
                } else if (genFeature.isWrappedFeatureMapType()) {
                    stringBuffer.append(TEXT_206);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                    stringBuffer.append(TEXT_207);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_208);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_209);
                } else if (genFeature.isFeatureMapType()) {
                    stringBuffer.append(TEXT_210);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_211);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                    stringBuffer.append(TEXT_212);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_213);
                } else {
                    stringBuffer.append(TEXT_214);
                    stringBuffer.append(genFeature.getGetAccessor());
                    stringBuffer.append(TEXT_215);
                }
            }
            stringBuffer.append(TEXT_216);
            if (genModel.isMinimalReflectiveMethods()) {
                stringBuffer.append(TEXT_217);
            } else {
                stringBuffer.append(TEXT_218);
            }
            stringBuffer.append(TEXT_219);
        }
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
            stringBuffer.append(TEXT_220);
            if (genModel.useGenerics()) {
                for (GenFeature genFeature : genClass.getESetGenFeatures()) {
                    if (genFeature.isUncheckedCast(genClass) && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
                        stringBuffer.append(TEXT_221);
                        break;
                    }
                }
            }
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_222);
            }
            stringBuffer.append(TEXT_223);
            stringBuffer.append(negativeOffsetCorrection);
            stringBuffer.append(TEXT_224);
            for (GenFeature genFeature : genClass.getESetGenFeatures()) {
                stringBuffer.append(TEXT_225);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(TEXT_226);
                if (genFeature.isListType()) {
                    if (genFeature.isWrappedFeatureMapType()) {
                        stringBuffer.append(TEXT_227);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                        stringBuffer.append(TEXT_228);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                        stringBuffer.append(TEXT_229);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_230);
                    } else if (genFeature.isFeatureMapType()) {
                        stringBuffer.append(TEXT_231);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                        stringBuffer.append(TEXT_232);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_233);
                    } else if (genFeature.isMapType()) {
                        if (genFeature.isEffectiveSuppressEMFTypes()) {
                            stringBuffer.append(TEXT_234);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
                            stringBuffer.append(TEXT_235);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
                            stringBuffer.append(TEXT_236);
                            stringBuffer.append(genFeature.getImportedMapTemplateArguments(genClass));
                            stringBuffer.append(TEXT_237);
                            stringBuffer.append(genFeature.getGetAccessor());
                            stringBuffer.append(TEXT_238);
                        } else {
                            stringBuffer.append(TEXT_239);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
                            stringBuffer.append(TEXT_240);
                            stringBuffer.append(genFeature.getGetAccessor());
                            stringBuffer.append(TEXT_241);
                        }
                    } else {
                        stringBuffer.append(TEXT_242);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_243);
                        stringBuffer.append(genFeature.getGetAccessor());
                        stringBuffer.append(TEXT_244);
                        stringBuffer.append(genModel.getImportedName("java.util.Collection"));
                        if (isJDK50) {
                            stringBuffer.append(TEXT_245);
                            stringBuffer.append(genFeature.getListItemType(genClass));
                            stringBuffer.append(TEXT_246);
                        }
                        stringBuffer.append(TEXT_247);
                    }
                } else if (!isJDK50 && genFeature.isPrimitiveType()) {
                    stringBuffer.append(TEXT_248);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_249);
                    stringBuffer.append(genFeature.getObjectType(genClass));
                    stringBuffer.append(TEXT_250);
                    stringBuffer.append(genFeature.getPrimitiveValueFunction());
                    stringBuffer.append(TEXT_251);
                } else {
                    stringBuffer.append(TEXT_252);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_253);
                    if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType() || !genFeature.getRawType().equals(genFeature.getType(genClass))) {
                        stringBuffer.append(TEXT_254);
                        stringBuffer.append(genFeature.getObjectType(genClass));
                        stringBuffer.append(TEXT_255);
                    }
                    stringBuffer.append(TEXT_256);
                }
                stringBuffer.append(TEXT_257);
            }
            stringBuffer.append(TEXT_258);
            if (genModel.isMinimalReflectiveMethods()) {
                stringBuffer.append(TEXT_259);
            } else {
                stringBuffer.append(TEXT_260);
            }
            stringBuffer.append(TEXT_261);
        }
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEUnsetGenFeatures())) {
            stringBuffer.append(TEXT_262);
            {
                //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.eUnset.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genClass", genClass);
                callParameters.put("genPackage", genPackage);
                callParameters.put("genModel", genModel);
                callParameters.put("isJDK50", isJDK50);
                callParameters.put("isInterface", isInterface);
                callParameters.put("isImplementation", isImplementation);
                callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                callParameters.put("singleWildcard", singleWildcard);
                callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03KfMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //Class/eUnset.override.javajetinc
        }
        if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEIsSetGenFeatures())) {
            stringBuffer.append(TEXT_263);
            {
                //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.eIsSet.override" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genClass", genClass);
                callParameters.put("genPackage", genPackage);
                callParameters.put("genModel", genModel);
                callParameters.put("isJDK50", isJDK50);
                callParameters.put("isInterface", isInterface);
                callParameters.put("isImplementation", isImplementation);
                callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                callParameters.put("singleWildcard", singleWildcard);
                callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03TpIGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //Class/eIsSet.override.javajetinc
        }
        if (isImplementation && (!genClass.getMixinGenFeatures().isEmpty() || genClass.hasOffsetCorrection() && !genClass.getGenFeatures().isEmpty())) {
            if (!genClass.getMixinGenFeatures().isEmpty()) {
                stringBuffer.append(TEXT_264);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_265);
                }
                stringBuffer.append(TEXT_266);
                stringBuffer.append(singleWildcard);
                stringBuffer.append(TEXT_267);
                for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
                    stringBuffer.append(TEXT_268);
                    stringBuffer.append(mixinGenClass.getRawImportedInterfaceName());
                    stringBuffer.append(TEXT_269);
                    stringBuffer.append(negativeOffsetCorrection);
                    stringBuffer.append(TEXT_270);
                    for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
                        stringBuffer.append(TEXT_271);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(TEXT_272);
                        stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(TEXT_273);
                    }
                    stringBuffer.append(TEXT_274);
                }
                stringBuffer.append(TEXT_275);
            }
            stringBuffer.append(TEXT_276);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_277);
            }
            stringBuffer.append(TEXT_278);
            stringBuffer.append(singleWildcard);
            stringBuffer.append(TEXT_279);
            for (GenClass mixinGenClass : genClass.getMixinGenClasses()) {
                stringBuffer.append(TEXT_280);
                stringBuffer.append(mixinGenClass.getRawImportedInterfaceName());
                stringBuffer.append(TEXT_281);
                for (GenFeature genFeature : mixinGenClass.getGenFeatures()) {
                    stringBuffer.append(TEXT_282);
                    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(TEXT_283);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(positiveOffsetCorrection);
                    stringBuffer.append(TEXT_284);
                }
                stringBuffer.append(TEXT_285);
            }
            if (genClass.hasOffsetCorrection() && !genClass.getGenFeatures().isEmpty()) {
                stringBuffer.append(TEXT_286);
                stringBuffer.append(genClass.getRawImportedInterfaceName());
                stringBuffer.append(TEXT_287);
                stringBuffer.append(negativeOffsetCorrection);
                stringBuffer.append(TEXT_288);
                for (GenFeature genFeature : genClass.getGenFeatures()) {
                    stringBuffer.append(TEXT_289);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(TEXT_290);
                    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                    stringBuffer.append(positiveOffsetCorrection);
                    stringBuffer.append(TEXT_291);
                }
                stringBuffer.append(TEXT_292);
            }
            stringBuffer.append(TEXT_293);
        }
        if (isImplementation && genModel.isVirtualDelegation()) {
            String eVirtualValuesField = genClass.getEVirtualValuesField();
            if (eVirtualValuesField != null) {
                stringBuffer.append(TEXT_294);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_295);
                }
                stringBuffer.append(TEXT_296);
                stringBuffer.append(eVirtualValuesField);
                stringBuffer.append(TEXT_297);
                if (genModel.useClassOverrideAnnotation()) {
                    stringBuffer.append(TEXT_298);
                }
                stringBuffer.append(TEXT_299);
                stringBuffer.append(eVirtualValuesField);
                stringBuffer.append(TEXT_300);
            }
            {
                List<String> eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList<String>());
                if (!eVirtualIndexBitFields.isEmpty()) {
                    List<String> allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList<String>());
                    stringBuffer.append(TEXT_301);
                    if (genModel.useClassOverrideAnnotation()) {
                        stringBuffer.append(TEXT_302);
                    }
                    stringBuffer.append(TEXT_303);
                    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
                        stringBuffer.append(TEXT_304);
                        stringBuffer.append(i);
                        stringBuffer.append(TEXT_305);
                        stringBuffer.append(allEVirtualIndexBitFields.get(i));
                        stringBuffer.append(TEXT_306);
                    }
                    stringBuffer.append(TEXT_307);
                    if (genModel.useClassOverrideAnnotation()) {
                        stringBuffer.append(TEXT_308);
                    }
                    stringBuffer.append(TEXT_309);
                    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
                        stringBuffer.append(TEXT_310);
                        stringBuffer.append(i);
                        stringBuffer.append(TEXT_311);
                        stringBuffer.append(allEVirtualIndexBitFields.get(i));
                        stringBuffer.append(TEXT_312);
                    }
                    stringBuffer.append(TEXT_313);
                }
            }
        }
        if (!genClass.hasImplementedToStringGenOperation() && isImplementation && !genModel.isReflectiveDelegation() && !genModel.isDynamicDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
            stringBuffer.append(TEXT_314);
            if (genModel.useClassOverrideAnnotation()) {
                stringBuffer.append(TEXT_315);
            }
            stringBuffer.append(TEXT_316);
            {
                boolean first = true;
                for (GenFeature genFeature : genClass.getToStringGenFeatures()) {
                    if (first) {
                        first = false;
                        stringBuffer.append(TEXT_317);
                        stringBuffer.append(genFeature.getName());
                        stringBuffer.append(TEXT_318);
                        stringBuffer.append(genModel.getNonNLS());
                    } else {
                        stringBuffer.append(TEXT_319);
                        stringBuffer.append(genFeature.getName());
                        stringBuffer.append(TEXT_320);
                        stringBuffer.append(genModel.getNonNLS());
                    }
                    if (genFeature.isUnsettable() && !genFeature.isListType()) {
                        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
                            stringBuffer.append(TEXT_321);
                            stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                            stringBuffer.append(positiveOffsetCorrection);
                            stringBuffer.append(TEXT_322);
                            stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                            stringBuffer.append(positiveOffsetCorrection);
                            stringBuffer.append(TEXT_323);
                            stringBuffer.append(genModel.getNonNLS());
                        } else {
                            if (genClass.isFlag(genFeature)) {
                                if (genFeature.isBooleanType()) {
                                    stringBuffer.append(TEXT_324);
                                    if (genClass.isESetFlag(genFeature)) {
                                        stringBuffer.append(TEXT_325);
                                        stringBuffer.append(genClass.getESetFlagsField(genFeature));
                                        stringBuffer.append(TEXT_326);
                                        stringBuffer.append(genFeature.getUpperName());
                                        stringBuffer.append(TEXT_327);
                                    } else {
                                        stringBuffer.append(genFeature.getUncapName());
                                        stringBuffer.append(TEXT_328);
                                    }
                                    stringBuffer.append(TEXT_329);
                                    stringBuffer.append(genClass.getFlagsField(genFeature));
                                    stringBuffer.append(TEXT_330);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_331);
                                    stringBuffer.append(genModel.getNonNLS());
                                } else {
                                    stringBuffer.append(TEXT_332);
                                    if (genClass.isESetFlag(genFeature)) {
                                        stringBuffer.append(TEXT_333);
                                        stringBuffer.append(genClass.getESetFlagsField(genFeature));
                                        stringBuffer.append(TEXT_334);
                                        stringBuffer.append(genFeature.getUpperName());
                                        stringBuffer.append(TEXT_335);
                                    } else {
                                        stringBuffer.append(genFeature.getUncapName());
                                        stringBuffer.append(TEXT_336);
                                    }
                                    stringBuffer.append(TEXT_337);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_338);
                                    stringBuffer.append(genClass.getFlagsField(genFeature));
                                    stringBuffer.append(TEXT_339);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_340);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_341);
                                    stringBuffer.append(genModel.getNonNLS());
                                }
                            } else {
                                stringBuffer.append(TEXT_342);
                                if (genClass.isESetFlag(genFeature)) {
                                    stringBuffer.append(TEXT_343);
                                    stringBuffer.append(genClass.getESetFlagsField(genFeature));
                                    stringBuffer.append(TEXT_344);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_345);
                                } else {
                                    stringBuffer.append(genFeature.getUncapName());
                                    stringBuffer.append(TEXT_346);
                                }
                                stringBuffer.append(TEXT_347);
                                stringBuffer.append(genFeature.getSafeName());
                                stringBuffer.append(TEXT_348);
                                stringBuffer.append(genModel.getNonNLS());
                            }
                        }
                    } else {
                        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
                            stringBuffer.append(TEXT_349);
                            stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                            stringBuffer.append(positiveOffsetCorrection);
                            if (!genFeature.isListType() && !genFeature.isReferenceType()) {
                                stringBuffer.append(TEXT_350);
                                stringBuffer.append(genFeature.getEDefault());
                            }
                            stringBuffer.append(TEXT_351);
                        } else {
                            if (genClass.isFlag(genFeature)) {
                                if (genFeature.isBooleanType()) {
                                    stringBuffer.append(TEXT_352);
                                    stringBuffer.append(genClass.getFlagsField(genFeature));
                                    stringBuffer.append(TEXT_353);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_354);
                                } else {
                                    stringBuffer.append(TEXT_355);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_356);
                                    stringBuffer.append(genClass.getFlagsField(genFeature));
                                    stringBuffer.append(TEXT_357);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_358);
                                    stringBuffer.append(genFeature.getUpperName());
                                    stringBuffer.append(TEXT_359);
                                }
                            } else {
                                stringBuffer.append(TEXT_360);
                                stringBuffer.append(genFeature.getSafeName());
                                stringBuffer.append(TEXT_361);
                            }
                        }
                    }
                }
            }
            stringBuffer.append(TEXT_362);
        }
        if (isImplementation && genClass.isMapEntry()) {
            GenFeature keyFeature = genClass.getMapEntryKeyFeature();
            GenFeature valueFeature = genClass.getMapEntryValueFeature();
            String objectType = genModel.getImportedName("java.lang.Object");
            String keyType = isJDK50 ? keyFeature.getObjectType(genClass) : objectType;
            String valueType = isJDK50 ? valueFeature.getObjectType(genClass) : objectType;
            String eMapType = genModel.getImportedName("org.eclipse.emf.common.util.EMap") + (isJDK50 ? "<" + keyType + ", " + valueType + ">" : "");
            stringBuffer.append(TEXT_363);
            stringBuffer.append(objectType);
            stringBuffer.append(TEXT_364);
            stringBuffer.append(keyType);
            stringBuffer.append(TEXT_365);
            if (!isJDK50 && keyFeature.isPrimitiveType()) {
                stringBuffer.append(TEXT_366);
                stringBuffer.append(keyFeature.getObjectType(genClass));
                stringBuffer.append(TEXT_367);
            } else {
                stringBuffer.append(TEXT_368);
            }
            stringBuffer.append(TEXT_369);
            stringBuffer.append(keyType);
            stringBuffer.append(TEXT_370);
            if (keyFeature.isListType()) {
                stringBuffer.append(TEXT_371);
                if (!genModel.useGenerics()) {
                    stringBuffer.append(TEXT_372);
                    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
                    stringBuffer.append(TEXT_373);
                }
                stringBuffer.append(TEXT_374);
            } else if (isJDK50) {
                stringBuffer.append(TEXT_375);
            } else if (keyFeature.isPrimitiveType()) {
                stringBuffer.append(TEXT_376);
                stringBuffer.append(keyFeature.getObjectType(genClass));
                stringBuffer.append(TEXT_377);
                stringBuffer.append(keyFeature.getPrimitiveValueFunction());
                stringBuffer.append(TEXT_378);
            } else {
                stringBuffer.append(TEXT_379);
                stringBuffer.append(keyFeature.getImportedType(genClass));
                stringBuffer.append(TEXT_380);
            }
            stringBuffer.append(TEXT_381);
            stringBuffer.append(valueType);
            stringBuffer.append(TEXT_382);
            if (!isJDK50 && valueFeature.isPrimitiveType()) {
                stringBuffer.append(TEXT_383);
                stringBuffer.append(valueFeature.getObjectType(genClass));
                stringBuffer.append(TEXT_384);
            } else {
                stringBuffer.append(TEXT_385);
            }
            stringBuffer.append(TEXT_386);
            stringBuffer.append(valueType);
            stringBuffer.append(TEXT_387);
            stringBuffer.append(valueType);
            stringBuffer.append(TEXT_388);
            stringBuffer.append(valueType);
            stringBuffer.append(TEXT_389);
            if (valueFeature.isListType()) {
                stringBuffer.append(TEXT_390);
                if (!genModel.useGenerics()) {
                    stringBuffer.append(TEXT_391);
                    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
                    stringBuffer.append(TEXT_392);
                }
                stringBuffer.append(TEXT_393);
            } else if (isJDK50) {
                stringBuffer.append(TEXT_394);
            } else if (valueFeature.isPrimitiveType()) {
                stringBuffer.append(TEXT_395);
                stringBuffer.append(valueFeature.getObjectType(genClass));
                stringBuffer.append(TEXT_396);
                stringBuffer.append(valueFeature.getPrimitiveValueFunction());
                stringBuffer.append(TEXT_397);
            } else {
                stringBuffer.append(TEXT_398);
                stringBuffer.append(valueFeature.getImportedType(genClass));
                stringBuffer.append(TEXT_399);
            }
            stringBuffer.append(TEXT_400);
            if (genModel.useGenerics()) {
                stringBuffer.append(TEXT_401);
            }
            stringBuffer.append(TEXT_402);
            stringBuffer.append(eMapType);
            stringBuffer.append(TEXT_403);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
            stringBuffer.append(TEXT_404);
            stringBuffer.append(eMapType);
            stringBuffer.append(TEXT_405);
        }
        stringBuffer.append(TEXT_406);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.insert" args="genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genClass", genClass);
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            callParameters.put("isJDK50", isJDK50);
            callParameters.put("isInterface", isInterface);
            callParameters.put("isImplementation", isImplementation);
            callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
            callParameters.put("singleWildcard", singleWildcard);
            callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
            callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03daIGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_407);
        stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
        // TODO fix the space above
        genModel.emitSortedImports();
        stringBuffer.append(TEXT_408);
    }

    public boolean preCondition() throws Exception {
        GenClass genClass = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
        canGenerate = canGenerate && (!genClass.isExternalInterface() && (!genModel.isSuppressInterfaces() || genClass.isInterface()));
        return canGenerate;
    }
}