package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileLoaderImpl implements FileLoader {
	
	private MainView mainView;
	private List<File> filesList;
	
	@Autowired   
	public FileLoaderImpl(MainView mainView, List<File> filesList) {	
		this.mainView = mainView;
		this.filesList = filesList;
	}
		
	public void loadFiles() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selecting files");
		
		mainView.getSearchFilesButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {			
				// it is possible to use instance field Stage in this class instead of a static method - 
				// but it would be another instance than in JavaFX start() method;
				// it is impossible to inject JavaFX instance of Stage object anywhere
				 filesList = fileChooser.showOpenMultipleDialog(StartApp.getPrimaryStage());    // showOpenDialog()	 
				 if(filesList == null || filesList.isEmpty()) {
					mainView.getAlerts().noFileSelectedAlertDialog();
				}			
	        }
	    });
	}

	/**
	 * @return the filesList
	 */
	public List<File> getFilesList() {
		return filesList;
	}
/*
	*//**
	 * @param filesList the filesList to set
	 *//*
	public void setFilesList(List<File> filesList) {
		this.filesList = filesList;
	}*/
}
