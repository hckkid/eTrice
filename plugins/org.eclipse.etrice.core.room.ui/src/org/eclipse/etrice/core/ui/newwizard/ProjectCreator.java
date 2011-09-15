/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.ui.newwizard;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Henrik Rentz-Reichert - Initial contribution and API
 * 
 */
public class ProjectCreator {

	private static final String[] commonNatureIDs = {
		JavaCore.NATURE_ID,
		"org.eclipse.xtend.shared.ui.xtendXPandNature",
		"org.eclipse.xtext.ui.shared.xtextNature",
		"org.eclipse.pde.PluginNature"
	};
	private static final String[] commonBuilderIDs = {
		"org.eclipse.pde.ManifestBuilder",
		"org.eclipse.pde.SchemaBuilder",
		"org.eclipse.xtext.ui.shared.xtextBuilder",
		"org.eclipse.xtend.shared.ui.xtendBuilder"
	};

	private static final String[] commonRequiredBundles = {
			"org.eclipse.etrice.generator;bundle-version=\"0.1.0\"",
			"org.eclipse.emf.mwe2.launch;bundle-version=\"1.0.1\";resolution:=optional",
			"org.eclipse.emf.mwe.utils;bundle-version=\"1.0.0\";visibility:=reexport",
			"org.apache.log4j;bundle-version=\"1.2.15\"",
			"org.apache.commons.logging;bundle-version=\"1.0.4\"",
			"org.eclipse.jface.text;bundle-version=\"3.6.0\"",
			"org.eclipse.jdt.core;bundle-version=\"3.6.0\"",
			"org.eclipse.xtend.util.stdlib;bundle-version=\"1.0.0\"",
			"org.eclipse.core.runtime;bundle-version=\"3.6.0\"",
			"org.eclipse.xtext.generator;bundle-version=\"1.0.0\""
		};

	public static List<String> getCommonNatureIDs() {
		return Arrays.asList(commonNatureIDs);
	}

	public static List<String> getCommonBuilderIDs() {
		return Arrays.asList(commonBuilderIDs);
	}
	
