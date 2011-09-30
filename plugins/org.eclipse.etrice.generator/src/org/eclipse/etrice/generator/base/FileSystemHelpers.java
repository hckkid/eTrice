/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * @author hrentz
 *
 */
public class FileSystemHelpers {

	/**
	 * calls {@link #getMarkerFileURI(EObject, String)} to determine the URI of the
	 * parent Eclipse project containing this object
	 * 
	 * @param obj an objected which should be located in a resource
	 * @return the URI of the Eclipse project
	 */
	public static URI getProjectURI(EObject obj) {
		return getMarkerFileURI(obj, ".project");
	}
	
	/**
	 * determines the URI of the first directory in the path of an object's resource
	 * which contains a file with a given name
	 * 
	 * @param obj an objected which should be located in a resource
	 * @param markerFileName name of marker file
	 * @return the URI of the first directory containing marker
	 */
	public static URI getMarkerFileURI(EObject obj, String markerFileName) {
		URI mainPath = null;
		if (obj!=null && obj.eResource()!=null) {
			mainPath = obj.eResource().getURI().trimSegments(1);
			File parent = null;
			if (mainPath.isPlatform()) {
				// HOWTO: get absolute OS path suitable for java.io.File from platform scheme EMF URI
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				IFile file = workspaceRoot.getFile(new Path(mainPath.toPlatformString(true)));
				String osString = file.getLocation().toOSString();
				parent = new File(osString);
			}
			else {
				parent = new File(mainPath.toFileString());
			}
			boolean isProject = false;
			int nUp = 0;
			do {
				parent = parent.getParentFile();
				String[] contents = parent.list();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i].equals(markerFileName)) {
						isProject = true;
						break;
					}
				}
				++nUp;
			}
			while (!isProject && parent!=null);
			if (isProject && nUp>0)
				mainPath = mainPath.trimSegments(nUp);
		}
		return mainPath;
	}
	
	private static boolean bothNullOrEqual(String s1, String s2) {
		if (s1==null && s2==null)
			return true;
		if (s1==null || s2==null)
			return false;
		return s1.equals(s2);
	}

	public static String getRelativePath(String base, String path) {
		return getRelativePath(URI.createFileURI(base), URI.createFileURI(path));
	}
	
	public static String getRelativePath(URI base, URI path) {
		if (base==null || path==null)
			return null;
		
		if (!bothNullOrEqual(base.scheme(),path.scheme()))
			return null;
		
		if (!bothNullOrEqual(base.authority(), path.authority()))
			return null;
		
		if (!bothNullOrEqual(base.device(), path.device()))
			return null;
		
		if (!base.hasAbsolutePath())
			return null;
		
		if (!path.hasAbsolutePath())
			return null;
		
		if (path.segmentCount()<base.segmentCount())
			return null;
		
		for (int i=0; i<base.segmentCount(); ++i) {
			if (!base.segment(i).equals(path.segment(i)))
				return null;
		}
		
		StringBuffer result = new StringBuffer();
		for (int i=base.segmentCount(); i<path.segmentCount(); ++i) {
			result.append(path.segment(i)+"/");
		}
		
		return result.substring(0, result.length()-1);
	}
}
