/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 * 
 */
public class URIHelper {

    private URIHelper() {
        // Prevent Instantiation
    }

    public static final URI PLATFORM_PLUGIN_URI = URI.createURI("platform:/plugin/"); //$NON-NLS-1$

    public static final URI PLATFORM_RESOURCE_URI = URI.createURI("platform:/resource/"); //$NON-NLS-1$  
    
    /* 
     * Fix support for fragment in path
     * 
     */
	public static URI createPlatformPluginURI(String path, boolean encode) {
		return createURI("platform:/plugin/", path);
	}

    /* 
     * Fix support for fragment in path
     * 
     */
	public static URI createPlatformResourceURI(String path, boolean encode) {
		return createURI("platform:/resource/", path);
	}

	private static URI createURI(String prefix, String path) {
		String uri = prefix;
		if (path.startsWith("/"))
			uri += path.substring(1);
		else
			uri += path;
		return URI.createURI(uri);
	}


    public static String toString(URI uri) {
        if (uri == null) {
            return null;
        }
        if (uri.isPlatformPlugin() || uri.isPlatformResource()) {
            String fragment = uri.fragment();
            URI encodedURI = null;
            if (uri.isPlatformPlugin()) {
                // Platform
                String pathName = URI.decode(uri.trimFragment().toString().substring(PLATFORM_PLUGIN_URI.toString().length(), uri.trimFragment().toString().length()));
                encodedURI = URI.createPlatformPluginURI(pathName, true);
            } else {
                // Resource
                String pathName = URI.decode(uri.trimFragment().toString().substring(PLATFORM_RESOURCE_URI.toString().length(), uri.trimFragment().toString().length()));
                encodedURI = URI.createPlatformResourceURI(pathName, true);
            }
            if (fragment != null) {
                encodedURI = encodedURI.appendFragment(fragment);
            }
            return encodedURI.toString();
        }
        return uri.toString();
    }

    public static URI getPlatformPluginURI(IPluginModelBase model, String value) {
        if (model == null || value == null || value.trim().length() == 0) {
            return null;
        }
        String bundleId = BundleHelper.getBundleId(model);
        if (bundleId == null) {
            return null;
        }
        return getPlatformPluginURI(bundleId, URI.decode(value.trim()), false);
    }

    public static URI getPlatformPluginURI(IPath path) {
        if (path == null || path.segmentCount() < 2) {
            return null;
        }
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0));
        if (project == null) {
            return null;
        }
        String bundleId = BundleHelper.getBundleId(project);
        if (bundleId == null) {
            return null;
        }
        return getPlatformPluginURI(bundleId, path.removeFirstSegments(1).toString(), false);
    }

    public static URI getPlatformPluginURI(IResource resource) {
        if (resource == null || resource.getFullPath() == null || resource.getFullPath().segmentCount() < 2) {
            return null;
        }
        String bundleId = BundleHelper.getBundleId(resource);
        if (bundleId == null) {
            return null;
        }
        return getPlatformPluginURI(bundleId, resource.getFullPath().removeFirstSegments(1).toString(), false);
    }

    public static URI getPlatformPluginURI(String bundleId, String value, boolean encode) {
        if (bundleId == null || bundleId.trim().length() == 0 || value == null || value.trim().length() == 0) {
            return null;
        }
        URI uri = URI.createURI(value.trim());
        if (uri.isRelative()) {
            if (value.trim().charAt(0) == EGFCommonConstants.SLASH_CHARACTER) {
                uri = URI.createPlatformPluginURI(bundleId.trim() + uri.toString(), encode);
            } else {
                uri = URI.createPlatformPluginURI(bundleId.trim() + "/" + uri.toString(), encode); //$NON-NLS-1$
            }
        }
        return uri;
    }

    public static URI getPlatformResourceURI(String bundleId, String value, boolean encode) {
        if (bundleId == null || bundleId.trim().length() == 0 || value == null || value.trim().length() == 0) {
            return null;
        }
        URI uri = URI.createURI(value.trim());
        if (uri.isRelative()) {
            if (value.trim().charAt(0) == EGFCommonConstants.SLASH_CHARACTER) {
                uri = URI.createPlatformResourceURI(bundleId.trim() + uri.toString(), encode);
            } else {
                uri = URI.createPlatformResourceURI(bundleId.trim() + "/" + uri.toString(), encode); //$NON-NLS-1$
            }
        }
        return uri;
    }

    public static String toPlatformProjectString(URI uri, boolean decode) {
        if (uri != null && uri.isPlatform() && uri.segmentCount() > 2) {
            StringBuffer result = new StringBuffer();
            for (int i = 2, len = uri.segmentCount(); i < len; i++) {
                if (result.length() != 0) {
                    result.append('/');
                }
                result.append(decode ? URI.decode(uri.segment(i)) : uri.segment(i));
            }
            return result.toString();
        }
        return uri != null ? uri.toString() : null;
    }

}