	public static IProject createETriceProject(
			IPath javaSource,
			IPath javaSourceGen,
			URI projectLocationURI,
			IProject runtimeProject,
			List<String> naturesToAdd,
			List<String> buildersToAdd,
			Monitor monitor
		) {
		IProgressMonitor progressMonitor = BasicMonitor
				.toIProgressMonitor(monitor);
		String projectName = javaSource.segment(0);
		IProject project = null;
		try {
			List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();

			progressMonitor.beginTask("", 10);
			progressMonitor.subTask("Creating eTrice project "
					+ projectName
					+ " ("
					+ (projectLocationURI != null ? projectLocationURI
							.toString() : projectName) + ")");
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			project = workspace.getRoot().getProject(projectName);

			// Clean up any old project information.
			//
			if (!project.exists()) {
				URI location = projectLocationURI;
				if (location == null) {
					location = URI.createFileURI(workspace.getRoot()
							.getLocation().append(projectName).toOSString());
				}
				location = location.appendSegment(".project");
				File projectFile = new File(location.toString());
				if (projectFile.exists()) {
					projectFile
							.renameTo(new File(location.toString() + ".old"));
				}
			}

			IJavaProject javaProject = JavaCore.create(project);
			IProjectDescription projectDescription = null;
			if (!project.exists()) {
				projectDescription = ResourcesPlugin.getWorkspace()
						.newProjectDescription(projectName);
				if (projectLocationURI != null) {
					projectDescription.setLocationURI(new java.net.URI(
							projectLocationURI.toString()));
				}
				project.create(projectDescription, new SubProgressMonitor(
						progressMonitor, 1));
				project.open(new SubProgressMonitor(progressMonitor, 1));
			}
			else {
				projectDescription = project.getDescription();
				project.open(new SubProgressMonitor(progressMonitor, 1));
				if (project.hasNature(JavaCore.NATURE_ID)) {
					classpathEntries.addAll(Arrays.asList(javaProject
							.getRawClasspath()));
				}
			}

			boolean isInitiallyEmpty = classpathEntries.isEmpty();

			{
				ArrayList<IProject> referencedProjects = new ArrayList<IProject>();
				if (runtimeProject!=null)
					referencedProjects.add(runtimeProject);
				if (!referencedProjects.isEmpty()) {
					projectDescription.setReferencedProjects(
							referencedProjects.toArray(new IProject[referencedProjects.size()]));
					for (IProject referencedProject : referencedProjects) {
						IClasspathEntry referencedProjectClasspathEntry = JavaCore.newProjectEntry(
										referencedProject.getFullPath());
						classpathEntries.add(referencedProjectClasspathEntry);
					}
				}
			}
			
			{
				String[] natureIds = projectDescription.getNatureIds();
				if (natureIds == null) {
					natureIds = new String[0];
				}
				for (String nature : naturesToAdd) {
					natureIds = addNature(nature, natureIds, project);
				}
				projectDescription.setNatureIds(natureIds);

				ICommand[] builders = projectDescription.getBuildSpec();
				if (builders == null) {
					builders = new ICommand[0];
				}
				for (String builder : buildersToAdd) {
					builders = addBuilder(builder, builders, projectDescription);
				}
				projectDescription.setBuildSpec(builders);

				project.setDescription(projectDescription,
						new SubProgressMonitor(progressMonitor, 1));

				createSrcFolder(progressMonitor, project, classpathEntries, javaSource);
				createSrcFolder(progressMonitor, project, classpathEntries, javaSourceGen);

				if (isInitiallyEmpty) {
					IClasspathEntry jreClasspathEntry = JavaCore
							.newVariableEntry(new Path(
									JavaRuntime.JRELIB_VARIABLE), new Path(
									JavaRuntime.JRESRC_VARIABLE), new Path(
									JavaRuntime.JRESRCROOT_VARIABLE));
					for (Iterator<IClasspathEntry> i = classpathEntries
							.iterator(); i.hasNext();) {
						IClasspathEntry classpathEntry = i.next();
						if (classpathEntry.getPath().isPrefixOf(
								jreClasspathEntry.getPath())) {
							i.remove();
						}
					}

					String jreContainer = JavaRuntime.JRE_CONTAINER;
					jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6";
					classpathEntries.add(JavaCore.newContainerEntry(new Path(
							jreContainer)));
				}

				javaProject.setRawClasspath(classpathEntries
						.toArray(new IClasspathEntry[classpathEntries.size()]),
						new SubProgressMonitor(progressMonitor, 1));
			}

			if (isInitiallyEmpty) {
				javaProject.setOutputLocation(
						new Path("/" + javaSource.segment(0) + "/bin"),
						new SubProgressMonitor(progressMonitor, 1));
			}
            
			classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

            // Remove variables since the plugin.xml should provide the complete path information.
            //
			/*
			 * hrr: this would remove the runtime project which we need of course
            for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext(); )
            {
              IClasspathEntry classpathEntry = i.next();
              if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_VARIABLE && 
                    !JavaRuntime.JRELIB_VARIABLE.equals(classpathEntry.getPath().toString()) ||
                    classpathEntry.getEntryKind() == IClasspathEntry.CPE_PROJECT)
              {
                i.remove();
              }
            }
			 */

            javaProject.setRawClasspath
            (classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
             new SubProgressMonitor(progressMonitor, 1));
			
            if (isInitiallyEmpty)
            {
              javaProject.setOutputLocation(new Path("/" + javaSource.segment(0) + "/bin"), new SubProgressMonitor(progressMonitor, 1));
            }

		} catch (Exception e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} finally {
			progressMonitor.done();
		}

		return project;
	}

	/**
	 * @param manifestBuilder
	 * @param builders
	 * @param projectDescription
	 * @return
	 */
	private static ICommand[] addBuilder(String manifestBuilder,
			ICommand[] builders, IProjectDescription projectDescription) {
		boolean hasBuilder = false;
		for (int i = 0; i < builders.length; ++i) {
			if (manifestBuilder.equals(builders[i]
					.getBuilderName())) {
				hasBuilder = true;
			}
		}
		if (!hasBuilder) {
			ICommand[] oldBuilders = builders;
			builders = new ICommand[oldBuilders.length + 1];
			System.arraycopy(oldBuilders, 0, builders, 0,
					oldBuilders.length);
			builders[oldBuilders.length] = projectDescription
					.newCommand();
			builders[oldBuilders.length]
					.setBuilderName(manifestBuilder);
		}
		return builders;
	}

