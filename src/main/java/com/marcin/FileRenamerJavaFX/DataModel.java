package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataModel {
	
	@Autowired	
	private FileLoader fileLoader;
	private int optionFlag = -1;
	private List<File> loadedFiles;
	private List<File> renamedFiles = new ArrayList<>();
	boolean succeedFlag;

	public DataModel() {
	}
	
	public void processInput(String input) throws Exception {
		loadedFiles = fileLoader.getFilesList();
		renamedFiles.clear();
		if(loadedFiles != null) {
			if(optionFlag == -1) {
				// TODO: alert dialog
			} else if(optionFlag == 0) {
				System.out.println("nana1: " + loadedFiles);
				succeedFlag = renameOption1(loadedFiles, input);
				if(succeedFlag) {
					refreshFilesList();	
					// metoda renameTo() zwraca false, nie wyrzuca wyjątku!!
				} else {
					throw new Exception();
				}
			} else if(optionFlag == 1) {
				System.out.println("nana3: " + loadedFiles);
				succeedFlag = renameOption2(loadedFiles, input);
				if(succeedFlag) {
					refreshFilesList();	
				} else {
					throw new Exception();
				}
			} else {
				
			}
		 } else {
			 //TODO: alert
		 }
	}
	
	public boolean renameOption1(List<File> filesList, String input) throws Exception {
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
				// if user wants to rename same pictures in same app run i other way, app has to remember
				// recently filename changes to files
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
	
	public boolean renameOption2(List<File> filesList, String input) throws Exception {
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
				// if user wants to rename same pictures in same app run i other way, app has to remember
				// recently filename changes to files
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

	/**
	 * @return the optionFlag
	 */
	public int getOptionFlag() {
		return optionFlag;
	}

	/**
	 * @param optionFlag the optionFlag to set
	 */
	public void setOptionFlag(int optionFlag) {
		this.optionFlag = optionFlag;
	}
	
	public void refreshFilesList() {
		List<File> temp = new ArrayList<>(renamedFiles);
		fileLoader.setFilesList(temp);
	}
}