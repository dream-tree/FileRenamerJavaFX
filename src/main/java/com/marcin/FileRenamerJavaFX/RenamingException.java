package com.marcin.FileRenamerJavaFX;

/**
 * Class supports error handling in the renaming process.
 * RenamingException exception is mainly supposed to be thrown if unpredicted error occurs 
 * during the process of renaming files.
 * RenamingException is also thrown if the user choose incorrect filename e.g., 
 * with unsupported characters ("?", ":" etc.). 
 * In this scenario, the appropriate alert dialog is shown.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
public class RenamingException extends Exception {
	
	private static final long serialVersionUID = -3410758186697343477L;
	private int numberOfRenamedFiles;
	
	public RenamingException() {
	}
	
	public RenamingException(String message, int numberOfRenamedFiles) {
		super(message);
		this.numberOfRenamedFiles = numberOfRenamedFiles;
	}

	/**
	 * @return the numberOfRenamedFiles
	 */
	public int getNumberOfRenamedFiles() {
		return numberOfRenamedFiles;
	}
}