	/**
	 * @param natureId
	 * @param natureIds
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	private static String[] addNature(String natureId, String[] natureIds,
			IProject project) throws CoreException {
		if (!project.hasNature(natureId)) {
			String[] oldNatureIds = natureIds;
			natureIds = new String[oldNatureIds.length + 1];
			System.arraycopy(oldNatureIds, 0, natureIds, 0,
					oldNatureIds.length);
			natureIds[oldNatureIds.length] = natureId;
		}
		return natureIds;
	}

	/**
	 * @param progressMonitor
	 * @param project
	 * @param classpathEntries
	 * @param src
	 * @throws CoreException
	 */
	private static void createSrcFolder(IProgressMonitor progressMonitor,
			IProject project, List<IClasspathEntry> classpathEntries, IPath src)
			throws CoreException {
		if (src.segmentCount() > 1) {
			IPath sourceContainerPath = src.removeFirstSegments(
					1).makeAbsolute();
			IFolder sourceContainer = project.getFolder(sourceContainerPath);
			if (!sourceContainer.exists()) {
				for (int i = sourceContainerPath.segmentCount() - 1; i >= 0; i--) {
					sourceContainer = project
							.getFolder(sourceContainerPath
									.removeLastSegments(i));
					if (!sourceContainer.exists()) {
						((IFolder) sourceContainer).create(false, true,
								new SubProgressMonitor(progressMonitor,
										1));
					}
				}
			}

			IClasspathEntry sourceClasspathEntry = JavaCore
					.newSourceEntry(src);
			for (Iterator<IClasspathEntry> i = classpathEntries
					.iterator(); i.hasNext();) {
				IClasspathEntry classpathEntry = i.next();
				if (classpathEntry.getPath().isPrefixOf(src)) {
					i.remove();
				}
			}
			classpathEntries.add(0, sourceClasspathEntry);
		}
	}

    public static IContainer findOrCreateContainer
      (IPath path, boolean forceRefresh, IPath localLocation, IProgressMonitor progressMonitor) throws CoreException
    {
      String projectName = path.segment(0);
      IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
      projectDescription.setLocation(localLocation);
      return findOrCreateContainer(path, forceRefresh, projectDescription, progressMonitor);
    }

