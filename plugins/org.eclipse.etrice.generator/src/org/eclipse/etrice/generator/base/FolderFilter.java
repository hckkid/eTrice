package org.eclipse.etrice.generator.base;

import java.util.Collection;

public class FolderFilter implements IFileFilter {

	private Collection<String> folders;
	
	public FolderFilter(Collection<String> folders) {
		this.folders = folders;
	}
	
	@Override
	public boolean accept(String fname) {
		for (String folder : folders) {
			if (fname.startsWith(folder))
				return true;
		}
		return false;
	}
	
}