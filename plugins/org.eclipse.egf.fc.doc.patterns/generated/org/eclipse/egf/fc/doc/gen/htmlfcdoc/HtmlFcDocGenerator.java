/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.fc.doc.gen.htmlfcdoc;

import java.util.Iterator;
import org.eclipse.egf.model.*;
import org.eclipse.egf.model.data.helper.ModelHelper;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.fc.doc.patterns.internal.*;

public class HtmlFcDocGenerator implements org.eclipse.egf.pattern.production.jet.IGenerator
{
  protected static String nl;
  public static synchronized HtmlFcDocGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    HtmlFcDocGenerator result = new HtmlFcDocGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">" + NL + "<head>" + NL + "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" + NL + "\t<title>" + NL + "\t\t";
  protected final String TEXT_2 = NL + "\t</title>" + NL + "\t<link rel=\"stylesheet\" href=\"../book.css\" charset=\"ISO-8859-1\" type=\"text/css\" />" + NL + "</head>" + NL + "" + NL + "<body xml:lang=\"EN-US\" lang=\"EN-US\">" + NL + "<div align=\"right\">" + NL + "  &nbsp;" + NL + "  <font face=\"Times New Roman, Times, serif\" size=\"2\">" + NL + "  Copyright <a href=\"http://www.epm.services.thales/wps/portal/epm\">Thales EPM</a> 2008. All rights reserved" + NL + "  </font>  " + NL + "  <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">" + NL + "    <tbody>" + NL + "      <tr>" + NL + "      \t<td colspan=\"2\" align=\"left\" bgcolor=\"#0080c0\" valign=\"top\">" + NL + "      \t  <b><font face=\"Arial,Helvetica\"><font color=\"#ffffff\">" + NL + "      \t  &nbsp;Factory Component Description " + NL + "      \t  </font></font></b>" + NL + "      \t</td>" + NL + "      </tr>" + NL + "  \t</tbody>" + NL + "  </table>" + NL + "</div><h1 align=\"center\">";
  protected final String TEXT_3 = "</h1>" + NL + "<blockquote>" + NL + "  <b>Summary</b>" + NL + "  <br/>" + NL + "  <p>" + NL + "  \t";
  protected final String TEXT_4 = NL + "  </p>" + NL + "</blockquote>" + NL + "<hr width=\"100%\" />" + NL + "<h2>Contract Description</h2>" + NL + "<p>" + NL + "<ul>";
  protected final String TEXT_5 = NL + "\t<li><img src=\"../../../org.eclipse.egf.model.edit/icons/full/obj16/";
  protected final String TEXT_6 = ".gif\" border=\"0\" /> " + NL + "  <b>";
  protected final String TEXT_7 = "</b> :<br/>" + NL + "\t";
  protected final String TEXT_8 = NL + "\t<ul>" + NL + "\t\t<li><b>Type holder class</b> : ";
  protected final String TEXT_9 = "</li>" + NL + "\t\t<li><b>Mandatory</b> : ";
  protected final String TEXT_10 = "</li>" + NL + "\t</ul>" + NL + "\t</li>" + NL + "\t<br/>";
  protected final String TEXT_11 = NL + "</ul>" + NL + "</p>" + NL + "<h2>Patterns Description</h2>" + NL + "<p>";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "</p>" + NL + "<h2>Mapping Description</h2>" + NL + "<p>" + NL + "<ul>";
  protected final String TEXT_14 = NL + "\t<li><img src=\"../../../org.eclipse.egf.model.edit/icons/full/obj16/MappingModel.gif\" border=\"0\" />" + NL + "\t<b>";
  protected final String TEXT_15 = "</b> (id: <b>";
  protected final String TEXT_16 = "</b>) :<br/>" + NL + "\t<ul>" + NL + "\t\t<li><b>Path</b> : ";
  protected final String TEXT_17 = "</li>" + NL + "\t\t<li><b>Factory Component used as source (domain provided by)</b> : ";
  protected final String TEXT_18 = "</li>" + NL + "\t\t<li><b>Factory Component used as target (domain provided by)</b> : ";
  protected final String TEXT_19 = "</li>" + NL + "\t</ul>" + NL + "\t</li>" + NL + "\t<br/>";
  protected final String TEXT_20 = "\t" + NL + "</ul>" + NL + "</p>" + NL + "<h2>Factory Description</h2>" + NL + "<p>" + NL + "Description of each declared asset configuration in the FC's factory." + NL + "</p>" + NL + "" + NL + "" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_21 = NL;

