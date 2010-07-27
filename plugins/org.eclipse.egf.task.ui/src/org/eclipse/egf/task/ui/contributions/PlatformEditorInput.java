package org.eclipse.egf.task.ui.contributions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.core.platform.uri.PlatformURIConverter;
import org.eclipse.egf.task.ui.EGFTaskUIPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

class PlatformEditorInput implements IStorageEditorInput {

    private final URI uri;

    public PlatformEditorInput(String path) {
        uri = URI.createURI(path);
    }

    public IStorage getStorage() throws CoreException {
        return new MyStorage();
    }

    public Object getAdapter(Class adapter) {

        return null;
    }

    public boolean exists() {

        return true;
    }

    public ImageDescriptor getImageDescriptor() {

        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlatformEditorInput) {
            PlatformEditorInput input = (PlatformEditorInput) obj;
            return input.uri.equals(uri);
        }
        return super.equals(obj);
    }

    public String getName() {

        return uri.lastSegment();
    }

    public IPersistableElement getPersistable() {

        return null;
    }

    public String getToolTipText() {

        return uri.path();
    }

    private class MyStorage implements IStorage {

        public InputStream getContents() throws CoreException {
            try {
                PlatformURIConverter converter = new PlatformURIConverter();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(converter.createInputStream(uri)));
                StringBuilder builder = new StringBuilder(1000);
                String readLine = reader.readLine();
                while (readLine != null) {
                    builder.append(readLine).append(EGFCommonConstants.LINE_SEPARATOR);
                    readLine = reader.readLine();
                }
                return new ByteArrayInputStream(builder.toString().getBytes());
            } catch (Exception e) {
                throw new CoreException(new Status(IStatus.ERROR, EGFTaskUIPlugin.getDefault().getPluginID(), e.getMessage(), e));
            }
        }

        public IPath getFullPath() {
            return null;
        }

        public String getName() {
            return null;
        }

        public boolean isReadOnly() {
            return true;
        }

        @SuppressWarnings("unchecked")
        public Object getAdapter(Class adapter) {
            return null;
        }

    }

}