package com.marcin.FileRenamerJavaFX.controllers;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marcin.FileRenamerJavaFX.data.DataModel;
import com.marcin.FileRenamerJavaFX.data.RenamingException;
import com.marcin.FileRenamerJavaFX.repository.FileLoader;
import com.marcin.FileRenamerJavaFX.views.MainView;

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
	@Autowired
	public MainViewController(MainView mainView, DataModel model, FileLoader fileLoader) {
		this.mainView = mainView;
		this.model = model;
		this.fileLoader = fileLoader;
	}
	
	/**
	 * Initializes the controller for the application main view i.e.,
	 * controller for rename button and
	 * controller for search button.
	 */
	public void initMainController() {
		
		mainView.getRenameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String input = mainView.getUserInputField().getText();
				filesList = fileLoader.getFilesList();
				if(input == null || input.isEmpty()) {
					mainView.getAlerts().noUserInputAlertDialog();
				} else if(filesList == null || filesList.isEmpty()) {
					mainView.getAlerts().noFileSelectedAlertDialog();
				} else if(input.length() > 251) {
					mainView.getAlerts().excededInputLengthAlertDialog();;
				} else {
					try {
						boolean successFlag = model.processInput(input);
						if(successFlag) {
							mainView.getAlerts().renamingSuccessAlertDialog(filesList.size());
						}
					} catch (RenamingException e) {
						// assuming incorrect file name schema chosen by user (with unsupported characters)
						if(e.getNumberOfRenamedFiles()==0) {
							mainView.getAlerts().renamingErrorAlertDialog();
							e.getMessage();
						}
						// unpredictable circumstances in the renaming process
						else {
							e.getMessage();
						}
					}
				}
			}
		});
		
		mainView.getSelectFilesButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				fileLoader.loadFiles();
	        }
	    });
	}
}