  /**
   * @see org.eclipse.egf.pattern.production.jet.IGenerator#generate(Object)
   */
  @SuppressWarnings({ "unchecked", "nls" })
  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
org.eclipse.emf.ecore.resource.Resource resource = org.eclipse.egf.pattern.execution.PatternExecutionHelper.getResource(argument);
org.eclipse.egf.core.context.ProductionContext context = org.eclipse.egf.pattern.execution.PatternExecutionHelper.getContext(argument);
org.eclipse.egf.pattern.execution.IPatternExecutionReporter reporter = org.eclipse.egf.pattern.execution.PatternExecutionHelper.getExecutionReporter(argument);

    
{
// Start of HtmlFcDoc (full id = patternLibrary.1212569425341.37/Pattern.1212569887715.48).
StringBuilder pattern121256988771548BuilderSave = new StringBuilder(stringBuffer);
StringBuilder pattern121256988771548Builder = new StringBuilder();
org.eclipse.egf.pattern.ecore.condition.IPatternCondition pattern121256988771548Condition = (org.eclipse.egf.pattern.ecore.condition.IPatternCondition) org.eclipse.egf.common.helper.ExtensionPointHelper.createExecutableExtension("org.eclipse.egf.pattern","patternCondition","patternId","patternLibrary.1212569425341.37/Pattern.1212569887715.48");
if (null != pattern121256988771548Condition) {
pattern121256988771548Condition.setContext(context);
java.util.List<org.eclipse.egf.pattern.relations.ParameterRelation> pattern121256988771548Parameters = org.eclipse.egf.pattern.ecore.PatternConditionHelper.getPatternParameters("patternLibrary.1212569425341.37/Pattern.1212569887715.48");
java.util.Map<String, org.eclipse.emf.ecore.EObject>  pattern121256988771548Result = new java.util.HashMap<String, org.eclipse.emf.ecore.EObject> ();
org.eclipse.egf.pattern.relations.ParameterRelation factoryComponentRelation = pattern121256988771548Parameters.get(0);
java.util.Collection<org.eclipse.emf.ecore.EObject> factoryComponentCollection = new org.eclipse.emf.query.statements.SELECT(new org.eclipse.emf.query.statements.FROM(resource.getContents()), new org.eclipse.emf.query.statements.WHERE(new org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition(org.eclipse.egf.common.helper.EcoreHelper.getStaticClass(factoryComponentRelation.getType()),org.eclipse.emf.query.conditions.eobjects.TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL))).execute();
for (org.eclipse.emf.ecore.EObject factoryComponentLoop : factoryComponentCollection) {
FactoryComponent factoryComponent =  (FactoryComponent) factoryComponentLoop;
if (pattern121256988771548Condition.check(factoryComponentLoop)) {
stringBuffer = new StringBuffer();

    String factoryComponentName = factoryComponent.getName();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(factoryComponentName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(factoryComponentName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(DataHelper.getDescription(factoryComponent));
    stringBuffer.append(TEXT_4);
    Contract contract = ModelHelper.getContract(factoryComponent);
	Iterator<ContractElement> contractElements = contract.getContractElements().iterator();
	while (contractElements.hasNext()) {	 
	 	ContractElement currentContractElement = contractElements.next();
	 	String contractElementName = currentContractElement.getName();
	 	String contractElementType = currentContractElement.getContractType().getTypeHolderClassName();
	 	String contractElementMandatoryValue = "No"; //$NON-NLS-1$
	 	String contractElementMandatoryImage = "ContractElement"; //$NON-NLS-1$
	 	if (currentContractElement.isMandatory()) {
	 		contractElementMandatoryValue = "Yes"; //$NON-NLS-1$
	 		contractElementMandatoryImage = "MandatoryContractElement"; //$NON-NLS-1$
	 	}
	 	String contractElementDescription = DataHelper.getDescription(currentContractElement);
	 	if (null == contractElementDescription) {
	 		contractElementDescription = "Empty Description"; //$NON-NLS-1$
	 	}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(contractElementMandatoryImage);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(contractElementName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(contractElementDescription);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(contractElementType);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(contractElementMandatoryValue);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
     PatternViewpoint patternViewpoint = ModelHelper.getPatternViewpoint(factoryComponent);
	String patternViewpointDescription = PatternDescriptionHelper.generateDescription(patternViewpoint);

    stringBuffer.append(TEXT_12);
    stringBuffer.append(patternViewpointDescription);
    stringBuffer.append(TEXT_13);
     MappingViewpoint mappingViewpoint = ModelHelper.getMappingViewpoint(factoryComponent);
	Iterator<MappingModel> mappings = mappingViewpoint.getMappings().iterator();
	while(mappings.hasNext()) {	 
	 	MappingModel currentMapping = mappings.next();
	 	String mappingName = currentMapping.getName();
	 	String mappingId = currentMapping.getId();
	 	String mappingPath = currentMapping.getPath();
	 	org.eclipse.egf.core.CoreActivator coreActivator = org.eclipse.egf.core.CoreActivator.getDefault();
	 	FactoryComponent fcAsSource = coreActivator.getFactoryComponent(currentMapping.getSource());
	 	FactoryComponent fcAsTarget = coreActivator.getFactoryComponent(currentMapping.getTarget());

    stringBuffer.append(TEXT_14);
    stringBuffer.append(mappingName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(mappingId);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(mappingPath);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( fcAsSource.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append( fcAsTarget.getName());
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
pattern121256988771548Result.put(factoryComponentRelation.getName(), factoryComponentLoop);
reporter.patternLoopExecutionFinished(stringBuffer.toString(),"patternLibrary.1212569425341.37/Pattern.1212569887715.48",context,pattern121256988771548Result);
pattern121256988771548Builder.append(stringBuffer);
}
}
}
stringBuffer = new StringBuffer(pattern121256988771548BuilderSave).append(pattern121256988771548Builder);
reporter.patternExecutionFinished(pattern121256988771548Builder.toString(),"patternLibrary.1212569425341.37/Pattern.1212569887715.48",context);
// End of HtmlFcDoc (full id = patternLibrary.1212569425341.37/Pattern.1212569887715.48).
}

    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
