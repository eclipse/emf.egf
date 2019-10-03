//Generated with EGF 1.5.0.qualifier
package org.eclipse.egf.emf.pattern.editor;

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

public class ActionBarContributor extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized ActionBarContributor create(String lineSeparator) {
		nl = lineSeparator;
		ActionBarContributor result = new ActionBarContributor();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * This is the action bar contributor for the ";
	protected final String TEXT_5 = " model editor." + NL + " * <!-- begin-user-doc -->" + NL
			+ " * <!-- end-user-doc -->";
	protected final String TEXT_6 = NL + " * ";
	protected final String TEXT_7 = NL + " * @generated" + NL + " */";
	protected final String TEXT_8 = NL + "@Deprecated";
	protected final String TEXT_9 = NL + "public class ";
	protected final String TEXT_10 = NL + "\textends ";
	protected final String TEXT_11 = NL + "\timplements ";
	protected final String TEXT_12 = NL + "{";
	protected final String TEXT_13 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tpublic static final String copyright = ";
	protected final String TEXT_14 = ";";
	protected final String TEXT_15 = NL;
	protected final String TEXT_16 = NL + "\t/**" + NL + "\t * Action to create objects from the ";
	protected final String TEXT_17 = " model." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->"
			+ NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class NewAction extends ";
	protected final String TEXT_18 = NL + "\t{" + NL + "\t\t/**" + NL
			+ "\t\t * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)" + NL
			+ "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL
			+ "\t\t */" + NL + "\t\tpublic void run(";
	protected final String TEXT_19 = " action)" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_20 = " wizard = new ";
	protected final String TEXT_21 = "();" + NL + "\t\t\twizard.init(getWindow().getWorkbench(), ";
	protected final String TEXT_22 = ".EMPTY);" + NL + "\t\t\t";
	protected final String TEXT_23 = " wizardDialog = new ";
	protected final String TEXT_24 = "(getWindow().getShell(), wizard);" + NL + "\t\t\twizardDialog.open();" + NL
			+ "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_25 = NL + "\t/**" + NL + "\t * This keeps track of the active editor." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected ";
	protected final String TEXT_26 = " activeEditorPart;" + NL + "" + NL + "\t/**" + NL
			+ "\t * This keeps track of the current selection provider." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_27 = " selectionProvider;" + NL + "" + NL + "\t/**" + NL
			+ "\t * This action opens the Properties view." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_28 = " showPropertiesViewAction =" + NL + "\t\tnew ";
	protected final String TEXT_29 = "(";
	protected final String TEXT_30 = ".INSTANCE.getString(\"_UI_ShowPropertiesView_menu_item\"))";
	protected final String TEXT_31 = NL + "\t\t{";
	protected final String TEXT_32 = NL + "\t\t\t@Override";
	protected final String TEXT_33 = NL + "\t\t\tpublic void run()" + NL + "\t\t\t{" + NL + "\t\t\t\ttry" + NL
			+ "\t\t\t\t{" + NL + "\t\t\t\t\tgetPage().showView(\"org.eclipse.ui.views.PropertySheet\");";
	protected final String TEXT_34 = NL + "\t\t\t\t}" + NL + "\t\t\t\tcatch (";
	protected final String TEXT_35 = " exception)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
	protected final String TEXT_36 = ".INSTANCE.log(exception);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};"
			+ NL + "" + NL + "\t/**" + NL + "\t * This action refreshes the viewer of the current editor if the editor"
			+ NL + "\t * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected ";
	protected final String TEXT_37 = " refreshViewerAction =" + NL + "\t\tnew ";
	protected final String TEXT_38 = ".INSTANCE.getString(\"_UI_RefreshViewer_menu_item\"))";
	protected final String TEXT_39 = NL + "\t\t\tpublic boolean isEnabled()" + NL + "\t\t\t{" + NL
			+ "\t\t\t\treturn activeEditorPart instanceof ";
	protected final String TEXT_40 = ";" + NL + "\t\t\t}" + NL;
	protected final String TEXT_41 = NL + "\t\t\tpublic void run()" + NL + "\t\t\t{" + NL
			+ "\t\t\t\tif (activeEditorPart instanceof ";
	protected final String TEXT_42 = ")" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
	protected final String TEXT_43 = " viewer = ((";
	protected final String TEXT_44 = ")activeEditorPart).getViewer();" + NL + "\t\t\t\t\tif (viewer != null)" + NL
			+ "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tviewer.refresh();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL
			+ "\t\t\t}" + NL + "\t\t};" + NL;
	protected final String TEXT_45 = NL + "\t/**" + NL
			+ "\t * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor"
			+ NL + "\t * generated for the current selection by the item provider." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected ";
	protected final String TEXT_46 = " createChildActions;" + NL;
	protected final String TEXT_47 = NL + "\t/**" + NL
			+ "\t * This will contain a map of {@link org.eclipse.emf.edit.ui.action.CreateChildAction}s, keyed by sub-menu text."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */" + NL + "\tprotected ";
	protected final String TEXT_48 = " createChildSubmenuActions;" + NL;
	protected final String TEXT_49 = NL + "\t/**" + NL
			+ "\t * This is the menu manager into which menu contribution items should be added for CreateChild actions."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */" + NL + "\tprotected ";
	protected final String TEXT_50 = " createChildMenuManager;" + NL + "" + NL + "\t/**" + NL
			+ "\t * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor"
			+ NL + "\t * generated for the current selection by the item provider." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected ";
	protected final String TEXT_51 = " createSiblingActions;" + NL;
	protected final String TEXT_52 = NL + "\t/**" + NL
			+ "\t * This will contain a map of {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction}s, keyed by submenu text."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */" + NL + "\tprotected ";
	protected final String TEXT_53 = " createSiblingSubmenuActions;" + NL;
	protected final String TEXT_54 = NL + "\t/**" + NL
			+ "\t * This is the menu manager into which menu contribution items should be added for CreateSibling actions."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */" + NL + "\tprotected ";
	protected final String TEXT_55 = " createSiblingMenuManager;" + NL;
	protected final String TEXT_56 = NL + "\t/**" + NL + "\t * This creates an instance of the contributor." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tpublic ";
	protected final String TEXT_57 = "()" + NL + "\t{" + NL + "\t\tsuper(ADDITIONS_LAST_STYLE);" + NL
			+ "\t\tloadResourceAction = new ";
	protected final String TEXT_58 = "();" + NL + "\t\tvalidateAction = new ";
	protected final String TEXT_59 = "();";
	protected final String TEXT_60 = NL + "\t\tliveValidationAction = new ";
	protected final String TEXT_61 = ".LiveValidator.LiveValidationAction(";
	protected final String TEXT_62 = ".getPlugin().getDialogSettings());";
	protected final String TEXT_63 = NL + "\t\tcontrolAction = new ";
	protected final String TEXT_64 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * This adds Separators for editor additions to the tool bar." + NL + "\t * <!-- begin-user-doc -->"
			+ NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_65 = NL + "\t@Override";
	protected final String TEXT_66 = NL + "\tpublic void contributeToToolBar(";
	protected final String TEXT_67 = " toolBarManager)" + NL + "\t{" + NL + "\t\ttoolBarManager.add(new ";
	protected final String TEXT_68 = "(\"";
	protected final String TEXT_69 = "-settings\"));";
	protected final String TEXT_70 = NL + "\t\ttoolBarManager.add(new ";
	protected final String TEXT_71 = "-additions\"));";
	protected final String TEXT_72 = NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * This adds to the menu bar a menu and some separators for editor additions," + NL
			+ "\t * as well as the sub-menus for object creation items." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_73 = NL + "\tpublic void contributeToMenu(";
	protected final String TEXT_74 = " menuManager)" + NL + "\t{" + NL + "\t\tsuper.contributeToMenu(menuManager);" + NL
			+ "" + NL + "\t\t";
	protected final String TEXT_75 = " submenuManager = new ";
	protected final String TEXT_76 = ".INSTANCE.getString(\"_UI_";
	protected final String TEXT_77 = "_menu\"), \"";
	protected final String TEXT_78 = "MenuID\");";
	protected final String TEXT_79 = NL + "\t\tmenuManager.insertAfter(\"additions\", submenuManager);";
	protected final String TEXT_80 = NL + "\t\tsubmenuManager.add(new ";
	protected final String TEXT_81 = "(\"settings\"));";
	protected final String TEXT_82 = "(\"actions\"));";
	protected final String TEXT_83 = "(\"additions\"));";
	protected final String TEXT_84 = "(\"additions-end\"));";
	protected final String TEXT_85 = NL + "\t\t// Prepare for CreateChild item addition or removal." + NL + "\t\t//"
			+ NL + "\t\tcreateChildMenuManager = new ";
	protected final String TEXT_86 = ".INSTANCE.getString(\"_UI_CreateChild_menu_item\"));";
	protected final String TEXT_87 = NL + "\t\tsubmenuManager.insertBefore(\"additions\", createChildMenuManager);";
	protected final String TEXT_88 = NL + NL + "\t\t// Prepare for CreateSibling item addition or removal." + NL
			+ "\t\t//" + NL + "\t\tcreateSiblingMenuManager = new ";
	protected final String TEXT_89 = ".INSTANCE.getString(\"_UI_CreateSibling_menu_item\"));";
	protected final String TEXT_90 = NL + "\t\tsubmenuManager.insertBefore(\"additions\", createSiblingMenuManager);";
	protected final String TEXT_91 = NL + NL + "\t\t// Force an update because Eclipse hides empty menus now." + NL
			+ "\t\t//" + NL + "\t\tsubmenuManager.addMenuListener" + NL + "\t\t\t(new ";
	protected final String TEXT_92 = "()" + NL + "\t\t\t {" + NL + "\t\t\t\t public void menuAboutToShow(";
	protected final String TEXT_93 = " menuManager)" + NL + "\t\t\t\t {" + NL
			+ "\t\t\t\t\t menuManager.updateAll(true);" + NL + "\t\t\t\t }" + NL + "\t\t\t });" + NL;
	protected final String TEXT_94 = NL + "\t\t// Add your contributions." + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL;
	protected final String TEXT_95 = NL + "\t\taddGlobalActions(submenuManager);" + NL + "\t}" + NL + "" + NL + "\t/**"
			+ NL
			+ "\t * When the active editor changes, this remembers the change and registers with it as a selection provider."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_96 = NL + "\tpublic void setActiveEditor(";
	protected final String TEXT_97 = " part)" + NL + "\t{" + NL + "\t\tsuper.setActiveEditor(part);" + NL
			+ "\t\tactiveEditorPart = part;" + NL + "" + NL + "\t\t// Switch to the new selection provider." + NL
			+ "\t\t//" + NL + "\t\tif (selectionProvider != null)" + NL + "\t\t{" + NL
			+ "\t\t\tselectionProvider.removeSelectionChangedListener(this);" + NL + "\t\t}" + NL
			+ "\t\tif (part == null)" + NL + "\t\t{" + NL + "\t\t\tselectionProvider = null;" + NL + "\t\t}" + NL
			+ "\t\telse" + NL + "\t\t{" + NL + "\t\t\tselectionProvider = part.getSite().getSelectionProvider();" + NL
			+ "\t\t\tselectionProvider.addSelectionChangedListener(this);" + NL + "" + NL
			+ "\t\t\t// Fake a selection changed event to update the menus." + NL + "\t\t\t//" + NL
			+ "\t\t\tif (selectionProvider.getSelection() != null)" + NL + "\t\t\t{" + NL
			+ "\t\t\t\tselectionChanged(new ";
	protected final String TEXT_98 = "(selectionProvider, selectionProvider.getSelection()));" + NL + "\t\t\t}" + NL
			+ "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener}," + NL
			+ "\t * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings"
			+ NL + "\t * that can be added to the selected object and updating the menus accordingly." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tpublic void selectionChanged(";
	protected final String TEXT_99 = " event)" + NL + "\t{";
	protected final String TEXT_100 = NL + "\t\t// Remove any menu items for old selection." + NL + "\t\t//" + NL
			+ "\t\tif (createChildMenuManager != null)" + NL + "\t\t{";
	protected final String TEXT_101 = NL
			+ "\t\t\tdepopulateManager(createChildMenuManager, createChildSubmenuActions);";
	protected final String TEXT_102 = NL + "\t\t\tdepopulateManager(createChildMenuManager, createChildActions);" + NL
			+ "\t\t}" + NL + "\t\tif (createSiblingMenuManager != null)" + NL + "\t\t{";
	protected final String TEXT_103 = NL
			+ "\t\t\tdepopulateManager(createSiblingMenuManager, createSiblingSubmenuActions);";
	protected final String TEXT_104 = NL + "\t\t\tdepopulateManager(createSiblingMenuManager, createSiblingActions);"
			+ NL + "\t\t}" + NL + "" + NL
			+ "\t\t// Query the new selection for appropriate new child/sibling descriptors" + NL + "\t\t//" + NL
			+ "\t\t";
	protected final String TEXT_105 = " newChildDescriptors = null;" + NL + "\t\t";
	protected final String TEXT_106 = " newSiblingDescriptors = null;" + NL + "" + NL + "\t\t";
	protected final String TEXT_107 = " selection = event.getSelection();" + NL + "\t\tif (selection instanceof ";
	protected final String TEXT_108 = " && ((IStructuredSelection)selection).size() == 1)" + NL + "\t\t{" + NL
			+ "\t\t\tObject object = ((";
	protected final String TEXT_109 = ")selection).getFirstElement();" + NL + "" + NL + "\t\t\t";
	protected final String TEXT_110 = " domain = ((";
	protected final String TEXT_111 = ")activeEditorPart).getEditingDomain();" + NL + "" + NL
			+ "\t\t\tnewChildDescriptors = domain.getNewChildDescriptors(object, null);" + NL
			+ "\t\t\tnewSiblingDescriptors = domain.getNewChildDescriptors(null, object);" + NL + "\t\t}" + NL + "" + NL
			+ "\t\t// Generate actions for selection; populate and redraw the menus." + NL + "\t\t//" + NL
			+ "\t\tcreateChildActions = generateCreateChildActions(newChildDescriptors, selection);";
	protected final String TEXT_112 = NL + "\t\tcreateChildSubmenuActions = extractSubmenuActions(createChildActions);";
	protected final String TEXT_113 = NL
			+ "\t\tcreateSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);";
	protected final String TEXT_114 = NL
			+ "\t\tcreateSiblingSubmenuActions = extractSubmenuActions(createSiblingActions);";
	protected final String TEXT_115 = NL + NL + "\t\tif (createChildMenuManager != null)" + NL + "\t\t{";
	protected final String TEXT_116 = NL
			+ "\t\t\tpopulateManager(createChildMenuManager, createChildSubmenuActions, null);";
	protected final String TEXT_117 = NL + "\t\t\tpopulateManager(createChildMenuManager, createChildActions, null);"
			+ NL + "\t\t\tcreateChildMenuManager.update(true);" + NL + "\t\t}" + NL
			+ "\t\tif (createSiblingMenuManager != null)" + NL + "\t\t{";
	protected final String TEXT_118 = NL
			+ "\t\t\tpopulateManager(createSiblingMenuManager, createSiblingSubmenuActions, null);";
	protected final String TEXT_119 = NL
			+ "\t\t\tpopulateManager(createSiblingMenuManager, createSiblingActions, null);" + NL
			+ "\t\t\tcreateSiblingMenuManager.update(true);" + NL + "\t\t}";
	protected final String TEXT_120 = NL + "\t\t// Add your contributions." + NL
			+ "\t\t// Ensure that you remove @generated or mark it @generated NOT";
	protected final String TEXT_121 = NL + "\t}" + NL;
	protected final String TEXT_122 = NL + "\t/**" + NL
			+ "\t * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,"
			+ NL + "\t * and returns the collection of these actions." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_123 = " generateCreateChildActions(";
	protected final String TEXT_124 = " descriptors, ";
	protected final String TEXT_125 = " selection)" + NL + "\t{" + NL + "\t\t";
	protected final String TEXT_126 = " actions = new ";
	protected final String TEXT_127 = "();" + NL + "\t\tif (descriptors != null)" + NL + "\t\t{";
	protected final String TEXT_128 = NL + "\t\t\tfor (";
	protected final String TEXT_129 = " descriptor : descriptors)";
	protected final String TEXT_130 = " i = descriptors.iterator(); i.hasNext(); )";
	protected final String TEXT_131 = NL + "\t\t\t{" + NL + "\t\t\t\tactions.add(new ";
	protected final String TEXT_132 = "(activeEditorPart, selection, ";
	protected final String TEXT_133 = "descriptor";
	protected final String TEXT_134 = "i.next()";
	protected final String TEXT_135 = "));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn actions;" + NL + "\t}"
			+ NL + "" + NL + "\t/**" + NL
			+ "\t * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,"
			+ NL + "\t * and returns the collection of these actions." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_136 = " generateCreateSiblingActions(";
	protected final String TEXT_137 = "));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn actions;" + NL + "\t}"
			+ NL + "" + NL + "\t/**" + NL
			+ "\t * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s"
			+ NL
			+ "\t * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection,"
			+ NL + "\t * by inserting them before the specified contribution item <code>contributionID</code>." + NL
			+ "\t * If <code>contributionID</code> is <code>null</code>, they are simply added." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected void populateManager(";
	protected final String TEXT_138 = " manager, ";
	protected final String TEXT_139 = " actions, String contributionID)" + NL + "\t{" + NL + "\t\tif (actions != null)"
			+ NL + "\t\t{";
	protected final String TEXT_140 = " action : actions)";
	protected final String TEXT_141 = " i = actions.iterator(); i.hasNext(); )";
	protected final String TEXT_142 = NL + "\t\t\t{";
	protected final String TEXT_143 = NL + "\t\t\t\t";
	protected final String TEXT_144 = " action = (IAction)i.next();";
	protected final String TEXT_145 = NL + "\t\t\t\tif (contributionID != null)" + NL + "\t\t\t\t{" + NL
			+ "\t\t\t\t\tmanager.insertBefore(contributionID, action);" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse" + NL
			+ "\t\t\t\t{" + NL + "\t\t\t\t\tmanager.add(action);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}"
			+ NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL
			+ "\t * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s"
			+ NL
			+ "\t * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */" + NL + "\tprotected void depopulateManager(";
	protected final String TEXT_146 = " actions)" + NL + "\t{" + NL + "\t\tif (actions != null)" + NL + "\t\t{" + NL
			+ "\t\t\t";
	protected final String TEXT_147 = "[] items = manager.getItems();" + NL
			+ "\t\t\tfor (int i = 0; i < items.length; i++)" + NL + "\t\t\t{" + NL
			+ "\t\t\t\t// Look into SubContributionItems" + NL + "\t\t\t\t//" + NL + "\t\t\t\t";
	protected final String TEXT_148 = " contributionItem = items[i];" + NL
			+ "\t\t\t\twhile (contributionItem instanceof ";
	protected final String TEXT_149 = ")" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tcontributionItem = ((";
	protected final String TEXT_150 = ")contributionItem).getInnerItem();" + NL + "\t\t\t\t}" + NL + "" + NL
			+ "\t\t\t\t// Delete the ActionContributionItems with matching action." + NL + "\t\t\t\t//" + NL
			+ "\t\t\t\tif (contributionItem instanceof ";
	protected final String TEXT_151 = " action = ((";
	protected final String TEXT_152 = ")contributionItem).getAction();" + NL + "\t\t\t\t\tif (actions.contains(action))"
			+ NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tmanager.remove(contributionItem);" + NL + "\t\t\t\t\t}" + NL
			+ "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_153 = NL + "\t/**" + NL
			+ "\t * This extracts those actions in the <code>submenuActions</code> collection whose text is qualified and returns"
			+ NL + "\t * a map of these actions, keyed by submenu text." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_154 = " extractSubmenuActions(";
	protected final String TEXT_155 = " createActions)" + NL + "\t{" + NL + "\t\t";
	protected final String TEXT_156 = " createSubmenuActions = new ";
	protected final String TEXT_157 = "();" + NL + "\t\tif (createActions != null)" + NL + "\t\t{" + NL + "\t\t\tfor (";
	protected final String TEXT_158 = " actions = createActions.iterator(); actions.hasNext(); )" + NL + "\t\t\t{" + NL
			+ "\t\t\t\t";
	protected final String TEXT_159 = " action = ";
	protected final String TEXT_160 = ")";
	protected final String TEXT_161 = "actions.next();" + NL + "\t\t\t\t";
	protected final String TEXT_162 = " st = new ";
	protected final String TEXT_163 = "(action.getText(), \"|\");";
	protected final String TEXT_164 = NL + "\t\t\t\tif (st.countTokens() == 2)" + NL + "\t\t\t\t{" + NL
			+ "\t\t\t\t\tString text = st.nextToken().trim();" + NL + "\t\t\t\t\t";
	protected final String TEXT_165 = " submenuActions = ";
	protected final String TEXT_166 = "createSubmenuActions.get(text);" + NL + "\t\t\t\t\tif (submenuActions == null)"
			+ NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tcreateSubmenuActions.put(text, submenuActions = new ";
	protected final String TEXT_167 = "());" + NL + "\t\t\t\t\t}" + NL
			+ "\t\t\t\t\taction.setText(st.nextToken().trim());" + NL + "\t\t\t\t\tsubmenuActions.add(action);" + NL
			+ "\t\t\t\t\tactions.remove();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL
			+ "\t\treturn createSubmenuActions;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.MenuManager}s containing"
			+ NL
			+ "\t * {@link org.eclipse.jface.action.ActionContributionItem}s based on the {@link org.eclipse.jface.action.IAction}s"
			+ NL
			+ "\t * contained in the <code>submenuActions</code> collection, by inserting them before the specified contribution"
			+ NL + "\t * item <code>contributionID</code>." + NL
			+ "\t * If <code>contributionID</code> is <code>null</code>, they are simply added." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected void populateManager(";
	protected final String TEXT_168 = " submenuActions, String contributionID)" + NL + "\t{" + NL
			+ "\t\tif (submenuActions != null)" + NL + "\t\t{";
	protected final String TEXT_169 = " entry : submenuActions.entrySet())" + NL + "\t\t\t{";
	protected final String TEXT_170 = " entries = submenuActions.entrySet().iterator(); entries.hasNext();)" + NL
			+ "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_171 = " entry = (";
	protected final String TEXT_172 = ")entries.next();";
	protected final String TEXT_173 = "(String)";
	protected final String TEXT_174 = "entry.getKey());" + NL + "\t\t\t\tif (contributionID != null)" + NL + "\t\t\t\t{"
			+ NL + "\t\t\t\t\tmanager.insertBefore(contributionID, submenuManager);" + NL + "\t\t\t\t}" + NL
			+ "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tmanager.add(submenuManager);" + NL + "\t\t\t\t}" + NL
			+ "\t\t\t\tpopulateManager(submenuManager, ";
	protected final String TEXT_175 = "entry.getValue(), null);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + ""
			+ NL + "\t/**" + NL
			+ "\t * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.MenuManager}s and their"
			+ NL
			+ "\t * {@link org.eclipse.jface.action.ActionContributionItem}s based on the {@link org.eclipse.jface.action.IAction}s"
			+ NL + "\t * contained in the <code>submenuActions</code> map." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tprotected void depopulateManager(";
	protected final String TEXT_176 = " submenuActions)" + NL + "\t{" + NL + "\t\tif (submenuActions != null)" + NL
			+ "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_177 = "[] items = manager.getItems();" + NL
			+ "\t\t\tfor (int i = 0; i < items.length; i++)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_178 = " contributionItem = items[i];" + NL + "\t\t\t\tif (contributionItem instanceof ";
	protected final String TEXT_179 = " submenuManager = (";
	protected final String TEXT_180 = ")contributionItem;" + NL
			+ "\t\t\t\t\tif (submenuActions.containsKey(submenuManager.getMenuText()))" + NL + "\t\t\t\t\t{" + NL
			+ "\t\t\t\t\t\tdepopulateManager(submenuManager, ";
	protected final String TEXT_181 = "submenuActions.get(contributionItem));" + NL
			+ "\t\t\t\t\t\tmanager.remove(contributionItem);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}"
			+ NL + "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_182 = NL + "\t/**" + NL + "\t * This populates the pop-up menu before it appears." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_183 = NL + "\tpublic void menuAboutToShow(";
	protected final String TEXT_184 = " menuManager)" + NL + "\t{" + NL + "\t\tsuper.menuAboutToShow(menuManager);";
	protected final String TEXT_185 = NL + "\t\t";
	protected final String TEXT_186 = " submenuManager = null;" + NL + "" + NL + "\t\tsubmenuManager = new ";
	protected final String TEXT_187 = NL + "\t\tpopulateManager(submenuManager, createChildSubmenuActions, null);";
	protected final String TEXT_188 = NL + "\t\tpopulateManager(submenuManager, createChildActions, null);" + NL
			+ "\t\tmenuManager.insertBefore(\"edit\", submenuManager);";
	protected final String TEXT_189 = NL + NL + "\t\tsubmenuManager = new ";
	protected final String TEXT_190 = NL + "\t\tpopulateManager(submenuManager, createSiblingSubmenuActions, null);";
	protected final String TEXT_191 = NL + "\t\tpopulateManager(submenuManager, createSiblingActions, null);" + NL
			+ "\t\tmenuManager.insertBefore(\"edit\", submenuManager);";
	protected final String TEXT_192 = NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * This inserts global actions before the \"additions-end\" separator." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_193 = NL + "\tprotected void addGlobalActions(";
	protected final String TEXT_194 = " menuManager)" + NL + "\t{" + NL
			+ "\t\tmenuManager.insertAfter(\"additions-end\", new ";
	protected final String TEXT_195 = "(\"ui-actions\"));";
	protected final String TEXT_196 = NL + "\t\tmenuManager.insertAfter(\"ui-actions\", showPropertiesViewAction);";
	protected final String TEXT_197 = NL + NL
			+ "\t\trefreshViewerAction.setEnabled(refreshViewerAction.isEnabled());\t\t" + NL
			+ "\t\tmenuManager.insertAfter(\"ui-actions\", refreshViewerAction);";
	protected final String TEXT_198 = NL + NL + "\t\tsuper.addGlobalActions(menuManager);" + NL + "\t}" + NL + "" + NL
			+ "\t/**" + NL + "\t * This ensures that a delete action will clean up all references to deleted objects."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t */";
	protected final String TEXT_199 = NL + "\tprotected boolean removeAllReferencesOnDelete()" + NL + "\t{" + NL
			+ "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "}";
	protected final String TEXT_200 = NL;

	public ActionBarContributor() {
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

		stringBuffer.append(TEXT_200);
		stringBuffer.append(TEXT_200);
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

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getEditorDirectory();
		packageName = genPackage.getPresentationPackageName();
		className = genPackage.getActionBarContributorClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditorDirectory(), genModel,
				GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2007 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 */

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();
		final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;

		String _CollectionOfAnything = null;
		String _CollectionOfIAction = null;
		String _ArrayListOfIAction = null;
		String _CollectionOfExtendsIAction = null;
		String _IteratorOfIAction = null;
		String _MapOfStringToCollectionOfIAction = null;
		String _MapEntryOfStringToCollectionOfIAction = null;
		String _LinkedHashMapOfStringToCollectionOfIAction = null;
		if (genModel.isCreationCommands()) {
			_CollectionOfAnything = genModel.getImportedName("Collection" + (genModel.useGenerics() ? "<?>" : ""));
			_CollectionOfIAction = genModel
					.getImportedName(genModel.useGenerics() ? "java.util.Collection<org.eclipse.jface.action.IAction>"
							: "java.util.Collection");
			_ArrayListOfIAction = genModel
					.getImportedName(genModel.useGenerics() ? "java.util.ArrayList<org.eclipse.jface.action.IAction>"
							: "java.util.ArrayList");
			_CollectionOfExtendsIAction = genModel.getImportedName(
					genModel.useGenerics() ? "java.util.Collection<? extends org.eclipse.jface.action.IAction>"
							: "java.util.Collection");
			if (genModel.isCreationSubmenus()) {
				_IteratorOfIAction = genModel
						.getImportedName(genModel.useGenerics() ? "java.util.Iterator<org.eclipse.jface.action.IAction>"
								: "java.util.Iterator");
				_MapOfStringToCollectionOfIAction = genModel.getImportedName("java.util.Map")
						+ (genModel.useGenerics() ? ("<String, " + _CollectionOfIAction + ">") : "");
				_MapEntryOfStringToCollectionOfIAction = genModel.getImportedName("java.util.Map") + ".Entry"
						+ (genModel.useGenerics() ? ("<String, " + _CollectionOfIAction + ">") : "");
				_LinkedHashMapOfStringToCollectionOfIAction = genModel.getImportedName("java.util.LinkedHashMap")
						+ (genModel.useGenerics() ? ("<String, " + _CollectionOfIAction + ">") : "");
			}
		}

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
		stringBuffer.append(genPackage.getPresentationPackageName());
		stringBuffer.append(TEXT_3);
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getPrefix());
		stringBuffer.append(TEXT_5);
		if (genPackage.hasAPITags()) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genPackage.getAPITags(genModel.getIndentation(stringBuffer)));
		}
		stringBuffer.append(TEXT_7);
		if (isJDK50 && genPackage.hasAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_8);
		}
		stringBuffer.append(TEXT_9);
		stringBuffer.append(genPackage.getActionBarContributorClassName());
		stringBuffer.append(TEXT_10);
		stringBuffer
				.append(genModel.getImportedName("org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor"));
		stringBuffer.append(TEXT_11);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.ISelectionChangedListener"));
		stringBuffer.append(TEXT_12);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_14);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_15);
		}
		if (genModel.isRichClientPlatform() && genPackage.isGenerateModelWizard()) {
			stringBuffer.append(TEXT_16);
			stringBuffer.append(genPackage.getPrefix());
			stringBuffer.append(TEXT_17);
			stringBuffer
					.append(genModel.getImportedName("org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate"));
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genPackage.getModelWizardClassName());
			stringBuffer.append(TEXT_20);
			stringBuffer.append(genPackage.getModelWizardClassName());
			stringBuffer.append(TEXT_21);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
			stringBuffer.append(TEXT_22);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
			stringBuffer.append(TEXT_23);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
			stringBuffer.append(TEXT_24);
		}
		stringBuffer.append(TEXT_25);
		stringBuffer.append(genModel.getImportedName("org.eclipse.ui.IEditorPart"));
		stringBuffer.append(TEXT_26);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.ISelectionProvider"));
		stringBuffer.append(TEXT_27);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
		stringBuffer.append(TEXT_28);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Action"));
		stringBuffer.append(TEXT_29);
		stringBuffer.append(genPackage.getImportedEditorPluginClassName());
		stringBuffer.append(TEXT_30);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_31);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_32);
		}
		stringBuffer.append(TEXT_33);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_34);
		stringBuffer.append(genModel.getImportedName("org.eclipse.ui.PartInitException"));
		stringBuffer.append(TEXT_35);
		stringBuffer.append(genPackage.getImportedEditorPluginClassName());
		stringBuffer.append(TEXT_36);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
		stringBuffer.append(TEXT_37);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Action"));
		stringBuffer.append(TEXT_29);
		stringBuffer.append(genPackage.getImportedEditorPluginClassName());
		stringBuffer.append(TEXT_38);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_31);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_32);
		}
		stringBuffer.append(TEXT_39);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.ui.viewer.IViewerProvider"));
		stringBuffer.append(TEXT_40);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_32);
		}
		stringBuffer.append(TEXT_41);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.ui.viewer.IViewerProvider"));
		stringBuffer.append(TEXT_42);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.Viewer"));
		stringBuffer.append(TEXT_43);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.ui.viewer.IViewerProvider"));
		stringBuffer.append(TEXT_44);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_45);
			stringBuffer.append(_CollectionOfIAction);
			stringBuffer.append(TEXT_46);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_47);
				stringBuffer.append(_MapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_48);
			}
			stringBuffer.append(TEXT_49);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
			stringBuffer.append(TEXT_50);
			stringBuffer.append(_CollectionOfIAction);
			stringBuffer.append(TEXT_51);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_52);
				stringBuffer.append(_MapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_53);
			}
			stringBuffer.append(TEXT_54);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
			stringBuffer.append(TEXT_55);
		}
		stringBuffer.append(TEXT_56);
		stringBuffer.append(genPackage.getActionBarContributorClassName());
		stringBuffer.append(TEXT_57);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.ui.action.LoadResourceAction"));
		stringBuffer.append(TEXT_58);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.ui.action.ValidateAction"));
		stringBuffer.append(TEXT_59);
		if (genModel.getDecoration() == GenDecoration.LIVE) {
			stringBuffer.append(TEXT_60);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.ui.provider.DiagnosticDecorator"));
			stringBuffer.append(TEXT_61);
			stringBuffer.append(genPackage.getImportedEditorPluginClassName());
			stringBuffer.append(TEXT_62);
		}
		stringBuffer.append(TEXT_63);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.ui.action.ControlAction"));
		stringBuffer.append(TEXT_64);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_65);
		}
		stringBuffer.append(TEXT_66);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IToolBarManager"));
		stringBuffer.append(TEXT_67);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_68);
		stringBuffer.append(genPackage.getPrefix().toLowerCase(genModel.getLocale()));
		stringBuffer.append(TEXT_69);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_70);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_68);
		stringBuffer.append(genPackage.getPrefix().toLowerCase(genModel.getLocale()));
		stringBuffer.append(TEXT_71);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_72);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_65);
		}
		stringBuffer.append(TEXT_73);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
		stringBuffer.append(TEXT_74);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
		stringBuffer.append(TEXT_75);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
		stringBuffer.append(TEXT_29);
		stringBuffer.append(genPackage.getImportedEditorPluginClassName());
		stringBuffer.append(TEXT_76);
		stringBuffer.append(genPackage.getEditorClassName());
		stringBuffer.append(TEXT_77);
		stringBuffer.append(genPackage.getInterfacePackageName());
		stringBuffer.append(TEXT_78);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(genModel.getNonNLS(2));
		stringBuffer.append(TEXT_79);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_80);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_81);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_80);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_82);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_80);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_83);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_80);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_84);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_15);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_85);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genPackage.getImportedEditorPluginClassName());
			stringBuffer.append(TEXT_86);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_87);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_88);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genPackage.getImportedEditorPluginClassName());
			stringBuffer.append(TEXT_89);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_90);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_91);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuListener"));
			stringBuffer.append(TEXT_92);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
			stringBuffer.append(TEXT_93);
		} else {
			stringBuffer.append(TEXT_94);
		}
		stringBuffer.append(TEXT_95);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_65);
		}
		stringBuffer.append(TEXT_96);
		stringBuffer.append(genModel.getImportedName("org.eclipse.ui.IEditorPart"));
		stringBuffer.append(TEXT_97);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.SelectionChangedEvent"));
		stringBuffer.append(TEXT_98);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.SelectionChangedEvent"));
		stringBuffer.append(TEXT_99);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_100);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_101);
			}
			stringBuffer.append(TEXT_102);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_103);
			}
			stringBuffer.append(TEXT_104);
			stringBuffer.append(_CollectionOfAnything);
			stringBuffer.append(TEXT_105);
			stringBuffer.append(_CollectionOfAnything);
			stringBuffer.append(TEXT_106);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.ISelection"));
			stringBuffer.append(TEXT_107);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
			stringBuffer.append(TEXT_108);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
			stringBuffer.append(TEXT_109);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.domain.EditingDomain"));
			stringBuffer.append(TEXT_110);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.domain.IEditingDomainProvider"));
			stringBuffer.append(TEXT_111);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_112);
			}
			stringBuffer.append(TEXT_113);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_114);
			}
			stringBuffer.append(TEXT_115);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_116);
			}
			stringBuffer.append(TEXT_117);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_118);
			}
			stringBuffer.append(TEXT_119);
		} else {
			stringBuffer.append(TEXT_120);
		}
		stringBuffer.append(TEXT_121);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_122);
			stringBuffer.append(_CollectionOfIAction);
			stringBuffer.append(TEXT_123);
			stringBuffer.append(_CollectionOfAnything);
			stringBuffer.append(TEXT_124);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.ISelection"));
			stringBuffer.append(TEXT_125);
			stringBuffer.append(_CollectionOfIAction);
			stringBuffer.append(TEXT_126);
			stringBuffer.append(_ArrayListOfIAction);
			stringBuffer.append(TEXT_127);
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_128);
				stringBuffer.append(genModel.getImportedName("java.lang.Object"));
				stringBuffer.append(TEXT_129);
			} else {
				stringBuffer.append(TEXT_128);
				stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
				stringBuffer.append(TEXT_130);
			}
			stringBuffer.append(TEXT_131);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.ui.action.CreateChildAction"));
			stringBuffer.append(TEXT_132);
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_133);
			} else {
				stringBuffer.append(TEXT_134);
			}
			stringBuffer.append(TEXT_135);
			stringBuffer.append(_CollectionOfIAction);
			stringBuffer.append(TEXT_136);
			stringBuffer.append(_CollectionOfAnything);
			stringBuffer.append(TEXT_124);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.viewers.ISelection"));
			stringBuffer.append(TEXT_125);
			stringBuffer.append(_CollectionOfIAction);
			stringBuffer.append(TEXT_126);
			stringBuffer.append(_ArrayListOfIAction);
			stringBuffer.append(TEXT_127);
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_128);
				stringBuffer.append(genModel.getImportedName("java.lang.Object"));
				stringBuffer.append(TEXT_129);
			} else {
				stringBuffer.append(TEXT_128);
				stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
				stringBuffer.append(TEXT_130);
			}
			stringBuffer.append(TEXT_131);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.edit.ui.action.CreateSiblingAction"));
			stringBuffer.append(TEXT_132);
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_133);
			} else {
				stringBuffer.append(TEXT_134);
			}
			stringBuffer.append(TEXT_137);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionManager"));
			stringBuffer.append(TEXT_138);
			stringBuffer.append(_CollectionOfExtendsIAction);
			stringBuffer.append(TEXT_139);
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_128);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
				stringBuffer.append(TEXT_140);
			} else {
				stringBuffer.append(TEXT_128);
				stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
				stringBuffer.append(TEXT_141);
			}
			stringBuffer.append(TEXT_142);
			if (!genModel.useGenerics()) {
				stringBuffer.append(TEXT_143);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
				stringBuffer.append(TEXT_144);
			}
			stringBuffer.append(TEXT_145);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionManager"));
			stringBuffer.append(TEXT_138);
			stringBuffer.append(_CollectionOfExtendsIAction);
			stringBuffer.append(TEXT_146);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionItem"));
			stringBuffer.append(TEXT_147);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionItem"));
			stringBuffer.append(TEXT_148);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.SubContributionItem"));
			stringBuffer.append(TEXT_149);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.SubContributionItem"));
			stringBuffer.append(TEXT_150);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.ActionContributionItem"));
			stringBuffer.append(TEXT_42);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
			stringBuffer.append(TEXT_151);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.ActionContributionItem"));
			stringBuffer.append(TEXT_152);
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_153);
				stringBuffer.append(_MapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_154);
				stringBuffer.append(_CollectionOfIAction);
				stringBuffer.append(TEXT_155);
				stringBuffer.append(_MapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_156);
				stringBuffer.append(_LinkedHashMapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_157);
				stringBuffer.append(_IteratorOfIAction);
				stringBuffer.append(TEXT_158);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
				stringBuffer.append(TEXT_159);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_29);
					stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IAction"));
					stringBuffer.append(TEXT_160);
				}
				stringBuffer.append(TEXT_161);
				stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
				stringBuffer.append(TEXT_162);
				stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
				stringBuffer.append(TEXT_163);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_164);
				stringBuffer.append(_CollectionOfIAction);
				stringBuffer.append(TEXT_165);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_29);
					stringBuffer.append(_CollectionOfIAction);
					stringBuffer.append(TEXT_160);
				}
				stringBuffer.append(TEXT_166);
				stringBuffer.append(_ArrayListOfIAction);
				stringBuffer.append(TEXT_167);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionManager"));
				stringBuffer.append(TEXT_138);
				stringBuffer.append(_MapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_168);
				if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
					stringBuffer.append(TEXT_128);
					stringBuffer.append(_MapEntryOfStringToCollectionOfIAction);
					stringBuffer.append(TEXT_169);
				} else {
					stringBuffer.append(TEXT_128);
					stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
					stringBuffer.append(TEXT_170);
					stringBuffer.append(_MapEntryOfStringToCollectionOfIAction);
					stringBuffer.append(TEXT_171);
					stringBuffer.append(_MapEntryOfStringToCollectionOfIAction);
					stringBuffer.append(TEXT_172);
				}
				stringBuffer.append(TEXT_143);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
				stringBuffer.append(TEXT_75);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
				stringBuffer.append(TEXT_29);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_173);
				}
				stringBuffer.append(TEXT_174);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_29);
					stringBuffer.append(_CollectionOfIAction);
					stringBuffer.append(TEXT_160);
				}
				stringBuffer.append(TEXT_175);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionManager"));
				stringBuffer.append(TEXT_138);
				stringBuffer.append(_MapOfStringToCollectionOfIAction);
				stringBuffer.append(TEXT_176);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionItem"));
				stringBuffer.append(TEXT_177);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IContributionItem"));
				stringBuffer.append(TEXT_178);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
				stringBuffer.append(TEXT_42);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
				stringBuffer.append(TEXT_179);
				stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
				stringBuffer.append(TEXT_180);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_29);
					stringBuffer.append(_CollectionOfIAction);
					stringBuffer.append(TEXT_160);
				}
				stringBuffer.append(TEXT_181);
			}
		}
		stringBuffer.append(TEXT_182);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_65);
		}
		stringBuffer.append(TEXT_183);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
		stringBuffer.append(TEXT_184);
		if (genModel.isCreationCommands()) {
			stringBuffer.append(TEXT_185);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
			stringBuffer.append(TEXT_186);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genPackage.getImportedEditorPluginClassName());
			stringBuffer.append(TEXT_86);
			stringBuffer.append(genModel.getNonNLS());
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_187);
			}
			stringBuffer.append(TEXT_188);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_189);
			stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.MenuManager"));
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genPackage.getImportedEditorPluginClassName());
			stringBuffer.append(TEXT_89);
			stringBuffer.append(genModel.getNonNLS());
			if (genModel.isCreationSubmenus()) {
				stringBuffer.append(TEXT_190);
			}
			stringBuffer.append(TEXT_191);
			stringBuffer.append(genModel.getNonNLS());
		}
		stringBuffer.append(TEXT_192);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_65);
		}
		stringBuffer.append(TEXT_193);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.IMenuManager"));
		stringBuffer.append(TEXT_194);
		stringBuffer.append(genModel.getImportedName("org.eclipse.jface.action.Separator"));
		stringBuffer.append(TEXT_195);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(genModel.getNonNLS(2));
		stringBuffer.append(TEXT_196);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_197);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_198);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_65);
		}
		stringBuffer.append(TEXT_199);
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_15);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenPackage genPackage = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject");
		canGenerate = canGenerate && (genPackage.hasConcreteClasses()
				&& genPackage.getGenModel().getRuntimePlatform() != GenRuntimePlatform.GWT);
		return canGenerate;
	}
}