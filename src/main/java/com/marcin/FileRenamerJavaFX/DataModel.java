package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Data model for application.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Service
public class DataModel {
	
	@Autowired	
	private FileLoader fileLoader;
	private List<File> loadedFiles;
	private List<File> renamedFiles = new ArrayList<>();
	
	/**
	 * One of 2 possible renaming options as detailed here: {@link ToggleController#initToggleController()} 
	 */
	private int renamingOption = 0;
	
	/**
	 * Indicates if the file renaming process was successful.
	 */
	boolean succeedFlag;

	/**
	 * Constructs the DataModel.
	 */
	public DataModel() {
	}
	
	/**
	 * Checks out if the list of files chosen by user is not empty
	 * and redirects renaming process to the appropriate method using optionFlag variable.
	 * @param input user schema for renaming selected files
	 * @throws Exception exception in file renaming process
	 * @return true if renaming process was successful, false otherwise
	 */
	public boolean processInput(String input) throws RenamingException {
		loadedFiles = fileLoader.getFilesList();
		renamedFiles.clear();
		if(loadedFiles != null) {
			if(renamingOption == 0) {
				succeedFlag = renameOption0(loadedFiles, input);
				if(succeedFlag) {
					refreshFilesList();	
					return true;
				} else {
					throw new RenamingException("Error in renameOption0() method.");
				}
			} else if(renamingOption == 1) {
				succeedFlag = renameOption1(loadedFiles, input);
				if(succeedFlag) {
					refreshFilesList();
					return true;
				} else {
					throw new RenamingException("Error in renamingOption1() method.");
				}
			} 
		 } else {
				return false;
		 }
		return false;
	}
	
	/**
	 * Renames files in the way chosen by user i.e., numbering from the left hand side.
	 * @param filesList list of files selected by user for renaming process
	 * @param input user schema for renaming selected files
	 * @return true if renaming process was successful, false otherwise
	 * @throws Exception exception in file renaming process
	 */
	public boolean renameOption0(List<File> filesList, String input) {
		try {
			for(int i = 0; i < filesList.size(); i++) {
				String[] pathWithoutFileNameAndExt = filesList.get(i).toString().split("\\\\([^\\\\]+)$"); 
				String[] pathWithoutFileExtension = filesList.get(i).toString().split("\\.([^\\.]+)$"); 
				String[] fileExtension = filesList.get(i).toString().split("\\.");   // take last element in the array
	
				StringBuilder sb = new StringBuilder(pathWithoutFileNameAndExt[0]);
				sb.append("\\").append(String.format("%04d", i+1)).append("_");
				sb.append(input);
				sb.append(".");
				sb.append(fileExtension[fileExtension.length-1]);
				File s = new File(sb.toString());
				succeedFlag = filesList.get(i).renameTo(s);
				// if user wants to rename the same picture set in the same app session in the other way, 
				// application has to remember recently filename changes
				renamedFiles.add(s);
				}
		} catch (Exception e) { 
			// TODO: logger - error in renaming files
			// TODO ALERT
			e.getMessage();
			throw e;		
		}
	return succeedFlag;
	}
	
	/**
	 * Renames files in the way chosen by user i.e., numbering from the right hand side.
	 * @param filesList list of files selected by user for renaming process
	 * @param input user schema for renaming selected files
	 * @return true if renaming process was successful, false otherwise
	 * @throws Exception exception in file renaming process
	 */
	public boolean renameOption1(List<File> filesList, String input) {
		try {
			for(int i = 0; i < filesList.size(); i++) {
				String[] pathWithoutFileNameAndExt = filesList.get(i).toString().split("\\\\([^\\\\]+)$"); 
				String[] pathWithoutFileExtension = filesList.get(i).toString().split("\\.([^\\.]+)$"); 
				String[] fileExtension = filesList.get(i).toString().split("\\.");   // take last element in the array
	
				StringBuilder sb = new StringBuilder(pathWithoutFileNameAndExt[0]);
				sb.append("\\").append(input).append("_");
				sb.append(String.format("%04d", i+1));
				sb.append(".");
				sb.append(fileExtension[fileExtension.length-1]);
				File s = new File(sb.toString());
				succeedFlag = filesList.get(i).renameTo(s);
				// if user wants to rename the same picture set in the same app session in the other way, 
				// application has to remember recently filename changes
				renamedFiles.add(s);
			}
		} catch (Exception e) { 
			// TODO: logger - error in renaming files
			// TODO: ALERT
			e.getMessage();
			throw e;		
		}
	return succeedFlag;
	}

/*	*//**
	 * @return the optionFlag
	 *//*
	public int getRenamingOption() {
		return renamingOption;
	}*/

	/**
	 * @param optionFlag the optionFlag to set
	 */
	public void setRenamingOption(int optionFlag) {
		this.renamingOption = optionFlag;
	}
	
	/**
	 * Reloads the list of files after the successful renaming process.
	 * It allows user to rename loaded files again in a different way 
	 * without necessity of choosing the same file set again.
	 */
	public void refreshFilesList() {
		List<File> renamedFilesList = new ArrayList<>(renamedFiles);
		fileLoader.updateFilesList(renamedFilesList);
	}
}