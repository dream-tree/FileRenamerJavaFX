package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Controller for the application main window.
 * 
 * @author dream-tree
 * @version 1.00, April 2018
 */
@Controller
public class MainViewController {
	
	private MainView mainView;
	private DataModel model;
	private FileLoader fileLoader;
	private List<File> filesList;
	
	/**
	* Constructs the MainViewController.
	* @param mainView the MainView instance
	* @param model the DataModel instance
	* @param fileLoader the FileLoader type
	*/
	public MainViewController(MainView mainView, DataModel model, FileLoader fileLoader) {
		this.mainView = mainView;
		this.model = model;
		this.fileLoader = fileLoader;
	}
	
	/**
	 * Initializes the controller for the application main view.
	 */
	public void initMainController() {
		
		mainView.getRenameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String input = mainView.getUserInputField().getText();
				try {
					filesList = fileLoader.getFilesList();
				} catch (Exception e) {
					// TODO: logger
				}
				if(input == null || input.isEmpty()) {
					mainView.getAlerts().noUserInputAlertDialog();
				} else if(filesList == null || filesList.isEmpty()) {
					mainView.getAlerts().noFileSelectedAlertDialog();
				} else if(input.length() > 251) {
					mainView.getAlerts().excededInputLengthAlertDialog();;
				}
				else {
					try {
						boolean succesFlag = model.processInput(input);
						if(succesFlag) {
							mainView.getAlerts().renamingSuccessAlertDialog(filesList.size());
						}
					} catch (RenamingException e) {
						e.printStackTrace();     // NO NO NO!!! EXCEPTION MIXED WITH ALERT!!!
						e.getMessage();
						mainView.getAlerts().renamingErrorAlertDialog();
					}
				}
			}
		});
		
		mainView.getSearchFilesButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				fileLoader.loadFiles();
	        }
	    });
	}
}
