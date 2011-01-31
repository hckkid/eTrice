package org.eclipse.etrice.ui.structure.commands;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.ui.structure.StructureTestActivator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

public abstract class TestBase {

	private String basePath;
	private LinkedList<RoomModel> models = new LinkedList<RoomModel>();

	protected void loadModelFile() {
		try {
			URL modelsDir = StructureTestActivator.getInstance().getBundle().getEntry("models");
			URL fileURL = FileLocator.toFileURL(modelsDir);
			basePath = fileURL.getFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		loadModels(getModelFileName());
	}

	protected void removeDiagramsDirectory() {
		File diagDir = new File(basePath+File.separator+"diagrams");
		File[] files = diagDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			files[i].delete();
		}
		diagDir.delete();
	}
	
	private void loadModels(String modelName) {
		XtextResourceSet rs = new XtextResourceSet();
		rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		String path = basePath + modelName;
		URI uri = URI.createFileURI(path);
		Resource resource = rs.getResource(uri, true);
		Object root = resource.getContents().get(0);
		if (root instanceof RoomModel)
			models.add((RoomModel) root);
		else
			fail("File contains no RoomModel as root object");
	}

	public LinkedList<RoomModel> getModels() {
		return models;
	}

	protected abstract String getModelFileName();
}
