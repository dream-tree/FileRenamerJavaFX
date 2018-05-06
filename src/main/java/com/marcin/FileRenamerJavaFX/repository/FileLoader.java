package com.marcin.FileRenamerJavaFX.repository;

import java.io.File;
import java.util.List;

/**
 * General contract for the process of selecting files for the purpose of files renaming operation.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
public interface FileLoader {

	/**
	 * Loads files chosen by user.
	 */
	public void loadFiles();
	
	/**
	 * Provides files selected by user.
	 */
	public List<File> getFilesList();
	
	/**
	 * Updates files in the current list.
	 * @param filesList the filesList to be updated
	 */
	public void updateFilesList(List<File> filesList);
}
