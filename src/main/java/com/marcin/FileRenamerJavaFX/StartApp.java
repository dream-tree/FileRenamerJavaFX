package com.marcin.FileRenamerJavaFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

// https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

public class StartApp extends Application {
		
	private static Stage primaryStage;
	
	public void start(Stage primaryStage) {
		StartApp.primaryStage = primaryStage;
		try {
			ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
			MainView view = context.getBean(MainView.class);		
			view.initView(primaryStage);	
			FileLoader fileLoader = context.getBean(FileLoaderImpl.class);
			fileLoader.loadFiles();
			MainViewController mainController = context.getBean(MainViewController.class);
			mainController.initMainController();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the primaryStage
	 */
	public static Stage getPrimaryStage() {
		return StartApp.primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
