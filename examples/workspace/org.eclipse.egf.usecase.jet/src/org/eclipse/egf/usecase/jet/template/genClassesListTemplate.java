package org.eclipse.egf.usecase.jet.template;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.resource.impl.*;

public class genClassesListTemplate
{
  protected static String nl;
  public static synchronized genClassesListTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    genClassesListTemplate result = new genClassesListTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " package Classes :" + NL + "-------------------------------";
  protected final String TEXT_3 = "\t\t\t";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     URI modelUri = (URI) argument; 
ResourceSet resourceSet = new ResourceSetImpl();
Resource resource = resourceSet.getResource(modelUri, true);
EObject eObject = resource.getContents().get(0);
if(eObject instanceof EPackage) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((EPackage)eObject).getName());
    stringBuffer.append(TEXT_2);
    
	for(EObject object : eObject.eContents()) {
		if(object instanceof EClass) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(((EClass) object).getName());
    
		}
	}
}

    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
