/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */

package org.eclipse.egf.task.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.platform.uri.PlatformURIConverter;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.TaskProductionForRuby;
import org.eclipse.emf.common.util.URI;
import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.util.ClassCache;

/**
 * @author xiaoru chen
 * 
 */
public class JRubyScriptEngine {
    private final Ruby runtime;

    public JRubyScriptEngine(String loadInterpreterPath) {
        ArrayList<String> loadpaths = new ArrayList<String>();
        // Get the interpreter library paths.
        if (loadInterpreterPath != null) {
            String[] libraryPaths = getLibraryPaths(loadInterpreterPath);
            for (String libraryPath : libraryPaths) {
                loadpaths.add(libraryPath);
            }
        }

        ClassLoader classLoader = this.getClass().getClassLoader();
        ClassCache createClassCache = JavaEmbedUtils.createClassCache(classLoader);
        runtime = JavaEmbedUtils.initialize(loadpaths, createClassCache);
    }

    /**
     * Evaluates the script under the ruby file, and return the ruby object.
     * 
     * @param uri
     *            The ruby file path.
     * @return The result of the eval.
     * @throws IOException
     */
    private IRubyObject getRubyobject(String uri) throws IOException {
        String script = getRubyScript(uri);
        IRubyObject rubyObject = runtime.evalScriptlet(script);
        return rubyObject;
    }

    /**
     * Get the script of the ruby file.
     * 
     * @param path
     *            The ruby file path.
     * @return The script of the ruby file
     * @throws IOException
     */
    private String getRubyScript(String path) throws IOException {
        StringBuffer script = new StringBuffer();
        PlatformURIConverter converter = new PlatformURIConverter();
        final URI uri = URI.createURI(path);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(converter.createInputStream(uri)));
        String readLine = reader.readLine();
        while (readLine != null) {
            script.append(readLine + "\r"); //$NON-NLS-1$
            readLine = reader.readLine();
        }
        return script.toString().trim();
    }

    /**
     * Execute the ruby task.
     * 
     * @param uri
     * @param context
     * @param monitor
     * @throws IOException
     * @throws InvocationException
     */
    public void executeRubyTask(String uri, ITaskProductionContext context, IProgressMonitor monitor) throws IOException, InvocationException {
        Object rubyobject = getRubyobject(uri);
        rubyobject = org.jruby.javasupport.JavaEmbedUtils.rubyToJava(runtime, (org.jruby.runtime.builtin.IRubyObject) rubyobject, TaskProductionForRuby.class);
        if (rubyobject != null && rubyobject instanceof TaskProductionForRuby) {

            // Execute the preExecute() method of ruby task.
            SubMonitor subMonitor = ((SubMonitor) monitor).newChild(100, SubMonitor.SUPPRESS_NONE);
            ((TaskProductionForRuby) rubyobject).preExecute(context, subMonitor);
            doSubMonitor(subMonitor);

            // Execute the doExecute() method of ruby task.
            subMonitor = ((SubMonitor) monitor).newChild(100, SubMonitor.SUPPRESS_NONE);
            ((TaskProductionForRuby) rubyobject).doExecute(context, subMonitor);
            doSubMonitor(subMonitor);

            // Execute the postExecute() method of ruby task.
            subMonitor = ((SubMonitor) monitor).newChild(100, SubMonitor.SUPPRESS_NONE);
            ((TaskProductionForRuby) rubyobject).postExecute(context, subMonitor);
            doSubMonitor(subMonitor);
        }
        JavaEmbedUtils.terminate(runtime);
    }

    private void doSubMonitor(SubMonitor subMonitor) {
        subMonitor.worked(100);
        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /**
     * Get the ruby VM library paths.
     * 
     * @param stringList
     *            All the library paths separated with file path separator.
     * @return
     */
    protected String[] getLibraryPaths(String stringList) {
        StringTokenizer st = new StringTokenizer(stringList, File.pathSeparator + "\n\r");//$NON-NLS-1$
        ArrayList v = new ArrayList();
        while (st.hasMoreElements()) {
            v.add(st.nextElement());
        }
        return (String[]) v.toArray(new String[v.size()]);
    }
}