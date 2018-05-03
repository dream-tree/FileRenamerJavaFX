package com.marcin.FileRenamerJavaFX;

/**
 * Class supports error handling in the renaming process.
 * RenamingException exception is thrown if unpredicted error occurs during process of renaming files chosen by user.
 * RenamingException is NOT supposed to be thrown if user choose incorrect filename e.g., 
 * with unsupported characters ("?", ":" etc.). Appropriate alert dialog is shown instead.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
public class RenamingException extends Exception {
	
	private static final long serialVersionUID = -3410758186697343477L;
	
	public RenamingException() {}
	
	public RenamingException(String message) {
		// TODO: przywrócić listę oryginalnych (nazw) plików?
		super(message);
	}
}
