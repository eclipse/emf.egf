//Generated with EGF 1.2.0.v20140805-0858
package org.eclipse.egf.portfolio.eclipse.build.buckminster.util;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmlfilesetProvider {
	protected static String nl;

	public static synchronized buildxmlfilesetProvider create(String lineSeparator) {
		nl = lineSeparator;
		buildxmlfilesetProvider result = new buildxmlfilesetProvider();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\t\t<fileset file=\"";
	protected final String TEXT_2 = "\"/>";
	protected final String TEXT_3 = NL + "\t\t\t<fileset dir=\"";
	protected final String TEXT_4 = "\"/>";
	protected final String TEXT_5 = NL + "\t\t\t<fileset dir=\"";
	protected final String TEXT_6 = "\"/>";
	protected final String TEXT_7 = NL + "\t\t\t<fileset dir=\"";
	protected final String TEXT_8 = "\"/>";
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public buildxmlfilesetProvider() {
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

		List<Object> filesetProviderList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object filesetProviderParameter : filesetProviderList) {

			this.filesetProvider = (org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider) filesetProviderParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_10);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("filesetProvider", this.filesetProvider);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider filesetProvider = null;

	public void set_filesetProvider(org.eclipse.egf.portfolio.eclipse.build.buildfile.FilesetProvider object) {
		this.filesetProvider = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("filesetProvider", this.filesetProvider);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		for (String filePath : filesetProvider.getFilePaths()) {
			stringBuffer.append(TEXT_1);
			stringBuffer.append(filePath);
			stringBuffer.append(TEXT_2);
		}
		for (String dirPath : filesetProvider.getDirPaths()) {
			stringBuffer.append(TEXT_3);
			stringBuffer.append(dirPath);
			stringBuffer.append(TEXT_4);
		}
		for (InstallStep installStep : filesetProvider.getInstallSteps()) {
			String location = new GenerationHelper().getPublishPath(ctx, installStep, installStep) + installStep.getId();
			stringBuffer.append(TEXT_5);
			stringBuffer.append(location);
			stringBuffer.append(TEXT_6);
		}
		for (ResultStep resultStep : filesetProvider.getResultSteps()) {
			ArrayList<PublishStep> publishSteps = new ArrayList<PublishStep>();
			if (resultStep instanceof PublishStep)
				publishSteps.add((PublishStep) resultStep);
			else if (resultStep instanceof AggregateStep)
				publishSteps.addAll(((AggregateStep) resultStep).getPublishSteps());
			for (PublishStep publishStep : publishSteps) {
				String location = new GenerationHelper().getPublishPath(ctx, publishStep, publishStep) + publishStep.getComponent().getId();
				stringBuffer.append(TEXT_7);
				stringBuffer.append(location);
				stringBuffer.append(TEXT_8);
			}
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}