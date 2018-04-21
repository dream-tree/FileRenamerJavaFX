package com.marcin.FileRenamerJavaFX;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


@Controller
public class MainViewController {
	
	private MainView mainView;
	private DataModel model;
	private FileLoader fileLoader;
	private List<File> filesList;
	
	@Autowired
	public MainViewController(MainView mainView, DataModel model, FileLoader fileLoader) {
		this.mainView = mainView;
		this.model = model;
		this.fileLoader = fileLoader;
		System.out.println("1: "+ fileLoader.getFilesList());
	}
	
	public void initMainController() {
		mainView.getRenameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String input = mainView.getUserInputField().getText();
				try {
					filesList = fileLoader.getFilesList();
				} catch (Exception e) {
					// TODO: logger
					System.out.println("renameButton info: no files in List<File>");
				}
				if(input == null || input.isEmpty()) {
					mainView.getAlerts().noUserInputAlertDialog();
				} else if(filesList == null || filesList.isEmpty()) {
					mainView.getAlerts().noFileSelectedAlertDialog();
				} else if(input.length() > 251) {
					mainView.getAlerts().excededInputLengthAlertDialog();
				}
				else {
					try {
						model.processInput(input);	
					} catch (Exception e) {
				//		e.printStackTrace();   unnecessary actions, earlier all logged
						mainView.getAlerts().renamingErrorAlertDialog();
					}
					
				}
			}
		});
	}


}
