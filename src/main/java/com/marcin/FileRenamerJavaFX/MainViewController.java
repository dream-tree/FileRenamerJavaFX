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
	private int optionFlag = 1;
	
	@Autowired
	public MainViewController(MainView mainView, DataModel model, FileLoader fileLoader) {
		this.mainView = mainView;
		this.model = model;
		this.fileLoader = fileLoader;
	}
	
	public void initMainController() {
		mainView.getRenameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String input = mainView.getUserInputField().getText();
				if(input != null && !input.isEmpty()) {
					model.processInput(input, 2);	
				} else {
					mainView.getAlerts().noUserInputAlertDialog();
				}
			
			}
		});
	}


}
