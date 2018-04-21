package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

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
				try {
					// clearing previous user choices
					if(filesList.size() != 0) {
						filesList.clear();
					}
				// user clicked selectingFilesButton again and nothing was selected in previous click
				} catch (Exception e) {
					// TODO: logger
					System.out.println("selectingFilesButton info: no selected files.");
				}
				 filesList = fileChooser.showOpenMultipleDialog(StartApp.getPrimaryStage());    // showOpenDialog()	 
				 System.out.println("1 " + filesList);
				 if(filesList == null || filesList.isEmpty()) {
					mainView.getAlerts().noFileSelectedAlertDialog();
				 }
				 System.out.println("2 " + filesList);
	        }
	    });
	}

	/**
	 * @return the filesList
	 */
	public List<File> getFilesList() {
		return filesList;
	}

	/**
	 * @param filesList the filesList to set
	 */
	public void setFilesList(List<File> filesList) {
		this.filesList = filesList;
	}
}
