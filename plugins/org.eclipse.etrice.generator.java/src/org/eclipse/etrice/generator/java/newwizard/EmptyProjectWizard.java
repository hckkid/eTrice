/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.etrice.generator.java.newwizard;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.etrice.core.ui.newwizard.ProjectCreator;
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
 * @author Henrik Rentz-Reichert (initial contribution and API)
 *
 */
public class EmptyProjectWizard extends Wizard implements INewWizard {
	protected IWorkbench workbench;
	protected IPath projectLocation;
	protected IPath sourcePath;
	protected IPath sourceGenPath;
	protected IProject project;
	protected IProject runtimeProject;
	protected String initialProjectName;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		setDefaultPageImageDescriptor(ProjectCreator.getImageDescriptor("icons/NewETriceProjectWizban.gif"));
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

	private List<String> getRequiredBundles() {
		List<String> requiredBundles = new ArrayList<String>(ProjectCreator.getCommonRequiredBundles());
		requiredBundles.add("org.eclipse.etrice.generator.java;bundle-version=\"0.1.0\"");
		requiredBundles.add("org.eclipse.etrice.modellib;bundle-version=\"0.1.0\"");
		return requiredBundles;
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
							ProjectCreator.getCommonNatureIDs(),
							ProjectCreator.getCommonBuilderIDs(),
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
							baseName,
							getRequiredBundles());

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
