package org.eclipse.etrice.generator.base;

import java.util.ArrayList;

public class GenDir extends GenItem {
	private ArrayList<GenItem> contents = new ArrayList<GenItem>();
	
	public GenDir(GenDir parent, String name) {
		super(parent, name);
	}
	
	public ArrayList<GenItem> getContents() {
		return contents;
	}
	
	public ArrayList<GenFile> getSources() {
		ArrayList<GenFile> sources = new ArrayList<GenFile>();
		for (GenItem item : contents) {
			if (item instanceof GenFile)
				sources.add((GenFile) item);
		}
		return sources;
	}
	
	public ArrayList<GenDir> getDirs() {
		ArrayList<GenDir> dirs = new ArrayList<GenDir>();
		for (GenItem item : contents) {
			if (item instanceof GenDir)
				dirs.add((GenDir) item);
		}
		return dirs;
	}
	
	public ArrayList<String> getNestedRelativePathsWithExtension(String ext) {
		ArrayList<String> dirs = new ArrayList<String>();
		for (GenItem item : contents) {
			if (item instanceof GenDir)
				if (((GenDir)item).hasFilesWithExtension(ext))
					dirs.add(item.getName());
				else {
					ArrayList<String> nested = ((GenDir)item).getNestedRelativePathsWithExtension(ext);
					for (String ndir : nested) {
						dirs.add(((GenDir)item).getName()+"/"+ndir);
					}
				}
		}
		return dirs;
	}
	
	public boolean hasFilesWithExtension(String ext) {
		ArrayList<GenFile> sources = getSources();
		for (GenFile source : sources) {
			if (source.getExtension().equals(ext))
				return true;
		}
		return false;
	}
}