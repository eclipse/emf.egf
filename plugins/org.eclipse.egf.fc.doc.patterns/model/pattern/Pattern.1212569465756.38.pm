<?xml version="1.0" encoding="ASCII"?>
<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" xmlns:egf.pattern="http://www.eclipse.org/egf/1.0.0/Pattern" name="pattern_1212569465756_38" nsURI="http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1212569465756.38" nsPrefix="pattern_1212569465756_38">
  <eClassifiers xsi:type="egf.pattern:Pattern" name="Style" id="patternLibrary.1212569425341.37/Pattern.1212569465756.38" logicalName="Style" description="Generate the .css content used to define HTML pages style.">
    <eSuperTypes href="../../../../plugin/org.eclipse.egf.model/model/pattern.ecore#//Pattern"/>
    <eOperations name="generateBody">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="CALL(generateContent);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(generateContent());&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
      <eParameters name="classLoader_p">
        <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EJavaObject"/>
      </eParameters>
    </eOperations>
    <eOperations name="generatePreMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePreMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePreMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generatePostMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePostMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePostMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateHeader">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1212569498953.39"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.39.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.39.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateFooter">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1212569498953.40"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.40.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.40.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateContent">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1212569805510.43"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569805510.43.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569805510.43.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
  </eClassifiers>
</ecore:EPackage>
