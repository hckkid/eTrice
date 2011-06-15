/**
 * <copyright>
 *
 * Copyright (c) 2005-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * EmptyProjectWizard.java,v 1.1 2005/05/06 02:19:59 marcelop Exp
 */
package org.eclipse.etrice.core.ui.newwizard;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * @since 2.1.0
 */
public class EmptyProjectWizard extends Wizard implements INewWizard {
	protected IWorkbench workbench;
	protected IPath projectLocation;
	protected IPath sourcePath;
	protected IPath sourceGenPath;
	protected IProject project;
	protected IProject runtimeProject;
	protected String initialProjectName;

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor(String path) {
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

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		setDefaultPageImageDescriptor(getImageDescriptor("icons/NewETriceProjectWizban.gif"));
		setWindowTitle("New Empty eTrice Project");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		runtimeProject = workspace.getRoot().getProject("org.eclipse.etrice.runtime.java");
	}

	@Override
	public void addPages() {
		WizardNewProjectCreationPage newProjectCreationPage = new WizardNewProjectCreationPage(
				"NewProjectCreationPage") {
			@Override
			protected boolean validatePage() {
				if (super.validatePage()) {
					if (runtimeProject==null || !runtimeProject.exists()) {
						setErrorMessage("the project 'org.eclipse.etrice.runtime.java' must be in the workspace");
						return false;
					}
					IPath locationPath = getLocationPath();
					projectLocation = Platform.getLocation().equals(
							locationPath) ? null : locationPath;
					IPath projectPath = getProjectHandle().getFullPath();
					sourcePath = projectPath.append("src");
					sourceGenPath = projectPath.append("src-gen");
					return true;
				} else {
					return false;
				}
			}
		};

		newProjectCreationPage.setInitialProjectName(initialProjectName);
		newProjectCreationPage.setTitle("Empty eTrice Project");
		newProjectCreationPage
				.setDescription("Create an empty Java plug-in project with eTrice dependencies");
		addPage(newProjectCreationPage);
	}

	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					URI modelProjectURI = (projectLocation==null) ? null : URI.createFileURI(projectLocation.toOSString());
					project = ProjectCreator.createETriceProject(
							new Path(sourcePath.toString()),
							new Path(sourceGenPath.toString()),
							modelProjectURI,
							runtimeProject,
							BasicMonitor.toMonitor(progressMonitor)
						);

					String baseName = sourcePath.segment(0);
					ProjectCreator.findOrCreateContainer(new Path("/"
							+ baseName + "/model"),
							true, projectLocation, progressMonitor);
					ProjectCreator.createModel(URI.createPlatformResourceURI("/"
							+ baseName
							+ "/model/"+baseName+".room", true),
							baseName);

					ProjectCreator.createManifest(URI.createPlatformResourceURI("/"
							+ baseName
							+ "/META-INF/MANIFEST.MF", true),
							baseName);

					ProjectCreator.findOrCreateContainer(new Path("/"
							+ baseName + "/src/workflow"),
							true, projectLocation, progressMonitor);
					ProjectCreator.createWorkflow(URI.createPlatformResourceURI("/"
							+ baseName
							+ "/src/workflow/"+baseName+".mwe2", true),
							baseName);

					ProjectCreator.createBuildProperties(URI.createPlatformResourceURI("/"
							+baseName+"/build.properties", true),
							baseName);

					ProjectCreator.createLaunchConfig(URI.createPlatformResourceURI("/"
							+baseName+"/"+baseName+".launch", true),
							baseName);

					ProjectCreator.findOrCreateContainer(new Path("/"
							+ baseName + "/tmp/log"),
							true, projectLocation, progressMonitor);
					
				} catch (Exception e) {
					Logger.getLogger(getClass()).error(e.getMessage(), e);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			return false;
		}

		if (project != null) {
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(
						project);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget) activePart)
								.selectReveal(targetSelection);
					}
				});
			}
		}

		return true;
	}

	public void setInitialProjectName(String value) {
		initialProjectName = value;
	}
}
