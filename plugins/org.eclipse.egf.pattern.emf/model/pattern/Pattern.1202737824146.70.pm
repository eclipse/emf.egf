<?xml version="1.0" encoding="ASCII"?>
<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" xmlns:egf.pattern="http://www.eclipse.org/egf/1.0.0/Pattern" name="pattern_1202737824146_70" nsURI="http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1202737824146.70" nsPrefix="pattern_1202737824146_70">
  <eClassifiers xsi:type="egf.pattern:Pattern" name="Pattern_1202737824146_70" id="EmfLibrary/patternLibrary.1202723104683.6/Pattern.1202737824146.70" logicalName="pluginXML" description="Emf pattern for Edit plugin.xml generation.">
    <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern/production">
      <details key="Path" value="edit/plugin.xmljet"/>
      <details key="Compilation" value="true"/>
      <details key="BufferModification" value="false"/>
    </eAnnotations>
    <eSuperTypes href="../../../../plugin/org.eclipse.egf.model/model/pattern.ecore#//Pattern"/>
    <eOperations name="generateBody">
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
      <eParameters name="classLoader_p">
        <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EJavaObject"/>
      </eParameters>
    </eOperations>
    <eOperations name="generatePreMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(emf.patterns/templates/generated/Pattern.1202737824146.70/generatePreMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;emf.patterns/templates/generated/Pattern.1202737824146.70/generatePreMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generatePostMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(emf.patterns/templates/generated/Pattern.1202737824146.70/generatePostMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;emf.patterns/templates/generated/Pattern.1202737824146.70/generatePostMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateHeader">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202737824146.71"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(emf.patterns/templates/Pattern.1202737824146.70/PatternMethod.1202737824146.71.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;emf.patterns/templates/Pattern.1202737824146.70/PatternMethod.1202737824146.71.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateFooter">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202737824146.72"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(emf.patterns/templates/Pattern.1202737824146.70/PatternMethod.1202737824146.72.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;emf.patterns/templates/Pattern.1202737824146.70/PatternMethod.1202737824146.72.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="include">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202738046831.74"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(emf.patterns/templates/Pattern.1202737824146.70/PatternMethod.1202738046831.74.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;emf.patterns/templates/Pattern.1202737824146.70/PatternMethod.1202738046831.74.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
  </eClassifiers>
</ecore:EPackage>
