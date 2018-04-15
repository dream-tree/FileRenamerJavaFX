package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataModel {
	
	
	private FileLoader fileLoader;
	
	@Autowired
	public DataModel() {
	}
	
	public void processInput(String input, int optionFlag) {
		List<File> filesList = fileLoader.getFilesList();
		if(filesList != null) {
			if(optionFlag == 0) {
				
			} else if(optionFlag == 1) {
				renameOption1(filesList, input);
			} else if(optionFlag == 2) {
				renameOption2(filesList, input);
			} else {
				
			}
		 } else {
			 //TODO: alert
		 }
	}
	
	public void renameOption1(List<File> filesList, String input) {
		 for(int i = 0; i < filesList.size(); i++) {					 
			 String[] splitted = filesList.get(i).toString().split("\\.");  // dowolna litera zero lub więcej razy
			 System.out.println(Arrays.toString(splitted));
	         StringBuilder sb = new StringBuilder(splitted[0]);
	      /*  for(int j = 0; j < splitted.length-1; j++) {
				 sb.append(splitted[j]+".");
			 }  */
			 sb.append("_");
			 sb.append(i+1);
			 sb.append(".");
			 sb.append(splitted[1]);
			 System.out.println(sb.toString());
			 filesList.get(i).renameTo(new File(sb.toString()));
		 } 
	}
	
	public void renameOption2(List<File> filesList, String input) {
		for(int i = 0; i < filesList.size(); i++) {
			String[] pathWithoutFileNameAndExt = filesList.get(i).toString().split("\\\\([^\\\\]+)$"); 
			String[] pathWithoutFileExtension = filesList.get(i).toString().split("\\.([^\\.]+)$"); 
			String[] fileExtension = filesList.get(i).toString().split("\\.");   // take last element in the array

			StringBuilder sb = new StringBuilder(pathWithoutFileNameAndExt[0]);
			sb.append("\\").append(input).append("_");
			sb.append(String.format("%04d", i+1));
			sb.append(".");
			sb.append(fileExtension[fileExtension.length-1]);
			filesList.get(i).renameTo(new File(sb.toString()));
		}
	}
	
}
	