    public static IContainer findOrCreateContainer
      (IPath path, boolean forceRefresh, IProjectDescription projectDescription, IProgressMonitor progressMonitor) throws CoreException
    {
      try
      {
        String projectName = path.segment(0);
        progressMonitor.beginTask("", path.segmentCount() + 3);
        progressMonitor.subTask("examine new project "+projectName);
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IProject project = workspace.getRoot().getProject(path.segment(0));
  
        if (forceRefresh)
        {
          project.refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(progressMonitor, 1));
        }
        else
        {
          progressMonitor.worked(1);
        }
  
        if (!project.exists())
        {
          project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
          project.open(new SubProgressMonitor(progressMonitor, 1));
        }
        else
        {
          project.open(new SubProgressMonitor(progressMonitor, 2));
        }
  
        IContainer container = project;
        for (int i = 1, length = path.segmentCount(); i < length; ++ i)
        {
          IFolder folder = container.getFolder(new Path(path.segment(i)));
          if (!folder.exists())
          {
            folder.create(false, true, new SubProgressMonitor(progressMonitor, 1));
          }
          else
          {
            progressMonitor.worked(1);
          }
  
          container = folder;
        }
  
        return container;
      }
      finally
      {
        progressMonitor.done();
      }
    }

    /**
     * @param uri
     * @param name
     * @param generatorName
     * @deprecated new Xtend2 based generator uses Java launch 
     */
    public static void createWorkflow(URI uri, String name, String generatorName) {
		try {
			PrintStream workflow = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null),
					false,
					"UTF-8"
				);
	    	workflow.println("module "+name);
	    	workflow.println("");
	    	workflow.println("import workflow.RoomGenerator");
	    	workflow.println("import org.eclipse.emf.mwe.utils.*");
	    	workflow.println("");
	    	workflow.println("var destDir = \"src-gen\"");
	    	workflow.println("");
	    	workflow.println("Workflow {");
	    	workflow.println("");
	    	workflow.println("	component = DirectoryCleaner {");
	    	workflow.println("		directory = destDir");
	    	workflow.println("	}");
	    	workflow.println("");
	    	workflow.println("	component = @"+generatorName+" {");
	    	workflow.println("		sourceDir = \"model\"");
	    	workflow.println("		targetDir = destDir");
	    	workflow.println("	}");
	    	workflow.println("}");
			workflow.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
    }

	public static void createManifest(URI uri, String baseName, List<String> requiredBundles) {
		try {
			PrintStream manifest = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null),
					false,
					"UTF-8");
			manifest.println("Manifest-Version: 1.0");
			manifest.println("Bundle-ManifestVersion: 2");
			manifest.println("Bundle-Name: "+baseName);
			manifest.println("Bundle-SymbolicName: "+CodeGenUtil.validPluginID(baseName));
			manifest.println("Bundle-Version: 0.1.0");
			Iterator<String> it = requiredBundles.iterator();
			if (it.hasNext()) {
				manifest.print("Require-Bundle:");
				manifest.print(" "+it.next());
				while (it.hasNext()) {
					manifest.print(",\n "+it.next());
				}
				manifest.println("");
			}
			manifest.println("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
			manifest.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}

	public static List<String> getCommonRequiredBundles() {
		return Arrays.asList(commonRequiredBundles);
	}

	public static void createModel(URI uri, String baseName) {
		try {
			PrintStream model = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null),
					false,
					"UTF-8");
			model.println("RoomModel "+baseName+" {");
			model.println("\t// TODO: add ROOM classes here...");
			model.println("}");
			model.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}

	public static void createBuildProperties(URI uri, String baseName) {
		try {
			PrintStream prop = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null),
					false,
					"UTF-8");
			prop.println("source.. = src/,\\");
			prop.println("src-gen/");
			prop.println("bin.includes = META-INF/,\\");
			prop.println("       .");
			prop.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}

	public static void createLaunchConfig(URI uri, String baseName) {
		try {
			PrintStream launch = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(uri, null),
					false,
					"UTF-8");
			launch.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			launch.println("<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">");
			launch.println("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">");
			launch.println("<listEntry value=\"/org.eclipse.etrice.generator.java/src/org/eclipse/etrice/generator/java/Main.java\"/>");
			launch.println("</listAttribute>");
			launch.println("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">");
			launch.println("<listEntry value=\"1\"/>");
			launch.println("</listAttribute>");
			launch.println("<listAttribute key=\"org.eclipse.debug.ui.favoriteGroups\">");
			launch.println("<listEntry value=\"org.eclipse.debug.ui.launchGroup.run\"/>");
			launch.println("</listAttribute>");
			launch.println("<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"org.eclipse.etrice.generator.java.Main\"/>");
			launch.println("<stringAttribute key=\"org.eclipse.jdt.launching.PROGRAM_ARGUMENTS\" value=\"${workspace_loc:"+baseName+"}\\model\\"+baseName+".room"
					+"&#13;&#10;${workspace_loc:org.eclipse.etrice.modellib}\\models\\TimingService.room\"/>");
			launch.println("<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"org.eclipse.etrice.generator.java\"/>");
			launch.println("<stringAttribute key=\"org.eclipse.jdt.launching.VM_ARGUMENTS\" value=\"-ea\"/>");
			launch.println("<stringAttribute key=\"org.eclipse.jdt.launching.WORKING_DIRECTORY\" value=\"${workspace_loc:org.eclipse.etrice.tutorials}\"/>");
			launch.println("</launchConfiguration>");
			launch.close();
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		} catch (IOException e) {
			Logger.getLogger(ProjectCreator.class).error(e.getMessage(), e);
		}
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		ImageDescriptor desc = RoomActivator.getInstance().getImageRegistry()
				.getDescriptor(path);
		if (desc == null) {
			desc = RoomActivator.imageDescriptorFromPlugin(
					"org.eclipse.etrice.core.room.ui", path);
			if (desc == null)
				System.err.println("image not found: " + path);
			else {
				RoomActivator.getInstance().getImageRegistry().put(path, desc);
				RoomActivator.getInstance().getImageRegistry().get(path);
			}
		}
		return desc;
	}
}
