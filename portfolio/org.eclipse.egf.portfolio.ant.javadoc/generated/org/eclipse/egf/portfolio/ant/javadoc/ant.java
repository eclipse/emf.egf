package org.eclipse.egf.portfolio.ant.javadoc;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.core.resources.*;

public class ant {
    protected static String nl;

    public static synchronized ant create(String lineSeparator) {
        nl = lineSeparator;
        ant result = new ant();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<?xml version=\"1.0\"?>" + NL + "" + NL + "<project name=\"Javadoc Generation\" default=\"main\">" + NL + "\t<target name=\"main\">" + NL;
    protected final String TEXT_2 = "\t\t<delete dir=\"";
    protected final String TEXT_3 = "\" />";
    protected final String TEXT_4 = "\t\t<javadoc" + NL + "\t\t\tdestdir=\"";
    protected final String TEXT_5 = "\"" + NL + "\t\t\tmaxmemory=\"1024m\"" + NL + "\t\t\tsource=\"1.5\"" + NL + "\t\t\tuseexternalfile=\"true\"" + NL + "\t\t\tauthor=\"true\"" + NL + "\t\t\tversion=\"true\"" + NL + "\t\t\tuse=\"true\"" + NL + "\t\t\twindowtitle=\"Javadoc\">";
    protected final String TEXT_6 = "\t\t<link offline=\"false\" href=\"http://download.oracle.com/javase/1.5.0/docs/api/\"/> " + NL + "\t\t<link offline=\"false\" href=\"http://www.osgi.org/javadoc/r4v42/\"/> " + NL + "\t\t<link offline=\"false\" href=\"http://download.eclipse.org/modeling/emf/emf/javadoc/2.5.0/\"/> " + NL + "\t\t<link offline=\"false\" href=\"http://help.eclipse.org/galileo/index.jsp?topic=/org.eclipse.platform.doc.isv/reference/api/\"/>";
    protected final String TEXT_7 = NL + "\t\t<fileset dir=\"";
    protected final String TEXT_8 = "\" defaultexcludes=\"true\">" + NL + "\t\t\t<include name=\"**/*.java\"/>" + NL + "\t\t</fileset>";
    protected final String TEXT_9 = NL;
    protected final String TEXT_10 = "\t</javadoc>";
    protected final String TEXT_11 = "\t</target>" + NL + "</project>" + NL + "\t";
    protected final String TEXT_12 = NL;
    protected final String TEXT_13 = NL;

    public ant() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        if (preCondition())
            orchestration(ctx);

        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_12);
        stringBuffer.append(TEXT_13);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        method_computeVariables(ictx.getBuffer(), ictx);

        method_begin(ictx.getBuffer(), ictx);

        method_deleteOutput(ictx.getBuffer(), ictx);

        method_beginJavadoc(ictx.getBuffer(), ictx);

        method_javadocLinks(ictx.getBuffer(), ictx);

        method_javadocInput(ictx.getBuffer(), ictx);

        method_endJavadoc(ictx.getBuffer(), ictx);

        method_end(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected java.lang.String outputFolderPath = null;

    public void set_outputFolderPath(java.lang.String object) {
        this.outputFolderPath = object;
    }

    protected java.util.List inputFolderPaths = null;

    public void set_inputFolderPaths(java.util.List object) {
        this.inputFolderPaths = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        return parameters;
    }

    protected void method_computeVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        String inputProjectNames = (String) ctx.getValue("inputProjectNames");
        String outputProjectName = (String) ctx.getValue("outputProjectName");
        String outputFolderName = (String) ctx.getValue("outputFolderName");

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

        IFolder folder = root.getProject(outputProjectName).getFolder(outputFolderName);
        outputFolderPath = folder.getRawLocation().toOSString();

        inputFolderPaths = new ArrayList<String>();
        String[] split = inputProjectNames.split(",");
        for (String inputProjectName : split) {
            String inputFolderPath = root.getProject(inputProjectName.trim()).getRawLocation().toOSString();
            inputFolderPaths.add(inputFolderPath);
        }

    }

    protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
    }

    protected void method_deleteOutput(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_2);
        stringBuffer.append(outputFolderPath);
        stringBuffer.append(TEXT_3);
    }

    protected void method_beginJavadoc(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_4);
        stringBuffer.append(outputFolderPath);
        stringBuffer.append(TEXT_5);
    }

    protected void method_javadocLinks(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_6);
    }

    protected void method_javadocInput(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        for (Iterator iterator = inputFolderPaths.iterator(); iterator.hasNext();) {
            String inputFolderPath = (String) iterator.next();

            stringBuffer.append(TEXT_7);
            stringBuffer.append(inputFolderPath);
            stringBuffer.append(TEXT_8);
        }
        stringBuffer.append(TEXT_9);
    }

    protected void method_endJavadoc(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_10);
    }

    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_11);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}