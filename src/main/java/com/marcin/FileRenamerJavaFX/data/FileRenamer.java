package com.marcin.FileRenamerJavaFX.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.FileRenamerJavaFX.controllers.ToggleController;
import com.marcin.FileRenamerJavaFX.repository.FileLoader;

/**
 * Class is responsible for the renaming process of loaded files.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Service
public class FileRenamer {
	
	@Autowired	
	private FileLoader fileLoader;

	/** 
	 * List of files after the successful loading process made by {@link FileLoader} implementation class.
	 */
	private List<File> loadedFiles;
	
	/** 
	 * List of files after the successful renaming process.
	 * If user repeats the renaming process with the same set of files, he has not to load the files again.
	 * In this scenario the loadedFiles array list stores the previously renamed files.
	 * If user is going to rename another set of files in the same application life cycle,
	 * the loadedFiles array must be cleared to prevent adding and accumulating old and new sets of files.
	 * Clearing the loadedFiles array happens in {@link FileRenamer#processInput(String)}.
	 */
	private List<File> renamedFiles = new ArrayList<>();
	
	/**
	 * One of two possible renaming options as detailed here: {@link ToggleController#initToggleController()} 
	 */
	private int renamingOption = 0;
	
	/**
	 * Indicates if the file renaming process was successful.
	 */
	boolean isSuccessful;

	/**
	 * Constructs the FileRenamer object.
	 */
	public FileRenamer() {
	}
	
	/**
	 * Retrieves the list of files chosen by user 
	 * and redirects renaming process to the appropriate method using optionFlag variable.
	 * Before this main process, method clears the renamedFiles array, 
	 * which might not be empty if the user made more then one renaming operation in one app session.
	 * @param input user schema for renaming selected files
	 * @throws Exception exception in file renaming process
	 * @return true if renaming process was successful, false otherwise
	 */
	public boolean processInput(String input) throws RenamingException {
		loadedFiles = fileLoader.getFilesList();
		renamedFiles.clear();
		if(renamingOption == 0) {
			isSuccessful = renameOption0(loadedFiles, input);
			if(isSuccessful) {
				refreshFilesList();	
				return true;
			} else {
				throw new RenamingException("Error in renamingOption0() method.", renamedFiles.size());
			}
		} else if(renamingOption == 1) {
			isSuccessful = renameOption1(loadedFiles, input);
			if(isSuccessful) {
				refreshFilesList();
				return true;
			} else {
				throw new RenamingException("Error in renamingOption1() method.", renamedFiles.size());
			}
		} 
	return false;
	}
	
	/**
	 * Renames files in the way chosen by user i.e., starts numbering from the left hand side.
	 * @param filesList list of files selected by user for renaming process
	 * @param input user schema for renaming selected files
	 * @return true if renaming process was successful, false otherwise
	 * @throws Exception exception in file renaming process
	 */
	public boolean renameOption0(List<File> filesList, String input) {
		try {
			for(int i = 0; i < filesList.size(); i++) {
				String[] pathWithoutFileNameAndExt = filesList.get(i).toString().split("\\\\([^\\\\]+)$"); 
				@SuppressWarnings("unused")
				String[] pathWithoutFileExtension = filesList.get(i).toString().split("\\.([^\\.]+)$"); 
				String[] fileExtension = filesList.get(i).toString().split("\\.");   // take last element in the array
	
				StringBuilder sb = new StringBuilder(pathWithoutFileNameAndExt[0]);
				sb.append("\\").append(String.format("%04d", i+1)).append("_");
				sb.append(input);
				sb.append(".");
				sb.append(fileExtension[fileExtension.length-1]);
				File s = new File(sb.toString());
				isSuccessful = filesList.get(i).renameTo(s);
				if(isSuccessful) {
					renamedFiles.add(s);
				}
			}
		} catch (Exception e) { 
			e.getMessage();
			throw e;		
		}
	return (renamedFiles.size()==loadedFiles.size() ? true : false);
	}
	
	/**
	 * Renames files in the way chosen by user i.e., starts numbering from the right hand side.
	 * @param filesList list of files selected by user for renaming process
	 * @param input user schema for renaming selected files
	 * @return true if renaming process was successful, false otherwise
	 * @throws Exception exception in file renaming process
	 */
	public boolean renameOption1(List<File> filesList, String input) {
		try {
			for(int i = 0; i < filesList.size(); i++) {
				String[] pathWithoutFileNameAndExt = filesList.get(i).toString().split("\\\\([^\\\\]+)$"); 
				String[] fileExtension = filesList.get(i).toString().split("\\.");   // takes last element in the array
	
				StringBuilder sb = new StringBuilder(pathWithoutFileNameAndExt[0]);
				sb.append("\\").append(input).append("_");
				sb.append(String.format("%04d", i+1));
				sb.append(".");
				sb.append(fileExtension[fileExtension.length-1]);
				File s = new File(sb.toString());
				isSuccessful = filesList.get(i).renameTo(s);
				if(isSuccessful) {
					renamedFiles.add(s);
				}
			}
		} catch (Exception e) { 
			e.getMessage();
			throw e;		
		}
	return (renamedFiles.size()==loadedFiles.size() ? true : false);
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
	
	/**
	 * @param optionFlag the optionFlag to set
	 */
	public void setRenamingOption(int optionFlag) {
		this.renamingOption = optionFlag;
	}
}